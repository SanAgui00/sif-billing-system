/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 17/04/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.prosa.sif.operation.ProcesoGeneral;
import com.prosa.sif.pojo.TBL_SIF_CAT_PERIODO;
import com.prosa.sif.pojo.TablaCentroCosto;
import com.prosa.sif.pojo.TablaCliente;
import com.prosa.sif.pojo.TablaContacto;
import com.prosa.sif.pojo.TablaFuente;
import com.prosa.sif.pojo.TablaImporte;
import com.prosa.sif.pojo.TablaNegocio;
import com.prosa.sif.pojo.TablaPolizasContable;
import com.prosa.sif.pojo.TablaServicio;
import com.prosa.sif.pojo.TablaTipoCuenta;
import com.prosa.sif.pojo.ViewClaveCliente;
import com.prosa.sif.pojo.ViewCuentaContable;
import com.prosa.sif.pojo.ViewDireccion;
import com.prosa.sif.pojo.ViewDireccionCliente;
import com.prosa.sif.pojo.ViewDireccionEmpresa;
import com.prosa.sif.pojo.ViewSegmentos;

@Repository
@Transactional
@SuppressWarnings("all")
public class ListaBusquedaGeneralDaoImpl implements ListaBusquedaGeneralDao {
	@Autowired
	private ProcesoGeneral procesoGeneral;

