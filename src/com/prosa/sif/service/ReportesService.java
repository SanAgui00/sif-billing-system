/**
################################################################################
# Autor               : Valverde Méndez Arturo                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 25/04/2018 #
# Descripcion General : Serivicio para reportes Jasper 			          	   #	
# Marca del cambio    :                                                        #
#------------------------------------------------------------------------------#
# Numero de Parametros: N/A                                                    #
# Parametros Entrada  : N/A                                  Formato:          #
# Parametros Salida   : N/A                                  Formato:          #
################################################################################
**/

package com.prosa.sif.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.prosa.sif.dao.ReportesDao;
import com.prosa.sif.pojo.B_ACUMULADO_COBRANZA;
import com.prosa.sif.pojo.B_COBRANZA_DIARIA;
import com.prosa.sif.pojo.B_ODT_VIGENTE;
import com.prosa.sif.pojo.B_REPORTE_COBRANZA;
import com.prosa.sif.pojo.B_SERVICIOS_CLIENTE;
import com.prosa.sif.pojo.B_SERVICIOS_CLIENTES_JASPER;
import com.prosa.sif.pojo.B_VIEW_SIF_CONSECUTIVO_FOLIOS;
import com.prosa.sif.pojo.TBL_SIF_CAT_CLIENTES;
import com.prosa.sif.pojo.TBL_SIF_CAT_EMPRESAS;
import com.prosa.sif.pojo.TBL_SIF_CAT_MONEDAS;
import com.prosa.sif.pojo.TBL_SIF_CAT_NEGOCIOS;
import com.prosa.sif.pojo.TBL_SIF_CAT_PERIODO;
import com.prosa.sif.pojo.TBL_SIF_CAT_PROCESOS;
import com.prosa.sif.pojo.TBL_SIF_FACTURAS;
import com.prosa.sif.pojo.TBL_SIF_FUENTES;
import com.prosa.sif.pojo.TBL_SIF_SERVICIOS;
import com.prosa.sif.pojo.VIEW_REPORTE_CUENTAS_ACTIVAS;
import com.prosa.sif.pojo.VIEW_REPORTE_CUENTAS_ACT_2;
import com.prosa.sif.pojo.VIEW_REPORTE_FOLIOS;
import com.prosa.sif.pojo.VIEW_REPORTE_TESORERIA;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;

@Service
public class ReportesService {

	@Autowired
	private ReportesDao reportes_dao;

	// Consultar
	public List<TBL_SIF_FACTURAS> findAll_TBL_SIF_FACTURAS() {
		return reportes_dao.findAll_TBL_SIF_FACTURAS();
	}

	public List<TBL_SIF_CAT_PROCESOS> findAll_TBL_SIF_CAT_PROCESOS() {
		return reportes_dao.findAll_TBL_SIF_CAT_PROCESOS();
	}

	public List<TBL_SIF_CAT_NEGOCIOS> findAll_TBL_SIF_CAT_NEGOCIOS() {
		return reportes_dao.findAll_TBL_SIF_CAT_NEGOCIOS();
	}

	public List<TBL_SIF_CAT_MONEDAS> findAll_TBL_SIF_CAT_MONEDAS() {
		return reportes_dao.findAll_TBL_SIF_CAT_MONEDAS();
	}

	public List<TBL_SIF_CAT_EMPRESAS> findAll_TBL_SIF_CAT_EMPRESAS() {
		return reportes_dao.findAll_TBL_SIF_CAT_EMPRESAS();
	}

	public List<TBL_SIF_CAT_CLIENTES> search_TBL_SIF_CAT_CLIENTES(String clave) {
		return reportes_dao.search_TBL_SIF_CAT_CLIENTES(clave);
	}

	public List<TBL_SIF_CAT_PERIODO> search_TBL_SIF_CAT_PERIODO() {
		return reportes_dao.findAll_TBL_SIF_CAT_PERIODO();
	}

	public List<TBL_SIF_SERVICIOS> findAll_TBL_SIF_SERVICIOS() {
		return reportes_dao.findAll_TBL_SIF_SERVICIOS();
	}

	public List<TBL_SIF_FUENTES> findAll_TBL_SIF_FUENTES() {
		return reportes_dao.findAll_TBL_SIF_FUENTES();
	}

	// Cargar Logo
	public File cargarLogo(HttpServletRequest request) throws FileNotFoundException {
		return reportes_dao.cargarLogo(request);
	}

	// Reporte Folio

	public List<VIEW_REPORTE_FOLIOS> findByRows_VIEW_REPORTE_FOLIOS(Integer id_empresas, String serie_value,
			String documento, Integer id_monedas, Integer id_negocios, Integer id_procesos, String estatus,
			Integer id_clientes, Date fecha_inicial, Date fecha_final) {
		return reportes_dao.findByRows_VIEW_REPORTE_FOLIOS(id_empresas, serie_value, documento, id_monedas, id_negocios,
				id_procesos, estatus, id_clientes, fecha_inicial, fecha_final);
	}

