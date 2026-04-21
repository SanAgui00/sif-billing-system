<%@ include file="../../layout/header.jsp"%>
<%@ include file="../../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<c:if test="${event=='delete'}">
		<sf:form action="${pageContext.request.contextPath}/home/cat/principal/negocio/save" method="POST" name="insert">
			<c:forEach items="${consulta}" var="editar">
				<div class="row">
					<div class="col-sm-12">
						<div class="card mt-1">
							<input name="evento" type="hidden" value="delete" /> <input name="id_negocio" type="hidden" value="${editar.id_negocio}" />
							<div class="card-header">
								<span class="title" id="menu-toggle">Eliminar</span> <a class="float-right text-secondary" href="<c:url value='/home/cat/principal/negocio/'/>" role="button">Regresar</a>
							</div>
							<div id="mainMenu" class="collapse show card-body">
								<div class="row">
									<div class="col-sm-12 col-md-12  text-center">
										<h5 class="card-title">
											Está a punto de eliminar a <span class="font-weight-bold">${editar.clave}.</span> ¿Desea continuar?
										</h5>
										<button type="submit" class="btn btn-secondary text-white btn-sm">Eliminar</button>
										<a class="btn btn-secondary text-white btn-sm" href="<c:url value='/home/cat/principal/negocio/'/>" role="button">Regresar</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</sf:form>
	</c:if>
	<c:if test="${event=='edit' && not empty consulta}">
		<sf:form action="${pageContext.request.contextPath}/home/cat/principal/negocio/save" method="POST" name="insert">
			<c:forEach items="${consulta}" var="editar">
				<div class="row">
					<div class="col-sm-12">
						<div class="card mt-1">
							<input name="evento" type="hidden" value="update" /> <input name="id_negocio" type="hidden" value="${editar.id_negocio}" /> <input name="id_grupo_edo_cuenta" type="hidden" value="${editar.id_grupo_edo_cuenta}" /> <input name="status" type="hidden" value="${editar.status}" />
							<div class="card-header">
								<span class="title" id="menu-toggle">Editando a ${editar.clave}</span> <a class="float-right text-secondary" href="<c:url value='/home/cat/principal/negocio/'/>" role="button">Regresar</a>
							</div>
							<div id="mainMenu" class="show card-body">
								<div class="collapse" id="general">
									<div class="row">
										<div class="col-sm-6 col-md-6 mt-2 mb-2">
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Negocio</label>
												<div class="col-sm-8">
													<input type="text" class="form-control form-control-sm" value="<c:out value="${editar.clave}"></c:out>" name="clave">
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Descripción</label>
												<div class="col-sm-8">
													<input type="text" class="form-control form-control-sm" value="<c:out value="${editar.descripcion}"></c:out>" name="descripcion">
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Metodo de pago</label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm" name="clave_metodopago_sat">
														<option value="empty" selected="selected">Selecciona un Metodo de pago</option>
														<c:forEach items="${listaMetodoPago}" var="listaMetodosPago">
															<option value="<c:out value="${listaMetodosPago.clave}"></c:out>" ${listaMetodosPago.clave==editar.clave_metodopago_sat ? 'selected="selected"' : ''}>
																<c:out value="${listaMetodosPago.clave}"></c:out>
															</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Uso de CFDI</label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm" name="clave_usocfdi_sat">
														<option value="empty" selected="selected">Selecciona un Uso de CFDI</option>
														<c:forEach items="${listaUsoCfdi}" var="listaUsosCFDI">
															<option value="<c:out value="${listaUsosCFDI.clave}"></c:out>" ${listaUsosCFDI.clave==editar.clave_usocfdi_sat ? 'selected="selected"' : ''}>
																<c:out value="${listaUsosCFDI.clave}"></c:out>
															</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Proceso</label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm" name="id_proceso" required>
														<option value="0" selected="selected">Selecciona un Proceso</option>
														<c:forEach items="${listaProceso}" var="listaProcesos">
															<option value="<c:out value="${listaProcesos.id_proceso}"></c:out>" ${listaProcesos.id_proceso==editar.id_proceso ? 'selected="selected"' : ''}>
																<c:out value="${listaProcesos.clave_proceso}"></c:out>
															</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Negocio / Padre</label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm" name="id_negocio_padre" required>
														<option value="0" selected="selected">Selecciona un Negocio / Padre</option>
														<c:forEach items="${listaNegocios}" var="catNegocio">
															<option value="<c:out value="${catNegocio.id_negocio}"></c:out>"${catNegocio.id_negocio==editar.id_negocio_padre ? 'selected="selected"' : ''}>
																<c:out value="${catNegocio.clave}"></c:out>
															</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Centro de Costos</label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm" name="id_centro_costos">
														<option value="0" selected="selected">Selecciona un Centro de costos</option>
														<c:forEach items="${listaSegmentos3}"
														var="lista3">
														<option
															value="<c:out value="${lista3.id}"> </c:out>"${lista3.id==editar.id_centro_costos ? 'selected="selected"' : ''}>
															<c:out value="${lista3.valor_segmento}"></c:out>
														</option>
													</c:forEach>		
													</select>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Cuenta de Ingreso</label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm"
													name="cuenta_ingreso">
													<option value="0" selected="selected">Selecciona
														cuenta de Ingreso</option>
													<c:forEach items="${listaSegmentos2}"
														var="lista2">
														<option
															value="<c:out value="${lista2.id}"> </c:out>"${lista2.id==editar.cuenta_ingreso ? 'selected="selected"' : ''}>
															<c:out value="${lista2.valor_segmento}"></c:out>
														</option>
													</c:forEach>
												</select>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Clave de Negocio GL</label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm"
													name="clave_gl">
													<option value="0" selected="selected">Selecciona
														Negocio GL</option>
													<c:forEach items="${listaSegmentos1}"
														var="lista1">
														<option
															value="<c:out value="${lista1.id}"> </c:out>"${lista1.id==editar.clave_gl ? 'selected="selected"' : ''}>
															<c:out value="${lista1.valor_segmento}"></c:out>
														</option>
													</c:forEach>
												</select>	
												</div>
											</div>
										</div>
										<div class="col-sm-6 col-md-6 mt-2 mb-2">
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Leyenda de Factura</label>
												<div class="col-sm-8">
													<textarea class="form-control form-control-sm" maxlength="250" name="comentarios">${editar.comentarios}</textarea>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Concepto Carta</label>
												<div class="col-sm-8">
													<textarea class="form-control form-control-sm" maxlength="250" name="concepto_carta">${editar.concepto_carta}</textarea>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Autor Última modificación</label>
												<div class="col-sm-8">
													<input type="text" class="form-control form-control-sm" placeholder="Autor Última modificación" name="usuario" value="${editar.usuario}" disabled>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Fecha de Creación</label>
												<div class="col-sm-8">
													<input type="date" class="form-control form-control-sm" placeholder="Autor Última modificación" name="fecha_crea" value="<fmt:formatDate value="${editar.fecha_cre}" pattern="yyyy-MM-dd"/>" disabled>
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Fecha de Modificación</label>
												<div class="col-sm-8">
													<input type="date" class="form-control form-control-sm" placeholder="Autor Última modificación" name="fecha_modi" value="<fmt:formatDate value="${editar.fecha_mod}" pattern="yyyy-MM-dd"/>" disabled>
												</div>
											</div>
										</div>
										<div class="col-sm-12 col-md-12">
											<button type="submit" class="btn btn-secondary text-white btn-sm float-right ">Actualizar</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</sf:form>
	</c:if>
	<c:if test="${event=='new'}">
		<sf:form action="${pageContext.request.contextPath}/home/cat/principal/negocio/save" method="POST" name="insert">
			<div class="row">
				<div class="col-sm-12">
					<div class="card mt-1">
						<input name="evento" type="hidden" value="insert" />
						<div class="card-header">
							<span class="title" id="menu-toggle">Nuevo Negocio</span> <a class="float-right text-secondary" href="<c:url value='/home/cat/principal/negocio/'/>" role="button">Regresar</a>
						</div>
						<div id="mainMenu" class="show card-body">
							<div class="collapse" id="general">
								<div class="row">
									<div class="col-sm-6 col-md-6 mt-2 mb-2">
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Negocio</label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm" name="clave">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Descripción</label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm" name="descripcion">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Metodo de pago</label>
											<div class="col-sm-8">
												<select class="form-control form-control-sm" name="clave_metodopago_sat">
													<option value="empty" selected="selected">Selecciona un Metodo de pago</option>
													<c:forEach items="${listaMetodoPago}" var="listaMetodosPago">
														<option value="<c:out value="${listaMetodosPago.clave}"> </c:out>">
															<c:out value="${listaMetodosPago.clave}"></c:out>
														</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Uso de CFDI</label>
											<div class="col-sm-8">
												<select class="form-control form-control-sm" name="clave_usocfdi_sat">
													<option value="empty" selected="selected">Selecciona un Uso de CFDI</option>
													<c:forEach items="${listaUsoCfdi}" var="listaUsosCFDI">
														<option value="<c:out value="${listaUsosCFDI.clave}"> </c:out>">
															<c:out value="${listaUsosCFDI.clave}"></c:out>
														</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Proceso</label>
											<div class="col-sm-8">
												<select class="form-control form-control-sm" name="id_proceso" required>
													<option value="0" selected="selected">Selecciona un Proceso</option>
													<c:forEach items="${listaProceso}" var="listaProcesos">
														<option value="<c:out value="${listaProcesos.id_proceso}"> </c:out>">
															<c:out value="${listaProcesos.clave_proceso}"></c:out>
														</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Negocio / Padre</label>
											<div class="col-sm-8">
												<select class="form-control form-control-sm" name="id_negocio_padre" required>
													<option value="0" selected="selected">Selecciona un Negocio / Padre</option>
													<c:forEach items="${listaNegocios}" var="catNegocio">
														<option value="<c:out value="${catNegocio.id_negocio}"> </c:out>">
															<c:out value="${catNegocio.clave}"></c:out>
														</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Centro de Costos</label>
											<div class="col-sm-8">
												<select class="form-control form-control-sm" name="id_centro_costos">
													<option value="0" selected="selected">Selecciona un Centro de costos</option>
													<c:forEach items="${listaSegmentos3}"
														var="lista3">
														<option
															value="<c:out value="${lista3.id}"> </c:out>">
															<c:out value="${lista3.valor_segmento}"></c:out>
														</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Cuenta de Ingreso</label>
											<div class="col-sm-8">
												<select class="form-control form-control-sm"
													name="cuenta_ingreso">
													<option value="0" selected="selected">Selecciona
														cuenta de Ingreso</option>
													<c:forEach items="${listaSegmentos2}"
														var="lista2">
														<option
															value="<c:out value="${lista2.id}"> </c:out>">
															<c:out value="${lista2.valor_segmento}"></c:out>
														</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Clave de Negocio GL</label>
											<div class="col-sm-8">
												<select class="form-control form-control-sm"
													name="clave_gl">
													<option value="0" selected="selected">Selecciona
														Negocio GL</option>
													<c:forEach items="${listaSegmentos1}"
														var="lista1">
														<option
															value="<c:out value="${lista1.id}"> </c:out>">
															<c:out value="${lista1.valor_segmento}"></c:out>
														</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-6 mt-2 mb-2">
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Leyenda de Factura</label>
											<div class="col-sm-8">
												<textarea class="form-control form-control-sm" maxlength="250" name="comentarios"></textarea>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Concepto Carta</label>
											<div class="col-sm-8">
												<textarea class="form-control form-control-sm" maxlength="250" name="concepto_carta"></textarea>
											</div>
										</div>
									</div>
									<div class="col-sm-12 col-md-12">
										<button type="submit" class="btn btn-secondary text-white btn-sm float-right ">Guardar</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</sf:form>
	</c:if>
</div>
<%@ include file="../../layout/footer.jsp"%>
