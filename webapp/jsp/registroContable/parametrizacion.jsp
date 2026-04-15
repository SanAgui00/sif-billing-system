<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<div class="card-header">
					<span class="title" id="menu-toggle">Prametrizar Registro
						Contable</span> <span class="float-right text-secondary" id="btn-ocultar">Ocultar</span>
					<sf:form
						action="${pageContext.request.contextPath}/home/registro/parametrizacion/crud"
						method="POST" name="new" id="nuevoElemento">
						<input name="event" type="hidden" value="new" />
						<button type="submit"
							class="btn-link float-right border-0 text-secondary">Nueva
							Poliza Contable</button>
					</sf:form>
				</div>


				<sf:form
					action="${pageContext.request.contextPath}/home/registro/parametrizacion/consulta"
					method="POST" commandName="fuente" autocomplete="off">
					<div id="mainMenu" class="show card-body">
						<div class="row">
							<div class="col-sm-6 col-md-6 mt-2 mb-2">
								<input type="hidden" id="path"
									value="${pageContext.request.contextPath}" />
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Polizas</label>
									<div class="col-sm-8">
										<input type="text" id="list_Polizas"
											class="form-control form-control-sm ajax-form"
											placeholder="Busca una Poliza" name="list_Polizas" />
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-6 mt-2 mb-2">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Descripcion</label>
									<div class="col-sm-8">
										<select class="form-control form-control-sm d-none "
											id="list_Polizas_r" name="id_poliza">
										</select> <select class="form-control form-control-sm "
											id="listaDePolizas" name="id_poliza">
											<option value="0">Selecciona una opcion</option>
											<c:forEach items="${listaPoliza}" var="lista">
												<option 
													value="<c:out value="${lista.id_modelo_poliza}"> </c:out>"
												${ lista.id_modelo_poliza==modelo_poliza ? 'selected="selected"' : ''}>
													<c:out value="${lista.clave}"></c:out></option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<div class="form-group col-md-12 d-flex flex-row-reverse ">
										<input type="hidden" id="clave_r" name="clave" />
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
										<th>Clave de Poliza</th>
										<th>Descripcion de Poliza</th>
										<th>Fecha de Ultima Modificacion</th>
										<th>Autor de Ultima Modificacion</th>
										<th>Fecha de Creacion</th>
										<th>Editar</th>
										<th>Eliminar</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${consulta}" var="lista">
										<tr>
											<td><c:out value="${lista.clave}"></c:out></td>
											<td><c:out value="${lista.descripcion}"></c:out></td>
											<td><fmt:formatDate value="${lista.fecha_mod}" pattern="dd/MM/YY" /></td>
											<td><c:out value="${lista.usuario}"></c:out></td>
											<td><fmt:formatDate value="${lista.fecha_cre}" pattern="dd/MM/YY" /></td>
											<td><sf:form
													action="${pageContext.request.contextPath}/home/registro/parametrizacion/crud"
													method="POST" name="crud" class="text-center">
													<input name="clave" type="hidden" value="${lista.id_modelo_poliza}" />
													<input name="event" type="hidden" value="edit" />
													<button type="button"
														class="btn btn-secondary text-white btn-sm btn-table">
														<span class="icon-brush"></span>
													</button>
												</sf:form></td>
											<td><sf:form
												action="${pageContext.request.contextPath}/home/registro/parametrizacion/crud"
												method="POST" name="crud" class="text-center">
												<input name="clave" type="hidden"
													value="${lista.id_modelo_poliza}" />
												<input name="event" type="hidden" value="delete" />
												<button type="submit"
													class="btn btn-secondary text-white btn-sm btn-table">
													<span class="icon-delete"></span>
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
							action="${pageContext.request.contextPath}/home/registro/parametrizacion/consulta"
							method="POST" name="pagination">
							<%-- 						VARIABLES OBTENIDAS MEDIANTE JS --%>
							<input type="hidden" name="listaDePolizas" id="getlistaDePolizas" class="globalGet">
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

		</div>
	</div>
	<%@ include file="../layout/footer.jsp"%>