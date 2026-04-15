<%@ include file="../../layout/header.jsp"%>
<%@ include file="../../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<c:if test="${empty id_precio}">
		<div class="row">
			<div class="col-sm-12">
				<div class="card mt-1">
					<div class="card-header">
						<span class="title" id="menu-toggle">Definir Precio de
							Servicio</span>
						<sf:form
							action="${pageContext.request.contextPath}/home/cat/principal/servicio/crud"
							method="POST" name="crud" class="text-center d-inline">
							<input name="id_servicios" type="hidden" value="${id_servicios}" />
							<input name="id_precio" type="hidden" value="${id_precio}" />
							<input name="event" type="hidden" value="edit" />
							<button type="submit" class="float-right text-secondary border-0">Regresar</button>
						</sf:form>
					</div>
					<sf:form
						action="${pageContext.request.contextPath}/home/cat/principal/servicio/precioSave"
						method="POST">

						<div class="tab-content" id="mainMenu">
							<div class="tab-pane  show active" id="tab1" role="tabpanel"
								aria-labelledby="tab-1">
								<%-- MENU1 --%>
								<%-- MENU1 --%>

								<div class="card-body">
									<div class="row">
										<div class="col-sm-6 col-md-6 mt-2">
											<div class="form-group row">
												<label class="col-sm-6 col-form-label">Servicio</label>
												<div class="col-sm-6">
													<input type="text" class="form-control form-control-sm"
														value="${clave}" disabled /> <input type="hidden"
														class="form-control form-control-sm" name="clave"
														id="clave" value="${clave}" />
												</div>
											</div>
										</div>
										<div class="col-sm-6 col-md-6 mt-2">
											<div class="form-group row">
												<label class="col-sm-6 col-form-label">Cliente</label>
												<div class="col-sm-6">
													<input type="text" class="form-control form-control-sm"
														value="${cliente}" disabled />
												</div>
											</div>
										</div>
										<div class="col-sm-6 col-md-6 mt-2">
											<div class="form-group row">
												<label class="col-sm-6 col-form-label">Tipo Precio</label>
												<div class="col-sm-6">
													<select class="form-control form-control-sm"
														name="tipoPrecio" id="tipoPrecio" required>
														<option value="" selected="selected">selecciona
															una opcion</option>
														<option value="FIJ">Precio Fijo</option>
														<option value="VOL">Precio Volumen</option>
														<option value="ESC">Precio por Escala</option>
														<option value="MIN">Precio Vol. Min.</option>
														<option value="REN">Precio Renta</option>
														<option value="PRO">Precio Cuentas Promedio</option>
														<option value="MAX">Precio Vol-Min-Max</option>
													</select>
												</div>
											</div>

											<div class="form-group row">
												<label class="col-sm-6 col-form-label">Precio</label>
												<div class="col-sm-6">
													<input type="text"
														class="form-control form-control-sm inputClear"
														name="inputPrecio" id="inputPrecio" />
												</div>
											</div>

										</div>
										<div class="col-sm-6 col-md-6 mt-2">
											<div class="form-group row">
												<label class="col-sm-6 col-form-label">Moneda</label>
												<div class="col-sm-6">
													<select class="form-control form-control-sm"
														name="inputMoneda" id="inputMoneda" required>
														<option value="" selected="selected">selecciona
															una opcion</option>
														<option value="2">DOLAR</option>
														<option value="1">PESO</option>
													</select>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-6 col-form-label">Volumen</label>
												<div class="col-sm-6">
													<input type="text"
														class="form-control form-control-sm inputClear"
														name="inputVolumen" id="inputVolumen" />
												</div>
											</div>
										</div>
										<div class="col-sm-4 col-md-4 mt-2">
											<div class="form-group row">
												<label class="col-sm-6 col-form-label">Volumen
													Inicial</label>
												<div class="col-sm-6">
													<input type="text"
														class="form-control form-control-sm inputClear"
														name="inputVolumenInicial" id="inputVolumenInicial" />
												</div>
											</div>
										</div>
										<div class="col-sm-4 col-md-4 mt-2">
											<div class="form-group row">
												<label class="col-sm-6 col-form-label">Volumen Final</label>
												<div class="col-sm-6">
													<input type="text"
														class="form-control form-control-sm inputClear"
														name="inputVolumenFinal" id="inputVolumenFinal" />
												</div>
											</div>
										</div>
										<div class="col-sm-4 col-md-4 mt-2">
											<div class="form-group row">
												<label class="col-sm-6 col-form-label">Precio</label>
												<div class="col-sm-6">
													<input type="text"
														class="form-control form-control-sm inputClear"
														name="inputPrecioVolumen" id="inputPrecioVolumen" />
												</div>
											</div>
											<button type="button"
												class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto"
												id="btnAgregarPrecio">Agregar Precio</button>
										</div>

									</div>
								</div>

								<div class="col-sm-12 mb-2">

									<div class="card mt-2">
										<div class="table-responsive">
											<table
												class="table table-scroll table-striped table-bordered table-hover">
												<thead>
													<tr>
														<th scope="col">Volumen Inicial</th>
														<th scope="col">Volumen Final</th>
														<th scope="col">Precio</th>
														<th scope="col">Eliminar</th>
													</tr>
												</thead>
												<tbody id="tablaRangoPrecio">



												</tbody>
											</table>
										</div>
									</div>

								</div>

								<%-- MENU1 --%>
								<%-- MENU1 --%>
							</div>
							<div class="col-md-12">
								<input name="id_servicios" type="hidden" value="${id_servicios}" />
								<input name="id_precio" type="hidden" value="${id_precio}" /> <input
									type="hidden" id="listaPrecios" name="listaPrecios">
								<button type="button"
									class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto"
									id="btnVerificarPrecio">Guardar</button>
								<button type="submit"
									class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto d-none"
									id="btnGuardarPrecio">Guardar</button>
							</div>
						</div>

					</sf:form>
				</div>
			</div>
		</div>
	</c:if>
	<c:if test="${not empty id_precio}">
		<div class="row">
			<div class="col-sm-12">
				<div class="card mt-1">
					<div class="card-header">
						<span class="title" id="menu-toggle">Definir Precio de
							Servicio</span>
						<sf:form
							action="${pageContext.request.contextPath}/home/cat/principal/servicio/crud"
							method="POST" name="crud" class="text-center d-inline">
							<input name="id_servicios" type="hidden" value="${id_servicios}" />
							<input name="id_precio" type="hidden" value="${id_precio}" />
							<input name="event" type="hidden" value="edit" />
							<button type="submit" class="float-right text-secondary border-0">Regresar</button>
						</sf:form>
					</div>
					<sf:form
						action="${pageContext.request.contextPath}/home/cat/principal/servicio/precioSave"
						method="POST">

						<div class="tab-content" id="mainMenu">
							<div class="tab-pane  show active" id="tab1" role="tabpanel"
								aria-labelledby="tab-1">
								<%-- MENU1 --%>
								<%-- MENU1 --%>
								<c:forEach items="${consultaPrecio}" var="consultaPrecio">
									<div class="card-body">
										<div class="row">
											<div class="col-sm-6 col-md-6 mt-2">
												<div class="form-group row">
													<label class="col-sm-6 col-form-label">Servicio</label>
													<div class="col-sm-6">
														<input type="text" class="form-control form-control-sm"
															value="${clave}" disabled /> <input type="hidden"
															class="form-control form-control-sm" name="clave"
															id="clave" value="${clave}" />
													</div>
												</div>
											</div>
											<div class="col-sm-6 col-md-6 mt-2">
												<div class="form-group row">
													<label class="col-sm-6 col-form-label">Cliente</label>
													<div class="col-sm-6">
														<input type="text" class="form-control form-control-sm"
															value="${cliente}" disabled />
													</div>
												</div>
											</div>
											<div class="col-sm-6 col-md-6 mt-2">
												<div class="form-group row">
													<label class="col-sm-6 col-form-label">Tipo Precio</label>
													<div class="col-sm-6">
														<select class="form-control form-control-sm"
															name="tipoPrecio" id="tipoPrecio" required>
															<option value="" selected="selected">selecciona
																una opcion</option>
															<option value="FIJ"
																${consultaPrecio.tipo_precio=='FIJ' ? 'selected="selected"':''}>Precio
																Fijo</option>
															<option value="VOL"
																${consultaPrecio.tipo_precio=='VOL' ? 'selected="selected"':''}>Precio
																Volumen</option>
															<option value="ESC"
																${consultaPrecio.tipo_precio=='ESC' ? 'selected="selected"':''}>Precio
																por Escala</option>
															<option value="MIN"
																${consultaPrecio.tipo_precio=='MIN' ? 'selected="selected"':''}>Precio
																Vol. Min.</option>
															<option value="REN"
																${consultaPrecio.tipo_precio=='REN' ? 'selected="selected"':''}>Precio
																Renta</option>
															<option value="PRO"
																${consultaPrecio.tipo_precio=='PRO' ? 'selected="selected"':''}>Precio
																Cuentas Promedio</option>
															<option value="MAX"
																${consultaPrecio.tipo_precio=='MAX' ? 'selected="selected"':''}>Precio
																Vol-Min-Max</option>
														</select>
													</div>
												</div>
												<c:if
													test="${consultaPrecio.tipo_precio eq 'FIJ' or consultaPrecio.tipo_precio eq 'REN'}">
													<c:forEach items="${consultaRangoPrecio}" var="consulta">
														<c:choose>
															<c:when
																test="${consultaPrecio.tipo_precio eq 'FIJ' or consultaPrecio.tipo_precio eq 'REN'}">
																<c:set var="precio" value="${consulta.precio}" />
																<div class="form-group row">
																	<label class="col-sm-6 col-form-label">Precio</label>
																	<div class="col-sm-6">
																		<input type="text"
																			class="form-control form-control-sm inputClear"
																			name="inputPrecio" id="inputPrecio" value="${precio}" />
																	</div>
																</div>
															</c:when>
															<c:otherwise>
																<c:set var="precio" value="" />
																<div class="form-group row">
																	<label class="col-sm-6 col-form-label">Precio</label>
																	<div class="col-sm-6">
																		<input type="text"
																			class="form-control form-control-sm inputClear"
																			name="inputPrecio" id="inputPrecio" value="${precio}" />
																	</div>
																</div>
															</c:otherwise>
														</c:choose>

													</c:forEach>
												</c:if>
												<c:if
													test="${consultaPrecio.tipo_precio ne 'FIJ' and consultaPrecio.tipo_precio ne 'REN'}">
													<div class="form-group row">
														<label class="col-sm-6 col-form-label">Precio</label>
														<div class="col-sm-6">
															<input type="text"
																class="form-control form-control-sm inputClear"
																name="inputPrecio" id="inputPrecio" />
														</div>
													</div>
												</c:if>
											</div>
											<div class="col-sm-6 col-md-6 mt-2">
												<div class="form-group row">
													<label class="col-sm-6 col-form-label">Moneda</label>
													<div class="col-sm-6">
														<select class="form-control form-control-sm"
															name="inputMoneda" id="inputMoneda" required>
															<option value="" selected="selected">selecciona
																una opcion</option>
															<option value="2"
																${consultaPrecio.id_moneda eq '2' ? 'selected="selected"':''}>DOLAR</option>
															<option value="1"
																${consultaPrecio.id_moneda eq '1' ? 'selected="selected"':''}>PESO</option>
														</select>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-6 col-form-label">Volumen</label>
													<div class="col-sm-6">
														<input type="text"
															class="form-control form-control-sm inputClear"
															name="inputVolumen" id="inputVolumen" />
													</div>
												</div>
											</div>
											<div class="col-sm-4 col-md-4 mt-2">
												<div class="form-group row">
													<label class="col-sm-6 col-form-label">Volumen
														Inicial</label>
													<div class="col-sm-6">
														<input type="text"
															class="form-control form-control-sm inputClear"
															name="inputVolumenInicial" id="inputVolumenInicial" />
													</div>
												</div>
											</div>
											<div class="col-sm-4 col-md-4 mt-2">
												<div class="form-group row">
													<label class="col-sm-6 col-form-label">Volumen
														Final</label>
													<div class="col-sm-6">
														<input type="text"
															class="form-control form-control-sm inputClear"
															name="inputVolumenFinal" id="inputVolumenFinal" />
													</div>
												</div>
											</div>
											<div class="col-sm-4 col-md-4 mt-2">
												<div class="form-group row">
													<label class="col-sm-6 col-form-label">Precio</label>
													<div class="col-sm-6">
														<input type="text"
															class="form-control form-control-sm inputClear"
															name="inputPrecioVolumen" id="inputPrecioVolumen" />
													</div>
												</div>
												<button type="button"
													class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto"
													id="btnAgregarPrecio">Agregar Precio</button>
											</div>

										</div>
									</div>

									<div class="col-sm-12 mb-2">

										<div class="card mt-2">
											<div class="table-responsive">
												<table
													class="table table-scroll table-striped table-bordered table-hover">
													<thead>
														<tr>
															<th scope="col">Volumen Inicial</th>
															<th scope="col">Volumen Final</th>
															<th scope="col">Precio</th>
															<th scope="col">Eliminar</th>
														</tr>
													</thead>
													<tbody id="tablaRangoPrecio">
														<c:if
															test="${consultaPrecio.tipo_precio ne 'FIJ' and consultaPrecio.tipo_precio ne 'REN'}">
															<c:set var="rangoInicial" value="" />
															<c:set var="rangoFinal" value="" />
															<c:set var="rangoPrecio" value="" />
															<c:forEach items="${consultaRangoPrecio}" var="consulta">
																<tr>
																	<c:choose>
																		<c:when test="${not empty consulta.rango_inicial}">
																			<c:set var="rangoInicial"
																				value="${consulta.rango_inicial}" />
																			<td><c:out value="${consulta.rango_inicial}"></c:out></td>
																		</c:when>
																		<c:when test="${empty consulta.rango_inicial}">
																			<c:set var="rangoInicial" value="null" />
																			<td><c:out value="null"></c:out></td>
																		</c:when>
																		<c:otherwise>
																		</c:otherwise>
																	</c:choose>

																	<c:choose>
																		<c:when test="${not empty consulta.rango_final}">
																			<c:set var="rangoFinal"
																				value="${consulta.rango_final}" />
																			<td><c:out value="${consulta.rango_final}"></c:out></td>
																		</c:when>
																		<c:when test="${empty consulta.rango_final}">
																			<c:set var="rangoFinal" value="null" />
																			<td><c:out value="null"></c:out></td>
																		</c:when>
																		<c:otherwise>
																		</c:otherwise>
																	</c:choose>
																	<c:choose>
																		<c:when test="${not empty consulta.precio}">
																			<c:set var="rangoPrecio" value="${consulta.precio}" />
																			<td><c:out value="${consulta.precio}"></c:out></td>
																		</c:when>
																		<c:when test="${empty consulta.precio}">
																			<c:set var="rangoPrecio" value="null" />
																			<td><c:out value="null"></c:out></td>
																		</c:when>
																		<c:otherwise>
																		</c:otherwise>
																	</c:choose>


																	<td><div class="form-check">
																			<input
																				class="form-check-input form-check-input-precios position-static d-none"
																				type="checkbox"
																				value="${rangoInicial},${rangoFinal},${rangoPrecio}"
																				checked="checked" />
																		</div>
																		<button type="button" class="removebutton">Eliminar</button></td>
																</tr>
															</c:forEach>
														</c:if>
													</tbody>
												</table>
											</div>
										</div>

									</div>
								</c:forEach>
								<%-- MENU1 --%>
								<%-- MENU1 --%>
							</div>
							<div class="col-md-12">
								<input name="id_servicios" type="hidden" value="${id_servicios}" />
								<input name="id_precio" type="hidden" value="${id_precio}" /> <input
									type="hidden" id="listaPrecios" name="listaPrecios">
								<button type="button"
									class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto"
									id="btnVerificarPrecio">Guardar</button>
								<button type="submit"
									class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto d-none"
									id="btnGuardarPrecio">Guardar</button>
							</div>
						</div>

					</sf:form>
				</div>
			</div>
		</div>
	</c:if>
	<%-- LIMITE --%>
	<%-- LIMITE --%>
	<%-- LIMITE --%>
</div>
<%@ include file="../../layout/footer.jsp"%>