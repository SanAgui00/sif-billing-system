<%--
################################################################################
# Autor               : Valverde Méndez Arturo                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 25/04/2018 #
# Descripcion General : Vista JSP para reporte Tesorería                       #
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
					action="${pageContext.request.contextPath}/home/reportes/tesoreria/find"
					method="POST" commandName="fuente" autocomplete="off">
					<div class="card-header">
						<span class="title" id="menu-toggle">Reporte Tesoreria</span> <span
							class="float-right text-secondary" id="btn-ocultar">Ocultar</span>
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
									<label class="col-sm-4 col-form-label">Proceso</label>
									<div class="col-sm-8">
										<select class="custom-select form-control-sm" name="proceso" id="proceso">

											<option selected value="0&&null">Opciones</option>


											<c:forEach items="${procesos}" var="proceso">

												<option
													value="${proceso.id_proceso}&&${proceso.clave_proceso}"
													${proceso.id_proceso==id_procesos ? 'selected="selected"' : ''}>

													<c:out value="${proceso.clave_proceso}"></c:out>

												</option>

											</c:forEach>
										</select>

									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Empresa</label>
									<div class="col-sm-8">
										<select class="custom-select form-control-sm" name="empresa" id="empresa">
											<option selected value="0">Opciones</option>
											<c:forEach items="${empresas}" var="empresa">


												<option value="${empresa.id_empresa}"
													${empresa.id_empresa==id_empresas ? 'selected="selected"' : ''}>

													<c:out value="${empresa.clave_empresa}"></c:out>

												</option>

											</c:forEach>
										</select>
									</div>
								</div>
								<input type="hidden" id="path"
									value="${pageContext.request.contextPath}" />
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Fecha Cobro
										Libra</label>
									<div class="col-sm-8">

										<input class="form-control form-control-sm  col-md-12"
											name="fecha_inicial" id="fecha_inicial" type="date" value="${pFechaInicial}"
											required />

									</div>
								</div>


								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Moneda</label>
									<div class="col-sm-8">
										<select class="custom-select form-control-sm" name="moneda" id="moneda">
											<option selected value="0&&null">Opciones</option>

											<c:forEach items="${monedas}" var="moneda">

												<option value="${moneda.id_moneda}&&${moneda.nombre_moneda}"
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
											id="list_Clientes_r" name="cliente">
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
									<label class="col-sm-4 col-form-label">Negocio</label>
									<div class="col-sm-8">
										<select class="custom-select form-control-sm" name="negocio" id="negocio">
											<option selected value="0&&null">Opciones</option>

											<c:forEach items="${negocios}" var="negocio">

												<option value="${negocio.id_negocio}&&${negocio.clave}"
													${negocio.id_negocio==id_negocios ? 'selected="selected"' : ''}>

													<c:out value="${negocio.clave}"></c:out>

												</option>

											</c:forEach>
										</select>


									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Tipo de Reporte</label>
									<div class="col-sm-8">
										<select class="custom-select form-control-sm " name="tipo_rep" id="tipo_rep">
											<option
												${tipo_rep.equals("null") ? 'selected="selected"' : ''}
												selected value="null">Opciones</option>
											<option ${tipo_rep.equals("PI") ? 'selected="selected"' : ''}
												value="PI">Por Interfase</option>
											<option ${tipo_rep.equals("IF") ? 'selected="selected"' : ''}
												value="IF">Integracion de Facturacion</option>
											<option ${tipo_rep.equals("GE") ? 'selected="selected"' : ''}
												value="GE">Global de Envio (Historico)</option>

										</select>

									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Fecha Cobro Sac</label>
									<div class="col-sm-8">

										<input class="form-control form-control-sm  col-md-12"
											name="fecha_final" id="fecha_final" type="date" value="${pFechaFinal}"
											required />

									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Interfase</label>
									<div class="col-sm-8">
										<select class="custom-select form-control-sm "
											name="interfase" id="interfase">
											<option
												${interfase.equals("null") ? 'selected="selected"' : ''}
												selected value="null">Opciones</option>
											<option
												${interfase.equals("LIB") ? 'selected="selected"' : ''}
												value="LIB">Libra</option>
											<option
												${interfase.equals("SAC") ? 'selected="selected"' : ''}
												value="SAC">SAC</option>
											<option
												${interfase.equals("MAN") ? 'selected="selected"' : ''}
												value="MAN">Manual</option>

										</select>


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
		<div class="col-md-12 mb-2">
			<div class="card mt-2">
				<c:if test="${not empty reportes}">
					<div class="table-responsive">
						<table
							class="table table-scroll table-striped table-bordered table-hover">
							<thead>

								<tr>
									<th>Folio</th>
									<th>Cliente</th>
									<th>Interfase</th>
									<th>Fecha de Envío</th>
									<th>Fecha de Cobro</th>
									<th>Concepto</th>
									<th>Importe de Cargo</th>
									<th>IVA Cargo</th>
									<th>Total de Cargo</th>
									<th>Importe de Abono</th>
									<th>IVA de Abono</th>
									<th>Total de Abono</th>

								</tr>
							</thead>

							<tbody>
								<c:forEach items="${reportes}" var="reportes">
									<tr>
										<td><c:out value="${reportes.folio_temporal}"></c:out>
										<td><c:out value="${reportes.nombre_corto}"></c:out></td>
										<td><c:out value="${reportes.interfase}"></c:out></td>
										<td><c:out value="${reportes.fecha_envio}"></c:out></td>
										<td><c:out value="${reportes.fecha_cobro}"></c:out></td>
										<td><c:out value="${reportes.descripcion_cobros}"></c:out></td>
										<td><c:out value="${reportes.importe_de_cargo}"></c:out></td>
										<td><c:out value="${reportes.iva_de_cargo}"></c:out></td>
										<td><c:out value="${reportes.total_de_cargo}"></c:out></td>
										<td><c:out value="${reportes.importe_de_abono}"></c:out></td>
										<td><c:out value="${reportes.iva_de_abono}"></c:out></td>
										<td><c:out value="${reportes.total_de_abono}"></c:out></td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
					<c:if test="${not empty registros_totales}">
						<sf:form
							action="${pageContext.request.contextPath}/home/reportes/tesoreria/find"
							method="POST" name="pagination">
							<%-- 						VARIABLES OBTENIDAS MEDIANTE JS --%>
							<input type="hidden" name="cliente" id="getlist_Clientes_r"
								class="globalGet">
							<input type="hidden" name="proceso" id="getproceso"
								class="globalGet">
							<input type="hidden" name="negocio" id="getnegocio"
								class="globalGet">
							<input type="hidden" name="fecha_inicial" id="getfecha_inicial"
								class="globalGet">
							<input type="hidden" name="fecha_final" id="getfecha_final"
								class="globalGet">
							<input type="hidden" name="empresa" id="getempresa"
								class="globalGet">
							<input type="hidden" name="tipo_rep" id="gettipo_rep"
								class="globalGet">
							<input type="hidden" name="moneda" id="getmoneda"
								class="globalGet">
							<input type="hidden" name="moneda" id="getmoneda"
								class="globalGet">
							<input type="hidden" name="interfase" id="getinterfase"
								class="globalGet">
							<input type="hidden" name="format" id="format"
								value="consultar">

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
</div>
<%@ include file="../layout/footer.jsp"%>