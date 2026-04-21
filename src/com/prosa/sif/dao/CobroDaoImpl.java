/**
################################################################################
# Autor               : Garnica Garcia David                                   #
# Compania            : C�digo Geek                                            #
# Proyecto/Procliente :                                      Fecha: 25/04/2018 #
# Descripcion General : Implement de cobro                                     #
# Marca del cambio    :                                                        #
#------------------------------------------------------------------------------#
# Numero de Parametros: N/A                                                    #
# Parametros Entrada  : N/A                                  Formato:          #
# Parametros Salida   : N/A                                  Formato:          #
################################################################################
**/
package com.prosa.sif.dao;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import java.util.regex.Pattern;
import com.prosa.sif.operation.ProcesoGeneral;
import com.prosa.sif.pojo.BeanCobrosFinancieros;
import com.prosa.sif.pojo.BeanCobrosPendientes;
import com.prosa.sif.pojo.TBL_SIF_COBROS;


@Repository
@Transactional
@SuppressWarnings("all")
public class CobroDaoImpl implements CobroDao {
	@Autowired
	private ProcesoGeneral procesoGeneral;

	@Override
	public void queryEnviarCifras(String tipo, Model model, Integer fromRow, Integer id_cliente, Integer proceso,
			Integer negocio, String fecha_libra, String fecha_sac, String periodicidad, String document,
			String interfase) {

		switch (tipo) {
		case "count":
			String consulta = "select id_servicio_cobrable as \"id_servicio_cobrable\", id_cliente as \"id_cliente\", clave_cliente as \"clave_cliente\" ,"
					+ " nombre_corto_cliente as \"nombre_corto_cliente\", id_negocio as \"id_negocio\", clave_negocio as \"clave_negocio\","
					+ " descripcion_negocio as \"descripcion_negocio\" ,id_centro_costos as \"id_centro_costos\" , id_proceso as \"id_proceso\" , "
					+ "periodicidad_cobro \"periodicidad_cobro\", id_moneda_cobro as \"id_moneda_cobro\", sistema_cobro as \"sistema_cobro\" ,"
					+ " fecha_datos \"fecha_datos\", fecha_cobro_area_op as \"fecha_cobro_area_op\", fecha_calculo as \"fecha_calculo\", "
					+ "fecha_cobro_libra as \"fecha_cobro_libra\", fecha_cobro_sac as \"fecha_cobro_sac\", costo_servicio as \"costo_servicio\", descuento as \"descuento\", "
					+ "iva_servicio as \"iva_servicio\", tipo_documento as \"tipo_documento\", tipo_cambio as \"tipo_cambio\", folio_interno as \"folio_interno\","
					+ " folio_impresion as \"folio_impresion\", fecha_cobro as \"fecha_cobro\" from v_sif_cobros_pendientes  "
					+ "where (1=1 )and(((fecha_cobro_libra=to_date('" + fecha_libra
					+ "' , 'yyyy/mm/dd'))and(sistema_cobro='LIB' ))" + "or((fecha_cobro_sac=to_date('" + fecha_sac
					+ "' , 'yyyy/mm/dd'))and(sistema_cobro='SAC' )))and(periodicidad_cobro='" + periodicidad + "' ) ";
			if (id_cliente != 0) {
				consulta = consulta
						.concat("and id_cliente= decode(" + id_cliente + ",0,id_cliente," + id_cliente + ") ");
			}
			if (proceso != 0) {
				consulta = consulta.concat("and id_proceso= decode(" + proceso + ",0,id_proceso," + proceso + ") ");
			}
			if (negocio != 0) {
				consulta = consulta.concat("and id_negocio= decode(" + negocio + ",0,id_negocio," + negocio + ") ");
			}
			if (!document.equals("empty")) {
				consulta = consulta
						.concat("and tipo_documento= decode('" + document + "',0,tipo_documento,'" + document + "') ");
			}
			if (!interfase.equals("empty")) {
				consulta = consulta
						.concat("and sistema_cobro= decode('" + interfase + "',0,sistema_cobro,'" + interfase + "') ");
			}
			consulta = consulta.concat(
					" order by  id_cliente , id_negocio , id_moneda_cobro , sistema_cobro , tipo_documento , fecha_calculo , fecha_datos");
			Query count = procesoGeneral.getSession().createSQLQuery(consulta);
			model.addAttribute("registros_totales", count.list().size());
			break;
		case "consulta":
			consulta = "select id_servicio_cobrable as \"id_servicio_cobrable\", id_cliente as \"id_cliente\", clave_cliente as \"clave_cliente\" ,"
					+ " nombre_corto_cliente as \"nombre_corto_cliente\", id_negocio as \"id_negocio\", clave_negocio as \"clave_negocio\","
					+ " descripcion_negocio as \"descripcion_negocio\" ,id_centro_costos as \"id_centro_costos\" , id_proceso as \"id_proceso\" , "
					+ "periodicidad_cobro \"periodicidad_cobro\", id_moneda_cobro as \"id_moneda_cobro\", sistema_cobro as \"sistema_cobro\" ,"
					+ " fecha_datos \"fecha_datos\", fecha_cobro_area_op as \"fecha_cobro_area_op\", fecha_calculo as \"fecha_calculo\", "
					+ "fecha_cobro_libra as \"fecha_cobro_libra\", fecha_cobro_sac as \"fecha_cobro_sac\", costo_servicio as \"costo_servicio\", descuento as \"descuento\", "
					+ "iva_servicio as \"iva_servicio\", tipo_documento as \"tipo_documento\", tipo_cambio as \"tipo_cambio\", folio_interno as \"folio_interno\","
					+ " folio_impresion as \"folio_impresion\", fecha_cobro as \"fecha_cobro\" from v_sif_cobros_pendientes  "
					+ "where (1=1 )and(((fecha_cobro_libra=to_date('" + fecha_libra
					+ "' , 'yyyy/mm/dd'))and(sistema_cobro='LIB' ))" + "or((fecha_cobro_sac=to_date('" + fecha_sac
					+ "' , 'yyyy/mm/dd'))and(sistema_cobro='SAC' )))and(periodicidad_cobro='" + periodicidad + "' ) ";
			if (id_cliente != 0) {
				consulta = consulta
						.concat("and id_cliente= decode(" + id_cliente + ",0,id_cliente," + id_cliente + ") ");
			}
			if (proceso != 0) {
				consulta = consulta.concat("and id_proceso= decode(" + proceso + ",0,id_proceso," + proceso + ") ");
			}
			if (negocio != 0) {
				consulta = consulta.concat("and id_negocio= decode(" + negocio + ",0,id_negocio," + negocio + ") ");
			}
			if (!document.equals("empty")) {
				consulta = consulta
						.concat("and tipo_documento= decode('" + document + "',0,tipo_documento,'" + document + "') ");
			}
			if (!interfase.equals("empty")) {
				consulta = consulta
						.concat("and sistema_cobro= decode('" + interfase + "',0,sistema_cobro,'" + interfase + "') ");
			}
			consulta = consulta.concat(
					" order by  id_cliente , id_negocio , id_moneda_cobro , sistema_cobro , tipo_documento , fecha_calculo , fecha_datos");
			consulta = consulta.concat(" OFFSET " + fromRow + " ROWS FETCH NEXT 15 ROWS ONLY");
			Query query = procesoGeneral.getSession().createSQLQuery(consulta)
					.setResultTransformer(Transformers.aliasToBean(BeanCobrosPendientes.class));
			model.addAttribute("consulta", query.list());

			break;

		default:
			break;

		}

	}

