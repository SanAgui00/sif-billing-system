/**
################################################################################
# Autor               : Garnica                                                #
# Compania            : Código Geek                                            #
# Proyecto/Procliente : Controller de registo contable       Fecha: 08/03/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/
package com.prosa.sif.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.prosa.sif.operation.ProcesoGeneral;
import com.prosa.sif.service.ListaGeneralService;
import com.prosa.sif.service.RegistroContableService;
/**
 * 
 * @author David Garnica Garcia
 *
 */
@Controller
public class RegistroContableController {
	@Autowired
	private ProcesoGeneral procesoGeneral;
	@Autowired
	private ListaGeneralService listaGeneralService;
	@Autowired
	private RegistroContableService registroContableService;
	
	private static String consulta = "consulta";
	private static String contr = "controller";
	private static String count = "count";
	private static String status = "estatus";
	private static String fechafinal = "fecha_final";
	private static String fechainicial = "fecha_inicial";
	private static String neg = "negocio";
	private static String proc = "proceso";
	private static String generarRegistro = "registroContable/generarRegistro";
	private static String mantenerRegistro = "registroContable/mantenerRegistro";
	private static String parametrizacion = "registroContable/parametrizacion";
	
	@RequestMapping("/home/registro/generar")
	public String viewGenerarRegistro(Model model, SessionStatus sessionStatus, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaProceso(model, request);
		listaGeneralService.listaNegocios(model, request);
		return generarRegistro;
		
	}
	
	
	@RequestMapping("/home/registro/generar/consulta")
	public String GenerarRegistroConsulta(Model model, 
			@RequestParam(value = "proceso", defaultValue = "0") Integer proceso,
			 @RequestParam(value = "id_negocio", defaultValue = "0") Integer negocio,
			 @RequestParam(value = "fecha_inicial", defaultValue = "empty") String fecha_inicial,
			 @RequestParam(value = "fecha_final", defaultValue = "empty") String fecha_final,
			 @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
	HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		model.addAttribute(proc, proceso);
		model.addAttribute(neg, negocio);
		model.addAttribute(fechainicial, fecha_inicial);
		model.addAttribute(fechafinal, fecha_final);
		registroContableService.queryRegistroContable(count,model,fromRow,proceso,negocio,fecha_inicial,fecha_final);
		registroContableService.queryRegistroContable(consulta,model,fromRow,proceso,negocio,fecha_inicial,fecha_final);
		listaGeneralService.listaProceso(model, request);
		listaGeneralService.listaNegocios(model, request);
		return generarRegistro;
		
	}
	
