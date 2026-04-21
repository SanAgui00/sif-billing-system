/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 23/08/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.prosa.sif.operation.ProcesoGeneral;
import com.prosa.sif.service.ListaGeneralService;
import com.prosa.sif.service.PrecioService;

/**
 * 
 * @author Loredo
 *
 */
@Controller
public class PrecioController {
	@Autowired
	private ListaGeneralService listaGeneralService;
	@Autowired
	private PrecioService precioService;
	@Autowired
	private ProcesoGeneral procesoGeneral;
	
	private static String contr = "controller";
	private static String count = "count";
	private static String consulta = "consulta";
	private static String even = "evento";
	private static String catdescuento = "catalogo/precio/descuento";

	@RequestMapping("/home/cat/precio/servicio")
	public String mostrarServicioCliente(Model model, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaClientes(model, request);
		listaGeneralService.listaServicios(model, request);
		listaGeneralService.listaNegocios(model, request);
		listaGeneralService.listaGrupoConceptoServ(model, request);
		model.addAttribute(even, "porCliente");
		return "catalogo/precio/servicioCliente";
	}

	@RequestMapping("/home/cat/precio/servicio/consulta")
	public String consultaServicioCliente(Model model, HttpServletRequest request,
			@RequestParam(value = "id_cliente", defaultValue = "") Integer id_cliente,
			@RequestParam(value = "id_servicio", defaultValue = "") Integer id_servicio,
			@RequestParam(value = "grupo_concepto", defaultValue = "") Integer grupo_concepto,
			@RequestParam(value = "idNegocio", defaultValue = "") Integer idNegocio,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "evento", defaultValue = "") String evento) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaClientes(model, request);
		listaGeneralService.listaServicios(model, request);
		listaGeneralService.listaNegocios(model, request);
		listaGeneralService.listaGrupoConceptoServ(model, request);
		precioService.queryServicioCliente(count, model, request, id_cliente, grupo_concepto, idNegocio, id_servicio,
				evento, fromRow);
		precioService.queryServicioCliente(consulta, model, request, id_cliente, grupo_concepto, idNegocio,
				id_servicio, evento, fromRow);
		model.addAttribute("id_servicio", id_servicio);
		model.addAttribute("id_cliente", id_cliente);
		model.addAttribute(even, evento);
		return "catalogo/precio/servicioCliente";
	}

	@RequestMapping("/home/cat/precio/servicio/crud")
	public String crudServicioCliente(Model model, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		return "catalogo/precio/servicioClienteCrud";
	}

	@RequestMapping(value = "/home/cat/precio/servicio/save", method = RequestMethod.POST)
	public void saveServicioCliente(Model model, HttpServletRequest request,
			@RequestParam(value = "checkboxPrueba", required = false) String check) {
		procesoGeneral.loggerUsr(contr, request);
	}

	@RequestMapping("/home/cat/precio/descuento")
	public String mostrarAsignarDescuento(Model model, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		return catdescuento;
	}

	@RequestMapping("/home/cat/precio/descuento/consulta")
	public String consultaAsignarDescuento(Model model, HttpServletRequest request,
			@RequestParam(value = "id_cliente", defaultValue = "") Integer id_cliente,
			@RequestParam(value = "id_servicio", defaultValue = "") Integer id_servicio,
			@RequestParam(value = "grupo_volumen", defaultValue = "") Integer grupo_volumen,
			@RequestParam(value = "grupo_concepto", defaultValue = "") Integer grupo_concepto,
			@RequestParam(value = "lista_clientes", defaultValue = "") Integer lista_clientes,
			@RequestParam(value = "id_negocio", defaultValue = "") Integer id_negocio,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "flag", defaultValue = "0") Integer flag,
			@RequestParam(value = "evento", defaultValue = "") String evento) {
		procesoGeneral.loggerUsr(contr, request);
		precioService.queryAsignarDescuento(count, model, request, id_cliente, id_servicio, grupo_volumen,
				grupo_concepto, lista_clientes, id_negocio, fromRow, flag, evento);
		precioService.queryAsignarDescuento(consulta, model, request, id_cliente, id_servicio, grupo_volumen,
				grupo_concepto, lista_clientes, id_negocio, fromRow, flag, evento);
		return catdescuento;
	}

	@RequestMapping("/home/cat/precio/descuento/crud")
	public String crudAsignarDescuento(Model model, HttpServletRequest request,
			@RequestParam(value = "id_cliente", defaultValue = "") Integer id_cliente,
			@RequestParam(value = "id_servicio", defaultValue = "") Integer id_servicio,
			@RequestParam(value = "evento", defaultValue = "") String evento,
			@RequestParam(value = "clave_cliente", defaultValue = "") String clave_cliente,
			@RequestParam(value = "nombre_corto", defaultValue = "") String nombre_corto,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "porcentaje_descuento", defaultValue = "") String porcentaje_descuento) {
		procesoGeneral.loggerUsr(contr, request);
		precioService.crudAsignarDescuento(count, model, request, evento, id_cliente, id_servicio,
				porcentaje_descuento, fromRow);
		precioService.crudAsignarDescuento(consulta, model, request, evento, id_cliente, id_servicio,
				porcentaje_descuento, fromRow);
		model.addAttribute("clave_cliente", clave_cliente);
		model.addAttribute("nombre_corto", nombre_corto);
		model.addAttribute("porcentaje_descuento", porcentaje_descuento);
		model.addAttribute(even, evento);
		model.addAttribute("id_cliente", id_cliente);
		model.addAttribute("id_servicio", id_servicio);
		return "catalogo/precio/descuentoCrud";
	}

	@RequestMapping("/home/cat/precio/save")
	public String saveAsignarDescuento(Model model, HttpServletRequest request,
			@RequestParam(value = "id_cliente", defaultValue = "") Integer id_cliente,
			@RequestParam(value = "id_servicio", defaultValue = "") Integer id_servicio,
			@RequestParam(value = "evento", defaultValue = "") String evento,
			@RequestParam(value = "lista", defaultValue = "") String lista,
			@RequestParam(value = "descuento", defaultValue = "") String descuento,
			@RequestParam(value = "comentarios", defaultValue = "") String comentarios) {
		procesoGeneral.loggerUsr(contr, request);
		precioService.saveAsignarDescuento(model, request, evento, lista, id_cliente, id_servicio, descuento,
				comentarios);
		return catdescuento;
	}
}