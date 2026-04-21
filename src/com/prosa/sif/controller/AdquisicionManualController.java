/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente : D-52-8268-17                         Fecha: 01/06/2018 #
# Descripcion General : Controlador para adquisiciones manuales			       #
# Marca del cambio    : LOGASIF									               #
################################################################################
**/
package com.prosa.sif.controller;

import java.lang.reflect.Array;
import java.sql.Date;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prosa.sif.operation.ProcesoGeneral;
import com.prosa.sif.service.AdquisicionManualService;
import com.prosa.sif.service.ListaGeneralService;

@Controller
public class AdquisicionManualController {
	@Autowired
	private AdquisicionManualService adquisicionManualService;
	@Autowired
	private ListaGeneralService listaGeneralService;
	@Autowired
	private ProcesoGeneral procesoGeneral;
	private static String contr = "controller"; 

	@RequestMapping("/home/adq/man/nueva")
	public String mostrarSolicitud(Model model, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		return "adquisicionManual/nuevaSolicitud";
	}
	
	@RequestMapping(value = "/home/adq/man/nueva/consulta", method = RequestMethod.POST)
	public String consultaSolicitud(Model model,
			@RequestParam(value = "servicio", defaultValue = "empty") String servicio,
			 HttpServletRequest request) {
		
		Integer id_servicio;
		String claveServicio;
		String descripcion;

		if (!servicio.equals("empty")) {
			String ser = servicio;

			String[] ser_temp;
			String ser_delimiter = "&&";
			ser_temp = ser.split(ser_delimiter);
			id_servicio = Integer.parseInt((String) Array.get(ser_temp, 0));
			claveServicio = (String) Array.get(ser_temp, 1);
			descripcion = (String) Array.get(ser_temp, 2);
		}

		else {
			id_servicio = 0;
			claveServicio = "";
			descripcion = "";
		}
		
		model.addAttribute("servicio", servicio);
		model.addAttribute("id_servicios", id_servicio);
		model.addAttribute("clave", claveServicio);
		model.addAttribute("descripcion", descripcion);
		listaGeneralService.listaServicios(model, request);
		listaGeneralService.listaPeriodos(model, request);
		adquisicionManualService.querySolicitud("consulta", model, request, id_servicio);
		procesoGeneral.loggerUsr(contr, request);
		
		return "adquisicionManual/nuevaSolicitud";
	}
	
	@RequestMapping("/home/adq/man/nueva/solicitud")
	public String crearSolicitud(Model model,
			@RequestParam(value = "id_moneda", defaultValue = "0") Integer id_moneda,
			@RequestParam(value = "tipo_cargo", defaultValue = "empty") String tipo_cargo,
			@RequestParam(value = "datos", defaultValue = "empty") String datos,
			@RequestParam(value = "subconceptos", defaultValue = "empty") String subconceptos,
			@RequestParam(value = "clientesTot", defaultValue = "empty") String clientes,
			@RequestParam(value = "servicios", defaultValue = "empty") String servicios,
			@RequestParam(value = "fecha_datos") Date fecha_datos,
			@RequestParam(value = "fechaSol") Date fechaSol,
			@RequestParam(value = "fecha_operativa", defaultValue = "empty") String fecha_operativa,
			@RequestParam(value = "uMedida", defaultValue = "empty") String uMedida,
			@RequestParam(value = "totConcep", defaultValue = "0") Integer conceptos,
			@RequestParam(value = "comentarios", defaultValue = "null") String comentarios,
			 HttpServletRequest request) {
		
		Integer id_servicio;
		String claveServicio;
		String descripcion;

		if (!servicios.equals("empty")) {
			String ser = servicios;

			String[] ser_temp;
			String ser_delimiter = "&&";
			ser_temp = ser.split(ser_delimiter);
			id_servicio = Integer.parseInt((String) Array.get(ser_temp, 0));
			claveServicio = (String) Array.get(ser_temp, 1);
			descripcion = (String) Array.get(ser_temp, 2);
		}

		else {
			id_servicio = 0;
			claveServicio = "";
			descripcion = "";
		}
		
		model.addAttribute("clave", claveServicio);
		model.addAttribute("descripcion", descripcion);
		model.addAttribute("fecha_datos", fecha_datos);
		model.addAttribute("fechaSol", fechaSol);
		model.addAttribute("uMedida", uMedida);
		model.addAttribute("fecha_operativa", fecha_operativa);
		model.addAttribute("id_servicios", id_servicio);
		model.addAttribute("id_moneda", id_moneda);
		model.addAttribute("tipo_cargo", tipo_cargo);
		model.addAttribute("datos", datos);
		model.addAttribute("subconceptos", subconceptos);
		model.addAttribute("clientes", clientes);
		model.addAttribute("conceptos", conceptos);
		model.addAttribute("comentarios", comentarios);

		return "adquisicionManual/nuevaSolicitudDetalle";
	}
	
