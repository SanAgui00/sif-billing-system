<%@ include file="../../layout/header.jsp"%>
<%@ include file="../../layout/menu.jsp"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<div class="card-header">
					<span class="title">Catálogo de Eventos por Servicio</span> <span class="float-right text-secondary" id="btn-ocultar">Ocultar</span>
					<sf:form action="${pageContext.request.contextPath}/home/cat/apoyo/eventos/crud" method="POST" name="new" id="nuevoElemento">
						<input name="event" type="hidden" value="new" />
						<button type="submit" class="btn-link float-right border-0 text-secondary">Nuevo Evento</button>
					</sf:form>
				</div>
				<sf:form action="${pageContext.request.contextPath}/home/cat/apoyo/eventos/consulta" method="POST" name="eventos" autocomplete="off">
					<div id="mainMenu" class="collapse show card-body">
						<div class="form-row mt-2">
							<div class="form-group col-md-6">
								<label>Servicio:</label> <select class="form-control form-control-sm" name="id">
									<option value="0">Selecciona un servicio</option>
									<c:forEach items="${listaJoinServicios}" var="listaJoinServicios">
										<option value="<c:out value="${listaJoinServicios.tbl_sif_servicios.id_servicios}"> </c:out>">
											<c:out value="${listaJoinServicios.tbl_sif_servicios.clave}"></c:out> --
											<c:out value="${listaJoinServicios.descripcion}"></c:out></option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group col-md-2">
								<label>Evento:</label> <select class="form-control form-control-sm" name="evento">
									<option value="">Selecciona un evento</option>
									<c:forEach items="${listaDistinctServicios}" var="listaDistinctServicios">
										<option value="${listaDistinctServicios.id}"><c:out value="${listaDistinctServicios.id}"></c:out> --
											<c:out value="${listaDistinctServicios.codigo}"></c:out></option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group col-md-2">
								<label>Estatus:</label> <select class="form-control form-control-sm" name="estatus">
									<option value="ACT">Activo</option>
									<option value="ELI">Eliminado</option>
								</select>
							</div>
							<div class="form-group col-md-2 d-flex flex-row-reverse">
								<button type="submit" class="btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Consultar</button>
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
						<table class="table table-scroll table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th scope="col">Concepto</th>
									<th scope="col">Código de evento</th>
									<th scope="col">Código de concepto</th>
									<th scope="col">Servicio</th>
									<th scope="col">Fecha</th>
									<th scope="col" class="text-center">Editar</th>
									<th scope="col" class="text-center">Eliminar</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${consulta}" var="consulta">
									<tr>
										<td><c:out value="${consulta.descripcion}"></c:out></td>
										<td><c:out value="${consulta.codigo}"></c:out></td>
										<td><c:out value="${consulta.clave}"></c:out></td>
										<td><c:out value="${consulta.tbl_sif_servicios.clave}"></c:out></td>
										<td><c:out value="${consulta.fecha}"></c:out></td>
										<td><sf:form action="${pageContext.request.contextPath}/home/cat/apoyo/eventos/crud" method="POST" name="crud" class="text-center">
												<input name="id" type="hidden" value="${consulta.id}" />
												<input name="event" type="hidden" value="edit" />
												<button type="submit" class="btn btn-secondary text-white btn-sm btn-table">
													<span class="icon-brush"></span>
												</button>
											</sf:form></td>
										<td><sf:form action="${pageContext.request.contextPath}/home/cat/apoyo/eventos/crud" method="POST" name="crud" class="text-center">
												<input name="id" type="hidden" value="${consulta.id}" />
												<input name="event" type="hidden" value="delete" />
												<button type="submit" class="btn btn-secondary text-white btn-sm btn-table">
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
					<sf:form action="${pageContext.request.contextPath}/home/cat/apoyo/eventos" method="POST" name="pagination">
						<input type="hidden" name="registros_totales" id="registros_totales" class="registros_totales" value="${registros_totales}">
						<input type="hidden" name="fromRow" id="fromRow" class="fromRow" value="">
						
						<nav>
							<ul class="pagination  pagination-sm justify-content-end">
								<span class='page-link prev'><span class="icon-arrow_back"></span></span>
								<span class='pagination-container d-inline-block" id="pagination-container'></span>
								<span class='page-link next'><span class="icon-arrow_forward"></span></span>
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