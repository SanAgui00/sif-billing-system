/**
################################################################################
# Autor               : Valverde Méndez Arturo                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 25/04/2018 #
# Descripcion General : Interfaz DAO para reportes Jasper 					   #         
# Marca del cambio    :                                                        #
#------------------------------------------------------------------------------#
# Numero de Parametros: N/A                                                    #
# Parametros Entrada  : N/A                                  Formato:          #
# Parametros Salida   : N/A                                  Formato:          #
################################################################################
**/
package com.prosa.sif.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.prosa.sif.pojo.B_ACUMULADO_COBRANZA;
import com.prosa.sif.pojo.B_COBRANZA_DIARIA;
import com.prosa.sif.pojo.B_ODT_VIGENTE;
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
import com.prosa.sif.pojo.B_REPORTE_COBRANZA;
import com.prosa.sif.pojo.VIEW_REPORTE_CUENTAS_ACTIVAS;
import com.prosa.sif.pojo.VIEW_REPORTE_CUENTAS_ACT_2;
import com.prosa.sif.pojo.VIEW_REPORTE_FOLIOS;
import com.prosa.sif.pojo.VIEW_REPORTE_TESORERIA;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;

public interface ReportesDao {

	// Consultar
	public List<TBL_SIF_FACTURAS> findAll_TBL_SIF_FACTURAS();

	public List<TBL_SIF_CAT_PROCESOS> findAll_TBL_SIF_CAT_PROCESOS();

	public List<TBL_SIF_CAT_NEGOCIOS> findAll_TBL_SIF_CAT_NEGOCIOS();

	public List<TBL_SIF_CAT_MONEDAS> findAll_TBL_SIF_CAT_MONEDAS();

	public List<TBL_SIF_CAT_EMPRESAS> findAll_TBL_SIF_CAT_EMPRESAS();

	public List<TBL_SIF_CAT_CLIENTES> search_TBL_SIF_CAT_CLIENTES(String clave);

	public List<TBL_SIF_CAT_PERIODO> findAll_TBL_SIF_CAT_PERIODO();

	public List<TBL_SIF_SERVICIOS> findAll_TBL_SIF_SERVICIOS();

	public List<TBL_SIF_FUENTES> findAll_TBL_SIF_FUENTES();

	// Cargar Imagen
	public File cargarLogo(HttpServletRequest request) throws FileNotFoundException;

	// Reportes Consecutivo de Folios
	public List<VIEW_REPORTE_FOLIOS> findByRows_VIEW_REPORTE_FOLIOS(Integer id_empresas, String serie_value,
			String documento, Integer id_monedas, Integer id_negocios, Integer id_procesos, String estatus,
			Integer id_clientes, Date fecha_inicial, Date fecha_final);

	public List<B_VIEW_SIF_CONSECUTIVO_FOLIOS> findByRows_VIEW_SIF_CONSECUTIVO_FOLIOS(String clave_proceso,
			String serie_value, String documento, String nombre_moneda, String clave_negocio, String estatus,
			String clave_cliente, Date fecha_inicial, Date fecha_final);

	public JasperReport reporteConsecutivoFolios(HttpServletRequest request)
			throws JRException, FileNotFoundException, IOException;

	// Reportes Tesoreria

	public List<VIEW_REPORTE_TESORERIA> findByRows_VIEW_REPORTE_TESORERIA(Integer id_procesos, Integer id_negocios,
			Integer id_monedas, Integer id_empresas, Integer id_clientes, Date fecha_inicial, Date fecha_final,
			String tipo_rep, String interfase);

	public JasperReport reporteTesoreria(HttpServletRequest request)
			throws JRException, FileNotFoundException, IOException;

	// Reportes Cobranza Diaria

	
	public List<B_COBRANZA_DIARIA> findByRows_B_COBRANZA_DIARIA_TABLA_2(Integer id_procesos, Integer id_negocios,
			Integer id_servicios, Integer id_monedas, Integer id_empresas, Integer id_clientes, Date fecha_inicial,
			Date fecha_final);

	public List<B_REPORTE_COBRANZA> findByRows_B_REPORTE_COBRANZA(Integer id_procesos, Integer id_negocios,
			Integer id_servicios, Integer id_monedas, Integer id_empresas, Integer id_clientes, Date fecha_inicial,
			Date fecha_final);

