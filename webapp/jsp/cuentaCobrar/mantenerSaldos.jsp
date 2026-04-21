<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<sf:form action="${pageContext.request.contextPath}/home/cuentas/saldos/consulta" method="POST" commandName="" autocomplete="off">
					<div class="card-header">
						<span class="title" id="menu-toggle">Mantener Saldos de Clientes</span> <span class="float-right text-secondary" id="btn-ocultar">Ocultar</span>
					</div>
					<div id="mainMenu" class="collapse show card-body">
						<div class="custom-control custom-radio custom-control-inline">
							<input type="radio" id="radioConsulta" name="radio_cuentas" class="custom-control-input radio_cuentas" checked> <label class="custom-control-label" for="radioConsulta">Consulta</label>
						</div>
						<div class="custom-control custom-radio custom-control-inline">
							<input type="radio" id="radioCaptura" name="radio_cuentas" class="custom-control-input radio_cuentas"> <label class="custom-control-label" for="radioCaptura">Captura</label>
						</div>
						<input type="hidden" id="path" value="${pageContext.request.contextPath}" />
						<div class="form-row mt-2">
							<%-- inputs --%>
							<div class="col-md-4">
								<label>Cliente</label>
								<div class="input-group">
									<div class="input-group-prepend">
										<input type="text" id="list_Clientes" class="form-control form-control-sm" placeholder="Clave | Nombre corto" />
									</div>
									<select class="form-control form-control-sm" id="list_Clientes_r" name="id_cliente">
									</select>
								</div>
							</div>
							<div class="form-group col-md-2">
								<label>Moneda</label> <select class="form-control form-control-sm" name="id_moneda">
									<option value="0">Selecciona la moneda</option>
									<c:forEach items="${listaMonedas}" var="lista">
										<option value="<c:out value=" ${lista.id_moneda}"> </c:out>">
											<c:out value="${lista.nombre_moneda}"></c:out>
										</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group col-md-2">
								<label>Tipo de Cuenta</label> <select class="form-control form-control-sm" name="id_moneda">
									<option value="0">Selecciona la moneda</option>
									<c:forEach items="${listaMonedas}" var="lista">
										<option value="<c:out value=" ${lista.id_moneda}"> </c:out>">
											<c:out value="${lista.nombre_moneda}"></c:out>
										</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group col-md-2">
								<label for="inputPassword4">Fecha Aplicación</label> <input type="date" class="form-control form-control-sm" id="inputPassword4" name="fecha_final" value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>" required>
							</div>
							<div class="form-group col-md-2 d-flex flex-row-reverse">
								<button type="submit" class="btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Consultar</button>
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
										<td><c:out value="${lista}"></c:out></td>
										<td><c:out value="${lista}"></c:out></td>
										<td><c:out value="${lista}"></c:out></td>
										<td><c:out value="${lista}"></c:out></td>
										<td><c:out value="${lista}"></c:out></td>
										<td><c:out value="${lista}"></c:out></td>
										<td><c:out value="${lista}"></c:out></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</c:if>
		</div>
		<c:if test="${not empty count}">
			<div class="col-sm-12 col-md-12 col-lg-12">
				<div class="alert alert-warning alert-dismissible fade show mt-2" role="alert">
					<strong><c:out value="${count}"></c:out></strong>
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</div>
		</c:if>
	</div>
</div>
<%@ include file="../layout/footer.jsp"%>
