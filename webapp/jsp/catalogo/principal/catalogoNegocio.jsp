<%@ include file="../../layout/header.jsp"%>
<%@ include file="../../layout/menu.jsp"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<div class="card-header">
					<span class="title" id="menu-toggle">Catálogo de Negocios</span> <span class="float-right text-secondary" id="btn-ocultar">Ocultar</span>
					<sf:form action="${pageContext.request.contextPath}/home/cat/principal/negocio/crud" method="POST" name="new" id="nuevoElemento">
						<input name="event" type="hidden" value="new" />
						<button type="submit" class="btn-link float-right border-0 text-secondary">Nuevo Negocio</button>
					</sf:form>
				</div>
				<sf:form action="${pageContext.request.contextPath}/home/cat/principal/negocio/consulta" method="POST" autocomplete="off">
					<div id="mainMenu" class="collapse show card-body">
						<div class="form-row">
							<%-- inputs --%>
							<div class="form-group col-md-4">
								<label>Negocio</label> <select class="form-control form-control-sm" name="idNegocio">
									<c:forEach items="${listaNegocios}" var="lista">
										<option value="<c:out value="${lista.id_negocio}"> </c:out>">
											<c:out value="${lista.clave}"></c:out></option>
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
									<%-- 										<th scope="col">Proceso</th> --%>
									<th scope="col">Negocio/Padre</th>
									<th scope="col">Fecha Última modificación</th>
									<th scope="col" class="text-center">Editar</th>
									<th scope="col" class="text-center">Eliminar</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${consulta}" var="consulta">
									<tr>
										<td><c:out value="${consulta.clave}"></c:out></td>
										<td><c:out value="${consulta.descripcion}"></c:out></td>
										<td><c:out value="${consulta.id_negocio_padre}"></c:out></td>
										<td><c:out value="${consulta.fecha_mod}"></c:out></td>
										<td><sf:form action="${pageContext.request.contextPath}/home/cat/principal/negocio/crud" method="POST" name="crud" class="text-center">
												<input name="idNegocio" type="hidden" value="${consulta.id_negocio}" />
												<input name="event" type="hidden" value="edit" />
												<button type="submit" class="btn btn-secondary text-white btn-sm btn-table">
													<span class="icon-brush"></span>
												</button>
											</sf:form></td>
										<td><sf:form action="${pageContext.request.contextPath}/home/cat/principal/negocio/crud" method="POST" name="crud" class="text-center">
												<input name="idNegocio" type="hidden" value="${consulta.id_negocio}" />
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
					<sf:form action="${pageContext.request.contextPath}/home/cat/principal/negocio/consulta" method="POST" name="pagination">
						<%-- 						VARIABLES OBTENIDAS MEDIANTE JS --%>
						<input type="hidden" name="fuentes" id="getfuentes" class="globalGet">
						<input type="hidden" name="estatus" id="getestatus" class="globalGet">
						<input type="hidden" name="fecha_inicial" id="getfecha_inicial" class="globalGet">
						<input type="hidden" name="fecha_final" id="getfecha_final" class="globalGet">
						<input type="hidden" name="registros_totales" id="registros_totales" class="registros_totales" value="${registros_totales}">
						<input type="hidden" name="fromRow" id="fromRow" class="fromRow" value="">
						
						<nav>
							<ul class="pagination  pagination-sm justify-content-end">
								<span class='page-link prev'><span class="icon-arrow_back"></span></span>
								<span class="pagination-container d-inline-block" id="pagination-container"></span>
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