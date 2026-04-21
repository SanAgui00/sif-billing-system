<%@ include file="../../layout/header.jsp"%>
<%@ include file="../../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<c:if test="${event=='delete'}">
		<sf:form
			action="${pageContext.request.contextPath}/home/cat/grupo/volumenCliente/save"
			method="POST" name="insert">
			<div class="row">
				<div class="col-sm-12">
					<div class="card mt-1">
						<c:forEach items="${consulta}" var="consulta">
							<input name="event" type="hidden" value="delete" />
							<input name="idGrupo" type="hidden" value="${consulta.id_grupo}" />
							<div class="card-header">
								<span class="title" id="menu-toggle">Eliminar</span> <a
									class="float-right text-secondary"
									href="<c:url value='/home/cat/grupo/volumenCliente/'/>"
									role="button">Regresar</a>
							</div>
							<div id="mainMenu" class="collapse show card-body">
								<div class="row">
									<div class="col-sm-12 col-md-12  text-center">
										<h5 class="card-title">
											Está a punto de eliminar a <span class="font-weight-bold"><c:out
													value="${consulta.clave}"></c:out>.</span> ¿Desea continuar?
										</h5>
										<button type="submit" class="btn btn-secondary text-white btn-sm">Eliminar</button>
										<a class="btn btn-secondary text-white btn-sm"
											href="<c:url value='/home/cat/grupo/volumenCliente/'/>"
											role="button">Regresar</a>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</sf:form>
	</c:if>
	<c:if test="${event=='edit' && not empty consulta}">
		<c:forEach items="${consulta}" var="consulta">
			<sf:form
				action="${pageContext.request.contextPath}/home/cat/grupo/volumenCliente/save"
				method="POST" name="insert">
				<input name="event" type="hidden" value="update" />
				<input name="idGrupo" type="hidden" value="${consulta.id_grupo}" />
				<div class="row">
					<div class="col-sm-12">
						<div class="card mt-1">
							<div class="card-header">
								<span class="title" id="menu-toggle">Detalle de Grupos de
									Conceptos</span> <a class="float-right text-secondary"
									href="<c:url value='/home/cat/grupo/volumenCliente/'/>"
									role="button">Regresar</a> <span
									class="float-right text-secondary pr-3" id="btn-ocultar">Ocultar</span>
							</div>
							<div id="mainMenu" class="collapse show card-body pb-0">
								<div class="row">
									<div class="col-sm-6 col-md-6 mt-2">
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Grupo de
												Conceptos</label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm"
													placeholder="clave" name="clave"
													value="<c:out
                                        value="${consulta.clave}"></c:out>"
													disabled />
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Descripción</label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm"
													placeholder="descripcion" name="descripcion"
													value="<c:out
                                        value="${consulta.descripcion}"></c:out>" />
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Comentarios</label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm"
													placeholder="comentarios" name="comentarios"
													value="<c:out
                                        value="${consulta.comentarios}"></c:out>" />
											</div>
										</div>

									</div>
									<div class="col-sm-6 col-md-6 mt-2">
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Autor</label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm"
													placeholder="usuario" name="usuario"
													value="<c:out
                                        value="${consulta.usuario}"></c:out>"
													disabled />
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Fecha Creación</label>
											<div class="col-sm-8">

												<input type="date" class="form-control form-control-sm"
													id="fecha_crea" name="fecha_crea"
													value="<fmt:formatDate value="${consulta.fecha_crea}" pattern="yyyy-MM-dd"/>"
													disabled>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Fecha
												Modificación</label>
											<div class="col-sm-8">
												<input type="date" class="form-control form-control-sm"
													id="fecha_mod" name="fecha_mod"
													value="<fmt:formatDate value="${consulta.fecha_mod}" pattern="yyyy-MM-dd"/>"
													disabled>
											</div>
										</div>

									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-12">

						<div class="card mt-2">
							<div class="card-header">Cliente Asignados</div>
							<div class="table-responsive">
								<table
									class="table table-scroll table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>Clave</th>
											<th>Descripción</th>
											<th>Fecha de Asignación</th>
											<th>Usuario</th>
											<th>Excluir</th>
											<th>Incluir</th>
										</tr>
									</thead>
									<tbody id="tablaAsignacion">
										<c:forEach items="${consultaAsignar}" var="lista">
											<tr>
												<td class="getColumn"><c:out value="${lista.clave}"></c:out></td>
												<td><c:out value="${lista.descripcion}"></c:out></td>
												<td><fmt:formatDate value="${lista.fecha_mod}"
														pattern="dd/MM/yyyy" /></td>
												<td><c:out value="${lista.usuario}"></c:out></td>
												<td><div class="form-check">
														<input
															class="form-check-input form-check-input-excluir position-static"
															type="checkbox" value="${lista.id_servicios}" />
													</div></td>
												<td></td>
											</tr>
										</c:forEach>
										<input type="hidden" name="listaServiciosExluidos"
											id="listaServiciosExluidos" />
										<input type="hidden" name="listaServiciosIncluidos"
											id="listaServiciosIncluidos" />
										<input type="hidden" name="listaUsuario" id="listaUsuario"
											value="<c:out value="${pageContext.request.userPrincipal.name}"/>" />
									</tbody>
								</table>
							</div>
						</div>

					</div>
					<div class="col-sm-12">
						<div class="card mt-2">
							<input type="hidden" id="path"
								value="${pageContext.request.contextPath}" /> <input
								type="hidden" id="type_list"
								value="${pageContext.request.contextPath}" />
							<div class="card-header">Asignar Cliente</div>
							<div class="collapse show card-body pb-1">
								<div class="row">
									<div class="col-sm-4 col-md-4 mt-2">

										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Buscar un
												Cliente</label>
											<div class="col-sm-8">
												<input type="text" id="list_Clientes"
													class="form-control form-control-sm ajax-form"
													placeholder="Busca un cliente" name="list_Clientes" />
											</div>
										</div>

									</div>
									<div class="col-sm-6 col-md-6 mt-2">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label">Selecciona un
												Cliente</label>
											<div class="col-sm-9">
												<select class="form-control form-control-sm d-none "
													id="list_Clientes_r" name="id_cliente">
												</select> <select class="form-control form-control-sm "
													id="listaDeClientes" name="id_cliente">
													<option value="0">Selecciona una opcion</option>
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
									</div>
									<div class="col-sm-2 col-md-2 mt-2">
										<div class="form-group row">
											<div class="col-md-6">
												<button type="button"
													class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto"
													id="btnAsignar">Asignar</button>
											</div>
											<div class="col-md-6">
												<button type="button"
													class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto"
													id="btnGuardarTodo">Guardar Todo</button>
												<button type="submit"
													class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto d-none"
													id="btnEjecutar">Ejecutar</button>
											</div>
										</div>
									</div>

								</div>
							</div>
						</div>
					</div>
				</div>
			</sf:form>
		</c:forEach>
	</c:if>
	<c:if test="${event=='new'}">
		<sf:form
			action="${pageContext.request.contextPath}/home/cat/grupo/volumenCliente/save"
			method="POST" name="insert">
			<input name="event" type="hidden" value="insert" />
			<div class="row">
				<div class="col-sm-12">
					<div class="card mt-1">
						<div class="card-header">
							<span class="title" id="menu-toggle">Nuevo Grupo</span> <a
								class="float-right text-secondary"
								href="<c:url value='/home/cat/grupo/volumenCliente/'/>"
								role="button">Regresar</a> <span
								class="float-right text-secondary pr-3" id="btn-ocultar">Ocultar</span>
						</div>
						<div id="mainMenu" class="collapse show card-body pb-0">
							<div class="row">
								<div class="col-sm-6 col-md-6 mt-2">
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Grupo de
											Conceptos</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm"
												placeholder="clave" name="clave" />
										</div>
									</div>

									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Comentarios</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm"
												placeholder="comentarios" name="comentarios" />
										</div>
									</div>

								</div>
								<div class="col-sm-6 col-md-6 mt-2">
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Descripción</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm"
												placeholder="descripcion" name="descripcion" />
										</div>
									</div>

								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-12">
					<c:if test="${empty consultaAsignar}">
						<div class="card mt-2">
							<div class="card-header">Cliente Asignados</div>
							<div class="table-responsive">
								<table
									class="table table-scroll table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>Clave</th>
											<th>Descripción</th>
											<th>Fecha de Asignación</th>
											<th>Usuario</th>
											<th>Excluir</th>
											<th>Incluir</th>
										</tr>
									</thead>
									<tbody id="tablaAsignacion">
										<c:forEach items="${consultaAsignar}" var="lista">
											<tr>
												<td class="getColumn"><c:out value="${lista.clave}"></c:out></td>
												<td><c:out value="${lista.descripcion}"></c:out></td>
												<td><fmt:formatDate value="${lista.fecha_mod}"
														pattern="dd/MM/yyyy" /></td>
												<td><c:out value="${lista.usuario}"></c:out></td>
												<td><div class="form-check">
														<input
															class="form-check-input form-check-input-excluir position-static"
															type="checkbox" value="${lista.id_servicios}" />
													</div></td>
												<td></td>
											</tr>
										</c:forEach>
										<input type="hidden" name="listaServiciosExluidos"
											id="listaServiciosExluidos" />
										<input type="hidden" name="listaServiciosIncluidos"
											id="listaServiciosIncluidos" />
										<input type="hidden" name="listaUsuario" id="listaUsuario"
											value="<c:out value="${pageContext.request.userPrincipal.name}"/>" />
									</tbody>
								</table>
							</div>
						</div>
					</c:if>
				</div>
				<div class="col-sm-12">
					<div class="card mt-2">
						<input type="hidden" id="path"
							value="${pageContext.request.contextPath}" /> <input
							type="hidden" id="type_list"
							value="${pageContext.request.contextPath}" />
						<div class="card-header">Asignar Cliente</div>
						<div class="collapse show card-body pb-1">
							<div class="row">
								<div class="col-sm-4 col-md-4 mt-2">

									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Buscar un
											Cliente</label>
										<div class="col-sm-8">
											<input type="text" id="list_Clientes"
												class="form-control form-control-sm ajax-form"
												placeholder="Busca un cliente" name="list_Clientes" />
										</div>
									</div>

								</div>
								<div class="col-sm-6 col-md-6 mt-2">
									<div class="form-group row">
										<label class="col-sm-3 col-form-label">Selecciona un
											Cliente</label>
										<div class="col-sm-9">
											<select class="form-control form-control-sm d-none "
												id="list_Clientes_r" name="id_cliente">
											</select> <select class="form-control form-control-sm "
												id="listaDeClientes" name="id_cliente">
												<option value="0">Selecciona una opcion</option>
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
								</div>
								<div class="col-sm-2 col-md-2 mt-2">
									<div class="form-group row">
										<div class="col-md-6">
											<button type="button"
												class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto"
												id="btnAsignar">Asignar</button>
										</div>
										<div class="col-md-6">
											<button type="button"
												class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto"
												id="btnGuardarTodo">Guardar Todo</button>
											<button type="submit"
												class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto d-none"
												id="btnEjecutar">Ejecutar</button>
										</div>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>

			</div>
		</sf:form>
	</c:if>
</div>
<%@ include file="../../layout/footer.jsp"%>