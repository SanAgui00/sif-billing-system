/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 08/03/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.dao;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface CobranzaDao {

	void queryCobranza(Model model, HttpServletRequest request, Integer id_fuente, Integer id_servicio, Integer flag,
			String fecha_inicial, String fecha_final, Integer fromRow);

	void crudCobranza(Model model, HttpServletRequest request, String cadena, String evento, Integer flag);

	void queryTipoCambio(Model model,String id_moneda, String id_periodo);

	void actualizariposCambio(String variables);

	void queryBitacora(String tipo, Model model, HttpServletRequest request, Integer fromRow, String fecha_inicial,
			String fecha_final, String usuario);

}
