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
						<span class="title" id="menu-toggle">Mantener
							Facturas,Recibos y Notas de Crédito</span><span
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
										<label class="col-sm-4 col-form-label">Clave cliente</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" id=""
												placeholder="">
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Proceso</label>
										<div class="col-sm-8">
											<select class="form-control form-control-sm"
												name="centro_costos">
												<option value="">Selecciona una opcion</option>

											</select>
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Folios internos
											Del:</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" id=""
												placeholder="">
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Fecha de Datos
											Inicial</label>
										<div class="col-sm-8">
											<input type="date" class="form-control form-control-sm"
												id="inputEmail4" name="fecha_inicial"
												value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>">
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Tipo de
											Documento</label>
										<div class="col-sm-8">
											<select class="form-control form-control-sm" name="">
												<option value="">Selecciona una opcion</option>

											</select>
										</div>
									</div>
									<div class="form-group row">
										<p class="col-sm-4">FActura</p>
										<div class="col-sm-8">
											<input type="radio" name="doc" value=""><br>
										</div>
									</div>
									<div class="form-group row">
										<p class="col-sm-4">Recibo</p>
										<div class="col-sm-8">
											<input type="radio" name="doc" value="">
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
										<label class="col-sm-4 col-form-label">Descripción
											Cliente</label>
										<div class="col-sm-8">
											<select class="form-control form-control-sm" name="">
												<option value="">Selecciona una opcion</option>

											</select>
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Estatus</label>
										<div class="col-sm-8">
											<select class="form-control form-control-sm"
												name="centro_costos">
												<option value="">Selecciona una opcion</option>

											</select>
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Al:</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" id=""
												placeholder="">
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Fecha de Datos
											Final</label>
										<div class="col-sm-8">
											<input type="date" class="form-control form-control-sm"
												id="inputEmail4" name="fecha_inicial"
												value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>">
										</div>
									</div>
								</div>
							</div>
							<div class="form-group col-md-12 d-flex flex-row-reverse">
								<button type="submit"
									class="btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Consultar</button>
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