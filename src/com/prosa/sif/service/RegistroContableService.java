/**
################################################################################
# Autor               : Garnica                                                #
# Compania            : Código Geek                                            #
# Proyecto/Procliente : Service de registo contable          Fecha: 08/03/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/
package com.prosa.sif.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.prosa.sif.dao.RegistroContableDao;
/**
 * 
 * @author David Garnica Garcia
 *
 */
@Service
public class RegistroContableService {
	@Autowired
	private RegistroContableDao registroContableDao;

	public void queryRegistroContable(String tipo,Model model, Integer fromRow, Integer proceso, Integer negocio,
			String fecha_inicial, String fecha_final) {
		registroContableDao.queryRegistroContable(tipo,model,fromRow,proceso,negocio,fecha_inicial,fecha_final);
		
	}

	public void queryGenerarRegistro(Model model, Integer fromRow, String values, HttpServletRequest request) {
		registroContableDao.queryGenerarRegistro(model, fromRow, values,request);
		
	}

	public void queryPolizasContables(String tipo, Model model, Integer fromRow, Integer id_modelo_poliza) {
		registroContableDao.queryPolizasContables(tipo,model,fromRow,id_modelo_poliza);
	}

	public void queryFindPolizaContable(Model model, Integer clave, String event, HttpServletRequest request, HttpServletResponse response) {
		registroContableDao.queryFindPolizaContable(model,clave,event,request,response);
	}

	public void saveOrUpdatePolizaContable(HttpServletRequest request, Model model, String event, String clavePoliza, String tipopoli,
			String descripcionPoli, String checkval, Integer id_modelo_poliza) {
		registroContableDao.saveOrUpdatePolizaContable(request,model,event,clavePoliza,tipopoli,descripcionPoli,checkval,id_modelo_poliza);
	}

	public void queryMantenerRegistro(String tipo, Model model, Integer fromRow, Integer cliente, Integer proceso,
			Integer negocio, String fecha_inicial, String fecha_final, String document, String estatus,
			String id_moneda) {
		registroContableDao.queryMantenerRegistro( tipo,model,fromRow,cliente,proceso,negocio,fecha_inicial,fecha_final,document,estatus,id_moneda);
	}

	public void queryAsignarPolizasNegocios(Model model, Integer id_negocio) {
		registroContableDao.queryAsignarPolizasNegocios(model,id_negocio);
	}

	public void SaveorUpdateAsignarPolizasNegocios(HttpServletRequest request, Model model, String values) {
		registroContableDao.SaveorUpdateAsignarPolizasNegocios(request, model,values);
	}

	public void queryFindRegistroPoliza(Model model, Integer clave, String event, HttpServletRequest request,
			HttpServletResponse response) {
		registroContableDao.queryFindRegistroPoliza(model,clave,event,request,response);
	}

	public void SaveorDeleteRegistroPoliza(Model model, Integer clave, String event, HttpServletRequest request,
			HttpServletResponse response, String checkval) {
		registroContableDao.SaveorDeleteRegistroPoliza(model,clave,event,request,response,checkval);
	}

	public void SaveorDeleteMantenerRegistro(Model model, HttpServletRequest request, HttpServletResponse response,
			String datos, String opcion) {
		registroContableDao.SaveorDeleteMantenerRegistro(model,request,response,datos,opcion);
	}

	public void queryenvelirev(Model model, String fecha_inicial, String fecha_final) {
		registroContableDao.queryenvelirev(model,fecha_inicial,fecha_final);
	}

}
