<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<div class="card-header">
					<span class="title" id="menu-toggle">Parametrizar Carga Datos</span> <span class="float-right text-secondary" id="btn-ocultar">Ocultar</span>
					<sf:form action="${pageContext.request.contextPath}/home/param/carga/crud" method="POST" name="new" id="nuevoElemento">
						<input name="event" type="hidden" value="new" />
						<button type="submit" class="btn-link float-right border-0 text-secondary">Agregar Carga</button>
					</sf:form>
				</div>
				<sf:form action="${pageContext.request.contextPath}/home/param/carga/consulta" method="POST" autocomplete="off">
					<div id="mainMenu" class="collapse show card-body">
						<div class="form-row">
							<%-- inputs --%>
							<div class="form-group col-md-3">
								<label for="inputEmail4 ">Fuente de Adquisición</label> <select class="form-control form-control-sm" name="id_reglas_carga">
									<option value="0">Opción</option>
									<c:forEach items="${listaFuentes}" var="fuente">
										<option value="<c:out value="${fuente.id_fuente}"></c:out>"><c:out value="${fuente.clave}"></c:out></option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group col-md-9 d-flex flex-row-reverse">
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
									<th>Fecha Últ. Modificación</th>
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
										<td><c:out value="${consulta.tabla_temporal}"></c:out></td>
										<td><c:out value="${consulta.fecha_mod}"></c:out></td>
										<td><c:out value="${consulta.estatus}"></c:out></td>
										<td><c:out value="${consulta.usuario}"></c:out></td>
										<td><sf:form action="${pageContext.request.contextPath}/home/param/carga/crud" method="POST" name="crud" class="text-center">
												<input name="id_reglas_carga" type="hidden" value="${consulta.id_reglas_carga}" />
												<input name="event" type="hidden" value="edit" />
												<button type="submit" class="btn btn-secondary text-white btn-sm  btn-table ">
													<span class="icon-brush"></span>
												</button>
											</sf:form></td>
										<td><sf:form action="${pageContext.request.contextPath}/home/param/carga/crud" method="POST" name="crud" class="text-center">
												<input name="id_reglas_carga" type="hidden" value="${consulta.id_reglas_carga}" />
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
					<sf:form action="${pageContext.request.contextPath}/home/param/carga/consulta" method="POST" name="pagination">
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
