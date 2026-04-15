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
								<span class="title">Editando a <c:out value="${consulta.nombre_moneda}"></c:out></span>
							</c:if>
							<c:if test="${event=='delete'}">
								<span class="title">¿Quiere eliminar a <c:out value="${consulta.nombre_moneda}"></c:out> ?
								</span>
							</c:if>
						</c:forEach>
					</c:if>
				</div>
				<div class="form-group col-md-6 auto">
					<c:if test="${event=='delete'}">
						<sf:form action="${pageContext.request.contextPath}/home/cat/apoyo/moneda/save" method="POST" name="insert">
							<c:forEach items="${consulta}" var="consulta">
								<input name="evento" type="hidden" value="delete" />
								<input name="id_moneda" type="hidden" value="${consulta.id_moneda}" />
								<button type="submit" class="btn btn-secondary text-white btn-sm float-right ">Eliminar</button>
							</c:forEach>
						</sf:form>
					</c:if>
					<a class="btn btn-secondary text-white btn-sm float-right " href="<c:url value='/home/cat/apoyo/moneda'/>" role="button">Regresar</a>
				</div>
			</div>
		</div>
	</div>
	<c:if test="${event=='edit' && not empty consulta}">
		<sf:form action="${pageContext.request.contextPath}/home/cat/apoyo/moneda/save" method="POST" name="insert">
			<c:forEach items="${consulta}" var="consulta">
				<input name="evento" type="hidden" value="update" />
				<input name="id_moneda" type="hidden" value="${consulta.id_moneda}" />
				<input name="estatus" type="hidden" value="${consulta.estatus}" />
				<div class="row card-row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="card">
							<div class="card-body">
								<div class="form-row">
									<div class="col-md-4">
										<div class="input-group input-group-sm mb-3">
											<div class="input-group-prepend">
												<span class="input-group-text" id="inputGroup-sizing-sm">Moneda</span>
											</div>
											<input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="nombre_moneda" value="${consulta.nombre_moneda}">
										</div>
									</div>
									<div class="col-md-4">
										<div class="input-group input-group-sm mb-3">
											<div class="input-group-prepend">
												<span class="input-group-text" id="inputGroup-sizing-sm">Clave SAT</span>
											</div>
											<input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="clave_sat" value="${consulta.clave_sat}">
										</div>
									</div>
									<div class="col-md-4">
										<div class="input-group input-group-sm mb-3">
											<div class="input-group-prepend">
												<span class="input-group-text" id="inputGroup-sizing-sm">Nombre SAT</span>
											</div>
											<input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="nombre_sat" value="${consulta.nombre_sat}">
										</div>
									</div>
									<div class="col-md-3">
										<div class="input-group input-group-sm mb-3">
											<div class="input-group-prepend">
												<span class="input-group-text" id="inputGroup-sizing-sm">Decimales</span>
											</div>
											<input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="decimales" value="${consulta.decimales}">
										</div>
									</div>
									<div class="col-md-3">
										<div class="input-group input-group-sm mb-3">
											<div class="input-group-prepend">
												<span class="input-group-text" id="inputGroup-sizing-sm">Variación</span>
											</div>
											<input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="variacion" value="${consulta.variacion}">
										</div>
									</div>
									<div class="col-md-3">
										<div class="input-group input-group-sm mb-3">
											<div class="input-group-prepend">
												<span class="input-group-text" id="inputGroup-sizing-sm">Pais</span>
											</div>
											<input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="pais" value="${consulta.pais}">
										</div>
									</div>
									<div class="col-md-3">
										<div class="input-group input-group-sm mb-3">
											<div class="input-group-prepend">
												<span class="input-group-text" id="inputGroup-sizing-sm">Importancía de moneda</span>
											</div>
											<input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="t_moneda" value="${consulta.t_moneda}">
										</div>
									</div>
									<div class="col-md-4">
										<div class="input-group input-group-sm mb-3">
											<div class="input-group-prepend">
												<span class="input-group-text" id="inputGroup-sizing-sm">Autor últ. mod.</span>
											</div>
											<input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="usuario" value="${consulta.usuario}" disabled>
										</div>
									</div>
									<div class="col-md-4">
										<div class="input-group input-group-sm mb-3">
											<div class="input-group-prepend">
												<span class="input-group-text" id="inputGroup-sizing-sm">Fecha de creación</span>
											</div>
											<input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="fecha_crea" value="${consulta.fecha_cre}"disabled>
										</div>
									</div>
									<div class="col-md-4">
										<div class="input-group input-group-sm mb-3">
											<div class="input-group-prepend">
												<span class="input-group-text" id="inputGroup-sizing-sm">Fecha últ. mod.</span>
											</div>
											<input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="fecha_modi" value="${consulta.fecha_mod}"disabled>
										</div>
									</div>
									<div class="col-md-12">
										<div class="input-group  input-group-sm ">
											<div class="input-group-prepend">
												<span class="input-group-text">Comentarios</span>
											</div>
											<textarea class="form-control" aria-label="With textarea" name="comentarios"><c:out value="${consulta.comentarios}"></c:out> </textarea>
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
		<sf:form action="${pageContext.request.contextPath}/home/cat/apoyo/moneda/save" method="POST" name="insert">
			<input name="evento" type="hidden" value="insert" />
			<div class="row card-row">
				<div class="col-sm-12 col-md-12 col-lg-12">
					<div class="card">
						<div class="card-body">
							<div class="form-row">
								<div class="col-md-4">
									<div class="input-group input-group-sm mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm">Moneda</span>
										</div>
										<input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="nombre_moneda">
									</div>
								</div>
								<div class="col-md-4">
									<div class="input-group input-group-sm mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm">Clave SAT</span>
										</div>
										<input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="clave_sat">
									</div>
								</div>
								<div class="col-md-4">
									<div class="input-group input-group-sm mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm">Nombre SAT</span>
										</div>
										<input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="nombre_sat">
									</div>
								</div>
								<div class="col-md-3">
									<div class="input-group input-group-sm mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm">Decimales</span>
										</div>
										<input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="decimales">
									</div>
								</div>
								<div class="col-md-3">
									<div class="input-group input-group-sm mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm">Variación</span>
										</div>
										<input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="variacion">
									</div>
								</div>
								<div class="col-md-3">
									<div class="input-group input-group-sm mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm">Pais</span>
										</div>
										<input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="pais">
									</div>
								</div>
								<div class="col-md-3">
									<div class="input-group input-group-sm mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm">Importancía de moneda</span>
										</div>
										<input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="t_moneda">
									</div>
								</div>
								
								<div class="col-md-12">
									<div class="input-group  input-group-sm ">
										<div class="input-group-prepend">
											<span class="input-group-text">Comentarios</span>
										</div>
										<textarea class="form-control" aria-label="With textarea" name="comentarios"></textarea>
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
