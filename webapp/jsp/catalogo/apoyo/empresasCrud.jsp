<%@ include file="../../layout/header.jsp"%>
<%@ include file="../../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<c:if test="${event=='delete'}">
		<sf:form action="${pageContext.request.contextPath}/home/cat/apoyo/empresas/save" method="POST" name="insert">
			<div class="row">
				<div class="col-sm-12">
					<div class="card mt-1">
						<c:forEach items="${consulta}" var="consulta">
							<input name="evento" type="hidden" value="delete" />
							<input name="id_empresa" type="hidden" value="${consulta.id_empresa}" />
							<div class="card-header">
								<span class="title" id="menu-toggle">Eliminar</span> <a class="float-right text-secondary" href="<c:url value='/home/cat/apoyo/empresas/'/>" role="button">Regresar</a>
							</div>
							<div id="mainMenu" class="collapse show card-body">
								<div class="row">
									<div class="col-sm-12 col-md-12  text-center">
										<h5 class="card-title">
											Está a punto de eliminar a <span class="font-weight-bold"><c:out value="${consulta.razon_social}"></c:out>.</span> ¿Desea continuar?
										</h5>
										<button type="submit" class="btn btn-secondary text-white btn-sm">Eliminar</button>
										<a class="btn btn-secondary text-white btn-sm" href="<c:url value='/home/cat/apoyo/empresas/'/>" role="button">Regresar</a>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</sf:form>
	</c:if>
	<c:if test="${event=='edit' && not empty consulta}">
		<c:forEach items="${consulta}" var="consulta">
			<sf:form action="${pageContext.request.contextPath}/home/cat/apoyo/empresas/save" method="POST" name="insert">
				<div class="row">
					<div class="col-sm-12">
						<div class="card mt-1">
							<input name="evento" type="hidden" value="update" /> <input name="id_empresa" type="hidden" value="${consulta.id_empresa}" /> <input name="estatus" type="hidden" value="${consulta.estatus}" /> <input name="id_domicilio" type="hidden" value="${consulta.id_domicilio}" /> <input name="certificado" type="hidden" value="${consulta.certificado}" /> <input name="key" type="hidden" value="${consulta.key}" /> <input name="regimen_fiscal" type="hidden" value="${consulta.regimen_fiscal}" /> <input name="lugar_expedicion" type="hidden" value="${consulta.lugar_expedicion}" /> <input name="version_cfdi_sat" type="hidden" value="${consulta.version_cfdi_sat}" />
							<div class="card-header">
								<span class="title" id="menu-toggle">Detalle de la Empresa</span> <a class="float-right text-secondary" href="<c:url value='/home/cat/apoyo/empresas/'/>" role="button">Regresar</a> <span class="float-right text-secondary pr-3" id="btn-ocultar">Ocultar</span>
							</div>
							<div id="mainMenu" class="collapse show card-body pb-0">
								<div class="row">
									<div class="col-sm-6 col-md-6 mt-2">
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Clave </label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm" placeholder="Clave" name="clave_empresa" value="<c:out
                                        value="${consulta.clave_empresa}"></c:out>" />
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Razón Social </label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm" placeholder="Razón social" name="razon_social" value="<c:out
                                        value="${consulta.razon_social}"></c:out>" />
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Email </label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm" placeholder="Email" name="email" value="<c:out
                                        value="${consulta.email}"></c:out>" />
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Teléfono Secundario </label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm" placeholder="Teléfono secundario" name="tel2" value="<c:out
                                        value="${consulta.tel2}"></c:out>" />
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Fecha de Creación </label>
											<div class="col-sm-8">
												<input type="date" class="form-control form-control-sm" name="fecha_crea" value="<fmt:formatDate value="${consulta.fecha_cre}" pattern="yyyy-MM-dd"/>" required />
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Comentarios</label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm" placeholder="comentario" maxlength="199" name="comentarios" value="<c:out
                                        value="${consulta.comentarios}"></c:out>" />
											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-6 mt-2">
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">RFC</label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm" placeholder="RFC" name="rfc" value="<c:out
                                        value="${consulta.rfc}"></c:out>" />
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Curp</label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm" placeholder="Curp" name="curp" value="<c:out
                                        value="${consulta.curp}"></c:out>" />
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Teléfono Principal</label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm" placeholder="Teléfono principal" name="tel1" value="<c:out
                                        value="${consulta.tel1}"></c:out>" />
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">FAX</label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm" placeholder="Fax" name="fax" value="<c:out
                                        value="${consulta.fax}"></c:out>" />
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Fecha de Modificación</label>
											<div class="col-sm-8">
												<input type="date" class="form-control form-control-sm" name="fecha_modi" value="<fmt:formatDate value="${consulta.fecha_mod}" pattern="yyyy-MM-dd"/>" required />
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label"> Régimen Fiscal</label>
											<div class="col-sm-8">
												<select class="form-control form-control-sm" name="clave_regfiscal_sat">
													<option value="0" selected="selected">Selecciona un Régimen Fiscal</option>
													<c:forEach items="${listaRegimenFiscal}" var="lista">
														<option value="<c:out value="${lista.clave}"> </c:out>" ${lista.clave==consulta.clave_regfiscal_sat ? 'selected="selected"' : ''}>
															<c:out value="${lista.descripcion}"></c:out>
														</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Autor Última Modificación </label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm" name="usuario" value="<c:out
                                        value="${consulta.usuario}"></c:out>" />
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Representante legal </label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm" placeholder="Representante legal" name="representante_legal" value="<c:out
                                        value="${consulta.representante_legal}"></c:out>" />
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-12 mt-1">
												<button type="submit" class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto btnAppendConceptos">Guardar</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</sf:form>
		</c:forEach>
	</c:if>
	<c:if test="${event=='new'}">
		<sf:form action="${pageContext.request.contextPath}/home/cat/apoyo/empresas/save" method="POST" name="insert">
			<input name="evento" type="hidden" value="insert" />
			<div class="row">
				<div class="col-sm-12">
					<div class="card mt-1">
						<div class="card-header">
							<span class="title" id="menu-toggle">Detalle de la Empresa</span> <a class="float-right text-secondary" href="<c:url value='/home/cat/apoyo/empresas/'/>" role="button">Regresar</a> <span class="float-right text-secondary pr-3" id="btn-ocultar">Ocultar</span>
						</div>
						<div id="mainMenu" class="collapse show card-body pb-0">
							<div class="row">
								<div class="col-sm-6 col-md-6 mt-2">
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Clave </label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" placeholder="Clave" name="clave_empresa" />
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Razón Social </label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" placeholder="Razón social" name="razon_social" />
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Email </label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" placeholder="Email" name="email" />
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Teléfono Secundario </label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" placeholder="Teléfono secundario" name="tel2" />
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Fecha de Creación </label>
										<div class="col-sm-8">
											<input type="date" class="form-control form-control-sm" name="fecha_crea" required />
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Comentarios</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" placeholder="comentario" maxlength="199" name="comentarios" />
										</div>
									</div>
								</div>
								<div class="col-sm-6 col-md-6 mt-2">
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">RFC</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" placeholder="RFC" name="rfc" />
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Curp</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" placeholder="Curp" name="curp" />
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Teléfono Principal</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" placeholder="Teléfono principal" name="tel1" />
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">FAX</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" placeholder="Fax" name="fax" />
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label"> Fecha de Modificación</label>
										<div class="col-sm-8">
											<input type="date" class="form-control form-control-sm" name="fecha_modi" required />
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label"> Régimen Fiscal</label>
										<div class="col-sm-8">
											<select class="form-control form-control-sm" name="clave_regfiscal_sat">
												<option value="0" selected="selected">Selecciona un Régimen Fiscal</option>
												<c:forEach items="${listaRegimenFiscal}" var="lista">
													<option value="<c:out value="${lista.clave}"> </c:out>">
														<c:out value="${lista.descripcion}"></c:out>
													</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Autor Última Modificación </label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" name="usuario" />
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Representante legal </label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" placeholder="Representante legal" name="representante_legal" />
										</div>
									</div>
									<div class=" form-group row ">
										<div class="col-md-12 mt-1 ">
											<button type="submit " class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto btnAppendConceptos ">Guardar</button>
										</div>
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