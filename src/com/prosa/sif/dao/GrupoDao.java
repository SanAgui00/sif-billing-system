/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 07/08/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.dao;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface GrupoDao {

	void queryConceptoServicio(String tipo, Integer idGrupo, Model model, HttpServletRequest request, Integer fromRow);

	void queryVolumenServicio(String tipo, Integer idGrupo, Model model, HttpServletRequest request, Integer fromRow);

	void queryVolumenCliente(String tipo, Integer idGrupo, Model model, HttpServletRequest request, Integer fromRow);

	void queryListaCliente(String tipo, Integer idGrupo, Model model, HttpServletRequest request, Integer fromRow);

	void crudConceptoServicio(String event, Integer idGrupo, String clave, String descripcion, String comentarios,
			Model model, HttpServletRequest request, String listaServiciosExluidos, String listaServiciosIncluidos);

	void crudVolumenServicio(String event, Integer idGrupo, String clave, String descripcion, String comentarios,
			Model model, HttpServletRequest request, String listaServiciosExluidos, String listaServiciosIncluidos);

	void crudVolumenCliente(String event, Integer idGrupo, String clave, String descripcion, String comentarios,
			Model model, HttpServletRequest request, String listaServiciosExluidos, String listaServiciosIncluidos);

	void crudListaCliente(String event, Integer idGrupo, String clave, String descripcion, String comentarios,
			Model model, HttpServletRequest request, String esquema, String listaServiciosExluidos, String listaServiciosIncluidos, String listaBeneficiarios, String listaDistribucion);

}
