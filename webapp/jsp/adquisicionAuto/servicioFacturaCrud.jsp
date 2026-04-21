<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<input name="evento" type="hidden" value="update" />
				<div class="card-header">
					<span class="title" id="menu-toggle">Visualizar y consulta Servicios a Facturar</span> <a class="float-right text-secondary" href="<c:url value='/home/adq/auto/servicio'/>" role="button">Regresar</a> <span class="float-right text-secondary pr-3" id="btn-ocultar">Ocultar</span>
				</div>
				<div id="mainMenu" class="collapse show card-body pb-0">
					<div class="row">
						<div class="col-sm-6 col-md-6 mt-2">
							<div class="form-group row">
								<label class="col-sm-4 col-form-label">Servicio </label>
								<div class="col-sm-8">
									<input class="form-control form-control-sm" id="" type="text">
								</div>
							</div>
							<div class="form-group row">
								<label class="col-sm-4 col-form-label">Fecha Inicio </label>
								<div class="col-sm-8">
									<input type="date" class="form-control form-control-sm" id="">
								</div>
							</div>
						</div>
						<div class="col-sm-6 col-md-6 mt-2">
							<div class="form-group row">
								<label class="col-sm-4 col-form-label">Descripción</label>
								<div class="col-sm-8">
									<input class="form-control form-control-sm" id="" type="text">
								</div>
							</div>
							<div class="form-group row">
								<label class="col-sm-4 col-form-label">Estatus </label>
								<div class="col-sm-8">
									<input type="date" class="form-control form-control-sm" id="">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-sm-12">
			<c:if test="${not empty consulta}">
				<div class="card mt-2">
					<div class="table-responsive">
						<table class="table table-scroll table-striped table-bordered table-hover tableGet">
							<thead>
								<tr>
									<th>Clave</th>
									<th>Concepto</th>
									<th>Fecha de Datos</th>
									<th>Total Transacciones Emisor</th>
									<th>Total Importe Emisor</th>
									<th>Total Transacciones Adquirente</th>
									<th>Total Importe Adquirente</th>
									<th>Moneda</th>
									<th>Estatus</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${consulta}" var="consulta">
									<tr>
										<input type="hidden" class="form-control form-control-sm table-form getColumn" value="${consulta.id_cliente}" />
										<td><input type="text" class="form-control form-control-sm table-form " value="${consulta.clave_cliente}" /></td>
										<td><input type="text" class="form-control form-control-sm table-form getColumn" value="${consulta.descripcion}" /></td>
										<td><input type="text" class="form-control form-control-sm table-form getColumn" value="<fmt:formatDate value="${consulta.fecha_datos}" pattern="dd-MM-yyyy" />" /></td>
										<td><input type="text" class="form-control form-control-sm table-form getColumn" value="${consulta.total_trans_emisor}" /></td>
										<td><input type="text" class="form-control form-control-sm table-form getColumn" value="${consulta.total_importe_emisor}" /></td>
										<td><input type="text" class="form-control form-control-sm table-form getColumn" value="${consulta.total_trans_adq}" /></td>
										<td><input type="text" class="form-control form-control-sm table-form getColumn" value="${consulta.total_importe_adq}" /></td>
										<td><input type="text" class="form-control form-control-sm table-form getColumn" value="${consulta.estatus}" /></td>
										<td><input type="text" class="form-control form-control-sm table-form getColumn" value="${consulta.estatus}" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<sf:form action="${pageContext.request.contextPath}/home/adq/auto/servicio/save" method="POST" autocomplete="off">
					<div class="form-group row">
						<div class="col-md-12 mt-1">
							<input name="event" id="event" value="updateList" type="hidden"> <input type="hidden" id="sendTable" name="listUpdate" class="sendTable" /> <input type="hidden" id="id_servicio" name="id_servicio" class="id_servicio" value="${idServicio}" />
							<button type="submit" class="d-none btn-hide">Lanzar</button>
							<button type="button" class="btn btn-secondary text-white btn-sm float-right mb-1 mt-auto btnAppendServicios">Guardar</button>
						</div>
					</div>
				</sf:form>
			</c:if>
		</div>
	</div>
</div>
<%@ include file="../layout/footer.jsp"%>