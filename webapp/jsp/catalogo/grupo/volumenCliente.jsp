<%@ include file="../../layout/header.jsp"%>
<%@ include file="../../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<div class="card-header">
					<span class="title" id="menu-toggle">Consulta de Grupos
						Volumen Clientes</span> <span class="float-right text-secondary"
						id="btn-ocultar">Ocultar</span>
					<sf:form action="${pageContext.request.contextPath}/home/cat/grupo/volumenCliente/crud"
						method="POST" name="new" id="nuevoElemento">
						<input name="event" type="hidden" value="new" />
						<button type="submit"
							class="btn-link float-right border-0 text-secondary">Nuevo</button>
					</sf:form>
				</div>
				<sf:form
					action="${pageContext.request.contextPath}/home/cat/grupo/volumenCliente"
					method="POST" autocomplete="off">
					<div id="mainMenu" class="collapse show card-body pb-0 pt-0">
						<div class="row">
							<div class="col-sm-6 col-md-6 mt-2">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Grupos Volumen
										Clientes</label>
									<div class="col-sm-8">
										<select class=" form-control form-control-sm" name="idGrupo"
											id="idGrupo">
											<option value="">Selecciona una opcion</option>
											<c:forEach items="${listaGrupoCliente}" var="lista">
												<option value="<c:out value="${lista.id_grupo}"></c:out>"
													${ lista.id_grupo==idGrupo ? 'selected="selected"' : ''}>
													<c:out value="${lista.clave}"></c:out>
												</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-6 mt-2">
								<div class="form-group row">
									<div class="col-md-12">
										<button type="submit"
											class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto">Consultar</button>
									</div>
								</div>
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
									<th>Clave</th>
									<th>Descripción del Grupo</th>
									<th>Fecha de Modificación</th>
									<th>Editar</th>
									<th>Eliminar</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${consulta}" var="consulta">
									<tr>
										<td><c:out value="${consulta.clave}"></c:out></td>
										<td><c:out value="${consulta.descripcion}"></c:out></td>
										<td><c:out value="${consulta.fecha_mod}"></c:out></td>
										<td><sf:form
												action="${pageContext.request.contextPath}/home/cat/grupo/volumenCliente/crud"
												method="POST" name="crud" class="text-center">
												<input name="idGrupo" type="hidden"
													value="${consulta.id_grupo}" />
												<input name="event" type="hidden" value="edit" />
												<button type="submit"
													class="btn btn-secondary text-white btn-sm btn-table ">
													<span class="icon-brush"></span>
												</button>
											</sf:form></td>
										<td><sf:form
												action="${pageContext.request.contextPath}/home/cat/grupo/volumenCliente/crud"
												method="POST" name="crud" class="text-center">
												<input name="idGrupo" type="hidden"
													value="${consulta.id_grupo}" />
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
						action="${pageContext.request.contextPath}/home/cat/grupo/volumenCliente"
						method="POST" name="pagination">
						<%-- 						VARIABLES OBTENIDAS MEDIANTE JS --%>
						<input type="hidden" name="idGrupo" id="getidGrupo"
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
<%@ include file="../../layout/footer.jsp"%>