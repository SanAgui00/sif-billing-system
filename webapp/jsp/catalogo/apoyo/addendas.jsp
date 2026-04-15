<%@ include file="../../layout/header.jsp"%>
<%@ include file="../../layout/menu.jsp"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<div class="card-header">
					<span class="title">Catálogo de Addendas</span> <span
						class="float-right text-secondary" id="btn-ocultar">Ocultar</span>
					<sf:form
						action="${pageContext.request.contextPath}/home/cat/apoyo/addendas/crud"
						method="POST" name="new" id="nuevoElemento">
						<input name="event" type="hidden" value="new" />
						<button type="submit"
							class="btn-link float-right border-0 text-secondary">Nueva
							Addenda</button>
					</sf:form>
				</div>
				<sf:form
					action="${pageContext.request.contextPath}/home/cat/apoyo/addendas/consulta"
					method="POST" autocomplete="off">
					<div id="mainMenu" class="collapse show card-body">
						<div class="form-row mt-2">
							<div class="form-group col-md-3">
								<label>Addendas:</label> <select
									class="form-control form-control-sm" name="id">
									<option value="">Selecciona la addenda</option>
									<c:forEach items="${listaAddendas}" var="listaAddenda">
										<option value="${listaAddenda.id}">
											<c:out value="${listaAddenda.valor}"></c:out>-
											<c:out value="${listaAddenda.addenda}"></c:out>
										</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group col-md-3">
								<label>Estatus:</label> <select
									class="form-control form-control-sm" name="estatus">
									<option value="empty">Selecciona el estatus</option>
									<option value="ACT">Activo</option>
									<option value="ELI">No Activo</option>
								</select>
							</div>
							<div class="form-group col-md-2 d-flex flex-row-reverse">
								<button type="submit"
									class="btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Consultar</button>
							</div>
						</div>
					</div>
				</sf:form>
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
									<th scope="col">Clave</th>
									<th scope="col">Nombre</th>
									<th scope="col">Estatus</th>
									<th scope="col">Fecha</th>
									<th scope="col">Usuario</th>
									<th scope="col" class="text-center">Editar</th>
									<th scope="col" class="text-center">Eliminar</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${consulta}" var="consulta">
									<tr>
										<td><c:out value="${consulta.valor}"></c:out></td>
										<td><c:out value="${consulta.addenda}"></c:out></td>
										<td class="max-width-150"><c:out
												value="${consulta.estatus}"></c:out></td>
										<td><c:out value="${consulta.fecha}"></c:out></td>
										<td><c:out value="${consulta.usuario}"></c:out></td>
										<td><sf:form
												action="${pageContext.request.contextPath}/home/cat/apoyo/addendas/crud"
												method="POST" name="crud" class="text-center">
												<input name="id" type="hidden" value="${consulta.id}" />
												<input name="event" type="hidden" value="edit" />
												<button type="submit"
													class="btn btn-secondary text-white btn-sm btn-table">
													<span class="icon-brush"></span>
												</button>
											</sf:form></td>
										<td><sf:form
												action="${pageContext.request.contextPath}/home/cat/apoyo/addendas/crud"
												method="POST" name="crud" class="text-center">
												<input name="id" type="hidden" value="${consulta.id}" />
												<input name="event" type="hidden" value="delete" />
												<button type="submit"
													class="btn btn-secondary text-white btn-sm btn-table">
													<span class="icon-delete"></span>
												</button>
											</sf:form></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<c:if test="${not empty registros_totales}">
					<sf:form
						action="${pageContext.request.contextPath}/home/cat/apoyo/addendas/consulta"
						method="POST" name="pagination">
						<input type="hidden" name="registros_totales"
							id="registros_totales" class="registros_totales"
							value="${registros_totales}">
						<input type="hidden" name="fromRow" id="fromRow" class="fromRow"
							value="">

						<nav>
							<ul class="pagination  pagination-sm justify-content-end">
								<span class='page-link prev'><span
									class="icon-arrow_back"></span></span>
								<span
									class='pagination-container d-inline-block" id="pagination-container'></span>
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