	@Override
	public void queryMovimientosFinancieros(String tipo, Model model, Integer fromRow, Integer id_cliente,
			Integer proceso, Integer negocio, String fecha_envio, String folio_impreso, Integer id_moneda, String serie,
			String sisenv, String document, String folio_interno) {
		String consulta;
		switch (tipo) {
		case "count":
			consulta = "select cl.CLAVE_CLIENTE as \"clave_cliente\", cl.NOMBRE_CORTO as \"nombre_corto\", x.ID_COBRO as \"id_cobro\", x.ID_NEGOCIO as \"id_negocio\", x.ID_CLIENTE as \"id_cliente\", x.ID_MONEDA_COBRO as \"id_moneda_cobro\", "
					+ " x.SISTEMA_COBRO as \"sistema_cobro\", x.TIPO_DOCUMENTO as \"tipo_documento\", x.FECHA_DATOS_INI as \"fecha_datos_ini\", x.FECHA_DATOS_FIN as \"fecha_datos_fin\","
					+ " x.DESCRIPCION as \"descripcion\", x.IMPORTE_COSTO as \"importe_costo\", x.IMPORTE_IVA as \"importe_iva\", x.TIPO_CAMBIO as \"tipo_cambio\", "
					+ " x.CLAVE_EXTERNA_CLIENTE as \"clave_externa_cliente\", x.ID_GEN_SISTEMA_COBRO as \"id_gen_sistema_cobro\", x.ESTATUS as \"estatus\", x.USUARIO as \"usuario\", "
					+ " x.FECHA_ENVIO as \"fecha_envio\", x.FECHA_MOD as \"fecha_mod\", x.FECHA_CRE as \"fecha_cre\", x.FOLIO_TEMPORAL as \"folio_temporal\", "
					+ " x.FECHA_COBRO as \"fecha_cobr\", x.OBSERVACION as \"observacion\", x.ESTATUS_CFDI as \"estatus_cfdi\" "
					+ " from TBL_SIF_COBROS x, TBL_SIF_CAT_NEGOCIOS n, TBL_SIF_CAT_CLIENTES cl where (x.ESTATUS in('ENV'))and(x.ID_NEGOCIO=n.ID_NEGOCIO )"
					+ " and(x.FECHA_ENVIO=to_date('" + fecha_envio + "' , 'YYYY-MM-DD')) and(x.ID_MONEDA_COBRO= "
					+ id_moneda + " )";

			if (negocio != 0) {
				consulta = consulta.concat(" and (x.ID_NEGOCIO= " + negocio + " )");
			}
			if (id_cliente != 0) {
				consulta = consulta
						.concat(" and (x.ID_CLIENTE= " + id_cliente + " ) and (cl.ID_CLIENTE= " + id_cliente + ")");
			}
			if (id_cliente == 0) {
				consulta = consulta.concat(" and (cl.ID_CLIENTE= x.ID_CLIENTE)");
			}
			if (proceso != 0) {
				consulta = consulta.concat(" and (n.ID_PROCESO= " + proceso + " )");
			}
			if (!(document.equals("empty"))) {
				consulta = consulta.concat(" and(x.TIPO_DOCUMENTO='" + document + "' )");
			}
			if (!(sisenv.equals("empty"))) {
				consulta = consulta.concat(" and(x.SISTEMA_COBRO='" + sisenv + "' )");
			}

			consulta = consulta.concat(
					" order by  x.SISTEMA_COBRO , x.ID_NEGOCIO , x.ID_CLIENTE , x.ID_MONEDA_COBRO , x.FOLIO_TEMPORAL");
			Query count = procesoGeneral.getSession().createSQLQuery(consulta);
			model.addAttribute("registros_totales", count.list().size());
			break;
		case "consulta":
			consulta = "select cl.CLAVE_CLIENTE as \"clave_cliente\", cl.NOMBRE_CORTO as \"nombre_corto\", x.ID_COBRO as \"id_cobro\", x.ID_NEGOCIO as \"id_negocio\", x.ID_CLIENTE as \"id_cliente\", x.ID_MONEDA_COBRO as \"id_moneda_cobro\", "
					+ " x.SISTEMA_COBRO as \"sistema_cobro\", x.TIPO_DOCUMENTO as \"tipo_documento\", x.FECHA_DATOS_INI as \"fecha_datos_ini\", x.FECHA_DATOS_FIN as \"fecha_datos_fin\","
					+ " x.DESCRIPCION as \"descripcion\", x.IMPORTE_COSTO as \"importe_costo\", x.IMPORTE_IVA as \"importe_iva\", x.TIPO_CAMBIO as \"tipo_cambio\", "
					+ " x.CLAVE_EXTERNA_CLIENTE as \"clave_externa_cliente\", x.ID_GEN_SISTEMA_COBRO as \"id_gen_sistema_cobro\", x.ESTATUS as \"estatus\", x.USUARIO as \"usuario\", "
					+ " x.FECHA_ENVIO as \"fecha_envio\", x.FECHA_MOD as \"fecha_mod\", x.FECHA_CRE as \"fecha_cre\", x.FOLIO_TEMPORAL as \"folio_temporal\", "
					+ " x.FECHA_COBRO as \"fecha_cobr\", x.OBSERVACION as \"observacion\", x.ESTATUS_CFDI as \"estatus_cfdi\" "
					+ " from TBL_SIF_COBROS x, TBL_SIF_CAT_NEGOCIOS n, TBL_SIF_CAT_CLIENTES cl where (x.ESTATUS in('ENV'))and(x.ID_NEGOCIO=n.ID_NEGOCIO )"
					+ " and(x.FECHA_ENVIO=to_date('" + fecha_envio + "' , 'YYYY-MM-DD')) and(x.ID_MONEDA_COBRO= "
					+ id_moneda + " )";

			if (negocio != 0) {
				consulta = consulta.concat(" and (x.ID_NEGOCIO= " + negocio + " )");
			}
			if (id_cliente != 0) {
				consulta = consulta
						.concat(" and (x.ID_CLIENTE= " + id_cliente + " ) and (cl.ID_CLIENTE= " + id_cliente + ")");
			}
			if (id_cliente == 0) {
				consulta = consulta.concat(" and (cl.ID_CLIENTE= x.ID_CLIENTE)");
			}
			if (proceso != 0) {
				consulta = consulta.concat(" and (n.ID_PROCESO= " + proceso + " )");
			}
			if (!(document.equals("empty"))) {
				consulta = consulta.concat(" and(x.TIPO_DOCUMENTO='" + document + "' )");
			}
			if (!(sisenv.equals("empty"))) {
				consulta = consulta.concat(" and(x.SISTEMA_COBRO='" + sisenv + "' )");
			}

			consulta = consulta.concat(
					" order by  x.SISTEMA_COBRO , x.ID_NEGOCIO , x.ID_CLIENTE , x.ID_MONEDA_COBRO , x.FOLIO_TEMPORAL");
			String consultaTotal = consulta;
			consulta = consulta.concat(" OFFSET " + fromRow + " ROWS FETCH NEXT 15 ROWS ONLY");
			Query query = procesoGeneral.getSession().createSQLQuery(consulta)
					.setResultTransformer(Transformers.aliasToBean(BeanCobrosFinancieros.class));
			model.addAttribute("consulta", query.list());

			Query query1 = procesoGeneral.getSession().createSQLQuery(consultaTotal)
					.setResultTransformer(Transformers.aliasToBean(BeanCobrosFinancieros.class));
			model.addAttribute("consultaTotal", query1.list());

			break;

		default:
			break;
		}
	}

