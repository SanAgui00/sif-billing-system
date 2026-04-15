/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 08/03/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/
package com.prosa.sif.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.prosa.sif.pojo.TBL_SIF_CAT_PERIODO;
import com.prosa.sif.pojo.TablaCentroCosto;
import com.prosa.sif.pojo.TablaCliente;
import com.prosa.sif.pojo.TablaContacto;
import com.prosa.sif.pojo.TablaFuente;
import com.prosa.sif.pojo.TablaImporte;
import com.prosa.sif.pojo.TablaNegocio;
import com.prosa.sif.pojo.TablaPolizasContable;
import com.prosa.sif.pojo.TablaServicio;
import com.prosa.sif.pojo.TablaTipoCuenta;
import com.prosa.sif.pojo.ViewDireccion;
import com.prosa.sif.pojo.ViewDireccionCliente;
import com.prosa.sif.pojo.ViewSegmentos;
import com.prosa.sif.service.ListaBusquedaGeneralService;

@Controller
public class AjaxController {
	@Autowired
	private ListaBusquedaGeneralService listaBusquedaGeneralService;

	@RequestMapping(value = "/home/list/json/cliente", produces = "application/json")
	@ResponseBody
	public Map<Integer, Object> ajaxCliente(@RequestParam("term") String clave, HttpServletRequest request) {
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		List<TablaCliente> cliente = listaBusquedaGeneralService.buscarCliente(clave);
		for (int i = 0; i < cliente.size(); i++) {
			TablaCliente cliente_r = cliente.get(i);
			map.put(cliente_r.getId_cliente(), cliente_r.getClave_cliente() + '-' + cliente_r.getNombre_corto());

		}
		return map;
	}

	@RequestMapping(value = "/home/list/json/fuentes", produces = "application/json")
	@ResponseBody
	public Map<Integer, Object> ajaxFuentes(@RequestParam("term") String clave, HttpServletRequest request) {
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		List<TablaFuente> fuente = listaBusquedaGeneralService.buscarFuente(clave);
		for (int i = 0; i < fuente.size(); i++) {
			TablaFuente fuente_r = fuente.get(i);
			map.put(fuente_r.getId_fuente(), fuente_r.getClave() + " - " + fuente_r.getDescripcion());

		}
		return map;
	}

	@RequestMapping(value = "/home/list/json/servicios", produces = "application/json")
	@ResponseBody
	public Map<Integer, Object> jsonServicios(@RequestParam("term") String clave, HttpServletRequest request) {
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		List<TablaServicio> servicio = listaBusquedaGeneralService.buscarServicio(clave);
		for (int i = 0; i < servicio.size(); i++) {
			TablaServicio servicio_r = servicio.get(i);
			map.put(servicio_r.getId_servicios(), servicio_r.getClave() + " - " + servicio_r.getDescripcion());

		}
		return map;
	}
	
	@RequestMapping(value = "/home/list/json/serviciosClave", produces = "application/json")
	@ResponseBody
	public Map<String, Object> jsonServiciosClave(@RequestParam("term") String clave, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<TablaServicio> servicio = listaBusquedaGeneralService.buscarServicio(clave);
		for (int i = 0; i < servicio.size(); i++) {
			TablaServicio servicio_r = servicio.get(i);
			String servicioClave = servicio_r.getId_servicios().toString() + "&&" + servicio_r.getClave()
			+ "&&" + servicio_r.getDescripcion();
			map.put(servicioClave, servicio_r.getClave() + " - " + servicio_r.getDescripcion());
		}
		return map;
	}

	@RequestMapping(value = "/home/list/json/proceso", produces = "application/json")
	@ResponseBody
	public Map<Integer, Object> jsonnegocio(@RequestParam("term") int clave) {
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		List<TablaNegocio> negocio = listaBusquedaGeneralService.buscarNegocio(clave);
		for (int i = 0; i < negocio.size(); i++) {
			TablaNegocio negocio_r = negocio.get(i);
			map.put(negocio_r.getId_negocio(), negocio_r.getClave());

		}
		return map;
	}

	@RequestMapping(value = "/home/list/json/polizas", produces = "application/json")
	@ResponseBody
	public Map<Integer, Object> jsonpolizas(@RequestParam("term") String clave) {
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		List<TablaPolizasContable> poliza = listaBusquedaGeneralService.buscarPoliza(clave);
		for (int i = 0; i < poliza.size(); i++) {
			TablaPolizasContable poliza_r = poliza.get(i);
			map.put(poliza_r.getId_modelo_poliza(), poliza_r.getClave());

		}
		return map;
	}

