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

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prosa.sif.operation.ProcesoGeneral;
import com.prosa.sif.pojo.ViewClavesCliente;
import com.prosa.sif.pojo.ViewDireccion;
import com.prosa.sif.service.ListaBusquedaGeneralService;
import com.prosa.sif.service.ListaGeneralService;
import com.prosa.sif.service.PrincipalService;

/***
 * 
 * @author Alejandro Loredo
 *
 */
@Controller
public class PrincipalController {
	@Autowired
	private PrincipalService principalService;
	@Autowired
	private ListaGeneralService listaGeneralService;
	@Autowired
	private ListaBusquedaGeneralService listaBusquedaGeneralService;
	@Autowired
	private ProcesoGeneral procesoGeneral;

	private static String catalogoCliente = "catalogo/principal/catalogoCliente";
	private static String catalogoServicio = "catalogo/principal/catalogoServicio";
	private static String consulta = "consulta";
	private static String contr = "controller";
	private static String count = "count";
	private static String even = "event";
	private static String empt = "empty";

	/**
	 * Controlador de cátalogo Negocio
	 * 
	 * @param model
	 * 
	 * @param page
	 * @param request
	 * @return catalogo/principal/catalogoNegocios.jsp
	 */
	@RequestMapping("/home/cat/principal/negocio")
	public String mostrarNegocio(Model model, HttpServletRequest request,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "idNegocio", defaultValue = "0") Integer idNegocio) {

		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaNegocios(model, request);
		principalService.queryNegocio(count, fromRow, idNegocio, model, request);
		principalService.queryNegocio(consulta, fromRow, idNegocio, model, request);
		return "catalogo/principal/catalogoNegocio";
	}

	/**
	 * Controlador de cátalogo Negocio, consulta específica
	 * 
	 * @param model
	 * 
	 * @param id_negocio
	 * @param request
	 * @return catalogo/principal/catalogoNegocios.jsp
	 */
	@RequestMapping(value = "/home/cat/principal/negocio/consulta", method = RequestMethod.POST)
	public String consultaNegocio(Model model, HttpServletRequest request,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "idNegocio", defaultValue = "0") Integer idNegocio) {

		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaNegocios(model, request);
		principalService.queryNegocio(count, fromRow, idNegocio, model, request);
		principalService.queryNegocio(consulta, fromRow, idNegocio, model, request);

		return "catalogo/principal/catalogoNegocio";
	}

	/**
	 * 
	 * @param model
	 * @param fromRow
	 * @param idNegocio
	 * @param event
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/principal/negocio/crud", method = RequestMethod.POST)
	public String operationNegocio(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "idNegocio", defaultValue = "0") Integer idNegocio,
			@RequestParam(value = "event", defaultValue = "none") String event, HttpServletRequest request) {

		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaMetodosPago(model, request);
		listaGeneralService.listaUsosCFDI(model, request);
		listaGeneralService.listaProceso(model, request);
		listaGeneralService.listaNegocios(model, request);
		
//		cargar lista de compañia, cuenta, centro de costos
		for (int i = 1; i <=3; i++) {
			listaGeneralService.listaSegmentos(model,request,i);
		}

		principalService.queryNegocio(consulta, fromRow, idNegocio, model, request);
		model.addAttribute(even, event);
		return "catalogo/principal/catalogoNegocioCrud";
	}

	/**
	 * 
	 * @param model
	 * @param insert
	 * @param fecha_cre
	 * @param fecha_mod
	 * @param evento
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/principal/negocio/save", method = RequestMethod.POST)
	public String saveNegocio(Model model, @RequestParam(value = "clave", defaultValue = "empty") String clave,
			@RequestParam(value = "descripcion", defaultValue = "") String descripcion,
			@RequestParam(value = "clave_metodopago_sat", defaultValue = "") String clave_metodopago_sat,
			@RequestParam(value = "clave_usocfdi_sat", defaultValue = "") String clave_usocfdi_sat,
			@RequestParam(value = "id_proceso", defaultValue = "0") Integer id_proceso,
			@RequestParam(value = "id_negocio_padre", defaultValue = "0") Integer id_negocio_padre,
			@RequestParam(value = "id_centro_costos", defaultValue = "0") Integer id_centro_costos,
			@RequestParam(value = "cuenta_ingreso", defaultValue = "0") Integer cuenta_ingreso,
			@RequestParam(value = "id_negocio", defaultValue = "0") Integer id_negocio,
			@RequestParam(value = "id_grupo_edo_cuenta", defaultValue = "0") Integer id_grupo_edo_cuenta,
			@RequestParam(value = "clave_gl", defaultValue = "") String clave_gl,
			@RequestParam(value = "comentarios", defaultValue = "") String comentarios,
			@RequestParam(value = "concepto_carta", defaultValue = "") String concepto_carta,
			@RequestParam(value = "usuario", defaultValue = "") String usuario,
			@RequestParam(value = "status", defaultValue = "") String status,
			@RequestParam(value = "fecha_crea", defaultValue = "") String fecha_cre,
			@RequestParam(value = "fecha_modi", defaultValue = "") String fecha_mod,
			@RequestParam(value = "evento", defaultValue = "") String evento, HttpServletRequest request) {

		procesoGeneral.loggerUsr(contr, request);
		principalService.crudNegocio(evento, clave, descripcion, clave_metodopago_sat, clave_usocfdi_sat, id_proceso,
				id_negocio_padre, id_centro_costos, cuenta_ingreso, clave_gl, comentarios, concepto_carta, usuario,
				fecha_cre, fecha_mod, model, request, id_negocio, id_grupo_edo_cuenta, status);
		return "redirect:/home/cat/principal/negocio/";
	}

	/**
	 * Controlador de cátalogo Servicio
	 *
	 * @param model
	 * @param page
	 * @param request
	 * @return catalogo/principal/catalogoServicio.jsp
	 */
	@RequestMapping("/home/cat/principal/servicio")
	public String viewServicio(Model model, @RequestParam(value = "servicio", defaultValue = "0") Integer servicio,
			@RequestParam(value = "grupo_concepto", defaultValue = "0") Integer concepto,
			@RequestParam(value = "grupo_volumen", defaultValue = "0") Integer volumen,
			@RequestParam(value = "estatus", defaultValue = "empty") String estatus,
			@RequestParam(value = "negocio", defaultValue = "0") Integer negocio,
			@RequestParam(value = "fuente", defaultValue = "0") Integer fuente, HttpServletRequest request,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow) {

		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaNegocios(model, request);
		listaGeneralService.listaFuentes(model, request);
		listaGeneralService.listaGrupoVolumen(model, request);
		listaGeneralService.listaGrupoConceptoServ(model, request);
		listaGeneralService.listaServicios(model, request);
		principalService.queryServicio(count, fromRow, servicio, concepto, volumen, estatus, negocio, fuente, model,
				request);
		principalService.queryServicio(consulta, fromRow, servicio, concepto, volumen, estatus, negocio, fuente, model,
				request);
		return catalogoServicio;
	}

	/**
	 * Controlador de cátalogo Servicio, consulta específica
	 *
	 * @param model
	 * @param servicio
	 * @param concepto
	 * @param volumen
	 * @param estatus
	 * @param negocio
	 * @param fuente
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/principal/servicio/consulta", method = RequestMethod.POST)
	public String showServicio(Model model, @RequestParam(value = "servicio", defaultValue = "0") Integer servicio,
			@RequestParam(value = "grupo_concepto", defaultValue = "0") Integer concepto,
			@RequestParam(value = "grupo_volumen", defaultValue = "0") Integer volumen,
			@RequestParam(value = "estatus", defaultValue = "empty") String estatus,
			@RequestParam(value = "negocio", defaultValue = "0") Integer negocio,
			@RequestParam(value = "fuente", defaultValue = "0") Integer fuente, HttpServletRequest request,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow) {

		procesoGeneral.loggerUsr(contr, request);
		model.addAttribute("servicio", servicio);
		model.addAttribute("grupo_concepto", concepto);
		model.addAttribute("grupo_volumen", volumen);
		model.addAttribute("estatus", estatus);
		model.addAttribute("negocio", negocio);
		model.addAttribute("fuente", fuente);
		listaGeneralService.listaNegocios(model, request);
		listaGeneralService.listaFuentes(model, request);
		listaGeneralService.listaGrupoVolumen(model, request);
		listaGeneralService.listaGrupoConceptoServ(model, request);
		listaGeneralService.listaServicios(model, request);
		principalService.queryServicio(count, fromRow, servicio, concepto, volumen, estatus, negocio, fuente, model,
				request);
		principalService.queryServicio(consulta, fromRow, servicio, concepto, volumen, estatus, negocio, fuente, model,
				request);

		return catalogoServicio;
	}

	@RequestMapping(value = "/home/cat/principal/servicio/crud", method = RequestMethod.POST)
	public String operationServicio(Model model,
			@RequestParam(value = "id_servicios", defaultValue = "0") Integer id_servicios,
			@RequestParam(value = "id_precio", defaultValue = "0") Integer id_precio,
			@RequestParam(value = "event", defaultValue = "none") String event, HttpServletRequest request) {

		procesoGeneral.loggerUsr(contr, request);
		listaBusquedaGeneralService.buscarServicioId(model, request, id_servicios);
		principalService.queryHistorico(model, request, id_servicios);
		switch (event) {
		case "edit":
			principalService.queryConcepto("subconcepto", model, request, id_servicios, id_precio);
			principalService.queryConcepto("aplicacion", model, request, id_servicios, id_precio);
			listaGeneralService.listaCentroCostos(model, request);
			listaGeneralService.listaFuentes(model, request);
			listaGeneralService.listaIngreso(model, request);
			listaGeneralService.listaClavesServicio(model, request);
			listaGeneralService.listaClavesUnidad(model, request);
			listaGeneralService.listaNegocios(model, request);
			listaGeneralService.listaGrupoConceptoServ(model, request);
			listaGeneralService.listaGrupoVolumen(model, request);
			listaGeneralService.listaServiciosParticulares(model, request);
			listaGeneralService.listaTiposImpuesto(model, request);
			listaGeneralService.listaTiposFactor(model, request);
			listaGeneralService.listaTasasCuotas(model, request);
			listaGeneralService.listaUnidadMedida(model, request);
			listaGeneralService.listaTiposCargo(model, request);
			listaGeneralService.listaUMedida(model, request);
			model.addAttribute(even, "edit");
			break;
		case "delete":
			model.addAttribute(even, "delete");
			break;
		case "new":
			principalService.queryConcepto("subconcepto", model, request, id_servicios, id_precio);
			principalService.queryConcepto("aplicacion", model, request, id_servicios, id_precio);
			listaGeneralService.listaCentroCostos(model, request);
			listaGeneralService.listaFuentes(model, request);
			listaGeneralService.listaIngreso(model, request);
			listaGeneralService.listaClavesServicio(model, request);
			listaGeneralService.listaClavesUnidad(model, request);
			listaGeneralService.listaNegocios(model, request);
			listaGeneralService.listaGrupoConceptoServ(model, request);
			listaGeneralService.listaGrupoVolumen(model, request);
			listaGeneralService.listaServiciosParticulares(model, request);
			listaGeneralService.listaTiposImpuesto(model, request);
			listaGeneralService.listaTiposFactor(model, request);
			listaGeneralService.listaTasasCuotas(model, request);
			listaGeneralService.listaUnidadMedida(model, request);
			listaGeneralService.listaTiposCargo(model, request);
			listaGeneralService.listaUMedida(model, request);

			model.addAttribute(even, "new");
			break;
		default:
			break;

		}
		return "catalogo/principal/catalogoServicioCrud";
	}

	/**
	 * 
	 * @param model
	 * @param insert
	 * @param fecha_cre
	 * @param fecha_mod
	 * @param evento
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/principal/servicio/save", method = RequestMethod.POST)
	public String saveServicio(Model model,
			@RequestParam(value = "id_servicios", defaultValue = "") Integer id_servicios,
			@RequestParam(value = "id_fuente", defaultValue = "") Integer id_fuente,
			@RequestParam(value = "id_negocio", defaultValue = "") Integer id_negocio,
			@RequestParam(value = "id_precio", defaultValue = "") Integer id_precio,
			@RequestParam(value = "id_forma_pago", defaultValue = "") Integer id_forma_pago,
			@RequestParam(value = "id_grupo_vol", defaultValue = "") Integer id_grupo_vol,
			@RequestParam(value = "id_grupo_concepto", defaultValue = "") Integer id_grupo_concepto,
			@RequestParam(value = "id_moneda_importe_adq", defaultValue = "") Integer id_moneda_importe_adq,
			@RequestParam(value = "id_moneda_adq", defaultValue = "") Integer id_moneda_adq,
			@RequestParam(value = "id_centro_costos", defaultValue = "") Integer id_centro_costos,
			@RequestParam(value = "b_adquisicion_auto", defaultValue = "") Integer b_adquisicion_auto,
			@RequestParam(value = "dias_habiles_cobro", defaultValue = "") Integer dias_habiles_cobro,
			@RequestParam(value = "dia_limite_solicitud", defaultValue = "") Integer dia_limite_solicitud,
			@RequestParam(value = "b_habilitar_op_av", required = false) String b_habilitar_op_av,
			@RequestParam(value = "b_incluir_rebate", required = false) String b_incluir_rebate,
			@RequestParam(value = "b_captura_imp_liquidado", required = false) String b_captura_imp_liquidado,
			@RequestParam(value = "b_precio_controlado", defaultValue = "") Integer b_precio_controlado,
			@RequestParam(value = "b_adquisicion_sin_iva", defaultValue = "") Integer b_adquisicion_sin_iva,
			@RequestParam(value = "b_info_extra_desc_subconcep", required = false) String b_info_extra_desc_subconcep,
			@RequestParam(value = "b_info_extra_transaccion", required = false) String b_info_extra_transaccion,
			@RequestParam(value = "b_imp_cantidad_en_fact", required = false) String b_imp_cantidad_en_fact,
			@RequestParam(value = "b_imp_costo_unitario", required = false) String b_imp_costo_unitario,
			@RequestParam(value = "id_serv_part", defaultValue = "") Integer id_serv_part,
			@RequestParam(value = "id_cat_ingreso", defaultValue = "") Integer id_cat_ingreso,
			@RequestParam(value = "valor_tasa_sat", defaultValue = "") BigDecimal valor_tasa_sat,
			@RequestParam(value = "clave", defaultValue = "") String clave,
			@RequestParam(value = "descripcion", defaultValue = "") String descripcion,
			@RequestParam(value = "estatus", defaultValue = "") String estatus,
			@RequestParam(value = "periodicidad_adquisicion", defaultValue = "") String periodicidad_adquisicion,
			@RequestParam(value = "periodicidad_cobro", defaultValue = "") String periodicidad_cobro,
			@RequestParam(value = "realizar_envio", required = false) String realizar_envio,
			@RequestParam(value = "realizar_reg_cont", required = false) String realizar_reg_cont,
			@RequestParam(value = "realizar_emision_fact", required = false) String realizar_emision_fact,
			@RequestParam(value = "b_auto_cobro", required = false) String b_auto_cobro,
			@RequestParam(value = "b_auto_reg_cont", required = false) String b_auto_reg_cont,
			@RequestParam(value = "unidad_medida", defaultValue = "") String unidad_medida,
			@RequestParam(value = "tipo_cargo", defaultValue = "null") String tipo_cargo,
			@RequestParam(value = "sistem_cobro", defaultValue = "") String sistem_cobro,
			@RequestParam(value = "usuario", defaultValue = "") String usuario,
			@RequestParam(value = "fecha_cre", defaultValue = "") String fecha_cre,
			@RequestParam(value = "fecha_mod", defaultValue = "") String fecha_mod,
			@RequestParam(value = "comentarios", defaultValue = "") String comentarios,
			@RequestParam(value = "tipo_servicio", defaultValue = "") String tipo_servicio,
			@RequestParam(value = "realizar_calculo", required = false) String realizar_calculo,
			@RequestParam(value = "cuenta_ingreso", defaultValue = "") String cuenta_ingreso,
			@RequestParam(value = "umedida_factura", defaultValue = "") String umedida_factura,
			@RequestParam(value = "clave_servicio_sat", defaultValue = "") String clave_servicio_sat,
			@RequestParam(value = "clave_unidad_sat", defaultValue = "") String clave_unidad_sat,
			@RequestParam(value = "clave_impuesto_sat", defaultValue = "") String clave_impuesto_sat,
			@RequestParam(value = "clave_factor_sat", defaultValue = "") String clave_factor_sat,
			@RequestParam(value = "evento", defaultValue = "null") String evento, HttpServletRequest request) {

		procesoGeneral.loggerUsr(contr, request);
		principalService.crudServicio(model, request, id_servicios, id_fuente, id_negocio, id_precio, id_forma_pago,
				id_grupo_vol, id_grupo_concepto, id_moneda_importe_adq, id_moneda_adq, id_centro_costos, clave,
				descripcion, estatus, b_adquisicion_auto, periodicidad_adquisicion, periodicidad_cobro,
				dias_habiles_cobro, dia_limite_solicitud, b_habilitar_op_av, realizar_envio, realizar_reg_cont,
				realizar_emision_fact, b_auto_cobro, b_auto_reg_cont, b_incluir_rebate, unidad_medida, tipo_cargo,
				sistem_cobro, b_captura_imp_liquidado, b_precio_controlado, b_adquisicion_sin_iva,
				b_info_extra_desc_subconcep, b_info_extra_transaccion, b_imp_cantidad_en_fact, b_imp_costo_unitario,
				usuario, fecha_cre, fecha_mod, comentarios, tipo_servicio, realizar_calculo, cuenta_ingreso,
				umedida_factura, id_serv_part, id_cat_ingreso, clave_servicio_sat, clave_unidad_sat, clave_impuesto_sat,
				clave_factor_sat, valor_tasa_sat, evento);

		return "redirect:/home/cat/principal/servicio/";
	}

	@RequestMapping("/home/cat/principal/servicio/precio")
	public String servicioPrecio(Model model,
			@RequestParam(value = "id_servicios", defaultValue = "") Integer id_servicios,
			@RequestParam(value = "id_fuente", defaultValue = "") Integer id_fuente,
			@RequestParam(value = "clave", defaultValue = "") String clave,
			@RequestParam(value = "cliente", defaultValue = "") String cliente,
			@RequestParam(value = "id_negocio", defaultValue = "") Integer id_negocio,
			@RequestParam(value = "id_precio", defaultValue = "") Integer id_precio,
			@RequestParam(value = "evento", defaultValue = "null") String evento, HttpServletRequest request) {

		procesoGeneral.loggerUsr(contr, request);
		model.addAttribute("id_servicios", id_servicios);
		model.addAttribute("id_precio", id_precio);
		model.addAttribute("clave", clave);
		model.addAttribute("cliente", cliente);
		principalService.queryPrecio("precio", model, request, id_servicios, id_precio);
		principalService.queryPrecio("rango", model, request, id_servicios, id_precio);
		return "catalogo/principal/definirPrecio";
	}

	@RequestMapping(value = "/home/cat/principal/servicio/precioSave")
	public ModelAndView guardarPrecio(Model model, HttpServletRequest request, RedirectAttributes redirectAttributes,
			@RequestParam(value = "id_servicios", defaultValue = "") Integer id_servicios,
			@RequestParam(value = "id_precio", defaultValue = "") Integer id_precio,
			@RequestParam(value = "listaPrecios", defaultValue = "") String listaPrecios,
			@RequestParam(value = "inputPrecio", defaultValue = "") String inputPrecio,
			@RequestParam(value = "tipoPrecio", defaultValue = "") String tipoPrecio,
			@RequestParam(value = "inputMoneda", defaultValue = "") Integer inputMoneda,
			@RequestParam(value = "clave", defaultValue = "") String clave) {

		procesoGeneral.loggerUsr(contr, request);
		principalService.crudPrecio(model, request, id_servicios, id_precio, listaPrecios, inputPrecio, tipoPrecio,
				inputMoneda, redirectAttributes);
		redirectAttributes.addFlashAttribute("clave", clave);
		return new ModelAndView("forward:/home/cat/principal/servicio/precio");
	}

	@RequestMapping("/home/cat/principal/servicio/jasper")
	public String jasper(Model model, @RequestParam(value = "servicio", defaultValue = "0") Integer servicio,
			@RequestParam(value = "grupo_concepto", defaultValue = "0") Integer concepto,
			@RequestParam(value = "grupo_volumen", defaultValue = "0") Integer volumen,
			@RequestParam(value = "estatus", defaultValue = "empty") String estatus,
			@RequestParam(value = "negocio", defaultValue = "0") Integer negocio,
			@RequestParam(value = "fuente", defaultValue = "0") Integer fuente,
			@RequestParam(value = "tipo", defaultValue = "empty") String tipo, HttpServletRequest request,
			HttpServletResponse response) {

		procesoGeneral.loggerUsr(contr, request);
		principalService.jasper(model, request, response, servicio, concepto, volumen, estatus, negocio, fuente, tipo);

		return catalogoServicio;
	}

	/**
	 * Controlador de cátalogo Cliente
	 *
	 * @param model
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping("/home/cat/principal/cliente")
	public String viewCliente(Model model,
			@RequestParam(value = "clave_cliente", defaultValue = "empty") String clave_cliente,
			@RequestParam(value = "nombre_corto", defaultValue = "empty") String nombre_corto,
			@RequestParam(value = "clave_grupo", defaultValue = "0") Integer clave_grupo,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "estatus", defaultValue = "ACT") String estatus, HttpServletRequest request) {

		procesoGeneral.loggerUsr(contr, request);
		principalService.queryCliente(count, model, request, fromRow, clave_cliente, nombre_corto, clave_grupo,
				estatus);
		principalService.queryCliente(consulta, model, request, fromRow, clave_cliente, nombre_corto, clave_grupo,
				estatus);
		return catalogoCliente;
	}

	/**
	 * Controlador de cátalogo Cliente, consulta específica
	 *
	 * @param model
	 * @param clave_cliente
	 * @param nombre_corto
	 * @param clave_grupo
	 * @param estatus
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/principal/cliente/consulta", method = { RequestMethod.POST, RequestMethod.GET })
	public String showCliente(Model model,
			@RequestParam(value = "clave_cliente", defaultValue = "empty") String clave_cliente,
			@RequestParam(value = "nombre_corto", defaultValue = "empty") String nombre_corto,
			@RequestParam(value = "clave_grupo", defaultValue = "0") Integer clave_grupo,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "estatus", defaultValue = "ACT") String estatus, HttpServletRequest request) {

		procesoGeneral.loggerUsr(contr, request);
		if (clave_cliente.equals(empt)) {
			clave_cliente = "";
			model.addAttribute("clave_cliente", clave_cliente);
			clave_cliente = empt;
		} else {
			model.addAttribute("clave_cliente", clave_cliente);
		}
		if (nombre_corto.equals(empt)) {
			nombre_corto = "";
			model.addAttribute("nombre_corto", nombre_corto);
			nombre_corto = empt;
		} else {
			model.addAttribute("nombre_corto", nombre_corto);
		}
		if (clave_grupo == 0) {
			clave_grupo = null;
			model.addAttribute("clave_grupo", clave_grupo);
			clave_grupo = 0;
		} else {
			model.addAttribute("clave_grupo", clave_grupo);
		}
		model.addAttribute("estatus", estatus);

		principalService.queryCliente(count, model, request, fromRow, clave_cliente, nombre_corto, clave_grupo,
				estatus);
		principalService.queryCliente(consulta, model, request, fromRow, clave_cliente, nombre_corto, clave_grupo,
				estatus);
		return catalogoCliente;
	}

	/**
	 *
	 * @param model
	 * @param id_cliente
	 * @param id_domicilio
	 * @param event
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/principal/cliente/crud", method = { RequestMethod.POST, RequestMethod.GET })
	public String operationCliente(Model model,
			@RequestParam(value = "id_cliente", defaultValue = "") Integer id_cliente,
			@RequestParam(value = "id_domicilio", defaultValue = "") Integer id_domicilio,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "event", defaultValue = "none") String event, HttpServletRequest request) {

		procesoGeneral.loggerUsr(contr, request);
		listaBusquedaGeneralService.buscarClienteId(model, request, id_cliente);
		listaBusquedaGeneralService.buscarDireccion(model, request, id_domicilio);
		listaBusquedaGeneralService.buscarClaveCliente(model, request, id_cliente);
		listaBusquedaGeneralService.buscarCuentaContable(model, request, id_cliente);

		switch (event) {
		case "edit":
			listaGeneralService.listaClientes(model, request);
			listaGeneralService.listaFuentes(model, request);
			listaGeneralService.listaEstados(model, request);
			listaGeneralService.listaCuentasBanco(model, request);
			listaGeneralService.listaFuentes(model, request);
			listaGeneralService.listaCuentasContables(model, request);
			listaGeneralService.listaFormasPago(model, request);
			listaGeneralService.listaGrupoCliente(model, request);
			listaGeneralService.listaPaises(model, request);
			principalService.queryHistoricoCliente(model, request, id_cliente);
			principalService.queryContacto(model, request, id_cliente);
			principalService.queryClavesCliente(count,model, request, id_cliente,fromRow);
			principalService.queryClavesCliente(consulta,model, request, id_cliente,fromRow);
			principalService.queryMetodoPago(model, request, id_cliente);
			model.addAttribute(even, "edit");
			break;
		case "delete":
			model.addAttribute(even, "delete");
			break;
		case "new":
			listaGeneralService.listaFuentes(model, request);
			listaGeneralService.listaCuentasContables(model, request);
			listaGeneralService.listaFormaPagos(model, request);
			listaGeneralService.listaGrupoCliente(model, request);
			model.addAttribute(even, "new");
			break;
		default:
			break;
		}

		return "catalogo/principal/catalogoClienteCrud";
	}

	/**
	 *
	 * @param model
	 * @param id_cliente
	 * @param clave_cliente
	 * @param nombre_corto
	 * @param razon_social
	 * @param id_grupo_vol
	 * @param fiid
	 * @param rfc
	 * @param curp
	 * @param estatus
	 * @param clave_formapago_sat
	 * @param numero_idfiscal_sat
	 * @param comentarios
	 * @param b_cliente_consorcio
	 * @param pct_iva
	 * @param b_cliente_socio
	 * @param inf_addicional
	 * @param b_incluir_rebate
	 * @param inf_addicional_1
	 * @param evento
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/principal/cliente/save", method = RequestMethod.POST)
	public String saveCliente(Model model, @RequestParam(value = "evento", defaultValue = "null") String evento,
			HttpServletRequest request, @RequestParam(value = "id_cliente", defaultValue = "") Integer id_cliente,
			@RequestParam(value = "clave_cliente", defaultValue = "") String clave_cliente,
			@RequestParam(value = "rfc", defaultValue = "") String rfc,
			@RequestParam(value = "curp", defaultValue = "") String curp,
			@RequestParam(value = "fiid", defaultValue = "") Integer fiid,
			@RequestParam(value = "nombre_corto", defaultValue = "") String nombre_corto,
			@RequestParam(value = "razon_social", defaultValue = "") String razon_social,
			@RequestParam(value = "id_grupo_vol", defaultValue = "") Integer id_grupo_vol,
			@RequestParam(value = "clave_formapago_sat", defaultValue = "") String clave_formapago_sat,
			@RequestParam(value = "numero_idfiscal_sat", defaultValue = "") String numero_idfiscal_sat,
			@RequestParam(value = "rfc_entidad_emi", defaultValue = "") String rfc_entidad_emi,
			@RequestParam(value = "cuenta_bancaria", defaultValue = "") String cuenta_bancaria,
			@RequestParam(value = "nom_entidad_emi", defaultValue = "") String nom_entidad_emi,
			@RequestParam(value = "id_cuenta_banco", defaultValue = "") Integer id_cuenta_banco,
			@RequestParam(value = "b_cliente_consorcio", required = false) String b_cliente_consorcio,
			@RequestParam(value = "b_cliente_socio", required = false) String b_cliente_socio,
			@RequestParam(value = "b_incluir_rebate", required = false) String b_incluir_rebate,
			@RequestParam(value = "pct_iva", defaultValue = "") Integer pct_iva,
			@RequestParam(value = "inf_addicional", defaultValue = "") String inf_addicional,
			@RequestParam(value = "inf_addicional_1", defaultValue = "") String inf_addicional_1,
			@RequestParam(value = "comentarios", defaultValue = "") String comentarios,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "b_cliente_nacional", defaultValue = "") Integer b_cliente_nacional,
			@RequestParam(value = "id_domicilio", defaultValue = "") Integer id_domicilio,
			@RequestParam(value = "id_pais", defaultValue = "") Integer id_pais,
			@RequestParam(value = "id_codigo_postal", defaultValue = "") Integer id_codigo_postal,
			@RequestParam(value = "id_poblacion", defaultValue = "") Integer id_poblacion,
			@RequestParam(value = "id_estado", defaultValue = "") Integer id_estado,
			@RequestParam(value = "calle", defaultValue = "") String calle,
			@RequestParam(value = "numero_ext", defaultValue = "") String numero_ext,
			@RequestParam(value = "numero_int", defaultValue = "") String numero_int,
			@RequestParam(value = "cp", defaultValue = "") String cp,
			@RequestParam(value = "colonia", defaultValue = "") String colonia,
			@RequestParam(value = "ciudad", defaultValue = "") String ciudad,
			@RequestParam(value = "id_pais", defaultValue = "") Integer id_paiss,
			@RequestParam(value = "estado", defaultValue = "") String estado,
			@RequestParam(value = "delegacion", defaultValue = "") String delegacion,
			@RequestParam(value = "contactosSplit", defaultValue = "") String datosContactos,
			@RequestParam(value = "teleprincipal", defaultValue = "") String telefonoPrin,
			@RequestParam(value = "apartado_postal", defaultValue = "") String apartado_postal) {
		System.out.println(datosContactos+" y "+ telefonoPrin);
		
		/*
		 * principalService.crudCliente(model, request, evento, fromRow, id_cliente,
		 * clave_cliente, rfc, curp, fiid, nombre_corto, razon_social, id_grupo_vol,
		 * clave_formapago_sat, numero_idfiscal_sat, rfc_entidad_emi, cuenta_bancaria,
		 * nom_entidad_emi, id_cuenta_banco, b_cliente_consorcio, b_cliente_socio,
		 * b_incluir_rebate, pct_iva, inf_addicional, inf_addicional_1, comentarios);
		 * 
		 * procesoGeneral.loggerUsr(contr, request);
		 */
		return "redirect:/home/cat/principal/cliente";
	}

	@RequestMapping("/home/cat/principal/cliente/jasper")
	public String jasperClientes(Model model,
			@RequestParam(value = "clave_cliente", defaultValue = "empty") String clave_cliente,
			@RequestParam(value = "nombre_corto", defaultValue = "empty") String nombre_corto,
			@RequestParam(value = "clave_grupo", defaultValue = "0") Integer clave_grupo,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "estatus", defaultValue = "empty") String estatus,
			@RequestParam(value = "tipo", defaultValue = "empty") String tipo, HttpServletRequest request,
			HttpServletResponse response) {

		procesoGeneral.loggerUsr(contr, request);
		principalService.jasperClientes(model, request, response, clave_cliente, nombre_corto, clave_grupo, estatus,
				tipo);

		return catalogoCliente;
	}
	@RequestMapping(value = "/home/list/json/cuentascliente", produces = "application/json")
	@ResponseBody
	public List<ViewClavesCliente> allDir(Model model, SessionStatus sessionStatus, HttpServletRequest request,
			@RequestParam("term") Integer cliente,@RequestParam("fromRow") Integer fromRow) {

		List<ViewClavesCliente> periodo = principalService.buscarClavesCliente(model,request,cliente,fromRow);

		return periodo;
	}
	
	@RequestMapping(value = "/home/list/json/agregar/cuentascliente", produces = "application/json")
	@ResponseBody
	public Integer addCuentasCliente(Model model, SessionStatus sessionStatus, HttpServletRequest request,
			@RequestParam("clave") String clave,@RequestParam("adquirente") Integer adquirente,
			@RequestParam("cliente") Integer cliente,@RequestParam("agrupador") Integer agrupador,@RequestParam("fuentesistema") String fuentesistema,
			@RequestParam("fuentesis") Integer fuentesis) {

		Integer periodo = principalService.saveClavesCliente(model,request,clave,adquirente,cliente,fuentesistema,fuentesis,agrupador);

		return periodo;
	}


}