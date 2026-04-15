/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 21/03/2018 #
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
import com.prosa.sif.service.AdquisicionAutoService;
import com.prosa.sif.service.FacturaService;
import com.prosa.sif.service.ListaGeneralService;

@Controller
public class AdquisicionAutoController {
	@Autowired
	private ProcesoGeneral procesoGeneral;
	@Autowired
	private ListaGeneralService listaGeneralService;
	@Autowired
	private AdquisicionAutoService adquisicionAutoService;
	@Autowired
	private FacturaService facturaService;
	
	private static String contr = "controller";  
	private static String count = "count"; 
	private static String consulta = "consulta"; 
	private static String serviFactura ="adquisicionAuto/servicioFactura";
	private static String fechainicial = "fecha_inicial";
	private static String fechafinal = "fecha_final";

	/**
	 * Verificar Adquisicion
	 * 
	 * @param model
	 * @param request
	 * @param fecha_inicial
	 * @param fecha_final
	 * @return
	 */
	@RequestMapping("home/adq/auto/verificar")
	public String viewAdquisicion(Model model, HttpServletRequest request,
			@RequestParam(value = "fecha_inicial", defaultValue = "null") String fecha_inicial,
			@RequestParam(value = "fecha_final", defaultValue = "null") String fecha_final) {
		
		
		procesoGeneral.loggerUsr(contr, request);
		model.addAttribute(fechainicial, fecha_inicial);
		model.addAttribute(fechafinal, fecha_final);
		listaGeneralService.listaFuentes(model, request);
		return "adquisicionAuto/verificarAdquisicion";
	}

	/**
	 * Verificar Adquisición Consulta
	 * 
	 * @param model
	 * @param request
	 * @param fuentes_clave
	 * @param estatus
	 * @param fecha_inicial
	 * @param fecha_final
	 * @param fromRow
	 * @return
	 */
	@RequestMapping(value = "home/adq/auto/verificar/consulta", method = RequestMethod.POST)
	public String showAdquisicion(Model model, HttpServletRequest request,
			@RequestParam(value = "fuentes", defaultValue = "0") Integer fuentes_clave,
			@RequestParam(value = "estatus", defaultValue = "null") String estatus,
			@RequestParam(value = "fecha_inicial", defaultValue = "null") String fecha_inicial,
			@RequestParam(value = "fecha_final", defaultValue = "null") String fecha_final,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow) {
		procesoGeneral.loggerUsr(contr, request);
		model.addAttribute("fuentes_clave", fuentes_clave);
		model.addAttribute("estatus", estatus);
		model.addAttribute(fechainicial, fecha_inicial);
		model.addAttribute(fechafinal, fecha_final);
		listaGeneralService.listaFuentes(model, request);
		adquisicionAutoService.queryAdquisicionAuto(count, fuentes_clave, estatus, fecha_inicial, fecha_final,
				fromRow, model, request);
		adquisicionAutoService.queryAdquisicionAuto(consulta, fuentes_clave, estatus, fecha_inicial, fecha_final,
				fromRow, model, request);
		return "adquisicionAuto/verificarAdquisicion";
	}

	/**
	 * Bitacora de Errores
	 * 
	 * @param model
	 * @param request
	 * @param fecha_inicial
	 * @param fecha_final
	 * @return
	 */
	@RequestMapping("/home/adq/auto/bitacora")
	public String viewBitacora(Model model, HttpServletRequest request,
			@RequestParam(value = "fecha_inicial", defaultValue = "null") String fecha_inicial,
			@RequestParam(value = "fecha_final", defaultValue = "null") String fecha_final) {
		procesoGeneral.loggerUsr(contr, request);
		model.addAttribute(fechainicial, fecha_inicial);
		model.addAttribute(fechafinal, fecha_final);
		listaGeneralService.listaFuentes(model, request);
		return "adquisicionAuto/consultarBitacora";
	}

	/**
	 * Bitacora de Errores Consulta
	 * 
	 * @param model
	 * @param fuentes_clave
	 * @param fecha_inicial
	 * @param fecha_final
	 * @param request
	 * @param fromRow
	 * @return
	 */
	@RequestMapping(value = "/home/adq/auto/bitacora/consulta", method = RequestMethod.POST)
	public String showBitacora(Model model, @RequestParam("fuentes") Integer fuentes_clave,
			@RequestParam(value = "fecha_inicial", defaultValue = "null") String fecha_inicial,
			@RequestParam(value = "fecha_final", defaultValue = "null") String fecha_final, HttpServletRequest request,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaFuentes(model, request);
		model.addAttribute("fuentes_clave", fuentes_clave);
		model.addAttribute(fechainicial, fecha_inicial);
		model.addAttribute(fechafinal, fecha_final);
		adquisicionAutoService.queryBitacoraAdq(count, fromRow, fuentes_clave, fecha_inicial, fecha_final, model,
				request);
		adquisicionAutoService.queryBitacoraAdq(consulta, fromRow, fuentes_clave, fecha_inicial, fecha_final, model,
				request);

		return "adquisicionAuto/consultarBitacora";
	}

