<%@ include file="../../layout/header.jsp"%>
<%@ include file="../../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<div class="card-header">
					<span class="title" id="menu-toggle">Mantenimiento de
						Clientes en Servicios</span> <span class="float-right text-secondary"
						id="btn-ocultar">Ocultar</span>
				</div>
				<sf:form
					action="${pageContext.request.contextPath}/home/cat/apoyo/clientes/consulta"
					method="POST" autocomplete="off">
					<div class="tab-content" id="mainMenu">
						<div class="tab-pane show active" id="tab1" role="tabpanel"
							aria-labelledby="tab-1">
							<%-- MENU1 --%>
							<%-- MENU1 --%>
							<div class="card-body pb-0">
								<div class="row">
									<div class="col-sm-8 col-md-8">
										<div class="form-group row">
											<label class="col-sm-2 col-form-label">Servicio</label>
											<div class="col-sm-10">
												<select class="form-control form-control-sm"
													name="listaClienteEnServicio" id="listaClienteEnServicio">
													<c:forEach items="${listaClienteEnServicio}" var="lista">
														<option value="<c:out value="${lista.clave}"> </c:out>"
															${lista.clave eq listaClienteEnServicioModelo ? 'selected="selected"':''}>
															<c:out value="${lista.clave}">
															</c:out> -
															<c:out value="${lista.descripcion}"></c:out>
														</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
									<div class="col-sm-4 col-md-4">
										<button type="submit"
											class="btn bg-danger text-white btn-sm float-right mb-1 mt-auto">Consultar</button>
									</div>
								</div>
							</div>
							<%-- MENU1 --%>
							<%-- MENU1 --%>
						</div>
					</div>
				</sf:form>
			</div>
		</div>
		<c:if test="${not empty consulta}">
			<div class="col-sm-12">
				<div class="card mt-2">
					<div class="table-responsive">
						<table
							class="table table-scroll table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th>Servicio</th>
									<th>Descripcion</th>
									<th>Cliente</th>
									<th>Nombre</th>
									<th>Estatus</th>
									<th>Emi</th>
									<th>Adq</th>
									<th>Activar</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${consulta}" var="consulta">
									<tr>
										<td><c:out value="${consulta.clave}"></c:out></td>
										<td><c:out value="${consulta.descripcion}"></c:out></td>
										<td><c:out value="${consulta.clave_cliente}"></c:out></td>
										<td><c:out value="${consulta.descripcion_cliente}"></c:out></td>
										<td><c:out
												value="${consulta.estatus eq 'ACT' ? 'Activo':'No Activo'}"></c:out></td>
										<td><div class="form-check">
												<input class="form-check-input position-static"
													type="checkbox"
													${consulta.inclusion_emi eq 'S' ? 'checked="checked"':''}>
											</div></td>
										<td><div class="form-check">
												<input class="form-check-input position-static"
													type="checkbox"
													${consulta.inclusion_adq eq 'S' ? 'checked="checked"':''}>
											</div></td>
										<td><div class="form-check">
												<input class="form-check-input position-static"
													type="checkbox">
											</div></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<c:if test="${not empty registros_totales}">
					<sf:form
						action="${pageContext.request.contextPath}/home/cat/apoyo/clientes/consulta"
						method="POST" name="pagination">

						<input type="hidden" name="listaClienteEnServicio"
							id="getlistaClienteEnServicio" class="globalGet">
						<input type="hidden" name="registros_totales"
							id="registros_totales" class="registros_totales"
							value="${registros_totales}">
						<input type="hidden" name="fromRow" id="fromRow" class="fromRow"
							value="">

						<nav>
							<ul class="pagination  pagination-sm justify-content-end mb-2">
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
			<sf:form
				action="${pageContext.request.contextPath}/home/cat/apoyo/clientes/save"
				method="POST" autocomplete="off">
				<input type="hidden" name="listaClienteEnServicio"
							id="reporteParamlistaClienteEnServicio" class="globalGetReport">
				<div class="col-sm-12">
					<div class="card">
						
						<div class="card-header">Agregar cliente</div>
						<div class="collapse show card-body pb-1">
							<div class="row">
								<div class="col-sm-6 col-md-6 mt-2">
									<div class="form-group row">
										<label class="col-sm-3 col-form-label">Selecciona un
											Cliente</label>
										<div class="col-sm-9">
											<select class="form-control form-control-sm"
												name="listaClienteServicio" id="listaClienteServicio">
												<c:forEach items="${listaClienteServicio}" var="lista">
													<option
														value="<c:out value="${lista.clave_cliente}"> </c:out>">
														<c:out value="${lista.clave_cliente}">
														</c:out> -
														<c:out value="${lista.descripcion_cliente}"></c:out>
													</option>
												</c:forEach>
											</select>
										</div>
									</div>
								</div>
								<div class="col-sm-6 col-md-6 mt-2">
									<div class="col-sm-12">
										<div class="form-group row float-right">
											<button type="button"
												class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto"
												id="btnGuardarTodo">Confirmar Cliente</button>
											<button type="submit"
												class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto ml-3"
												id="btnAsignar">Agregar Cliente</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</sf:form>
		</c:if>
		<c:if test="${registros_totales eq 0}">
			<div class="col-sm-12 col-md-12 col-lg-12">
				<div class="alert alert-warning alert-dismissible fade show mt-2"
					role="alert">
					<strong>No se han encontrado resultados para tu búsqueda.</strong>
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</div>
		</c:if>
	</div>
</div>
<%@ include file="../../layout/footer.jsp"%>