/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 23/08/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.dao;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

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
import com.prosa.sif.pojo.BeanPrecio;
import com.prosa.sif.pojo.ViewPrecioServicio;
import com.prosa.sif.pojo.ViewPrecioServicioCliente;

@Repository
@Transactional
@SuppressWarnings("all")
public class PrecioDaoImpl implements PrecioDao {
	@Autowired
	private ProcesoGeneral procesoGeneral;

	@Override
	public void queryServicioCliente(String tipo, Model model, HttpServletRequest request, Integer id_cliente,
			Integer grupo_concepto, Integer idNegocio, Integer id_servicio, String evento, Integer fromRow) {

		switch (evento) {
		case "porCliente":
			switch (tipo) {
			case "count":
				Criteria count = procesoGeneral.getSession().createCriteria(ViewPrecioServicioCliente.class);
				count.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
						.add(Projections.property("id_servicio"), "id_servicio")
						.add(Projections.property("clave_servicio"), "clave_servicio")
						.add(Projections.property("descripcion"), "descripcion")
						.add(Projections.property("clave_grupo"), "clave_grupo")
						.add(Projections.property("clave_negocio"), "clave_negocio"));
				if (!(id_cliente == null)) {
					count.add(Restrictions.eq("id_cliente", id_cliente));
				}
				Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
				count.setResultTransformer(Transformers.aliasToBean(ViewPrecioServicioCliente.class));
				model.addAttribute("registros_totales", registrosTotales);
				break;
			case "consulta":
				Criteria crit = procesoGeneral.getSession().createCriteria(ViewPrecioServicioCliente.class);
				crit.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
						.add(Projections.property("id_servicio"), "id_servicio")
						.add(Projections.property("clave_servicio"), "clave_servicio")
						.add(Projections.property("descripcion"), "descripcion")
						.add(Projections.property("clave_grupo"), "clave_grupo")
						.add(Projections.property("clave_negocio"), "clave_negocio"));
				if (!(id_cliente == null)) {
					crit.add(Restrictions.eq("id_cliente", id_cliente));
				}
				crit.setFirstResult(fromRow);
				crit.setMaxResults(15);
				crit.setResultTransformer(Transformers.aliasToBean(ViewPrecioServicioCliente.class));
				model.addAttribute("consulta", crit.list());
				model.addAttribute("TablaConsulta", "porCliente");
				break;
			default:
				break;
			}

