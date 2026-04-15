<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<sf:form
					action="${pageContext.request.contextPath}/home/facturasgeneral/consulta"
					method="POST" autocomplete="off">
					<div class="card-header">
						<span class="title" id="menu-toggle">Reservar y Cancelar,
							Folios de Facturas, Recibos y Notas de Crédito</span><span
							class="float-right text-secondary" id="btn-ocultar">Ocultar</span>
					</div>
					<div id="mainMenu" class="show card-body">
						<div class="collapse" id="general">
							<div class="row">
								<div class="col-sm-6 col-md-6 mt-2 mb-2">
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Tipo de
											documento</label>
										<div class="col-sm-8">
											<select class="form-control form-control-sm"
												name="id_documento">
												<option value="">Selecciona una opcion</option>
												<option value="NOT">Nota de Credito</option>
												<option value="SER">Factura</option>
												<option value="REC">Recibo</option>
											</select>
										</div>

									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Número de meses</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" id=""
												placeholder="">
										</div>
									</div>
								</div>
								<div class="col-sm-6 col-md-6 mt-2 mb-2">
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Serie</label>
										<div class="col-sm-8">
											<select class="form-control form-control-sm" name="id_moneda">
												<option value="">Selecciona una opcion</option>
												<option value="A">A</option>
												<option value="B">B</option>
												<option value="C">C</option>
												<option value="D">D</option>
												<option value="E">E</option>
												<option value="F">F</option>
												<option value="G">G</option>
												<option value="H">H</option>
												<option value="I">I</option>
												<option value="J">J</option>
												<option value="K">K</option>
												<option value="L">L</option>
												<option value="M">M</option>
												<option value="N">N</option>
												<option value="O">O</option>
												<option value="P">P</option>
												<option value="Q">Q</option>
												<option value="R">R</option>
												<option value="S">S</option>
												<option value="T">T</option>
												<option value="U">U</option>
												<option value="V">V</option>
												<option value="W">W</option>
												<option value="X">X</option>
												<option value="Y">Y</option>
												<option value="Z">Z</option>
												<option value="AA">AA</option>
											</select>
										</div>
									</div>
									<input type="hidden" id="path"
										value="${pageContext.request.contextPath}" />
								</div>

							</div>
							<div class="form-group row">
								<div class="form-group col-md-4 d-flex flex-row-reverse">
									<button type="submit"
										class="btn btn-secondary text-white btn-sm float-right  mt-auto  ">Consultar</button>
								</div>
								<div class="form-group col-md-4 d-flex flex-row-reverse">
									<button type="submit"
										class="btn btn-secondary text-white btn-sm float-right  mt-auto  ">Actualizar</button>
								</div>
							</div>
							<div class="row bg-secondary pb-2">
								<div class="col-md-12 mt-2 mb-3">
									<span class="title">Reservar Folios</span>
								</div>
								<div class="col-sm-6 col-md-6">
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Tipo de
											documento</label>
										<div class="col-sm-8">
											<select class="form-control form-control-sm" name="">
												<option value="">Selecciona una opcion</option>
												<option value="NOT">Nota de Credito</option>
												<option value="SER">Factura</option>
												<option value="REC">Recibo</option>
											</select>
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Numero
											Aprobación</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" id=""
												placeholder="">
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Inicio Folio</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" id=""
												placeholder="">
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Fecha de
											Reservacion</label>
										<div class="col-sm-8">
											<input type="date" class="form-control form-control-sm"
												id="inputEmail4" name="fecha_inicial"
												value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>">
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Número de
											Folios</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" id=""
												placeholder="">
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Comentarios</label>
										<div class="col-sm-8">
											<textarea rows="4" cols="50"></textarea>
										</div>
									</div>


								</div>
								<div class="col-sm-6 col-md-6">
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Serie</label>
										<div class="col-sm-8">
											<select class="form-control form-control-sm" name="id_moneda">
												<option value="">Selecciona una opcion</option>
												<option value="A">A</option>
												<option value="B">B</option>
												<option value="C">C</option>
												<option value="D">D</option>
												<option value="E">E</option>
												<option value="F">F</option>
												<option value="G">G</option>
												<option value="H">H</option>
												<option value="I">I</option>
												<option value="J">J</option>
												<option value="K">K</option>
												<option value="L">L</option>
												<option value="M">M</option>
												<option value="N">N</option>
												<option value="O">O</option>
												<option value="P">P</option>
												<option value="Q">Q</option>
												<option value="R">R</option>
												<option value="S">S</option>
												<option value="T">T</option>
												<option value="U">U</option>
												<option value="V">V</option>
												<option value="W">W</option>
												<option value="X">X</option>
												<option value="Y">Y</option>
												<option value="Z">Z</option>
												<option value="AA">AA</option>
											</select>
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Año aprobación</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" id=""
												placeholder="">
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Fin de Folio</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" id=""
												placeholder="">
										</div>
									</div>

								</div>
							</div>
							<div class="form-group row">
								<div class="form-group col-sm-4 d-flex flex-row-reverse">
									<button type="submit"
										class="btn btn-secondary text-white btn-sm float-right  mt-auto  ">Eliminar
										Stock</button>
								</div>
								<div class="form-group col-sm-4 d-flex flex-row-reverse">
									<button type="submit"
										class="btn btn-secondary text-white btn-sm float-right  mt-auto  ">Agregar
										Stock</button>
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
							</thead>
							<tbody>
								<c:forEach items="${consulta}" var="consulta">
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</c:if>
		</div>
	</div>
</div>
<%@ include file="../layout/footer.jsp"%>