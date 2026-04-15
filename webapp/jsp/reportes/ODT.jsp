<%--
################################################################################
# Autor               : Garnica Garcia David                                   #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 25/04/2018 #
# Descripcion General : Vista JSP para reporte ODT's Vigentes                  #
# Marca del cambio    :                                                        #
#------------------------------------------------------------------------------#
# Numero de Parametros: N/A                                                    #
# Parametros Entrada  : N/A                                  Formato:          #
# Parametros Salida   : N/A                                  Formato:          #
################################################################################
--%>
<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%-- fin de menu --%>
<div class="col-md-10 ml-sm-auto col-lg-10">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<sf:form
					action="${pageContext.request.contextPath}/home/reportes/odt/reporte"
					method="POST" commandName="fuente" autocomplete="off">
					<div class="card-header">
						<span class="title" id="menu-toggle">Reporte ODT's</span> <span class="float-right text-secondary"
							id="btn-ocultar">Ocultar</span>
					</div>
					<input type="hidden" id="path"
									value="${pageContext.request.contextPath}" />
					<div id="mainMenu" class="show card-body">
						<div class="row">
							<div class="col-sm-6 col-md-6 mt-2 mb-2">
								<input type="hidden" id="path"
									value="${pageContext.request.contextPath}" />
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Clientes</label>
									<div class="col-sm-8">
										<input type="text" id="list_Clientes_report"
								class="form-control form-control-sm ajax-form"
								${clave_cliente.equals("null") ? 'placeholder="Clave | Nombre corto"' : ''}
								value="${!clave_cliente.equals('null') ? clave_cliente : ''}"
								placeholder="Clave | Nombre corto" name="list_Clientes_report" />
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Fecha Datos
										Inicial</label>
									<div class="col-sm-8">

										<input class="form-control form-control-sm  col-md-12"
										name="fecha_inicial" type="date" required value="${pFechaInicial}" />

									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Moneda</label>
									<div class="col-sm-8">
										<select class="custom-select form-control-sm" name="moneda" required>
											<option selected value="">Opciones</option>
											<c:forEach items="${monedas}" var="moneda">
												<option value="${moneda.id_moneda}"
													${moneda.id_moneda==id_monedas ? 'selected="selected"' : ''}>
													<c:out value="${moneda.nombre_moneda}"></c:out>
												</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-6 mt-2 mb-2">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Descripcion</label>
									<div class="col-sm-8">
										<select class="custom-select form-control-sm"
							id="list_Clientes_report_r" name="cliente">
							<c:if
								test="${not empty id_clientes && not empty clave_cliente && not empty nombre_corto}">
								<option
									value="${id_clientes}&&${clave_cliente}&&${nombre_corto}">
									<c:out value="${clave_cliente}-${nombre_corto}"></c:out></option>
							</c:if>
						</select>
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Fecha Datos
										Final</label>
									<div class="col-sm-8">

										<input class="form-control form-control-sm  col-md-12" name="fecha_final"
										type="date" required value="${pFechaFinal}" />

									</div>
								</div>
								<div class="form-group row">
									<div class="form-group col-md-12 d-flex flex-row-reverse">
										<button type="submit"
											class="btn bg-danger text-white btn-sm float-right  mb-1 mt-auto d-none"
											id="reporte">Reporte</button>
										<div role="toolbar" aria-label="Contenedor de botones"
											class="btn-toolbar float-left pagination">
											<div class="btn-group mr-2" role="group"
												aria-label="Botones de reportes">
												<button type="submit" name="format" id="btnLogin"
												class="btn btn-secondary btn-sm btn-consulta"
												value="xls" formtarget="_blank">
													<span class="mr-2">Excel</span><span class="icon-file-excel"></span>
												</button>
												<button type="submit" name="format" id="btnLogin"
												class="btn btn-secondary btn-sm btn-consulta"
												value="pdf" formtarget="_blank">
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
			<%@ include file="../layout/footer.jsp"%>