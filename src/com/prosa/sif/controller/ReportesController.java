/**
################################################################################
# Autor               : Valverde Méndez Arturo                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 25/04/2018 #
# Descripcion General : Controlador para reportes Jasper 			           #
# Marca del cambio    :                                                        #
#------------------------------------------------------------------------------#
# Numero de Parametros: N/A                                                    #
# Parametros Entrada  : N/A                                  Formato:          #
# Parametros Salida   : N/A                                  Formato:          #
################################################################################
**/

package com.prosa.sif.controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.Date;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.prosa.sif.operation.ProcesoGeneral;
import com.prosa.sif.pojo.B_ACUMULADO_COBRANZA;
import com.prosa.sif.pojo.B_COBRANZA_DIARIA;
import com.prosa.sif.pojo.B_ODT_VIGENTE;
import com.prosa.sif.pojo.B_REPORTE_COBRANZA;

import com.prosa.sif.pojo.B_SERVICIOS_CLIENTES_JASPER;

import com.prosa.sif.pojo.TBL_SIF_CAT_CLIENTES;
import com.prosa.sif.pojo.TBL_SIF_CAT_EMPRESAS;
import com.prosa.sif.pojo.TBL_SIF_CAT_MONEDAS;
import com.prosa.sif.pojo.TBL_SIF_CAT_NEGOCIOS;
import com.prosa.sif.pojo.TBL_SIF_CAT_PERIODO;
import com.prosa.sif.pojo.TBL_SIF_CAT_PROCESOS;
import com.prosa.sif.pojo.TBL_SIF_FUENTES;
import com.prosa.sif.pojo.TBL_SIF_SERVICIOS;
import com.prosa.sif.pojo.VIEW_REPORTE_CUENTAS_ACTIVAS;
import com.prosa.sif.pojo.VIEW_REPORTE_CUENTAS_ACT_2;

import com.prosa.sif.pojo.VIEW_REPORTE_TESORERIA;
import com.prosa.sif.service.ListaGeneralService;
import com.prosa.sif.service.ReportesService;

import net.sf.jasperreports.engine.JRException;

@Controller
public class ReportesController {

	@Autowired
	private ReportesService reportesService;
	@Autowired
	private ListaGeneralService listaGeneralService;
	@Autowired
	private ProcesoGeneral procesoGeneral;
	
	private static String contr = "controller";
	private static String clavecliente = "clave_cliente";
	private static String consulta = "consulta";
	private static String count = "count";
	private static String datsour= "datasource";
	private static String empre = "empresas";
	private static String formt = "format";
	private static String idclientes = "id_clientes";
	private static String fechafin = "fecha_fin";
	private static String fechaini = "fecha_ini";
	private static String idmonedas = "id_monedas";
	private static String idempresas = "id_empresas";
	private static String idnegocios = "id_negocios";
	private static String idprocesos = "id_procesos";
	private static String mone = "monedas";
	private static String nego = "negocios";
	private static String nombrecorto = "nombre_corto";
	private static String pFechaFinal = "pFechaFinal";
	private static String pFechaInicial = "pFechaInicial";
	private static String proce = "procesos";
	private static String reportPath = "reportHomePath";
	private static String serv = "servicios";

