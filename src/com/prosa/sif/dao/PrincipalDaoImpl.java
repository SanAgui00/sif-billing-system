/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 08/03/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.dao;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prosa.sif.operation.ProcesoGeneral;
import com.prosa.sif.pojo.BeanSubconceptoAplicacion;
import com.prosa.sif.pojo.TablaClavesCliente;
import com.prosa.sif.pojo.TablaCliente;
import com.prosa.sif.pojo.TablaConcepto;
import com.prosa.sif.pojo.TablaContacto;
import com.prosa.sif.pojo.TablaHistoricoCliente;
import com.prosa.sif.pojo.TablaHistoricoServicio;
import com.prosa.sif.pojo.TablaMetodosPago;
import com.prosa.sif.pojo.TablaNegocio;
import com.prosa.sif.pojo.TablaPrecio;
import com.prosa.sif.pojo.TablaRangoPrecio;
import com.prosa.sif.pojo.TablaRegimenFiscal;
import com.prosa.sif.pojo.TablaServicio;
import com.prosa.sif.pojo.ViewClavesCliente;

@Repository
@Transactional
@SuppressWarnings("all")
public class PrincipalDaoImpl implements PrincipalDao {
	@Autowired
	private ProcesoGeneral procesoGeneral;
	private Integer max_id;

