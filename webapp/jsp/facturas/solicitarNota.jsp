<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<div class="card-header">
					<span class="title" id="menu-toggle">Solicitar Nota de
						Crédito</span> <a class="pl-4 text-secondary tab-link general"
						data-toggle="collapse" href="#general" role="button"
						aria-expanded="false" aria-controls="general">General</a> <a
						class="pl-4 text-secondary tab-link conceptos"
						data-toggle="collapse" href="#conceptos" role="button"
						aria-expanded="false" aria-controls="conceptos">Agregar Más
						Conceptos</a> <span class="float-right text-secondary"
						id="btn-ocultar">Ocultar</span>
				</div>
				<sf:form action="${pageContext.request.contextPath}/home/facturasgeneral/consulta" method="POST"  autocomplete="off">
					<div id="mainMenu" class="show card-body">
						<div class="collapse" id="general">
							<div class="row">
								<div class="col-sm-6 col-md-6 mt-2 mb-2">
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Folio</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" id=""
												placeholder="">
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
										<label class="col-sm-4 col-form-label">Modelos Polizas</label>
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
											<input type="text" class="form-control form-control-sm" id=""
												placeholder="">
										</div>
									</div>
								</div>
							</div>
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
											<input type="text" class="form-control form-control-sm" id=""
												placeholder="">
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
							<div class="row">
								<div class="col-md-12 mt-2 mb-3">
									<span class="title">IVA</span>
								</div>
								<div class="col-sm-4 col-md-4">
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">% IVA a Aplicar</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" id=""
												placeholder="">
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-6 col-form-label">Numero De
											Recibos</label>
										<div class="col-sm-6">
											<input type="text" class="form-control form-control-sm" id=""
												placeholder="">
										</div>
									</div>
								</div>
								<div class="col-sm-4 col-md-4">
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Descuento</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" id=""
												placeholder="">
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Subtotal</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" id=""
												placeholder="">
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">I.V.A.</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" id=""
												placeholder="">
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Total</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" id=""
												placeholder="">
										</div>
									</div>
								</div>
								<div class="col-sm-4 col-md-4">
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Monto a
											Liquidar</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" id=""
												placeholder="">
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">I.V.A. a
											Liquidar</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" id=""
												placeholder="">
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-6 col-form-label">Subtotal a
											Liquidar</label>
										<div class="col-sm-6">
											<input type="text" class="form-control form-control-sm" id=""
												placeholder="">
										</div>
									</div>
									<div class="form-group row">
										<div class="form-group col-md-12 d-flex flex-row-reverse">
											<button type="submit"
												class="btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Guardar</button>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="collapse" id="conceptos">
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
											<button type="submit"
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
					</div>
				</sf:form>
			</div>
		</div>
	</div>
</div>
<%@ include file="../layout/footer.jsp"%>