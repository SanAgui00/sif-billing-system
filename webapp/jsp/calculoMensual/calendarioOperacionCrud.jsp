<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<c:if test="${event=='edit'}">
		<div class="row">
			<div class="col-sm-12">
				<div class="card mt-1">
					<div class="card-header">
						<a class="float-right text-secondary"
							href="<c:url value='/home/cobranza/calendario'/>" role="button">Regresar</a>
						<span class="title" id="menu-toggle">Detalle de Calendario
							de Operación</span> <span class="float-right text-secondary pr-3"
							id="btn-ocultar">Ocultar</span>
					</div>
					<c:if test="${not empty consulta}">
						<c:forEach items="${consulta}" var="consulta">
							<div id="mainMenu" class="collapse show card-body pb-0">
								<div class="row">
									<div class="col-sm-6 col-md-6 mt-2">
										<div class="form-group row">
											<label class="col-sm-4 col-form-label">Nombre </label>
											<div class="col-sm-8">
												<input class="form-control form-control-sm" id=""
													type="text" value="${consulta.nombre}" disabled>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-6 col-form-label">Fecha Inicio </label>
											<div class="col-sm-6">
												<input type="date" class="form-control form-control-sm"
													id=""
													value="<fmt:formatDate value="${consulta.fecha_inicio}" pattern="yyyy-MM-dd"/>">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-6 col-form-label">Fecha para
												Ejecución del Cierre del Periodo </label>
											<div class="col-sm-6">
												<input type="date" class="form-control form-control-sm"
													id=""
													value="<fmt:formatDate value="${consulta.fecha_cierre}" pattern="yyyy-MM-dd"/>">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-6 col-form-label">Fecha Creación
											</label>
											<div class="col-sm-6">
												<input type="date" class="form-control form-control-sm"
													id=""
													value="<fmt:formatDate value="${consulta.fecha_cre}" pattern="yyyy-MM-dd"/>"
													disabled>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-6 col-form-label">Fecha
												Modificación </label>
											<div class="col-sm-6">
												<input type="date" class="form-control form-control-sm"
													id=""
													value="<fmt:formatDate value="${consulta.fecha_mod}" pattern="yyyy-MM-dd"/>"
													disabled>
											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-6 mt-2">
										<div class="form-group row">
											<label class="col-sm-6 col-form-label">Autor</label>
											<div class="col-sm-6">
												<input class="form-control form-control-sm" id=""
													type="text" value="${consulta.usuario}" disabled>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-6 col-form-label">Fecha Fin </label>
											<div class="col-sm-6">
												<input type="date" class="form-control form-control-sm"
													id=""
													value="<fmt:formatDate value="${consulta.fecha_fin}" pattern="yyyy-MM-dd"/>">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-6 col-form-label">Estatus</label>
											<div class="col-sm-6">
												<input class="form-control form-control-sm" id=""
													type="text" value="${consulta.estatus}" disabled>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-6 col-form-label">Comentarios</label>
											<div class="col-sm-6">
												<textarea class="form-control" id="" rows="2">${consulta.comentarios}</textarea>
											</div>
										</div>
										<sf:form
											action="${pageContext.request.contextPath}/home/cobranza/calendario/Save"
											method="POST" commandName="" autocomplete="off">
											<div class="form-group row">
												<div class="col-md-12 mt-1">
													<input name="event" id="event" value="update" type="hidden">
													<input name="bandera" id="bandera" value="" type="hidden">
													<input type="hidden" id="sendTable" name="listUpdate"
														class="sendTable" /> <input type="hidden" id="id_periodo"
														name="id_periodo" class="id_periodo"
														value="${consulta.id_periodos}" />
													<button type="submit" class="d-none btn-hide">Lanzar</button>
													<button type="button"
														class="btnCalendario btn btn-secondary text-white btn-sm float-right mb-1 mt-auto btnAppendConceptos">Guardar</button>
												</div>
											</div>
										</sf:form>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:if>
				</div>
			</div>
			<div class="col-sm-12">
				<c:if test="${not empty consultaDia}">
					<div class="card mt-2">
						<div class="table-responsive">
							<table
								class="table table-scroll table-bordered table-hover tableGet">
								<thead>
									<tr>
										<th>Fecha Referencia</th>
										<th>Fecha Cobranza</th>
										<th>Fecha Cobro</th>
										<th>Fecha Envío LIBRA</th>
										<th>Fecha Envío SAC</th>
										<th>Fecha Registro GL</th>
										<th>Fecha Contingencia</th>
										<th>Marcar</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${consultaDia}" var="consulta">
										<tr class="${consulta.b_dia_habil=='0' ? 'bg-warning' : ''}">
											<td><input type="text"
												class="form-control form-control-sm table-form getColumn"
												name=""
												value="<fmt:formatDate value="${consulta.fecha_referencia}" pattern="dd/MM/yy EEEE"/>"
												disabled /></td>
											<td><input type="text"
												class="form-control form-control-sm table-form getColumn"
												name=""
												value="<fmt:formatDate value="${consulta.fecha_calculo}" pattern="dd/MM/yy EEEE"/>" /></td>
											<td><input type="text"
												class="form-control form-control-sm table-form getColumn"
												name=""
												value="<fmt:formatDate value="${consulta.fecha_cobro}" pattern="dd/MM/yy EEEE"/>" /></td>
											<td><input type="text"
												class="form-control form-control-sm table-form getColumn"
												name=""
												value="<fmt:formatDate value="${consulta.fecha_cobro_libra}" pattern="dd/MM/yy EEEE"/>" /></td>
											<td><input type="text"
												class="form-control form-control-sm table-form getColumn"
												name=""
												value="<fmt:formatDate value="${consulta.fecha_cobro_sac}" pattern="dd/MM/yy EEEE"/>" /></td>
											<td><input type="text"
												class="form-control form-control-sm table-form getColumn"
												name=""
												value="<fmt:formatDate value="${consulta.fecha_registro_gl}" pattern="dd/MM/yy EEEE"/>" /></td>
											<td><input type="text"
												class="form-control form-control-sm table-form getColumn"
												name=""
												value="<fmt:formatDate value="${consulta.fecha_contingencia}" pattern="dd/MM/yy EEEE"/>" /></td>
											<td><div class="form-check">
													<input class="formCalendario form-check-input position-static"
														type="checkbox"
														${consulta.b_dia_habil=='0' ? 'checked="checked"' : ''}
														value="${consulta.id_periodos}">
												</div></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</c:if>
			</div>
		</div>
	</c:if>
	<c:if test="${event=='new'}">
		<div class="row">
			<div class="col-sm-12">
				<div class="card mt-1">
					<div class="card-header">
						<a class="float-right text-secondary"
							href="<c:url value='/home/cobranza/calendario'/>" role="button">Regresar</a>
						<span class="title" id="menu-toggle">Nuevo Calendario de
							Operación</span> <span class="float-right text-secondary pr-3"
							id="btn-ocultar">Ocultar</span>
					</div>
					<sf:form
						action="${pageContext.request.contextPath}/home/cobranza/calendario/Crud"
						method="POST" commandName="" autocomplete="off">
						<input type="hidden" id="event" name="event" value="new">
						<input type="hidden" id="secondaryEvent" name="secondaryEvent"
							value="secondaryEvent">
						<div id="mainMenu" class="collapse show card-body pb-0">
							<div class="row">
								<div class="col-sm-6 col-md-6 mt-2">
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Nombre </label>
										<div class="col-sm-8">
											<input class="form-control form-control-sm" type="text"
												name="nombre" id="nombre"
												value="${nombre ne 'null' ? nombre :''}" required>
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-6 col-form-label">Fecha Inicio </label>
										<div class="col-sm-6">
											<c:if test="${fechaInicio eq 'null'}">
												<input type="date" class="form-control form-control-sm"
													id="fechaInicio" name="fechaInicio"
													value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>"
													required>
											</c:if>
											<c:if test="${fechaInicio ne 'null'}">
												<fmt:parseDate value="${fechaInicio}" pattern="yyyy-MM-dd"
													var="fechaInicial" />
												<input type="date" class="form-control form-control-sm"
													id="fechaInicio" name="fechaInicio"
													value="<fmt:formatDate value="${fechaInicial}" pattern="yyyy-MM-dd"/>"
													required>
											</c:if>
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-6 col-form-label">Fecha para
											Ejecución del Cierre del Periodo </label>
										<div class="col-sm-6">
											<c:if test="${fechaCierre eq 'null'}">
												<input type="date" class="form-control form-control-sm"
													id="fechaCierre" name="fechaCierre"
													value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>"
													required>
											</c:if>
											<c:if test="${fechaCierre ne 'null'}">
												<fmt:parseDate value="${fechaCierre}" pattern="yyyy-MM-dd"
													var="fechaDeCierre" />
												<input type="date" class="form-control form-control-sm"
													id="fechaCierre" name="fechaCierre"
													value="<fmt:formatDate value="${fechaDeCierre}" pattern="yyyy-MM-dd"/>"
													required>
											</c:if>
										</div>
									</div>
								</div>
								<div class="col-sm-6 col-md-6 mt-2">
									<div class="form-group row">
										<label class="col-sm-6 col-form-label">Fecha Fin </label>
										<div class="col-sm-6">
											<c:if test="${fechaFin eq 'null'}">
												<input type="date" class="form-control form-control-sm"
													id="fechaFin" name="fechaFin"
													value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>"
													required>
											</c:if>
											<c:if test="${fechaFin ne 'null'}">
												<fmt:parseDate value="${fechaFin}" pattern="yyyy-MM-dd"
													var="fechaDeFin" />
												<input type="date" class="form-control form-control-sm"
													id="fechaFin" name="fechaFin"
													value="<fmt:formatDate value="${fechaDeFin}" pattern="yyyy-MM-dd"/>"
													required>
											</c:if>
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-6 col-form-label">Comentarios</label>
										<div class="col-sm-6">
											<textarea class="form-control" rows="2" name="comentarios"
												id="comentarios">${comentarios ne 'null' ? comentarios :''}</textarea>
										</div>
									</div>
									<div class="form-group row">
										<div class="col-md-12 mt-1">
											<button type="submit"
												class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto">Generar
												Calendario</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</sf:form>
				</div>
			</div>
			<div class="col-sm-12">
				<c:if test="${not empty autoTable}">
					<div class="card mt-2">
						<div class="table-responsive">
							<table
								class="table table-scroll table-bordered table-hover tableGet">
								<thead>
									<tr>
										<th>Fecha Referencia</th>
										<th>Fecha Cobranza</th>
										<th>Fecha Cobro</th>
										<th>Fecha Envío LIBRA</th>
										<th>Fecha Envío SAC</th>
										<th>Fecha Registro GL</th>
										<th>Fecha Contingencia</th>
										<th>Marcar</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${autoTable}" var="autoTable"
										varStatus="count">
										<tr value="${listaDia[count.index]}"
											class="${listaDia[count.index]=='Saturday' or listaDia[count.index]=='Sunday' ? 'bg-warning' : ''}">
											<td><input type="text"
												class="form-control form-control-sm table-form getColumn"
												name=""
												value="<fmt:formatDate value="${autoTable}" pattern="dd/MM/yy EEEE"/>"
												disabled /></td>
											<td><input type="text"
												class="form-control form-control-sm table-form getColumn"
												name=""
												value="<fmt:formatDate value="${autoTableDos[count.index]}" pattern="dd/MM/yy EEEE"/>" /></td>
											<td><input type="text"
												class="form-control form-control-sm table-form getColumn"
												name=""
												value="<fmt:formatDate value="${autoTableTres[count.index]}" pattern="dd/MM/yy EEEE"/>" /></td>
											<td><input type="text"
												class="form-control form-control-sm table-form getColumn"
												name=""
												value="<fmt:formatDate value="${autoTableDos[count.index]}" pattern="dd/MM/yy EEEE"/>" /></td>
											<td><input type="text"
												class="form-control form-control-sm table-form getColumn"
												name=""
												value="<fmt:formatDate value="${autoTableTres[count.index]}" pattern="dd/MM/yy EEEE"/>" /></td>
											<td><input type="text"
												class="form-control form-control-sm table-form getColumn"
												name=""
												value="<fmt:formatDate value="${autoTableCuatro[count.index]}" pattern="dd/MM/yy EEEE"/>" /></td>
											<td><input type="text"
												class="form-control form-control-sm table-form getColumn"
												name=""
												value="<fmt:formatDate value="${autoTableCinco[count.index]}" pattern="dd/MM/yy EEEE"/>" /></td>
											<td><div class="form-check">
													<input class="formCalendario form-check-input position-static"
														type="checkbox"
														${listaDia[count.index]=='Saturday' or listaDia[count.index]=='Sunday' ? 'checked="checked"' : ''}>
												</div></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<sf:form
								action="${pageContext.request.contextPath}/home/cobranza/calendario/Save"
								method="POST" commandName="" autocomplete="off">
								<div class="col-md-12 mt-1">
									<input name="bandera" id="bandera" value="" type="hidden">
									<input name="event" id="event" value="insert" type="hidden">
									<input name="nombre" id="getnombre" class="globalGet"
										type="hidden"> <input name="fechaInicio"
										id="getfechaInicio" class="globalGet" type="hidden"> <input
										name="fechaFin" id="getfechaFin" class="globalGet"
										type="hidden"> <input name="fechaCierre"
										id="getfechaCierre" class="globalGet" type="hidden"> <input
										name="comentarios" id="getcomentarios" class="globalGet"
										type="hidden"> <input id="sendTable" name="listUpdate"
										class="sendTable" type="hidden">
									<button type="submit" class="d-none btn-hide">Lanzar</button>
									<button type="button"
										class="btnCalendario btn btn-secondary text-white btn-sm float-right mb-1 mt-auto btnAppendConceptos">Guardar</button>
								</div>
							</sf:form>
						</div>
					</div>
				</c:if>
			</div>
		</div>
	</c:if>
	<c:if test="${event=='delete'}">
		<sf:form
			action="${pageContext.request.contextPath}/home/cobranza/calendario/Save"
			method="POST">
			<div class="row">
				<div class="col-sm-12">
					<div class="card mt-1">
						<c:forEach items="${consulta}" var="editar">
							<input name="evento" type="hidden" value="delete" />
							<input name="id_periodo" type="hidden"
								value="${editar.id_periodos}" />
							<input name="event" type="hidden" value="delete" />
							<div class="card-header">
								<span class="title" id="menu-toggle">Eliminar</span> <a
									class="float-right text-secondary"
									href="<c:url value='/home/cat/estructuraDatos'/>" role="button">Regresar</a>
							</div>
							<div id="mainMenu" class="collapse show card-body">
								<div class="row">
									<div class="col-sm-12 col-md-12  text-center">
										<h5 class="card-title">
											Está a punto de cerrar el periodo <span class="font-weight-bold">${editar.nombre}.</span>
											¿Desea continuar?
										</h5>
										<button type="submit"
											class="btn btn-secondary text-white btn-sm">Eliminar</button>
										<a class="btn btn-secondary text-white btn-sm"
											href="<c:url value='/home/cobranza/calendario/'/>"
											role="button">Regresar</a>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</sf:form>
	</c:if>
</div>
<script type="text/javascript"
	src="<c:url value='/js/appCobros/calculoMensual.js'/>" defer="defer">
</script>
<%@ include file="../layout/footer.jsp"%>