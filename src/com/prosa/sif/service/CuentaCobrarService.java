package com.prosa.sif.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.prosa.sif.dao.CuentaCobrarDao;

@Service
public class CuentaCobrarService {
	@Autowired
	private CuentaCobrarDao cuentaCobrarDao;
	
	public void queryCuentaCobrar(String tipo, Integer fromRow, Integer idCliente, Integer id_moneda, String fecha_inicial, String fecha_final, Model model, HttpServletRequest request) {
		cuentaCobrarDao.queryCuentaCobrar(tipo, fromRow, idCliente, id_moneda, fecha_inicial, fecha_final, model, request);
	}

	public void queryMantenerSaldos(String tipo, String radioVal, Integer fromRow, Integer idCliente,
			Integer id_moneda, Integer id_tipo_cuenta, String fecha_aplic, Model model, HttpServletRequest request) {
		cuentaCobrarDao.queryMantenerSaldos(tipo, radioVal, fromRow, idCliente, id_moneda, id_tipo_cuenta, fecha_aplic, model, request);
		
	}

	public void guardarMantenerSaldos(String variables) {
		cuentaCobrarDao.guardarMantenerSaldos(variables);
	}

}
