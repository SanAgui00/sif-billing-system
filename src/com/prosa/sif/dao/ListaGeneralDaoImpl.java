/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 08/05/2018 #
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
import com.prosa.sif.pojo.TablaAddenda;
import com.prosa.sif.pojo.TablaBanco;
import com.prosa.sif.pojo.TablaCentroCosto;
import com.prosa.sif.pojo.TablaCertificados;
import com.prosa.sif.pojo.TablaClaveServicio;
import com.prosa.sif.pojo.TablaClaveUnidad;
import com.prosa.sif.pojo.TablaCliente;
import com.prosa.sif.pojo.TablaConcepto;
import com.prosa.sif.pojo.TablaEmpresa;
import com.prosa.sif.pojo.TablaEstados;
import com.prosa.sif.pojo.TablaFormaPagos;
import com.prosa.sif.pojo.TablaFormasPago;
import com.prosa.sif.pojo.TablaFuente;
import com.prosa.sif.pojo.TablaFuncionalidad;
import com.prosa.sif.pojo.TablaGrupoCliente;
import com.prosa.sif.pojo.TablaGrupoConceptoServicio;
import com.prosa.sif.pojo.TablaGrupoVolumenCliente;
import com.prosa.sif.pojo.TablaGrupoVolumenServicio;
import com.prosa.sif.pojo.TablaHisReglaConversion;
import com.prosa.sif.pojo.TablaImporte;
import com.prosa.sif.pojo.TablaIngreso;
import com.prosa.sif.pojo.TablaMetodoPago;
import com.prosa.sif.pojo.TablaMoneda;
import com.prosa.sif.pojo.TablaNegocio;
import com.prosa.sif.pojo.TablaPais;
import com.prosa.sif.pojo.TablaParametro;
import com.prosa.sif.pojo.TablaPolizasContable;
import com.prosa.sif.pojo.TablaProceso;
import com.prosa.sif.pojo.TablaRedLogica;
import com.prosa.sif.pojo.TablaRegimenFiscal;
import com.prosa.sif.pojo.TablaServicio;
import com.prosa.sif.pojo.TablaServicioParticular;
import com.prosa.sif.pojo.TablaTasaCuota;
import com.prosa.sif.pojo.TablaTipoCargo;
import com.prosa.sif.pojo.TablaTipoCuenta;
import com.prosa.sif.pojo.TablaTipoFactor;
import com.prosa.sif.pojo.TablaTipoImpuesto;
import com.prosa.sif.pojo.TablaTipoPago;
import com.prosa.sif.pojo.TablaTiposComprobante;
import com.prosa.sif.pojo.TablaTiposRelacion;
import com.prosa.sif.pojo.TablaUMedida;
import com.prosa.sif.pojo.TablaUnidadMedida;
import com.prosa.sif.pojo.TablaUsoCfdi;
import com.prosa.sif.pojo.TablaUsuario;
import com.prosa.sif.pojo.ViewSegmentos;

/**
 * 
 * @author Loredo
 *
 */
@Repository
@Transactional
@SuppressWarnings("all")
public class ListaGeneralDaoImpl implements ListaGeneralDao {
	@Autowired
	private ProcesoGeneral procesoGeneral;

