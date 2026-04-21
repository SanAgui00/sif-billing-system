/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 16/04/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prosa.sif.operation.ProcesoGeneral;
import com.prosa.sif.pojo.BeanClienteUsuarioServicio;
import com.prosa.sif.pojo.TablaAddenda;
import com.prosa.sif.pojo.TablaBanco;
import com.prosa.sif.pojo.TablaCentroCosto;
import com.prosa.sif.pojo.TablaConcepto;
import com.prosa.sif.pojo.TablaEmpresa;
import com.prosa.sif.pojo.TablaEventoServicio;
import com.prosa.sif.pojo.TablaFormaPagos;
import com.prosa.sif.pojo.TablaFuente;
import com.prosa.sif.pojo.TablaFuncionalidad;
import com.prosa.sif.pojo.TablaIngreso;
import com.prosa.sif.pojo.TablaMoneda;
import com.prosa.sif.pojo.TablaParametro;
import com.prosa.sif.pojo.TablaProceso;
import com.prosa.sif.pojo.TablaServicioParticular;
import com.prosa.sif.pojo.TablaTipoCuenta;
import com.prosa.sif.pojo.TablaTipoPago;
import com.prosa.sif.pojo.TablaUMedida;
import com.prosa.sif.pojo.TablaUsuario;

/**
 * 
 * @author Loredo
 *
 */
@Repository
@Transactional
@SuppressWarnings("all")
public class ApoyoDaoImpl implements ApoyoDao {
	@Autowired
	private ProcesoGeneral procesoGeneral;

