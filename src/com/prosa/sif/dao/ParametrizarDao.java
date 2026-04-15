/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 16/06/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.dao;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface ParametrizarDao {

	void queryContingencia(String tipo, Model model, HttpServletRequest request, Integer id_fuente, String fecha_datos,
			String fecha_datos_final);

	void crudContingencia(String event, Model model, HttpServletRequest request, Integer id_fuente, String fecha_datos,
			String fecha_datos_final);

	void queryReglaCarga(String tipo, Model model, HttpServletRequest request, Integer id_reglas_carga,
			Integer fromRow);

	void crudCargaDato(Model model, HttpServletRequest request, String evento, Integer id_reglas_carga,
			Integer id_fuente, String tabla_temporal, String fecha_mod, String usuario, String estatus,
			String comentarios, String sentencia, String fecha_creacion, String fecha_mod_old);

	void queryReglaConversion(String tipo, Model model, HttpServletRequest request, Integer regla_conv_id,
			Integer fuente, String estatus);

	void crudConversionDato(Model model, HttpServletRequest request, Integer regla_conv_id, Integer id_fuente,
			Integer id_servicio, String fecha_mod, String usuario, String estatus, String comentarios, String sentencia,
			String evento);

	void queryEstructuraDato(String tipo, Integer id_fuente, String estatus, Model model, HttpServletRequest request);

	void crudEstructuraDato(Model model, HttpServletRequest request, String evento, Integer id_estructura,
			Integer id_fuente, String tabla_temporal, String tabla_totales, String estatus,
			Integer b_suspender_depuracion, Integer b_no_hay_carga, String nombre_campo_cliente,
			String nombre_campo_cliente_adq, String fecha_creacion, String fecha_mod, String usuario,
			String comentarios);

	void queryTest(Model model, String sentencia);

}
