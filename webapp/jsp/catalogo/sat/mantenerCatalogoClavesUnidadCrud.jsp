<%--
################################################################################
# Autor               : Sanchez Aguilar Jesus Alfonso                          #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 25/04/2018 #
# Descripcion General : Vista JSP para  Catalógo SAT 						   # 
#  Formas de Pago   	   	 	                     					       #
# Marca del cambio    :                                                        #
#------------------------------------------------------------------------------#
# Numero de Parametros: N/A                                                    #
# Parametros Entrada  : N/A                                  Formato:          #
# Parametros Salida   : N/A                                  Formato:          #
################################################################################
--%>
<%@ include file="../../layout/header.jsp"%>
<%@ include file="../../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
<c:if test="${event=='delete'}">
	<div class="card mt-2 general-title">
		<div class="card">
			<div class="form-row h-100">


				<div class="form-group auto col-sm-12 the-title">
					
						<sf:form
							action="${pageContext.request.contextPath}/home/cat/sat/unidad/save"
							method="POST" name="insert">
							<c:forEach items="${editar}" var="editar">
								<input name="evento" type="hidden" value="delete" />
								<input name="idUnidad" type="hidden" value="${editar.id}" />
								<div class="card-header">
									<span class="title" id="menu-toggle">Eliminar</span> <a
										class="float-right text-secondary"
										href="<c:url value='/home/cat/sat/unidad'/>" role="button">Regresar</a>
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
												href="<c:url value='/home/cat/sat/unidad'/>"
												role="button">Regresar</a>
										</div>
									</div>
								</div>
							</c:forEach>
						</sf:form>
					

				</div>
			</div>
		</div>
	</div>
	</c:if>
	<c:if test="${event=='edit'}">
		<div class="card mt-2 general-title">
			<div class="card">
				<div class="form-row h-100">
					<div class="form-group auto col-sm-12 the-title">
						<sf:form
							action="${pageContext.request.contextPath}/home/cat/sat/unidad/save"
							method="POST" name="insert">
							<c:forEach items="${editar}" var="editar">
								<input name="evento" type="hidden" value="update" />
								<input name="idUnidad" type="hidden" value="${editar.id}" />
								<div class="card-header">
									<span class="title" id="menu-toggle">Editando a <c:out
											value="${editar.clave}"></c:out></span> <a
										class="float-right text-secondary"
										href="<c:url value='/home/cat/sat/unidad'/>" role="button">Regresar</a>
								</div>
								<div id="mainMenu" class="show card card-body">

									<div class="row">
										<div class="col-sm-6 col-md-6 mt-2 mb-2">
											<input type="hidden" id="path"
												value="${pageContext.request.contextPath}" />
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Clave</label>
												<div class="col-sm-8">
													<input type="text" class="form-control form-control-sm"
														name="clave" value="${editar.clave}">
												</div>
											</div>
											
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Simbolo</label>
												<div class="col-sm-8">
													<input type="text" class="form-control form-control-sm"
														name="simbolo" value="${simbolo.descripcion}">
												</div>
											</div>

											
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Estatus</label>
												<div class="col-sm-8">
													<select class="form-control form-control-sm" name="estatus">
														<option value="ACT"
															${ 'ACT'==editar.estatus ? 'selected="selected"' : ''}>Activo</option>
														<option value="NOA"
															${ 'NOA'==editar.estatus ? 'selected="selected"' : ''}>Eliminado</option>
													</select>
												</div>
											</div>
											
										</div>
										<div class="col-sm-6 col-md-6 mt-2 mb-2">
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Descripcion</label>
												<div class="col-sm-8">
													<input type="text" class="form-control form-control-sm"
														name="descripcion" value="${editar.descripcion}">
												</div>
											</div>
											<div class="form-group row">
												<label class="col-sm-4 col-form-label">Usuario</label>
												<div class="col-sm-8">
													<input type="text" class="form-control form-control-sm"
														name="usuario" value="${editar.usuario}" disabled="disabled">
												</div>
											</div>
											
											<div class="form-group row">
												<div class="form-group col-md-12 d-flex flex-row-reverse">
													<button id="btnCon" type="submit"
														class="btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Actualizar</button>
												</div>
											</div>
										</div>
									</div>
								</div>



							</c:forEach>
						</sf:form>
					</div>
				</div>
			</div>
		</div>


	</c:if>
	<c:if test="${event=='new'}">
		<div class="card mt-2 general-title">
			<div class="card">
				<div class="form-row h-100">
					<div class="form-group auto col-sm-12 the-title">
						<sf:form
							action="${pageContext.request.contextPath}/home/cat/sat/unidad/save"
							method="POST" name="insert">
							<input name="evento" type="hidden" value="insert" />
							<div class="card-header">
								<span class="title" id="menu-toggle">Nueva Claves de unidadad</span> <a
									class="float-right text-secondary"
									href="<c:url value='/home/cat/sat/unidad'/>" role="button">Regresar</a>
							</div>
							<div id="mainMenu" class="show card card-body">
								<div class="row">
									<div class="col-sm-6 col-md-6 mt-2 mb-2">
										<input type="hidden" id="path"
											value="${pageContext.request.contextPath}" />
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Clave</label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm"
													name="clave">
											</div>
										</div>
										<div class="form-group row">
												<label class="col-sm-4 col-form-label">Simbolo</label>
												<div class="col-sm-8">
													<input type="text" class="form-control form-control-sm"
														name="simbolo" value="${editar.descripcion}">
												</div>
											</div>
										
									</div>
									
									<div class="col-sm-6 col-md-6 mt-2 mb-2">
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Descripcion</label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm"
													name="descripcion">
											</div>
										</div>
										<div class="form-group row">
											<div class="form-group col-md-12 d-flex flex-row-reverse">
												<button id="btnCon" type="submit"
													class="btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Guardar</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</sf:form>
					</div>
				</div>
			</div>
		</div>
	</c:if>
</div>
<%@ include file="../../layout/footer.jsp"%>