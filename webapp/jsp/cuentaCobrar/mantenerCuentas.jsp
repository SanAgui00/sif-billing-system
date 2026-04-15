<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<sf:form action="${pageContext.request.contextPath}/home/cuentas/mantener/consulta" method="POST" commandName="" autocomplete="off">
					<div class="card-header">
						<span class="title" id="menu-toggle">Mantener Cuentas por Cobrar</span> <span class="float-right text-secondary" id="btn-ocultar">Ocultar</span>
					</div>
					<div id="mainMenu" class="collapse show card-body">
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
								<label>Moneda:</label> <select class="form-control form-control-sm" name="id_moneda">
									<option value="0">Selecciona la moneda</option>
									<c:forEach items="${listaMonedas}" var="lista">
										<option value="<c:out value=" ${lista.id_moneda}"> </c:out>">
											<c:out value="${lista.nombre_moneda}"></c:out>
										</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group col-md-2">
								<label for="inputPassword4">Fecha inicial</label> <input type="date" class="form-control form-control-sm" id="inputPassword4" name="fecha_final" value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>" required>
							</div>
							<div class="form-group col-md-2">
								<label for="inputPassword4">Fecha final</label> <input type="date" class="form-control form-control-sm" id="inputPassword4" name="fecha_final" value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>" required>
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
									<th scope="col">Importe</th>
									<th scope="col">IVA</th>
									<th scope="col">Total</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${consulta}" var="lista">
									<tr>
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