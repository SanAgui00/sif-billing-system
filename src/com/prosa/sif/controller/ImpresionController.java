/**
################################################################################
# Autor               : David Garnica                                          #
# Compania            : Código Geek                                            #
# Proyecto/Procliente : Controller de Estado de Cuenta       Fecha: 02/08/2018 #
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
import com.prosa.sif.pojo.TablaEstiloCarta;
import com.prosa.sif.service.ImpresionService;

@Controller
public class ImpresionController {

	@Autowired
	private ImpresionService ImpresionService;
	@Autowired
	private ProcesoGeneral procesoGeneral;
	
	private static String contr = "controller";

	@RequestMapping("/home/impresiones/etiquetas")
	public String viewEtiquetas(Model consulta, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		List<TablaEstiloCarta> procesos = ImpresionService.findAll_TBL_SIF_ESTILO_CARTA();
		consulta.addAttribute("consulta", procesos);
		return "impresion/ImpresionesEtiquetas";
	}

	@RequestMapping(value = "/home/impresiones/crud", method = RequestMethod.POST)
	public String Crud(Model consulta, @RequestParam(value = "event", defaultValue = "none") String event,
			@RequestParam(value = "id", defaultValue = "0") int id, HttpServletRequest request) {

		procesoGeneral.loggerUsr(contr, request);
		List<TablaEstiloCarta> editar = ImpresionService.findById_TBL_SIF_CAT_ESTILOS_CARTA(id);
		switch (event) {
		case "edit":
			consulta.addAttribute("editar", editar);
			consulta.addAttribute("event", "edit");
			break;
		case "new":
			consulta.addAttribute("event", "new");
			break;
		default:
			break;
		}
		return "impresion/ImpresionesEtiquetasCrud";
	}

	@RequestMapping(value = "/home/impresiones/etiquetas/save", method = RequestMethod.POST)
	public String CrudAct(Model consulta, @RequestParam(value = "evento", defaultValue = "none") String event,
			@RequestParam(value = "id", defaultValue = "0") int id,
			@RequestParam(value = "estatus", defaultValue = "null") String status,
			@RequestParam(value = "cuenta_act", defaultValue = "null") String cuenta,
			@RequestParam(value = "clave", defaultValue = "null") String clave,
			@RequestParam(value = "descripcion", defaultValue = "null") String descripcion,
			@RequestParam(value = "autor", defaultValue = "null") String autor,
			@RequestParam(value = "cuenta", defaultValue = "null") String cuenta1, HttpServletRequest request) {

		procesoGeneral.loggerUsr(contr, request);
		ImpresionService.ActbyId_TBL_SIF_CAT_ESTILOS_CARTA(event, id, status, cuenta, clave, descripcion, autor,
				cuenta1);
		List<TablaEstiloCarta> procesos = ImpresionService.findAll_TBL_SIF_ESTILO_CARTA();
		consulta.addAttribute("consulta", procesos);
		return "impresion/ImpresionesEtiquetas";

	}
}
