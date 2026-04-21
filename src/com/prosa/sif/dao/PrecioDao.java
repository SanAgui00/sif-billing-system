/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 23/08/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.dao;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface PrecioDao {

	void queryServicioCliente(String tipo, Model model, HttpServletRequest request, Integer id_cliente,
			Integer grupo_concepto, Integer idNegocio, Integer id_servicio, String evento, Integer fromRow);

	void queryAsignarDescuento(String tipo, Model model, HttpServletRequest request, Integer id_cliente,
			Integer id_servicio, Integer grupo_volumen, Integer grupo_concepto, Integer lista_clientes,
			Integer id_negocio, Integer fromRow, Integer flag, String evento);

	void crudAsignarDescuento(String tipo, Model model, HttpServletRequest request, String evento, Integer id_cliente, Integer id_servicio, String porcentaje_descuento, Integer fromRow);

	void saveAsignarDescuento(Model model, HttpServletRequest request, String evento, String lista, Integer id_cliente,
			Integer id_servicio, String descuento, String comentarios);

}
