/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 16/06/2018 #
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.prosa.sif.operation.ProcesoGeneral;
import com.prosa.sif.service.ListaGeneralService;
import com.prosa.sif.service.ParametrizarService;

@Controller
public class ParametrizarController {
	@Autowired
	private ListaGeneralService listaGeneralService;
	@Autowired
	private ParametrizarService parametrizarService;
	@Autowired
	private ProcesoGeneral procesoGeneral;
	
	private static String contr = "controller";  
	private static String count = "count"; 
	private static String consulta = "consulta";
	private static String even = "event";
	private static String param = "param";

	@RequestMapping("/home/param/carga")
	public String showCargaDatos(Model model, HttpServletRequest request,
			@RequestParam(value = "id_reglas_carga", defaultValue = "0") Integer id_reglas_carga,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaFuentes(model, request);
		parametrizarService.queryReglaCarga(count, model, request, id_reglas_carga, fromRow);
		parametrizarService.queryReglaCarga(consulta, model, request, id_reglas_carga, fromRow);
		return "parametrizacion/cargaDatos";
	}

	@RequestMapping(value = "/home/param/carga/consulta", method = RequestMethod.POST)
	public String consultaCargaDatos(Model model, HttpServletRequest request,
			@RequestParam(value = "id_reglas_carga", defaultValue = "0") Integer id_reglas_carga,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaFuentes(model, request);
		parametrizarService.queryReglaCarga(count, model, request, id_reglas_carga, fromRow);
		parametrizarService.queryReglaCarga(consulta, model, request, id_reglas_carga, fromRow);
		return "parametrizacion/cargaDatos";
	}

	@RequestMapping(value = "/home/param/carga/crud", method = RequestMethod.POST)
	public String crudCargaDatos(Model model, HttpServletRequest request,
			@RequestParam(value = "event", defaultValue = "none") String event,
			@RequestParam(value = "id_reglas_carga", defaultValue = "0") Integer id_reglas_carga,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaFuentes(model, request);
		parametrizarService.queryReglaCarga(param, model, request, id_reglas_carga, fromRow);
		model.addAttribute(even, event);
		return "parametrizacion/cargaDatosCrud";
	}

	@RequestMapping(value = "/home/param/carga/crud", method = RequestMethod.GET)
	public String crudCargaDatosGet(Model model, HttpServletRequest request,
			@RequestParam(value = "event", defaultValue = "none") String event,
			@RequestParam(value = "id_reglas_carga", defaultValue = "0") Integer id_reglas_carga,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaFuentes(model, request);
		parametrizarService.queryReglaCarga(param, model, request, id_reglas_carga, fromRow);
		model.addAttribute(even, event);
		return "parametrizacion/cargaDatosCrud";
	}

	@RequestMapping(value = "/home/param/carga/test", method = RequestMethod.POST)
	public String testCargaDatos(Model model, HttpServletRequest request,
			@RequestParam(value = "event", defaultValue = "") String event,
			@RequestParam(value = "sentencia", defaultValue = "") String sentencia,
			@RequestParam(value = "idRegla", defaultValue = "") Integer idRegla,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow) {
		
		procesoGeneral.loggerUsr(contr, request);
		parametrizarService.queryTest(model,sentencia);
		model.addAttribute("prueba", sentencia);
		model.addAttribute("idRegla", idRegla);
		model.addAttribute(even, event);
		return "parametrizacion/cargaDatosTest";
	}

	@RequestMapping(value = "/home/param/carga/save", method = RequestMethod.POST)
	public String saveCargaDatos(Model model,
			@RequestParam(value = "id_reglas_carga", defaultValue = "0") Integer id_reglas_carga,
			@RequestParam(value = "id_fuente", defaultValue = "0") Integer id_fuente,
			@RequestParam(value = "tabla_temporal", defaultValue = "null") String tabla_temporal,
			@RequestParam(value = "fecha_mod", defaultValue = "null") String fecha_mod,
			@RequestParam(value = "usuario", defaultValue = "null") String usuario,
			@RequestParam(value = "estatus", defaultValue = "null") String estatus,
			@RequestParam(value = "comentarios", defaultValue = "null") String comentarios,
			@RequestParam(value = "sentencia", defaultValue = "null") String sentencia,
			@RequestParam(value = "fecha_creacion", defaultValue = "null") String fecha_creacion,
			@RequestParam(value = "fecha_mod_old", defaultValue = "null") String fecha_mod_old,
			@RequestParam(value = "evento", defaultValue = "null") String evento, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		parametrizarService.crudCargaDato(model, request, evento, id_reglas_carga, id_fuente, tabla_temporal, fecha_mod,
				usuario, estatus, comentarios, sentencia, fecha_creacion, fecha_mod_old);
		return "redirect:/home/param/carga";
	}

