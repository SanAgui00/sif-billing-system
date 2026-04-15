/**
################################################################################
# Autor               : David Garnica                                          #
# Compania            : Código Geek                                            #
# Proyecto/Procliente : Controller de Estado de Cuenta       Fecha: 02/08/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.dao;

import java.util.List;

import com.prosa.sif.pojo.TablaEstiloCarta;

public interface ImpresionDao {
	public List<TablaEstiloCarta> findAll_TBL_SIF_ESTILO_CARTA();

	public List<TablaEstiloCarta> findById_TBL_SIF_ESTILO_CARTA(int id);

	public void ImpresionesDaoImpl(String event, int id, String status, String cuenta, String clave, String descripcion, String autor, String cuenta1);

}
