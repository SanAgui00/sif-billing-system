<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<div class="card-header">
					<span class="title" id="menu-toggle">Cuentas de Etiquetas</span> <span class="float-right text-secondary" id="btn-ocultar"></span>
					<sf:form action="${pageContext.request.contextPath}/home/impresiones/crud" method="POST" name="new" id="nuevoElemento">
						<input name="event" type="hidden" value="new" />
						<button type="submit" class="btn-link float-right border-0 text-secondary">Nueva Cuenta</button>
					</sf:form>
				</div>
				
					
						<div>
							<div>
								<div class="table-responsive">
									<table
										class="table table-scroll table-striped table-bordered table-hover"
										id="dinamic">
										<thead>
											<tr>
												<th scope="col">Clave</th>
												<th scope="col">Descripcion</th>
												<th scope="col">Estatus</th>
												<th scope="col">Autor de ultima Modificacion</th>
												<th scope="col">Numero de Cuenta</th>
												<th scope="col" class="text-center">Editar</th>
											</tr>
										</thead>
										<tbody>
											<c:if test="${not empty consulta}">
												<c:forEach items="${consulta}" var="consulta">
													<tr>
														<td><c:out value="${consulta.clave}">${consulta.clave}</c:out></td>
														<td><c:out value="${consulta.descripcion}">${consulta.descripcion}</c:out></td>
														<td class="max-width-150"><c:out
																value="${consulta.estatus}">${consulta.estatus}</c:out></td>
														<td><c:out value="${consulta.usuario}">${consulta.usuario}</c:out></td>
														<td><c:out value="${consulta.parrafo3}">${consulta.parrafo3}</c:out></td>
														<td><sf:form
																action="${pageContext.request.contextPath}/home/impresiones/crud"
																method="POST" name="crud" class="text-center">
																<input name="id" type="hidden" value="${consulta.id_estilo}" />
																<input name="event" type="hidden" value="edit" />
																<button type="submit"
																	class="btn btn-secondary text-white btn-sm btn-table">
																	<span class="icon-brush"></span>
																</button>
															</sf:form></td>
													</tr>
												</c:forEach>
											</c:if>
											
										</tbody>
									</table>
								</div>
							</div>

						</div>

				
			</div>
		</div>

	</div>
</div>
<%@ include file="../layout/footer.jsp"%>
