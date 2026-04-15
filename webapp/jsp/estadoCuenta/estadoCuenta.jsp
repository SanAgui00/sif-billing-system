<%-- ################################################################################ --%>
<%-- # Autor               : Garnica                                                # --%>
<%-- # Compania            : Código Geek                                            # --%>
<%-- # Proyecto/Procliente : Vista de estado de cuenta            Fecha: 08/03/2018 # --%>
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
					action="${pageContext.request.contextPath}/home/estados/cuenta/consulta"
					method="POST" commandName="fuente" autocomplete="off">
					<div class="card-header">
						<span class="title" id="menu-toggle">Vizualizar Estado de
							Cuenta Integrado</span> <span class="float-right text-secondary"
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
										<input type="text" id="list_Clientes"
											class="form-control form-control-sm ajax-form"
											placeholder="Busca un cliente" name="list_Clientes"/>
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Periodo</label>
									<div class="col-sm-8">
										<select class="ajax-form-periodo form-control form-control-sm"
									name="id_periodo" id="id_periodo"  required>
											<option value="0">Selecciona una opcion</option>
											<c:forEach items="${listaPeriodos}" var="listaPeriodos">
												<option
													value="<c:out value="${listaPeriodos.id_periodos}"> </c:out>"
													${ listaPeriodos.id_periodos==periodo ? 'selected="selected"' : ''}>
													<c:out value="${listaPeriodos.nombre}"></c:out>
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
										<select class="form-control form-control-sm d-none "
											id="list_Clientes_r" name="id_cliente">
										</select> <select class="form-control form-control-sm "
											id="listaDeClientes" name="id_cliente">
											<option value="">Selecciona una opcion</option>
											<c:forEach items="${listaClientes}" var="lista">
												<option 
													value="<c:out value="${lista.id_cliente}"> </c:out>"
												${ lista.id_cliente==cliente ? 'selected="selected"' : ''}>
													<c:out value="${lista.clave_cliente}"></c:out> -
													<c:out value="${lista.nombre_corto}"></c:out></option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Moneda</label>
									<div class="col-sm-8">
										<select class="form-control form-control-sm" name="id_moneda" id="id_moneda">
											<option value="">Selecciona una opcion</option>
											<c:forEach items="${listaMonedas}" var="lista">
												<option
													value="<c:out value="${lista.id_moneda}"> </c:out>"
													${ lista.id_moneda==moneda ? 'selected="selected"' : ''}>
													<c:out value="${lista.nombre_moneda}"></c:out>
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
										<th>Clave Negocio</th>
										<th>Descripcion Negocio</th>
										<th>Moneda</th>
										<th>Tipo Documento</th>
										<th>Numero de Factura</th>
										<th>Fecha de Factura</th>
										<th>Concepto</th>
										<th>Sub Total</th>
										<th>IVA</th>
										<th>Total</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${consulta}" var="lista">
										<tr>
											<td>${lista.clave_neg}</td>
											<td>${lista.desc_neg}</td>
											<td>${lista.desc_mon}</td>
											<td>${lista.tipo_doc}</td>
											<td>${lista.num_fac}</td>
											<td><fmt:formatDate value="${lista.fecha_cre}"
													pattern="dd/MM/YY" /></td>
											<td>${lista.descripcion}</td>
											<td>${lista.subtotal}</td>
											<td>${lista.iva_monto}</td>
											<td>${lista.total_monto}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<c:if test="${not empty registros_totales}">
						<sf:form
							action="${pageContext.request.contextPath}/home/estados/cuenta/consulta"
							method="POST" name="pagination">
							<%-- 						VARIABLES OBTENIDAS MEDIANTE JS --%>
							<input type="hidden" name="id_cliente" id="getlistaDeClientes"
								class="globalGet">
							<input type="hidden" name="id_periodo" id="getid_periodo"
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
									<span class="pagination-container d-inline-block" id="pagination-container"></span>
									<span class='page-link next'><span class="icon-arrow_forward"></span></span>
								</ul>
							</nav>
							<button type="submit" class="d-none" id="pagination-submit"></button>
						</sf:form>
					</c:if>
				</c:if>
			</div>
		</div>
			<%@ include file="../layout/footer.jsp"%>