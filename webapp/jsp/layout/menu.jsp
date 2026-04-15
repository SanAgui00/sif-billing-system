<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav
	class="col-md-2 d-none d-md-block bg-white sidebar h-100 p-0 position-fixed">
	<div class="sidebar-sticky">
		<ul class="nav flex-column">
			<li class="nav-item mx-auto d-block"><a class="nav-link"
				href="<c:url value='/'/>"> <img
					src="<c:url value='/imagenes/logo.svg'/>" class="img-fluid"
					alt="Prosa">
			</a></li>
			<li class="divider not">Menú</li>
			<sec:authorize access="hasAnyRole('ROLE_ADMINISTRADOR')">
				<div class="contenedor-menu">
					<div class="div-hover">
						<li class="dropdown-submenu action="${pageContext.request.contextPath}/home/"><span
							class="icon-list"></span><span> Adquisiciones automaticas</span>
							<ul class="dropdown-menu">
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/adq/auto/verificar'/>">Verificar
										adquisición</a></li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/adq/auto/bitacora'/>">Consultar
										bitácora</a></li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/adq/auto/servicio'/>">Servicios a
										facturar</a></li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/adq/auto/comparar'/>">Comparar
										adquisición</a></li>
							</ul></li>
					</div>
					<div class="div-hover">
						<li class="dropdown-submenu action="${pageContext.request.contextPath}/home/"><span
							class="icon-list"></span><span> Adquisiciones manuales</span>
							<ul class="dropdown-menu">
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/adq/man/nueva'/>">Nueva solicitud</a></li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/adq/man/historico'/>">Histórico
										de solicitudes</a></li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/adq/man/verificar'/>">Verificar
										solicitudes</a></li>
							</ul></li>
					</div>
					<div class="div-hover">
						<li class="dropdown-submenu action="${pageContext.request.contextPath}/home/"><span
							class="icon-list"></span><span> Cobranza diaria</span>
							<ul class="dropdown-menu">
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/cobranza/calcular'/>">Calcular
										cobranza</a></li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/cobranza/cifras'/>">Enviar cifras</a></li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/cobranza/cambio'/>">Tipos de
										cambio</a></li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/cobranza/bitacora'/>">Consultar
										bitácora</a></li>
							</ul></li>
					</div>

					<div class="div-hover">
						<li class="dropdown-submenu action="${pageContext.request.contextPath}/home/"><span
							class="icon-list"></span><span> Cobros</span>
							<ul class="dropdown-menu">
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/cobros/cifras'/>">Enviar cifras</a></li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/cobros/movimientos'/>">Movimientos
										financieros</a></li>
							</ul></li>
					</div>
					<div class="div-hover">
						<li class="dropdown-submenu action="${pageContext.request.contextPath}/home/"><span
							class="icon-list"></span><span> Registros contables</span>
							<ul class="dropdown-menu">
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/registro/mantener'/>">Mantener
										registros</a></li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/registro/asociar'/>">Asociar
										negocio/póliza</a></li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/registro/parametrizar'/>">Parametrización</a></li>
							</ul></li>
					</div>
					<div class="div-hover">
						<li class="dropdown-submenu action="${pageContext.request.contextPath}/home/"><span
							class="icon-list"></span><span> Calculo mensual</span>
							<ul class="dropdown-menu">
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/cobranza/ajuste'/>">Calcular
										ajuste</a></li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/cobranza/calendario'/>">Calendario
										de operaciones</a></li>
							</ul></li>
					</div>
					<div class="div-hover">
						<li class="dropdown-submenu action="${pageContext.request.contextPath}/home/"><span
							class="icon-list"></span><span> Facturas, recibos</span>
							<ul class="dropdown-menu list-menu-2">
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/factura/generar'/>">Generar
										facturas</a></li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/factura/solicitar'/>">Solicitar
										factura abierta</a></li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/factura/automatizacion'/>">Automatización
										de factura abierta</a></li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/factura/solicitar/odt'/>">Solicitud
										ODT</a></li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/factura/automatizacion/odt'/>">Automatización
										de ODT’s</a></li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/factura/solicitar/nota'/>">Solicitud
										nota de crédito</a></li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/factura/mantener'/>">Mantener
										documentos</a></li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/factura/reservar'/>">Reservar /
										cancelar folios</a></li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/factura/stock'/>">Stock de folios</a></li>
							</ul></li>
					</div>
					<div class="div-hover">
						<li class="dropdown-submenu action="${pageContext.request.contextPath}/home/"><span
							class="icon-list"></span><span> Impresiones</span>
							<ul class="dropdown-menu">
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/impresiones/etiquetas'/>">Estilos
										de cartas</a></li>
							</ul></li>
					</div>
					<div class="div-hover">
						<li class="dropdown-submenu action="${pageContext.request.contextPath}/home/"><span
							class="icon-list"></span><span> Catálogos</span>
							<ul class="dropdown-menu">
								<li class="dropdown-submenu"><span class="dropdown-item">Principales</span>
									<ul class="dropdown-menu">
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/principal/negocio'/>">Negocios</a></li>
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/principal/servicio'/>">Servicios</a></li>
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/principal/cliente'/>">Clientes</a></li>
									</ul></li>
								<li class="dropdown-submenu"><span class="dropdown-item">Precios</span>
									<ul class="dropdown-menu">
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/precio/servicio'/>">Lista
												de Servicios por Cliente</a></li>
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/precio/descuento'/>">Asignar
												Descuentos</a></li>
									</ul></li>
								<li class="dropdown-submenu"><span class="dropdown-item">Apoyo</span>
									<ul class="dropdown-menu list-menu">
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/apoyo/empresas'/>">Empresas</a></li>
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/apoyo/fuentes'/>">Fuentes</a></li>
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/apoyo/procesos'/>">Procesos</a></li>
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/apoyo/formasdepago'/>">Formas
												de pago</a></li>
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/apoyo/tiposdepago'/>">Tipos
												de pago</a></li>
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/apoyo/umedida'/>">UMedida
												factura</a></li>
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/apoyo/conceptos'/>">Conceptos
												factura</a></li>
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/apoyo/addendas'/>">Addendas
												CFD</a></li>
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/apoyo/moneda'/>">Moneda</a></li>
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/apoyo/perfiles'/>">Perfiles
												de usuario</a></li>
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/apoyo/usuario'/>">Usuario
												por Cliente</a></li>
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/apoyo/clientes'/>">Clientes
												en Servicios</a></li>
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/apoyo/funcionalidades'/>">Funcionalidades</a></li>
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/apoyo/parametros'/>">Parámetros</a></li>
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/apoyo/eventos'/>">Eventos
												por servicio</a></li>
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/apoyo/servicios'/>">Servicios
												particulares</a></li>
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/apoyo/categorias'/>">Categorias
												ingreso</a></li>
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/apoyo/banco'/>">Cuentas
												de Banco</a></li>
									</ul></li>
								<li class="dropdown-submenu"><span class="dropdown-item">Grupos</span>
									<ul class="dropdown-menu list-menu-2">
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/grupo/concepto'/>">Concepto
												Servicios</a></li>
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/grupo/volumenServicio'/>">Volumen
												Servicios</a></li>
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/grupo/volumenCliente'/>">Volumen
												Clientes</a></li>
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/grupo/listaCliente'/>">Lista
												de Clientes</a></li>
									</ul></li>
								<li class="dropdown-submenu"><span class="dropdown-item">Redes
										lógicas</span>
									<ul class="dropdown-menu">
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/redes/'/>">Catalogo de
												redes lógicas</a></li>
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/redes/asignacion'/>">Asignación
												de redes lógicas</a></li>
									</ul></li>
								<li class="dropdown-submenu"><span class="dropdown-item">SAT</span>
									<ul class="dropdown-menu list-menu">
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/sat/regimen'/>">Regimen
												fiscal</a></li>
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/sat/comprobantes'/>">Tipos
												de comprobante</a></li>
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/sat/cfdi'/>">Usos de CFDI</a></li>
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/sat/formaspago'/>">Formas
												de pago</a></li>
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/sat/metodopago'/>">Metodos
												de pago</a></li>
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/sat/relacion'/>">Tipos de
												relacion</a></li>
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/sat/servicio'/>">Claves de
												servicio</a></li>
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/sat/unidad'/>">Claves de
												unidad</a></li>
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/sat/impuesto'/>">Tipos de
												impuesto</a></li>
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/sat/factor'/>">Tipos de
												factor</a></li>
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='/home/cat/sat/tasascuota'/>">Tasas /
												cuotas</a></li>
										<li class="dropdown-submenu"><a class="dropdown-item"
											href="<c:url value='home/cat/sat/certificado'/>">Certificados</a></li>
									</ul></li>
							</ul></li>
					</div>
					<div class="div-hover">
						<li class="dropdown-submenu action="${pageContext.request.contextPath}/home/"><span
							class="icon-list"></span><span> Reportes</span>
							<ul class="dropdown-menu list-menu-2">
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/reportes/folios'/>">Consecutivo
										folios</a></li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/reportes/servicios'/>">Servicios
										/ Cliente</a></li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/reportes/soporte'/>">Soporte de
										servicios</a></li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/reportes/tesoreria'/>">Tesorería</a></li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/reportes/cobranza'/>">Cobranza
										diaria</a></li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/reportes/cuentas'/>">Cuentas
										Activas</a></li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/reportes/odt'/>">ODT's</a></li>
							</ul></li>
					</div>

					<div class="div-hover">
						<li class="dropdown-submenu action="${pageContext.request.contextPath}/home/"><span
							class="icon-list"></span><span> Cuentas por cobrar</span>
							<ul class="dropdown-menu">
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/cuentas/mantener'/>">Mantener
										cuentas</a></li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/cuentas/saldos'/>">Mantener
										saldos</a></li>
							</ul></li>
					</div>
					<div class="div-hover">
						<li class="dropdown-submenu action="${pageContext.request.contextPath}/home/"><span
							class="icon-list"></span><span> Estados de cuenta</span>
							<ul class="dropdown-menu">
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/estados/cuenta'/>">Estado de
										cuenta</a></li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/estados/cobranza'/>">Estado
										cobranza diaria</a></li>
							</ul></li>
					</div>




				</div>
			</sec:authorize>
			<sec:authorize
				access="hasAnyRole('ROLE_MOD_ADQ_ADMINISTRADOR','ROLE_ADMIN_MOD_ADQ')">
				<div class="contenedor-menu">
					<div class="div-hover">
						<li class="dropdown-submenu action="${pageContext.request.contextPath}/home/"><span
							class="icon-list"></span><span> Monitoreo</span>
							<ul class="dropdown-menu">
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/adq/auto/verificar'/>">Verificar
										adquisición</a></li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/adq/auto/bitacora'/>">Consultar
										bitácora</a></li>
							</ul></li>
					</div>
					<div class="div-hover">
						<li class="dropdown-submenu action="${pageContext.request.contextPath}/home/"><span
							class="icon-list"></span><span> Contingencia</span>
							<ul class="dropdown-menu">
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/contingencia'/>">Contingencias</a></li>
							</ul></li>
					</div>
					<div class="div-hover">
						<li class="dropdown-submenu action="${pageContext.request.contextPath}/home/"><span
							class="icon-list"></span><span> Catálogos</span>
							<ul class="dropdown-menu">
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/cat/estructuraDatos'/>">Estructura
										de Datos</a></li>
							</ul></li>
					</div>
					<div class="div-hover">
						<li class="dropdown-submenu action="${pageContext.request.contextPath}/home/"><span
							class="icon-list"></span><span> Parametrización</span>
							<ul class="dropdown-menu">
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/param/carga'/>">Carga de Datos</a></li>
								<li class="dropdown-submenu"><a class="dropdown-item"
									href="<c:url value='/home/param/conversion'/>">Conversión
										de Servicios</a></li>
							</ul></li>
					</div>
				</div>
			</sec:authorize>
			<li class="not">
				<form method="post"
					action="${pageContext.request.contextPath}/logout" id="form-logout">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<button type="submit"
						class="btn bg-danger text-white btn-sm rounded  btn-block">Cerrar
						sesión</button>
				</form>
			</li>
		</ul>
	</div>
</nav>