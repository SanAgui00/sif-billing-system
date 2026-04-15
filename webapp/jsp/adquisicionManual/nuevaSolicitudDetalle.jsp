<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<sf:form
					action="${pageContext.request.contextPath}/home/adq/man/nueva/solicitud/enviar"
					method="POST" commandName="" autocomplete="off">
					<div class="card-header">
						<span class="title" id="menu-toggle">Solicitar Facturación</span>
					</div>

					<div id="mainMenu" class="collapse show card-body">
						<c:if test="${not empty insert}">
							<div class="card-header bg-warning text-dark">
								<span class="title" id="menu-toggle">La solicitud fué
									enviada con exito.</span>
							</div>
						</c:if>
						<div class="card-header">
							<span class="title" id="menu-toggle">Información del
								Servicio</span>
						</div>
						<input type="hidden" id="path"
							value="${pageContext.request.contextPath}" />
						<div class="form-row mt-2">
							<%-- inputs --%>
							<div class="col-md-12">
								<label>Servicio: </label>
								<div class="form-group row">
									<div class="col-sm-4">
										<input type="text" id="clave" name="clave" value="${clave}"
											readonly />
									</div>
									<div class="col-sm-8">
										<input class="col-sm-8" type="text" id="descripcion"
											name="descripcion" value="${descripcion}" readonly />
									</div>
								</div>
							</div>

						</div>
					</div>



					<div class="col-sm-12">
						<div class="card mt-1">
							<div class="card-header">
								<span class="title" id="menu-toggle">Información de la
									Solicitud de Facturación</span>
								<div class="col-sm-12 col-md-12">
									<div class="form-group row">
										<label class="col-sm-3 col-form-label">Fecha de Datos:</label>
										<div class="col-sm-3">
											<input type="date" class="form-control form-control-sm"
												id="fecha_datos" name="fecha_datos"
												value="<fmt:formatDate value="${fecha_datos}" pattern="yyyy-MM-dd"/>"
												readonly>
										</div>
										<label class="col-sm-3 col-form-label">Fecha de
											Solicitud:</label>
										<div class="col-sm-3">
											<input type="date" class="form-control form-control-sm"
												id="fechaSol" name="fechaSol"
												value="<fmt:formatDate value="${fechaSol}" pattern="yyyy-MM-dd"/>"
												readonly>
										</div>
										<label class="col-sm-3 col-form-label">Unidad de
											Medida:</label>
										<div class="col-sm-3">
											<input type="text" id="uMedida" name="uMedida"
												value="${uMedida}" readonly>
										</div>
									</div>

									<div class="card mt-1">
										<div class="table-responsive">
											<c:set var="datos" value="${datos}" />
											<c:set var="datosSplit" value="${fn:split(datos,'||')}" />
											<table
												class="table table-scroll table-striped table-bordered table-hover nowrap">
												<thead>
													<tr>
														<c:set var="clientes" value="${clientes}" />
														<c:set var="clienteSplit"
															value="${fn:split(clientes,'&&')}" />
														<c:forEach var="i" begin="0"
															end="${fn:length(clienteSplit)-1}">
															<th>${clienteSplit [i]}</th>
														</c:forEach>
													</tr>
												</thead>
												<tbody>
													<c:set var="subconceptos" value="${subconceptos}" />
													<c:set var="subconceptosSplit"
														value="${fn:split(subconceptos,'&&')}" />
													<c:forEach var="i" begin="1"
														end="${fn:length(subconceptosSplit)-1}">
														<tr>

															<c:set var="subconceptosSplit1"
																value="${fn:split(subconceptosSplit[i],',')}" />
															<td>${subconceptosSplit1 [1]}</td>
															<c:forEach var="j" begin="1"
																end="${fn:length(clienteSplit)-1}">
																<c:set var="datosSplit1"
																	value="${fn:split(datosSplit[j-1],',')}" />
																<td>${datosSplit1 [i]}</td>
															</c:forEach>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
									<div class="form-group col-md-12 d-flex flex-row-reverse">
										<input type="hidden" id="path"
											value="${pageContext.request.contextPath}" />

										<%--obtener variables --%>

										<input type="hidden" id="id_servicio" name="id_servicio"
											value="${id_servicios}"> <input type="hidden"
											name="id_moneda" id="id_moneda" value="${id_moneda}">
										<input type="hidden" name="tipo_cargo" id="tipo_cargo"
											value="${tipo_cargo}"> <input type="hidden"
											name="datos" id="datos" value="${datos}"> <input
											type="hidden" id="fecha_operativa" name="fecha_operativa"
											value="${fecha_operativa}"> <input type="hidden"
											name="subconceptos" id="subconceptos" value="${subconceptos}">
										<input type="hidden" name="clientesTot" id="clientesTot"
											value="${clientes}"> <input type="hidden"
											name="conceptos" id="conceptos" value="${conceptos}">
										<input type="hidden" name="comentarios" id="comentarios"
											value="${comentarios}">

										<c:if test="${empty insert}">
											<button type="submit"
												class="btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto"
												id="consultar">Enviar Solicitud</button>
										</c:if>
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
<script type="text/javascript"
	src='<c:url value="/js/appManual/nuevaSolicitud.js"/>' defer="defer"></script>
<%@ include file="../layout/footer.jsp"%>