<%-- ################################################################################ --%>
<%-- # Autor               : Loredo                                                 # --%>
<%-- # Compania            : Código Geek                                            # --%>
<%-- # Proyecto/Procliente : D-52-8268-17                         Fecha: 01/06/2018 # --%>
<%-- # Descripcion General : Vista de Verificar Solicitudes de Facturación 			# --%>
<%-- # Marca del cambio    : LOGASIF												# --%>
<%-- ################################################################################ --%>
<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<div class="card-header">
					<span class="title" id="menu-toggle">Verificar Solicitudes
						de Facturación</span> <span class="float-right text-secondary"
						id="btn-ocultar">Ocultar</span>
				</div>
				<sf:form
					action="${pageContext.request.contextPath}/home/adq/man/verificar/consulta"
					method="POST" autocomplete="off">
					<input type="hidden" id="path"
						value="${pageContext.request.contextPath}" />
					<input type="hidden" id="type_list"
						value="${pageContext.request.contextPath}" />
					<div id="mainMenu" class="collapse show card-body pb-0 pt-0">
						<div class="row">
							<div class="col-sm-6 col-md-6 mt-2">
								<div class="form-group row">
									<label class="col-sm-3 col-form-label">Buscar Servicio</label>
									<div class="col-sm-9">
										<input type="text" id="list_Servicios"
											class="form-control form-control-sm ajax-form flagServicio"
											placeholder="Busca un Servicio" name="list_Servicios" />
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-6 mt-2">
								<div class="form-group row">
									<label class="col-sm-3 col-form-label">Selecciona
										Servicio</label>
									<div class="col-sm-9">
										<select class="form-control form-control-sm flagServicio"
											id="list_Servicios_r" name="id_fuente">
										</select> <select class="form-control form-control-sm flagServicio"
											id="listaDeServicios" name="">
											<option value="0">Selecciona un servicio</option>
											<c:forEach items="${listaServicio}" var="lista">
												<option
													value="<c:out value=" ${lista.id_servicios}"> </c:out>">
													<c:out value="${lista.clave}"></c:out> -
													<c:out value="${lista.descripcion}"></c:out>
												</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>


							<div class="col-sm-6 col-md-6">
								<div class="form-group row">
									<label class="col-sm-3 col-form-label">Periodo</label>
									<div class="col-sm-9">
										<select class="form-control form-control-sm" name="id_periodo"
											id="id_periodo" required>
											<c:forEach items="${listaPeriodos}" var="lista">
												<option
													value="<c:out value="${lista.id_periodos}"> </c:out>"
													${lista.id_periodos==id_periodo ? 'selected="selected"' : ''}>
													<c:out value="${lista.nombre}"></c:out>
												</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-6">
								<div class="form-group row">
									<div class="col-md-12">
										<button type="submit"
											class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto">Consultar</button>
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
						<table
							class="table table-scroll table-striped table-bordered table-hover">
							<thead>
								<tr>

									<th>Clave del Servicio</th>
									<th>Descripcion</th>
									<th>Moneda</th>
									<th>Fecha de Captura</th>
									<th>Cliente</th>
									<th>Nombre</th>
									<th>Estatus</th>
									<th>Total Transacciones Emisor</th>
									<th>Total Importe Emisor</th>
									<th>Total Transacciones Adquirente</th>
									<th>Total Importe Adquirente</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${consulta}" var="consulta">
									<tr>
										<td><c:out value="${consulta.clave}"></c:out></td>
										<td><c:out value="${consulta.descripcion}"></c:out></td>
										<td><c:out value="${consulta.nombre_moneda}"></c:out></td>
										<td><c:out value="${consulta.fecha_datos}"></c:out></td>
										<td><c:out value="${consulta.clave_cliente}"></c:out></td>
										<td><c:out value="${consulta.nombre_corto}"></c:out></td>
										<td><c:out value="${consulta.estatus}"></c:out></td>
										<td><c:out value="${consulta.total_trans_emisor}"></c:out></td>
										<td><c:out value="${consulta.total_importe_emisor}"></c:out></td>
										<td><c:out value="${consulta.total_trans_adq}"></c:out></td>
										<td><c:out value="${consulta.total_importe_adq}"></c:out></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</c:if>
		</div>
	</div>
</div>
<%@ include file="../layout/footer.jsp"%>