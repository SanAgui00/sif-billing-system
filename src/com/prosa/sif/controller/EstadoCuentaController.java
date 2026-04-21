/**
################################################################################
# Autor               : David Garnica                                          #
# Compania            : Código Geek                                            #
# Proyecto/Procliente : Controller de Estado de Cuenta       Fecha: 29/08/2018 #
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
import org.springframework.web.bind.annotation.RequestParam;

import com.prosa.sif.operation.ProcesoGeneral;
import com.prosa.sif.service.EstadoCuentaService;
import com.prosa.sif.service.ListaGeneralService;
/**
 * 
 * @author David Garnica Garcia
 *
 */
@Controller
public class EstadoCuentaController {
	@Autowired
	private ProcesoGeneral procesoGeneral;
	@Autowired
	private EstadoCuentaService estadoCuentaService;
	@Autowired
	private ListaGeneralService listaGeneralService;
	
	private static String contr = "controller";
	private static String estCobranzaDiaria = "estadoCuenta/estadoCobranzaDiaria";

	/**
	 * 
	 * @param request
	 * @return 
	 */
	@RequestMapping("/home/estados/cuenta")
	public String showEstadosCuenta(Model model, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaPeriodos(model, request);
		listaGeneralService.listaClientes(model, request);
		listaGeneralService.listaMonedas(model, request);
		return "estadoCuenta/estadoCuenta";
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/home/estados/cuenta/consulta")
	public String estadosCuentaConsulta(Model model, HttpServletRequest request,
			@RequestParam(value = "id_periodo", defaultValue = "0") Integer periodo,
			 @RequestParam(value = "id_moneda", defaultValue = "0") Integer moneda,
			 @RequestParam(value = "id_cliente", defaultValue = "0") Integer cliente,
			 @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow) {
		
		procesoGeneral.loggerUsr(contr, request);
		model.addAttribute("periodo", periodo);
		model.addAttribute("moneda", moneda);
		model.addAttribute("cliente", cliente);
		estadoCuentaService.listaEstadoCuenta("count", fromRow,model, periodo, cliente, moneda, request);
		estadoCuentaService.listaEstadoCuenta("consulta",fromRow,model, periodo, cliente, moneda, request);
		listaGeneralService.listaPeriodos(model, request);
		listaGeneralService.listaClientes(model, request);
		listaGeneralService.listaMonedas(model, request);
		return "estadoCuenta/estadoCuenta";
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/home/estados/cobranza")
	public String showEstadosCobranzaDiaria(Model model, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaClientes(model, request);
		listaGeneralService.listaMonedas(model, request);
		listaGeneralService.listaProceso(model, request);
		listaGeneralService.listaNegocios(model, request);
		return estCobranzaDiaria;
	}
	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/home/estados/cobranza/consulta")
	public String EstadosCobranzaDiariaConsulta(Model model, 
			@RequestParam(value = "proceso", defaultValue = "0") Integer proceso,
			 @RequestParam(value = "id_moneda", defaultValue = "0") Integer moneda,
			 @RequestParam(value = "id_cliente", defaultValue = "") String cliente,
			 @RequestParam(value = "id_negocio", defaultValue = "0") String negocio,
			 @RequestParam(value = "fecha_inicial", defaultValue = "empty") String fecha_inicial,
			 @RequestParam(value = "fecha_final", defaultValue = "empty") String fecha_final,
			 @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
	HttpServletRequest request) {
		
		procesoGeneral.loggerUsr(contr, request);
		model.addAttribute("proceso",proceso);
		model.addAttribute("moneda",moneda);
		model.addAttribute("fecha_final",fecha_final);
		model.addAttribute("fecha_inicial",fecha_inicial);
		estadoCuentaService.listaEstadoCobranzaDiaria("count",model,request,fromRow,proceso,moneda,cliente,negocio,fecha_inicial,fecha_final);
		estadoCuentaService.listaEstadoCobranzaDiaria("consulta",model,request,fromRow,proceso,moneda,cliente,negocio,fecha_inicial,fecha_final);
		listaGeneralService.listaClientes(model, request);
		listaGeneralService.listaMonedas(model, request);
		listaGeneralService.listaProceso(model, request);
		listaGeneralService.listaNegocios(model, request);
		
		return estCobranzaDiaria;
		
	}
	
	@RequestMapping("/home/estados/cobranza/jasper")
	public String jasperCobranzaDiaria(Model model, 
			@RequestParam(value = "proceso", defaultValue = "0") Integer proceso,
			 @RequestParam(value = "id_moneda", defaultValue = "0") Integer moneda,
			 @RequestParam(value = "id_cliente", defaultValue = "") String cliente,
			 @RequestParam(value = "id_negocio", defaultValue = "0") String negocio,
			 @RequestParam(value = "fecha_inicial", defaultValue = "empty") String fecha_inicial,
			 @RequestParam(value = "fecha_final", defaultValue = "empty") String fecha_final,
			 @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "tipo", defaultValue = "empty") String tipo, HttpServletRequest request,
			HttpServletResponse response) {

		procesoGeneral.loggerUsr(contr, request);
		estadoCuentaService.jasperCobranzaDiaria(model, request, response, proceso, moneda, cliente, negocio, fecha_inicial, fecha_final, tipo);

		return estCobranzaDiaria;
	}

}