	@Override
	public void queryEmpresa(String tipo, Model model, HttpServletRequest request, Integer id_empresa,
			Integer fromRow) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaEmpresa.class);
			if (!(id_empresa == 0)) {
				count.add(Restrictions.eq("id_empresa", id_empresa));
			}
			count.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("razon_social"))
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);
			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaEmpresa.class);
			if (!(id_empresa == 0)) {
				crit.add(Restrictions.eq("id_empresa", id_empresa));
			}
			crit.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("razon_social")).setFirstResult(fromRow)
					.setMaxResults(15).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			model.addAttribute("consulta", crit.list());
			break;

		default:
			break;
		}

	}

	@Override
	public void crudEmpresa(Model model, HttpServletRequest request, String evento, TablaEmpresa insert,
			String fecha_cre, String fecha_mod) {
		if (!fecha_cre.equals("null")) {
			Date fecha_creacion = procesoGeneral.formatDate(fecha_cre);
			insert.setFecha_cre(fecha_creacion);
		}
		if (!fecha_mod.equals("null")) {
			Date fecha_modificacion = procesoGeneral.formatDate(fecha_mod);
			insert.setFecha_mod(fecha_modificacion);
		}

		switch (evento) {
		case "update":
			procesoGeneral.getSession().update(insert);
			break;
		case "insert":
			Integer max_id = procesoGeneral.getId(TablaEmpresa.class, "id_empresa");
			insert.setId_empresa(max_id);
			insert.setEstatus(new String("ACT"));
			procesoGeneral.getSession().save(insert);

			break;
		case "delete":
				Query delete = procesoGeneral.getSession().createSQLQuery(
						"update TBL_SIF_CAT_EMPRESAS set estatus='ELI' where id_empresa=" + insert.getId_empresa());
				delete.executeUpdate();
			break;

		default:
			break;
		}
	}

	@Override
	public void queryFuente(String tipo, Model model, HttpServletRequest request, Integer id_fuente, Integer fromRow) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaFuente.class);
			count.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave"));
			if (!(id_fuente == 0)) {
				count.add(Restrictions.eq("id_fuente", id_fuente));
			}
			count.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);
			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaFuente.class);
			crit.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave"));
			if (!(id_fuente == 0)) {
				crit.add(Restrictions.eq("id_fuente", id_fuente));
			}
			crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("consulta", crit.list());
			break;

		default:
			break;
		}
	}

	@Override
	public void crudFuente(Model model, HttpServletRequest request, String evento, Integer id_fuente, String clave,
			Integer id_fuente_base_clave_cli, String descripcion, String comentarios) {
	
		switch (evento) {
		case "update":
			Query update = procesoGeneral.getSession().createSQLQuery(
					"update tbl_sif_fuentes set id_fuente_base_clave_cli=?,clave=?,descripcion=?," + 
					"fecha_mod=sysdate,usuario=?,comentarios=? where id_fuente=?");
			update.setInteger(0, id_fuente_base_clave_cli);
			update.setString(1, clave);
			update.setString(2,descripcion);
			update.setString(3,procesoGeneral.getSesionActual());
			update.setString(4, comentarios);
			update.setInteger(5, id_fuente);
			update.executeUpdate();
			break;
		case "insert":
			Integer max_id = procesoGeneral.getId(TablaFuente.class, "id_fuente");
			Query insert = procesoGeneral.getSession().createSQLQuery(
					"insert into tbl_sif_fuentes values(?,?,?,?,?,sysdate,sysdate,?,?)");
			insert.setInteger(0, max_id);
			insert.setInteger(1, id_fuente_base_clave_cli);
			insert.setString(2, clave);
			insert.setString(3, descripcion);
			insert.setString(4, "ACT");
			insert.setString(5, procesoGeneral.getSesionActual());
			insert.setString(6, comentarios);
			insert.executeUpdate();

			break;
		case "delete":
				Query delete = procesoGeneral.getSession().createSQLQuery(
						"update TBL_SIF_FUENTES set estatus='ELI' where id_fuente=?");
				delete.setParameter(0, id_fuente);
				delete.executeUpdate();
			break;

		default:
			break;
		}
	}

	@Override
	public void queryProceso(String tipo, Model model, HttpServletRequest request, Integer id_proceso,
			Integer fromRow) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaProceso.class);
			count.add(Restrictions.eq("estatus", "ACT"));
			if (!(id_proceso == 0)) {
				count.add(Restrictions.eq("id_proceso", id_proceso));
			}
			count.addOrder(Order.asc("clave_proceso"));
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);
			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaProceso.class);
			crit.add(Restrictions.eq("estatus", "ACT"));
			if (!(id_proceso == 0)) {
				crit.add(Restrictions.eq("id_proceso", id_proceso));
			}
			crit.addOrder(Order.asc("clave_proceso"));
			model.addAttribute("consulta", crit.list());
			break;

		default:
			break;
		}

	}

	@Override
	public void crudProceso(Model model, HttpServletRequest request, String evento, TablaProceso insert,
			String fecha_cre, String fecha_mod) {
		if (!fecha_cre.equals("null")) {
			Date fecha_creacion = procesoGeneral.formatDate(fecha_cre);
			insert.setFecha_cre(fecha_creacion);
		}
		if (!fecha_mod.equals("null")) {
			Date fecha_modificacion = procesoGeneral.formatDate(fecha_mod);
			insert.setFecha_mod(fecha_modificacion);
		}

		switch (evento) {
		case "update":
			insert.setFecha_mod(new Date());
			insert.setUsuario(procesoGeneral.getSesionActual());
			procesoGeneral.getSession().update(insert);
			break;
		case "insert":
			insert.setFecha_cre(new Date());
			insert.setFecha_mod(new Date());
			insert.setUsuario(procesoGeneral.getSesionActual());
			Integer max_id = procesoGeneral.getId(TablaProceso.class, "id_proceso");
			insert.setId_proceso(max_id);
			insert.setEstatus(new String("ACT"));
			procesoGeneral.getSession().save(insert);
			break;
		case "delete":
				Query delete = procesoGeneral.getSession().createSQLQuery(
						"update TBL_SIF_CAT_PROCESOS set estatus='ELI' where id_proceso=" + insert.getId_proceso());
				delete.executeUpdate();
			break;

		default:
			break;
		}

	}

	@Override
	public void queryCentroCosto(String tipo, Model model, HttpServletRequest request, Integer id_centro_costos,
			Integer fromRow) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaCentroCosto.class);
			if (!(id_centro_costos == 0)) {
				count.add(Restrictions.eq("id_centro_costos", id_centro_costos));
			}
			count.add(Restrictions.eq("estatus", "ACT"));
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);
			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaCentroCosto.class);
			if (!(id_centro_costos == 0)) {
				crit.add(Restrictions.eq("id_centro_costos", id_centro_costos));
			}
			crit.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave_centro_costos"))
					.setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("consulta", crit.list());
			break;
		default:
			break;
		}
	}

	@Override
	public void crudCentroCosto(Model model, HttpServletRequest request, String evento, TablaCentroCosto insert,
			String fecha_cre, String fecha_mod) {
		if (!fecha_cre.equals("null")) {
			Date fecha_creacion = procesoGeneral.formatDate(fecha_cre);
			insert.setFecha_cre(fecha_creacion);
		}
		if (!fecha_mod.equals("null")) {
			Date fecha_modificacion = procesoGeneral.formatDate(fecha_mod);
			insert.setFecha_mod(fecha_modificacion);
		}

		switch (evento) {
		case "update":
			procesoGeneral.getSession().update(insert);

			break;
		case "insert":
			Integer max_id = procesoGeneral.getId(TablaCentroCosto.class, "id_centro_costos");
			insert.setId_centro_costos(max_id);
			insert.setEstatus(new String("ACT"));

			procesoGeneral.getSession().save(insert);

			break;
		case "delete":
				Query delete = procesoGeneral.getSession()
						.createSQLQuery("update TBL_SIF_CAT_CENTRO_COSTOS set estatus='ELI' where id_centro_costos="
								+ insert.getId_centro_costos());
				delete.executeUpdate();
			break;

		default:
			break;
		}
	}

	@Override
	public void queryCuentaContable(String tipo, Model model, HttpServletRequest request, Integer id_tipo_cuenta,
			Integer fromRow) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaTipoCuenta.class);
			if (!(id_tipo_cuenta == 0)) {
				count.add(Restrictions.eq("id_tipo_cuenta", id_tipo_cuenta));
			}
			count.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave"))
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);

			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaTipoCuenta.class);
			if (!(id_tipo_cuenta == 0)) {
				crit.add(Restrictions.eq("id_tipo_cuenta", id_tipo_cuenta));
			}
			crit.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave"))
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("consulta", crit.list());
			break;

		default:
			break;
		}
	}

	@Override
	public void crudCuentaContable(Model model, HttpServletRequest request, String evento, TablaTipoCuenta insert,
			String fecha_cre, String fecha_mod) {
		if (!fecha_cre.equals("null")) {
			Date fecha_creacion = procesoGeneral.formatDate(fecha_cre);
			insert.setFecha_cre(fecha_creacion);
		}
		if (!fecha_mod.equals("null")) {
			Date fecha_modificacion = procesoGeneral.formatDate(fecha_mod);
			insert.setFecha_mod(fecha_modificacion);
		}

		switch (evento) {
		case "update":
			procesoGeneral.getSession().update(insert);

			break;
		case "insert":
			Integer max_id = procesoGeneral.getId(TablaTipoCuenta.class, "id_tipo_cuenta");
			insert.setEstatus(new String("ACT"));
			insert.setId_tipo_cuenta(max_id);
			procesoGeneral.getSession().save(insert);

			break;
		case "delete":
				Query delete = procesoGeneral.getSession()
						.createSQLQuery("update TBL_SIF_CAT_TIPO_CUENTAS set estatus='ELI' where id_tipo_cuenta="
								+ insert.getId_tipo_cuenta());
				delete.executeUpdate();
			break;

		default:
			break;
		}
	}

	@Override
	public void queryFormaPago(String tipo, Model model, HttpServletRequest request, Integer id_forma_pago,
			Integer fromRow) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaFormaPagos.class);
			if (!(id_forma_pago == 0)) {
				count.add(Restrictions.eq("id_forma_pago", id_forma_pago));
			}
			count.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave"))
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);
			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaFormaPagos.class);
			if (!(id_forma_pago == 0)) {
				crit.add(Restrictions.eq("id_forma_pago", id_forma_pago));
			}
			crit.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave"))
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("consulta", crit.list());
			break;

		default:
			break;
		}
	}

	@Override
	public void crudFormaPago(Model model, HttpServletRequest request, String evento, TablaFormaPagos insert,
			String fecha_cre, String fecha_mod) {
		if (!fecha_cre.equals("null")) {
			Date fecha_creacion = procesoGeneral.formatDate(fecha_cre);
			insert.setFecha_cre(fecha_creacion);
		}
		if (!fecha_mod.equals("null")) {
			Date fecha_modificacion = procesoGeneral.formatDate(fecha_mod);
			insert.setFecha_mod(fecha_modificacion);
		}

		switch (evento) {
		case "update":
			procesoGeneral.getSession().update(insert);

			break;
		case "insert":
			Integer max_id = procesoGeneral.getId(TablaFormaPagos.class, "id_forma_pago");
			insert.setId_forma_pago(max_id);
			insert.setEstatus(new String("ACT"));
			procesoGeneral.getSession().save(insert);

			break;
		case "delete":
				Query delete = procesoGeneral.getSession()
						.createSQLQuery("update TBL_SIF_CAT_FORMAS_PAGOS set estatus='ELI' where id_forma_pago="
								+ insert.getId_forma_pago());
				delete.executeUpdate();
			break;

		default:
			break;
		}
	}

	@Override
	public void queryTipoPago(String tipo, Model model, HttpServletRequest request, Integer id_tipos_pago,
			Integer fromRow) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaTipoPago.class);
			if (!(id_tipos_pago == 0)) {
				count.add(Restrictions.eq("id_tipos_pago", id_tipos_pago));
			}
			count.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave"))
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);

			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaTipoPago.class);
			if (!(id_tipos_pago == 0)) {
				crit.add(Restrictions.eq("id_tipos_pago", id_tipos_pago));
			}
			crit.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave"))
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("consulta", crit.list());
			break;

		default:
			break;
		}
	}

	@Override
	public void crudTipoPago(Model model, HttpServletRequest request, String evento, TablaTipoPago insert,
			String fecha_cre, String fecha_mod) {
		if (!fecha_cre.equals("null")) {
			Date fecha_creacion = procesoGeneral.formatDate(fecha_cre);
			insert.setFecha_cre(fecha_creacion);
		}
		if (!fecha_mod.equals("null")) {
			Date fecha_modificacion = procesoGeneral.formatDate(fecha_mod);
			insert.setFecha_mod(fecha_modificacion);
		}

		switch (evento) {
		case "update":
			procesoGeneral.getSession().update(insert);

			break;
		case "insert":
			Integer max_id = procesoGeneral.getId(TablaTipoPago.class, "id_tipos_pago");
			insert.setId_tipos_pago(max_id);
			insert.setEstatus(new String("ACT"));
			procesoGeneral.getSession().save(insert);

			break;
		case "delete":
				Query delete = procesoGeneral.getSession()
						.createSQLQuery("update TBL_SIF_CAT_TIPOS_PAGO set estatus='ELI' where id_tipos_pago="
								+ insert.getId_tipos_pago());
				delete.executeUpdate();
			break;

		default:
			break;
		}

	}

	@Override
	public void queryUMedida(String tipo, Model model, HttpServletRequest request, Integer id, String estatus,
			Integer fromRow) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaUMedida.class);
			if (!(id == 0)) {
				count.add(Restrictions.eq("id", id));
			}
			if (!estatus.equals("empty")) {
				count.add(Restrictions.eq("estatus", estatus));
			}
			count.addOrder(Order.asc("clave")).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);

			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaUMedida.class);
			if (!(id == 0)) {
				crit.add(Restrictions.eq("id", id));
			}
			if (!estatus.equals("empty")) {
				crit.add(Restrictions.eq("estatus", estatus));
			}
			crit.addOrder(Order.asc("clave")).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
					.setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("consulta", crit.list());
			break;

		default:
			break;
		}
	}

	@Override
	public void crudUMedida(Model model, HttpServletRequest request, String evento, TablaUMedida insert,
			String fecha_cre, String fecha_mod) {
		if (!fecha_cre.equals("null")) {
			Date fecha_creacion = procesoGeneral.formatDate(fecha_cre);
			insert.setFecha(fecha_creacion);
		}
		if (!fecha_mod.equals("null")) {
			Date fecha_modificacion = procesoGeneral.formatDate(fecha_mod);
			insert.setFecha(fecha_modificacion);
		}

		switch (evento) {
		case "update":
			procesoGeneral.getSession().update(insert);

			break;
		case "insert":
			Integer max_id = procesoGeneral.getId(TablaUMedida.class, "id");
			insert.setId(max_id);
			insert.setEstatus(new String("ACT"));
			procesoGeneral.getSession().save(insert);

			break;
		case "delete":
				Query delete = procesoGeneral.getSession().createSQLQuery(
						"update TBL_SIF_CAT_UMEDIDAFACTURA set estatus='ELI' where id=" + insert.getId());
				delete.executeUpdate();
			break;

		default:
			break;
		}
	}

	@Override
	public void queryConcepto(String tipo2, Model model, HttpServletRequest request, String tipo, Integer grupo,
			String descripcion, String estatus, Integer id, Integer fromRow) {
		switch (tipo2) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaConcepto.class);
			if (!tipo.equals("empty")) {
				count.add(Restrictions.eq("tipo", tipo));
			}
			if (!(grupo == 0)) {
				count.add(Restrictions.eq("id", grupo));
			}
			if (!descripcion.equals("empty")) {
				count.add(Restrictions.eq("descripcion", descripcion));
			}
			if (!estatus.equals("empty")) {
				count.add(Restrictions.eq("estatus", estatus));
			}

			count.addOrder(Order.asc("valor")).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);

			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaConcepto.class);
			if (!tipo.equals("empty")) {
				crit.add(Restrictions.eq("tipo", tipo));
			}
			if (!(grupo == 0)) {
				crit.add(Restrictions.eq("id", grupo));
			}
			if (!descripcion.equals("empty")) {
				crit.add(Restrictions.eq("descripcion", descripcion));
			}
			if (!estatus.equals("empty")) {
				crit.add(Restrictions.eq("estatus", estatus));
			}
			if (!(id == 0)) {
				crit.add(Restrictions.eq("id", id));
			}

			crit.addOrder(Order.asc("valor")).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
					.setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("consulta", crit.list());
			break;

		default:
			break;
		}
	}

	@Override
	public void crudConcepto(Model model, HttpServletRequest request, String evento, TablaConcepto insert,
			String fecha_cre, String fecha_mod) {
		if (!fecha_cre.equals("null")) {
			Date fecha_creacion = procesoGeneral.formatDate(fecha_cre);
			insert.setFecha(fecha_creacion);
		}
		if (!fecha_mod.equals("null")) {
			Date fecha_modificacion = procesoGeneral.formatDate(fecha_mod);
			insert.setFecha(fecha_modificacion);
		}

		switch (evento) {
		case "update":
			procesoGeneral.getSession().update(insert);

			break;
		case "insert":
			Integer max_id = procesoGeneral.getId(TablaConcepto.class, "id");
			insert.setId(max_id);
			insert.setEstatus(new String("ACT"));
			procesoGeneral.getSession().save(insert);

			break;
		case "delete":
				Query delete = procesoGeneral.getSession()
						.createSQLQuery("update TBL_SIF_CAT_CONCEPTOS set estatus='ELI' where id=" + insert.getId());
				delete.executeUpdate();	
			break;

		default:
			break;
		}
	}

	@Override
	public void queryAddenda(String tipo, Model model, HttpServletRequest request, Integer id_cliente, String addenda,
			String estatus, Integer id, Integer fromRow) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaAddenda.class);
			if (!(id_cliente == 0)) {
				count.add(Restrictions.eq("id_cliente", id_cliente));
			}
			if (!addenda.equals("empty")) {
				count.add(Restrictions.eq("addenda", addenda));
			}
			if (!estatus.equals("empty")) {
				count.add(Restrictions.eq("estatus", estatus));
			}
			if (!(id == 0)) {
				count.add(Restrictions.eq("id", id));
			}
			count.add(Restrictions.eq("tipo", "Addenda")).addOrder(Order.asc("addenda"))
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);
			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaAddenda.class);
			if (!(id_cliente == 0)) {
				crit.add(Restrictions.eq("id_cliente", id_cliente));
			}
			if (!addenda.equals("empty")) {
				crit.add(Restrictions.eq("addenda", addenda));
			}
			if (!estatus.equals("empty")) {
				crit.add(Restrictions.eq("estatus", estatus));
			}
			if (!(id == 0)) {
				crit.add(Restrictions.eq("id", id));
			}
			crit.add(Restrictions.eq("tipo", "Addenda")).addOrder(Order.asc("addenda"))
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("consulta", crit.list());
			break;

		default:
			break;
		}
	}

	@Override
	public void crudAddenda(Model model, HttpServletRequest request, String evento, String fecha_cre, String fecha_mod,
			String valor, Integer id_cliente, String nombre, String descripcion, Integer id) {

		switch (evento) {
		case "update":
			Query queryUpdate = procesoGeneral.getSession()
					.createSQLQuery("update TBL_SIF_CAT_ADDENDAS set nombre=?,valor=?,"
							+ " descripcion=?, addenda=?,usuario=?,"
							+ " fecha=sysdate, id_cliente=? "
							+ " where id=?");
			queryUpdate.setParameter(0, nombre);
			queryUpdate.setParameter(1, valor);
			queryUpdate.setParameter(2, descripcion);
			queryUpdate.setParameter(3, nombre);
			queryUpdate.setParameter(4, procesoGeneral.getSesionActual());
			queryUpdate.setParameter(5, id_cliente);
			queryUpdate.setParameter(6, id);
			queryUpdate.executeUpdate();
			break;
		case "insert":
			Integer max_id = procesoGeneral.getId(TablaAddenda.class, "id");
			Query queryInsert = procesoGeneral.getSession()
					.createSQLQuery("insert into TBL_SIF_CAT_ADDENDAS values(?, ?, ?, ?, 'Addenda', ?, 'ACT', ?,"
							+ " sysdate, 0, ?)");
			queryInsert.setParameter(0, max_id);
			queryInsert.setParameter(1, nombre);
			queryInsert.setParameter(2, valor);
			queryInsert.setParameter(3, descripcion);
			queryInsert.setParameter(4, nombre);
			queryInsert.setParameter(5, procesoGeneral.getSesionActual());
			queryInsert.setParameter(6, id_cliente);
			queryInsert.executeUpdate();

			break;
		case "delete":
				Query delete = procesoGeneral.getSession()
						.createSQLQuery("update TBL_SIF_CAT_ADDENDAS set estatus='ELI' where id=?");
				delete.setParameter(0, id);
				delete.executeUpdate();
			break;

		default:
			break;
		}
	}

	@Override
	public void queryMoneda(String tipo, Model model, HttpServletRequest request, Integer id_moneda, Integer fromRow) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaMoneda.class);
			if (!(id_moneda == 0)) {
				count.add(Restrictions.eq("id_moneda", id_moneda));
			}
			count.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("nombre_moneda"))
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);

			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaMoneda.class);
			if (!(id_moneda == 0)) {
				crit.add(Restrictions.eq("id_moneda", id_moneda));
			}
			crit.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("nombre_moneda"))
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("consulta", crit.list());
			break;

		default:
			break;
		}
	}

	@Override
	public void crudMoneda(Model model, HttpServletRequest request, String evento, Integer id_moneda,
			String nombre_moneda, String pais, String simbolo, Integer t_moneda, String estatus, String fecha_cre,
			String fecha_mod, String usuario, String comentarios, String clave_sat, String nombre_sat,
			Integer decimales, Integer variacion) {
		switch (evento) {
		case "update":
				Query queryUpdate = procesoGeneral.getSession()
						.createSQLQuery("update TBL_SIF_CAT_MONEDAS set nombre_moneda=?, pais=?,"
								+ " simbolo=?, t_moneda=?, estatus=?,"
								+ " fecha_mod=sysdate, usuario=?,"
								+ " comentarios=?, clave_sat=?, nombre_sat=?,"
								+ " decimales=?, variacion=? where id_moneda=?");
			queryUpdate.setParameter(0, nombre_moneda);
			queryUpdate.setParameter(1, pais);
			queryUpdate.setParameter(2, simbolo);
			queryUpdate.setParameter(3, t_moneda);
			queryUpdate.setParameter(4, estatus);
			queryUpdate.setParameter(5, procesoGeneral.getSesionActual());
			queryUpdate.setParameter(6, comentarios);
			queryUpdate.setParameter(7, clave_sat);
			queryUpdate.setParameter(8, nombre_sat);
			queryUpdate.setParameter(9, decimales);
			queryUpdate.setParameter(10, variacion);
			queryUpdate.setParameter(11, id_moneda);
			queryUpdate.executeUpdate();
			break;
		case "insert":
			Integer max_id = procesoGeneral.getId(TablaMoneda.class, "id_moneda");
			Query queryInsert = procesoGeneral.getSession()
					.createSQLQuery("insert into TBL_SIF_CAT_MONEDAS values(?, ?, ?, ?, ?"
							+ ",'ACT',sysdate,sysdate,"
							+ " ?, ?, ?, ?, ?, ?)");
			queryInsert.setParameter(0, max_id);
			queryInsert.setParameter(1, nombre_moneda);
			queryInsert.setParameter(2, pais);
			queryInsert.setParameter(3, simbolo);
			queryInsert.setParameter(4, t_moneda);
			queryInsert.setParameter(5, procesoGeneral.getSesionActual());
			queryInsert.setParameter(6, comentarios);
			queryInsert.setParameter(7, clave_sat);
			queryInsert.setParameter(8, nombre_sat);
			queryInsert.setParameter(9, decimales);
			queryInsert.setParameter(10, variacion);
			queryInsert.executeUpdate();
			break;
		case "delete":
				Query delete = procesoGeneral.getSession()
						.createSQLQuery("update TBL_SIF_CAT_MONEDAS set estatus='ELI' where id_moneda=?");
				delete.setParameter(0, id_moneda);
				delete.executeUpdate();
			break;

		default:
			break;
		}
	}

	@Override
	public void queryUsuario(String tipo, Model model, HttpServletRequest request, String usuario, Integer fromRow) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaUsuario.class);
			if (!usuario.equals("empty")) {
				count.add(Restrictions.eq("usuario", usuario));
			}
			count.addOrder(Order.asc("usuario")).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);

			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaUsuario.class);
			if (!usuario.equals("empty")) {
				crit.add(Restrictions.eq("usuario", usuario));
			}
			crit.addOrder(Order.asc("usuario")).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
					.setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("consulta", crit.list());
			break;

		default:
			break;
		}
	}

	@Override
	public void crudUsuario(Model model, HttpServletRequest request, String evento, TablaUsuario insert,
			String nombre_usuario) {
		switch (evento) {
		case "update":

			Query update = procesoGeneral.getSession()
					.createSQLQuery("update TBL_SIF_CAT_USUARIOS set usuario='" + insert.getUsuario() + "', area='"
							+ insert.getArea() + "', tipo_usuario='" + insert.getTipo_usuario() + "' where usuario=?");
			update.setParameter(0, nombre_usuario);
			update.executeUpdate();
			break;
		case "insert":
			String nombre = insert.getUsuario();
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaUsuario.class);
			crit.add(Restrictions.eq("usuario", nombre));

			if (crit.list().size() > 0) {

			} else {
				insert.setTipo_usuario("INT");
				procesoGeneral.getSession().save(insert);
			}

			break;
		case "delete":

				procesoGeneral.getSession().delete(insert);

			break;

		default:
			break;
		}
	}

	@Override
	public void queryFuncionalidad(String tipo, Model model, HttpServletRequest request, Integer id, Integer fromRow) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaFuncionalidad.class);
			if (!(id == 0)) {
				count.add(Restrictions.eq("id", id));
			}
			count.addOrder(Order.asc("nombre")).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);

			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaFuncionalidad.class);
			if (!(id == 0)) {
				crit.add(Restrictions.eq("id", id));
			}
			crit.addOrder(Order.asc("nombre")).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
					.setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("consulta", crit.list());
			break;

		default:
			break;
		}
	}

	@Override
	public void crudFuncionalidad(Model model, HttpServletRequest request, String evento, TablaFuncionalidad insert,
			String fecha_cre) {
		if (!fecha_cre.equals("null")) {
			Date fecha_creacion = procesoGeneral.formatDate(fecha_cre);
			insert.setFecha(fecha_creacion);
		}

		switch (evento) {
		case "update":
			procesoGeneral.getSession().update(insert);

			break;
		case "insert":
			Integer max_id = procesoGeneral.getId(TablaFuncionalidad.class, "id");
			insert.setId(max_id);
			procesoGeneral.getSession().save(insert);

			break;
		case "delete":
				procesoGeneral.getSession().delete(insert);
			break;

		default:
			break;
		}

	}

	@Override
	public void queryParametro(String tipo, Model model, HttpServletRequest request, Integer id, Integer fromRow) {
		Criteria crit;
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaParametro.class);
			if (!(id == 0)) {
				count.add(Restrictions.eq("id_funcionalidad", id));
			}
			count.addOrder(Order.asc("nombre"));
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);

			break;
		case "consulta":
			crit = procesoGeneral.getSession().createCriteria(TablaParametro.class);
			if (!(id == 0)) {
				crit.add(Restrictions.eq("id_funcionalidad", id));
			}
			crit.addOrder(Order.asc("nombre")).setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("consulta", crit.list());
			break;
		case "consultaCrud":
			crit = procesoGeneral.getSession().createCriteria(TablaParametro.class);
			if (!(id == 0)) {
				crit.add(Restrictions.eq("id", id));
			}
			crit.addOrder(Order.asc("nombre")).setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("consulta", crit.list());
			break;

		default:
			break;
		}
	}

	@Override
	public void crudParametro(Model model, HttpServletRequest request, String evento, String fecha, Integer id,
			Integer id_funcionalidad, String valor2, String estatus, String usuario, String valor1, String nombre) {

		switch (evento) {
		case "update":
			Query queryUpdate = procesoGeneral.getSession()
					.createSQLQuery("update TBL_SIF_CAT_PARAMETROS set nombre=?, estatus=?,"
							+ " valor1=?, valor2=?, usuario=?,"
							+ "fecha=sysdate where id=?");
			queryUpdate.setParameter(0, nombre);
			queryUpdate.setParameter(1, estatus);
			queryUpdate.setParameter(2, valor1);
			queryUpdate.setParameter(3, valor2);
			queryUpdate.setParameter(4, procesoGeneral.getSesionActual());
			queryUpdate.setParameter(5, id);
			queryUpdate.executeUpdate();
			break;
		case "insert":
			Integer max_id = procesoGeneral.getId(TablaParametro.class, "id");
			Query queryInsert = procesoGeneral.getSession()
					.createSQLQuery("insert into TBL_SIF_CAT_PARAMETROS values(?, ?, 'ACT', ?, ?, ?,"
							+ " sysdate,2)");
			queryInsert.setParameter(0, max_id);
			queryInsert.setParameter(1, nombre);
			queryInsert.setParameter(2, valor1);
			queryInsert.setParameter(3, valor2);
			queryInsert.setParameter(4, procesoGeneral.getSesionActual());
			queryInsert.executeUpdate();
			break;
		case "delete":
				Query delete = procesoGeneral.getSession()
						.createSQLQuery("update TBL_SIF_CAT_PARAMETROS set estatus='ELI' where id=?");
				delete.setParameter(0, id);
				delete.executeUpdate();
			break;

		default:
			break;
		}

	}

	@Override
	public void queryEventoServicio(String tipo, Model model, HttpServletRequest request, Integer fromRow, Integer id,
			Integer evento, String estatus) {
		Criteria crit;
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaEventoServicio.class);
			if (!(id == null)) {
				count.add(Restrictions.eq("id_servicios", id));
			}
			count.setFetchMode("tbl_sif_servicios", FetchMode.JOIN).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);
			break;
		case "join":
			crit = procesoGeneral.getSession().createCriteria(TablaEventoServicio.class)
					.setFetchMode("tbl_sif_servicios", FetchMode.JOIN)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			model.addAttribute("listaJoinServicios", crit.list());
			break;
		case "consulta":
			crit = procesoGeneral.getSession().createCriteria(TablaEventoServicio.class)
					.setFetchMode("tbl_sif_servicios", FetchMode.JOIN).add(Restrictions.eq("estatus", "ACT"));
			if (!(id == null)) {
				crit.add(Restrictions.eq("id_servicios", id));
			}
			crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("consulta", crit.list());
			break;
		case "param":
			Criteria param = procesoGeneral.getSession().createCriteria(TablaEventoServicio.class)
					.add(Restrictions.eq("id", id));
			model.addAttribute("consulta", param.list());
			break;
		case "distinct":
			crit = procesoGeneral.getSession().createCriteria(TablaEventoServicio.class)
					.setProjection(Projections.distinct(Projections.property("codigo")))
					.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
							.add(Projections.property("codigo"), "codigo"))
					.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("codigo"))
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
					.setResultTransformer(Transformers.aliasToBean(TablaEventoServicio.class));
			model.addAttribute("listaDistinctServicios", crit.list());
			break;

		default:
			break;
		}

	}

	@Override
	public void crudEventoServicio(String evento, TablaEventoServicio insert, Model model, HttpServletRequest request) {
		switch (evento) {
		case "update":
			
			Date date = new Date();
			insert.setFecha(date);
			procesoGeneral.getSession().update(insert);

			break;
		case "insert":
			Integer max_id = procesoGeneral.getId(TablaEventoServicio.class, "id");
			insert.setId(max_id);
			procesoGeneral.getSession().save(insert);

			break;
		case "delete":
				Query delete = procesoGeneral.getSession().createSQLQuery(
						"update TBL_SIF_CAT_EVENTOS_SERVICIOS set estatus='ELI' where id=" + insert.getId());
				delete.executeUpdate();
			break;

		default:
			break;
		}

	}

	@Override
	public void queryServiciosParticulares(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			Integer id) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaServicioParticular.class);
			if (!(id == 0)) {
				count.add(Restrictions.eq("id", id));
			}
			count.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("descripcion"));
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);
			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaServicioParticular.class);
			if (!(id == 0)) {
				crit.add(Restrictions.eq("id", id));
			}
			crit.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("descripcion")).setFirstResult(fromRow)
					.setMaxResults(15);
			model.addAttribute("consulta", crit.list());
			break;

		default:
			break;
		}
	}

	@Override
	public void crudServiciosParticulares(Model model, HttpServletRequest request, String evento,
			TablaServicioParticular insert) {
		switch (evento) {
		case "update":
			
			Date date = new Date();
			insert.setFecha(date);
			procesoGeneral.getSession().update(insert);

			break;
		case "insert":
			
			Integer max_id = procesoGeneral.getId(TablaServicioParticular.class, "id");
			insert.setId(max_id);
			System.out.println(insert.getClave()+" "+insert.getDescripcion()+" "+insert.getComentarios()+"  "+insert.getEstatus()+" "+insert.getUsuario()+"  "+max_id);
			procesoGeneral.getSession().save(insert);

			break;
		case "delete":
				Query delete = procesoGeneral.getSession()
						.createSQLQuery("update TBL_SIF_SERV_PART set estatus='ELI' where id=" + insert.getId());
				delete.executeUpdate();
			break;

		default:
			break;
		}

	}

	@Override
	public void queryIngreso(String tipo, Model model, HttpServletRequest request, Integer fromRow, Integer id) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaIngreso.class);
			if (!(id == 0)) {
				count.add(Restrictions.eq("id", id));
			}
			count.addOrder(Order.asc("clave"));
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);

			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaIngreso.class);
			if (!(id == 0)) {
				crit.add(Restrictions.eq("id", id));
			}
			crit.add(Restrictions.eq("estatus", "ACT"));
			crit.addOrder(Order.asc("clave"));
			model.addAttribute("consulta", crit.list());
			break;

		default:
			break;
		}
	}

	@Override
	public void crudIngreso(Model model, HttpServletRequest request, String evento, TablaIngreso insert) {
		switch (evento) {
		case "update":
			
			Date date = new Date();
			insert.setFecha(date);
			procesoGeneral.getSession().update(insert);

			break;
		case "insert":
			Integer max_id = procesoGeneral.getId(TablaIngreso.class, "id");
			insert.setId(max_id);
			procesoGeneral.getSession().save(insert);
			break;
		case "delete":
				Query delete = procesoGeneral.getSession()
						.createSQLQuery("update TBL_SIF_CAT_INGRESO set estatus='ELI' where id=" + insert.getId());
				delete.executeUpdate();
			break;

		default:
			break;
		}

	}

	@Override
	public void queryclienteEnServicio(Model model, HttpServletRequest request, String listaClienteEnServicio,
			String tipo, Integer fromRow) {
		switch (tipo) {
		case "lista":
			Query lista = procesoGeneral.getSession().createSQLQuery(
					"select clave as \"clave\", descripcion as \"descripcion\"  from tbl_sif_servicios  where id_fuente = ? and estatus = ? order by clave asc");
			lista.setParameter(0, 4);
			lista.setParameter(1, "ACT");
			lista.setResultTransformer(Transformers.aliasToBean(BeanClienteUsuarioServicio.class));
			model.addAttribute("listaClienteEnServicio", lista.list());
			break;
		case "consulta":

			Query consulta = procesoGeneral.getSession().createSQLQuery("select cs.cv_servicio as \"clave\","
					+ "s.descripcion as \"descripcion\"," + "cs.cv_cliente as \"clave_cliente\","
					+ "c.nombre_corto as \"descripcion_cliente\"," + "cs.inclusion_emi as \"inclusion_emi\","
					+ "cs.inclusion_adq as \"inclusion_adq\"," + "cs.estatus as \"estatus\","
					+ "cs.usuario as \"usuario\"," + "cs.fecha as \"fecha\""
					+ " from tbl_sif_clientes_servicios cs,tbl_sif_servicios s,tbl_sif_cat_clientes c "
					+ " where cs.cv_servicio = s.clave and cs.cv_cliente = c.clave_cliente and s.clave= ? order by cv_cliente OFFSET ? ROWS FETCH NEXT 15 ROWS ONLY");
			consulta.setParameter(0, listaClienteEnServicio);
			consulta.setParameter(1, fromRow);
			consulta.setResultTransformer(Transformers.aliasToBean(BeanClienteUsuarioServicio.class));
			model.addAttribute("consulta", consulta.list());
			break;
		case "count":

			Query count = procesoGeneral.getSession()
					.createSQLQuery("select cs.cv_servicio as \"clave\"," + "s.descripcion as \"descripcion\","
							+ "cs.cv_cliente as \"clave_cliente\"," + "c.nombre_corto as \"descripcion_cliente\","
							+ "cs.inclusion_emi as \"inclusion_emi\"," + "cs.inclusion_adq as \"inclusion_adq\","
							+ "cs.estatus as \"estatus\"," + "cs.usuario as \"usuario\"," + "cs.fecha as \"fecha\""
							+ " from tbl_sif_clientes_servicios cs,tbl_sif_servicios s,tbl_sif_cat_clientes c "
							+ " where cs.cv_servicio = s.clave and cs.cv_cliente = c.clave_cliente and s.clave= ?");
			count.setParameter(0, listaClienteEnServicio);
			count.setResultTransformer(Transformers.aliasToBean(BeanClienteUsuarioServicio.class));
			model.addAttribute("registros_totales", count.list().size());
			break;
		case "cliente":
			Query cliente = procesoGeneral.getSession().createSQLQuery(
					"select clave_cliente as \"clave_cliente\", nombre_corto as \"descripcion_cliente\" "
							+ " from tbl_sif_cat_clientes c, tbl_sif_servicios_clientes sc, tbl_sif_servicios s "
							+ "where c.id_cliente = sc.id_cliente " + "and s.id_servicios = sc.id_servicio "
							+ "and s.id_fuente = 4 and s.clave = ? "
							+ "and c.clave_cliente not in (select cv_cliente from tbl_sif_clientes_servicios where cv_servicio = ? )"
							+ " and c.estatus = 'ACT' and s.estatus = 'ACT' and sc.estatus = 'ACT' "
							+ " order by clave_cliente");
			cliente.setParameter(0, listaClienteEnServicio);
			cliente.setParameter(1, listaClienteEnServicio);
			cliente.setResultTransformer(Transformers.aliasToBean(BeanClienteUsuarioServicio.class));
			model.addAttribute("listaClienteServicio", cliente.list());
			break;
		default:
			break;
		}

	}

	@Override
	public void crudClienteEnServicio(Model model, HttpServletRequest request, String listaClienteServicio,
			Integer fromRow, String tipo) {
		switch (tipo) {
		case "asignar":

			break;
		case "confirmar":

			break;
		default:
			break;
		}
	}

	@Override
	public void queryBanco(String tipo, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes,
			Integer id_cuenta, String estatus, Integer fromRow) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaBanco.class);
			count.add(Restrictions.eq("estatus", estatus));
			if (!(id_cuenta == null)) {
				count.add(Restrictions.eq("id", id_cuenta));
			}
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);
			break;
		case "consulta":
			Criteria consulta = procesoGeneral.getSession().createCriteria(TablaBanco.class);
			consulta.add(Restrictions.eq("estatus", estatus));
			if (!(id_cuenta == null)) {
				consulta.add(Restrictions.eq("id", id_cuenta));
			}
			consulta.addOrder(Order.asc("cuenta"));
			consulta.setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("consulta", consulta.list());
			break;

		default:
			break;
		}
	}

}