	@RequestMapping("/home/param/conversion")
	public String showConversionServicios(Model model, HttpServletRequest request,
			@RequestParam(value = "fuente", defaultValue = "0") Integer fuente,
			@RequestParam(value = "estatus", defaultValue = "empty") String estatus,
			@RequestParam(value = "regla_conv_id", defaultValue = "0") Integer regla_conv_id) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaFuentes(model, request);
		parametrizarService.queryReglaConversion(count, model, request, regla_conv_id, fuente, estatus);
		parametrizarService.queryReglaConversion(consulta, model, request, regla_conv_id, fuente, estatus);
		return "parametrizacion/conversionServicios";
	}

	@RequestMapping("/home/param/conversion/crud")
	public String crudConversionServicios(Model model, HttpServletRequest request,
			@RequestParam(value = "event", defaultValue = "none") String event,
			@RequestParam(value = "fuente", defaultValue = "0") Integer fuente,
			@RequestParam(value = "servicio_id", defaultValue = "0") Integer servicio_id,
			@RequestParam(value = "regla_conv_id", defaultValue = "0") Integer regla_conv_id,
			@RequestParam(value = "estatus", defaultValue = "empty") String estatus) {
		procesoGeneral.loggerUsr(contr, request);
		switch (event) {
		case "edit":
			listaGeneralService.listaServicios(model, request);
			listaGeneralService.listaFuentes(model, request);
			listaGeneralService.reglasConversion(model, request, servicio_id);
			parametrizarService.queryReglaConversion(param, model, request, regla_conv_id, fuente, estatus);
			model.addAttribute(even, "edit");
			break;
		case "delete":
			parametrizarService.queryReglaConversion(param, model, request, regla_conv_id, fuente, estatus);
			model.addAttribute(even, "delete");
			break;
		case "new":
			listaGeneralService.listaServicios(model, request);
			listaGeneralService.listaFuentes(model, request);
			model.addAttribute(even, "new");
			break;
		default:
			break;
		}
		return "parametrizacion/conversionServiciosCrud";
	}
	
	@RequestMapping(value = "/home/param/conversion/test", method = RequestMethod.POST)
	public String testConversionServicios(Model model, HttpServletRequest request,
			@RequestParam(value = "event", defaultValue = "") String event,
			@RequestParam(value = "sentencia", defaultValue = "") String sentencia,
			@RequestParam(value = "idRegla", defaultValue = "") Integer idRegla,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow) {
		
		procesoGeneral.loggerUsr(contr, request);
		parametrizarService.queryTest(model,sentencia);
		model.addAttribute("prueba", sentencia);
		model.addAttribute("idRegla", idRegla);
		model.addAttribute(even, event);
		return "parametrizacion/conversionServiciosTest";
	}

	@RequestMapping("/home/param/conversion/save")
	public String saveConversionDatos(Model model,
			@RequestParam(value = "regla_conv_id", defaultValue = "0") Integer regla_conv_id,
			@RequestParam(value = "id_fuente", defaultValue = "0") Integer id_fuente,
			@RequestParam(value = "id_servicio", defaultValue = "0") Integer id_servicio,
			@RequestParam(value = "fecha_mod", defaultValue = "null") String fecha_mod,
			@RequestParam(value = "usuario", defaultValue = "null") String usuario,
			@RequestParam(value = "estatus", defaultValue = "null") String estatus,
			@RequestParam(value = "comentarios", defaultValue = "null") String comentarios,
			@RequestParam(value = "sentencia", defaultValue = "null") String sentencia,
			@RequestParam(value = "evento", defaultValue = "null") String evento, HttpServletRequest request) {

		procesoGeneral.loggerUsr(contr, request);
		parametrizarService.crudConversionDato(model, request, regla_conv_id, id_fuente, id_servicio, fecha_mod,
				usuario, estatus, comentarios, sentencia, evento);

		return "redirect:/home/param/conversion";
	}

	@RequestMapping("/home/contingencia")
	public String showContingencia(Model model, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaFuentes(model, request);
		return "parametrizacion/contingencia";
	}

	@RequestMapping(value = "/home/contingencia/consulta", method = RequestMethod.POST)
	public String consultaContingencia(Model model, HttpServletRequest request,
			@RequestParam(value = "id_fuente", defaultValue = "0") Integer id_fuente,
			@RequestParam(value = "fecha_datos", defaultValue = "empty") String fecha_datos,
			@RequestParam(value = "fecha_datos_final", defaultValue = "empty") String fecha_datos_final) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaFuentes(model, request);
		parametrizarService.queryContingencia(param, model, request, id_fuente, fecha_datos, fecha_datos_final);
		return "parametrizacion/contingencia";
	}

	@RequestMapping(value = "/home/contingencia/ajustar", method = RequestMethod.POST)
	public String procesosContingencia(Model model, HttpServletRequest request,
			@RequestParam(value = "id_fuente", defaultValue = "0") Integer id_fuente,
			@RequestParam(value = "fecha_datos", defaultValue = "empty") String fecha_datos,
			@RequestParam(value = "fecha_datos_final", defaultValue = "empty") String fecha_datos_final,
			@RequestParam(value = "event", defaultValue = "null") String event) {
		procesoGeneral.loggerUsr(contr, request);
		parametrizarService.crudContingencia(event, model, request, id_fuente, fecha_datos, fecha_datos_final);
		return "redirect:/home/Contingencia";
	}
}
