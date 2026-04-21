/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente : D-52-8268-17                         Fecha: 01/06/2018 #
# Descripcion General : Interfaz para adquisiciones manuales			       #
# Marca del cambio    : LOGASIF									               #
################################################################################
**/
package com.prosa.sif.dao;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface AdquisicionManualDao {

	void queryHistorico(String tipo, Model model, HttpServletRequest request, Integer fromRow, String fecha_inicial,
			String fecha_final, String usuario, Integer id_fuente);

	void queryVerificar(String tipo, Model model, HttpServletRequest request, Integer id_periodo, Integer id_servicio,
			Integer fromRow);

	void querySolicitud(String tipo, Model model, HttpServletRequest request, Integer id_servicio);

	void enviarSolicitud(Model model, HttpServletRequest request, Integer id_moneda, String tipo_cargo, String datos,
			String subconceptos, Integer id_servicio, Date fecha_datos, Date fechaSol, String fecha_operativa,
			String uMedida, Integer conceptos, String comentarios);

}
