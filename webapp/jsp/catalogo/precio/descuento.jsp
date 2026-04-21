<%@ include file="../../layout/header.jsp"%>
<%@ include file="../../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<input type="hidden" id="path"
	value="${pageContext.request.contextPath}" />
<input type="hidden" id="type_list"
	value="${pageContext.request.contextPath}" />
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<div class="card-header">
					<span class="title" id="menu-toggle">Asignar y Aplicar
						Descuentos</span>
					<ul class="nav d-inline-block">
						<li class="nav-item d-inline-block"><a
							class="nav-link text-secondary p-0 mr-3 ml-3  tab-link active"
							id="tab-1" data-toggle="tab" href="#tab1" role="tab"
							aria-controls="tab1" aria-selected="true">Por Cliente</a></li>
						<li class="nav-item d-inline-block"><a
							class="nav-link text-secondary p-0 mr-3  tab-link" id="tab-2"
							data-toggle="tab" href="#tab2" role="tab" aria-controls="tab2"
							aria-selected="false">Por Servicio</a></li>
					</ul>
					<span class="float-right text-secondary" id="btn-ocultar">Ocultar</span>
				</div>
				<div class="tab-content" id="mainMenu">
					<%-- MENU1 --%>
					<%-- MENU1 --%>
					<div class="tab-pane  show active" id="tab1" role="tabpanel"
						aria-labelledby="tab-1">
						<sf:form
							action="${pageContext.request.contextPath}/home/cat/precio/descuento/consulta"
							method="POST" autocomplete="off">
							<input type="hidden" name="flag" value="0">
							<div class="card-body">
								<div class="row">
									<div class="col-sm-6 col-md-6 mt-2">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label">Buscar Cliente
											</label>
											<div class="col-sm-9">
												<input type="text" id="list_Clientes"
													class="form-control form-control-sm ajax-form"
													placeholder="Busca un cliente" name="list_Clientes" />
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-6 col-form-label">Grupo Volumen</label>
											<div class="col-sm-6">
												<select class="form-control form-control-sm"
													name="grupo_volumen">
													<option value="">Seleccionar Grupo Concepto</option>
													<c:forEach items="${listaGrupoConceptoServ}" var="grupoCon">
														<option
															value="<c:out value=" ${grupoCon.id_grupo} "> </c:out>">
															<c:out value="${grupoCon.clave}"></c:out>
														</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-6 mt-2">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label">Selecciona
												Cliente</label>
											<div class="col-sm-9">
												<select class="form-control form-control-sm d-none "
													id="list_Clientes_r" name="id_cliente">
												</select> <select class="form-control form-control-sm "
													id="listaDeClientes" name="id_cliente">
													<option value="">Selecciona un cliente</option>
													<c:forEach items="${listaClientes}" var="lista">
														<option
															value="<c:out value="${lista.id_cliente}"> </c:out>">
															<c:out value="${lista.clave_cliente}"></c:out> -
															<c:out value="${lista.nombre_corto}"></c:out></option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-6 col-form-label">Lista de
												Clientes</label>
											<div class="col-sm-6">
												<select class="form-control form-control-sm"
													name="lista_clientes">
													<option value="">Selecciona una opcion</option>
													<c:forEach items="${listaNegocios}" var="lista">
														<option
															value="<c:out value="${lista.id_negocio}"> </c:out>">
															<c:out value="${lista.clave}"></c:out></option>
													</c:forEach>
												</select>
											</div>
										</div>
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
					<%-- MENU1 --%>
					<%-- MENU1 --%>
					<%-- MENU2 --%>
					<%-- MENU2 --%>
					<div class="tab-pane " id="tab2" role="tabpanel"
						aria-labelledby="tab-2">
						<sf:form
							action="${pageContext.request.contextPath}/home/cat/precio/descuento/consulta"
							method="POST" autocomplete="off">
							<input type="hidden" name="flag" value="1">
							<div class="card-body">
								<div class="row">
									<div class="col-sm-6 col-md-6 mt-2">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label">Buscar
												Servicio </label>
											<div class="col-sm-9">
												<input type="text" id="list_Servicios"
													class="form-control form-control-sm ajax-form flagServicio"
													placeholder="Busca un Servicio" name="list_Servicios" />
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-6 col-form-label">Grupo Concepto
												Servicio</label>
											<div class="col-sm-6">
												<select class="form-control form-control-sm"
													name="grupo_concepto">
													<option value="">Seleccionar Grupo Concepto</option>
													<c:forEach items="${listaGrupoConceptoServ}" var="grupoCon">
														<option
															value="<c:out value=" ${grupoCon.id_grupo} "> </c:out>">
															<c:out value="${grupoCon.clave}"></c:out>
														</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-6 mt-2">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label">Selecciona
												Servicio</label>
											<div class="col-sm-9">
												<select class="form-control form-control-sm flagServicio"
													id="list_Servicios_r" name="id_servicio">
												</select> <select class="form-control form-control-sm flagServicio"
													id="listaDeServicios" name="id_servicio">
													<option value="">Selecciona un servicio</option>
													<c:forEach items="${listaServicio}" var="lista">
														<option
															value="<c:out value=" ${lista.id_servicios} "> </c:out>">
															<c:out value="${lista.clave}"></c:out> -
															<c:out value="${lista.descripcion}"></c:out>
														</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-6 col-form-label">Negocio</label>
											<div class="col-sm-6">
												<select class="form-control form-control-sm"
													name="idNegocio">
													<option value="">Selecciona una opcion</option>
													<c:forEach items="${listaNegocios}" var="lista">
														<option
															value="<c:out value="${lista.id_negocio}"> </c:out>">
															<c:out value="${lista.clave}"></c:out></option>
													</c:forEach>
												</select>
											</div>
										</div>
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
					<%-- MENU2 --%>
					<%-- MENU2 --%>

				</div>
			</div>
		</div>
		<c:if test="${not empty consulta}">
			<div class="col-sm-12 mb-2">
				<div class="card mt-2">
					<div class="table-responsive">
						<table
							class="table table-scroll table-striped table-bordered table-hover">
							<c:if test="${flag eq 0}">
								<thead>
									<tr>
										<th scope="col">Clave del Cliente</th>
										<th scope="col">Nombre Corto</th>
										<th scope="col">Descuento</th>
										<th scope="col" class="text-center">Editar</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${consulta}" var="consulta">
										<tr>
											<td><c:out value="${consulta.clave_cliente}"></c:out></td>
											<td><c:out value="${consulta.nombre_corto}"></c:out></td>
											<td><c:out value="${consulta.porcentaje_descuento}"></c:out></td>
											<td><sf:form
													action="${pageContext.request.contextPath}/home/cat/precio/descuento/crud"
													method="POST" name="crud" class="text-center">
													<input name="id_cliente" type="hidden"
														value="${consulta.id_cliente}" />
													<input name="clave_cliente" type="hidden"
														value="${consulta.clave_cliente}" />
													<input name="nombre_corto" type="hidden"
														value="${consulta.nombre_corto}" />
													<input name="porcentaje_descuento" type="hidden"
														value="${consulta.porcentaje_descuento}" />
													<input name="evento" type="hidden" value="cliente" />
													<button type="submit"
														class="btn btn-secondary text-white btn-sm btn-table">
														<span class="icon-brush"></span>
													</button>
												</sf:form></td>
										</tr>
									</c:forEach>
								</tbody>
							</c:if>
							<c:if test="${flag eq 1}">
								<thead>
									<tr>
										<th scope="col">Clave del Servicio</th>
										<th scope="col">Descripción</th>
										<th scope="col">Negocio</th>
										<th scope="col">Descuento</th>
										<th scope="col" class="text-center">Editar</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${consulta}" var="consulta">
										<tr>
											<td><c:out value="${consulta.clave}"></c:out></td>
											<td><c:out value="${consulta.descripcion}"></c:out></td>
											<td><c:out value="${consulta.negocio}"></c:out></td>
											<td><c:out value="${consulta.porcentaje_descuento}"></c:out></td>
											<td><sf:form
													action="${pageContext.request.contextPath}/home/cat/precio/descuento/crud"
													method="POST" name="crud" class="text-center">
													<input name="id_servicio" type="hidden"
														value="${consulta.id_servicio}" />
													<input name="clave_cliente" type="hidden"
														value="${consulta.clave}" />
													<input name="nombre_corto" type="hidden"
														value="${consulta.descripcion}" />
													<input name="porcentaje_descuento" type="hidden"
														value="${consulta.porcentaje_descuento}" />
													<input name="evento" type="hidden" value="servicio" />
													<button type="submit"
														class="btn btn-secondary text-white btn-sm btn-table">
														<span class="icon-brush"></span>
													</button>
												</sf:form></td>
										</tr>
									</c:forEach>
								</tbody>
							</c:if>
						</table>
					</div>
				</div>
				<c:if test="${not empty registros_totales}">
					<sf:form
						action="${pageContext.request.contextPath}/home/cat/precio/descuento/consulta"
						method="POST" name="pagination">
						<input type="hidden" name="fuentes" id="getfuentes"
							class="globalGet">
						<input type="hidden" name="registros_totales"
							id="registros_totales" class="registros_totales"
							value="${registros_totales}">
						<input type="hidden" name="fromRow" id="fromRow" class="fromRow"
							value="">

						<nav>
							<ul class="pagination  pagination-sm justify-content-end">
								<span class='page-link prev'><span
									class="icon-arrow_back"></span></span>
								<span class="pagination-container d-inline-block"
									id="pagination-container"></span>
								<span class='page-link next'><span
									class="icon-arrow_forward"></span></span>
							</ul>
						</nav>
						<button type="submit" class="d-none" id="pagination-submit"></button>
					</sf:form>
				</c:if>
			</div>

		</c:if>
	</div>
</div>
<%@ include file="../../layout/footer.jsp"%>