	@RequestMapping("/home/adq/man/nueva/solicitud/enviar")
	public String enviarSolicitud(Model model,
			@RequestParam(value = "id_moneda", defaultValue = "0") Integer id_moneda,
			@RequestParam(value = "tipo_cargo", defaultValue = "empty") String tipo_cargo,
			@RequestParam(value = "datos", defaultValue = "empty") String datos,
			@RequestParam(value = "subconceptos", defaultValue = "empty") String subconceptos,
			@RequestParam(value = "id_servicio", defaultValue = "0") Integer id_servicio,
			@RequestParam(value = "clientesTot", defaultValue = "empty") String clientes,
			@RequestParam(value = "fecha_datos") Date fecha_datos,
			@RequestParam(value = "fechaSol") Date fechaSol,
			@RequestParam(value = "fecha_operativa", defaultValue = "empty") String fecha_operativa,
			@RequestParam(value = "uMedida", defaultValue = "empty") String uMedida,
			@RequestParam(value = "conceptos", defaultValue = "0") Integer conceptos,
			@RequestParam(value = "comentarios", defaultValue = "null") String comentarios,
			@RequestParam(value = "clave", defaultValue = "empty") String clave,
			@RequestParam(value = "descripcion", defaultValue = "empty") String descripcion,
			 HttpServletRequest request) {
		
		model.addAttribute("clave", clave);
		model.addAttribute("descripcion", descripcion);
		model.addAttribute("fecha_datos", fecha_datos);
		model.addAttribute("fechaSol", fechaSol);
		model.addAttribute("uMedida", uMedida);
		model.addAttribute("fecha_operativa", fecha_operativa);
		model.addAttribute("id_servicios", id_servicio);
		model.addAttribute("id_moneda", id_moneda);
		model.addAttribute("tipo_cargo", tipo_cargo);
		model.addAttribute("datos", datos);
		model.addAttribute("subconceptos", subconceptos);
		model.addAttribute("clientes", clientes);
		model.addAttribute("conceptos", conceptos);
		model.addAttribute("comentarios", comentarios);
		
		adquisicionManualService.enviarSolicitud(model, request, id_moneda, tipo_cargo, datos, subconceptos,
				id_servicio, fecha_datos, fechaSol, fecha_operativa, uMedida, conceptos, comentarios);
		
		return "adquisicionManual/nuevaSolicitudDetalle";
	}
		
	@RequestMapping("/home/adq/man/historico")
	public String mostrarHistorico(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "fecha_inicial", defaultValue = "null") String fecha_inicial,
			@RequestParam(value = "fecha_final", defaultValue = "null") String fecha_final,
			@RequestParam(value = "usuario", defaultValue = "null") String usuario, HttpServletRequest request) {
		listaGeneralService.listaServicios(model, request);
		model.addAttribute("fecha_inicial", fecha_inicial);
		model.addAttribute("fecha_final", fecha_final);
		model.addAttribute("usuario", usuario);
		procesoGeneral.loggerUsr(contr, request);
		return "adquisicionManual/historico";
	}

	@RequestMapping(value = "/home/adq/man/historico/consulta", method = RequestMethod.POST)
	public String consultaHistorico(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "id_fuente", defaultValue = "") Integer id_fuente,
			@RequestParam(value = "fecha_inicial", defaultValue = "null") String fecha_inicial,
			@RequestParam(value = "fecha_final", defaultValue = "null") String fecha_final,
			@RequestParam(value = "usuario", defaultValue = "null") String usuario, HttpServletRequest request) {
		listaGeneralService.listaServicios(model, request);
		adquisicionManualService.queryHistorico("consulta", model, request, fromRow, fecha_inicial, fecha_final,
				usuario, id_fuente);
		model.addAttribute("fecha_inicial", fecha_inicial);
		model.addAttribute("fecha_final", fecha_final);
		model.addAttribute("usuario", usuario);
		procesoGeneral.loggerUsr(contr, request);
		return "adquisicionManual/historico";
	}

	@RequestMapping("/home/adq/man/verificar")
	public String mostrarVerificar(Model model, HttpServletRequest request,
			@RequestParam(value = "id_periodo", defaultValue = "") Integer id_periodo,
			@RequestParam(value = "id_fuente", defaultValue = "") Integer id_servicio,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaPeriodos(model, request);
		listaGeneralService.listaServicios(model, request);
		return "adquisicionManual/verificarSolicitud";
	}

	@RequestMapping(value = "/home/adq/man/verificar/consulta", method = RequestMethod.POST)
	public String consultaVerificar(Model model, HttpServletRequest request,
			@RequestParam(value = "id_periodo", defaultValue = "") Integer id_periodo,
			@RequestParam(value = "id_fuente", defaultValue = "") Integer id_servicio,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaPeriodos(model, request);
		listaGeneralService.listaServicios(model, request);
		adquisicionManualService.queryVerificar("consulta", model, request, id_periodo, id_servicio, fromRow);
		return "adquisicionManual/verificarSolicitud";
	}
}