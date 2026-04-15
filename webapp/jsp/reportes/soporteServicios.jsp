<%--
################################################################################
# Autor               : Valverde Méndez Arturo                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 25/04/2018 #
# Descripcion General : Vista JSP para reporte Facturación de los Servicios    #
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
					action="${pageContext.request.contextPath}/home/reportes/soporte/find"
					method="POST" commandName="fuente" autocomplete="off">
					<div class="card-header">
						<span class="title" id="menu-toggle">Reporte Facturación de
							los Servicios</span> <span class="float-right text-secondary"
							id="btn-ocultar">Ocultar</span>
					</div>
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
											placeholder="Clave | Nombre corto"
											name="list_Clientes_report" />
									</div>
								</div>

								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Servicio</label>
									<div class="col-sm-8">
										<select
											class="custom-select descripcion_servicio form-control-sm"
											name="servicio" id="servicio">

											<option selected value="0">Opciones</option>
											<c:forEach items="${servicios}" var="servicio">

												<option value="${servicio.clave}"
													id="<c:out value="${servicio.descripcion}"></c:out>"
													${servicio.clave==clave ? 'selected="selected"' : ''}>

													<c:out value="${servicio.clave}"></c:out>

												</option>

											</c:forEach>
										</select>

									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Fecha Inicial</label>
									<div class="col-sm-8">

										<input class="form-control form-control-sm  col-md-12"
											name="fecha_inicial" id="fecha_inicial" type="date" required
											value="${pFechaInicial}" />

									</div>
								</div>

								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Fuente</label>
									<div class="col-sm-8">
										<select class="custom-select form-control-sm" name="fuente"
											id="fuente">

											<option selected value="0">Opciones</option>

											<c:forEach items="${fuentes}" var="fuente">

												<option value="${fuente.id_fuente}"
													${fuente.id_fuente==id_fuentes ? 'selected="selected"' : ''}>

													<c:out value="${fuente.clave}"></c:out>

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
									<label class="col-sm-4 col-form-label">Descripcion
										Servicio</label>
									<div class="col-sm-8">
										<input type="text"
											class="col-md-12 form-control-sm input_descripcion"
											disabled="disabled" placeholder="Descripcion"
											name="descripcion" />


									</div>
								</div>

								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Fecha Final</label>
									<div class="col-sm-8">
										<input class="form-control form-control-sm  col-md-12"
											name="fecha_final" id="fecha_final" type="date" required
											value="${pFechaFinal}" />
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
													value="consultar">
													<span class="mr-2">Consultar</span><span
														class="icon-search"></span>
												</button>
												<button type="submit" name="format" id="btnLogin"
													class="btn btn-secondary btn-sm btn-consulta" value="pdf"
													formtarget="_blank">
													<span class="mr-2">Exportar/Mensual</span><span
														class="icon-file-pdf"></span>
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
		<div class="col-md-12">
			<c:if test="${not empty reportes}">
				<div class="card mt-2">
					<div class="table-responsive">
						<table
							class="table table-scroll table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th>Fecha Datos</th>
									<th>Banco</th>
									<th>Nombre Corto</th>
									<th>Clave Negocio</th>
									<th>Descripcion Negocio</th>
									<th>Clave Grupo</th>
									<th>Nombre Grupo</th>
									<th>Servicio</th>
									<th>Descripcion del Servicio</th>
									<th>Clave Caja</th>
									<th>Nombre Caja</th>
									<th>Transacciones</th>
									<th>Precio</th>
									<th>Importe</th>
									<th>Desc.Adic. VoL</th>
									<th>Total Factura</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${reportes}" var="reportes">
									<tr>
										<td><c:out value="${reportes.fechadatos}"></c:out></td>
										<td><c:out value="${reportes.cvbanco}"></c:out></td>
										<td><c:out value="${reportes.nmbanco}"></c:out></td>
										<td><c:out value="${reportes.cvnegocio}"></c:out></td>
										<td><c:out value="${reportes.nmnegocio}"></c:out></td>
										<td><c:out value="${reportes.cvgrupoconcepto}"></c:out></td>
										<td><c:out value="${reportes.nmgrupoconcepto}"></c:out></td>
										<td><c:out value="${reportes.cvservicio}"></c:out></td>
										<td><c:out value="${reportes.nmservicio}"></c:out></td>
										<td><c:out value="${reportes.cvcaja}"></c:out></td>
										<td><c:out value="${reportes.nmcaja}"></c:out></td>
										<td><c:out value="${reportes.transacciones}"></c:out></td>
										<td><c:out value="${reportes.precio}"></c:out></td>
										<td><c:out value="${reportes.importe}"></c:out></td>
										<td><c:out value="${reportes.descadicional}"></c:out></td>
										<td><c:out value="${reportes.totalfactura}"></c:out></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<c:if test="${not empty registros_totales}">
					<sf:form
						action="${pageContext.request.contextPath}/home/reportes/soporte/find"
						method="POST" name="pagination">
						<%-- 						VARIABLES OBTENIDAS MEDIANTE JS --%>
						<input type="hidden" name="cliente" id="getlist_Clientes_r"
							class="globalGet">
						<input type="hidden" name="fuente" id="getfuente"
							class="globalGet">
						<input type="hidden" name="fecha_inicial" id="getfecha_inicial"
							class="globalGet">
						<input type="hidden" name="fecha_final" id="getfecha_final"
							class="globalGet">
						<input type="hidden" name="servicio" id="getservicio"
							class="globalGet">
						<input type="hidden" name="format" id="format" value="consultar">
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
			</c:if>

		</div>



	</div>


</div>
<%@ include file="../layout/footer.jsp"%>