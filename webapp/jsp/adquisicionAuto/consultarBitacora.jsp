<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<sf:form
					action="${pageContext.request.contextPath}/home/adq/auto/bitacora/consulta"
					method="POST" autocomplete="off">
					<div class="card-header">
						<span class="title" id="menu-toggle">Bitácora de Errores en
							Adquisiciones</span> <span class="float-right text-secondary"
							id="btn-ocultar">Ocultar</span>
					</div>
					<div id="mainMenu" class="collapse show card-body">
						<input type="hidden" name="flag" id="flag" value="0" />
						<div class="form-row">
							<div class="form-group col-md-3 ">
								<label for="inputEmail4 ">Fuentes</label> <select
									class="form-control form-control-sm" name="fuentes"
									id="fuentes">
									<c:forEach items="${listaFuentes}" var="lista">
										<option value="<c:out value="${lista.id_fuente}"> </c:out>"
											${lista.id_fuente==fuentes_clave ? 'selected="selected"' : ''}>
											<c:out value="${lista.clave}"></c:out></option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group col-md-3">
								<label>Fecha datos inicial</label> <input
									class="form-control form-control-sm  col-md-12"
									name="fecha_inicial" id="fecha_inicial" type="date"
									value="${fecha_inicial}" />

							</div>
							<div class="form-group col-md-3">
								<label>Fecha datos final</label> <input
									class="form-control form-control-sm  col-md-12"
									name="fecha_final" id="fecha_final" type="date"
									value="${fecha_final}" />

							</div>
							<div class="form-group col-md-3 d-flex flex-row-reverse">
								<button type="submit"
									class="btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Consultar</button>
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
									<th scope="col">Fecha y hora</th>
									<th scope="col">Descripción del evento</th>
									<th scope="col">Procedimiento</th>
									<th scope="col">Usuario</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${consulta}" var="lista">
									<tr>
										<td><fmt:formatDate type="both" value="${lista.pk_hora}"
												pattern="dd-MM-yyyy kk:mm:ss" /></td>
										<td><c:out value="${lista.descripcion}"></c:out></td>
										<td><c:out value="${lista.procedimiento}"></c:out></td>
										<td><c:out value="${lista.usuario}"></c:out></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<c:if test="${not empty registros_totales}">
					<sf:form
						action="${pageContext.request.contextPath}/home/adq/auto/bitacora/consulta"
						method="POST" name="pagination">
						<%-- 						VARIABLES OBTENIDAS MEDIANTE JS --%>
						<input type="hidden" name="fuentes" id="getfuentes"
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
