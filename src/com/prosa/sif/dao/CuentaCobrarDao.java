package com.prosa.sif.dao;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface CuentaCobrarDao {

	void queryCuentaCobrar(String tipo, Integer fromRow, Integer idCliente, Integer id_moneda,
			String fecha_inicial, String fecha_final, Model model, HttpServletRequest request);

	void queryMantenerSaldos(String tipo, String radioVal, Integer fromRow, Integer idCliente, Integer id_moneda,
			Integer id_tipo_cuenta, String fecha_aplic, Model model, HttpServletRequest request);

	void guardarMantenerSaldos(String variables);

}
