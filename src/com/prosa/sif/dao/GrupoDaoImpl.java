/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 07/08/2018 #
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
import com.prosa.sif.pojo.BeanAsignarServicio;
import com.prosa.sif.pojo.TablaGrupoCliente;
import com.prosa.sif.pojo.TablaGrupoConceptoServicio;
import com.prosa.sif.pojo.TablaGrupoVolumenCliente;
import com.prosa.sif.pojo.TablaGrupoVolumenServicio;

@Repository
@Transactional
@SuppressWarnings("all")
public class GrupoDaoImpl implements GrupoDao {
	@Autowired
	private ProcesoGeneral procesoGeneral;

	@Override
	public void queryConceptoServicio(String tipo, Integer idGrupo, Model model, HttpServletRequest request,
			Integer fromRow) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaGrupoConceptoServicio.class);
			if (!(idGrupo == null)) {
				count.add(Restrictions.eq("id_grupo", idGrupo));
			}
			count.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave"));
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);
			
			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaGrupoConceptoServicio.class);
			if (!(idGrupo == null)) {
				crit.add(Restrictions.eq("id_grupo", idGrupo));
			}
			crit.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave")).setFirstResult(fromRow)
					.setMaxResults(15);
			model.addAttribute("consulta", crit.list());
			
			break;

		case "asignar":
			Query queryAsignar = procesoGeneral.getSession().createSQLQuery(
					"SELECT A.ID_GRUPO as \"id_grupo\", A.CLAVE as \"clave_grupo\", A.DESCRIPCION as \"descripcion_grupo\", A.ESTATUS as \"estatus\", A.FECHA_MOD as \"fecha_mod_grupo\", \r\n"
							+ "A.FECHA_CREA  as \"fecha_crea_grupo\", A.COMENTARIOS as \"comentarios_grupo\", A.USUARIO  as \"usuario_grupo\" ,B.ID_SERVICIOS as \"id_servicios\", B.CLAVE as \"clave\", \r\n"
							+ "B.DESCRIPCION as \"descripcion\", \r\n"
							+ "B.FECHA_MOD as \"fecha_mod\", B.USUARIO  as \"usuario\" FROM TBL_SIF_CAT_GPO_CCPT_SERV A, TBL_SIF_SERVICIOS B WHERE A.ID_GRUPO = B.ID_GRUPO_CONCEPTO AND A.ESTATUS = 'ACT' AND\r\n"
							+ "B.ESTATUS = 'ACT' AND A.ID_GRUPO = decode(:idGrupo,null,null,:idGrupo) ORDER BY B.CLAVE");
			queryAsignar.setParameter("idGrupo", idGrupo);
			queryAsignar.setResultTransformer(Transformers.aliasToBean(BeanAsignarServicio.class));
			model.addAttribute("consultaAsignar", queryAsignar.list());
			break;

		default:
			break;
		}
	}

	@Override
	public void queryVolumenServicio(String tipo, Integer idGrupo, Model model, HttpServletRequest request,
			Integer fromRow) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaGrupoVolumenServicio.class);
			if (!(idGrupo == null)) {
				count.add(Restrictions.eq("id_grupo", idGrupo));
			}
			count.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave"));
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);
			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaGrupoVolumenServicio.class);
			if (!(idGrupo == null)) {
				crit.add(Restrictions.eq("id_grupo", idGrupo));
			}
			crit.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave")).setFirstResult(fromRow)
					.setMaxResults(15);
			model.addAttribute("consulta", crit.list());

			break;
		case "asignar":
			Query queryAsignar = procesoGeneral.getSession().createSQLQuery(
					"SELECT B.CLAVE as \"clave\", B.DESCRIPCION as \"descripcion\", B.FECHA_MOD as \"fecha_mod\", B.USUARIO as \"usuario\",B.ID_SERVICIOS as \"id_servicios\",A.ID_GRUPO as \"id_grupo\", A.CLAVE as \"clave_grupo\", A.DESCRIPCION as \"descripcion_grupo\", A.ESTATUS as \"estatus\", A.FECHA_MOD as \"fecha_mod_grupo\", A.FECHA_CREA as \"fecha_crea_grupo\", A.COMENTARIOS as \"comentarios_grupo\", \r\n"
							+ "A.USUARIO as \"usuario_grupo\" FROM TBL_SIF_CAT_GPO_VOL_SERV A, TBL_SIF_SERVICIOS B WHERE A.ID_GRUPO = B.ID_GRUPO_VOL AND A.ESTATUS = 'ACT' \r\n"
							+ "AND B.ESTATUS = 'ACT' AND A.ID_GRUPO = decode(:idGrupo,null,null,:idGrupo) ORDER BY A.ID_GRUPO");
			queryAsignar.setParameter("idGrupo", idGrupo);
			queryAsignar.setResultTransformer(Transformers.aliasToBean(BeanAsignarServicio.class));
			model.addAttribute("consultaAsignar", queryAsignar.list());
			
			break;
		default:
			break;
		}
	}

	@Override
	public void queryVolumenCliente(String tipo, Integer idGrupo, Model model, HttpServletRequest request,
			Integer fromRow) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaGrupoVolumenCliente.class);
			if (!(idGrupo == null)) {
				count.add(Restrictions.eq("id_grupo", idGrupo));
			}
			count.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave"));
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);
			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaGrupoVolumenCliente.class);
			if (!(idGrupo == null)) {
				crit.add(Restrictions.eq("id_grupo", idGrupo));
			}
			crit.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave")).setFirstResult(fromRow)
					.setMaxResults(15);
			model.addAttribute("consulta", crit.list());

			break;
		case "asignar":
			Query queryAsignar = procesoGeneral.getSession().createSQLQuery(
					"SELECT A.ID_GRUPO as \"id_grupo\", A.CLAVE as \"clave_grupo\", A.DESCRIPCION as \"descripcion_grupo\", A.ESTATUS as \"estatus\", A.FECHA_MOD  as \"fecha_mod_grupo\", \r\n"
							+ "A.FECHA_CREA as \"fecha_crea_grupo\", A.COMENTARIOS as \"comentarios_grupo\", A.USUARIO as \"usuario_grupo\",B.ID_CLIENTE as \"id_servicios\", B.CLAVE_CLIENTE  as \"clave\", \r\n"
							+ "B.NOMBRE_CORTO as \"descripcion\", B.FECHA_MOD as \"fecha_mod\", B.USUARIO as \"usuario\" FROM TBL_SIF_CAT_GPO_VOL_CLIENTES A, TBL_SIF_CAT_CLIENTES B \r\n"
							+ "WHERE A.ID_GRUPO = B.ID_GRUPO_VOL AND A.ESTATUS = 'ACT' AND B.ESTATUS = 'ACT' AND A.ID_GRUPO = decode(:idGrupo,null,null,:idGrupo)"
							+ " ORDER BY A.ID_GRUPO");
			queryAsignar.setParameter("idGrupo", idGrupo);
			queryAsignar.setResultTransformer(Transformers.aliasToBean(BeanAsignarServicio.class));
			model.addAttribute("consultaAsignar", queryAsignar.list());
			
			break;

		default:
			break;
		}
	}

	@Override
	public void queryListaCliente(String tipo, Integer idGrupo, Model model, HttpServletRequest request,
			Integer fromRow) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaGrupoCliente.class);
			if (!(idGrupo == null)) {
				count.add(Restrictions.eq("id_grupo", idGrupo));
			}
			count.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave"));
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);
			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaGrupoCliente.class);
			if (!(idGrupo == null)) {
				crit.add(Restrictions.eq("id_grupo", idGrupo));
			}
			crit.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave")).setFirstResult(fromRow)
					.setMaxResults(15);
			model.addAttribute("consulta", crit.list());

			break;
		case "asignar"://aqui
			Query queryAsignar = procesoGeneral.getSession().createSQLQuery(
					"SELECT A.ID_GRUPO as \"id_grupo\", A.CLAVE as \"clave\", A.DESCRIPCION as \"descripcion\", A.ESQUEMA as \"esquema\", B.USUARIO as \"usuario\", A.COMENTARIOS as \"comentarios\", A.FECHA_CREA as \"fecha_crea\", B.FECHA_CRE as \"fecha_cre\", B.ID_CLIENTE as \"id_cliente\", C.CLAVE_CLIENTE as \"clave_cliente\", C.NOMBRE_CORTO as \"nombre_corto\", B.B_BENEFICIARIO as \"b_beneficiario\",B.DISTRIBUCION as \"distribucion\" FROM TBL_SIF_CAT_GPO_CLIENTES A, TBL_SIF_IND_CLIENTE_GPO B, TBL_SIF_CAT_CLIENTES C WHERE A.ID_GRUPO = B.ID_GRUPO AND B.ID_CLIENTE = C.ID_CLIENTE AND A.ESTATUS = 'ACT' AND A.id_grupo= decode(:idGrupo,null,null,:idGrupo)");
			queryAsignar.setParameter("idGrupo", idGrupo);
			queryAsignar.setResultTransformer(Transformers.aliasToBean(BeanAsignarServicio.class));
			model.addAttribute("consultaAsignar", queryAsignar.list());
			break;
		default:
			break;
		}
	}

	@Override
	public void crudConceptoServicio(String event, Integer idGrupo, String clave, String descripcion,
			String comentarios, Model model, HttpServletRequest request, String listaServiciosExluidos,
			String listaServiciosIncluidos) {
		switch (event) {
		case "delete":
			Query queryDelete = procesoGeneral.getSession()
					.createSQLQuery("update TBL_SIF_CAT_GPO_CCPT_SERV set estatus='ELI' WHERE id_grupo=?");
			queryDelete.setParameter(0, idGrupo);
			queryDelete.executeUpdate();
			break;
		case "update":
			Query queryUpdate = procesoGeneral.getSession()
					.createSQLQuery("update TBL_SIF_CAT_GPO_CCPT_SERV set descripcion=?,"
							+ " fecha_mod=sysdate, comentarios=?, usuario=?"
							+ " where id_grupo=?");
			queryUpdate.setParameter(0, descripcion);
			queryUpdate.setParameter(1, comentarios);
			queryUpdate.setParameter(2, procesoGeneral.getSesionActual());
			queryUpdate.setParameter(3, idGrupo);
			queryUpdate.executeUpdate();
			if (!listaServiciosExluidos.equals("")) {
				String[] dividirStringExcluido = listaServiciosExluidos.split(Pattern.quote("||"));
				
				int numEx = 1;
				for (String valor : dividirStringExcluido) {
					String[] valorDivididoExcluido = valor.split(Pattern.quote("||"));
					String excluido = valorDivididoExcluido[0];
					Query queryExcluir = procesoGeneral.getSession().createSQLQuery(
							"update TBL_SIF_SERVICIOS set id_grupo_concepto=null,fecha_mod=sysdate,usuario=?"
									+ " where id_servicios=?"
									+ " and id_grupo_concepto=?");
					queryExcluir.setParameter(0, procesoGeneral.getSesionActual());
					queryExcluir.setParameter(1, excluido);
					queryExcluir.setParameter(2, idGrupo);
					queryExcluir.executeUpdate();
					numEx++;
				}
			}
			if (!listaServiciosIncluidos.equals("")) {
				String[] dividirStringIncluido = listaServiciosIncluidos.split(Pattern.quote("||"));
				int numIn = 1;

				for (String valor : dividirStringIncluido) {
					String[] valorDivididoIncluido = valor.split(Pattern.quote("||"));
					String incluido = valorDivididoIncluido[0];
					Query queryIncluir = procesoGeneral.getSession()
							.createSQLQuery("update TBL_SIF_SERVICIOS set id_grupo_concepto=?,"
									+ " fecha_mod=sysdate, usuario=?"
									+ " where id_servicios=?");
					queryIncluir.setParameter(0, idGrupo);
					queryIncluir.setParameter(1, procesoGeneral.getSesionActual());
					queryIncluir.setParameter(2, incluido);
					queryIncluir.executeUpdate();
					numIn++;
				}

			}
			break;

		case "insert":
			Integer max_id = procesoGeneral.getId(TablaGrupoConceptoServicio.class, "id_grupo");
			Query queryInsert = procesoGeneral.getSession()
					.createSQLQuery("insert into TBL_SIF_CAT_GPO_CCPT_SERV values(?, ?, ?,"
							+ " 'ACT', sysdate,sysdate, ?, ?)");
			queryInsert.setParameter(0, max_id);
			queryInsert.setParameter(1, clave);
			queryInsert.setParameter(2, descripcion);
			queryInsert.setParameter(3, comentarios);
			queryInsert.setParameter(4, procesoGeneral.getSesionActual());
			queryInsert.executeUpdate();
			if (!listaServiciosExluidos.equals("")) {
				String[] dividirStringExcluido = listaServiciosExluidos.split(Pattern.quote("||"));
				
				int numEx = 1;
				for (String valor : dividirStringExcluido) {
					String[] valorDivididoExcluido = valor.split(Pattern.quote("||"));
					String excluido = valorDivididoExcluido[0];
					Query queryExcluir = procesoGeneral.getSession().createSQLQuery(
							"update TBL_SIF_SERVICIOS set id_grupo_concepto=null,fecha_mod=sysdate,usuario=?"
									+ " where id_servicios=?"
									+ " and id_grupo_concepto=?");
					queryExcluir.setParameter(0, procesoGeneral.getSesionActual());
					queryExcluir.setParameter(1, excluido);
					queryExcluir.setParameter(2, max_id);
					queryExcluir.executeUpdate();
					numEx++;
				}
			}
			if (!listaServiciosIncluidos.equals("")) {
				String[] dividirStringIncluido = listaServiciosIncluidos.split(Pattern.quote("||"));
				int numIn = 1;

				for (String valor : dividirStringIncluido) {
					String[] valorDivididoIncluido = valor.split(Pattern.quote("||"));
					String incluido = valorDivididoIncluido[0];
					Query queryIncluir = procesoGeneral.getSession()
							.createSQLQuery("update TBL_SIF_SERVICIOS set id_grupo_concepto=?,"
									+ " fecha_mod=sysdate,usuario=?"
									+ " where id_servicios=?");
					queryIncluir.setParameter(0, max_id);
					queryIncluir.setParameter(1, procesoGeneral.getSesionActual());
					queryIncluir.setParameter(2, incluido);
					queryIncluir.executeUpdate();
					numIn++;
				}
			}
			break;

		default:
			break;
		}
	}

	@Override
	public void crudVolumenServicio(String event, Integer idGrupo, String clave, String descripcion, String comentarios,
			Model model, HttpServletRequest request, String listaServiciosExluidos, String listaServiciosIncluidos) {
		
		switch (event) {
		case "delete":
			Query queryDelete = procesoGeneral.getSession()
					.createSQLQuery("update TBL_SIF_CAT_GPO_VOL_SERV set estatus='ELI' WHERE id_grupo=?");
			queryDelete.setParameter(0, idGrupo);
			queryDelete.executeUpdate();
			break;
		case "update":
			Query queryUpdate = procesoGeneral.getSession()
					.createSQLQuery("update TBL_SIF_CAT_GPO_VOL_SERV set descripcion=?,"
							+ " fecha_mod=sysdate, comentarios=?, usuario=?"
							+ " where id_grupo=?");
			queryUpdate.setParameter(0, descripcion);
			queryUpdate.setParameter(1, comentarios);
			queryUpdate.setParameter(2, procesoGeneral.getSesionActual());
			queryUpdate.setParameter(3, idGrupo);
			queryUpdate.executeUpdate();
			
			if (!listaServiciosExluidos.equals("")) {
				String[] dividirStringExcluido = listaServiciosExluidos.split(Pattern.quote("||"));
				
				int numEx = 1;
				for (String valor : dividirStringExcluido) {
					String[] valorDivididoExcluido = valor.split(Pattern.quote("||"));
					String excluido = valorDivididoExcluido[0];
					Query queryExcluir = procesoGeneral.getSession()
							.createSQLQuery("update TBL_SIF_SERVICIOS set id_grupo_vol=null,fecha_mod=sysdate,usuario=?"
									+ " where id_servicios=?"
									+ " and id_grupo_vol=?");
					queryExcluir.setParameter(0, procesoGeneral.getSesionActual());
					queryExcluir.setParameter(1, excluido);
					queryExcluir.setParameter(2, idGrupo);
					queryExcluir.executeUpdate();
					numEx++;
				}
			}
			if (!listaServiciosIncluidos.equals("")) {
				String[] dividirStringIncluido = listaServiciosIncluidos.split(Pattern.quote("||"));
				int numIn = 1;

				for (String valor : dividirStringIncluido) {
					String[] valorDivididoIncluido = valor.split(Pattern.quote("||"));
					String incluido = valorDivididoIncluido[0];
					Query queryIncluir = procesoGeneral.getSession()
							.createSQLQuery("update TBL_SIF_SERVICIOS set id_grupo_vol=?,"
									+ " fecha_mod=sysdate,usuario=?"
									+ " where id_servicios=?");
					queryIncluir.setParameter(0, idGrupo);
					queryIncluir.setParameter(1, procesoGeneral.getSesionActual());
					queryIncluir.setParameter(2, incluido);
					queryIncluir.executeUpdate();
					numIn++;
				}

			}

			break;

		case "insert":
			Integer max_id = procesoGeneral.getId(TablaGrupoVolumenServicio.class, "id_grupo");
			Query queryInsert = procesoGeneral.getSession()
					.createSQLQuery("insert into TBL_SIF_CAT_GPO_VOL_SERV values(?, ?, ?,"
							+ " 'ACT', sysdate, sysdate, ?, ?)");
			queryInsert.setParameter(0, max_id);
			queryInsert.setParameter(1, clave);
			queryInsert.setParameter(2, descripcion);
			queryInsert.setParameter(3, comentarios);
			queryInsert.setParameter(4, procesoGeneral.getSesionActual());
			queryInsert.executeUpdate();
			
			if (!listaServiciosExluidos.equals("")) {
				String[] dividirStringExcluido = listaServiciosExluidos.split(Pattern.quote("||"));
				
				int numEx = 1;
				for (String valor : dividirStringExcluido) {
					String[] valorDivididoExcluido = valor.split(Pattern.quote("||"));
					String excluido = valorDivididoExcluido[0];
					Query queryExcluir = procesoGeneral.getSession()
							.createSQLQuery("update TBL_SIF_SERVICIOS set id_grupo_vol=null,fecha_mod=sysdate,usuario=?"
									+ " where id_servicios=?"
									+ " and id_grupo_vol=?");
					queryExcluir.setParameter(0, procesoGeneral.getSesionActual());
					queryExcluir.setParameter(1, excluido);
					queryExcluir.setParameter(2, max_id);
					queryExcluir.executeUpdate();
					numEx++;
				}
			}
			if (!listaServiciosIncluidos.equals("")) {
				String[] dividirStringIncluido = listaServiciosIncluidos.split(Pattern.quote("||"));
				int numIn = 1;

				for (String valor : dividirStringIncluido) {
					String[] valorDivididoIncluido = valor.split(Pattern.quote("||"));
					String incluido = valorDivididoIncluido[0];
					Query queryIncluir = procesoGeneral.getSession()
							.createSQLQuery("update TBL_SIF_SERVICIOS set id_grupo_vol=?,"
									+ " fecha_mod=sysdate,usuario=?"
									+ " where id_servicios=?");
					queryIncluir.setParameter(0, max_id);
					queryIncluir.setParameter(1, procesoGeneral.getSesionActual());
					queryIncluir.setParameter(2, incluido);
					queryIncluir.executeUpdate();
					numIn++;
				}
			}
			break;

		default:
			break;
		}

	}

	@Override
	public void crudVolumenCliente(String event, Integer idGrupo, String clave, String descripcion, String comentarios,
			Model model, HttpServletRequest request, String listaServiciosExluidos, String listaServiciosIncluidos) {
		
		switch (event) {
		case "delete":
			Query queryDelete = procesoGeneral.getSession()
					.createSQLQuery("update TBL_SIF_CAT_GPO_VOL_CLIENTES set estatus='ELI' WHERE id_grupo=?");
			queryDelete.setParameter(0, idGrupo);
			queryDelete.executeUpdate();
			break;
		case "update":
			Query queryUpdate = procesoGeneral.getSession()
					.createSQLQuery("update TBL_SIF_CAT_GPO_VOL_CLIENTES set descripcion=?,"
							+ " fecha_mod=sysdate, comentarios=?, usuario=?"
							+ " where id_grupo=?");
			queryUpdate.setParameter(0, descripcion);
			queryUpdate.setParameter(1, comentarios);
			queryUpdate.setParameter(2, procesoGeneral.getSesionActual());
			queryUpdate.setParameter(3, idGrupo);
			queryUpdate.executeUpdate();
			if (!listaServiciosExluidos.equals("")) {
				String[] dividirStringExcluido = listaServiciosExluidos.split(Pattern.quote("||"));
				
				int numEx = 1;
				for (String valor : dividirStringExcluido) {
					String[] valorDivididoExcluido = valor.split(Pattern.quote("||"));
					String excluido = valorDivididoExcluido[0];
					Query queryExcluir = procesoGeneral.getSession().createSQLQuery(
							"update tbl_sif_cat_clientes set id_grupo_vol=null,fecha_mod=sysdate,usuario=?"
									+ " where id_cliente=?"
									+ " and id_grupo_vol=?");
					queryExcluir.setParameter(0, procesoGeneral.getSesionActual());
					queryExcluir.setParameter(1, excluido);
					queryExcluir.setParameter(2, idGrupo);
					queryExcluir.executeUpdate();
					numEx++;
				}
			}
			if (!listaServiciosIncluidos.equals("")) {
				String[] dividirStringIncluido = listaServiciosIncluidos.split(Pattern.quote("||"));
				int numIn = 1;

				for (String valor : dividirStringIncluido) {
					String[] valorDivididoIncluido = valor.split(Pattern.quote("||"));
					String incluido = valorDivididoIncluido[0];
					Query queryIncluir = procesoGeneral.getSession()
							.createSQLQuery("update tbl_sif_cat_clientes set id_grupo_vol=?,"
									+ " fecha_mod=sysdate,usuario=?"
									+ " where id_cliente=?");
					queryIncluir.setParameter(0, idGrupo);
					queryIncluir.setParameter(1, procesoGeneral.getSesionActual());
					queryIncluir.setParameter(2, incluido);
					queryIncluir.executeUpdate();
					numIn++;
				}

			}
			break;

		case "insert":
			Integer max_id = procesoGeneral.getId(TablaGrupoVolumenCliente.class, "id_grupo");
			Query queryInsert = procesoGeneral.getSession()
					.createSQLQuery("insert into TBL_SIF_CAT_GPO_VOL_CLIENTES values(?, ?, ?,"
							+ " 'ACT',sysdate,sysdate, ?, ?)");
			queryInsert.setParameter(0, max_id);
			queryInsert.setParameter(1, clave);
			queryInsert.setParameter(2, descripcion);
			queryInsert.setParameter(3, comentarios);
			queryInsert.setParameter(4, procesoGeneral.getSesionActual());
			queryInsert.executeUpdate();
			
			
			if (!listaServiciosExluidos.equals("")) {
				String[] dividirStringExcluido = listaServiciosExluidos.split(Pattern.quote("||"));
				
				int numEx = 1;
				for (String valor : dividirStringExcluido) {
					String[] valorDivididoExcluido = valor.split(Pattern.quote("||"));
					String excluido = valorDivididoExcluido[0];
					Query queryExcluir = procesoGeneral.getSession().createSQLQuery(
							"update tbl_sif_cat_clientes set id_grupo_vol=null,fecha_mod=sysdate,usuario=?"
									+ " where id_cliente=?"
									+ " and id_grupo_vol=?");
					queryExcluir.setParameter(0, procesoGeneral.getSesionActual());
					queryExcluir.setParameter(1, excluido);
					queryExcluir.setParameter(2, idGrupo);
					queryExcluir.executeUpdate();
					numEx++;
				}
			}
			if (!listaServiciosIncluidos.equals("")) {
				String[] dividirStringIncluido = listaServiciosIncluidos.split(Pattern.quote("||"));
				int numIn = 1;
				
				for (String valor : dividirStringIncluido) {
					String[] valorDivididoIncluido = valor.split(Pattern.quote("||"));
					String incluido = valorDivididoIncluido[0];
					Query queryIncluir = procesoGeneral.getSession()
							.createSQLQuery("update tbl_sif_cat_clientes set id_grupo_vol= ?,"
									+ " fecha_mod=sysdate, usuario=?"
									+ " where id_cliente=?");
					queryIncluir.setParameter(0, max_id);
					queryIncluir.setParameter(1, procesoGeneral.getSesionActual());
					queryIncluir.setParameter(2, incluido);
					queryIncluir.executeUpdate();
					numIn++;
				}

			}
			break;

		default:
			break;
		}
	}

	@Override
	public void crudListaCliente(String event, Integer idGrupo, String clave, String descripcion, String comentarios,
			Model model, HttpServletRequest request, String esquema, String listaServiciosExluidos,
			String listaServiciosIncluidos, String listaBeneficiarios, String listaDistribucion) {
		switch (event) {
		case "delete":
			Query queryDelete = procesoGeneral.getSession()
					.createSQLQuery("update TBL_SIF_CAT_GPO_CLIENTES set estatus='ELI' WHERE id_grupo=?");
			queryDelete.setParameter(0, idGrupo);
			queryDelete.executeUpdate();
			break;
		case "update":
			Query queryUpdate = procesoGeneral.getSession()
					.createSQLQuery("update TBL_SIF_CAT_GPO_CLIENTES set descripcion=?, esquema=?,"
							+ " fecha_mod=sysdate, comentarios=?, usuario=?"
							+ " where id_grupo=?");
			queryUpdate.setParameter(0, descripcion);
			queryUpdate.setParameter(1, esquema);
			queryUpdate.setParameter(2, comentarios);
			queryUpdate.setParameter(3, procesoGeneral.getSesionActual());
			queryUpdate.setParameter(4, idGrupo);
			queryUpdate.executeUpdate();
			if (!listaServiciosIncluidos.equals("")) {
				String[] dividirStringIncluido = listaServiciosIncluidos.split(Pattern.quote("||"));
				int numIn = 1;

				for (String valor : dividirStringIncluido) {
					String[] valorDivididoIncluido = valor.split(Pattern.quote("||"));
					String incluido = valorDivididoIncluido[0];
					Query queryIncluir = procesoGeneral.getSession()
							.createSQLQuery("insert into TBL_SIF_IND_CLIENTE_GPO values(?, ?"
									+ ", ?,sysdate,'NO',0)");
					queryIncluir.setParameter(0, incluido);
					queryIncluir.setParameter(1, idGrupo);
					queryIncluir.setParameter(2, procesoGeneral.getSesionActual());
					queryIncluir.executeUpdate();
					numIn++;
				}

			}
			if (!listaBeneficiarios.equals("")) {
				String[] dividirStringBeneficiario = listaBeneficiarios.split(Pattern.quote("||"));
				
				int numBeneficiario = 1;
				for (String valorBeneficiario : dividirStringBeneficiario) {
					String[] valorDivididoBeneficiario = valorBeneficiario.split(Pattern.quote("||"));
					String beneficiado = valorDivididoBeneficiario[0];
					
					Query queryBeneficiario = procesoGeneral.getSession()
							.createSQLQuery("update TBL_SIF_IND_CLIENTE_GPO set b_beneficiario='Si' where id_cliente=?"
									+ " and id_grupo=?");
					queryBeneficiario.setParameter(0, beneficiado);
					queryBeneficiario.setParameter(1, idGrupo);
					queryBeneficiario.executeUpdate();
					numBeneficiario++;
				}
			}
			if (!listaDistribucion.equals("")) {
				String[] dividirStringDistribucion = listaDistribucion.split(Pattern.quote("||"));
				
				int numDistribucion = 1;
				for (String valorDistribucion : dividirStringDistribucion) {
					String[] valorDivididoDistribucion = valorDistribucion.split(Pattern.quote(","));
					String distribucion = valorDivididoDistribucion[0];
					String distribucion2 = valorDivididoDistribucion[1];
					
					Query queryDistribucion = procesoGeneral.getSession()
							.createSQLQuery("update TBL_SIF_IND_CLIENTE_GPO set distribucion=?"
									+ " where id_cliente=? and id_grupo=?");
					queryDistribucion.setParameter(0, distribucion);
					queryDistribucion.setParameter(1, distribucion2);
					queryDistribucion.setParameter(2, idGrupo);
					queryDistribucion.executeUpdate();
					numDistribucion++;
				}
			}
			if (!listaServiciosExluidos.equals("")) {
				String[] dividirStringExcluido = listaServiciosExluidos.split(Pattern.quote("||"));
				
				int numEx = 1;
				for (String valor : dividirStringExcluido) {
					String[] valorDivididoExcluido = valor.split(Pattern.quote("||"));
					String excluido = valorDivididoExcluido[0];
					Query queryExcluir = procesoGeneral.getSession()
							.createSQLQuery("delete from TBL_SIF_IND_CLIENTE_GPO where id_cliente=?"
									+ " and id_grupo=?");
					queryExcluir.setParameter(0, excluido);
					queryExcluir.setParameter(1, idGrupo);
					queryExcluir.executeUpdate();
					numEx++;
				}
			}

			break;

		case "insert":
			Integer max_id = procesoGeneral.getId(TablaGrupoCliente.class, "id_grupo");
			Query queryInsert = procesoGeneral.getSession()
					.createSQLQuery("insert into TBL_SIF_CAT_GPO_CLIENTES values(?, ?, ?,"
							+ " 'ACT',sysdate,sysdate, ?, ?, ?)");
			queryInsert.setParameter(0, max_id);
			queryInsert.setParameter(1, clave);
			queryInsert.setParameter(2, descripcion);
			queryInsert.setParameter(3, comentarios);
			queryInsert.setParameter(4, procesoGeneral.getSesionActual());
			queryInsert.setParameter(5, esquema);
			queryInsert.executeUpdate();

			if (!listaServiciosExluidos.equals("")) {
				String[] dividirStringExcluido = listaServiciosExluidos.split(Pattern.quote("||"));
				
				int numEx = 1;
				for (String valor : dividirStringExcluido) {
					String[] valorDivididoExcluido = valor.split(Pattern.quote("||"));
					String excluido = valorDivididoExcluido[0];
					Query queryExcluir = procesoGeneral.getSession()
							.createSQLQuery("delete from TBL_SIF_IND_CLIENTE_GPO where id_cliente=?"
									+ " and id_grupo=?");
					queryExcluir.setParameter(0, excluido);
					queryExcluir.setParameter(1, max_id);
					queryExcluir.executeUpdate();
					numEx++;
				}
			}
			if (!listaServiciosIncluidos.equals("")) {
				String[] dividirStringIncluido = listaServiciosIncluidos.split(Pattern.quote("||"));
				int numIn = 1;

				for (String valor : dividirStringIncluido) {
					String[] valorDivididoIncluido = valor.split(Pattern.quote("||"));
					String incluido = valorDivididoIncluido[0];
					Query queryIncluir = procesoGeneral.getSession()
							.createSQLQuery("insert into TBL_SIF_IND_CLIENTE_GPO values(?, ?"
									+ ", ?,sysdate,'NO',0)");
					queryIncluir.setParameter(0, incluido);
					queryIncluir.setParameter(1, max_id);
					queryIncluir.setParameter(2, procesoGeneral.getSesionActual());
					queryIncluir.executeUpdate();
					numIn++;
				}
			}
			if (!listaBeneficiarios.equals("")) {
				String[] dividirStringBeneficiario = listaBeneficiarios.split(Pattern.quote("||"));
				
				int numBeneficiario = 1;
				for (String valorBeneficiario : dividirStringBeneficiario) {
					String[] valorDivididoBeneficiario = valorBeneficiario.split(Pattern.quote("||"));
					String beneficiado = valorDivididoBeneficiario[0];
					
					Query queryBeneficiario = procesoGeneral.getSession()
							.createSQLQuery("update TBL_SIF_IND_CLIENTE_GPO set b_beneficiario='Si' where id_cliente=?"
									+ " and id_grupo=?");
					queryBeneficiario.setParameter(0, beneficiado);
					queryBeneficiario.setParameter(1, max_id);
					queryBeneficiario.executeUpdate();
					numBeneficiario++;
				}
			}
			if (!listaDistribucion.equals("")) {
				String[] dividirStringDistribucion = listaDistribucion.split(Pattern.quote("||"));
				
				int numDistribucion = 1;
				for (String valorDistribucion : dividirStringDistribucion) {
					String[] valorDivididoDistribucion = valorDistribucion.split(Pattern.quote(","));
					String distribucion = valorDivididoDistribucion[0];
					String distribucion2 = valorDivididoDistribucion[1];
					
					Query queryDistribucion = procesoGeneral.getSession()
							.createSQLQuery("update TBL_SIF_IND_CLIENTE_GPO set distribucion=?"
									+ " where id_cliente=? and id_grupo=?");
					queryDistribucion.setParameter(0, distribucion);
					queryDistribucion.setParameter(1, distribucion2);
					queryDistribucion.setParameter(2, max_id);
					queryDistribucion.executeUpdate();
					numDistribucion++;
				}
			}
			break;

		default:
			break;
		}

	}

}
