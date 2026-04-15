<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<div class="card-header">
					<span class="title" id="menu-toggle">Generar Registros
						Contables</span> <span class="float-right text-secondary"
						id="btn-ocultar">Ocultar</span>
					
				</div>


				<sf:form
					action="${pageContext.request.contextPath}/home/registro/generar/consulta"
					method="POST" commandName="fuente" autocomplete="off">
					<div id="mainMenu" class="show card-body">
						<div class="row">
							<div class="col-sm-6 col-md-6 mt-2 mb-2">
								<input type="hidden" id="path"
									value="${pageContext.request.contextPath}" />
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Proceso</label>
									<div class="col-sm-8">
										<select class="ajax-form-negocio form-control form-control-sm"
											name="proceso" id="proceso">
											<option value="0">Selecciona una opcion</option>
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

										<input type="date" class="form-control form-control-sm"
											id="fecha_inicial" name="fecha_inicial" required
											value="${fecha_inicial}">

									</div>
								</div>

							</div>
							<div class="col-sm-6 col-md-6 mt-2 mb-2">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Negocio</label>
									<div class="col-sm-8">
										<select class="form-control form-control-sm" name="id_negocio"
											id="id_negocio">
											<option value="0">Selecciona una opcion</option>
											<c:forEach items="${listaNegocios}" var="lista">
												<option
													value="<c:out value=" ${lista.id_negocio} "> </c:out>"
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

										<input type="date" class="form-control form-control-sm"
											id="fecha_final" name="fecha_final" required
											value="${fecha_final}">

									</div>
								</div>

								<div class="form-group row">
									<div class="form-group col-md-12 d-flex flex-row-reverse ">
										<button id="btnCon" type="submit"
											class="btn btn-secondary text-white btn-sm float-right ml-3  mb-1 mt-auto">Consultar</button>

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
										<th>Clave de Negocio</th>
										<th>Descripcion de Negocio</th>
										<th>Clave de Poliza</th>
										<th>Descripcion de la Poliza Contable</th>
										<th>Fecha de Calculo</th>
										<th>Fecha de Registro Contable</th>
										<th>Marcar</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${consulta}" var="lista">
										<tr>
											<td><c:out value="${lista.clave_negocio}"></c:out></td>
											<td><c:out value="${lista.descripcion_negocio}"></c:out></td>
											<td><c:out value="${lista.clave_modelo_poliza}"></c:out></td>
											<td><c:out value="${lista.descripcion}"></c:out></td>
											<td class="text-center"><fmt:formatDate value="${lista.fecha_calculo}" pattern="dd/MM/YY" /></td>
												<td class="text-center"><fmt:formatDate value="${lista.fecha_registro_gl}" pattern="dd/MM/YY" /></td>
											<td><div class="form-check">
													<input class="form-check-input position-static"
														type="checkbox" id="idAsignacion" name="idAsignacion"
														value="${proceso},${negocio},<fmt:formatDate value="${lista.fecha_calculo}" pattern="dd-MMM-yyyy" />,${lista.id_modelo_poliza}">
												</div></td>

										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<c:if test="${not empty registros_totales}">
						<sf:form
							action="${pageContext.request.contextPath}/home/registro/generar/consulta"
							method="POST" name="pagination">
							<%-- 						VARIABLES OBTENIDAS MEDIANTE JS --%>
							<input type="hidden" name="proceso" id="getproceso" class="globalGet">
							<input type="hidden" name="id_negocio" id="getid_negocio" class="globalGet">
							<input type="hidden" name="fecha_inicial" id="getfecha_inicial" class="globalGet">
							<input type="hidden" name="fecha_final" id="getfecha_final" class="globalGet">
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

			
				<div class="card mt-1">
					<div class="card-header">
						<span class="title" id="menu-toggle">Registros Contables</span>

					</div>

	<sf:form
										action="${pageContext.request.contextPath}/home/registro/generar/generarregistro"
										method="POST" commandName="fuente" autocomplete="off">
					<div id="mainMenu" class="show card-body">
						<div class="row">
							<div class="col-sm-6 col-md-6 mt-2 mb-2">
								<input type="hidden" id="path"
									value="${pageContext.request.contextPath}" />

							</div>
							<div class="col-sm-6 col-md-6 mt-2 mb-2">

								<div class="form-group row">

									<div class="form-group col-md-12 d-flex flex-row-reverse">

										<button id="btnCon" type="submit"
											class="btn btn-secondary text-white btn-sm float-right ml-2 mb-1 mt-auto">Generar
											Reverso Mensual</button>
										
										<button id="llenarMandar" type="submit"
											class="btn btn-secondary text-white btn-sm float-right ml-3  mb-1 mt-auto">Generar
											 Registros Contables</button>
										<input type="hidden" id="checkval" name="checkval"/>
										<button id="Mandar" type="submit"
											class="btn btn-secondary text-white btn-sm float-right ml-3 d-none mb-1 mt-auto"></button>
									

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
<%@ include file="../layout/footer.jsp"%>