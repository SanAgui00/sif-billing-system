<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				
					<div class="card-header">
						<span class="title" id="menu-toggle">Tipos de Cambio</span> <span class="float-right text-secondary"
							id="btn-ocultar">Ocultar</span>
						<sf:form
						action="${pageContext.request.contextPath}/home/cat/sat/metodopago/crud"
						method="POST" name="new" id="nuevoElemento">
						<input name="event" type="hidden" value="new" />
					</sf:form>
					</div>
				<sf:form
					action="${pageContext.request.contextPath}/home/cobranzadiaria/tipocambio/consulta"
					method="POST" commandName="fuente" autocomplete="off">
					<div id="mainMenu" class="show card-body">
						<div class="row">
							<div class="col-sm-6 col-md-6 mt-2 mb-2">
								<input type="hidden" id="path"
									value="${pageContext.request.contextPath}" />
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Periodo</label>
									<div class="col-sm-8">
										<select class="ajax-form-negocio form-control form-control-sm"
											name="id_periodo" id="id_periodo" required>
											<option value="">Selecciona una opcion</option>
											<c:forEach items="${listaPeriodos}" var="listaPeriodos">
												<option value="<c:out value="${listaPeriodos.id_periodos}"> </c:out>" ${listaPeriodos.id_periodos==id_peri ? 'selected="selected"' : ''}>
													<c:out value="${listaPeriodos.nombre}"></c:out>
												</option>
											</c:forEach>
										</select>
									</div>
								</div>
								

							</div>
							<div class="col-sm-6 col-md-6 mt-2 mb-2">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Moneda</label>
									<div class="col-sm-8">
										<select class="form-control form-control-sm "
											id="id_moneda" name="id_moneda" required>
											<option value="">Selecciona una opcion</option>
											<c:forEach items="${listaMonedas}" var="lista">
												<option value="<c:out value="${lista.id_moneda}"> </c:out>"
													${lista.id_moneda eq id_mone ? 'selected="selected"' : ''}>
													<c:out value="${lista.nombre_moneda}"></c:out>
												</option>
											</c:forEach>
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
	<div>
			<c:if test="${not empty consulta}">
				<div class="card mt-2">
					<div class="table-responsive">
						<table
							class="table table-scroll table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th class="text-center" scope="col">Día</th>
									<th class="text-center" scope="col">Tipo de cambio</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${consulta}" var="consulta">
									<tr>

										<td class="text-center"><fmt:formatDate
												value="${consulta.fecha_tipo_cambio}"
												pattern="dd/MM/YY - EEEE" /></td>
										<td class=""><input type="text"
											class="text-center center-block form-control form-control-sm"
											id="tipo_cambio" name="tipo_cambio"
											value="${consulta.tipo_cambio}"></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
					<div class="card mt-1">

		<div id="mainMenu" class="collapse show card-body">

			<div class="form-row mt-2">
				<div class="form-group col-md-8 d-flex flex-row-reverse"></div>
				<div class="form-group col-md-4 d-flex flex-row-reverse">
					<input type="hidden" class="form-control form-control-sm"
						name="event" id="event-button">
					<sf:form
						action="${pageContext.request.contextPath}/home/cobranza/cambio"
						method="POST" commandName="fuente" autocomplete="off">
					<button type="submit" id="btnDir"
						class="ml-2 btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto d-none"></button>
					</sf:form>
					<button type="submit"
						class="botonArray pr-4 pr-4 btn btn-secondary text-white btn-sm float-right ml-3 mt-auto mb-1">Guardar</button>
					<sf:form
						action="${pageContext.request.contextPath}/home/cobranzadiaria/tipocambio/imprimir"
						method="POST" commandName="fuente" autocomplete="off">
						<button type="submit"
							class="btnClic btnImprimir pr-4 pr-4 btn btn-secondary text-white btn-sm float-right  mt-auto mb-1">Imprimir</button>
					</sf:form>
				</div>
			</div>
		</div>

	</div>
			</c:if>
		</div>

</div>
<%@ include file="../layout/footer.jsp"%>