			break;
		case "porServicio":
			switch (tipo) {
			case "count":
				Criteria count = procesoGeneral.getSession().createCriteria(ViewPrecioServicio.class);
				count.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
						.add(Projections.property("id_servicio"), "id_servicio")
						.add(Projections.property("clave_cliente"), "clave_cliente")
						.add(Projections.property("nombre_corto"), "nombre_corto"));
				if (!(id_servicio == null)) {
					count.add(Restrictions.eq("id_servicio", id_servicio));
				}
				Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
				count.setResultTransformer(Transformers.aliasToBean(ViewPrecioServicio.class));
				model.addAttribute("registros_totales", registrosTotales);
				break;
			case "consulta":
				Criteria crit = procesoGeneral.getSession().createCriteria(ViewPrecioServicio.class);
				crit.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
						.add(Projections.property("id_servicio"), "id_servicio")
						.add(Projections.property("clave_cliente"), "clave_cliente")
						.add(Projections.property("nombre_corto"), "nombre_corto"));
				if (!(id_servicio == null)) {
					crit.add(Restrictions.eq("id_servicio", id_servicio));
				}
				crit.setFirstResult(fromRow);
				crit.setMaxResults(15);
				crit.addOrder(Order.asc("clave_cliente"));
				crit.setResultTransformer(Transformers.aliasToBean(ViewPrecioServicio.class));
				model.addAttribute("consulta", crit.list());
				model.addAttribute("TablaConsulta", "porServicio");
				break;
			default:
				break;
			}
			break;

		default:
			break;
		}

	}

	@Override
	public void queryAsignarDescuento(String tipo, Model model, HttpServletRequest request, Integer id_cliente,
			Integer id_servicio, Integer grupo_volumen, Integer grupo_concepto, Integer lista_clientes,
			Integer id_negocio, Integer fromRow, Integer flag, String evento) {
		switch (flag) {
		case 0:
			String consulta = "select serviciocliente.id_cliente as \"id_cliente\", "
					+ "cliente.clave_cliente as \"clave_cliente\" , cliente.nombre_corto as \"nombre_corto\" , "
					+ "cliente.rfc as \"rfc\",  serviciocliente.porcentaje_descuento as \"porcentaje_descuento\"  "
					+ "from  tbl_sif_servicios_clientes serviciocliente   join tbl_sif_cat_clientes cliente "
					+ "on  serviciocliente.id_cliente = cliente.id_cliente    join tbl_sif_servicios servicios on  serviciocliente.id_servicio = servicios.id_servicios  "
					+ "left join tbl_sif_ind_cliente_gpo listacliente on serviciocliente.id_cliente = listacliente.id_cliente  "
					+ "where serviciocliente.estatus =  'ACT'  "
					+ "and serviciocliente.porcentaje_descuento is not null " + "and  servicios.estatus = 'ACT'  ";
			if (!(id_cliente == null)) {
				consulta = consulta.concat(" and cliente.id_cliente=" + id_cliente);
			}
			if (!(grupo_volumen == null)) {
				consulta = consulta.concat(" and cliente.id_grupo_vol=" + grupo_volumen);
			}
			if (!(lista_clientes == null)) {
				consulta = consulta.concat(" and listacliente.id_grupo=" + lista_clientes);
			}

			consulta = consulta.concat("group by serviciocliente.id_cliente, cliente.clave_cliente , "
					+ "cliente.nombre_corto , cliente.rfc," + "serviciocliente.porcentaje_descuento  "
					+ "order by cliente.clave_cliente, serviciocliente.id_cliente, cliente.nombre_corto , "
					+ "cliente.rfc,serviciocliente.porcentaje_descuento ");
			if (tipo.equals("consulta")) {
				consulta = consulta.concat(" OFFSET " + fromRow + " ROWS FETCH NEXT 15 ROWS ONLY");
			}
			Query query = procesoGeneral.getSession().createSQLQuery(consulta)
					.setResultTransformer(Transformers.aliasToBean(BeanPrecio.class));
			if (tipo.equals("count")) {
				model.addAttribute("registros_totales", query.list().size());
			}
			if (tipo.equals("consulta")) {
				model.addAttribute("consulta", query.list());
			}
			model.addAttribute("flag", flag);
			break;
		case 1:
			String consulta2 = "select serviciocliente.id_servicio as \"id_servicio\", servicio.clave as \"clave\", servicio.descripcion as \"descripcion\", negocio.clave as \"negocio\", serviciocliente.porcentaje_descuento as \"porcentaje_descuento\"  "
					+ " from  tbl_sif_servicios_clientes serviciocliente   join tbl_sif_servicios servicio on  serviciocliente.id_servicio = servicio.id_servicios    "
					+ " left join tbl_sif_cat_negocios negocio  on negocio.id_negocio = servicio.id_negocio    "
					+ " left join tbl_sif_cat_gpo_ccpt_serv grupoconcepto on grupoconcepto.id_grupo = servicio.id_grupo_concepto    "
					+ " where serviciocliente.estatus =  'ACT' ";
			if (!(id_servicio == null)) {
				consulta2 = consulta2.concat(" and servicio.id_servicios=" + id_servicio);
			}
			if (!(grupo_concepto == null)) {
				consulta2 = consulta2.concat(" and grupoConcepto.id_grupo=" + grupo_concepto);
			}
			if (!(id_negocio == null)) {
				consulta2 = consulta2.concat(" and negocio.id_negocio=" + id_negocio);
			}
			consulta2 = consulta2.concat(
					" group by serviciocliente.id_servicio, servicio.clave , servicio.descripcion, negocio.clave,"
							+ " serviciocliente.porcentaje_descuento "
							+ " order by servicio.clave, serviciocliente.id_servicio,  servicio.descripcion , "
							+ " negocio.clave, serviciocliente.porcentaje_descuento ");
			if (tipo.equals("consulta")) {
				consulta2 = consulta2.concat(" OFFSET " + fromRow + " ROWS FETCH NEXT 15 ROWS ONLY");
			}
			Query query2 = procesoGeneral.getSession().createSQLQuery(consulta2)
					.setResultTransformer(Transformers.aliasToBean(BeanPrecio.class));
			if (tipo.equals("count")) {
				model.addAttribute("registros_totales", query2.list().size());
			}
			if (tipo.equals("consulta")) {
				model.addAttribute("consulta", query2.list());
			}
			model.addAttribute("flag", flag);
			break;
		default:
			break;
		}
	}

	@Override
	public void crudAsignarDescuento(String tipo, Model model, HttpServletRequest request, String evento,
			Integer id_cliente, Integer id_servicio, String porcentaje_descuento, Integer fromRow) {
		
		switch (evento) {//pag 1134
		case "cliente":
			String consulta = "select serviciocliente.id_servicio as \"id_servicio\", serviciocliente.porcentaje_descuento as \"porcentaje_descuento\", servicio.clave as \"clave\", servicio.descripcion as \"descripcion\", negocio.clave as \"negocio\" "
					+ "from  tbl_sif_servicios_clientes serviciocliente  " + "join tbl_sif_servicios servicio on  "
					+ "serviciocliente.id_servicio = servicio.id_servicios and servicio.b_precio_controlado = 1 "
					+ "and servicio.estatus='ACT'    join tbl_sif_cat_clientes cliente on  "
					+ "serviciocliente.id_cliente = cliente.id_cliente  "
					+ "left join tbl_sif_cat_negocios negocio  on negocio.id_negocio = servicio.id_negocio  "
					+ "left join tbl_sif_cat_gpo_ccpt_serv grupoconcepto on grupoconcepto.id_grupo = servicio.id_grupo_concepto   "
					+ "where serviciocliente.estatus =  'ACT'   and servicio.estatus='ACT' ";
			if (!(id_cliente == null)) {
				consulta = consulta.concat(" and cliente.id_cliente=" + id_cliente);
			}
			if (porcentaje_descuento != null && !porcentaje_descuento.isEmpty()) {
				consulta = consulta.concat(" and serviciocliente.porcentaje_descuento=" + porcentaje_descuento);
			}
			if (porcentaje_descuento.equals("null") && porcentaje_descuento.isEmpty()) {
				consulta = consulta.concat(" and serviciocliente.porcentaje_descuento is null ");
			}
			consulta = consulta.concat(
					" group by serviciocliente.id_servicio,serviciocliente.porcentaje_descuento, servicio.clave , servicio.descripcion , negocio.clave ");
			if (tipo.equals("consulta")) {
				consulta = consulta.concat(" OFFSET " + fromRow + " ROWS FETCH NEXT 15 ROWS ONLY");
			}
			Query query = procesoGeneral.getSession().createSQLQuery(consulta)
					.setResultTransformer(Transformers.aliasToBean(BeanPrecio.class));
			if (tipo.equals("count")) {
				model.addAttribute("registros_totales", query.list().size());
			}
			if (tipo.equals("consulta")) {
				model.addAttribute("consulta", query.list());
			}
			break;
		case "servicio":
			String consulta2 = "select  c.id_cliente as \"id_cliente\",c.clave_cliente as \"clave_cliente\",c.nombre_corto as \"nombre_corto\",sc.porcentaje_descuento as \"porcentaje_descuento\""
					+ "from tbl_sif_cat_clientes c,tbl_sif_servicios_clientes sc,tbl_sif_servicios s "
					+ "where c.id_cliente = sc.id_cliente and sc.id_servicio = s.id_servicios and c.estatus = sc.estatus and c.estatus = s.estatus "
					+ "and s.b_precio_controlado = 1 and c.estatus = 'ACT' ";
			if (!(id_servicio == null)) {
				consulta2 = consulta2.concat(" and sc.id_servicio=" + id_servicio);
			}
			if (porcentaje_descuento != null && !porcentaje_descuento.isEmpty()) {
				consulta2 = consulta2.concat(" and sc.porcentaje_descuento=" + porcentaje_descuento);
			}
			if (porcentaje_descuento.equals("null") && porcentaje_descuento.isEmpty()) {
				consulta2 = consulta2.concat(" and sc.porcentaje_descuento is null ");
			}
			consulta2 = consulta2
					.concat(" group by c.id_cliente, c.clave_cliente, c.nombre_corto,sc.porcentaje_descuento ");
			if (tipo.equals("consulta")) {
				consulta2 = consulta2
						.concat(" order by clave_cliente asc OFFSET " + fromRow + " ROWS FETCH NEXT 15 ROWS ONLY");
			}
			Query query2 = procesoGeneral.getSession().createSQLQuery(consulta2)
					.setResultTransformer(Transformers.aliasToBean(BeanPrecio.class));
			if (tipo.equals("count")) {
				model.addAttribute("registros_totales", query2.list().size());
			}
			if (tipo.equals("consulta")) {
				model.addAttribute("consulta", query2.list());
			}
			break;
		default:
			break;
		}

	}

	@Override
	public void saveAsignarDescuento(Model model, HttpServletRequest request, String evento, String lista,
			Integer id_cliente, Integer id_servicio, String descuento, String comentarios) {
		Query update;
		switch (evento) {
		case "porCliente":
			if (descuento != null && !descuento.isEmpty() && !(id_cliente == null) && lista != null
					&& !lista.isEmpty()) {
				update = procesoGeneral.getSession()
						.createSQLQuery("update tbl_sif_servicios_clientes  set comentarios = ?,"
								+ " porcentaje_descuento = ?,"
								+ " fecha_mod = sysdate  where id_cliente in (?) and id_servicio in (?"
								+ ") and estatus = 'ACT'");
				update.setParameter(0, comentarios);
				update.setParameter(1, descuento);
				update.setParameter(2, id_cliente);
				update.setParameter(3, lista);
				update.executeUpdate();

			}
			break;
		case "porServicio":
			if (descuento != null && !descuento.isEmpty() && !(id_servicio == null) && lista != null
					&& !lista.isEmpty()) {
				update = procesoGeneral.getSession()
						.createSQLQuery("update tbl_sif_servicios_clientes  set comentarios = ?,"
								+ " porcentaje_descuento = ? ,"
								+ " fecha_mod = sysdate  where id_cliente in (?) and id_servicio in (?"
								+ ") and estatus = 'ACT'");
				update.setParameter(0, comentarios);
				update.setParameter(1, descuento);
				update.setParameter(2, lista);
				update.setParameter(3, id_servicio);
				update.executeUpdate();
			}

			break;

		default:
			break;
		}
	}
}