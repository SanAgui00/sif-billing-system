<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<sf:form
					action="${pageContext.request.contextPath}/home/adq/man/nueva/consulta"
					method="POST" commandName="" autocomplete="off">
					<div class="card-header">
						<span class="title" id="menu-toggle">Solicitar Facturación</span>
						<span class="float-right text-secondary" id="btn-ocultar">Ocultar</span>
					</div>
					<div id="mainMenu" class="collapse show card-body">
						<input type="hidden" id="path"
							value="${pageContext.request.contextPath}" />
						<div class="form-row mt-2">
							<%-- inputs --%>
							<div class="col-md-10">
								<label>Servicio</label>
								<div class="input-group">
									<div class="input-group-prepend">
										<c:if test="${empty clave}">
											<input type="text" id="lista_Servicios"
												class="form-control form-control-sm ajax-form1"
												${clave.equals("null") ? 'placeholder="Clave servicio"' : ''}
												value="${!clave.equals('null') ? clave : ''}"
												placeholder="Clave servicio" name="lista_Servicios" required />
										</c:if>
										<c:if test="${not empty clave}">
											<input type="text" id="lista_Servicios"
												class="form-control form-control-sm ajax-form1"
												${clave.equals("null") ? 'placeholder="Clave servicio"' : ''}
												value="${!clave.equals('null') ? clave : ''}"
												placeholder="Clave servicio" name="lista_Servicios" readonly />
										</c:if>
									</div>
									<select class="custom-select form-control-sm"
										id="lista_Servicios_r" name="servicio">
										<c:if test="${not empty id_servicios && not empty clave}">
											<option value="${id_servicios}&&${clave}">
												<c:out value="${clave}-${descripcion}"></c:out></option>
										</c:if>
									</select>
								</div>
							</div>
							<div class="form-group col-md-2 d-flex flex-row-reverse">
								<c:if test="${empty clave}">
									<button type="submit"
										class="btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto"
										id="consultar">Continuar</button>
								</c:if>
							</div>

						</div>
					</div>
				</sf:form>
			</div>
		</div>

		<c:if test="${not empty consulta}">
			<div class="col-sm-12">
				<div class="card mt-1">
					<sf:form
						action="${pageContext.request.contextPath}/home/adq/man/nueva/solicitud"
						method="POST" commandName="fuente" autocomplete="off">
						<div class="form-group col-md-12 d-flex flex-row-reverse">
							<div class="card mt-1">
								<div class="card-header">
									<span class="title" id="menu-toggle">Información de la
										Solicitud de Facturación</span>
									<div class="col-sm-12 col-md-12">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label">Periodo de
												Facturación:</label>
											<div class="col-sm-3">
												<select class="form-control form-control-sm"
													name="id_periodo" id="id_periodo" required>
													<c:forEach items="${listaPeriodos}" var="lista">
														<option
															value="<c:out value="${lista.id_periodos}"> </c:out>"
															${lista.id_periodos==id_periodo ? 'selected="selected"' : ''}>
															<c:out value="${lista.nombre}"></c:out>
														</option>
													</c:forEach>
												</select>
											</div>
											<label class="col-sm-3 col-form-label">Fecha de
												Datos:</label>
											<div class="col-sm-3">
												<input type="date"
													class="form-fecha form-control form-control-sm"
													id="fecha_datos" name="fecha_datos" required>

											</div>
											<label class="col-sm-3 col-form-label">Fecha de
												Solicitud:</label>
											<div class="col-sm-3">
												<input type="date" class="form-control form-control-sm"
													id="fechaSol" name="fechaSol"
													value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>">

											</div>
											<label class="col-sm-3 col-form-label">Unidad de
												Medida:</label>
											<div class="col-sm-3">
												<c:set var="medida" value="null" />
												<c:set var="tipo_cargo" value="null" />
												<c:forEach items="${consulta}" var="lista">
													<c:set var="tipo_cargo" value="${lista.tipo_cargo}" />
													<c:set var="medida" value="${lista.unidad_medida}" />
												</c:forEach>
												<input type="text"
													class="form-fecha form-control form-control-sm"
													id="uMedida" name="uMedida" value="${medida}" readonly>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>

						<%--Precio no controlado --%>
						<div class="col-sm-12">
							<c:if test="${not empty consulta}">

								<c:set var="precio_controlado" value="" />
								<c:forEach items="${consulta}" var="lista">
									<c:set var="precio_controlado"
										value="${lista.precio_controlado}" />
								</c:forEach>
								<%--precio_controlado=0 --%>
								<c:if test="${precio_controlado eq 0}">

									<div class="card mt-1">
										<div class="card-header">
											<span class="title" id="menu-toggle">Precio No
												Controlado por Sistema: </span>
											<div class="col-sm-12 col-md-12">
												<div class="form-group row">
													<label class="col-sm-3 col-form-label">Fecha de
														cobro por el Área Operativa:</label>
													<div class="col-sm-3">
														<input type="date"
															class="form-fecha form-control form-control-sm"
															id="fecha_operativa" name="fecha_operativa" required>

													</div>
													<label class="col-sm-3 col-form-label">Moneda para
														los importes informados: </label>
													<div class="col-sm-3">
														<c:set var="monedaGet" value="null" />
														<c:forEach items="${consulta}" var="lista">
															<c:set var="monedaGet" value="${lista.id_moneda}" />
														</c:forEach>
														<c:if test="${monedaGet eq '1'}">
															<input type="text"
																class="form-fecha form-control form-control-sm"
																id="moneda" name="moneda" value="PESO" readonly>
														</c:if>
														<c:if test="${monedaGet eq '2'}">
															<input type="text"
																class="form-fecha form-control form-control-sm"
																id="moneda" name="moneda" value="DOLAR" readonly>
														</c:if>
													</div>
												</div>
											</div>
										</div>
									</div>
								</c:if>
							</c:if>
						</div>

						<%--Lista de clientes --%>
						<div class="col-sm-12">
							<%--cliente>0 --%>
							<div class="card mt-1">
								<div class="card-header">
									<div class="col-sm-12 col-md-12">
										<div class="form-group row">
											<c:set var="totClientes" value="Concepto" />
											<label class="col-sm-3 col-form-label">Clientes: </label>
											<div class="col-sm-3">
												<select class="form-control form-control-sm" name="clientes"
													id="clientes">
													<c:forEach items="${consulta}" var="lista">
														<option
															value="${lista.id_cliente}&&(${lista.clave_cliente}) ${lista.nombre_corto}">
															<c:out
																value="(${lista.clave_cliente})${lista.nombre_corto}"></c:out>
														</option>
													</c:forEach>
												</select>
											</div>

											<div class="form-group row d-flex flex-row-reverse">
												<div class="col-md-4">
													<button type="button"
														class="btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto btnAddClientes">Agregar
														clientes</button>
												</div>
												<input type="hidden" name="valoresTr" id="valoresTr"
													value="">
											</div>

										</div>
									</div>
								</div>
							</div>
						</div>

						<%-- Tabla --%>
						<div class="col-sm-12">
							<c:if test="${not empty consulta}">
								<div class="card mt-2">
									<div class="table-responsive">
										<table id="nuevaSolicitudTable"
											class="table table-scroll table-striped table-bordered table-hover nowrap">
											<c:set var="totColum" value="${0}" />
											<c:set var="medidaTipo" value="null" />
											<c:forEach items="${consulta}" var="lista">
												<c:set var="medidaTipo" value="${lista.unidad_medida}" />
											</c:forEach>
											<%--UNIDAD_MEDIDA=MONTO --%>
											<c:if test="${medidaTipo eq 'MONTO'}">
												<thead>
													<tr id="tr0">
														<th scope="col">Concepto</th>
														<c:set var="colTot" value="${0}" />
														<c:set var="totConcep" value="${0}" />
														<c:set var="totalSub" value="0,Concepto" />
														<c:if test="${not empty conSubConceptos}">
															<c:forEach items="${conSubConceptos}" var="lista1">
																<c:set var="colTot" value="${colTot + 1}" />
																<c:set var="totConcep" value="${totConcep + 1}" />
																<th scope="col">${colTot}${lista1.descripcion}</th>
																<c:set var="totalSub"
																	value="${totalSub}&&${lista1.numero},${lista1.descripcion}" />
															</c:forEach>
															<th scope="col">Total:</th>
														</c:if>
														<c:if test="${empty conSubConceptos}">
															<th scope="col">Concepto Principal</th>
														</c:if>
														<th class="d-none"><input type="hidden"
															name="totConcep" id="totConcep" value="${totConcep+1}">
														</th>
													</tr>
												</thead>
												<tbody id="AddClientes">
												</tbody>
											</c:if>
											<%--UNIDAD_MEDIDA=TRANSACCION --%>
											<c:if test="${medidaTipo eq 'TRANSACCION'}">
												<thead>
													<tr id="tr0">
														<th scope="col">Concepto</th>
														<c:set var="colTot" value="${0}" />
														<c:set var="totConcep" value="${0}" />
														<c:set var="totalSub" value="0,Concepto" />
														<c:if test="${not empty conSubConceptos}">
															<c:forEach items="${conSubConceptos}" var="lista1">
																<c:set var="colTot" value="${colTot + 1}" />
																<c:set var="totConcep" value="${totConcep + 1}" />
																<th scope="col">${colTot}${lista1.descripcion}</th>
																<c:set var="totalSub"
																	value="${totalSub}&&${lista1.numero},${lista1.descripcion}" />
															</c:forEach>
															<th scope="col">Total:</th>
														</c:if>
														<c:if test="${empty conSubConceptos}">
															<th scope="col">Concepto Principal</th>
														</c:if>
														<th class="d-none"><input type="hidden"
															name="totConcep" id="totConcep" value="${totConcep+1}">
														</th>
													</tr>
												</thead>
												<tbody id="AddClientes">
												</tbody>
											</c:if>

										</table>
									</div>
								</div>
							</c:if>
						</div>
						<%--botones --%>
						<div class="col-sm-12">
							<c:if test="${not empty consulta}">
								<div class="card mt-1">
									<div class="card-header">
										<div class="col-sm-12 col-md-12">
											<div class="form-group row">
												<div class="col-md-12">

													<input type="hidden" name="colum" id="colum"
														value="${totColum}">

													<%--obtener variables y mandarlas a la vista de detalle --%>
													<input type="hidden" name="servicio"
														id="getlista_Servicios_r" class="globalGet"> <input
														type="hidden" name="servicios" id="servicios" value="${servicio}"><input
														type="hidden" name="datos" id="datos"> <input
														type="hidden" id="path"
														value="${pageContext.request.contextPath}" /> <input
														type="hidden" name="id_moneda" id="id_moneda"
														value="${monedaGet}"> <input type="hidden"
														name="tipo_cargo" id="tipo_cargo" value="${tipo_cargo}">
													<input type="hidden" name="subconceptos" id="subconceptos"
														value="${totalSub}&&0,Total:"> <input
														type="hidden" name="clientesTot" id="clientesTot"
														value="Concepto&&">
													<button type="submit"
														class="btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto d-none"
														id="opciones">Opciones</button>
													<div class="input-group  input-group-sm ">
														<div class="input-group-prepend">
															<span class="input-group-text">Comentarios</span>
														</div>
														<textarea class="form-control" aria-label="With textarea"
															name="comentarios"> </textarea>
													</div>
													<button type="submit" name="solCrear" id="solCrear"
														class="ml-3 btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto btnSolicitud d-none">Crear
														Solicitud</button>

												</div>
											</div>
										</div>
									</div>
								</div>
							</c:if>
						</div>

					</sf:form>
				</div>
			</div>
		</c:if>
	</div>
</div>
<script type="text/javascript"
	src='<c:url value="/js/appManual/nuevaSolicitud.js"/>' defer="defer"></script>
<%@ include file="../layout/footer.jsp"%>