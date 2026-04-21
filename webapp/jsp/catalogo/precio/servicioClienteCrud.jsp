<%@ include file="../../layout/header.jsp"%>
<%@ include file="../../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<%-- VISTA EDITAR --%>
				<%-- VISTA EDITAR --%>
				<%-- VISTA EDITAR --%>
				<%-- 				<c:if test="${event=='edit'}"> --%>
				<%-- 					<c:forEach items="${consulta}" var="editar"> --%>
				<div class="card-header">
					<span class="title" id="menu-toggle">Detalle de Servicios
						por Cliente</span>
					<ul class="nav d-inline-block">
						<li class="nav-item d-inline-block"><a
							class="nav-link text-secondary p-0 mr-3 ml-3  tab-link active"
							id="tab-1" data-toggle="tab" href="#tab1" role="tab"
							aria-controls="tab1" aria-selected="true">Datos Generales</a></li>
						<li class="nav-item d-inline-block"><a
							class="nav-link text-secondary p-0 mr-3  tab-link" id="tab-2"
							data-toggle="tab" href="#tab2" role="tab" aria-controls="tab2"
							aria-selected="false">Subconceptos</a></li>
						<li class="nav-item d-inline-block"><a
							class="nav-link text-secondary p-0 mr-3  tab-link" id="tab-3"
							data-toggle="tab" href="#tab3" role="tab" aria-controls="tab3"
							aria-selected="false">Histórico</a></li>
					</ul>
					<a class="float-right text-secondary"
						href="<c:url value='/home/cat/precio/servicio'/>" role="button">Regresar</a>
					<span class="float-right text-secondary mr-3" id="btn-ocultar">Ocultar</span>
				</div>
				<sf:form
					action="${pageContext.request.contextPath}/home/cat/principal/cliente/save"
					method="POST" commandName="fuente" autocomplete="off">
					<div class="tab-content" id="mainMenu">
						<div class="card-body">
							<div class="row">
								<div class="col-sm-6 col-md-6 mt-1">
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Cliente</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm"
												value="" id="" name="" disabled />
										</div>
									</div>
								</div>
								<div class="col-sm-6 col-md-6 mt-1">
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Servicio</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm"
												value="" id="" name="" disabled />
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 col-md-6 mt-0">
									<div class="form-group row">
										<label class="col-sm-6 col-form-label">Negocio</label>
										<div class="col-sm-6">
											<input type="text" class="form-control form-control-sm"
												value="" id="" name="" disabled />
										</div>
									</div>
								</div>
								<div class="col-sm-6 col-md-6 mt-0">
									<div class="form-group row">
										<label class="col-sm-6 col-form-label">Grupo Concepto</label>
										<div class="col-sm-6">
											<input type="text" class="form-control form-control-sm"
												value="" id="" name="" disabled />
										</div>
									</div>
								</div>
								<div class="col-sm-6 col-md-6 mt-0">
									<div class="form-group row">
										<label class="col-sm-6 col-form-label">Fecha
											Asignación</label>
										<div class="col-sm-6">
											<input type="text" class="form-control form-control-sm"
												value="" id="" name="" disabled />
										</div>
									</div>
								</div>
								<div class="col-sm-6 col-md-6 mt-0">
									<div class="form-group row">
										<label class="col-sm-6 col-form-label">Usuario</label>
										<div class="col-sm-6">
											<input type="text" class="form-control form-control-sm"
												value="" id="" name="" disabled />
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="tab-pane  show active" id="tab1" role="tabpanel"
							aria-labelledby="tab-1">
							<%-- MENU1 --%>
							<%-- MENU1 --%>
							<div class="card-body">
								<div class="row bg-secondary pb-2">
									<div class="col-md-12 mt-2 mb-2">
										<span class="title">Precio</span>
									</div>
									<div class="col-sm-6 col-md-6 mt-0">
										<div class="form-group row">
											<label class="col-sm-6 col-form-label">Precio para el
												Servicio en el periodo actual</label>
											<div class="col-sm-6">
												<input type="text" class="form-control form-control-sm"
													value="" id="" name="" />
											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-6 mt-0">
										<div class="form-group row">
											<label class="col-sm-6 col-form-label">Moneda para el
												Servicio en el periodo actual</label>
											<div class="col-sm-6">
												<select class="form-control form-control-sm" id="" name="">
													<option value=""></option>
												</select>
											</div>
										</div>
									</div>
								</div>
								<div class="row pb-2">
									<div class="col-md-12 mt-2 mb-2">
										<span class="title">Formas de Pago</span>
									</div>
									<div class="col-md-12 mt-2 mb-2">
										<div class="custom-control custom-checkbox">
											<input type="checkbox" class="custom-control-input"
												id="checkboxPrueba" name="checkboxPrueba"> <label
												class="custom-control-label" for="checkboxPrueba">Forma
												de Pago específica para el Cliente</label>
										</div>
									</div>
									<div class="col-sm-6 col-md-6 mt-0">
										<div class="form-group row">
											<label class="col-sm-6 col-form-label">Forma de Pago</label>
											<div class="col-sm-6">
												<select class="form-control form-control-sm" id="" name="">
													<option value=""></option>
												</select>
											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-6 mt-0">
										<div class="form-group row">
											<label class="col-sm-6 col-form-label">Sistema</label>
											<div class="col-sm-6">
												<select class="form-control form-control-sm" id="" name="">
													<option value=""></option>
												</select>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-6 col-form-label">Moneda de
												Cobro</label>
											<div class="col-sm-6">
												<select class="form-control form-control-sm" id="" name="">
													<option value=""></option>
												</select>
											</div>
										</div>
									</div>
								</div>
								<div class="row bg-secondary pb-2">
									<div class="col-md-12 mt-2 mb-2">
										<div class="custom-control custom-checkbox">
											<input type="checkbox" class="custom-control-input"
												id="checkboxPrueba" name="checkboxPrueba"> <label
												class="custom-control-label" for="checkboxPrueba">Precio
												específico para el cliente</label>
										</div>
									</div>
									<div class="col-md-12 mt-2 mb-2">
										<div class="custom-control custom-checkbox">
											<input type="checkbox" class="custom-control-input"
												id="checkboxPrueba" name="checkboxPrueba"> <label
												class="custom-control-label" for="checkboxPrueba">Incluir
												en el cálculo de Ajuste</label>
										</div>
									</div>
									<div class="col-md-12 mt-2 mb-2">
										<div class="custom-control custom-checkbox">
											<input type="checkbox" class="custom-control-input"
												id="checkboxPrueba" name="checkboxPrueba"> <label
												class="custom-control-label" for="checkboxPrueba">Incluir
												en el cálculo del Rebate</label>
										</div>
									</div>
									<div class="col-md-12 mt-2 mb-2">
										<div class="custom-control custom-checkbox">
											<input type="checkbox" class="custom-control-input"
												id="checkboxPrueba" name="checkboxPrueba"> <label
												class="custom-control-label" for="checkboxPrueba">Incluir
												en el cálculo de la Cobranza</label>
										</div>
									</div>

									<div class="col-sm-6 col-md-6 mt-0">
										<div class="form-group row">
											<label class="col-sm-6 col-form-label">Descuento</label>
											<div class="col-sm-6">
												<input type="text" class="form-control form-control-sm"
													value="" id="" name="" />
											</div>
										</div>
									</div>

								</div>
							</div>
							<%-- MENU1 --%>
							<%-- MENU1 --%>
						</div>
						<div class="tab-pane " id="tab2" role="tabpanel"
							aria-labelledby="tab-2">
							<%-- MENU2 --%>
							<%-- MENU2 --%>
							<div class="card-body"></div>
							<%-- MENU2 --%>
							<%-- MENU2 --%>
						</div>
						<div class="tab-pane " id="tab3" role="tabpanel"
							aria-labelledby="tab-3">
							<%-- MENU3 --%>
							<%-- MENU3 --%>
							<div class="card-body">
								<c:if test="${not empty consultaHistorico}">
									<div class="card mt-2">
										<div class="table-responsive">
											<table
												class="table table-scroll table-striped table-bordered table-hover">
												<thead>
													<tr>
														<th scope="col">Fecha Modificación</th>
														<th scope="col">Usuario</th>
														<th scope="col">Comentarios</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${consultaHistorico}" var="consulta">
														<tr>
															<td><c:out value="${consulta.fecha_mod}"></c:out></td>
															<td><c:out value="${consulta.usuario}"></c:out></td>
															<td><c:out value="${consulta.comentarios}"></c:out></td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>

								</c:if>
							</div>
							<%-- MENU3 --%>
							<%-- MENU3 --%>
						</div>
						<div class="col-md-12">
							<button type="submit"
								class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto ">Guardar</button>
						</div>
					</div>
				</sf:form>
				<%-- 					</c:forEach> --%>
				<%-- 					</c:if> --%>
				<%-- VISTA EDITAR --%>
				<%-- VISTA EDITAR --%>
				<%-- VISTA EDITAR --%>
			</div>
		</div>
	</div>
</div>
<%@ include file="../../layout/footer.jsp"%>
<script type="text/javascript"
	src='<c:url value="/js/appFacturas/operaciones.js"/>' defer="defer"></script>