<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<c:if test="${event=='delete'}">
					<sf:form
						action="${pageContext.request.contextPath}/home/param/conversion/save"
						method="POST" name="insert">
						<c:forEach items="${consulta}" var="editar">
							<input name="evento" type="hidden" value="delete" />
							<input name="regla_conv_id" type="hidden"
								value="${editar.regla_conv_id}" />
							<div class="card-header">
								<span class="title" id="menu-toggle">Eliminar</span> <a
									class="float-right text-secondary"
									href="<c:url value='/home/param/conversion'/>" role="button">Regresar</a>
							</div>
							<div id="mainMenu" class="collapse show card-body">
								<div class="row">
									<div class="col-sm-12 col-md-12  text-center">
										<h5 class="card-title">
											Está a punto de eliminar a <span class="title">${editar.clave}.</span>
											¿Desea continuar?
										</h5>
										<button type="submit" class="btn btn-secondary text-white btn-sm">Eliminar</button>
										<a class="btn btn-secondary text-white btn-sm"
											href="<c:url value='/home/param/conversion'/>" role="button">Regresar</a>
									</div>
								</div>
							</div>
						</c:forEach>
					</sf:form>
				</c:if>
				<c:if test="${event=='edit'}">
					<c:forEach items="${consulta}" var="lista">
						<sf:form
							action="${pageContext.request.contextPath}/home/param/conversion/save"
							method="POST" name="insert">
							<input name="evento" type="hidden" value="update" />
							<input name="regla_conv_id" type="hidden"
								value="${lista.regla_conv_id}" />
							<input name="servicio_id" type="hidden"
								value="${lista.servicio_id}" />
							<div class="card-header">
								<span class="title" id="menu-toggle">Detalle de
									Adquisición y Conversión de Servicios</span> <a
									class="pl-4 text-secondary tab-link" data-toggle="collapse"
									href="#general" role="button" aria-expanded="false"
									aria-controls="general">Datos Generales</a> <a
									class="pl-4 text-secondary tab-link" data-toggle="collapse"
									href="#historico" role="button" aria-expanded="false"
									aria-controls="tab2">Histórico</a> <a
									class="float-right text-secondary"
									href="<c:url value='/home/param/conversion'/>" role="button">Regresar</a>
							</div>
							<div id="mainMenu" class="show card-body">
								<div class="collapse" id="general">
									<div class="row">
										<div class="col-sm-6 col-md-6 mt-2">
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Fuente</label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm"
														name="id_fuente">
														<option value="0">Opción</option>
														<c:forEach items="${listaFuentes}" var="fuente">
															<option
																value="<c:out value="${fuente.id_fuente}"></c:out>"
																${ fuente.id_fuente==lista.id_fuente ? 'selected="selected"' : ''}><c:out
																	value="${fuente.clave}"></c:out></option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Servicio</label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm"
														name="id_servicio">
														<option value="0">Seleccionar Servicio</option>
														<c:forEach items="${listaServicio}" var="lista_r">
															<option
																value="<c:out value=" ${lista_r.id_servicios} "> </c:out>"
																${ lista_r.id_servicios==lista.servicio_id ? 'selected="selected"' : ''}>
																<c:out value="${lista_r.clave}"></c:out>
															</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Fecha Última
													Modificación</label>
												<div class="col-sm-8">
													<input type="text" class="form-control form-control-sm"
														name="fecha_mod"
														value="<fmt:formatDate value="${lista.fecha_mod}" pattern="yyyy-MM-dd"/>" />
												</div>
											</div>
										</div>
										<div class="col-sm-6 col-md-6 mt-2">
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Usuario</label>
												<div class="col-sm-8">
													<input type="text" class="form-control form-control-sm"
														name="usuario" value="${lista.usuario}"/>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Estatus</label>
												<div class="col-sm-8">
													<input type="text" class="form-control form-control-sm"
														name="estatus" value="${lista.estatus}" />
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Comentarios</label>
												<div class="col-sm-8">
													<textarea class="form-control" maxlength="250"
														name="comentarios">${lista.comentarios}</textarea>
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-12 col-md-12 mt-2">
											<blockquote class="blockquote">
												<footer class="blockquote-footer"> Se recomienda
													agregar el criterio "CLAVE_CLIENTE_SILFAC IS NOT NULL" Y/O
													"CLAVE_CLIENTE_ADQ_SILFAC IS NOT NULL" este último cuando
													aplique. </footer>
												<footer class="blockquote-footer"> El campo
													B_TIPO_ADQ debe llevar el valor 'NOR' y FECHA_SILFAC debe
													llevar 'NULL'. </footer>
												<footer class="blockquote-footer"> Los 4 campos de
													MONTO con terminación en número corresponden a los valores
													que se tomará para cada subconcepto en esta orden. </footer>
												<footer class="blockquote-footer"> En la tabla
													temporal los campos CLAVE_CLIENTE_SILFAC y
													CLAVE_CLIENTE_ADQ_SILFAC son generados automáticamente por
													el proceso de conversión de claves y los campos
													FECHA_CONVERSION, NUM_CONVERSIONES y SERVICIOS_CONVERTIDOS
													son de uso interno. </footer>
												<footer class="blockquote-footer"> El tipo de dato
													que se ingrese es responsabilidad del usuario. </footer>
											</blockquote>
										</div>
										<div class="col-sm-12 col-md-12 mt-2">
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Sentencia SQL</label>
												<div class="col-sm-8">
													<textarea class="form-control" maxlength="4000"
														name="sentencia" id="sentencia" rows="5">${lista.criterios}</textarea>
												</div>
											</div>
											<%-- 											probar --%>
										</div>
									</div>
									<div class="form-group row">
										<div class="col-md-10">
											<button type="button"
												class="btn btn-secondary text-white btn-sm float-right bordered  mb-1 mr-2 mt-auto"
												id="btnProbar">Probar</button>
											</div>
											<div class="col-md-2">
											<button type="submit"
												class="btn btn-secondary text-white btn-sm float-right bordered  mb-1 mt-auto btnAppendConceptos">Actualizar</button>
										</div>
									</div>
									
								</div>

							</div>
							
							<div class="collapse" id="historico">
									<div class="row">
										<div class="col-sm-6 col-md-6 mt-2">
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Fuente</label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm"
														name="id_fuente" disabled>
														<option value="0">Opción</option>
														<c:forEach items="${listaFuentes}" var="fuente">
															<option
																value="<c:out value="${fuente.id_fuente}"></c:out>"
																${ fuente.id_fuente==lista.id_fuente ? 'selected="selected"' : ''}><c:out
																	value="${fuente.clave}"></c:out></option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Servicio</label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm"
														name="id_servicio" disabled>
														<option value="0">Seleccionar Servicio</option>
														<c:forEach items="${listaServicio}" var="lista_r">
															<option
																value="<c:out value=" ${lista_r.id_servicios} "> </c:out>"
																${ lista_r.id_servicios==lista.servicio_id ? 'selected="selected"' : ''}>
																<c:out value="${lista_r.clave}"></c:out>
															</option>
														</c:forEach>
													</select>
												</div>
											</div>
										</div>
										<div class="col-sm-6 col-md-6 mt-2">
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Usuario</label>
												<div class="col-sm-8">
													<input type="text" class="form-control form-control-sm"
														name="usuario" value="${lista.usuario}" disabled/>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Fecha Última
													Modificación</label>
												<div class="col-sm-8">
													<input type="text" class="form-control form-control-sm"
														name="fecha_mod"
														value="<fmt:formatDate value="${lista.fecha_mod}" pattern="yyyy-MM-dd" />" disabled/>
												</div>
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
																	<th>Fecha de Última Modificación</th>
																	<th>Usuarios</th>
																	<th>Comentarios</th>
																</tr>
															</thead>
															<tbody>
																<c:forEach items="${reglasConversion}" var="consulta">
																	<tr>
																		<td><c:out value="${consulta.fecha_mod}"></c:out></td>
																		<td><c:out value="${consulta.usuario}"></c:out></td>
																		<td><c:out value="${consulta.comentarios}"></c:out></td>
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
							
						</sf:form>
						
						<sf:form
									action="${pageContext.request.contextPath}/home/param/conversion/test"
									method="POST" name="cargaDatos">
									<input type="hidden" class="form-control form-control-sm"
										name="event" id="event" value="edit">
									<input type="hidden" class="form-control form-control-sm"
										name="idRegla" id="idRegla" value="${lista.regla_conv_id}">
									<input type="text" class="form-control form-control-sm d-none"
										name="sentencia" id="nuevaSentencia">
									<button type="submit" id="enviarPrueba"
										class="btn btn-secondary text-white btn-sm float-right bordered  mb-1 mt-auto d-none">Guardar</button>
								</sf:form>
								
					</c:forEach>
				</c:if>
				<c:if test="${event=='new'}">
					<sf:form
						action="${pageContext.request.contextPath}/home/param/conversion/save"
						method="POST" name="insert">
						<input name="evento" type="hidden" value="insert" />
						<div class="card-header">
							<span class="title" id="menu-toggle">Detalle de
								Adquisición y Conversión de Servicios</span> <a
								class="pl-4 text-secondary tab-link" data-toggle="collapse"
								href="#general" role="button" aria-expanded="false"
								aria-controls="general">Datos Generales</a>
							<%-- 								<a class="pl-4 text-secondary tab-link" data-toggle="collapse" href="#tab2" role="button" aria-expanded="false" aria-controls="tab2">Histórico</a> --%>
							<a class="float-right text-secondary"
								href="<c:url value='/home/param/conversion'/>" role="button">Regresar</a>
						</div>
						<div id="mainMenu" class="show card-body">
							<div class="collapse" id="general">
								<div class="row">
									<div class="col-sm-6 col-md-6 mt-2">
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Fuente</label>
											<div class="col-sm-8">
												<select class="form-control form-control-sm"
													name="id_fuente">
													<option value="0">Opción</option>
													<c:forEach items="${listaFuentes}" var="fuente">
														<option
															value="<c:out value="${fuente.id_fuente}"></c:out>"><c:out
																value="${fuente.clave}"></c:out></option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Servicio</label>
											<div class="col-sm-8">
												<select class="form-control form-control-sm"
													name="id_servicio">
													<option value="0">Seleccionar Servicio</option>
													<c:forEach items="${listaServicio}" var="lista_r">
														<option
															value="<c:out value=" ${lista_r.id_servicios} "> </c:out>">
															<c:out value="${lista_r.clave}"></c:out>
														</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-6 mt-2">
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Comentarios</label>
											<div class="col-sm-8">
												<textarea class="form-control" maxlength="250"
													name="comentarios"></textarea>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12 col-md-12 mt-2">
										<blockquote class="blockquote">
											<footer class="blockquote-footer"> Se recomienda
												agregar el criterio "CLAVE_CLIENTE_SILFAC IS NOT NULL" Y/O
												"CLAVE_CLIENTE_ADQ_SILFAC IS NOT NULL" este último cuando
												aplique. </footer>
											<footer class="blockquote-footer"> El campo
												B_TIPO_ADQ debe llevar el valor 'NOR' y FECHA_SILFAC debe
												llevar 'NULL'. </footer>
											<footer class="blockquote-footer"> Los 4 campos de
												MONTO con terminación en número corresponden a los valores
												que se tomará para cada subconcepto en esta orden. </footer>
											<footer class="blockquote-footer"> En la tabla
												temporal los campos CLAVE_CLIENTE_SILFAC y
												CLAVE_CLIENTE_ADQ_SILFAC son generados automáticamente por
												el proceso de conversión de claves y los campos
												FECHA_CONVERSION, NUM_CONVERSIONES y SERVICIOS_CONVERTIDOS
												son de uso interno. </footer>
											<footer class="blockquote-footer"> El tipo de dato
												que se ingrese es responsabilidad del usuario. </footer>
										</blockquote>
									</div>
									<div class="col-sm-12 col-md-12 mt-2">
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Sentencia SQL</label>
											<div class="col-sm-8">
												<textarea class="form-control" maxlength="250"
													name="sentencia" id="sentencia" rows="10"></textarea>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-10">
									<button type="button"
										class="btn btn-secondary text-white btn-sm float-right bordered  mb-1 mr-2 mt-auto"
										id="btnProbar">Probar</button>
										</div>
								<div class="col-md-2">
									<button type="submit"
										class="btn btn-secondary text-white btn-sm float-right bordered  mb-1 mt-auto btnAppendConceptos">Guardar</button>
								</div>
							</div>
						</div>
					</sf:form>

					<sf:form
						action="${pageContext.request.contextPath}/home/param/conversion/test"
						method="POST" name="cargaDatos">
						<input type="hidden" class="form-control form-control-sm"
							name="event" id="event" value="new">
						<input type="hidden" class="form-control form-control-sm"
							name="idRegla" id="idRegla" value="${lista.regla_conv_id}">
						<input type="text" class="form-control form-control-sm d-none"
							name="sentencia" id="nuevaSentencia">
						<button type="submit" id="enviarPrueba"
							class="btn btn-secondary text-white btn-sm float-right bordered  mb-1 mt-auto d-none">Guardar</button>
					</sf:form>
				</c:if>
			</div>
		</div>
	</div>
</div>
<%@ include file="../layout/footer.jsp"%>
