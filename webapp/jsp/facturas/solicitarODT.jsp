<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<sf:form
					action="${pageContext.request.contextPath}/home/facturasgeneral/consulta"
					method="POST" autocomplete="off">
					<div class="card-header">
						<span class="title" id="menu-toggle">Solicitar ODT</span><span
							class="float-right text-secondary" id="btn-ocultar">Ocultar</span>
					</div>
					<div id="mainMenu" class="show card-body">
						<div class="collapse" id="general">
							<div class="row">
								<div class="col-sm-6 col-md-6 mt-2 mb-2">
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Negocio</label>
										<div class="col-sm-8">
											<select class="form-control form-control-sm"
												name="id_negocio">
												<option value="">Selecciona una opcion</option>
												<c:forEach items="${catNegocio}" var="negocio">
													<option
														value="<c:out value="${negocio.id_negocio}"> </c:out>">
														<c:out value="${negocio.clave}"></c:out></option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Cliente</label><input
											type="hidden" id="path"
											value="${pageContext.request.contextPath}" />
										<div class="col-sm-8">
											<div class="input-group">
												<div class="input-group-prepend">
													<input type="text" id="list_Clientes"
														class="form-control form-control-sm ajax-form"
														placeholder="Clave | Nombre corto" name="list_Clientes" />
												</div>
												<select class="form-control form-control-sm"
													id="list_Clientes_r" name="id">
												</select>
											</div>
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Centro costos</label>
										<div class="col-sm-8">
											<select class="form-control form-control-sm"
												name="centro_costos">
												<option value="">Selecciona una opcion</option>
												<c:forEach items="${listaCentroCostos}" var="lista">
													<option
														value="<c:out value=" ${lista.id_centro_costos} "> </c:out>">
														<c:out value="${lista.descripcion}"></c:out>
													</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group row">
										<%-- En la maquina virtual no permite entrada del teclado, no podemos saber que lista de opciones se agrega aqui --%>
										<label class="col-sm-4 col-form-label">Cuenta de
											Ingresos</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" id=""
												placeholder="">
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Fecha de Datos</label>
										<div class="col-sm-8">
											<input type="date" class="form-control form-control-sm"
												id="inputEmail4" name="fecha_inicial"
												value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>">
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Fecha de Cobro</label>
										<div class="col-sm-8">
											<input type="date" class="form-control form-control-sm"
												id="inputEmail4" name="fecha_inicial"
												value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>">
										</div>
									</div>
								</div>
								<div class="col-sm-6 col-md-6 mt-2 mb-2">
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Moneda</label>
										<div class="col-sm-8">
											<select class="form-control form-control-sm" name="id_moneda">
												<option value="">Selecciona una opcion</option>
												<c:forEach items="${listaMonedas}" var="lista">
													<option
														value="<c:out value=" ${lista.id_moneda} "> </c:out>">
														<c:out value="${lista.nombre_moneda}"></c:out>
													</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Sistema de
											Cobro</label>
										<div class="col-sm-8">
											<select class="form-control form-control-sm" name="">
												<option value="">Selecciona una opcion</option>
												<option value="LIB">LIBRA</option>
												<option value="SAC">SAC</option>
											</select>
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Folio</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" id=""
												placeholder="">
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Número de ODT</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" id=""
												placeholder="">
										</div>
										<div class="form-group col-md-2 d-flex flex-row-reverse">
											<button type="submit"
												class="btn btn-secondary text-white btn-sm float-right  mt-auto  ">Consultar</button>
										</div>
									</div>
								</div>
							</div>

						</div>
					</div>
				</sf:form>
			</div>

		</div>
	</div>
	<div class="col-sm-12">
		<c:if test="${not empty consulta}">
			<div class="card mt-2">
				<div class="table-responsive">
					<table
						class="table table-scroll table-striped table-bordered table-hover">
						<thead>
						</thead>
						<tbody>
							<c:forEach items="${consulta}" var="consulta">
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