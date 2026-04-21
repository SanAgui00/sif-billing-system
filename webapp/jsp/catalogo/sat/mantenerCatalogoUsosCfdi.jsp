<%--
################################################################################
# Autor               : Garnica Garcia David                                   #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 25/04/2018 #
# Descripcion General : Vista JSP para  Catalógo SAT 						   # 
#  Usos de CFDI 	 		 	                    					       #
# Marca del cambio    :                                                        #
#------------------------------------------------------------------------------#
# Numero de Parametros: N/A                                                    #
# Parametros Entrada  : N/A                                  Formato:          #
# Parametros Salida   : N/A                                  Formato:          #
################################################################################
--%>
<%@ include file="../../layout/header.jsp"%>
<%@ include file="../../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				
					<div class="card-header">
						<span class="title" id="menu-toggle">Mantener Catálogo Usos de CFDI</span> <span class="float-right text-secondary"
							id="btn-ocultar">Ocultar</span>
						<sf:form
						action="${pageContext.request.contextPath}/home/cat/sat/cfdi/crud"
						method="POST" name="new" id="nuevoElemento">
						<input name="event" type="hidden" value="new" />
						<button type="submit"
							class="btn-link float-right border-0 text-secondary">Nuevo
							Uso</button>
					</sf:form>
					</div>
				<sf:form
					action="${pageContext.request.contextPath}/home/cat/sat/cfdi"
					method="POST" commandName="fuente" autocomplete="off">
					<div id="mainMenu" class="show card-body">
						<div class="row">
							<div class="col-sm-6 col-md-6 mt-2 mb-2">
								<input type="hidden" id="path"
									value="${pageContext.request.contextPath}" />
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Usos de CFDI</label>
									<div class="col-sm-8">
										<select class="ajax-form-negocio form-control form-control-sm"
											name="cfdi" id="cfdi">
											<option value="">Selecciona una opcion</option>
											<c:forEach items="${listaUsoCfdi}" var="lista">
												<option value="${lista.id}"
												${lista.id eq cfdi ? 'selected="selected"' : ''}>
													<c:out value="${lista.clave}"></c:out>
													<c:out value="-"></c:out>
													<c:out value="${lista.descripcion}"></c:out>
												</option>
											</c:forEach>
										</select>
									</div>
								</div>
								

							</div>
							<div class="col-sm-6 col-md-6 mt-2 mb-2">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Estatus</label>
									<div class="col-sm-8">
										<select class="form-control form-control-sm "
											id="estatus" name="estatus">
											<option value="">Selecciona una opcion</option>
											<option value="ACT" ${estatus eq 'ACT' ? 'selected="selected"' : ''}>Activo</option>
											<option value="NOA" ${estatus eq 'NOA' ? 'selected="selected"' : ''}>No Activo</option>
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
								<th>Clave</th>
								<th>Descripcion</th>
								<th>Aplica Fisica</th>
								<th>Aplica Moral</th>
								<th>Estatus</th>
								<th>Fecha</th>
								<th>Editar</th>
								<th>Eliminar</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${consulta}" var="lista">
								<tr>
									<td>${lista.clave}</td>
									<td>${lista.descripcion}</td>
									<td>${lista.aplica_fisica}</td>
									<td>${lista.aplica_moral}</td>
									<td>${lista.estatus}</td>
									<td><fmt:formatDate value="${lista.fecha}" pattern="dd/MM/YY" /></td>
									<td><sf:form
													action="${pageContext.request.contextPath}/home/cat/sat/cfdi/crud"
													method="POST" name="crud" class="text-center">
													<input name="clave" type="hidden" value="${lista.id}" />
													<input name="event" type="hidden" value="edit" />
													<button type="submit"
														class="btn btn-secondary text-white btn-sm btn-table">
														<span class="icon-brush"></span>
													</button>
												</sf:form></td>
											<td><sf:form
													action="${pageContext.request.contextPath}/home/cat/sat/cfdi/crud"
													method="POST" name="crud" class="text-center">
													<input name="clave" type="hidden" value="${lista.id}" />
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
					action="${pageContext.request.contextPath}/home/cat/sat/cfdi"
					method="POST" name="pagination">
					<!-- 						VARIABLES OBTENIDAS MEDIANTE JS -->
					<input type="hidden" name="cfdi" id="getcfdi"
						class="globalGet">
					<input type="hidden" name="estatus" id="getestatus"
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
</div>

<%@ include file="../../layout/footer.jsp"%>