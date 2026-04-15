<%--
################################################################################
# Autor               : Gutierrez Estrada Luis Antonio                         #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 25/04/2018 #
# Descripcion General : Vista JSP para  Catalógo SAT 						   # 
#  Certificados		 	                    				          	       #
# Marca del cambio    :                                                        #
#------------------------------------------------------------------------------#
# Numero de Parametros: N/A                                                    #
# Parametros Entrada  : N/A                                  Formato:          #
# Parametros Salida   : N/A                                  Formato:          #
################################################################################
--%>
<%@ include file="../../layout/header.jsp"%>
<%@ include file="../../layout/menu.jsp"%>
<div class="col-md-10 ml-sm-auto col-lg-10">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				
					<div class="card-header">
						<span class="title" id="menu-toggle">Catálogo Certificados</span> <span class="float-right text-secondary"
							id="btn-ocultar">Ocultar</span>
						<sf:form
						action="${pageContext.request.contextPath}/home/cat/sat/certificado/crud"
						method="POST" name="new" id="nuevoElemento">
						<input name="event" type="hidden" value="new" />
						<button type="submit"
							class="btn-link float-right border-0 text-secondary"> Nuevo
							Certificados </button>
					</sf:form>
					</div>
				<sf:form
					action="${pageContext.request.contextPath}/home/cat/sat/certificado"
					method="POST" commandName="fuente" autocomplete="off">
					<div id="mainMenu" class="show card-body">
						<div class="row">
							<div class="col-sm-6 col-md-6 mt-2 mb-2">
								<input type="hidden" id="path"
									value="${pageContext.request.contextPath}" />
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Certificado </label>
									<div class="col-sm-8">
										<select class="ajax-form-negocio form-control form-control-sm"
											name="certificado" id="certificado">
											<option value="">Selecciona una opcion</option>
											<c:forEach items="${ListaCertificados}" var="fuente">
						<option value="${fuente.id}" ${fuente.id eq certificado ? 'selected="selected"' : ''}>
							
							<c:out value="${fuente.id}"></c:out>
							<c:out value="-"></c:out>
							<c:out value="${fuente.descripcion}"></c:out>
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
						 		<th>Empresa</th>
								<th>Certificado Privado</th>
								<th>Certificado Publico</th>
								<th>Ruta del certificado</th>
								<th>Descripción</th>
								<th>Estatus</th>
								<th>Editar</th>
								<th>Eliminar</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach items="${consulta}" var="lista">
										<tr>

											<td><c:out value="${lista.razon_social}"></c:out></td>
											<td><c:out value="${lista.cert_privado}"></c:out></td>
											<td><c:out value="${lista.cert_publico}"></c:out></td>
											<td><c:out value="${lista.cert_ruta}"></c:out></td>
											<td><c:out value="${lista.descripcion}"></c:out></td>
											<td><c:out value="${lista.estatus}"></c:out></td>
										

											<td><sf:form
													action="${pageContext.request.contextPath}/home/cat/sat/certificado/crud"
													method="POST" name="crud" class="text-center">
													<input name="clave" type="hidden" value="${lista.id}" />
													<input name="event" type="hidden" value="edit" />
													<button type="submit"
														class="btn btn-secondary text-white btn-sm btn-table">
														<span class="icon-brush"></span>
													</button>
												</sf:form></td>
											<td><sf:form
													action="${pageContext.request.contextPath}/home/cat/sat/certificado/crud"
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
					action="${pageContext.request.contextPath}/home/cat/sat/certificado"
					method="POST" name="pagination">
					<!-- 						VARIABLES OBTENIDAS MEDIANTE JS -->
					

					<input type="hidden" name="certificado" id="getcertificado"
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