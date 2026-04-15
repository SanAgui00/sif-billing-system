/**
################################################################################
# Autor               : Garnica                                                #
# Compania            : Código Geek                                            #
# Proyecto/Procliente : Impl de registro Contable            Fecha: 08/03/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.dao;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.prosa.sif.operation.ProcesoGeneral;
import com.prosa.sif.pojo.BeanAsignarPolizaNegocio;
import com.prosa.sif.pojo.BeanMantenerRegistro;
import com.prosa.sif.pojo.BeanRegistroContable;
import com.prosa.sif.pojo.TablaMantenerPolizas;
import com.prosa.sif.pojo.TablaPolizasContable;
import com.prosa.sif.pojo.ViewMantenerRegistro;
import com.prosa.sif.pojo.ViewRegistrosPendientes;


/**
 * 
 * @author David Garnica Garcia
 *
 */
@Repository
@Transactional
@SuppressWarnings("all")
public class RegistroContableDaoImpl implements RegistroContableDao {
	Integer maxid;
	@Autowired
	private ProcesoGeneral procesoGeneral;

	@Override
	public void queryRegistroContable(String tipo, Model model, Integer fromRow, Integer proceso, Integer negocio,
			String fecha_inicial, String fecha_final) {
		switch (tipo) {
		case "count":
			String consulta = "select ID_MODELO_POLIZA as \"id_modelo_poliza\", CLAVE_MODELO_POLIZA as "
					+ "\"clave_modelo_poliza\", DESCRIPCION as \"descripcion\", TIPO_MODELO_POLIZA as \"tipo_modelo_poliza\","
					+ " FECHA_REGISTRO_GL as \"fecha_registro_gl\", FECHA_CALCULO as \"fecha_calculo\","
					+ " CLAVE_NEGOCIO as \"clave_negocio\", DESCRIPCION_NEGOCIO as \"descripcion_negocio\", "
					+ "ID_NEGOCIO as \"id_negocio\" from v_sif_registros_pendientes  where (1=1 )";
					consulta = consulta.concat ("and (id_negocio= decode(:negocio, 0, id_negocio, :negocio))");
					consulta = consulta.concat ("and (id_proceso= decode(:proceso, 0, id_proceso, :proceso))");
					consulta = consulta.concat("and(fecha_calculo between to_date(:fecha_inicial , 'yyyy/mm/dd')" 
					+ " and to_date(:fecha_final , 'yyyy/mm/dd')) "
					+ "and(clave_modelo_poliza not like('%_CFD')) group by  clave_negocio , "
					+ "descripcion_negocio , id_negocio , fecha_calculo , fecha_registro_gl , "
					+ "id_modelo_poliza , clave_modelo_poliza , descripcion , tipo_modelo_poliza");
			Query count = procesoGeneral.getSession().createSQLQuery(consulta);
			count.setParameter("negocio", negocio);
			count.setParameter("proceso", proceso);
			count.setParameter("fecha_inicial", fecha_inicial);
			count.setParameter("fecha_final", fecha_final);
			model.addAttribute("registros_totales", count.list().size());
			break;
		case "consulta":
			consulta = "select ID_MODELO_POLIZA as \"id_modelo_poliza\", CLAVE_MODELO_POLIZA as "
					+ "\"clave_modelo_poliza\", DESCRIPCION as \"descripcion\", TIPO_MODELO_POLIZA as \"tipo_modelo_poliza\","
					+ " FECHA_REGISTRO_GL as \"fecha_registro_gl\", FECHA_CALCULO as \"fecha_calculo\","
					+ " CLAVE_NEGOCIO as \"clave_negocio\", DESCRIPCION_NEGOCIO as \"descripcion_negocio\", "
					+ "ID_NEGOCIO as \"id_negocio\" from v_sif_registros_pendientes  where (1=1 )";
					consulta = consulta.concat ("and (id_negocio= decode(:negocio, 0, id_negocio, :negocio))");
					consulta = consulta.concat ("and (id_proceso= decode(:proceso, 0, id_proceso, :proceso))");
					consulta = consulta.concat("and(fecha_calculo between to_date(:fecha_inicial , 'yyyy/mm/dd')" 
					+ " and to_date(:fecha_final , 'yyyy/mm/dd')) "
					+ "and(clave_modelo_poliza not like('%_CFD')) group by  clave_negocio , "
					+ "descripcion_negocio , id_negocio , fecha_calculo , fecha_registro_gl , "
					+ "id_modelo_poliza , clave_modelo_poliza , descripcion , tipo_modelo_poliza");
			consulta = consulta.concat(" OFFSET  :fromRow ROWS FETCH NEXT 15 ROWS ONLY");
			Query query = procesoGeneral.getSession().createSQLQuery(consulta)
					.setResultTransformer(Transformers.aliasToBean(ViewRegistrosPendientes.class));
			query.setParameter("negocio", negocio);
			query.setParameter("proceso", proceso);
			query.setParameter("fecha_inicial", fecha_inicial);
			query.setParameter("fecha_final", fecha_final);
			query.setParameter("fromRow", fromRow);
			model.addAttribute("consulta", query.list());
			break;

		default:
			break;

		}

	}