	// Clientes
	@RequestMapping(value = "/home/list/json/cliente/report", produces = "application/json")
	@ResponseBody
	public Map<String, Object> json(@RequestParam("term") String clave) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<TBL_SIF_CAT_CLIENTES> cliente = reportesService.search_TBL_SIF_CAT_CLIENTES(clave);
		for (int i = 0; i < cliente.size(); i++) {
			TBL_SIF_CAT_CLIENTES cliente_r = cliente.get(i);
			String cliente_clave = cliente_r.getId_cliente().toString() + "&&" + cliente_r.getClave_cliente() + "&&"
					+ cliente_r.getNombre_corto();
			map.put(cliente_clave, cliente_r.getClave_cliente() + '-' + cliente_r.getNombre_corto());
		}
		return map;
	}

	// Reporte Folio
	// Consultar
	@RequestMapping("/home/reportes/folios")
	public String mostrarConsultaConsecutivoFolios(Model model, SessionStatus sessionStatus, 
			HttpServletRequest request) {

		procesoGeneral.loggerUsr(contr, request);
		List<TBL_SIF_CAT_PROCESOS> procesos = reportesService.findAll_TBL_SIF_CAT_PROCESOS();
		model.addAttribute(proce, procesos);
		List<TBL_SIF_CAT_NEGOCIOS> negocios = reportesService.findAll_TBL_SIF_CAT_NEGOCIOS();
		model.addAttribute(nego, negocios);
		List<TBL_SIF_CAT_MONEDAS> monedas = reportesService.findAll_TBL_SIF_CAT_MONEDAS();
		model.addAttribute(mone, monedas);
		List<TBL_SIF_CAT_EMPRESAS> empresas = reportesService.findAll_TBL_SIF_CAT_EMPRESAS();
		model.addAttribute(empre, empresas);
		sessionStatus.setComplete();
		return "reportes/consecutivoFolios";
	}

	@RequestMapping(value = "/home/reportes/folios/find", method = RequestMethod.POST)
	public String handleConsultaReportesFolios(Model model, @RequestParam("proceso") String proceso,
			@RequestParam("negocio") String negocio, @RequestParam("moneda") String moneda,
			@RequestParam("empresa") Integer id_empresas,
			@RequestParam(name = "cliente", defaultValue = "0") String cliente,
			@RequestParam("fecha_inicial") Date fecha_inicial, @RequestParam("fecha_final") Date fecha_final,
			@RequestParam("documento") String documento, @RequestParam("serie_value") String serie_value,
			@RequestParam(name = "estatus", defaultValue = "null") String estatus,
			@RequestParam("format") String format, SessionStatus sessionStatus,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow, HttpServletRequest request,
			HttpServletResponse response) throws JRException, IOException {

		procesoGeneral.loggerUsr(contr, request);
		List<TBL_SIF_CAT_PROCESOS> procesos = reportesService.findAll_TBL_SIF_CAT_PROCESOS();
		model.addAttribute(proce, procesos);

		List<TBL_SIF_CAT_NEGOCIOS> negocios = reportesService.findAll_TBL_SIF_CAT_NEGOCIOS();
		model.addAttribute(nego, negocios);

		List<TBL_SIF_CAT_MONEDAS> monedas = reportesService.findAll_TBL_SIF_CAT_MONEDAS();
		model.addAttribute(mone, monedas);

		List<TBL_SIF_CAT_EMPRESAS> empresas = reportesService.findAll_TBL_SIF_CAT_EMPRESAS();
		model.addAttribute(empre, empresas);

		Integer id_clientes;
		String clave_cliente;
		String nombre_corto;

		String pr = proceso;

		String[] pr_temp;
		String pr_delimiter = "&&";
		pr_temp = pr.split(pr_delimiter);
		Integer id_procesos = Integer.parseInt((String) Array.get(pr_temp, 0));
		String clave_proceso = (String) Array.get(pr_temp, 1);

		String ne = negocio;

		String[] ne_temp;
		String ne_delimiter = "&&";
		ne_temp = ne.split(ne_delimiter);
		Integer id_negocios = Integer.parseInt((String) Array.get(ne_temp, 0));
		String clave_negocio = (String) Array.get(ne_temp, 1);

		String mo = moneda;

		String[] mo_temp;
		String mo_delimiter = "&&";
		mo_temp = mo.split(mo_delimiter);
		Integer id_monedas = Integer.parseInt((String) Array.get(mo_temp, 0));
		String nombre_moneda = (String) Array.get(mo_temp, 1);

		if (!cliente.equals("0")) {
			String cl = cliente;

			String[] cl_temp;
			String cl_delimiter = "&&";
			cl_temp = cl.split(cl_delimiter);
			id_clientes = Integer.parseInt((String) Array.get(cl_temp, 0));
			clave_cliente = (String) Array.get(cl_temp, 1);
			nombre_corto = (String) Array.get(cl_temp, 2);
		}

		else {
			clave_cliente = "";
			nombre_corto = "";
			id_clientes = 0;
		}

		

		switch (format) {

		// JSP
		case ("consultar"):
			reportesService.queryReporteFolio(count, model, fromRow, id_empresas, serie_value, documento, id_monedas,
					id_negocios, id_procesos, estatus, id_clientes, fecha_inicial, fecha_final);
			reportesService.queryReporteFolio(consulta, model, fromRow, id_empresas, serie_value, documento,
					id_monedas, id_negocios, id_procesos, estatus, id_clientes, fecha_inicial, fecha_final);
			model.addAttribute(idprocesos, id_procesos);
			model.addAttribute(idmonedas, id_monedas);
			model.addAttribute(idnegocios, id_negocios);
			model.addAttribute(idempresas, id_empresas);
			model.addAttribute(idclientes, id_clientes);
			model.addAttribute(clavecliente, clave_cliente);
			model.addAttribute(nombrecorto, nombre_corto);
			model.addAttribute("serie", serie_value);
			model.addAttribute("documento", documento);
			model.addAttribute("estatus", estatus);
			model.addAttribute(pFechaInicial, fecha_inicial);
			model.addAttribute(pFechaFinal, fecha_final);

		

			break;

		// Jasper1
		case ("xls"):

			reportesService.jasperexcel(request, response, clave_proceso, clave_negocio, clave_cliente, nombre_moneda,
					documento, serie_value, estatus, fecha_inicial, fecha_final, format);

			break;
			
		default:
			break;
		}

		sessionStatus.setComplete();

		return "reportes/consecutivoFolios";
	}

	// Reporte Tesoreria
	// Consultar
	@RequestMapping("/home/reportes/tesoreria")
	public String mostrarConsultaServiciosClientes(Model model, SessionStatus sessionStatus,
			HttpServletRequest request) {

		procesoGeneral.loggerUsr(contr, request);
		List<TBL_SIF_CAT_PROCESOS> procesos = reportesService.findAll_TBL_SIF_CAT_PROCESOS();
		model.addAttribute(proce, procesos);

		List<TBL_SIF_CAT_NEGOCIOS> negocios = reportesService.findAll_TBL_SIF_CAT_NEGOCIOS();
		model.addAttribute(nego, negocios);

		List<TBL_SIF_CAT_MONEDAS> monedas = reportesService.findAll_TBL_SIF_CAT_MONEDAS();
		model.addAttribute(mone, monedas);

		List<TBL_SIF_CAT_EMPRESAS> empresas = reportesService.findAll_TBL_SIF_CAT_EMPRESAS();
		model.addAttribute(empre, empresas);

		sessionStatus.setComplete();
		return "reportes/tesoreria";
	}

	// Mostrar Reporte Tesoreria
	@RequestMapping(value = "/home/reportes/tesoreria/find", method = RequestMethod.POST)
	public String handleConsultaReportesTesoreria(Model model, @RequestParam("proceso") String ci_procesos,
			@RequestParam("negocio") String ci_negocios, @RequestParam("moneda") String ci_monedas,
			@RequestParam("empresa") Integer id_empresas,
			@RequestParam(name = "cliente", defaultValue = "0") String cliente,
			@RequestParam("fecha_inicial") Date fecha_inicial, @RequestParam("fecha_final") Date fecha_final,
			@RequestParam("tipo_rep") String tipo_rep, @RequestParam("interfase") String interfase,
			@RequestParam("format") String format, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			SessionStatus sessionStatus, HttpServletRequest request) throws JRException, IOException {

		procesoGeneral.loggerUsr(contr, request);
		List<TBL_SIF_CAT_PROCESOS> procesos = reportesService.findAll_TBL_SIF_CAT_PROCESOS();
		model.addAttribute(proce, procesos);

		List<TBL_SIF_CAT_NEGOCIOS> negocios = reportesService.findAll_TBL_SIF_CAT_NEGOCIOS();
		model.addAttribute(nego, negocios);

		List<TBL_SIF_CAT_MONEDAS> monedas = reportesService.findAll_TBL_SIF_CAT_MONEDAS();
		model.addAttribute(mone, monedas);

		List<TBL_SIF_CAT_EMPRESAS> empresas = reportesService.findAll_TBL_SIF_CAT_EMPRESAS();
		model.addAttribute(empre, empresas);

		String pr = ci_procesos;

		String[] pr_temp;
		String pr_delimiter = "&&";
		pr_temp = pr.split(pr_delimiter);
		Integer id_procesos = Integer.parseInt((String) Array.get(pr_temp, 0));
		String clave_proceso = (String) Array.get(pr_temp, 1);

		String ne = ci_negocios;

		String[] ne_temp;
		String ne_delimiter = "&&";
		ne_temp = ne.split(ne_delimiter);
		Integer id_negocios = Integer.parseInt((String) Array.get(ne_temp, 0));
		String clave_negocio = (String) Array.get(ne_temp, 1);

		String mo = ci_monedas;

		String[] mo_temp;
		String mo_delimiter = "&&";
		mo_temp = mo.split(mo_delimiter);
		Integer id_monedas = Integer.parseInt((String) Array.get(mo_temp, 0));
		String clave_moneda = (String) Array.get(mo_temp, 1);

		Integer id_clientes;
		String clave_cliente;
		String nombre_corto;

		if (!cliente.equals("0")) {
			String cl = cliente;

			String[] cl_temp;
			String cl_delimiter = "&&";
			cl_temp = cl.split(cl_delimiter);
			id_clientes = Integer.parseInt((String) Array.get(cl_temp, 0));
			clave_cliente = (String) Array.get(cl_temp, 1);
			nombre_corto = (String) Array.get(cl_temp, 2);
		}

		else {
			clave_cliente = "";
			id_clientes = 0;
			nombre_corto = "";
		}

		String vista = null;
		switch (format) {

		// JSP
		case "consultar":
			reportesService.queryReporteTesosreria(count, model, fromRow, id_procesos, id_negocios, id_monedas,
					id_empresas, id_clientes, fecha_inicial, fecha_final, tipo_rep, interfase);
			reportesService.queryReporteTesosreria(consulta, model, fromRow, id_procesos, id_negocios, id_monedas,
					id_empresas, id_clientes, fecha_inicial, fecha_final, tipo_rep, interfase);

			model.addAttribute(idprocesos, id_procesos);
			model.addAttribute(idmonedas, id_monedas);
			model.addAttribute(idnegocios, id_negocios);
			model.addAttribute(idempresas, id_empresas);
			model.addAttribute(idclientes, id_clientes);
			model.addAttribute("tipo_rep", tipo_rep);
			model.addAttribute(clavecliente, clave_cliente);
			model.addAttribute(nombrecorto, nombre_corto);
			model.addAttribute("interfase", interfase);
			model.addAttribute(pFechaInicial, fecha_inicial);
			model.addAttribute(pFechaFinal, fecha_final);

			vista = "reportes/tesoreria";

			break;

		// Jasper
		case "pdf":

			List<VIEW_REPORTE_TESORERIA> datasource = reportesService.findByRows_VIEW_REPORTE_TESORERIA(id_procesos,
					id_negocios, id_monedas, id_empresas, id_clientes, fecha_inicial, fecha_final, tipo_rep, interfase);

			model.addAttribute(datsour, datasource);

			reportesService.reporteTesoreria(request);
			File img = reportesService.cargarLogo(request);

			model.addAttribute("pProceso", clave_proceso);
			model.addAttribute("pNegocio", clave_negocio);
			model.addAttribute("pMoneda", clave_moneda);
			model.addAttribute("pInterfase", interfase);
			model.addAttribute(pFechaInicial, fecha_inicial.toString());
			model.addAttribute(pFechaFinal, fecha_final.toString());
			model.addAttribute(formt, format);
			model.addAttribute("pTituloReporte", "Reporte de Tesorería");
			model.addAttribute(reportPath, img);

			vista = "Tesoreria_report";
			
			break;
			
		default:
			break;
		}

		sessionStatus.setComplete();

		return vista;
	}

	// Reporte Cobranza Diaria
	// Consultar
	@RequestMapping("/home/reportes/cobranza")
	public String mostrarConsultaCobranzaDiaria(Model model, SessionStatus sessionStatus,
			HttpServletRequest request) {

		procesoGeneral.loggerUsr(contr, request);
		List<TBL_SIF_CAT_PROCESOS> procesos = reportesService.findAll_TBL_SIF_CAT_PROCESOS();
		model.addAttribute(proce, procesos);

		List<TBL_SIF_CAT_NEGOCIOS> negocios = reportesService.findAll_TBL_SIF_CAT_NEGOCIOS();
		model.addAttribute(nego, negocios);

		List<TBL_SIF_CAT_MONEDAS> monedas = reportesService.findAll_TBL_SIF_CAT_MONEDAS();
		model.addAttribute(mone, monedas);

		List<TBL_SIF_CAT_EMPRESAS> empresas = reportesService.findAll_TBL_SIF_CAT_EMPRESAS();
		model.addAttribute(empre, empresas);

		List<TBL_SIF_SERVICIOS> servicios = reportesService.findAll_TBL_SIF_SERVICIOS();
		model.addAttribute(serv, servicios);
		sessionStatus.setComplete();
		return "reportes/cobranzaDiaria";
	}

	// Mostrar Reporte Cobranza Diaria
	@RequestMapping(value = "/home/reportes/cobranza/find", method = RequestMethod.POST)
	public String handleConsultaReportesCobranza(Model model, @RequestParam("proceso") Integer id_procesos,
			@RequestParam("negocio") Integer id_negocios, @RequestParam("moneda") Integer id_monedas,
			@RequestParam("empresa") Integer id_empresas,
			@RequestParam(name = "cliente", defaultValue = "0") String cliente,
			@RequestParam("fecha_inicial") Date fecha_inicial, @RequestParam("fecha_final") Date fecha_final,
			@RequestParam("servicio") Integer id_servicios, SessionStatus sessionStatus,
			@RequestParam("accion") String accion, HttpServletRequest request,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow) throws JRException, IOException {

		procesoGeneral.loggerUsr(contr, request);
		List<TBL_SIF_CAT_PROCESOS> procesos = reportesService.findAll_TBL_SIF_CAT_PROCESOS();
		model.addAttribute(proce, procesos);

		List<TBL_SIF_CAT_NEGOCIOS> negocios = reportesService.findAll_TBL_SIF_CAT_NEGOCIOS();
		model.addAttribute(nego, negocios);

		List<TBL_SIF_CAT_MONEDAS> monedas = reportesService.findAll_TBL_SIF_CAT_MONEDAS();
		model.addAttribute(mone, monedas);

		List<TBL_SIF_CAT_EMPRESAS> empresas = reportesService.findAll_TBL_SIF_CAT_EMPRESAS();
		model.addAttribute(empre, empresas);

		List<TBL_SIF_SERVICIOS> servicios = reportesService.findAll_TBL_SIF_SERVICIOS();
		model.addAttribute(serv, servicios);

		Integer id_clientes;
		String clave_cliente;
		String nombre_corto;

		if (!cliente.equals("0")) {
			String cl = cliente;

			String[] cl_temp;
			String cl_delimiter = "&&";
			cl_temp = cl.split(cl_delimiter);
			id_clientes = Integer.parseInt((String) Array.get(cl_temp, 0));
			clave_cliente = (String) Array.get(cl_temp, 1);
			nombre_corto = (String) Array.get(cl_temp, 2);
		}

		else {
			clave_cliente = "";
			id_clientes = 0;
			nombre_corto = "";
		}

		String vista = null;
		String format = "pdf";
		File img = reportesService.cargarLogo(request);

		switch (accion) {

		// JSP
		case "consultar":

			List<B_COBRANZA_DIARIA> reportes_total = reportesService.findByRows_B_COBRANZA_DIARIA_TABLA_2(id_procesos,
					id_negocios, id_servicios, id_monedas, id_empresas, id_clientes, fecha_inicial, fecha_final);
			reportesService.queryReporteConranzaDiaria(count, model, fromRow, id_procesos, id_negocios, id_servicios,
					id_monedas, id_empresas, id_clientes, fecha_inicial, fecha_final);
			reportesService.queryReporteConranzaDiaria(consulta, model, fromRow, id_procesos, id_negocios,
					id_servicios, id_monedas, id_empresas, id_clientes, fecha_inicial, fecha_final);
			model.addAttribute("reportes_total", reportes_total);

			model.addAttribute(idprocesos, id_procesos);
			model.addAttribute(idmonedas, id_monedas);
			model.addAttribute(idnegocios, id_negocios);
			model.addAttribute(idempresas, id_empresas);
			model.addAttribute(idclientes, id_clientes);
			model.addAttribute(clavecliente, clave_cliente);
			model.addAttribute(nombrecorto, nombre_corto);
			model.addAttribute("id_servicios", id_servicios);
			model.addAttribute(pFechaInicial, fecha_inicial);
			model.addAttribute(pFechaFinal, fecha_final);

			vista = "reportes/cobranzaDiaria";

			break;

		// Jasper
		case "reporte":

			List<B_REPORTE_COBRANZA> datasource = reportesService.findByRows_B_REPORTE_COBRANZA(id_procesos,
					id_negocios, id_servicios, id_monedas, id_empresas, id_clientes, fecha_inicial, fecha_final);

			reportesService.reporteCobranza(request);
			model.addAttribute(datsour, datasource);

			model.addAttribute(reportPath, img);
			model.addAttribute(fechaini, fecha_inicial);
			model.addAttribute(fechafin, fecha_final);
			model.addAttribute(formt, format);

			vista = "CobranzaDiaria_report";

			break;

		case "acumulado":

			List<B_ACUMULADO_COBRANZA> reporte = reportesService.findByRows_B_ACUMULADO_COBRANZA(id_procesos,
					id_negocios, id_servicios, id_monedas, id_empresas, id_clientes, fecha_inicial, fecha_final);
			model.addAttribute(datsour, reporte);

			reportesService.reporteCobranzaAcumulado(request);

			model.addAttribute(reportPath, img);
			model.addAttribute(fechaini, fecha_inicial);
			model.addAttribute(fechafin, fecha_final);
			model.addAttribute(formt, format);

			vista = "AcumuladoCobranza_report";

			break;
			
		default:
			break;
		}

		sessionStatus.setComplete();

		return vista;
	}

	// Reporte Servicios Cliente
	// Consultar
	@RequestMapping("/home/reportes/servicios")
	public String mostrarConsultaServiciosCliente(Model model, SessionStatus sessionStatus,
			HttpServletRequest request) {

		procesoGeneral.loggerUsr(contr, request);
		List<TBL_SIF_CAT_PROCESOS> procesos = reportesService.findAll_TBL_SIF_CAT_PROCESOS();
		model.addAttribute(proce, procesos);

		List<TBL_SIF_CAT_NEGOCIOS> negocios = reportesService.findAll_TBL_SIF_CAT_NEGOCIOS();
		model.addAttribute(nego, negocios);

		List<TBL_SIF_CAT_MONEDAS> monedas = reportesService.findAll_TBL_SIF_CAT_MONEDAS();
		model.addAttribute(mone, monedas);

		List<TBL_SIF_CAT_EMPRESAS> empresas = reportesService.findAll_TBL_SIF_CAT_EMPRESAS();
		model.addAttribute(empre, empresas);

		List<TBL_SIF_SERVICIOS> servicios = reportesService.findAll_TBL_SIF_SERVICIOS();
		model.addAttribute(serv, servicios);
		sessionStatus.setComplete();
		return "reportes/serviciosCliente";
	}

	// Mostrar Reporte Servicio Cliente
	@RequestMapping(value = "/home/reportes/servicios/find", method = RequestMethod.POST)
	public String handleConsultaReportesServicios(Model model, @RequestParam("proceso") Integer id_procesos,
			@RequestParam("negocio") Integer id_negocios, @RequestParam("moneda") Integer id_monedas,
			@RequestParam("empresa") Integer id_empresas,
			@RequestParam(name = "cliente", defaultValue = "0") String cliente,
			@RequestParam("fecha_inicial") Date fecha_inicial, @RequestParam("fecha_final") Date fecha_final,
			@RequestParam("servicio") Integer id_servicios, @RequestParam("format") String format,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow, SessionStatus sessionStatus,
			HttpServletRequest request, HttpServletResponse response) throws JRException, IOException {

		procesoGeneral.loggerUsr(contr, request);
		List<TBL_SIF_CAT_PROCESOS> procesos = reportesService.findAll_TBL_SIF_CAT_PROCESOS();
		model.addAttribute(proce, procesos);

		List<TBL_SIF_CAT_NEGOCIOS> negocios = reportesService.findAll_TBL_SIF_CAT_NEGOCIOS();
		model.addAttribute(nego, negocios);

		List<TBL_SIF_CAT_MONEDAS> monedas = reportesService.findAll_TBL_SIF_CAT_MONEDAS();
		model.addAttribute(mone, monedas);

		List<TBL_SIF_CAT_EMPRESAS> empresas = reportesService.findAll_TBL_SIF_CAT_EMPRESAS();
		model.addAttribute(empre, empresas);

		List<TBL_SIF_SERVICIOS> servicios = reportesService.findAll_TBL_SIF_SERVICIOS();
		model.addAttribute(serv, servicios);

		Integer id_clientes;
		String clave_cliente;
		String nombre_corto;

		if (!cliente.equals("0")) {
			String cl = cliente;

			String[] cl_temp;
			String cl_delimiter = "&&";
			cl_temp = cl.split(cl_delimiter);
			id_clientes = Integer.parseInt((String) Array.get(cl_temp, 0));
			clave_cliente = (String) Array.get(cl_temp, 1);
			nombre_corto = (String) Array.get(cl_temp, 2);
		}

		else {
			clave_cliente = "";
			id_clientes = 0;
			nombre_corto = "";
		}

		String vista = null;

		switch (format) {

		// JSP
		case "consultar":
			reportesService.queryReporteServiciosCliente(count, model, fromRow, id_procesos, id_negocios,
					id_servicios, id_monedas, id_empresas, id_clientes, fecha_inicial, fecha_final);
			reportesService.queryReporteServiciosCliente(consulta, model, fromRow, id_procesos, id_negocios,
					id_servicios, id_monedas, id_empresas, id_clientes, fecha_inicial, fecha_final);

			model.addAttribute(clavecliente, clave_cliente);
			model.addAttribute(nombrecorto, nombre_corto);
			model.addAttribute(idprocesos, id_procesos);
			model.addAttribute(idmonedas, id_monedas);
			model.addAttribute(idnegocios, id_negocios);
			model.addAttribute(idempresas, id_empresas);
			model.addAttribute(idclientes, id_clientes);
			model.addAttribute("id_servicios", id_servicios);
			model.addAttribute(pFechaInicial, fecha_inicial);
			model.addAttribute(pFechaFinal, fecha_final);

			vista = "reportes/serviciosCliente";

			break;

		// Jasper
		case "pdf":

			 List<B_SERVICIOS_CLIENTES_JASPER> datasource = reportesService
			 .findByRows_VIEW_REPORTE_SERVICIOS_CLIENTE_JASPER(id_procesos, id_negocios,
			 id_monedas, id_empresas,
			 id_clientes, id_servicios, fecha_inicial, fecha_final);
			
			 File img = reportesService.cargarLogo(request);
			 reportesService.reporteServiciosCliente(request);
			 model.addAttribute(fechaini, fecha_inicial);
			 model.addAttribute(fechafin, fecha_final);
			 model.addAttribute(formt, format);
			 model.addAttribute(datsour, datasource);
			 model.addAttribute(reportPath, img);
			
			 vista = "Servicios_Cliente_report";

			break;
			
		default:
			break;
		}

		sessionStatus.setComplete();

		 return vista;
	}

	// Reporte Cuentas Activas
	// Consultar
	@RequestMapping("/home/reportes/cuentas")
	public String mostrarConsultaCuentasActivas(Model model, SessionStatus sessionStatus,
			HttpServletRequest request) {

		procesoGeneral.loggerUsr(contr, request);
		List<TBL_SIF_CAT_MONEDAS> monedas = reportesService.findAll_TBL_SIF_CAT_MONEDAS();
		model.addAttribute(mone, monedas);

		List<TBL_SIF_CAT_PERIODO> periodos = reportesService.search_TBL_SIF_CAT_PERIODO();
		model.addAttribute("periodos", periodos);

		sessionStatus.setComplete();
		return "reportes/cuentasActivas";
	}

	// Mostrar Reporte Cuentas Activas
	@RequestMapping(value = "/home/reportes/cuentas/find", method = RequestMethod.POST)
	public String handleConsultaCuentasActivas(Model model, @RequestParam("moneda") Integer id_monedas,
			@RequestParam("periodo") Integer id_periodos, @RequestParam("accion") String accion,
			SessionStatus sessionStatus, HttpServletRequest request,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow) throws JRException, IOException {

		procesoGeneral.loggerUsr(contr, request);
		List<TBL_SIF_CAT_PERIODO> periodos = reportesService.search_TBL_SIF_CAT_PERIODO();
		model.addAttribute("periodos", periodos);

		List<TBL_SIF_CAT_MONEDAS> monedas = reportesService.findAll_TBL_SIF_CAT_MONEDAS();
		model.addAttribute(mone, monedas);

		String vista = null;
		String format = "pdf";
		File img = reportesService.cargarLogo(request);

		switch (accion) {

		// JSP
		case "consultar":

			reportesService.queryReporteCuentasActivas(count, model, fromRow, id_monedas, id_periodos);
			reportesService.queryReporteCuentasActivas(consulta, model, fromRow, id_monedas, id_periodos);

			model.addAttribute(idmonedas, id_monedas);

			model.addAttribute("id_periodos", id_periodos);

			vista = "reportes/cuentasActivas";

			break;

		// Jasper
		case "reporte":

			List<VIEW_REPORTE_CUENTAS_ACTIVAS> datasource = reportesService
					.findByRows_VIEW_REPORTE_CUENTAS_ACTIVAS(id_monedas, id_periodos);
			reportesService.reporteCuentasActivas(request);
			model.addAttribute(reportPath, img);
			model.addAttribute("moneda", id_monedas);
			model.addAttribute(formt, format);
			model.addAttribute(datsour, datasource);

			vista = "CuentasActivas_report";

			break;

		case "estadistico":

			List<VIEW_REPORTE_CUENTAS_ACT_2> reporte = reportesService
					.findByRows_VIEW_REPORTE_CUENTAS_ACTIVAS_2(id_periodos);
			reportesService.reporteCuentasActivas_Dos(request);
			model.addAttribute(reportPath, img);
			model.addAttribute(formt, format);
			model.addAttribute(datsour, reporte);

			vista = "CuentasActivasTrx_report";

			break;
			
		default:
			break;
		}

		sessionStatus.setComplete();

		return vista;
	}

	// Reporte ODT's
	// Consultar
	@RequestMapping("/home/reportes/odt")
	public String mostrarConsultaODT(Model model, SessionStatus sessionStatus, HttpServletRequest request) {

		procesoGeneral.loggerUsr(contr, request);
		List<TBL_SIF_CAT_MONEDAS> monedas = reportesService.findAll_TBL_SIF_CAT_MONEDAS();
		model.addAttribute(mone, monedas);
		listaGeneralService.listaClientes(model, request);
		sessionStatus.setComplete();
		return "reportes/ODT";
	}

	// Jasper
	@RequestMapping(value = "/home/reportes/odt/reporte", method = RequestMethod.POST)
	public String verReporteODT(Model model, @RequestParam("moneda") Integer id_monedas,
			@RequestParam(value = "id_cliente", defaultValue = "") String cliente,
			@RequestParam("fecha_inicial") Date fecha_inicial, @RequestParam("fecha_final") Date fecha_final,
			@RequestParam(name = "format", defaultValue = "pdf", required = false) String format,
			SessionStatus sessionStatus, HttpServletRequest request) throws JRException, IOException {

		procesoGeneral.loggerUsr(contr, request);
		
		Integer id_clientes;
		String clave_cliente;
		String nombre_corto;
		
		if (!cliente.equals("")) {
			String cl = cliente;

			String[] cl_temp;
			String cl_delimiter = "&&";
			cl_temp = cl.split(cl_delimiter);
			id_clientes = Integer.parseInt((String) Array.get(cl_temp, 0));
			clave_cliente = (String) Array.get(cl_temp, 1);
			nombre_corto = (String) Array.get(cl_temp, 2);
		}

		else {
			clave_cliente = "";
			id_clientes = 0;
			nombre_corto = "";
		}

		List<B_ODT_VIGENTE> reportes = reportesService.findByRows_B_ODT_VIGENTE(id_monedas, id_clientes, fecha_inicial,
				fecha_final);

		reportesService.reporteODT(request);
		File img = reportesService.cargarLogo(request);

		model.addAttribute(idclientes, id_clientes);
		model.addAttribute(clavecliente, clave_cliente);
		model.addAttribute(nombrecorto, nombre_corto);
		model.addAttribute(reportPath, img);
		model.addAttribute("p_fecha_ini", fecha_inicial);
		model.addAttribute("p_fecha_fin", fecha_final);
		model.addAttribute("id_moneda", id_monedas);
		model.addAttribute(formt, format);
		model.addAttribute(datsour, reportes);

		return "ODTs_vigentes_report";
	}

	// Reporte Soporte Servicios
	// Consultar
	@RequestMapping("/home/reportes/soporte")
	public String mostrarConsultaSoporteServicios(Model model, SessionStatus sessionStatus,
			HttpServletRequest request) {

		procesoGeneral.loggerUsr(contr, request);
		List<TBL_SIF_FUENTES> fuentes = reportesService.findAll_TBL_SIF_FUENTES();
		List<TBL_SIF_SERVICIOS> servicios = reportesService.findAll_TBL_SIF_SERVICIOS();

		model.addAttribute(serv, servicios);
		model.addAttribute("fuentes", fuentes);
		sessionStatus.setComplete();
		return "reportes/soporteServicios";
	}

	// Mostrar Reporte Soporte Servicios
	@RequestMapping(value = "/home/reportes/soporte/find", method = RequestMethod.POST)
	public String handleConsultaReportesSoporteServicios(Model model,
			@RequestParam(name = "cliente", defaultValue = "0") String cliente,
			@RequestParam("fecha_inicial") Date fecha_inicial, @RequestParam("fecha_final") Date fecha_final,
			@RequestParam(name = "servicio", defaultValue = "0") String clave,
			@RequestParam(name = "format", defaultValue = "") String format,
			@RequestParam(name = "fuente", defaultValue = "0") Integer id_fuentes, SessionStatus sessionStatus,
			HttpServletResponse response, HttpServletRequest request,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow) throws JRException, IOException {

		procesoGeneral.loggerUsr(contr, request);
		List<TBL_SIF_FUENTES> fuentes = reportesService.findAll_TBL_SIF_FUENTES();
		model.addAttribute("fuentes", fuentes);

		List<TBL_SIF_SERVICIOS> servicios = reportesService.findAll_TBL_SIF_SERVICIOS();
		model.addAttribute(serv, servicios);

		Integer id_clientes;
		String clave_cliente;
		String nombre_corto;

		if (!cliente.equals("0")) {
			String cl = cliente;

			String[] cl_temp;
			String cl_delimiter = "&&";
			cl_temp = cl.split(cl_delimiter);
			id_clientes = Integer.parseInt((String) Array.get(cl_temp, 0));
			clave_cliente = (String) Array.get(cl_temp, 1);
			nombre_corto = (String) Array.get(cl_temp, 2);
		}

		else {
			clave_cliente = "";
			id_clientes = 0;
			nombre_corto = "";
		}

		

		switch (format) {

		// JSP
		case "consultar":

			reportesService.queryReporteServicioCliente(count, model, fromRow, id_fuentes, clave, id_clientes,
					fecha_inicial, fecha_final);
			reportesService.queryReporteServicioCliente(consulta, model, fromRow, id_fuentes, clave, id_clientes,
					fecha_inicial, fecha_final);
			model.addAttribute(clavecliente, clave_cliente);
			model.addAttribute(nombrecorto, nombre_corto);
			model.addAttribute(idclientes, id_clientes);
			model.addAttribute("clave", clave);
			model.addAttribute("id_fuentes", id_fuentes);
			model.addAttribute(pFechaInicial, fecha_inicial);
			model.addAttribute(pFechaFinal, fecha_final);

		

			break;

		// Jasper pdf
		case "pdf":

			reportesService.jasperpdf(request, response, clave, clave_cliente, id_fuentes, fecha_inicial, fecha_final);

			break;
			
		default:
			break;
		}

		sessionStatus.setComplete();

		return "reportes/soporteServicios";
	}

}
