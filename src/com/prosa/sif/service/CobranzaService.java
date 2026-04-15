package com.prosa.sif.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.prosa.sif.dao.CobranzaDao;

@Service
public class CobranzaService {
	@Autowired
	private CobranzaDao cobranzaDao;

	public void queryCobranza(Model model, HttpServletRequest request, Integer id_fuente, Integer id_servicio,
			Integer flag, String fecha_inicial, String fecha_final, Integer fromRow) {
		cobranzaDao.queryCobranza(model, request, id_fuente, id_servicio, flag, fecha_inicial, fecha_final, fromRow);
	}

	public void crudCobranza(Model model, HttpServletRequest request, String cadena, String evento, Integer flag) {
		cobranzaDao.crudCobranza(model, request, cadena, evento, flag);
	}

	public void queryTipoCambio(Model model, String id_moneda, String id_periodo) {
		cobranzaDao.queryTipoCambio(model, id_moneda, id_periodo);

	}

	public void actualizarTiposCambio(String variables) {
		cobranzaDao.actualizariposCambio(variables);

	}

	public void queryBitacora(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			String fecha_inicial, String fecha_final, String usuario) {
		cobranzaDao.queryBitacora(tipo, model, request, fromRow, fecha_inicial, fecha_final, usuario);
	}

}
