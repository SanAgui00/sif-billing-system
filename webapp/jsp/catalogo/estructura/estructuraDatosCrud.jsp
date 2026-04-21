<%@ include file="../../layout/header.jsp"%>
<%@ include file="../../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row pb-4">
		<div class="col-sm-12">
			<div class="card mt-1">
				<c:if test="${event=='delete'}">
					<sf:form action="${pageContext.request.contextPath}/home/cat/estructuraDatos/save" method="POST" name="insert">
						<c:forEach items="${consulta}" var="editar">
							<input name="evento" type="hidden" value="delete" />
							<input name="id_estructura" type="hidden" value="${editar.id_estructura}" />
							<div class="card-header">
								<span class="title" id="menu-toggle">Eliminar</span> <a class="float-right text-secondary" href="<c:url value='/home/cat/estructuraDatos'/>" role="button">Regresar</a>
							</div>
							<div id="mainMenu" class="collapse show card-body">
								<div class="row">
									<div class="col-sm-12 col-md-12  text-center">
										<h5 class="card-title">
											Está a punto de eliminar a <span class="title">${editar.clave}.</span> ¿Desea continuar?
										</h5>
										<button type="submit" class="btn btn-secondary text-white btn-sm">Eliminar</button>
										<a class="btn btn-secondary text-white btn-sm" href="<c:url value='/home/cat/estructuraDatos'/>" role="button">Regresar</a>
									</div>
								</div>
							</div>
						</c:forEach>
					</sf:form>
				</c:if>
				<c:if test="${event=='edit'}">
					<c:forEach items="${consulta}" var="editar">
						<sf:form action="${pageContext.request.contextPath}/home/cat/estructuraDatos/save" method="POST" name="insert">
							<input name="evento" type="hidden" value="update" />
							<input name="id_estructura" type="hidden" value="${editar.id_estructura}" />
							<div class="card-header">
								<span class="title" id="menu-toggle">Detalle de Estructura de Datos</span> <a class="float-right text-secondary" href="<c:url value='/home/cat/estructuraDatos'/>" role="button">Regresar</a>
							</div>
							<div id="mainMenu" class="collapse show card-body pb-0">
								<div class="row">
									<div class="col-sm-6 col-md-6 mt-2">
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Fuente de Adquisición </label>
											<div class="col-sm-8">
												<select class="form-control form-control-sm" name="id_fuente">
													<c:forEach items="${listaFuentes}" var="fuente">
														<option value="<c:out value="${fuente.id_fuente}"></c:out>" ${ fuente.id_fuente==editar.id_fuente ? 'selected="selected"' : ''}><c:out value="${fuente.clave}"></c:out></option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Tabla Temporal</label>
											<div class="col-sm-8">
												<input class="form-control form-control-sm" id="" type="text" name="tabla_temporal" value="${editar.tabla_temporal} ">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-6 col-form-label">Depuración de Datos </label>
											<div class="col-sm-6">
												<select class="form-control form-control-sm" name="b_suspender_depuracion">
													<option value="0" ${ '0'==editar.b_suspender_depuracion ? 'selected="selected"' : ''}>Activado</option>
													<option value="1" ${ '1'==editar.b_suspender_depuracion ? 'selected="selected"' : ''}>Desactivado</option>
												</select>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-6 col-form-label">Campo de la Clave del Cliente</label>
											<div class="col-sm-6">
												<input id="" class="form-control form-control-sm ajax-form" name="nombre_campo_cliente" type="text" value="${editar.nombre_campo_cliente}">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-6 col-form-label">Fecha de Creación </label>
											<div class="col-sm-6">
												<input type="date" class="form-control form-control-sm" name="fecha_creacion" value="<fmt:formatDate value="${editar.fecha_creacion}" pattern="yyyy-MM-dd"/>" />
											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-6 mt-2">
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Estatus</label>
											<div class="col-sm-8">
												<select class="form-control form-control-sm" name="estatus">
													<option value="ACT" ${ 'ACT'==editar.estatus ? 'selected="selected"' : ''}>Activo</option>
													<option valur="ELI" ${ 'ELI'==editar.estatus ? 'selected="selected"' : ''}>Eliminado</option>
												</select>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Tabla Totales</label>
											<div class="col-sm-8">
												<input class="form-control form-control-sm" id="" type="text" name="tabla_totales" value="${editar.tabla_totales}">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-6 col-form-label">Carga de Datos a Tabla Temporal</label>
											<div class="col-sm-6">
												<select class="form-control form-control-sm" name="b_no_hay_carga">
													<option value="0" ${ '0'==editar.b_no_hay_carga ? 'selected="selected"' : ''}>Activado</option>
													<option value="1" ${ '1'==editar.b_no_hay_carga ? 'selected="selected"' : ''}>Desactivado</option>
												</select>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-6 col-form-label">Campo de la Clave del Cliente Adquirente</label>
											<div class="col-sm-6">
												<input class="form-control form-control-sm" id="" type="text" name="nombre_campo_cliente_adq" value="${editar.nombre_campo_cliente_adq}">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-6 col-form-label">Fecha de Últ. Mod </label>
											<div class="col-sm-6">
												<input type="date" class="form-control form-control-sm" name="fecha_mod" value="<fmt:formatDate value="${editar.fecha_mod}" pattern="yyyy-MM-dd"/>" />
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-6 col-form-label">Usuario</label>
											<div class="col-sm-6">
												<input class="form-control form-control-sm" id="" type="text" name="usuario" value="${editar.usuario}">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-6 col-form-label">Comentarios</label>
											<div class="col-sm-6">
												<textarea class="form-control" id="" rows="3" name="comentarios">${editar.comentarios}</textarea>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-12 mt-1">
												<button type="submit" class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto btnAppendConceptos">Actualizar</button>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="container">
							<div class="row">
										<div class="col-sm-10 col-md-12 mt-2">
											<blockquote class="blockquote">
												<footer class="blockquote-footer"> La opción de suspender la depuración automática puede ser utilizada para mantener datos en la tabla temporal con la finalidad de ejecutar pruebas de las reglas de conversión de servicios. Sin embargo se recomenda cautela en la utilización de esta opción, ya que podrá impactar en el desempeño y mantenimiento de la base de datos. </footer>
												<footer class="blockquote-footer"> En los casos en que no se hará cópia de datos de la fuente a una tabla temporal, se debe desmarcar la opción para realizar el proceso de carga, y se debe indicar los nombres de los campos de la tabla fuente en los cuales están las claves de cliente emisor y cliente adquirente. Por default, si no se indican nombres para estos campos, se assumirán los nombres CLAVE_CLIENTE y CLAVE_CLIENTE_ADQ, respectivamente. </footer>
												<footer class="blockquote-footer"> Cuando la opción de NO REALIZAR el proceso de carga esté marcada, no se hará depuración de los datos. </footer>
												<footer class="blockquote-footer"> Es requerido que la tabla temporal posea los campos abajo: </footer>
												<footer class="blockquote-footer"> CLAVE_CLIENTE VARCHAR2(20) </footer>
												<footer class="blockquote-footer"> CLAVE_CLIENTE_ADQ VARCHAR2(20) </footer>
												<footer class="blockquote-footer"> CLAVE_CLIENTE_SILFAC VARCHAR2(20) </footer>
												<footer class="blockquote-footer"> CLAVE_CLIENTE_ADQ_SILFAC VARCHAR2(20) </footer>
												<footer class="blockquote-footer"> FECHA_CONVERSION DATE  </footer>
												<footer class="blockquote-footer"> NUM_CONVERSIONES NUMBER(4)  </footer>
												<footer class="blockquote-footer"> SERVICIOS_CONVERTIDOS VARCHAR2(500) </footer>
												<footer class="blockquote-footer"> FECHA_PROCESO_SILFAC DATE </footer>
												<footer class="blockquote-footer"> Es requerido que la tabla de totales posea la estructura abajo: </footer>
												<footer class="blockquote-footer"> FECHA_PROCESO DATE  </footer>
												<footer class="blockquote-footer"> CLAVE_SERVICIO VARCHAR2(25) </footer>
												<footer class="blockquote-footer"> CLAVE_CLIENTE VARCHAR2(20) </footer>
												<footer class="blockquote-footer"> B_TIPO_ADQ VARCHAR2(3)  </footer>
												<footer class="blockquote-footer"> CLAVE_CLIENTE_ADQ VARCHAR2(20) </footer>
												<footer class="blockquote-footer"> FECHA_SILFAC DATE  </footer>
												<footer class="blockquote-footer"> MONTO_TRANS_EMI_0 NUMBER(10)  </footer>
												<footer class="blockquote-footer"> MONTO_EMI_0 NUMBER(20,2) </footer>
												<footer class="blockquote-footer"> MONTO_TRANS_ADQ_0 NUMBER(10)  </footer>
												<footer class="blockquote-footer"> MONTO_ADQ_0 NUMBER(20,2) </footer>
												<footer class="blockquote-footer"> Para cada concepto extra que se utilice se deben de agregar el grupo de cuatro campos MONTO_, modificando solamente el número al final, por ejemplo si la fuente tiene 2 conceptos para determinado servicio, se agregan a la tabla de totales los campos abajo: </footer>
												<footer class="blockquote-footer"> MONTO_TRANS_EMI_1 NUMBER(10)  </footer>
												<footer class="blockquote-footer"> MONTO_EMI_1 NUMBER(20,2) </footer>
												<footer class="blockquote-footer"> MONTO_TRANS_ADQ_1 NUMBER(10)  </footer>
												<footer class="blockquote-footer"> MONTO_ADQ_1 NUMBER(20,2) </footer>
											</blockquote>
										</div>
									</div>
							</div>
						</sf:form>
					</c:forEach>
				</c:if>
				<c:if test="${event=='new'}">
					<sf:form action="${pageContext.request.contextPath}/home/cat/estructuraDatos/save" method="POST" name="insert">
						<input name="evento" type="hidden" value="insert" />
						<div class="card-header">
							<span class="title" id="menu-toggle">Agregar Estructura de Datos</span> <a class="float-right text-secondary" href="<c:url value='/home/cat/estructuraDatos'/>" role="button">Regresar</a>
						</div>
						<div id="mainMenu" class="collapse show card-body pb-0">
							<div class="row">
								<div class="col-sm-6 col-md-6 mt-2">
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Fuente de Adquisición </label>
										<div class="col-sm-8">
											<select class="form-control form-control-sm" name="id_fuente">
												<c:forEach items="${listaFuentes}" var="fuente">
													<option value="<c:out value="${fuente.id_fuente}"></c:out>"><c:out value="${fuente.clave}"></c:out></option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Tabla Temporal</label>
										<div class="col-sm-8">
											<input class="form-control form-control-sm" id="" type="text" name="tabla_temporal">
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-6 col-form-label">Depuración de Datos </label>
										<div class="col-sm-6">
											<select class="form-control form-control-sm" name="b_suspender_depuracion">
												<option value="0">Activado</option>
												<option value="1">Desactivado</option>
											</select>
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-6 col-form-label">Campo de la Clave del Cliente</label>
										<div class="col-sm-6">
											<input id="" class="form-control form-control-sm ajax-form" name="nombre_campo_cliente" type="text">
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-6 col-form-label">Fecha de Creación </label>
										<div class="col-sm-6">
											<input type="date" class="form-control form-control-sm" name="fecha_creacion" value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>" />
										</div>
									</div>
								</div>
								<div class="col-sm-6 col-md-6 mt-2">
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Estatus</label>
										<div class="col-sm-8">
											<select class="form-control form-control-sm" name="estatus">
												<option value="ACT">Activo</option>
												<option valur="ELI">Eliminado</option>
											</select>
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Tabla Totales</label>
										<div class="col-sm-8">
											<input class="form-control form-control-sm" id="" type="text" name="tabla_totales">
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-6 col-form-label">Carga de Datos a Tabla Temporal</label>
										<div class="col-sm-6">
											<select class="form-control form-control-sm" name="b_no_hay_carga">
												<option value="0">Activado</option>
												<option value="1">Desactivado</option>
											</select>
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-6 col-form-label">Campo de la Clave del Cliente Adquirente</label>
										<div class="col-sm-6">
											<input class="form-control form-control-sm" id="" type="text" name="nombre_campo_cliente_adq">
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-6 col-form-label">Fecha de Últ. Mod </label>
										<div class="col-sm-6">
											<input type="date" class="form-control form-control-sm" name="fecha_mod" value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>" />
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-6 col-form-label">Usuario</label>
										<div class="col-sm-6">
											<input class="form-control form-control-sm" id="" type="text" name="usuario">
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-6 col-form-label">Comentarios</label>
										<div class="col-sm-6">
											<textarea class="form-control" id="" rows="3" name="comentarios"></textarea>
										</div>
									</div>

									<div class="form-group row">
										<div class="col-md-12 mt-1">
											<button type="submit" class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto btnAppendConceptos">Guardar</button>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="container">
						<div class="row">
										<div class="col-sm-12 col-md-12 mt-1">
											<blockquote class="blockquote">
												<footer class="blockquote-footer"> La opción de suspender la depuración automática puede ser utilizada para mantener datos en la tabla temporal con la finalidad de ejecutar pruebas de las reglas de conversión de servicios. Sin embargo se recomenda cautela en la utilización de esta opción, ya que podrá impactar en el desempeño y mantenimiento de la base de datos. </footer>
												<footer class="blockquote-footer"> En los casos en que no se hará cópia de datos de la fuente a una tabla temporal, se debe desmarcar la opción para realizar el proceso de carga, y se debe indicar los nombres de los campos de la tabla fuente en los cuales están las claves de cliente emisor y cliente adquirente. Por default, si no se indican nombres para estos campos, se assumirán los nombres CLAVE_CLIENTE y CLAVE_CLIENTE_ADQ, respectivamente. </footer>
												<footer class="blockquote-footer"> Cuando la opción de NO REALIZAR el proceso de carga esté marcada, no se hará depuración de los datos. </footer>
												<footer class="blockquote-footer"> Es requerido que la tabla temporal posea los campos abajo: </footer>
												<footer class="blockquote-footer"> CLAVE_CLIENTE VARCHAR2(20) </footer>
												<footer class="blockquote-footer"> CLAVE_CLIENTE_ADQ VARCHAR2(20) </footer>
												<footer class="blockquote-footer"> CLAVE_CLIENTE_SILFAC VARCHAR2(20) </footer>
												<footer class="blockquote-footer"> CLAVE_CLIENTE_ADQ_SILFAC VARCHAR2(20) </footer>
												<footer class="blockquote-footer"> FECHA_CONVERSION DATE  </footer>
												<footer class="blockquote-footer"> NUM_CONVERSIONES NUMBER(4)  </footer>
												<footer class="blockquote-footer"> SERVICIOS_CONVERTIDOS VARCHAR2(500) </footer>
												<footer class="blockquote-footer"> FECHA_PROCESO_SILFAC DATE </footer>
												<footer class="blockquote-footer"> Es requerido que la tabla de totales posea la estructura abajo: </footer>
												<footer class="blockquote-footer"> FECHA_PROCESO DATE  </footer>
												<footer class="blockquote-footer"> CLAVE_SERVICIO VARCHAR2(25) </footer>
												<footer class="blockquote-footer"> CLAVE_CLIENTE VARCHAR2(20) </footer>
												<footer class="blockquote-footer"> B_TIPO_ADQ VARCHAR2(3)  </footer>
												<footer class="blockquote-footer"> CLAVE_CLIENTE_ADQ VARCHAR2(20) </footer>
												<footer class="blockquote-footer"> FECHA_SILFAC DATE  </footer>
												<footer class="blockquote-footer"> MONTO_TRANS_EMI_0 NUMBER(10)  </footer>
												<footer class="blockquote-footer"> MONTO_EMI_0 NUMBER(20,2) </footer>
												<footer class="blockquote-footer"> MONTO_TRANS_ADQ_0 NUMBER(10)  </footer>
												<footer class="blockquote-footer"> MONTO_ADQ_0 NUMBER(20,2) </footer>
												<footer class="blockquote-footer"> Para cada concepto extra que se utilice se deben de agregar el grupo de cuatro campos MONTO_, modificando solamente el número al final, por ejemplo si la fuente tiene 2 conceptos para determinado servicio, se agregan a la tabla de totales los campos abajo: </footer>
												<footer class="blockquote-footer"> MONTO_TRANS_EMI_1 NUMBER(10)  </footer>
												<footer class="blockquote-footer"> MONTO_EMI_1 NUMBER(20,2) </footer>
												<footer class="blockquote-footer"> MONTO_TRANS_ADQ_1 NUMBER(10)  </footer>
												<footer class="blockquote-footer"> MONTO_ADQ_1 NUMBER(20,2) </footer>
											</blockquote>
										</div>
									</div>
						</div>
					</sf:form>
				</c:if>
			</div>
		</div>
	</div>
</div>
<%@ include file="../../layout/footer.jsp"%>
