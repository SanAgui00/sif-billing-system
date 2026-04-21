<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<div class="col-md-10 ml-sm-auto col-lg-10">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<sf:form
					action="${pageContext.request.contextPath}/home/calculomensual/rebate/consulta"
					method="POST" commandName="fuente" autocomplete="off">
					<div class="card-header">
						<span class="title" id="menu-toggle">Calcular y Aplicar
							Rebate</span> <span class="float-right text-secondary" id="btn-ocultar">Ocultar</span>
					</div>
					<div id="mainMenu" class="show card-body">
						<div class="row">
							<div class="col-sm-6 col-md-6 mt-2 mb-2">
								<input type="hidden" id="path"
									value="${pageContext.request.contextPath}" />
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Periodo</label>
									<div class="col-sm-8">
										<select class="ajax-form-periodo form-control form-control-sm"
											name="id_periodo" required>
											<option value="0">Selecciona una opcion</option>
											<c:forEach items="${listaPeriodos}" var="listaPeriodos">
												<option
													value="<c:out value=" ${listaPeriodos.id_periodos} "> </c:out>"
													${ listaPeriodos.id_periodos==id_periodo ? 'selected="selected"' : ''}>
													<c:out value="${listaPeriodos.nombre}"></c:out>
												</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Fecha Inicio</label>
									<div class="col-sm-8">

										<input value="${fecha_inicio}" type="text"
											class="form-control form-control-sm" id="fecha_inicio"
											name="fecha_inicio" placeholder="" readonly="readonly">
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-6 mt-2 mb-2">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Moneda</label>
									<div class="col-sm-8">
										<select class="form-control form-control-sm" name="id_moneda"
											required>
											<option value="">Selecciona una opcion</option>
											<c:forEach items="${listaMonedas}" var="lista">
												<option
													value="<c:out value=" ${lista.id_moneda} "> </c:out>"
													${ lista.id_moneda==id_moneda ? 'selected="selected"' : ''}>
													<c:out value="${lista.nombre_moneda}"></c:out>
												</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Fecha Final</label>
									<div class="col-sm-8">
										<input type="text" class="form-control form-control-sm"
											id="fecha_final" name="fecha_final" placeholder=""
											readonly="readonly" value="${fecha_final}">
									</div>
								</div>
								<div class="form-group row">
									<div class="form-group col-md-12 d-flex flex-row-reverse">
										<button id="btnCon" type="submit"
											class="btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Consultar</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</sf:form>
			</div>
			<c:if test="${bandera != 0}">
				<c:forEach items="${rebate}" var="rebate">
					<div class="card mt-1">
						<sf:form
							action="${pageContext.request.contextPath}/home/calculomensual/rebate/busqueda"
							method="POST" commandName="fuente" autocomplete="off">
							<div id="mainMenu" class="show card-body">
								<div class="row">
									<div class="col-sm-6 col-md-6 mt-2 mb-2">
										<input type="hidden" id="path"
											value="${pageContext.request.contextPath}" />
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Porcentaje de
												Rebate</label>
											<div class="col-sm-8">
												<input type="text"
													class=" text-right form-control form-control-sm"
													id="pocentaje_rebate" placeholder=""
													value="${rebate.relacion_porc_monto_rebate}">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label ">Monto para el
												Rebate</label>
											<div class="col-sm-8">
												<input type="text"
													class="text-right moneda-form form-control form-control-sm"
													name="monto_rebate" id="monto_rebate" placeholder=""
													value="${rebate.monto_rebate}">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Tipo de
												Calculo</label>
											<div class="col-sm-8"></div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Base</label>
											<div class="col-sm-8">
												<select
													class="ajax-form-periodo form-control form-control-sm"
													name="base">
													<option value="" selected="selected">Selecciona
														una opcion</option>
													<option value="TRA" class="text">Transaccional</option>
													<option value="ING" class="text">Ingreso</option>
												</select>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Estatus</label>
											<div class="col-sm-8">
												<input type="text"
													class="text-right form-control form-control-sm"
													id="estatus" placeholder="" readonly="readonly"
													${ rebate.estatus=='NAP' ? 'value="No Aplicado"' : 'value="Aplicado"'}>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Monto Aplicado</label>
											<div class="text-right col-sm-8">
												<label class="col-sm-4 col-form-label">${rebate.monto_rebate}</label>
											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-6 mt-2 mb-2">
										<div class="form-group row pb-5">
											<div class="col-sm-8">
												<input type="text"
													class="text-right form-control form-control-sm"
													id="pocentaje_rebate" placeholder=""
													value="${rebate.relacion_porc_monto_servicio}">
											</div>
											<div class="col-sm-2">%</div>

										</div>
										<div class="form-group row mt-4 pt-2">
											<label class="col-sm-4 col-form-label">Distribucion</label>
											<div class="col-sm-8">
												<select class="form-control form-control-sm"
													name="id_moneda">
													<option value="" selected="selected">Selecciona
														una opcion</option>
													<option value="TRA" class="text">Transaccional</option>
													<option value="ING" class="text">Ingreso</option>
												</select>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Fecha
												Aplicacion</label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm"
													id="fecha_aplicacion" placeholder="" readonly="readonly"
													value="${rebate.fecha_aplicacion}">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Moneda Monto
												Aplicado</label>
											<div class="col-sm-8">
												<input type="text" class="form-control form-control-sm"
													id="fecha_aplicacion" placeholder="" readonly="readonly"
													${ id_moneda==1 ? 'value="PESO"' : 'value="DOLAR"'}>
											</div>
										</div>
										<div class="form-group row">
											<div class="form-group col-md-12 d-flex flex-row-reverse">
												<input type="hidden" class="form-control form-control-sm"
													name="event" id="event-button">
												<button type="submit" id="btnPrin"
													class="ml-2 btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto d-none"></button>
												<button type="button" name="GruposServicio"
													class="btnClic ml-2 btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Grupos
													de Servicios</button>
												<button type="button" name="ServicioClientes"
													class="btnClic ml-2 btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Servicios-Clientes</button>
												<button type="button" name="Clientes"
													class="btnClic ml-2 btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Clientes</button>
												<button type="button" name="Servicios"
													class="btnClic ml-2 btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Servicios</button>
											</div>
										</div>
									</div>
								</div>
						</sf:form>
					</div>
		</div>
		<div class="card mt-1">
			<sf:form
				action="${pageContext.request.contextPath}/home/calculomensual/rebate/opciones"
				method="POST" commandName="fuente" autocomplete="off">
				<div id="mainMenu" class="show card-body">
					<div class="row">
						<div class="col-sm-4 col-md-4 mt-2 mb-2 mr-5">
							<input type="hidden" id="path"
								value="${pageContext.request.contextPath}" />
						</div>
						<div class="col-sm-6 col-md-6 mt-2 mb-2">
							<div class="form-group row mt-4 pt-2">
								<div class="form-group row">
									<div class="form-group col-md-12 d-flex flex-row-reverse">
										<input type="hidden" class="form-control form-control-sm"
											name="event" id="event-button-op">
										<button type="submit" id="btnPrinOp"
											class="ml-2 btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto d-none"></button>
										<button type="button" name="RegisRebate"
											class="ml-2 btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Registrar
											Rebate</button>
										<button type="button" name="DeshacerRebate"
											class="ml-2 btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Deshacer
											Rebate</button>
										<button type="button" name="Regresar"
											class="ml-2 btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Regresar</button>
										<button type="button" name="Proyectar"
											class="ml-2 btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Proyectar</button>
										<button type="button" name="Aplicar"
											class="ml-2 btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Aplicar</button>
										<button type="button" name="Reportes"
											class="ml-2 btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Reportes</button>
										<button type="button" name="RebateManual"
											class="ml-2 btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Rebate
											Manual</button>
									</div>
								</div>
							</div>
						</div>
					</div>
			</sf:form>

		</div>
		</c:forEach>
		</c:if>

		<c:if test="${bandera == 0}">

			<div class="card mt-1">
				<sf:form
					action="${pageContext.request.contextPath}/home/calculomensual/rebate/busqueda"
					method="POST" commandName="fuente" autocomplete="off">
					<div id="mainMenu" class="show card-body">
						<div class="row">
							<div class="col-sm-6 col-md-6 mt-2 mb-2">
								<input type="hidden" id="path"
									value="${pageContext.request.contextPath}" />
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Porcentaje de
										Rebate</label>
									<div class="col-sm-8">
										<input type="text"
											class=" text-right form-control form-control-sm"
											id="pocentaje_rebate" placeholder="" value="80">
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label ">Monto para el
										Rebate</label>
									<div class="col-sm-8">
										<input type="text"
											class="text-right form-control form-control-sm"
											name="monto_rebate" id="monto_rebate" placeholder="">
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Tipo de Calculo</label>
									<div class="col-sm-8"></div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Base</label>
									<div class="col-sm-8">
										<select class="ajax-form-periodo form-control form-control-sm"
											name="base">
											<option value="" selected="selected">Selecciona una
												opcion</option>
											<option value="TRA" class="text">Transaccional</option>
											<option value="ING" class="text">Ingreso</option>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Estatus</label>
									<div class="col-sm-8">
										<input type="text"
											class="text-right form-control form-control-sm" id="estatus"
											placeholder="" readonly="readonly" value="No Aplicado">
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Monto Aplicado</label>
									<div class="text-right col-sm-8">
										<label class=" col-sm-4 col-form-label">0,00</label>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-6 mt-2 mb-2">
								<div class="form-group row pb-5">
									<div class="col-sm-8">
										<input type="text"
											class="text-right form-control form-control-sm"
											id="pocentaje_rebate" placeholder="" value="20">
									</div>
									<div class="col-sm-2">%</div>

								</div>
								<div class="form-group row mt-4 pt-2">
									<label class="col-sm-4 col-form-label">Distribucion</label>
									<div class="col-sm-8">
										<select class="form-control form-control-sm" name="id_moneda">
											<option value="" selected="selected">Selecciona una
												opcion</option>
											<option value="TRA" class="text">Transaccional</option>
											<option value="ING" class="text">Ingreso</option>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Fecha Aplicacion</label>
									<div class="col-sm-8">
										<input type="text" class="form-control form-control-sm"
											id="fecha_aplicacion" placeholder="" readonly="readonly">
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Moneda Monto
										Aplicado</label>
									<div class="col-sm-8">
										<input type="text" class="form-control form-control-sm"
											id="fecha_aplicacion" placeholder="" readonly="readonly">
									</div>
								</div>
								<div class="form-group row">
									<div class="form-group col-md-12 d-flex flex-row-reverse">
										<input type="hidden" class="form-control form-control-sm"
											id="event-button" name="event">
										<button type="submit" id="btnPrin"
											class="ml-2 btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto d-none"></button>
										<button type="button" name="GruposServicio"
											class="btnClic ml-2 btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Grupos
											de Servicios</button>
										<button type="button" name="ServicioClientes"
											class="btnClic ml-2 btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Servicios-Clientes</button>
										<button type="button" name="Clientes"
											class="btnClic ml-2 btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Clientes</button>
										<button type="button" name="Servicios"
											class="btnClic ml-2 btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Servicios</button>
									</div>
								</div>
							</div>
						</div>
				</sf:form>
			</div>
	</div>
	<div class="card mt-1">
		<sf:form
			action="${pageContext.request.contextPath}/home/calculomensual/rebate/opciones"
			method="POST" commandName="fuente" autocomplete="off">
			<div id="mainMenu" class="show card-body">
				<div class="row">
					<div class="col-sm-4 col-md-4 mt-2 mb-2 mr-5">
						<input type="hidden" id="path"
							value="${pageContext.request.contextPath}" />
					</div>
					<div class="col-sm-6 col-md-6 mt-2 mb-2">
						<div class="form-group row mt-4 pt-2">
							<div class="form-group row">
								<div class="form-group col-md-12 d-flex flex-row-reverse">
									<input type="hidden" class="form-control form-control-sm"
										name="event" id="event-button-op">
									<button type="submit" id="btnPrinOp"
										class="ml-2 btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto d-none"></button>
									<button type="button" name="RegisRebate"
										class="ml-2 btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Registrar
										Rebate</button>
									<button type="button" name="DeshacerRebate"
										class="ml-2 btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Deshacer
										Rebate</button>
									<button type="button" name="Regresar"
										class="ml-2 btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Regresar</button>
									<button type="button" name="Proyectar"
										class="ml-2 btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Proyectar</button>
									<button type="button" name="Aplicar"
										class="ml-2 btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Aplicar</button>
									<button type="button" name="Reportes"
										class="ml-2 btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Reportes</button>
									<button type="button" name="RebateManual"
										class="ml-2 btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Rebate
										Manual</button>
								</div>
							</div>
						</div>
					</div>
				</div>
		</sf:form>
	</div>
	</c:if>
	<%@ include file="../layout/footer.jsp"%>