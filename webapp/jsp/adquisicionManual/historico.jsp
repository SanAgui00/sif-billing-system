<%-- ################################################################################ --%>
<%-- # Autor               : Loredo                                                 # --%>
<%-- # Compania            : Código Geek                                            # --%>
<%-- # Proyecto/Procliente : D-52-8268-17                         Fecha: 01/06/2018 # --%>
<%-- # Descripcion General : Vista de Historicos Servicios							# --%>
<%-- # Marca del cambio    : LOGASIF												# --%>
<%-- ################################################################################ --%>
<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<div class="card-header">
					<span class="title" id="menu-toggle">Historico de Servicios</span>
					<span class="float-right text-secondary" id="btn-ocultar">Ocultar</span>
				</div>
				<sf:form
					action="${pageContext.request.contextPath}/home/adq/man/historico/consulta"
					method="POST" autocomplete="off">
					<input type="hidden" id="path"
						value="${pageContext.request.contextPath}" />
					<input type="hidden" id="type_list"
						value="${pageContext.request.contextPath}" />
					<div id="mainMenu" class="collapse show card-body pb-0 pt-0">
						<div class="row">
							<div class="col-sm-6 col-md-6 mt-2">
								<div class="form-group row">
									<label class="col-sm-3 col-form-label">Buscar Servicio</label>
									<div class="col-sm-9">
										<input type="text" id="list_Servicios"
											class="form-control form-control-sm ajax-form flagServicio"
											placeholder="Busca un Servicio" name="list_Servicios" />
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-6 mt-2">
								<div class="form-group row">
									<label class="col-sm-3 col-form-label">Selecciona
										Servicio</label>
									<div class="col-sm-9">
										<select class="form-control form-control-sm flagServicio"
											id="list_Servicios_r" name="id_fuente">
										</select> <select class="form-control form-control-sm flagServicio"
											id="listaDeServicios" name="id_fuente">
											<option value="0">Selecciona un servicio</option>
											<c:forEach items="${listaServicio}" var="lista">
												<option
													value="<c:out value="${lista.id_servicios}"> </c:out>">
													<c:out value="${lista.clave}"></c:out> -
													<c:out value="${lista.descripcion}"></c:out>
												</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>
							<div class="col-sm-3 col-md-3 mt-2">
								<div class="form-group row">
									<label class="col-sm-6 col-form-label">Fecha Inicial</label>
									<div class="col-sm-6">
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
									<label class="col-sm-6 col-form-label">Fecha Final</label>
									<div class="col-sm-6">
										<c:if test="${fecha_final eq 'null'}">
											<input type="date" class="form-control form-control-sm"
												id="fecha_final" name="fecha_final"
												value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>"
												required>
										</c:if>
										<c:if test="${fecha_final ne 'null'}">
											<fmt:parseDate value="${fecha_final}" pattern="yyyy-MM-dd"
												var="fechaInicial" />
											<input type="date" class="form-control form-control-sm"
												id="fecha_final" name="fecha_final"
												value="<fmt:formatDate value="${fechaInicial}" pattern="yyyy-MM-dd"/>"
												required>
										</c:if>
									</div>
								</div>
							</div>
							<div class="col-sm-3 col-md-3 mt-2">
								<div class="form-group row">
									<label class="col-sm-6 col-form-label">Usuario</label>
									<div class="col-sm-6">
										<input type="text" id="usuario"
											class="form-control form-control-sm" placeholder="Usuario"
											name="usuario" />
									</div>
								</div>
							</div>
							<div class="col-sm-3 col-md-3">
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
									<th>Clave del Servicio</th>
									<th>Descripcion del Servicio</th>
									<th>Fecha de Datos</th>
									<th>Fecha de Captura</th>
									<th>Usuario</th>
									<th>Total Transacción Emisor</th>
									<th>Total Transacción Adquirente</th>
									<th>Total Importe Emisor</th>
									<th>Total Importe Adquirente</th>
									<th>Total cobranza</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${consulta}" var="consulta">
									<tr>
										<td><c:out value="${consulta.clave}"></c:out></td>
										<td><c:out value="${consulta.descripcion}"></c:out></td>
										<td><fmt:formatDate value="${consulta.fecha_datos}"
												pattern="dd-MM-yyyy" /></td>
										<td><fmt:formatDate value="${consulta.fecha_cre}"
												pattern="dd-MM-yyyy" /></td>
										<td><c:out value="${consulta.usuario}"></c:out></td>
										<td><c:out value="${consulta.total_trans_emisor}"></c:out></td>
										<td><c:out value="${consulta.total_trans_adq}"></c:out></td>
										<td><c:out value="${consulta.total_importe_emisor}"></c:out></td>
										<td><c:out value="${consulta.total_importe_adq}"></c:out></td>
										<td><c:out value="${consulta.total_cobranza}"></c:out></td>
									</tr>
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