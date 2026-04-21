/**
################################################################################
# Autor               : Valverde Méndez Arturo                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 25/04/2018 #
# Descripcion General : DAO para reportes Jasper 					           #
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.prosa.sif.operation.ProcesoGeneral;
import com.prosa.sif.pojo.B_ACUMULADO_COBRANZA;
import com.prosa.sif.pojo.B_COBRANZA_DIARIA;
import com.prosa.sif.pojo.B_ODT_VIGENTE;
import com.prosa.sif.pojo.B_REPORTE_COBRANZA;
import com.prosa.sif.pojo.B_SERVICIOS_CLIENTE;
import com.prosa.sif.pojo.B_SERVICIOS_CLIENTES_JASPER;
import com.prosa.sif.pojo.B_SOPORTE_SERVICIOS;
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
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRSaver;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

@Transactional
@Repository
@SuppressWarnings("all")
public class ReportesDaoImpl implements ReportesDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private ProcesoGeneral procesoGeneral;
	
	private static JasperDesign jasperDesign = null;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	// Consultar Todos
	@SuppressWarnings("unchecked")
	@Override
	public List<TBL_SIF_FACTURAS> findAll_TBL_SIF_FACTURAS() {
		Criteria cr = getSession().createCriteria(TBL_SIF_FACTURAS.class);
		return cr.list();
	}

	// findAll Procesos
	@SuppressWarnings("unchecked")
	@Override
	public List<TBL_SIF_CAT_PROCESOS> findAll_TBL_SIF_CAT_PROCESOS() {
		Criteria cr = getSession().createCriteria(TBL_SIF_CAT_PROCESOS.class).add(Restrictions.eq("estatus", "ACT"));
		cr.addOrder(Order.asc("clave_proceso"));
		return cr.list();
	}

	// findAll Negocios
	@SuppressWarnings("unchecked")
	@Override
	public List<TBL_SIF_CAT_NEGOCIOS> findAll_TBL_SIF_CAT_NEGOCIOS() {
		Criteria cr = getSession().createCriteria(TBL_SIF_CAT_NEGOCIOS.class).add(Restrictions.eq("status", "ACT"));
		cr.addOrder(Order.asc("clave"));
		return cr.list();
	}

	// findAll Monedas
	@SuppressWarnings("unchecked")
	@Override
	public List<TBL_SIF_CAT_MONEDAS> findAll_TBL_SIF_CAT_MONEDAS() {
		Criteria cr = getSession().createCriteria(TBL_SIF_CAT_MONEDAS.class).add(Restrictions.eq("estatus", "ACT"));
		cr.addOrder(Order.asc("nombre_moneda"));
		return cr.list();
	}

	// findAll Empresas
	@SuppressWarnings("unchecked")
	@Override
	public List<TBL_SIF_CAT_EMPRESAS> findAll_TBL_SIF_CAT_EMPRESAS() {
		Criteria cr = getSession().createCriteria(TBL_SIF_CAT_EMPRESAS.class).add(Restrictions.eq("estatus", "ACT"));
		cr.addOrder(Order.asc("clave_empresa"));
		return cr.list();
	}

	// findAll Clientes
	@SuppressWarnings("unchecked")
	@Override
	public List<TBL_SIF_CAT_CLIENTES> search_TBL_SIF_CAT_CLIENTES(String clave) {

		Criteria crit = getSession().createCriteria(TBL_SIF_CAT_CLIENTES.class);
		Criterion crit1 = Restrictions.like("clave_cliente", "%" + clave + "%");
		Criterion crit2 = Restrictions.like("nombre_corto", "%" + clave + "%");
		crit.add(Restrictions.or(crit1, crit2)).setMaxResults(20).addOrder(Order.asc("clave_cliente"));
		return crit.list();
	}

	// findAll Periodos
	@SuppressWarnings("unchecked")
	@Override
	public List<TBL_SIF_CAT_PERIODO> findAll_TBL_SIF_CAT_PERIODO() {

		Criteria cr = getSession().createCriteria(TBL_SIF_CAT_PERIODO.class).add(Restrictions.eq("estatus", "ACT"));
		cr.addOrder(Order.desc("id_periodos"));
		return cr.list();
	}

	// findAll Servicios
	@SuppressWarnings("unchecked")
	@Override
	public List<TBL_SIF_SERVICIOS> findAll_TBL_SIF_SERVICIOS() {
		Criteria cr = getSession().createCriteria(TBL_SIF_SERVICIOS.class).add(Restrictions.eq("estatus", "ACT"));
		cr.addOrder(Order.asc("clave"));
		return cr.list();
	}

	// findAll Fuentes
	@SuppressWarnings("unchecked")
	@Override
	public List<TBL_SIF_FUENTES> findAll_TBL_SIF_FUENTES() {
		Criteria cr = getSession().createCriteria(TBL_SIF_FUENTES.class).add(Restrictions.and(Restrictions.eq("estatus", "ACT"),
				Restrictions.ne("id_fuente", 7)));
		return cr.list();
	}

	// findLogo
	@Override
	public File cargarLogo(HttpServletRequest request) throws FileNotFoundException {
		String in = request.getSession().getServletContext().getRealPath("/imagenes/slash.jpg");
		File logo = new File(in);

		return logo;
	}

	// Reporte Consecutivo Folios
	// findbyRowsConsecutivodeFolios
	@SuppressWarnings("unchecked")
	@Override
	public List<VIEW_REPORTE_FOLIOS> findByRows_VIEW_REPORTE_FOLIOS(Integer id_empresas, String serie_value,
			String documento, Integer id_monedas, Integer id_negocios, Integer id_procesos, String estatus,
			Integer id_clientes, Date fecha_inicial, Date fecha_final) {

		Criteria crit = getSession().createCriteria(VIEW_REPORTE_FOLIOS.class)
				.add(Restrictions.and(Restrictions.eq("id_empresa", id_empresas), Restrictions.eq("serie", serie_value),
						Restrictions.eq("clave_documento", documento),
						Restrictions.between("fecha_datos", fecha_inicial, fecha_final)));

		if (!(id_negocios == 0)) {
			crit.add(Restrictions.eq("id_negocio", id_negocios));
		}
		if (!(id_procesos == 0)) {
			crit.add(Restrictions.eq("id_proceso", id_procesos));
		}
		if (!(id_monedas == 0)) {
			crit.add(Restrictions.eq("id_moneda", id_monedas));
		}
		if (!(id_clientes == 0)) {
			crit.add(Restrictions.eq("id_cliente", id_clientes));
		}
		if (!estatus.equals("null")) {
			crit.add(Restrictions.eq("estatus", estatus));
		}

		crit.addOrder(Order.asc("numero"));

		return crit.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<B_VIEW_SIF_CONSECUTIVO_FOLIOS> findByRows_VIEW_SIF_CONSECUTIVO_FOLIOS(String clave_proceso,
			String serie_value, String documento, String nombre_moneda, String clave_negocio, String estatus,
			String clave_cliente, Date fecha_inicial, Date fecha_final) {

		String str = "SELECT " + " FOLIO_IMPRESO as FOLIO_IMPRESO," + " FOLIO_INTERNO as FOLIO_INTERNO,"
				+ " DECODE(TIPO_DOCUMENTO,'SER','FACTURA DE SERVICIOS',"
				+ " 'ABI','FACTURA ABIERTA','NOT','NOTA DE CREDITO','OTRO DOCUMENTO') as TIPO_DOCUMENTO,"
				+ " CLAVE_PROCESO as CLAVE_PROCESO, " + " DESC_PROCESO as DESC_PROCESO,"
				+ " CLAVE_NEGOCIO as CLAVE_NEGOCIO," + " DESC_NEGOCIO as DESC_NEGOCIO," + " RFC as RFC,"
				+ " CLAVE_CLIENTE as CLAVE_CLIENTE," + " RAZON_SOCIAL as RAZON_SOCIAL,"
				+ " NOMBRE_CORTO as NOMBRE_CORTO," + " DOMICILIO as DOMICILIO," + " CANTIDAD as CANTIDAD,"
				+ " CONCEPTO as CONCEPTO," + " NOMBRE_MONEDA as NOMBRE_MONEDA," + " PRECIO_UNITARIO as PRECIO_UNITARIO,"
				+ " SUBTOTAL as SUBTOTAL," + " SUBTOTAL_DESC as SUBTOTAL_DESC," + " IVA as IVA," + " TOTAL as TOTAL,"
				+ " TIPO_CAMBIO as TIPO_CAMBIO," + " FECHA_RESERVACION as FECHA_RESERVACION,"
				+ " FECHA_IMPRESION as FECHA_IMPRESION," + " FECHA_COBRO as FECHA_COBRO, " + " ESTATUS as ESTATUS,"
				+ " REFERENCIA as REFERENCIA," + " COMENTARIOS as COMENTARIOS," + " FECHA_FACTURA as FECHA_FACTURA,"
				+ " ID_GENERADO_GL as ID_GENERADO_GL," + " CUENTA_CLIENTE as CUENTA_CLIENTE,"
				+ " ESTATUS_COBRO as ESTATUS_COBRO," + " CLAVE_CATEGORIA_INGRESO as CLAVE_CATEGORIA_INGRESO,"
				+ " CUENTA_INGRESO as CUENTA_INGRESO," + " CENTRO_COSTOS as CENTRO_COSTOS,"
				+ " CLAVE_SERVICIO_PARTICULAR as CLAVE_SERVICIO_PARTICULAR, " + " CLAVE_SERVICIO as CLAVE_SERVICIO,"
				+ " TEMPORAL as TEMPORAL" + "		from VIEW_SIF_CONSECUTIVO_FOLIOS"
				+ "		WHERE fecha_factura BETWEEN TO_DATE('" + fecha_inicial.toString()
				+ "','yyyy/mm/dd') and TO_DATE('" + fecha_final.toString() + "', 'yyyy/mm/dd')";

		if (!(clave_proceso.equals("null"))) {
			str = str.concat(" AND clave_proceso= '" + clave_proceso + "'");
		}
		if (!(clave_negocio.equals("null"))) {
			str = str.concat(" AND clave_negocio= '" + clave_negocio + "'");
		}
		if (!(clave_cliente.equals(""))) {
			str = str.concat(" AND clave_cliente= '" + clave_cliente + "'");
		}
		if (!(nombre_moneda.equals("null"))) {
			str = str.concat(" AND nombre_moneda= '" + nombre_moneda + "'");
		}
		if (!(documento.equals("null"))) {
			str = str.concat(" AND decode(tipo_documento,'ODT','ABI',tipo_documento) = " + "nvl(trim('" + documento
					+ "'),decode(tipo_documento,'ODT','ABI',tipo_documento))");
		}
		if (!(serie_value.equals("null"))) {
			str = str.concat(" AND serie='" + serie_value + "'");
		}
		if (!(estatus.equals("null"))) {
			str = str.concat(" AND estatus= '" + estatus + "'");
		}

		str = str.concat(" ORDER BY 1");

		Query qr = getSession().createSQLQuery(str)
				.setResultTransformer(Transformers.aliasToBean(B_VIEW_SIF_CONSECUTIVO_FOLIOS.class));

		return qr.list();

	}

	// Jasper
	@Override
	public JasperReport reporteConsecutivoFolios(HttpServletRequest request)
			throws JRException, FileNotFoundException, IOException {

		String in = request.getSession().getServletContext().getRealPath("/jasper/repConsecutivoFolios_report.jrxml");
		String out = request.getSession().getServletContext().getRealPath("/jasper");
		
		jasperDesign = JRXmlLoader.load(in);
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
		JRSaver.saveObject(jasperReport, "/" + out + "/repConsecutivoFolios_report.jasper");

		return jasperReport;
	}

	// Reporte Tesoreria
	// findbyRowsTesoreria
	@SuppressWarnings("unchecked")
	@Override
	public List<VIEW_REPORTE_TESORERIA> findByRows_VIEW_REPORTE_TESORERIA(Integer id_procesos, Integer id_negocios,
			Integer id_monedas, Integer id_empresas, Integer id_clientes, Date fecha_inicial, Date fecha_final,
			String tipo_rep, String interfase) {

		Criteria crit = getSession().createCriteria(VIEW_REPORTE_TESORERIA.class)
				.add(Restrictions.and(Restrictions.between("fecha_cobro", fecha_inicial, fecha_final)));

		if (id_procesos != 0) {
			crit.add(Restrictions.eq("id_proceso", id_procesos));
		}

		if (id_negocios != 0) {
			crit.add(Restrictions.eq("id_negocio", id_negocios));
		}
		if (id_monedas != 0) {
			crit.add(Restrictions.eq("id_moneda", id_monedas));
		}
		if (id_clientes != 0) {
			crit.add(Restrictions.eq("id_cliente", id_clientes));
		}
		if (id_empresas != 0) {
			crit.add(Restrictions.eq("id_empresa", id_empresas));
		}
		if (!interfase.equals("null")) {
			crit.add(Restrictions.eq("interfase", interfase));
		}
		if (!tipo_rep.equals("null")) {
			if (tipo_rep.equals("IF")) {
				crit.addOrder(Order.asc("nombre_corto")).addOrder(Order.asc("sistema_cobro"))
						.addOrder(Order.asc("folio_temporal"));
			} else if (tipo_rep.equals("GE")) {
				crit.addOrder(Order.asc("nombre_corto")).addOrder(Order.asc("sistema_cobro"))
						.addOrder(Order.asc("folio_temporal"));
			} else {
				crit.addOrder(Order.asc("sistema_cobro")).addOrder(Order.asc("nombre_corto"))
						.addOrder(Order.asc("folio_temporal"));
			}
		}

		return crit.list();
	}

	// Jasper
	@Override
	public JasperReport reporteTesoreria(HttpServletRequest request)
			throws JRException, FileNotFoundException, IOException {

		String in = request.getSession().getServletContext().getRealPath("/jasper/Tesoreria_report.jrxml");
		String out = request.getSession().getServletContext().getRealPath("/jasper");
		
		jasperDesign = JRXmlLoader.load(in);
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
		JRSaver.saveObject(jasperReport, "/" + out + "/Tesoreria_report.jasper");

		return jasperReport;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<B_COBRANZA_DIARIA> findByRows_B_COBRANZA_DIARIA_TABLA_2(Integer id_procesos, Integer id_negocios,
			Integer id_servicios, Integer id_monedas, Integer id_empresas, Integer id_clientes, Date fecha_inicial,
			Date fecha_final) {

		String str = "SELECT " + " clave_negocio as clave_negocio," + " descripcion_negocio as descripcion_negocio,"
				+ " sum(trx_cobdia) as total_trx_cobdia," + " sum(imp_cobdia) as total_imp_cobdia,"
				+ " sum(total_ajuste) as total_imp_ajuste,"
				+ " (sum(desc_cobdia)+sum(desc_ajuste)) as total_desc_especial,"
				+ " sum(desc_adicional) as total_desc_adicional" + " FROM V_SIF_COBRANZA_DIARIA  " + " WHERE "
				+ " id_moneda =" + id_monedas + " AND fecha_datos BETWEEN to_char(TO_DATE('" + fecha_inicial
				+ "','YYYY/MM/DD'),'dd/mm/rr') and to_char(TO_DATE('" + fecha_final + "', 'YYYY/MM/DD'),'dd/mm/rr')";

		if (id_procesos != 0) {
			str = str.concat(" AND id_proceso=" + id_procesos);
		}
		if (id_negocios != 0) {
			str = str.concat(" AND id_negocio=" + id_negocios);
		}
		if (id_servicios != 0) {
			str = str.concat(" AND id_servicios=" + id_servicios);
		}
		if (id_clientes != 0) {
			str = str.concat(" AND id_cliente=" + id_clientes);
		}
		if (id_empresas != 0) {
			str = str.concat(" AND id_empresa=" + id_empresas);
		}

		str = str.concat(
				" GROUP BY" + " descripcion_negocio," + " clave_negocio," + " id_negocio" + " ORDER BY clave_negocio");

		Query qr = getSession().createSQLQuery(str)
				.setResultTransformer(Transformers.aliasToBean(B_COBRANZA_DIARIA.class));

		return qr.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<B_REPORTE_COBRANZA> findByRows_B_REPORTE_COBRANZA(Integer id_procesos, Integer id_negocios,
			Integer id_servicios, Integer id_monedas, Integer id_empresas, Integer id_clientes, Date fecha_inicial,
			Date fecha_final) {

		String str = " select " + " v.ID_EMPRESA, " + " v.CLAVE_EMPRESA  , " + " v.RAZON_SOCIAL  , "
				+ " v.ID_PROCESO  , " + " v.CLAVE_PROCESO  , " + " v.DESC_PROCESO, " + " v.ID_MONEDA, "
				+ " v.NOMBRE_MONEDA, " + " v.ID_NEGOCIO, " + " v.CLAVE_NEGOCIO, " + " v.DESCRIPCION_NEGOCIO, "
				+ " v.ID_SERVICIOS, " + " v.CLAVE_SERVICIO, " + " v.DESCRIPCION_SERVICIO, " + " v.ID_CLIENTE, "
				+ " v.CLAVE_CLIENTE, " + " v.NOMBRE_CLIENTE, " + " v.FECHA_DATOS, " + " v.TRX_COBDIA, " + " v.PRECIO, "
				+ " v.TIPO_CAMBIO, " + " v.IMP_COBDIA," + " v.DESC_COBDIA, " + " v.DESC_ADICIONAL,"
				+ " v.SUBTOTAL_COBDIA, " + " v.IVA_COBDIA, " + " v.TOTAL_COBDIA, " + " v.AJUSTE, " + " v.DESC_AJUSTE, "
				+ " v.SUBTOTAL_AJUSTE, " + " v.IVA_AJUSTE, " + " v.TOTAL_AJUSTE," + " v.IVA_COBDIA+IVA_AJUSTE IVA,"
				+ " v.TOTAL_COBDIA+TOTAL_AJUSTE TOTAL," + " ts.TIPO_SERVICIO" + " from v_sif_cobranza_diaria v,"
				+ " tbl_sif_servicios ts" + " where" + " ts.ID_SERVICIOS = v.ID_SERVICIOS and" + " v.id_moneda ="
				+ id_monedas + " and FECHA_DATOS between" + " TO_DATE('" + fecha_inicial
				+ "','YYYY/MM/DD') and TO_DATE('" + fecha_final + "','YYYY/MM/DD')";

		if (id_procesos != 0) {
			str = str.concat(" AND v.id_proceso=" + id_procesos);
		}
		if (id_negocios != 0) {
			str = str.concat(" AND v.id_negocio=" + id_negocios);
		}
		if (id_servicios != 0) {
			str = str.concat(" AND v.id_servicios=" + id_servicios);
		}
		if (id_clientes != 0) {
			str = str.concat(" AND v.id_cliente=" + id_clientes);
		}
		if (id_empresas != 0) {
			str = str.concat(" AND v.id_empresa=" + id_empresas);
		}

		str = str.concat(" Order by id_negocio,fecha_datos,clave_servicio,clave_cliente");

		Query qr = getSession().createSQLQuery(str)
				.setResultTransformer(Transformers.aliasToBean(B_REPORTE_COBRANZA.class));

		return qr.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<B_ACUMULADO_COBRANZA> findByRows_B_ACUMULADO_COBRANZA(Integer id_procesos, Integer id_negocios,
			Integer id_servicios, Integer id_monedas, Integer id_empresas, Integer id_clientes, Date fecha_inicial,
			Date fecha_final) {

		String str = "SELECT" + " v.ID_NEGOCIO as ID_NEGOCIO," + " v.CLAVE_NEGOCIO as CLAVE_NEGOCIO,"
				+ " v.DESCRIPCION_NEGOCIO as DESCRIPCION_NEGOCIO," + " v.ID_CLIENTE as ID_CLIENTE,"
				+ " v.CLAVE_CLIENTE as CLAVE_CLIENTE," + " v.NOMBRE_CLIENTE as NOMBRE_CLIENTE,"
				+ " sum(decode(ts.tipo_servicio,'PAGO',v.trx_cobdia*-1,v.trx_cobdia)) as TRX_COBDIA,"
				+ " sum(imp_cobdia) as IMP_COBDIA," + " sum(desc_cobdia) as DESC_COBDIA,"
				+ " sum(desc_adicional) as DESC_ADICIONAL," + " sum(subtotal_cobdia) as SUBTOTAL_COBDIA,"
				+ " sum(iva_cobdia) as IVA_COBDIA," + " sum(total_cobdia) as TOTAL_COBDIA," + " sum(ajuste) as AJUSTE,"
				+ " sum(desc_ajuste) as DESC_AJUSTE," + " sum(subtotal_ajuste) as SUBTOTAL_AJUSTE,"
				+ " sum(iva_ajuste) as IVA_AJUSTE, " + " sum(total_ajuste) as TOTAL_AJUSTE,"
				+ " sum(iva_cobdia+iva_ajuste) as IVA," + " sum(total_cobdia+total_ajuste) as TOTAL"
				+ " from V_SIF_COBRANZA_DIARIA v,TBL_SIF_SERVICIOS ts" + " where ts.id_servicios = v.id_servicios"
				+ " AND v.fecha_datos BETWEEN TO_DATE('" + fecha_inicial + "','YYYY/MM/DD') " + " AND TO_DATE('"
				+ fecha_final + "','YYYY/MM/DD')" + " AND v.id_moneda =" + id_monedas;

		if (id_procesos != 0) {
			str = str.concat(" AND v.id_proceso=" + id_procesos);
		}
		if (id_negocios != 0) {
			str = str.concat(" AND v.id_negocio=" + id_negocios);
		}
		if (id_servicios != 0) {
			str = str.concat(" AND v.id_servicios=" + id_servicios);
		}
		if (id_clientes != 0) {
			str = str.concat(" AND v.id_cliente=" + id_clientes);
		}
		if (id_empresas != 0) {
			str = str.concat(" AND v.id_empresa=" + id_empresas);
		}

		str = str.concat("GROUP BY" + " v.id_negocio," + " v.clave_negocio," + " v.descripcion_negocio,"
				+ " v.id_cliente," + " v.clave_cliente," + " v.nombre_cliente");

		Query qr = getSession().createSQLQuery(str)
				.setResultTransformer(Transformers.aliasToBean(B_ACUMULADO_COBRANZA.class));

		return qr.list();
	}

	// Jasper
	@Override
	public JasperReport reporteCobranzaAcumulado(HttpServletRequest request)
			throws JRException, FileNotFoundException, IOException {

		String in = request.getSession().getServletContext().getRealPath("/jasper/AcumuladoCobranza_report.jrxml");
		String out = request.getSession().getServletContext().getRealPath("/jasper");
		
		jasperDesign = JRXmlLoader.load(in);
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
		JRSaver.saveObject(jasperReport, "/" + out + "/AcumuladoCobranza_report.jasper");
		return jasperReport;
	}

	@Override
	public JasperReport reporteCobranza(HttpServletRequest request)
			throws JRException, FileNotFoundException, IOException {

		String in = request.getSession().getServletContext().getRealPath("/jasper/CobranzaDiaria_report.jrxml");
		String out = request.getSession().getServletContext().getRealPath("/jasper");
		
		jasperDesign = JRXmlLoader.load(in);
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
		JRSaver.saveObject(jasperReport, "/" + out + "/CobranzaDiaria_report.jasper");
		return jasperReport;
	}

	// Reporte Servicios Cliente
	// findbyRowsServiciosCliente
	@SuppressWarnings("unchecked")
	@Override
	public List<B_SERVICIOS_CLIENTE> findByRows_SERVICIOS_CLIENTE(Integer id_procesos, Integer id_negocios,
			Integer id_servicios, Integer id_monedas, Integer id_empresas, Integer id_clientes, Date fecha_inicial,
			Date fecha_final) {

		String str = " SELECT" + " m.nombre_moneda as NOMBRE_MONEDA," + " sv.id_negocio as ID_NEGOCIO,"
				+ " ng.clave as CLAVE_NEGOCIO," + " sf.id_cliente as ID_CLIENTE,"
				+ " cl.clave_cliente as CLAVE_CLIENTE," + " cl.nombre_corto as NOMBRECORTO,"
				+ " gcs.id_grupo as ID_GRUPO," + " gcs.descripcion as DESCRIPCION_GRUPO,"
				+ " sv.clave as CLAVE_SERVICIO," + " sv.descripcion as DESCRIPCION_SERVICIO,"
				+ " DECODE(sv.tipo_cargo,'EMISOR',"
				+ " NVL(sf.total_trans_emisor,0),NVL(sf.total_trans_adquirente,0)) as TRANSACCIONES,"
				+ " NVL(sf.precio_aplicado,0)* pk_sif_tipos_cambio.obt_tc_a_aplicar(sf.id_servicio,"
				+ " sf.id_cliente,to_date('" + fecha_final + "','yyyy/mm/dd')) as PRECIO,"
				+ " Sum(NVL(f.costo_servicio,0)+Nvl(f.descuento,0)) as IMPORTE_COBRANZA,"
				+ " Round(NVL ( sf.calculo_ajuste_neto, 0)/(1-(nvl(sc.porcentaje_descuento,0)/100)),2) as IMPORTE_AJUSTE,"
				+ " decode(nvl(sf.total_descuento,0),0,0,sf.total_descuento) as DESCUENTO,"
				+ " Decode(r.estatus,'APL',decode(nvl(sf.total_rebate,0),0,0,sf.total_rebate),0) as DESCUENTO_ADICIONAL,"
				+ " NVL (sf.total_costo_servicio, 0) -"
				+ " Decode(r.estatus,'APL',decode(nvl(sf.total_rebate,0),0,0,sf.total_rebate),0) as TOTAL_IMPORTE_REAL  "
				+ " FROM " + " tbl_sif_servicios_clientes sc," + " tbl_sif_resu_perio_serv_cli sf,"
				+ " tbl_sif_servicios_facturar f," + " tbl_sif_servicios sv," + " tbl_sif_cat_clientes cl,"
				+ " tbl_sif_cat_negocios ng," + " tbl_sif_cat_empresas em," + " tbl_sif_cat_procesos pr,"
				+ " tbl_sif_cat_gpo_ccpt_serv gcs," + " tbl_sif_cat_monedas m," + " tbl_sif_cat_dias_periodo p,"
				+ " tbl_sif_rebate r," + " tbl_sif_folios fol," + " tbl_sif_facturas fs"
				+ " WHERE sf.id_periodo = p.id_periodo AND p.fecha_referencia = f.fecha_datos "
				+ " AND sf.id_servicio = f.id_servicio  AND pr.ID_PROCESO=" + id_procesos
				+ " AND sf.id_cliente = f.id_cliente AND sf.id_moneda = f.id_moneda "
				+ " AND sf.id_moneda = f.id_moneda And f.id_factura = fs.id_factura(+)"
				+ " And fs.id_factura = fol.id_documento(+) AND sf.id_servicio = sc.id_servicio "
				+ " AND sf.id_cliente = sc.id_cliente AND sf.id_servicio = sv.id_servicios"
				+ " AND sf.id_cliente = cl.id_cliente AND sv.id_negocio = ng.id_negocio "
				+ " AND em.id_empresa = pr.id_empresa AND ng.id_proceso = pr.id_proceso "
				+ " AND gcs.id_grupo(+) =  sv.id_grupo_concepto AND sf.id_moneda =  m.id_moneda "
				+ " AND sf.id_periodo = r.id_periodo(+) AND sf.id_moneda = r.id_moneda(+) "
				+ " AND f.fecha_datos between to_date('" + fecha_inicial + "','yyyy/mm/dd') " + "and to_date('"
				+ fecha_final + "','yyyy/mm/dd')" + " AND em.id_empresa = " + id_empresas + " AND sf.id_moneda ="
				+ id_monedas + " And fol.estatus(+) != 'CAN' And fol.clave_documento(+) = 'SER' "
				+ " AND NVL (sf.total_costo_servicio, 0) - "
				+ " Decode(r.estatus,'APL',decode(nvl(sf.total_rebate,0),0,0,sf.total_rebate),0) != 0 "
				+ " AND sc.estatus= 'ACT' AND f.estatus != 'ELI' AND f.estatus_calculo = 'CAL'";

		if (id_negocios != 0) {
			str = str.concat(" AND sv.id_negocio=" + id_negocios);
		}
		if (id_servicios != 0) {
			str = str.concat(" AND sv.id_servicio=" + id_servicios);
		}
		if (id_clientes != 0) {
			str = str.concat(" AND sf.id_cliente=" + id_clientes);
		}

		str = str.concat(" GROUP BY  m.nombre_moneda,sv.id_negocio,ng.clave,sf.id_cliente,"
				+ " cl.clave_cliente,cl.nombre_corto,gcs.id_grupo,gcs.descripcion,sv.clave," + " sv.descripcion,"
				+ " DECODE(sv.tipo_cargo,'EMISOR',NVL(sf.total_trans_emisor,0),NVL(sf.total_trans_adquirente,0)), "
				+ " NVL(sf.precio_aplicado,0)* pk_sif_tipos_cambio.obt_tc_a_aplicar(sf.id_servicio,sf.id_cliente,to_date('"
				+ fecha_final + "','yyyy/mm/dd'))," + " NVL(sf.calculo_ajuste_neto,0),nvl(sc.porcentaje_descuento,0),"
				+ " decode(nvl(sf.total_descuento,0),0,0,sf.total_descuento),"
				+ " Decode(r.estatus,'APL',decode(nvl(sf.total_rebate,0),0,0,sf.total_rebate),0),"
				+ " NVL (sf.total_costo_servicio, 0) - Decode(r.estatus,'APL',decode(nvl(sf.total_rebate,0),0,0,sf.total_rebate),0)"
				+ " ORDER BY gcs.id_grupo, sv.id_negocio, sv.clave, sf.id_cliente");

		Query qr = getSession().createSQLQuery(str)
				.setResultTransformer(Transformers.aliasToBean(B_SERVICIOS_CLIENTE.class));

		return qr.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<B_SERVICIOS_CLIENTES_JASPER> findByRows_SERVICIOS_CLIENTE_JASPER(Integer id_procesos,
			Integer id_negocios, Integer id_monedas, Integer id_empresas, Integer id_clientes, Integer id_servicios,
			Date fecha_inicial, Date fecha_final) {

		String str = "SELECT em.clave_empresa AS CLAVE_EMPRESA," + " em.razon_social AS RAZON_SOCIAL,"
				+ " Upper(d.calle||' Numero '||d.numero_ext) AS CALLE," + " cp.colonia AS COLONIA, "
				+ " pais.nombre||'. '||e.nombre AS ESTADO," + " m.nombre_moneda AS NOMBRE_MONEDA,"
				+ " 'Anexo de la factura Numero '||fol.serie||lpad(fol.numero,6,0) AS FOLIO,"
				+ " sv.id_negocio AS ID_NEGOCIO," + " ng.clave AS CLAVE_NEGOCIO," + " ng.descripcion AS DESC_NEGOCIO,"
				+ " sf.id_cliente AS ID_CLIENTE," + " cl.clave_cliente AS CLAVE_CLIENTE,"
				+ " cl.nombre_corto AS NOMBRE_CORTO," + " gcs.id_grupo AS ID_GRUPO," + " gcs.clave AS CLAVE_GRUPO,"
				+ " gcs.descripcion AS DESCRIPCION_GRUPO," + " sv.clave AS CLAVE_SERVICIO,"
				+ " initcap(sv.descripcion) AS DESCRIPCION_SERVICIO," + " scf.NUMERO_SUBCONCEPTO AS NUMERO_SUBCONCEPTO,"
				+ " initcap(scf.DESCRIPCION) AS DESCRIPCION,"
				+ " DECODE(sv.tipo_cargo,'EMISOR',decode(sf.total_trans_emisor,0,1,Null,1,sf.total_trans_emisor),"
				+ " decode(sf.total_trans_adquirente,0,1,Null,1,sf.total_trans_adquirente)) AS TRANSACCIONES,"
				+ " decode(pk_sif_servicios_clientes.valida_monedas(sf.id_servicio,sf.id_cliente),1,"
				+ " decode(sv.periodicidad_cobro,'DIA',1,0),0) AS APLICA_PROMEDIO,"
				+ " Nvl(sf.precio_aplicado,0) * pk_sif_tipos_cambio.obt_tc_a_aplicar(sf.id_servicio,"
				+ " sf.id_cliente," + " to_date('" + fecha_final + "','yyyy/mm/dd')) AS PRECIO,"
				+ " NVL(sf.total_costo_servicio,0)+Nvl(sf.total_descuento,0) AS IMPORTE_COBRANZA,"
				+ " decode(nvl(sf.total_descuento,0),0,0,sf.total_descuento) AS DESCUENTO,"
				+ " Decode(r.estatus,'APL',decode(nvl(sf.total_rebate,0),0,0,sf.total_rebate),0) AS DESCUENTO_ADICIONAL,"
				+ " NVL (sf.total_costo_servicio, 0) - Decode(r.estatus,'APL',"
				+ " decode(nvl(sf.total_rebate,0),0,0,sf.total_rebate),0) AS TOTAL_IMPORTE_REAL,"
				+ "	sum(decode(sv.tipo_cargo,'EMISOR',nvl(scf.TOTAL_TRANS_EMISOR,0),"
				+ " nvl(scf.TOTAL_TRANS_ADQ,0))) AS TRANS_SUBCONCEPTO,"
				+ "	sum(nvl(scf.COSTO_SUBCONCEPTO,0)) AS COSTO_SUBCONCEPTO,"
				+ "	sum(nvl(scf.DESC_SUBCONCEPTO,0)) AS DESC_SUBCONCEPTO," + "	sum(Decode(r.estatus,'APL',"
				+ " decode(nvl(scf.REBATE_SUBCONCEPTO,0),0,0,scf.REBATE_SUBCONCEPTO),null)) AS REBATE_SUBCONCEPTO,"
				+ " sum(nvl(scf.COSTO_SUBCONCEPTO,0)-"
				+ " Decode(r.estatus,'APL',decode(nvl(scf.REBATE_SUBCONCEPTO,0),0,0,scf.REBATE_SUBCONCEPTO),0))"
				+ " AS TOTAL_SUBCONCEPTO," + " (select sum(nvl(rp2.total_descuento,0)) "
				+ "	from tbl_sif_resu_perio_serv_cli rp2" + "	where rp2.id_periodo = sf.id_periodo"
				+ " and rp2.id_moneda = sf.id_moneda" + " and rp2.id_cliente = sf.id_cliente) AS HAY_DESCUENTO,"
				+ " (select sum(decode(r2.estatus,'APL',rp2.total_rebate,0)) "
				+ "	from tbl_sif_resu_perio_serv_cli rp2,tbl_sif_rebate r2" + "	where rp2.id_periodo = r2.id_periodo"
				+ " and rp2.id_moneda = r2.id_moneda" + " and rp2.id_periodo = sf.id_periodo"
				+ " and rp2.id_moneda = sf.id_moneda" + " and rp2.id_cliente = sf.id_cliente) AS HAY_REBATE"
				+ " FROM tbl_sif_resu_perio_serv_cli sf," + " tbl_sif_servicios_facturar f,"
				+ " tbl_sif_subconceptos_facturar scf," + "	tbl_sif_facturas fs," + "	tbl_sif_folios fol,"
				+ " tbl_sif_servicios_clientes sc," + " tbl_sif_servicios sv," + " tbl_sif_cat_clientes cl,"
				+ " tbl_sif_cat_negocios ng," + " tbl_sif_cat_empresas em," + " tbl_sif_cat_procesos pr,"
				+ " tbl_sif_cat_gpo_ccpt_serv gcs," + " tbl_sif_cat_monedas m," + " v_sif_cat_periodos p,"
				+ " tbl_sif_cat_domicilios d," + " tbl_sif_cat_codigo_postal cp," + " tbl_sif_cat_poblaciones p,"
				+ " tbl_sif_cat_estados e," + " tbl_sif_cat_paises pais," + " tbl_sif_rebate r"
				+ " WHERE sf.id_periodo = p.id_periodos" + " AND f.fecha_datos between p.fecha_inicio and p.fecha_fin"
				+ "	And sf.id_servicio = f.id_servicio" + "	And sf.id_cliente = f.id_cliente"
				+ "	And sf.id_moneda = f.id_moneda" + "	And f.id_servicios_facturar = scf.id_servicio_facturar(+)"
				+ "	And f.id_factura = fs.id_factura(+)" + "	And fs.id_factura = fol.id_documento(+)"
				+ "	And sf.id_servicio = sc.id_servicio" + "	And sf.id_cliente = sc.id_cliente"
				+ " AND sf.id_servicio = sv.id_servicios " + " AND sf.id_cliente = cl.id_cliente "
				+ " AND sv.id_negocio = ng.id_negocio " + " AND em.id_empresa = pr.id_empresa "
				+ " AND ng.id_proceso = pr.id_proceso " + " AND gcs.id_grupo(+) =  sv.id_grupo_concepto "
				+ " AND sf.id_moneda =  m.id_moneda " + "	And em.id_domicilio = d.id_domicilio"
				+ "	And d.id_codigo_postal = cp.id_codigo_postal" + "	And cp.id_poblacion = p.id_poblacion"
				+ "	And p.id_estado = e.id_estado" + "	And e.id_pais = pais.id_pais"
				+ "	And sf.id_periodo = r.id_periodo(+)" + "	And sf.id_moneda = r.id_moneda(+)"
				+ " AND f.fecha_datos between TO_DATE('" + fecha_inicial + "','YYYY/MM/DD') " + "and TO_DATE('"
				+ fecha_final + "','YYYY/MM/DD')" + " AND em.id_empresa =" + id_empresas + "	AND m.id_moneda ="
				+ id_monedas + " And fol.estatus(+) != 'CAN'" + "	And fol.clave_documento(+) = 'SER'"
				+ "	AND NVL (sf.total_costo_servicio, 0) - "
				+ " Decode(r.estatus,'APL',decode(nvl(sf.total_rebate,0),0,0,sf.total_rebate),0) != 0"
				+ "	AND sc.estatus= 'ACT'" + " AND f.estatus != 'ELI'" + " AND f.estatus_calculo = 'CAL' ";
		// + "and rownum <=500 ";

		if (id_negocios != 0) {
			str = str.concat(" AND ng.id_negocio=" + id_negocios);
		}
		if (id_servicios != 0) {
			str = str.concat(" AND sf.id_servicio=" + id_servicios);
		}
		if (id_clientes != 0) {
			str = str.concat(" AND cl.id_cliente=" + id_clientes);
		}

		str = str.concat(" GROUP BY em.clave_empresa," + " em.razon_social," + "	d.calle||' Numero '||d.numero_ext,"
				+ "	cp.colonia," + " pais.nombre||'. '||e.nombre," + " m.nombre_moneda,"
				+ " 'Anexo de la factura Numero '||fol.serie||lpad(fol.numero,6,0)," + " sf.precio_aplicado,"
				+ " sv.id_negocio," + " ng.clave," + " ng.descripcion," + " sf.id_servicio," + " sf.id_cliente,"
				+ " cl.clave_cliente," + " cl.nombre_corto," + " gcs.id_grupo," + "	gcs.clave," + " gcs.descripcion,"
				+ " sv.clave," + " sv.descripcion," + "	scf.NUMERO_SUBCONCEPTO," + "	scf.DESCRIPCION,"
				+ " DECODE(sv.tipo_cargo,'EMISOR',decode(sf.total_trans_emisor,0,1,Null,1,sf.total_trans_emisor),"
				+ " decode(sf.total_trans_adquirente,0,1,Null,1,sf.total_trans_adquirente)),"
				+ " decode(pk_sif_servicios_clientes.valida_monedas(sf.id_servicio,sf.id_cliente),1,"
				+ " decode(sv.periodicidad_cobro,'DIA',1,0),0),"
				+ " Nvl(sf.precio_aplicado,0) * pk_sif_tipos_cambio.obt_tc_a_aplicar(sf.id_servicio,sf.id_cliente,"
				+ " to_date('" + fecha_final
				+ "','yyyy/mm/dd')),NVL(sf.total_costo_servicio,0)+Nvl(sf.total_descuento,0) ,"
				+ " decode(nvl(sf.total_descuento,0),0,0,sf.total_descuento) ,"
				+ " Decode(r.estatus,'APL',decode(nvl(sf.total_rebate,0),0,0,sf.total_rebate),0) ,"
				+ " NVL (sf.total_costo_servicio, 0) - Decode(r.estatus,'APL',decode(nvl(sf.total_rebate,0),0,0,sf.total_rebate),0),"
				+ " sf.id_periodo," + " sf.id_moneda"
				+ " ORDER BY  ng.clave, cl.clave_cliente, gcs.clave,  sv.clave, scf.numero_subconcepto");

		Query qr = getSession().createSQLQuery(str)
				.setResultTransformer(Transformers.aliasToBean(B_SERVICIOS_CLIENTES_JASPER.class));

		return qr.list();
	}

	// Jasper
	@Override
	public JasperReport reporteServiciosCliente(HttpServletRequest request)
			throws JRException, FileNotFoundException, IOException {

		String in = request.getSession().getServletContext().getRealPath("/jasper/Servicios_Cliente_report.jrxml");
		String out = request.getSession().getServletContext().getRealPath("/jasper");
		
		jasperDesign = JRXmlLoader.load(in);
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
		JRSaver.saveObject(jasperReport, "/" + out + "/Servicios_Cliente_report.jasper");
		return jasperReport;
	}

	// Reporte Cuentas Activas
	// findbyRowsCuentasActivas
	@SuppressWarnings("unchecked")
	@Override
	public List<VIEW_REPORTE_CUENTAS_ACTIVAS> findByRows_VIEW_REPORTE_CUENTAS_ACTIVAS(Integer id_monedas,
			Integer id_periodos) {

		Criteria crit = getSession().createCriteria(VIEW_REPORTE_CUENTAS_ACTIVAS.class).add(
				Restrictions.and(Restrictions.eq("id_moneda", id_monedas), Restrictions.eq("id_periodo", id_periodos)));

		return crit.list();
	}

	// Jasper
	@Override
	public JasperReport reporteCuentasActivas(HttpServletRequest request)
			throws JRException, FileNotFoundException, IOException {

		String in = request.getSession().getServletContext().getRealPath("/jasper/CuentasActivas_report.jrxml");
		String out = request.getSession().getServletContext().getRealPath("/jasper");
		
		jasperDesign = JRXmlLoader.load(in);
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
		JRSaver.saveObject(jasperReport, "/" + out + "/CuentasActivas_report.jasper");
		return jasperReport;
	}

	// findbyRowsCuentasActivas2
	@SuppressWarnings("unchecked")
	@Override
	public List<VIEW_REPORTE_CUENTAS_ACT_2> findByRows_VIEW_REPORTE_CUENTAS_ACTIVAS_2(Integer id_periodos) {
		Criteria crit = getSession().createCriteria(VIEW_REPORTE_CUENTAS_ACT_2.class)
				.add(Restrictions.eq("id_periodos", id_periodos));

		return crit.list();
	}

	// Jasper
	@Override
	public JasperReport reporteCuentasActivas_Dos(HttpServletRequest request)
			throws JRException, FileNotFoundException, IOException {

		String in = request.getSession().getServletContext().getRealPath("/jasper/CuentasActivasTrx_report.jrxml");
		String out = request.getSession().getServletContext().getRealPath("/jasper");
		
		jasperDesign = JRXmlLoader.load(in);
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
		JRSaver.saveObject(jasperReport, "/" + out + "/CuentasActivasTrx_report.jasper");
		return jasperReport;
	}

	// Reporte ODT's Vigentes
	// findbyRowsODT
	@SuppressWarnings("unchecked")
	@Override
	public List<B_ODT_VIGENTE> findByRows_B_ODT_VIGENTE(Integer id_monedas, Integer id_clientes, Date fecha_inicial,
			Date fecha_final) {

		String str = "SELECT " + " fa.numero_odt,nvl(f.serie||lpad(f.numero,6,'0'),'0000000') as FOLIO,"
				+ " fa.fecha_datos," + " decode(fa.numero_parcialidad,0,'ALTA','FACTURA') as TIPO,"
				+ " decode(f.estatus,'IMP','Impresa','CAN','Cancelada','Generada') as ESTATUS," + " c.clave_cliente,"
				+ " c.nombre_corto," + "	n.clave as CLAVE_NEGOCIO," + " n.descripcion as DESC_NEGOCIO,"
				+ " cfa.descripcion,"
				+ " decode(fa.numero_parcialidad,0,fa.subtotal_monto+nvl(fa.ajuste_odt,0),cfa.importe*-1) as IMPORTE,"
				+ "	round(decode(fa.numero_parcialidad,0,fa.subtotal_monto"
				+ " +nvl(fa.ajuste_odt,0),cfa.importe*-1)*c.pct_iva/100,2) as IVA,"
				+ "	decode(fa.numero_parcialidad,0,fa.subtotal_monto"
				+ " +nvl(fa.ajuste_odt,0)+round((fa.subtotal_monto+nvl(fa.ajuste_odt,0))*c.pct_iva/100,2),"
				+ " (cfa.importe+round(cfa.importe*c.pct_iva/100,2))*-1) as TOTAL,"
				+ " pk_sif_facturas_abiertas.obt_neto_odt(fa.numero_odt) as NETO" + " FROM "
				+ " TBL_SIF_FACTURAS_ABIERTAS fa," + " TBL_SIF_CONCEPTOS_FACT_AB cfa," + "	TBL_SIF_FOLIOS f,"
				+ "	TBL_SIF_CAT_CLIENTES c," + "	TBL_SIF_CAT_NEGOCIOS n"
				+ " WHERE fa.id_factura_abierta = cfa.id_factura_abierta"
				+ " and fa.id_factura_abierta = f.id_documento(+)" + " and fa.id_cliente = c.id_cliente "
				+ " and fa.id_negocio = n.id_negocio" + " and fa.numero_odt in (SELECT DISTINCT numero_odt "
				+ " FROM TBL_SIF_FACTURAS_ABIERTAS fa," + " TBL_SIF_CAT_CLIENTES c"
				+ " WHERE fa.id_cliente=c.id_cliente" + " AND fa.fecha_datos between to_date('" + fecha_inicial
				+ "','yyyy/mm/dd') " + "AND to_date('" + fecha_final + "','yyyy/mm/dd')" + " AND fa.id_moneda ="
				+ id_monedas;
		if (id_clientes != 0) {
			str = str.concat(" AND fa.id_cliente=" + id_clientes);
		}

		str = str.concat(" AND fa.id_tipo_doc = 2" + " AND fa.numero_odt > 0)" + " AND nvl(f.estatus,'NUT') != 'CAN'"
				+ " AND f.clave_documento(+)='ODT'" + " UNION ALL" + " SELECT" + " fa.numero_odt,"
				+ " nvl(f.serie||lpad(f.numero,5,'0'),'000000') as FOLIO," + " nc.fecha_datos,"
				+ "	'NOTA DE CREDITO' as TIPO,"
				+ " decode(f.estatus,'IMP','Impresa','CAN','Cancelada','Generada') as ESTATUS," + " c.clave_cliente,"
				+ " c.nombre_corto," + "	n.clave as CLAVE_NEGOCIO," + " n.descripcion as DESC_NEGOCIO,"
				+ "	cnc.descripcion," + " nc.subtotal as IMPORTE," + "	nc.iva as IVA,"
				+ "	nc.subtotal+nc.iva as TOTAL," + " pk_sif_facturas_abiertas.obt_neto_odt(fa.numero_odt) as NETO"
				+ " FROM" + " TBL_SIF_FACTURAS_ABIERTAS fa," + " TBL_SIF_NOTAS_CREDITO nc,"
				+ "	TBL_SIF_CONCEPTOS_NOTA_CREDITO cnc," + "	TBL_SIF_FOLIOS f," + "	TBL_SIF_CAT_CLIENTES c,"
				+ "	TBL_SIF_CAT_NEGOCIOS n" + " WHERE fa.id_factura_abierta = nc.id_documento(+)"
				+ " AND nc.id_nota_credito = cnc.id_nota_credito  " + " AND nc.id_nota_credito = f.id_documento(+)"
				+ " AND fa.id_cliente = c.id_cliente " + " AND fa.id_negocio = n.id_negocio"
				+ " AND fa.numero_odt in (SELECT DISTINCT numero_odt " + " FROM " + " TBL_SIF_FACTURAS_ABIERTAS fa,"
				+ " TBL_SIF_CAT_CLIENTES c" + " WHERE fa.id_cliente = c.id_cliente"
				+ " AND fa.fecha_datos between to_date('" + fecha_inicial + "','yyyy/mm/dd')" + " AND to_date('"
				+ fecha_final + "','yyyy/mm/dd')" + " AND fa.id_moneda =" + id_monedas);
		if (id_clientes != 0) {
			str = str.concat(" AND fa.id_cliente=" + id_clientes);
		}
		str = str.concat(" AND fa.id_tipo_doc = 2" + " AND fa.numero_odt > 0)" + " AND nc.tipo_documento = 'ODT'"
				+ " AND nvl(f.estatus,'NUT') != 'CAN' " + " ORDER BY 1,5,4");

		Query qr = getSession().createSQLQuery(str).setResultTransformer(Transformers.aliasToBean(B_ODT_VIGENTE.class));

		return qr.list();

	}

	// Jasper
	@Override
	public JasperReport reporteODT(HttpServletRequest request) throws JRException, FileNotFoundException, IOException {

		String in = request.getSession().getServletContext().getRealPath("/jasper/ODTs_vigentes_report.jrxml");
		String out = request.getSession().getServletContext().getRealPath("/jasper");
		
		jasperDesign = JRXmlLoader.load(in);
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
		JRSaver.saveObject(jasperReport, "/" + out + "/ODTs_vigentes_report.jasper");
		return jasperReport;
	}

	// Reporte Soporte de Servicios
	// findbyRowsSoporteServicios

	@Override
	public void queryReporteTesosreria(String tipo, Model model, Integer fromRow, Integer id_procesos,
			Integer id_negocios, Integer id_monedas, Integer id_empresas, Integer id_clientes, Date fecha_inicial,
			Date fecha_final, String tipo_rep, String interfase) {
		// TODO Auto-generated method stub
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(VIEW_REPORTE_TESORERIA.class)
					.add(Restrictions.and(Restrictions.between("fecha_cobro", fecha_inicial, fecha_final)));

			if (id_procesos != 0) {
				count.add(Restrictions.eq("id_proceso", id_procesos));
			}

			if (id_negocios != 0) {
				count.add(Restrictions.eq("id_negocio", id_negocios));
			}
			if (id_monedas != 0) {
				count.add(Restrictions.eq("id_moneda", id_monedas));
			}
			if (id_clientes != 0) {
				count.add(Restrictions.eq("id_cliente", id_clientes));
			}
			if (id_empresas != 0) {
				count.add(Restrictions.eq("id_empresa", id_empresas));
			}
			if (!interfase.equals("null")) {
				count.add(Restrictions.eq("interfase", interfase));
			}
			if (!tipo_rep.equals("null")) {
				if (tipo_rep.equals("IF")) {
					count.addOrder(Order.asc("nombre_corto")).addOrder(Order.asc("sistema_cobro"))
							.addOrder(Order.asc("folio_temporal"));
				} else if (tipo_rep.equals("GE")) {
					count.addOrder(Order.asc("nombre_corto")).addOrder(Order.asc("sistema_cobro"))
							.addOrder(Order.asc("folio_temporal"));
				} else {
					count.addOrder(Order.asc("sistema_cobro")).addOrder(Order.asc("nombre_corto"))
							.addOrder(Order.asc("folio_temporal"));
				}
			}
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);
			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(VIEW_REPORTE_TESORERIA.class)
					.add(Restrictions.and(Restrictions.between("fecha_cobro", fecha_inicial, fecha_final)));

			if (id_procesos != 0) {
				crit.add(Restrictions.eq("id_proceso", id_procesos));
			}

			if (id_negocios != 0) {
				crit.add(Restrictions.eq("id_negocio", id_negocios));
			}
			if (id_monedas != 0) {
				crit.add(Restrictions.eq("id_moneda", id_monedas));
			}
			if (id_clientes != 0) {
				crit.add(Restrictions.eq("id_cliente", id_clientes));
			}
			if (id_empresas != 0) {
				crit.add(Restrictions.eq("id_empresa", id_empresas));
			}
			if (!interfase.equals("null")) {
				crit.add(Restrictions.eq("interfase", interfase));
			}
			if (!tipo_rep.equals("null")) {
				if (tipo_rep.equals("IF")) {
					crit.addOrder(Order.asc("nombre_corto")).addOrder(Order.asc("sistema_cobro"))
							.addOrder(Order.asc("folio_temporal"));
				} else if (tipo_rep.equals("GE")) {
					crit.addOrder(Order.asc("nombre_corto")).addOrder(Order.asc("sistema_cobro"))
							.addOrder(Order.asc("folio_temporal"));
				} else {
					crit.addOrder(Order.asc("sistema_cobro")).addOrder(Order.asc("nombre_corto"))
							.addOrder(Order.asc("folio_temporal"));
				}
			}

			crit.setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("reportes", crit.list());
			break;
		default:
			break;

		}

	}

	@Override

	public void queryReporteServiciosCliente(String tipo, Model model, Integer fromRow, Integer id_procesos,
			Integer id_negocios, Integer id_servicios, Integer id_monedas, Integer id_empresas, Integer id_clientes,
			Date fecha_inicial, Date fecha_final) {
		// TODO Auto-generated method stub
		switch (tipo) {
		case "count":
			String str = " SELECT" + " m.nombre_moneda as NOMBRE_MONEDA," + " sv.id_negocio as ID_NEGOCIO,"
					+ " ng.clave as CLAVE_NEGOCIO," + " sf.id_cliente as ID_CLIENTE,"
					+ " cl.clave_cliente as CLAVE_CLIENTE," + " cl.nombre_corto as NOMBRECORTO,"
					+ " gcs.id_grupo as ID_GRUPO," + " gcs.descripcion as DESCRIPCION_GRUPO,"
					+ " sv.clave as CLAVE_SERVICIO," + " sv.descripcion as DESCRIPCION_SERVICIO,"
					+ " DECODE(sv.tipo_cargo,'EMISOR',"
					+ " NVL(sf.total_trans_emisor,0),NVL(sf.total_trans_adquirente,0)) as TRANSACCIONES,"
					+ " NVL(sf.precio_aplicado,0)* pk_sif_tipos_cambio.obt_tc_a_aplicar(sf.id_servicio,"
					+ " sf.id_cliente,to_date('" + fecha_final + "','yyyy/mm/dd')) as PRECIO,"
					+ " Sum(NVL(f.costo_servicio,0)+Nvl(f.descuento,0)) as IMPORTE_COBRANZA,"
					+ " Round(NVL ( sf.calculo_ajuste_neto, 0)/(1-(nvl(sc.porcentaje_descuento,0)/100)),2) as IMPORTE_AJUSTE,"
					+ " decode(nvl(sf.total_descuento,0),0,0,sf.total_descuento) as DESCUENTO,"
					+ " Decode(r.estatus,'APL',decode(nvl(sf.total_rebate,0),0,0,sf.total_rebate),0) as DESCUENTO_ADICIONAL,"
					+ " NVL (sf.total_costo_servicio, 0) -"
					+ " Decode(r.estatus,'APL',decode(nvl(sf.total_rebate,0),0,0,sf.total_rebate),0) as TOTAL_IMPORTE_REAL  "
					+ " FROM " + " tbl_sif_servicios_clientes sc," + " tbl_sif_resu_perio_serv_cli sf,"
					+ " tbl_sif_servicios_facturar f," + " tbl_sif_servicios sv," + " tbl_sif_cat_clientes cl,"
					+ " tbl_sif_cat_negocios ng," + " tbl_sif_cat_empresas em," + " tbl_sif_cat_procesos pr,"
					+ " tbl_sif_cat_gpo_ccpt_serv gcs," + " tbl_sif_cat_monedas m," + " tbl_sif_cat_dias_periodo p,"
					+ " tbl_sif_rebate r," + " tbl_sif_folios fol," + " tbl_sif_facturas fs"
					+ " WHERE sf.id_periodo = p.id_periodo AND p.fecha_referencia = f.fecha_datos "
					+ " AND sf.id_servicio = f.id_servicio  AND pr.ID_PROCESO=" + id_procesos
					+ " AND sf.id_cliente = f.id_cliente AND sf.id_moneda = f.id_moneda "
					+ " AND sf.id_moneda = f.id_moneda And f.id_factura = fs.id_factura(+)"
					+ " And fs.id_factura = fol.id_documento(+) AND sf.id_servicio = sc.id_servicio "
					+ " AND sf.id_cliente = sc.id_cliente AND sf.id_servicio = sv.id_servicios"
					+ " AND sf.id_cliente = cl.id_cliente AND sv.id_negocio = ng.id_negocio "
					+ " AND em.id_empresa = pr.id_empresa AND ng.id_proceso = pr.id_proceso "
					+ " AND gcs.id_grupo(+) =  sv.id_grupo_concepto AND sf.id_moneda =  m.id_moneda "
					+ " AND sf.id_periodo = r.id_periodo(+) AND sf.id_moneda = r.id_moneda(+) "
					+ " AND f.fecha_datos between to_date('" + fecha_inicial + "','yyyy/mm/dd') " + "and to_date('"
					+ fecha_final + "','yyyy/mm/dd')" + " AND em.id_empresa = " + id_empresas + " AND sf.id_moneda ="
					+ id_monedas + " And fol.estatus(+) != 'CAN' And fol.clave_documento(+) = 'SER' "
					+ " AND NVL (sf.total_costo_servicio, 0) - "
					+ " Decode(r.estatus,'APL',decode(nvl(sf.total_rebate,0),0,0,sf.total_rebate),0) != 0 "
					+ " AND sc.estatus= 'ACT' AND f.estatus != 'ELI' AND f.estatus_calculo = 'CAL'";

			if (id_negocios != 0) {
				str = str.concat(" AND sv.id_negocio=" + id_negocios);
			}
			if (id_servicios != 0) {
				str = str.concat(" AND sv.id_servicio=" + id_servicios);
			}
			if (id_clientes != 0) {
				str = str.concat(" AND sf.id_cliente=" + id_clientes);
			}

			str = str.concat(" GROUP BY  m.nombre_moneda,sv.id_negocio,ng.clave,sf.id_cliente,"
					+ " cl.clave_cliente,cl.nombre_corto,gcs.id_grupo,gcs.descripcion,sv.clave," + " sv.descripcion,"
					+ " DECODE(sv.tipo_cargo,'EMISOR',NVL(sf.total_trans_emisor,0),NVL(sf.total_trans_adquirente,0)), "
					+ " NVL(sf.precio_aplicado,0)* pk_sif_tipos_cambio.obt_tc_a_aplicar(sf.id_servicio,sf.id_cliente,to_date('"
					+ fecha_final + "','yyyy/mm/dd')),"
					+ " NVL(sf.calculo_ajuste_neto,0),nvl(sc.porcentaje_descuento,0),"
					+ " decode(nvl(sf.total_descuento,0),0,0,sf.total_descuento),"
					+ " Decode(r.estatus,'APL',decode(nvl(sf.total_rebate,0),0,0,sf.total_rebate),0),"
					+ " NVL (sf.total_costo_servicio, 0) - Decode(r.estatus,'APL',decode(nvl(sf.total_rebate,0),0,0,sf.total_rebate),0)"
					+ " ORDER BY gcs.id_grupo, sv.id_negocio, sv.clave, sf.id_cliente");

			Query count = getSession().createSQLQuery(str)
					.setResultTransformer(Transformers.aliasToBean(B_SERVICIOS_CLIENTE.class));
			model.addAttribute("registros_totales", count.list().size());

			break;
		case "consulta":
			String consulta = " SELECT" + " m.nombre_moneda as NOMBRE_MONEDA," + " sv.id_negocio as ID_NEGOCIO,"
					+ " ng.clave as CLAVE_NEGOCIO," + " sf.id_cliente as ID_CLIENTE,"
					+ " cl.clave_cliente as CLAVE_CLIENTE," + " cl.nombre_corto as NOMBRECORTO,"
					+ " gcs.id_grupo as ID_GRUPO," + " gcs.descripcion as DESCRIPCION_GRUPO,"
					+ " sv.clave as CLAVE_SERVICIO," + " sv.descripcion as DESCRIPCION_SERVICIO,"
					+ " DECODE(sv.tipo_cargo,'EMISOR',"
					+ " NVL(sf.total_trans_emisor,0),NVL(sf.total_trans_adquirente,0)) as TRANSACCIONES,"
					+ " NVL(sf.precio_aplicado,0)* pk_sif_tipos_cambio.obt_tc_a_aplicar(sf.id_servicio,"
					+ " sf.id_cliente,to_date('" + fecha_final + "','yyyy/mm/dd')) as PRECIO,"
					+ " Sum(NVL(f.costo_servicio,0)+Nvl(f.descuento,0)) as IMPORTE_COBRANZA,"
					+ " Round(NVL ( sf.calculo_ajuste_neto, 0)/(1-(nvl(sc.porcentaje_descuento,0)/100)),2) as IMPORTE_AJUSTE,"
					+ " decode(nvl(sf.total_descuento,0),0,0,sf.total_descuento) as DESCUENTO,"
					+ " Decode(r.estatus,'APL',decode(nvl(sf.total_rebate,0),0,0,sf.total_rebate),0) as DESCUENTO_ADICIONAL,"
					+ " NVL (sf.total_costo_servicio, 0) -"
					+ " Decode(r.estatus,'APL',decode(nvl(sf.total_rebate,0),0,0,sf.total_rebate),0) as TOTAL_IMPORTE_REAL  "
					+ " FROM " + " tbl_sif_servicios_clientes sc," + " tbl_sif_resu_perio_serv_cli sf,"
					+ " tbl_sif_servicios_facturar f," + " tbl_sif_servicios sv," + " tbl_sif_cat_clientes cl,"
					+ " tbl_sif_cat_negocios ng," + " tbl_sif_cat_empresas em," + " tbl_sif_cat_procesos pr,"
					+ " tbl_sif_cat_gpo_ccpt_serv gcs," + " tbl_sif_cat_monedas m," + " tbl_sif_cat_dias_periodo p,"
					+ " tbl_sif_rebate r," + " tbl_sif_folios fol," + " tbl_sif_facturas fs"
					+ " WHERE sf.id_periodo = p.id_periodo AND p.fecha_referencia = f.fecha_datos "
					+ " AND sf.id_servicio = f.id_servicio  AND pr.ID_PROCESO=" + id_procesos
					+ " AND sf.id_cliente = f.id_cliente AND sf.id_moneda = f.id_moneda "
					+ " AND sf.id_moneda = f.id_moneda And f.id_factura = fs.id_factura(+)"
					+ " And fs.id_factura = fol.id_documento(+) AND sf.id_servicio = sc.id_servicio "
					+ " AND sf.id_cliente = sc.id_cliente AND sf.id_servicio = sv.id_servicios"
					+ " AND sf.id_cliente = cl.id_cliente AND sv.id_negocio = ng.id_negocio "
					+ " AND em.id_empresa = pr.id_empresa AND ng.id_proceso = pr.id_proceso "
					+ " AND gcs.id_grupo(+) =  sv.id_grupo_concepto AND sf.id_moneda =  m.id_moneda "
					+ " AND sf.id_periodo = r.id_periodo(+) AND sf.id_moneda = r.id_moneda(+) "
					+ " AND f.fecha_datos between to_date('" + fecha_inicial + "','yyyy/mm/dd') " + "and to_date('"
					+ fecha_final + "','yyyy/mm/dd')" + " AND em.id_empresa = " + id_empresas + " AND sf.id_moneda ="
					+ id_monedas + " And fol.estatus(+) != 'CAN' And fol.clave_documento(+) = 'SER' "
					+ " AND NVL (sf.total_costo_servicio, 0) - "
					+ " Decode(r.estatus,'APL',decode(nvl(sf.total_rebate,0),0,0,sf.total_rebate),0) != 0 "
					+ " AND sc.estatus= 'ACT' AND f.estatus != 'ELI' AND f.estatus_calculo = 'CAL'";

			if (id_negocios != 0) {
				consulta = consulta.concat(" AND sv.id_negocio=" + id_negocios);
			}
			if (id_servicios != 0) {
				consulta = consulta.concat(" AND sv.id_servicio=" + id_servicios);
			}
			if (id_clientes != 0) {
				consulta = consulta.concat(" AND sf.id_cliente=" + id_clientes);
			}

			consulta = consulta.concat(" GROUP BY  m.nombre_moneda,sv.id_negocio,ng.clave,sf.id_cliente,"
					+ " cl.clave_cliente,cl.nombre_corto,gcs.id_grupo,gcs.descripcion,sv.clave," + " sv.descripcion,"
					+ " DECODE(sv.tipo_cargo,'EMISOR',NVL(sf.total_trans_emisor,0),NVL(sf.total_trans_adquirente,0)), "
					+ " NVL(sf.precio_aplicado,0)* pk_sif_tipos_cambio.obt_tc_a_aplicar(sf.id_servicio,sf.id_cliente,to_date('"
					+ fecha_final + "','yyyy/mm/dd')),"
					+ " NVL(sf.calculo_ajuste_neto,0),nvl(sc.porcentaje_descuento,0),"
					+ " decode(nvl(sf.total_descuento,0),0,0,sf.total_descuento),"
					+ " Decode(r.estatus,'APL',decode(nvl(sf.total_rebate,0),0,0,sf.total_rebate),0),"
					+ " NVL (sf.total_costo_servicio, 0) - Decode(r.estatus,'APL',decode(nvl(sf.total_rebate,0),0,0,sf.total_rebate),0)"
					+ " ORDER BY gcs.id_grupo, sv.id_negocio, sv.clave, sf.id_cliente");
			consulta = consulta.concat(" OFFSET " + fromRow + " ROWS FETCH NEXT 15 ROWS ONLY");
			Query query = getSession().createSQLQuery(consulta)
					.setResultTransformer(Transformers.aliasToBean(B_SERVICIOS_CLIENTE.class));
			model.addAttribute("reportes", query.list());
			break;
		default:
			break;

		}
	}

	@Override
	public void queryReporteFolio(String tipo, Model model, Integer fromRow, Integer id_empresas, String serie_value,
			String documento, Integer id_monedas, Integer id_negocios, Integer id_procesos, String estatus,
			Integer id_clientes, Date fecha_inicial, Date fecha_final) {
		// TODO Auto-generated method stub

		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(VIEW_REPORTE_FOLIOS.class)
					.add(Restrictions.and(Restrictions.eq("id_empresa", id_empresas),
							Restrictions.eq("serie", serie_value), Restrictions.eq("clave_documento", documento),
							Restrictions.between("fecha_datos", fecha_inicial, fecha_final)));

			if (!(id_negocios == 0)) {
				count.add(Restrictions.eq("id_negocio", id_negocios));
			}
			if (!(id_procesos == 0)) {
				count.add(Restrictions.eq("id_proceso", id_procesos));
			}
			if (!(id_monedas == 0)) {
				count.add(Restrictions.eq("id_moneda", id_monedas));
			}
			if (!(id_clientes == 0)) {
				count.add(Restrictions.eq("id_cliente", id_clientes));
			}
			if (!estatus.equals("null")) {
				count.add(Restrictions.eq("estatus", estatus));
			}

			count.addOrder(Order.asc("numero"));

			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);
			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(VIEW_REPORTE_FOLIOS.class)
					.add(Restrictions.and(Restrictions.eq("id_empresa", id_empresas),
							Restrictions.eq("serie", serie_value), Restrictions.eq("clave_documento", documento),
							Restrictions.between("fecha_datos", fecha_inicial, fecha_final)));

			if (!(id_negocios == 0)) {
				crit.add(Restrictions.eq("id_negocio", id_negocios));
			}
			if (!(id_procesos == 0)) {
				crit.add(Restrictions.eq("id_proceso", id_procesos));
			}
			if (!(id_monedas == 0)) {
				crit.add(Restrictions.eq("id_moneda", id_monedas));
			}
			if (!(id_clientes == 0)) {
				crit.add(Restrictions.eq("id_cliente", id_clientes));
			}
			if (!estatus.equals("null")) {
				crit.add(Restrictions.eq("estatus", estatus));
			}

			crit.addOrder(Order.asc("numero"));

			crit.setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("reportes", crit.list());
			break;
		default:
			break;

		}

	}

	public void jasperpdf(HttpServletRequest request, HttpServletResponse response, String clave, String clave_cliente,
			Integer id_fuentes, Date fecha_inicial, Date fecha_final) {
		// TODO Auto-generated method stub
		String in = request.getSession().getServletContext().getRealPath("/imagenes/logo1.jpg");
		String consulta = "";

		// valor clave
		if (clave.equals("0")) {
			clave = "";
		}
		Map parameters = new HashMap();
		parameters.put("reportHomePath", in);
		parameters.put("id_servicio", clave);
		parameters.put("id_fuente", id_fuentes);
		parameters.put("clave_cliente", clave_cliente);

		// convertir fechas
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String fecha_inicialconv = dateFormat.format(fecha_inicial);
		String fecha_finalconv = dateFormat.format(fecha_final);
		// parametros convertidos
		parameters.put("fechaini", fecha_inicialconv);
		parameters.put("fechafin", fecha_finalconv);

		if (id_fuentes == 32) {
			procesoGeneral.GenerarReporte(null, request, response, consulta, "reporte_mensualCross",
					"reporte_mensualCross", "pdf", parameters);
		}

		else if (id_fuentes == 48) {
			procesoGeneral.GenerarReporte(null, request, response, consulta, "reporteSoporteFacturaMI",
					"reporteSoporteFacturaMI", "pdf", parameters);
		}

		else if (id_fuentes == 7) {
			procesoGeneral.GenerarReporte(null, request, response, consulta, "reporteSoporteFacturaProal",
					"reporteSoporteFacturaProal", "pdf", parameters);
		}

		else if (id_fuentes == 31) {
			procesoGeneral.GenerarReporte(null, request, response, consulta, "reporteSoporteFacturaSms",
					"reporteSoporteFacturaSms", "pdf", parameters);
		}

		else if (id_fuentes == 73) {
			procesoGeneral.GenerarReporte(null, request, response, consulta, "reporteAcumuladoCross",
					"reporteAcumuladoCross", "pdf", parameters);
		}

		else if (id_fuentes == 76) {
			procesoGeneral.GenerarReporte(null, request, response, consulta, "repDetalleFacVM", "repDetalleFacVM",
					"pdf", parameters);
		}

		else {
			procesoGeneral.GenerarReporte(null, request, response, consulta, "reporte_mensualSISCOOP",
					"reporte_mensualSISCOOP", "pdf", parameters);
		}
	}

	@Override
	public void queryReporteConranzaDiaria(String tipo, Model model, Integer fromRow, Integer id_procesos,
			Integer id_negocios, Integer id_servicios, Integer id_monedas, Integer id_empresas, Integer id_clientes,
			Date fecha_inicial, Date fecha_final) {
		// TODO Auto-generated method stub
		switch (tipo) {
		case "count":
			String count = "SELECT * FROM V_SIF_COBRANZA_DIARIA " + " WHERE" + " id_moneda =" + id_monedas
					+ " AND fecha_datos BETWEEN TO_DATE('" + fecha_inicial + "','YYYY/MM/DD')" + " AND TO_DATE('"
					+ fecha_final + "','YYYY/MM/DD')";

			if (id_procesos != 0) {
				count = count.concat(" AND id_proceso =" + id_procesos);
			}

			if (id_negocios != 0) {
				count = count.concat(" AND id_negocio =" + id_negocios);
			}
			if (id_servicios != 0) {
				count = count.concat(" AND id_servicios =" + id_servicios);
			}
			if (id_clientes != 0) {
				count = count.concat("AND id_cliente =" + id_clientes);
			}
			if (id_empresas != 0) {
				count = count.concat("AND id_empresa =" + id_empresas);
			}

			count = count.concat("ORDER BY fecha_datos");

			Query conteo = getSession().createSQLQuery(count)
					.setResultTransformer(Transformers.aliasToBean(B_COBRANZA_DIARIA.class));
			model.addAttribute("registros_totales", conteo.list().size());

			break;
		case "consulta":
			String consulta = "SELECT * FROM V_SIF_COBRANZA_DIARIA " + " WHERE" + " id_moneda =" + id_monedas
					+ " AND fecha_datos BETWEEN TO_DATE('" + fecha_inicial + "','YYYY/MM/DD')" + " AND TO_DATE('"
					+ fecha_final + "','YYYY/MM/DD')";

			if (id_procesos != 0) {
				consulta = consulta.concat(" AND id_proceso =" + id_procesos);
			}

			if (id_negocios != 0) {
				consulta = consulta.concat(" AND id_negocio =" + id_negocios);
			}
			if (id_servicios != 0) {
				consulta = consulta.concat(" AND id_servicios =" + id_servicios);
			}
			if (id_clientes != 0) {
				consulta = consulta.concat("AND id_cliente =" + id_clientes);
			}
			if (id_empresas != 0) {
				consulta = consulta.concat("AND id_empresa =" + id_empresas);
			}

			consulta = consulta.concat("ORDER BY fecha_datos");
			consulta = consulta.concat(" OFFSET " + fromRow + " ROWS FETCH NEXT 15 ROWS ONLY");
			Query query = getSession().createSQLQuery(consulta)
					.setResultTransformer(Transformers.aliasToBean(B_COBRANZA_DIARIA.class));
			model.addAttribute("reportes", query.list());
			break;
		default:
			break;

		}

	}

	@Override
	public void queryReporteServicioCliente(String tipo, Model model, Integer fromRow, Integer id_fuentes, String clave,
			Integer id_clientes, Date fecha_inicial, Date fecha_final) {
		// TODO Auto-generated method stub
		switch (tipo) {
		case "count":
			String str = "SELECT " + " to_char(trunc(ru.fecha_datos)) as \"fechadatos\" ,"
					+ " ru.banco  as  \"cvbanco\" ," + " c.nombre_corto as \"nmbanco\" ,"
					+ " n.clave as \"cvnegocio\" ," + " n.descripcion as \"nmnegocio\" ,"
					+ " gs.clave as \"cvgrupoconcepto\" ," + " gs.descripcion as \"nmgrupoconcepto\" ,"
					+ " ru.servicio as \"cvservicio\"," + " s.descripcion as \"nmservicio\" ,"
					+ " ru.caja as \"cvcaja\"," + " cc.nombre_corto as \"nmcaja\" ,"
					+ " ru.transacciones as \"transacciones\" ," + " sf.precio_aplicado as \"precio\" ,"
					+ " sf.costo_servicio as \"importe\" ,"
					+ " nvl(sf.imp_rebate_mensual,0)*ru.transacciones/(select sum(transacciones) " + " FROM"
					+ " TBL_SIF_REP_BANCOS WHERE " + " fecha_datos BETWEEN TO_DATE('" + fecha_inicial
					+ "','YYYY/MM/DD')" + " and TO_DATE('" + fecha_final + "', 'YYYY/MM/DD') "
					+ " and banco = ru.banco and servicio = ru.servicio) as \"descadicional\" ,"
					+ " round(ru.transacciones*sf.precio_aplicado,2)+(nvl(sf.imp_rebate_mensual,0)*ru.transacciones/"
					+ " (select sum(transacciones) from TBL_SIF_REP_BANCOS WHERE fecha_datos " + " BETWEEN TO_DATE('"
					+ fecha_inicial + "','YYYY/MM/DD') " + " and TO_DATE('" + fecha_final + "', 'YYYY/MM/DD')"
					+ " and banco = ru.banco and servicio = ru.servicio)) as \"totalfactura\" " + " FROM"
					+ " TBL_SIF_REP_BANCOS ru ," + " TBL_SIF_SERVICIOS s ," + " TBL_SIF_CAT_CLIENTES c ,"
					+ " TBL_SIF_CAT_CLIENTES cc ," + " TBL_SIF_FUENTES f ," + " TBL_SIF_CAT_NEGOCIOS n ,"
					+ " TBL_SIF_CAT_GPO_CCPT_SERV gs ," + " TBL_SIF_SERVICIOS_FACTURAR sf WHERE "
					+ " ru.servicio =  s.clave " + " and ru.banco = c.clave_cliente "
					+ " and ru.caja = cc.clave_cliente" + " and ru.fuente = f.clave"
					+ " and s.id_negocio = n.id_negocio" + " and s.id_grupo_concepto = gs.id_grupo(+)"
					+ " and ru.fecha_datos(+) = sf.fecha_datos " + " and c.id_cliente = sf.id_cliente and "
					+ " s.id_servicios = sf.id_servicio and trunc(ru.FECHA_DATOS) " + " BETWEEN TO_DATE('"
					+ fecha_inicial + "','YYYY/MM/DD') and TO_DATE('" + fecha_final + "', 'YYYY/MM/DD') ";

			if (id_fuentes != 0) {
				str = str.concat(" AND f.id_fuente=" + id_fuentes);
			}
			if (!clave.equals("0")) {
				str = str.concat(" AND ru.servicio= '" + clave + "'");
			}
			if (id_clientes != 0) {
				str = str.concat(" AND c.id_cliente=" + id_clientes);
			}

			str = str.concat("order by 1,3,5,7,9 ");

			Query conteo = getSession().createSQLQuery(str)
					.setResultTransformer(Transformers.aliasToBean(B_SOPORTE_SERVICIOS.class));
			model.addAttribute("registros_totales", conteo.list().size());

			break;
		case "consulta":
			String consulta = "SELECT " + " to_char(trunc(ru.fecha_datos)) as \"fechadatos\" ,"
					+ " ru.banco  as  \"cvbanco\" ," + " c.nombre_corto as \"nmbanco\" ,"
					+ " n.clave as \"cvnegocio\" ," + " n.descripcion as \"nmnegocio\" ,"
					+ " gs.clave as \"cvgrupoconcepto\" ," + " gs.descripcion as \"nmgrupoconcepto\" ,"
					+ " ru.servicio as \"cvservicio\"," + " s.descripcion as \"nmservicio\" ,"
					+ " ru.caja as \"cvcaja\"," + " cc.nombre_corto as \"nmcaja\" ,"
					+ " ru.transacciones as \"transacciones\" ," + " sf.precio_aplicado as \"precio\" ,"
					+ " sf.costo_servicio as \"importe\" ,"
					+ " nvl(sf.imp_rebate_mensual,0)*ru.transacciones/(select sum(transacciones) " + " FROM"
					+ " TBL_SIF_REP_BANCOS WHERE " + " fecha_datos BETWEEN TO_DATE('" + fecha_inicial
					+ "','YYYY/MM/DD')" + " and TO_DATE('" + fecha_final + "', 'YYYY/MM/DD') "
					+ " and banco = ru.banco and servicio = ru.servicio) as \"descadicional\" ,"
					+ " round(ru.transacciones*sf.precio_aplicado,2)+(nvl(sf.imp_rebate_mensual,0)*ru.transacciones/"
					+ " (select sum(transacciones) from TBL_SIF_REP_BANCOS WHERE fecha_datos " + " BETWEEN TO_DATE('"
					+ fecha_inicial + "','YYYY/MM/DD') " + " and TO_DATE('" + fecha_final + "', 'YYYY/MM/DD')"
					+ " and banco = ru.banco and servicio = ru.servicio)) as \"totalfactura\" " + " FROM"
					+ " TBL_SIF_REP_BANCOS ru ," + " TBL_SIF_SERVICIOS s ," + " TBL_SIF_CAT_CLIENTES c ,"
					+ " TBL_SIF_CAT_CLIENTES cc ," + " TBL_SIF_FUENTES f ," + " TBL_SIF_CAT_NEGOCIOS n ,"
					+ " TBL_SIF_CAT_GPO_CCPT_SERV gs ," + " TBL_SIF_SERVICIOS_FACTURAR sf WHERE "
					+ " ru.servicio =  s.clave " + " and ru.banco = c.clave_cliente "
					+ " and ru.caja = cc.clave_cliente" + " and ru.fuente = f.clave"
					+ " and s.id_negocio = n.id_negocio" + " and s.id_grupo_concepto = gs.id_grupo(+)"
					+ " and ru.fecha_datos(+) = sf.fecha_datos " + " and c.id_cliente = sf.id_cliente and "
					+ " s.id_servicios = sf.id_servicio and trunc(ru.FECHA_DATOS) " + " BETWEEN TO_DATE('"
					+ fecha_inicial + "','YYYY/MM/DD') and TO_DATE('" + fecha_final + "', 'YYYY/MM/DD') ";

			if (id_fuentes != 0) {
				consulta = consulta.concat(" AND f.id_fuente=" + id_fuentes);
			}
			if (!clave.equals("0")) {
				consulta = consulta.concat(" AND ru.servicio= '" + clave + "'");
			}
			if (id_clientes != 0) {
				consulta = consulta.concat(" AND c.id_cliente=" + id_clientes);
			}

			consulta = consulta.concat("order by 1,3,5,7,9 ");

			consulta = consulta.concat(" OFFSET " + fromRow + " ROWS FETCH NEXT 15 ROWS ONLY");
			Query query = getSession().createSQLQuery(consulta)
					.setResultTransformer(Transformers.aliasToBean(B_SOPORTE_SERVICIOS.class));
			model.addAttribute("reportes", query.list());
			break;
		default:
			break;

		}

	}

	@Override
	public void queryReporteCuentasActivas(String tipo, Model model, Integer fromRow, Integer id_monedas,
			Integer id_periodos) {
		// TODO Auto-generated method stub
		switch (tipo) {
		case "count":
			Criteria count = getSession().createCriteria(VIEW_REPORTE_CUENTAS_ACTIVAS.class).add(Restrictions
					.and(Restrictions.eq("id_moneda", id_monedas), Restrictions.eq("id_periodo", id_periodos)));
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);
			break;
		case "consulta":
			Criteria crit = getSession().createCriteria(VIEW_REPORTE_CUENTAS_ACTIVAS.class).add(Restrictions
					.and(Restrictions.eq("id_moneda", id_monedas), Restrictions.eq("id_periodo", id_periodos)));
			crit.setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("reportes", crit.list());
			break;
		default:
			break;

		}
	}

	@Override
	public void jasperexcel(HttpServletRequest request, HttpServletResponse response, String clave_proceso,
			String clave_negocio, String clave_cliente, String nombre_moneda, String documento, String serie_value,
			String estatus, Date fecha_inicial, Date fecha_final, String format) {
		// TODO Auto-generated method stub
		String in = request.getSession().getServletContext().getRealPath("/imagenes/logo1.jpg");
		String consulta = "";

		Map parameters = new HashMap();
		parameters.put("reportHomePath", in);
		parameters.put("pClaveProceso", clave_proceso);
		parameters.put("pClaveNegocio", clave_negocio);
		parameters.put("pClaveCliente", clave_cliente);
		parameters.put("pClaveMoneda", nombre_moneda);
		parameters.put("pTipoDocumento", documento);
		parameters.put("pSerie", serie_value);
		parameters.put("pEstatus", estatus);

		// convertir fechas
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String fecha_inicialconv = dateFormat.format(fecha_inicial);
		String fecha_finalconv = dateFormat.format(fecha_final);
		// parametros convertidos
		parameters.put("pFechaInicial", fecha_inicialconv);
		parameters.put("pFechaFinal", fecha_finalconv);

		procesoGeneral.GenerarReporte(null, request, response, consulta, "repConsecutivoFolios_report",
				"repConsecutivoFolios_report", format, parameters);

	}

}
