<%@ include file="../../layout/header.jsp"%>
<%@ include file="../../layout/menu.jsp"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<div class="card-header">
					<span class="title">Catálogo de Centro Costos</span> <span class="float-right text-secondary" id="btn-ocultar">Ocultar</span>
					<sf:form action="${pageContext.request.contextPath}/home/cat/apoyo/centrocostos/crud" method="POST" name="new" id="nuevoElemento">
						<input name="event" type="hidden" value="new" />
						<button type="submit" class="btn-link float-right border-0 text-secondary">Nuevo Centro Costos</button>
					</sf:form>
				</div>
				<sf:form action="${pageContext.request.contextPath}/home/cat/apoyo/centrocostos/consulta" method="POST" autocomplete="off">
					<div id="mainMenu" class="collapse show card-body">
						<div class="form-row mt-2">
							<div class="form-group col-md-4 ">
								<label>Centro de costos</label> <select class="form-control form-control-sm" name="centro_costos">
									<c:forEach items="${listaCentroCosto}" var="lista">
										<option value="<c:out value=" ${lista.id_centro_costos} "> </c:out>">
											<c:out value="${lista.descripcion}"></c:out>
										</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group col-md-8 d-flex flex-row-reverse">
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
									<th scope="col">Clave</th>
									<th scope="col">Descripción</th>
									<th scope="col">Fecha Última modificación</th>
									<th scope="col" class="text-center">Editar</th>
									<th scope="col" class="text-center">Eliminar</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${consulta}" var="consulta">
									<tr>
										<td><c:out value="${consulta.clave_centro_costos}"></c:out></td>
										<td><c:out value="${consulta.descripcion}"></c:out></td>
										<td><c:out value="${consulta.fecha_mod}"></c:out></td>
										<td><sf:form action="${pageContext.request.contextPath}/home/cat/apoyo/centrocostos/crud" method="POST" name="crud" class="text-center">
												<input name="id_centro_costos" type="hidden" value="${consulta.id_centro_costos}" />
												<input name="event" type="hidden" value="edit" />
												<button type="submit" class="btn btn-secondary text-white btn-sm btn-table">
													<span class="icon-brush"></span>
												</button>
											</sf:form></td>
										<td><sf:form action="${pageContext.request.contextPath}/home/cat/apoyo/centrocostos/crud" method="POST" name="crud" class="text-center">
												<input name="id_centro_costos" type="hidden" value="${consulta.id_centro_costos}" />
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
					<sf:form action="${pageContext.request.contextPath}/home/cat/apoyo/centrocostos/consulta" method="POST" name="pagination">
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
