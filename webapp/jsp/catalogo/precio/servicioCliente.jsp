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
					<span class="title" id="menu-toggle">Lista de Servicios por
						Cliente <c:out value="${editar.clave_cliente}"></c:out>
					</span>
					<ul class="nav d-inline-block">
						<li class="nav-item d-inline-block"><a
							class="nav-link text-secondary p-0 mr-3 ml-4  tab-link active"
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

					<div class="tab-pane  show active" id="tab1" role="tabpanel"
						aria-labelledby="tab-1">
						<sf:form
							action="${pageContext.request.contextPath}/home/cat/precio/servicio/consulta"
							method="POST" autocomplete="off">
							<input type="hidden" name="evento" id="evento" value="${evento}" />
							<div class="card-body">
								<div class="row">
									<div class="col-md-12 mt-1 mb-1">
										<span class="title" id="tituloServicioCliente">Búsqueda
											por CLIENTE</span>
									</div>
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
											<label class="col-sm-3 col-form-label">Buscar
												Servicio </label>
											<div class="col-sm-9">
												<input type="text" id="list_Servicios"
													class="form-control form-control-sm ajax-form flagServicio"
													placeholder="Busca un Servicio" name="list_Servicios" />
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-6 col-form-label">Grupo Servicio</label>
											<div class="col-sm-6">
												<select class="form-control form-control-sm"
													name="grupo_concepto" id="grupo_concepto">
													<option value="">Seleccionar Grupo Concepto</option>
													<c:forEach items="${listaGrupoConceptoServ}" var="grupoCon">
														<option
															value="<c:out value="${grupoCon.id_grupo}"> </c:out>">
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
															value="<c:out value="${lista.id_cliente}"> </c:out>"
															${id_cliente eq lista.id_cliente ? 'selected="selected"':''}>
															<c:out value="${lista.clave_cliente}"></c:out> -
															<c:out value="${lista.nombre_corto}"></c:out>
														</option>
													</c:forEach>
												</select>
											</div>
										</div>
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
															value="<c:out value="${lista.id_servicios}"> </c:out>"
															${id_servicio eq lista.id_servicios ? 'selected="selected"':''}>
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
													name="idNegocio" id="idNegocio">
													<option value="">Selecciona una opcion</option>
													<c:forEach items="${listaNegocios}" var="lista">
														<option
															value="<c:out value="${lista.id_negocio}"> </c:out>">
															<c:out value="${lista.clave}"></c:out>
														</option>
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
				</div>
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
									<c:if test="${TablaConsulta eq 'porCliente'}">
										<th>Clave del Servicio</th>
										<th>Descripción</th>
										<th>Grupo Concepto</th>
										<th>Negocio</th>
										<th>¿Precio Específico?</th>
										<th class="text-center">Editar</th>
										<th class="text-center">Excluir Servicio</th>
									</c:if>
									<c:if test="${TablaConsulta eq 'porServicio'}">
										<th>Clave de Cliente</th>
										<th>Nombre corto</th>
										<th>¿Precio Específico?</th>
									</c:if>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${consulta}" var="lista">
									<tr>
										<c:if test="${TablaConsulta eq 'porCliente'}">
											<td>${lista.clave_servicio}</td>
											<td>${lista.descripcion}</td>
											<td>${lista.clave_grupo}</td>
											<td>${lista.clave_negocio}</td>
											<td>NO</td>
											<td><sf:form
													action="${pageContext.request.contextPath}/home/cat/precio/servicio/crud"
													method="POST" name="crud" class="text-center">
													<input name="event" type="hidden" value="edit" />
													<button type="submit"
														class="btn btn-secondary text-white btn-sm btn-table ">
														<span class="icon-brush"></span>
													</button>
												</sf:form></td>
											<td><div class="form-check text-center">
													<input
														class="form-check-input form-check-input-excluir position-static"
														value="${lista.id_servicio}" type="checkbox">
												</div></td>
										</c:if>
										<c:if test="${TablaConsulta eq 'porServicio'}">
											<td>${lista.clave_cliente}</td>
											<td>${lista.nombre_corto}</td>
											<td>NO</td>
										</c:if>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<c:if test="${not empty registros_totales}">
					<sf:form
						action="${pageContext.request.contextPath}/home/cat/precio/servicio/consulta"
						method="POST" name="pagination">
						<input type="hidden" name="id_cliente" id="getlistaDeClientes"
							class="globalGet">
						<input type="hidden" name="id_servicio" id="getlistaDeServicios"
							class="globalGet">
						<input type="hidden" name="grupo_concepto" id="getgrupo_concepto"
							class="globalGet">
						<input type="hidden" name="idNegocio" id="getidNegocio"
							class="globalGet">
						<input type="hidden" name="evento" id="getevento"
							class="globalGet" />
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
			</c:if>
		</div>
	</div>
</div>
<%@ include file="../../layout/footer.jsp"%>
<script type="text/javascript"
	src='<c:url value="/js/appFacturas/operaciones.js"/>' defer="defer"></script>