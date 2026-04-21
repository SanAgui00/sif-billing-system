/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 08/03/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.operation;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRXlsAbstractExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 * 
 * @author Loredo
 *
 */
@Repository
@SuppressWarnings("all")
public class ProcesoGeneral {
	private static Logger loggerSif = LoggerFactory.getLogger("sif");
	private static Logger loggerErr = LoggerFactory.getLogger("sif_err");
	private static Logger loggerDb = LoggerFactory.getLogger("sif_db");
	private static Logger loggerUsr = LoggerFactory.getLogger("sif_usr");
	private static Logger loggerCon = LoggerFactory.getLogger("sif_con");
	private static Logger loggerMon = LoggerFactory.getLogger("sif_mon");

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private DataSource dataSource;
	
	public static final String usuario = "El usuario ";
	public static final String usu = "Usuario= ";
	public static final String url = ", error al buscar la URL= ";
	public static final String accesoUrl = " ha accesado a la url ";
	public static final String mensError = ", mensaje de error= ";
	public static final String urlNot = ", la URL no existe.";
	public static final String sesionIni = " ha iniciado sesión";
	public static final String sesionFin = " ha cerrado sesión";
	public static final String conn = ", error al crear nueva conexión en= ";
	public static final String con = ", compruebe su conexión.";
	public static final String rollback = ", error al no poder realizar rollback en= ";
	public static final String borrar = ", no se pudo borrar";
	public static final String errorReport = ", error en los reportes";

	public Session getSession() {
		Query setNls = sessionFactory.getCurrentSession()
				.createSQLQuery("ALTER SESSION SET NLS_DATE_FORMAT = 'dd/MON/yyyy'");
		setNls.executeUpdate();
		return sessionFactory.getCurrentSession();
	}

	public String getSesionActual() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String sesion = authentication.getName();
		return sesion.toUpperCase();
	}

	public Integer getId(Class table, String id) {

		int max_id = 0;
		Criteria crit = getSession().createCriteria(table);
		Integer registrosTotales = crit.setProjection(Projections.max(id)).uniqueResult().hashCode();
		max_id = registrosTotales + 1;
		return max_id;
	}

	public Date formatDate(String fecha) {
		Date initDate;
		Date date = null;

		try {
			initDate = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
			String parsedDate = formatter.format(initDate);
			SimpleDateFormat fo = new SimpleDateFormat("dd/MM/yy");
			date = fo.parse(parsedDate);

		} catch (ParseException e) {
			loggerErr.error(usu + this.getSesionActual() + mensError + e.getMessage());
		}

		return date;
	}

	public void Bitacora(Model model, HttpServletRequest request, String codigo, String descripcion,
			String procedimiento) {
		Query query = getSession().createSQLQuery("insert into tbl_sif_bitacora values(sysdate,'" + codigo + "','"
				+ this.getSesionActual() + "','" + descripcion + "','" + procedimiento + "')");
		query.executeUpdate();
	}

	public void BitacoraAdquisicion(Model model, HttpServletRequest request, Integer id_fuente, String codigo,
			String descripcion, String procedimiento) {
		Query query = getSession().createSQLQuery("insert into tbl_sif_bit_adquisiciones values(sysdate," + id_fuente
				+ ",'" + codigo + "','" + this.getSesionActual() + "','" + procedimiento + "','" + descripcion + "')");
		query.executeUpdate();
	}

	public void loggerUsr(String tipo, HttpServletRequest request) {
		switch (tipo) {
		case "controller":
			loggerUsr.info(usuario + this.getSesionActual() + accesoUrl + request.getRequestURI());
			break;
		case "login":
			loggerUsr.info(usuario + this.getSesionActual() + sesionIni);
			break;
		case "logout":
			loggerUsr.info(usuario + this.getSesionActual() + sesionFin);
			break;
		default:
			break;
		}
	}

	public void loggerErr(String tipo, HttpServletRequest request, Exception ex) {
		switch (tipo) {
		case "404":
			loggerErr.error(usu + this.getSesionActual() + url
					+ request.getRequestURI() + mensError + ex.getMessage() + urlNot);
			break;
		case "GenericJDBCException":
			loggerErr.error(usu + this.getSesionActual() + conn
					+ request.getRequestURI() + mensError + ex.getMessage() + con);
			break;
		case "TransactionException":
			loggerErr.error(usu + this.getSesionActual() + rollback
					+ request.getRequestURI() + mensError + ex.getMessage() + con);
			break;
		case "catch":
			loggerErr.error(usu + this.getSesionActual() + mensError + ex.getMessage() + borrar);
			break;
		case "ParseException":
			loggerErr.error(usu + this.getSesionActual() + mensError + ex.getMessage());
			break;
		default:
			break;
		}
	}

	public void GenerarReporte(Model model, HttpServletRequest request, HttpServletResponse response, String consulta,
			String jasper, String nombre, String tipo, Map parameters) {
		
		
		
		try {
			Connection con = dataSource.getConnection();
			String path = request.getSession().getServletContext().getRealPath("/jasper/" + jasper + ".jrxml");
			JasperDesign jasperDesign = null;
			jasperDesign = JRXmlLoader.load(path);
			if(!consulta.equals("")) {
				JRDesignQuery newQuery = new JRDesignQuery();
				newQuery.setText(consulta);
				jasperDesign.setQuery(newQuery);
			}
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
			if (tipo.trim().equals("pdf")) {
				byte[] byteStream = JasperRunManager.runReportToPdf(jasperReport, parameters,con);
				OutputStream outStream = response.getOutputStream();
				response.setContentType("application/pdf");
				response.setContentLength(byteStream.length);
				response.setHeader("Content-Disposition", "attachment;filename=" + nombre + ".pdf");
				outStream.write(byteStream, 0, byteStream.length);
				outStream.flush();
				outStream.close();
			} else {
				JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, con);
				
				ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
				JRXlsExporter exporterXLS = new JRXlsExporter();
				exporterXLS.setParameter(JRExporterParameter.JASPER_PRINT, print);
				exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, arrayOutputStream);
				exporterXLS.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, nombre + ".xls");
				// exporterXLS.setParameter(JRXlsAbstractExporterParameter.IS_WHITE_PAGE_BACKGROUND,Boolean.TRUE);
				exporterXLS.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
						Boolean.TRUE);
				exporterXLS.setParameter(JRXlsAbstractExporterParameter.IS_FONT_SIZE_FIX_ENABLED, Boolean.TRUE);
				exporterXLS.setParameter(JRXlsAbstractExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
				exporterXLS.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
						Boolean.TRUE);// ESTA
				exporterXLS.setParameter(JRXlsAbstractExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
				exporterXLS.exportReport();
				response.setContentType("application/vnd.ms-excel");
				response.setHeader("Content-Disposition", "attachment; filename=" + nombre + ".xls");
				response.getOutputStream().write(arrayOutputStream.toByteArray());
				response.getOutputStream().flush();
				response.getOutputStream().close();
				response.flushBuffer();
			}
			con.close();
		} catch (JRException | IOException | SQLException e) {
			loggerErr.error(usu + this.getSesionActual() + mensError + e.getMessage() + errorReport);
		}
	}
}