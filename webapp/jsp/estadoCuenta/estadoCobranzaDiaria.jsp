<%-- ################################################################################ --%>
<%-- # Autor               : Garnica                                                # --%>
<%-- # Compania            : Código Geek                                            # --%>
<%-- # Proyecto/Procliente : Vista de estado cobranza diaria      Fecha: 08/03/2018 # --%>
<%-- # Descripcion General : 									   	                # --%>
<%-- # Marca del cambio    : 									                    # --%>
<%-- ################################################################################ --%>

<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<sf:form
					action="${pageContext.request.contextPath}/home/estados/cobranza/consulta"
					method="POST" commandName="fuente" autocomplete="off">
					<div class="card-header">
						<span class="title" id="menu-toggle">Vizualizar Estado de
							la Cobranza Diaria</span> <span class="float-right text-secondary"
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
										<input type="text" id="list_Clientes_report" required
											class="form-control form-control-sm ajax-form" 
											${clave_cliente.equals("null") ? 'placeholder="Clave | Nombre corto"' : ''}
											value="${!clave_cliente.equals('null') ? clave_cliente : ''}"
											placeholder="Clave | Nombre corto"
											name="list_Clientes_report" />
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Fecha Datos
										Inicial</label>
									<div class="col-sm-8">

										<input type="date" class="form-control form-control-sm"
											id="fecha_inicial" name="fecha_inicial" required
											value="${fecha_inicial}">

									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Proceso</label>
									<div class="col-sm-8">
										<select class="form-control form-control-sm" name="proceso"
											id="proceso" required>
											<option value="0">Selecciona una opcion</option>
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
									<label class="col-sm-4 col-form-label">Moneda</label>
									<div class="col-sm-8">
										<select class="form-control form-control-sm" id="id_moneda"
											name="id_moneda" required>
											<option value="">Selecciona una opcion</option>
											<c:forEach items="${listaMonedas}" var="lista">
												<option
													value="<c:out value=" ${lista.id_moneda} "> </c:out>"
													${ lista.id_moneda==moneda ? 'selected="selected"' : ''}>
													<c:out value="${lista.nombre_moneda}"></c:out>
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
											id="list_Clientes_report_r" name="id_cliente">
											<c:if
												test="${not empty cliente && not empty clave_cliente && not empty nombre_corto}">
												<option value="${cliente}&&${clave_cliente}&&${nombre_corto}">
													<c:out value="${clave_cliente}-${nombre_corto}"></c:out></option>
											</c:if>
										</select> 
										
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Fecha Datos
										Final</label>
									<div class="col-sm-8">

										<input type="date" class="form-control form-control-sm"
											id="fecha_final" name="fecha_final" required
											value="${fecha_final}">

									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Negocio</label>
									<div class="col-sm-8">
										<select class="form-control form-control-sm" name="id_negocio"
											id="id_negocio" required>
											<option value="">Selecciona una opcion</option>
											<c:forEach items="${listaNegocios}" var="lista">
												<option
													value="<c:out value="${lista.id_negocio}||${lista.clave}"> </c:out>"
													${ lista.id_negocio==negocio ? 'selected="selected"' : ''}>
													<c:out value="${lista.clave}"></c:out>
												</option>
											</c:forEach>
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
			<div>
				<c:if test="${not empty consulta}">
					<div class="card mt-2">
						<div class="table-responsive">
							<table
								class="table table-scroll table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>Clave Cliente</th>
										<th>Desc. Cliente</th>
										<th>Clave Negocio</th>
										<th>Desc. Negocio</th>
										<th>Fecha de Datos</th>
										<th>Fecha de Cobro</th>
										<th>Clave Servicio</th>
										<th>Desc. Servicio</th>
										<th>Moneda</th>
										<th>Trx</th>
										<th>Importe</th>
										<th>Descuento</th>
										<th>Iva</th>
										<th>Total</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${consulta}" var="lista">
										<tr>
											<td>${lista.cv_banco}</td>
											<td>${lista.nm_banco}</td>
											<td>${lista.cv_negocio}</td>
											<td>${lista.nm_negocio}</td>
											<td><fmt:formatDate value="${lista.fecha_datos}"
													pattern="dd/MM/YY" /></td>
											<td><fmt:formatDate value="${lista.fecha_cobro}"
													pattern="dd/MM/YY" /></td>
											<td>${lista.cv_servicio}</td>
											<td>${lista.nm_servicio}</td>
											<td>${lista.nm_moneda}</td>
											<td>${lista.TRX}</td>
											<td>${lista.IMPORTE}</td>
											<td>${lista.DESCUENTO}</td>
											<td>${lista.IVA}</td>
											<td>${lista.TOTAL}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>

					<div class="form-row">
						<div class="col-md-2 col-lg-3">
							<sf:form
								action="${pageContext.request.contextPath}/home/estados/cobranza/jasper"
								method="POST" name="fuentes" autocomplete="off">
								<input type="hidden" name="fecha_inicial"
									id="reporteParamfecha_inicial" class="globalGetReport">
								<input type="hidden" name="proceso" id="reporteParamproceso"
									class="globalGetReport">
								<input type="hidden" name="id_moneda" id="reporteParamid_moneda"
									class="globalGetReport">
								<input type="hidden" name="id_cliente"
									id="reporteParamlist_Clientes_report_r" class="globalGetReport">
								<input type="hidden" name="fecha_final"
									id="reporteParamfecha_final" class="globalGetReport">
								<input type="hidden" name="id_negocio"
									id="reporteParamid_negocio" class="globalGetReport">
								<input type="hidden" name="tipo" id="tipo">
								<button type="submit"
									class="btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto d-none"
									id="reporte">Reporte</button>
								<div role="toolbar" aria-label="Contenedor de botones"
									class="btn-toolbar float-left pagination">

									<div class="btn-group mr-2" role="group"
										aria-label="Botones de reportes">
										<button type="button"
											class="btn btn-secondary btn-sm buttonreporte" id="excel">
											<span class="mr-2">Reporte Excel</span><span
												class="icon-file-excel"></span>
										</button>
										<button type="button"
											class="btn btn-secondary btn-sm buttonreporte" id="pdf">
											<span class="mr-2">Imprimir Pdf</span><span
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
							</sf:form>
						</div>
						<div class="col-md-10 col-lg-9">
							<c:if test="${not empty registros_totales}">
								<sf:form
									action="${pageContext.request.contextPath}/home/estados/cobranza/consulta"
									method="POST" name="pagination">
									<%-- 						VARIABLES OBTENIDAS MEDIANTE JS --%>
									<input type="hidden" name="proceso" id="getproceso"
										class="globalGet">
									<input type="hidden" name="id_moneda" id="getid_moneda"
										class="globalGet">
									<input type="hidden" name="id_cliente" id="getlistaDeClientes"
										class="globalGet">
									<input type="hidden" name="id_negocio" id="getid_negocio"
										class="globalGet">
									<input type="hidden" name="fecha_inicial" id="getfecha_inicial"
										class="globalGet">
									<input type="hidden" name="fecha_final" id="getfecha_final"
										class="globalGet">
									<input type="hidden" name="registros_totales"
										id="registros_totales" class="registros_totales"
										value="${registros_totales}">
									<input type="hidden" name="fromRow" id="fromRow"
										class="fromRow" value="">

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
						</div>
				</c:if>

			</div>
			<%@ include file="../layout/footer.jsp"%>