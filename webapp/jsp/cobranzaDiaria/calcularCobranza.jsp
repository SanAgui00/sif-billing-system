<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<div class="card-header">
					<span class="title" id="menu-toggle">Recalcular Cobranza <c:out
							value="${editar.clave_cliente}"></c:out></span>
					<%-- menu --%>
					<%-- menu --%>
					<%-- menu --%>
					<ul class="nav d-inline-block">
						<li class="nav-item d-inline-block"><a
							class="nav-link text-secondary p-0 mr-3 ml-5  tab-link active selectTab"
							id="tab-1" data-toggle="tab" href="#tab1" role="tab"
							aria-controls="tab1" aria-selected="true">Por Fuente</a></li>
						<li class="nav-item d-inline-block"><a
							class="nav-link text-secondary p-0 mr-3  tab-link selectTab"
							id="tab-2" data-toggle="tab" href="#tab2" role="tab"
							aria-controls="tab2" aria-selected="false">Por Servicio</a></li>
					</ul>
					<%-- menu --%>
					<%-- menu --%>
					<%-- menu --%>
					<span class="float-right text-secondary" id="btn-ocultar">Ocultar</span>
				</div>
				<div class="tab-content" id="mainMenu">
					<div class="tab-pane  show active" id="tab1" role="tabpanel"
						aria-labelledby="tab-1">
						<sf:form
							action="${pageContext.request.contextPath}/home/cobranza/calcular/consulta"
							method="POST" autocomplete="off">
							<input type="hidden" name="flag" id="flag" value="${flag}" />
							<div class="card-body">
								<div class="row">
									<div class="col-sm-6 col-md-6 mt-2">
										<div class="form-group row tabFuente">
											<label class="col-sm-3 col-form-label">Buscar Fuente
											</label>
											<div class="col-sm-9">
												<input type="hidden" id="path"
													value="${pageContext.request.contextPath}" /> <input
													type="hidden" id="type_list"
													value="${pageContext.request.contextPath}" /><input
													type="text" id="list_Fuentes"
													class="form-control form-control-sm ajax-form flagFuente"
													placeholder="Busca una Fuente" name="list_Fuentes" />
											</div>
										</div>
										<div class="form-group row d-none tabServicio">
											<label class="col-sm-3 col-form-label">Buscar
												Servicio </label>
											<div class="col-sm-9">
												<input type="text" id="list_Servicios"
													class="form-control form-control-sm ajax-form flagServicio"
													placeholder="Busca un Servicio" name="list_Servicios" />
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-6 col-form-label">Fecha Datos
												Inicial </label>
											<div class="col-sm-6">
												<c:if test="${fecha_inicial eq 'null'}">
													<input type="date" class="form-control form-control-sm"
														id="fecha_inicial" name="fecha_inicial"
														value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>"
														required>
												</c:if>
												<c:if test="${fecha_inicial ne 'null'}">
													<fmt:parseDate value="${fecha_inicial}"
														pattern="yyyy-MM-dd" var="fechaInicial" />
													<input type="date" class="form-control form-control-sm"
														id="fecha_inicial" name="fecha_inicial"
														value="<fmt:formatDate value="${fechaInicial}" pattern="yyyy-MM-dd"/>"
														required>
												</c:if>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-6 col-form-label">Fecha Datos
												Final</label>
											<div class="col-sm-6">
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
									<div class="col-sm-6 col-md-6 mt-2">
										<div class="form-group row tabFuente">
											<label class="col-sm-3 col-form-label">Selecciona
												Fuente</label>
											<div class="col-sm-9">
												<select class="form-control form-control-sm flagFuente"
													id="list_Fuentes_r" name="id_fuente">
												</select> <select class="form-control form-control-sm flagFuente"
													id="listaDeFuentes" name="id_fuente">
													<option value="0">Selecciona una fuente</option>
													<c:forEach items="${listaFuentes}" var="lista">
														<option
															value="<c:out value="${lista.id_fuente}"> </c:out>"
															${ lista.id_fuente==id_fuente ? 'selected="selected"' : ''}>
															<c:out value="${lista.clave}"></c:out> -
															<c:out value="${lista.descripcion}"></c:out></option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group row d-none tabServicio">
											<label class="col-sm-3 col-form-label">Selecciona
												Servicio</label>
											<div class="col-sm-9">
												<select class="form-control form-control-sm flagServicio"
													id="list_Servicios_r" name="id_servicio">
												</select> <select class="form-control form-control-sm flagServicio"
													id="listaDeServicios" name="id_servicio">
													<option value="0">Selecciona un servicio</option>
													<c:forEach items="${listaServicio}" var="lista">
														<option
															value="<c:out value="${lista.id_servicios}"> </c:out>"
															${ lista.id_servicios==id_servicio ? 'selected="selected"' : ''}>
															<c:out value="${lista.clave}"></c:out> -
															<c:out value="${lista.descripcion}"></c:out></option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-6 col-form-label">Estatus</label>
											<div class="col-sm-6">
												<select class="form-control form-control-sm" name="estatus">
													<option value="emtpy">Selecciona una opcion</option>
													<option value="MOD">Modificado</option>
													<option value="NOR">Adq. automaticas</option>
													<option value="CON">Adq. contingencia</option>
													<option value="MAN">Manual</option>
												</select>
											</div>
										</div>
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
			</div>
		</div>

		<div class="col-sm-12">
			<c:if test="${not empty consulta}">
				<div class="card mt-2">
					<div class="table-responsive">
						<table
							class="table table-scroll table-striped table-bordered table-hover">
							<c:choose>
								<c:when test="${flag=='1'}">
									<thead>
										<tr>
											<th scope="col">Servicio</th>
											<th scope="col">Concepto</th>
											<th scope="col">Fecha Datos</th>
											<th scope="col">Tipo Adq.</th>
											<th scope="col">Trans. Emisor</th>
											<th scope="col">Trans. Adq.</th>
											<th scope="col">Importe</th>
											<th scope="col">Estatus Calculo</th>
											<th scope="col">Calcular</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${consulta}" var="lista">
											<tr>
												<td><c:out value="${lista.clave}"></c:out></td>
												<td><c:out value="${lista.descripcion}"></c:out></td>
												<td><fmt:formatDate value="${lista.fecha_datos}"
														pattern="dd-MM-yyyy" /></td>
												<td><c:out value="${lista.estatus}"></c:out></td>
												<td><c:out value="${lista.total_trans_emisor}"></c:out></td>
												<td><c:out value="${lista.total_trans_adq}"></c:out></td>
												<td><c:out value="${lista.costo_servicio}"></c:out></td>
												<td><c:out value="${lista.estatus_calculo}"></c:out></td>
												<td><div class="form-check">
														<input class="form-check-input position-static"
															type="checkbox" checked="checked"
															value="${lista.id_servicio},<fmt:formatDate value="${lista.fecha_datos}" pattern="dd-MM-yyyy" />">


													</div></td>
											</tr>
										</c:forEach>
									</tbody>
								</c:when>
								<c:otherwise>
									<thead>
										<tr>
											<th scope="col">Fuente</th>
											<th scope="col">Estatus Adquisición</th>
											<th scope="col">Fecha</th>
											<th scope="col">Calcular</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${consulta}" var="lista">
											<tr>
												<td><c:out value="${lista.clave}"></c:out></td>
												<td>${lista.estatus=='EXI' ? 'EXITOSA' : lista.estatus}</td>
												<td><fmt:formatDate value="${lista.fecha_datos}"
														pattern="dd-MM-yyyy" /></td>
												<td><div class="form-check">
														<input class="form-check-input position-static"
															type="checkbox" checked="checked"
															value="${lista.id_fuente},<fmt:formatDate value="${lista.fecha_datos}" pattern="dd-MM-yyyy" />">
													</div></td>
											</tr>
										</c:forEach>
									</tbody>
								</c:otherwise>
							</c:choose>
						</table>
					</div>
				</div>
				<c:if test="${not empty registros_totales}">
					<sf:form
						action="${pageContext.request.contextPath}/home/cobranza/calcular/consulta"
						method="POST" name="pagination">
						<%--                        VARIABLES OBTENIDAS MEDIANTE JS --%>
						<input type="hidden" name="id_fuente" id="getlistaDeFuentes"
							class="globalGet">
						<input type="hidden" name="fecha_inicial" id="getfecha_inicial"
							class="globalGet">
						<input type="hidden" name="fecha_final" id="getfecha_final"
							class="globalGet">
						<input type="hidden" name="flag" id="getflag" class="globalGet">
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
		<c:if test="${not empty consulta}">
			<div class="col-sm-12 mt-2">
				<sf:form
					action="${pageContext.request.contextPath}/home/cobranza/calcular/proceso"
					method="POST" name="fuentes" autocomplete="off">
					<input type="submit" class="d-none" id="btnEjecutar">
					<input type="hidden" id="variables"
						class="form-control form-control-sm" name="variables" />
					<input id="evento" class="form-control form-control-sm inputEvento"
						name="evento" type="hidden">
					<input type="hidden" name="flag" id="reporteParamflag"
						class="globalGetReport">
				</sf:form>
				<button type="button"
					class="btn btn-secondary btn-sm float-right bordered  mb-1 ml-2 mt-auto btnEvento"
					id="recalcular">Recalcular</button>
				<button type="button"
					class="btn btn-secondary btn-sm float-right bordered  mb-1 ml-2 mt-auto btnEvento"
					id="deshacer">Deshacer</button>
				<button type="button"
					class="btn btn-secondary btn-sm float-right bordered  mb-1 mt-auto btnEvento"
					id="pendientes" disabled>Calcular pendientes</button>
			</div>
		</c:if>
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