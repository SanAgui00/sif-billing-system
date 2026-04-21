/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 08/03/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/
package com.prosa.sif.controller;

import java.lang.reflect.Array;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prosa.sif.operation.ProcesoGeneral;
import com.prosa.sif.service.CuentaCobrarService;
import com.prosa.sif.service.ListaGeneralService;


@Controller
public class CuentaCobrarController {
	@Autowired
	private ProcesoGeneral procesoGeneral;
	@Autowired
	private ListaGeneralService listaGeneralService;
	@Autowired
	private CuentaCobrarService cuentaCobrarService;
	
	private static String consulta = "consulta";
	private static String contr = "controller";
	

	@RequestMapping("/home/cuentas/mantener")
	public String showMantenerCuentas(Model model, HttpServletRequest request) {
		listaGeneralService.listaMonedas(model, request);
		listaGeneralService.listaClientes(model, request);
		procesoGeneral.loggerUsr("controller", request);
		return "cuenta/mantenerCuentas";
	}
	@RequestMapping(value = "/home/cuentas/mantener/consulta")
	public String consultaMantenerCuentas(Model model, 
			@RequestParam(value = "id_cliente", defaultValue = "0") String cliente,
			@RequestParam(value = "id_moneda", defaultValue = "0") Integer id_moneda,
			@RequestParam(value = "fecha_inicial", defaultValue = "") String fecha_inicial,
			@RequestParam(value = "fecha_final", defaultValue = "") String fecha_final,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			HttpServletRequest request) {
		
		Integer idCliente;
		String clave_cliente;
		String nombre_corto;

		if (!cliente.equals("0")) {
			String cl = cliente;

			String[] cl_temp;
			String cl_delimiter = "&&";
			cl_temp = cl.split(cl_delimiter);
			idCliente = Integer.parseInt((String) Array.get(cl_temp, 0));
			clave_cliente = (String) Array.get(cl_temp, 1);
			nombre_corto = (String) Array.get(cl_temp, 2);
		}

		else {
			clave_cliente = "";
			idCliente = 0;
			nombre_corto = "";
		}
		
		model.addAttribute("idCliente", idCliente);
		model.addAttribute("clave_cliente", clave_cliente);
		model.addAttribute("nombre_corto", nombre_corto);
		model.addAttribute("fecha_inicial", fecha_inicial);
		model.addAttribute("fecha_final", fecha_final);
		model.addAttribute("id_moneda", id_moneda);
		listaGeneralService.listaMonedas(model, request);
		listaGeneralService.listaClientes(model, request);
		procesoGeneral.loggerUsr(contr, request);
//		cuentaCobrarService.queryServicio(count, fromRow, servicio, concepto, volumen, estatus, negocio, fuente, model,
//				request);
		cuentaCobrarService.queryCuentaCobrar(consulta, fromRow, idCliente, id_moneda, fecha_inicial, fecha_final, model, request);
		return "cuenta/mantenerCuentas";
	}

	@RequestMapping("/home/cuentas/saldos")
	public String showMantenerSaldos(Model model, HttpServletRequest request) {
		listaGeneralService.listaMonedas(model, request);
		listaGeneralService.listaCuentasContables(model, request);
		procesoGeneral.loggerUsr("controller", request);
		return "cuenta/mantenerSaldos";
	}
	
	@RequestMapping(value = "/home/cuentas/saldos/consulta")
	public String consultaMantenerSaldos(Model model,
			@RequestParam(value = "id_cliente", defaultValue = "0") String cliente,
			@RequestParam(value = "id_moneda", defaultValue = "0") Integer id_moneda,
			@RequestParam(value = "id_tipo_cuenta", defaultValue = "0") Integer id_tipo_cuenta,
			@RequestParam(value = "fecha_aplic", defaultValue = "null") String fecha_aplic,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "radio_cuentas", defaultValue = "") String radioVal,
			HttpServletRequest request) {
		
		Integer idCliente;
		String clave_cliente;
		String nombre_corto;

		if (!cliente.equals("0")) {
			String cl = cliente;

			String[] cl_temp;
			String cl_delimiter = "&&";
			cl_temp = cl.split(cl_delimiter);
			idCliente = Integer.parseInt((String) Array.get(cl_temp, 0));
			clave_cliente = (String) Array.get(cl_temp, 1);
			nombre_corto = (String) Array.get(cl_temp, 2);
		}

		else {
			clave_cliente = "";
			idCliente = 0;
			nombre_corto = "";
		}
		
		model.addAttribute("idCliente", idCliente);
		model.addAttribute("clave_cliente", clave_cliente);
		model.addAttribute("nombre_corto", nombre_corto);
		model.addAttribute("id_moneda", id_moneda);
		model.addAttribute("id_tipo_cuenta", id_tipo_cuenta);
		model.addAttribute("fecha_aplic", fecha_aplic);
		listaGeneralService.listaMonedas(model, request);
		listaGeneralService.listaCuentasContables(model, request);
		procesoGeneral.loggerUsr(contr, request);
		
		cuentaCobrarService.queryMantenerSaldos(consulta, radioVal, fromRow, idCliente, id_moneda, id_tipo_cuenta, fecha_aplic, model, request);
		
		return "cuenta/mantenerSaldos";
	}
	
	@RequestMapping(value = "/home/cuentas/saldos/save", produces = "application/json")
	public String saveMantenerSaldos(Model model,
			@RequestParam(value = "term", defaultValue = "null") String variables,
			HttpServletRequest request) {

		listaGeneralService.listaMonedas(model, request);
		listaGeneralService.listaCuentasContables(model, request);
		procesoGeneral.loggerUsr(contr, request);
		cuentaCobrarService.guardarMantenerSaldos(variables);
		return "cuenta/mantenerSaldos";
	}
	
}
