/**
################################################################################
# Autor               : Garnica                                                #
# Compania            : Código Geek                                            #
# Proyecto/Procliente : Dao de red logica                    Fecha: 08/03/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/
package com.prosa.sif.dao;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.prosa.sif.pojo.TablaRedLogica;
/**
 * 
 * @author David Garnica Garcia
 *
 */
public interface RedLogicaDao {

	void queryRedLogica(String tipo, Model model, HttpServletRequest request, Integer fromRow, String clave, String estatus);

	void queryFindRedLogica(Model model, String clave);

	void saveOrUpdateRedesLogicas(HttpServletRequest request,String evento, TablaRedLogica insert, String fecha_crea, String descripcion,
			String usuario, String estatus, String clave);

	void queryRedLogicaService(String tipo, Model model, HttpServletRequest request, Integer fromRow, String clave);

	void ConfirmarService(Model model, HttpServletRequest request, Integer fromRow, String values);

	void listaServicio(Model model,int clave, String estatus);

	void Agregarservicio(Model model, HttpServletRequest request, String id_servicio);

}
