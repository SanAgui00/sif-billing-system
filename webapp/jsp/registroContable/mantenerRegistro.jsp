<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<sf:form
					action="${pageContext.request.contextPath}/home/registro/mantener/consulta"
					method="POST" commandName="fuente" autocomplete="off">
					<div class="card-header">
						<span class="title" id="menu-toggle">Mantener Registros
							Contables</span> <span class="float-right text-secondary"
							id="btn-ocultar">Ocultar</span>
					</div>
					<div id="mainMenu" class="show card-body">
						<div class="row">
							<div class="col-sm-6 col-md-6 mt-2 mb-2">
								<input type="hidden" id="path"
									value="${pageContext.request.contextPath}" />
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Clientes</label>
									<div class="col-sm-8">
										<input type="text" id="list_Clientes"
											class="form-control form-control-sm ajax-form"
											placeholder="Busca un cliente" name="list_Clientes" />
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Proceso</label>
									<div class="col-sm-8">
										<select class="ajax-form-negocio form-control form-control-sm"
											name="proceso" id="proceso">
											<option value="">Selecciona una opcion</option>
											<c:forEach items="${listaProceso}" var="listaProceso">
												<option
													value="<c:out value=" ${listaProceso.id_proceso} "> </c:out>"
													${ listaProceso.id_proceso==proceso ? 'selected="selected"' : ''}>
													<c:out value="${listaProceso.clave_proceso}"></c:out>
												</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Fecha Datos
										Inicial</label>
									<div class="col-sm-8">

										<input type="date" class="form-fecha form-control form-control-sm"
											id="fecha_inicial" name="fecha_inicial"
											value="${fecha_inicial}" required>

									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Tipo de
										Documento</label>
									<div class="col-sm-8">
										<select class="ajax-form-periodo form-control form-control-sm"
											name="document" id="document">
											<option value="">Selecciona una opcion</option>
											<option value="ODT" class="texto"
												${ document eq 'ODT' ? 'selected="selected"' : ''}>Odt</option>
											<option value="SER" class="texto"
												${ document eq 'SER' ? 'selected="selected"' : ''}>Factura
												de Servicio</option>
											<option value="ABI" class="texto"
												${ document eq 'ABI' ? 'selected="selected"' : ''}>Factura
												Abierta</option>
											<option value="NOT" class="texto"
												${ document eq 'NOT' ? 'selected="selected"' : ''}>Nota
												de Credito</option>
											<option value="REC" class="texto"
												${ document eq 'REC' ? 'selected="selected"' : ''}>Recibo
												Electrónico de Pago</option>
										</select>
									</div>
								</div>

								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Moneda</label>
									<div class="col-sm-8">
										<select class="form-control form-control-sm" name="id_moneda"
											id="id_moneda" required>
											<option value="">Selecciona una opcion</option>
											<c:forEach items="${listaMonedas}" var="lista">
												<option value="<c:out value="${lista.id_moneda}"> </c:out>"
													${ lista.id_moneda==moneda ? 'selected="selected"' : ''}>
													<c:out value="${lista.nombre_moneda}"></c:out>
												</option>
											</c:forEach>
										</select>
									</div>
								</div>

							</div>
							<div class="col-sm-6 col-md-6 mt-2 mb-2">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Descripcion</label>
									<div class="col-sm-8">
										<select class="form-control form-control-sm d-none "
											id="list_Clientes_r" name="id_cliente">
										</select> <select class="form-control form-control-sm "
											id="listaDeClientes" name="id_cliente">
											<option value="0">Selecciona una opcion</option>
											<c:forEach items="${listaClientes}" var="lista">
												<option value="<c:out value="${lista.id_cliente}"> </c:out>"
													${ lista.id_cliente==cliente ? 'selected="selected"' : ''}>
													<c:out value="${lista.clave_cliente}"></c:out> -
													<c:out value="${lista.nombre_corto}"></c:out></option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Negocio</label>
									<div class="col-sm-8">
										<select class="form-control form-control-sm" name="id_negocio"
											id="id_negocio">
											<option value="">Selecciona una opcion</option>
											<c:forEach items="${listaNegocios}" var="lista">
												<option value="<c:out value="${lista.id_negocio}"> </c:out>"
													${ lista.id_negocio==negocio ? 'selected="selected"' : ''}>
													<c:out value="${lista.clave}"></c:out>
												</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Fecha Datos
										Final</label>
									<div class="col-sm-8">

										<input type="date" class="form-fecha form-control form-control-sm"
											id="fecha_final" name="fecha_final" value="${fecha_final}"
											required >

									</div>
								</div>

								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Estatus</label>
									<div class="col-sm-8">
										<select class="form-control form-control-sm" name="estatus"
											id="estatus" required>
											<option value="">Selecciona una opcion</option>
											<option value="ENV" class="texto"
												${ estatus eq 'ENV' ? 'selected="selected"' : ''}>Enviado</option>
											<option value="GEN" class="texto"
												${ estatus eq 'GEN' ? 'selected="selected"' : ''}>Pendiente
												por Enviar</option>
											<option value="REV" class="texto"
												${ estatus eq 'REV' ? 'selected="selected"' : ''}>Reversado</option>
										</select>
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
		</div>
	</div>
	<div class="card mt-1">
		<sf:form
			action="${pageContext.request.contextPath}/home/estados/cuenta/consulta"
			method="POST" commandName="fuente" autocomplete="off">
			<div class="card-header">
				<span class="title" id="menu-toggle">Opciones de Envio a GL</span>
			</div>
			<div id="mainMenu" class="show card-body">
				<div class="row">
					<div class="col-sm-6 col-md-6 mt-2 mb-2">
						<input type="hidden" id="path"
							value="${pageContext.request.contextPath}" />
						<div class="form-group row">
							<label class="col-sm-4 col-form-label">Forma de Envio</label>
							<div class="col-sm-8">
								<select class="ajax-form-periodo form-control form-control-sm"
									name="envio">
									<option value="">Selecciona una opcion</option>
									<option value="LOT">Por Lote</option>
									<option value="POL">Por Póliza</option>
								</select>
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-md-6 mt-2 mb-2">

						<div class="form-group row">
							<label class="col-sm-4 col-form-label">Categoria</label>
							<div class="col-sm-8">

								<input type="text" class="form-control form-control-sm"
									id="fecha_final" name="fecha_final">

							</div>
						</div>

					</div>
				</div>
			</div>
		</sf:form>
	</div>
	<div>
		<c:if test="${not empty consulta}">
			<div class="card mt-2">
				<div class="table-responsive">
					<table
						class="table table-scroll table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th>Poliza</th>
								<th>Descripcion del Registro Contable</th>
								<th>Fecha de Generacion del Registro Contable</th>
								<th>Fecha de Datos</th>
								<th>Estatus</th>
								<th>ID SILFAC</th>
								<th>Marcar</th>
								<th>Editar</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${consulta}" var="lista">
								<tr>
									<td>${lista.id_poliza}</td>
									<td>${lista.descripcion}</td>
									<td><fmt:formatDate value="${lista.fecha_cre}"
											pattern="dd/MM/YY" /></td>
									<td><fmt:formatDate value="${lista.fecha_datos_ini}"
											pattern="dd/MM/YY" /></td>
									<td>${ lista.estatus eq 'ENV' ? 'Enviado' : 'Pendiente por Enviar'}</td>
									<td>${lista.id_generado_gl}</td>

									<td><div class="form-check">
											<input class="form-check-input position-static"
												type="checkbox" id="idAsignacion" name="idAsignacion"
												value="${lista.id_poliza},${lista.descripcion},${lista.fecha_cre},${lista.estatus}">
										</div></td>
									<td><sf:form
											action="${pageContext.request.contextPath}/home/registro/mantener/crud"
											method="POST" name="crud" class="text-center">
											<input name="clave" type="hidden" value="${lista.id_poliza}" />
											<input name="descripcion" type="hidden" value="${lista.descripcion}" />
											<input name="fecha" type="hidden" value="${lista.fecha_cre}" />
											<input name="id_generado_gl" type="hidden" value="${lista.id_generado_gl}" />
											<input name="moneda" type="hidden" value="${moneda}" />
											<input name="estatus" type="hidden" value="${lista.estatus}" />
											<input name="event" type="hidden" value="edit" />
											<button type="submit"
												class="btn btn-secondary text-white btn-sm btn-table" disabled>
												<span class="icon-brush" ></span>
											</button>
										</sf:form></td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<c:if test="${not empty registros_totales}">
				<sf:form
					action="${pageContext.request.contextPath}/home/registro/mantener/consulta"
					method="POST" name="pagination">
					<%-- 						VARIABLES OBTENIDAS MEDIANTE JS --%>
					<input type="hidden" name="id_cliente" id="getid_cliente"
						class="globalGet">
					<input type="hidden" name="proceso" id="getproceso"
						class="globalGet">
					<input type="hidden" name="id_negocio" id="getid_negocio"
						class="globalGet">
					<input type="hidden" name="fecha_inicial" id="getfecha_inicial"
						class="globalGet">
					<input type="hidden" name="fecha_final" id="getfecha_final"
						class="globalGet">
					<input type="hidden" name="document" id="getdocument"
						class="globalGet">
					<input type="hidden" name="estatus" id="getestatus"
						class="globalGet">
					<input type="hidden" name="id_moneda" id="getid_moneda"
						class="globalGet">

					<input type="hidden" name="registros_totales"
						id="registros_totales" class="registros_totales"
						value="${registros_totales}">
					<input type="hidden" name="fromRow" id="fromRow" class="fromRow"
						value="">

					<nav>
						<ul class="pagination  pagination-sm justify-content-end">
							<span class='page-link prev'><span class="icon-arrow_back"></span></span>
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
		<div class="col-md-12 col-lg-12 pl-0 pr-0">
			<div class="row">
				<div class="col-sm-12">
					<div class="card mt-1">
						<sf:form
							action="${pageContext.request.contextPath}/home/registro/mantener/envreveli"
							method="POST" commandName="fuente" autocomplete="off">
							<div class="card-header">
								<span class="title" id="menu-toggle">Polizas Contables</span>
							</div>
							<div id="mainMenu" class="show card-body">
								<div class="row">
									<div class="col-sm-4 col-md-4 mt-2 mb-2">
										<div class="form-group row">
											<div class="form-group col-md-12 d-flex flex-row-reverse">
												<button name="btnEnviar" type="submit"
													class="mr-5 btnMantener btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto"
													${ estatus eq 'ENV' ? 'disabled' : ''}>Enviar
													Polizas Contables</button>
											</div>
										</div>
									</div>
									<input class="form-check-input position-static"
												type="hidden" id="opcion" name="fecha_inicial" value="${fecha_inicial}">
									<input class="form-check-input position-static"
												type="hidden" id="opcion" name="fecha_final" value="${fecha_final}">
									<div class="col-sm-4 col-md-4 mt-2 mb-2">
										<div class="form-group row">
											<div class="form-group col-md-12 d-flex flex-row-reverse">
												<button name="btnReversar" type="submit"
													class="mr-5 btnMantener btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto"
													${ estatus eq 'ENV' ? '' : 'disabled'}>Reversar
													Polizas Contables</button>
											</div>
										</div>
									</div>
									<div class="col-sm-4 col-md-4 mt-2 mb-2">
										<input class="form-check-input position-static"
												type="hidden" id="opcion" name="opcion" >
										<input class="form-check-input position-static"
												type="hidden" id="datos" name="datos" >
										<div class="form-group row">
											<div class="form-group col-md-12 d-flex flex-row-reverse">
												<button id="btnGen" type="submit" class="d-none"></button>
												<button name="btnEli" type="submit"
													class="mr-5 btnMantener btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto"
													${ estatus eq 'ENV' ? 'disabled' : ''}>Eliminar
													Polizas Contables</button>
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
	</c:if>
</div>
<%@ include file="../layout/footer.jsp"%>