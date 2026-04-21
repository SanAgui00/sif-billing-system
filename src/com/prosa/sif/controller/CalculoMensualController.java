/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 12/06/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.prosa.sif.operation.ProcesoGeneral;
import com.prosa.sif.pojo.TBL_SIF_REBATE;
import com.prosa.sif.service.CalculoMensualService;
import com.prosa.sif.service.FacturaService;
import com.prosa.sif.service.ListaGeneralService;

@Controller
public class CalculoMensualController {
	@Autowired
	private ListaGeneralService listaGeneralService;
	@Autowired
	private CalculoMensualService calculoMensualService;
	@Autowired
	private ProcesoGeneral procesoGeneral;
	@Autowired
	private FacturaService facturaService;
	
	private static String contr = "controller";  
	private static String count = "count"; 
	private static String consulta = "consulta";
	private static String calAjuste = "calculoMensual/calcularAjuste";
	private static String idPeriodo = "id_periodo";

	@RequestMapping("/home/cobranza/ajuste")
	public String showCalcularAjuste(Model model, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaPeriodos(model, request);
		return calAjuste;
	}

	@RequestMapping(value = "/home/cobranza/ajuste/consulta", method = RequestMethod.POST)
	public String consultaCalcularAjuste(Model model,
			@RequestParam(value = "id_periodo", defaultValue = "0") Integer id_periodo,
			@RequestParam(value = "ajustePorProceso", defaultValue = "0") Integer ajustePorProceso,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaPeriodos(model, request);
		calculoMensualService.queryCalcularAjuste(count, model, request, id_periodo, ajustePorProceso, fromRow);
		calculoMensualService.queryCalcularAjuste(consulta, model, request, id_periodo, ajustePorProceso, fromRow);
		model.addAttribute(idPeriodo, id_periodo);
		model.addAttribute("ajustePorProceso", ajustePorProceso);

		return calAjuste;
	}

	@RequestMapping(value = "/home/cobranza/ajuste/save", method = RequestMethod.POST)
	public String procesoCalcularAjuste(Model model, HttpServletRequest request,
			@RequestParam(value = "id_periodo", defaultValue = "") Integer id_periodo,
			@RequestParam(value = "ajustePorProceso", defaultValue = "") Integer ajustePorProceso,
			@RequestParam(value = "lista1", defaultValue = "") String lista1,
			@RequestParam(value = "operacion", defaultValue = "") String operacion,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaPeriodos(model, request);
		calculoMensualService.crudCalcularAjuste(model, request, id_periodo, ajustePorProceso, lista1, operacion);
		calculoMensualService.queryCalcularAjuste(count, model, request, id_periodo, ajustePorProceso, fromRow);
		calculoMensualService.queryCalcularAjuste(consulta, model, request, id_periodo, ajustePorProceso, fromRow);
		model.addAttribute(idPeriodo, id_periodo);
		model.addAttribute("ajustePorProceso", ajustePorProceso);
		return calAjuste;
	}

