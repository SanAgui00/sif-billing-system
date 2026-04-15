/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 16/06/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.dao;

import javax.servlet.http.HttpServletRequest;
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
import com.prosa.sif.pojo.BeanContingencia;
import com.prosa.sif.pojo.BeanEstructuraDato;
import com.prosa.sif.pojo.BeanReglaConversion;
import com.prosa.sif.pojo.TablaEstructuraDato;
import com.prosa.sif.pojo.TablaReglaCarga;
import com.prosa.sif.pojo.TablaReglaConversion;
import com.prosa.sif.pojo.ViewCargaDato;

@Repository
@Transactional
@SuppressWarnings("all")
public class ParametrizarDaoImpl implements ParametrizarDao {
	@Autowired
	private ProcesoGeneral procesoGeneral;

	@Override
	public void queryContingencia(String tipo, Model model, HttpServletRequest request, Integer id_fuente,
			String fecha_datos, String fecha_datos_final) {

		switch (tipo) {
		case "param":
			String consulta = "select distinct( f.id_fuente)  as \"id_fuente\", f.clave as \"clave\", r.hora_inicio  as \"hora_inicio\", r.hora_final  as \"hora_final\","
					+ " r.fecha_datos as \"fecha_datos\", r.descripcion_evento as \"descripcion_evento\", r.total_trans_leidas as \"total_trans_leidas\","
					+ "r.total_trans_conv as \"total_trans_conv\", r.total_trans_nconv as \"total_trans_nconv\", nvl(r.estatus,'NRL')  as \"estatus\" from tbl_sif_fuentes f, tbl_sif_resumen_adq r where f.estatus = 'ACT' "
					+ "and f.id_fuente = " + id_fuente
					+ " and r.id_fuente = f.id_fuente and trunc(r.fecha_datos) between to_date('" + fecha_datos
					+ "','YYYY-MM-DD') and to_date('" + fecha_datos_final + "','YYYY-MM-DD') "
					+ "and (nvl(r.estatus,'NRL') = 'EXI'or r.estatus='CON') and fecha_base_contingencia is not null  order by r.fecha_datos, r.hora_inicio desc";

			Query query = procesoGeneral.getSession().createSQLQuery(consulta)
					.setResultTransformer(Transformers.aliasToBean(BeanContingencia.class));
			model.addAttribute("consulta", query.list());
			break;
		default:
			break;
		}

	}

	@Override
	public void crudContingencia(String event, Model model, HttpServletRequest request, Integer id_fuente,
			String fecha_datos, String fecha_datos_final) {
		Query query;
		switch (event) {
		case "ajusteDentro":
			query = procesoGeneral.getSession().createSQLQuery(
					"DECLARE amount VARCHAR2(240); today VARCHAR2(240); BEGIN today \\:\\= pk_sif_contingencia.f_ajusta_contingencia("
							+ id_fuente + ",sysdate,sysdate,'" + procesoGeneral.getSesionActual() + "',amount); END;");
			query.executeUpdate();

			break;
		case "ajusteFuera":
			query = procesoGeneral.getSession().createSQLQuery(
					"DECLARE amount VARCHAR2(240); today VARCHAR2(240); BEGIN today \\:\\= pk_sif_contingencia.f_ajusta_contingencia_periodo("
							+ id_fuente + ",sysdate,sysdate,'" + procesoGeneral.getSesionActual()
							+ "','mensaje',amount); END;");
			query.executeUpdate();

			break;
		case "aplicar":
			query = procesoGeneral.getSession().createSQLQuery(
					"DECLARE amount VARCHAR2(242); BEGIN pk_sif_contingencia.p_aplica_contingencia(sysdate,'FUENTE',sysdate,'"
							+ procesoGeneral.getSesionActual() + "',amount); DBMS_OUTPUT.PUT_LINE(amount); END;");
			query.executeUpdate();
			break;
		default:
			break;
		}
	}

