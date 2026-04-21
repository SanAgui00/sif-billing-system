<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<sf:form
					action="${pageContext.request.contextPath}/home/cobros/movimientos/consulta"
					method="POST" commandName="fuente" autocomplete="off">
					<div class="card-header">
						<span class="title" id="menu-toggle">Mantener Movimientos
							Financieros</span> <span class="float-right text-secondary"
							id="btn-ocultar">Ocultar</span>
					</div>
					<div id="mainMenu" class="show card-body">
						<div class="row">
							<div class="col-sm-6 col-md-6 mt-2 mb-2">
								<input type="hidden" id="path"
									value="${pageContext.request.contextPath}" />
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Clientes</label>
									<div class="col-sm-8">
										<input type="text" id="list_Clientes_report"
											class="form-control form-control-sm ajax-form"
											${clave_cliente.equals("null") ? 'placeholder="Clave | Nombre corto"' : ''}
											value="${!clave_cliente.equals('null') ? clave_cliente : ''}"
											placeholder="Busca un cliente" name="list_Clientes_report" />
										<input type="hidden" class="form-control form-control-sm"
											id="id_cliente" name="id_cliente" value="${id_cliente}">
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Proceso</label>
									<div class="col-sm-8">
										<select class="ajax-form-negocio form-control form-control-sm"
											name="proceso" id="proceso">
											<option value="">Selecciona una opcion</option>
											<c:forEach items="${listaProceso}" var="listaProceso">
												<option
													value="<c:out value=" ${listaProceso.id_proceso} "> </c:out>"
													${ listaProceso.id_proceso==proceso ? 'selected="selected"' : ''}>
													<c:out value="${listaProceso.clave_proceso}"></c:out>
												</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Fecha Envio</label>
									<div class="col-sm-8">

										<input type="date"
											class="form-fecha form-control form-control-sm"
											id="fecha_envio" name="fecha_envio" value="${fecha_envio}"
											required>

									</div>
								</div>

								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Folio Impreso</label>
									<div class="col-sm-8">
										<input type="text" class="form-control form-control-sm"
											id="folio_impreso" name="folio_impreso"
											value="${folio_impreso}">
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Moneda</label>
									<div class="col-sm-8">
										<select class="form-control form-control-sm" name="id_moneda"
											id="id_moneda" required>
											<option value="">Selecciona una opcion</option>
											<c:forEach items="${listaMonedas}" var="lista">
												<option value="<c:out value="${lista.id_moneda}"> </c:out>"
													${ lista.id_moneda==id_moneda ? 'selected="selected"' : ''}>
													<c:out value="${lista.nombre_moneda}"></c:out>
												</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Serie</label>
									<div class="col-sm-8">
										<select class="form-control form-control-sm" name="serie"
											id="serie">
											<option value=""texto">Selecciona una opcion</option>
											<option value="A" class="texto"
												${ serie eq 'A' ? 'selected="selected"' : ''}>A</option>
											<option value="B" class="texto"
												${ serie eq 'B' ? 'selected="selected"' : ''}>B</option>
											<option value="C" class="texto"
												${ serie eq 'C' ? 'selected="selected"' : ''}>C</option>
											<option value="D" class="texto"
												${ serie eq 'D' ? 'selected="selected"' : ''}>D</option>
											<option value="E" class="texto"
												${ serie eq 'E' ? 'selected="selected"' : ''}>E</option>
											<option value="F" class="texto"
												${ serie eq 'F' ? 'selected="selected"' : ''}>F</option>
											<option value="G" class="texto"
												${ serie eq 'G' ? 'selected="selected"' : ''}>G</option>
											<option value="H" class="texto"
												${ serie eq 'H' ? 'selected="selected"' : ''}>H</option>
											<option value="I" class="texto"
												${ serie eq 'I' ? 'selected="selected"' : ''}>I</option>
											<option value="J" class="texto"
												${ serie eq 'J' ? 'selected="selected"' : ''}>J</option>
											<option value="K" class="texto"
												${ serie eq 'K' ? 'selected="selected"' : ''}>K</option>
											<option value="L" class="texto"
												${ serie eq 'L' ? 'selected="selected"' : ''}>L</option>
											<option value="M" class="texto"
												${ serie eq 'M' ? 'selected="selected"' : ''}>M</option>
											<option value="N" class="texto"
												${ serie eq 'N' ? 'selected="selected"' : ''}>N</option>
											<option value="O" class="texto"
												${ serie eq 'O' ? 'selected="selected"' : ''}>O</option>
											<option value="P" class="texto"
												${ serie eq 'P' ? 'selected="selected"' : ''}>P</option>
											<option value="Q" class="texto"
												${ serie eq 'Q' ? 'selected="selected"' : ''}>Q</option>
											<option value="R" class="texto"
												${ serie eq 'R' ? 'selected="selected"' : ''}>R</option>
											<option value="S" class="texto"
												${ serie eq 'S' ? 'selected="selected"' : ''}>S</option>
											<option value="T" class="texto"
												${ serie eq 'T' ? 'selected="selected"' : ''}>T</option>
											<option value="U" class="texto"
												${ serie eq 'U' ? 'selected="selected"' : ''}>U</option>
											<option value="V" class="texto"
												${ serie eq 'V' ? 'selected="selected"' : ''}>V</option>
											<option value="W" class="texto"
												${ serie eq 'W' ? 'selected="selected"' : ''}>W</option>
											<option value="X" class="texto"
												${ serie eq 'X' ? 'selected="selected"' : ''}>X</option>
											<option value="Y" class="texto"
												${ serie eq 'Y' ? 'selected="selected"' : ''}>Y</option>
											<option value="Z" class="texto"
												${ serie eq 'Z' ? 'selected="selected"' : ''}>Z</option>
											<option value="AA" class="texto"
												${ serie eq 'AA' ? 'selected="selected"' : ''}>AA</option>
										</select>
									</div>
								</div>

							</div>
							<div class="col-sm-6 col-md-6 mt-2 mb-2">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Descripcion</label>
									<div class="col-sm-8">
										<select class="custom-select form-control-sm"
											id="list_Clientes_report_r" name="cliente">
											<c:if
												test="${not empty id_cliente && not empty clave_cliente && not empty nombre_corto}">
												<option
													value="${id_cliente}&&${clave_cliente}&&${nombre_corto}">
													<c:out value="${clave_cliente}-${nombre_corto}"></c:out></option>
											</c:if>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Negocio</label>
									<div class="col-sm-8">
										<select class="form-control form-control-sm" name="negocio"
											id="negocio">
											<option value="">Selecciona una opcion</option>
											<c:forEach items="${listaNegocios}" var="lista">
												<option value="<c:out value="${lista.id_negocio}"> </c:out>"
													${ lista.id_negocio==negocio ? 'selected="selected"' : ''}>
													<c:out value="${lista.clave}"></c:out>
												</option>
											</c:forEach>
										</select>
									</div>
								</div>

								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Sistema para
										Envio</label>
									<div class="col-sm-8">
										<select class="ajax-form-periodo form-control form-control-sm"
											name="sisenv" id="sisenv">
											<option value="">Selecciona una opcion</option>
											<option value="LIB" class="texto"
												${ sisenv eq 'LIB' ? 'selected="selected"' : ''}>Libra</option>
											<option value="SAC" class="texto"
												${ sisenv eq 'SAC' ? 'selected="selected"' : ''}>SAC</option>
											<option value="MAN" class="texto"
												${ sisenv eq 'MAN' ? 'selected="selected"' : ''}>Manual</option>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Folio Interno</label>
									<div class="col-sm-8">
										<input type="text" class="form-control form-control-sm"
											id="folio_interno" name="folio_interno"
											value="${folio_interno}">
									</div>
								</div>


								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Tipo de
										Documento</label>
									<div class="col-sm-8">
										<select class="ajax-form-periodo form-control form-control-sm"
											name="document" id="document">
											<option value="">Selecciona una opcion</option>
											<option value="ABI" class="texto"
												${ document eq 'ABI' ? 'selected="selected"' : ''}>Factura
												Abierta</option>
											<option value="NOT" class="texto"
												${ document eq 'NOT' ? 'selected="selected"' : ''}>Nota
												de Credito</option>
											<option value="ODT" class="texto"
												${ document eq 'ODT' ? 'selected="selected"' : ''}>ODT</option>
											<option value="SER" class="texto"
												${ document eq 'SER' ? 'selected="selected"' : ''}>Servicio
												Facturar</option>
										</select>
									</div>
								</div>


								<div class="form-group row">
									<div class="form-group col-md-12 d-flex flex-row-reverse">
										<button id="btnCon" type="submit"
											class="btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Consultar</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</sf:form>
			</div>
		</div>
	</div>
	<div>
		<c:if test="${not empty consulta}">
			<div class="card mt-2">
				<div class="table-responsive">
					<table id="movimientosTable"
						class="table table-scroll table-striped table-bordered table-hover nowrap">
						<thead>
							<tr>
								<th>Fecha Cobro</th>
								<th>Folio Impreso</th>
								<th>Folio Interno</th>
								<th>Clave del Cliente</th>
								<th>Cliente</th>
								<th>Concepto de Envío</th>
								<th>Sistema de Envío</th>
								<th>Importe Total de Cobro</th>
								<th>Tipo de Documento</th>
								<th>Estatus cobro</th>
								<th>Estatus CFDI</th>
								<th>Importe Total de Pago</th>
								<th>Fecha de Pago</th>
								<th>Diferencia de Cuenta por Cobrar</th>
								<th>Utilidad</th>
								<th>Pérdida</th>
								<th>Marcar</th>
							</tr>
						</thead>
						<tbody>
							<c:set var="id" value="${0}" />
							<c:forEach items="${consulta}" var="lista">
								<c:set var="id" value="${id + 1}" />
								<c:set var="Total" value="${0}" />
								<c:set var="Total"
									value="${Total + lista.importe_costo + lista.importe_iva}" />
								<tr id="tr${id}">
									<td class="d-none"><input type="text" id="td0" name="td0"
										value="${lista.id_cobro}"></td>
									<td><input type="text"
										class="form-control form-control-sm" id="td1" name="td1"
										value="<fmt:formatDate value="${lista.fecha_datos_ini}" pattern="yyyy-MM-dd"/>">
									<td><input type="text" id="td2" name="td2" value="null"
										disabled></td>
									<td><input type="text" id="td3" name="td3"
										value="${lista.folio_temporal}" disabled></td>
									<td><input type="text" id="td4"
										value="${lista.clave_cliente}" disabled></td>
									<td><input type="text" id="td5"
										value="${lista.nombre_corto}" disabled></td>
									<td><input type="text" id="td6"
										value="${lista.descripcion}" disabled></td>
									<td class="${lista.sistema_cobro ne 'LIB' ? 'd-none' :''}"><input
										type="text" id="td7"
										value="${lista.sistema_cobro eq 'LIB' ? 'LIBRA' :'null'}"
										disabled></td>
									<td class="${lista.sistema_cobro ne 'SAC' ? 'd-none' :''}"><input
										type="text" id="td8"
										value="${lista.sistema_cobro eq 'SAC' ? 'SAC' :'null'}"
										disabled></td>
									<td class="${lista.sistema_cobro ne 'MAN' ? 'd-none' :''}"><input
										type="text" id="td9"
										value="${lista.sistema_cobro eq 'MAN' ? 'MANUAL' :'null'}"
										disabled></td>
									<td><input type="text" id="td10" value="${Total}" disabled></td>
									<td class="${lista.tipo_documento ne 'ABI' ? 'd-none' :''}"><input
										type="text" id="td11"
										value="${lista.tipo_documento eq 'ABI' ? 'Factura Abierta' :'null'}"
										disabled></td>
									<td class="${lista.tipo_documento ne 'NOT' ? 'd-none' :''}"><input
										type="text" id="td12"
										value="${lista.tipo_documento eq 'NOT' ? 'Nota de Credito' :'null'}"
										disabled></td>
									<td class="${lista.tipo_documento ne 'ODT' ? 'd-none' :''}"><input
										type="text" id="td13"
										value="${lista.tipo_documento eq 'ODT' ? 'ODT' :'null'}"
										disabled></td>
									<td class="${lista.tipo_documento ne 'SER' ? 'd-none' :''}"><input
										type="text" id="td14"
										value="${lista.tipo_documento eq 'SER' ? 'Facturas' :'null'}"
										disabled></td>
									<td><input type="text" id="td15"
										value="${lista.estatus eq 'ENV' ? 'ENVIADO' : 'null'}"
										disabled></td>
									<td><input type="text" id="td16"
										value="${lista.estatus_cfdi}" disabled></td>
									<td><input type="text" id="td17" name="td17"
										value="${Total}" /></td>
									<td><input type="date"
										class="form-control form-control-sm" id="td18" name="td18"
										value="<fmt:formatDate value="${lista.fecha_envio}" pattern="yyyy-MM-dd"/>"></td>
									<td><input type="text" id="td19" value="null" disabled></td>
									<td><input type="text" id="td20" value="null" disabled></td>
									<td><input type="text" id="td21" value="null" disabled></td>
									<td><div class="form-check">
											<input
												class="form-check-input form-check-input-obtener position-static"
												type="checkbox" id="tr${id}" name="check" value="val${id}">
											<input type="hidden" id="checkValue" value="">
										</div></td>
									<td class="d-none"><input type="text" id="td23"
										name="td23" value="${lista.importe_costo}" /></td>
									<td class="d-none"><input type="text" id="td24"
										name="td24" value="${lista.importe_iva}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<c:if test="${not empty registros_totales}">
				<sf:form
					action="${pageContext.request.contextPath}/home/cobros/movimientos/consulta"
					method="POST" name="pagination">
					<%-- 						VARIABLES OBTENIDAS MEDIANTE JS --%>
					<input type="hidden" name="cliente" id="getlist_Clientes_report_r"
						class="globalGet">
					<input type="hidden" name="proceso" id="getproceso"
						class="globalGet">
					<input type="hidden" name="negocio" id="getnegocio"
						class="globalGet">
					<input type="hidden" name="fecha_envio" id="getfecha_envio"
						class="globalGet">
					<input type="hidden" name="folio_impreso" id="getfolio_impreso"
						class="globalGet">
					<input type="hidden" name="id_moneda" id="getid_moneda"
						class="globalGet">
					<input type="hidden" name="serie" id="getserie" class="globalGet">
					<input type="hidden" name="sisenv" id="getsisenv" class="globalGet">
					<input type="hidden" name="document" id="getdocument"
						class="globalGet">
					<input type="hidden" name="folio_interno" id="getfolio_interno"
						class="globalGet">

					<input type="hidden" name="registros_totales"
						id="registros_totales" class="registros_totales"
						value="${registros_totales}">
					<input type="hidden" name="fromRow" id="fromRow" class="fromRow"
						value="">

					<nav>
						<ul class="pagination  pagination-sm justify-content-end">
							<span class='page-link prev'><span class="icon-arrow_back"></span></span>
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

	<div>
		<c:if test="${not empty consultaTotal}">
			<div class="card mt-2">
				<div class="table-responsive">
					<table
						class="table table-scroll table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th>Total de Cargos</th>
								<th>Total de Abonos</th>
								<th>Total de Envío</th>
							</tr>
						</thead>
						<tbody>
							<c:set var="TotalCargos" value="${0}" />
							<c:set var="TotalAbonos" value="${0}" />
							<c:set var="TotalEnvio" value="${0}" />
							<c:forEach items="${consultaTotal}" var="lista">
								<%-- 								<c:set var="TotalCargos" --%>
								<%-- 									value="${TotalCargos + lista.importe_costo + lista.importe_iva}" /> --%>
								<c:if test="${lista.tipo_documento ne 'NOT'}">
									<c:set var="TotalCargos"
										value="${TotalCargos + lista.importe_costo + lista.importe_iva}" />
								</c:if>
								<c:if test="${lista.tipo_documento eq 'NOT'}">
									<c:set var="TotalAbonos"
										value="${TotalAbonos + lista.importe_costo + lista.importe_iva}" />
								</c:if>
							</c:forEach>
							<c:set var="TotalEnvio" value="${TotalCargos - TotalAbonos}" />
							<tr>
								<td><fmt:formatNumber type="number" maxFractionDigits="4"
										value="${TotalCargos}" /></td>
								<td><fmt:formatNumber type="number" maxFractionDigits="4"
										value="${TotalAbonos}" /></td>
								<td><fmt:formatNumber type="number" maxFractionDigits="4"
										value="${TotalEnvio}" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>

		</c:if>
	</div>


	<c:if test="${not empty consulta}">
		<div class="col-md-12 col-lg-12 pl-0 pr-0">
			<div class="row">
				<div class="col-sm-12">
					<div class="card mt-1">
						<sf:form
							action="${pageContext.request.contextPath}/home/cobros/movimientos/cfds"
							method="POST" commandName="fuente" autocomplete="off">
							<div class="card-header">
								<span class="title" id="menu-toggle">Polizas Contables</span>
							</div>
							<div id="mainMenu" class="show card-body">
								<div class="row">
									<div class="form-group row">
										<div class="form-group col-md-12 d-flex flex-row-reverse">
											<input type="hidden" name="mostrar" id="mostrar" class="w-50"><input
												type="hidden" id="path"
												value="${pageContext.request.contextPath}" /> <input
												type="hidden" name="tipo" id="tipo"> <input
												type="hidden" name="datos" id="datos"><input
												type="hidden" name="num" id="num"> <input
												type="hidden" name="datosInput" id="datosInput">
											<button type="submit"
												class="btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto d-none"
												id="opciones">Opciones</button>
											<button name="previewCFD" id="previewCFD" type="button"
												class="ml-3 btnMantener btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto botonopcion">Preview
												CFD Pagos</button>
											<button name="eliminarCFD" id="eliminarCFD" type="button"
												class="ml-3 btnMantener btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto botonopcion">Eliminar
												CFD Pagos</button>
											<button name="generarCFD" id="generarCFD" type="button"
												class="ml-3 btnMantener btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto botonopcion">Generar
												CFD Pagos</button>
											<button name="reversarCFD" id="reversarCFD" type="button"
												class="ml-3 btnMantener btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto botonopcion">Reversar</button>
											<button name="btnImprimir" id="btnImprimir" type="button"
												class="ml-3 btnMantener btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto botonopcion">Imprimir</button>
										</div>
									</div>
								</div>
							</div>
						</sf:form>
					</div>
				</div>
			</div>
		</div>
	</c:if>
</div>
<%@ include file="../layout/footer.jsp"%>