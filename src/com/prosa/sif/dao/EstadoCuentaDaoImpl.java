/**
################################################################################
# Autor               : Garnica                                                #
# Compania            : Código Geek                                            #
# Proyecto/Procliente : Implement de Estado de Cuenta        Fecha: 08/03/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/
package com.prosa.sif.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.transaction.annotation.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.prosa.sif.operation.ProcesoGeneral;
import com.prosa.sif.pojo.BeanEstadoCobranza;
import com.prosa.sif.pojo.BeanRedesLogica;
import com.prosa.sif.pojo.TablaBitacoraAdq;
import com.prosa.sif.pojo.TablaCliente;
import com.prosa.sif.pojo.ViewEstadoCuenta;
/**
 * 
 * @author David Garnica Garcia
 *
 */
@Repository
@Transactional
@SuppressWarnings("all")
public class EstadoCuentaDaoImpl implements EstadoCuentaDao {
	@Autowired
	private ProcesoGeneral procesoGeneral;
	
	private static String mens = "ParseException";

	@Override
	public void listaEstadoCuenta(String string, Integer fromRow, Model model, Integer periodo, Integer cliente,
			Integer moneda, HttpServletRequest request) {
		
		switch (string) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(ViewEstadoCuenta.class)
					.add(Restrictions.eq("id_cliente", cliente)).add(Restrictions.eq("id_periodo", periodo))
					.add(Restrictions.eq("mon_id_moneda", moneda));
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			
			model.addAttribute("registros_totales", registrosTotales);
			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(ViewEstadoCuenta.class)
					.add(Restrictions.eq("id_cliente", cliente)).add(Restrictions.eq("id_periodo", periodo))
					.add(Restrictions.eq("mon_id_moneda", moneda)).addOrder(Order.desc("tipo_doc"))
					.addOrder(Order.desc("clave_neg"));
			crit.setFirstResult(fromRow).setMaxResults(15);
			
			model.addAttribute("consulta", crit.list());
			break;
		default:
			break;

		}
	}

	@Override
	public void listaEstadoCobranzaDiaria(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			Integer proceso, Integer moneda, String cliente, String negocio, String fecha_inicial,
			String fecha_final) {
		String[] clientes=cliente.split(Pattern.quote("&&"));
		String[] negocios=negocio.split(Pattern.quote("||"));
		model.addAttribute("cliente",clientes[0]);
		model.addAttribute("clave_cliente", clientes[1]);
		model.addAttribute("nombre_corto", clientes[2]);
		model.addAttribute("negocio",negocios[0]);
		switch (tipo) {
		case "count":
			String consulta = "SELECT cs.clave_cliente AS \"cv_banco\",cs.nombre_corto AS \"nm_banco\",ns.clave AS \"cv_negocio\","
					+ "ns.descripcion AS \"nm_negocio\",SF.fecha_datos AS \"fecha_datos\",dp.fecha_cobro AS \"fecha_cobro\","
					+ "ss.clave AS \"cv_servicio\",ss.descripcion AS \"nm_servicio\",SF.id_moneda AS \"cv_moneda\","
					+ "ms.nombre_moneda AS \"nm_moneda\",tc.tipo_cambio AS \"tipo_cambio\","
					+ "SUM(DECODE(SF.TOTAL_TRANS_EMISOR,NULL,SF.TOTAL_TRANS_ADQ,0,SF.TOTAL_TRANS_ADQ,SF.TOTAL_TRANS_EMISOR )) Trx, "
					+ "SUM(NVL(SF.COSTO_SERVICIO,0)+NVL(SF.DESCUENTO,0)+NVL(rp.ajuste,0)) Importe,SUM(NVL(SF.DESCUENTO,0)) Descuento,"
					+ "NVL(rp.TOTAL_REBATE,0) Descuento_Adicional,"
					+ "SUM(ROUND((NVL(SF.COSTO_SERVICIO,0)+NVL(rp.ajuste,0)-NVL(rp.TOTAL_REBATE,0))*(cs.PCT_IVA/100),2)) Iva, "
					+ "SUM(ROUND((NVL(SF.COSTO_SERVICIO,0)+NVL(rp.ajuste,0)-NVL(rp.TOTAL_REBATE,0))*(1+(cs.PCT_IVA/100)),2)) Total "
					+ "FROM TBL_SIF_SERVICIOS_FACTURAR SF , (SELECT e.id_negocio ,d.id_moneda ,d.id_servicio  ,d.id_cliente ,"
					+ "MAX(c.fecha_referencia ) fecha_datos  ,d.CALCULO_AJUSTE_NETO ajuste ,d.total_rebate ,"
					+ "TRUNC(NVL(d.total_rebate,0)*f.pct_iva/100,2) iva_rebate FROM TBL_SIF_RESU_PERIO_SERV_CLI d,TBL_SIF_CAT_DIAS_PERIODO c,"
					+ "TBL_SIF_SERVICIOS e,TBL_SIF_CAT_CLIENTES f WHERE  c.id_periodo = d.id_periodo AND d.id_servicio = e.id_servicios"
					+ " AND d.id_cliente = f.id_cliente AND c.fecha_referencia BETWEEN to_date('" + fecha_inicial
					+ "','yyyy/mm/dd') AND " + "to_date('" + fecha_final
					+ "','yyyy/mm/dd') GROUP BY e.id_negocio,d.id_moneda,d.id_servicio,d.id_cliente,"
					+ "d.CALCULO_AJUSTE_NETO, d.total_rebate,f.pct_iva) rp ,TBL_SIF_CAT_CLIENTES cs ,TBL_SIF_SERVICIOS ss ,"
					+ "TBL_SIF_CAT_DIAS_PERIODO dp ,TBL_SIF_TIPOS_CAMBIO tc ,TBL_SIF_CAT_NEGOCIOS ns ,TBL_SIF_CAT_MONEDAS ms"
					+ " WHERE SF.id_moneda = rp.id_moneda(+)  AND SF.id_servicio = rp.id_servicio(+)  AND SF.id_cliente = rp.id_cliente (+)  "
					+ "AND SF.fecha_datos = rp.fecha_datos(+)   AND SF.id_cliente = cs.id_cliente  AND SF.id_servicio = ss.id_servicios   "
					+ "AND SF.fecha_datos = dp.fecha_referencia  AND SF.fecha_datos = tc.fecha_tipo_cambio  AND ss.id_negocio = ns.id_negocio  "
					+ "AND SF.id_moneda = ms.id_moneda   AND SF.fecha_datos BETWEEN  to_date('" + fecha_inicial
					+ "','yyyy/mm/dd') " + "AND to_date('" + fecha_final + "','yyyy/mm/dd') and cs.id_cliente="
					+ clientes[0] + "  and ns.id_proceso=" + proceso + "  and ns.id_negocio=" + negocios[0];
			if (moneda == 0) {
				consulta.concat(" and SF.id_moneda=" + moneda + " ");
			}
			consulta = consulta.concat(
					" AND SF.estatus_calculo = 'CAL'  AND ss.estatus = cs.estatus  AND cs.estatus = 'ACT' GROUP BY"
							+ " cs.clave_cliente,cs.nombre_corto,ns.clave,ns.descripcion, SF.fecha_datos,dp.fecha_cobro,ns.clave,"
							+ "ns.descripcion,ss.clave,ss.descripcion,SF.id_moneda,ms.nombre_moneda,tc.tipo_cambio,NVL(rp.TOTAL_REBATE,0)");
			Query count = procesoGeneral.getSession().createSQLQuery(consulta);
			model.addAttribute("registros_totales", count.list().size());
			break;
		case "consulta":
			consulta = "SELECT cs.clave_cliente AS \"cv_banco\",cs.nombre_corto AS \"nm_banco\",ns.clave AS \"cv_negocio\","
					+ "ns.descripcion AS \"nm_negocio\",SF.fecha_datos AS \"fecha_datos\",dp.fecha_cobro AS \"fecha_cobro\","
					+ "ss.clave AS \"cv_servicio\",ss.descripcion AS \"nm_servicio\",SF.id_moneda AS \"cv_moneda\","
					+ "ms.nombre_moneda AS \"nm_moneda\",tc.tipo_cambio AS \"tipo_cambio\","
					+ "SUM(DECODE(SF.TOTAL_TRANS_EMISOR,NULL,SF.TOTAL_TRANS_ADQ,0,SF.TOTAL_TRANS_ADQ,SF.TOTAL_TRANS_EMISOR )) Trx, "
					+ "SUM(NVL(SF.COSTO_SERVICIO,0)+NVL(SF.DESCUENTO,0)+NVL(rp.ajuste,0)) Importe,SUM(NVL(SF.DESCUENTO,0)) Descuento,"
					+ "NVL(rp.TOTAL_REBATE,0) Descuento_Adicional,"
					+ "SUM(ROUND((NVL(SF.COSTO_SERVICIO,0)+NVL(rp.ajuste,0)-NVL(rp.TOTAL_REBATE,0))*(cs.PCT_IVA/100),2)) Iva, "
					+ "SUM(ROUND((NVL(SF.COSTO_SERVICIO,0)+NVL(rp.ajuste,0)-NVL(rp.TOTAL_REBATE,0))*(1+(cs.PCT_IVA/100)),2)) Total "
					+ "FROM TBL_SIF_SERVICIOS_FACTURAR SF , (SELECT e.id_negocio ,d.id_moneda ,d.id_servicio  ,d.id_cliente ,"
					+ "MAX(c.fecha_referencia ) fecha_datos  ,d.CALCULO_AJUSTE_NETO ajuste ,d.total_rebate ,"
					+ "TRUNC(NVL(d.total_rebate,0)*f.pct_iva/100,2) iva_rebate FROM TBL_SIF_RESU_PERIO_SERV_CLI d,TBL_SIF_CAT_DIAS_PERIODO c,"
					+ "TBL_SIF_SERVICIOS e,TBL_SIF_CAT_CLIENTES f WHERE  c.id_periodo = d.id_periodo AND d.id_servicio = e.id_servicios"
					+ " AND d.id_cliente = f.id_cliente AND c.fecha_referencia BETWEEN to_date('" + fecha_inicial
					+ "','yyyy/mm/dd') AND " + "to_date('" + fecha_final
					+ "','yyyy/mm/dd') GROUP BY e.id_negocio,d.id_moneda,d.id_servicio,d.id_cliente,"
					+ "d.CALCULO_AJUSTE_NETO, d.total_rebate,f.pct_iva) rp ,TBL_SIF_CAT_CLIENTES cs ,TBL_SIF_SERVICIOS ss ,"
					+ "TBL_SIF_CAT_DIAS_PERIODO dp ,TBL_SIF_TIPOS_CAMBIO tc ,TBL_SIF_CAT_NEGOCIOS ns ,TBL_SIF_CAT_MONEDAS ms"
					+ " WHERE SF.id_moneda = rp.id_moneda(+)  AND SF.id_servicio = rp.id_servicio(+)  AND SF.id_cliente = rp.id_cliente (+)  "
					+ "AND SF.fecha_datos = rp.fecha_datos(+)   AND SF.id_cliente = cs.id_cliente  AND SF.id_servicio = ss.id_servicios   "
					+ "AND SF.fecha_datos = dp.fecha_referencia  AND SF.fecha_datos = tc.fecha_tipo_cambio  AND ss.id_negocio = ns.id_negocio  "
					+ "AND SF.id_moneda = ms.id_moneda   AND SF.fecha_datos BETWEEN  to_date('" + fecha_inicial
					+ "','yyyy/mm/dd') " + "AND to_date('" + fecha_final + "','yyyy/mm/dd') and cs.id_cliente="
					+ clientes[0] + "  and ns.id_proceso=" + proceso + "  and ns.id_negocio=" + negocios[0];
			if (moneda == 0) {
				consulta.concat(" and SF.id_moneda=" + moneda + " ");
			}
			consulta = consulta.concat(
					" AND SF.estatus_calculo = 'CAL'  AND ss.estatus = cs.estatus  AND cs.estatus = 'ACT' GROUP BY"
							+ " cs.clave_cliente,cs.nombre_corto,ns.clave,ns.descripcion, SF.fecha_datos,dp.fecha_cobro,ns.clave,"
							+ "ns.descripcion,ss.clave,ss.descripcion,SF.id_moneda,ms.nombre_moneda,tc.tipo_cambio,NVL(rp.TOTAL_REBATE,0)");
			consulta = consulta.concat(" OFFSET " + fromRow + " ROWS FETCH NEXT 15 ROWS ONLY");
			Query query = procesoGeneral.getSession().createSQLQuery(consulta)
					.setResultTransformer(Transformers.aliasToBean(BeanEstadoCobranza.class));
			model.addAttribute("consulta", query.list());
			break;

		default:
			break;

		}

	}

	@Override
	public void jasperCobranzaDiaria(Model model, HttpServletRequest request, HttpServletResponse response,
			Integer proceso, Integer moneda, String cliente, String negocio, String fecha_inicial, String fecha_final,
			String tipo) {
		// TODO Auto-generated method stub
		String in = request.getSession().getServletContext().getRealPath("/imagenes/logo1.jpg");
		String consulta = "";
		String[] clientes=cliente.split(Pattern.quote("&&"));
		String[] negocios=negocio.split(Pattern.quote("||"));
		
		Map parameters = new HashMap();
		parameters.put("reportHomePath", in);
		parameters.put("id_proceso", new Long(proceso));
		parameters.put("id_moneda", new Long(moneda));
		parameters.put("clave_cliente", clientes[1]);
		parameters.put("nm_cliente", clientes[2]);
		parameters.put("id_negocio", new Long(Integer.parseInt(negocios[0])));
		parameters.put("clave_negocio", negocios[1]);
		
		DateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date fecha_inicialconv = fecha.parse(fecha_inicial);
			Date fecha_finalconv = fecha.parse(fecha_final);
			java.sql.Date sqlini = new java.sql.Date(fecha_inicialconv.getTime());
			java.sql.Date sqlfin = new java.sql.Date(fecha_finalconv.getTime());
			
			parameters.put("fecha_ini", sqlini);
			parameters.put("fecha_fin", sqlfin);
		} catch (ParseException e) {
			procesoGeneral.loggerErr(mens, request, e);
		}
		
		procesoGeneral.GenerarReporte(null, request, response, consulta, "estado_de_cuenta_v3", "estado_de_cuenta_v3",
				tipo, parameters);
	}

}
