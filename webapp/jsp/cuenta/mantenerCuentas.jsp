<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<sf:form
					action="${pageContext.request.contextPath}/home/cuentas/mantener/consulta"
					method="POST" commandName="" autocomplete="off">
					<div class="card-header">
						<span class="title" id="menu-toggle">Mantener Cuentas por
							Cobrar</span> <span class="float-right text-secondary" id="btn-ocultar">Ocultar</span>
					</div>
					<div id="mainMenu" class="collapse show card-body">
						<input type="hidden" id="path"
							value="${pageContext.request.contextPath}" />
						<div class="form-row mt-2">
							<%-- inputs --%>
							<div class="col-md-4">
								<label>Cliente</label>
								<div class="input-group">
									<div class="input-group-prepend">
										<input type="text" id="list_Clientes_report"
											class="form-control form-control-sm ajax-form"
											${clave_cliente.equals("null") ? 'placeholder="Clave | Nombre corto"' : ''}
											value="${!clave_cliente.equals('null') ? clave_cliente : ''}"
											placeholder="Clave | Nombre corto" name="list_Clientes_report" />	
									</div>
									
									<select class="custom-select form-control-sm"
											id="list_Clientes_report_r" name="id_cliente">
											<c:if
												test="${not empty idCliente && not empty clave_cliente && not empty nombre_corto}">
												<option
													value="${idCliente}&&${clave_cliente}&&${nombre_corto}">
													<c:out value="${clave_cliente}-${nombre_corto}"></c:out></option>
											</c:if>
										</select>
									
								</div>
							</div>
							<div class="form-group col-md-2">
								<label>Moneda:</label> <select
									class="form-control form-control-sm" name="id_moneda">
									<option value="0">Selecciona la moneda</option>
									<c:forEach items="${listaMonedas}" var="lista">
										<option value="<c:out value=" ${lista.id_moneda}"> </c:out>"
										${ lista.id_moneda==id_moneda ? 'selected="selected"' : ''}>
											<c:out value="${lista.nombre_moneda}"></c:out>
										</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group col-md-2">
								<label for="inputPassword4">Fecha inicial</label> 
									<c:if test="${fecha_inicial eq 'null'}">
									<input type="date" class="form-control form-control-sm"
										id="fecha_inicial" name="fecha_inicial"
										value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>"
										required>
								</c:if>
								<c:if test="${fecha_inicial ne 'null'}">
									<fmt:parseDate value="${fecha_inicial}" pattern="yyyy-MM-dd"
										var="fechaInicial" />
									<input type="date" class="form-control form-control-sm"
										id="fecha_inicial" name="fecha_inicial"
										value="<fmt:formatDate value="${fechaInicial}" pattern="yyyy-MM-dd"/>"
										required>
								</c:if>
									
							</div>
							<div class="form-group col-md-2">
								<label for="inputPassword4">Fecha final</label>
									<c:if test="${fecha_final eq 'null'}">
									<input type="date" class="form-control form-control-sm"
										id="fecha_final" name="fecha_final"
										value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>"
										required>
								</c:if>
								<c:if test="${fecha_final ne 'null'}">
									<fmt:parseDate value="${fecha_final}" pattern="yyyy-MM-dd"
										var="fechaFinal" />
									<input type="date" class="form-control form-control-sm"
										id="fecha_final" name="fecha_final"
										value="<fmt:formatDate value="${fechaFinal}" pattern="yyyy-MM-dd"/>"
										required>
								</c:if>
									
							</div>
							<div class="form-group col-md-2 d-flex flex-row-reverse">
								<button type="submit"
									class="btn btn-secondary text-white btn-sm float-right  mb-1 mt-auto">Consultar</button>
							</div>
						</div>
					</div>
				</sf:form>
			</div>
		</div>
		<div class="col-sm-12">
			<c:if test="${not empty consulta}">
				<div class="card mt-2">
					<div class="table-responsive">
						<table
							class="table table-scroll table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th scope="col">Importe</th>
									<th scope="col">IVA</th>
									<th scope="col">Total</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${consulta}" var="lista">
									<tr>
										<td><c:out value="${lista.TOTAL_IMPORTE_NETO}"></c:out></td>
										<td><c:out value="${lista.TOTAL_IMPORTE_IVA}"></c:out></td>
										<td><c:out value="${lista.TOTAL_IMPORTE_DOCUMENTO}"></c:out></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</c:if>
		</div>
		<c:if test="${not empty count}">
			<div class="col-sm-12 col-md-12 col-lg-12">
				<div class="alert alert-warning alert-dismissible fade show mt-2"
					role="alert">
					<strong><c:out value="${count}"></c:out></strong>
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</div>
		</c:if>
	</div>
</div>
<%@ include file="../layout/footer.jsp"%>