	public List<B_ACUMULADO_COBRANZA> findByRows_B_ACUMULADO_COBRANZA(Integer id_procesos, Integer id_negocios,
			Integer id_servicios, Integer id_monedas, Integer id_empresas, Integer id_clientes, Date fecha_inicial,
			Date fecha_final);

	public JasperReport reporteCobranza(HttpServletRequest request)
			throws JRException, FileNotFoundException, IOException;

	public JasperReport reporteCobranzaAcumulado(HttpServletRequest request)
			throws JRException, FileNotFoundException, IOException;

	// Reportes Servicios Cliente
	public List<B_SERVICIOS_CLIENTE> findByRows_SERVICIOS_CLIENTE(Integer id_procesos, Integer id_negocios,
			Integer id_servicios, Integer id_monedas, Integer id_empresas, Integer id_clientes, Date fecha_inicial,
			Date fecha_final);

	public JasperReport reporteServiciosCliente(HttpServletRequest request)
			throws JRException, FileNotFoundException, IOException;

	public List<B_SERVICIOS_CLIENTES_JASPER> findByRows_SERVICIOS_CLIENTE_JASPER(Integer id_procesos,
			Integer id_negocios, Integer id_monedas, Integer id_empresas, Integer id_clientes, Integer id_servicios,
			Date fecha_inicial, Date fecha_final);

	// Reportes Cuentas Activas
	public List<VIEW_REPORTE_CUENTAS_ACTIVAS> findByRows_VIEW_REPORTE_CUENTAS_ACTIVAS(Integer id_monedas,
			Integer id_periodos);

	public JasperReport reporteCuentasActivas(HttpServletRequest request)
			throws JRException, FileNotFoundException, IOException;

	public List<VIEW_REPORTE_CUENTAS_ACT_2> findByRows_VIEW_REPORTE_CUENTAS_ACTIVAS_2(Integer id_periodos);

	public JasperReport reporteCuentasActivas_Dos(HttpServletRequest request)
			throws JRException, FileNotFoundException, IOException;

	// Reportes ODT
	public List<B_ODT_VIGENTE> findByRows_B_ODT_VIGENTE(Integer id_monedas, Integer id_clientes, Date fecha_inicial,
			Date fecha_final);

	public JasperReport reporteODT(HttpServletRequest request) throws JRException, FileNotFoundException, IOException;

	// Reportes Soporte Servicios
	

	public void queryReporteTesosreria(String tipo, Model model, Integer fromRow, Integer id_procesos,
			Integer id_negocios, Integer id_monedas, Integer id_empresas, Integer id_clientes, Date fecha_inicial,
			Date fecha_final, String tipo_rep, String interfase);

	public void queryReporteServiciosCliente(String tipo, Model model, Integer fromRow, Integer id_procesos,
			Integer id_negocios, Integer id_servicios, Integer id_monedas, Integer id_empresas, Integer id_clientes,
			Date fecha_inicial, Date fecha_final);

	public void queryReporteFolio(String tipo, Model model, Integer fromRow, Integer id_empresas, String serie_value,
			String documento, Integer id_monedas, Integer id_negocios, Integer id_procesos, String estatus,
			Integer id_clientes, Date fecha_inicial, Date fecha_final);

	public void jasperpdf(HttpServletRequest request, HttpServletResponse response, String clave, String clave_cliente, Integer id_fuentes, Date fecha_inicial,
			Date fecha_final);

	public void queryReporteConranzaDiaria(String tipo, Model model, Integer fromRow, Integer id_procesos,
			Integer id_negocios, Integer id_servicios, Integer id_monedas, Integer id_empresas, Integer id_clientes,
			Date fecha_inicial, Date fecha_final);

	public void queryReporteServicioCliente(String tipo, Model model, Integer fromRow, Integer id_fuentes, String clave,
			Integer id_clientes, Date fecha_inicial, Date fecha_final);

	public void queryReporteCuentasActivas(String tipo, Model model, Integer fromRow, Integer id_monedas,
			Integer id_periodos);

	public void jasperexcel(HttpServletRequest request, HttpServletResponse response, String clave_proceso,
			String clave_negocio, String clave_cliente, String nombre_moneda, String documento, String serie_value,
			String estatus, Date fecha_inicial, Date fecha_final, String format);


}
