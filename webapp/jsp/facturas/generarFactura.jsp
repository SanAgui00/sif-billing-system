<%--
################################################################################
# Autor               : Loredo                                        		   #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 21/05/2018 #
# Descripcion General : Vista JSP de generacion de facturas 		           #
# Marca del cambio    :                                                        #
#------------------------------------------------------------------------------#
# Numero de Parametros: N/A                                                    #
# Parametros Entrada  : N/A                                  Formato:          #
# Parametros Salida   : N/A                                  Formato:          #
################################################################################
--%>
<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<sf:form
		action="${pageContext.request.contextPath}/home/facturasgeneral/consulta"
		method="POST" autocomplete="off">
		<input type="hidden" id="path"
			value="${pageContext.request.contextPath}" />
		<input type="hidden" id="type_list"
			value="${pageContext.request.contextPath}" />
		<div class="row">
			<div class="col-sm-12">
				<div class="card mt-1">
					<div class="card-header">
						<span class="title" id="menu-toggle">Generar Facturas y
							Recibos</span> <span class="float-right text-secondary" id="btn-ocultar">Ocultar</span>
					</div>
					<div class="tab-content" id="mainMenu">
						<div class="tab-pane  show active" id="tab1" role="tabpanel"
							aria-labelledby="tab-1">
							<div class="card-body pb-0">
								<div class="row">
									<div class="col-sm-6 col-md-6 mt-1">
										<div class="form-group row">
											<label class="col-sm-5 col-form-label">Proceso:</label>
											<div class="col-sm-7">
												<select
													class="ajax-form-negocio form-control form-control-sm"
													name="proceso" id="proceso">
													<option value="0">Selecciona una opcion</option>
													<c:forEach items="${listaProceso}" var="listaProceso">
														<option
															value="<c:out value="${listaProceso.id_proceso}"> </c:out>"
															${listaProceso.id_proceso==proceso ? 'selected="selected"' : ''}>
															<c:out value="${listaProceso.clave_proceso}"></c:out>
														</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-6 mt-1">
										<div class="form-group row">
											<label class="col-sm-5 col-form-label">Negocio:</label>
											<div class="col-sm-7">

												<select class="form-control form-control-sm"
													name="id_negocio" id="id_negocio">
													<option value="">Selecciona una opcion</option>
													<c:forEach items="${listaNegocios}" var="lista">
														<option
															value="<c:out value="${lista.id_negocio}"> </c:out>"
															${lista.id_negocio==negocio ? 'selected="selected"' : ''}>
															<c:out value="${lista.clave}"></c:out>
														</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-6 mt-1">
										<div class="form-group row">
											<label class="col-sm-5 col-form-label">Buscar
												Cliente:</label>
											<div class="col-sm-7">
												<input type="text" id="list_Clientes"
													class="form-control form-control-sm ajax-form"
													placeholder="Busca un cliente" name="list_Clientes" />
											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-6 mt-1">
										<div class="form-group row">
											<label class="col-sm-5 col-form-label">Selecciona
												Cliente:</label>
											<div class="col-sm-7">
												<select class="form-control form-control-sm d-none "
													id="list_Clientes_r" name="id_cliente">
												</select> <select class="form-control form-control-sm "
													id="listaDeClientes" name="id_cliente">
													<option value="0">Selecciona una opcion</option>
													<c:forEach items="${listaClientes}" var="lista">
														<option
															value="<c:out value="${lista.id_cliente}"> </c:out>">
															<c:out value="${lista.clave_cliente}"></c:out> -
															<c:out value="${lista.nombre_corto}"></c:out>
														</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-6 mt-1">
										<div class="form-group row">
											<label class="col-sm-5 col-form-label">Moneda:</label>
											<div class="col-sm-7">
												<select class="form-control form-control-sm" name="">
													<option value="" selected="selected">selecciona
														una opcion</option>
													<c:forEach items="${listaMonedas}" var="lista">
														<option
															value="<c:out value="${lista.id_moneda}"> </c:out>">
															<c:out value="${lista.nombre_moneda}"></c:out>
														</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-6 mt-1">
										<div class="form-group row">
											<label class="col-sm-5 col-form-label">Periodo:</label>
											<div class="col-sm-7">
												<select class="form-control form-control-sm" name="">
													<option value="" selected="selected">selecciona
														una opcion</option>
													<c:forEach items="${listaPeriodos}" var="lista">
														<option
															value="<c:out value="${lista.id_periodos}"> </c:out>"
															${lista.id_periodos==id_periodo ? 'selected="selected"' : ''}>
															<c:out value="${lista.nombre}"></c:out>
														</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-6 mt-1">
										<div class="form-group row">
											<label class="col-sm-5 col-form-label">Tipo de
												Documento:</label>
											<div class="col-sm-7">
												<select class="form-control form-control-sm" name="">
													<option value="" selected="selected">selecciona
														una opcion</option>
													<option value="SER">Factura de Servicios</option>
													<option value="COM">Facturas de Compensación</option>
													<option value="ABI">Facturas Abiertas</option>
													<option value="NOT">Notas de Crédito</option>
													<option value="ODT">ODT</option>
												</select>

											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-6 mt-1">
										<div class="form-group row">
											<label class="col-sm-5 col-form-label">Fecha Factura:</label>
											<div class="col-sm-7">
												<input type="date" class="form-control form-control-sm"
													id="fecha_inicial" name="fecha_inicial"
													value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>">
											</div>
										</div>
									</div>

									<div class="col-sm-6 col-md-6 mt-1">
										<div class="form-group row">
											<label class="col-sm-5 col-form-label">Inicio del
												Perido:</label>
											<div class="col-sm-7">
												<input type="date" class="form-control form-control-sm"
													id="fecha_inicial" name="fecha_inicial"
													value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>">
											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-6 mt-1">
										<div class="form-group row">
											<label class="col-sm-5 col-form-label">Fin del
												Perido:</label>
											<div class="col-sm-7">
												<input type="date" class="form-control form-control-sm"
													id="fecha_inicial" name="fecha_inicial"
													value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>">
											</div>
										</div>
									</div>

									<div class="col-sm-12 col-md-12 mt-0 mb-2">
										<button type="submit"
											class="btn btn-secondary text-white btn-sm float-right mt-auto">Consultar</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</sf:form>
	<%-- inicio de tabla --%>
	<%-- inicio de tabla --%>
	<%-- inicio de tabla --%>
	<div class="row">
		<div class="col-sm-12">
			<c:if test="${not empty consulta}">
				<div class="card mt-2">
					<div class="table-responsive">
						<table
							class="table table-scroll table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th>Clave Negocio</th>
									<th>Clave Cliente</th>
									<th>Nombre Corto del Cliente</th>
									<th>Contacto</th>
									<th>Subtotal</th>
									<th>Importe Descuento Especial</th>
									<th>Importe Descuento Adicional por Volumen</th>
									<th>Subtotal Factura</th>
									<th>IVA</th>
									<th>Total</th>
									<th>Recibo</th>
									<th>Moneda</th>
									<th>Opcion Marcar Generar</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${consulta}" var="consulta">
									<tr>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</c:if>
		</div>
	</div>
	<%-- fin de tabla --%>
	<%-- fin de tabla --%>
	<%-- fin de tabla --%>
</div>
<%@ include file="../layout/footer.jsp"%>