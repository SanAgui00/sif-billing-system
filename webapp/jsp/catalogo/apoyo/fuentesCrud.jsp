<%@ include file="../../layout/header.jsp"%>
<%@ include file="../../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<c:if test="${event=='delete'}">
		<sf:form
			action="${pageContext.request.contextPath}/home/cat/apoyo/fuentes/save"
			method="POST">
			<div class="row">
				<div class="col-sm-12">
					<div class="card mt-1">
						<c:forEach items="${consulta}" var="consulta">
							<input name="evento" type="hidden" value="delete" />
							<input name="id_fuente" type="hidden"
								value="${consulta.id_fuente}" />
							<div class="card-header">
								<span class="title" id="menu-toggle">Eliminar</span> <a
									class="float-right text-secondary"
									href="<c:url value='/home/cat/apoyo/fuentes'/>" role="button">Regresar</a>
							</div>
							<div id="mainMenu" class="collapse show card-body">
								<div class="row">
									<div class="col-sm-12 col-md-12  text-center">
										<h5 class="card-title">
											Está a punto de eliminar a <span class="font-weight-bold"><c:out
													value="${consulta.clave}"></c:out>.</span> ¿Desea continuar?
										</h5>
										<button type="submit"
											class="btn btn-secondary text-white btn-sm">Eliminar</button>
										<a class="btn btn-secondary text-white btn-sm"
											href="<c:url value='/home/cat/apoyo/fuentes'/>" role="button">Regresar</a>
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
				action="${pageContext.request.contextPath}/home/cat/apoyo/fuentes/save"
				method="POST">
				<input name="evento" type="hidden" value="update" />
				<div class="row">
					<div class="col-sm-12">
						<div class="card mt-1">
							 <input
								name="id_fuente" type="hidden" value="${consulta.id_fuente}" />
							<div class="card-header">
								<span class="title" id="menu-toggle">Detalle de la Fuente</span>
								<a class="float-right text-secondary"
									href="<c:url value='/home/cat/apoyo/fuentes'/>" role="button">Regresar</a>
								<span class="float-right text-secondary pr-3" id="btn-ocultar">Ocultar</span>
							</div>
							<div id="mainMenu" class="collapse show card-body pb-0">
								<div class="row">
									<div class="col-sm-6 col-md-6 mt-2">
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Nombre Fuente</label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm"
													placeholder="Clave" value="${consulta.clave}" name="clave" maxlength="10">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Fuente Base </label>
											<div class="col-sm-8">
												<select class="form-control form-control-sm" name="id_fuente_base_clave_cli">
													<option value="">Seleccionar Fuente</option>
													<c:forEach items="${listaFuentes}" var="fuente">
														<option
															value="<c:out value="${fuente.id_fuente}"></c:out>" ${fuente.id_fuente eq consulta.id_fuente_base_clave_cli ? 'selected="selected"':''}>
															<c:out value="${fuente.clave}"></c:out>
														</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-6 mt-2">
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Descripción</label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm"
													placeholder="Descripcion" value="${consulta.descripcion}"
													name="descripcion" maxlength="50">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Comentarios</label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm"
													placeholder="Comentarios" value="${consulta.comentarios}"
													name="comentarios" maxlength="250">
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-12 mt-1">
												<button type="submit"
													class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto btnAppendConceptos">Guardar</button>
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
			action="${pageContext.request.contextPath}/home/cat/apoyo/fuentes/save"
			method="POST">
			<input name="evento" type="hidden" value="insert" />
			<div class="row">
				<div class="col-sm-12">
					<div class="card mt-1">
						<div class="card-header">
							<span class="title" id="menu-toggle">Nueva Fuente</span> <a
								class="float-right text-secondary"
								href="<c:url value='/home/cat/apoyo/fuentes'/>" role="button">Regresar</a>
							<span class="float-right text-secondary pr-3" id="btn-ocultar">Ocultar</span>
						</div>
						<div id="mainMenu" class="collapse show card-body pb-0">
							<div class="row">
								<div class="col-sm-6 col-md-6 mt-2">
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Nombre Fuente</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm"
												placeholder="Clave" name="clave" maxlength="10">
										</div>
									</div>
									<div class="form-group row">
											<label class="col-sm-4 col-form-label">Fuente Base </label>
											<div class="col-sm-8">
												<select class="form-control form-control-sm" name="id_fuente_base_clave_cli">
													<option value="0">Seleccionar Fuente</option>
													<c:forEach items="${listaFuentes}" var="fuente">
														<option
															value="<c:out value=" ${fuente.id_fuente} "></c:out>">
															<c:out value="${fuente.clave}"></c:out>
														</option>
													</c:forEach>
												</select>
											</div>
										</div>
								</div>
								<div class="col-sm-6 col-md-6 mt-2">
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Descripción</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm"
												placeholder="Descripcion" name="descripcion" maxlength="50">
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Comentarios</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm"
												placeholder="Comentarios" name="comentarios" maxlength="250">
										</div>
									</div>
									<div class="form-group row">
										<div class="col-md-12 mt-1">
											<button type="submit"
												class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto btnAppendConceptos">Guardar</button>
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
