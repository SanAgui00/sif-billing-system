/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente : D-52-8268-17                         Fecha: 01/06/2018 #
# Descripcion General : Clase de implementacion para adquisiciones manuales	   #
# Marca del cambio    : LOGASIF									               #
################################################################################
**/
package com.prosa.sif.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.prosa.sif.operation.ProcesoGeneral;
import com.prosa.sif.pojo.BeanCobrosPendientes;
import com.prosa.sif.pojo.BeanHistoricoSolicitud;
import com.prosa.sif.pojo.BeanNuevaSolicitud;
import com.prosa.sif.pojo.BeanSecuencia;
import com.prosa.sif.pojo.BeanVerificarSolicitud;
import com.prosa.sif.pojo.TBL_SIF_SERVICIOS_FACTURAR;
import com.prosa.sif.pojo.TablaFuente;
import com.prosa.sif.pojo.TablaSubConceptos;

@Transactional
@Repository
@SuppressWarnings("all")
public class AdquisicionManualDaoImpl implements AdquisicionManualDao {
	@Autowired
	private ProcesoGeneral procesoGeneral;

	@Override
	public void queryHistorico(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			String fecha_inicial, String fecha_final, String usuario, Integer id_fuente) {
		switch (tipo) {
		case "consulta":
			Query queryConsulta = procesoGeneral.getSession().createSQLQuery(
					"select a.id_servicio as \"id_servicio\", b.clave as \"clave\", b.descripcion as \"descripcion\", a.fecha_datos as \"fecha_datos\", a.fecha_cobro_area_op as \"fecha_cobro_area_op\", a.estatus as \"estatus\", a.fecha_cre as \"fecha_cre\", a.usuario as \"usuario\", sum(nvl(a.total_trans_emisor,0)) as \"total_trans_emisor\",  sum(nvl(a.total_trans_adq,0)) as \"total_trans_adq\",   sum(nvl(a.total_importe_emisor,0)) as \"total_importe_emisor\", sum(nvl(a.total_importe_adq,0)) as \"total_importe_adq\",  sum(nvl(a.costo_servicio,0)) as \"total_cobranza\"  from tbl_sif_servicios_facturar a , tbl_sif_servicios b where a.id_servicio = b.id_servicios"
							+ " and a.id_servicio =?"
							+ " and a.fecha_datos between to_date(?, 'yyyy/mm/dd') and to_date(?, 'yyyy/mm/dd')"
							+ " and a.usuario = nvl('', a.usuario)  group by a.id_servicio,  a.estatus, a.fecha_cre, b.descripcion, a.usuario, a.fecha_datos, a.fecha_cobro_area_op, b.clave  order by a.fecha_datos desc, a.fecha_cre desc, a.estatus asc");
			queryConsulta.setParameter(0, id_fuente);
			queryConsulta.setParameter(1, fecha_inicial);
			queryConsulta.setParameter(2, fecha_final);
			queryConsulta.setResultTransformer(Transformers.aliasToBean(BeanHistoricoSolicitud.class));
			model.addAttribute("consulta", queryConsulta.list());
			break;

		default:
			break;
		}
	}

