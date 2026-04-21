<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="card mt-2 general-title">
		<div class="card-body">
			<div class="form-row h-100">
				<div class="form-group col-md-6 auto the-title">
					<c:if test="${not empty editar}">
						<c:forEach items="${editar}" var="editar">
							<c:if test="${event=='edit'}">
								<span class="title">Editando a <c:out
										value="${editar.clave}"></c:out></span>
							</c:if>
							<c:if test="${event=='delete'}">
								<span class="title">¿Quiere eliminar a <c:out
										value="${editar.clave}"></c:out> ?
								</span>
							</c:if>
						</c:forEach>
					</c:if>
				</div>
				<div class="form-group col-md-6 auto">
					<c:if test="${event=='delete'}">
						<sf:form
							action="${pageContext.request.contextPath}/home/impresiones/etiquetas/save"
							method="POST" name="insert">
							<c:forEach items="${editar}" var="editar">
								<input name="evento" type="hidden" value="delete" />
								<input name="id" type="hidden" value="${editar.id_estilo}" />
								<button type="submit"
									class="btn btn-secondary text-white btn-sm float-right ">Eliminar</button>
							</c:forEach>
						</sf:form>
					</c:if>
					<a class="float-right text-secondary"
						href="<c:url value='/home/impresiones/etiquetas'/>" role="button">Regresar</a>
				</div>
			</div>
		</div>
	</div>
	<c:if test="${event=='edit' && not empty editar}">
		<sf:form
			action="${pageContext.request.contextPath}/home/impresiones/etiquetas/save"
			
			method="POST" name="insert">
			<c:forEach items="${editar}" var="editar">
				<input name="evento" type="hidden" value="update" />
				<input name="id" type="hidden" value="${editar.id_estilo}" />
				<div class="row card-row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="card">
							<div class="card-body">
								<div class="form-row">
									<div class="col-md-6">
										<div class="input-group input-group-sm mb-3">

											<label class="col-sm-4 col-form-label"
												id="inputGroup-sizing-sm">Estatus</label> <select
												class="custom-select " name="estatus">
												<option selected value="0">Opciones</option>
												<option value="ACT"${ 'ACT'==editar.estatus ? 'selected="selected"' : ''}>Activo</option>
												<option value="ELI"${ 'ELI'==editar.estatus ? 'selected="selected"' : ''}>Eliminado</option>
											</select>
										</div>
									</div>
									<div class="col-md-6">
										<div class="input-group input-group-sm mb-3">
											<label class="col-sm-4 col-form-label"
												id="inputGroup-sizing-sm">Numero de Cuenta</label> <input
												type="text" class="form-control" aria-label="Small"
												aria-describedby="inputGroup-sizing-sm" name="cuenta_act"
												value="${editar.parrafo3}">
										</div>
									</div>

									<div class="col-md-12">
										<button type="submit"
											class="btn btn-secondary text-white btn-sm float-right  ">Actualizar</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</sf:form>
	</c:if>
	<c:if test="${event=='new'}">
		<sf:form
			action="${pageContext.request.contextPath}/home/impresiones/etiquetas/save"
			method="POST" name="insert">
			<input name="evento" type="hidden" value="insert" />
			<div class="row card-row">
				<div class="col-sm-12 col-md-12 col-lg-12">
					<div class="card">
						<div class="card-body">
							<div class="form-row">
								<div class="col-md-6">
									<div class="input-group input-group-sm mb-3">
										
										<label class="col-sm-4 col-form-label"
												id="inputGroup-sizing-sm">Clave</label>
										<input type="text" class="form-control" aria-label="Small"
											aria-describedby="inputGroup-sizing-sm" name="clave">
									</div>
								</div>
								<div class="col-md-6">
									<div class="input-group input-group-sm mb-3">
										
										<label class="col-sm-4 col-form-label"
												id="inputGroup-sizing-sm">Descripcion</label>
										<input type="text" class="form-control" aria-label="Small"
											aria-describedby="inputGroup-sizing-sm" name="descripcion">
									</div>
								</div>
								<div class="col-md-6">
									<div class="input-group input-group-sm mb-3">
										
										<label class="col-sm-4 col-form-label"
												id="inputGroup-sizing-sm">Autor</label>
										<input type="text" class="form-control" aria-label="Small"
											aria-describedby="inputGroup-sizing-sm" name="autor">
									</div>
								</div>
								<div class="col-md-6">
									<div class="input-group input-group-sm mb-3">
										<label class="col-sm-4 col-form-label"
												id="inputGroup-sizing-sm">No de Cuenta</label>
										<input type="text" class="form-control" aria-label="Small"
											aria-describedby="inputGroup-sizing-sm" name="cuenta" value="No de Cuenta: ">
									</div>
								</div>
								<div class="col-md-12">
									<button type="submit"
										class="btn btn-secondary text-white btn-sm float-right  ">Guardar</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</sf:form>
	</c:if>
</div>
<%@ include file="../layout/footer.jsp"%>