	@Override
	public void listaFuentes(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaFuente.class)
				.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		model.addAttribute("listaFuentes", crit.list());
	}

	@Override
	public void listaServicios(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaServicio.class);
		crit.setProjection(Projections.projectionList().add(Projections.property("id_servicios"), "id_servicios")
				.add(Projections.property("clave"), "clave").add(Projections.property("descripcion"), "descripcion"));
		crit.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave"));
		crit.setResultTransformer(Transformers.aliasToBean(TablaServicio.class));
		model.addAttribute("listaServicio", crit.list());
	}

	@Override
	public void listaClientes(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaCliente.class)
				.addOrder(Order.asc("clave_cliente")).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		model.addAttribute("listaClientes", crit.list());
	}

	@Override
	public void listaNegocios(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaNegocio.class)
				.add(Restrictions.eq("status", "ACT")).addOrder(Order.asc("clave"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		model.addAttribute("listaNegocios", crit.list());
	}

	@Override
	public void listaMetodosPago(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaMetodoPago.class)
				.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave"));
				
		model.addAttribute("listaMetodosPago", crit.list());
	}

	@Override
	public void listaUsosCFDI(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaUsoCfdi.class)
				.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		model.addAttribute("listaUsoCfdi", crit.list());

	}

	@Override
	public void listaProceso(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaProceso.class)
				.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave_proceso"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		model.addAttribute("listaProceso", crit.list());

	}

	@Override
	public void listaCentroCostos(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaCentroCosto.class)
				.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave_centro_costos"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		model.addAttribute("listaCentroCosto", crit.list());
	}

	@Override
	public void listaGrupoVolumen(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaGrupoVolumenServicio.class)
				.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.desc("clave"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		model.addAttribute("listaGrupoVolumenServicio", crit.list());

	}

	@Override
	public void listaGrupoConcepto(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaConcepto.class)
				.setProjection(Projections.distinct(Projections.property("descripcion")))
				.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
						.add(Projections.property("descripcion"), "descripcion"))
				.add(Restrictions.eq("tipo", "GRUPO")).addOrder(Order.asc("descripcion"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.setResultTransformer(Transformers.aliasToBean(TablaConcepto.class));
		model.addAttribute("listaGrupoConceptoServicio", crit.list());

	}

	@Override
	public void listaIngreso(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaIngreso.class).addOrder(Order.asc("clave"));
		model.addAttribute("listaIngreso", crit.list());
	}

	@Override
	public void listaClavesServicio(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaClaveServicio.class)
				.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.desc("clave"));
		model.addAttribute("listaClavesServicio", crit.list());
	}

	@Override
	public void listaClavesUnidad(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaClaveUnidad.class)
				.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave"));
		model.addAttribute("listaClavesUnidad", crit.list());
	}

	@Override
	public void listaServiciosParticulares(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaServicioParticular.class)
				.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("descripcion"));
		model.addAttribute("listaServiciosParticulares", crit.list());
	}

	@Override
	public void listaTipoImpuesto(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaTipoImpuesto.class)
				.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave"));
		model.addAttribute("listaTiposImpuesto", crit.list());
	}

	@Override
	public void listaTiposFactor(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaTipoFactor.class)
				.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave"));
		model.addAttribute("listaTiposFactor", crit.list());
	}

	@Override
	public void listaTasasCuotas(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaTasaCuota.class)
				.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave"));
		model.addAttribute("listaTasasCuotas", crit.list());
	}

	@Override
	public void listaUnidadMedida(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaUnidadMedida.class)
				.addOrder(Order.asc("unidad_medida"));
		model.addAttribute("listaUnidadMedida", crit.list());
	}

	@Override
	public void listaTiposCargo(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaTipoCargo.class)
				.addOrder(Order.asc("tipo_cargo"));
		model.addAttribute("listaTiposCargo", crit.list());

	}

	@Override
	public void listaUMedida(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaUMedida.class).addOrder(Order.asc("clave"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		model.addAttribute("listaUMedida", crit.list());
	}

	@Override
	public void listaCuentasContables(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaTipoCuenta.class)
				.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		model.addAttribute("listaCuentasContables", crit.list());

	}

	@Override
	public void listaFormaPagos(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaFormaPagos.class)
				.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		model.addAttribute("listaFormasPagos", crit.list());
	}

	@Override
	public void listaGrupoCliente(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaGrupoVolumenCliente.class)
				.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave"));
		model.addAttribute("listaGrupoCliente", crit.list());
	}

	@Override
	public void listaRedesLogicas(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaRedLogica.class).addOrder(Order.asc("clave"));
		model.addAttribute("listaRedesLogicas", crit.list());
	}

	@Override
	public void listaEmpresas(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaEmpresa.class)
				.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("razon_social"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		model.addAttribute("listaEmpresas", crit.list());
	}

	@Override
	public void listaRegimenFiscal(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaRegimenFiscal.class)
				.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		model.addAttribute("listaRegimenFiscal", crit.list());
	}

	@Override
	public void listaTipoPago(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaTipoPago.class)
				.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		model.addAttribute("listaTipoPago", crit.list());
	}

	@Override
	public void listaConceptos(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaConcepto.class).addOrder(Order.asc("valor"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		model.addAttribute("listaConceptos", crit.list());
	}

	@Override
	public void listaTipoConceptos(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaConcepto.class)
				.setProjection(Projections.distinct(Projections.property("tipo"))).addOrder(Order.asc("tipo"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		model.addAttribute("listaTipo", crit.list());
	}

	@Override
	public void listaDescripcionConceptos(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaConcepto.class)
				.setProjection(Projections.distinct(Projections.property("descripcion")))
				.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
						.add(Projections.property("descripcion"), "descripcion"))
				.add(Restrictions.eq("tipo", "USUARIO")).addOrder(Order.asc("descripcion"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.setResultTransformer(Transformers.aliasToBean(TablaConcepto.class));
		model.addAttribute("listaDescripcion", crit.list());
	}

	@Override
	public void listaAddendas(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaAddenda.class)
				.add(Restrictions.eq("tipo", "Addenda")).addOrder(Order.asc("addenda"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		model.addAttribute("listaAddendas", crit.list());
	}

	@Override
	public void listaMonedas(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaMoneda.class)
				.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("nombre_moneda"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		model.addAttribute("listaMonedas", crit.list());
	}

	@Override
	public void listaUsuarios(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaUsuario.class).addOrder(Order.asc("usuario"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		model.addAttribute("listaUsuario", crit.list());
	}

	@Override
	public void listaFuncionalidades(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaFuncionalidad.class)
				.addOrder(Order.asc("nombre")).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		model.addAttribute("listaFuncionalidades", crit.list());
	}

	@Override
	public void listaParametros(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaParametro.class)
				.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("nombre"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		model.addAttribute("listaParametros", crit.list());
	}

	@Override
	public void listaGrupoConceptoServ(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaGrupoConceptoServicio.class)
				.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave"));
		model.addAttribute("listaGrupoConceptoServ", crit.list());
	}

	@Override
	public void listaPeriodos(Model model, HttpServletRequest request) {
		String consulta = "from ViewListaPeriodo where estatus='ACT' order by fecha_inicio desc";
		Query query = procesoGeneral.getSession().createQuery(consulta);
		model.addAttribute("listaPeriodos", query.list());
	}

	@Override
	public void listaGruposCliente(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaGrupoCliente.class)
				.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave"));
		model.addAttribute("listaGruposCliente", crit.list());
	}

	@Override
	public void listaPolizas(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaPolizasContable.class)
				.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave"));
		model.addAttribute("listaPoliza", crit.list());

	}

	@Override
	public void reglasConversion(Model model, HttpServletRequest request, Integer servicio_id) {
		// TODO Auto-generated method stub
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaHisReglaConversion.class)
				.add(Restrictions.eq("servicio_id", servicio_id)).addOrder(Order.desc("fecha_mod"));
		model.addAttribute("reglasConversion", crit.list());
	}

	@Override
	public void listaTipoComprobantes(Model model, HttpServletRequest request) {
		// TODO Auto-generated method stub
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaTiposComprobante.class)
				.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave"));
		model.addAttribute("listaTiposComprobante", crit.list());

	}

	@Override
	public void listaFormaPago(Model model, HttpServletRequest request) {
		// TODO Auto-generated method stub
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaFormasPago.class)
				.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		model.addAttribute("listaFormasPago", crit.list());
	}
	
	@Override
	public void listaTipoRelacion(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaTiposRelacion.class)
				.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave"));
				
		model.addAttribute("listaTipoRelacion", crit.list());
	}

	@Override
	public void ListaCertificados(Model model, HttpServletRequest request) {
		// TODO Auto-generated method stub
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaCertificados.class)
				.add(Restrictions.eq("estatus", "ACT"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		model.addAttribute("ListaCertificados", crit.list());
	}

	@Override
	public void listaImportes(Model model, HttpServletRequest request) {
		// TODO Auto-generated method stub
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaImporte.class)
				.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave"));
		model.addAttribute("listaImportes", crit.list());
	}

	@Override
	public void listaSegmentos(Model model, HttpServletRequest request, int i) {
		// TODO Auto-generated method stub
		Criteria crit = procesoGeneral.getSession().createCriteria(ViewSegmentos.class)
				.add(Restrictions.eq("estatus", 1)).add(Restrictions.eq("id_segmento", i));
		model.addAttribute("listaSegmentos"+i, crit.list());
	}

	@Override
	public void listaCuentasBanco(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaBanco.class)
				.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("nom_banco"));
		model.addAttribute("listaBanco", crit.list());
	}

	@Override
	public void listaFormasPago(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaFormasPago.class);
		crit.setProjection(Projections.projectionList().add(Projections.property("clave"), "clave")
				.add(Projections.property("descripcion"), "descripcion"));
		crit.add(Restrictions.eq("estatus", "ACT")).addOrder(Order.asc("clave"));
		crit.setResultTransformer(Transformers.aliasToBean(TablaFormasPago.class));
		model.addAttribute("listaFormasPago", crit.list());
	}

	@Override
	public void listaPaises(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaPais.class);
		crit.setProjection(Projections.projectionList().add(Projections.property("id_pais"), "id_pais")
				.add(Projections.property("nombre"), "nombre"));
		crit.addOrder(Order.asc("nombre"));
		crit.setResultTransformer(Transformers.aliasToBean(TablaPais.class));
		model.addAttribute("listaPaises", crit.list());
	}

	@Override
	public void listaEstados(Model model, HttpServletRequest request) {
		Criteria crit = procesoGeneral.getSession().createCriteria(TablaEstados.class);
		model.addAttribute("listaEstados", crit.list());
	}


}
