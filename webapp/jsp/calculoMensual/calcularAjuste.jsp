<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<sf:form
					action="${pageContext.request.contextPath}/home/cobranza/ajuste/consulta"
					method="POST" commandName="ajuste">
					<div class="card-header">
						<span class="title">Calcular Proceso Mensual y Aplicar
							Ajuste de Precio</span> <span class="float-right text-secondary"
							id="btn-ocultar">Ocultar</span>
					</div>
					<div id="mainMenu" class="collapse show card-body">
						<div class="form-row ">
							<div class="form-group col-md-2">
								<label>Periodo:</label> <select
									class="form-control form-control-sm" name="id_periodo"
									id="id_periodo" required>
									<c:forEach items="${listaPeriodos}" var="lista">
										<option value="<c:out value="${lista.id_periodos}"> </c:out>"
											${lista.id_periodos==id_periodo ? 'selected="selected"' : ''}>
											<c:out value="${lista.nombre}"></c:out>
										</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group col-md-4 d-flex">
								<div class="custom-control custom-checkbox mt-auto mb-1">
									<input type="hidden" name="ajustePorProceso"
										id="ajustePorProceso" value="0"> <input
										type="checkbox" class="custom-control-input"
										id="checkAjustePorProceso"
										${ajustePorProceso==1 ? 'checked="checked"' : ''}> <label
										class="custom-control-label" for="checkAjustePorProceso">Calcular
										Ajuste por Proceso</label>
								</div>
							</div>
							<div class="form-group col-md-6 d-flex flex-row-reverse">
								<button type="submit"
									class="btn btn-secondary text-white btn-sm float-right  mt-auto mb-1">Consultar</button>
							</div>
						</div>
					</div>
				</sf:form>
			</div>
		</div>
		<div class="col-sm-12">
			<c:if test="${not empty consulta}">
				<div class="card mt-2">
					<div class="table-responsive">
						<table
							class="table table-scroll table-striped table-bordered table-hover">
							<c:choose>
								<c:when test="${ajustePorProceso=='1'}">
									<thead>
										<tr>
											<th scope="col">Proceso</th>
											<th scope="col">Negocio</th>
											<th scope="col">No. Servicios a Facturar</th>
											<th scope="col">Hay Fuente en Contingencia</th>
											<th scope="col" class="text-center">Ajustar</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${consulta}" var="lista">
											<tr>
												<td><c:out value="${lista.clave_proceso}"></c:out></td>
												<td><c:out value="${lista.clave}"></c:out></td>
												<td><c:out value="${lista.num_serv}"></c:out></td>
												<td>${lista.num_serv_cont==0 ? 'NO' : 'SI'}</td>
												<td><div class="form-check text-center">
														<input
															class="form-check-input form-check-get-1 position-static"
															type="checkbox" checked="checked"
															value="${lista.id_negocio}">
													</div></td>
											</tr>
										</c:forEach>
									</tbody>
								</c:when>
								<c:otherwise>
									<thead>
										<tr>
											<th scope="col">Fuente</th>
											<th scope="col">Estatus Adquisición</th>
											<th scope="col">Fecha de Datos</th>
											<th scope="col" class="text-center">Ajustar</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${consulta}" var="lista">
											<tr>
												<td><c:out value="${lista.clave}"></c:out></td>
												<td>${lista.estatus=='EXI' ? 'EXITOSA' : lista.estatus}</td>
												<td><fmt:formatDate value="${lista.fecha_datos}"
														pattern="dd-MM-yyyy" /></td>
												<td><div class="form-check text-center">
														<input
															class="form-check-input form-check-get-1 position-static"
															type="checkbox" checked="checked"
															value="${lista.id_fuente}">
													</div></td>
											</tr>
										</c:forEach>
									</tbody>
								</c:otherwise>
							</c:choose>
						</table>
					</div>
				</div>

				<c:if test="${not empty registros_totales}">
					<sf:form
						action="${pageContext.request.contextPath}/home/cobranza/ajuste/consulta"
						method="POST" name="pagination">
						<%-- 						VARIABLES OBTENIDAS MEDIANTE JS --%>
						<input type="hidden" name="id_periodo" id="getid_periodo"
							class="globalGet">
						<input type="hidden" name="registros_totales"
							id="registros_totales" class="registros_totales"
							value="${registros_totales}">
						<input type="hidden" name="ajustePorProceso" id="ajustePorProceso"
							value="${ajustePorProceso}">
						<input type="hidden" name="fromRow" id="fromRow" class="fromRow"
							value="">
						<nav>
							<ul class="pagination  pagination-sm justify-content-end">
								<span class='page-link prev'><span
									class="icon-arrow_back"></span></span>
								<span class="pagination-container d-inline-block"
									id="pagination-container"></span>
								<span class='page-link next'><span
									class="icon-arrow_forward"></span></span>
							</ul>
						</nav>
						<button type="submit" class="d-none" id="pagination-submit"></button>
					</sf:form>
				</c:if>

				<sf:form
					action="${pageContext.request.contextPath}/home/cobranza/ajuste/save"
					method="POST" name="fuentes" autocomplete="off">
					<input class="globalGetProceso" type="hidden" name="id_periodo"
						id="getProcesoid_periodo">
					<input class="globalGetProceso" type="hidden"
						name="ajustePorProceso" id="ajustePorProceso"
						value="${ajustePorProceso}">
					<input type="hidden" name="lista1" id="lista1">
					<input type="hidden" name=operacion id="operacion">
					<button type="submit"
						class="btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto d-none"
						id="btnEjecutar">Reporte</button>
					<div role="toolbar" aria-label="Contenedor de botones"
						class="btn-toolbar float-right pagination">
						<c:choose>
							<c:when test="${ajustePorProceso=='0'}">
								<button type="button"
									class="btn btn-secondary btn-sm ml-2 btnProceso" id="porFuente">
									<span class="mr-2">Ajuste por Fuente</span><span
										class="icon-settings"></span>
								</button>
							</c:when>
							<c:otherwise>
								<button type="button"
									class="btn btn-secondary btn-sm ml-2 btnProceso"
									id="porProceso">
									<span class="mr-2">Ajuste por Proceso</span><span
										class="icon-settings"></span>
								</button>
								<button type="button"
									class="btn btn-secondary btn-sm ml-2 btnProceso" id="deshacer">
									<span class="mr-2">Deshacer Ajuste</span><span
										class="icon-settings"></span>
								</button>
							</c:otherwise>
						</c:choose>
					</div>
				</sf:form>

			</c:if>
		</div>
	</div>
</div>
<script type="text/javascript"
	src="<c:url value='/js/appCobros/calculoMensual.js'/>" defer="defer">
	
</script>
<%@ include file="../layout/footer.jsp"%>