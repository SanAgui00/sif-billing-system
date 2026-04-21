<%@ include file="../../layout/header.jsp"%>
<%@ include file="../../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<%-- DELETE --%>
	<c:if test="${event=='delete'}">
		<sf:form
			action="${pageContext.request.contextPath}/home/cat/principal/servicio/save"
			method="POST">
			<c:forEach items="${consulta}" var="consulta">
				<input name="evento" type="hidden" value="delete" />
				<input name="id_servicios" type="hidden"
					value="${consulta.id_servicios}" />
				<div class="row">
					<div class="col-sm-12">
						<div class="card mt-1">
							<div class="card-header">
								<span class="title" id="menu-toggle">Eliminar</span> <a
									class="float-right text-secondary"
									href="<c:url value='/home/cat/principal/servicio'/>"
									role="button">Regresar</a>
							</div>
							<div id="mainMenu" class="collapse show card-body">
								<div class="row">
									<div class="col-sm-12 col-md-12  text-center">
										<h5 class="card-title">
											Está a punto de eliminar a <span class="font-weight-bold">${consulta.clave}.</span>
											¿Desea continuar?
										</h5>
										<button type="submit"
											class="btn btn-secondary text-white btn-sm">Eliminar</button>
										<a class="btn btn-secondary text-white btn-sm"
											href="<c:url value='/home/cat/principal/servicio'/>"
											role="button">Regresar</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</sf:form>
	</c:if>
	<%-- DELETE --%>
	<%-- EDIT --%>
	<c:if test="${event=='edit'}">
		<sf:form
			action="${pageContext.request.contextPath}/home/cat/principal/servicio/save"
			method="POST">
			<c:forEach items="${consulta}" var="consulta">
				<input name="evento" type="hidden" value="update" />
				<input name="id_servicios" type="hidden"
					value="${consulta.id_servicios}" />
				<input name="estatus" type="hidden" value="${consulta.estatus}" />
				<input name="id_forma_pago" type="hidden"
					value="${consulta.id_forma_pago}" />
				<div class="row">
					<div class="col-sm-12">
						<div class="card mt-1">
							<div class="card-header">
								<span class="title" id="menu-toggle">Detalle de Servicios</span>
								<ul class="nav d-inline-block">
									<li class="nav-item d-inline-block"><a
										class="nav-link text-secondary p-0 mr-3 ml-3  tab-link active"
										id="tab-1" data-toggle="tab" href="#tab1" role="tab"
										aria-controls="tab1" aria-selected="true">Datos Generales</a>
									</li>
									<li class="nav-item d-inline-block"><a
										class="nav-link text-secondary p-0 mr-3  tab-link" id="tab-2"
										data-toggle="tab" href="#tab2" role="tab" aria-controls="tab2"
										aria-selected="false">Procesos</a></li>
									<li class="nav-item d-inline-block"><a
										class="nav-link text-secondary p-0 mr-3  tab-link" id="tab-3"
										data-toggle="tab" href="#tab3" role="tab" aria-controls="tab3"
										aria-selected="false">Cobro y Precio</a></li>

									<li class="nav-item d-inline-block"><a
										class="nav-link text-secondary p-0 mr-3  tab-link" id="tab-5"
										data-toggle="tab" href="#tab5" role="tab" aria-controls="tab5"
										aria-selected="false">Subconceptos y Factura</a></li>
									<li class="nav-item d-inline-block"><a
										class="nav-link text-secondary p-0 mr-3  tab-link" id="tab-6"
										data-toggle="tab" href="#tab6" role="tab" aria-controls="tab6"
										aria-selected="false">Aplicaciones</a></li>
									<li class="nav-item d-inline-block"><a
										class="nav-link text-secondary p-0 mr-3  tab-link" id="tab-7"
										data-toggle="tab" href="#tab7" role="tab" aria-controls="tab7"
										aria-selected="false">Histórico</a></li>
								</ul>
								<a class="float-right text-secondary"
									href="<c:url value='/home/cat/principal/servicio'/>"
									role="button">Regresar</a><span
									class="float-right text-secondary mr-3" id="btn-ocultar">Ocultar</span>
							</div>
							<div class="tab-content" id="mainMenu">
								<div class="tab-pane  show active" id="tab1" role="tabpanel"
									aria-labelledby="tab-1">
									<%-- MENU1 --%>
									<%-- MENU1 --%>
									<div class="card-body">
										<div class="row">
											<div class="col-sm-6 col-md-6 mt-2">
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Clave </label>
													<div class="col-sm-8">
														<input type="text" class="form-control form-control-sm"
															name="clave" id="clave" value="${consulta.clave}"
															required>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Descripción
													</label>
													<div class="col-sm-8">
														<input type="text" class="form-control form-control-sm"
															name="descripcion" id="descripcion"
															value="${consulta.descripcion}" required>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Grupo
														Concepto </label>
													<div class="col-sm-8">
														<select class="form-control form-control-sm"
															name="id_grupo_concepto">
															<option value="" selected="selected">selecciona
																una opcion</option>
															<c:forEach items="${listaGrupoConceptoServ}"
																var="grupoCon">
																<option
																	value="<c:out value="${grupoCon.id_grupo}">
                                                                        </c:out>"
																	${grupoCon.id_grupo==consulta.id_grupo_concepto ?
                                                                        'selected="selected"' : ''}>
																	<c:out value="${grupoCon.clave}"></c:out>
																</option>
															</c:forEach>
														</select>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Grupo
														Volumen </label>
													<div class="col-sm-8">
														<select class="form-control form-control-sm"
															name="id_grupo_vol">
															<option value="" selected="selected">selecciona
																una opcion</option>
															<c:forEach items="${listaGrupoVolumenServicio}"
																var="grupoVol">
																<option
																	value="<c:out value="${grupoVol.id_grupo}"></c:out>"
																	${grupoVol.id_grupo==consulta.id_grupo_vol ?
                                                                        'selected="selected"' : ''}>
																	<c:out value="${grupoVol.clave}"></c:out>
																</option>
															</c:forEach>
														</select>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Negocio </label>
													<div class="col-sm-8">
														<select class="form-control form-control-sm"
															name="id_negocio">
															<option value="" selected="selected">selecciona
																una opcion</option>
															<c:forEach items="${listaNegocios}" var="negocio">
																<option
																	value="<c:out value="${negocio.id_negocio}">
                                                                        </c:out>"
																	${negocio.id_negocio==consulta.id_negocio ?
                                                                        'selected="selected"' : ''}>
																	<c:out value="${negocio.clave}"></c:out>
																</option>
															</c:forEach>
														</select>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Clave de
														Centro de Costos </label>
													<div class="col-sm-8">
														<select class="form-control form-control-sm"
															name="id_centro_costos">
															<option value="" selected="selected">selecciona
																una opcion</option>
															<c:forEach items="${listaCentroCosto}" var="centro">
																<option
																	value="<c:out value="${centro.id_centro_costos}">
                                                                        </c:out>"
																	${centro.id_centro_costos==consulta.id_centro_costos
                                                                        ? 'selected="selected"' : ''}>
																	<c:out value="${centro.clave_centro_costos}"></c:out> -
																	<c:out value="${centro.descripcion}"></c:out>
																</option>
															</c:forEach>
														</select>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Cuenta de
														Ingreso </label>
													<div class="col-sm-8">
														<input type="text" class="form-control form-control-sm"
															name="cuenta_ingreso" value="${consulta.cuenta_ingreso}" />
													</div>
												</div>
											</div>
											<div class="col-sm-6 col-md-6 mt-2">
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Servicios
														Particulares </label>
													<div class="col-sm-8">
														<select class="form-control form-control-sm"
															name="id_serv_part">
															<option value="" selected="selected">selecciona
																una opcion</option>
															<c:forEach items="${listaServiciosParticulares}"
																var="lista">
																<option
																	value="<c:out value="${lista.id}">
                                                                        </c:out>"
																	${lista.id==consulta.id_serv_part ?
                                                                        'selected="selected"' : ''}>
																	<c:out value="${lista.clave}"></c:out>
																</option>
															</c:forEach>
														</select>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Categorías
														de Ingreso </label>
													<div class="col-sm-8">
														<select class="form-control form-control-sm"
															name="id_cat_ingreso">
															<option value="" selected="selected">selecciona
																una opcion</option>
															<c:forEach items="${listaIngreso}" var="lista">
																<option
																	value="<c:out value="${lista.id}">
                                                                        </c:out>"
																	${lista.id==consulta.id_cat_ingreso ?
                                                                        'selected="selected"' : ''}>
																	<c:out value="${lista.clave}"></c:out> -
																	<c:out value="${lista.descripcion}"></c:out>
																</option>
															</c:forEach>
														</select>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Clave
														Servicio SAT </label>
													<div class="col-sm-8">
														<select class="form-control form-control-sm"
															name="clave_servicio_sat">
															<option value="" selected="selected">selecciona
																una opcion</option>
															<c:forEach items="${listaClavesServicio}" var="lista">
																<option
																	value="<c:out value="${lista.clave}">
                                                                        </c:out>"
																	${lista.clave==consulta.clave_servicio_sat ?
                                                                        'selected="selected"' : ''}>
																	<c:out value="${lista.clave}"></c:out> -
																	<c:out value="${lista.descripcion}"></c:out>
																</option>
															</c:forEach>
														</select>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Clave Unidad
														SAT </label>
													<div class="col-sm-8">
														<select class="form-control form-control-sm"
															name="clave_unidad_sat">
															<option value="" selected="selected">selecciona
																una opcion</option>
															<c:forEach items="${listaClavesUnidad}" var="lista">
																<option
																	value="<c:out value="${lista.clave}">
                                                                        </c:out>"
																	${lista.clave==consulta.clave_unidad_sat ?
                                                                        'selected="selected"' : ''}>
																	<c:out value="${lista.clave}"></c:out> -
																	<c:out value="${lista.descripcion}"></c:out>
																</option>
															</c:forEach>
														</select>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Clave
														Impuesto SAT </label>
													<div class="col-sm-8">
														<select class="form-control form-control-sm"
															name="clave_impuesto_sat">
															<option value="" selected="selected">selecciona
																una opcion</option>
															<c:forEach items="${listaTiposImpuesto}" var="lista">
																<option
																	value="<c:out value="${lista.clave}">
                                                                        </c:out>"
																	${lista.clave==consulta.clave_impuesto_sat ?
                                                                        'selected="selected"' : ''}>
																	<c:out value="${lista.clave}"></c:out> -
																	<c:out value="${lista.descripcion}"></c:out>
																</option>
															</c:forEach>
														</select>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Clave Factor
														SAT </label>
													<div class="col-sm-8">
														<select class="form-control form-control-sm"
															name="clave_factor_sat">
															<option value="" selected="selected">selecciona
																una opcion</option>
															<c:forEach items="${listaTiposFactor}" var="lista">
																<option
																	value="<c:out value="${lista.clave}">
                                                                        </c:out>"
																	${lista.clave==consulta.clave_factor_sat ?
                                                                        'selected="selected"' : ''}>
																	<c:out value="${lista.clave}"></c:out> -
																	<c:out value="${lista.descripcion}"></c:out>
																</option>
															</c:forEach>
														</select>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Valor Tasa
														SAT </label>
													<div class="col-sm-8">
														<select class="form-control form-control-sm"
															name="valor_tasa_sat">
															<option value="" selected="selected">selecciona
																una opcion</option>
															<c:forEach items="${listaTasasCuotas}" var="lista">
																<option
																	value="<c:out value="${lista.valor_maximo}">
                                                                        </c:out>"
																	${lista.valor_maximo==consulta.valor_tasa_sat ?
                                                                        'selected="selected"' : ''}>
																	<c:out value="${lista.clave}"></c:out> -
																	<c:out value="${lista.descripcion}"></c:out>
																</option>
															</c:forEach>
														</select>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Comentarios
													</label>
													<div class="col-sm-8">
														<textarea class="form-control" maxlength="250"
															name="comentarios">${consulta.comentarios}</textarea>
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
										<div class="row">
											<div class="col-sm-12 col-md-12 mt-2">
												<table class="table table-bordered">
													<thead>
														<tr>
															<th scope="col" class="border-bottom-0 col-1">Realizar</th>
															<th scope="col" class="border-bottom-0 col-2">Piloto
																Automático</th>
															<th scope="col" class="border-bottom-0 col-2">Proceso</th>
															<th scope="col" class="border-bottom-0 col-7">Datos
																relacionados al Proceso</th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td>N/A</td>
															<td>N/A</td>
															<td>Adquisición</td>
															<td>
																<div class="row">
																	<div class="col-sm-6 col-md-6 mt-2">
																		<div class="form-group row">
																			<label class="col-sm-4 col-form-label">Tipo</label>
																			<div class="col-sm-8">
																				<select class="form-control form-control-sm"
																					name="b_adquisicion_auto">
																					<option value="">selecciona una opcion</option>
																					<option value="0"
																						${'0' eq consulta.b_adquisicion_auto ? 'selected="selected"':''}>Manual</option>
																					<option value="1"
																						${'1' eq consulta.b_adquisicion_auto ? 'selected="selected"':''}>Automática</option>
																				</select>
																			</div>
																		</div>
																		<div class="form-group row">
																			<label class="col-sm-4 col-form-label">Fuente
																			</label>
																			<div class="col-sm-8">
																				<select class="form-control form-control-sm"
																					name="id_fuente" id="fuente">
																					<option value="">Seleccionar Fuente</option>
																					<c:forEach items="${listaFuentes}" var="lista">
																						<option
																							value="<c:out value="${lista.id_fuente}"></c:out>"
																							${lista.id_fuente eq consulta.id_fuente ? 'selected="selected"' : ''}>
																							<c:out value="${lista.clave}"></c:out>
																						</option>
																					</c:forEach>
																				</select>
																			</div>
																		</div>
																		<div class="form-group row">
																			<label class="col-sm-4 col-form-label">Fecha
																				Limite </label>
																			<div class="col-sm-8">
																				<select class="form-control form-control-sm"
																					name="dia_limite_solicitud">
																					<option value="">selecciona una opcion</option>
																					<option value="0">Manual</option>
																					<option value="1">Automática</option>
																				</select>
																			</div>
																		</div>
																	</div>
																	<div class="col-sm-6 col-md-6 mt-2">
																		<div class="form-group row">
																			<label class="col-sm-4 col-form-label">Periodicidad</label>
																			<div class="col-sm-8">
																				<select class="form-control form-control-sm"
																					name="periodicidad_adquisicion">
																					<option value="">selecciona una opcion</option>
																					<option value="DIA"
																						${'DIA' eq consulta.periodicidad_adquisicion ? 'selected="selected"':''}>Diaria</option>
																					<option value="MEN"
																						${'MEN' eq consulta.periodicidad_adquisicion ? 'selected="selected"':''}>Mensual</option>
																					<option value="EVE"
																						${'EVE' eq consulta.periodicidad_adquisicion ? 'selected="selected"':''}>Eventual</option>
																				</select>
																			</div>
																		</div>
																	</div>
																	<div class="col-sm-12 col-md-12 mt-2">
																		<div class="form-group row">
																			<div class="col-sm-12">
																				<div class="custom-control custom-checkbox">
																					<input class="custom-control-input"
																						id="opcionesAvanzadas" name="b_habilitar_op_av"
																						type="checkbox"
																						${consulta.b_habilitar_op_av eq '1' ? 'checked="checked"':''}>
																					<label class="custom-control-label pt-1"
																						for="opcionesAvanzadas">Habilitar al
																						usuario Opciones Avanzadas en la captura manual de
																						una solicitud del servicio</label>
																				</div>
																			</div>
																		</div>
																	</div>
																</div>
															</td>
														</tr>
														<tr>
															<td>
																<div class="row">
																	<div class="col-sm-12 col-md-12">
																		<div class="form-group row">
																			<div class="col-sm-12">
																				<div class="custom-control custom-checkbox">
																					<input class="custom-control-input"
																						id="realizar_calculo" name="realizar_calculo"
																						type="checkbox"
																						${consulta.realizar_calculo eq 'SI' ? 'checked="checked"':''}>
																					<label class="custom-control-label mb-3"
																						for="realizar_calculo"></label>
																				</div>
																			</div>
																		</div>
																	</div>
																</div>
															</td>
															<td>N/A</td>
															<td>Cálculo</td>
															<td>Siempre realizado después de la adquisición (con
																la misma periodicidad) o cuando solicitado.</td>
														</tr>
														<tr>
															<td>
																<div class="row">
																	<div class="col-sm-12 col-md-12">
																		<div class="form-group row">
																			<div class="col-sm-12">
																				<div class="custom-control custom-checkbox">
																					<input class="custom-control-input"
																						id="validate_envio" name="realizar_envio"
																						type="checkbox"
																						${consulta.realizar_envio eq 'SI' ? 'checked="checked"':''}>
																					<label class="custom-control-label mb-3"
																						for="validate_envio"></label>
																				</div>
																			</div>
																		</div>
																	</div>
																</div>
															</td>
															<td>
																<div class="row">
																	<div class="col-sm-12 col-md-12">
																		<div class="form-group row">
																			<div class="col-sm-12">
																				<div class="custom-control custom-checkbox">
																					<input class="custom-control-input"
																						id="validate_auto_envio" name="b_auto_cobro"
																						type="checkbox"
																						${consulta.b_auto_cobro eq 'SI' ? 'checked="checked"':''}>
																					<label class="custom-control-label mb-3"
																						for="validate_auto_envio"></label>
																				</div>
																			</div>
																		</div>
																	</div>
																</div>
															</td>
															<td>Envío de Cobro</td>
															<td>
																<div class="row mt-2">
																	<div class="col-sm-5 col-md-5">
																		<div class="form-group row">
																			<label class="col-sm-5 col-form-label">Periodicidad</label>
																			<div class="col-sm-7">
																				<select class="form-control form-control-sm"
																					name="periodicidad_cobro">
																					<option value="">selecciona una opcion</option>
																					<option value="DIA"
																						${'DIA' eq consulta.periodicidad_cobro ?  'selected="selected"':''}>Diaria</option>
																					<option value="MEN"
																						${'MEN' eq consulta.periodicidad_cobro ?  'selected="selected"':''}>Mensual</option>
																					<option value="EVE"
																						${'EVE' eq consulta.periodicidad_cobro ?  'selected="selected"':''}>Eventual</option>
																				</select>
																			</div>
																		</div>
																	</div>
																	<div class="col-sm-7 col-md-7">
																		<div class="form-group row">
																			<label class="col-sm-7 col-form-label">Dias
																				Hábiles Después de Emisión </label>
																			<div class="col-sm-5">
																				<input type="text"
																					class="form-control form-control-sm"
																					name="dias_habiles_cobro">
																			</div>
																		</div>
																	</div>
																</div>
															</td>
														</tr>
														<tr>
															<td>
																<div class="row">
																	<div class="col-sm-12 col-md-12">
																		<div class="form-group row">
																			<div class="col-sm-12">
																				<div class="custom-control custom-checkbox">
																					<input class="custom-control-input"
																						id="validate_reg_cont" name="realizar_reg_cont"
																						type="checkbox"
																						${consulta.realizar_reg_cont eq 'SI' ? 'checked="checked"':''}>
																					<label class="custom-control-label mb-3"
																						for="validate_reg_cont"></label>
																				</div>
																			</div>
																		</div>
																	</div>
																</div>
															</td>
															<td>
																<div class="row">
																	<div class="col-sm-12 col-md-12">
																		<div class="form-group row">
																			<div class="col-sm-12">
																				<div class="custom-control custom-checkbox">
																					<input class="custom-control-input"
																						id="validate_auto_reg_cont" name="b_auto_reg_cont"
																						type="checkbox"
																						${consulta.b_auto_reg_cont eq 'SI' ? 'checked="checked"':''}>
																					<label class="custom-control-label mb-3"
																						for="validate_auto_reg_cont"></label>
																				</div>
																			</div>
																		</div>
																	</div>
																</div>
															</td>
															<td>Registro Contable</td>
															<td>Siempre realizada después de la adquisición (con
																la misma periodicidad).</td>
														</tr>
														<tr>
															<td>N/A</td>
															<td>N/A</td>
															<td>Ajuste Mensual</td>
															<td>Siempre realizado en el cierre del mes.</td>
														</tr>
														<tr>
															<td>
																<div class="row">
																	<div class="col-sm-12 col-md-12">
																		<div class="form-group row">
																			<div class="col-sm-12">
																				<div class="custom-control custom-checkbox">
																					<input class="custom-control-input"
																						id="b_incluir_rebate" name="b_incluir_rebate"
																						type="checkbox"
																						${consulta.b_incluir_rebate eq '1' ? 'checked="checked"':''}>
																					<label class="custom-control-label mb-3"
																						for="b_incluir_rebate"></label>
																				</div>
																			</div>
																		</div>
																	</div>
																</div>
															</td>
															<td>N/A</td>
															<td>Rebate</td>
															<td>Siempre realizada en el cierre del mes.</td>
														</tr>
														<tr>
															<td>
																<div class="row">
																	<div class="col-sm-12 col-md-12">
																		<div class="form-group row">
																			<div class="col-sm-12">
																				<div class="custom-control custom-checkbox">
																					<input class="custom-control-input"
																						id="realizar_emision_fact"
																						name="realizar_emision_fact" type="checkbox"
																						${consulta.realizar_emision_fact eq 'SI' ? 'checked="checked"':''}>
																					<label class="custom-control-label mb-3"
																						for="realizar_emision_fact"></label>
																				</div>
																			</div>
																		</div>
																	</div>
																</div>
															</td>
															<td>N/A</td>
															<td>Emisión de Factura</td>
															<td>Realizada en el cierre del mes o cuando
																solicitado.</td>
														</tr>
													</tbody>
												</table>
											</div>
										</div>
									</div>
									<%-- MENU2 --%>
									<%-- MENU2 --%>
								</div>
								<div class="tab-pane " id="tab3" role="tabpanel"
									aria-labelledby="tab-3">
									<%-- MENU3 --%>
									<%-- MENU3 --%>
									<div class="card-body">
										<div class="row">
											<div class="col-sm-6 col-md-6 mt-2">
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Unidad de
														medida </label>
													<div class="col-sm-8">
														<select class="form-control form-control-sm"
															name="unidad_medida">
															<option value="">selecciona una opcion</option>
															<c:forEach items="${listaUnidadMedida}" var="lista">
																<option
																	value="<c:out value="${lista.unidad_medida}">
                                                                        </c:out>"
																	${lista.unidad_medida==consulta.unidad_medida ?
                                                                        'selected="selected"' : ''}>
																	<c:out value="${lista.unidad_medida}"></c:out>
																</option>
															</c:forEach>
														</select>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label"> Con cargo a</label>
													<div class="col-sm-8">
														<select class="form-control form-control-sm"
															name="tipo_cargo">
															<option value="">selecciona una opcion</option>
															<c:forEach items="${listaTiposCargo}" var="lista">
																<option
																	value="<c:out value="${lista.tipo_cargo}">
                                                                        </c:out>"
																	${lista.tipo_cargo==consulta.tipo_cargo ?
                                                                        'selected="selected"' : ''}>
																	<c:out value="${lista.tipo_cargo}"></c:out>
																</option>
															</c:forEach>
														</select>
													</div>
												</div>
											</div>
											<div class="col-sm-6 col-md-6 mt-2">
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Tipo de
														servicio </label>
													<div class="col-sm-8">
														<select class="form-control form-control-sm"
															name="tipo_servicio">
															<option value="">selecciona una opcion</option>
															<option value="COBRO"
																${'COBRO' eq consulta.tipo_servicio ? 'selected="selected"':''}>COBRO</option>
															<option value="PAGO"
																${'PAGO' eq consulta.tipo_servicio ? 'selected="selected"':''}>PAGO</option>
														</select>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-6 col-form-label">Unidad de
														medida de facturación</label>
													<div class="col-sm-6">
														<select class="form-control form-control-sm"
															name="umedida_factura">
															<option value="">selecciona una opcion</option>
															<c:forEach items="${listaUMedida}" var="lista">
																<option
																	value="<c:out value="${lista.clave}">
                                                                        </c:out>"
																	${lista.clave==consulta.umedida_factura ?
                                                                        'selected="selected"' : ''}>
																	<c:out value="${lista.clave}"></c:out>
																</option>
															</c:forEach>
														</select>
													</div>
												</div>
												<div class="form-group row">

													<div class="col-sm-6">
														<div class="form-group row">
															<div class="col-sm-12">
																<div class="custom-control custom-checkbox">
																	<input class="custom-control-input"
																		id="b_captura_imp_liquidado"
																		name="b_captura_imp_liquidado" type="checkbox"
																		${consulta.b_captura_imp_liquidado eq '1' ? 'checked="checked"':''}>
																	<label class="custom-control-label"
																		for="b_captura_imp_liquidado">Capturar Importe
																		Liquidado</label>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="row bg-secondary pb-2">
											<div class="col-sm-12 col-md-12 mt-2">
												<span class="title">Formas de pago</span>
											</div>
											<div class="col-sm-6 col-md-6 mt-2">
												<div class="form-group row">
													<label class="col-sm-6 col-form-label">Sistema</label>
													<div class="col-sm-6">
														<select class="form-control form-control-sm"
															name="sistem_cobro">
															<option value="">selecciona una opcion</option>
															<option value="LIB"
																${'LIB' eq consulta.sistem_cobro ? 'selected="selected"':''}>LIBRA</option>
															<option value="SAC"
																${'SAC' eq consulta.sistem_cobro ? 'selected="selected"':''}>SAC</option>
														</select>
													</div>
												</div>
											</div>
											<div class="col-sm-6 col-md-6 mt-2">
												<div class="form-group row">
													<label class="col-sm-6 col-form-label">Moneda para
														cobro </label>
													<div class="col-sm-6">
														<select class="form-control form-control-sm"
															name="id_moneda_adq">
															<option value="" selected="selected">selecciona
																una opcion</option>
															<option value="2"
																${'2' eq consulta.id_moneda_adq ? 'selected="selected"':''}>DOLAR</option>
															<option value="1"
																${'1' eq consulta.id_moneda_adq ? 'selected="selected"':''}>PESO</option>
														</select>
													</div>
												</div>
											</div>
										</div>
										<div class="row  pb-2">
											<div class="card-body">
												<div class="row">
													<div class="col-sm-6 col-md-6 mt-2">
														<div class="form-group row">
															<label class="col-sm-6 col-form-label">Precio
																controlado </label>
															<div class="col-sm-6">
																<select class="form-control form-control-sm"
																	name="b_precio_controlado" id="selectPrecioControlado">
																	<option value="1"
																		${consulta.b_precio_controlado == 1 ? 'selected="selected"':''}>SI</option>
																	<option value="0"
																		${consulta.b_precio_controlado == 0 ? 'selected="selected"':''}>NO</option>
																</select>
															</div>
														</div>
														<div class="form-group row">
															<label class="col-sm-6 col-form-label">Fecha
																ultima modificación de precio</label>
															<div class="col-sm-6">
																<input type="date" class="form-control form-control-sm"
																	name="" disabled />
															</div>
														</div>
													</div>
													<div class="col-sm-6 col-md-6 mt-2">
														<div class="form-group row">
															<label class="col-sm-6 col-form-label">Moneda de
																los importes adquiridos</label>
															<div class="col-sm-6">
																<select class="form-control form-control-sm"
																	name="id_moneda_importe_adq">
																	<option value="">selecciona una opcion</option>
																	<option value="2"
																		${'2' eq consulta.id_moneda_importe_adq ? 'selected="selected"':''}>DOLAR</option>
																	<option value="1"
																		${'1' eq consulta.id_moneda_importe_adq ? 'selected="selected"':''}>PESO</option>
																</select>
															</div>
														</div>
														<div class="form-group row">
															<label class="col-sm-6 col-form-label">Precio
																base</label>
															<div class="col-sm-6">
																<input type="text" class="form-control form-control-sm"
																	name="" disabled />
															</div>
														</div>

														<button type="button"
															class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto"
															id="btnDefinirPrecio">Definir Precio</button>
													</div>
												</div>
											</div>
										</div>
										<div class="row bg-secondary pb-2">
											<div class="col-sm-12 col-md-12 mt-2">
												<span class="title">IVA</span>
											</div>
											<div class="col-sm-8 col-md-8 mt-2">
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Manejo del
														IVA </label>
													<div class="col-sm-8">
														<select class="form-control form-control-sm"
															name="b_adquisicion_sin_iva">
															<option value="1"
																${'1' eq consulta.b_adquisicion_sin_iva ? 'selected="selected"':''}>No
																se captura IVA en la adquisición del servicio (será
																calculado por el sistema).</option>
															<option value="0"
																${'0' eq consulta.b_adquisicion_sin_iva ? 'selected="selected"':''}>Se
																captura IVA integrado a los importes informados en la
																adquisición del servicio.</option>
														</select>
													</div>
												</div>
											</div>
										</div>
									</div>
									<%-- MENU3 --%>
									<%-- MENU3 --%>
								</div>

								<div class="tab-pane " id="tab5" role="tabpanel"
									aria-labelledby="tab-5">
									<%-- MENU5 --%>
									<%-- MENU5 --%>
									<div class="card-body">
										<div class="row">
											<div class="col-sm-12 col-md-12 mt-2">
												<div class="form-group row">
													<div class="col-sm-12">
														<div class="custom-control custom-checkbox">
															<input class="custom-control-input"
																id="b_info_extra_desc_subconcep"
																name="b_info_extra_desc_subconcep" type="checkbox"
																${consulta.b_info_extra_desc_subconcep eq '1' ? 'checked="checked"':''}>
															<label class="custom-control-label"
																for="b_info_extra_desc_subconcep">Permite
																captura de campo de descripción.</label>
														</div>
													</div>
												</div>
												<div class="form-group row">
													<div class="col-sm-12">
														<div class="custom-control custom-checkbox">
															<input class="custom-control-input"
																id="b_info_extra_transaccion"
																name="b_info_extra_transaccion" type="checkbox"
																${consulta.b_info_extra_transaccion eq '1' ? 'checked="checked"':''}>
															<label class="custom-control-label"
																for="b_info_extra_transaccion">Permite captura
																de campo de transacciones (si Unidad de Medida no son
																transacciones).</label>
														</div>
													</div>
												</div>
												<div class="form-group row">

													<label class="col-sm-12 col-form-label title ml-4">Impresión
														de Facturas: Marque los datos que deben ir a la factura en
														la impresión (nota: no se imprimen los subconceptos)</label>
												</div>
												<div class="form-group row">
													<div class="col-sm-12">
														<div class="custom-control custom-checkbox">
															<input class="custom-control-input"
																id="b_imp_cantidad_en_fact"
																name="b_imp_cantidad_en_fact" type="checkbox"
																${consulta.b_imp_cantidad_en_fact eq '1' ? 'checked="checked"':''}>
															<label class="custom-control-label"
																for="b_imp_cantidad_en_fact">Cantidad (Número de
																Transacciones).</label>
														</div>
													</div>
												</div>
												<div class="form-group row">
													<div class="col-sm-12">
														<div class="custom-control custom-checkbox">
															<input class="custom-control-input"
																id="b_imp_costo_unitario" name="b_imp_costo_unitario"
																type="checkbox"
																${consulta.b_imp_costo_unitario eq '1' ? 'checked="checked"':''}>
															<label class="custom-control-label"
																for="b_imp_costo_unitario">Precio (Costo
																Unitario).</label>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<%-- MENU5 --%>
									<%-- MENU5 --%>
								</div>
								<div class="tab-pane " id="tab6" role="tabpanel"
									aria-labelledby="tab-6">
									<%-- MENU6 --%>
									<%-- MENU6 --%>
									<div class="card-body">
										<div class="row">
											<div class="col-sm-6 col-md-6 mt-2">
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Lista de
														aplicaciones</label>
													<div class="col-sm-8">
														<select name="asignarAplicacion"
															class="form-control form-control-sm">
															<c:forEach items="${consultaAplicacion}" var="consulta">
																<option value="${consulta.id}"><c:out
																		value="${consulta.descripcion_concepto}"></c:out></option>
															</c:forEach>
														</select>
													</div>
												</div>
											</div>
											<div class="col-sm-6 col-md-6 mt-2"></div>
										</div>
									</div>
									<div class="col-sm-12 mb-2">
										<div class="card mt-2">
											<span class="card-header title pl-2 p-1">Subconceptos
												Asociados</span>
											<div class="table-responsive">
												<table
													class="table table-scroll table-striped table-bordered table-hover">
													<thead>
														<tr>
															<th>Aplicacion</th>
															<th>Usuario</th>
															<th>Descripcion</th>
															<th>Id precio</th>
															<th>Ver precio</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach items="${consultaSubConcepto}" var="consulta">
															<tr>
																<td>${consulta.numero}</td>
																<td>${consulta.valor}</td>
																<td>${consulta.descripcion}</td>
																<td>${consulta.id_precio}</td>
																<td>
																	<button type="submit"
																		class="btn btn-secondary text-white btn-sm btn-table"
																		value="${consulta.numero}" id="btnAplicacionPrecio">
																		<span class="icon-border_color"></span>
																	</button>
																</td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
									</div>

									<%-- MENU6 --%>
									<%-- MENU6 --%>
								</div>
								<div class="tab-pane " id="tab7" role="tabpanel"
									aria-labelledby="tab-7">
									<%-- MENU7 --%>
									<%-- MENU7 --%>
									<div class="col-sm-12 mb-2">
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
									<%-- MENU7 --%>
									<%-- MENU7 --%>
								</div>
								<div class="col-md-12">
									<button type="submit"
										class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto ">Guardar</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</sf:form>
		<c:forEach items="${consulta}" var="consulta">
			<sf:form
				action="${pageContext.request.contextPath}/home/cat/principal/servicio/precio"
				method="POST">
				<input name="id_servicios" type="hidden"
					value="${consulta.id_servicios}" />
				<input name="clave" type="hidden" value="${consulta.clave}" />
				<input name="id_precio" type="hidden" value="${consulta.id_precio}" />
				<button type="submit"
					class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto d-none"
					id="btnHidden">Ir</button>
			</sf:form>
		</c:forEach>
		<c:forEach items="${consulta}" var="consulta">
			<sf:form
				action="${pageContext.request.contextPath}/home/cat/principal/servicio/precio"
				method="POST">
				<input name="id_servicios" type="hidden"
					value="${consulta.id_servicios}" />
				<input name="clave" type="hidden" value="${consulta.clave}" />
				<input name="id_precio" type="hidden" value="${consulta.id_precio}" />
				<input name="numero" type="hidden" />
				<button type="submit"
					class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto d-none"
					id="btnHiddenAplicacionesPrecio">Ir</button>
			</sf:form>
		</c:forEach>
	</c:if>
	<c:if test="${event=='new'}">
		<sf:form
			action="${pageContext.request.contextPath}/home/cat/principal/servicio/save"
			method="POST">

			<input name="evento" type="hidden" value="insert" />

			<div class="row">
				<div class="col-sm-12">
					<div class="card mt-1">
						<div class="card-header">
							<span class="title" id="menu-toggle">Detalle de Servicios</span>
							<ul class="nav d-inline-block">
								<li class="nav-item d-inline-block"><a
									class="nav-link text-secondary p-0 mr-3 ml-3  tab-link active"
									id="tab-1" data-toggle="tab" href="#tab1" role="tab"
									aria-controls="tab1" aria-selected="true">Datos Generales</a></li>
								<li class="nav-item d-inline-block"><a
									class="nav-link text-secondary p-0 mr-3  tab-link" id="tab-2"
									data-toggle="tab" href="#tab2" role="tab" aria-controls="tab2"
									aria-selected="false">Procesos</a></li>
								<li class="nav-item d-inline-block"><a
									class="nav-link text-secondary p-0 mr-3  tab-link" id="tab-3"
									data-toggle="tab" href="#tab3" role="tab" aria-controls="tab3"
									aria-selected="false">Cobro y Precio</a></li>
							</ul>
							<a class="float-right text-secondary"
								href="<c:url value='/home/cat/principal/servicio'/>"
								role="button">Regresar</a><span
								class="float-right text-secondary mr-3" id="btn-ocultar">Ocultar</span>
						</div>
						<div class="tab-content" id="mainMenu">
							<div class="tab-pane  show active" id="tab1" role="tabpanel"
								aria-labelledby="tab-1">
								<%-- MENU1 --%>
								<%-- MENU1 --%>
								<div class="card-body">
									<div class="row">
										<div class="col-sm-6 col-md-6 mt-2">
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Clave </label>
												<div class="col-sm-8">
													<input type="text" class="form-control form-control-sm"
														name="clave" id="clave" required>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Descripción </label>
												<div class="col-sm-8">
													<input type="text" class="form-control form-control-sm"
														name="descripcion" id="descripcion" required>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Grupo
													Concepto </label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm"
														name="id_grupo_concepto">
														<option value="" selected="selected">selecciona
															una opcion</option>
														<c:forEach items="${listaGrupoConceptoServ}"
															var="grupoCon">
															<option
																value="<c:out value="${grupoCon.id_grupo}">
                                                                        </c:out>">
																<c:out value="${grupoCon.clave}"></c:out>
															</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Grupo Volumen
												</label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm"
														name="id_grupo_vol">
														<option value="" selected="selected">selecciona
															una opcion</option>
														<c:forEach items="${listaGrupoVolumenServicio}"
															var="grupoVol">
															<option
																value="<c:out value="${grupoVol.id_grupo}"></c:out>">
																<c:out value="${grupoVol.clave}"></c:out>
															</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Negocio </label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm"
														name="id_negocio">
														<option value="" selected="selected">selecciona
															una opcion</option>
														<c:forEach items="${listaNegocios}" var="negocio">
															<option
																value="<c:out value="${negocio.id_negocio}">
                                                                        </c:out>">
																<c:out value="${negocio.clave}"></c:out>
															</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Clave de
													Centro de Costos </label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm"
														name="id_centro_costos">
														<option value="" selected="selected">selecciona
															una opcion</option>
														<c:forEach items="${listaCentroCosto}" var="centro">
															<option
																value="<c:out value="${centro.id_centro_costos}">
                                                                        </c:out>">
																<c:out value="${centro.clave_centro_costos}"></c:out> -
																<c:out value="${centro.descripcion}"></c:out>
															</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Cuenta de
													Ingreso </label>
												<div class="col-sm-8">
													<input type="text" class="form-control form-control-sm"
														name="cuenta_ingreso" />
												</div>
											</div>
										</div>
										<div class="col-sm-6 col-md-6 mt-2">
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Servicios
													Particulares </label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm"
														name="id_serv_part">
														<option value="" selected="selected">selecciona
															una opcion</option>
														<c:forEach items="${listaServiciosParticulares}"
															var="lista">
															<option
																value="<c:out value="${lista.id}">
                                                                        </c:out>">
																<c:out value="${lista.clave}"></c:out>
															</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Categorías de
													Ingreso </label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm"
														name="id_cat_ingreso">
														<option value="" selected="selected">selecciona
															una opcion</option>
														<c:forEach items="${listaIngreso}" var="lista">
															<option
																value="<c:out value="${lista.id}">
                                                                        </c:out>">
																<c:out value="${lista.clave}"></c:out> -
																<c:out value="${lista.descripcion}"></c:out>
															</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Clave
													Servicio SAT </label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm"
														name="clave_servicio_sat">
														<option value="" selected="selected">selecciona
															una opcion</option>
														<c:forEach items="${listaClavesServicio}" var="lista">
															<option
																value="<c:out value="${lista.clave}">
                                                                        </c:out>">
																<c:out value="${lista.clave}"></c:out> -
																<c:out value="${lista.descripcion}"></c:out>
															</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Clave Unidad
													SAT </label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm"
														name="clave_unidad_sat">
														<option value="" selected="selected">selecciona
															una opcion</option>
														<c:forEach items="${listaClavesUnidad}" var="lista">
															<option
																value="<c:out value="${lista.clave}">
                                                                        </c:out>">
																<c:out value="${lista.clave}"></c:out> -
																<c:out value="${lista.descripcion}"></c:out>
															</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Clave
													Impuesto SAT </label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm"
														name="clave_impuesto_sat">
														<option value="" selected="selected">selecciona
															una opcion</option>
														<c:forEach items="${listaTiposImpuesto}" var="lista">
															<option
																value="<c:out value="${lista.clave}">
                                                                        </c:out>">
																<c:out value="${lista.clave}"></c:out> -
																<c:out value="${lista.descripcion}"></c:out>
															</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Clave Factor
													SAT </label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm"
														name="clave_factor_sat">
														<option value="" selected="selected">selecciona
															una opcion</option>
														<c:forEach items="${listaTiposFactor}" var="lista">
															<option
																value="<c:out value="${lista.clave}">
                                                                        </c:out>">
																<c:out value="${lista.clave}"></c:out> -
																<c:out value="${lista.descripcion}"></c:out>
															</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Valor Tasa
													SAT </label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm"
														name="valor_tasa_sat">
														<option value="" selected="selected">selecciona
															una opcion</option>
														<c:forEach items="${listaTasasCuotas}" var="lista">
															<option
																value="<c:out value="${lista.valor_maximo}">
                                                                        </c:out>">
																<c:out value="${lista.clave}"></c:out> -
																<c:out value="${lista.descripcion}"></c:out>
															</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Comentarios </label>
												<div class="col-sm-8">
													<textarea class="form-control" maxlength="250"
														name="comentarios"></textarea>
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
									<div class="row">
										<div class="col-sm-12 col-md-12 mt-2">
											<table class="table table-bordered">
												<thead>
													<tr>
														<th scope="col" class="border-bottom-0 col-1">Realizar</th>
														<th scope="col" class="border-bottom-0 col-2">Piloto
															Automático</th>
														<th scope="col" class="border-bottom-0 col-2">Proceso</th>
														<th scope="col" class="border-bottom-0 col-7">Datos
															relacionados al Proceso</th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td>N/A</td>
														<td>N/A</td>
														<td>Adquisición</td>
														<td>
															<div class="row">
																<div class="col-sm-6 col-md-6 mt-2">
																	<div class="form-group row">
																		<label class="col-sm-4 col-form-label">Tipo</label>
																		<div class="col-sm-8">
																			<select class="form-control form-control-sm"
																				name="b_adquisicion_auto">
																				<option value="">selecciona una opcion</option>
																				<option value="0">Manual</option>
																				<option value="1">Automática</option>
																			</select>
																		</div>
																	</div>
																	<div class="form-group row">
																		<label class="col-sm-4 col-form-label">Fuente
																		</label>
																		<div class="col-sm-8">
																			<select class="form-control form-control-sm"
																				name="id_fuente" id="fuente">
																				<option value="">Seleccionar Fuente</option>
																				<c:forEach items="${listaFuentes}" var="lista">
																					<option
																						value="<c:out value="${lista.id_fuente}"></c:out>">
																						<c:out value="${lista.clave}"></c:out>
																					</option>
																				</c:forEach>
																			</select>
																		</div>
																	</div>
																	<div class="form-group row">
																		<label class="col-sm-4 col-form-label">Fecha
																			Limite </label>
																		<div class="col-sm-8">
																			<select class="form-control form-control-sm"
																				name="dia_limite_solicitud">
																				<option value="">selecciona una opcion</option>
																				<option value="0">Manual</option>
																				<option value="1">Automática</option>
																			</select>
																		</div>
																	</div>
																</div>
																<div class="col-sm-6 col-md-6 mt-2">
																	<div class="form-group row">
																		<label class="col-sm-4 col-form-label">Periodicidad</label>
																		<div class="col-sm-8">
																			<select class="form-control form-control-sm"
																				name="periodicidad_adquisicion">
																				<option value="">selecciona una opcion</option>
																				<option value="DIA">Diaria</option>
																				<option value="MEN">Mensual</option>
																				<option value="EVE">Eventual</option>
																			</select>
																		</div>
																	</div>
																</div>
																<div class="col-sm-12 col-md-12 mt-2">
																	<div class="form-group row">
																		<div class="col-sm-12">
																			<div class="custom-control custom-checkbox">
																				<input class="custom-control-input"
																					id="opcionesAvanzadas" name="b_habilitar_op_av"
																					type="checkbox"> <label
																					class="custom-control-label pt-1"
																					for="opcionesAvanzadas">Habilitar al
																					usuario Opciones Avanzadas en la captura manual de
																					una solicitud del servicio</label>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</td>
													</tr>
													<tr>
														<td>
															<div class="row">
																<div class="col-sm-12 col-md-12">
																	<div class="form-group row">
																		<div class="col-sm-12">
																			<div class="custom-control custom-checkbox">
																				<input class="custom-control-input"
																					id="realizar_calculo" name="realizar_calculo"
																					type="checkbox"> <label
																					class="custom-control-label mb-3"
																					for="realizar_calculo"></label>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</td>
														<td>N/A</td>
														<td>Cálculo</td>
														<td>Siempre realizado después de la adquisición (con
															la misma periodicidad) o cuando solicitado.</td>
													</tr>
													<tr>
														<td>
															<div class="row">
																<div class="col-sm-12 col-md-12">
																	<div class="form-group row">
																		<div class="col-sm-12">
																			<div class="custom-control custom-checkbox">
																				<input class="custom-control-input"
																					id="validate_envio" name="realizar_envio"
																					type="checkbox"> <label
																					class="custom-control-label mb-3"
																					for="validate_envio"></label>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</td>
														<td>
															<div class="row">
																<div class="col-sm-12 col-md-12">
																	<div class="form-group row">
																		<div class="col-sm-12">
																			<div class="custom-control custom-checkbox">
																				<input class="custom-control-input"
																					id="validate_auto_envio" name="b_auto_cobro"
																					type="checkbox"> <label
																					class="custom-control-label mb-3"
																					for="validate_auto_envio"></label>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</td>
														<td>Envío de Cobro</td>
														<td>
															<div class="row mt-2">
																<div class="col-sm-5 col-md-5">
																	<div class="form-group row">
																		<label class="col-sm-5 col-form-label">Periodicidad</label>
																		<div class="col-sm-7">
																			<select class="form-control form-control-sm"
																				name="periodicidad_cobro">
																				<option value="">selecciona una opcion</option>
																				<option value="DIA">Diaria</option>
																				<option value="MEN">Mensual</option>
																				<option value="EVE">Eventual</option>
																			</select>
																		</div>
																	</div>
																</div>
																<div class="col-sm-7 col-md-7">
																	<div class="form-group row">
																		<label class="col-sm-7 col-form-label">Dias
																			Hábiles Después de Emisión </label>
																		<div class="col-sm-5">
																			<input type="text"
																				class="form-control form-control-sm"
																				name="dias_habiles_cobro">
																		</div>
																	</div>
																</div>
															</div>
														</td>
													</tr>
													<tr>
														<td>
															<div class="row">
																<div class="col-sm-12 col-md-12">
																	<div class="form-group row">
																		<div class="col-sm-12">
																			<div class="custom-control custom-checkbox">
																				<input class="custom-control-input"
																					id="validate_reg_cont" name="realizar_reg_cont"
																					type="checkbox"> <label
																					class="custom-control-label mb-3"
																					for="validate_reg_cont"></label>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</td>
														<td>
															<div class="row">
																<div class="col-sm-12 col-md-12">
																	<div class="form-group row">
																		<div class="col-sm-12">
																			<div class="custom-control custom-checkbox">
																				<input class="custom-control-input"
																					id="validate_auto_reg_cont" name="b_auto_reg_cont"
																					type="checkbox"> <label
																					class="custom-control-label mb-3"
																					for="validate_auto_reg_cont"></label>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</td>
														<td>Registro Contable</td>
														<td>Siempre realizada después de la adquisición (con
															la misma periodicidad).</td>
													</tr>
													<tr>
														<td>N/A</td>
														<td>N/A</td>
														<td>Ajuste Mensual</td>
														<td>Siempre realizado en el cierre del mes.</td>
													</tr>
													<tr>
														<td>
															<div class="row">
																<div class="col-sm-12 col-md-12">
																	<div class="form-group row">
																		<div class="col-sm-12">
																			<div class="custom-control custom-checkbox">
																				<input class="custom-control-input"
																					id="b_incluir_rebate" name="b_incluir_rebate"
																					type="checkbox"> <label
																					class="custom-control-label mb-3"
																					for="b_incluir_rebate"></label>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</td>
														<td>N/A</td>
														<td>Rebate</td>
														<td>Siempre realizada en el cierre del mes.</td>
													</tr>
													<tr>
														<td>
															<div class="row">
																<div class="col-sm-12 col-md-12">
																	<div class="form-group row">
																		<div class="col-sm-12">
																			<div class="custom-control custom-checkbox">
																				<input class="custom-control-input"
																					id="realizar_emision_fact"
																					name="realizar_emision_fact" type="checkbox">
																				<label class="custom-control-label mb-3"
																					for="realizar_emision_fact"></label>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</td>
														<td>N/A</td>
														<td>Emisión de Factura</td>
														<td>Realizada en el cierre del mes o cuando
															solicitado.</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
								<%-- MENU2 --%>
								<%-- MENU2 --%>
							</div>
							<div class="tab-pane " id="tab3" role="tabpanel"
								aria-labelledby="tab-3">
								<%-- MENU3 --%>
								<%-- MENU3 --%>
								<div class="card-body">
									<div class="row">
										<div class="col-sm-6 col-md-6 mt-2">
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Unidad de
													medida </label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm"
														name="unidad_medida">
														<option value="">selecciona una opcion</option>
														<c:forEach items="${listaUnidadMedida}" var="lista">
															<option
																value="<c:out value="${lista.unidad_medida}">
                                                                        </c:out>">
																<c:out value="${lista.unidad_medida}"></c:out>
															</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label"> Con cargo a</label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm"
														name="tipo_cargo">
														<option value="">selecciona una opcion</option>
														<c:forEach items="${listaTiposCargo}" var="lista">
															<option
																value="<c:out value="${lista.tipo_cargo}">
                                                                        </c:out>">
																<c:out value="${lista.tipo_cargo}"></c:out>
															</option>
														</c:forEach>
													</select>
												</div>
											</div>
										</div>
										<div class="col-sm-6 col-md-6 mt-2">
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Tipo de
													servicio </label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm"
														name="tipo_servicio">
														<option value="">selecciona una opcion</option>
														<option value="COBRO">COBRO</option>
														<option value="PAGO">PAGO</option>
													</select>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-6 col-form-label">Unidad de
													medida de facturación</label>
												<div class="col-sm-6">
													<select class="form-control form-control-sm"
														name="umedida_factura">
														<option value="">selecciona una opcion</option>
														<c:forEach items="${listaUMedida}" var="lista">
															<option
																value="<c:out value="${lista.clave}">
                                                                        </c:out>">
																<c:out value="${lista.clave}"></c:out>
															</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-group row">

												<div class="col-sm-6">
													<div class="form-group row">
														<div class="col-sm-12">
															<div class="custom-control custom-checkbox">
																<input class="custom-control-input"
																	id="b_captura_imp_liquidado"
																	name="b_captura_imp_liquidado" type="checkbox">
																<label class="custom-control-label"
																	for="b_captura_imp_liquidado">Capturar Importe
																	Liquidado</label>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="row bg-secondary pb-2">
										<div class="col-sm-12 col-md-12 mt-2">
											<span class="title">Formas de pago</span>
										</div>
										<div class="col-sm-6 col-md-6 mt-2">
											<div class="form-group row">
												<label class="col-sm-6 col-form-label">Sistema</label>
												<div class="col-sm-6">
													<select class="form-control form-control-sm"
														name="sistem_cobro">
														<option value="">selecciona una opcion</option>
														<option value="LIB">LIBRA</option>
														<option value="SAC">SAC</option>
													</select>
												</div>
											</div>
										</div>
										<div class="col-sm-6 col-md-6 mt-2">
											<div class="form-group row">
												<label class="col-sm-6 col-form-label">Moneda para
													cobro </label>
												<div class="col-sm-6">
													<select class="form-control form-control-sm"
														name="id_moneda_adq">
														<option value="" selected="selected">selecciona
															una opcion</option>
														<option value="2">DOLAR</option>
														<option value="1">PESO</option>
													</select>
												</div>
											</div>
										</div>
									</div>
									
									<div class="row bg-secondary pb-2">
										<div class="col-sm-12 col-md-12 mt-2">
											<span class="title">IVA</span>
										</div>
										<div class="col-sm-8 col-md-8 mt-2">
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Manejo del
													IVA </label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm"
														name="b_adquisicion_sin_iva">
														<option value="1">No se captura IVA en la
															adquisición del servicio (será calculado por el sistema).</option>
														<option value="0">Se captura IVA integrado a los
															importes informados en la adquisición del servicio.</option>
													</select>
												</div>
											</div>
										</div>
									</div>
								</div>
								<%-- MENU3 --%>
								<%-- MENU3 --%>
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
		<c:forEach items="${consulta}" var="consulta">
			<sf:form
				action="${pageContext.request.contextPath}/home/cat/principal/servicio/precio"
				method="POST">
				<input name="id_servicios" type="hidden"
					value="${consulta.id_servicios}" />
				<input name="clave" type="hidden" value="${consulta.clave}" />
				<input name="id_precio" type="hidden" value="${consulta.id_precio}" />
				<button type="submit"
					class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto d-none"
					id="btnHidden">Ir</button>
			</sf:form>
		</c:forEach>
		<c:forEach items="${consulta}" var="consulta">
			<sf:form
				action="${pageContext.request.contextPath}/home/cat/principal/servicio/precio"
				method="POST">
				<input name="id_servicios" type="hidden"
					value="${consulta.id_servicios}" />
				<input name="clave" type="hidden" value="${consulta.clave}" />
				<input name="id_precio" type="hidden" value="${consulta.id_precio}" />
				<input name="numero" type="hidden" />
				<button type="submit"
					class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto d-none"
					id="btnHiddenAplicacionesPrecio">Ir</button>
			</sf:form>
		</c:forEach>
	</c:if>


	<%-- LIMITE --%>
	<%-- LIMITE --%>
	<%-- LIMITE --%>

</div>

<%@ include file="../../layout/footer.jsp"%>