	@RequestMapping(value = "/home/list/json/centro", produces = "application/json")
	@ResponseBody
	public Map<Integer, Object> jsoncentro(@RequestParam("term") String clave) {
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		List<TablaCentroCosto> poliza = listaBusquedaGeneralService.buscarCentro(clave);
		for (int i = 0; i < poliza.size(); i++) {
			TablaCentroCosto poliza_r = poliza.get(i);
			map.put(poliza_r.getId_centro_costos(), poliza_r.getClave_centro_costos() +" - "+poliza_r.getDescripcion());
		}
		return map;
	}

	@RequestMapping(value = "/home/registro/parametrizacion/comprobacion", produces = "application/json")
	@ResponseBody
	public Map<Integer, Object> jsonCompPolizas(@RequestParam("term") String clave) {
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		List<TablaPolizasContable> negocio = listaBusquedaGeneralService.buscarPolizaUnica(clave);
		if (!negocio.isEmpty()) {
			map.put(1, "lleno");
		} else {
			map.put(0, "vacio");
		}
		return map;
	}

	@RequestMapping(value = "/home/list/json/negocio", produces = "application/json")
	@ResponseBody
	public Map<Integer, Object> jsonNegocio(@RequestParam("term") String clave, HttpServletRequest request) {
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		List<TablaNegocio> negocio = listaBusquedaGeneralService.buscarNegocioDin(clave);
		for (int i = 0; i < negocio.size(); i++) {
			TablaNegocio negocio_r = negocio.get(i);
			map.put(negocio_r.getId_negocio(), negocio_r.getClave() +" - "+negocio_r.getDescripcion());

		}
		return map;
	}

	@RequestMapping(value = "/home/list/json/periodo", produces = "application/json")
	@ResponseBody
	public Map<Integer, Object> jsonPeriodo(@RequestParam("term") int clave) {
		SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		List<TBL_SIF_CAT_PERIODO> periodo = listaBusquedaGeneralService.search_TBL_SIF_CAT_PERIDO(clave);
		for (int i = 0; i < periodo.size(); i++) {
			TBL_SIF_CAT_PERIODO periodo_r = periodo.get(i);
			map.put(periodo_r.getId_periodos(), formateador.format(periodo_r.getFecha_inicio()) + " , "
					+ formateador.format(periodo_r.getFecha_fin()));

		}
		return map;
	}
	@RequestMapping(value = "/home/list/json/cuentas", produces = "application/json")
	@ResponseBody
	public Map<Integer, Object> jsonCuentas(@RequestParam("term") String clave, HttpServletRequest request) {
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		List<TablaTipoCuenta> cuenta = listaBusquedaGeneralService.buscarCuentas(clave);
		for (int i = 0; i < cuenta.size(); i++) {
			TablaTipoCuenta cuenta_r = cuenta.get(i);
			map.put(cuenta_r.getId_tipo_cuenta(), cuenta_r.getClave() +" - "+cuenta_r.getDescripcion());

		}
		return map;

	}
	@RequestMapping(value = "/home/list/json/importe", produces = "application/json")
	@ResponseBody
	public Map<String, Object> jsonImportes(@RequestParam("term") String clave, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<TablaImporte> cuenta = listaBusquedaGeneralService.buscarImporte(clave);
		for (int i = 0; i < cuenta.size(); i++) {
			TablaImporte cuenta_r = cuenta.get(i);
			map.put(cuenta_r.getId_importe()  +" - "+cuenta_r.getDescripcion(), cuenta_r.getId_importe() +" - "+cuenta_r.getDescripcion());

		}
		return map;

	}
	@RequestMapping(value = "/home/list/json/parametrizacion", produces = "application/json")
	@ResponseBody
	public Map<String, Object> jsonParametrizacion(@RequestParam("term") String clave, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ViewSegmentos> cuenta = listaBusquedaGeneralService.buscarParametrizacion(clave);
		for (int i = 0; i < cuenta.size(); i++) {
			ViewSegmentos cuenta_r = cuenta.get(i);
			map.put(cuenta_r.getId() +" - "+cuenta_r.getDescripcion(), cuenta_r.getValor_segmento() +" - "+cuenta_r.getDescripcion());

		}
		
		return map;
	}
	
	
	@RequestMapping(value = "/home/list/json/codigopostal", produces = "application/json")
	@ResponseBody
	public List<ViewDireccion> allDir(Model model, SessionStatus sessionStatus, HttpServletRequest request,
			@RequestParam("term") String clave) {

		List<ViewDireccion> periodo = listaBusquedaGeneralService.buscarDireccion(model, request,clave);

		return periodo;
	}
	@RequestMapping(value = "/home/list/json/direccioncontacto", produces = "application/json")
	@ResponseBody
	public List<ViewDireccionCliente> Contacto(Model model, SessionStatus sessionStatus, HttpServletRequest request,
			@RequestParam("term") Integer clave) {

		List<ViewDireccionCliente> periodo = listaBusquedaGeneralService.buscarContacto(clave);

		return periodo;
	}
}