	@Override
	public void queryReglaCarga(String tipo, Model model, HttpServletRequest request, Integer id_reglas_carga,
			Integer fromRow) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(ViewCargaDato.class);
			if (!(id_reglas_carga == 0)) {
				count.add(Restrictions.eq("id_fuente", id_reglas_carga));
			}
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);
			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(ViewCargaDato.class);
			if (!(id_reglas_carga == 0)) {
				crit.add(Restrictions.eq("id_fuente", id_reglas_carga));
			}
			crit.addOrder(Order.asc("id_fuente")).setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("consulta", crit.list());
			break;
		case "param":
			Criteria critp = procesoGeneral.getSession().createCriteria(ViewCargaDato.class);
			if (!(id_reglas_carga == 0)) {
				critp.add(Restrictions.eq("id_reglas_carga", id_reglas_carga));
			}
			critp.addOrder(Order.asc("id_fuente")).setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("consulta", critp.list());

			break;
		default:
			break;
		}
	}

	@Override
	public void crudCargaDato(Model model, HttpServletRequest request, String evento, Integer id_reglas_carga,
			Integer id_fuente, String tabla_temporal, String fecha_mod, String usuario, String estatus,
			String comentarios, String sentencia, String fecha_creacion, String fecha_mod_old) {
		Query query = null;
		switch (evento) {
		case "insert":
			sentencia = sentencia.replace("'", "''");
			Integer max_id = procesoGeneral.getId(TablaReglaCarga.class, "id_reglas_carga");
			query = procesoGeneral.getSession()
					.createSQLQuery("insert into tbl_sif_reglas_carga values(" + max_id + "," + id_fuente + ",'"
							+ procesoGeneral.getSesionActual() + "','ACT',sysdate,sysdate,'" + comentarios + "','"
							+ sentencia + "',null)");
			query.executeUpdate();
			break;
		case "update":
			sentencia = sentencia.replace("'", "''");
			query = procesoGeneral.getSession()
					.createSQLQuery("update tbl_sif_reglas_carga set fecha_mod=to_char(to_date('" + fecha_mod
							+ "','DD/MM/YYYY HH24:MI:SS'),'DD/MON/YYYY'), sentencia='" + sentencia + "'," + "usuario='"
							+ usuario + "', fecha_creacion=to_char(to_date('" + fecha_creacion
							+ "','YYYY/MM/DD'),'DD/MON/YYYY'), comentarios='" + comentarios + "', estatus='" + estatus
							+ "', sentencia2=null , id_fuente=" + id_fuente + "   " + "where id_reglas_carga="
							+ id_reglas_carga + " " + "and TRUNC(fecha_mod)= to_char(to_date('" + fecha_mod_old
							+ "','DD/MM/YYYY HH24:MI:SS'),'DD/MON/YYYY')");
			query.executeUpdate();
			break;
		case "delete":

			query = procesoGeneral.getSession()
					.createSQLQuery("delete from tbl_sif_reglas_carga where id_reglas_carga=" + id_reglas_carga);
			query.executeUpdate();

			break;
		default:
			break;
		}

	}

	@Override
	public void queryReglaConversion(String tipo, Model model, HttpServletRequest request, Integer regla_conv_id,
			Integer fuente, String estatus) {
		String consulta = "";
		switch (tipo) {
		case "count":

			break;
		case "consulta":
			consulta = "select c.id_fuente as \"id_fuente\",a.regla_conv_id as \"regla_conv_id\",a.servicio_id as \"servicio_id\",b.clave as \"clave\",b.descripcion as \"descripcion\",a.fecha_mod as \"fecha_mod\",a.estatus as \"estatus\",a.usuario as \"usuario\",a.criterios as \"criterios\",a.comentarios as \"comentarios\",c.clave as \"clave_fuente\",c.descripcion as \"descripcion_fuente\""
					+ " from tbl_sif_reglas_conversion a, tbl_sif_servicios b,tbl_sif_fuentes c "
					+ " where b.id_servicios=a.servicio_id " + " and b.id_fuente=c.id_fuente ";
			if (!(fuente == 0)) {
				consulta = consulta.concat(" and b.id_fuente=" + fuente);
			}
			if (!estatus.equals("empty")) {
				consulta = consulta.concat(" and a.estatus='" + estatus + "'");
			}
			consulta = consulta.concat(" and rownum <=15 order by b.clave asc");
			Query query = procesoGeneral.getSession().createSQLQuery(consulta)
					.setResultTransformer(Transformers.aliasToBean(BeanReglaConversion.class));
			model.addAttribute("consulta", query.list());
			break;
		case "param":

			consulta = "select c.id_fuente as \"id_fuente\" ,a.regla_conv_id as \"regla_conv_id\",a.servicio_id as \"servicio_id\",b.clave as \"clave\",b.descripcion as \"descripcion\",a.fecha_mod as \"fecha_mod\",a.estatus as \"estatus\",a.usuario as \"usuario\",a.criterios as \"criterios\",a.comentarios as \"comentarios\",c.clave as \"clave_fuente\",c.descripcion as \"descripcion_fuente\""
					+ " from tbl_sif_reglas_conversion a, tbl_sif_servicios b,tbl_sif_fuentes c "
					+ " where b.id_servicios=a.servicio_id " + " and b.id_fuente=c.id_fuente "
					+ " and a.estatus='ACT' and regla_conv_id=" + regla_conv_id + " and rownum <=15 "
					+ " order by b.clave asc";
			Query query2 = procesoGeneral.getSession().createSQLQuery(consulta)
					.setResultTransformer(Transformers.aliasToBean(BeanReglaConversion.class));
			model.addAttribute("consulta", query2.list());
			break;
		default:
			break;
		}

	}

	@Override
	public void crudConversionDato(Model model, HttpServletRequest request, Integer regla_conv_id, Integer id_fuente,
			Integer id_servicio, String fecha_mod, String usuario, String estatus, String comentarios, String sentencia,
			String evento) {
		Query query = null;
		switch (evento) {
		case "insert":
			Integer max_id = procesoGeneral.getId(TablaReglaConversion.class, "regla_conv_id");
			sentencia = sentencia.replace("'", "''");
			query = procesoGeneral.getSession()
					.createSQLQuery("insert into tbl_sif_reglas_conversion values(" + max_id + "," + id_servicio
							+ ",null,null,'" + procesoGeneral.getSesionActual() + "','ACT',sysdate,sysdate,'"
							+ procesoGeneral.getSesionActual() + "',sysdate,'" + comentarios + "',null,'" + sentencia
							+ "')");
			query.executeUpdate();
			break;
		case "update":

			sentencia = sentencia.replace("'", "''");
			query = procesoGeneral.getSession()
					.createSQLQuery("update tbl_sif_reglas_conversion set servicio_id=" + id_servicio + ",usuario='"
							+ usuario + "',estatus='" + estatus + "',fecha_mod=sysdate,comentarios='" + comentarios
							+ "'," + "criterios='" + sentencia + "' where regla_conv_id=" + regla_conv_id + "");
			query.executeUpdate();
			break;
		case "delete":
			query = procesoGeneral.getSession()
					.createSQLQuery("delete from tbl_sif_reglas_conversion where regla_conv_id=" + regla_conv_id + "");
			query.executeUpdate();

			break;

		default:
			break;
		}

	}

	@Override
	public void queryEstructuraDato(String tipo, Integer id_fuente, String estatus, Model model,
			HttpServletRequest request) {
		String consulta = "";
		switch (tipo) {
		case "lista":
			consulta = "select x.id_estructura as \"id_estructura\", x.fecha_mod as \"fecha_mod\", x.usuario  as \"usuario\","
					+ " x.fecha_creacion as \"fecha_creacion\", x.comentarios  as \"comentarios\", x.estatus as \"estatus\", x.tabla_totales "
					+ " as \"tabla_totales\", x.tabla_temporal  as \"tabla_temporal\", x.b_suspender_depuracion  as \"b_suspender_depuracion\","
					+ " x.b_no_hay_carga as \"b_no_hay_carga\", x.nombre_campo_cliente as \"nombre_campo_cliente\", x.nombre_campo_cliente_adq  as \"nombre_campo_cliente_adq\","
					+ " x.id_fuente as \"id_fuente\",f.clave as \"clave\"  from tbl_sif_estructura_datos_fte x, tbl_sif_fuentes f "
					+ "where x.id_fuente=f.id_fuente and ((x.estatus like '%ACT%' )) and rownum <=15 order by  f.clave";
			
			Query query = procesoGeneral.getSession().createSQLQuery(consulta)
					.setResultTransformer(Transformers.aliasToBean(BeanEstructuraDato.class));
			model.addAttribute("consulta", query.list());
			
			break;
		case "param":
			consulta = "select x.id_estructura as \"id_estructura\", x.fecha_mod as \"fecha_mod\", x.usuario  as \"usuario\","
					+ " x.fecha_creacion as \"fecha_creacion\", x.comentarios  as \"comentarios\", x.estatus as \"estatus\", x.tabla_totales "
					+ " as \"tabla_totales\", x.tabla_temporal  as \"tabla_temporal\", x.b_suspender_depuracion  as \"b_suspender_depuracion\","
					+ " x.b_no_hay_carga as \"b_no_hay_carga\", x.nombre_campo_cliente as \"nombre_campo_cliente\", x.nombre_campo_cliente_adq  as \"nombre_campo_cliente_adq\","
					+ " x.id_fuente as \"id_fuente\",f.clave as \"clave\"  from tbl_sif_estructura_datos_fte x, tbl_sif_fuentes f "
					+ "where x.id_fuente=f.id_fuente and ((x.estatus like '%' || ? || '%' )and(x.id_fuente=?"
					+ " )) and rownum <=15 order by  f.clave";
			
			Query queryparam = procesoGeneral.getSession().createSQLQuery(consulta)
					.setResultTransformer(Transformers.aliasToBean(BeanEstructuraDato.class));
			queryparam.setParameter(0, estatus);
			queryparam.setParameter(1, id_fuente);
			model.addAttribute("consulta", queryparam.list());

			break;
		case "crud":
			consulta = "select x.id_estructura as \"id_estructura\", x.fecha_mod as \"fecha_mod\", x.usuario  as \"usuario\","
					+ " x.fecha_creacion as \"fecha_creacion\", x.comentarios  as \"comentarios\", x.estatus as \"estatus\", x.tabla_totales "
					+ " as \"tabla_totales\", x.tabla_temporal  as \"tabla_temporal\", x.b_suspender_depuracion  as \"b_suspender_depuracion\","
					+ " x.b_no_hay_carga as \"b_no_hay_carga\", x.nombre_campo_cliente as \"nombre_campo_cliente\", x.nombre_campo_cliente_adq  as \"nombre_campo_cliente_adq\","
					+ " x.id_fuente as \"id_fuente\",f.clave as \"clave\"  from tbl_sif_estructura_datos_fte x, tbl_sif_fuentes f "
					+ "where x.id_fuente=f.id_fuente and ((x.estatus like '%' || ? || '%' )"
					+ ") and x.id_estructura=? and rownum <=15 order by  f.clave";
			
			Query querycrud = procesoGeneral.getSession().createSQLQuery(consulta)
					.setResultTransformer(Transformers.aliasToBean(BeanEstructuraDato.class));
			querycrud.setParameter(0, estatus);
			querycrud.setParameter(1, id_fuente);
			model.addAttribute("consulta", querycrud.list());

			break;
		default:
			break;
		}

	}

	@Override
	public void crudEstructuraDato(Model model, HttpServletRequest request, String evento, Integer id_estructura,
			Integer id_fuente, String tabla_temporal, String tabla_totales, String estatus,
			Integer b_suspender_depuracion, Integer b_no_hay_carga, String nombre_campo_cliente,
			String nombre_campo_cliente_adq, String fecha_creacion, String fecha_mod, String usuario,
			String comentarios) {

		switch (evento) {
		case "update":
			Query queryUpdate = procesoGeneral.getSession()
					.createSQLQuery("update TBL_SIF_ESTRUCTURA_DATOS_FTE set id_fuente=?,"
							+ " tabla_totales=?, tabla_temporal=?,"
							+ " b_suspender_depuracion=?, b_no_hay_carga=?,"
							+ " nombre_campo_cliente=?, nombre_campo_cliente_adq=?,"
							+ " usuario=?, estatus=?,"
							+ " fecha_creacion=to_char(to_date(?,"
							+ "'YYYY-MM-DD'),'DD/MON/YYYY'), fecha_mod=to_char(to_date(?,"
							+ "'YYYY-MM-DD'),'DD/MON/YYYY'), comentarios=? where id_estructura=?");
			queryUpdate.setParameter(0, id_fuente);
			queryUpdate.setParameter(1, tabla_totales);
			queryUpdate.setParameter(2, tabla_temporal);
			queryUpdate.setParameter(3, b_suspender_depuracion);
			queryUpdate.setParameter(4, b_no_hay_carga);
			queryUpdate.setParameter(5, nombre_campo_cliente);
			queryUpdate.setParameter(6, nombre_campo_cliente_adq);
			queryUpdate.setParameter(7, usuario);
			queryUpdate.setParameter(8, estatus);
			queryUpdate.setParameter(9, fecha_creacion);
			queryUpdate.setParameter(10, fecha_mod);
			queryUpdate.setParameter(11, comentarios);
			queryUpdate.setParameter(12, id_estructura);
			queryUpdate.executeUpdate();
			break;
		case "insert":
			Integer max_id = procesoGeneral.getId(TablaEstructuraDato.class, "id_estructura");
			Query query = procesoGeneral.getSession()
					.createSQLQuery("insert into TBL_SIF_ESTRUCTURA_DATOS_FTE " + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
							+ "to_char(to_date(?,"
							+ "'YYYY-MM-DD'),'DD/MON/YYYY'), to_char(to_date(?,"
							+ "'YYYY-MM-DD'),'DD/MON/YYYY'), ?)");
			query.setParameter(0, max_id);
			query.setParameter(1, id_fuente);
			query.setParameter(2, tabla_totales);
			query.setParameter(3, tabla_temporal);
			query.setParameter(4, b_suspender_depuracion);
			query.setParameter(5, b_no_hay_carga);
			query.setParameter(6, nombre_campo_cliente);
			query.setParameter(7, nombre_campo_cliente_adq);
			query.setParameter(8, usuario);
			query.setParameter(9, estatus);
			query.setParameter(10, fecha_creacion);
			query.setParameter(11, fecha_mod);
			query.setParameter(12, comentarios);
			query.executeUpdate();
			break;
		case "delete":
			Query queryDelete = procesoGeneral.getSession().createSQLQuery(
					"delete from TBL_SIF_ESTRUCTURA_DATOS_FTE where id_estructura=?");
			queryDelete.setParameter(0, id_estructura);
			queryDelete.executeUpdate();
			break;

		default:
			break;
		}
	}

	@Override
	public void queryTest(Model model, String sentencia) {
		sentencia = sentencia.replaceAll(":FECHAPROCESO", "SYSDATE");
		try {//falta
			Query query = procesoGeneral.getSession().createSQLQuery("" + sentencia + "");
			query.executeUpdate();
			model.addAttribute("resultado", "Sentencia SQL exitosa");
		} catch (Exception e) {
			model.addAttribute("resultado", e.getMessage());
		}
		
	}
}
