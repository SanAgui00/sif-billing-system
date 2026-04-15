<%--
################################################################################
# Autor               : Sanchez Aguilar Jesus Alfonso                          #
# Compania            :  Código Geek                                           #
# Proyecto/Procliente :                                      Fecha: 25/04/2018 #
# Descripcion General : Vista JSP Enviar Cifras     						   # 
#  Mï¿½todos de Pago		 	 	                     			           #
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
<div class="col-md-10 ml-sm-auto col-lg-10">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<sf:form
					action="${pageContext.request.contextPath}/home/cobro/cifras/consulta"
					method="POST" commandName="fuente" autocomplete="off">
					<div class="card-header">
						<span class="title" id="menu-toggle">Enviar Cifras A Cobro</span>
						<span class="float-right text-secondary" id="btn-ocultar">Ocultar</span>
					</div>
					<div id="mainMenu" class="show card-body">
						<div class="row">
							<div class="col-sm-6 col-md-6 mt-2 mb-2">
								<input type="hidden" id="path"
									value="${pageContext.request.contextPath}" />
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Clientes</label>
									<div class="col-sm-8">
										<input type="text" id="list_Clientes"
											class="form-control form-control-sm ajax-form"
											placeholder="Busca un cliente" name="list_Clientes" />
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Proceso</label>
									<div class="col-sm-8">
										<select class="ajax-form-negocio form-control form-control-sm"
											name="proceso" id="proceso">
											<option value="">Selecciona una opcion</option>
											<c:forEach items="${listaProceso}" var="listaProceso">
												<option
													value="<c:out value=" ${listaProceso.id_proceso} "> </c:out>"
													${ listaProceso.id_proceso==proceso ? 'selected="selected"' : ''}>
													<c:out value="${listaProceso.clave_proceso}"></c:out>
												</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Fecha Cobro
										Libra</label>
									<div class="col-sm-8">

										<input type="date"
											class="form-fecha form-control form-control-sm"
											id="fecha_libra" name="fecha_libra" value="${fecha_libra}"
											required>

									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Periodicidad</label>
									<div class="col-sm-8">
										<select class="ajax-form-periodo form-control form-control-sm"
											name="periodicidad" id="periodicidad">
											<option value="">Selecciona una opcion</option>
											<option value="DIA"
												${ periodicidad eq 'DIA' ? 'selected="selected"' : ''}>Diaria</option>
											<option value="MEN"
												${ periodicidad eq 'MEN' ? 'selected="selected"' : ''}>Mensual</option>
											<option value="EVE"
												${ periodicidad eq 'EVE' ? 'selected="selected"' : ''}>Eventual</option>
										</select>
									</div>
								</div>

								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Interfase</label>
									<div class="col-sm-8">
										<select class="form-control form-control-sm" name="interfase"
											id="interfase">
											<option value="">Selecciona una opcion</option>
											<option value="LIB" class="texto"
												${ periodicidad eq 'EVE' ? 'selected="selected"' : ''}>Libra</option>
											<option value="SAC" class="texto">SAC</option>
											<option value="MAN" class="texto">Manual</option>
										</select>
									</div>
								</div>

							</div>
							<div class="col-sm-6 col-md-6 mt-2 mb-2">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Descripcion</label>
									<div class="col-sm-8">
										<select class="form-control form-control-sm d-none "
											id="list_Clientes_r" name="id_cliente">
										</select> <select class="form-control form-control-sm "
											id="listaDeClientes" name="id_cliente">
											<option value="0">Selecciona una opcion</option>
											<c:forEach items="${listaClientes}" var="lista">
												<option value="<c:out value="${lista.id_cliente}"> </c:out>"
													${ lista.id_cliente==cliente ? 'selected="selected"' : ''}>
													<c:out value="${lista.clave_cliente}"></c:out> -
													<c:out value="${lista.nombre_corto}"></c:out></option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Negocio</label>
									<div class="col-sm-8">
										<select class="form-control form-control-sm" name="id_negocio"
											id="id_negocio">
											<option value="">Selecciona una opcion</option>
											<c:forEach items="${listaNegocios}" var="lista">
												<option value="<c:out value="${lista.id_negocio}"> </c:out>"
													${ lista.id_negocio==negocio ? 'selected="selected"' : ''}>
													<c:out value="${lista.clave}"></c:out>
												</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Fecha Cobro Sac</label>
									<div class="col-sm-8">
										<input type="date"
											class="form-fecha form-control form-control-sm"
											id="fecha_sac" name="fecha_sac" value="${fecha_sac}"
											required>
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Tipo de
										Documento</label>
									<div class="col-sm-8">
										<select class="ajax-form-periodo form-control form-control-sm"
											name="document" id="document">
											<option value="">Selecciona una opcion</option>
											<option value="ODT" class="texto"
												${ document eq 'ODT' ? 'selected="selected"' : ''}>Odt</option>
											<option value="SER" class="texto"
												${ document eq 'SER' ? 'selected="selected"' : ''}>Factura
												de Servicio</option>
											<option value="ABI" class="texto"
												${ document eq 'ABI' ? 'selected="selected"' : ''}>Factura
												Abierta</option>
											<option value="NOT" class="texto"
												${ document eq 'NOT' ? 'selected="selected"' : ''}>Nota
												de Credito</option>
										</select>
									</div>
								</div>

								<div class="form-group row">
									<div class="form-group col-md-12 d-flex flex-row-reverse">
										<button id="btnCon" type="submit"
											class="btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Consultar</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</sf:form>
			</div>
		</div>
	</div>
	<div>
		<c:if test="${not empty consulta}">
			<div class="card mt-2">
				<div class="table-responsive">
					<table
						class="table table-scroll table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th>Clave Cliente</th>
								<th>Nombre Corto Cliente</th>
								<th>Clave Negocio</th>
								<th>Nombre Corto Negocio</th>
								<th>Fecha Calculo</th>
								<th>Fecha Cobro Sac</th>
								<th>Fecha Cobro Libra</th>
								<th>Fecha Cobro Manual</th>
								<th>Tipo de Documento</th>
								<th>Concepto de Envio</th>
								<th>Interfase</th>
								<th>Moneda</th>
								<th>Importe</th>
								<th>IVA</th>
								<th>Marcar</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${consulta}" var="lista">
								<tr>
									<td>${lista.clave_cliente}</td>
									<td>${lista.nombre_corto_cliente}</td>
									<td>${lista.clave_negocio}</td>
									<td>${lista.descripcion_negocio}</td>
									<td><fmt:formatDate value="${lista.fecha_calculo}"
											pattern="dd/MM/YY" /></td>
									<td><fmt:formatDate value="${lista.fecha_cobro_libra}"
											pattern="dd/MM/YY" /></td>
									<td><fmt:formatDate value="${lista.fecha_cobro_sac}"
											pattern="dd/MM/YY" /></td>
									<td><fmt:formatDate value="${lista.fecha_cobro}"
											pattern="dd/MM/YY" /></td>
									<td>${lista.tipo_documento}</td>
									<td>${lista.descripcion_negocio} Ap: <fmt:formatDate value="${lista.fecha_cobro}"
											pattern="dd/MM/YY" /> Dt: <fmt:formatDate value="${lista.fecha_datos}"
											pattern="dd/MM/YY" /></td>
									<td>${lista.sistema_cobro}</td>
									<td>${lista.id_moneda_cobro}</td>
									<td>${lista.costo_servicio}</td>
									<td>${lista.iva_servicio}</td>
									<td><div class="form-check">
											<input class="form-check-input position-static"
												type="checkbox" id="idAsignacion" name="idAsignacion"
												value="${lista.id_cliente},${lista.id_negocio},${lista.id_moneda_cobro},${lista.sistema_cobro},${lista.tipo_documento},<fmt:formatDate value="${lista.fecha_datos}"
											pattern="dd/MM/YY" />,<fmt:formatDate value="${lista.fecha_calculo}"
											pattern="dd/MM/YY" />,${lista.descripcion_negocio},${lista.costo_servicio},${lista.iva_servicio},${lista.clave_cliente},<fmt:formatDate value="${lista.fecha_cobro}"
											pattern="dd/MM/YY" />,${lista.id_servicio_cobrable},${lista.folio_interno}"> 
										</div>
										</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<c:if test="${not empty registros_totales}">
				<sf:form
					action="${pageContext.request.contextPath}/home/registro/mantener/consulta"
					method="POST" name="pagination">
					<%-- 						VARIABLES OBTENIDAS MEDIANTE JS --%>
					<input type="hidden" name="id_cliente" id="getid_cliente"
						class="globalGet">
					<input type="hidden" name="proceso" id="getproceso"
						class="globalGet">
					<input type="hidden" name="id_negocio" id="getid_negocio"
						class="globalGet">
					<input type="hidden" name="fecha_inicial" id="getfecha_inicial"
						class="globalGet">
					<input type="hidden" name="fecha_final" id="getfecha_final"
						class="globalGet">
					<input type="hidden" name="document" id="getdocument"
						class="globalGet">
					<input type="hidden" name="estatus" id="getestatus"
						class="globalGet">
					<input type="hidden" name="id_moneda" id="getid_moneda"
						class="globalGet">
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

	<div>
		<c:if test="${not empty consulta}">
			<div class="card mt-2">
				<div class="table-responsive">
					<table
						class="table table-scroll table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th>Interfase</th>
								<th>Moneda</th>
								<th>Total Importe Cargos</th>
								<th>Total Importe Abonos</th>
								<th>Diferencia</th>
							</tr>
						</thead>
						<tbody>
							<c:set var="Total" value="${0}" />
							<c:forEach items="${consulta}" var="lista">
								<c:set var="Total" value="${Total + lista.costo_servicio}" />
							</c:forEach>


							<tr>
								<td>SAC</td>
								<td>PESO</td>
								<td><fmt:formatNumber type = "number" maxFractionDigits = "4" value = "${Total}" /></td>
								<td>0.00</td>
								<td><fmt:formatNumber type = "number" maxFractionDigits = "4" value = "${Total}" /></td>
							</tr>


						</tbody>
					</table>
				</div>
			</div>

		</c:if>
	</div>


	<c:if test="${not empty consulta}">
		<div class="col-md-12 col-lg-12 pl-0 pr-0">
			<div class="row">
				<div class="col-sm-12">
					<div class="card mt-1">
						<sf:form
							action="${pageContext.request.contextPath}/home/cobro/enviar/enviartodo"
							method="POST" commandName="fuente" autocomplete="off">
							<div class="card-header">
								<span class="title" id="menu-toggle">Polizas Contables</span>
							</div>
							<div id="mainMenu" class="show card-body">
								<div class="row">
									<input type="hidden"
											class="form-fecha form-control form-control-sm"
											id="fecha_libra" name="fecha_libra" value="${fecha_libra}"
											>
									<input type="hidden"
											class="form-fecha form-control form-control-sm"
											id="fecha_sac" name="fecha_sac" value="${fecha_sac}"
											>
									<div class="col-sm-6 col-md-6 mt-2 mb-2">
										<div class="form-group row">
											<div class="form-group col-md-12 d-flex flex-row-reverse">
											
												<button id="MandarTodo" name="MandarTodo" type="button"
											class="btn btn-secondary text-white btn-sm float-right ml-3  mb-1 mt-auto botonesenviar">Enviar Todo</button>
										<input type="hidden" id="checkval" name="checkval"/>
										<button id="Mandar" type="submit"
											class="btn btn-secondary text-white btn-sm float-right ml-3 d-none mb-1 mt-auto"></button>
											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-6 mt-2 mb-2">
										<input class="form-check-input position-static" type="hidden"
											id="opcion" name="opcion"> <input
											class="form-check-input position-static" type="hidden"
											id="datos" name="datos">
										<div class="form-group row">
											<div class="form-group col-md-12 d-flex flex-row-reverse">
												<button id="btnGen" type="submit" class="d-none"></button>
											
											<button id="MandarDato"  name="MandarDato" type="button"
											class="btn btn-secondary text-white btn-sm float-right ml-3  mb-1 mt-auto botonesenviar">Enviar</button>
										<input type="hidden" id="checkval" name="checkval"/>
										<button id="Mandar" type="submit"
											class="btn btn-secondary text-white btn-sm float-right ml-3 d-none mb-1 mt-auto"></button>
											
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

<%@ include file="../layout/footer.jsp"%>