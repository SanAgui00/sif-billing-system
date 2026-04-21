/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 03/07/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/
package com.prosa.sif.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.prosa.sif.operation.ProcesoGeneral;
import com.prosa.sif.service.FacturaService;
import com.prosa.sif.service.ListaGeneralService;

@Controller
public class FacturaController {
	@Autowired
	private ListaGeneralService listaGeneralService;
	@Autowired
	private FacturaService facturaService;
	@Autowired
	private ProcesoGeneral procesoGeneral;
	
	private static String contr = "controller";

	@RequestMapping("/home/factura/generar")
	public String vistaGenerarFactura(Model model, SessionStatus sessionStatus, HttpServletRequest request,
			@RequestParam(value = "fecha_final", defaultValue = "2018-01-01") String fecha_final) {
		procesoGeneral.loggerUsr(contr, request);
//		listas
		listaGeneralService.listaProceso(model, request);
		listaGeneralService.listaNegocios(model, request);
		listaGeneralService.listaClientes(model, request);
		listaGeneralService.listaMonedas(model, request);
		listaGeneralService.listaPeriodos(model, request);
		facturaService.queryFacturas(model, request, fecha_final);
		return "facturas/generarFactura";
	}

	@RequestMapping("/home/factura/solicitar")
	public String viewSolicitarFactura(Model model, SessionStatus sessionStatus, HttpServletRequest request,
			@RequestParam(value = "fecha_final", defaultValue = "2018-01-01") String fecha_final) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaNegocios(model, request);
		listaGeneralService.listaClientes(model, request);
		listaGeneralService.listaCentroCostos(model, request);
		listaGeneralService.listaMonedas(model, request);
		listaGeneralService.listaTipoPago(model, request);
		facturaService.queryFacturas(model, request, fecha_final);
		return "facturas/solicitarFactura";
	}

	@RequestMapping("/home/factura/automatizacion")
	public String viewAutomatizarFactura(Model model, SessionStatus sessionStatus, HttpServletRequest request,
			@RequestParam(value = "fecha_final", defaultValue = "2018-01-01") String fecha_final) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaNegocios(model, request);
		listaGeneralService.listaClientes(model, request);
		facturaService.queryFacturas(model, request, fecha_final);
		return "facturas/automatizarFactura";
	}

	@RequestMapping("/home/factura/solicitar/odt")
	public String viewSolicitarODT(Model model, SessionStatus sessionStatus, HttpServletRequest request,
			@RequestParam(value = "fecha_final", defaultValue = "2018-01-01") String fecha_final) {
		procesoGeneral.loggerUsr(contr, request);
		facturaService.queryFacturas(model, request, fecha_final);
		return "facturas/solicitarODT";
	}

	@RequestMapping("/home/factura/automatizacion/odt")
	public String viewAutomatizarODT(Model model, SessionStatus sessionStatus, HttpServletRequest request,
			@RequestParam(value = "fecha_final", defaultValue = "2018-01-01") String fecha_final) {
		procesoGeneral.loggerUsr(contr, request);
		facturaService.queryFacturas(model, request, fecha_final);
		return "facturas/automatizarODT";
	}

	@RequestMapping("/home/facturasgeneral/consulta")
	public String consultaGeneral(Model model, SessionStatus sessionStatus, HttpServletRequest request,
			@RequestParam(value = "fecha_final", defaultValue = "2018-01-01") String fecha_final) {

		procesoGeneral.loggerUsr(contr, request);
		facturaService.queryFacturas(model, request, fecha_final);
		return "facturas/automatizarODT";
	}

	@RequestMapping("/home/factura/solicitar/nota")
	public String viewSolicitarNota(Model model, SessionStatus sessionStatus, HttpServletRequest request,
			@RequestParam(value = "fecha_final", defaultValue = "2018-01-01") String fecha_final) {
		procesoGeneral.loggerUsr(contr, request);
		facturaService.queryFacturas(model, request, fecha_final);
		return "facturas/solicitarNota";
	}

	@RequestMapping("/home/factura/mantener")
	public String viewMantenerDocumentos(Model model, SessionStatus sessionStatus, HttpServletRequest request,
			@RequestParam(value = "fecha_final", defaultValue = "2018-01-01") String fecha_final) {
		procesoGeneral.loggerUsr(contr, request);
		facturaService.queryFacturas(model, request, fecha_final);
		return "facturas/mantenerDocumento";
	}

	@RequestMapping("/home/factura/reservar")
	public String viewReservarCancelarFolios(Model model, SessionStatus sessionStatus, HttpServletRequest request,
			@RequestParam(value = "fecha_final", defaultValue = "2018-01-01") String fecha_final) {
		procesoGeneral.loggerUsr(contr, request);
		facturaService.queryFacturas(model, request, fecha_final);
		return "facturas/folio";
	}

	@RequestMapping("/home/factura/stock")
	public String viewStockFolios(Model model, SessionStatus sessionStatus, HttpServletRequest request,
			@RequestParam(value = "fecha_final", defaultValue = "2018-01-01") String fecha_final) {
		procesoGeneral.loggerUsr(contr, request);
		facturaService.queryFacturas(model, request, fecha_final);
		return "facturas/stockFolio";
	}

}