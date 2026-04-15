<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<div class="card-header">
					<span class="title" id="menu-toggle">Mantener Calendario de
						Operación</span> <span class="float-right text-secondary"
						id="btn-ocultar">Ocultar</span>
					<sf:form
						action="${pageContext.request.contextPath}/home/cobranza/calendario/Crud"
						method="POST" name="new" id="nuevoElemento">
						<input name="event" type="hidden" value="new" />
						<button type="submit"
							class="btn-link float-right border-0 text-secondary">Agregar
							Calendario</button>
					</sf:form>
				</div>
				<sf:form
					action="${pageContext.request.contextPath}/home/cobranza/calendario/"
					method="POST" commandName="" autocomplete="off">
					<div id="mainMenu" class="collapse show card-body">
						<div class="form-row mt-2">
							<%-- inputs --%>
							<div class="form-group col-md-3">
								<c:if test="${periodo eq 'null'}">
									<c:set var="model_periodo" value="" />
								</c:if>
								<c:if test="${periodo ne 'null'}">
									<c:set var="model_periodo" value="${periodo}" />
								</c:if>
								<label for="inputEmail4 ">Nombre Periodo Facturación</label> <input
									type="text" class="form-control form-control-sm" name="periodo"
									id="periodo" value="${model_periodo}" maxlength="50" />
							</div>
							<div class="form-group col-md-3">
								<c:if test="${fecha eq 'null'}">
									<c:set var="model_fecha" value="<%=new java.util.Date()%>" />
								</c:if>
								<c:if test="${fecha ne 'null'}">
									<c:set var="model_fecha" value="${fecha}" />
									<fmt:parseDate pattern="yyyy-MM-dd" value="${fecha}"
										var="myDate" />
								</c:if>
								<label for="inputEmail4 ">Fecha Incluida en el Periodo</label> <input
									type="date" class="form-control form-control-sm" id="fecha"
									name="fecha"
									value="<fmt:formatDate value="${myDate}" pattern="yyyy-MM-dd"/>">
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
							<thead>
								<tr>
									<th>Periodo</th>
									<th>Fecha Inicio</th>
									<th>Fecha Fin</th>
									<th>Estatus</th>
									<th>Editar</th>
									<th class="text-center">Cerrar Periodos</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${consulta}" var="consulta">
									<tr>
										<td>${consulta.nombre}</td>
										<td><fmt:formatDate value="${consulta.fecha_inicio}"
												pattern="dd/MM/yyyy" /></td>
										<td><fmt:formatDate value="${consulta.fecha_fin}"
												pattern="dd/MM/yyyy" /></td>
										<td>${consulta.estatus}</td>
										<td><sf:form
												action="${pageContext.request.contextPath}/home/cobranza/calendario/Crud"
												method="POST" name="crud" class="text-center">
												<input name="id_periodo" type="hidden"
													value="${consulta.id_periodos}" />
												<input name="event" type="hidden" value="edit" />
												<button type="submit"
													class="btn btn-secondary text-white btn-sm btn-table ">
													<span class="icon-brush"></span>
												</button>
											</sf:form></td>
										<td><sf:form
												action="${pageContext.request.contextPath}/home/cobranza/calendario/Crud"
												method="POST" name="crud" class="text-center">
												<input name="id_periodo" type="hidden"
													value="${consulta.id_periodos}" />
												<input name="event" type="hidden" value="delete" />
												<button type="submit"
													class="btn btn-secondary text-white btn-sm btn-table ">
													<span class="icon-close"></span>
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
						action="${pageContext.request.contextPath}/home/cobranza/calendario/"
						method="POST" name="pagination">
						<%-- 						VARIABLES OBTENIDAS MEDIANTE JS --%>
						<input type="hidden" name="periodo" id="getperiodo"
							class="globalGet">
						<input type="hidden" name="fecha" id="getfecha" class="globalGet">
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
	</div>
</div>
<script type="text/javascript"
	src="<c:url value='/js/appCobros/calculoMensual.js'/>" defer="defer">
</script>
<%@ include file="../layout/footer.jsp"%>