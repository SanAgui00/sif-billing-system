<%@ include file="../../layout/header.jsp"%>
<%@ include file="../../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<c:if test="${event=='delete'}">
		<sf:form action="${pageContext.request.contextPath}/home/cat/apoyo/procesos/save" method="POST" name="insert">
			<div class="row">
				<div class="col-sm-12">
					<div class="card mt-1">
						<c:forEach items="${consulta}" var="consulta">
							<input name="evento" type="hidden" value="delete" />
							<input name="id_proceso" type="hidden" value="${consulta.id_proceso}" />
							<div class="card-header">
								<span class="title" id="menu-toggle">Eliminar</span> <a class="float-right text-secondary" href="<c:url value='/home/cat/apoyo/procesos'/>" role="button">Regresar</a>
							</div>
							<div id="mainMenu" class="collapse show card-body">
								<div class="row">
									<div class="col-sm-12 col-md-12  text-center">
										<h5 class="card-title">
											Está a punto de eliminar a <span class="font-weight-bold"><c:out value="${consulta.clave_proceso}"></c:out>.</span> ¿Desea continuar?
										</h5>
										<button type="submit" class="btn btn-secondary text-white btn-sm">Eliminar</button>
										<a class="btn btn-secondary text-white btn-sm" href="<c:url value='/home/cat/apoyo/procesos'/>" role="button">Regresar</a>
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
			<sf:form action="${pageContext.request.contextPath}/home/cat/apoyo/procesos/save" method="POST" name="insert">
				<div class="row">
					<div class="col-sm-12">
						<div class="card mt-1">
							<input name="evento" type="hidden" value="update" /> <input name="id_proceso" type="hidden" value="${consulta.id_proceso}" /> <input name="estatus" type="hidden" value="${consulta.estatus}" /> <input name="fecha_cre" type="hidden" value="<fmt:formatDate value="${consulta.fecha_cre}" pattern="dd/MM/yyyy"/>" /> 
							<div class="card-header">
								<span class="title" id="menu-toggle">Detalle del Proceso</span> <a class="float-right text-secondary" href="<c:url value='/home/cat/apoyo/procesos'/>" role="button">Regresar</a> <span class="float-right text-secondary pr-3" id="btn-ocultar">Ocultar</span>
							</div>
							<div id="mainMenu" class="collapse show card-body pb-0">
								<div class="row">
									<div class="col-sm-6 col-md-6 mt-2">
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Clave </label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm" value="${consulta.clave_proceso}" name="clave_proceso">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Tipo de Comprobante </label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm" value="${consulta.clave_tipocomp_sat}" name="clave_tipocomp_sat">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Empresa </label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm" value="${consulta.id_empresa}" name="id_empresa">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Servicios en Rebate </label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm" value="${consulta.b_servicios_en_rebate}" name="b_servicios_en_rebate">
											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-6 mt-2">
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Descripción</label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm" value="${consulta.descripcion}" name="descripcion">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Comentarios</label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm" placeholder="Comentarios" value="${consulta.comentarios}" name="comentarios">
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-12 mt-1">
												<button type="submit" class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto btnAppendConceptos">Guardar</button>
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
		<sf:form action="${pageContext.request.contextPath}/home/cat/apoyo/procesos/save" method="POST" name="insert">
			<input name="evento" type="hidden" value="insert" />
			<div class="row">
				<div class="col-sm-12">
					<div class="card mt-1">
						<div class="card-header">
							<span class="title" id="menu-toggle">Nuevo Proceso</span> <a class="float-right text-secondary" href="<c:url value='/home/cat/apoyo/procesos'/>" role="button">Regresar</a> <span class="float-right text-secondary pr-3" id="btn-ocultar">Ocultar</span>
						</div>
						<div id="mainMenu" class="collapse show card-body pb-0">
							<div class="row">
								<div class="col-sm-6 col-md-6 mt-2">
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Clave </label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" name="clave_proceso">
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Tipo de Comprobante </label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" name="clave_tipocomp_sat">
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Empresa </label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" name="id_empresa">
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Servicios en Rebate </label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" name="b_servicios_en_rebate">
										</div>
									</div>
								</div>
								<div class="col-sm-6 col-md-6 mt-2">
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Descripción</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" name="descripcion">
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Comentarios</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" placeholder="Comentarios" name="comentarios">
										</div>
									</div>
									<div class="form-group row">
										<div class="col-md-12 mt-1">
											<button type="submit" class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto btnAppendConceptos">Guardar</button>
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