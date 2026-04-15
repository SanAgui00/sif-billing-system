<%@ include file="../../layout/header.jsp"%>
<%@ include file="../../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<div class="card-header">
					<span class="title" id="menu-toggle">Catálogo de Clientes</span> <span
						class="float-right text-secondary" id="btn-ocultar">Ocultar</span>
					<sf:form
						action="${pageContext.request.contextPath}/home/cat/principal/cliente/crud"
						method="POST" name="new" id="nuevoElemento">
						<input name="event" type="hidden" value="new" />
						<button type="submit"
							class="btn-link float-right border-0 text-secondary">Nuevo
							Cliente</button>
					</sf:form>
				</div>
				<sf:form
					action="${pageContext.request.contextPath}/home/cat/principal/cliente/consulta"
					method="POST" autocomplete="off">
					<div id="mainMenu" class="collapse show card-body">
						<input type="hidden" name="flag" id="flag" value="0" />
						<div class="form-row">
							<div class="form-group col-md-3">
								<label>Clave del Cliente:</label> <input type="text"
									class="form-control form-control-sm"
									placeholder="Clave del cliente" name="clave_cliente"
									id="clave_cliente" value="${clave_cliente}">
							</div>
							<div class="form-group col-md-3">
								<label>Nombre Corto del Cliente:</label> <input type="text"
									class="form-control form-control-sm" placeholder="Nombre corto"
									name="nombre_corto" id="nombre_corto" value="${nombre_corto}">
							</div>
							<div class="form-group col-md-2">
								<label>Clave Grupo de Clientes:</label> <input type="text"
									class="form-control form-control-sm"
									placeholder="Clave del grupo" name="clave_grupo"
									id="clave_grupo" value="${clave_grupo}">
							</div>
							<div class="form-group col-md-2">
								<label>Estatus:</label> <select
									class="form-control form-control-sm" name="estatus"
									id="estatus">
									<option value="ACT"
										${estatus eq 'ACT' ? 'selected="selected"' : ''}>Activo</option>
									<option value="ELI"
										${estatus eq 'ELI' ? 'selected="selected"' : ''}>Eliminado</option>
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
									<th scope="col">Clave cliente</th>
									<th scope="col">Nombre corto</th>
									<th scope="col">RFC</th>
									<th scope="col">Teléfono principal</th>
									<th scope="col">Contacto factura</th>
									<th scope="col">Estatus</th>
									<th scope="col">Fecha ultima modificación</th>
									<th scope="col" class="text-center">Editar</th>
									<th scope="col" class="text-center">Eliminar</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${consulta}" var="consulta">
									<tr>
										<td><c:out value="${consulta.clave_cliente}"></c:out></td>
										<td><c:out value="${consulta.nombre_corto}"></c:out></td>
										<td><c:out value="${consulta.rfc}"></c:out></td>
										<td><c:out value="${consulta.telefono_pric}"></c:out></td>
										<td><c:out value="${consulta.id_cliente}"></c:out></td>
										<td><c:out value="${consulta.estatus}"></c:out></td>
										<td><fmt:formatDate type="both"
												value="${consulta.fecha_mod}" pattern="dd/MM/yyyy kk:mm:ss" /></td>
										<td><sf:form
												action="${pageContext.request.contextPath}/home/cat/principal/cliente/crud"
												method="POST" name="crud" class="text-center">
												<input name="id_cliente" type="hidden"
													value="${consulta.id_cliente}" />
												<input name="id_domicilio" type="hidden"
													value="${consulta.id_domicilio}" />
												<input name="event" type="hidden" value="edit" />
												<button type="submit"
													class="btn btn-secondary text-white btn-sm btn-table ">
													<span class="icon-brush"></span>
												</button>
											</sf:form></td>
										<td><sf:form
												action="${pageContext.request.contextPath}/home/cat/principal/cliente/crud"
												method="POST" name="crud" class="text-center">
												<input name="id_cliente" type="hidden"
													value="${consulta.id_cliente}" />
												<input name="id_domicilio" type="hidden"
													value="${consulta.id_domicilio}" />
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
				<div class="form-row">
					<div class="col-md-2 col-lg-2">
						<sf:form
							action="${pageContext.request.contextPath}/home/cat/principal/cliente/jasper"
							method="POST" name="fuentes" autocomplete="off">
							<input type="hidden" name="clave_cliente"
								id="reporteParamclave_cliente" class="globalGetReport">
							<input type="hidden" name="nombre_corto"
								id="reporteParamnombre_corto" class="globalGetReport">
							<input type="hidden" name="clave_grupo"
								id="reporteParamclave_grupo" class="globalGetReport">
							<input type="hidden" name="estatus" id="reporteParamestatus"
								class="globalGetReport">
							<input type="hidden" name="tipo" id="tipo">
							<button type="submit"
								class="btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto d-none"
								id="reporte">Reporte</button>
							<div role="toolbar" aria-label="Contenedor de botones"
								class="btn-toolbar float-left pagination">

								<div class="btn-group mr-2" role="group"
									aria-label="Botones de reportes">
									<button type="button"
										class="btn btn-secondary btn-sm buttonreporte" id="excel">
										<span class="mr-2">Excel</span><span class="icon-file-excel"></span>
									</button>
									<button type="button"
										class="btn btn-secondary btn-sm buttonreporte" id="pdf">
										<span class="mr-2">Pdf</span><span class="icon-file-pdf"></span>
									</button>
								</div>
								<div class="btn-group" role="group"
									aria-label="Boton de recomendacion" id="btnRecomendacion">
									<button type="button" class="btn btn-secondary btn-sm">
										<span class="icon-error_outline"></span>
									</button>
								</div>
							</div>
						</sf:form>
					</div>
					<div class="col-md-10 col-lg-10">
						<c:if test="${not empty registros_totales}">
							<sf:form
								action="${pageContext.request.contextPath}/home/cat/principal/cliente/consulta"
								method="POST" name="pagination">
								<%-- 						VARIABLES OBTENIDAS MEDIANTE JS --%>
								<input type="hidden" name="fuentes" id="getfuentes"
									class="globalGet">
								<input type="hidden" name="estatus" id="getestatus"
									class="globalGet">
								<input type="hidden" name="fecha_inicial" id="getfecha_inicial"
									class="globalGet">
								<input type="hidden" name="fecha_final" id="getfecha_final"
									class="globalGet">
								<input type="hidden" name="registros_totales"
									id="registros_totales" class="registros_totales"
									value="${registros_totales}">
								<input type="hidden" name="fromRow" id="fromRow" class="fromRow"
									value="">

								<nav>
									<ul class="pagination  pagination-sm justify-content-end">
										<span class="p-0 mr-1 page-link  page-search"><div
												class="input-group">
												<input type="text"
													class="form-control form-control-sm border-0 just-number"
													id="paginacionBuscar" placeholder="buscar página">
												<div class="input-group-prepend">
													<div class="input-group-text rounded-0">
														<span class="icon-search"></span>
													</div>
												</div>
											</div></span>
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
				</div>
			</c:if>
		</div>
	</div>
</div>
<%@ include file="../../layout/footer.jsp"%>