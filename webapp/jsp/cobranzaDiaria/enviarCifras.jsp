<%--
################################################################################
# Autor               : David Garnica                                 		   #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 21/05/2018 #
# Descripcion General : Vista JSP para Enviar Cifras a Cobro		           #
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
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<div class="card-header">
					<span class="title" id="menu-toggle">Enviar Cifras a Cobro</span> <span class="float-right text-secondary" id="btn-ocultar">Ocultar</span>
				</div>
				<sf:form action="${pageContext.request.contextPath}/home/cobranza/cifras/consulta" method="POST" commandName="envio" autocomplete="off">
					<input type="hidden" id="path" value="${pageContext.request.contextPath}" />
					<input type="hidden" id="type_list" value="${pageContext.request.contextPath}" />
					<div id="mainMenu" class="show card-body">
						<div class="collapse" id="general">
							<div class="row">
								<div class="col-sm-6 col-md-6 mt-2">
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Proceso</label>
										<div class="col-sm-8">
											<select class="form-control form-control-sm" name="id_proceso">
												<option value="0">Seleccionar una opcion</option>
												<c:forEach items="${listaProceso}" var="proceso">
													<option value="<c:out value=" ${proceso.id_proceso} "></c:out>">
														<c:out value="${proceso.clave_proceso}"></c:out>
													</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Cliente</label>
										<div class="col-sm-8">
											<input type="text" id="list_Clientes" class="form-control form-control-sm ajax-form" placeholder="Busca un cliente" name="list_Clientes" />
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Fecha Cobro Libra</label>
										<div class="col-sm-8">
											<input type="date" class="form-control form-control-sm" value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>" name="fecha_libra" required="required"/>
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Periodicidad </label>
										<div class="col-sm-8">
											<select class="form-control form-control-sm" name="periodicidad" required="required">
												<option value="null">Selecciona una opcion</option>
												<option value="DIA">Diaria</option>
												<option value="EVE">Eventual</option>
												<option value="MEN">Mensual</option>
											</select>
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Interfase </label>
										<div class="col-sm-8">
											<select class="form-control form-control-sm" name="interfase" required="required">
												<option value="null">Selecciona una opcion</option>
												<option value="LIB">Libra</option>
												<option value="MAN">Manual</option>
												<option value="SAC">SAC</option>
											</select>
										</div>
									</div>
								</div>
								<div class="col-sm-6 col-md-6 mt-2">
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Negocio</label>
										<div class="col-sm-8">
											<select class="form-control form-control-sm" name="id_negocio">
												<option value="0" selected="selected">Selecciona una opcion</option>
												<c:forEach items="${listaNegocios}" var="catNegocio">
													<option value="<c:out value="${catNegocio.id_negocio}"></c:out>">
														<c:out value="${catNegocio.clave}"></c:out>
													</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Descripción</label>
										<div class="col-sm-8">
											<select class="form-control form-control-sm d-none " id="list_Clientes_r" name="id_cliente">
											</select> <select class="form-control form-control-sm " id="listaDeClientes" name="id_cliente">
												<option value="0">Selecciona una opcion</option>
												<c:forEach items="${listaClientes}" var="lista">
													<option value="<c:out value="${lista.id_cliente}"> </c:out>">
														<c:out value="${lista.clave_cliente}"></c:out> -
														<c:out value="${lista.nombre_corto}"></c:out></option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Fecha Cobro SAC</label>
										<div class="col-sm-8">
											<input type="date" class="form-control form-control-sm" value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>" name="fecha_sac" required="required"/>
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Tipo de Documento</label>
										<div class="col-sm-8">
											<select class="form-control form-control-sm" name="tipo_documento">
												<option value="">Selecciona una opcion</option>
												<option value="ABI">Factura Abierta</option>
												<option value="NOT">Nota de Credito</option>
												<option value="ODT">ODT</option>
												<option value="SER"">Servicio Facturar</option>
											</select>
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label"></label>
										<div class="col-sm-8">
											<button type="submit" class="btn btn-secondary text-white btn-sm float-right bordered  mb-1 mt-auto ">Consultar</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</sf:form>
			</div>
		</div>
		<div class="col-sm-12">
			<c:if test="${not empty consulta}">
				<div class="card mt-2">
					<div class="table-responsive">
						<table class="table table-scroll table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th>Clave</th>
									<th>Nombre Corto</th>
									<th>Clave Negocio</th>
									<th>Descripción</th>
									<th>Fecha Cálculo</th>
									<th>Fecha Cobro SAC</th>
									<th>Fecha Cobro Libra</th>
									<th>Fecha Cobro Manual</th>
									<th>Tipo Documento</th>
									<th>Concepto de Envio</th>
									<th>Interfase</th>
									<th>Moneda</th>
									<th>Importe</th>
									<th>IVA</th>
									<th>Marcar</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${consulta}" var="consulta">
									<tr>
										<td>${consulta.clave_cliente}</td>
										<td>${consulta.nombre_corto_cliente}</td>
										<td>${consulta.clave_negocio}</td>
										<td>${consulta.descripcion_negocio}</td>
										<td>${consulta.fecha_calculo}</td>
										<td>${consulta.fecha_cobro_sac}</td>
										<td>${consulta.fecha_cobro_libra}</td>
										<td></td>
										<td>${consulta.tipo_documento}</td>
										<td></td>
										<td>${consulta.sistema_cobro}</td>
										<td>${consulta.nombre_moneda}</td>
										<td>${consulta.importe}</td>
										<td>${consulta.iva}</td>
										
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