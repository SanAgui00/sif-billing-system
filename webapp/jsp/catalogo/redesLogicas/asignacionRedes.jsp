<%-- ################################################################################ --%>
<%-- # Autor               : Garnica                                                # --%>
<%-- # Compania            : Código Geek                                            # --%>
<%-- # Proyecto/Procliente : Vista de Asignacion de redes         Fecha: 08/03/2018 # --%>
<%-- # Descripcion General : 									   	                # --%>
<%-- # Marca del cambio    : 									                    # --%>
<%-- ################################################################################ --%>
<%@ include file="../../layout/header.jsp"%>
<%@ include file="../../layout/menu.jsp"%>
<div class="col-md-10 ml-sm-auto col-lg-10">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<div class="card-header">
					<span class="title" id="menu-toggle">Mantenimiento de
						Catalogo de Redes Logicas</span> <span class="float-right text-secondary"
						id="btn-ocultar">Ocultar</span>
					<sf:form
						action="${pageContext.request.contextPath}/home/cat/redes/crud"
						method="POST" name="new" id="nuevoElemento">
						<input name="event" type="hidden" value="new" />
					</sf:form>
				</div>


				<div id="mainMenu" class="show card-body">
					<div class="row">
						<div class="col-sm-6 col-md-6 mt-2 mb-2">
							<input type="hidden" id="path"
								value="${pageContext.request.contextPath}" />
							<div class="form-group row">
								<label class="col-sm-4 col-form-label">Redes Logicas</label>
								<div class="col-sm-8">
									<select class="changelogic form-control form-control-sm"
										name="clave" id="clave">
										<option value="">Selecciona una opcion</option>
										<c:forEach items="${listaRedesLogicas}" var="lista">
											<option value="<c:out value="${lista.clave}"> </c:out>"
											${lista.clave eq clave ? 'selected="selected"' : ''}>
												<c:out value="${lista.clave}"></c:out> -
												<c:out value="${lista.descripcion}"></c:out>
											</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="col-sm-6 col-md-6 mt-2 mb-2">
							<div class="form-group row">
								<div class="form-group col-md-12 d-flex flex-row-reverse ">
									<sf:form
										action="${pageContext.request.contextPath}/home/cat/redes/asignacion/consulta"
										method="POST" commandName="fuente" autocomplete="off">
										<input type="hidden" id="clave_r" name="clave"/>
										<button id="btnCon" type="submit"
											class="btn btn-secondary text-white btn-sm float-right ml-3  mb-1 mt-auto">Consultar</button>
									</sf:form>
									<sf:form
										action="${pageContext.request.contextPath}/home/cat/redes/asignacion/confirmar"
										method="POST" commandName="fuente" autocomplete="off">
										<button id="llenarMandar" type="button"
											class="btn btn-secondary text-white btn-sm float-right ml-3  mb-1 mt-auto">Confirmar
											Servicios</button>
										<input type="hidden" id="checkval" name="checkval"/>
										<button id="Mandar" type="submit"
											class="btn btn-secondary text-white btn-sm float-right ml-3 d-none mb-1 mt-auto"></button>
									</sf:form>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
			<div>
				<c:if test="${not empty consultaLogic}">
					<div class="card mt-2">
						<div class="table-responsive">
							<table
								class="table table-scroll table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>Clave de Red Logica</th>
										<th>Clave Servicio</th>
										<th>Descripcion</th>
										<th>Estatus</th>
										<th>Incluir/Excluir</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${consultaLogic}" var="lista">
										<tr>
											<td><c:out value="${lista.cv_red_logica}"></c:out></td>
											<td><c:out value="${lista.cv_servicio}"></c:out></td>
											<td><c:out value="${lista.descripcion}"></c:out></td>
											<td>${lista.estatus eq 'ACT' ? 'ACTIVO' : 'NO ACTIVO'}</td>
											<td><div class="form-check">
												<input class="form-check-input position-static"  type="checkbox" id="idAsignacion" name="idAsignacion" 
											value="${lista.cv_red_logica},${lista.cv_servicio},${lista.estatus}">
											</div>
											</td>
											
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<c:if test="${not empty registros_totales}">
						<sf:form
							action="${pageContext.request.contextPath}/home/cat/redes/asignacion/consulta"
							method="POST" name="pagination">
							<%-- 						VARIABLES OBTENIDAS MEDIANTE JS --%>
							<input type="hidden" name="clave" id="getclave" class="globalGet">
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

			<sf:form
				action="${pageContext.request.contextPath}/home/cat/redes/asignacion/agregarservicio"
				method="POST" commandName="fuente" autocomplete="off">
				<div class="card mt-1">
					<div class="card-header">
						<span class="title" id="menu-toggle">Agrergar Servicios</span> 

					</div>


					<div id="mainMenu" class="show card-body">
						<div class="row">
							<div class="col-sm-6 col-md-6 mt-2 mb-2">
								<input type="hidden" id="path"
									value="${pageContext.request.contextPath}" />
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Fuente</label>
									<div class="col-sm-8">
										<select class="changelogic form-control form-control-sm"
											name="clave" id="clave">
											<option value="">Selecciona una opcion</option>
											<c:forEach items="${consulta}" var="lista">
												<option value="<c:out value="${lista.clave}"> </c:out>">
													<c:out value="${lista.clave} -"></c:out> -
													<c:out value="${lista.descripcion}"></c:out>
												</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-6 mt-2 mb-2">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Servicio</label>
									<div class="col-sm-8">
										<select class="changelogic form-control form-control-sm"
											name="id_servicio" id="id_servicio">
											<option value="">Selecciona una opcion</option>
											<c:forEach items="${listaService}" var="lista">
												<option value="<c:out value="${lista.clave}"> </c:out>">
													<c:out value="${lista.clave}"></c:out> -
													<c:out value="${lista.descripcion}"></c:out>
												</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group row">

									<div class="form-group col-md-12 d-flex flex-row-reverse">


										<button id="btnCon" type="submit"
											class="btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Agregar Servicio</button>

									</div>
								</div>
							</div>
						</div>
					</div>
			</sf:form>
		</div>
	</div><%@ include file="../../layout/footer.jsp"%>