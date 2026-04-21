/**
################################################################################
# Autor               : Garnica Garcia David                                   #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 25/04/2018 #
# Descripcion General : Service de Cobro                                       #
# Marca del cambio    :                                                        #
#------------------------------------------------------------------------------#
# Numero de Parametros: N/A                                                    #
# Parametros Entrada  : N/A                                  Formato:          #
# Parametros Salida   : N/A                                  Formato:          #
################################################################################
**/
package com.prosa.sif.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.prosa.sif.dao.CobroDao;
/**
 * 
 * @author David Garnica Garcia
 *
 */
@Service
public class CobroService {
	@Autowired
	private CobroDao cobroDao;
	public void queryEnviarCifras(String tipo,Model model, Integer fromRow, Integer id_cliente, Integer proceso, Integer negocio,
			String fecha_libra, String fecha_sac, String periodicidad, String document, String interfase) {
		cobroDao.queryEnviarCifras(tipo,model,fromRow,id_cliente,proceso,negocio,fecha_libra,fecha_sac,periodicidad,document,interfase);
		
	}
	public void queryMovimientosFinancieros(String tipo, Model model, Integer fromRow, Integer id_cliente,
			Integer proceso, Integer negocio, String fecha_envio, String folio_impreso, Integer id_moneda, String serie,
			String sisenv, String document, String folio_interno) {
		cobroDao.queryMovimientosFinancieros(tipo,model,fromRow,id_cliente,proceso,negocio,fecha_envio,folio_impreso,id_moneda,serie,sisenv,document,folio_interno);
	}
	/**
	 * 
	 * @author Sanchez Aguiar Jesus Alfonso
	 *
	 */
	public void Enviarcifras(Model model, String values) {
		cobroDao.Enviarcifras(model,values);
	}
	public void movimientosFinancierosCFDS(Model model, String tipo, String datos, String datosInput) {
		cobroDao.movimientosFinancierosCFDS(model, tipo, datos, datosInput);
	}


}
