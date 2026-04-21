<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<div class="card-header">
					<span class="title" id="menu-toggle">Lista de Facturas
						Abiertas</span> <span class="float-right text-secondary" id="btn-ocultar">Ocultar</span>
				</div>
				<sf:form
					action="${pageContext.request.contextPath}/home/facturasgeneral/consulta"
					method="POST" autocomplete="off">
					<input type="hidden" id="path"
						value="${pageContext.request.contextPath}" />
					<input type="hidden" id="type_list"
						value="${pageContext.request.contextPath}" />
					<div id="mainMenu" class="show card-body">
						<div class="collapse" id="general">
							<div class="row">
								<div class="col-sm-6 col-md-6 mt-2">
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Negocio</label>
										<div class="col-sm-8">
											<input type="text" id="list_Negocios"
												class="tabin1neg form-control form-control-sm ajax-form"
												placeholder="Busca un negocio" name="list_Negocios" />
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Cliente</label>
										<div class="col-sm-8">
											<input type="text" id="list_Clientes"
												class="form-control form-control-sm ajax-form"
												placeholder="Busca un cliente" name="list_Clientes" />
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Fecha Inicial</label>
										<div class="col-sm-8">
											<input type="date" class="form-control form-control-sm"
												value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>"
												name="fecha_inicial" id="fecha_inicial" />
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Estatus</label>
										<div class="col-sm-8">
											<select class="form-control form-control-sm" name="">
												<option value="0">Selecciona una opcion</option>
												<option value="CRE">Creada</option>
												<option value="PEN">Pendiente</option>
												<option value="GEN">Generada</option>
											</select>
										</div>
									</div>
								</div>
								<div class="col-sm-6 col-md-6 mt-2">
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Selecciona un
											Negocio</label>
										<div class="col-sm-8">
											<select class="tab1neg1 form-control form-control-sm d-none"
												id="list_Negocios_r" name="id_negocio">
											</select> <select class="tab1neg form-control form-control-sm"
												id="listaDeNegocios" name="id_negocio">
												<option value="">Selecciona una opcion</option>
												<c:forEach items="${listaNegocios}" var="lista">
													<option
														value="<c:out value="${lista.id_negocio}"> </c:out>"
														${ lista.id_negocio==negocio ? 'selected="selected"' : ''}>
														<c:out value="${lista.clave}"></c:out>
													</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Selecciona un
											Cliente</label>
										<div class="col-sm-8">
											<select class="form-control form-control-sm d-none"
												id="list_Clientes_r" name="id_cliente">
											</select> <select class="form-control form-control-sm"
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
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Fecha Final</label>
										<div class="col-sm-8">
											<input type="date" class="form-control form-control-sm"
												value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>"
												name="fecha_final" id="fecha_final" />
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label"></label>
										<div class="col-sm-8">
											<button type="submit"
												class="btn btn-secondary text-white btn-sm float-right bordered mb-1 mt-auto ml-2">Consultar</button>
											<button type="submit"
												class="btn btn-secondary text-white btn-sm float-right bordered mb-1 mt-auto ml-2">Eliminar</button>
											<button type="submit"
												class="btn btn-secondary text-white btn-sm float-right bordered mb-1 mt-auto ml-2">Aprobar</button>
											<button type="submit"
												class="btn btn-secondary text-white btn-sm float-right bordered mb-1 mt-auto ml-2">Reporte</button>
											<button type="submit"
												class="btn btn-secondary text-white btn-sm float-right bordered mb-1 mt-auto ml-2">Integrar</button>
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
						<table
							class="table table-scroll table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th>Id Factura</th>
									<th>Periodo</th>
									<th>Negocio</th>
									<th>Cliente</th>
									<th>Nombre Cliente</th>
									<th>Moneda</th>
									<th>Fecha de datos</th>
									<th>Importe</th>
									<th>Estatus</th>
									<th>Selección</th>
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