/**
################################################################################
# Autor               : Garnica                                                #
# Compania            : Código Geek                                            #
# Proyecto/Procliente : Implement de red logica              Fecha: 08/03/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/
package com.prosa.sif.dao;

import java.util.regex.Pattern;

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
import com.prosa.sif.pojo.BeanRedesLogica;
import com.prosa.sif.pojo.TablaNegocio;
import com.prosa.sif.pojo.TablaRedLogica;
import com.prosa.sif.pojo.TablaServicio;
/**
 * 
 * @author David Garnica Garcia
 *
 */
@Repository
@Transactional
@SuppressWarnings("all")
public class RedLogicaDaoImpl implements RedLogicaDao {
	@Autowired
	private ProcesoGeneral procesoGeneral;
	
	Integer max_id;
	
	@Override
	public void queryRedLogica(String tipo, Model model, HttpServletRequest request, Integer fromRow, String clave,
			String estatus) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaRedLogica.class);
			if (!clave.equals("empty")) {
				count.add(Restrictions.eq("clave", clave));
			}
			if (!estatus.equals("empty")) {
				count.add(Restrictions.eq("estatus", estatus));
			}
			count.addOrder(Order.asc("clave"));
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);

			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaRedLogica.class);
			if (!clave.equals("empty")) {
				crit.add(Restrictions.eq("clave", clave));
			}
			if (!estatus.equals("empty")) {
				crit.add(Restrictions.eq("estatus", estatus));
			}
			crit.addOrder(Order.asc("clave")).setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("consulta", crit.list());
			break;

		default:
			break;
		}

	}

	@Override
	public void queryFindRedLogica(Model model,String clave) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaRedLogica.class).add(Restrictions.eq("clave", clave));
		model.addAttribute("editar", crit.list());
	}


	@Override
	public void saveOrUpdateRedesLogicas(HttpServletRequest request, String evento, TablaRedLogica insert, String fecha_crea, String descripcion,
			String usuario, String estatus, String clave) {
		
		// TODO Auto-generated method stub
		switch (evento) {
		case "update":
			Query queryUpdate = procesoGeneral.getSession()
					.createSQLQuery("update TBL_SIF_CAT_REDES_LOGICAS " + " set descripcion= ?,"
							+ " estatus= ?," + " usuario= ?,"
							+ " fecha=to_date(?,'yyyy-mm-dd')" + " where clave=?");
			queryUpdate.setParameter(0, descripcion);
			queryUpdate.setParameter(1, estatus);
			queryUpdate.setParameter(2, usuario);
			queryUpdate.setParameter(3, fecha_crea);
			queryUpdate.setParameter(4, clave);
			queryUpdate.executeUpdate();
			break;
		case "insert":
			
			Query queryInsert = procesoGeneral.getSession()
					.createSQLQuery("Insert into TBL_SIF_CAT_REDES_LOGICAS values(?, ?, ?, ?,"
							+ "to_date(?,'yyyy-mm-dd'))");
			queryInsert.setParameter(0, clave);
			queryInsert.setParameter(1, descripcion);
			queryInsert.setParameter(2, estatus);
			queryInsert.setParameter(3, usuario);
			queryInsert.setParameter(4, fecha_crea);
			queryInsert.executeUpdate();
			break;
		case "delete":
				Query delete = procesoGeneral.getSession()
						.createSQLQuery("update TBL_SIF_CAT_NEGOCIOS set status='NOA' where clave=?");
				delete.setParameter(0, clave);
				delete.executeUpdate();
			break;
		default:
			break;
		}
	}

	@Override
	public void queryRedLogicaService(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			String clave) {
		switch (tipo) {
		case "count":
			String consulta="select rls.cv_red_logica AS \"cv_red_logica\",s.clave AS \"clave\","
					+ " rls.cv_servicio AS \"cv_servicio\","
					+ " s.descripcion AS \"descripcion\",rls.estatus AS \"estatus\", "
					+ "rls.usuario AS \"usuario\", rls.fecha AS \"fecha\" from tbl_sif_redlogica_servicios rls,tbl_sif_servicios s "
					+ "where substr(rls.cv_servicio,1,5) = s.clave and rls.cv_red_logica = ? order by 3";
			Query count = procesoGeneral.getSession().createSQLQuery(consulta);
			count.setParameter(0, clave);
			model.addAttribute("registros_totales", count.list().size());
			break;
		case "consulta":
			consulta="select rls.cv_red_logica AS \"cv_red_logica\",s.clave AS \"clave\","
					+ " rls.cv_servicio AS \"cv_servicio\","
					+ " s.descripcion AS \"descripcion\",rls.estatus AS \"estatus\", "
					+ "rls.usuario AS \"usuario\", rls.fecha AS \"fecha\" from tbl_sif_redlogica_servicios rls,tbl_sif_servicios s "
					+ "where substr(rls.cv_servicio,1,5) = s.clave and rls.cv_red_logica = ? order by 3";
			consulta = consulta.concat(" OFFSET ? ROWS FETCH NEXT 15 ROWS ONLY");
			Query query = procesoGeneral.getSession().createSQLQuery(consulta)
					.setResultTransformer(Transformers.aliasToBean(BeanRedesLogica.class));
			query.setParameter(0, clave);
			query.setParameter(1, fromRow);
			model.addAttribute("consultaLogic", query.list());
			break;

		default:
			break;

		}		
	}

	@Override
	public void ConfirmarService(Model model, HttpServletRequest request, Integer fromRow, String values) {
		String[] numact=values.split(Pattern.quote("||"));
		for (int i = 0; i < numact.length; i++) {
			String[] val=numact[i].split(Pattern.quote(","));
			if(val[2].trim().equals("ACT")) {
				Query queryUpdate = procesoGeneral.getSession()
						.createSQLQuery("update TBL_SIF_REDLOGICA_SERVICIOS set estatus = 'NOA' "
								+ "where cv_red_logica = ? and cv_servicio = ?");
				queryUpdate.setParameter(0, val[0]);
				queryUpdate.setParameter(1, val[1]);
				queryUpdate.executeUpdate();
			}else {
				Query queryUpdate = procesoGeneral.getSession()
						.createSQLQuery("update TBL_SIF_REDLOGICA_SERVICIOS set estatus = 'ACT' "
								+ "where cv_red_logica = ? and cv_servicio = ?");
				queryUpdate.setParameter(0, val[0]);
				queryUpdate.setParameter(1, val[1]);
				queryUpdate.executeUpdate();
			}
			
			
		}
		String[] valrec=numact[0].split(Pattern.quote(","));
		model.addAttribute("clave", valrec[0]);
		queryRedLogicaService("count", model, request, fromRow, valrec[0]);
		queryRedLogicaService("consulta", model, request, fromRow,valrec[0]);
	}

	@Override
	public void listaServicio(Model model,int clave, String estatus) {
		String consulta ="select clave as \"clave\", descripcion as \"descripcion\"  from tbl_sif_servicios where"
				+ " id_fuente = "+clave+" and estatus = '"+estatus+"'" + 
				"and clave not in (select cv_servicio from tbl_sif_redlogica_servicios) order by 1";
		Query query = procesoGeneral.getSession().createSQLQuery(consulta)
				.setResultTransformer(Transformers.aliasToBean(TablaServicio.class));
		model.addAttribute("listaService", query.list());
		
	}

	@Override
	public void Agregarservicio(Model model, HttpServletRequest request, String id_servicio) {
		String serv = "'"+id_servicio+"X"+"'";
		Query queryInsertIn = procesoGeneral.getSession()
				.createSQLQuery("insert into tbl_sif_redlogica_servicios "
						+ "(cv_servicio, cv_red_logica, estatus, usuario, fecha)" + 
						"select ?,clave,'NOA'"
								+ ", ?,sysdate" + 
						" from tbl_sif_cat_redes_logicas  where estatus = 'ACT'");
		queryInsertIn.setParameter(0, id_servicio);
		queryInsertIn.setParameter(1, procesoGeneral.getSesionActual());
		Query queryInsertEx = procesoGeneral.getSession()
				.createSQLQuery("insert into tbl_sif_redlogica_servicios "
						+ "(cv_servicio, cv_red_logica, estatus, usuario, fecha)" + 
						"select ?,clave,'NOA'"
								+ ", ?,sysdate" + 
						" from tbl_sif_cat_redes_logicas  where estatus = 'ACT'");
		queryInsertEx.setParameter(0, serv);
		queryInsertEx.setParameter(1, procesoGeneral.getSesionActual());
		queryInsertIn.executeUpdate();
		queryInsertEx.executeUpdate();
	}

}
