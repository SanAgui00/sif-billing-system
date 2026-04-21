package com.prosa.sif.dao;

import java.lang.reflect.Array;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.prosa.sif.operation.ProcesoGeneral;
import com.prosa.sif.pojo.BeanCuentaCobrar;
import com.prosa.sif.pojo.BeanMantenerSaldos;

@Repository
@Transactional
@SuppressWarnings("all")
public class CuentaCobrarDaoImpl implements CuentaCobrarDao{

	@Autowired
	private ProcesoGeneral procesoGeneral;
	
	@Override
	public void queryCuentaCobrar(String tipo, Integer fromRow, Integer idCliente, Integer id_moneda,
			String fecha_inicial, String fecha_final, Model model, HttpServletRequest request) {
		
		String consulta= "";
		
		switch (tipo) {
		case "count":
			
			break;
		
		case "consulta":
						consulta = "SELECT   ra.cv_cliente as \"clave_cliente\", ra.nm_cliente as \"nombre_corto\"," +
		                        " SUM (DECODE (ra.tipo_documento, 'NCS', NVL (ra.importe, 0) * -1," +
		                        " 'NOT', NVL (ra.importe, 0) * -1, NVL (ra.importe, 0))) total_importe_neto," +
		                        " SUM (DECODE (ra.tipo_documento, 'NCS', NVL (ra.iva, 0) * -1, 'NOT', NVL (ra.iva, 0) * -1," +
		                        " NVL (ra.iva, 0))) total_importe_iva, SUM (DECODE (ra.tipo_documento," +
		                        " 'NCS', NVL (ra.total, 0) * -1, 'NOT', NVL (ra.total, 0) * -1," +
		                        " NVL (ra.total, 0))) total_importe_documento, ra.id_cliente as \"id_cliente\"" +
		                        " FROM (SELECT DISTINCT DECODE (cb.tipo_documento,'NOT', 'NCS', cb.tipo_documento) tipo_documento," +
		                        " DECODE (cb.tipo_documento, 'SER', '1. FACTURAS DE SERVICIOS', 'NOT', '2. NOTAS DE CREDITO DE SERVICIOS') clave_documento," +
		                        " p.id_proceso id_proceso, p.clave_proceso cv_proceso, p.descripcion nm_proceso, m.id_moneda id_moneda," +
		                        " m.nombre_moneda nm_moneda, c.id_cliente id_cliente, c.clave_cliente cv_cliente," +
		                        " c.nombre_corto nm_cliente, n.id_negocio id_negocio, n.clave cv_negocio, n.descripcion nm_negocio," +
		                        " dp.id_periodo id_periodo,dp.fecha_referencia fecha_datos, dp.fecha_cobro fecha_cobro, cb.folio_temporal folio," +
		                        " cb.descripcion concepto, cb.estatus estatus, NVL (cb.importe_costo, 0) importe, NVL (cb.importe_iva, 0) iva," +
		                        " NVL (cb.importe_costo, 0) + NVL (cb.importe_iva, 0) total" +
		                        " FROM tbl_sif_cobros cb, tbl_sif_cat_clientes c, tbl_sif_cat_dias_periodo dp, " +
		                        " tbl_sif_cat_negocios n, tbl_sif_cat_procesos p, tbl_sif_cat_monedas m WHERE cb.id_cliente = c.id_cliente " +
		                        " AND n.id_negocio = cb.id_negocio AND n.id_proceso = p.id_proceso AND cb.id_moneda_cobro = m.id_moneda " +
		                        " AND dp.fecha_referencia BETWEEN cb.fecha_datos_ini AND cb.fecha_datos_fin AND n.id_proceso = 1 " +
		                        " AND dp.fecha_cobro >= TO_DATE (:fecha_final, 'YYYY-MM-DD') AND cb.estatus = 'ENV'" +
		                        " UNION ALL SELECT DISTINCT DECODE (fa.id_tipo_doc, 1, 'ABI', 2, 'ODT') tipo_documento," +
		                        " DECODE (fa.id_tipo_doc, 1, '3. FACTURAS ABIERTAS', 2, '4. ODTS') clave_documento," +
		                        " p.id_proceso id_proceso, p.clave_proceso cv_proceso, p.descripcion nm_proceso, m.id_moneda id_moneda," +
		                        " m.nombre_moneda nm_moneda, c.id_cliente id_cliente, c.clave_cliente cv_cliente," +
		                        " c.nombre_corto nm_cliente, n.id_negocio id_negocio, n.clave cv_negocio, n.descripcion nm_negocio," +
		                        " dp.id_periodo id_periodo, dp.fecha_referencia fecha_datos, NVL (fa.fecha_cobro, dp.fecha_cobro) fecha_cobro," +
		                        " f.serie || LPAD (f.numero, 6, '0') folio, DECODE (fa.id_tipo_doc, 1, 'FACTURA ABIERTA', 2, 'ODT') concepto," +
		                        " fa.estatus_cobro estatus, NVL (fa.subtotal_monto, 0) importe, NVL (fa.iva_monto, 0) iva, NVL (fa.total_monto, 0) total" +
		                        " FROM tbl_sif_facturas_abiertas fa, tbl_sif_folios f,tbl_sif_cat_clientes c, tbl_sif_cat_dias_periodo dp," +
		                        " tbl_sif_cat_negocios n, tbl_sif_cat_procesos p, tbl_sif_cat_monedas m WHERE fa.id_factura_abierta = f.id_documento" +
		                        " AND fa.id_cliente = c.id_cliente AND fa.id_moneda = m.id_moneda AND fa.id_negocio = n.id_negocio" +
		                        " AND n.id_proceso = p.id_proceso AND fa.fecha_datos = dp.fecha_referencia AND fa.estatus_cobro = 'PEN'" +
		                        " AND f.estatus = 'IMP' AND NVL (f.clave_documento, f.tipo_documento) IN ('ABI', 'ODT') UNION ALL" +
		                        " SELECT DISTINCT 'NOT' tipo_documento, '5. NOTAS DE CREDITO' clave_documento, p.id_proceso id_proceso, p.clave_proceso cv_proceso," +
		                        " p.descripcion nm_proceso, m.id_moneda id_moneda, m.nombre_moneda nm_moneda, c.id_cliente id_cliente," +
		                        " c.clave_cliente cv_cliente, c.nombre_corto nm_cliente, n.id_negocio id_negocio, n.clave cv_negocio, n.descripcion nm_negocio," +
		                        " dp.id_periodo id_periodo, dp.fecha_referencia fecha_datos, dp.fecha_cobro fecha_cobro, f.serie || LPAD (f.numero, 6, '0') folio," +
		                        " 'NOTA DE CREDITO' concepto, nc.estatus_cobro estatus, NVL (nc.subtotal, 0) importe, NVL (nc.iva_monto, 0) iva," +
		                        " NVL (nc.monto_total, 0) total FROM tbl_sif_notas_credito nc, tbl_sif_folios f, tbl_sif_cat_clientes c," +
		                        " tbl_sif_cat_dias_periodo dp, tbl_sif_cat_negocios n, tbl_sif_cat_procesos p, tbl_sif_cat_monedas m" +
		                        " WHERE nc.id_documento = f.id_documento AND nc.id_cliente = c.id_cliente AND nc.id_moneda = m.id_moneda" +
		                        " AND nc.id_negocio = n.id_negocio AND n.id_proceso = p.id_proceso AND nc.fecha_datos = dp.fecha_referencia" +
		                        " AND nc.estatus_cobro = 'PEN' AND f.estatus = 'IMP' AND NVL (f.clave_documento, f.tipo_documento) = 'NOT') ra" +
		                        " WHERE ra.id_moneda = :id_moneda AND ra.fecha_datos BETWEEN TO_DATE (:fecha_inicial, 'YYYY-MM-DD')" +
		                        " AND TO_DATE (:fecha_final, 'YYYY-MM-DD') AND ra.id_cliente = NVL (DECODE(:idCliente,0,ra.id_cliente,:idCliente), ra.id_cliente)" +
		                        " GROUP BY ra.cv_cliente, ra.nm_cliente, ra.id_cliente ";
						Query query = procesoGeneral.getSession().createSQLQuery(consulta)
								.setResultTransformer(Transformers.aliasToBean(BeanCuentaCobrar.class));
						query.setParameter("id_moneda", id_moneda);
						query.setParameter("fecha_inicial", fecha_inicial);
						query.setParameter("fecha_final", fecha_final);
						query.setParameter("idCliente", idCliente);
						model.addAttribute("consulta", query.list());
			break;

		default:
			break;
		}
	}

