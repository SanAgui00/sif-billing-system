/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 07/08/2018 #
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

import com.prosa.sif.operation.ProcesoGeneral;
import com.prosa.sif.service.GrupoService;
import com.prosa.sif.service.ListaGeneralService;

/**
 * 
 * @author Loredo
 *
 */
@Controller
public class GrupoController {
	@Autowired
	private ListaGeneralService listaGeneralService;
	@Autowired
	private GrupoService grupoService;
	@Autowired
	private ProcesoGeneral procesoGeneral;
	
	private static String asignar = "asignar";
	private static String consulta = "consulta";
	private static String contr = "controller";
	private static String count = "count";
	private static String even = "event";
	private static String  idgrupo= "idGrupo";

	/**
	 * 
	 * @param model
	 * @param request
	 * @param idGrupo
	 * @param fromRow
	 * @return
	 */
	@RequestMapping("/home/cat/grupo/concepto")
	public String mostrarConceptoServicio(Model model, HttpServletRequest request,
			@RequestParam(value = "idGrupo", defaultValue = "") Integer idGrupo,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaGrupoConceptoServ(model, request);
		grupoService.queryConceptoServicio(count, idGrupo, model, request, fromRow);
		grupoService.queryConceptoServicio(consulta, idGrupo, model, request, fromRow);
		model.addAttribute(idgrupo, idGrupo);
		return "catalogo/grupo/conceptoServicio";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @param idGrupo
	 * @param fromRow
	 * @param event
	 * @return
	 */
	@RequestMapping("/home/cat/grupo/concepto/crud")
	public String crudConceptoServicio(Model model, HttpServletRequest request,
			@RequestParam(value = "idGrupo", defaultValue = "") Integer idGrupo,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "event", defaultValue = "") String event) {
		
		procesoGeneral.loggerUsr(contr, request);
		grupoService.queryConceptoServicio(consulta, idGrupo, model, request, fromRow);
		grupoService.queryConceptoServicio(asignar, idGrupo, model, request, fromRow);
		model.addAttribute(even, event);
		return "catalogo/grupo/conceptoServicioCrud";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @param idGrupo
	 * @param clave
	 * @param descripcion
	 * @param comentarios
	 * @param event
	 * @return
	 */
	@RequestMapping("/home/cat/grupo/concepto/save")
	public String saveConceptoServicio(Model model, HttpServletRequest request,
			@RequestParam(value = "idGrupo", defaultValue = "") Integer idGrupo,
			@RequestParam(value = "clave", defaultValue = "") String clave,
			@RequestParam(value = "descripcion", defaultValue = "") String descripcion,
			@RequestParam(value = "comentarios", defaultValue = "") String comentarios,
			@RequestParam(value = "listaServiciosExluidos", defaultValue = "") String listaServiciosExluidos,
			@RequestParam(value = "listaServiciosIncluidos", defaultValue = "") String listaServiciosIncluidos,
			@RequestParam(value = "event", defaultValue = "") String event) {
		procesoGeneral.loggerUsr(contr, request);
		grupoService.crudConceptoServicio(event, idGrupo, clave, descripcion, comentarios, model, request,
				listaServiciosExluidos, listaServiciosIncluidos);
		model.addAttribute(even, event);
		return "redirect:/home/cat/grupo/concepto/";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @param idGrupo
	 * @param fromRow
	 * @return
	 */
	@RequestMapping("/home/cat/grupo/volumenServicio")
	public String mostrarVolumenServicio(Model model, HttpServletRequest request,
			@RequestParam(value = "idGrupo", defaultValue = "") Integer idGrupo,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaGrupoVolumen(model, request);
		grupoService.queryVolumenServicio(count, idGrupo, model, request, fromRow);
		grupoService.queryVolumenServicio(consulta, idGrupo, model, request, fromRow);
		model.addAttribute(idgrupo, idGrupo);
		return "catalogo/grupo/volumenServicio";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @param idGrupo
	 * @param fromRow
	 * @param event
	 * @return
	 */
	@RequestMapping("/home/cat/grupo/volumenServicio/crud")
	public String crudVolumenServicio(Model model, HttpServletRequest request,
			@RequestParam(value = "idGrupo", defaultValue = "") Integer idGrupo,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "event", defaultValue = "") String event) {
		procesoGeneral.loggerUsr(contr, request);
		grupoService.queryVolumenServicio(consulta, idGrupo, model, request, fromRow);
		grupoService.queryVolumenServicio(asignar, idGrupo, model, request, fromRow);
		model.addAttribute(even, event);
		return "catalogo/grupo/volumenServicioCrud";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @param idGrupo
	 * @param clave
	 * @param descripcion
	 * @param comentarios
	 * @param event
	 * @return
	 */
	@RequestMapping("/home/cat/grupo/volumenServicio/save")
	public String saveVolumenServicio(Model model, HttpServletRequest request,
			@RequestParam(value = "idGrupo", defaultValue = "") Integer idGrupo,
			@RequestParam(value = "clave", defaultValue = "") String clave,
			@RequestParam(value = "descripcion", defaultValue = "") String descripcion,
			@RequestParam(value = "comentarios", defaultValue = "") String comentarios,
			@RequestParam(value = "listaServiciosExluidos", defaultValue = "") String listaServiciosExluidos,
			@RequestParam(value = "listaServiciosIncluidos", defaultValue = "") String listaServiciosIncluidos,
			@RequestParam(value = "event", defaultValue = "") String event) {
		procesoGeneral.loggerUsr(contr, request);
		grupoService.crudVolumenServicio(event, idGrupo, clave, descripcion, comentarios, model, request,
				listaServiciosExluidos, listaServiciosIncluidos);
		model.addAttribute(even, event);
		return "redirect:/home/cat/grupo/volumenServicio/";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @param idGrupo
	 * @param fromRow
	 * @return
	 */
	@RequestMapping("/home/cat/grupo/volumenCliente")
	public String mostrarVolumenCliente(Model model, HttpServletRequest request,
			@RequestParam(value = "idGrupo", defaultValue = "") Integer idGrupo,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaGrupoCliente(model, request);
		grupoService.queryVolumenCliente(count, idGrupo, model, request, fromRow);
		grupoService.queryVolumenCliente(consulta, idGrupo, model, request, fromRow);
		model.addAttribute(idgrupo, idGrupo);
		return "catalogo/grupo/volumenCliente";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @param idGrupo
	 * @param fromRow
	 * @param event
	 * @return
	 */
	@RequestMapping("/home/cat/grupo/volumenCliente/crud")
	public String crudVolumenCliente(Model model, HttpServletRequest request,
			@RequestParam(value = "idGrupo", defaultValue = "") Integer idGrupo,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "event", defaultValue = "") String event) {
		procesoGeneral.loggerUsr(contr, request);
		grupoService.queryVolumenCliente(consulta, idGrupo, model, request, fromRow);
		grupoService.queryVolumenCliente(asignar, idGrupo, model, request, fromRow);
		model.addAttribute(even, event);
		return "catalogo/grupo/volumenClienteCrud";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @param idGrupo
	 * @param clave
	 * @param descripcion
	 * @param comentarios
	 * @param event
	 * @return
	 */
	@RequestMapping("/home/cat/grupo/volumenCliente/save")
	public String saveVolumenCliente(Model model, HttpServletRequest request,
			@RequestParam(value = "idGrupo", defaultValue = "") Integer idGrupo,
			@RequestParam(value = "clave", defaultValue = "") String clave,
			@RequestParam(value = "descripcion", defaultValue = "") String descripcion,
			@RequestParam(value = "comentarios", defaultValue = "") String comentarios,
			@RequestParam(value = "listaServiciosExluidos", defaultValue = "") String listaServiciosExluidos,
			@RequestParam(value = "listaServiciosIncluidos", defaultValue = "") String listaServiciosIncluidos,
			@RequestParam(value = "event", defaultValue = "") String event) {
		procesoGeneral.loggerUsr(contr, request);
		grupoService.crudVolumenCliente(event, idGrupo, clave, descripcion, comentarios, model, request,
				listaServiciosExluidos, listaServiciosIncluidos);
		model.addAttribute(even, event);
		return "redirect:/home/cat/grupo/volumenCliente/";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @param idGrupo
	 * @param fromRow
	 * @return
	 */
	@RequestMapping("/home/cat/grupo/listaCliente")
	public String mostrarListaCliente(Model model, HttpServletRequest request,
			@RequestParam(value = "idGrupo", defaultValue = "") Integer idGrupo,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaGruposCliente(model, request);
		grupoService.queryListaCliente(count, idGrupo, model, request, fromRow);
		grupoService.queryListaCliente(consulta, idGrupo, model, request, fromRow);
		model.addAttribute(idgrupo, idGrupo);
		return "catalogo/grupo/listaCliente";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @param idGrupo
	 * @param fromRow
	 * @param event
	 * @return
	 */
	@RequestMapping("/home/cat/grupo/listaCliente/crud")
	public String crudListaCliente(Model model, HttpServletRequest request,
			@RequestParam(value = "idGrupo", defaultValue = "") Integer idGrupo,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "event", defaultValue = "") String event) {
		procesoGeneral.loggerUsr(contr, request);
		grupoService.queryListaCliente(consulta, idGrupo, model, request, fromRow);
		grupoService.queryListaCliente(asignar, idGrupo, model, request, fromRow);
		model.addAttribute(even, event);
		return "catalogo/grupo/listaClienteCrud";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @param idGrupo
	 * @param clave
	 * @param descripcion
	 * @param comentarios
	 * @param event
	 * @return
	 */
	@RequestMapping("/home/cat/grupo/listaCliente/save")
	public String saveListaCliente(Model model, HttpServletRequest request,
			@RequestParam(value = "idGrupo", defaultValue = "") Integer idGrupo,
			@RequestParam(value = "clave", defaultValue = "") String clave,
			@RequestParam(value = "descripcion", defaultValue = "") String descripcion,
			@RequestParam(value = "comentarios", defaultValue = "") String comentarios,
			@RequestParam(value = "listaServiciosExluidos", defaultValue = "") String listaServiciosExluidos,
			@RequestParam(value = "listaServiciosIncluidos", defaultValue = "") String listaServiciosIncluidos,
			@RequestParam(value = "listaBeneficiarios", defaultValue = "") String listaBeneficiarios,
			@RequestParam(value = "listaDistribucion", defaultValue = "") String listaDistribucion,
			@RequestParam(value = "esquema", defaultValue = "") String esquema,
			@RequestParam(value = "event", defaultValue = "") String event) {
		procesoGeneral.loggerUsr(contr, request);
		grupoService.crudListaCliente(event, idGrupo, clave, descripcion, comentarios, model, request, esquema,
				listaServiciosExluidos, listaServiciosIncluidos,listaBeneficiarios,listaDistribucion);
		model.addAttribute(even, event);
		return "redirect:/home/cat/grupo/listaCliente/";
	}

}
