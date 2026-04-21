<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<sf:form action="${pageContext.request.contextPath}/home/cobranza/calcular/consulta" method="POST" name="fuentes" autocomplete="off">
					<div class="card-header">
						<span class="title" id="menu-toggle">Comparativo de Servicios</span> <span class="float-right text-secondary" id="btn-ocultar">Ocultar</span>
					</div>
					<div id="mainMenu" class="collapse show card-body">
						<input type="hidden" name="flag" id="flag" value="0" />
						<div class="form-row">
							<%-- inputs --%>
							<div class="form-group col-md-3">
								<label for="inputPassword4 ">Nivel de Comparación</label> <select class="form-control form-control-sm" name="estatus">
									<option value="empty"></option>
								</select>
							</div>
							<div class="form-group col-md-3">
								<label for="inputPassword4 ">Comparar Servicios de Periodicidad</label> <select class="form-control form-control-sm" name="estatus">
									<option value="empty"></option>
								</select>
							</div>
							<div class="form-group col-md-3">
								<label for="inputPassword4 ">Traer solamente los rebases</label> <select class="form-control form-control-sm" name="estatus">
									<option value="empty"></option>
								</select>
							</div>
							<%-- fin inputs --%>
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
									<th scope="col">Col</th>
									<th scope="col">Col</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${consulta}" var="lista">
									<tr>
										<td><c:out value="${lista.clave}"></c:out></td>
										<td>${lista.estatus=='EXI' ? 'EXITOSA' : lista.estatus}</td>
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
