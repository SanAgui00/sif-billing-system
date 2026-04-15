/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 21/03/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.dao;

import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.prosa.sif.operation.ProcesoGeneral;
import com.prosa.sif.pojo.TablaBitacoraAdq;
import com.prosa.sif.pojo.ViewAdquisicionAuto;
import com.prosa.sif.pojo.ViewServicioFacturar;

/**
 * 
 * @author Loredo
 *
 */
@Repository
@Transactional
@SuppressWarnings("all")
public class AdquisicionAutoDaoImpl implements AdquisicionAutoDao {
	@Autowired
	private ProcesoGeneral procesoGeneral;
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}


	@Override
	public void queryAdquisicionAuto(String tipo, Integer fuentes_clave, String estatus, String fecha_inicial,
			String fecha_final, Integer fromRow, Model model, HttpServletRequest request) {
		
		String val = "TRUNC(fecha_datos) between to_date('" + fecha_inicial
				+ "','YYYY-MM-DD') and to_date('" + fecha_final + "','YYYY-MM-DD')";
		switch (tipo) {
		case "count":

			Criteria count = procesoGeneral.getSession().createCriteria(ViewAdquisicionAuto.class);
			if (!(fuentes_clave == 0)) {
				count.add(Restrictions.eq("id_fuente", fuentes_clave));
			}
			if (!estatus.equals("null")) {
				count.add(Restrictions.eq("estatus", estatus));
			}
//			count.add(Restrictions.sqlRestriction("TRUNC(fecha_datos) between to_date('" + fecha_inicial
//					+ "','YYYY-MM-DD') and to_date('" + fecha_final + "','YYYY-MM-DD')"));
			count.add(Restrictions.sqlRestriction(val));
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);
			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(ViewAdquisicionAuto.class);
			if (!(fuentes_clave == 0)) {
				crit.add(Restrictions.eq("id_fuente", fuentes_clave));
			}
			if (!estatus.equals("null")) {
				crit.add(Restrictions.eq("estatus", estatus));
			}
//			crit.add(Restrictions.sqlRestriction("TRUNC(fecha_datos) between to_date('" + fecha_inicial
//					+ "','YYYY-MM-DD') and to_date('" + fecha_final + "','YYYY-MM-DD')"));
			crit.add(Restrictions.sqlRestriction(val));
			crit.addOrder(Order.desc("fecha_datos"));
			crit.setFirstResult(fromRow);
			crit.setMaxResults(15);
			model.addAttribute("consulta", crit.list());
			break;
		default:
			break;
		}

	}

	@Override
	public void queryBitacoraAdq(String tipo, Integer fromRow, Integer fuentes_clave, String fecha_inicial,
			String fecha_final, Model model, HttpServletRequest request) {
		
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaBitacoraAdq.class);
			count.add(Restrictions.eq("id_fuente", fuentes_clave));
			
			if (fecha_inicial.equals("null") && fecha_final.equals("null")) {
				count.add(Restrictions.eq("id_fuente", fuentes_clave));
			}
			else {
			count.add(Restrictions.sqlRestriction("TRUNC(pk_hora) between to_date('" + fecha_inicial
					+ "','YYYY-MM-DD') and  to_date('" + fecha_final + "','YYYY-MM-DD')"))
					.addOrder(Order.desc("pk_hora"));
			}
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);
			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaBitacoraAdq.class);
			crit.add(Restrictions.eq("id_fuente", fuentes_clave));
			
			if (fecha_inicial.equals("null") && fecha_final.equals("null")) {
				crit.add(Restrictions.eq("id_fuente", fuentes_clave));
			}
			else {
			crit.add(Restrictions.sqlRestriction("TRUNC(pk_hora) between to_date('" + fecha_inicial
					+ "','YYYY-MM-DD') and  to_date('" + fecha_final + "','YYYY-MM-DD')"))
					.addOrder(Order.desc("pk_hora"));
			}
			crit.setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("consulta", crit.list());

			break;
		default:
			break;
		}
	}

	@Override
	public void queryServicioFacturar(String tipo, Model model, HttpServletRequest request, Integer idCliente,
			Integer idServicio, String fechaInicio, String fechaFin, String estatus, Integer fromRow) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(ViewServicioFacturar.class);
			if (!(idServicio == 0)) {
				count.add(Restrictions.eq("id_servicio", idServicio));
			}
			if (!(idCliente == 0)) {
				count.add(Restrictions.eq("id_cliente", idCliente));
			}
			if (!estatus.equals("empty")) {
				count.add(Restrictions.eq("estatus", estatus));
			}
			if (!fechaInicio.equals("empty") && !fechaFin.equals("empty")) {
				count.add(Restrictions.sqlRestriction("TRUNC(fecha_datos) between to_date('" + fechaInicio
						+ "','YYYY-MM-DD') and to_date('" + fechaFin + "','YYYY-MM-DD')"));
			}
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);
			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(ViewServicioFacturar.class);
			if (!(idServicio == 0)) {
				crit.add(Restrictions.eq("id_servicio", idServicio));
			}
			if (!(idCliente == 0)) {
				crit.add(Restrictions.eq("id_cliente", idCliente));
			}
			if (!estatus.equals("empty")) {
				crit.add(Restrictions.eq("estatus", estatus));
			}
			if (!fechaInicio.equals("empty") && !fechaFin.equals("empty")) {
				crit.add(Restrictions.sqlRestriction("TRUNC(fecha_datos) between to_date('" + fechaInicio
						+ "','YYYY-MM-DD') and to_date('" + fechaFin + "','YYYY-MM-DD')"));
			}

			crit.addOrder(Order.desc("clave"));
			crit.setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("consulta", crit.list());
			break;

		default:
			break;
		}
	}

	@Override
	public void crudServicioFacturar(Model model, HttpServletRequest request, String event, String listaSeleccion,
			Integer idMoneda, Integer idCliente, Integer idServicio, String fechaDatos, String estatus) {
		switch (event) {
		case "updateList":
			String[] partrInsert = listaSeleccion.split(Pattern.quote("||"));
			int numInserts = 1;
			for (String part : partrInsert) {
				String[] part2 = part.split(Pattern.quote(","));

				String id_cliente_clave = part2[0];
				String fechaDato = part2[2];
				String totalTransaccionesEmisor = part2[3];
				String totalImporteEmisor = part2[4];
				String totalTransaccionesAdquirente = part2[5];
				String totalImporteAdquirente = part2[6];
				String estatu = part2[8];
				Query query = procesoGeneral.getSession()
						.createSQLQuery("update TBL_SIF_SERVICIOS_FACTURAR set total_trans_emisor=?"
								+ ",total_importe_emisor=?, total_trans_adq=?, total_importe_adq=?"
								+ " " + " where FECHA_DATOS=TO_DATE(?, 'dd-MM-yyyy') " 
								+ " and ESTATUS=? and ID_SERVICIO=? and id_cliente=?");
				query.setParameter(0,totalTransaccionesEmisor);
				query.setParameter(1,totalImporteEmisor);
				query.setParameter(2,totalTransaccionesAdquirente);
				query.setParameter(3,totalImporteAdquirente);
				query.setParameter(4,fechaDato);
				query.setParameter(5,estatu);
				query.setParameter(6,idServicio);
				query.setParameter(7,id_cliente_clave);
				query.executeUpdate();

				numInserts++;
			}

			break;
		case "delete":
			String[] variablesLista = listaSeleccion.split(Pattern.quote("||"));
			int numInsert = 1;
			for (String registro : variablesLista) {
				String[] columna = registro.split(Pattern.quote(","));

				String idServicioRow = columna[0];
				String estatusRow = columna[1];
				String idClienteRow = columna[2];
				String fechaDatoRow = columna[3];
				Query query = procesoGeneral.getSession()
						.createSQLQuery("update tbl_sif_servicios_facturar set estatus='ELI', usuario=?,"
										+ " fecha_mod=sysdate  where id_servicio=?"
										+ " and estatus=? and id_cliente=?"
										+ " and fecha_datos= TO_DATE(?,'dd-MM-yyyy')");
				query.setParameter(0,procesoGeneral.getSesionActual());
				query.setParameter(1,idServicioRow);
				query.setParameter(2,estatusRow);
				query.setParameter(3,idClienteRow);
				query.setParameter(4,fechaDatoRow);
				query.executeUpdate();
				numInsert++;
			}

			break;

		case "edit":

			Criteria crit = procesoGeneral.getSession().createCriteria(ViewServicioFacturar.class);
			if (!(idServicio == 0)) {
				crit.add(Restrictions.eq("id_servicio", idServicio));
			}
			if (!estatus.equals("empty")) {
				crit.add(Restrictions.eq("estatus", estatus));
			}
			if (!fechaDatos.equals("empty")) {
				crit.add(Restrictions.sqlRestriction("fecha_datos=TO_DATE('" + fechaDatos + "' , 'dd-MM-yyyy')"));
			}
			if (!(idMoneda == 0)) {
				crit.add(Restrictions.eq("id_moneda", idMoneda));
			}

			crit.addOrder(Order.desc("clave"));
			model.addAttribute("idServicio", idServicio);
			model.addAttribute("consulta", crit.list());

			break;
		default:
			break;
		}

	}

}
