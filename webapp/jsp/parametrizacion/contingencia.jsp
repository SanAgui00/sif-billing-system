<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<sf:form action="${pageContext.request.contextPath}/home/contingencia/consulta" method="POST" commandName="fuente" autocomplete="off">
					<div class="card-header">
						<span class="title" id="menu-toggle">Contingencias</span> <span class="float-right text-secondary" id="btn-ocultar">Ocultar</span>
					</div>
					<div id="mainMenu" class="collapse show card-body pt-1">
						<div class="form-row">
							<%-- inputs --%>
							<div class="form-group col-md-3">
								<label for="inputEmail4 ">Fuente</label> <select class="form-control form-control-sm" name="id_fuente" required="required">
									<option value="0">Opción</option>
									<c:forEach items="${listaFuentes}" var="fuente">
										<option value="<c:out value="${fuente.id_fuente}"></c:out>"><c:out value="${fuente.clave}"></c:out></option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group col-md-3">
								<label for="inputEmail4 ">Fecha Datos Inicial</label> <input type="date" class="form-control form-control-sm" value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>" name="fecha_datos" required="required" />
							</div>
							<div class="form-group col-md-3">
								<label for="inputEmail4 ">Fecha Datos Final</label> <input type="date" class="form-control form-control-sm" value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>" name="fecha_datos_final" required="required" />
							</div>
							<div class="form-group col-md-3 d-flex flex-row-reverse">
								<button type="submit" class="btn btn-secondary text-white btn-sm float-right bordered  mb-1 mt-auto">Consultar</button>
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
									<th>Fuente</th>
									<th>Estatus</th>
									<th>Fecha Datos</th>
									<th>Fecha de Adquisición</th>
									<th>Núm. Trans. Leidas</th>
									<th>Núm. Trans. Convertidas</th>
									<th>Núm. Trans. No Convertidas</th>
									<th>Contingencia</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${consulta}" var="consulta">
									<tr>
										<td>${consulta.clave}</td>
										<td>${consulta.estatus}</td>
										<td>${consulta.fecha_datos}</td>
										<td>${consulta.hora_inicio}</td>
										<td>${consulta.total_trans_leidas}</td>
										<td>${consulta.total_trans_conv}</td>
										<td>${consulta.total_trans_nconv}</td>
										<td><div class="form-check">
												<input class="form-check-input position-static" checked="checked" value="11,2018-01-01 00:00:00.0" type="checkbox">
											</div></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<div class="col-sm-12 mt-2">
					<sf:form action="${pageContext.request.contextPath}/home/contingencia/ajustar" method="POST" commandName="fuente" autocomplete="off">
						<input type="hidden" name="event" value="ajusteFuera">
						<button type="submit" class="btn btn-secondary text-white btn-sm float-right bordered  mb-1 ml-2 mt-auto">Ajustar Fuera del Ejercicio</button>
					</sf:form>
					<sf:form action="${pageContext.request.contextPath}/home/contingencia/ajustar" method="POST" commandName="fuente" autocomplete="off">
						<input type="hidden" name="event" value="ajusteDentro">
						<button type="submit" class="btn btn-secondary text-white btn-sm float-right bordered  mb-1 ml-2 mt-auto">Ajustar Dentro del Ejercicio</button>
					</sf:form>
					<sf:form action="${pageContext.request.contextPath}/home/contingencia/ajustar" method="POST" commandName="fuente" autocomplete="off">
						<input type="hidden" name="event" value="aplicar">
						<button type="submit" class="btn btn-secondary text-white btn-sm float-right bordered  mb-1 mt-auto">Aplicar Contingencia</button>
					</sf:form>
				</div>
			</c:if>
		</div>
	</div>
</div>
<%@ include file="../layout/footer.jsp"%>