	@Override
	public void queryGenerarRegistro(Model model, Integer fromRow, String values, HttpServletRequest request) {
		
		String[] numact = values.split(Pattern.quote("||"));
		for (int i = 0; i < numact.length; i++) {
			String[] split = numact[i].split(Pattern.quote(","));
			String[] splitfecha = split[2].split(Pattern.quote(" "));
			procesoGeneral.Bitacora(model, request, "GENREGCON", "INICIO GENERACION DE REGISTROS CONTABLES", "PK_SIF_REG_CONTBALE.PRC_SIF_GENERA_REGISTRO");
			String consulta="DECLARE "
					+ "P_PROC VARCHAR2(200); P_NEG VARCHAR2(200); P_MOD_POLIZA NUMBER; P_FECHAI DATE; P_FECHAF DATE; USUARIO VARCHAR2(200); v_Return NUMBER; "
					+ "BEGIN "
					+ "P_PROC \\:\\= "+split[0]+"; P_NEG \\:\\= "+split[1]+"; P_MOD_POLIZA \\:\\= "+split[3]+"; P_FECHAI \\:\\= '"+splitfecha[0]+"';P_FECHAF \\:\\= '"+splitfecha[0]+"'; USUARIO \\:\\= '"+procesoGeneral.getSesionActual()+"'; "
					+ "v_Return \\:\\= PK_SIF_REG_CONTABLE.PRC_SIF_GENERA_REGISTRO( P_PROC => P_PROC, P_NEG => P_NEG, P_MOD_POLIZA => P_MOD_POLIZA, P_FECHAI => P_FECHAI, P_FECHAF => P_FECHAF, USUARIO => USUARIO); END;";
			Query query = procesoGeneral.getSession().createSQLQuery(consulta);
			query.executeUpdate();
			procesoGeneral.Bitacora(model, request, "GENREGCON", "FINAL GENERACION DE REGISTROS CONTABLES", "PK_SIF_REG_CONTBALE.PRC_SIF_GENERA_REGISTRO");
		}
		

	}

