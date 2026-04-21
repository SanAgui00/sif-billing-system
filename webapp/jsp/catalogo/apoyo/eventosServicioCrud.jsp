<%@ include file="../../layout/header.jsp"%>
<%@ include file="../../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="card mt-2 general-title">
		<div class="card-body">
			<div class="form-row h-100">
				<div class="form-group col-md-6 auto the-title">
					<c:if test="${not empty consulta}">
						<c:forEach items="${consulta}" var="consulta">
							<c:if test="${event=='edit'}">
								<span class="title">Editando a <c:out value="${consulta.descripcion}"></c:out></span>
							</c:if>
							<c:if test="${event=='delete'}">
								<span class="title">¿Quiere eliminar a <c:out value="${consulta.descripcion}"></c:out> ?
								</span>
							</c:if>
						</c:forEach>
					</c:if>
				</div>
				<div class="form-group col-md-6 auto">
					<c:if test="${event=='delete'}">
						<sf:form action="${pageContext.request.contextPath}/home/cat/apoyo/eventos/save" method="POST" name="insert">
							<c:forEach items="${consulta}" var="consulta">
								<input name="evento" type="hidden" value="delete" />
								<input name="id" type="hidden" value="${consulta.id}" />
								<button type="submit" class="btn btn-secondary text-white btn-sm float-right ">Eliminar</button>
							</c:forEach>
						</sf:form>
					</c:if>
					<a class="btn btn-secondary text-white btn-sm float-right " href="<c:url value='/home/cat/apoyo/eventos'/>" role="button">Regresar</a>
				</div>
			</div>
		</div>
	</div>
	<c:if test="${event=='edit' && not empty consulta}">
		<sf:form action="${pageContext.request.contextPath}/home/cat/apoyo/eventos/save" method="POST" name="insert">
			<c:forEach items="${consulta}" var="consulta">
				<input name="evento" type="hidden" value="update" />
				<input name="id" type="hidden" value="${consulta.id}" />
				<div class="row card-row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="card">
							<div class="card-body">
								<div class="form-row">
									<div class="col-md-6">
										<div class="input-group input-group-sm mb-3">
											<div class="input-group-prepend">
												<span class="input-group-text" id="inputGroup-sizing-sm">Codigo de evento</span>
											</div>
											<input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="codigo" value="${consulta.codigo}">
										</div>
									</div>
									<div class="col-md-6">
										<div class="input-group input-group-sm mb-3">
											<div class="input-group-prepend">
												<span class="input-group-text" id="inputGroup-sizing-sm">Clave de concepto</span>
											</div>
											<input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="clave" value="${consulta.clave}">
										</div>
									</div>
									<div class="col-md-6">
										<div class="input-group input-group-sm mb-3">
											<div class="input-group-prepend">
												<span class="input-group-text" id="inputGroup-sizing-sm">Descripción</span>
											</div>
											<input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="descripcion" value="${consulta.descripcion}">
										</div>
									</div>
									<div class="col-md-6">
										<div class="input-group input-group-sm mb-3">
											<div class="input-group-prepend">
												<span class="input-group-text" id="inputGroup-sizing-sm">Emisor/Adquirente</span>
											</div>
											<input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="b_adq_emi" value="${consulta.b_adq_emi}">
										</div>
									</div>
									<div class="col-md-12">
										<div class="input-group input-group-sm mb-3">
											<div class="input-group-prepend">
												<span class="input-group-text" id="inputGroup-sizing-sm">Servicio</span>
											</div>
											<input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="id_servicios" value="${consulta.id_servicios}">
										</div>
									</div>
									<div class="col-md-4">
										<div class="input-group input-group-sm mb-3">
											<div class="input-group-prepend">
												<span class="input-group-text" id="inputGroup-sizing-sm">Origen</span>
											</div>
											<input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="origen" value="${consulta.origen}">
										</div>
									</div>
									<div class="col-md-4">
										<div class="input-group input-group-sm mb-3">
											<div class="input-group-prepend">
												<span class="input-group-text" id="inputGroup-sizing-sm">Estatus</span>
											</div>
											<input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="estatus" value="${consulta.estatus}">
										</div>
									</div>
									<div class="col-md-4">
										<div class="input-group input-group-sm mb-3">
											<div class="input-group-prepend">
												<span class="input-group-text" id="inputGroup-sizing-sm">Usuario</span>
											</div>
											<input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="usuario" value="${consulta.usuario}">
										</div>
									</div>
									<div class="col-md-12">
										<button type="submit" class="btn btn-secondary text-white btn-sm float-right  ">Actualizar</button>
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
		<sf:form action="${pageContext.request.contextPath}/home/cat/apoyo/eventos/save" method="POST" name="insert">
			<input name="evento" type="hidden" value="insert" />
			<div class="row card-row">
				<div class="col-sm-12 col-md-12 col-lg-12">
					<div class="card">
						<div class="card-body">
							<div class="form-row">
								<div class="col-md-6">
									<div class="input-group input-group-sm mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm">Codigo de evento</span>
										</div>
										<input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="codigo">
									</div>
								</div>
								<div class="col-md-6">
									<div class="input-group input-group-sm mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm">Clave de concepto</span>
										</div>
										<input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="clave">
									</div>
								</div>
								<div class="col-md-6">
									<div class="input-group input-group-sm mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm">Descripción</span>
										</div>
										<input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="descripcion">
									</div>
								</div>
								<div class="col-md-6">
									<div class="input-group input-group-sm mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm">Emisor/Adquirente</span>
										</div>
										<input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="b_adq_emi">
									</div>
								</div>
								<div class="col-md-12">
									<div class="input-group input-group-sm mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm">Servicio</span>
										</div>
										<input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="id_servicios">
									</div>
								</div>
								<div class="col-md-4">
									<div class="input-group input-group-sm mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm">Origen</span>
										</div>
										<input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="origen">
									</div>
								</div>
								<div class="col-md-4">
									<div class="input-group input-group-sm mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm">Estatus</span>
										</div>
										<input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="estatus">
									</div>
								</div>
								<div class="col-md-4">
									<div class="input-group input-group-sm mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm">Usuario</span>
										</div>
										<input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="usuario">
									</div>
								</div>
								<div class="col-md-12">
									<button type="submit" class="btn btn-secondary text-white btn-sm float-right  ">Guardar</button>
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
