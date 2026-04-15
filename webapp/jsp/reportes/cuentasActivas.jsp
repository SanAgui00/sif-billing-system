<%-- 
################################################################################
# Autor               : Valverde Méndez Arturo                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 25/04/2018 #
# Descripcion General : Vista JSP para reporte Cuentas Activas                 #
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
					action="${pageContext.request.contextPath}/home/reportes/cuentas/find"
					method="POST" commandName="fuente" autocomplete="off">
					<div class="card-header">
						<span class="title" id="menu-toggle">Reporte Cuentas Activas (Proalerta)</span> <span class="float-right text-secondary"
							id="btn-ocultar">Ocultar</span>
					</div>
					<div id="mainMenu" class="show card-body">
						<div class="row">
							<div class="col-sm-6 col-md-6 mt-2 mb-2">
								<input type="hidden" id="path"
									value="${pageContext.request.contextPath}" />
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Periodo</label>
									<div class="col-sm-8">
										<select
						class="custom-select form-control-sm" name="periodo" id="periodo" required>

						<option selected value="">Opciones</option>


						<c:forEach items="${periodos}" var="periodo">

							<option value="${periodo.id_periodos}"
							${periodo.id_periodos==id_periodos ? 'selected="selected"' : ''}>

								<c:out value="${periodo.nombre}"></c:out>

							</option>

						</c:forEach>
					</select>
									</div>
								</div>

								



							</div>
							<div class="col-sm-6 col-md-6 mt-2 mb-2">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Moneda</label>
									<div class="col-sm-8">
									<select
						class="custom-select form-control-sm" name="moneda" id="moneda" required>
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
													class="btn btn-secondary btn-sm btn-consulta" value="estadistico"
													formtarget="_blank">
													<span class="mr-2">Ver Reporte Estadístico</span><span class="icon-file-pdf"></span>
												</button>
												<button type="submit" name="accion" id="btnLogin"
													class="btn btn-secondary btn-sm btn-consulta" value="reporte"
													formtarget="_blank">
													<span class="mr-2">Ver Reporte</span><span class="icon-file-pdf"></span>
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
			<c:if test="${not empty reportes}" >
			<div class="card mt-2">
				<div class="table-responsive">
					<table
						class="table table-scroll table-striped table-bordered table-hover">
						<thead> 		
							<tr>
								<th>Banco</th>
								<th>Tipo Cambio</th>
								<th>Cuentas Activas Crédito</th>
								<th>Cuentas Activas Débito</th>
								<th>Cobro Mensual. Crédito</th>
								<th>Cobro Mensual Débito</th>
								<th>Precio Crédito</th>
								<th>Precio Débito</th>
								<th>Cuota Fija</th>
								<th>Total</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${reportes}" var="reportes">
								<tr>
									<td><c:out
										value="${reportes.nombre_corto}"></c:out></td>
								<td><c:out
										value="${reportes.tipo_cambio}"></c:out></td>
								<td><c:out
										value="${reportes.trans_credito}"></c:out></td>
								<td><c:out
										value="${reportes.trans_debito}"></c:out></td>
								<td><c:out
										value="${reportes.importe_credito}"></c:out></td>
								<td><c:out
										value="${reportes.importe_debito}"></c:out></td>
								<td><c:out
										value="${reportes.precio_credito}"></c:out></td>
								<td><c:out
										value="${reportes.precio_debito}"></c:out></td>
								<td><c:out
										value="${reportes.cuota_fija}"></c:out></td>
								<td><c:out
										value="${reportes.total}"></c:out></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<c:if test="${not empty registros_totales}">
				<sf:form
					action="${pageContext.request.contextPath}/home/reportes/cuentas/find"
					method="POST" name="pagination">
					<%-- 						VARIABLES OBTENIDAS MEDIANTE JS --%>
					<input type="hidden" name="periodo" id="getperiodo"
						class="globalGet">
					<input type="hidden" name="moneda" id="getmoneda"
						class="globalGet">
					<input type="hidden" name="accion" id="accion" value="consultar">
					<input type="hidden" name="registros_totales"
						id="registros_totales" class="registros_totales"
						value="${registros_totales}">
					<input type="hidden" name="fromRow" id="fromRow" class="fromRow"
						value="">

					<nav>
						<ul class="pagination  pagination-sm justify-content-end">
							<span class='page-link prev'><span class="icon-arrow_back"></span></span>
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