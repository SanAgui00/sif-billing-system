/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 21/03/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.dao;



import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;


/**
 * 
 * @author Loredo
 *
 */
public interface AdquisicionAutoDao {

	void queryAdquisicionAuto(String tipo, Integer fuentes_clave, String estatus, String fecha_inicial,
			String fecha_final, Integer fromRow, Model model, HttpServletRequest request);

	void queryBitacoraAdq(String tipo, Integer fromRow, Integer fuentes_clave, String fecha_inicial, String fecha_final,
			Model model, HttpServletRequest request);

	void queryServicioFacturar(String tipo, Model model, HttpServletRequest request, Integer idCliente, Integer idServicio,
			String fechaInicio, String fechaFin, String estatus, Integer fromRow);

	void crudServicioFacturar(Model model, HttpServletRequest request, String event, String listaSeleccion,
			Integer idMoneda, Integer idCliente, Integer idServicio, String fechaDatos, String estatus);

}
