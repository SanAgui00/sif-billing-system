/**
################################################################################
# Autor               : Garnica                                                #
# Compania            : Código Geek                                            #
# Proyecto/Procliente : Estado de cuenta Service             Fecha: 08/03/2018 #
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

import com.prosa.sif.dao.EstadoCuentaDao;
/**
 * 
 * @author David Garnica Garcia
 *
 */
@Service
public class EstadoCuentaService {

	
	@Autowired
	private EstadoCuentaDao estadoCuentaDao;
	
	public void listaEstadoCuenta(String string, Integer fromRow, Model model, Integer periodo, Integer cliente,
			Integer moneda, HttpServletRequest request) {
		estadoCuentaDao.listaEstadoCuenta(string,fromRow,model,periodo,cliente,moneda,request);
	}

	public void listaEstadoCobranzaDiaria(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			Integer proceso, Integer moneda, String cliente, String negocio, String fecha_inicial,
			String fecha_final) {
		estadoCuentaDao.listaEstadoCobranzaDiaria(tipo,model,request,fromRow,proceso,moneda,cliente,negocio,fecha_inicial,fecha_final);
		
	}

	public void jasperCobranzaDiaria(Model model, HttpServletRequest request, HttpServletResponse response,
			Integer proceso, Integer moneda, String cliente, String negocio, String fecha_inicial, String fecha_final,
			String tipo) {
		estadoCuentaDao.jasperCobranzaDiaria(model, request, response,proceso, moneda, cliente, negocio, 
				fecha_inicial, fecha_final,tipo);
	}

	

}
