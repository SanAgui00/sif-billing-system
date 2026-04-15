package com.prosa.sif.service;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.prosa.sif.dao.AdquisicionAutoDao;

/**
 * 
 * @author Loredo
 *
 */
@Service
public class AdquisicionAutoService {
	@Autowired
	private AdquisicionAutoDao adquisicionAutoDao;

	public void queryAdquisicionAuto(String tipo, Integer fuentes_clave, String estatus, String fecha_inicial,
			String fecha_final, Integer fromRow, Model model, HttpServletRequest request) {
		adquisicionAutoDao.queryAdquisicionAuto(tipo, fuentes_clave, estatus, fecha_inicial, fecha_final, fromRow,
				model, request);
	}

	public void queryBitacoraAdq(String tipo, Integer fromRow, Integer fuentes_clave, String fecha_inicial,
			String fecha_final, Model model, HttpServletRequest request) {
		adquisicionAutoDao.queryBitacoraAdq(tipo, fromRow, fuentes_clave, fecha_inicial, fecha_final, model, request);
	}

	public void queryServicioFacturar(String tipo, Model model, HttpServletRequest request, Integer idCliente,
			Integer idServicio, String fechaInicio, String fechaFin, String estatus, Integer fromRow) {
		adquisicionAutoDao.queryServicioFacturar(tipo, model, request, idCliente, idServicio, fechaInicio, fechaFin,
				estatus, fromRow);

	}

	public void crudServicioFacturar(Model model, HttpServletRequest request, String event, String listaSeleccion,
			Integer idMoneda, Integer idCliente, Integer idServicio, String fechaDatos, String estatus) {
		adquisicionAutoDao.crudServicioFacturar(model,request,event,listaSeleccion,idMoneda,idCliente,idServicio,fechaDatos,estatus);
	}

}
