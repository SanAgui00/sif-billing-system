/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 12/06/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.prosa.sif.pojo.TBL_SIF_REBATE;

public interface CalculoMensualDao {

	void queryPeriodo(String tipo, String periodo, String fecha, Model model, Integer fromRow);

	void queryDiaPeriodo(String tipo, Integer id_periodo, Model model, String event);

	void listaDiaPeriodo(HttpServletRequest request, String event, String nombre, String fechaInicio, String fechaFin, String fechaCierre,
			Model model, Integer inicio, Integer fin, String secondaryEvent);

	void crudDiaPeriodo(HttpServletRequest request,Integer id_periodo, String listUpdate, Model model, String event, String nombre,
			String fechaInicio, String fechaFin, String fechaCierre, String comentarios, String bandera);

	void queryCalcularAjuste(String tipo, Model model, HttpServletRequest request, Integer id_periodo,
			Integer ajustePorProceso, Integer fromRow);

	void crudCalcularAjuste(Model model, HttpServletRequest request, Integer id_periodo, Integer ajustePorProceso,
			String lista1, String operacion);

	List<TBL_SIF_REBATE> findAllRebate(int id_periodo, int id_moneda);

}
