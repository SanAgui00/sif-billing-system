<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<div class="card-header">
					<span class="title" id="menu-toggle">Visualizar y Editar Servicios a Facturar</span> <span class="float-right text-secondary" id="btn-ocultar">Ocultar</span>
				</div>
				<sf:form action="${pageContext.request.contextPath}/home/adq/auto/servicio/consulta" method="POST" autocomplete="off">
					<input type="hidden" id="path" value="${pageContext.request.contextPath}" />
					<div id="mainMenu" class="collapse show card-body pb-0">
						<div class="row">
							<div class="col-sm-6 col-md-6 mt-2">
								<div class="form-group row">
									<label class="col-sm-3 col-form-label">Buscar Cliente</label>
									<div class="col-sm-9">
										<input type="text" id="list_Clientes" class="form-control form-control-sm ajax-form" placeholder="Busca un cliente" name="list_Clientes" />
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-3 col-form-label">Buscar Servicio </label>
									<div class="col-sm-9">
										<input type="text" id="list_Servicios" class="form-control form-control-sm ajax-form flagServicio" placeholder="Busca un servicio" name="list_Servicios" />
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-6 col-form-label">Fecha Datos Inicial </label>
									<div class="col-sm-6">
										<input type="date" class="form-control form-control-sm" id="fechaInicio" name="fechaInicio" value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>">
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-6 col-form-label">Fecha Datos Final</label>
									<div class="col-sm-6">
										<input type="date" class="form-control form-control-sm" id="fechaFin" name="fechaFin" value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>">
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-6 mt-2">
								<div class="form-group row">
									<label class="col-sm-3 col-form-label">Selecciona Cliente</label>
									<div class="col-sm-9">
										<select class="form-control form-control-sm d-none " id="list_Clientes_r" name="idCliente">
										</select> <select class="form-control form-control-sm " id="listaDeClientes" name="idCliente">
											<option value="0">Selecciona una opcion</option>
											<c:forEach items="${listaClientes}" var="lista">
												<option value="<c:out value=" ${lista.id_cliente} "> </c:out>">
													<c:out value="${lista.clave_cliente}"></c:out> -
													<c:out value="${lista.nombre_corto}"></c:out>
												</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-3 col-form-label">Selecciona Servicio </label>
									<div class="col-sm-9">
										<select class="form-control form-control-sm flagServicio" id="list_Servicios_r" name="idServicio">
										</select> <select class="form-control form-control-sm flagServicio" id="listaDeServicios" name="idServicio">
											<option value="0">Selecciona un servicio</option>
											<c:forEach items="${listaServicio}" var="lista">
												<option value="<c:out value=" ${lista.id_servicios} "> </c:out>">
													<c:out value="${lista.clave}"></c:out> -
													<c:out value="${lista.descripcion}"></c:out>
												</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-6 col-form-label">Estatus</label>
									<div class="col-sm-6">
										<select class="form-control form-control-sm" name="estatus">
											<option value="empty">Selecciona una opcion</option>
											<option value="MOD">Modificado</option>
											<option value="NOR">Adq. automaticas</option>
											<option value="CON">Adq. contingencia</option>
											<option value="MAN">Manual</option>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-md-12">
										<button type="submit" class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto">Consultar</button>
									</div>
								</div>
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
						<table class="table table-scroll table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th>Clave</th>
									<th>Concepto</th>
									<th>Fecha de Datos</th>
									<th>Fecha de Calculo</th>
									<th>Total Transacciones Emisor</th>
									<th>Total Importe Emisor</th>
									<th>Total Transacciones Adquirente</th>
									<th>Total Importe Adquirente</th>
									<th>Moneda</th>
									<th>Estatus</th>
									<th>Editar</th>
									<th>Marcar</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${consulta}" var="consulta">
									<tr>
										<td>${consulta.clave_cliente}</td>
										<td>${consulta.descripcion}</td>
										<td><fmt:formatDate value="${consulta.fecha_datos}" pattern="dd-MM-yyyy" /></td>
										<td><fmt:formatDate value="${consulta.fecha_calculo}" pattern="dd-MM-yyyy" /></td>
										<td>${consulta.total_trans_emisor}</td>
										<td>${consulta.total_importe_emisor}</td>
										<td>${consulta.total_trans_adq}</td>
										<td>${consulta.total_importe_adq}</td>
										<td>${consulta.estatus}</td>
										<td>${consulta.estatus}</td>
										<td><sf:form action="${pageContext.request.contextPath}/home/adq/auto/servicio/crud" method="POST" class="text-center">
												<input name="idMoneda" type="hidden" value="${consulta.id_moneda}" />
												<input name="fechaDatos" type="hidden" value="<fmt:formatDate value="${consulta.fecha_datos}" pattern="dd-MM-yyyy" />" />
												<input name="estatus" type="hidden" value="${consulta.estatus}" />
												<input name="idServicio" type="hidden" value="${consulta.id_servicio}" />
												<input name="idCliente" type="hidden" value="${consulta.id_cliente}" />
												<input name="event" type="hidden" value="edit" />
												<button type="submit" class="btn btn-secondary text-white btn-sm btn-table ">
													<span class="icon-brush"></span>
												</button>
											</sf:form></td>
										<td><div class="form-check">
												<input class="form-check-input position-static" value="${consulta.id_servicio},${consulta.estatus},${consulta.id_cliente},<fmt:formatDate value="${consulta.fecha_datos}" pattern="dd-MM-yyyy" />" type="checkbox">
											</div></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<c:if test="${not empty registros_totales}">
					<sf:form action="${pageContext.request.contextPath}/home/adq/auto/servicio/consulta" method="POST" name="pagination">
						<%-- 						VARIABLES OBTENIDAS MEDIANTE JS --%>
						<input type="hidden" name="fuentes" id="getfuentes" class="globalGet">
						<input type="hidden" name="estatus" id="getestatus" class="globalGet">
						<input type="hidden" name="fecha_inicial" id="getfecha_inicial" class="globalGet">
						<input type="hidden" name="fecha_final" id="getfecha_final" class="globalGet">
						<input type="hidden" name="registros_totales" id="registros_totales" class="registros_totales" value="${registros_totales}">
						<input type="hidden" name="fromRow" id="fromRow" class="fromRow" value="">
						
						<nav>
							<ul class="pagination  pagination-sm justify-content-end">
								<span class='page-link prev'><span class="icon-arrow_back"></span></span>
								<span class="pagination-container d-inline-block" id="pagination-container"></span>
								<span class='page-link next'><span class="icon-arrow_forward"></span></span>
							</ul>
						</nav>
						<button type="submit" class="d-none" id="pagination-submit"></button>
					</sf:form>
				</c:if>
				<sf:form action="${pageContext.request.contextPath}/home/adq/auto/servicio/crud" method="POST">
					<input type="hidden" name="listaSeleccion" class="resultadoSeleccion">
					<input name="event" type="hidden" value="delete" />
					<button type="submit" class="d-none btn-hide"></button>
					<button type="button" class="btn btn-secondary text-white btn-sm float-right bordered  mb-1 ml-2 mt-auto  btnSeleccionMultipleCheckBox">Eliminar</button>
				</sf:form>
			</c:if>
		</div>
	</div>
</div>
<%@ include file="../layout/footer.jsp"%>