<%@ include file="../../layout/header.jsp"%>
<%@ include file="../../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<input type="hidden" id="path"
					value="${pageContext.request.contextPath}" />
				<%-- VISTA ELIMINAR --%>
				<%-- VISTA ELIMINAR --%>
				<%-- VISTA ELIMINAR --%>
				<c:if test="${event=='delete'}">
					<sf:form
						action="${pageContext.request.contextPath}/home/cat/principal/cliente/save"
						method="POST" name="insert">
						<c:forEach items="${consulta}" var="editar">
							<input name="evento" type="hidden" value="delete" />
							<input name="id_cliente" type="hidden"
								value="${editar.id_cliente}" />
							<div class="card-header">
								<span class="title" id="menu-toggle">Eliminar</span> <a
									class="float-right text-secondary"
									href="<c:url value='/home/cat/principal/cliente'/>"
									role="button">Regresar</a>
							</div>
							<div id="mainMenu" class="collapse show card-body">
								<div class="row">
									<div class="col-sm-12 col-md-12  text-center">
										<h5 class="card-title">
											Está a punto de eliminar a <span class="font-weight-bold">${editar.clave_cliente}.</span>
											¿Desea continuar?
										</h5>
										<button type="submit"
											class="btn btn-secondary text-white btn-sm">Eliminar</button>
										<a class="btn btn-secondary text-white btn-sm"
											href="<c:url value='/home/cat/principal/cliente'/>"
											role="button">Regresar</a>
									</div>
								</div>
							</div>
						</c:forEach>
					</sf:form>
				</c:if>
				<%-- VISTA ELIMINAR --%>
				<%-- VISTA ELIMINAR --%>
				<%-- VISTA ELIMINAR --%>
				<%-- VISTA EDITAR --%>
				<%-- VISTA EDITAR --%>
				<%-- VISTA EDITAR --%>
				<c:if test="${event=='edit'}">
					<c:forEach items="${consulta}" var="editar">
						<div class="card-header">
							<span class="title" id="menu-toggle">Editando a <c:out
									value="${editar.clave_cliente}"></c:out></span>
							<ul class="nav d-inline-block">
								<li class="nav-item d-inline-block"><a
									class="contactostab nav-link text-secondary p-0 mr-3 ml-3  tab-link active"
									id="tab-1" data-toggle="tab" href="#tab1" role="tab"
									aria-controls="tab1" aria-selected="true">Datos Generales</a></li>
								<li class="nav-item d-inline-block"><a
									class="contactostab nav-link text-secondary p-0 mr-3  tab-link"
									id="tab-2" data-toggle="tab" href="#tab2" role="tab"
									aria-controls="tab2" aria-selected="false">Dirección</a></li>
								<li class="nav-item d-inline-block"><a
									class="contactostab nav-link text-secondary p-0 mr-3  tab-link"
									id="tab-3" data-toggle="tab" href="#tab3" role="tab"
									aria-controls="tab3" aria-selected="false">Contactos</a></li>
								<li class="nav-item d-inline-block"><a
									class="nav-link text-secondary p-0 mr-3  tab-link" id="tab-4"
									data-toggle="tab" href="#tab4" role="tab" aria-controls="tab4"
									aria-selected="false">Relación de Claves</a></li>
								<!-- 
								
								
								<li class="nav-item d-inline-block"><a
									class="nav-link text-secondary p-0 mr-3  tab-link" id="tab-5"
									data-toggle="tab" href="#tab5" role="tab" aria-controls="tab5"
									aria-selected="false">Cuentas Contables</a></li>
								<li class="nav-item d-inline-block"><a
									class="nav-link text-secondary p-0 mr-3  tab-link" id="tab-5"
									data-toggle="tab" href="#tab6" role="tab" aria-controls="tab6"
									aria-selected="false">Metodos de pago</a></li>
								-->
								<li class="nav-item d-inline-block"><a
									class="contactostab nav-link text-secondary p-0 mr-3  tab-link"
									id="tab-8" data-toggle="tab" href="#tab8" role="tab"
									aria-controls="tab8" aria-selected="false">Histórico</a></li>
							</ul>
							<a class="float-right text-secondary"
								href="<c:url value='/home/cat/principal/cliente'/>"
								role="button">Regresar</a> <span
								class="float-right text-secondary mr-3" id="btn-ocultar">Ocultar</span>
						</div>
						<sf:form
							action="${pageContext.request.contextPath}/home/cat/principal/cliente/save"
							method="POST" commandName="fuente" autocomplete="off">
							<input name="evento" type="hidden" value="update" />
							<input name="id_cliente" id="cliente_id" type="hidden"
								value="${editar.id_cliente}" />
							<div class="tab-content" id="mainMenu">
								<div class="tab-pane  show active" id="tab1" role="tabpanel"
									aria-labelledby="tab-1">
									<%-- MENU1 --%>
									<%-- MENU1 --%>
									<div class="card-body">
										<div class="row">
											<div class="col-sm-6 col-md-6 mt-2">
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Cliente</label>
													<div class="col-sm-8">
														<input type="text" class="form-control form-control-sm"
															name="clave_cliente" value="${editar.clave_cliente}"
															maxlength="20" disabled required />
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">RFC</label>
													<div class="col-sm-8">
														<input type="text" class="form-control form-control-sm"
															name="rfc" value="${editar.rfc}" maxlength="45" />
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Curp</label>
													<div class="col-sm-8">
														<input type="text" class="form-control form-control-sm"
															name="curp" value="${editar.curp}" maxlength="18" />
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Fiid</label>
													<div class="col-sm-8">
														<input type="text" class="form-control form-control-sm"
															name="fiid" value="${editar.fiid}" maxlength="5" />
													</div>
												</div>
											</div>
											<div class="col-sm-6 col-md-6 mt-2">
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Nombre Corto</label>
													<div class="col-sm-8">
														<input type="text" class="form-control form-control-sm"
															name="nombre_corto" value="${editar.nombre_corto}"
															maxlength="80" required />
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Razón Social</label>
													<div class="col-sm-8">
														<input type="text" class="form-control form-control-sm"
															name="razon_social" value="${editar.razon_social}"
															maxlength="200" required />
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Clave Grupo
														de Cliente</label>
													<div class="col-sm-8">
														<select class="form-control form-control-sm"
															name="id_grupo_vol">
															<option value="">Selecciona una opcion</option>
															<c:forEach items="${listaGrupoCliente}" var="lista">
																<option
																	value="<c:out value="${lista.id_grupo}"> </c:out>"
																	${ lista.id_grupo==editar.id_grupo_vol ? 'selected="selected"' : ''}>
																	<c:out value="${lista.clave}"></c:out>
																</option>
															</c:forEach>
														</select>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Formas de
														Pago SAT</label>
													<div class="col-sm-8">
														<select class="form-control form-control-sm"
															name="clave_formapago_sat">
															<option value="">Selecciona una opcion</option>
															<c:forEach items="${listaFormasPago}" var="lista">
																<option value="${lista.clave}"
																	${lista.clave eq editar.clave_formapago_sat ? 'selected="selected"' : ''}>${lista.clave}-${lista.descripcion}</option>
															</c:forEach>
														</select>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label"> Numero Id
														Fiscal (extranjero) </label>
													<div class="col-sm-8">
														<input type="text" class="form-control form-control-sm"
															name="numero_idfiscal_sat"
															value="${editar.numero_idfiscal_sat}" maxlength="64" />
													</div>
												</div>
											</div>
											<div class="col-sm-6 col-md-6 mt-4">
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">RFC Banco
														Emisor</label>
													<div class="col-sm-8">
														<input type="text" class="form-control form-control-sm"
															name="rfc_entidad_emi" value="${editar.rfc_entidad_emi}"
															maxlength="32" />
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Cuenta Banco
														Emisor</label>
													<div class="col-sm-8">
														<input type="text" class="form-control form-control-sm"
															name="cuenta_bancaria" value="${editar.cuenta_bancaria}"
															maxlength="64" />
													</div>
												</div>
											</div>
											<div class="col-sm-6 col-md-6 mt-4">
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Nombre Banco
														Emisor</label>
													<div class="col-sm-8">
														<input type="text" class="form-control form-control-sm"
															name="nom_entidad_emi" value="${editar.nom_entidad_emi}"
															maxlength="128" />
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Cuenta Banco
														Deposito</label>
													<div class="col-sm-8">
														<select class="form-control form-control-sm"
															name="id_cuenta_banco">
															<option value="">Selecciona una opcion</option>
															<c:forEach items="${listaBanco}" var="lista">
																<option value="<c:out value="${lista.id}"></c:out>"
																	${lista.id eq editar.id_cuenta_banco ?'selected="selected"':''}>
																	<c:out value="${lista.cuenta}"></c:out>
																	<c:out value="${lista.nom_banco}"></c:out>
																</option>
															</c:forEach>
														</select>
													</div>
												</div>
											</div>
											<div class="col-sm-6 col-md-6 mt-4">
												<div class="custom-control custom-checkbox">
													<input class="custom-control-input"
														id="b_cliente_consorcio" name="b_cliente_consorcio"
														type="checkbox"
														${editar.b_cliente_consorcio eq '1' ? 'checked="checked"':''}>
													<label class="custom-control-label"
														for="b_cliente_consorcio">Cliente Consorcio</label>
												</div>
												<div class="custom-control custom-checkbox">
													<input class="custom-control-input" id="b_cliente_socio"
														name="b_cliente_socio" type="checkbox"
														${editar.b_cliente_socio eq '1' ? 'checked="checked"':''}>
													<label class="custom-control-label" for="b_cliente_socio">Cliente
														Socio</label>
												</div>
												<div class="custom-control custom-checkbox">
													<input class="custom-control-input" id="b_incluir_rebate"
														name="b_incluir_rebate" type="checkbox"
														${editar.b_incluir_rebate eq '1' ? 'checked="checked"':''}>
													<label class="custom-control-label" for="b_incluir_rebate">Cliente
														Entra en Rebate</label>
												</div>
											</div>
											<div class="col-sm-6 col-md-6 mt-4">
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Tasa IVA del
														Cliente</label>
													<div class="col-sm-8">
														<input type="text"
															class="form-control form-control-sm just-number"
															name="pct_iva" value="${editar.pct_iva}" maxlength="5" />
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Información
														Adicional 1</label>
													<div class="col-sm-8">
														<input type="text" class="form-control form-control-sm"
															name="inf_addicional" value="${editar.inf_addicional}"
															maxlength="100" />
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Información
														Adicional 2</label>
													<div class="col-sm-8">
														<input type="text" class="form-control form-control-sm"
															name="inf_addicional_1"
															value="${editar.inf_addicional_1}" maxlength="100" />
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Comentarios</label>
													<div class="col-sm-8">
														<input type="text" class="form-control form-control-sm"
															name="comentarios" value="${editar.comentarios}"
															maxlength="200" required />
													</div>
												</div>
											</div>
										</div>
									</div>
									<%-- MENU1 --%>
									<%-- MENU1 --%>
								</div>
								<div class="tab-pane origen" id="tab2" role="tabpanel"
									aria-labelledby="tab-2">
									<%-- MENU2 --%>
									<%-- MENU2 --%>
									<div class="card-body llevar">
										<input type="hidden" name="b_cliente_nacional"
											id="b_cliente_nacional" value="1">
										<div class="custom-control custom-radio custom-control-inline">
											<input type="radio" id="radioNacional" name="radioDireccion"
												class="custom-control-input radioDireccion"
												${editar.b_cliente_nacional eq '1' ? 'checked="checked"':''}>
											<label class="custom-control-label" for="radioNacional">Nacional</label>
										</div>
										<div class="custom-control custom-radio custom-control-inline">
											<input type="radio" id="radioInternacional"
												name="radioDireccion"
												class="custom-control-input radioDireccion"
												${editar.b_cliente_nacional eq '0' ? 'checked="checked"':''}>
											<label class="custom-control-label" for="radioInternacional">Internacional</label>
										</div>
										<div class="row">
											<div class="col-sm-6 col-md-6 mt-2">
												<c:forEach items="${direccion}" var="dir">
													<c:set var="id_domicilio" value="${dir.id_domicilio}"></c:set>
													<c:set var="id_pais" value="${dir.id_pais}"></c:set>
													<c:set var="id_codigo_postal"
														value="${dir.id_codigo_postal}"></c:set>
													<c:set var="id_poblacion" value="${dir.id_poblacion}"></c:set>
													<c:set var="id_estado" value="${dir.id_estado}"></c:set>
													<c:set var="calle" value="${dir.calle}"></c:set>
													<c:set var="numero_int" value="${dir.numero_int}"></c:set>
													<c:set var="numero_ext" value="${dir.numero_ext}"></c:set>
													<c:set var="cp" value="${dir.cp}"></c:set>
													<c:set var="colonia" value="${dir.colonia}"></c:set>
													<c:set var="ciudad" value="${dir.ciudad}"></c:set>
													<c:set var="pais" value="${dir.pais}"></c:set>
													<c:set var="estado" value="${dir.estado}"></c:set>
													<c:set var="delegacion" value="${dir.delegacion}"></c:set>
													<c:set var="apartado_postal" value="${dir.apartado_postal}"></c:set>
												</c:forEach>
												<input type="hidden" name="id_domicilio" id="id_domicilio"
													value="${id_domicilio}"> <input type="hidden"
													name="id_pais" id="id_pais" value="${id_pais}"> <input
													type="hidden" name="id_codigo_postal" id="id_codigo_postal"
													value="${id_codigo_postal}"> <input type="hidden"
													name="id_poblacion" id="id_poblacion"
													value="${id_poblacion}"> <input type="hidden"
													name="id_estado" id="id_estado" value="${id_estado}">
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Calle</label>
													<div class="col-sm-8">
														<input type="text" class="form-control form-control-sm"
															name="calle" value="${calle}" id="dir_calle"
															maxlength="120" />
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Número
														Interior </label>
													<div class="col-sm-8">
														<input type="text" class="form-control form-control-sm"
															name="numero_int" value="${numero_int}" id="dir_num_int"
															maxlength="20" />
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Número
														Exterior </label>
													<div class="col-sm-8">
														<input type="text" class="form-control form-control-sm"
															name="numero_ext" value="${numero_ext}" id="dir_num_ext"
															maxlength="20" />
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Código
														Postal </label>
													<div class="input-group input-group-sm mb-2 col-sm-8">
														<input type="text" class="form-control" name="clave"
															value="${cp}" id="dir_cp">
														<div class="input-group-append">
															<button class="btn btn-sm" type="button"
																id="buscarCodigoPostal">Buscar por Código
																Postal</button>
														</div>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Colonia</label>
													<div class="col-sm-8">
														<input type="text" class="form-control form-control-sm"
															name="colonia" value="${colonia}" id="dir_colonia" />
													</div>
												</div>
											</div>
											<div class="col-sm-6 col-md-6 mt-2">
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Ciudad</label>
													<div class="col-sm-8">
														<input type="text" class="form-control form-control-sm"
															name="ciudad" id="dir_ciudad" value="${ciudad}" />
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">País</label>
													<div class="col-sm-8">
														<select class="form-control form-control-sm"
															name="id_pais" id="dir_pais">
															<option value="">Selecciona una opcion</option>
															<c:forEach items="${listaPaises}" var="lista">
																<option value="${lista.id_pais}"
																	${lista.id_pais eq id_pais ?'selected="selected"':''}>
																	<c:out value="${lista.nombre}"></c:out>
																</option>
															</c:forEach>
														</select>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Apartado
														Postal </label>
													<div class="col-sm-8">
														<input type="text" class="form-control form-control-sm"
															name="apartado" id="dir_apartado" maxlength="12"
															value="${apartado_postal}" />
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Estado</label>
													<div class="col-sm-8">
														<input type="text" class="form-control form-control-sm"
															name="estado" value="${estado}" id="dir_estado" />
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Delegación /
														Municipio</label>
													<div class="col-sm-8">
														<input type="text" class="form-control form-control-sm"
															name="delegacion" value="${delegacion}"
															id="dir_delegacion" />
													</div>
												</div>
											</div>
										</div>
									</div>
									<%-- MENU2 --%>
									<%-- MENU2 --%>
								</div>

								<div class="tab-pane" id="tab3" role="tabpanel"
									aria-labelledby="tab-3">
									<%-- MENU3 --%>
									<%-- MENU3 --%>
									<ul class="nav d-inline-block">
										<li class="nav-item d-inline-block"><a
											class="d-none nav-link text-secondary p-0 mr-3 ml-3  tab-link active"
											id="tab-9" data-toggle="tab" href="#tab9" role="tab"
											aria-controls="tab9" aria-selected="true">Contactos</a></li>
										<li class="nav-item d-inline-block"><a
											class="d-none nav-link text-secondary p-0 mr-3  tab-link"
											id="tab-10" data-toggle="tab" href="#tab10" role="tab"
											aria-controls="tab10" aria-selected="false">Nuevo
												Contacto</a></li>
									</ul>

									<div class="tab-content">
										<div class="tab-pane show active" id="tab9" role="tabpanel"
											aria-labelledby="tab-9">
											<div class="card-body">
												<div class="row">
													<div class="col-sm-6 col-md-6 mt-2">
														<div class="form-group row">
															<label class="col-sm-4 col-form-label">Cliente</label>
															<div class="col-sm-8">
																<input type="text" class="form-control form-control-sm"
																	name="clave_cliente" value="${editar.clave_cliente}"
																	maxlength="20" disabled required />
															</div>
														</div>
														<div class="form-group row">
															<label class="col-sm-4 col-form-label">Telefono
																Principal</label>
															<div class="col-sm-8">
																<input type="text"
																	class="text-right just-number form-control form-control-sm"
																	name="teleprincipal" value="${editar.telefono_pric}" />
																<input type="hidden"
																	class="form-control form-control-sm"
																	name="contactosSplit" id="contactosSplit" />
															</div>
														</div>
													</div>
													<div class="col-sm-6 col-md-6 mt-2">
														<div class="form-group row">
															<label class="col-sm-4 col-form-label">Nombre
																Corto</label>
															<div class="col-sm-8">
																<input type="text" class="form-control form-control-sm"
																	name="nombre_corto" value="${editar.nombre_corto}"
																	maxlength="80" required />
															</div>
														</div>

														<div class="form-group row">
															<label class="col-sm-4 col-form-label"></label>
															<div class="col-sm-8">
																<button type="button" name="cambio10"
																	class="changetab btn btn-secondary text-white btn-sm float-right mb-2 mt-auto">Nuevo
																	Contacto</button>
															</div>
														</div>
													</div>
													<div class="col-md-12 mb-2">

														<div class="card mt-2">
															<div class="table-responsive">
																<table
																	class="table table-scroll table-striped table-bordered table-hover">
																	<thead>
																		<tr>
																			<th>Nombre/Apellido</th>
																			<th>Email</th>
																			<th>Teléfono</th>
																			<th>Envío</th>
																			<th>Puesto</th>
																			<th>Comentarios</th>
																			<th>Editar</th>
																			<th>Eliminar</th>
																		</tr>
																	</thead>
																	<tbody id="tableBody">
																		<c:set var="i" value="${1}" />
																		<c:forEach items="${consultaContactos}" var="lista">
																			<tr id="bd${i}">
																				<td><c:out value="${lista.nombre_contacto}"></c:out></td>
																				<td><c:out value="${lista.email}"></c:out></td>
																				<td><c:out value="${lista.telefono_1}"></c:out></td>
																				<td><c:out
																						value="${lista.b_enviocfd_x_email eq 1 ?'Si':'No'}"></c:out></td>
																				<td><c:out value="${lista.puesto}"></c:out></td>
																				<td><c:out value="${lista.comentarios}"></c:out>
																					<input type="hidden" class="inputBdContacto bd${i}"
																					value="${lista.id_contacto},ACT,update" /></td>
																				<td><button type="button"
																						id="editContact${lista.id_contacto}"
																						class="editarContacto btn btn-secondary text-white btn-sm btn-table editarContacto base${i}">
																						<span class="icon-brush"></span>
																					</button></td>
																				<td><button type="button" id="bd${i}"
																						class="eliminarContact btn btn-secondary text-white btn-sm btn-table">
																						<span class="icon-delete"></span>
																					</button></td>
																				<c:set var="i" value="${i+1}" />
																			</tr>
																		</c:forEach>
																	</tbody>
																</table>
															</div>
														</div>


													</div>


												</div>
											</div>

										</div>
										<div class="tab-pane" id="tab10" role="tabpanel"
											aria-labelledby="tab-10">
											<div class="card-body">
												<div class="row">
													<div class="col-sm-6 col-md-6 mt-2">
														<div class="form-group row">
															<label class="col-sm-4 col-form-label">Cliente</label>
															<div class="col-sm-8">
																<input type="text" class="form-control form-control-sm"
																	name="clave_cliente" value="${editar.clave_cliente}"
																	maxlength="20" disabled required /> <input
																	type="hidden" class="form-control form-control-sm"
																	name="id_contacto" value="0" id="id_contacto" /> <input
																	type="hidden" class="form-control form-control-sm"
																	name="bd" value="" id="bd" /> <input type="hidden"
																	class="form-control form-control-sm" name="banderacon"
																	value="0" id="banderacon" />
															</div>
														</div>

														<div class="form-group row">
															<label class="col-sm-4 col-form-label">Nombre
																Apellido</label>
															<div class="col-sm-8">
																<input type="text"
																	class="cleanInput form-control form-control-sm"
																	name="nom_ape" id="nom_ape" />
															</div>
														</div>

														<div class="form-group row">
															<label class="col-sm-4 col-form-label">Telefono 1</label>
															<div class="col-sm-8">
																<input type="text"
																	class="cleanInput text-right just-number form-control form-control-sm"
																	name="tel1" id="tel1" maxlength="20" />
															</div>
														</div>

														<div class="form-group row">
															<label class="col-sm-4 col-form-label">Telefono 2</label>
															<div class="col-sm-8">
																<input type="text"
																	class="cleanInput text-right just-number form-control form-control-sm"
																	name="tel2" id="tel2" maxlength="20" />
															</div>
														</div>

														<div class="form-group row">
															<label class="col-sm-4 col-form-label">Puesto</label>
															<div class="col-sm-8">
																<input type="text"
																	class="cleanInput form-control form-control-sm"
																	name="puesto" id="puesto" />
															</div>
														</div>

														<div class="form-group row">
															<div class="col-sm-12">
																<div class="custom-control custom-checkbox">
																	<input class="custom-control-input" id=cfdmail
																		name="cfdmail" type="checkbox"> <label
																		class="custom-control-label" for="cfdmail">Enviar
																		CFD por email?</label>
																</div>
															</div>
														</div>

														<div class="form-group row">
															<div class="col-sm-12">
																<div class="custom-control custom-checkbox">
																	<input class="custom-control-input" id="apli"
																		name="apli" type="checkbox"> <label
																		class="custom-control-label" for="apli">Aplica
																		Addenda?</label>
																</div>
															</div>
														</div>







													</div>
													<div class="col-sm-6 col-md-6 mt-2">
														<div class="form-group row">
															<label class="col-sm-4 col-form-label">Nombre
																Corto</label>
															<div class="col-sm-8">
																<input type="text" class="form-control form-control-sm"
																	name="nombre_corto" value="${editar.nombre_corto}"
																	maxlength="80" required />
															</div>
														</div>

														<div class="form-group row">
															<label class="col-sm-4 col-form-label">Ext.</label>
															<div class="col-sm-8">
																<input type="text"
																	class="cleanInput form-control form-control-sm"
																	name="ext" id="ext" />
															</div>
														</div>

														<div class="form-group row">
															<label class="col-sm-4 col-form-label">Fax.</label>
															<div class="col-sm-8">
																<input type="text"
																	class="cleanInput form-control form-control-sm"
																	name="fax" id="fax" />
															</div>
														</div>

														<div class="form-group row">
															<label class="col-sm-4 col-form-label">Email</label>
															<div class="col-sm-8">
																<input type="text"
																	class="cleanInput form-control form-control-sm"
																	name="email" id="email" />
															</div>
														</div>

														<div class="form-group row">
															<div class="col-sm-12">
																<div class="custom-control custom-checkbox">
																	<input class="custom-control-input" id=patronfac
																		name="patronfac" type="checkbox"> <label
																		class="custom-control-label" for="patronfac">Contacto
																		Patron para Factura</label>
																</div>
															</div>
														</div>

														<div class="form-group row mt-4">
															<label class="col-sm-4 col-form-label">Addenda</label>
															<div class="col-sm-8">
																<input type="text"
																	class="cleanInput form-control form-control-sm"
																	name="addenda" id="addenda" />
															</div>
														</div>


													</div>

													<div class="col-sm-8 col-md-8 mt-2">
														<div class="form-group row">
															<label class="ml-3 mr-5 col-form-label">Comentarios</label>

															<textarea cols="60" rows="4" id="comentarios"
																name="comentarios"
																class="cleanInput col-sm-8 ml-5 form-control form-control-sm"></textarea>

														</div>
													</div>
													<div class="destino col-sm-12 col-md-12">
														<div class="card-body llevar">
															<input type="hidden" name="b_cliente_nacional1"
																id="b_cliente_nacional1" value="1">
															<div
																class="custom-control custom-radio custom-control-inline">
																<input type="radio" id="radioNacional1"
																	name="radioDireccion1"
																	class="custom-control-input radioDireccion1"
																	checked="checked"> <label
																	class="custom-control-label" for="radioNacional1">Nacional</label>
															</div>
															<div
																class="custom-control custom-radio custom-control-inline">
																<input type="radio" id="radioInternacional1"
																	name="radioDireccion1"
																	class="custom-control-input radioDireccion1"> <label
																	class="custom-control-label" for="radioInternacional1">Internacional</label>
															</div>
															<div class="row">
																<div class="col-sm-6 col-md-6 mt-2">
																	<input type="hidden" name="id_domicilio"
																		id="id_domicilio" value=""> <input
																		type="hidden" name="id_pais" id="id_pais" value="">
																	<input type="hidden" name="id_codigo_postal"
																		id="id_codigo_postal" value=""> <input
																		type="hidden" name="id_poblacion" id="id_poblacion"
																		value=""> <input type="hidden"
																		name="id_estado" id="id_estado" value="">
																	<div class="form-group row">
																		<label class="col-sm-4 col-form-label">Calle</label>
																		<div class="col-sm-8">
																			<input type="text"
																				class="cleanInput form-control form-control-sm"
																				name="calle" value="" id="dir_calle1"
																				maxlength="120" />
																		</div>
																	</div>
																	<div class="form-group row">
																		<label class="col-sm-4 col-form-label">Número
																			Interior </label>
																		<div class="col-sm-8">
																			<input type="text"
																				class="cleanInput form-control form-control-sm"
																				name="numero_int" value="" id="dir_num_int1"
																				maxlength="20" />
																		</div>
																	</div>
																	<div class="form-group row">
																		<label class="col-sm-4 col-form-label">Número
																			Exterior </label>
																		<div class="col-sm-8">
																			<input type="text"
																				class="cleanInput form-control form-control-sm"
																				name="numero_ext" value="" id="dir_num_ext1"
																				maxlength="20" />
																		</div>
																	</div>
																	<div class="form-group row">
																		<label class="col-sm-4 col-form-label">Código
																			Postal </label>
																		<div class="input-group input-group-sm mb-2 col-sm-8">
																			<input type="text"
																				class="cleanInput form-control text-right"
																				name="clave" value="" id="dir_cp1" maxlength="5">
																			<div class="input-group-append">
																				<button class="btn btn-sm buscarCodigo"
																					type="button" id="buscarCodigoPostal1">Buscar
																					por Código Postal</button>
																			</div>
																		</div>
																	</div>
																	<div class="form-group row">
																		<label class="col-sm-4 col-form-label">Colonia</label>
																		<div class="col-sm-8">
																			<select
																				class="form-control form-control-sm changedatos"
																				name="colonia" id="dir_colonia11">
																				<option value="">Selecciona una opcion</option>
																				<option value="nueva">Nueva Colonia</option>
																			</select>
																		</div>
																	</div>
																	<div class="form-group row nuevacolonia d-none">
																		<label class="col-sm-4 col-form-label">Nueva
																			Colonia</label>
																		<div class="col-sm-8">
																			<input type="text"
																				class="cleanInput nuevacolonia d-none form-control form-control-sm"
																				name="colonia" value="" id="dir_colonia1" />
																		</div>
																	</div>
																</div>
																<div class="col-sm-6 col-md-6 mt-2">
																	<div class="form-group row">
																		<label class="col-sm-4 col-form-label">Ciudad</label>
																		<div class="col-sm-8">
																			<input type="text"
																				class="cleanInput form-control form-control-sm"
																				name="ciudad" id="dir_ciudad1" value="" />
																		</div>
																	</div>
																	<div class="form-group row">
																		<label class="col-sm-4 col-form-label">País</label>
																		<div class="col-sm-8">
																			<select class="form-control form-control-sm"
																				name="id_pais" id="dir_pais1">
																				<option value="">Selecciona una opcion</option>
																				<c:forEach items="${listaPaises}" var="lista">
																					<option value="${lista.id_pais}">
																						<c:out value="${lista.nombre}"></c:out>
																					</option>
																				</c:forEach>
																			</select>
																		</div>
																	</div>
																	<div class="form-group row">
																		<label class="col-sm-4 col-form-label">Apartado
																			Postal </label>
																		<div class="col-sm-8">
																			<input type="text"
																				class="cleanInput form-control form-control-sm"
																				name="apartado" id="dir_apartado1" maxlength="12" />
																		</div>
																	</div>
																	<div class="form-group row">
																		<label class="col-sm-4 col-form-label">Estado</label>
																		<div class="col-sm-8">
																			<select class="form-control form-control-sm"
																				name="estado" id="dir_estado1">
																				<option value="">Selecciona una opcion</option>
																				<c:forEach items="${listaEstados}" var="lista">
																					<option value="${lista.id_estado}">
																						<c:out value="${lista.nombre}"></c:out>
																					</option>
																				</c:forEach>
																			</select>
																		</div>
																	</div>
																	<div class="form-group row">
																		<label class="col-sm-4 col-form-label">Delegación
																			/ Municipio</label>
																		<div class="col-sm-8">
																			<select
																				class="form-control form-control-sm changedatos"
																				name="delegacion" id="dir_delegacion11">
																				<option value="">Selecciona una opcion</option>
																				<option value="nueva">Nueva Delegacion</option>
																			</select>
																		</div>
																	</div>
																	<div class="form-group row nuevadelegacion d-none">
																		<label class="col-sm-4 col-form-label">Nueva
																			Delegación / Municipio</label>
																		<div class="col-sm-8">
																			<input type="text"
																				class="cleanInput nuevadelegacion d-none form-control form-control-sm"
																				name="delegacion" id="dir_delegacion1" />
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</div>

													<div class="col-sm-6 col-md-6"></div>
													<div class="col-sm-6 col-md-6">
														<div class="form-group row">
															<label class="col-sm-4 col-form-label"></label>
															<div class="col-sm-8">
																<button type="button"
																	class="btn btn-secondary text-white btn-sm float-right mb-2 mt-auto"
																	id="addContact">Agregar Contacto</button>
																<button type="button" name="cambio9"
																	id="regresarContact"
																	class="changetab mr-4 btn btn-secondary text-white btn-sm float-right mb-2 mt-auto">
																	Regresar</button>
															</div>
														</div>
													</div>
												</div>
											</div>

										</div>
									</div>
									<%-- MENU3 --%>
									<%-- MENU3 --%>
								</div>
								<div class="tab-pane origen" id="tab4" role="tabpanel"
									aria-labelledby="tab-4">
									<%-- MENU4 --%>
									<%-- MENU4 --%>
									<div class="card-body">
										<div class="row">
											<div class="col-sm-6 col-md-6 mt-2">
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Cliente</label>
													<div class="col-sm-8">
														<input type="text" class="form-control form-control-sm"
															name="clave_cliente" value="${editar.clave_cliente}"
															maxlength="20" disabled required />
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Agrupador</label>
													<div class="col-sm-8">
														<input type="text" id="list_Clientes"
															class="form-control form-control-sm ajax-form"
															placeholder="Busca un cliente" name="list_Clientes" />
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Clave
														Externa</label>
													<div class="col-sm-8">
														<input type="text" class="form-control form-control-sm"
															name="claveext" id="claveext" />
													</div>
												</div>
												<div class="form-group row">
													<div class="col-sm-12">
														<div class="custom-control custom-checkbox">
															<input class="custom-control-input" id=adquirente
																name="adquirente" type="checkbox"> <label
																class="custom-control-label" for="adquirente">Es
																Adquirente</label>
														</div>
													</div>
												</div>

											</div>
											<div class="col-sm-6 col-md-6 mt-2">
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Nombre Corto</label>
													<div class="col-sm-8">
														<input type="text" class="form-control form-control-sm"
															name="nombre_corto" value="${editar.nombre_corto}"
															maxlength="80" required />
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Descripcion</label>
													<div class="col-sm-8">
														<select class="form-control form-control-sm d-none "
															id="list_Clientes_r" name="id_cliente">
														</select> <select class="form-control form-control-sm "
															id="listaDeClientes" name="id_cliente">
															<option value="">Selecciona una opcion</option>
															<c:forEach items="${listaClientes}" var="lista">
																<option
																	value="<c:out value="${lista.id_cliente}"> </c:out>"
																	${ lista.id_cliente==editar.id_cliente ? 'selected="selected"' : ''}>
																	<c:out value="${lista.clave_cliente}"></c:out> -
																	<c:out value="${lista.nombre_corto}"></c:out></option>
															</c:forEach>
														</select>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label"></label>
													<div class="col-sm-8">
														<div
															class="custom-control custom-radio custom-control-inline">
															<input type="radio" id="entrada"
																name="radioentradasalida"
																class="custom-control-input radioentradasalida"
																checked="checked"> <label
																class="custom-control-label" for="entrada">Entrada</label>
														</div>
														<div
															class="custom-control custom-radio custom-control-inline">
															<input type="radio" id="salida" name="radioentradasalida"
																class="custom-control-input radioentradasalida">
															<label class="custom-control-label" for="salida">Salida</label>
														</div>
													</div>
												</div>
												<div class="form-group row">
													<label class="form-fuente col-sm-4 col-form-label">Fuente</label>
													<label class="form-sistema d-none col-sm-4 col-form-label">Sistema</label>
													<div class="col-sm-8">
														<select class="form-fuente form-control form-control-sm "
															id="fuenteentrada" name="fuenteentrada">
															<option value="">Selecciona una opcion</option>
															<c:forEach items="${listaFuentes}" var="lista">
																<option
																	value="<c:out value="${lista.id_fuente}"> </c:out>">
																	<c:out value="${lista.clave}"></c:out> -
																	<c:out value="${lista.descripcion}"></c:out></option>
															</c:forEach>
														</select> <select
															class="form-sistema d-none form-control form-control-sm "
															id="sistema" name="sistema">
															<option value="">Selecciona una opcion</option>
															<option value="ORA">ORACLE GL</option>
															<option value="SAC">SAC</option>
															<option value="LIB">LIBRA</option>
														</select>
													</div>
												</div>
												<div class="form-group row">
															<label class="col-sm-4 col-form-label"></label>
															<div class="col-sm-8">
																<button type="button"
																	class="agregareliminar btn btn-secondary text-white btn-sm float-right mb-2 mt-auto"
																	id="add">Agregar</button>
															</div>
														</div>


											</div>


											<div class="col-sm-12 mt-2">
												<div class="table-responsive">
													<table
														class="table table-scroll table-striped table-bordered table-hover">
														<thead>
															<tr>
																<th>Clave Externa</th>
																<th>Entrada</th>
																<th>Salida</th>
																<th>Adquirente</th>
																<th>Agrupador</th>
																<th>Eliminar</th>
															</tr>
														</thead>
														<tbody id="tableBodyClaves">
															<c:set var="i" value="${1}" />
															<c:forEach items="${consultaClavesCliente}" var="lista">
																<tr id="clave${i}">
																	<td><c:out value="${lista.clave_externa}"></c:out></td>
																	<td><c:out value="${lista.id_fuente}"></c:out> - <c:out
																			value="${lista.clave}"></c:out></td>
																	<td><c:out value="${lista.clave_sistema_salida}"></c:out></td>
																	<td><c:out
																			value="${lista.b_adquirente eq 1 ?'Si':'No'}"></c:out></td>
																	<td><c:out value="${lista.id_agrupador}"></c:out> - <c:out
																			value="${lista.clave_cliente}"></c:out></td>
																	<td><button type="button" id="clave${i}"
																			class="agregareliminar btn btn-secondary text-white btn-sm btn-table">
																			<span class="icon-delete"></span>
																		</button></td>
																	<c:set var="i" value="${i+1}" />
																</tr>
															</c:forEach>
														</tbody>
													</table>
												</div>
												
													
														<!-- 						VARIABLES OBTENIDAS MEDIANTE JS -->



														<input type="hidden" name="registros_totales"
															id="registros_totales" class="registros_totales"
															value="${registros_totales_claves}">
														<input type="hidden" name="fromRow" id="fromRow"
															class="fromRow" value="0">

														<nav>
															<ul class="pagination  pagination-sm justify-content-end">
																<button type="button" id="prev" class='btn-pag btn btn-light border'><span
																	class="icon-arrow_back"></span></button>
																
																<button type="button" id="next" class='btn-pag btn btn-light border'><span
																	class="icon-arrow_forward"></span></button>
															</ul>
														</nav>
														
													
												

											</div>



										</div>
									</div>
									<%-- MENU4 --%>
									<%-- MENU4 --%>
								</div>
								<div class="tab-pane " id="tab8" role="tabpanel"
									aria-labelledby="tab-8">
									<%-- MENU8 --%>
									<%-- MENU8 --%>
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
																	<td><fmt:formatDate type="both"
																			value="${consulta.fecha_mod}"
																			pattern="dd/MM/yyyy kk:mm:ss" /></td>
																	<td><c:out value="${consulta.usuario}"></c:out></td>
																	<td><c:out value="${consulta.comentarios}"></c:out></td>
																</tr>
															</c:forEach>
														</tbody>
													</table>
												</div>
											</div>
										</c:if>
										<c:if test="${empty consultaHistorico}">
											<p class="text-center mt-4">No hay información que
												mostrar en esta sección.</p>
										</c:if>
									</div>
									<%-- MENU8 --%>
									<%-- MENU8 --%>
								</div>
								<div class="col-md-12">
									<button type="button"
										class="button-script btn btn-secondary text-white btn-sm float-right mb-2 mt-auto">Guardar</button>
									<button type="submit" id="save"
										class="d-none btn btn-secondary text-white btn-sm float-right mb-2 mt-auto">Guardar</button>
								</div>
							</div>
						</sf:form>
					</c:forEach>
				</c:if>
				<%-- VISTA EDITAR --%>
				<%-- VISTA EDITAR --%>
				<%-- VISTA EDITAR --%>
				<%-- VISTA NUEVO --%>
				<%-- VISTA NUEVO --%>
				<%-- VISTA NUEVO --%>
				<%-- VISTA NUEVO --%>
				<%-- VISTA NUEVO --%>
				<%-- VISTA NUEVO --%>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript"
	src='<c:url value="/js/appCliente/Cliente.js"/>' defer="defer"></script>
<%@ include file="../../layout/footer.jsp"%>