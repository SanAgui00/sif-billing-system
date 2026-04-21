<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<sf:form
		action="${pageContext.request.contextPath}/home/facturasgeneral/consulta"
		method="POST" autocomplete="off">
		<div class="row">
			<div class="col-sm-12">
				<div class="card mt-1">
					<div class="card-header">
						<span class="title" id="menu-toggle">Solicitar Factura
							Abierta</span>
						<ul class="nav d-inline-block">
							<li class="nav-item d-inline-block"><a
								class="nav-link text-secondary p-0 mr-3 ml-3  tab-link active"
								id="tab-1" data-toggle="tab" href="#tab1" role="tab"
								aria-controls="tab1" aria-selected="true">Datos Generales</a></li>
							<li class="nav-item d-inline-block"><a
								class="nav-link text-secondary p-0 mr-3  tab-link" id="tab-2"
								data-toggle="tab" href="#tab2" role="tab" aria-controls="tab2"
								aria-selected="false">Agregar Conceptos</a></li>
						</ul>
						<span class="float-right text-secondary" id="btn-ocultar">Ocultar</span>
					</div>
					<div class="tab-content" id="mainMenu">
						<div class="tab-pane  show active" id="tab1" role="tabpanel"
							aria-labelledby="tab-1">
							<%-- MENU1 --%>
							<%-- MENU1 --%>
							<div class="card-body">
								<div class="row">
									<div class="col-sm-6 col-md-6 mt-2 mb-2">
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Folio</label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm"
													id="" placeholder="">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Negocio</label>
											<div class="col-sm-8">
												<select class="form-control form-control-sm" name="">
													<option value="">Selecciona una opcion</option>
												</select>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Modelos
												Polizas</label>
											<div class="col-sm-8">
												<select class="form-control form-control-sm" name="">
													<option value="">Selecciona una opcion</option>
												</select>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Cliente</label>
											<div class="col-sm-8">
												<select class="form-control form-control-sm" name="">
													<option value="">Selecciona una opcion</option>
												</select>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Centro costos</label>
											<div class="col-sm-8">
												<select class="form-control form-control-sm" name="">
													<option value="">Selecciona una opcion</option>
												</select>
											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-6 mt-2 mb-2">
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Moneda</label>
											<div class="col-sm-8">
												<select class="form-control form-control-sm" name="">
													<option value="">Selecciona una opcion</option>
												</select>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Tipo de Pago</label>
											<div class="col-sm-8">
												<select class="form-control form-control-sm" name="">
													<option value="">Selecciona una opcion</option>
												</select>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Sistema de
												Cobro</label>
											<div class="col-sm-8">
												<select class="form-control form-control-sm" name="">
													<option value="">Selecciona una opcion</option>
												</select>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Cuenta De
												Ingresos</label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm"
													id="" placeholder="">
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="card-body">
								<div class="row bg-secondary pb-2">
									<div class="col-md-12 mt-2 mb-3">
										<span class="title">Sustitución de factura</span>
									</div>
									<div class="col-sm-6 col-md-6">
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Tipo de
												documento</label>
											<div class="col-sm-8">
												<select class="form-control form-control-sm" name="">
													<option value="">Selecciona una opcion</option>
												</select>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Folio Factura</label>
											<div class="col-sm-8">
												<select class="form-control form-control-sm" name="">
													<option value="">Selecciona una opcion</option>
												</select>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Tipo de
												relacion</label>
											<div class="col-sm-8">
												<select class="form-control form-control-sm" name="">
													<option value="">Selecciona una opcion</option>
												</select>
											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-6">
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Paridad</label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm"
													id="" placeholder="">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Fecha de Datos</label>
											<div class="col-sm-8">
												<input type="date" class="form-control form-control-sm"
													id="inputEmail4" name="fecha_inicial"
													value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Fecha de Cobro</label>
											<div class="col-sm-8">
												<input type="date" class="form-control form-control-sm"
													id="inputEmail4" name="fecha_inicial"
													value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>">
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="card-body">
								<div class="row">
									<div class="col-md-12 mt-2 mb-3">
										<span class="title">IVA</span>
									</div>
									<div class="col-sm-4 col-md-4">
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">% IVA a
												Aplicar</label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm"
													id="" placeholder="">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-6 col-form-label">Numero De
												Recibos</label>
											<div class="col-sm-6">
												<input type="text" class="form-control form-control-sm"
													id="" placeholder="">
											</div>
										</div>
									</div>
									<div class="col-sm-4 col-md-4">
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Descuento</label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm"
													id="" placeholder="">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Subtotal</label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm"
													id="" placeholder="">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">I.V.A.</label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm"
													id="" placeholder="">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Total</label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm"
													id="" placeholder="">
											</div>
										</div>
									</div>
									<div class="col-sm-4 col-md-4">
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Monto a
												Liquidar</label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm"
													id="" placeholder="">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">I.V.A. a
												Liquidar</label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm"
													id="" placeholder="">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-6 col-form-label">Subtotal a
												Liquidar</label>
											<div class="col-sm-6">
												<input type="text" class="form-control form-control-sm"
													id="" placeholder="">
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
							<div class="card-body">
								<div class="row mb-4">
									<div class="col-sm-4 col-md-4 mt-2">
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Cantidad</label>
											<div class="col-sm-8">
												<input type="text"
													class="form-control form-control-sm just-number"
													name="cantidad" id="cantidad" value="" />
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Unidad</label>
											<div class="col-sm-8">
												<select class="form-control form-control-sm" name="unidad"
													id="unidad">
													<option value="empty">Selecciona una opcion</option>
												</select>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Clave Unidad</label>
											<div class="col-sm-8">
												<select class="form-control form-control-sm"
													name="claveUnidad" id="claveUnidad">
													<option value="empty">Selecciona una opcion</option>
												</select>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Clave Servicio</label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm"
													name="claveServicio" value="" id="claveServicio" />
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Serv. Part</label>
											<div class="col-sm-8">
												<select class="form-control form-control-sm" name="servPart"
													id="servPart">
													<option value="empty">Selecciona una opcion</option>
												</select>
											</div>
										</div>
									</div>
									<div class="col-sm-4 col-md-4 mt-2">
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Cat. Ingreso</label>
											<div class="col-sm-8">
												<select class="form-control form-control-sm"
													name="catIngreso" id="catIngreso">
													<option value="empty">Selecciona una opcion</option>
												</select>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Concepto</label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm"
													name="concepto" value="" id="concepto" />
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Costo Unitario</label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm"
													name="costoUnitario" value="" id="costoUnitario" />
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Importe</label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm"
													name="importe" value="" id="importe" />
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Descuento</label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm"
													name="descuento" value="" id="descuento" />
											</div>
										</div>
									</div>
									<div class="col-sm-4 col-md-4 mt-2">
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Impuesto</label>
											<div class="col-sm-8">
												<select class="form-control form-control-sm" name="impuesto"
													id="impuesto">
													<option value="empty">Selecciona una opcion</option>
												</select>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Factor</label>
											<div class="col-sm-8">
												<select class="form-control form-control-sm" name="factor"
													id="factor">
													<option value="empty">Selecciona una opcion</option>
												</select>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Tasa</label>
											<div class="col-sm-8">
												<select class="form-control form-control-sm" name="tasa"
													id="tasa">
													<option value="empty">Selecciona una opcion</option>
												</select>
											</div>
										</div>
										<div class="form-group row d-flex flex-row-reverse">
											<div class="col-md-4">
												<button type="button"
													class="btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto btnAppendConceptos">Agregar
													Conceptos</button>
											</div>
										</div>
									</div>
								</div>
								<div class="mt-2 table-hide d-none">
									<div class="table-responsive">
										<table
											class="table table-scroll table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th scope="col">Cantidad</th>
													<th scope="col">Unidad</th>
													<th scope="col">Clave Unidad</th>
													<th scope="col">Clave Servicio</th>
													<th scope="col">Serv. Part</th>
													<th scope="col">Cat. Ingreso</th>
													<th scope="col">Concepto</th>
													<th scope="col">Costo Unitario</th>
													<th scope="col">Importe</th>
													<th scope="col">Descuento</th>
													<th scope="col">Impuesto</th>
													<th scope="col">Factor</th>
													<th scope="col">Tasa</th>
													<th scope="col">Eliminar</th>
												</tr>
											</thead>
											<tbody id="appendConceptos">
											</tbody>
										</table>
									</div>
								</div>
							</div>
							<%-- MENU2 --%>
							<%-- MENU2 --%>
						</div>
						<div class="col-md-12">
							<button type="submit"
								class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto ">Guardar</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</sf:form>

</div>
<%@ include file="../layout/footer.jsp"%>