	@Override
	public List<TablaCliente> buscarCliente(String clave) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaCliente.class)
				.add(Restrictions.eq("estatus", "ACT"));
		Criterion crit1 = Restrictions.like("clave_cliente", "%" + clave + "%");
		Criterion crit2 = Restrictions.like("nombre_corto", "%" + clave + "%");
		crit.add(Restrictions.or(crit1, crit2)).setMaxResults(20).addOrder(Order.asc("clave_cliente"));
		return crit.list();
	}

	@Override
	public List<TablaFuente> buscarFuente(String clave) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaFuente.class)
				.add(Restrictions.eq("estatus", "ACT"));
		Criterion crit1 = Restrictions.like("clave", "%" + clave + "%");
		Criterion crit2 = Restrictions.like("descripcion", "%" + clave + "%");
		crit.add(Restrictions.or(crit1, crit2)).setMaxResults(20).addOrder(Order.asc("clave"));
		return crit.list();
	}

	@Override
	public List<TablaServicio> buscarServicio(String clave) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaServicio.class);
		crit.setProjection(Projections.projectionList().add(Projections.property("id_servicios"), "id_servicios")
				.add(Projections.property("clave"), "clave").add(Projections.property("descripcion"), "descripcion"));
		crit.add(Restrictions.eq("estatus", "ACT"));
		Criterion crit1 = Restrictions.like("clave", "%" + clave + "%");
		Criterion crit2 = Restrictions.like("descripcion", "%" + clave + "%");
		crit.add(Restrictions.or(crit1, crit2)).setMaxResults(20).addOrder(Order.asc("clave"));
		crit.setResultTransformer(Transformers.aliasToBean(TablaServicio.class));
		return crit.list();
	}

	@Override
	public void buscarServicioId(Model model, HttpServletRequest request, Integer id_servicios) {
		if (id_servicios != 0) {
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaServicio.class)
					.add(Restrictions.eq("id_servicios", id_servicios)).setMaxResults(1);
			model.addAttribute("consulta", crit.list());

		}
	}

	@Override
	public void buscarClienteId(Model model, HttpServletRequest request, Integer id_cliente) {
		if (id_cliente != 0) {
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaCliente.class)
					.add(Restrictions.eq("id_cliente", id_cliente)).setMaxResults(1);
			model.addAttribute("consulta", crit.list());

		}
	}

	@Override
	public void buscarDireccion(Model model, HttpServletRequest request, Integer id_domicilio) {
		Criteria crit = procesoGeneral.getSession().createCriteria(ViewDireccion.class)
				.add(Restrictions.eq("id_domicilio", id_domicilio)).setMaxResults(1);
		model.addAttribute("direccion", crit.list());

	}

	@Override
	public void buscarClaveCliente(Model model, HttpServletRequest request, Integer id_cliente) {
		Criteria crit = procesoGeneral.getSession().createCriteria(ViewClaveCliente.class)
				.add(Restrictions.eq("id_cliente", id_cliente));
		model.addAttribute("listaClavesCliente", crit.list());
	}

	@Override
	public void buscarCuentaContable(Model model, HttpServletRequest request, Integer id_cliente) {
		Criteria crit = procesoGeneral.getSession().createCriteria(ViewCuentaContable.class)
				.add(Restrictions.eq("id_cliente", id_cliente));
		model.addAttribute("listaCuentasClientes", crit.list());

	}

	@Override
	public void buscarDireccionEmpresa(Model model, HttpServletRequest request, Integer id_empresa) {
		Criteria crit = procesoGeneral.getSession().createCriteria(ViewDireccionEmpresa.class)
				.add(Restrictions.eq("id_empresa", id_empresa)).setMaxResults(1);
		model.addAttribute("direccion", crit.list());
	}

	@Override
	public List<TablaNegocio> buscarNegocio(int clave) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaNegocio.class)
				.add(Restrictions.eq("id_proceso", clave)).add(Restrictions.eq("status", "ACT"))
				.addOrder(Order.asc("clave"));
		return crit.list();
	}

	@Override
	public List<TablaPolizasContable> buscarPoliza(String clave) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaPolizasContable.class)
				.add(Restrictions.like("clave", "%" + clave + "%")).add(Restrictions.eq("estatus", "ACT"))
				.addOrder(Order.asc("clave"));
		return crit.list();
	}

	@Override
	public List<TablaCentroCosto> buscarCentro(String clave) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaCentroCosto.class)
				.add(Restrictions.like("descripcion", "%" + clave + "%")).add(Restrictions.eq("estatus", "ACT"))
				.addOrder(Order.asc("clave_centro_costos"));
		return crit.list();
	}

	@Override
	public List<TablaPolizasContable> buscarPolizaUnica(String clave) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaPolizasContable.class)
				.add(Restrictions.eq("clave", clave));
		return crit.list();
	}

	@Override
	public List<TablaNegocio> buscarNegocioDin(String clave) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaNegocio.class)
				.add(Restrictions.like("clave", "%" + clave + "%")).add(Restrictions.eq("status", "ACT"))
				.addOrder(Order.asc("clave"));
		return crit.list();
	}

	@Override
	public List<TBL_SIF_CAT_PERIODO> search_TBL_SIF_CAT_PERIDO(int clave) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TBL_SIF_CAT_PERIODO.class)
				.add(Restrictions.eq("id_periodos", clave));

		return crit.list();
	}

	@Override
	public List<TablaTipoCuenta> buscarCuentas(String clave) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaTipoCuenta.class)
				.add(Restrictions.like("clave", "%" + clave + "%")).add(Restrictions.eq("estatus", "ACT"))
				.addOrder(Order.asc("clave"));
		return crit.list();
	}

	

	@Override
	public List<TablaImporte> buscarImporte(String clave) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaImporte.class)
				.add(Restrictions.like("descripcion", "%" + clave + "%")).add(Restrictions.eq("estatus", "ACT"))
				.addOrder(Order.asc("clave"));
		return crit.list();
	}

	@Override
	public List<ViewSegmentos> buscarParametrizacion(String clave) {
		String datos[]=clave.split(Pattern.quote("||"));
		Criteria crit = procesoGeneral.getSession().createCriteria(ViewSegmentos.class)
				.add(Restrictions.eq("estatus", 1)).add(Restrictions.eq("id_segmento", Integer.parseInt(datos[0])));
		Criterion crit1 = Restrictions.like("valor_segmento", "%" + datos[1].toLowerCase() + "%");
		Criterion crit2 = Restrictions.like("descripcion", "%" + datos[1].toLowerCase() + "%");
		
		crit.add(Restrictions.or(crit1, crit2)).setMaxResults(20);
		return crit.list();
	}

	@Override
	public List<ViewDireccion> buscarDireccion(Model model, HttpServletRequest request, String clave) {
		Criteria crit = procesoGeneral.getSession().createCriteria(ViewDireccion.class)
		.add(Restrictions.eq("cp", clave));
		return crit.list();
	}

	@Override
	public List<ViewDireccionCliente> buscarContacto(Integer clave) {
		Criteria crit = procesoGeneral.getSession().createCriteria(ViewDireccionCliente.class)
		.add(Restrictions.eq("id_contacto", clave));
		return crit.list();
	}

	
}