	@Override
	public void queryVerificar(String tipo, Model model, HttpServletRequest request, Integer id_periodo,
			Integer id_servicio, Integer fromRow) {
		switch (tipo) {
		case "consulta":
			Query queryConsulta = procesoGeneral.getSession().createSQLQuery(
					"select a.id_servicio as \"id_servicio\", a.id_moneda as \"id_moneda\", a.fecha_datos as \"fecha_datos\", a.estatus as \"estatus\", b.descripcion as \"descripcion\",c.nombre_moneda as \"nombre_moneda\", a.usuario as \"usuario\",a.fecha_cobro_area_op as \"fecha_cobro_area_op\",sum(a.total_trans_emisor) as \"total_trans_emisor\", sum(round(a.total_importe_emisor,4)) as \"total_importe_emisor\",sum(round(a.total_iva_emisor,4)) as \"total_iva_emisor\", sum(a.total_trans_adq) as \"total_trans_adq\", sum(round(a.total_importe_adq,4)) as \"total_importe_adq\", b.clave as \"clave\", trunc(a.fecha_calculo) as \"fecha_calculo\",max(a.fecha_cre) as \"fecha_cre\",d.id_cliente as \"id_cliente\",d.clave_cliente as \"clave_cliente\",d.nombre_corto as \"nombre_corto\"  from tbl_sif_servicios_facturar a , tbl_sif_servicios b, tbl_sif_cat_monedas c, tbl_sif_cat_clientes d where a.id_servicio = b.id_servicios and a.id_moneda = c.id_moneda(+) and a.id_cliente = d.id_cliente and a.fecha_datos between to_date('01/07/2007','dd/mm/yyyy') and to_date('31/07/2007','dd/mm/yyyy') and a.estatus in ('MAN','EDI') and b.clave =nvl( ('S1501'), b.clave) and d.clave_cliente = nvl(('') , d.clave_cliente ) group by a.id_servicio , a.estatus, a.fecha_datos , a.id_moneda, b.descripcion, c.nombre_moneda, a.usuario, a.fecha_cobro_area_op, b.clave, trunc(a.fecha_calculo),d.id_cliente,d.clave_cliente,d.nombre_corto   order by a.estatus asc, b.clave asc, d.clave_cliente, a.fecha_datos asc");
			queryConsulta.setResultTransformer(Transformers.aliasToBean(BeanVerificarSolicitud.class));
			model.addAttribute("consulta", queryConsulta.list());
			break;

		default:
			break;
		}
	}

	@Override
	public void querySolicitud(String tipo, Model model, HttpServletRequest request, Integer id_servicio) {
		String consulta = "";

		switch (tipo) {
		case "consulta":
			consulta = "select x.ID as \"id\", x.ID_CLIENTE as \"id_cliente\", x.ID_SERVICIO as \"id_servicio\", serv.CLAVE as \"clave_servicio\", "
					+ " cli.CLAVE_CLIENTE as \"clave_cliente\", cli.NOMBRE_CORTO as \"nombre_corto\", "
					+ " ume.UNIDAD_MEDIDA as \"unidad_medida\", serv.TIPO_CARGO as \"tipo_cargo\", serv.B_PRECIO_CONTROLADO as \"precio_controlado\", "
					+ " serv.ID_PRECIO as \"id_precio\", serv.ID_MONEDA_IMPORTE_ADQ as \"id_moneda\" "
					+ " from TBL_SIF_SERVICIOS_CLIENTES x, TBL_SIF_CAT_CLIENTES cli, TBL_SIF_SERVICIOS serv, TBL_SIF_CAT_UNIDAD_MEDIDA ume"
					+ " where x.ID_CLIENTE=cli.ID_CLIENTE and ((x.ESTATUS='ACT' )and(cli.ESTATUS='ACT'  and x.ID_CLIENTE=cli.ID_CLIENTE)"
					+ " and(serv.ESTATUS='ACT'  and x.ID_SERVICIO=serv.ID_SERVICIOS)"
					+ " and(serv.ID_SERVICIOS=:id_servicio and x.ID_SERVICIO=serv.ID_SERVICIOS) and (serv.UNIDAD_MEDIDA=ume.UNIDAD_MEDIDA))"
					+ " order by  cli.CLAVE_CLIENTE asc";
			Query query = procesoGeneral.getSession().createSQLQuery(consulta)
					.setResultTransformer(Transformers.aliasToBean(BeanNuevaSolicitud.class));
			query.setParameter("id_servicio", id_servicio);
			model.addAttribute("consulta", query.list());

			consulta = "select x.ID AS \"id\", x.ID_SERVICIOS as \"id_servicios\", x.NUMERO as \"numero\", "
					+ " x.DESCRIPCION as \"descripcion\", x.VALOR as \"valor\", x.ID_PRECIO as \"id_precio\" "
					+ " FROM TBL_SIF_SUBCONCEPTOS x WHERE ID_SERVICIOS=:id_servicio ORDER BY NUMERO";
			Query query2 = procesoGeneral.getSession().createSQLQuery(consulta)
					.setResultTransformer(Transformers.aliasToBean(TablaSubConceptos.class));
			query2.setParameter("id_servicio", id_servicio);
			model.addAttribute("conSubConceptos", query2.list());

			break;

		default:
			break;
		}
	}

