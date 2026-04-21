<%@ include file="../../layout/header.jsp"%>
<%@ include file="../../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
	<div class="row">
		<div class="col-sm-12">
			<div class="card mt-1">
				<div class="card-header">
					<span class="title" id="menu-toggle">Catalogo Usuarios por
						Cliente</span>
					<ul class="nav d-inline-block">
						<li class="nav-item d-inline-block"><a
							class="nav-link text-secondary p-0 mr-3 ml-3  tab-link active"
							id="tab-1" data-toggle="tab" href="#tab1" role="tab"
							aria-controls="tab1" aria-selected="true">Mostrar Usuarios</a></li>
						<li class="nav-item d-inline-block"><a
							class="nav-link text-secondary p-0 mr-3 tab-link" id="tab-2"
							data-toggle="tab" href="#tab2" role="tab" aria-controls="tab2"
							aria-selected="true">Mostrar Clientes</a></li>
					</ul>
					<span class="float-right text-secondary" id="btn-ocultar">Ocultar</span>
				</div>
				<div class="tab-content" id="mainMenu">
					<div class="tab-pane show active" id="tab1" role="tabpanel"
						aria-labelledby="tab-1">
						<%-- MENU1 --%>
						<%-- MENU1 --%>
						<div class="card-body pb-0">
							<div class="row">
								<div class="col-sm-5 col-md-5">
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Usuario</label>
										<div class="col-sm-8">
											<select class="form-control form-control-sm" name="" id="">
												<option value="">Selecciona una opcion</option>
											</select>
										</div>
									</div>
								</div>
								<div class="col-sm-7 col-md-7">
									<button type="submit"
										class="btn bg-danger text-white btn-sm float-right mb-1 mt-auto ">Consultar</button>
								</div>
							</div>
						</div>
						<%-- MENU1 --%>
						<%-- MENU1 --%>
					</div>
					<div class="tab-pane" id="tab2" role="tabpanel"
						aria-labelledby="tab-2">
						<%-- MENU2 --%>
						<%-- MENU2 --%>
						<div class="card-body pb-0">
							<div class="row">
								<div class="col-sm-5 col-md-5">
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Buscar Cliente</label>
										<div class="col-sm-8">
											<input type="text" class="form-control form-control-sm" id=""
												name="">
										</div>
									</div>
								</div>
								<div class="col-sm-5 col-md-5">
									<div class="form-group row">
										<label class="col-sm-4 col-form-label">Seleccionar
											Cliente</label>
										<div class="col-sm-8">
											<select class="form-control form-control-sm" name="" id="">
												<option value="">Selecciona una opcion</option>
											</select>
										</div>
									</div>
								</div>
								<div class="col-sm-2 col-md-2">
									<button type="submit"
										class="btn bg-danger text-white btn-sm float-right mb-1 mt-auto ">Consultar</button>
								</div>
							</div>
						</div>
						<%-- MENU2 --%>
						<%-- MENU2 --%>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="../../layout/footer.jsp"%>