package com.prosa.sif.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.prosa.sif.dao.PrecioDao;

@Service
public class PrecioService {
	@Autowired
	private PrecioDao precioDao;

	public void queryServicioCliente(String tipo, Model model, HttpServletRequest request, Integer id_cliente,
			Integer grupo_concepto, Integer idNegocio, Integer id_servicio, String evento, Integer fromRow) {
		precioDao.queryServicioCliente(tipo, model, request, id_cliente, grupo_concepto, idNegocio, id_servicio, evento,
				fromRow);
	}

	public void queryAsignarDescuento(String tipo, Model model, HttpServletRequest request, Integer id_cliente,
			Integer id_servicio, Integer grupo_volumen, Integer grupo_concepto, Integer lista_clientes,
			Integer id_negocio, Integer fromRow, Integer flag, String evento) {
		precioDao.queryAsignarDescuento(tipo, model, request, id_cliente, id_servicio, grupo_volumen, grupo_concepto,
				lista_clientes, id_negocio, fromRow, flag, evento);
	}

	public void crudAsignarDescuento(String tipo, Model model, HttpServletRequest request, String evento,
			Integer id_cliente, Integer id_servicio, String porcentaje_descuento, Integer fromRow) {
		precioDao.crudAsignarDescuento(tipo, model, request, evento, id_cliente, id_servicio, porcentaje_descuento,
				fromRow);
	}

	public void saveAsignarDescuento(Model model, HttpServletRequest request, String evento, String lista,
			Integer id_cliente, Integer id_servicio, String descuento, String comentarios) {
		precioDao.saveAsignarDescuento(model, request, evento, lista, id_cliente, id_servicio, descuento, comentarios);
	}
}
