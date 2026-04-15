/**
################################################################################
# Autor               : Garnica Garcia David                                   #
# Compania            : Codigo Geek                                            #
# Proyecto/Procliente :                                      Fecha: 25/04/2018 #
# Descripcion General : 								 			           #
# Marca del cambio    :                                                        #
################################################################################
**/

package com.prosa.sif.dao;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import com.prosa.sif.operation.ProcesoGeneral;
import com.prosa.sif.pojo.TablaFormasPago;
import com.prosa.sif.pojo.TablaMetodoPago;
import com.prosa.sif.pojo.TablaRegimenFiscal;
import com.prosa.sif.pojo.TablaTiposComprobante;
import com.prosa.sif.pojo.TablaTiposRelacion;
import com.prosa.sif.pojo.TablaUsoCfdi;
import com.prosa.sif.pojo.TablaTipoImpuesto;
import com.prosa.sif.pojo.TablaTipoFactor;
import com.prosa.sif.pojo.TablaTasaCuota;
import com.prosa.sif.pojo.BeanCertificados;
import com.prosa.sif.pojo.TablaCertificados;
import com.prosa.sif.pojo.TablaClaveServicio;
import com.prosa.sif.pojo.TablaClaveUnidad;

@Transactional
@Repository
@SuppressWarnings("all")
public class SATDaoImpl implements SATDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private ProcesoGeneral procesoGeneral;

	@Override
	public void queryRegimenFiscal(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			Integer regimen, String estatus) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaRegimenFiscal.class);
			if (regimen != 0) {
				count.add(Restrictions.eq("id", regimen));
			}
			if (!estatus.equals("empty")) {
				count.add(Restrictions.eq("estatus", estatus));
			}else{
				count.add(Restrictions.eq("estatus", "ACT"));
			}
			count.addOrder(Order.asc("clave"));
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);

			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaRegimenFiscal.class);
			if (regimen != 0) {
				crit.add(Restrictions.eq("id", regimen));
			}
			if (!estatus.equals("empty")) {
				crit.add(Restrictions.eq("estatus", estatus));
			}else {
				crit.add(Restrictions.eq("estatus", "ACT"));
			}
			crit.addOrder(Order.asc("clave")).setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("consulta", crit.list());
			break;

		default:
			break;
		}

		
	}

	@Override
	public void queryFindRegimenFiscal(Model model, HttpServletRequest request, Integer regimen, String evento) {
		if(!evento.equals("new")) {
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaRegimenFiscal.class).add(Restrictions.eq("id", regimen));
			model.addAttribute("editar", crit.list());
		}
		model.addAttribute("event", evento);
	}

	@Override
	public void SaveOrUpdateRegimenFiscal(Model model, HttpServletRequest request, Integer regimen, String clave,
			String descripcion, String fisica, String moral, String evento, String estatus) {
		switch (evento) {
		case "update":
			Query queryUpdate = procesoGeneral.getSession()
					.createSQLQuery("update TBL_SIF_CAT_REGIMEN_FISCAL set clave= ?,descripcion= ?,aplica_fisica= ?, aplica_moral= ?,estatus= ?,usuario= ?,fecha= sysdate where id=?" );
			queryUpdate.setParameter(0, clave);
			queryUpdate.setParameter(1, descripcion);
			queryUpdate.setParameter(2, fisica);
			queryUpdate.setParameter(3, moral);
			queryUpdate.setParameter(4, estatus);
			queryUpdate.setParameter(5, procesoGeneral.getSesionActual());
			queryUpdate.setParameter(6, regimen);
			queryUpdate.executeUpdate(); 
			break;
		case "insert":
			
			Query queryInsert = procesoGeneral.getSession()
					.createSQLQuery("Insert into TBL_SIF_CAT_REGIMEN_FISCAL  values (?,?,?,?,?,'ACT',?,sysdate)");
			queryInsert.setParameter(0, procesoGeneral.getId(TablaRegimenFiscal.class, "id"));
			queryInsert.setParameter(1, clave);
			queryInsert.setParameter(2, descripcion);
			queryInsert.setParameter(3, fisica);
			queryInsert.setParameter(4, moral);
			queryInsert.setParameter(5, procesoGeneral.getSesionActual());
			queryInsert.executeUpdate();
			break;
		case "delete":
				Query delete = procesoGeneral.getSession()
						.createSQLQuery("update TBL_SIF_CAT_REGIMEN_FISCAL set estatus='NOA' where id=?");
				delete.setParameter(0, regimen);
				delete.executeUpdate();
			break;
		default:
			break;
		}

	
	}

	@Override
	public void queryTiposImpuesto(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			Integer impuesto, String estatus) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaTipoImpuesto.class);
			if (impuesto != 0) {
				count.add(Restrictions.eq("id", impuesto));
			}
			if (!estatus.equals("empty")) {
				count.add(Restrictions.eq("estatus", estatus));
			}else {
				count.add(Restrictions.eq("estatus", "ACT"));
			}
			count.addOrder(Order.asc("clave"));
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);

			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaTipoImpuesto.class);
			if (impuesto != 0) {
				crit.add(Restrictions.eq("id", impuesto));
			}
			if (!estatus.equals("empty")) {
				crit.add(Restrictions.eq("estatus", estatus));
			}else {
				crit.add(Restrictions.eq("estatus", "ACT"));
			}
			crit.addOrder(Order.asc("clave")).setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("consulta", crit.list());
			break;

		default:
			break;
		}


	}

	@Override
	public void queryFindTipoImpuesto(Model model, HttpServletRequest request, Integer impuesto, String evento) {
		if(!evento.equals("new")) {
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaTipoImpuesto.class).add(Restrictions.eq("id", impuesto));
			model.addAttribute("editar", crit.list());
		}
		model.addAttribute("event", evento);
		
	}

	@Override
	public void queryTiposComprobante(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			Integer comprobante, String estatus) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaTiposComprobante.class);
			if (comprobante != 0) {
				count.add(Restrictions.eq("id", comprobante));
			}
			if (!estatus.equals("empty")) {
				count.add(Restrictions.eq("estatus", estatus));
			}else {
				count.add(Restrictions.eq("estatus", "ACT"));
			}
			count.addOrder(Order.asc("clave"));
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);

			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaTiposComprobante.class);
			if (comprobante != 0) {
				crit.add(Restrictions.eq("id", comprobante));
			}
			if (!estatus.equals("empty")) {
				crit.add(Restrictions.eq("estatus", estatus));
			}else {
				crit.add(Restrictions.eq("estatus", "ACT"));
			}
			crit.addOrder(Order.asc("clave")).setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("consulta", crit.list());
			break;

		default:
			break;
		}

		
	}

	@Override
	public void queryFindTiposComprobante(Model model, HttpServletRequest request, Integer comprobante, String evento) {
		if(!evento.equals("new")) {
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaTiposComprobante.class).add(Restrictions.eq("id", comprobante));
			model.addAttribute("editar", crit.list());
		}
		model.addAttribute("event", evento);
	}

	@Override
	public void SaveOrUpdateTiposComprobante(Model model, HttpServletRequest request, Integer comprobantes,
			String clave, String descripcion, Integer minimo, Integer maximo, String evento, String estatus) {
		switch (evento) {
		case "update":
			Query queryUpdate = procesoGeneral.getSession()
					.createSQLQuery("update TBL_SIF_CAT_TIPOS_COMPROBANTE set clave= ?,descripcion= ?,valor_minimo= ?, valor_maximo= ?,estatus= ?,usuario= ?,fecha= sysdate where id=?" );
			queryUpdate.setParameter(0, clave);
			queryUpdate.setParameter(1, descripcion);
			queryUpdate.setParameter(2, minimo);
			queryUpdate.setParameter(3, maximo);
			queryUpdate.setParameter(4, estatus);
			queryUpdate.setParameter(5, procesoGeneral.getSesionActual());
			queryUpdate.setParameter(6, comprobantes);
			queryUpdate.executeUpdate(); 
			break;
		case "insert":
			
			Query queryInsert = procesoGeneral.getSession()
					.createSQLQuery("Insert into TBL_SIF_CAT_TIPOS_COMPROBANTE  values (?,?,?,?,?,'ACT',?,sysdate)");
			queryInsert.setParameter(0, procesoGeneral.getId(TablaTiposComprobante.class, "id"));
			queryInsert.setParameter(1, clave);
			queryInsert.setParameter(2, descripcion);
			queryInsert.setParameter(3, minimo);
			queryInsert.setParameter(4, maximo);
			queryInsert.setParameter(5, procesoGeneral.getSesionActual());
			queryInsert.executeUpdate();
			break;
		case "delete":
				Query delete = procesoGeneral.getSession()
						.createSQLQuery("update TBL_SIF_CAT_TIPOS_COMPROBANTE set estatus='NOA' where id=?");
				delete.setParameter(0, comprobantes);
				delete.executeUpdate();
			break;
		default:
			break;
		}

		
	}

	@Override
	public void queryUsosCfdi(String tipo, Model model, HttpServletRequest request, Integer fromRow, Integer cfdi,
			String estatus) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaUsoCfdi.class);
			if (cfdi != 0) {
				count.add(Restrictions.eq("id", cfdi));
			}
			if (!estatus.equals("empty")) {
				count.add(Restrictions.eq("estatus", estatus));
			}else {
				count.add(Restrictions.eq("estatus", "ACT"));
			}
			count.addOrder(Order.asc("clave"));
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);

			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaUsoCfdi.class);
			if (cfdi != 0) {
				crit.add(Restrictions.eq("id", cfdi));
			}
			if (!estatus.equals("empty")) {
				crit.add(Restrictions.eq("estatus", estatus));
			}else {
				crit.add(Restrictions.eq("estatus", "ACT"));
			}
			crit.addOrder(Order.asc("clave")).setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("consulta", crit.list());
			break;

		default:
			break;
		}

		
	}

	@Override
	public void queryFindUsoCfdi(Model model, HttpServletRequest request, Integer cfdi, String evento) {
		if(!evento.equals("new")) {
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaUsoCfdi.class).add(Restrictions.eq("id", cfdi));
			model.addAttribute("editar", crit.list());
		}
		model.addAttribute("event", evento);
		
	}

	@Override
	public void SaveOrUpdateUsoCfdi(Model model, HttpServletRequest request, Integer cfdi, String clave,
			String descripcion, String fisica, String moral, String evento, String estatus) {
		switch (evento) {
		case "update":
			Query queryUpdate = procesoGeneral.getSession()
					.createSQLQuery("update TBL_SIF_CAT_USOS_CFDI set clave= ?,descripcion= ?,aplica_fisica= ?, aplica_moral= ?,estatus= ?,usuario= ?,fecha= sysdate where id=?" );
			queryUpdate.setParameter(0, clave);
			queryUpdate.setParameter(1, descripcion);
			queryUpdate.setParameter(2, fisica);
			queryUpdate.setParameter(3, moral);
			queryUpdate.setParameter(4, estatus);
			queryUpdate.setParameter(5, procesoGeneral.getSesionActual());
			queryUpdate.setParameter(6, cfdi);
			queryUpdate.executeUpdate(); 
			break;
		case "insert":
			
			Query queryInsert = procesoGeneral.getSession()
					.createSQLQuery("Insert into TBL_SIF_CAT_USOS_CFDI  values (?,?,?,?,?,'ACT',?,sysdate)");
			queryInsert.setParameter(0, procesoGeneral.getId(TablaUsoCfdi.class, "id"));
			queryInsert.setParameter(1, clave);
			queryInsert.setParameter(2, descripcion);
			queryInsert.setParameter(3, fisica);
			queryInsert.setParameter(4, moral);
			queryInsert.setParameter(5, procesoGeneral.getSesionActual());
			queryInsert.executeUpdate();
			break;
		case "delete":
				Query delete = procesoGeneral.getSession()
						.createSQLQuery("update TBL_SIF_CAT_USOS_CFDI set estatus='NOA' where id=?");
				delete.setParameter(0, cfdi);
				delete.executeUpdate();
			break;
		default:
			break;
		}

		
	}

	@Override
	public void queryFormasPago(String tipo, Model model, HttpServletRequest request, Integer fromRow, Integer forma,
			String estatus) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaFormasPago.class);
			if (forma != 0) {
				count.add(Restrictions.eq("id", forma));
			}
			if (!estatus.equals("empty")) {
				count.add(Restrictions.eq("estatus", estatus));
			}else {
				count.add(Restrictions.eq("estatus", "ACT"));
			}
			count.addOrder(Order.asc("clave"));
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);

			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaFormasPago.class);
			if (forma != 0) {
				crit.add(Restrictions.eq("id", forma));
			}
			if (!estatus.equals("empty")) {
				crit.add(Restrictions.eq("estatus", estatus));
			}else {
				crit.add(Restrictions.eq("estatus", "ACT"));
			}
			crit.addOrder(Order.asc("clave")).setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("consulta", crit.list());
			break;

		default:
			break;
		}

		
	}

	@Override
	public void queryFindFormasPago(Model model, HttpServletRequest request, Integer formas, String evento) {
		if(!evento.equals("new")) {
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaFormasPago.class).add(Restrictions.eq("id", formas));
			model.addAttribute("editar", crit.list());
		}
		model.addAttribute("event", evento);
	}

	@Override
	public void SaveOrUpdateFormasPago(Model model, HttpServletRequest request, Integer formas, String clave,
			String descripcion, String bancarizado, String evento, String estatus) {
		switch (evento) {
		case "update":
			Query queryUpdate = procesoGeneral.getSession()
					.createSQLQuery("update TBL_SIF_CAT_FORMAS_PAGO set clave= ?,descripcion= ?,bancarizado= ?,estatus= ?,usuario= ?,fecha= sysdate where id=?" );
			queryUpdate.setParameter(0, clave);
			queryUpdate.setParameter(1, descripcion);
			queryUpdate.setParameter(2, bancarizado);
			queryUpdate.setParameter(3, estatus);
			queryUpdate.setParameter(4, procesoGeneral.getSesionActual());
			queryUpdate.setParameter(5, formas);
			queryUpdate.executeUpdate(); 
			break;
		case "insert":
			
			Query queryInsert = procesoGeneral.getSession()
					.createSQLQuery("Insert into TBL_SIF_CAT_FORMAS_PAGO  values (?,?,?,?,'ACT',?,sysdate)");
			queryInsert.setParameter(0, procesoGeneral.getId(TablaFormasPago.class, "id"));
			queryInsert.setParameter(1, clave);
			queryInsert.setParameter(2, descripcion);
			queryInsert.setParameter(3, bancarizado);
			queryInsert.setParameter(4, procesoGeneral.getSesionActual());
			queryInsert.executeUpdate();
			break;
		case "delete":
				Query delete = procesoGeneral.getSession()
						.createSQLQuery("update TBL_SIF_CAT_FORMAS_PAGO set estatus='NOA' where id=?");
				delete.setParameter(0, formas);
				delete.executeUpdate();
			break;
		default:
			break;
		}

		
	}




	@Override
	public void SaveOrUpdateTiposFactor(Model model, HttpServletRequest request, Integer factor, String clave,
			String descripcion, String estatus,String evento) {
		switch (evento) {
		case "update":
			Query queryUpdate = procesoGeneral.getSession()
					.createSQLQuery("update TBL_SIF_CAT_TIPOS_FACTOR set clave= ?,descripcion= ?,estatus= ?,usuario= ?,fecha= sysdate where id=?" );
			queryUpdate.setParameter(0, clave);
			queryUpdate.setParameter(1, descripcion);
			queryUpdate.setParameter(2, estatus);
			queryUpdate.setParameter(3, procesoGeneral.getSesionActual());
			queryUpdate.setParameter(4, factor);
			queryUpdate.executeUpdate(); 
			break;
		case "insert":
			
			Query queryInsert = procesoGeneral.getSession()
					.createSQLQuery("Insert into TBL_SIF_CAT_TIPOS_FACTOR  values (?,?,?,'ACT',?,sysdate)");
			queryInsert.setParameter(0, procesoGeneral.getId(TablaTipoFactor.class, "id"));
			queryInsert.setParameter(1, clave);
			queryInsert.setParameter(2, descripcion);
			queryInsert.setParameter(3, procesoGeneral.getSesionActual());
			queryInsert.executeUpdate();
			break;
		case "delete":
				Query delete = procesoGeneral.getSession()
						.createSQLQuery("update TBL_SIF_CAT_TIPOS_FACTOR set estatus='NOA' where id=?");
				delete.setParameter(0, factor);
				delete.executeUpdate();
			break;
		default:
			break;
		}

		
	}

	@Override
	public void queryFindTipoFactor(Model model, HttpServletRequest request, Integer factor, String evento) {
		
		if(!evento.equals("new")) {
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaTipoFactor.class).add(Restrictions.eq("id", factor));
			model.addAttribute("editar", crit.list());
		}
		model.addAttribute("event", evento);
		
	}
	@Override
	public void queryTiposFactor(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			Integer factor, String estatus) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaTipoFactor.class);
			if (factor != 0) {
				count.add(Restrictions.eq("id", factor));
			}
			if (!estatus.equals("empty")) {
				count.add(Restrictions.eq("estatus", estatus));
			}else {
				count.add(Restrictions.eq("estatus", "ACT"));
			}
			count.addOrder(Order.asc("clave"));
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);

			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaTipoFactor.class);
			if (factor != 0) {
				crit.add(Restrictions.eq("id", factor));
			}
			if (!estatus.equals("empty")) {
				crit.add(Restrictions.eq("estatus", estatus));
			}else {
				crit.add(Restrictions.eq("estatus", "ACT"));
			}
			crit.addOrder(Order.asc("clave")).setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("consulta", crit.list());
			break;

		default:
			break;
		}


	}

	@Override
	public void queryTasasCuota(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			Integer tasascuota, String estatus) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaTasaCuota.class);
			if (tasascuota != 0) {
				count.add(Restrictions.eq("id", tasascuota));
			}
			if (!estatus.equals("empty")) {
				count.add(Restrictions.eq("estatus", estatus));
			}else {
				count.add(Restrictions.eq("estatus", "ACT"));
			}
			count.addOrder(Order.asc("clave"));
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);

			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaTasaCuota.class);
			if (tasascuota != 0) {
				crit.add(Restrictions.eq("id", tasascuota));
			}
			if (!estatus.equals("empty")) {
				crit.add(Restrictions.eq("estatus", estatus));
			}else {
				crit.add(Restrictions.eq("estatus", "ACT"));
			}
			crit.addOrder(Order.asc("clave")).setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("consulta", crit.list());
			break;

		default:
			break;
		}
		
	}

	@Override
	public void queryFindTasasCuotas(Model model, HttpServletRequest request, Integer tasascuota, String evento) {
		
		if(!evento.equals("new")) {
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaTasaCuota.class).add(Restrictions.eq("id", tasascuota));
			model.addAttribute("editar", crit.list());
		}
		model.addAttribute("event", evento);
		
	}

	@Override
	public void SaveOrUpdateTasascuota(Model model, HttpServletRequest request, Integer tasascuota, String clave,
			String descripcion, String valorminimo, String valormaximo, String estatus, String evento) {
		switch (evento) {
		case "update":
			Query queryUpdate = procesoGeneral.getSession()
					.createSQLQuery("update TBL_SIF_CAT_TASAS_CUOTAS set clave= ?,descripcion= ?,valor_minimo= ?,valor_maximo= ?,estatus= ?,usuario= ?,fecha= sysdate where id=?" );
			queryUpdate.setParameter(0, clave);
			queryUpdate.setParameter(1, descripcion);
			queryUpdate.setParameter(2, valorminimo);
			queryUpdate.setParameter(3, valormaximo);
			queryUpdate.setParameter(4, estatus);
			queryUpdate.setParameter(5, procesoGeneral.getSesionActual());
			queryUpdate.setParameter(6, tasascuota);
			queryUpdate.executeUpdate(); 
			break;
		case "insert":
			
			Query queryInsert = procesoGeneral.getSession()
					.createSQLQuery("Insert into TBL_SIF_CAT_TASAS_CUOTAS  values (?,?,?,?,?,'ACT',?,sysdate)");
			queryInsert.setParameter(0, procesoGeneral.getId(TablaTasaCuota.class, "id"));
			queryInsert.setParameter(1, clave);
			queryInsert.setParameter(2, descripcion);
			queryInsert.setParameter(3, valorminimo);
			queryInsert.setParameter(4, valormaximo);
			queryInsert.setParameter(5, procesoGeneral.getSesionActual());
			queryInsert.executeUpdate();
			break;
		case "delete":
				Query delete = procesoGeneral.getSession()
						.createSQLQuery("update TBL_SIF_CAT_TASAS_CUOTAS set estatus='NOA' where id=?");
				delete.setParameter(0, tasascuota);
				delete.executeUpdate();
			break;
		default:
			break;
		}

		
	}

	@Override
	public void queryMetodosPagos(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			Integer metodos, String estatus) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaMetodoPago.class);
			if (metodos != 0) {
				count.add(Restrictions.eq("id", metodos));
			}
			if (!estatus.equals("empty")) {
				count.add(Restrictions.eq("estatus", estatus));
			}else {
				count.add(Restrictions.eq("estatus", "ACT"));
			}
			count.addOrder(Order.asc("clave"));
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);

			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaMetodoPago.class);
			if (metodos != 0) {
				crit.add(Restrictions.eq("id", metodos));
			}
			if (!estatus.equals("empty")) {
				crit.add(Restrictions.eq("estatus", estatus));
			}else {
				crit.add(Restrictions.eq("estatus", "ACT"));
			}
			crit.addOrder(Order.asc("clave")).setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("consulta", crit.list());
			break;

		default:
			break;
		}
		
	}

	@Override
	public void queryFindMetodosPago(Model model, HttpServletRequest request, Integer metodos, String evento) {
		if(!evento.equals("new")) {
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaMetodoPago.class).add(Restrictions.eq("id", metodos));
			model.addAttribute("editar", crit.list());
		}
		model.addAttribute("event", evento);
		
	}

	@Override
	public void SaveOrUpdateMetodosPago(Model model, HttpServletRequest request, Integer metodos, String clave,
			String descripcion, String evento, String estatus) {
		switch (evento) {
		case "update":
			Query queryUpdate = procesoGeneral.getSession()
					.createSQLQuery("update TBL_SIF_CAT_METODOS_PAGO set clave= ?,descripcion= ?,estatus= ?,usuario= ?,fecha=sysdate where id=?" );
			queryUpdate.setParameter(0, clave);
			queryUpdate.setParameter(1, descripcion);
			queryUpdate.setParameter(2, estatus);
			queryUpdate.setParameter(3, procesoGeneral.getSesionActual());
			queryUpdate.setParameter(4,metodos);
			queryUpdate.executeUpdate(); 
			break;
		case "insert":
			
			Query queryInsert = procesoGeneral.getSession()
					.createSQLQuery("Insert into TBL_SIF_CAT_METODOS_PAGO  values (?,?,?,'ACT',?,sysdate)");
			queryInsert.setParameter(0, procesoGeneral.getId(TablaMetodoPago.class, "id"));
			queryInsert.setParameter(1, clave);
			queryInsert.setParameter(2, descripcion);
			queryInsert.setParameter(3,procesoGeneral.getSesionActual());
			queryInsert.executeUpdate();
			break;
		case "delete":
				Query delete = procesoGeneral.getSession()
						.createSQLQuery("update TBL_SIF_CAT_METODOS_PAGO set estatus='NOA' where id=?");
				delete.setParameter(0, metodos);
				delete.executeUpdate();
			break;
		default:
			break;
		}
		
	}

	@Override
	public void SaveOrUpdateTiposImpuesto(Model model, HttpServletRequest request, Integer impuesto, String clave,
			String tras, String estatus, String tipoentidad, String descripcion, String reten, String entidad,
			String evento) {

switch (evento) {
case "update":
	Query queryUpdate = procesoGeneral.getSession()
			.createSQLQuery("update TBL_SIF_CAT_TIPOS_IMPUESTO set clave= ?,descripcion= ?,retencion= ?, traslado= ?,estatus= ?,usuario= ?,fecha= sysdate,tipo_entidad= ?,nombre_entidad= ? where id=?" );
	queryUpdate.setParameter(0, clave);
	queryUpdate.setParameter(1, descripcion);
	queryUpdate.setParameter(2, reten);
	queryUpdate.setParameter(3, tras);
	queryUpdate.setParameter(4, estatus);
	queryUpdate.setParameter(5, procesoGeneral.getSesionActual());
	queryUpdate.setParameter(6, tipoentidad);
	queryUpdate.setParameter(7, entidad);
	queryUpdate.setParameter(8, impuesto);
	queryUpdate.executeUpdate(); 
	break;
case "insert":
	
	Query queryInsert = procesoGeneral.getSession()
			.createSQLQuery("Insert into TBL_SIF_CAT_TIPOS_IMPUESTO  values (?,?,?,?,?,'ACT',?,sysdate,?,?)");
	queryInsert.setParameter(0, procesoGeneral.getId(TablaTipoImpuesto.class, "id"));
	queryInsert.setParameter(1, clave);
	queryInsert.setParameter(2, descripcion);
	queryInsert.setParameter(3, reten);
	queryInsert.setParameter(4, tras);
	queryInsert.setParameter(5, procesoGeneral.getSesionActual());
	queryInsert.setParameter(6, tipoentidad);
	queryInsert.setParameter(7, entidad);
	queryInsert.executeUpdate();
	break;
case "delete":
		Query delete = procesoGeneral.getSession()
				.createSQLQuery("update TBL_SIF_CAT_TIPOS_IMPUESTO set estatus='NOA' where id=?");
		delete.setParameter(0, impuesto);
		delete.executeUpdate();
	break;
default:
	break;
}


}

	@Override
	public void queryCertificado(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			Integer certificado, String estatus) {
		switch (tipo) {
		case "count":
			String consulta = "select a.id as \"id\",b.razon_social as \"razon_social\",a.cert_publico as \"cert_publico\",a.cert_privado as \"cert_privado\",a.descripcion as \"descripcion\",a.estatus as \"estatus\",a.usuario as \"usuario\",a.fecha as \"fecha\",a.cert_ruta as \"cert_ruta\" from TBL_SIF_CAT_CERTIFICADOS a, TBL_SIF_CAT_EMPRESAS b where a.id_empresa=b.id_empresa and a.estatus =decode(:estatus,'empty','ACT',:estatus) and a.id=decode(:certificado,0,a.id,:certificado)";
			Query count = procesoGeneral.getSession().createSQLQuery(consulta);
			count.setParameter("estatus", estatus);
			count.setParameter("certificado", certificado);
			model.addAttribute("registros_totales", count.list().size());
			break;
		case "consulta":
			consulta = "select a.id as \"id\",b.razon_social as \"razon_social\",a.cert_publico as \"cert_publico\",a.cert_privado as \"cert_privado\",a.descripcion as \"descripcion\",a.estatus as \"estatus\",a.usuario as \"usuario\",a.fecha as \"fecha\",a.cert_ruta as \"cert_ruta\" from TBL_SIF_CAT_CERTIFICADOS a, TBL_SIF_CAT_EMPRESAS b where a.id_empresa=b.id_empresa and a.estatus =decode(:estatus,'empty','ACT',:estatus) and a.id=decode(:certificado,0,a.id,:certificado)";
			consulta = consulta.concat(" OFFSET  :fromRow ROWS FETCH NEXT 15 ROWS ONLY");
			Query query = procesoGeneral.getSession().createSQLQuery(consulta).setResultTransformer(Transformers.aliasToBean(BeanCertificados.class));
			query.setParameter("estatus", estatus);
			query.setParameter("certificado", certificado);
			query.setParameter("fromRow", fromRow);
			model.addAttribute("consulta", query.list());
			
			break;

		default:
			break;

		}
	}

	@Override
	public void queryFindCertificados(Model model, HttpServletRequest request, Integer certificado, String evento) {
		if(!evento.equals("new")) {
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaCertificados.class).add(Restrictions.eq("id", certificado));
			model.addAttribute("editar", crit.list());
		}
		model.addAttribute("event", evento);
	}
	
	@Override
	public void queryTiposRelacion(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			Integer metodos, String estatus) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaTiposRelacion.class);
			if (metodos != 0) {
				count.add(Restrictions.eq("id", metodos));
			}
			if (!estatus.equals("empty")) {
				count.add(Restrictions.eq("estatus", estatus));
			}else {
				count.add(Restrictions.eq("estatus", "ACT"));
			}
			count.addOrder(Order.asc("clave"));
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);

			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaTiposRelacion.class);
			if (metodos != 0) {
				crit.add(Restrictions.eq("id", metodos));
			}
			if (!estatus.equals("empty")) {
				crit.add(Restrictions.eq("estatus", estatus));
			}else {
				crit.add(Restrictions.eq("estatus", "ACT"));
			}
			crit.addOrder(Order.asc("clave")).setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("consulta", crit.list());
			break;

		default:
			break;
		}
		
	}

	@Override
	public void SaveOrUpdateCertificado(Model model, HttpServletRequest request, Integer certificado,
			String cert_privado, String cert_publico, String descripcion, String estatus, String id_empresa,
			String cert_ruta, String evento) {
		switch (evento) {
	
		case "update":
			Query queryUpdate = procesoGeneral.getSession()
					.createSQLQuery("update TBL_SIF_CAT_CERTIFICADOS set cert_privado= ?,cert_publico= ?,descripcion= ?, estatus= ?,usuario= ?,fecha= sysdate,id_empresa= ?,cert_ruta= ? where id=?" );
			queryUpdate.setParameter(0, cert_privado);
			queryUpdate.setParameter(1, cert_publico);
			queryUpdate.setParameter(2, descripcion);
			queryUpdate.setParameter(3, estatus);
			queryUpdate.setParameter(4, procesoGeneral.getSesionActual());
			queryUpdate.setParameter(5, id_empresa);
			queryUpdate.setParameter(6, cert_ruta);
			queryUpdate.setParameter(7, certificado);
			queryUpdate.executeUpdate(); 
			break;
		case "insert":
			
			Query queryInsert = procesoGeneral.getSession()
			.createSQLQuery("Insert into TBL_SIF_CAT_CERTIFICADOS  values (?,?,?,?,'ACT',?,sysdate,?,?)");
			queryInsert.setParameter(0, procesoGeneral.getId(TablaCertificados.class, "id"));
			queryInsert.setParameter(1, cert_privado);
			queryInsert.setParameter(2, cert_publico);
			queryInsert.setParameter(3, descripcion);
			queryInsert.setParameter(4, estatus);
			queryInsert.setParameter(5, procesoGeneral.getSesionActual());
			queryInsert.setParameter(6, id_empresa);
			queryInsert.setParameter(7, cert_ruta);
			queryInsert.executeUpdate();
			break;
		case "delete":
				Query delete = procesoGeneral.getSession()
						.createSQLQuery("update TBL_SIF_CAT_CERTIFICADOS set estatus='NOA' where id=?");
				delete.setParameter(0, certificado);
				delete.executeUpdate();
			break;
		default:
			break;
		}

	}

	@Override
	public void queryFindTiposRelacion(Model model, HttpServletRequest request, Integer metodos, String evento) {
		if(!evento.equals("new")) {
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaTiposRelacion.class).add(Restrictions.eq("id", metodos));
			model.addAttribute("editar", crit.list());
		}
		model.addAttribute("event", evento);
		
		}
	

	@Override
	public void SaveOrUpdateTiposRelacion(Model model, HttpServletRequest request, Integer metodos, String clave,
			String descripcion, String evento, String estatus) {
		switch (evento) {
		case "update":
			Query queryUpdate = procesoGeneral.getSession()
					.createSQLQuery("update TBL_SIF_CAT_TIPOS_RELACION set clave= ?,descripcion= ?,estatus= ?,usuario= ?,fecha=sysdate where id=?" );
			queryUpdate.setParameter(0, clave);
			queryUpdate.setParameter(1, descripcion);
			queryUpdate.setParameter(2, estatus);
			queryUpdate.setParameter(3, procesoGeneral.getSesionActual());
			queryUpdate.setParameter(4,metodos);
			queryUpdate.executeUpdate(); 
			break;
		case "insert":
			
			Query queryInsert = procesoGeneral.getSession()
					.createSQLQuery("Insert into TBL_SIF_CAT_TIPOS_RELACION values (?,?,?,'ACT',?,sysdate)");
			queryInsert.setParameter(0, procesoGeneral.getId(TablaTiposRelacion.class, "id"));
			queryInsert.setParameter(1, clave);
			queryInsert.setParameter(2, descripcion);
			queryInsert.setParameter(3,procesoGeneral.getSesionActual());
			queryInsert.executeUpdate();
			break;
		case "delete":
				Query delete = procesoGeneral.getSession()
						.createSQLQuery("update TBL_SIF_CAT_TIPOS_RELACION set estatus='NOA' where id=?");
				delete.setParameter(0, metodos);
				delete.executeUpdate();
			break;
		default:
			break;
		}
		
	}

	@Override
	public void queryClavesServicio(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			Integer metodos, String estatus) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaClaveServicio.class);
			if (metodos != 0) {
				count.add(Restrictions.eq("id", metodos));
			}
			if (!estatus.equals("empty")) {
				count.add(Restrictions.eq("estatus", estatus));
			}else {
				count.add(Restrictions.eq("estatus", "ACT"));
			}
			count.addOrder(Order.asc("clave"));
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);

			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaClaveServicio.class);
			if (metodos != 0) {
				crit.add(Restrictions.eq("id", metodos));
			}
			if (!estatus.equals("empty")) {
				crit.add(Restrictions.eq("estatus", estatus));
			}else {
				crit.add(Restrictions.eq("estatus", "ACT"));
			}
			crit.addOrder(Order.asc("clave")).setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("consulta", crit.list());
			break;

		default:
			break;
		}
		
	}

	@Override
	public void queryFindClavesServicio(Model model, HttpServletRequest request, Integer metodos, String evento) {
		if(!evento.equals("new")) {
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaClaveServicio.class).add(Restrictions.eq("id", metodos));
			model.addAttribute("editar", crit.list());
		}
		model.addAttribute("event", evento);
		
	}

	@Override
	public void SaveOrUpdateClavesServicio(Model model, HttpServletRequest request, Integer metodos, String clave,
			String descripcion, String iva_traslado, String ieps_traslado, String evento, String estatus) {
		switch (evento) {
		case "update":
			Query queryUpdate = procesoGeneral.getSession()
					.createSQLQuery("update TBL_SIF_CAT_CLAVES_SERVICIO set clave= ?,descripcion= ?,iva_traslado=?,ieps_traslado=?,estatus= ?,usuario= ?,fecha=sysdate where id=?" );
			queryUpdate.setParameter(0, clave);
			queryUpdate.setParameter(1, descripcion);
			queryUpdate.setParameter(2, iva_traslado);
			queryUpdate.setParameter(3, ieps_traslado);
			queryUpdate.setParameter(4, estatus);
			queryUpdate.setParameter(5, procesoGeneral.getSesionActual());
			queryUpdate.setParameter(6,metodos);
			queryUpdate.executeUpdate(); 
			break;
		case "insert":
			
			Query queryInsert = procesoGeneral.getSession()
					.createSQLQuery("Insert into TBL_SIF_CAT_CLAVES_SERVICIO values (?,?,?,?,?,'ACT',?,sysdate)");
			queryInsert.setParameter(0, procesoGeneral.getId(TablaClaveServicio.class, "id"));
			queryInsert.setParameter(1, clave);
			queryInsert.setParameter(2, descripcion);
			queryInsert.setParameter(3, iva_traslado);
			queryInsert.setParameter(4, ieps_traslado);
			queryInsert.setParameter(5,procesoGeneral.getSesionActual());
			queryInsert.executeUpdate();
			break;
		case "delete":
				Query delete = procesoGeneral.getSession()
						.createSQLQuery("update TBL_SIF_CAT_CLAVES_SERVICIO set estatus='NOA' where id=?");
				delete.setParameter(0, metodos);
				delete.executeUpdate();
			break;
		default:
			break;
		}
		
	}

	@Override
	public void queryClavesUnidad(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			Integer metodos, String estatus) {
		switch (tipo) {
		case "count":
			Criteria count = procesoGeneral.getSession().createCriteria(TablaClaveUnidad.class);
			if (metodos != 0) {
				count.add(Restrictions.eq("id", metodos));
			}
			if (!estatus.equals("empty")) {
				count.add(Restrictions.eq("estatus", estatus));
			}else {
				count.add(Restrictions.eq("estatus", "ACT"));
			}
			count.addOrder(Order.asc("clave"));
			Integer registrosTotales = count.setProjection(Projections.rowCount()).uniqueResult().hashCode();
			model.addAttribute("registros_totales", registrosTotales);

			break;
		case "consulta":
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaClaveUnidad.class);
			if (metodos != 0) {
				crit.add(Restrictions.eq("id", metodos));
			}
			if (!estatus.equals("empty")) {
				crit.add(Restrictions.eq("estatus", estatus));
			}else {
				crit.add(Restrictions.eq("estatus", "ACT"));
			}
			crit.addOrder(Order.asc("clave")).setFirstResult(fromRow).setMaxResults(15);
			model.addAttribute("consulta", crit.list());
			break;

		default:
			break;
		}
		
	}

	@Override
	public void queryFindClavesUnidad(Model model, HttpServletRequest request, Integer metodos, String evento) {
		if(!evento.equals("new")) {
			Criteria crit = procesoGeneral.getSession().createCriteria(TablaClaveUnidad.class).add(Restrictions.eq("id", metodos));
			model.addAttribute("editar", crit.list());
		}
		model.addAttribute("event", evento);
		
		
	}

	@Override
	public void SaveOrUpdateClavesUnidad(Model model, HttpServletRequest request, Integer metodos, String clave,
			String descripcion, String simbolo, String evento, String estatus) {
		switch (evento) {
		case "update":
			Query queryUpdate = procesoGeneral.getSession()
					.createSQLQuery("update TBL_SIF_CAT_CLAVES_UNIDAD set clave= ?,descripcion= ?,simbolo=?,estatus= ?,usuario= ?,fecha=sysdate where id=?" );
			queryUpdate.setParameter(0, clave);
			queryUpdate.setParameter(1, descripcion);
			queryUpdate.setParameter(2, simbolo);
			queryUpdate.setParameter(3, estatus);
			queryUpdate.setParameter(4, procesoGeneral.getSesionActual());
			queryUpdate.setParameter(5,metodos);
			queryUpdate.executeUpdate(); 
			break;
		case "insert":
			
			Query queryInsert = procesoGeneral.getSession()
					.createSQLQuery("Insert into TBL_SIF_CAT_CLAVES_UNIDAD values (?,?,?,?,'ACT',?,sysdate)");
			queryInsert.setParameter(0, procesoGeneral.getId(TablaClaveUnidad.class, "id"));
			queryInsert.setParameter(1, clave);
			queryInsert.setParameter(2, descripcion);
			queryInsert.setParameter(3, simbolo);
			queryInsert.setParameter(4,procesoGeneral.getSesionActual());
			queryInsert.executeUpdate();
			break;
		case "delete":
				Query delete = procesoGeneral.getSession()
						.createSQLQuery("update TBL_SIF_CAT_CLAVES_UNIDAD set estatus='NOA' where id=?");
				delete.setParameter(0, metodos);
				delete.executeUpdate();
			break;
		default:
			break;
		}
		
		
	}
		
		
	}