	public List<B_VIEW_SIF_CONSECUTIVO_FOLIOS> findByRows_VIEW_SIF_CONSECUTIVO_FOLIOS(String clave_proceso,
			String serie_value, String documento, String nombre_moneda, String clave_negocio, String estatus,
			String clave_cliente, Date fecha_inicial, Date fecha_final) {
		return reportes_dao.findByRows_VIEW_SIF_CONSECUTIVO_FOLIOS(clave_proceso, serie_value, documento, nombre_moneda,
				clave_negocio, estatus, clave_cliente, fecha_inicial, fecha_final);
	}

	public JasperReport reporteConsecutivoFolios(HttpServletRequest request) throws JRException, IOException {
		return reportes_dao.reporteConsecutivoFolios(request);

	}

	// Reportes Tesoreria
	public List<VIEW_REPORTE_TESORERIA> findByRows_VIEW_REPORTE_TESORERIA(Integer id_procesos, Integer id_negocios,
			Integer id_monedas, Integer id_empresas, Integer id_clientes, Date fecha_inicial, Date fecha_final,
			String tipo_rep, String interfase) {
		return reportes_dao.findByRows_VIEW_REPORTE_TESORERIA(id_procesos, id_negocios, id_monedas, id_empresas,
				id_clientes, fecha_inicial, fecha_final, tipo_rep, interfase);
	}

	public JasperReport reporteTesoreria(HttpServletRequest request) throws JRException, IOException {
		return reportes_dao.reporteTesoreria(request);
	}

	// Reportes Cobranza Diaria

	

	public List<B_COBRANZA_DIARIA> findByRows_B_COBRANZA_DIARIA_TABLA_2(Integer id_procesos, Integer id_negocios,
			Integer id_servicios, Integer id_monedas, Integer id_empresas, Integer id_clientes, Date fecha_inicial,
			Date fecha_final) {
		return reportes_dao.findByRows_B_COBRANZA_DIARIA_TABLA_2(id_procesos, id_negocios, id_servicios, id_monedas,
				id_empresas, id_clientes, fecha_inicial, fecha_final);
	}

	public List<B_REPORTE_COBRANZA> findByRows_B_REPORTE_COBRANZA(Integer id_procesos, Integer id_negocios,
			Integer id_servicios, Integer id_monedas, Integer id_empresas, Integer id_clientes, Date fecha_inicial,
			Date fecha_final) {
		return reportes_dao.findByRows_B_REPORTE_COBRANZA(id_procesos, id_negocios, id_servicios, id_monedas,
				id_empresas, id_clientes, fecha_inicial, fecha_final);
	}

	public List<B_ACUMULADO_COBRANZA> findByRows_B_ACUMULADO_COBRANZA(Integer id_procesos, Integer id_negocios,
			Integer id_servicios, Integer id_monedas, Integer id_empresas, Integer id_clientes, Date fecha_inicial,
			Date fecha_final) {
		return reportes_dao.findByRows_B_ACUMULADO_COBRANZA(id_procesos, id_negocios, id_servicios, id_monedas,
				id_empresas, id_clientes, fecha_inicial, fecha_final);
	}

	public JasperReport reporteCobranza(HttpServletRequest request)
			throws JRException, FileNotFoundException, IOException {
		return reportes_dao.reporteCobranza(request);
	}

	public JasperReport reporteCobranzaAcumulado(HttpServletRequest request)
			throws JRException, FileNotFoundException, IOException {
		return reportes_dao.reporteCobranzaAcumulado(request);
	}

	// Reportes Servicios Cliente
	public List<B_SERVICIOS_CLIENTE> findByRows_VIEW_REPORTE_SERVICIOS_CLIENTE(Integer id_procesos, Integer id_negocios,
			Integer id_servicios, Integer id_monedas, Integer id_empresas, Integer id_clientes, Date fecha_inicial,
			Date fecha_final) {
		return reportes_dao.findByRows_SERVICIOS_CLIENTE(id_procesos, id_negocios, id_servicios, id_monedas,
				id_empresas, id_clientes, fecha_inicial, fecha_final);
	}

	public List<B_SERVICIOS_CLIENTES_JASPER> findByRows_VIEW_REPORTE_SERVICIOS_CLIENTE_JASPER(Integer id_procesos,
			Integer id_negocios, Integer id_monedas, Integer id_empresas, Integer id_clientes, Integer id_servicios,
			Date fecha_inicial, Date fecha_final) {
		return reportes_dao.findByRows_SERVICIOS_CLIENTE_JASPER(id_procesos, id_negocios, id_monedas, id_empresas,
				id_clientes, id_servicios, fecha_inicial, fecha_final);
	}

	public JasperReport reporteServiciosCliente(HttpServletRequest request)
			throws JRException, FileNotFoundException, IOException {
		return reportes_dao.reporteServiciosCliente(request);
	}