	@Override
	public void queryMantenerSaldos(String tipo, String radioVal, Integer fromRow, Integer idCliente,
			Integer id_moneda, Integer id_tipo_cuenta, String fecha_aplic, Model model, HttpServletRequest request) {
		
		String consulta= "";
		
		switch (tipo) {
		case "count":
			
			break;
		
		case "consulta":
						consulta = "select c2.CLAVE_CLIENTE as \"clave_cliente\", c2.NOMBRE_CORTO as \"nombre_corto\", tc.DESCRIPCION as \"descripcion\", x.FECHA_APLICACION as \"fecha_aplicacion\", x.NUMERO_CUENTA as \"numero_cuenta\", x.IMPORTE as \"importe\", " + 
								" x.FECHA_CRE as \"fecha_cre\", x.ID_CLIENTE as \"id_cliente\", x.ID_MONEDA as \"id_moneda\", x.ID_TIPO_CUENTA as \"id_tipo_cuenta\", m2.NOMBRE_MONEDA as \"nombre_moneda\" from TBL_SIF_SALDOS_CUENTAS x, tbl_sif_cat_monedas m2, TBL_SIF_CAT_CLIENTES c2, TBL_SIF_CAT_TIPO_CUENTAS tc where (x.ID_TIPO_CUENTA= "+id_tipo_cuenta+" ) " + 
								"and(x.NUMERO_CUENTA IN(SELECT t1.NUMERO_CUENTA " + 
								"FROM TBL_SIF_CAT_CUENTAS_CLIENTES t1, TBL_SIF_CAT_TIPO_CUENTAS t2 WHERE t1.ID_TIPO_CTA_CONTABLE = t2.ID_TIPO_CUENTA " ;
						if (idCliente!=0) {
							consulta = consulta.concat(" AND t1.ID_CLIENTE = "+idCliente+" ");
						}
						consulta = consulta.concat(" AND t1.ID_TIPO_CTA_CONTABLE = "+id_tipo_cuenta+" ))");
						
						if (!fecha_aplic.equals("null")) {
							consulta = consulta.concat(" and(x.FECHA_APLICACION=to_date('" + fecha_aplic + "' , 'YYYY-MM-DD')) ");
						}
						
						if (idCliente!=0) {
							consulta = consulta.concat(" AND x.ID_CLIENTE = "+idCliente+" AND (c2.ID_CLIENTE= "+idCliente+")");
						}
						if (id_moneda!=0) {
							consulta = consulta.concat(" and(x.ID_MONEDA= "+id_moneda+") AND (m2.ID_MONEDA= "+id_moneda+")");
						}
						
						if (idCliente==0) {
							consulta = consulta.concat(" AND (c2.ID_CLIENTE= x.ID_CLIENTE)");
						}
						if (id_moneda==0) {
							consulta = consulta.concat(" AND (m2.ID_MONEDA= x.ID_MONEDA)");
						}
						
						consulta = consulta.concat(" and (tc.ID_TIPO_CUENTA= "+id_tipo_cuenta+")");
						Query query = procesoGeneral.getSession().createSQLQuery(consulta)
								.setResultTransformer(Transformers.aliasToBean(BeanMantenerSaldos.class));
				
							model.addAttribute("consulta", query.list());
							model.addAttribute("radioVal", radioVal);
						
			break;

		default:
			break;
		}
		
	}

