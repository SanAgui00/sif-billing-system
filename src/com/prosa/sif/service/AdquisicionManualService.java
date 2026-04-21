/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente : D-52-8268-17                         Fecha: 01/06/2018 #
# Descripcion General : Servicio para adquisiciones manuales			       #
# Marca del cambio    : LOGASIF									               #
################################################################################
**/
package com.prosa.sif.service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.prosa.sif.dao.AdquisicionManualDao;

@Service
public class AdquisicionManualService {
	@Autowired
	private AdquisicionManualDao adquisicionManualDao;

	public void queryHistorico(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			String fecha_inicial, String fecha_final, String usuario, Integer id_fuente) {
		adquisicionManualDao.queryHistorico(tipo, model, request, fromRow, fecha_inicial, fecha_final, usuario,
				id_fuente);
	}

	public void queryVerificar(String tipo, Model model, HttpServletRequest request, Integer id_periodo,
			Integer id_servicio, Integer fromRow) {
		adquisicionManualDao.queryVerificar(tipo, model, request, id_periodo, id_servicio, fromRow);
	}

	public void querySolicitud(String tipo, Model model, HttpServletRequest request, Integer id_servicio) {
		adquisicionManualDao.querySolicitud(tipo, model, request, id_servicio);
	}

	public void enviarSolicitud(Model model, HttpServletRequest request, Integer id_moneda, String tipo_cargo, String datos, 
			String subconceptos, Integer id_servicio, Date fecha_datos, Date fechaSol,
			String fecha_operativa, String uMedida, Integer conceptos, String comentarios) {
		adquisicionManualDao.enviarSolicitud(model, request, id_moneda, tipo_cargo, datos, subconceptos, id_servicio, 
				fecha_datos, fechaSol, fecha_operativa, uMedida, conceptos, comentarios);
		
	}
}