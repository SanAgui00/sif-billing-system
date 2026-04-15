<%--
################################################################################
# Autor               : Valverde Méndez Arturo                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 25/04/2018 #
# Descripcion General : Vista JSP para reporte Consecutivo de Folios           #
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
					action="${pageContext.request.contextPath}/home/reportes/folios/find"
					method="POST" commandName="fuente" autocomplete="off">
					<div class="card-header">
					<input type="hidden" id="path"
									value="${pageContext.request.contextPath}" />
						<span class="title" id="menu-toggle">Reporte Consecutivo
							Folio</span> <span class="float-right text-secondary" id="btn-ocultar">Ocultar</span>
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
											id="proceso">

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
										<select class="custom-select form-control-sm" name="empresa"
											id="empresa" required>
											<option selected value="">Opciones</option>
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
									<label class="col-sm-4 col-form-label">Fecha Inicial</label>
									<div class="col-sm-8">

										<input class="form-control form-control-sm  col-md-12"
											name="fecha_inicial" id="fecha_inicial" type="date" required
											value="${pFechaInicial}" />

									</div>
								</div>

								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Tipo Documento</label>
									<div class="col-sm-8">
										<select class="custom-select form-control form-control-sm"
											name="documento" id="documento" required>
											<option selected value="">Opciones</option>
											<option
												${documento.equals("SER") ? 'selected="selected"' : ''}
												value="SER">Factura</option>
											<option
												${documento.equals("ABI") ? 'selected="selected"' : ''}
												value="ABI">Factura Abierta</option>
											<option
												${documento.equals("NOT") ? 'selected="selected"' : ''}
												value="NOT">Nota de Credito</option>
											<option
												${documento.equals("REC") ? 'selected="selected"' : ''}
												value="REC">Recibo</option>
										</select>

									</div>
								</div>

								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Serie</label>
									<div class="col-sm-8">

										<select class="custom-select form-control form-control-sm"
											name="serie_value" id="serie_value" required>
											<option selected value="">Opciones</option>
											<option ${serie.equals("A") ? 'selected="selected"' : ''}
												value="A">A</option>
											<option ${serie.equals("B") ? 'selected="selected"' : ''}
												value="B">B</option>
											<option ${serie.equals("C") ? 'selected="selected"' : ''}
												value="C">C</option>
											<option ${serie.equals("D") ? 'selected="selected"' : ''}
												value="D">D</option>
											<option ${serie.equals("E") ? 'selected="selected"' : ''}
												value="E">E</option>
											<option ${serie.equals("F") ? 'selected="selected"' : ''}
												value="F">F</option>
											<option ${serie.equals("G") ? 'selected="selected"' : ''}
												value="G">G</option>
											<option ${serie.equals("H") ? 'selected="selected"' : ''}
												value="H">H</option>
											<option ${serie.equals("I") ? 'selected="selected"' : ''}
												value="I">I</option>
											<option ${serie.equals("J") ? 'selected="selected"' : ''}
												value="J">J</option>
											<option ${serie.equals("K") ? 'selected="selected"' : ''}
												value="K">K</option>
											<option ${serie.equals("L") ? 'selected="selected"' : ''}
												value="L">L</option>
											<option ${serie.equals("M") ? 'selected="selected"' : ''}
												value="M">M</option>
											<option ${serie.equals("N") ? 'selected="selected"' : ''}
												value="N">N</option>
											<option ${serie.equals("O") ? 'selected="selected"' : ''}
												value="O">O</option>
											<option ${serie.equals("P") ? 'selected="selected"' : ''}
												value="P">P</option>
											<option ${serie.equals("Q") ? 'selected="selected"' : ''}
												value="Q">Q</option>
											<option ${serie.equals("R") ? 'selected="selected"' : ''}
												value="R">R</option>
											<option ${serie.equals("S") ? 'selected="selected"' : ''}
												value="S">S</option>
											<option ${serie.equals("T") ? 'selected="selected"' : ''}
												value="T">T</option>
											<option ${serie.equals("U") ? 'selected="selected"' : ''}
												value="U">U</option>
											<option ${serie.equals("V") ? 'selected="selected"' : ''}
												value="V">V</option>
											<option ${serie.equals("W") ? 'selected="selected"' : ''}
												value="W">W</option>
											<option ${serie.equals("X") ? 'selected="selected"' : ''}
												value="X">X</option>
											<option ${serie.equals("Y") ? 'selected="selected"' : ''}
												value="Y">Y</option>
											<option ${serie.equals("Z") ? 'selected="selected"' : ''}
												value="Z">Z</option>
											<option ${serie.equals("AA") ? 'selected="selected"' : ''}
												value="AA">AA</option>
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
									<label class="col-sm-4 col-form-label">Negocio</label>
									<div class="col-sm-8">
										<select class="custom-select form-control-sm" name="negocio"
											id="negocio">
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
									<label class="col-sm-4 col-form-label">Moneda</label>
									<div class="col-sm-8">
										<select class="custom-select form-control-sm" name="moneda"
											id="moneda">
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

								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Fecha Final</label>
									<div class="col-sm-8">
										<input class="form-control form-control-sm  col-md-12"
											name="fecha_final" id="fecha_final" type="date" required
											value="${pFechaFinal}" />

									</div>
								</div>


								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Estatus</label>
									<div class="col-sm-8">
										<select class="custom-select form-control form-control-sm "
											name="estatus" id="estatus">
											<option selected value="null">Opciones</option>
											<option ${estatus.equals("IMP") ? 'selected="selected"' : ''}
												value="IMP">Impreso</option>
											<option ${estatus.equals("REI") ? 'selected="selected"' : ''}
												value="REI">Reimpreso</option>
											<option ${estatus.equals("CAN") ? 'selected="selected"' : ''}
												value="CAN">Cancelados</option>
											<option ${estatus.equals("RES") ? 'selected="selected"' : ''}
												value="RES">Reservados</option>
										</select>


									</div>
								</div>


								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Subtitulo</label>
									<div class="col-sm-8">

										<input class=" form-control form-control-sm" type="text"
											maxlength="80" name="subtitulo" id="subtitulo">

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
													class="btn btn-secondary btn-sm btn-consulta" value="xls"
													formtarget="_blank">
													<span class="mr-2">Excel</span><span
														class="icon-file-excel"></span>
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
									<th>Folio Impreso</th>
									<th>Folio Interno</th>
									<th>Tipo Documento</th>
									<th>Clave Proceso</th>
									<th>Descripcion proceso</th>
									<th>Clave Negocio</th>
									<th>Descripción Negocio</th>
									<th>RFC</th>
									<th>Clave Cliente</th>
									<th>Razón Social</th>
									<th>Nombre Corto</th>
									<th>Domicilio</th>
									<th>Fecha Tipo Documento</th>
									<th>Concepto</th>
									<th>Moneda</th>
									<th>Importe Total</th>
									<th>Descuento</th>
									<th>Importe IVA</th>
									<th>Total</th>
									<th>Tipo Cambio</th>
									<th>Fecha Reservación</th>
									<th>Fecha Impresión</th>
									<th>Fecha Cobro</th>
									<th>Estatus</th>
									<th>Referencia</th>
									<th>Comentarios</th>
									<th>Fecha Factura</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach items="${reportes}" var="reportes">
									<tr class="nowrap">
										<td><c:out value="${reportes.serie}"></c:out> <c:out
												value="${reportes.numero}"></c:out></td>
										<td><c:out value="${reportes.folio}"></c:out></td>
										<td><c:choose>
												<c:when test="${reportes.tipo_documento=='SER'}">
											FACTURA DE SERVICIOS
									</c:when>
												<c:when test="${reportes.tipo_documento=='ABI'}">
											FACTURA ABIERTA									
									</c:when>
												<c:when test="${reportes.tipo_documento=='NOT'}">
											NOTA DE CRÉDITO
									</c:when>
												<c:otherwise>
            								OTRO DOCUMENTO
         								</c:otherwise>
											</c:choose></td>
										<td><c:out value="${reportes.clave_proceso}"></c:out></td>
										<td><c:out value="${reportes.descripcion_proceso}"></c:out></td>
										<td><c:out value="${reportes.clave}"></c:out></td>
										<td><c:out value="${reportes.descripcion_negocio}"></c:out></td>
										<td><c:out value="${reportes.rfc}"></c:out></td>
										<td><c:out value="${reportes.clave_cliente}"></c:out></td>
										<td><c:out value="${reportes.razon_social}"></c:out></td>
										<td><c:out value="${reportes.nombre_corto}"></c:out></td>
										<td><c:out value="${reportes.direccion_cliente}"></c:out></td>
										<td><c:out value="${reportes.fecha_datos}"></c:out></td>
										<td><c:out value="${reportes.concepto_descripcion}"></c:out></td>
										<td><c:out value="${reportes.nombre_moneda}"></c:out></td>
										<td><c:out value="${reportes.subtotal_monto}"></c:out></td>
										<td><c:out value="${reportes.descuento}"></c:out></td>
										<td><c:out value="${reportes.importe_iva}"></c:out></td>
										<td><c:out value="${reportes.total}"></c:out></td>
										<td><c:out value="${reportes.tipo_cambio}"></c:out></td>
										<td><c:out value="${reportes.fecha_reservacion}"></c:out></td>
										<td><c:out value="${reportes.fecha_ult_impresion}"></c:out></td>
										<td></td>
										<td><c:out value="${reportes.estatus}"></c:out></td>
										<td><c:out value="${reportes.numero}"></c:out></td>
										<td><c:out value="${reportes.comentarios}"></c:out></td>
										<td><c:out value="${reportes.fecha_datos}"></c:out></td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<c:if test="${not empty registros_totales}">
					<sf:form
						action="${pageContext.request.contextPath}/home/reportes/folios/find"
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
						<input type="hidden" name="documento" id="getdocumento"
							class="globalGet">
						<input type="hidden" name="estatus" id="getestatus"
							class="globalGet">
						<input type="hidden" name="subtitulo" id="getsubtitulo"
							class="globalGet">
						<input type="hidden" name="serie_value" id="getserie_value"
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