	@Override
	public void queryNegocio(String tipo, Integer fromRow, Integer idNegocio, Model model, HttpServletRequest request) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaNegocio.class);
			count.add(Restrictions.eq("status", "ACT"));
			if (!(idNegocio == 0)) {
				count.add(Restrictions.eq("id_negocio", idNegocio));
			}
			count.addOrder(Order.asc("clave")).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);
			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaNegocio.class);
			crit.add(Restrictions.eq("status", "ACT"));
			if (!(idNegocio == 0)) {
				crit.add(Restrictions.eq("id_negocio", idNegocio));
			}
			crit.addOrder(Order.asc("clave"));
			crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("consulta", crit.list());
			break;

		default:
			break;
		}

	}

	@Override
	public void crudNegocio(String evento, String clave, String descripcion, String clave_metodopago_sat,
			String clave_usocfdi_sat, Integer id_proceso, Integer id_negocio_padre, Integer id_centro_costos,
			Integer cuenta_ingreso, String clave_gl, String comentarios, String concepto_carta, String usuario,
			String fecha_cre, String fecha_mod, Model model, HttpServletRequest request, Integer id_negocio,
			Integer id_grupo_edo_cuenta, String status) {

		switch (evento) {
		case "update":
			if (id_negocio_padre == 0) {
				id_negocio_padre = null;
			}
			if (id_grupo_edo_cuenta == 0) {
				id_grupo_edo_cuenta = null;
			}
			if (id_centro_costos == 0) {
				id_centro_costos = null;
			}
			if (cuenta_ingreso == 0) {
				cuenta_ingreso = null;
			}
			if (clave_gl.equals("empty")) {
				clave_gl = null;
			}
			if (id_proceso == 0) {
				id_proceso = null;
			}

			Query queryUpdate = procesoGeneral.getSession()
					.createSQLQuery("update TBL_SIF_CAT_NEGOCIOS " + " set ID_PROCESO= " + id_proceso + ","
							+ " ID_CENTRO_COSTOS= " + id_centro_costos + "," + " ID_NEGOCIO_PADRE= " + id_negocio_padre
							+ "," + " ID_GRUPO_EDO_CUENTA=" + id_grupo_edo_cuenta + "," + " CLAVE = '" + clave + "',"
							+ " DESCRIPCION = '" + descripcion + "'," + " CUENTA_INGRESO= '" + cuenta_ingreso + "',"
							+ " CLAVE_GL= '" + clave_gl + "'," + " USUARIO= '" + procesoGeneral.getSesionActual() + "',"
							+ " STATUS= '" + status + "' ," + " FECHA_MOD= sysdate," + " COMENTARIOS= '" + comentarios
							+ "'," + " CONCEPTO_CARTA='" + concepto_carta + "' ," + " CLAVE_METODOPAGO_SAT= '"
							+ clave_metodopago_sat + "'," + " CLAVE_USOCFDI_SAT= '" + clave_usocfdi_sat + "'"
							+ "where id_negocio=" + id_negocio);
			queryUpdate.executeUpdate();
			break;
		case "insert":
			if (id_negocio_padre == 0) {
				id_negocio_padre = null;
			}
			if (id_grupo_edo_cuenta == 0) {
				id_grupo_edo_cuenta = null;
			}
			if (id_centro_costos == 0) {
				id_centro_costos = null;
			}
			if (cuenta_ingreso == 0) {
				cuenta_ingreso = null;
			}
			if (clave_gl.equals("empty")) {
				clave_gl = null;
			}
			if (id_proceso == 0) {
				id_proceso = null;
			}
			max_id = procesoGeneral.getId(TablaNegocio.class, "id_negocio");
			Query queryInsert = procesoGeneral.getSession()
					.createSQLQuery("Insert into TBL_SIF_CAT_NEGOCIOS values(" + max_id + "," + id_proceso + ","
							+ id_centro_costos + "," + id_negocio_padre + ",null,'" + clave + "','" + descripcion
							+ "','" + cuenta_ingreso + "','" + clave_gl + "','" + procesoGeneral.getSesionActual()
							+ "','ACT',sysdate,sysdate,'" + comentarios + "','" + concepto_carta + "','"
							+ clave_metodopago_sat + "','" + clave_usocfdi_sat + "')");
			queryInsert.executeUpdate();
			break;
		case "delete":
			Query delete = procesoGeneral.getSession()
					.createSQLQuery("update TBL_SIF_CAT_NEGOCIOS set status='ELI' where id_negocio=" + id_negocio);
			delete.executeUpdate();
			break;
		default:
			break;
		}

	}

	@Override
	public void queryCliente(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			String clave_cliente, String nombre_corto, Integer clave_grupo, String estatus) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaCliente.class);

			if (!clave_cliente.equals("empty")) {
				count.add(Restrictions.eq("clave_cliente", clave_cliente));
			}
			if (!nombre_corto.equals("empty")) {
				count.add(Restrictions.eq("nombre_corto", nombre_corto));
			}
			if (!(clave_grupo == 0)) {
				count.add(Restrictions.eq("id_grupo_vol", clave_grupo));
			}

			count.add(Restrictions.eq("estatus", estatus));
			System.out.println("estatus count " + estatus);
			count.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);
			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaCliente.class);

			if (!clave_cliente.equals("empty")) {
				crit.add(Restrictions.eq("clave_cliente", clave_cliente));
			}
			if (!nombre_corto.equals("empty")) {
				crit.add(Restrictions.eq("nombre_corto", nombre_corto));
			}
			if (!(clave_grupo == 0)) {
				crit.add(Restrictions.eq("id_grupo_vol", clave_grupo));
			}
			System.out.println("estatus consulta " + estatus);
			crit.add(Restrictions.eq("estatus", estatus));

			crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			crit.addOrder(Order.asc("clave_cliente"));
			crit.setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("consulta", crit.list());
			break;
		default:
			break;
		}
	}

	@Override
	public void queryServicio(String tipo, Integer fromRow, Integer servicio, Integer concepto, Integer volumen,
			String estatus, Integer negocio, Integer fuente, Model model, HttpServletRequest request) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaServicio.class);
			if (!(servicio == 0)) {
				count.add(Restrictions.eq("id_servicios", servicio));
			}
			if (!(concepto == 0)) {
				count.add(Restrictions.eq("id_grupo_concepto", concepto));
			}
			if (!(volumen == 0)) {
				count.add(Restrictions.eq("id_grupo_vol", volumen));
			}
			if (!estatus.equals("empty")) {
				count.add(Restrictions.eq("estatus", estatus));
			}
			if (!(negocio == 0)) {
				count.add(Restrictions.eq("id_negocio", negocio));
			}
			if (!(fuente == 0)) {
				count.add(Restrictions.eq("id_fuente", fuente));
			}
			count.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);

			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaServicio.class);
			if (!(servicio == 0)) {
				crit.add(Restrictions.eq("id_servicios", servicio));
			}
			if (!(concepto == 0)) {
				crit.add(Restrictions.eq("id_grupo_concepto", concepto));
			}
			if (!(volumen == 0)) {
				crit.add(Restrictions.eq("id_grupo_vol", volumen));
			}
			if (!estatus.equals("empty")) {
				crit.add(Restrictions.eq("estatus", estatus));
			}
			if (!(negocio == 0)) {
				crit.add(Restrictions.eq("id_negocio", negocio));
			}
			if (!(fuente == 0)) {
				crit.add(Restrictions.eq("id_fuente", fuente));
			}
			crit.addOrder(Order.asc("clave"));
			crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			crit.setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("consulta", crit.list());
			break;

		default:
			break;
		}
	}

	@Override
	public void crudServicio(Model model, HttpServletRequest request, Integer id_servicios, Integer id_fuente,
			Integer id_negocio, Integer id_precio, Integer id_forma_pago, Integer id_grupo_vol,
			Integer id_grupo_concepto, Integer id_moneda_importe_adq, Integer id_moneda_adq, Integer id_centro_costos,
			String clave, String descripcion, String estatus, Integer b_adquisicion_auto,
			String periodicidad_adquisicion, String periodicidad_cobro, Integer dias_habiles_cobro,
			Integer dia_limite_solicitud, String b_habilitar_op_av, String realizar_envio, String realizar_reg_cont,
			String realizar_emision_fact, String b_auto_cobro, String b_auto_reg_cont, String b_incluir_rebate,
			String unidad_medida, String tipo_cargo, String sistem_cobro, String b_captura_imp_liquidado,
			Integer b_precio_controlado, Integer b_adquisicion_sin_iva, String b_info_extra_desc_subconcep,
			String b_info_extra_transaccion, String b_imp_cantidad_en_fact, String b_imp_costo_unitario, String usuario,
			String fecha_cre, String fecha_mod, String comentarios, String tipo_servicio, String realizar_calculo,
			String cuenta_ingreso, String umedida_factura, Integer id_serv_part, Integer id_cat_ingreso,
			String clave_servicio_sat, String clave_unidad_sat, String clave_impuesto_sat, String clave_factor_sat,
			BigDecimal valor_tasa_sat, String evento) {

		if (id_servicios == 0) {
			id_servicios = null;
		}
		if (id_fuente == 0) {
			id_fuente = null;
		}
		if (id_negocio == 0) {
			id_negocio = null;
		}
		if (id_precio == null) {
			id_precio = null;
		}
		if (id_forma_pago == 0) {
			id_forma_pago = null;
		}
		if (id_grupo_vol == null) {
			id_grupo_vol = null;
		}
		if (id_grupo_concepto == null) {
			id_grupo_concepto = null;
		}
		if (id_moneda_importe_adq == 0) {
			id_moneda_importe_adq = null;
		}
		if (id_moneda_adq == 0) {
			id_moneda_adq = null;
		}
		if (id_centro_costos == 0) {
			id_centro_costos = null;
		}
		if (b_adquisicion_auto == 0) {
			b_adquisicion_auto = null;
		}
		if (dias_habiles_cobro == null) {
			dias_habiles_cobro = null;
		}
		if (dia_limite_solicitud == null) {
			dia_limite_solicitud = null;
		}

		if (b_precio_controlado == 0) {
			b_precio_controlado = null;
		}
		if (b_adquisicion_sin_iva == 0) {
			b_adquisicion_sin_iva = null;
		}

		if (id_serv_part == null) {
			id_serv_part = null;
		}
		if (id_cat_ingreso == null) {
			id_cat_ingreso = null;
		}
		if (tipo_cargo.equals("null")) {
			tipo_cargo = null;
		} else {
			tipo_cargo = "'" + tipo_cargo + "'";
		}
		if (b_habilitar_op_av != null) {
			b_habilitar_op_av = "1";
		} else {
			b_habilitar_op_av = "0";
		}

		if (realizar_envio != null) {
			realizar_envio = "SI";
		} else {
			realizar_envio = "NO";
		}
		if (realizar_reg_cont != null) {
			realizar_reg_cont = "SI";
		} else {
			realizar_reg_cont = "NO";
		}
		if (realizar_emision_fact != null) {
			realizar_emision_fact = "SI";
		} else {
			realizar_emision_fact = "NO";
		}
		if (b_auto_cobro != null) {
			b_auto_cobro = "SI";
		} else {
			b_auto_cobro = "NO";
		}
		if (b_auto_reg_cont != null) {
			b_auto_reg_cont = "SI";
		} else {
			b_auto_reg_cont = "NO";
		}
		if (realizar_calculo != null) {
			realizar_calculo = "SI";
		} else {
			realizar_calculo = "NO";
		}
		if (b_incluir_rebate != null) {
			b_incluir_rebate = "1";
		} else {
			b_incluir_rebate = "0";
		}
		if (b_captura_imp_liquidado != null) {
			b_captura_imp_liquidado = "1";
		} else {
			b_captura_imp_liquidado = "0";
		}
		if (b_info_extra_desc_subconcep != null) {
			b_info_extra_desc_subconcep = "1";
		} else {
			b_info_extra_desc_subconcep = "0";
		}
		if (b_info_extra_transaccion != null) {
			b_info_extra_transaccion = "1";
		} else {
			b_info_extra_transaccion = "0";
		}
		if (b_imp_cantidad_en_fact != null) {
			b_imp_cantidad_en_fact = "1";
		} else {
			b_imp_cantidad_en_fact = "0";
		}
		if (b_imp_costo_unitario != null) {
			b_imp_costo_unitario = "1";
		} else {
			b_imp_costo_unitario = "0";
		}

		switch (evento) {
		case "delete":
			Query delete = procesoGeneral.getSession()
					.createSQLQuery("update tbl_sif_servicios set estatus='ELI' where id_servicios=" + id_servicios);
			delete.executeUpdate();
			break;
		case "update":
			Query queryUpdate = procesoGeneral.getSession().createSQLQuery("update tbl_sif_servicios set "
					+ "id_fuente=" + id_fuente + "," + "id_negocio=" + id_negocio + "," + "id_forma_pago="
					+ id_forma_pago + "," + "id_grupo_vol=" + id_grupo_vol + "," + "id_grupo_concepto="
					+ id_grupo_concepto + "," + "id_moneda_importe_adq=" + id_moneda_importe_adq + ","
					+ "id_moneda_adq=" + id_moneda_adq + "," + "id_centro_costos=" + id_centro_costos + "," + "clave='"
					+ clave + "'," + "descripcion='" + descripcion + "'," + "estatus='" + estatus + "',"
					+ "b_adquisicion_auto=" + b_adquisicion_auto + "," + "periodicidad_adquisicion='"
					+ periodicidad_adquisicion + "'," + "periodicidad_cobro='" + periodicidad_cobro + "',"
					+ "dias_habiles_cobro=" + dias_habiles_cobro + "," + "dia_limite_solicitud=" + dia_limite_solicitud
					+ "," + "b_habilitar_op_av=" + b_habilitar_op_av + "," + "realizar_envio='" + realizar_envio + "',"
					+ "realizar_reg_cont='" + realizar_reg_cont + "'," + "realizar_emision_fact='"
					+ realizar_emision_fact + "'," + "b_auto_cobro='" + b_auto_cobro + "'," + "b_auto_reg_cont='"
					+ b_auto_reg_cont + "'," + "b_incluir_rebate=" + b_incluir_rebate + "," + "unidad_medida='"
					+ unidad_medida + "'," + "tipo_cargo=" + tipo_cargo + "," + "sistem_cobro='" + sistem_cobro + "',"
					+ "b_captura_imp_liquidado=" + b_captura_imp_liquidado + "," + "b_precio_controlado="
					+ b_precio_controlado + "," + "b_adquisicion_sin_iva=" + b_adquisicion_sin_iva + ","
					+ "b_info_extra_desc_subconcep=" + b_info_extra_desc_subconcep + "," + "b_info_extra_transaccion="
					+ b_info_extra_transaccion + "," + "b_imp_cantidad_en_fact=" + b_imp_cantidad_en_fact + ","
					+ "b_imp_costo_unitario=" + b_imp_costo_unitario + "," + "usuario='"
					+ procesoGeneral.getSesionActual() + "'," + "fecha_mod=sysdate," + "comentarios='" + comentarios
					+ "'," + "tipo_servicio='" + tipo_servicio + "'," + "realizar_calculo='" + realizar_calculo + "',"
					+ "cuenta_ingreso='" + cuenta_ingreso + "'," + "umedida_factura='" + umedida_factura + "',"
					+ "id_serv_part=" + id_serv_part + "," + "id_cat_ingreso=" + id_cat_ingreso + ","
					+ "clave_servicio_sat='" + clave_servicio_sat + "'," + "clave_unidad_sat='" + clave_unidad_sat
					+ "'," + "clave_impuesto_sat='" + clave_impuesto_sat + "'," + "clave_factor_sat='"
					+ clave_factor_sat + "'," + "valor_tasa_sat=" + valor_tasa_sat + " where id_servicios="
					+ id_servicios);
			queryUpdate.executeUpdate();
			break;
		case "insert":
			max_id = procesoGeneral.getId(TablaServicio.class, "id_servicios");
			Query queryInsert = procesoGeneral.getSession().createSQLQuery("insert into tbl_sif_servicios values ("
					+ max_id + "," + id_fuente + "," + id_negocio + "," + id_precio + "," + id_forma_pago + ","
					+ id_grupo_vol + "," + id_grupo_concepto + "," + id_moneda_importe_adq + "," + id_moneda_adq + ","
					+ id_centro_costos + ",'" + clave + "','" + descripcion + "','ACT'," + b_adquisicion_auto + ",'"
					+ periodicidad_adquisicion + "','" + periodicidad_cobro + "'," + dias_habiles_cobro + ","
					+ dia_limite_solicitud + "," + b_habilitar_op_av + ",'" + realizar_envio + "','" + realizar_reg_cont
					+ "','" + realizar_emision_fact + "','" + b_auto_cobro + "','" + b_auto_reg_cont + "',"
					+ b_incluir_rebate + "," + "'" + unidad_medida + "'," + tipo_cargo + ",'" + sistem_cobro + "',"
					+ b_captura_imp_liquidado + "," + b_precio_controlado + "," + b_adquisicion_sin_iva + ","
					+ b_info_extra_desc_subconcep + "," + b_info_extra_transaccion + "," + b_imp_cantidad_en_fact + ","
					+ b_imp_costo_unitario + ",'" + procesoGeneral.getSesionActual() + "',sysdate,sysdate,'"
					+ comentarios + "','" + tipo_servicio + "','" + realizar_calculo + "','" + cuenta_ingreso + "',"
					+ "'" + umedida_factura + "'," + id_serv_part + "," + id_cat_ingreso + ",'" + clave_servicio_sat
					+ "','" + clave_unidad_sat + "','" + clave_impuesto_sat + "','" + clave_factor_sat + "',"
					+ valor_tasa_sat + ")");
			queryInsert.executeUpdate();
			break;
		default:
			break;
		}

	}

	@Override
	public void queryHistorico(Model model, HttpServletRequest request, Integer id_servicios) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaHistoricoServicio.class);
		crit.add(Restrictions.eq("id", id_servicios));
		model.addAttribute("consultaHistorico", crit.list());
	}

	@Override
	public void queryHistoricoCliente(Model model, HttpServletRequest request, Integer id_cliente) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaHistoricoCliente.class);
		crit.add(Restrictions.eq("id", id_cliente));
		model.addAttribute("consultaHistorico", crit.list());
	}

	@Override
	public void queryPrecio(String tipo, Model model, HttpServletRequest request, Integer id_servicios,
			Integer id_precio) {
		switch (tipo) {
		case "precio":
			Criteria critPrecio = procesoGeneral.getSession().createCriteria(TablaPrecio.class);
			critPrecio.add(Restrictions.eq("id_precio", id_precio));
			model.addAttribute("consultaPrecio", critPrecio.list());
			break;
		case "rango":
			Query queryRango = procesoGeneral.getSession().createSQLQuery(
					"select id_precio as \"id_precio\",rango_inicial as \"rango_inicial\",rango_final as \"rango_final\",precio as \"precio\",cuota_fija as \"cuota_fija\" from TBL_SIF_CAT_RANGO_PREC where id_precio="
							+ id_precio);
			queryRango.setResultTransformer(Transformers.aliasToBean(TablaRangoPrecio.class));
			model.addAttribute("consultaRangoPrecio", queryRango.list());
			break;

		default:
			break;
		}
	}

	@Override
	public void crudPrecio(Model model, HttpServletRequest request, Integer id_servicios, Integer id_precio,
			String listaPrecios, String inputPrecio, String tipoPrecio, Integer inputMoneda,
			RedirectAttributes redirectAttributes) {
		Integer idPrecioVacio = id_precio;
		Query queryUpdatePrecio = null;
		Query queryInsertRangoPrecio = null;
		Query queryDeleteRangoPrecio = null;
		Query queryInsertPrecio = null;
		Query queryUpdateServicio = null;
		if (id_precio == null) {
			Integer max_id = procesoGeneral.getId(TablaPrecio.class, "id_precio");
			queryInsertPrecio = procesoGeneral.getSession().createSQLQuery(
					"insert into TBL_SIF_CAT_PRECIOS (ID_PRECIO,TIPO_PRECIO,ID_MONEDA,ESTATUS,FECHA_MOD,FECHA_CRE,USUARIO,COMENTARIOS) values ("
							+ max_id + ",'" + tipoPrecio + "'," + inputMoneda + ",'ACT',sysdate,sysdate,'"
							+ procesoGeneral.getSesionActual() + "','" + tipoPrecio + "')");
			queryInsertPrecio.executeUpdate();
			queryUpdateServicio = procesoGeneral.getSession().createSQLQuery("update tbl_sif_servicios set id_precio="
					+ max_id + ",fecha_mod=sysdate where id_servicios=" + id_servicios);
			queryUpdateServicio.executeUpdate();
			id_precio = max_id;
		}

		if (tipoPrecio.equals("FIJ") || tipoPrecio.equals("REN")) {
			if (!(idPrecioVacio == null)) {
				queryUpdatePrecio = procesoGeneral.getSession()
						.createSQLQuery("update TBL_SIF_CAT_PRECIOS set tipo_precio='" + tipoPrecio + "',id_moneda="
								+ inputMoneda + ",usuario='" + procesoGeneral.getSesionActual() + "' where id_precio="
								+ id_precio);
				queryUpdatePrecio.executeUpdate();
			}
			queryDeleteRangoPrecio = procesoGeneral.getSession()
					.createSQLQuery("delete from TBL_SIF_CAT_RANGO_PREC where id_precio=" + id_precio);
			queryInsertRangoPrecio = procesoGeneral.getSession().createSQLQuery(
					"insert into TBL_SIF_CAT_RANGO_PREC (ID_PRECIO,RANGO_INICIAL,RANGO_FINAL,PRECIO,CUOTA_FIJA) values ("
							+ id_precio + ",1,null," + inputPrecio + ",null)");

			queryDeleteRangoPrecio.executeUpdate();
			queryInsertRangoPrecio.executeUpdate();
		}
		if (tipoPrecio.equals("VOL") || tipoPrecio.equals("ESC")) {
			String[] partrInsert = listaPrecios.split(Pattern.quote("||"));
			int numInsert = 1;
			queryUpdatePrecio = procesoGeneral.getSession()
					.createSQLQuery("update TBL_SIF_CAT_PRECIOS set tipo_precio='" + tipoPrecio + "',id_moneda="
							+ inputMoneda + ",usuario='" + procesoGeneral.getSesionActual() + "' where id_precio="
							+ id_precio);
			queryDeleteRangoPrecio = procesoGeneral.getSession()
					.createSQLQuery("delete from TBL_SIF_CAT_RANGO_PREC where id_precio=" + id_precio);
			queryUpdatePrecio.executeUpdate();
			queryDeleteRangoPrecio.executeUpdate();
			for (String part : partrInsert) {
				String[] part2 = part.split(Pattern.quote(","));
				String uno = part2[0];
				String dos = part2[1];
				String tres = part2[2];
				if (uno.isEmpty()) {
					uno = null;
				}
				if (dos.isEmpty()) {
					dos = null;
				}
				if (tres.isEmpty()) {
					tres = null;
				}

				queryInsertRangoPrecio = procesoGeneral.getSession().createSQLQuery(
						"insert into TBL_SIF_CAT_RANGO_PREC (ID_PRECIO,RANGO_INICIAL,RANGO_FINAL,PRECIO,CUOTA_FIJA) values ("
								+ id_precio + "," + uno + "," + dos + "," + tres + ",null)");

				queryInsertRangoPrecio.executeUpdate();

				numInsert++;
			}
		}
		if (tipoPrecio.equals("PRO") || tipoPrecio.equals("MAX") || tipoPrecio.equals("MIN")) {
		}

		redirectAttributes.addFlashAttribute("id_servicios", id_servicios);
		redirectAttributes.addFlashAttribute("id_precio", id_precio);

	}

	@Override
	public void jasper(Model model, HttpServletRequest request, HttpServletResponse response, Integer servicio,
			Integer concepto, Integer volumen, String estatus, Integer negocio, Integer fuente, String tipo) {
		String sql = "select 	* from TBL_SIF_SERVICIOS where 1=1 ";
		if (!(servicio == 0)) {
			sql = sql.concat(" and id_servicios=" + servicio);
		}
		if (!(concepto == 0)) {
			sql = sql.concat(" and id_grupo_concepto=" + concepto);
		}
		if (!(volumen == 0)) {
			sql = sql.concat(" and id_grupo_vol=" + volumen);
		}
		if (!estatus.equals("empty")) {
			sql = sql.concat(" and estatus= '" + estatus + "'");
		}
		if (!(negocio == 0)) {
			sql = sql.concat(" and id_negocio=" + negocio);
		}

		if (!(fuente == 0)) {
			sql = sql.concat(" and id_fuente=" + fuente);
		}
		sql = sql.concat(" order by clave asc");
		String in = request.getSession().getServletContext().getRealPath("/imagenes/logo1.jpg");
		File logo = new File(in);
		Map parameters = new HashMap();
		parameters.put("reportHomePath", logo);
		procesoGeneral.GenerarReporte(model, request, response, sql, "Report_Serv", "Reporte de servicios", tipo,
				parameters);

	}

	public void queryConcepto(String tipo, Model model, HttpServletRequest request, Integer id_servicios,
			Integer id_precio) {

		switch (tipo) {
		case "aplicacion":
			Query queryAplicacion = procesoGeneral.getSession().createSQLQuery(
					"select distinct id as \"id\", id||' - '||valor||': '||descripcion as \"descripcion_concepto\",descripcion as \"descripcion\" from tbl_sif_cat_conceptos where tipo = 'APLICACION'  and id_grupo = 0  and estatus = 'ACT' and id not in (select numero from tbl_sif_subconceptos where id_servicios = "
							+ id_servicios + ")");
			queryAplicacion.setResultTransformer(Transformers.aliasToBean(BeanSubconceptoAplicacion.class));
			model.addAttribute("consultaAplicacion", queryAplicacion.list());

			break;
		case "subconcepto":
			Query querySubConpcepto = procesoGeneral.getSession().createSQLQuery(
					"select s.id_servicios as \"id_servicios\",s.clave as \"clave\",sc.numero as \"numero\",c.descripcion as \"descripcion\",c.valor as \"valor\", sc.id_precio as \"id_precio\",p.tipo_precio as \"tipo_precio\",m.nombre_moneda as \"nombre_moneda\" from tbl_sif_servicios s,tbl_sif_subconceptos sc,tbl_sif_cat_conceptos c,tbl_sif_cat_precios p,tbl_sif_cat_monedas m where s.id_servicios = sc.id_servicios and sc.numero = c.id and sc.id_precio = p.id_precio(+) and p.id_moneda = m.id_moneda(+) and tipo = 'APLICACION' and sc.id_servicios="
							+ id_servicios);
			querySubConpcepto.setResultTransformer(Transformers.aliasToBean(BeanSubconceptoAplicacion.class));
			model.addAttribute("consultaSubConcepto", querySubConpcepto.list());
			break;

		default:
			break;
		}
	}

	@Override
	public void jasperClientes(Model model, HttpServletRequest request, HttpServletResponse response,
			String clave_cliente, String nombre_corto, Integer clave_grupo, String estatus, String tipo) {
		String sql = "select 	* from TBL_SIF_CAT_CLIENTES where 1=1 ";

		if (!clave_cliente.equals("empty")) {
			sql = sql.concat(" and clave_cliente= '" + clave_cliente + "'");
		}
		if (!nombre_corto.equals("empty")) {
			sql = sql.concat(" and nombre_corto= '" + nombre_corto + "'");
		}
		if (!(clave_grupo == 0)) {
			sql = sql.concat(" and clave_grupo=" + clave_grupo);
		}
		if (!estatus.equals("empty")) {
			sql = sql.concat(" and estatus= '" + estatus + "'");
		}
		sql = sql.concat(" order by clave_cliente asc");
		String in = request.getSession().getServletContext().getRealPath("/imagenes/logo1.jpg");
		File logo = new File(in);
		Map parameters = new HashMap();
		parameters.put("reportHomePath", logo);

		procesoGeneral.GenerarReporte(model, request, response, sql, "Report_Clientes", "Reporte de clientes", tipo,
				parameters);

	}

	@Override
	public void queryContacto(Model model, HttpServletRequest request, Integer id_cliente) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaContacto.class);
		crit.add(Restrictions.eq("id_cliente", id_cliente));
		model.addAttribute("consultaContactos", crit.list());
	}

	@Override
	public void queryMetodoPago(Model model, HttpServletRequest request, Integer id_cliente) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaMetodosPago.class);
		crit.add(Restrictions.eq("id_cliente", id_cliente));
		model.addAttribute("consultaMetodoPago", crit.list());
	}

	// CAMBIO
	@Override
	public void crudCliente(Model model, HttpServletRequest request, String evento, Integer fromRow, Integer id_cliente,
			String clave_cliente, String rfc, String curp, Integer fiid, String nombre_corto, String razon_social,
			Integer id_grupo_vol, String clave_formapago_sat, String numero_idfiscal_sat, String rfc_entidad_emi,
			String cuenta_bancaria, String nom_entidad_emi, Integer id_cuenta_banco, String b_cliente_consorcio,
			String b_cliente_socio, String b_incluir_rebate, Integer pct_iva, String inf_addicional,
			String inf_addicional_1, String comentarios) {
		if (b_cliente_consorcio != null) {
			b_cliente_consorcio = "1";
		} else {
			b_cliente_consorcio = "0";
		}
		if (b_cliente_socio != null) {
			b_cliente_socio = "1";
		} else {
			b_cliente_socio = "0";
		}
		if (b_incluir_rebate != null) {
			b_incluir_rebate = "1";
		} else {
			b_incluir_rebate = "0";
		}

		System.out.println("evento= " + evento + "," + "id_cliente= " + id_cliente + "," + "clave_cliente= "
				+ clave_cliente + "," + "rfc= " + rfc + "," + "curp= " + curp + "," + "fiid= " + fiid + ","
				+ "nombre_corto= " + nombre_corto + "," + "razon_social= " + razon_social + "," + "id_grupo_vol= "
				+ id_grupo_vol + "," + "clave_formapago_sat= " + clave_formapago_sat + "," + "numero_idfiscal_sat= "
				+ numero_idfiscal_sat + "," + "rfc_entidad_emi= " + rfc_entidad_emi + "," + "cuenta_bancaria= "
				+ cuenta_bancaria + "," + "nom_entidad_emi= " + nom_entidad_emi + "," + "id_cuenta_banco= "
				+ id_cuenta_banco + "," + "b_cliente_consorcio= " + b_cliente_consorcio + "," + "b_cliente_socio= "
				+ b_cliente_socio + "," + "b_incluir_rebate= " + b_incluir_rebate + "," + "pct_iva= " + pct_iva + ","
				+ "inf_addicional= " + inf_addicional + "," + "inf_addicional_1= " + inf_addicional_1 + ","
				+ "comentarios= " + comentarios + ",");
		switch (evento) {
		case "update":
			Query queryUpdate = procesoGeneral.getSession()
					.createSQLQuery("update tbl_sif_cat_clientes set " + "rfc= ? ," + "curp= ? ," + "fiid= ? ,"
							+ "nombre_corto= ? ," + "razon_social= ? ," + "id_grupo_vol= ? ,"
							+ "clave_formapago_sat= ? ," + "numero_idfiscal_sat= ? ," + "rfc_entidad_emi= ? ,"
							+ "cuenta_bancaria= ? ," + "nom_entidad_emi= ? ," + "id_cuenta_banco= ? ,"
							+ "b_cliente_consorcio= ? ," + "b_cliente_socio= ? ," + "b_incluir_rebate= ? ,"
							+ "pct_iva= ? ," + "inf_addicional= ? ," + "inf_addicional_1= ? ,"
							+ "comentarios= ?, fecha_mod=sysdate " + "where id_cliente= ?");
			queryUpdate.setString(0, rfc);
			queryUpdate.setString(1, curp);
			queryUpdate.setInteger(2, fiid);
			queryUpdate.setString(3, nombre_corto);
			queryUpdate.setString(4, razon_social);
			queryUpdate.setInteger(5, id_grupo_vol);
			queryUpdate.setString(6, clave_formapago_sat);
			queryUpdate.setString(7, numero_idfiscal_sat);
			queryUpdate.setString(8, rfc_entidad_emi);
			queryUpdate.setString(9, cuenta_bancaria);
			queryUpdate.setString(10, nom_entidad_emi);
			queryUpdate.setInteger(11, id_cuenta_banco);
			queryUpdate.setString(12, b_cliente_consorcio);
			queryUpdate.setString(13, b_cliente_socio);
			queryUpdate.setString(14, b_incluir_rebate);
			queryUpdate.setInteger(15, pct_iva);
			queryUpdate.setString(16, inf_addicional);
			queryUpdate.setString(17, inf_addicional_1);
			queryUpdate.setString(18, comentarios);
			queryUpdate.setInteger(19, id_cliente);
			queryUpdate.executeUpdate();

			break;
		case "insert":
			Integer max_id = procesoGeneral.getId(TablaCliente.class, "id_cliente");
			Query queryInsert = procesoGeneral.getSession().createSQLQuery("insert into tbl_sif_cat_clientes values()");
			queryInsert.executeUpdate();
			break;
		case "delete":
			Query queryDelete = procesoGeneral.getSession()
					.createSQLQuery("update tbl_sif_cat_clientes set estatus='ELI' where id_cliente=?");
			queryDelete.setInteger(0, id_cliente);
			queryDelete.executeUpdate();
			break;

		default:
			break;
		}
	}

	@Override
	public void queryClavesCliente(String tipo, Model model, HttpServletRequest request, Integer id_cliente,
			Integer fromRow) {

		Criteria crit = procesoGeneral.getSession().createCriteria(ViewClavesCliente.class);
		crit.add(Restrictions.eq("id_cliente", id_cliente));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).setFirstResult(fromRow).setMaxResults(15);
		model.addAttribute("consultaClavesCliente", crit.list());

	}

	@Override
	public List<ViewClavesCliente> buscarClavesCliente(Model model, HttpServletRequest request, Integer cliente,
			Integer fromRow) {
		Criteria crit = procesoGeneral.getSession().createCriteria(ViewClavesCliente.class);
		crit.add(Restrictions.eq("id_cliente", cliente));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).setFirstResult(fromRow).setMaxResults(15);
		return crit.list();
	}

	@Override
	public Integer saveClavesCliente(Model model, HttpServletRequest request, String clave, Integer adquirente,
			Integer cliente, String fuentesistema, Integer fuentesis,Integer agrupador) {
		Integer bandera = 0;
		int bandera2=0;
		if(fuentesis==1) {
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaClavesCliente.class);
			crit.add(Restrictions.eq("id_fuente", Integer.parseInt(fuentesistema)));
			crit.add(Restrictions.ne("id_cliente", cliente));
			if(crit.list().size()>=0) {
				bandera=2;
			}else {
				bandera2=1;
			}
		}else {
			bandera2=1;
		}
		if(bandera2==1) {
			try {
				Query queryInsert = procesoGeneral.getSession()
						.createSQLQuery("Insert into TBL_SIF_CAT_CONV_CVE_CLI "
								+ " values "
								+ "(:cliente,:clave,decode(:fuentesis,1,:fuentesistema,null),"
								+ "decode(:fuentesis,2,:fuentesistema,null),:adquirente,:agrupador)");
				queryInsert.setParameter("cliente", cliente);
				queryInsert.setParameter("clave", clave);
				queryInsert.setParameter("fuentesis", fuentesis);
				queryInsert.setParameter("fuentesistema", fuentesistema);
				queryInsert.setParameter("adquirente", adquirente);
				queryInsert.setParameter("agrupador",cliente);
				queryInsert.executeUpdate();
				bandera=1;
			} catch (Exception e) {
				bandera=0;
			}

		}
		return bandera;
	}

}