	// Reportes Cuentas Activas
	public List<VIEW_REPORTE_CUENTAS_ACTIVAS> findByRows_VIEW_REPORTE_CUENTAS_ACTIVAS(Integer id_monedas,
			Integer id_periodos) {
		return reportes_dao.findByRows_VIEW_REPORTE_CUENTAS_ACTIVAS(id_monedas, id_periodos);
	}

	public JasperReport reporteCuentasActivas(HttpServletRequest request)
			throws JRException, FileNotFoundException, IOException {
		return reportes_dao.reporteCuentasActivas(request);
	}

	public List<VIEW_REPORTE_CUENTAS_ACT_2> findByRows_VIEW_REPORTE_CUENTAS_ACTIVAS_2(Integer id_periodos) {
		return reportes_dao.findByRows_VIEW_REPORTE_CUENTAS_ACTIVAS_2(id_periodos);
	}

	public JasperReport reporteCuentasActivas_Dos(HttpServletRequest request)
			throws JRException, FileNotFoundException, IOException {
		return reportes_dao.reporteCuentasActivas_Dos(request);
	}

	// Reportes ODT
	public List<B_ODT_VIGENTE> findByRows_B_ODT_VIGENTE(Integer id_monedas, Integer id_clientes, Date fecha_inicial,
			Date fecha_final) {
		return reportes_dao.findByRows_B_ODT_VIGENTE(id_monedas, id_clientes, fecha_inicial, fecha_final);
	}

	public JasperReport reporteODT(HttpServletRequest request) throws JRException, FileNotFoundException, IOException {
		return reportes_dao.reporteODT(request);
	}

	// Reportes Soporte Servicios

	public void queryReporteTesosreria(String tipo, Model model, Integer fromRow, Integer id_procesos,
			Integer id_negocios, Integer id_monedas, Integer id_empresas, Integer id_clientes, Date fecha_inicial,
			Date fecha_final, String tipo_rep, String interfase) {
		reportes_dao.queryReporteTesosreria(tipo,model,fromRow,id_procesos, id_negocios, id_monedas, id_empresas,id_clientes, fecha_inicial, fecha_final, tipo_rep, interfase);
	}

	public void queryReporteServiciosCliente(String tipo, Model model, Integer fromRow, Integer id_procesos,
			Integer id_negocios, Integer id_servicios, Integer id_monedas, Integer id_empresas, Integer id_clientes,
			Date fecha_inicial, Date fecha_final) {
		reportes_dao.queryReporteServiciosCliente(tipo,model,fromRow,id_procesos,id_negocios,id_servicios,id_monedas,id_empresas,id_clientes,fecha_inicial,fecha_final);
	}

	public void queryReporteFolio(String tipo, Model model, Integer fromRow, Integer id_empresas, String serie_value,
			String documento, Integer id_monedas, Integer id_negocios, Integer id_procesos, String estatus,
			Integer id_clientes, Date fecha_inicial, Date fecha_final) {
		reportes_dao.queryReporteFolio(tipo,model,fromRow,id_empresas,serie_value,documento,id_monedas,id_negocios,id_procesos,estatus,id_clientes, fecha_inicial, fecha_final);
	}
	
	public void jasperpdf(HttpServletRequest request, HttpServletResponse response, String clave, String clave_cliente, Integer id_fuentes, Date fecha_inicial,
			Date fecha_final) {
		reportes_dao.jasperpdf( request, response,clave,  clave_cliente,  id_fuentes, fecha_inicial,
				 fecha_final);

	}

	public void queryReporteConranzaDiaria(String tipo, Model model, Integer fromRow, Integer id_procesos,
			Integer id_negocios, Integer id_servicios, Integer id_monedas, Integer id_empresas, Integer id_clientes,
			Date fecha_inicial, Date fecha_final) {
		reportes_dao.queryReporteConranzaDiaria(tipo,model,fromRow,id_procesos,id_negocios,id_servicios,id_monedas,id_empresas,id_clientes,fecha_inicial,fecha_final);
		
	}

	public void queryReporteServicioCliente(String tipo, Model model, Integer fromRow, Integer id_fuentes,
			String clave, Integer id_clientes, Date fecha_inicial, Date fecha_final) {
		reportes_dao.queryReporteServicioCliente(tipo,model,fromRow,id_fuentes,clave,id_clientes,fecha_inicial,fecha_final);
	}

	public void queryReporteCuentasActivas(String tipo, Model model, Integer fromRow, Integer id_monedas,
			Integer id_periodos) {
		reportes_dao.queryReporteCuentasActivas(tipo,model,fromRow,id_monedas,id_periodos);
		
	}

	public void jasperexcel(HttpServletRequest request, HttpServletResponse response, String clave_proceso,
			String clave_negocio, String clave_cliente, String nombre_moneda, String documento, String serie_value,
			String estatus, Date fecha_inicial, Date fecha_final, String format) {
		reportes_dao.jasperexcel(request, response, clave_proceso,
				clave_negocio, clave_cliente, nombre_moneda, documento, serie_value,
				estatus, fecha_inicial, fecha_final, format);
	}

}
