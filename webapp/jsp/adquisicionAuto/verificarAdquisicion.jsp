<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<sf:form
					action="${pageContext.request.contextPath}/home/adq/auto/verificar/consulta"
					method="POST" commandName="fuente" autocomplete="off">
					<div class="card-header">
						<span class="title" id="menu-toggle">Verificar
							Adquisiciones Automaticas</span> <span
							class="float-right text-secondary" id="btn-ocultar">Ocultar</span>
					</div>
					<div id="mainMenu" class="collapse show card-body">
						<input type="hidden" name="flag" id="flag" value="0" />
						<div class="form-row">
							<%-- inputs --%>
							<div class="form-group col-md-2">
								<label>Fuentes</label> <select
									class="form-control form-control-sm" name="fuentes"
									id="fuentes">
									<option value="0">Selecciona una opcion</option>
									<c:forEach items="${listaFuentes}" var="lista">
										<option value="<c:out value="${lista.id_fuente}"></c:out>"
											${lista.id_fuente==fuentes_clave ? 'selected="selected"' : ''}><c:out
												value="${lista.clave}"></c:out></option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group col-md-2">
								<label>Estatus</label> <select
									class="form-control form-control-sm" name="estatus"
									id="estatus">
									<option value="null"
										${ 'null'==estatus ? 'selected="selected"' : ''}>Selecciona
										una opcion</option>
									<option value="EXI"
										${ 'EXI'==estatus ? 'selected="selected"' : ''}>Realizadas
										con exito</option>
									<option value="ERR"
										${ 'ERR'==estatus ? 'selected="selected"' : ''}>Realizadas
										con errores</option>
									<option value="CNT"
										${ 'CNT'==estatus ? 'selected="selected"' : ''}>Contingencia</option>
									<option value="PAJ"
										${ 'PAJ'==estatus ? 'selected="selected"' : ''}>Pendientes
										por ajustar</option>
									<option value="NRL"
										${ 'NRL'==estatus ? 'selected="selected"' : ''}>No
										realizada</option>
									<option value="PRC"
										${ 'PRC'==estatus ? 'selected="selected"' : ''}>En
										proceso</option>
								</select>
							</div>
							<div class="form-group col-md-2">
								<label>Fecha Datos Inicial</label>
								<c:if test="${fecha_inicial eq 'null'}">
									<input type="date" class="form-control form-control-sm"
										id="fecha_inicial" name="fecha_inicial"
										value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>"
										required>
								</c:if>
								<c:if test="${fecha_inicial ne 'null'}">
									<fmt:parseDate value="${fecha_inicial}" pattern="yyyy-MM-dd"
										var="fechaInicial" />
									<input type="date" class="form-control form-control-sm"
										id="fecha_inicial" name="fecha_inicial"
										value="<fmt:formatDate value="${fechaInicial}" pattern="yyyy-MM-dd"/>"
										required>
								</c:if>
							</div>
							<div class="form-group col-md-2">
								<label>Fecha Datos Final</label>
								<c:if test="${fecha_final eq 'null'}">
									<input type="date" class="form-control form-control-sm"
										id="fecha_final" name="fecha_final"
										value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>"
										required>
								</c:if>
								<c:if test="${fecha_final ne 'null'}">
									<fmt:parseDate value="${fecha_final}" pattern="yyyy-MM-dd"
										var="fechaFinal" />
									<input type="date" class="form-control form-control-sm"
										id="fecha_final" name="fecha_final"
										value="<fmt:formatDate value="${fechaFinal}" pattern="yyyy-MM-dd"/>"
										required>
								</c:if>
							</div>
							<div class="form-group col-md-4 d-flex flex-row-reverse">
								<button type="submit"
									class="btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Consultar</button>
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
							<thead>
								<tr>
									<th scope="col">Fuente</th>
									<th scope="col">Estatus</th>
									<th scope="col">Fecha Datos</th>
									<th scope="col">Fecha Adquisición</th>
									<th scope="col">Núm. Trans. Leidas</th>
									<th scope="col">Núm. Trans. Convertidas</th>
									<th scope="col">Núm. Trans. No Convertidas</th>
									<th scope="col" class="text-center">Ir a bitacora</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${consulta}" var="lista">
									<tr>
										<td><c:out value="${lista.clave}"></c:out></td>
										<td><c:out value="${lista.estatus}"></c:out></td>
										<td><fmt:formatDate value="${lista.fecha_datos}"
												pattern="dd-MM-yyyy" /></td>
										<td><fmt:formatDate type="both" value="${lista.hora_inicio}"
												pattern="dd-MM-yyyy kk:mm:ss" /></td>
										<td><c:out value="${lista.total_trans_leidas}"></c:out></td>
										<td><c:out value="${lista.total_trans_conv}"></c:out></td>
										<td><c:out value="${lista.total_trans_nconv}"></c:out></td>
										<td><sf:form
												action="${pageContext.request.contextPath}/home/adq/auto/bitacora/consulta"
												method="POST" name="crud" class="text-center">
												<input name="fuentes" type="hidden"
													value="${lista.id_fuente}" />
												<input name="event" type="hidden" value="edit" />
												<button type="submit"
													class="btn btn-secondary text-white btn-sm btn-table">
													<span class="icon-today"></span>
												</button>
											</sf:form></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<c:if test="${not empty registros_totales}">
					<sf:form
						action="${pageContext.request.contextPath}/home/adq/auto/verificar/consulta"
						method="POST" name="pagination">
						<%-- 						VARIABLES OBTENIDAS MEDIANTE JS --%>
						<input type="hidden" name="fuentes" id="getfuentes"
							class="globalGet">
						<input type="hidden" name="estatus" id="getestatus"
							class="globalGet">
						<input type="hidden" name="fecha_inicial" id="getfecha_inicial"
							class="globalGet">
						<input type="hidden" name="fecha_final" id="getfecha_final"
							class="globalGet">
						<input type="hidden" name="registros_totales"
							id="registros_totales" class="registros_totales"
							value="${registros_totales}">
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
			</c:if>
		</div>
		<c:if test="${not empty count}">
			<div class="col-sm-12 col-md-12 col-lg-12">
				<div class="alert alert-warning alert-dismissible fade show mt-2"
					role="alert">
					<strong><c:out value="${count}"></c:out></strong>
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</div>
		</c:if>
	</div>
</div>
<%@ include file="../layout/footer.jsp"%>