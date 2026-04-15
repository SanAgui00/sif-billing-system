package com.prosa.sif.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.prosa.sif.pojo.TBL_SIF_REBATE;
import com.prosa.sif.dao.CalculoMensualDao;

@Service
public class CalculoMensualService {
	@Autowired
	private CalculoMensualDao calculoMensualDao;

	public void queryPeriodo(String tipo, String periodo, String fecha, Model model, Integer fromRow) {
		calculoMensualDao.queryPeriodo(tipo, periodo, fecha, model, fromRow);
	}

	public void queryDiaPeriodo(String tipo, Integer id_periodo, Model model, String event) {
		calculoMensualDao.queryDiaPeriodo(tipo, id_periodo, model, event);
	}

	public void listaDiaPeriodo(HttpServletRequest request, String event, String nombre, String fechaInicio, String fechaFin, String fechaCierre,
			Model model, Integer inicio, Integer fin, String secondaryEvent) {
		calculoMensualDao.listaDiaPeriodo(request, event, nombre, fechaInicio, fechaFin, fechaCierre, model, inicio, fin,
				secondaryEvent);
	}

	public void crudDiaPeriodo(HttpServletRequest request, Integer id_periodo, String listUpdate, Model model, String event, String nombre,
			String fechaInicio, String fechaFin, String fechaCierre, String comentarios, String bandera) {
		calculoMensualDao.crudDiaPeriodo(request, id_periodo, listUpdate, model, event, nombre, fechaInicio, fechaFin,
				fechaCierre, comentarios,bandera);
	}

	public void queryCalcularAjuste(String tipo, Model model, HttpServletRequest request, Integer id_periodo,
			Integer ajustePorProceso, Integer fromRow) {
		calculoMensualDao.queryCalcularAjuste(tipo, model, request, id_periodo, ajustePorProceso, fromRow);
	}

	public void crudCalcularAjuste(Model model, HttpServletRequest request, Integer id_periodo,
			Integer ajustePorProceso, String lista1, String operacion) {
		calculoMensualDao.crudCalcularAjuste(model, request, id_periodo, ajustePorProceso, lista1, operacion);
	}

	public List<TBL_SIF_REBATE> findAllRebate(int id_periodo, int id_moneda) {
		return calculoMensualDao.findAllRebate(id_periodo, id_moneda);
	}
}