	@Override
	public void enviarSolicitud(Model model, HttpServletRequest request, Integer id_moneda, String tipo_cargo,
			String datos, String subconceptos, Integer id_servicio, Date fecha_datos, Date fechaSol,
			String fecha_operativa, String uMedida, Integer conceptos, String comentarios) {

		// VARIABLES INSERTAR EN TBL_SIF_SERVICIOS_FACTURAR
		String totalesAll = "";
		String clienteInser = "";
		String totalInser = "";
		Number id_servicios_facturar = 0;
		
		// VARIABLES PARA INSERTAR TBL_SIF_SUBCONCEPTOS_FACTURAR
		String id_servicio_facturar = "";
		String numeroSub = "";
		String descripSub = "";
		String totalSub = "";
		String secue= "";
		
		// Split de datos
		String[] datosSplit = datos.split(Pattern.quote("||"));

		for (String datosSplit1 : datosSplit) {
			String[] datosSplitComa = datosSplit1.split(Pattern.quote(","));

//			obtener secuencia
			String consultaId = "select SEC_SIF_SERVICIOS_FAC.nextval as \"secuencia\" from dual";
			Query queryId = procesoGeneral.getSession().createSQLQuery(consultaId)
					.setResultTransformer(Transformers.aliasToBean(BeanSecuencia.class));
			List<BeanSecuencia> rs = queryId.list();
			
			for(int i=0;i<rs.size();i++){
				
				BeanSecuencia fuente_r = rs.get(i);
				id_servicios_facturar = fuente_r.getSecuencia();
				secue += id_servicios_facturar + ",";

			} 
			
			for (int i = 0; i <= datosSplitComa.length; i++) {

				if (i == 0) {
					clienteInser = datosSplitComa[i];
				}
				if (i > 0 && i < datosSplitComa.length - 1) {

					if (i < datosSplitComa.length - 2) {
						totalesAll += datosSplitComa[i] + ",";

					} else {
						totalesAll += datosSplitComa[i];
					}
				}
				if (i == datosSplitComa.length - 1) {
					totalInser = datosSplitComa[i];
				}
			}
			totalesAll = totalesAll + "||";

			// insert TBL_SIF_SERVICIOS_FACTURAR
			
				Query insert = procesoGeneral.getSession().createSQLQuery("insert into TBL_SIF_SERVICIOS_FACTURAR"
						+ " (ID_SERVICIOS_FACTURAR, ID_SERVICIO, ID_CLIENTE, FECHA_DATOS, "
						+ " TOTAL_TRANS_EMISOR, TOTAL_IMPORTE_EMISOR, TOTAL_TRANS_ADQ, TOTAL_IMPORTE_ADQ,"
						+ " ESTATUS_CALCULO, ESTATUS_REGISTRO_CONTABLE, ESTATUS_COBRO, ESTATUS_FACTURA, ID_MONEDA, "
						+ " FECHA_COBRO_AREA_OP, USUARIO, ESTATUS, FECHA_CRE,FECHA_MOD, COMENTARIOS) "
						+ " values (:id_servicios_facturar, :id_servicio, :id_cliente, to_date('" + fecha_datos
						+ "', 'yyyy-MM-dd'), "
						+ " decode(:tipo_cargo,'EMISOR',(decode(:uMedida,'TRANSACCION',:total_importe,null)),null), " 
						+ "	decode(:tipo_cargo,'EMISOR',(decode(:uMedida,'MONTO',:total_importe,null)),null), "
						+ "	decode(:tipo_cargo,'ADQUIRENTE',(decode(:uMedida,'TRANSACCION',:total_importe,null)),null), "
						+ "	decode(:tipo_cargo,'ADQUIRENTE',(decode(:uMedida,'MONTO',:total_importe,null)),null), "
						+ " 'PEN', 'PEN', 'PEN', 'PEN', :id_moneda, to_date(decode('" + fecha_operativa + "','empty',null,'" + fecha_operativa + "'), 'yyyy-MM-dd'), "
						+ " :usuario, 'NOR', sysdate, sysdate, :comentarios)");
				
				insert.setParameter("id_servicios_facturar", id_servicios_facturar);
				insert.setParameter("id_servicio", id_servicio);
				insert.setParameter("id_cliente", clienteInser);
				insert.setParameter("tipo_cargo", tipo_cargo);
				insert.setParameter("uMedida", uMedida);
				insert.setParameter("total_importe", totalInser);
				insert.setParameter("id_moneda", id_moneda);
				insert.setParameter("usuario", procesoGeneral.getSesionActual());
				insert.setParameter("comentarios", comentarios);

				insert.executeUpdate();

		}

		if (conceptos > 1) {
			
			// Split de secuencia
			String[] secueSpli = secue.split(Pattern.quote(","));

			// Split de totalesAll
			String[] totalesAllSplit = totalesAll.split(Pattern.quote("||"));

			for (int y = 0; y < totalesAllSplit.length; y++) {
				String[] totalesAllSplitComa = totalesAllSplit[y].split(Pattern.quote(","));

				// Split de subconceptos
				String[] subconceptosSplit = subconceptos.split(Pattern.quote("&&"));

				for (int j = 1; j < subconceptosSplit.length - 1; j++) {
					String[] subconceptosSplitComa = subconceptosSplit[j].split(Pattern.quote(","));
					
					id_servicio_facturar = secueSpli[y];

					for (int i = 0; i <= subconceptosSplitComa.length; i++) {

						if (i == 0) {
							numeroSub = subconceptosSplitComa[i];
						}
						if (i == subconceptosSplitComa.length - 1) {
							descripSub = subconceptosSplitComa[i];
						}
					}
					int x = j - 1;
					totalSub = totalesAllSplitComa[x];

						// query insertar TBL_SIF_SUBCONCEPTOS_FACTURAR
						Query insertSub = procesoGeneral.getSession()
								.createSQLQuery("insert into TBL_SIF_SUBCONCEPTOS_FACTURAR"
										+ " (ID_SERVICIO_FACTURAR, NUMERO_SUBCONCEPTO, DESCRIPCION, "
										+ " TOTAL_TRANS_EMISOR,TOTAL_MONTO_EMISOR, TOTAL_TRANS_ADQ, TOTAL_MONTO_ADQ) "
										+ " values (:id_servicio_facturar, :numeroSub, :descripSub,"
										+ " 		decode(:tipo_cargo,'EMISOR',(decode(:uMedida,'TRANSACCION',:totalSub,null)),null)," 
										+ "         decode(:tipo_cargo,'EMISOR',(decode(:uMedida,'MONTO',:totalSub,null)),null),"  
										+ "         decode(:tipo_cargo,'ADQUIRENTE',(decode(:uMedida,'TRANSACCION',:totalSub,null)),null),"  
										+ "         decode(:tipo_cargo,'ADQUIRENTE',(decode(:uMedida,'MONTO',:totalSub,null)),null))");
						
						insertSub.setParameter("id_servicio_facturar", id_servicio_facturar);
						insertSub.setParameter("numeroSub", numeroSub);
						insertSub.setParameter("descripSub", descripSub);
						insertSub.setParameter("tipo_cargo", tipo_cargo);
						insertSub.setParameter("uMedida", uMedida);
						insertSub.setParameter("totalSub", totalSub);

						insertSub.executeUpdate();

				}
			}
		}
		
		model.addAttribute("insert", "La solicitud fue enviada");

	}

}