	@Override
	public void guardarMantenerSaldos(String variables) {
		String var = variables;
		String[] var_temp;
		String var_delimiter = ",";
		var_temp = var.split(var_delimiter);
			String numero_cuenta = (String) Array.get(var_temp, 0);
			String fecha_aplicacion = (String) Array.get(var_temp, 1);
			double importe = Double.parseDouble((String) Array.get(var_temp, 2));
			String fecha_cre = (String) Array.get(var_temp, 3);
			int id_tipo_cuenta = Integer.parseInt((String) Array.get(var_temp, 4));
			int id_cliente = Integer.parseInt((String) Array.get(var_temp, 5));
			int id_moneda = Integer.parseInt((String) Array.get(var_temp, 6));
			Query query = procesoGeneral.getSession()
					.createQuery("update TBL_SIF_SALDOS_CUENTAS set NUMERO_CUENTA=:numero_cuenta, IMPORTE=:importe,"
							+ " USUARIO=:usu, FECHA_CRE=to_date(:fecha_cre,'DD-MM-YYYY'), FECHA_MOD=sysdate where FECHA_APLICACION=to_date(:fecha_aplicacion,'DD-MM-YYYY')"
							+ " and ID_TIPO_CUENTA=:id_tipo_cuenta and ID_CLIENTE=:id_cliente and ID_MONEDA=:id_moneda");

			query.setParameter("numero_cuenta", numero_cuenta);
			query.setParameter("importe", importe);
			query.setParameter("usu", procesoGeneral.getSesionActual());
			query.setParameter("fecha_cre", fecha_cre);
			
			query.setParameter("fecha_aplicacion", fecha_aplicacion);
			query.setParameter("id_tipo_cuenta", id_tipo_cuenta);
			query.setParameter("id_cliente", id_cliente);
			query.setParameter("id_moneda", id_moneda);	
			query.executeUpdate();
//		}
		
	}

}
