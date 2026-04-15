<%@ include file="../../layout/header.jsp"%>
<%@ include file="../../layout/menu.jsp"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<div class="card-header">
					<span class="title" id="menu-toggle">Mantener Catálogo
						Cuentas de Deposito</span> <span class="float-right text-secondary"
						id="btn-ocultar">Ocultar</span>
					<sf:form
						action="${pageContext.request.contextPath}/home/cat/apoyo/banco/crud"
						method="POST" name="new" id="nuevoElemento">
						<input name="event" type="hidden" value="new" />
						<button type="submit"
							class="btn-link float-right border-0 text-secondary">Agregar</button>
					</sf:form>
				</div>
				<div class="tab-content" id="mainMenu">
					<div class="tab-pane show active" id="tab1" role="tabpanel"
						aria-labelledby="tab-1">
						<div class="card-body pb-0">
							<div class="row">
								<div class="col-sm-6 col-md-6">
									<div class="form-group row">
										<label class="col-sm-3 col-form-label">Cuenta de
											deposito</label>
										<div class="col-sm-9">
											<select class="form-control form-control-sm" name="" id="">
												<option value="">Selecciona una opcion</option>
											</select>
										</div>
									</div>
								</div>
								<div class="col-sm-4 col-md-4">
									<div class="form-group row">
										<label class="col-sm-3 col-form-label">Estatus</label>
										<div class="col-sm-9">
											<select class="form-control form-control-sm" name="" id="">
												<option value="">Selecciona una opcion</option>
											</select>
										</div>
									</div>
								</div>
								<div class="col-sm-2 col-md-2">
									<button type="submit"
										class="btn bg-danger text-white btn-sm float-right mb-1 mt-auto ">Consultar</button>
								</div>
							</div>
						</div>
					</div>
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
								<tr>
									<th>Empresa</th>
									<th>Cuenta de deposito</th>
									<th>RFC Banco</th>
									<th>Nombre Banco</th>
									<th>Tipo cadena</th>
									<th>Estatus</th>
									<th>Editar</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${consulta}" var="lista">
									<tr>
										<td><c:out value="${lista.cuenta}"></c:out></td>
										<td><c:out value="${lista.rfc_banco}"></c:out></td>
										<td><c:out value="${lista.nom_banco}"></c:out></td>
										<td><c:out value="${lista.tipo_cadena}"></c:out></td>
										<td><c:out value="${lista.estatus}"></c:out></td>
										<td></td>
										<td><sf:form
												action="${pageContext.request.contextPath}/home/cat/apoyo/banco/crud"
												method="POST" name="crud" class="text-center">
												<input name="fuentes" type="hidden" value="${lista.id}" />
												<input name="event" type="hidden" value="edit" />
												<button type="submit"
													class="btn btn-secondary text-white btn-sm btn-table">
													<span class="icon-today"></span>
												</button>
											</sf:form></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<c:if test="${not empty registros_totales}">
					<sf:form
						action="${pageContext.request.contextPath}/home/cat/apoyo/banco/consulta"
						method="POST" name="pagination">
						<%-- 						VARIABLES OBTENIDAS MEDIANTE JS --%>
						<input type="hidden" name="fuentes" id="getfuentes"
							class="globalGet">
						<input type="hidden" name="estatus" id="getestatus"
							class="globalGet">
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
<%@ include file="../../layout/footer.jsp"%>