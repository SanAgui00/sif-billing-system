<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<div class="card-header">
					<span class="title" id="menu-toggle">Consultar Bitácora del
						Sistema</span> <span class="float-right text-secondary" id="btn-ocultar">Ocultar</span>
				</div>
				<sf:form
					action="${pageContext.request.contextPath}/home/cobranza/bitacora/consulta"
					method="POST" autocomplete="off">
					<div id="mainMenu" class="collapse show card-body pb-0 pt-0">
						<div class="row">
							<div class="col-sm-3 col-md-3 mt-2">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Fecha Inicial</label>
									<div class="col-sm-8">
										<c:if test="${fecha_inicial eq 'null'}">
											<input type="date" class="form-control form-control-sm"
												id="fecha_inicial" name="fecha_inicial"
												value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>"
												required>
										</c:if>
										<c:if test="${fecha_inicial ne 'null'}">
											<fmt:parseDate value="${fecha_inicial}" pattern="yyyy-MM-dd"
												var="fechaInicial" />
											<input type="date" class="form-control form-control-sm"
												id="fecha_inicial" name="fecha_inicial"
												value="<fmt:formatDate value="${fechaInicial}" pattern="yyyy-MM-dd"/>"
												required>
										</c:if>
									</div>
								</div>
							</div>
							<div class="col-sm-3 col-md-3 mt-2">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Fecha Final</label>
									<div class="col-sm-8">
										<c:if test="${fecha_final eq 'null'}">
											<input type="date" class="form-control form-control-sm"
												id="fecha_final" name="fecha_final"
												value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>"
												required>
										</c:if>
										<c:if test="${fecha_final ne 'null'}">
											<fmt:parseDate value="${fecha_final}" pattern="yyyy-MM-dd"
												var="fechaFinal" />
											<input type="date" class="form-control form-control-sm"
												id="fecha_final" name="fecha_final"
												value="<fmt:formatDate value="${fechaFinal}" pattern="yyyy-MM-dd"/>"
												required>
										</c:if>
									</div>
								</div>
							</div>
							<div class="col-sm-3 col-md-3 mt-2">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Usuario</label>
									<div class="col-sm-8">
										<c:if test="${usuario eq 'null'}">
											<input type="text" id="usuario"
												class="form-control form-control-sm" placeholder="Usuario"
												name="usuario" id="usuario" />
										</c:if>
										<c:if test="${usuario ne 'null'}">
											<input type="text" id="usuario"
												class="form-control form-control-sm" placeholder="Usuario"
												name="usuario" id="usuario" value="${usuario}" />
										</c:if>
									</div>
								</div>
							</div>
							<div class="col-sm-3 col-md-3 mt-2">
								<div class="form-group row">
									<div class="col-md-12">
										<button type="submit"
											class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto">Consultar</button>
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
									<th>Fecha</th>
									<th>Usuario</th>
									<th>Descripción</th>
									<th>Procedimiento</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${consulta}" var="consulta">
									<tr>
										<td><fmt:formatDate type="both" dateStyle="medium"
												timeStyle="medium" value="${consulta.hora}" /></td>
										<td><c:out value="${consulta.usuario}"></c:out></td>
										<td><c:out value="${consulta.descripcion}"></c:out></td>
										<td><c:out value="${consulta.procedimiento}"></c:out></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<c:if test="${not empty registros_totales}">
					<sf:form
						action="${pageContext.request.contextPath}/home/cobranza/bitacora/consulta"
						method="POST" name="pagination">
						<%-- 						VARIABLES OBTENIDAS MEDIANTE JS --%>

						<input type="hidden" name="usuario" id="getusuario"
							class="globalGet">
						<input type="hidden" name="fecha_inicial" id="getfecha_inicial"
							class="globalGet">
						<input type="hidden" name="fecha_final" id="getfecha_final"
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
<%@ include file="../layout/footer.jsp"%>