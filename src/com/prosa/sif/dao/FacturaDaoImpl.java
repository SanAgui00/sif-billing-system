/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 03/07/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.dao;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.prosa.sif.operation.ProcesoGeneral;

@Repository
@Transactional
@SuppressWarnings("all")
public class FacturaDaoImpl implements FacturaDao {
	@Autowired
	private ProcesoGeneral procesoGeneral;

	@Override
	public void queryFacturas(Model model, HttpServletRequest request, String fecha_final) {
		Query query = procesoGeneral.getSession()
				.createSQLQuery("select * from tbl_sif_servicios_facturar where fecha_datos=to_date(?,'yyyy-mm-dd')");
		query.setParameter(0, fecha_final);
		query.executeUpdate();
	}

}
