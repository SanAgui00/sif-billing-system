/**
################################################################################
# Autor               : Garnica                                                #
# Compania            : Código Geek                                            #
# Proyecto/Procliente : Dao de registo contable              Fecha: 08/03/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/
package com.prosa.sif.dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

/**
 * 
 * @author David Garnica Garcia
 *
 */
public interface RegistroContableDao{

	void queryRegistroContable(String tipo,Model model, Integer fromRow, Integer proceso, Integer negocio, String fecha_inicial,String fecha_final);

	void queryGenerarRegistro(Model model, Integer fromRow, String values, HttpServletRequest request);

	void queryPolizasContables(String tipo, Model model, Integer fromRow, Integer id_modelo_poliza);

	void queryFindPolizaContable(Model model, Integer clave, String event, HttpServletRequest request, HttpServletResponse response);

	void saveOrUpdatePolizaContable(HttpServletRequest request, Model model, String event, String clavePoliza, String tipopoli,
			String descripcionPoli, String checkval, Integer id_modelo_poliza);

	void queryMantenerRegistro(String tipo, Model model, Integer fromRow, Integer cliente, Integer proceso,
			Integer negocio, String fecha_inicial, String fecha_final, String document, String estatus,
			String id_moneda);

	void queryAsignarPolizasNegocios(Model model, Integer id_negocio);

	void SaveorUpdateAsignarPolizasNegocios(HttpServletRequest request, Model model, String values);

	void queryFindRegistroPoliza(Model model, Integer clave, String event, HttpServletRequest request,
			HttpServletResponse response);

	void SaveorDeleteRegistroPoliza(Model model, Integer clave, String event, HttpServletRequest request,
			HttpServletResponse response, String checkval);

	void SaveorDeleteMantenerRegistro(Model model, HttpServletRequest request, HttpServletResponse response,
			String datos, String opcion);

	void queryenvelirev(Model model, String fecha_inicial, String fecha_final);

}
