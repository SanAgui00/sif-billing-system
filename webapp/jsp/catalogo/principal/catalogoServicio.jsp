<%@ include file="../../layout/header.jsp"%>
<%@ include file="../../layout/menu.jsp"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<div class="card-header">
					<span class="title" id="menu-toggle">Catálogo de Servicios</span> <span
						class="float-right text-secondary" id="btn-ocultar">Ocultar</span>
					<sf:form
						action="${pageContext.request.contextPath}/home/cat/principal/servicio/crud"
						method="POST" name="new" id="nuevoElemento">
						<input name="event" type="hidden" value="new" />
						<button type="submit"
							class="btn-link float-right border-0 text-secondary">Nuevo
							Servicio</button>
					</sf:form>
				</div>
				<sf:form
					action="${pageContext.request.contextPath}/home/cat/principal/servicio/consulta"
					method="POST" name="fuentes" autocomplete="off">
					<div id="mainMenu" class="collapse show card-body">
						<div class="form-row">
							<%-- inputs --%>
							<div class="form-group col-md-3">
								<label>Servicio:</label> <select
									class="form-control form-control-sm" name="servicio"
									id="servicio">
									<option value="0">Seleccionar Servicio</option>
									<c:forEach items="${listaServicio}" var="lista_r">
										<option
											value="<c:out value="${lista_r.id_servicios}"> </c:out>"
											${lista_r.id_servicios eq servicio ? 'selected="selected"' : ''}>
											<c:out value="${lista_r.clave}"></c:out>
										</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group col-md-3">
								<label>Grupo concepto:</label> <select
									class="form-control form-control-sm" name="grupo_concepto"
									id="grupo_concepto">
									<option value="0">Seleccionar Grupo Concepto</option>
									<c:forEach items="${listaGrupoConceptoServ}" var="grupoCon">
										<option value="<c:out value="${grupoCon.id_grupo}"> </c:out>"
											${grupoCon.id_grupo eq grupo_concepto ? 'selected="selected"' : ''}>
											<c:out value="${grupoCon.clave}"></c:out>
										</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group col-md-3">
								<label>Grupo volumen:</label> <select
									class="form-control form-control-sm" name="grupo_volumen"
									id="grupo_volumen">
									<option value="0">Seleccionar Grupo Volumen</option>
									<c:forEach items="${listaGrupoVolumenServicio}" var="grupoVol">
										<option value="<c:out value="${grupoVol.id_grupo}"> </c:out>"
											${grupoVol.id_grupo eq grupo_volumen ? 'selected="selected"' : ''}>
											<c:out value="${grupoVol.clave}"></c:out>
										</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group col-md-3">
								<label>Estatus:</label> <select
									class="form-control form-control-sm" name="estatus"
									id="estatus">
									<option value="empty">Seleccionar Estatus</option>
									<option value="ACT"
										${estatus eq 'ACT' ? 'selected="selected"' : ''}>Activo</option>
									<option value="NOA"
										${estatus eq 'NOA' ? 'selected="selected"' : ''}>No
										activo</option>
									<option value="CRE"
										${estatus eq 'CRE' ? 'selected="selected"' : ''}>Creado</option>
								</select>
							</div>
							<div class="form-group col-md-3">
								<label>Negocio:</label> <select
									class="form-control form-control-sm" name="negocio"
									id="negocio">
									<option value="0">Seleccionar Negocio</option>
									<c:forEach items="${listaNegocios}" var="lista">
										<option value="<c:out value="${lista.id_negocio}"> </c:out>"
											${lista.id_negocio eq negocio ? 'selected="selected"' : ''}>
											<c:out value="${lista.clave}"></c:out>
										</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group col-md-3">
								<label>Fuente:</label> <select
									class="form-control form-control-sm" name="fuente" id="fuente">
									<option value="0">Seleccionar Fuente</option>
									<c:forEach items="${listaFuentes}" var="lista">
										<option value="<c:out value="${lista.id_fuente}"></c:out>"
											${lista.id_fuente eq fuente ? 'selected="selected"' : ''}>
											<c:out value="${lista.clave}"></c:out>
										</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group col-md-6 d-flex flex-row-reverse">
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
									<th scope="col">Descripción</th>
									<th scope="col">Grupo concepto</th>
									<th scope="col">Negocio</th>
									<th scope="col">Adq. Automática</th>
									<th scope="col">Estatus</th>
									<th scope="col">Fecha Última Modificación</th>
									<th scope="col">Periodo de cobro</th>
									<th scope="col" class="text-center">Editar</th>
									<th scope="col" class="text-center">Eliminar</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${consulta}" var="lista_r">
									<tr>
										<td><c:out value="${lista_r.clave}"></c:out></td>
										<td><c:out value="${lista_r.descripcion}"></c:out></td>
										<td><c:out value="${lista_r.id_grupo_concepto}"></c:out></td>
										<td><c:out value="${lista_r.id_negocio}"></c:out></td>
										<td><c:out value="${lista_r.b_adquisicion_auto}"></c:out></td>
										<td><c:out value="${lista_r.estatus}"></c:out></td>
										<td><c:out value="${lista_r.fecha_mod}"></c:out></td>
										<td><c:out value="${lista_r.periodicidad_cobro}"></c:out></td>
										<td><sf:form
												action="${pageContext.request.contextPath}/home/cat/principal/servicio/crud"
												method="POST" name="crud" class="text-center">
												<input name="id_servicios" type="hidden"
													value="${lista_r.id_servicios}" />
												<input name="id_precio" type="hidden"
													value="${lista_r.id_precio}" />
												<input name="event" type="hidden" value="edit" />
												<button type="submit"
													class="btn btn-secondary text-white btn-sm btn-table">
													<span class="icon-brush"></span>
												</button>
											</sf:form></td>
										<td><sf:form
												action="${pageContext.request.contextPath}/home/cat/principal/servicio/crud"
												method="POST" name="crud" class="text-center">
												<input name="id_servicios" type="hidden"
													value="${lista_r.id_servicios}" />
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
							action="${pageContext.request.contextPath}/home/cat/principal/servicio/jasper"
							method="POST" name="fuentes" autocomplete="off">
							<input type="hidden" name="servicio" id="reporteParamservicio"
								class="globalGetReport">
							<input type="hidden" name="grupo_concepto"
								id="reporteParamgrupo_concepto" class="globalGetReport">
							<input type="hidden" name="grupo_volumen"
								id="reporteParamgrupo_volumen" class="globalGetReport">
							<input type="hidden" name="estatus" id="reporteParamestatus"
								class="globalGetReport">
							<input type="hidden" name="negocio" id="reporteParamnegocio"
								class="globalGetReport">
							<input type="hidden" name="fuente" id="reporteParamfuente"
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
								action="${pageContext.request.contextPath}/home/cat/principal/servicio/consulta"
								method="POST" name="pagination">
								<%-- 						VARIABLES OBTENIDAS MEDIANTE JS --%>
								<input type="hidden" name="fuentes" id="getfuentes"
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
					</div>
				</div>
			</c:if>
		</div>
	</div>
</div>
<%@ include file="../../layout/footer.jsp"%>