	@Override
	public void queryPolizasContables(String tipo, Model model, Integer fromRow, Integer id_modelo_poliza) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaPolizasContable.class);
			if (id_modelo_poliza != 0) {
				count.add(Restrictions.eq("id_modelo_poliza", id_modelo_poliza));
			}
			count.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave"));
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);

			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaPolizasContable.class);
			if (id_modelo_poliza != 0) {
				crit.add(Restrictions.eq("id_modelo_poliza", id_modelo_poliza));
			}
			crit.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave"));
			crit.setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("consulta", crit.list());
			break;

		default:
			break;
		}

	}

	@Override
	public void queryFindPolizaContable(Model model, Integer clave, String event, HttpServletRequest request,
			HttpServletResponse response) {
		if (!event.equals("new")) {
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaPolizasContable.class)
					.add(Restrictions.eq("id_modelo_poliza", clave));
			model.addAttribute("consulta", crit.list());
			if (event.equals("edit")) {
				String consulta = "select a.id_modelo_poliza AS \"id_modelo_poliza\",a.numero AS \"numero\",a.id_empresa AS \"id_empresa\",a.id_tipo_cuenta_contable AS \"id_tipo_cuenta_contable\","
						+ "a.tipo_centro_costos AS \"tipo_centro_costos\",a.id_centro_costos AS \"id_centro_costos\",a.tipo_movimiento AS \"tipo_movimiento\",a.proyecto AS \"proyecto\",a.producto AS \"producto\","
						+ "a.temporal AS \"temporal\",a.descripcion AS \"descripcion\",a.tipo_importe AS \"tipo_importe\",b.razon_social AS \"razon_social\" from tbl_sif_cat_registros_cont a"
						+ ",tbl_sif_cat_empresas b where a.id_empresa=b.id_empresa AND a.id_modelo_poliza="+clave;
				Query query = procesoGeneral.getSession().createSQLQuery(consulta)
						.setResultTransformer(Transformers.aliasToBean(BeanRegistroContable.class));
				model.addAttribute("consultaEdit", query.list());

			}
		}

	}

	@Override
	public void saveOrUpdatePolizaContable(HttpServletRequest request, Model model, String event, String clavePoliza, String tipopoli,
			String descripcionPoli, String checkval, Integer id_modelo_poliza) {
		
		switch (event) {
		case "update":
			maxid = id_modelo_poliza;
			if (!checkval.equals("empty")) {
				String split1[] = checkval.split(Pattern.quote("||"));
				for (int i = 0; i < split1.length; i++) {
					
					String split[] = split1[i].split(Pattern.quote(","));

					if (split[5].equals("null")) {
						split[5] = "" + split[5] + "";
					} else {
						split[5] = "'" + split[5] + "'";
					}
					if (split[6].equals("null")) {
						split[6] = "" + split[6] + "";
					} else {
						split[6] = "'" + split[6] + "'";
					}
					if (split[7].equals("null")) {
						split[7] = "" + split[7] + "";
					} else {
						split[7] = "'" + split[7] + "'";
					}
					if (split[9].equals("null")) {
						split[9] = "" + split[9] + "";
					} else {
						split[9] = "'" + split[9] + "'";
					}
					if (split[10].equals("null")) {
						split[10] = "" + split[10] + "";
					} else {
						split[10] = "'" + split[10] + "'";
					}
					
					Query queryInsert1 = procesoGeneral.getSession().createSQLQuery(
							"Insert into TBL_SIF_CAT_REGISTROS_CONT (ID_MODELO_POLIZA,NUMERO,ID_EMPRESA,ID_TIPO_CUENTA_CONTABLE,TIPO_CENTRO_COSTOS,ID_CENTRO_COSTOS,TIPO_MOVIMIENTO,PROYECTO,PRODUCTO,TEMPORAL,DESCRIPCION,TIPO_IMPORTE) "
									+ "values (" + maxid + "," + split[0] + "," + split[1] + "," + split[2] + ",'"
									+ split[3] + "'," + split[4] + "," + split[5] + "," + split[6] + "," + split[7]
									+ ",'" + split[8] + "'," + split[9] + "," + split[10] + ")");
					queryInsert1.executeUpdate();

				}
			}
			break;
		case "insert":
			if (clavePoliza.equals("empty")) {
				clavePoliza = "" + null + "";
			} else {
				clavePoliza = "'" + clavePoliza + "'";
			}
			if (tipopoli.equals("empty")) {
				tipopoli = "" + null + "";
			} else {
				tipopoli = "'" + tipopoli + "'";
			}
			if (descripcionPoli.equals("empty")) {
				descripcionPoli = "" + null + "";
			} else {
				descripcionPoli = "'" + descripcionPoli + "'";
			}
			maxid = procesoGeneral.getId(TablaPolizasContable.class, "id_modelo_poliza");
			Query queryInsert = procesoGeneral.getSession().createSQLQuery(
					"Insert into TBL_SIF_CAT_POLIZAS_CONTABLES (ID_MODELO_POLIZA,CLAVE,DESCRIPCION,TIPO,USUARIO,ESTATUS,FECHA_CRE,FECHA_MOD,COMENTARIOS)"
							+ "values (" + maxid + "," + clavePoliza + "," + descripcionPoli + "," + tipopoli + ",'"
							+ procesoGeneral.getSesionActual() + "','ACT',sysdate,sysdate,null)");
			queryInsert.executeUpdate();
			if (!checkval.equals("empty")) {
				String split1[] = checkval.split(Pattern.quote("||"));
				for (int i = 0; i < split1.length; i++) {

					String split[] = split1[i].split(Pattern.quote(","));

					if (split[5].equals("null")) {
						split[5] = "" + split[5] + "";
					} else {
						split[5] = "'" + split[5] + "'";
					}
					if (split[6].equals("null")) {
						split[6] = "" + split[6] + "";
					} else {
						split[6] = "'" + split[6] + "'";
					}
					if (split[7].equals("null")) {
						split[7] = "" + split[7] + "";
					} else {
						split[7] = "'" + split[7] + "'";
					}
					if (split[9].equals("null")) {
						split[9] = "" + split[9] + "";
					} else {
						split[9] = "'" + split[9] + "'";
					}
					if (split[10].equals("null")) {
						split[10] = "" + split[10] + "";
					} else {
						split[10] = "'" + split[10] + "'";
					}

					Query queryInsert1 = procesoGeneral.getSession().createSQLQuery(
							"Insert into TBL_SIF_CAT_REGISTROS_CONT (ID_MODELO_POLIZA,NUMERO,ID_EMPRESA,ID_TIPO_CUENTA_CONTABLE,TIPO_CENTRO_COSTOS,ID_CENTRO_COSTOS,TIPO_MOVIMIENTO,PROYECTO,PRODUCTO,TEMPORAL,DESCRIPCION,TIPO_IMPORTE) "
									+ "values (" + maxid + "," + split[0] + "," + split[1] + "," + split[2] + ",'"
									+ split[3] + "'," + split[4] + "," + split[5] + "," + split[6] + "," + split[7]
									+ ",'" + split[8] + "'," + split[9] + "," + split[10] + ")");
					queryInsert1.executeUpdate();

				}
			}
			break;
		case "delete":
				Query delete = procesoGeneral.getSession().createSQLQuery(
						"update TBL_SIF_CAT_POLIZAS_CONTABLES set estatus='ELI', fecha_mod=sysdate where clave='"
								+ clavePoliza + "'");
				delete.executeUpdate();
			break;
		default:
			break;
		}

	}

	@Override
	public void queryMantenerRegistro(String tipo, Model model, Integer fromRow, Integer cliente, Integer proceso,
			Integer negocio, String fecha_inicial, String fecha_final, String document, String estatus,
			String id_moneda) {
		
		switch (tipo) {
		case "count":
			String consulta = "SELECT DISTINCT POLIZA.ID_POLIZA, DECODE ( MODELO.DESCRIPCION, NULL, "
					+ "'POLIZA ALTA ODT', MODELO.DESCRIPCION ) AS DESCRIPCION,POLIZA.FECHA_CRE, "
					+ "POLIZA.ESTATUS, POLIZA.ID_GENERADO_GL,POLIZA.ID_POLIZA_REVERSADA,POLIZA.FECHA_DATOS_INI,"
					+ "POLIZA.FECHA_DATOS_FIN  FROM TBL_SIF_POLIZAS_CONTABLES POLIZA, TBL_SIF_REGISTROS_CONTABLES REGISTRO,"
					+ " TBL_SIF_CAT_POLIZAS_CONTABLES MODELO WHERE MODELO.ID_MODELO_POLIZA (+) = POLIZA.ID_MODELO_POLIZA "
					+ "AND REGISTRO.ID_POLIZA = POLIZA.ID_POLIZA AND TRUNC(POLIZA.FECHA_CRE)BETWEEN "
					+ "TO_DATE( '"+fecha_inicial+"', 'yyyy/MM/dd' ) AND TO_DATE( '"+fecha_final+"', 'yyyy/MM/dd' ) "
					+ " AND POLIZA.ID_MONEDA = "+id_moneda +" AND POLIZA.ESTATUS = '"+estatus+"'";
			if(!document.equals("empty")) {
				consulta =consulta.concat(" AND POLIZA.TIPO_DOCUMENTO IN ('"+document+"' ) ");
			}else {
				consulta =consulta.concat(" AND POLIZA.TIPO_DOCUMENTO IN ('SER','ABI','ODT','NOT','REC' ) ");
			}
			if(cliente!=0) {
				consulta =consulta.concat(" AND REGISTRO.ID_CLIENTE = "+cliente);
			}
			if(negocio!=null) {
				consulta =consulta.concat(" AND REGISTRO.ID_NEGOCIO = "+negocio);
			}
			if(proceso!=null) {
				consulta =consulta.concat(" AND REGISTRO.ID_NEGOCIO IN ( SELECT ID_NEGOCIO FROM TBL_SIF_CAT_NEGOCIOS WHERE ID_PROCESO =  "+proceso+") ");
			}
			
			Query count = procesoGeneral.getSession().createSQLQuery(consulta);
			model.addAttribute("registros_totales", count.list().size());
			break;
		case "consulta":
			consulta = "SELECT DISTINCT POLIZA.ID_POLIZA AS \"id_poliza\", DECODE ( MODELO.DESCRIPCION, NULL, "
					+ "'POLIZA ALTA ODT', MODELO.DESCRIPCION ) AS \"descripcion\",POLIZA.FECHA_CRE AS \"fecha_cre\", "
					+ "POLIZA.ESTATUS AS \"estatus\", POLIZA.ID_GENERADO_GL \"id_generado_gl\",POLIZA.ID_POLIZA_REVERSADA AS \"id_poliza_reversada\",POLIZA.FECHA_DATOS_INI AS \"fecha_datos_ini\","
					+ "POLIZA.FECHA_DATOS_FIN AS \"fecha_datos_fin\" FROM TBL_SIF_POLIZAS_CONTABLES POLIZA, TBL_SIF_REGISTROS_CONTABLES REGISTRO,"
					+ " TBL_SIF_CAT_POLIZAS_CONTABLES MODELO WHERE MODELO.ID_MODELO_POLIZA (+) = POLIZA.ID_MODELO_POLIZA "
					+ "AND REGISTRO.ID_POLIZA = POLIZA.ID_POLIZA AND TRUNC(POLIZA.FECHA_CRE)BETWEEN "
					+ "TO_DATE( '"+fecha_inicial+"', 'yyyy/MM/dd' ) AND TO_DATE( '"+fecha_final+"', 'yyyy/MM/dd' ) "
					+ " AND POLIZA.ID_MONEDA = "+id_moneda;
			if(!estatus.equals("empty")) {
				consulta =consulta.concat(" AND POLIZA.ESTATUS = '"+estatus+"' ");
			}else {
				consulta =consulta.concat(" AND POLIZA.ESTATUS <> 'CAN'");
			}
			if(!document.equals("empty")) {
			}else {
				consulta =consulta.concat(" AND POLIZA.TIPO_DOCUMENTO IN ('SER','ABI','ODT','NOT','REC' ) ");
			}
			if(cliente!=0) {
				consulta =consulta.concat(" AND REGISTRO.ID_CLIENTE = "+cliente);
			}
			if(negocio!=null) {
				consulta =consulta.concat(" AND REGISTRO.ID_NEGOCIO = "+negocio);
			}
			if(proceso!=null) {
				consulta =consulta.concat(" AND REGISTRO.ID_NEGOCIO IN ( SELECT ID_NEGOCIO FROM TBL_SIF_CAT_NEGOCIOS WHERE ID_PROCESO =  "+proceso+") ");
			}
			consulta = consulta.concat(" OFFSET " + fromRow + " ROWS FETCH NEXT 15 ROWS ONLY");
			Query query = procesoGeneral.getSession().createSQLQuery(consulta)
					.setResultTransformer(Transformers.aliasToBean(BeanMantenerRegistro.class));
			model.addAttribute("consulta", query.list());
			break;

		default:
			break;

		}

	}

	@Override
	public void queryAsignarPolizasNegocios(Model model, Integer id_negocio) {
		String consulta = "select a.id_modelo_poliza AS \"id_modelo_poliza\", a.clave AS \"clave\" from tbl_sif_cat_polizas_contables a, tbl_sif_negocios_polizas b"
				+ " where a.id_modelo_poliza=b.id_modelo_poliza and b.id_negocio= "+id_negocio;
		Query query = procesoGeneral.getSession().createSQLQuery(consulta)
				.setResultTransformer(Transformers.aliasToBean(BeanAsignarPolizaNegocio.class));
		model.addAttribute("consulta", query.list());
		String consulta1 = "select id_modelo_poliza AS \"id_modelo_poliza\", clave AS \"clave\" from tbl_sif_cat_polizas_contables "
				+ "where id_modelo_poliza NOT IN (select a.id_modelo_poliza from tbl_sif_cat_polizas_contables a, "
				+ "tbl_sif_negocios_polizas b where a.id_modelo_poliza=b.id_modelo_poliza and b.id_negocio= "+id_negocio+") ";
		Query query1 = procesoGeneral.getSession().createSQLQuery(consulta1)
				.setResultTransformer(Transformers.aliasToBean(BeanAsignarPolizaNegocio.class));
		model.addAttribute("consultaEnv", query1.list());

		
	}

	@Override
	public void SaveorUpdateAsignarPolizasNegocios(HttpServletRequest request, Model model, String values) {
		
		String[] numact = values.split(Pattern.quote("||"));
		String[] valuesneg = numact[0].split(Pattern.quote(","));
		
			Query delete = procesoGeneral.getSession().createSQLQuery(
					"delete from tbl_sif_negocios_polizas where id_negocio = "+valuesneg[0]);
			delete.executeUpdate();
			
		for (int i = 0; i < numact.length; i++) {
			String[] act = numact[i].split(Pattern.quote(","));
			Query queryInsert = procesoGeneral.getSession().createSQLQuery(
					"Insert into tbl_sif_negocios_polizas (ID_NEGOCIO,ID_MODELO_POLIZA,USUARIO,FECHA_CRE) "
					+ "values ("+valuesneg[0]+","+act[1]+",'"+procesoGeneral.getSesionActual()+"',sysdate)");
			queryInsert.executeUpdate();
		}
		
		
	}

	@Override
	public void queryFindRegistroPoliza(Model model, Integer clave, String event, HttpServletRequest request,
			HttpServletResponse response) {
		
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaMantenerPolizas.class).add(Restrictions.eq("id_poliza", clave));
		model.addAttribute("consulta", crit.list());
		Criteria crit1 = procesoGeneral.getSession().createCriteria(ViewMantenerRegistro.class).add(Restrictions.eq("id_poliza", clave));
		model.addAttribute("consultaRegistros", crit1.list());
	}

	@Override
	public void SaveorDeleteRegistroPoliza(Model model, Integer clave, String event, HttpServletRequest request,
			HttpServletResponse response, String checkval) {
		// TODO Auto-generated method stub
		String[]numact=checkval.split(Pattern.quote("||"));

		for (int i = 0; i < numact.length; i++) {
			String[] act = numact[i].split(Pattern.quote(","));
			if(act[2].trim().equals("---")) {
				Query queryInsert = procesoGeneral.getSession().createSQLQuery(
						"Insert into TBL_SIF_REGISTROS_CONTABLES (ID_REGISTRO,ID_POLIZA,ID_NEGOCIO,ID_CLIENTE,ID_TIPO_CUENTA_CONTABLE,CLAVE_NEGOCIO_GL,"
						+ "CODIGO_EMPRESA,NUMERO_CUENTA_CONTABLE,CODIGO_CENTRO_COSTOS,TIPO_MOVIMIENTO,PROYECTO,PRODUCTO,TEMPORAL,DESCRIPCION,IMPORTE,IMPORTE_PS) "
						+ "values (sec_sif_reg_cont.nextval,"+clave+","+act[4]+",00000,"+act[7]+",'"+act[6]+"','"+act[6]+"',"+act[5]+",'"+act[5]+"','"+act[6]+"','00000','00000','000','IVA Cobranza Diaria',3150,null);");
				queryInsert.executeUpdate();
			}else {
				Query queryInsert = procesoGeneral.getSession().createSQLQuery(
						"Insert into TBL_SIF_REGISTROS_CONTABLES (ID_REGISTRO,ID_POLIZA,ID_NEGOCIO,ID_CLIENTE,ID_TIPO_CUENTA_CONTABLE,CLAVE_NEGOCIO_GL,"
						+ "CODIGO_EMPRESA,NUMERO_CUENTA_CONTABLE,CODIGO_CENTRO_COSTOS,TIPO_MOVIMIENTO,PROYECTO,PRODUCTO,TEMPORAL,DESCRIPCION,IMPORTE,IMPORTE_PS) "
						+ "values (24758,246,13,14,1,'02','2',11111111,'9992','A','00000','00000','000','IVA Cobranza Diaria',3150,null);");
				queryInsert.executeUpdate();
			}
			
			
		}
	}

	@Override
	public void SaveorDeleteMantenerRegistro(Model model, HttpServletRequest request, HttpServletResponse response,
			String datos, String opcion) {
		
	}

	@Override
	public void queryenvelirev(Model model, String fecha_inicial, String fecha_final) {
		
		String consulta = "SELECT DISTINCT POLIZA.ID_POLIZA AS \"id_poliza\", DECODE ( MODELO.DESCRIPCION, NULL, "
				+ "'POLIZA ALTA ODT', MODELO.DESCRIPCION ) AS \"descripcion\",POLIZA.FECHA_CRE AS \"fecha_cre\", "
				+ "POLIZA.ESTATUS AS \"estatus\", POLIZA.ID_GENERADO_GL \"id_generado_gl\",POLIZA.ID_POLIZA_REVERSADA AS \"id_poliza_reversada\",POLIZA.FECHA_DATOS_INI AS \"fecha_datos_ini\","
				+ "POLIZA.FECHA_DATOS_FIN AS \"fecha_datos_fin\" FROM TBL_SIF_POLIZAS_CONTABLES POLIZA, TBL_SIF_REGISTROS_CONTABLES REGISTRO,"
				+ " TBL_SIF_CAT_POLIZAS_CONTABLES MODELO WHERE MODELO.ID_MODELO_POLIZA (+) = POLIZA.ID_MODELO_POLIZA "
				+ "AND REGISTRO.ID_POLIZA = POLIZA.ID_POLIZA AND TRUNC(POLIZA.FECHA_CRE)BETWEEN "
				+ "TO_DATE( '"+fecha_inicial+"', 'dd/MM/yyyy' ) AND TO_DATE( '"+fecha_final+"', 'dd/MM/yyyy' ) "
				+ " AND POLIZA.ID_MONEDA = 1";
				Query query = procesoGeneral.getSession().createSQLQuery(consulta)
				.setResultTransformer(Transformers.aliasToBean(BeanMantenerRegistro.class));
		model.addAttribute("consulta", query.list());

		
	}

}