	@RequestMapping("/home/registro/generar/generarregistro")
	public String GenerarRegistro(Model model, SessionStatus sessionStatus,
			@RequestParam(value = "proceso", defaultValue = "0") Integer proceso,
			 @RequestParam(value = "id_negocio", defaultValue = "0") Integer negocio,
			 @RequestParam(value = "fecha_inicial", defaultValue = "2010-02-12") String fecha_inicial,
			 @RequestParam(value = "fecha_final", defaultValue = "2012-02-12") String fecha_final,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "checkval", defaultValue = "empty") String values,HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		registroContableService.queryenvelirev(model,fecha_inicial,fecha_final);
		listaGeneralService.listaProceso(model, request);
		listaGeneralService.listaNegocios(model, request);
		return generarRegistro;
	}

	@RequestMapping("/home/registro/mantener")
	public String viewMantenerRegistro(Model model, SessionStatus sessionStatus, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaProceso(model, request);
		listaGeneralService.listaNegocios(model, request);
		listaGeneralService.listaClientes(model, request);
		listaGeneralService.listaMonedas(model, request);
		return mantenerRegistro;
	}
	@RequestMapping("/home/registro/mantener/consulta")
	public String MantenerRegistroConsulta(Model model, SessionStatus sessionStatus, HttpServletRequest request,
			@RequestParam(value = "id_cliente", defaultValue = "0") Integer cliente,
			@RequestParam(value = "proceso", defaultValue = "") Integer proceso,
			@RequestParam(value = "id_negocio", defaultValue = "") Integer negocio,
			@RequestParam(value = "fecha_inicial", defaultValue = "empty") String fecha_inicial,
			@RequestParam(value = "fecha_final", defaultValue = "empty") String fecha_final, 
			HttpServletResponse response,
			@RequestParam(value = "document", defaultValue = "empty") String document,
			@RequestParam(value = "estatus", defaultValue = "empty") String estatus,
			@RequestParam(value = "id_moneda", defaultValue = "") String id_moneda,
			 @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow) {
		procesoGeneral.loggerUsr(contr, request);
		model.addAttribute("cliente",cliente);
		model.addAttribute(proc,proceso);
		model.addAttribute(neg,negocio);
		model.addAttribute(fechainicial,fecha_inicial);
		model.addAttribute(fechafinal,fecha_final);
		model.addAttribute("document",document);
		model.addAttribute(status,estatus);
		model.addAttribute("moneda",id_moneda);
		registroContableService.queryMantenerRegistro(count,model,fromRow,cliente,proceso,negocio,fecha_inicial,fecha_final,document,estatus,id_moneda);
		registroContableService.queryMantenerRegistro(consulta,model,fromRow,cliente,proceso,negocio,fecha_inicial,fecha_final,document,estatus,id_moneda);
		listaGeneralService.listaProceso(model, request);
		listaGeneralService.listaNegocios(model, request);
		listaGeneralService.listaClientes(model, request);
		listaGeneralService.listaMonedas(model, request);
		return mantenerRegistro;
	}
	@RequestMapping(value = "/home/registro/mantener/crud", method = RequestMethod.POST)
	public String MantenerCrud(Model model, SessionStatus sessionStatus,
			@RequestParam(value = "clave", defaultValue = "0") Integer clave,
			@RequestParam(value = "event", defaultValue = "none") String event,
			@RequestParam(value = "clavePoliza", defaultValue = "empty") String clavePoliza,
			@RequestParam(value = "descripcion", defaultValue = "empty") String descripcion,
			@RequestParam(value = "fecha", defaultValue = "empty") String fecha,
			@RequestParam(value = "id_generado_gl", defaultValue = "") String id_generado_gl
			,@RequestParam(value = "estatus", defaultValue = "") String estatus,HttpServletRequest request, HttpServletResponse response) {
		
		procesoGeneral.loggerUsr(contr, request);
		registroContableService.queryFindRegistroPoliza(model, clave,event,request,response);
		model.addAttribute("event", event);
		model.addAttribute("clavePoliza", clavePoliza);
		model.addAttribute("descripcion", descripcion);
		model.addAttribute("fecha", fecha);
		model.addAttribute("id_generado", id_generado_gl);
		model.addAttribute(status, estatus);
		listaGeneralService.listaProceso(model, request);
		listaGeneralService.listaCentroCostos(model, request);
		listaGeneralService.listaClientes(model, request);
		listaGeneralService.listaNegocios(model, request);
		listaGeneralService.listaFuentes(model, request);
		listaGeneralService.listaServicios(model, request);
		listaGeneralService.listaEmpresas(model, request);
		sessionStatus.setComplete();
		return "registroContable/MantenerRegistroCrud";
	}
	
	@RequestMapping(value = "/home/registro/mantener/save", method = RequestMethod.POST)
	public String MantenerUpdateorDelete(Model model, SessionStatus sessionStatus,
			@RequestParam(value = "id_poliza", defaultValue = "0") Integer clave,
			@RequestParam(value = "clavePoliza", defaultValue = "empty") String clavePoliza,
			@RequestParam(value = "descripcion1", defaultValue = "empty") String descripcion,
			@RequestParam(value = "fecha", defaultValue = "empty") String fecha,
			@RequestParam(value = "evento", defaultValue = "empty") String event,
			@RequestParam(value = "checkval", defaultValue = "empty") String checkval,
			@RequestParam(value = "id_generado_gl", defaultValue = "") String id_generado_gl,HttpServletRequest request, HttpServletResponse response) {
		
		procesoGeneral.loggerUsr(contr, request);
		registroContableService.SaveorDeleteRegistroPoliza(model,clave,event,request,response,checkval);

		return "registroContable/MantenerRegistroCrud";
	}
	
	
	@RequestMapping("/home/registro/asociar")
	public String viewAsociarNegocioPoliza(Model model, SessionStatus sessionStatus, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaNegocios(model, request);
		return "registroContable/asociarNegocioPoliza";
	}
	
	@RequestMapping("/home/registro/asociar/consulta")
	public String AsociarNegocioPolizaConsulta(Model model, 
			@RequestParam(value = "id_negocio", defaultValue = "0") Integer id_negocio
			,SessionStatus sessionStatus, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		model.addAttribute(neg,id_negocio);
		model.addAttribute("bandera","lleno");
		registroContableService.queryAsignarPolizasNegocios(model,id_negocio);
		listaGeneralService.listaNegocios(model, request);
		return "registroContable/asociarNegocioPoliza";
	}
	@RequestMapping("/home/registro/asociar/asociarpolinego")
	public String AsociarNegocioPolizaUpdate(Model model, 
			@RequestParam(value = "newaso", defaultValue = "0") String values,SessionStatus sessionStatus, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		registroContableService.SaveorUpdateAsignarPolizasNegocios(request, model,values);
		return "redirect:/home/registro/asociar";
	}
	@RequestMapping("/home/registro/parametrizar")
	public String viewParametrizacion(Model model, SessionStatus sessionStatus,
			HttpServletRequest request,
			@RequestParam(value = "id_poliza", defaultValue = "0") Integer id_modelo_poliza,
			 @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaPolizas(model, request);
		registroContableService.queryPolizasContables(count,model,fromRow,id_modelo_poliza);
		registroContableService.queryPolizasContables(consulta,model,fromRow,id_modelo_poliza);
		return parametrizacion;
	}
	@RequestMapping("/home/registro/parametrizacion/consulta")
	public String ParametrizacionConsulta(Model model, SessionStatus sessionStatus,
			HttpServletRequest request,
			@RequestParam(value = "id_poliza", defaultValue = "0") Integer id_modelo_poliza,
			 @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaPolizas(model, request);
		model.addAttribute("modelo_poliza",id_modelo_poliza);
		registroContableService.queryPolizasContables(count,model,fromRow,id_modelo_poliza);
		registroContableService.queryPolizasContables(consulta,model,fromRow,id_modelo_poliza);
		return parametrizacion;
	}
	@RequestMapping(value = "/home/registro/parametrizacion/crud", method = RequestMethod.POST)
	public String ParametrizacionCrud(Model model, SessionStatus sessionStatus,
			@RequestParam(value = "clave", defaultValue = "0") Integer clave,
			@RequestParam(value = "event", defaultValue = "none") String event, HttpServletRequest request, HttpServletResponse response) {
		procesoGeneral.loggerUsr(contr, request);
		for (int i = 1; i <=7; i++) {
			listaGeneralService.listaSegmentos(model,request,i);
		}
//		listaGeneralService.listaCuentasContables(model, request);
//		listaGeneralService.listaEmpresas(model, request);
//		listaGeneralService.listaCentroCostos(model, request);
		listaGeneralService.listaClientes(model, request);
		listaGeneralService.listaNegocios(model, request);
		listaGeneralService.listaImportes(model,request);
		registroContableService.queryFindPolizaContable(model, clave,event,request,response);
		model.addAttribute("event", event);
		sessionStatus.setComplete();
		return "registroContable/parametrizacionCrud";
	}
	
	@RequestMapping(value = "/home/registro/parametrizar/save", method = RequestMethod.POST)
	public String ParametrizacionSave(Model model, SessionStatus sessionStatus,
			@RequestParam(value = "evento", defaultValue = "empty") String event,
			@RequestParam(value = "clavePoliza", defaultValue = "empty") String clavePoliza,
			@RequestParam(value = "tipopoli", defaultValue = "empty") String tipopoli,
			@RequestParam(value = "checkval", defaultValue = "empty") String checkval,
			@RequestParam(value = "descripcionPoli", defaultValue = "empty") String descripcionPoli, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "id_poliza", defaultValue = "0") Integer id_modelo_poliza,
			 @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow) {
			procesoGeneral.loggerUsr(contr, request);
			registroContableService.saveOrUpdatePolizaContable(request, model,event,clavePoliza,tipopoli,descripcionPoli,checkval,id_modelo_poliza);
			listaGeneralService.listaPolizas(model, request);
			registroContableService.queryPolizasContables(count,model,fromRow,0);
			registroContableService.queryPolizasContables(consulta,model,fromRow,0);
		return parametrizacion;
	}
	
	@RequestMapping(value = "/home/registro/mantener/envreveli", method = RequestMethod.POST)
	public String MantenerRegistro(Model model, SessionStatus sessionStatus, HttpServletRequest request,
			@RequestParam(value = "id_cliente", defaultValue = "0") Integer cliente,
			@RequestParam(value = "proceso", defaultValue = "") Integer proceso,
			@RequestParam(value = "id_negocio", defaultValue = "") Integer negocio,
			@RequestParam(value = "fecha_inicial", defaultValue = "empty") String fecha_inicial,
			@RequestParam(value = "fecha_final", defaultValue = "empty") String fecha_final, 
			HttpServletResponse response,
			@RequestParam(value = "document", defaultValue = "empty") String document,
			@RequestParam(value = "estatus", defaultValue = "empty") String estatus,
			@RequestParam(value = "id_moneda", defaultValue = "") String id_moneda,
			 @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow) {
		procesoGeneral.loggerUsr(contr, request);
		model.addAttribute("cliente",cliente);
		model.addAttribute(proc,proceso);
		model.addAttribute(neg,negocio);
		model.addAttribute(fechainicial,fecha_inicial);
		model.addAttribute(fechafinal,fecha_final);
		model.addAttribute("document",document);
		model.addAttribute(status,estatus);
		model.addAttribute("moneda",id_moneda);
		registroContableService.queryenvelirev(model,fecha_inicial,fecha_final);
		listaGeneralService.listaProceso(model, request);
		listaGeneralService.listaNegocios(model, request);
		listaGeneralService.listaClientes(model, request);
		listaGeneralService.listaMonedas(model, request);
		return mantenerRegistro;
	}
	
}
