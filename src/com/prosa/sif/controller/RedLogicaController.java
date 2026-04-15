/**
################################################################################
# Autor               : Garnica                                                #
# Compania            : Código Geek                                            #
# Proyecto/Procliente : Red Logica Controller                Fecha: 08/03/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/
package com.prosa.sif.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.prosa.sif.operation.ProcesoGeneral;
import com.prosa.sif.pojo.TablaRedLogica;
import com.prosa.sif.service.ApoyoService;
import com.prosa.sif.service.ListaGeneralService;
import com.prosa.sif.service.RedLogicaService;
/**
 * 
 * @author David Garnica Garcia
 *
 */
@Controller
public class RedLogicaController {
	@Autowired
	private RedLogicaService redLogicaService;
	@Autowired
	private ListaGeneralService listaGeneralService;
	@Autowired
	private ApoyoService apoyoService;
	@Autowired
	private ProcesoGeneral procesoGeneral;
	
	private static String consulta = "consulta";
	private static String contr = "controller";
	private static String count = "count";
	private static String empty = "empty";
	private static String asignacionRedes = "catalogo/redesLogicas/asignacionRedes";
	private static String catRedesLogicas = "catalogo/redesLogicas/catRedesLogicas";

	@RequestMapping("/home/cat/redes/")
	public String viewRedes(Model model, SessionStatus sessionStatus, HttpServletRequest request,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "clave", defaultValue = "empty") String clave,
			@RequestParam(value = "estatus", defaultValue = "empty") String estatus) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaRedesLogicas(model, request);
		redLogicaService.queryRedLogica(count, model, request, fromRow, clave, estatus);
		redLogicaService.queryRedLogica(consulta, model, request, fromRow, clave, estatus);
		return catRedesLogicas;
	}

	@RequestMapping(value = "/home/cat/redes/consulta", method = RequestMethod.POST)
	public String showRedes(Model model, SessionStatus sessionStatus,
			@RequestParam(value = "clave", defaultValue = "empty") String clave,
			@RequestParam(value = "estatus", defaultValue = "empty") String estatus, HttpServletRequest request,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaRedesLogicas(model, request);
		redLogicaService.queryRedLogica(count, model, request, fromRow, clave, estatus);
		redLogicaService.queryRedLogica(consulta, model, request, fromRow, clave, estatus);
		return catRedesLogicas;
	}

	@RequestMapping(value = "/home/cat/redes/crud", method = RequestMethod.POST)
	public String operationRedes(Model model, SessionStatus sessionStatus,
			@RequestParam(value = "clave", defaultValue = "0") String clave,
			@RequestParam(value = "event", defaultValue = "none") String event, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		redLogicaService.queryFindRedLogica(model, clave);
		model.addAttribute("event", event);
		sessionStatus.setComplete();
		return "catalogo/redesLogicas/catRedesLogicasCrud";
	}

	@RequestMapping(value = "/home/cat/redes/save", method = RequestMethod.POST)
	public String saveNegocio(Model model, @ModelAttribute("insert") TablaRedLogica insert, SessionStatus sessionStatus,
			@RequestParam(value = "fecha_crea", defaultValue = "null") String fecha_crea,
			@RequestParam(value = "descripcion", defaultValue = "null") String descripcion,
			@RequestParam(value = "usuario", defaultValue = "null") String usuario,
			@RequestParam(value = "estatus", defaultValue = "null") String estatus,
			@RequestParam(value = "clave", defaultValue = "null") String clave,
			@RequestParam(value = "evento", defaultValue = "null") String evento
			,@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow, HttpServletRequest request) {

		procesoGeneral.loggerUsr(contr, request);
		redLogicaService.saveOrUpdateRedesLogicas(request, evento, insert, fecha_crea,descripcion, usuario, estatus, clave);
		listaGeneralService.listaRedesLogicas(model, request);
		redLogicaService.queryRedLogica(count, model, request, fromRow, empty, empty);
		redLogicaService.queryRedLogica(consulta, model, request, fromRow, empty, empty);
		return catRedesLogicas;
	}

	// ASIGNACION
	@RequestMapping("/home/cat/redes/asignacion")
	public String viewAsignacion(Model model, SessionStatus sessionStatus,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "page", defaultValue = "0") Integer page, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaRedesLogicas(model, request);
		apoyoService.queryFuente(consulta, model, request, 15, fromRow);
		redLogicaService.listaServicio(model,15,"ACT");
		return asignacionRedes;
	}
	
	@RequestMapping("/home/cat/redes/asignacion/consulta")
	public String AsignacionConsulta(Model model, SessionStatus sessionStatus,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "clave", defaultValue = "empty") String clave,HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		model.addAttribute("clave", clave);
		apoyoService.queryFuente(consulta, model, request, 15, fromRow);
		redLogicaService.queryRedLogicaService(count, model, request, fromRow, clave);
		redLogicaService.queryRedLogicaService(consulta, model, request, fromRow, clave);
		listaGeneralService.listaRedesLogicas(model, request);
		redLogicaService.listaServicio(model,15,"ACT");
		return asignacionRedes;
	}
	
	
	@RequestMapping("/home/cat/redes/asignacion/confirmar")
	public String AsignacionConfirmar(Model model, SessionStatus sessionStatus,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "checkval", defaultValue = "empty") String values,HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaRedesLogicas(model, request);
		apoyoService.queryFuente(consulta, model, request, 15, fromRow);
		redLogicaService.listaServicio(model,15,"ACT");
		redLogicaService.ConfirmarService(model,request,fromRow,values);
		return asignacionRedes;
	}
	@RequestMapping("/home/cat/redes/asignacion/agregarservicio")
	public String AsignacionAgregar(Model model, SessionStatus sessionStatus,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "id_servicio", defaultValue = "empty") String id_servicio,HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		redLogicaService.Agregarservicio(model ,request,id_servicio);
		listaGeneralService.listaRedesLogicas(model, request);
		apoyoService.queryFuente(consulta, model, request, 15, fromRow);
		redLogicaService.listaServicio(model,15,"ACT");
		return "redirect:/home/cat/redes/asignacion";
	}

}
