<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<sf:form
					action="${pageContext.request.contextPath}/home/cuentas/saldos/consulta"
					method="POST" commandName="" autocomplete="off">
					<div class="card-header">
						<span class="title" id="menu-toggle">Mantener Saldos de
							Clientes</span> <span class="float-right text-secondary"
							id="btn-ocultar">Ocultar</span>
					</div>
					<div id="mainMenu" class="collapse show card-body">
						<div class="custom-control custom-radio custom-control-inline">
							<input type="radio" id="radioConsulta" name="radio_cuentas"
								class="custom-control-input radio_cuentas" value="consul"
								checked> <label class="custom-control-label"
								for="radioConsulta">Consulta</label>
						</div>
						<div class="custom-control custom-radio custom-control-inline">
							<input type="radio" id="radioCaptura" name="radio_cuentas"
								class="custom-control-input radio_cuentas" value="captura">
							<label class="custom-control-label" for="radioCaptura">Captura</label>
						</div>
						<input type="hidden" id="path"
							value="${pageContext.request.contextPath}" />
						<div class="form-row mt-2">
							<%-- inputs --%>
							<div class="col-md-4">
								<label>Cliente</label>
								<div class="input-group">
									<div class="input-group-prepend">
										<input type="text" id="list_Clientes_report"
											class="form-control form-control-sm ajax-form"
											${clave_cliente.equals("null") ? 'placeholder="Clave | Nombre corto"' : ''}
											value="${!clave_cliente.equals('null') ? clave_cliente : ''}"
											placeholder="Clave | Nombre corto"
											name="list_Clientes_report" />

									</div>
									<select class="custom-select form-control-sm"
										id="list_Clientes_report_r" name="id_cliente">
										<c:if
											test="${not empty idCliente && not empty clave_cliente && not empty nombre_corto}">
											<option
												value="${idCliente}&&${clave_cliente}&&${nombre_corto}">
												<c:out value="${clave_cliente}-${nombre_corto}"></c:out></option>
										</c:if>
									</select>

								</div>
							</div>
							<div class="form-group col-md-2">
								<label>Moneda</label> <select
									class="form-control form-control-sm" name="id_moneda"
									id="id_moneda">
									<option value="">Selecciona la moneda</option>
									<c:forEach items="${listaMonedas}" var="lista">
										<option value="<c:out value=" ${lista.id_moneda}"> </c:out>"
											${ lista.id_moneda==id_moneda ? 'selected="selected"' : ''}>
											<c:out value="${lista.nombre_moneda}"></c:out>
										</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group col-md-2">
								<label>Tipo de Cuenta</label> <select
									class="form-control form-control-sm" id="id_tipo_cuenta"
									name="id_tipo_cuenta" required>
									<option value="">Seleccionar cuenta</option>
									<c:forEach items="${listaCuentasContables}" var="lista">
										<option
											value="<c:out value=" ${lista.id_tipo_cuenta}"> </c:out>"
											${ lista.id_tipo_cuenta==id_tipo_cuenta ? 'selected="selected"' : ''}>
											<c:out value="${lista.clave}"></c:out>
										</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group col-md-2">
								<label for="inputPassword4">Fecha Aplicación</label>
								<c:if test="${fecha_aplic eq 'null'}">
									<input type="date" class="form-control form-control-sm"
										id="fecha_aplic" name="fecha_aplic">
								</c:if>
								<c:if test="${fecha_aplic ne 'null'}">
									<fmt:parseDate value="${fecha_aplic}" pattern="yyyy-MM-dd"
										var="fechaInicial" />
									<input type="date" class="form-control form-control-sm"
										id="fecha_aplic" name="fecha_aplic"
										value="<fmt:formatDate value="${fechaInicial}" pattern="yyyy-MM-dd"/>">
								</c:if>

							</div>
							<div class="form-group col-md-2 d-flex flex-row-reverse">
								<button type="submit"
									class="btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto"
									id="consultar">Consultar</button>
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
							id="saldosCuentasTable" class="table table-scroll table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th scope="col"># CUENTA</th>
									<th scope="col">Descripción Cuenta</th>
									<th scope="col">CLIENTE</th>
									<th scope="col">NOMBRE</th>
									<th scope="col">FECHA</th>
									<th scope="col">MONEDA</th>
									<th scope="col">IMPORTE</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${consulta}" var="lista">
									<tr>
										<td><c:out value="${lista.numero_cuenta}"></c:out></td>
										<td><c:out value="${lista.descripcion}"></c:out></td>
										<td><c:out value="${lista.clave_cliente}"></c:out></td>
										<td><c:out value="${lista.nombre_corto}"></c:out></td>
										<td><fmt:formatDate type="both"
												value="${lista.fecha_aplicacion}" pattern="dd-MM-yyyy" /></td>
										<td><c:out value="${lista.nombre_moneda}"></c:out></td>
										<td class="${ radioVal=='consul' ? 'd-none' : ''}"><input type="text"
											class="form-control form-control-sm table-form getColumn"
											id="importe" name="importe" value="${lista.importe}" /></td>
										<td class="${ radioVal=='consul' ? '' : 'd-none'}">${lista.importe}</td>
										<td class="d-none"><fmt:formatDate type="both" value="${lista.fecha_cre}"
										pattern="dd-MM-yyyy" /></td>
										<td class="d-none"><c:out value="${lista.id_tipo_cuenta}"></c:out></td>
										<td class="d-none"><c:out value="${lista.id_cliente}"></c:out></td>
										<td class="d-none"><c:out value="${lista.id_moneda}"></c:out></td>	
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</c:if>
		</div>

		<div class="col-sm-12">
			<c:if test="${not empty consulta}">
				<div class="card mt-2">
					<div class="table-responsive">
						<table
							class="table table-scroll table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th>MONEDA</th>
									<th>TOTAL</th>
								</tr>
							</thead>
							<tbody>
								<c:set var="Total" value="${0}" />
								<c:forEach items="${consulta}" var="lista">
									<c:set var="Total" value="${Total + lista.importe}" />
									<c:set var="Moneda" value="${lista.nombre_moneda}" />
								</c:forEach>
								<tr>
									<td>${Moneda}</td>
									<td><fmt:formatNumber type="number" maxFractionDigits="4"
											value="${Total}" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>

				<input type="hidden" id="path"
						value="${pageContext.request.contextPath}" />
				<sf:form
						action="${pageContext.request.contextPath}/home/cuentas/saldos"
						method="POST" commandName="fuente" autocomplete="off">
					<button type="submit" id="btnCuentas"
						class="ml-2 btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto d-none"></button>
					</sf:form>
				<button type="submit"
						class="botonSaldos pr-4 pr-4 btn btn-secondary text-white btn-sm float-right ml-3 mt-auto mb-1 ${ radioVal=='consul' ? 'd-none' : ''}">Guardar</button>

			</c:if>
		</div>

		<c:if test="${not empty count}">
			<div class="col-sm-12 col-md-12 col-lg-12">
				<div class="alert alert-warning alert-dismissible fade show mt-2"
					role="alert">
					<strong><c:out value="${count}"></c:out></strong>
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</div>
		</c:if>
	</div>
</div>
<%@ include file="../layout/footer.jsp"%>
