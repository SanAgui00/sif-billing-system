<%--
################################################################################
# Autor               : Valverde Méndez Arturo                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 25/04/2018 #
# Descripcion General : Vista JSP para reporte Cobranza Diaria                 #
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
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<sf:form
					action="${pageContext.request.contextPath}/home/reportes/cobranza/find"
					method="POST" commandName="fuente" autocomplete="off">
					<div class="card-header">
						<span class="title" id="menu-toggle">Generar Reporte
							Cobranza</span> <span class="float-right text-secondary"
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
									<label class="col-sm-4 col-form-label">Proceso</label>
									<div class="col-sm-8">
										<select class="custom-select form-control-sm" name="proceso"
											id="proceso" required>

											<option selected value="">Opciones</option>


											<c:forEach items="${procesos}" var="proceso">

												<option value="${proceso.id_proceso}"
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
										<select class="custom-select form-control-sm" name="empresa"
											id="empresa">
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


								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Servicio</label>
									<div class="col-sm-8">
										<select
											class="custom-select descripcion_servicio form-control-sm"
											name="servicio" id="servicio">

											<option selected value="0">Opciones</option>
											<c:forEach items="${servicios}" var="servicio">

												<option value="${servicio.id_servicios}"
													id="<c:out value="${servicio.descripcion}"></c:out>"
													${servicio.id_servicios==id_servicios ? 'selected="selected"' : ''}>

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
									<label class="col-sm-4 col-form-label">Negocio</label>
									<div class="col-sm-8">
										<select class="custom-select form-control-sm" name="negocio"
											id="negocio">
											<option selected value="0">Opciones</option>

											<c:forEach items="${negocios}" var="negocio">

												<option value="${negocio.id_negocio}"
													${negocio.id_negocio==id_negocios ? 'selected="selected"' : ''}>

													<c:out value="${negocio.clave}"></c:out>

												</option>

											</c:forEach>
										</select>



									</div>
								</div>

								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Moneda</label>
									<div class="col-sm-8">
										<select class="custom-select form-control-sm" name="moneda"
											id="moneda" required>
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
												<button type="submit" name="accion" id="btnLogin"
													class="btn btn-secondary btn-sm btn-consulta"
													value="consultar">
													<span class="mr-2">Consultar</span><span
														class="icon-search"></span>
												</button>
												<button type="submit" name="accion" id="btnLogin"
													class="btn btn-secondary btn-sm btn-consulta"
													value="acumulado" formtarget="_blank">
													<span class="mr-2">Reporte Acumulado</span><span
														class="icon-file-pdf"></span>
												</button>
												<button type="submit" name="accion" id="btnLogin"
													class="btn btn-secondary btn-sm btn-consulta"
													value="reporte" formtarget="_blank">
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
		<div class="col-md-12">
			<c:if test="${not empty reportes}">
				<div class="card mt-2">
					<div class="table-responsive">
						<table
							class="table table-scroll table-striped table-bordered table-hover">
							<thead>
								<tr class="nowrap">
									<th>Clave Negocio</th>
									<th>Descripción Negocio</th>
									<th>Clave Servicio</th>
									<th>Descripcion Servicio</th>
									<th>Clave Cliente</th>
									<th>Nombre Cliente</th>
									<th>Fecha Datos</th>
									<th>Nombre Moneda</th>
									<th>Transacciones Cobranza Diaria</th>
									<th>Precio</th>
									<th>Tipo Cambio</th>
									<th>Importe Cobranza Diaria</th>
									<th>Descuento Cobranza Diaria</th>
									<th>Descuento Adicional</th>
									<th>Subtotal Cobranza Diaria</th>
									<th>IVA Cobranza Diaria</th>
									<th>Total Cobranza Diaria</th>
									<th>Ajuste</th>
									<th>Descuento Ajuste</th>
									<th>Subtotal Ajuste</th>
									<th>IVA Ajuste</th>
									<th>Total Ajuste</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach items="${reportes}" var="reportes">
									<tr class="nowrap">
										<td><c:out value="${reportes.CLAVE_NEGOCIO}"></c:out></td>
										<td><c:out value="${reportes.DESCRIPCION_NEGOCIO}"></c:out></td>
										<td><c:out value="${reportes.CLAVE_SERVICIO}"></c:out></td>
										<td><c:out value="${reportes.DESCRIPCION_SERVICIO}"></c:out></td>
										<td><c:out value="${reportes.CLAVE_CLIENTE}"></c:out></td>
										<td><c:out value="${reportes.NOMBRE_CLIENTE}"></c:out></td>
										<td><c:out value="${reportes.FECHA_DATOS}"></c:out></td>
										<td><c:out value="${reportes.NOMBRE_MONEDA}"></c:out></td>
										<td><c:out value="${reportes.TRX_COBDIA}"></c:out></td>
										<td><c:out value="${reportes.PRECIO}"></c:out></td>
										<td><c:out value="${reportes.TIPO_CAMBIO}"></c:out></td>
										<td><c:out value="${reportes.IMP_COBDIA}"></c:out></td>
										<td><c:out value="${reportes.DESC_COBDIA}"></c:out></td>
										<td><c:out value="${reportes.DESC_ADICIONAL}"></c:out></td>
										<td><c:out value="${reportes.SUBTOTAL_COBDIA}"></c:out></td>
										<td><c:out value="${reportes.IVA_COBDIA}"></c:out></td>
										<td><c:out value="${reportes.TOTAL_COBDIA}"></c:out></td>
										<td><c:out value="${reportes.AJUSTE}"></c:out></td>
										<td><c:out value="${reportes.DESC_AJUSTE}"></c:out></td>
										<td><c:out value="${reportes.SUBTOTAL_AJUSTE}"></c:out></td>
										<td><c:out value="${reportes.IVA_AJUSTE}"></c:out></td>
										<td><c:out value="${reportes.TOTAL_AJUSTE}"></c:out></td>


									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<c:if test="${not empty registros_totales}">
					<sf:form
						action="${pageContext.request.contextPath}/home/reportes/cobranza/find"
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
						<input type="hidden" name="moneda" id="getmoneda"
							class="globalGet">
						<input type="hidden" name="servicio" id="getservicio"
							class="globalGet">
						<input type="hidden" name="accion" id="accion" value="consultar">
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


		<div class="col-md-12">
			<c:if test="${not empty reportes_total}">
				<div class="card mt-2">
					<div class="table-responsive">
						<table
							class="table table-scroll table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th class="pt-2 pb-2 pl-3 pr-2">Clave Negocio</th>
									<th class="pt-2 pb-2 pl-3 pr-2">Descripción Negocio</th>
									<th class="pt-2 pb-2 pl-3 pr-2">Total de Transacciones de
										Cobranza</th>
									<th class="pt-2 pb-2 pl-3 pr-2">Total de Importe de
										Cobranza</th>
									<th class="pt-2 pb-2 pl-3 pr-2">Total Importe de Ajuste</th>
									<th class="pt-2 pb-2 pl-3 pr-2">Total de Descuento
										Especial</th>
									<th class="pt-2 pb-2 pl-3 pr-2">Total de Descuento
										Adicional por Volumen</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${reportes_total}" var="reportes_total">
									<tr>
										<td class="pt-2 pb-2 pl-3 pr-2"><c:out
												value="${reportes_total.CLAVE_NEGOCIO}"></c:out></td>
										<td class="pt-2 pb-2 pl-3 pr-2"><c:out
												value="${reportes_total.DESCRIPCION_NEGOCIO}"></c:out></td>
										<td class="pt-2 pb-2 pl-3 pr-2"><c:out
												value="${reportes_total.TOTAL_TRX_COBDIA}"></c:out></td>
										<td class="pt-2 pb-2 pl-3 pr-2"><c:out
												value="${reportes_total.TOTAL_IMP_COBDIA}"></c:out></td>
										<td class="pt-2 pb-2 pl-3 pr-2"><c:out
												value="${reportes_total.TOTAL_IMP_AJUSTE}"></c:out></td>
										<td class="pt-2 pb-2 pl-3 pr-2"><c:out
												value="${reportes_total.TOTAL_DESC_ESPECIAL}"></c:out></td>
										<td class="pt-2 pb-2 pl-3 pr-2"><c:out
												value="${reportes_total.TOTAL_DESC_ADICIONAL}"></c:out></td>

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

<%@ include file="../layout/footer.jsp"%>