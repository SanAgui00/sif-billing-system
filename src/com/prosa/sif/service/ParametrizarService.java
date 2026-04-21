package com.prosa.sif.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.prosa.sif.dao.ParametrizarDao;

@Service
public class ParametrizarService {
	@Autowired
	private ParametrizarDao parametrizarDao;

	public void queryContingencia(String tipo, Model model, HttpServletRequest request, Integer id_fuente,
			String fecha_datos, String fecha_datos_final) {
		parametrizarDao.queryContingencia(tipo, model, request, id_fuente, fecha_datos, fecha_datos_final);
	}

	public void crudContingencia(String event, Model model, HttpServletRequest request, Integer id_fuente,
			String fecha_datos, String fecha_datos_final) {
		parametrizarDao.crudContingencia(event, model, request, id_fuente, fecha_datos, fecha_datos_final);

	}

	public void queryReglaCarga(String tipo, Model model, HttpServletRequest request, Integer id_reglas_carga,
			Integer fromRow) {
		parametrizarDao.queryReglaCarga(tipo, model, request, id_reglas_carga, fromRow);
	}

	public void crudCargaDato(Model model, HttpServletRequest request, String evento, Integer id_reglas_carga,
			Integer id_fuente, String tabla_temporal, String fecha_mod, String usuario, String estatus,
			String comentarios, String sentencia, String fecha_creacion, String fecha_mod_old) {
		parametrizarDao.crudCargaDato(model, request, evento, id_reglas_carga, id_fuente, tabla_temporal, fecha_mod,
				usuario, estatus, comentarios, sentencia, fecha_creacion, fecha_mod_old);
	}

	public void queryReglaConversion(String tipo, Model model, HttpServletRequest request, Integer regla_conv_id,
			Integer fuente, String estatus) {
		parametrizarDao.queryReglaConversion(tipo, model, request, regla_conv_id, fuente, estatus);
	}

	public void crudConversionDato(Model model, HttpServletRequest request, Integer regla_conv_id, Integer id_fuente,
			Integer id_servicio, String fecha_mod, String usuario, String estatus, String comentarios, String sentencia,
			String evento) {
		parametrizarDao.crudConversionDato(model, request, regla_conv_id, id_fuente, id_servicio, fecha_mod, usuario,
				estatus, comentarios, sentencia, evento);
	}

	public void queryEstructuraDato(String tipo, Integer id_fuente, String estatus, Model model,
			HttpServletRequest request) {
		parametrizarDao.queryEstructuraDato(tipo, id_fuente, estatus, model, request);
	}

	public void crudEstructuraDato(Model model, HttpServletRequest request, String evento, Integer id_estructura,
			Integer id_fuente, String tabla_temporal, String tabla_totales, String estatus,
			Integer b_suspender_depuracion, Integer b_no_hay_carga, String nombre_campo_cliente,
			String nombre_campo_cliente_adq, String fecha_creacion, String fecha_mod, String usuario,
			String comentarios) {
		parametrizarDao.crudEstructuraDato(model, request, evento, id_estructura, id_fuente, tabla_temporal,
				tabla_totales, estatus, b_suspender_depuracion, b_no_hay_carga, nombre_campo_cliente,
				nombre_campo_cliente_adq, fecha_creacion, fecha_mod, usuario, comentarios);
	}

	public void queryTest(Model model, String sentencia) {
		parametrizarDao.queryTest(model,sentencia);
	}
}