	/**
	 * 
	 * @author Sanchez Aguiar Jesus Alfonso
	 *
	 */
	@Override
	public void movimientosFinancierosCFDS(Model model, String tipo, String datos, String datosInput) {
		String variables = "";
		String[ ] datosAll = new String[22];
		String[] datosSeparados = datos.split("&&");
		for (int i = 0; i < datosSeparados.length; i++) {
			String[] stringDatos = datosSeparados[i].split(",");
			int id_cobro = Integer.parseInt(stringDatos[0]);
			String fecha_datos_ini = stringDatos[1];
			String folio_temporal = stringDatos[2];
			String clave_cliente = stringDatos[3];
			String nombre_corto = stringDatos[4];
			String descripcion = stringDatos[5];
			String sistema_cobro = stringDatos[6];
			String importe_costo = stringDatos[7];
			String importe_iva = stringDatos[8];
			String tipo_documento = stringDatos[9];
			String estatus = stringDatos[10];
			String estatus_cfdi = stringDatos[11];

			String[] datosInputSeparados = datosInput.split("#");
			for (int j = 0; j < datosInputSeparados.length; j++) {
				String[] stringInput = datosInputSeparados[j].split(",");
				int id_cobroInput = Integer.parseInt(stringInput[0]);
				String importe = stringInput[1];
				String fecha_envio = stringInput[2];
			}
		}

	}

