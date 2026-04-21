/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 14/05/2018 #
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
public class EstructuraController {
	@Autowired
	private ListaGeneralService listaGeneralService;
	@Autowired
	private ParametrizarService parametrizarService;
	@Autowired
	private ProcesoGeneral procesoGeneral;
	
	private static String contr = "controller";
	private static String even = "event";

	@RequestMapping("/home/cat/estructuraDatos")
	public String viewEstructuraDatos(Model model, HttpServletRequest request,
			@RequestParam(value = "id_fuente", defaultValue = "0") Integer id_fuente,
			@RequestParam(value = "estatus", defaultValue = "ACT") String estatus) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaFuentes(model, request);
		parametrizarService.queryEstructuraDato("lista", id_fuente, estatus, model, request);

		return "catalogo/estructura/estructuraDatos";
	}

	@RequestMapping(value = "/home/cat/estructuraDatos/consulta", method = RequestMethod.POST)
	public String consultaEstructuraDatos(Model model, HttpServletRequest request,
			@RequestParam(value = "id_fuente", defaultValue = "0") Integer id_fuente,
			@RequestParam(value = "estatus", defaultValue = "ACT") String estatus) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaFuentes(model, request);
		parametrizarService.queryEstructuraDato("param", id_fuente, estatus, model, request);

		return "catalogo/estructura/estructuraDatos";
	}

	@RequestMapping(value = "/home/cat/estructuraDatos/crud", method = RequestMethod.POST)
	public String crudEstructuraDatos(Model model, HttpServletRequest request,
			@RequestParam(value = "event", defaultValue = "none") String event,
			@RequestParam(value = "estatus", defaultValue = "ACT") String estatus,
			@RequestParam(value = "id_fuente", defaultValue = "0") Integer id_fuente,
			@RequestParam(value = "id_estructura", defaultValue = "0") Integer id_estructura) {
		procesoGeneral.loggerUsr(contr, request);
		switch (event) {
		case "edit":
			listaGeneralService.listaFuentes(model, request);
			parametrizarService.queryEstructuraDato("crud", id_estructura, estatus, model, request);
			model.addAttribute(even, "edit");
			break;
		case "delete":
			parametrizarService.queryEstructuraDato("crud", id_estructura, estatus, model, request);
			model.addAttribute(even, "delete");
			break;
		case "new":
			listaGeneralService.listaFuentes(model, request);
			model.addAttribute(even, "new");
			break;
		default:
			break;
		}
		return "catalogo/estructura/estructuraDatosCrud";
	}

	@RequestMapping(value = "/home/cat/estructuraDatos/save", method = RequestMethod.POST)
	public String operationEstructuraDatos(Model model, HttpServletRequest request,
			@RequestParam(value = "id_estructura", defaultValue = "0") Integer id_estructura,
			@RequestParam(value = "id_fuente", defaultValue = "0") Integer id_fuente,
			@RequestParam(value = "tabla_temporal", defaultValue = "null") String tabla_temporal,
			@RequestParam(value = "tabla_totales", defaultValue = "null") String tabla_totales,
			@RequestParam(value = "estatus", defaultValue = "ACT") String estatus,
			@RequestParam(value = "b_suspender_depuracion", defaultValue = "0") Integer b_suspender_depuracion,
			@RequestParam(value = "b_no_hay_carga", defaultValue = "0") Integer b_no_hay_carga,
			@RequestParam(value = "nombre_campo_cliente", defaultValue = "null") String nombre_campo_cliente,
			@RequestParam(value = "nombre_campo_cliente_adq", defaultValue = "null") String nombre_campo_cliente_adq,
			@RequestParam(value = "fecha_creacion", defaultValue = "null") String fecha_creacion,
			@RequestParam(value = "fecha_mod", defaultValue = "null") String fecha_mod,
			@RequestParam(value = "usuario", defaultValue = "null") String usuario,
			@RequestParam(value = "comentarios", defaultValue = "null") String comentarios,
			@RequestParam(value = "evento", defaultValue = "null") String evento) {

		procesoGeneral.loggerUsr(contr, request);
		parametrizarService.crudEstructuraDato(model, request, evento, id_estructura, id_fuente, tabla_temporal,
				tabla_totales, estatus, b_suspender_depuracion, b_no_hay_carga, nombre_campo_cliente,
				nombre_campo_cliente_adq, fecha_creacion, fecha_mod, usuario, comentarios);

		return "redirect:/home/cat/estructuraDatos";
	}
}
