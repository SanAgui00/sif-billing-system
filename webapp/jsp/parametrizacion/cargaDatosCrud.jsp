<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<c:if test="${event=='delete'}">
					<c:forEach items="${consulta}" var="lista">
						<sf:form
							action="${pageContext.request.contextPath}/home/param/carga/save"
							method="POST" name="cargaDatoss">
							<input name="evento" type="hidden" value="delete" />
							<input name="id_reglas_carga" type="hidden"
								value="${lista.id_reglas_carga}" />
							<div class="card-header">
								<span class="title" id="menu-toggle">Eliminar</span> <a
									class="float-right text-secondary"
									href="<c:url value='/home/param/carga'/>" role="button">Regresar</a>
							</div>
							<div id="mainMenu" class="collapse show card-body">
								<div class="row">
									<div class="col-sm-12 col-md-12  text-center">
										<h5 class="card-title">
											Está a punto de eliminar a <span class="title">${lista.clave}.</span>
											¿Desea continuar?
										</h5>
										<button type="submit" class="btn btn-secondary text-white btn-sm">Eliminar</button>
										<a class="btn btn-secondary text-white btn-sm"
											href="<c:url value='/home/param/carga'/>" role="button">Regresar</a>
									</div>
								</div>
							</div>
						</sf:form>
					</c:forEach>
				</c:if>
				<c:if test="${event=='edit'}">
					<c:forEach items="${consulta}" var="lista">
						<sf:form
							action="${pageContext.request.contextPath}/home/param/carga/save"
							method="POST" name="cargaDatos">
							<input name="evento" type="hidden" value="update" />
							<input name="id_reglas_carga" type="hidden"
								value="${lista.id_reglas_carga}" />
							<input type="hidden" id="path"
								value="${pageContext.request.contextPath}" />
							<input name="fecha_creacion" type="hidden"
								value="<fmt:formatDate value="${lista.fecha_creacion}" pattern="yyyy-MM-dd"/>" />
							<input name="fecha_mod_old" type="hidden"
								value="${lista.fecha_mod}" />
							<div class="card-header">
								<span class="title" id="menu-toggle">Detalle Carga Datos</span>
								<a class="pl-4 text-secondary tab-link" data-toggle="collapse"
									href="#general" role="button" aria-expanded="false"
									aria-controls="general">Datos Generales</a>
								<%-- 								 <a class="pl-4 text-secondary tab-link" data-toggle="collapse" href="#tab2" role="button" aria-expanded="false" aria-controls="tab2">Histórico</a> --%>
								<a class="float-right text-secondary"
									href="<c:url value='/home/param/carga'/>" role="button">Regresar</a>
							</div>
							<div id="mainMenu" class="show card-body">
								<div class="collapse" id="general">
									<div class="row">
										<div class="col-sm-6 col-md-6 mt-2">
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Fuente de
													Adquisición</label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm"
														name="id_fuente">
														<c:forEach items="${listaFuentes}" var="fuente">
															<option
																value="<c:out value="${fuente.id_fuente}"></c:out>"
																${ fuente.id_fuente==lista.id_fuente ? 'selected="selected"' : ''}><c:out
																	value="${fuente.clave}"></c:out></option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Tabla
													Temporal</label>
												<div class="col-sm-8">
													<input type="text" class="form-control form-control-sm"
														name="tabla_temporal" value="${lista.tabla_temporal}" />
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Fecha Última
													Modificación</label>
												<div class="col-sm-8">
													<input type="text" class="form-control form-control-sm"
														name="fecha_mod" value="${lista.fecha_mod}" />
												</div>
											</div>
										</div>
										<div class="col-sm-6 col-md-6 mt-2">
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Usuario</label>
												<div class="col-sm-8">
													<input type="text" class="form-control form-control-sm"
														name="usuario" value="${lista.usuario}" />
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Estatus</label>
												<div class="col-sm-8">
													<input type="text" class="form-control form-control-sm"
														name="estatus" value="${lista.estatus}" />
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Comentarios</label>
												<div class="col-sm-8">
													<textarea class="form-control" maxlength="250"
														name="comentarios">${lista.comentarios}</textarea>
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-12 col-md-12 mt-2">
											<blockquote class="blockquote">
												<footer class="blockquote-footer">
													Para indicar la fecha de ejecución del proceso es necesario
													escribir dentro la regla <cite title="Source Title">:FECHAPROCESO</cite>
												</footer>
												<footer class="blockquote-footer">Para utilizar las
													funciones COUNT() o SUM() es necesario indicar una alias en
													la columna </footer>
											</blockquote>
										</div>
										<div class="col-sm-12 col-md-12 mt-2">
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Sentencia SQL</label>
												<div class="col-sm-8">
													<textarea class="form-control" maxlength="4000"
														name="sentencia" id="sentencia" rows="10">${lista.sentencia}</textarea>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-md-12 mt-2">
										<button type="submit"
											class="btn btn-secondary text-white btn-sm float-right bordered  mb-1 mt-auto">Guardar</button>
										<button type="button"
											class="btn btn-secondary text-white btn-sm float-right bordered  mb-1 mr-2 mt-auto"
											id="btnProbar">Probar</button>
									</div>
								</div>
						</sf:form>
						<sf:form
							action="${pageContext.request.contextPath}/home/param/carga/test"
							method="POST" name="cargaDatos">
							<input type="hidden" class="form-control form-control-sm"
								name="event" id="event" value="edit">
							<input type="hidden" class="form-control form-control-sm"
								name="idRegla" id="idRegla" value="${lista.id_reglas_carga}">
							<input type="text" class="form-control form-control-sm d-none"
								name="sentencia" id="nuevaSentencia">
							<button type="submit" id="enviarPrueba"
								class="btn btn-secondary text-white btn-sm float-right bordered  mb-1 mt-auto d-none">Guardar</button>
						</sf:form>
					</c:forEach>
				</c:if>
				<c:if test="${event=='new'}">
					<sf:form
						action="${pageContext.request.contextPath}/home/param/carga/save"
						method="POST" name="cargaDatos">
						<input name="evento" type="hidden" value="insert" />
						<input type="hidden" id="path"
							value="${pageContext.request.contextPath}" />
						<div class="card-header">
							<span class="title" id="menu-toggle">Agregar Carga Datos</span> <a
								class="pl-4 text-secondary tab-link" data-toggle="collapse"
								href="#general" role="button" aria-expanded="false"
								aria-controls="general">Datos Generales</a>
							<%-- 								 <a class="pl-4 text-secondary tab-link" data-toggle="collapse" href="#tab2" role="button" aria-expanded="false" aria-controls="tab2">Histórico</a> --%>
							<a class="float-right text-secondary"
								href="<c:url value='/home/param/carga'/>" role="button">Regresar</a>
						</div>
						<div id="mainMenu" class="show card-body">
							<div class="collapse" id="general">
								<div class="row">
									<div class="col-sm-6 col-md-6 mt-2">
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Fuente de
												Adquisición</label>
											<div class="col-sm-8">
												<select class="form-control form-control-sm"
													name="id_fuente">
													<c:forEach items="${listaFuentes}" var="fuente">
														<option
															value="<c:out value="${fuente.id_fuente}"></c:out>"><c:out
																value="${fuente.clave}"></c:out></option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-6 mt-2">
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Comentarios</label>
											<div class="col-sm-8">
												<textarea class="form-control" maxlength="256"
													name="comentarios"></textarea>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12 col-md-12 mt-2">
										<blockquote class="blockquote">
											<footer class="blockquote-footer">
												Para indicar la fecha de ejecución del proceso es necesario
												escribir dentro la regla <cite title="Source Title">:FECHAPROCESO</cite>
											</footer>
											<footer class="blockquote-footer">Para utilizar las
												funciones COUNT() o SUM() es necesario indicar una alias en
												la columna </footer>
										</blockquote>
									</div>
									<div class="col-sm-12 col-md-12 mt-2">
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Sentencia SQL</label>
											<div class="col-sm-8">
												<textarea class="form-control" maxlength="4000"
													name="sentencia" id="sentencia" rows="10"></textarea>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-12 mt-2">
									<button type="submit"
										class="btn btn-secondary text-white btn-sm float-right bordered  mb-1 mt-auto">Guardar</button>
									<button type="button"
										class="btn btn-secondary text-white btn-sm float-right bordered  mb-1 mr-2 mt-auto"
										id="btnProbar">Probar</button>
								</div>
							</div>
						</div>
					</sf:form>
					<sf:form
							action="${pageContext.request.contextPath}/home/param/carga/test"
							method="POST" name="cargaDatos">
							<input type="hidden" class="form-control form-control-sm"
								name="event" id="event" value="new">
							<input type="hidden" class="form-control form-control-sm"
								name="idRegla" id="idRegla" value="${lista.id_reglas_carga}">
							<input type="text" class="form-control form-control-sm d-none"
								name="sentencia" id="nuevaSentencia">
							<button type="submit" id="enviarPrueba"
								class="btn btn-secondary text-white btn-sm float-right bordered  mb-1 mt-auto d-none">Guardar</button>
						</sf:form>
				</c:if>
			</div>
		</div>
	</div>
</div>
<%@ include file="../layout/footer.jsp"%>
