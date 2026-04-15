<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<%-- etiquetas unicas --%>
	<%-- DELETE --%>
	<input type="hidden" id="path"
		value="${pageContext.request.contextPath}" />
	<c:if test="${event=='delete'}">
		<sf:form
			action="${pageContext.request.contextPath}/home/registro/parametrizar/save"
			method="POST">
			<c:forEach items="${consulta}" var="consulta">
				<input name="evento" type="hidden" value="delete" />
				<input name="clavePoliza" type="hidden" value="${consulta.clave}" />
				<div class="row">
					<div class="col-sm-12">
						<div class="card mt-1">
							<div class="card-header">
								<span class="title" id="menu-toggle">Eliminar</span> <a
									class="float-right text-secondary"
									href="<c:url value='/home/registro/parametrizar'/>"
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
											href="<c:url value='/home/registro/parametrizar'/>"
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
			action="${pageContext.request.contextPath}/home/registro/parametrizar/save"
			method="POST">
			<c:forEach items="${consulta}" var="consulta">
				<input name="evento" type="hidden" value="update" />
				<input name="clavePoliza" type="hidden" value="${consulta.clave}" />
				<input name="tipopoli" type="hidden" value="${consulta.tipo}" />
				<input name="descripcionPoli" type="hidden"
					value="${consulta.descripcion}" />
				<input name="id_poliza" type="hidden"
					value="${consulta.id_modelo_poliza}" />
				<div class="row">
					<div class="col-sm-12">
						<div class="card mt-1">
							<div class="card-header">
								<span class="title" id="menu-toggle">Editando a <c:out
										value="${consulta.clave}"></c:out></span>
								<%-- menus --%>
								<%-- menus --%>
								<%-- menus --%>
								<ul class="nav d-inline-block">
									<li class="nav-item d-inline-block"><a
										class="nav-link text-secondary p-0 mr-3 ml-5  tab-link active"
										id="tab-1" data-toggle="tab" href="#tab1" role="tab"
										aria-controls="tab1" aria-selected="true">Datos Polizas
											Contables</a></li>
									<li class="nav-item d-inline-block"><a
										class="nav-link text-secondary p-0 mr-3  tab-link" id="tab-2"
										data-toggle="tab" href="#tab2" role="tab" aria-controls="tab2"
										aria-selected="false">Agregar Registro</a></li>

								</ul>
								<%-- menus --%>
								<%-- menus --%>
								<%-- menus --%>
								<a class="float-right text-secondary"
									href="<c:url value='/home/registro/parametrizar'/>"
									role="button">Regresar</a><span
									class="float-right text-secondary mr-3" id="btn-ocultar">Ocultar</span>
							</div>
							<div class="tab-content" id="mainMenu">
								<div class="tab-pane  show active" id="tab1" role="tabpanel"
									aria-labelledby="tab-1">
									<%-- menu 1--%>
									<%-- menu 1--%>
									<%-- menu 1--%>
									<div class="card-body">
										<div class="row">
											<div class="col-sm-6 col-md-6 mt-2">
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Clave de
														Poliza</label>
													<div class="col-sm-8">
														<label class="col-form-label">${consulta.clave}</label>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Tipo de
														Poliza</label>
													<div class="col-sm-8">
														<label class="col-form-label">${consulta.tipo}</label>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Fecha de
														Modificacion</label>
													<div class="col-sm-8">
														<label class="col-form-label">${consulta.fecha_mod}</label>
													</div>
												</div>
											</div>
											<div class="col-sm-6 col-md-6 mt-2">
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Descripcion
														de Poliza </label>
													<div class="col-sm-8">
														<label class="col-form-label">${consulta.descripcion}</label>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Fecha de
														Creacion</label>
													<div class="col-sm-8">
														<label class="col-form-label">${consulta.fecha_cre}</label>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Autor ultima
														Modificacion</label>
													<div class="col-sm-8">
														<label class="col-form-label">${consulta.usuario}</label>
													</div>
												</div>

											</div>
										</div>
									</div>

									<%-- menu 1--%>
									<%-- menu 1--%>
									<%-- menu 1--%>
								</div>
								<div class="tab-pane" id="tab2" role="tabpanel"
									aria-labelledby="tab-2">
									<%-- menu 2 --%>
									<%-- menu 2 --%>
									<%-- menu 2 --%>
									<div class="card-body">
										<div class="row">


											<div class="col-sm-6 col-md-6 mt-2">
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Tipo de
														Movimiento</label>
													<div class="col-sm-8">
														<select class="form-control form-control-sm" name="tipo"
															id="tipo">
															<option value="" selected="selected">selecciona
																una opcion</option>
															<option value="CARGO,C" class="texto">Cuenta de
																Cargo</option>
															<option value="ABONO,A" class="texto">Cuenta de
																Abono</option>
														</select>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Importe</label>
													<div class="col-sm-8">
														<input type="text" id="list_Importes"
															class="form-control form-control-sm ajax-form-registro"
															placeholder="Busca un importe" name="list_Importes" />
													</div>
												</div>
												<div class=" form-group row">
													<label class="col-sm-4 col-form-label">Clientes</label>
													<div class="col-sm-8">
														<input type="text" id="list_Clientes"
															class="form-control form-control-sm ajax-form"
															placeholder="Busca un cliente" name="list_Clientes" />
													</div>
												</div>
												<div class=" form-group row">
													<label class="col-sm-4 col-form-label">Negocio</label>
													<div class="col-sm-8">
														<input type="text" id="list_Negocios"
															class="form-control form-control-sm ajax-form-registro"
															placeholder="Busca un negocio" name="list_Negocios" />
													</div>
												</div>

												<div class="form-libre form-group row">
													<label class="col-sm-4 col-form-label">Cuentas
														Contables</label>
													<div class="col-sm-8">
														<input type="text" id="list_Cuentas"
															class="form-control form-control-sm ajax-form-registro"
															placeholder="Busca una Cuenta Contable"
															name="list_Cuentas" />
													</div>
												</div>
												<div class="form-libre form-group row">
													<label class="col-sm-4 col-form-label">Empresa</label>
													<div class="col-sm-8">
														<select
															class="required-libre form-control form-control-sm "
															id="empresa" name="empresa" id="empresa">
															<option value="">Selecciona una opcion</option>
															<c:forEach items="${listaEmpresas}" var="lista">
																<option
																	value="<c:out value="${lista.razon_social}||${lista.id_empresa}"> </c:out>">
																	<c:out value="${lista.clave_empresa}"></c:out></option>
															</c:forEach>
														</select>
													</div>
												</div>

												<div class="form-libre form-group row">
													<label class="col-sm-4 col-form-label">Centro de
														Costos</label>
													<div class="col-sm-8">
														<input type="text" id="list_Centro"
															class="form-control form-control-sm ajax-form"
															placeholder="Busca un Centro de Costos"
															name="list_Centro" />
													</div>
												</div>
												<div class="form-libre form-group row">
													<label class="required-libre col-sm-4 col-form-label">Proyecto</label>
													<div class="col-sm-8">
														<select class="form-control form-control-sm"
															name="proyecto" id="proyecto">
															<option value="" selected="selected">selecciona
																una opcion</option>
															<option value="00000" class="texto">00000</option>
															<option value="N_ODT" class="texto">Numero de
																ODT</option>



														</select>
													</div>
												</div>
												<div class="form-libre form-group row">
													<label class="col-sm-4 col-form-label">Futuro</label>
													<div class="col-sm-8">
														<input type="text"
															class="required-libre form-control form-control-sm"
															name="temporal" id="temporal" maxlength="3" />
													</div>
												</div>

											</div>
											<div class="col-sm-6 col-md-6 mt-2">
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Descripcion</label>
													<div class="col-sm-8">
														<input type="text" class="form-control form-control-sm"
															name="descripcion" id="descripcion" />
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Descripcion
														Importe</label>
													<div class="col-sm-8">
														<select class="form-control form-control-sm d-none "
															id="list_Importes_r" name="id_importe">
														</select> <select class="form-control form-control-sm "
															id="listaDeImportes" name="id_importe">
															<option value="">Selecciona una opcion</option>
															<c:forEach items="${listaImportes}" var="lista">
																<option
																	value="<c:out value="${lista.id_importe}"> </c:out>">
																	<c:out value="${lista.id_importe}"></c:out> -
																	<c:out value="${lista.descripcion}"></c:out></option>
															</c:forEach>
														</select>
													</div>
												</div>
												<div class=" form-group row">
													<label class="col-sm-4 col-form-label">Descripcion
														Clientes</label>
													<div class="col-sm-8">
														<select class="form-control form-control-sm d-none "
															id="list_Clientes_r" name="id_cliente">
														</select> <select class="form-control form-control-sm "
															id="listaDeClientes" name="id_cliente">
															<option value="">Selecciona una opcion</option>
															<c:forEach items="${listaClientes}" var="lista">
																<option
																	value="<c:out value="${lista.id_cliente}"> </c:out>"
																	${ lista.id_cliente==cliente ? 'selected="selected"' : ''}>
																	<c:out value="${lista.clave_cliente}"></c:out> -
																	<c:out value="${lista.nombre_corto}"></c:out></option>
															</c:forEach>
														</select>
													</div>
												</div>
												<div class=" form-group row">
													<label class="col-sm-4 col-form-label">Descripcion
														Negocio</label>
													<div class="col-sm-8">
														<select
															class="tab1neg1 form-control form-control-sm d-none "
															id="list_Negocios_r" name="id_negocio">
														</select> <select class="tab1neg form-control form-control-sm "
															id="listaDeNegocios" name="id_negocio">
															<option value="">Selecciona una opcion</option>
															<c:forEach items="${listaNegocios}" var="lista">
																<option
																	value="<c:out value=" ${lista.id_negocio} "> </c:out>"
																	${ lista.id_negocio==negocio ? 'selected="selected"' : ''}>
																	<c:out value="${lista.clave}"></c:out>
																	<c:out value=" - "></c:out>
																	<c:out value="${lista.descripcion}"></c:out>
																</option>
															</c:forEach>
														</select>
													</div>
												</div>

												<div class="form-libre form-group row">
													<label class="col-sm-4 col-form-label">Descripcion
														Cuentas</label>
													<div class="col-sm-8">
														<select class="form-control form-control-sm d-none "
															id="list_Cuentas_r" name="id_cuenta">
														</select> <select class="form-control form-control-sm "
															id="listaDeCuentas" name="id_cuenta">
															<option value="">Selecciona una opcion</option>
															<c:forEach items="${listaCuentasContables}" var="lista">
																<option
																	value="<c:out value="${lista.id_tipo_cuenta}"> </c:out>"
																	${ lista.id_tipo_cuenta==cuenta ? 'selected="selected"' : ''}>
																	<c:out value="${lista.clave}"></c:out> -
																	<c:out value="${lista.descripcion}"></c:out></option>
															</c:forEach>
														</select>
													</div>
												</div>
												<div class="form-libre form-group row">
													<label class="col-sm-4 col-form-label">InterCompañia</label>
													<div class="col-sm-8">
														<select
															class="required-libre form-control form-control-sm"
															name="centroCostos" id="centroCostos">
															<option value="" selected="selected">selecciona
																una opcion</option>
															<option value="FIJO" class="texto">Valor Fijo</option>
															<option value="0000" class="texto">0000</option>
															<option value="SERV" class="texto">C.C. Servicio</option>
															<option value="NEGC" class="texto">C.C. Negocio</option>
														</select>
													</div>
												</div>
												<div class="form-libre form-group row">
													<label class="col-sm-4 col-form-label">Descripcion
														Costos</label>
													<div class="col-sm-8">
														<select class="form-control form-control-sm d-none "
															id="list_Centro_r" name="id_centro">
														</select> <select class="form-control form-control-sm "
															id="listaDeCentro" name="id_centro">
															<option value="">Selecciona una opcion</option>
															<c:forEach items="${listaCentroCosto}" var="lista">
																<option
																	value="<c:out value="${lista.id_centro_costos}"> </c:out>"
																	${ lista.id_centro_costos==centro_costos ? 'selected="selected"' : ''}>
																	<c:out value="${lista.clave_centro_costos}"></c:out>
																	<c:out value=" - "></c:out>
																	<c:out value="${lista.descripcion}"></c:out></option>
															</c:forEach>
														</select>
													</div>

												</div>
												<div class="form-libre form-group row">
													<label class="col-sm-4 col-form-label">Producto</label>
													<div class="col-sm-8">
														<select
															class="required-libre form-control form-control-sm"
															name="producto" id="producto">
															<option value="" selected="selected">selecciona
																una opcion</option>
															<option value="00000" class="texto">00000</option>
															<option value="C_SER" class="texto">Clave de
																Servicio</option>


														</select>
													</div>
												</div>

												<div class="form-group row">
													<div class="form-group col-md-12 d-flex flex-row-reverse ">
														<input type="hidden" id="clave_r" name="clave" />
														<button id="addModelo" type="button"
															class="btn btn-secondary text-white btn-sm float-right ml-3  mb-1 mt-auto">Agregar
															Modelo</button>
														<button id="compro" type="submit"
															class="btn btn-secondary text-white btn-sm float-right d-none ml-3  mb-1 mt-auto"></button>
														<button id="llenarMandar" type="button"
															class="btn btn-secondary text-white btn-sm float-right d-none ml-3  mb-1 mt-auto"></button>
														<button id="Mandar" type="submit"
															class="btn btn-secondary text-white btn-sm float-right d-none ml-3  mb-1 mt-auto"></button>
														<input type="hidden" id="checkval" name="checkval" />
													</div>
												</div>

											</div>

										</div>
									</div>
									<%-- menu 2 --%>
									<%-- menu 2 --%>
									<%-- menu 2 --%>
								</div>

							</div>
							<%-- submit --%>
							<%-- submit --%>
							<div class="col-md-12 mb-2">

								<div class="card mt-2">
									<div class="table-responsive">
										<table
											class="table table-scroll table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th>Numero</th>
													<th>Empresa</th>
													<th>Cuenta Contable</th>
													<th>Centro de Costos</th>
													<th>Tipo de Movimiento</th>
													<th>Proyecto</th>
													<th>Producto</th>
													<th>Futuro</th>
													<th>Descripcion</th>
													<th>Importe</th>
												</tr>
											</thead>
											<tbody id="tableBody">
												<c:forEach items="${consultaEdit}" var="lista">
													<tr>
														<td><c:out value="${lista.numero}"></c:out></td>
														<td><c:out value="${lista.razon_social}"></c:out></td>
														<td><c:out value="${lista.id_tipo_cuenta_contable}"></c:out></td>
														<td><c:out value="${lista.id_centro_costos}"></c:out></td>
														<td id="tabletipo">${ lista.tipo_movimiento eq 'C' ? 'CARGO' : 'ABONO'}</td>
														<td><c:out value="${lista.proyecto}"></c:out></td>
														<td><c:out value="${lista.producto}"></c:out></td>
														<td><c:out value="${lista.temporal}"></c:out></td>
														<td><c:out value="${lista.descripcion}"></c:out></td>
														<td><c:out value="${lista.tipo_importe}"></c:out></td>
													</tr>
												</c:forEach>


											</tbody>
										</table>
									</div>
								</div>


							</div>

							<div class="col-md-12">
								<button id="llenarMandar" type="button"
									class="btn btn-secondary text-white btn-sm float-right ml-3  mb-1 mt-auto">Actualizar</button>
								<input type="hidden" id="checkval" name="checkval" />
								<button id="Mandar" type="submit"
									class="btn btn-secondary text-white btn-sm float-right ml-3  mb-1 mt-auto"></button>
							</div>
							<%-- submit --%>
							<%-- submit --%>
						</div>
					</div>
				</div>
			</c:forEach>
		</sf:form>
	</c:if>
	<%-- EDIT --%>
	<%-- NEW --%>
	<c:if test="${event=='new'}">
		<sf:form
			action="${pageContext.request.contextPath}/home/registro/parametrizar/save"
			method="POST">
			<input name="evento" type="hidden" value="insert" />
			<div class="row">
				<div class="col-sm-12">
					<div class="card mt-1">
						<div class="card-header">
							<span class="title" id="menu-toggle">Nueva Poliza Contable</span>
							<%-- menus --%>
							<%-- menus --%>
							<%-- menus --%>
							<ul class="nav d-inline-block">
								<li class="nav-item d-inline-block"><a
									class="nav-link text-secondary p-0 mr-3 ml-5  tab-link active"
									id="tab-1" data-toggle="tab" href="#tab1" role="tab"
									aria-controls="tab1" aria-selected="true">Datos de Poliza</a></li>
								<li class="nav-item d-inline-block"><a
									class="nav-link text-secondary p-0 mr-3  tab-link" id="tab-2"
									data-toggle="tab" href="#tab2" role="tab" aria-controls="tab2"
									aria-selected="false">Agregar Registro</a></li>
							</ul>
							<%-- menus --%>
							<%-- menus --%>
							<%-- menus --%>
							<a class="float-right text-secondary"
								href="<c:url value='/home/registro/parametrizar'/>"
								role="button">Regresar</a><span
								class="float-right text-secondary mr-3" id="btn-ocultar">Ocultar</span>
						</div>
						<div class="tab-content" id="mainMenu">
							<div class="tab-pane  show active" id="tab1" role="tabpanel"
								aria-labelledby="tab-1">
								<%-- menu 1--%>
								<%-- menu 1--%>
								<%-- menu 1--%>
								<div class="card-body">
									<div class="row">
										<div class="col-sm-6 col-md-6 mt-2">
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Clave de
													Poliza</label>
												<div class="col-sm-8">
													<input type="text" class="form-control form-control-sm"
														name="clavePoliza" id="clavePoliza" />
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Tipo de
													Poliza</label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm"
														name="tipopoli" id="tipopoli">
														<option value="" selected="selected">selecciona
															una opcion</option>
														<option value="COB">Cobro</option>
														<option value="PAG">Pago</option>
														<option value="UTL">Diferencia de Pagos
															(utilidad)</option>
														<option value="PER">Diferencia de Pagos (Perdida)</option>



													</select>
												</div>
											</div>
										</div>
										<div class="col-sm-6 col-md-6 mt-2">
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Descripcion
													de Poliza </label>
												<div class="col-sm-8">
													<input type="text" class="form-control form-control-sm"
														name="descripcionPoli" />
												</div>
											</div>
										</div>
									</div>
								</div>

								<%-- menu 1--%>
								<%-- menu 1--%>
								<%-- menu 1--%>
							</div>
							<div class="tab-pane" id="tab2" role="tabpanel"
								aria-labelledby="tab-2">
								<%-- menu 2 --%>
								<%-- menu 2 --%>
								<%-- menu 2 --%>
								<div class="card-body">
									<div class="row">
										<div class="col-sm-11 col-md-11 mt-2 ml-2">
											<div
												class="custom-control custom-radio custom-control-inline">
												<input type="radio" id="radioNegocio" name="radioOpcion"
													class="custom-control-input radioOpcion" checked="checked">
												<label class="custom-control-label" for="radioNegocio">Cliente
													y Negocio</label>
											</div>
											<div
												class="custom-control custom-radio custom-control-inline">
												<input type="radio" id="radioLibre" name="radioOpcion"
													class="custom-control-input radioOpcion"> <label
													class="custom-control-label" for="radioLibre">Distribucion
													Libre</label>
											</div>
										</div>

										<div class="col-sm-6 col-md-6 mt-2">
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Tipo de
													Movimiento</label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm" name="tipo"
														id="tipo">
														<option value="" selected="selected">selecciona
															una opcion</option>
														<option value="CARGO" class="texto">Cuenta de
															Cargo</option>
														<option value="ABONO" class="texto">Cuenta de
															Abono</option>
													</select>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Importe</label>
												<div class="col-sm-8">
													<input type="text" id="list_Importes"
														class="form-control form-control-sm ajax-form-registro"
														placeholder="Busca un importe" name="list_Importes" />
												</div>
											</div>
											<div class="form-negocio form-group row">
												<label class="col-sm-4 col-form-label">Clientes</label>
												<div class="col-sm-8">
													<input type="text" id="list_Clientes"
														class="form-control form-control-sm ajax-form"
														placeholder="Busca un cliente" name="list_Clientes" />
												</div>
											</div>
											<div class="form-negocio form-group row">
												<label class="col-sm-4 col-form-label">Negocio</label>
												<div class="col-sm-8">
													<input type="text" id="list_Negocios"
														class="form-control form-control-sm ajax-form"
														placeholder="Busca un negocio" name="list_Negocios" />
												</div>
											</div>

											<div class="form-libre d-none form-group row">
												<label class="col-sm-4 col-form-label">Cuentas
													Contables</label>
												<div class="col-sm-8">
													<input type="text" id="list_Cuentas"
														class="form-control form-control-sm ajax-form-registro"
														placeholder="Busca una Cuenta Contable"
														name="list_Cuentas" />
												</div>
											</div>

											<div class="form-libre d-none form-group row">
												<label class="col-sm-4 col-form-label">Compañia</label>
												<div class="col-sm-8">
													<input type="text" id="list_Empresas"
														class="form-control form-control-sm ajax-form-registro"
														placeholder="Busca una Compañia" name="list_Empresas" />
												</div>
											</div>

											<div class="form-libre d-none form-group row">
												<label class="col-sm-4 col-form-label">InterCompañia</label>
												<div class="col-sm-8">
													<input type="text" id="list_Inter"
														class="form-control form-control-sm ajax-form-registro"
														placeholder="Busca una Inter Compañia" name="list_Inter" />
												</div>
											</div>


											<div class="form-libre d-none form-group row">
												<label class="col-sm-4 col-form-label">Centro de
													Costos</label>
												<div class="col-sm-8">
													<input type="text" id="list_Centro"
														class="form-control form-control-sm ajax-form-registro"
														placeholder="Busca un Centro de Costos" name="list_Centro" />
												</div>
											</div>

											<div class="form-libre d-none form-group row">
												<label class="col-sm-4 col-form-label">Proyecto</label>
												<div class="col-sm-8">
													<input type="text" id="list_Proyectos"
														class="form-control form-control-sm ajax-form-registro"
														placeholder="Busca un Proyecto" name="list_Proyectos" />
												</div>
											</div>
											
											
											<div class="form-libre d-none form-group row">
												<label class="col-sm-4 col-form-label">Producto</label>
												<div class="col-sm-8">
													<input type="text" id="list_Productos"
														class="form-control form-control-sm ajax-form-registro"
														placeholder="Busca un Producto" name="list_Productos" />
												</div>
											</div>
											
											<div class="form-libre d-none form-group row">
												<label class="col-sm-4 col-form-label">Futuro</label>
												<div class="col-sm-8">
													<input type="text" id="list_Futuro"
														class="form-control form-control-sm ajax-form-registro"
														placeholder="Busca un Futuro" name="list_Futuro" />
												</div>
											</div>
										</div>
										<div class="col-sm-6 col-md-6 mt-2">
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Descripcion</label>
												<div class="col-sm-8">
													<input type="text" class="form-control form-control-sm"
														name="descripcion" id="descripcion" />
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Descripcion
													Importe</label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm d-none "
														id="list_Importes_r" name="id_importe">
													</select> <select class="form-control form-control-sm "
														id="listaDeImportes" name="id_importe">
														<option value="">Selecciona una opcion</option>
														<c:forEach items="${listaImportes}" var="lista">
															<option
																value="<c:out value="${lista.id_importe} - ${lista.descripcion}"> </c:out>">
																<c:out value="${lista.id_importe}"></c:out> -
																<c:out value="${lista.descripcion}"></c:out></option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-negocio form-group row">
												<label class="col-sm-4 col-form-label">Descripcion
													Clientes</label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm d-none "
														id="list_Clientes_r" name="id_cliente">
													</select> <select class="form-control form-control-sm "
														id="listaDeClientes" name="id_cliente">
														<option value="">Selecciona una opcion</option>
														<c:forEach items="${listaClientes}" var="lista">
															<option
																value="<c:out value="${lista.id_cliente}"> </c:out>"
																${ lista.id_cliente==cliente ? 'selected="selected"' : ''}>
																<c:out value="${lista.clave_cliente}"></c:out> -
																<c:out value="${lista.nombre_corto}"></c:out></option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-negocio form-group row">
												<label class="col-sm-4 col-form-label">Descripcion
													Negocio</label>
												<div class="col-sm-8">
													<select
														class="tab1neg1 form-control form-control-sm d-none "
														id="list_Negocios_r" name="id_negocio">
													</select> <select class="tab1neg form-control form-control-sm "
														id="listaDeNegocios" name="id_negocio">
														<option value="">Selecciona una opcion</option>
														<c:forEach items="${listaNegocios}" var="lista">
															<option
																value="<c:out value=" ${lista.id_negocio} "> </c:out>"
																${ lista.id_negocio==negocio ? 'selected="selected"' : ''}>
																<c:out value="${lista.clave}"></c:out>
																<c:out value=" - "></c:out>
																<c:out value="${lista.descripcion}"></c:out>
															</option>
														</c:forEach>
													</select>
												</div>
											</div>

											<div class="form-libre d-none form-group row">
												<label class="col-sm-4 col-form-label">Descripcion
													Cuentas</label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm d-none "
														id="list_Cuentas_r" name="id_cuenta">
													</select> <select class="form-control form-control-sm "
														id="listaDeCuentas" name="id_cuenta">
														<option value="">Selecciona una opcion</option>
														<c:forEach items="${listaSegmentos2}" var="lista">
															<option
																value="<c:out value="${lista.id} - ${lista.descripcion}"> </c:out>">
																<c:out value="${lista.valor_segmento}"></c:out> -
																<c:out value="${lista.descripcion}"></c:out></option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-libre d-none form-group row">
												<label class="col-sm-4 col-form-label">Descripcion
													Compañia</label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm d-none "
														id="list_Empresas_r" name="id_empresa">
													</select> <select class="form-control form-control-sm "
														id="listaDeEmpresas" name="id_empresa">
														<option value="">Selecciona una opcion</option>
														<c:forEach items="${listaSegmentos1}" var="lista">
															<option
																value="<c:out value="${lista.id} - ${lista.descripcion}"> </c:out>">
																<c:out value="${lista.valor_segmento}"></c:out> -
																<c:out value="${lista.descripcion}"></c:out></option>
														</c:forEach>
													</select>
												</div>
											</div>

											<div class="form-libre d-none form-group row">
												<label class="col-sm-4 col-form-label">Descripcion
													Inter</label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm d-none "
														id="list_Inter_r" name="id_inter">
													</select> <select class="form-control form-control-sm "
														id="listaDeInter" name="id_inter">
														<option value="">Selecciona una opcion</option>
														<c:forEach items="${listaSegmentos5}" var="lista">
															<option
																value="<c:out value="${lista.id} - ${lista.descripcion}"> </c:out>">
																<c:out value="${lista.valor_segmento}"></c:out> -
																<c:out value="${lista.descripcion}"></c:out></option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-libre d-none form-group row">
												<label class="col-sm-4 col-form-label">Descripcion
													Costos</label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm d-none "
														id="list_Centro_r" name="id_centro">
													</select> <select class="form-control form-control-sm "
														id="listaDeCentro" name="id_centro">
														<option value="">Selecciona una opcion</option>
														<c:forEach items="${listaSegmentos3}" var="lista">
															<option
																value="<c:out value="${lista.id} - ${lista.descripcion}"> </c:out>">
																<c:out value="${lista.valor_segmento}"></c:out> -
																<c:out value="${lista.descripcion}"></c:out></option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-libre d-none form-group row">
												<label class="col-sm-4 col-form-label">Descripcion
													Proyecto</label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm d-none "
														id="list_Proyectos_r" name="id_proyecto">
													</select> <select class="form-control form-control-sm "
														id="listaDeProyectos" name="id_proyecto">
														<option value="">Selecciona una opcion</option>
														<c:forEach items="${listaSegmentos4}" var="lista">
															<option
																value="<c:out value="${lista.id} - ${lista.descripcion}"> </c:out>">
																<c:out value="${lista.valor_segmento}"></c:out> -
																<c:out value="${lista.descripcion}"></c:out></option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-libre d-none form-group row">
												<label class="col-sm-4 col-form-label">Descripcion
													Producto</label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm d-none "
														id="list_Productos_r" name="id_producto">
													</select> <select class="form-control form-control-sm "
														id="listaDeProductos" name="id_producto">
														<option value="">Selecciona una opcion</option>
														<c:forEach items="${listaSegmentos6}" var="lista">
															<option
																value="<c:out value="${lista.id} - ${lista.descripcion}"> </c:out>">
																<c:out value="${lista.valor_segmento}"></c:out> -
																<c:out value="${lista.descripcion}"></c:out></option>
														</c:forEach>
													</select>
												</div>
											</div>
											
											<div class="form-libre d-none form-group row">
												<label class="col-sm-4 col-form-label">Descripcion
													Futuro</label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm d-none "
														id="list_Futuro_r" name="id_futuro">
													</select> <select class="form-control form-control-sm "
														id="listaDeFuturo" name="id_futuro">
														<option value="">Selecciona una opcion</option>
														<c:forEach items="${listaSegmentos7}" var="lista">
															<option
																value="<c:out value="${lista.id} - ${lista.descripcion}"> </c:out>">
																<c:out value="${lista.valor_segmento}"></c:out> -
																<c:out value="${lista.descripcion}"></c:out></option>
														</c:forEach>
													</select>
												</div>
											</div>


											<div class="form-group row">
												<div class="form-group col-md-12 d-flex flex-row-reverse ">
													<input type="hidden" id="clave_r" name="clave" />
													<button id="addModelo" type="button"
														class="btn btn-secondary text-white btn-sm float-right ml-3  mb-1 mt-auto">Agregar
														Modelo</button>
													<button id="removeModelo" type="button"
													class="btn btn-secondary text-white btn-sm float-right ml-3  mb-1 mt-auto">
													<span class="icon-arrow_back"></span>
													</button>
													
													<button id="compro" type="submit"
														class="btn btn-secondary text-white btn-sm float-right d-none ml-3  mb-1 mt-auto"></button>
													<button id="llenarMandar" type="button"
														class="btn btn-secondary text-white btn-sm float-right d-none ml-3  mb-1 mt-auto"></button>
													<button id="Mandar" type="submit"
														class="btn btn-secondary text-white btn-sm float-right d-none ml-3  mb-1 mt-auto"></button>
													<input type="hidden" id="checkval" name="checkval" />
												</div>
											</div>

										</div>

									</div>
								</div>

								<%-- menu 2 --%>
								<%-- menu 2 --%>
								<%-- menu 2 --%>
							</div>

						</div>
						<%-- submit --%>
						<%-- submit --%>
						<div class="col-md-12 mb-2">

							<div class="card mt-2">
								<div class="table-responsive">
									<table
										class="table table-scroll table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>Tipo Movimiento</th>
												<th>Descripcion</th>
												<th>Importe</th>
												<th>Compañia</th>
												<th>Cuenta</th>
												<th>Centro de Costos</th>
												<th>Proyecto</th>
												<th>InterCompañia</th>
												<th>Producto</th>
												<th>Futuro</th>
												<th>Eliminar</th>
											</tr>
										</thead>
										<tbody id="tableBody">

										</tbody>
									</table>
								</div>
							</div>


						</div>

						<div class="col-md-12">
							<button id="comparar" type="button"
								class="btn btn-secondary text-white btn-sm float-right   mb-1 mt-auto btnAppendConceptos">Guardar</button>
						</div>
						<%-- submit --%>
						<%-- submit --%>
					</div>
				</div>
			</div>
		</sf:form>
	</c:if>
	<%-- NEW --%>
	<%-- etiquetas unicas --%>
</div>
<script type="text/javascript"
	src='<c:url value="/js/appRegistroContable/registroContable.js"/>'
	defer="defer"></script>
<%@ include file="../layout/footer.jsp"%>