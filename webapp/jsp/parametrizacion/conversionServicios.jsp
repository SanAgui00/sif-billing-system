<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<div class="card-header">
					<span class="title" id="menu-toggle">Adquisición y Conversión de Servicios</span> <span class="float-right text-secondary" id="btn-ocultar">Ocultar</span>
					<sf:form action="${pageContext.request.contextPath}/home/param/conversion/crud" method="POST" name="new" id="nuevoElemento">
						<input name="event" type="hidden" value="new" />
						<button type="submit" class="btn-link float-right border-0 text-secondary">Agregar Conversión</button>
					</sf:form>
				</div>
				<sf:form action="${pageContext.request.contextPath}/home/param/conversion" method="POST" autocomplete="off">
					<div id="mainMenu" class="collapse show card-body">
						<div class="form-row">
							<%-- inputs --%>
							<div class="form-group col-md-3">
								<label for="inputEmail4 ">Fuente</label> <select class="form-control form-control-sm" name="fuente">
									<option value="0">Opción</option>
									<c:forEach items="${listaFuentes}" var="fuente">
										<option value="<c:out value="${fuente.id_fuente}"></c:out>"><c:out value="${fuente.clave}"></c:out></option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group col-md-3">
								<label for="inputEmail4 ">Estatus</label> <select class="form-control form-control-sm" name="estatus">
									<option value="empty">Opción</option>
									<option value="PAP">Pendiente por aprobar</option>
									<option value="PEL">Pendiente por eliminar</option>
									<option value="ACT">Aprobado</option>
									<option value="ELI">Eliminado</option>
								</select> </select>
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
									<th>Clave de Servicio</th>
									<th>Descripción del Servicio</th>
									<th>Fecha de Última Modificación</th>
									<th>Estatus</th>
									<th>Usuario</th>
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
										<td><c:out value="${consulta.estatus}"></c:out></td>
										<td><c:out value="${consulta.usuario}"></c:out></td>
										<td><sf:form action="${pageContext.request.contextPath}/home/param/conversion/crud" method="POST" name="crud" class="text-center">
												<input name="regla_conv_id" type="hidden" value="${consulta.regla_conv_id}" />
												<input name="servicio_id" type="hidden" value="${consulta.servicio_id}" />
												<input name="event" type="hidden" value="edit" />
												<button type="submit" class="btn btn-secondary text-white btn-sm  btn-table ">
													<span class="icon-brush"></span>
												</button>
											</sf:form></td>
										<td><sf:form action="${pageContext.request.contextPath}/home/param/conversion/crud" method="POST" name="crud" class="text-center">
												<input name="regla_conv_id" type="hidden" value="${consulta.regla_conv_id}" />
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
				<c:if test="${not empty registros_totales}">
					<sf:form action="${pageContext.request.contextPath}/home/param/conversion" method="POST" name="pagination">
						<%-- 						VARIABLES OBTENIDAS MEDIANTE JS --%>
						<input type="hidden" name="fuentes" id="getfuentes" class="globalGet">
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
<%@ include file="../layout/footer.jsp"%>
