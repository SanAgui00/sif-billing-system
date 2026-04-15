/**
################################################################################
# Autor               : David Garnica                                          #
# Compania            : Código Geek                                            #
# Proyecto/Procliente : Controller de Estado de Cuenta       Fecha: 02/08/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prosa.sif.operation.ProcesoGeneral;
import com.prosa.sif.pojo.TablaEstiloCarta;

@Transactional
@Repository
@SuppressWarnings("all")
public class ImpresionDaoImpl implements ImpresionDao {
	@Autowired
	private ProcesoGeneral procesoGeneral;

	@Override
	public List<TablaEstiloCarta> findAll_TBL_SIF_ESTILO_CARTA() {
		
		Criteria cr = procesoGeneral.getSession().createCriteria(TablaEstiloCarta.class)
				.add(Restrictions.eq("estatus", "ACT")).add(Restrictions.like("parrafo3", "%No de Cuenta%"))
				.add(Restrictions.ne("clave", "CAT_SAN"));
		return cr.list();
	}

	@Override
	public List<TablaEstiloCarta> findById_TBL_SIF_ESTILO_CARTA(int id) {
		Criteria cr = procesoGeneral.getSession().createCriteria(TablaEstiloCarta.class)
				.add(Restrictions.eq("id_estilo", id));
		return cr.list();
	}

	public int getId(String table, String id) {
		int max_id = 0;
		Iterator<Integer> iterator1 = procesoGeneral.getSession()
				.createQuery("select nvl(max(" + id + ")+1, 0) as max_val  from " + table).iterate();

		while (iterator1.hasNext()) {
			max_id = (int) iterator1.next();
		}

		return max_id;
	}

	@Override
	public void ImpresionesDaoImpl(String event, int id, String status, String cuenta, String clave, String descripcion,
			String autor, String cuenta1) {
		// TODO Auto-generated method stub

		switch (event) {
		case "update":
			Query query1 = procesoGeneral.getSession().createQuery("update TablaEstiloCarta set parrafo3='" + cuenta
					+ "',estatus='" + status + "' where id_estilo=" + id);
			query1.executeUpdate();

			break;
		case "insert":
			int idmax = this.getId("TablaEstiloCarta", "id_estilo");
			Query query2 = procesoGeneral.getSession()
					.createSQLQuery("insert into TablaEstiloCarta (id_estilo,clave,descripcion,"
							+ "usuario,parrafo3,estatus) values (" + idmax + ",'" + clave.toUpperCase() + "','"
							+ descripcion + "','" + autor + "','" + cuenta1 + "','ACT')");
			query2.executeUpdate();

			break;

		default:
			break;
		}

	}

}