	@RequestMapping("/home/adq/auto/servicio")
	public String viewFacturar(Model model, HttpServletRequest request,
			@RequestParam(value = "idCliente", defaultValue = "0") Integer idCliente,
			@RequestParam(value = "idServicio", defaultValue = "0") Integer idServicio,
			@RequestParam(value = "fechaInicio", defaultValue = "empty") String fechaInicio,
			@RequestParam(value = "fechaFin", defaultValue = "empty") String fechaFin,
			@RequestParam(value = "estatus", defaultValue = "empty") String estatus,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaServicios(model, request);
		listaGeneralService.listaClientes(model, request);

		return serviFactura;
	}

	@RequestMapping("/home/adq/auto/servicio/consulta")
	public String consultaFacturar(Model model, HttpServletRequest request,
			@RequestParam(value = "idCliente", defaultValue = "0") Integer idCliente,
			@RequestParam(value = "idServicio", defaultValue = "0") Integer idServicio,
			@RequestParam(value = "fechaInicio", defaultValue = "empty") String fechaInicio,
			@RequestParam(value = "fechaFin", defaultValue = "empty") String fechaFin,
			@RequestParam(value = "estatus", defaultValue = "empty") String estatus,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaServicios(model, request);
		listaGeneralService.listaClientes(model, request);
		adquisicionAutoService.queryServicioFacturar(count, model, request, idCliente, idServicio, fechaInicio,
				fechaFin, estatus, fromRow);
		adquisicionAutoService.queryServicioFacturar(consulta, model, request, idCliente, idServicio, fechaInicio,
				fechaFin, estatus, fromRow);
		return serviFactura;
	}

	/**
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping("/home/adq/auto/servicio/crud")
	public String showFacturar(HttpServletRequest request, Model model,
			@RequestParam(value = "listaSeleccion", defaultValue = "empty") String listaSeleccion,
			@RequestParam(value = "event", defaultValue = "empty") String event,
			@RequestParam(value = "idMoneda", defaultValue = "0") Integer idMoneda,
			@RequestParam(value = "fechaDatos", defaultValue = "empty") String fechaDatos,
			@RequestParam(value = "estatus", defaultValue = "empty") String estatus,
			@RequestParam(value = "idServicio", defaultValue = "0") Integer idServicio,
			@RequestParam(value = "idCliente", defaultValue = "0") Integer idCliente) {
		procesoGeneral.loggerUsr(contr, request);
		adquisicionAutoService.crudServicioFacturar(model, request, event, listaSeleccion, idMoneda, idCliente,
				idServicio, fechaDatos, estatus);
		String redireccion = "";
		switch (event) {
		case "delete":
			redireccion = serviFactura;
			break;
		case "edit":
			redireccion = "adquisicionAuto/servicioFacturaCrud";
			break;
		default:
			break;

		}
		return redireccion;
	}

	@RequestMapping("/home/adq/auto/servicio/save")
	public String operacionCalendarioOperacional(Model model, HttpServletRequest request,
			@RequestParam(value = "id_servicio", defaultValue = "0") Integer idServicio,
			@RequestParam(value = "listUpdate", defaultValue = "null") String listUpdate,
			@RequestParam(value = "event", defaultValue = "null") String event) {
		procesoGeneral.loggerUsr(contr, request);
		adquisicionAutoService.crudServicioFacturar(model, request, event, listUpdate, 0, 0, idServicio, "empty",
				"empty");
		return "redirect:/home/adq/auto/servicio";
	}

	/**
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping("/home/adq/auto/comparar")
	public String viewComparar(Model model, HttpServletRequest request,
			@RequestParam(value = "fecha_final", defaultValue = "2018-01-01") String fecha_final) {
		procesoGeneral.loggerUsr(contr, request);
		facturaService.queryFacturas(model, request, fecha_final);
		return "adquisicionAuto/compararAdquisicion";
	}

	/**
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping("/home/adq/auto/comparar/consulta")
	public String showComparar(HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		return "adquisicionAuto/compararAdquisicion";
	}
	
}
