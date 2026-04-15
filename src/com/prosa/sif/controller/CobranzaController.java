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

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prosa.sif.operation.ProcesoGeneral;
import com.prosa.sif.service.CobranzaService;
import com.prosa.sif.service.ListaGeneralService;

@Controller
public class CobranzaController {
	@Autowired
	private ListaGeneralService listaGeneralService;
	@Autowired
	private CobranzaService cobranzaService;
	@Autowired
	private ProcesoGeneral procesoGeneral;
	private static String contr= "controller";
	private static String fechainicial = "fecha_inicial";
	private static String fechafinal = "fecha_final";
	private static String calCobranza = "cobranzaDiaria/calcularCobranza";

	@RequestMapping("/home/cobranza/calcular")
	public String showCalcularCobranza(Model model,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow, HttpServletRequest request,
			@RequestParam(value = "fecha_inicial", defaultValue = "null") String fecha_inicial,
			@RequestParam(value = "flag", defaultValue = "0") Integer flag,
			@RequestParam(value = "fecha_final", defaultValue = "null") String fecha_final) {
		model.addAttribute(fechainicial, fecha_inicial);
		model.addAttribute(fechafinal, fecha_final);
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaFuentes(model, request);
		listaGeneralService.listaServicios(model, request);
		return calCobranza;
	}

	@RequestMapping(value = "/home/cobranza/calcular/consulta", method = RequestMethod.POST)
	public String consultaCalcularCobranza(Model model,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "id_fuente", defaultValue = "0") Integer id_fuente,
			@RequestParam(value = "id_servicio", defaultValue = "0") Integer id_servicio,
			@RequestParam(value = "flag", defaultValue = "0") Integer flag,
			@RequestParam(value = "fecha_inicial", defaultValue = "null") String fecha_inicial,
			@RequestParam(value = "fecha_final", defaultValue = "null") String fecha_final,
			HttpServletRequest request) {

		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaFuentes(model, request);
		listaGeneralService.listaServicios(model, request);
		cobranzaService.queryCobranza(model, request, id_fuente, id_servicio, flag, fecha_inicial, fecha_final,
				fromRow);
		model.addAttribute("id_fuente", id_fuente);
		model.addAttribute("id_servicio", id_servicio);
		model.addAttribute("flag", flag);
		model.addAttribute(fechainicial, fecha_inicial);
		model.addAttribute(fechafinal, fecha_final);
		return calCobranza;
	}

	@RequestMapping(value = "/home/cobranza/calcular/proceso", method = RequestMethod.POST)
	public String procesoCalcularCobranza(Model model,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "variables", defaultValue = "") String cadena, HttpServletRequest request,
			@RequestParam(value = "evento", defaultValue = "") String evento,
			@RequestParam(value = "flag", defaultValue = "0") Integer flag) {
		procesoGeneral.loggerUsr(contr, request);
		cobranzaService.crudCobranza(model, request, cadena, evento, flag);
		return calCobranza;

	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/home/cobranza/cifras")
	public String mostrarConsultaEnviarCifras(Model model,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaProceso(model, request);
		listaGeneralService.listaNegocios(model, request);
		listaGeneralService.listaClientes(model, request);
		return "cobranzaDiaria/enviarCifras";
	}

	@RequestMapping(value = "/home/cobranza/cifras/consulta", method = RequestMethod.POST)
	public String consultaEnviarCifrasCobros(Model model,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "id_proceso", defaultValue = "0") Integer id_proceso,
			@RequestParam(value = "id_negocio", defaultValue = "0") Integer id_negocio,
			@RequestParam(value = "id_cliente", defaultValue = "0") Integer id_cliente,
			@RequestParam(value = "fecha_libra", defaultValue = "null") String fecha_libra,
			@RequestParam(value = "fecha_sac", defaultValue = "null") String fecha_sac,
			@RequestParam(value = "periodicidad", defaultValue = "null") String periodicidad,
			@RequestParam(value = "tipo_documento", defaultValue = "null") String tipo_documento,
			@RequestParam(value = "interfase", defaultValue = "null") String interfase,
			@RequestParam(value = "evento", defaultValue = "null") String evento, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaProceso(model, request);
		listaGeneralService.listaNegocios(model, request);
		listaGeneralService.listaClientes(model, request);

		return "cobranzaDiaria/enviarCifras";
	}

	@RequestMapping("/home/cobranza/cambio")
	public String showTiposCambio(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaPeriodos(model, request);
		listaGeneralService.listaMonedas(model, request);
		return "cobranzaDiaria/tipoCambio";
	}

	@RequestMapping("/home/cobranzadiaria/tipocambio/consulta")
	public String consultaTiposCambio(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			HttpServletRequest request, @RequestParam(value = "id_periodo", defaultValue = "null") String id_periodo,
			@RequestParam(value = "id_moneda", defaultValue = "null") String id_moneda) {
		
		procesoGeneral.loggerUsr(contr, request);
		model.addAttribute("id_peri", id_periodo);
		model.addAttribute("id_mone", id_moneda);
		cobranzaService.queryTipoCambio(model, id_moneda, id_periodo);
		listaGeneralService.listaPeriodos(model, request);
		listaGeneralService.listaMonedas(model, request);
		return "cobranzaDiaria/tipoCambio";
	}

	@RequestMapping(value = "/home/cobranzadiaria/tiposcambio/guardar", produces = "application/json")
	public String guardarTiposCambio(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			HttpServletRequest request, @RequestParam(value = "term", defaultValue = "null") String variables,
			@RequestParam(value = "peri", defaultValue = "0") String id_periodo,
			@RequestParam(value = "mone", defaultValue = "0") String id_moneda,RedirectAttributes redirectAttributes) {
		procesoGeneral.loggerUsr(contr, request);
		cobranzaService.actualizarTiposCambio(variables);
		return "redirect:/home/cobranza/cambio";
	}

	@RequestMapping("/home/cobranza/bitacora")
	public String showBitacora(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "fecha_inicial", defaultValue = "null") String fecha_inicial,
			@RequestParam(value = "fecha_final", defaultValue = "null") String fecha_final,
			@RequestParam(value = "usuario", defaultValue = "null") String usuario, HttpServletRequest request) {
		model.addAttribute(fechainicial, fecha_inicial);
		model.addAttribute(fechafinal, fecha_final);
		model.addAttribute("usuario", usuario);
		procesoGeneral.loggerUsr(contr, request);
		return "cobranzaDiaria/consultarBitacora";
	}

	@RequestMapping(value = "/home/cobranza/bitacora/consulta", method = RequestMethod.POST)
	public String showConsultarBitacora(Model model,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "fecha_inicial", defaultValue = "null") String fecha_inicial,
			@RequestParam(value = "fecha_final", defaultValue = "null") String fecha_final,
			@RequestParam(value = "usuario", defaultValue = "null") String usuario, HttpServletRequest request) {
		model.addAttribute(fechainicial, fecha_inicial);
		model.addAttribute(fechafinal, fecha_final);
		model.addAttribute("usuario", usuario);
		cobranzaService.queryBitacora("consulta", model, request, fromRow, fecha_inicial, fecha_final, usuario);
		procesoGeneral.loggerUsr(contr, request);
		return "cobranzaDiaria/consultarBitacora";
	}
}