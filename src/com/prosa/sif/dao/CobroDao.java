/**
################################################################################
# Autor               : Garnica Garcia David                                   #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 25/04/2018 #
# Descripcion General : Dao de cobro                                           #
# Marca del cambio    :                                                        #
#------------------------------------------------------------------------------#
# Numero de Parametros: N/A                                                    #
# Parametros Entrada  : N/A                                  Formato:          #
# Parametros Salida   : N/A                                  Formato:          #
################################################################################
**/
package com.prosa.sif.dao;

import org.springframework.ui.Model;
/**
 * 
 * @author David Garnica Garcia
 *
 */
public interface CobroDao {

	void queryEnviarCifras(String tipo,Model model, Integer fromRow, Integer id_cliente, Integer proceso, Integer negocio,
			String fecha_libra, String fecha_sac, String periodicidad, String document, String interfase);

	void queryMovimientosFinancieros(String tipo, Model model, Integer fromRow, Integer id_cliente, Integer proceso,
			Integer negocio, String fecha_envio, String folio_impreso, Integer id_moneda, String serie, String sisenv,
			String document, String folio_interno);
	
	void Enviarcifras(Model model, String values);


	void movimientosFinancierosCFDS(Model model, String tipo, String datos, String datosInput);

}
