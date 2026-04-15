<%@ include file="../../layout/header.jsp"%>
<%@ include file="../../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<div class="card-header">
					<span class="title" id="menu-toggle">Mantener Estructura de Datos</span> <span class="float-right text-secondary" id="btn-ocultar">Ocultar</span>
					<sf:form action="${pageContext.request.contextPath}/home/cat/estructuraDatos/crud" method="POST" name="new" id="nuevoElemento">
						<input name="event" type="hidden" value="new" />
						<button type="submit" class="btn-link float-right border-0 text-secondary">Agregar Estructura</button>
					</sf:form>
				</div>
				<sf:form action="${pageContext.request.contextPath}/home/cat/estructuraDatos/consulta" method="POST" autocomplete="off">
					<div id="mainMenu" class="collapse show card-body">
						<div class="form-row">
							<%-- inputs --%>
							<div class="form-group col-md-3">
								<label for="inputEmail4 ">Fuente de Adquisición</label> <select class="form-control form-control-sm" name="id_fuente">
									<option value="0">Opción</option>
									<c:forEach items="${listaFuentes}" var="fuente">
										<option value="<c:out value="${fuente.id_fuente}"></c:out>"><c:out value="${fuente.clave}"></c:out></option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group col-md-3">
								<label for="inputEmail4 ">Estatus</label> <select class="form-control form-control-sm" name="estatus">
									<option>Seleccione una opcion</option>
									<option value="ACT">Activo</option>
									<option valur="ELI">Eliminado</option>
								</select>
							</div>
							<div class="form-group col-md-6 d-flex flex-row-reverse">
								<button type="submit" class="btn btn-secondary text-white btn-sm float-right bordered  mb-1 mt-auto">Consultar</button>
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
									<th>Fuente de Adquisición</th>
									<th>Tabla Temporal</th>
									<th>Tabla Totales</th>
									<th>Estatus</th>
									<th>Fecha Última Modificación</th>
									<th>Editar</th>
									<th>Eliminar</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${consulta}" var="consulta">
									<tr>
										<td><c:out value="${consulta.clave}"></c:out></td>
										<td><c:out value="${consulta.tabla_temporal}"></c:out></td>
										<td><c:out value="${consulta.tabla_totales}"></c:out></td>
										<td><c:out value="${consulta.estatus}"></c:out></td>
										<td><c:out value="${consulta.fecha_mod}"></c:out></td>
										<td><sf:form action="${pageContext.request.contextPath}/home/cat/estructuraDatos/crud" method="POST" name="crud" class="text-center">
												<input name="id_estructura" type="hidden" value="${consulta.id_estructura}" />
												<input name="event" type="hidden" value="edit" />
												<button type="submit" class="btn btn-secondary text-white btn-sm  btn-table ">
													<span class="icon-brush"></span>
												</button>
											</sf:form></td>
										<td><sf:form action="${pageContext.request.contextPath}/home/cat/estructuraDatos/crud" method="POST" name="crud" class="text-center">
												<input name="id_estructura" type="hidden" value="${consulta.id_estructura}" />
												<input name="event" type="hidden" value="delete" />
												<button type="submit" class="btn btn-secondary text-white btn-sm btn-table ">
													<span class="icon-delete"></span>
												</button>
											</sf:form></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</c:if>
		</div>
	</div>
</div>
<%@ include file="../../layout/footer.jsp"%>
