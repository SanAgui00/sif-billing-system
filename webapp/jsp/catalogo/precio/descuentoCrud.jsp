<%@ include file="../../layout/header.jsp"%>
<%@ include file="../../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<div class="card-header">
					<span class="title" id="menu-toggle">Asignar y Aplicar
						Descuentos </span> <a class="float-right text-secondary"
						href="<c:url value='/home/cat/precio/descuento'/>" role="button">Regresar</a>
					<span class="float-right text-secondary mr-3" id="btn-ocultar">Ocultar</span>
				</div>
				<div class="tab-content" id="mainMenu">
					<div class="tab-pane  show active" id="tab1" role="tabpanel"
						aria-labelledby="tab-1">
						<input type="hidden" name="evento" value="porCliente" />
						<sf:form
							action="${pageContext.request.contextPath}/home/cat/precio/servicio/consulta"
							method="POST" autocomplete="off">
							<div class="card-body">
								<div class="row">
									<div class="col-sm-4 col-md-4 mt-2">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label">Clave </label>
											<div class="col-sm-9">
												<input type="text" id="clave_cliente"
													class="form-control form-control-sm" name="clave_cliente"
													placeholder="Clave" value="${clave_cliente}" disabled />
											</div>
										</div>
									</div>
									<div class="col-sm-4 col-md-4 mt-2">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label">Descripción </label>
											<div class="col-sm-9">
												<input type="text" id="nombre_corto"
													class="form-control form-control-sm"
													placeholder="Descripción" name="nombre_corto"
													value="${nombre_corto}" disabled />
											</div>
										</div>
									</div>
									<div class="col-sm-4 col-md-4 mt-2">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label">Descuento </label>
											<div class="col-sm-9">
												<input type="text" id="porcentaje_descuento"
													class="form-control form-control-sm"
													placeholder="porcentaje" name="porcentaje_descuento"
													value="${porcentaje_descuento}" disabled />
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
							<c:if test="${evento eq 'cliente'}">
								<thead>
									<tr>
										<th>Clave del Cliente</th>
										<th>Nombre Corto</th>
										<th>Descuento</th>
										<th class="text-center">Marcar</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${consulta}" var="lista">
										<tr>
											<td>${lista.clave}</td>
											<td>${lista.descripcion}</td>
											<td>${lista.porcentaje_descuento}</td>
											<td class="text-center"><div class="form-check">
													<input
														class="form-check-input form-check-input-asignar position-static"
														value="${lista.id_servicio}" type="checkbox">
												</div></td>
										</tr>
									</c:forEach>
								</tbody>
							</c:if>
							<c:if test="${evento eq 'servicio'}">
								<thead>
									<tr>
										<th>Clave del Cliente</th>
										<th>Nombre Corto</th>
										<th>Descuento</th>
										<th class="text-center">Marcar</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${consulta}" var="lista">
										<tr>
											<td>${lista.clave_cliente}</td>
											<td>${lista.nombre_corto}</td>
											<td>${lista.porcentaje_descuento}</td>
											<td class="text-center"><div class="form-check">
													<input
														class="form-check-input form-check-input-asignar position-static"
														type="checkbox" value="${lista.id_cliente}">
												</div></td>
										</tr>
									</c:forEach>
								</tbody>
							</c:if>
						</table>
					</div>
				</div>
				<div class="card mt-1">
					<sf:form
						action="${pageContext.request.contextPath}/home/cat/precio/save"
						method="POST" autocomplete="off">
						<div class="tab-content" id="mainMenu">
							<div class="tab-pane  show active" id="tab1" role="tabpanel"
								aria-labelledby="tab-1">
								<c:if test="${evento eq 'cliente'}">
									<input name="evento" value="porCliente" type="hidden">
									<input name="id_cliente" value="${id_cliente}" type="hidden">
								</c:if>
								<c:if test="${evento eq 'servicio'}">
									<input name="evento" value="porServicio" type="hidden">
									<input name="id_servicio" value="${id_servicio}" type="hidden">
								</c:if>
								<input name="lista" id="lista" class="lista" type="hidden">

								<div class="card-body">
									<div class="row">
										<div class="col-sm-5 col-md-5 mt-2">
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Asignar
													Descuento</label>
												<div class="col-sm-8">
													<input id="descuento"
														class="form-control form-control-sm formatearNumero100"
														name="descuento" type="text">
												</div>
											</div>
										</div>
										<div class="col-sm-5 col-md-5 mt-2">
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Comentarios </label>
												<div class="col-sm-8">
													<input id="comentarios"
														class="form-control form-control-sm" name="comentarios"
														type="text" maxlength="199">
												</div>
											</div>
										</div>
										<div class="col-sm-2 col-md-2 mt-2">
											<div class="form-group row">
												<div class="col-sm-12">
													<button type="submit"
														class="btn btn-secondary btn-sm float-right mb-1 mt-auto d-none btnEjecutar">Ejecutar</button>
													<button type="button"
														class="btn btn-secondary btn-sm float-right mb-1 mt-auto btnAplicar">Aplicar</button>
												</div>
											</div>
										</div>
									</div>
								</div>

							</div>
						</div>
					</sf:form>
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
			</c:if>
		</div>
	</div>
</div>
<script type="text/javascript"
	src='<c:url value="/js/appFacturas/operaciones.js"/>' defer="defer"></script>
<%@ include file="../../layout/footer.jsp"%>