	/**
	 * 
	 * @author Sanchez Aguiar Jesus Alfonso
	 *
	 */
	@Override
	public void Enviarcifras(Model model,String values) {
		// TODO Auto-generated method stub
		
		String[] numact=values.split(Pattern.quote("||"));
		for (int i = 0; i < numact.length; i++) {
			String[] val=numact[i].split(Pattern.quote(","));
			Integer max_id = procesoGeneral.getId(TBL_SIF_COBROS.class,"id_cobro");
			
			
			
			Query queryInsert = procesoGeneral.getSession()
					.createSQLQuery("Insert into TBL_SIF_COBROS values (?,?,?,?,?,?,null,to_date(?,'yyyy-mm-dd'),to_date(?,'yyyy-mm-dd'),"
							+"?,?,?,null,?,null,?,?,SYSDATE,SYSDATE,SYSDATE,to_date(?,'yyyy-mm-dd'),null,?)");
			queryInsert.setParameter(0,max_id );
			queryInsert.setParameter(1, val[0]);
			queryInsert.setParameter(2,val[1]);
			queryInsert.setParameter(3, val[2]);
			queryInsert.setParameter(4, val[3]);	
			queryInsert.setParameter(5, val[4]);
			queryInsert.setParameter(6, val[5]);
			queryInsert.setParameter(7, val[6]);
			queryInsert.setParameter(8,val[7]); //descripcion
			queryInsert.setParameter(9, val[8]);	
			queryInsert.setParameter(10, val[9]);
			queryInsert.setParameter(11,val[10]); 
			queryInsert.setParameter(12, "ENV");
			queryInsert.setParameter(13, procesoGeneral.getSesionActual());
			queryInsert.setParameter(14, val[11]);
			queryInsert.setParameter(15,"Pendiente");
			
			Query queryInsert2 = procesoGeneral.getSession()
					.createSQLQuery("insert into TBL_SIF_COBROS_SERV_COBRABLES (ID_COBRO, ID_SERVICIO_COBRABLE, TIPO_SERVICIO_COBRABLE) values (?, ?,?)");
			queryInsert2.setParameter(0,max_id );
			queryInsert2.setParameter(1, val[12]);
			queryInsert2.setParameter(2, val[4]); //TIPO_DOCUMENTO,
			
			Query queryUpdate = procesoGeneral.getSession()
					.createSQLQuery("update tbl_sif_notas_credito set estatus_cobro = 'ENV' "
							+ "where id_cliente= ? and folio= ?");
			queryUpdate.setParameter(0, val[0]);
			queryUpdate.setParameter(1, val[13]);
			
			queryInsert.executeUpdate();
			queryInsert2.executeUpdate();
			queryUpdate.executeUpdate();
			
		 
			
			}
			
			
		}

	
	}


