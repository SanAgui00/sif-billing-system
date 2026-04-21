/**
################################################################################
# Autor               : Loredo y Garnica                                       #
# Compania            : C�digo Geek                                            #
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
import com.prosa.sif.service.CobroService;
import com.prosa.sif.service.ListaGeneralService;

/**
 * 
 * @author Loredo y Garnica
 *
 */
@Controller
public class CobroController {
	@Autowired
	private ProcesoGeneral procesoGeneral;
	@Autowired
	private ListaGeneralService listaGeneralService;
	@Autowired
	private CobroService cobroService;
	
	private static String contr = "controller";
	private static String enviarCifras = "cobro/enviarCifras";

	@RequestMapping("/home/cobros/cifras")
	public String showEnviarCifras(Model model, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaClientes(model, request);
		listaGeneralService.listaNegocios(model, request);
		listaGeneralService.listaProceso(model, request);
		return enviarCifras;
	}
	
	@RequestMapping("/home/cobro/cifras/consulta")
	public String EnviarCifrasConsulta(Model model,
			@RequestParam(value = "id_cliente", defaultValue = "0") Integer id_cliente,
			@RequestParam(value = "proceso", defaultValue = "0") Integer proceso,
			 @RequestParam(value = "id_negocio", defaultValue = "0") Integer negocio,
			 @RequestParam(value = "fecha_sac", defaultValue = "empty") String fecha_sac,
			 @RequestParam(value = "fecha_libra", defaultValue = "empty") String fecha_libra,
			 @RequestParam(value = "periodicidad", defaultValue = "empty") String periodicidad,
			 @RequestParam(value = "document", defaultValue = "empty") String document,
			 @RequestParam(value = "interfase", defaultValue = "empty") String interfase,
			 @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		model.addAttribute("fecha_sac", fecha_sac);
		model.addAttribute("fecha_libra", fecha_libra);
		cobroService.queryEnviarCifras("count",model,fromRow,id_cliente,proceso,negocio,fecha_libra,fecha_sac,periodicidad,document,interfase);
		cobroService.queryEnviarCifras("consulta",model,fromRow,id_cliente,proceso,negocio,fecha_libra,fecha_sac,periodicidad,document,interfase);
		listaGeneralService.listaClientes(model, request);
		listaGeneralService.listaNegocios(model, request);
		listaGeneralService.listaProceso(model, request);
		return enviarCifras;
	}

	@RequestMapping("/home/cobros/movimientos")
	public String showMovimientosFinancieros(Model model, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaClientes(model, request);
		listaGeneralService.listaNegocios(model, request);
		listaGeneralService.listaProceso(model, request);
		listaGeneralService.listaMonedas(model, request);
		return "cobro/movimientosFinancieros";
	}
	
	@RequestMapping("/home/cobros/movimientos/consulta")
	public String MovimientosFinancierosConsulta(Model model,
			@RequestParam(name = "cliente", defaultValue = "0") String cliente,
			@RequestParam(value = "proceso", defaultValue = "0") Integer proceso,
			 @RequestParam(value = "negocio", defaultValue = "0") Integer negocio,
			 @RequestParam(value = "fecha_envio", defaultValue = "empty") String fecha_envio,
			 @RequestParam(value = "folio_impreso", defaultValue = "") String folio_impreso,
			 @RequestParam(value = "id_moneda", defaultValue = "empty") Integer id_moneda,
			 @RequestParam(value = "serie", defaultValue = "empty") String serie,
			 @RequestParam(value = "sisenv", defaultValue = "empty") String sisenv,
			 @RequestParam(value = "document", defaultValue = "empty") String document,
			 @RequestParam(value = "folio_interno", defaultValue = "") String folio_interno,
			 @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			HttpServletRequest request) {
		
		Integer id_cliente;
		String clave_cliente;
		String nombre_corto;

		if (!cliente.equals("0")) {
			String cl = cliente;

			String[] cl_temp;
			String cl_delimiter = "&&";
			cl_temp = cl.split(cl_delimiter);
			id_cliente = Integer.parseInt((String) Array.get(cl_temp, 0));
			clave_cliente = (String) Array.get(cl_temp, 1);
			nombre_corto = (String) Array.get(cl_temp, 2);
		}

		else {
			clave_cliente = "";
			id_cliente = 0;
			nombre_corto = "";
		}		
		model.addAttribute("clave_cliente", clave_cliente);
		model.addAttribute("nombre_corto", nombre_corto);
		model.addAttribute("id_cliente", id_cliente);
		model.addAttribute("proceso", proceso);
		model.addAttribute("negocio", negocio);
		model.addAttribute("fecha_envio", fecha_envio);
		model.addAttribute("folio_impreso", folio_impreso);
		model.addAttribute("id_moneda", id_moneda);
		model.addAttribute("serie", serie);
		model.addAttribute("sisenv", sisenv);
		model.addAttribute("document", document);
		model.addAttribute("folio_interno", folio_interno);
		
		procesoGeneral.loggerUsr(contr, request);
		cobroService.queryMovimientosFinancieros("count",model,fromRow,id_cliente,proceso,negocio,fecha_envio,folio_impreso,id_moneda,serie,sisenv,document,folio_interno);
		cobroService.queryMovimientosFinancieros("consulta",model,fromRow,id_cliente,proceso,negocio,fecha_envio,folio_impreso,id_moneda,serie,sisenv,document,folio_interno);
		listaGeneralService.listaClientes(model, request);
		listaGeneralService.listaNegocios(model, request);
		listaGeneralService.listaProceso(model, request);
		listaGeneralService.listaMonedas(model, request);
		return "cobro/movimientosFinancieros";
	}
	
	@RequestMapping("/home/cobros/movimientos/cfds")
	public String movimientosFinancierosCFDS(Model model,
			@RequestParam(value = "tipo", defaultValue = "empty") String tipo,
			@RequestParam(value = "mostrar", defaultValue = "empty") String mostrar,
			HttpServletRequest request) {

		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaClientes(model, request);
		listaGeneralService.listaNegocios(model, request);
		listaGeneralService.listaProceso(model, request);
		listaGeneralService.listaMonedas(model, request);
				
		//cobroService.movimientosFinancierosCFDS(model, tipo, datos, datosInput);

		return "cobro/movimientosFinancieros";
	}
	
	
	@RequestMapping("/home/cobro/enviar/enviartodo")
	public String EnviarCifras(Model model,
			 @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			 @RequestParam(value = "checkval", defaultValue = "empty") String values,HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		
		cobroService.Enviarcifras(model,values);
		listaGeneralService.listaClientes(model, request);
		listaGeneralService.listaNegocios(model, request);
		listaGeneralService.listaProceso(model, request);
		return enviarCifras;
	}
}
