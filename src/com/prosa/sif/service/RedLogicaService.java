/**
################################################################################
# Autor               : Garnica                                                #
# Compania            : Código Geek                                            #
# Proyecto/Procliente : Red Logica Service                   Fecha: 08/03/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/
package com.prosa.sif.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.prosa.sif.dao.RedLogicaDao;
import com.prosa.sif.pojo.TablaRedLogica;
/**
 * 
 * @author David Garnica Garcia
 *
 */
@Service
public class RedLogicaService {
	@Autowired
	private RedLogicaDao redLogicaDao;

	public void queryRedLogica(String tipo, Model model, HttpServletRequest request, Integer fromRow, String clave,
			String estatus) {
		redLogicaDao.queryRedLogica(tipo, model, request, fromRow, clave, estatus);
	}

	public void queryFindRedLogica(Model model, String clave) {
		redLogicaDao.queryFindRedLogica(model,clave);
	}

	public void saveOrUpdateRedesLogicas(HttpServletRequest request, String evento, TablaRedLogica insert, String fecha_crea, String descripcion,
			String usuario, String estatus, String clave) {
		redLogicaDao.saveOrUpdateRedesLogicas(request, evento,insert,fecha_crea, descripcion,
				 usuario, estatus, clave);
	}

	public void queryRedLogicaService(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			String clave) {
		redLogicaDao.queryRedLogicaService(tipo,model,request, fromRow, clave);
	}

	public void ConfirmarService(Model model, HttpServletRequest request, Integer fromRow, String values) {
		redLogicaDao.ConfirmarService(model,request,fromRow,values);
	}

	public void listaServicio(Model model,int clave, String estatus) {
		redLogicaDao.listaServicio(model, clave, estatus);
		
	}

	public void Agregarservicio(Model model, HttpServletRequest request, String id_servicio) {
		redLogicaDao.Agregarservicio(model,request, id_servicio);
		
	}
}