	@RequestMapping("/home/cobranza/rebate")
	public String showCalcularRebate(Model model, HttpServletRequest request,
			@RequestParam(name = "fecha_final", defaultValue = "2018-01-01") String fecha_final) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaPeriodos(model, request);
		listaGeneralService.listaMonedas(model, request);
		facturaService.queryFacturas(model, request, fecha_final);
		return "calculoMensual/calcularRebate";
	}

	@RequestMapping("/home/calculomensual/rebate/consulta")
	public String consultaCalcularRebate(Model model, @RequestParam("id_periodo") Integer id_periodo,
			@RequestParam("id_moneda") Integer id_moneda,
			@RequestParam(name = "fecha_inicio", defaultValue = "") String fecha_inicio,
			@RequestParam(name = "fecha_final", defaultValue = "") String fecha_final, HttpServletRequest request) {

		procesoGeneral.loggerUsr(contr, request);

		model.addAttribute("fecha_inicio", fecha_inicio);
		model.addAttribute("fecha_final", fecha_final);
		model.addAttribute(idPeriodo, id_periodo);
		model.addAttribute("id_moneda", id_moneda);
		List<TBL_SIF_REBATE> rebate = calculoMensualService.findAllRebate(id_periodo, id_moneda);
		model.addAttribute("rebate", rebate);
		int tamaño = rebate.size();
		model.addAttribute("bandera", tamaño);
		listaGeneralService.listaPeriodos(model, request);
		listaGeneralService.listaMonedas(model, request);
		return "calculoMensual/calcularRebate";
	}

	@RequestMapping("/home/cobranza/calendario")
	public String mostrarCalendarioOperacional(Model model, HttpServletRequest request,
			@RequestParam(value = "periodo", defaultValue = "null") String periodo,
			@RequestParam(value = "fecha", defaultValue = "null") String fecha,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow) {

		procesoGeneral.loggerUsr(contr, request);
		calculoMensualService.queryPeriodo(count, periodo, fecha, model, fromRow);
		calculoMensualService.queryPeriodo(consulta, periodo, fecha, model, fromRow);

		return "calculoMensual/calendarioOperacion";
	}

	@RequestMapping("/home/cobranza/calendario/Crud")
	public String crudCalendarioOperacional(Model model, HttpServletRequest request,
			@RequestParam(value = "id_periodo", defaultValue = "0") Integer id_periodo,
			@RequestParam(value = "event", defaultValue = "null") String event,
			@RequestParam(value = "secondaryEvent", defaultValue = "null") String secondaryEvent,
			@RequestParam(value = "nombre", defaultValue = "null") String nombre,
			@RequestParam(value = "fechaInicio", defaultValue = "null") String fechaInicio,
			@RequestParam(value = "fechaFin", defaultValue = "null") String fechaFin,
			@RequestParam(value = "comentarios", defaultValue = "null") String comentarios,
			@RequestParam(value = "fechaCierre", defaultValue = "null") String fechaCierre,
			@RequestParam(value = "inicio", defaultValue = "1") Integer inicio,
			@RequestParam(value = "fin", defaultValue = "0") Integer fin) {
		procesoGeneral.loggerUsr(contr, request);
		model.addAttribute("nombre", nombre);
		model.addAttribute("fechaInicio", fechaInicio);
		model.addAttribute("fechaFin", fechaFin);
		model.addAttribute("fechaCierre", fechaCierre);
		model.addAttribute("comentarios", comentarios);
		calculoMensualService.queryDiaPeriodo("dia", id_periodo, model, event);
		calculoMensualService.queryDiaPeriodo("param", id_periodo, model, event);
		calculoMensualService.listaDiaPeriodo(request, event, nombre, fechaInicio, fechaFin, fechaCierre, model, inicio, fin,
				secondaryEvent);
		calculoMensualService.listaDiaPeriodo(request, event, nombre, fechaInicio, fechaFin, fechaCierre, model, 2, 1,
				secondaryEvent);
		return "calculoMensual/calendarioOperacionCrud";
	}

	@RequestMapping("/home/cobranza/calendario/Save")
	public String operacionCalendarioOperacional(Model model, HttpServletRequest request,
			@RequestParam(value = "id_periodo", defaultValue = "0") Integer id_periodo,
			@RequestParam(value = "listUpdate", defaultValue = "null") String listUpdate,
			@RequestParam(value = "event", defaultValue = "null") String event,
			@RequestParam(value = "nombre", defaultValue = "null") String nombre,
			@RequestParam(value = "fechaInicio", defaultValue = "null") String fechaInicio,
			@RequestParam(value = "fechaFin", defaultValue = "null") String fechaFin,
			@RequestParam(value = "bandera", defaultValue = "null") String bandera,
			@RequestParam(value = "comentarios", defaultValue = "null") String comentarios,
			@RequestParam(value = "fechaCierre", defaultValue = "null") String fechaCierre) {
		procesoGeneral.loggerUsr(contr, request);
		calculoMensualService.crudDiaPeriodo(request, id_periodo, listUpdate, model, event, nombre, fechaInicio, fechaFin,
				fechaCierre, comentarios,bandera);
		return "redirect:/home/cobranza/calendario";
	}

}
