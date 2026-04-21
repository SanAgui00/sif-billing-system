/**
################################################################################
# Autor               : Garnica                                                #
# Compania            : Código Geek                                            #
# Proyecto/Procliente : Dao de estado de cuenta              Fecha: 08/03/2018 #
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
public interface EstadoCuentaDao {

	void listaEstadoCuenta(String string, Integer fromRow, Model model, Integer periodo, Integer cliente, Integer moneda,HttpServletRequest request);

	void listaEstadoCobranzaDiaria(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			Integer proceso, Integer moneda, String cliente, String negocio, String fecha_inicial,
			String fecha_final);

	void jasperCobranzaDiaria(Model model, HttpServletRequest request, HttpServletResponse response, Integer proceso,
			Integer moneda, String cliente, String negocio, String fecha_inicial, String fecha_final, String tipo);

}
