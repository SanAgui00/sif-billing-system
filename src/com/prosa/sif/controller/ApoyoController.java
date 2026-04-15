/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 16/04/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prosa.sif.operation.ProcesoGeneral;
import com.prosa.sif.pojo.TablaCentroCosto;
import com.prosa.sif.pojo.TablaConcepto;
import com.prosa.sif.pojo.TablaEmpresa;
import com.prosa.sif.pojo.TablaEventoServicio;
import com.prosa.sif.pojo.TablaFormaPagos;
import com.prosa.sif.pojo.TablaFuncionalidad;
import com.prosa.sif.pojo.TablaIngreso;
import com.prosa.sif.pojo.TablaProceso;
import com.prosa.sif.pojo.TablaServicioParticular;
import com.prosa.sif.pojo.TablaTipoCuenta;
import com.prosa.sif.pojo.TablaTipoPago;
import com.prosa.sif.pojo.TablaUMedida;
import com.prosa.sif.pojo.TablaUsuario;
import com.prosa.sif.service.ApoyoService;
import com.prosa.sif.service.ListaBusquedaGeneralService;
import com.prosa.sif.service.ListaGeneralService;

@Controller
public class ApoyoController {
	@Autowired
	private ListaGeneralService listaGeneralService;
	@Autowired
	private ApoyoService apoyoService;
	@Autowired
	private ListaBusquedaGeneralService listaBusquedaGeneralService;
	@Autowired
	private ProcesoGeneral procesoGeneral;
	
	private static String contr = "controller";
	private static String count = "count";
	private static String consulta = "consulta";
	private static String even = "event";

	/**
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/home/cat/apoyo/empresas")
	public String viewEmpresas(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			HttpServletRequest request, @RequestParam(value = "id_empresa", defaultValue = "0") Integer id_empresa) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.queryEmpresa(count, model, request, id_empresa, fromRow);
		apoyoService.queryEmpresa(consulta, model, request, id_empresa, fromRow);
		listaGeneralService.listaEmpresas(model, request);
		return "catalogo/apoyo/empresas";
	}

	/**
	 * 
	 * @param model
	 * @param id_empresa
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/empresas/consulta", method = RequestMethod.POST)
	public String showEmpresas(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "id_empresa", defaultValue = "0") Integer id_empresa, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaEmpresas(model, request);
		apoyoService.queryEmpresa(count, model, request, id_empresa, fromRow);
		apoyoService.queryEmpresa(consulta, model, request, id_empresa, fromRow);
		return "catalogo/apoyo/empresas";
	}

	/**
	 * 
	 * @param model
	 * @param id_empresa
	 * @param event
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/empresas/crud", method = RequestMethod.POST)
	public String operationEmpresas(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "id_empresa", defaultValue = "0") Integer id_empresa,
			@RequestParam(value = "event", defaultValue = "none") String event, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaRegimenFiscal(model, request);
		apoyoService.queryEmpresa(consulta, model, request, id_empresa, fromRow);
		listaBusquedaGeneralService.buscarDireccionEmpresa(model, request, id_empresa);
		model.addAttribute(even, event);
		return "catalogo/apoyo/empresasCrud";
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
	@RequestMapping(value = "/home/cat/apoyo/empresas/save", method = RequestMethod.POST)
	public String saveNegocio(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@ModelAttribute("insert") TablaEmpresa insert,
			@RequestParam(value = "fecha_crea", defaultValue = "null") String fecha_cre,
			@RequestParam(value = "fecha_modi", defaultValue = "null") String fecha_mod,
			@RequestParam(value = "evento", defaultValue = "null") String evento, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.crudEmpresa(model, request, evento, insert, fecha_cre, fecha_mod);
		return "redirect:/home/cat/apoyo/empresas/";
	}

	/**
	 * 
	 * @param model
	 * @param fromRow
	 * @param request
	 * @param id_fuente
	 * @return
	 */
	@RequestMapping("/home/cat/apoyo/fuentes")
	public String viewFuentes(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			HttpServletRequest request, @RequestParam(value = "fuente", defaultValue = "0") Integer id_fuente) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaFuentes(model, request);
		apoyoService.queryFuente(count, model, request, id_fuente, fromRow);
		apoyoService.queryFuente(consulta, model, request, id_fuente, fromRow);
		return "catalogo/apoyo/fuentes";
	}

	/**
	 * 
	 * @param model
	 * @param id_fuente
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/fuentes/consulta", method = RequestMethod.POST)
	public String showFuentes(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "fuente", defaultValue = "0") Integer id_fuente, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaFuentes(model, request);
		apoyoService.queryFuente(count, model, request, id_fuente, fromRow);
		apoyoService.queryFuente(consulta, model, request, id_fuente, fromRow);
		return "catalogo/apoyo/fuentes";
	}

	/**
	 * 
	 * @param model
	 * @param id_fuente
	 * @param event
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/fuentes/crud", method = RequestMethod.POST)
	public String operationFuentes(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "id_fuente", defaultValue = "0") Integer id_fuente,
			@RequestParam(value = "event", defaultValue = "none") String event, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaFuentes(model, request);
		apoyoService.queryFuente(consulta, model, request, id_fuente, fromRow);
		model.addAttribute(even, event);
		return "catalogo/apoyo/fuentesCrud";
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
	@RequestMapping(value = "/home/cat/apoyo/fuentes/save", method = RequestMethod.POST)
	public String saveFuentes(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "id_fuente", defaultValue = "") Integer id_fuente,
			@RequestParam(value = "clave", defaultValue = "") String clave,
			@RequestParam(value = "id_fuente_base_clave_cli", defaultValue = "") Integer id_fuente_base_clave_cli,
			@RequestParam(value = "descripcion", defaultValue = "") String descripcion,
			@RequestParam(value = "comentarios", defaultValue = "null") String comentarios,
			@RequestParam(value = "evento", defaultValue = "null") String evento, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.crudFuente(model, request, evento, id_fuente,clave,id_fuente_base_clave_cli,descripcion,comentarios);
		return "redirect:/home/cat/apoyo/fuentes";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @param id_proceso
	 * @return
	 */
	@RequestMapping("/home/cat/apoyo/procesos")
	public String viewProcesos(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			HttpServletRequest request, @RequestParam(value = "proceso", defaultValue = "0") Integer id_proceso) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaProceso(model, request);
		apoyoService.queryProceso(count, model, request, id_proceso, fromRow);
		apoyoService.queryProceso(consulta, model, request, id_proceso, fromRow);
		return "catalogo/apoyo/procesos";
	}

	/**
	 * 
	 * @param model
	 * @param id_proceso
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/procesos/consulta", method = RequestMethod.POST)
	public String showProcesos(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "proceso", defaultValue = "0") Integer id_proceso, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaProceso(model, request);
		apoyoService.queryProceso(count, model, request, id_proceso, fromRow);
		apoyoService.queryProceso(consulta, model, request, id_proceso, fromRow);
		return "catalogo/apoyo/procesos";
	}

	/**
	 * 
	 * @param model
	 * @param id_proceso
	 * @param event
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/procesos/crud", method = RequestMethod.POST)
	public String operationProcesos(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "id_proceso", defaultValue = "0") Integer id_proceso,
			@RequestParam(value = "event", defaultValue = "none") String event, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.queryProceso(consulta, model, request, id_proceso, fromRow);
		model.addAttribute(even, event);
		return "catalogo/apoyo/procesosCrud";
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
	@RequestMapping(value = "/home/cat/apoyo/procesos/save", method = RequestMethod.POST)
	public String saveProceso(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@ModelAttribute("insert") TablaProceso insert,
			@RequestParam(value = "fecha_crea", defaultValue = "null") String fecha_cre,
			@RequestParam(value = "fecha_modi", defaultValue = "null") String fecha_mod,
			@RequestParam(value = "evento", defaultValue = "null") String evento, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.crudProceso(model, request, evento, insert, fecha_cre, fecha_mod);
		return "redirect:/home/cat/apoyo/procesos/";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/home/cat/apoyo/centrocostos")
	public String viewCentroCostos(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			HttpServletRequest request,
			@RequestParam(value = "centro_costos", defaultValue = "0") Integer id_centro_costos) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaCentroCostos(model, request);
		apoyoService.queryCentroCosto(count, model, request, id_centro_costos, fromRow);
		apoyoService.queryCentroCosto(consulta, model, request, id_centro_costos, fromRow);
		return "catalogo/apoyo/centroCostos";
	}

	/**
	 * 
	 * @param model
	 * @param id_centro_costos
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/centrocostos/consulta", method = RequestMethod.POST)
	public String showCentroCostos(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "centro_costos", defaultValue = "0") Integer id_centro_costos,
			HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaCentroCostos(model, request);
		apoyoService.queryCentroCosto(count, model, request, id_centro_costos, fromRow);
		apoyoService.queryCentroCosto(consulta, model, request, id_centro_costos, fromRow);
		return "catalogo/apoyo/centroCostos";
	}

	/**
	 * 
	 * @param model
	 * @param id_centro_costos
	 * @param event
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/centrocostos/crud", method = RequestMethod.POST)
	public String operationCentroCostos(Model model,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "id_centro_costos", defaultValue = "0") Integer id_centro_costos,
			@RequestParam(value = "event", defaultValue = "none") String event, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.queryCentroCosto(consulta, model, request, id_centro_costos, fromRow);
		model.addAttribute(even, event);
		return "catalogo/apoyo/centroCostosCrud";
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
	@RequestMapping(value = "/home/cat/apoyo/centrocostos/save", method = RequestMethod.POST)
	public String saveCentroCostos(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@ModelAttribute("insert") TablaCentroCosto insert,
			@RequestParam(value = "fecha_crea", defaultValue = "null") String fecha_cre,
			@RequestParam(value = "fecha_modi", defaultValue = "null") String fecha_mod,
			@RequestParam(value = "evento", defaultValue = "null") String evento, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.crudCentroCosto(model, request, evento, insert, fecha_cre, fecha_mod);
		return "redirect:/home/cat/apoyo/centrocostos/";
	}

	/**
	 * 
	 * @param model
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping("/home/cat/apoyo/cuentascontables")
	public String viewCuentasContables(Model model,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow, HttpServletRequest request,
			@RequestParam(value = "id_tipo_cuenta", defaultValue = "0") Integer id_tipo_cuenta) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaCuentasContables(model, request);
		apoyoService.queryCuentaContable(count, model, request, id_tipo_cuenta, fromRow);
		apoyoService.queryCuentaContable(consulta, model, request, id_tipo_cuenta, fromRow);
		return "catalogo/apoyo/cuentasContables";
	}

	/**
	 * 
	 * @param model
	 * @param id_tipo_cuenta
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/cuentascontables/consulta", method = RequestMethod.POST)
	public String showCuentasContables(Model model,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "id_tipo_cuenta", defaultValue = "0") Integer id_tipo_cuenta,
			HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaCuentasContables(model, request);
		apoyoService.queryCuentaContable(count, model, request, id_tipo_cuenta, fromRow);
		apoyoService.queryCuentaContable(consulta, model, request, id_tipo_cuenta, fromRow);
		return "catalogo/apoyo/cuentasContables";
	}

	/**
	 * 
	 * @param model
	 * @param id_tipo_cuenta
	 * @param event
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/cuentascontables/crud", method = RequestMethod.POST)
	public String operationCuentasContables(Model model,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "id_tipo_cuenta", defaultValue = "0") Integer id_tipo_cuenta,
			@RequestParam(value = "event", defaultValue = "none") String event, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.queryCuentaContable(consulta, model, request, id_tipo_cuenta, fromRow);
		model.addAttribute(even, event);
		return "catalogo/apoyo/cuentasContablesCrud";
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
	@RequestMapping(value = "/home/cat/apoyo/cuentascontables/save", method = RequestMethod.POST)
	public String saveCuentasContables(Model model,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@ModelAttribute("insert") TablaTipoCuenta insert,
			@RequestParam(value = "fecha_crea", defaultValue = "null") String fecha_cre,
			@RequestParam(value = "fecha_modi", defaultValue = "null") String fecha_mod,
			@RequestParam(value = "evento", defaultValue = "null") String evento, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.crudCuentaContable(model, request, evento, insert, fecha_cre, fecha_mod);
		return "redirect:/home/cat/apoyo/cuentascontables/";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/home/cat/apoyo/formasdepago")
	public String viewFormasPago(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			HttpServletRequest request,
			@RequestParam(value = "id_forma_pago", defaultValue = "0") Integer id_forma_pago) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaFormaPagos(model, request);
		apoyoService.queryFormaPago(count, model, request, id_forma_pago, fromRow);
		apoyoService.queryFormaPago(consulta, model, request, id_forma_pago, fromRow);
		return "catalogo/apoyo/formasPago";
	}

	/**
	 * 
	 * @param model
	 * @param id_forma_pago
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/formasdepago/consulta", method = RequestMethod.POST)
	public String showFormasPago(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "id_forma_pago", defaultValue = "0") Integer id_forma_pago,
			HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaFormaPagos(model, request);
		apoyoService.queryFormaPago(count, model, request, id_forma_pago, fromRow);
		apoyoService.queryFormaPago(consulta, model, request, id_forma_pago, fromRow);
		return "catalogo/apoyo/formasPago";
	}

	/**
	 * 
	 * @param model
	 * @param id_forma_pago
	 * @param event
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/formasdepago/crud", method = RequestMethod.POST)
	public String operationFormasPago(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "id_forma_pago", defaultValue = "0") Integer id_forma_pago,
			@RequestParam(value = "event", defaultValue = "none") String event, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.queryFormaPago(consulta, model, request, id_forma_pago, fromRow);
		model.addAttribute(even, event);
		return "catalogo/apoyo/formasPagoCrud";
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
	@RequestMapping(value = "/home/cat/apoyo/formasdepago/save", method = RequestMethod.POST)
	public String saveFormasPago(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@ModelAttribute("insert") TablaFormaPagos insert,
			@RequestParam(value = "fecha_crea", defaultValue = "null") String fecha_cre,
			@RequestParam(value = "fecha_modi", defaultValue = "null") String fecha_mod,
			@RequestParam(value = "evento", defaultValue = "null") String evento, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.crudFormaPago(model, request, evento, insert, fecha_cre, fecha_mod);
		return "redirect:/home/cat/apoyo/formasdepago/";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @param id_tipos_pago
	 * @return
	 */
	@RequestMapping("/home/cat/apoyo/tiposdepago")
	public String viewTiposPago(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			HttpServletRequest request,
			@RequestParam(value = "id_tipos_pago", defaultValue = "0") Integer id_tipos_pago) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaTipoPago(model, request);
		apoyoService.queryTipoPago(count, model, request, id_tipos_pago, fromRow);
		apoyoService.queryTipoPago(consulta, model, request, id_tipos_pago, fromRow);
		return "catalogo/apoyo/tiposPago";
	}

	/**
	 * 
	 * @param model
	 * @param id_tipos_pago
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/tiposdepago/consulta", method = RequestMethod.POST)
	public String showTiposPago(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "id_tipos_pago", defaultValue = "0") Integer id_tipos_pago,
			HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaTipoPago(model, request);
		apoyoService.queryTipoPago(count, model, request, id_tipos_pago, fromRow);
		apoyoService.queryTipoPago(consulta, model, request, id_tipos_pago, fromRow);
		return "catalogo/apoyo/tiposPago";
	}

	/**
	 * 
	 * @param model
	 * @param id_tipos_pago
	 * @param event
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/tiposdepago/crud", method = RequestMethod.POST)
	public String operationTipoPago(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "id_tipos_pago", defaultValue = "0") Integer id_tipos_pago,
			@RequestParam(value = "event", defaultValue = "none") String event, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.queryTipoPago(consulta, model, request, id_tipos_pago, fromRow);
		model.addAttribute(even, event);
		return "catalogo/apoyo/tiposPagoCrud";
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
	@RequestMapping(value = "/home/cat/apoyo/tiposdepago/save", method = RequestMethod.POST)
	public String saveTiposPago(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@ModelAttribute("insert") TablaTipoPago insert,
			@RequestParam(value = "fecha_crea", defaultValue = "null") String fecha_cre,
			@RequestParam(value = "fecha_modi", defaultValue = "null") String fecha_mod,
			@RequestParam(value = "evento", defaultValue = "null") String evento, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.crudTipoPago(model, request, evento, insert, fecha_cre, fecha_mod);

		return "redirect:/home/cat/apoyo/tiposdepago/";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @param id
	 * @param estatus
	 * @return
	 */
	@RequestMapping("/home/cat/apoyo/umedida")
	public String viewUMedida(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			HttpServletRequest request, @RequestParam(value = "id", defaultValue = "0") Integer id,
			@RequestParam(value = "estatus", defaultValue = "empty") String estatus) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaUMedida(model, request);
		apoyoService.queryUMedida(count, model, request, id, estatus, fromRow);
		apoyoService.queryUMedida(consulta, model, request, id, estatus, fromRow);
		return "catalogo/apoyo/uMedida";
	}

	/**
	 * 
	 * @param model
	 * @param id
	 * @param estatus
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/umedida/consulta", method = RequestMethod.POST)
	public String showUMedida(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "id", defaultValue = "0") Integer id,
			@RequestParam(value = "estatus", defaultValue = "empty") String estatus, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaUMedida(model, request);
		apoyoService.queryUMedida(count, model, request, id, estatus, fromRow);
		apoyoService.queryUMedida(consulta, model, request, id, estatus, fromRow);
		return "catalogo/apoyo/uMedida";
	}

	/**
	 * 
	 * @param model
	 * @param id
	 * @param event
	 * @param estatus
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/umedida/crud", method = RequestMethod.POST)
	public String operationUMedida(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "id", defaultValue = "0") Integer id,
			@RequestParam(value = "event", defaultValue = "none") String event,
			@RequestParam(value = "estatus", defaultValue = "empty") String estatus, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.queryUMedida(consulta, model, request, id, estatus, fromRow);
		model.addAttribute(even, event);
		return "catalogo/apoyo/uMedidaCrud";
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
	@RequestMapping(value = "/home/cat/apoyo/umedida/save", method = RequestMethod.POST)
	public String saveUMedida(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@ModelAttribute("insert") TablaUMedida insert,
			@RequestParam(value = "fecha_crea", defaultValue = "null") String fecha_cre,
			@RequestParam(value = "fecha_modi", defaultValue = "null") String fecha_mod,
			@RequestParam(value = "evento", defaultValue = "null") String evento, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.crudUMedida(model, request, evento, insert, fecha_cre, fecha_mod);
		return "redirect:/home/cat/apoyo/umedida/";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @param tipo
	 * @param grupo
	 * @param descripcion
	 * @param estatus
	 * @param id
	 * @return
	 */
	@RequestMapping("/home/cat/apoyo/conceptos")
	public String viewConceptos(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			HttpServletRequest request, @RequestParam(value = "tipo", defaultValue = "empty") String tipo,
			@RequestParam(value = "grupo", defaultValue = "0") Integer grupo,
			@RequestParam(value = "descripcion", defaultValue = "empty") String descripcion,
			@RequestParam(value = "estatus", defaultValue = "empty") String estatus,
			@RequestParam(value = "id", defaultValue = "0") Integer id) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaConceptos(model, request);
		listaGeneralService.listaTipoConceptos(model, request);
		listaGeneralService.listaGrupoConcepto(model, request);
		listaGeneralService.listaDescripcionConceptos(model, request);
		apoyoService.queryConcepto(count, model, request, tipo, grupo, descripcion, estatus, id, fromRow);
		apoyoService.queryConcepto(consulta, model, request, tipo, grupo, descripcion, estatus, id, fromRow);
		return "catalogo/apoyo/conceptosFactura";
	}

	/**
	 * 
	 * @param model
	 * @param tipo
	 * @param grupo
	 * @param id
	 * @param descripcion
	 * @param estatus
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/conceptos/consulta", method = RequestMethod.POST)
	public String showConceptos(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "tipo", defaultValue = "empty") String tipo,
			@RequestParam(value = "grupo", defaultValue = "0") Integer grupo,
			@RequestParam(value = "id", defaultValue = "0") Integer id,
			@RequestParam(value = "descripcion", defaultValue = "empty") String descripcion,
			@RequestParam(value = "estatus", defaultValue = "empty") String estatus, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaConceptos(model, request);
		listaGeneralService.listaTipoConceptos(model, request);
		listaGeneralService.listaGrupoConcepto(model, request);
		listaGeneralService.listaDescripcionConceptos(model, request);
		apoyoService.queryConcepto(count, model, request, tipo, grupo, descripcion, estatus, id, fromRow);
		apoyoService.queryConcepto(consulta, model, request, tipo, grupo, descripcion, estatus, id, fromRow);
		return "catalogo/apoyo/conceptosFactura";
	}

	/**
	 * 
	 * @param model
	 * @param id
	 * @param event
	 * @param tipo
	 * @param descripcion
	 * @param grupo
	 * @param estatus
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/conceptos/crud", method = RequestMethod.POST)
	public String operationConceptos(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "id", defaultValue = "0") Integer id,
			@RequestParam(value = "event", defaultValue = "none") String event,
			@RequestParam(value = "tipo", defaultValue = "empty") String tipo,
			@RequestParam(value = "descripcion", defaultValue = "empty") String descripcion,
			@RequestParam(value = "grupo", defaultValue = "0") Integer grupo,
			@RequestParam(value = "estatus", defaultValue = "empty") String estatus, HttpServletRequest request) {

		procesoGeneral.loggerUsr(contr, request);
		apoyoService.queryConcepto(consulta, model, request, tipo, grupo, descripcion, estatus, id, fromRow);
		model.addAttribute(even, event);
		return "catalogo/apoyo/conceptosFacturaCrud";
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
	@RequestMapping(value = "/home/cat/apoyo/conceptos/save", method = RequestMethod.POST)
	public String saveConceptos(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@ModelAttribute("insert") TablaConcepto insert,
			@RequestParam(value = "fecha_crea", defaultValue = "null") String fecha_cre,
			@RequestParam(value = "fecha_modi", defaultValue = "null") String fecha_mod,
			@RequestParam(value = "evento", defaultValue = "null") String evento, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.crudConcepto(model, request, evento, insert, fecha_cre, fecha_mod);
		return "redirect:/home/cat/apoyo/conceptos/";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @param id_cliente
	 * @param addenda
	 * @param estatus
	 * @param id
	 * @return
	 */
	@RequestMapping("/home/cat/apoyo/addendas")
	public String viewAddendas(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			HttpServletRequest request, @RequestParam(value = "id_cliente", defaultValue = "0") Integer id_cliente,
			@RequestParam(value = "addenda", defaultValue = "empty") String addenda,
			@RequestParam(value = "estatus", defaultValue = "empty") String estatus,
			@RequestParam(value = "id", defaultValue = "0") Integer id) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaAddendas(model, request);
		apoyoService.queryAddenda(count, model, request, id_cliente, addenda, estatus, id, fromRow);
		apoyoService.queryAddenda(consulta, model, request, id_cliente, addenda, estatus, id, fromRow);
		return "catalogo/apoyo/addendas";
	}

	/**
	 * 
	 * @param model
	 * @param id_cliente
	 * @param id
	 * @param addenda
	 * @param estatus
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/addendas/consulta", method = RequestMethod.POST)
	public String showAddendas(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "id_cliente", defaultValue = "0") Integer id_cliente,
			@RequestParam(value = "id", defaultValue = "0") Integer id,
			@RequestParam(value = "addenda", defaultValue = "empty") String addenda,
			@RequestParam(value = "estatus", defaultValue = "empty") String estatus, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaAddendas(model, request);
		apoyoService.queryAddenda(count, model, request, id_cliente, addenda, estatus, id, fromRow);
		apoyoService.queryAddenda(consulta, model, request, id_cliente, addenda, estatus, id, fromRow);
		return "catalogo/apoyo/addendas";
	}

	/**
	 * 
	 * @param model
	 * @param id
	 * @param event
	 * @param id_cliente
	 * @param addenda
	 * @param estatus
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/addendas/crud", method = RequestMethod.POST)
	public String operationAddendas(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "id", defaultValue = "0") Integer id,
			@RequestParam(value = "event", defaultValue = "none") String event,
			@RequestParam(value = "id_cliente", defaultValue = "0") Integer id_cliente,
			@RequestParam(value = "addenda", defaultValue = "empty") String addenda,
			@RequestParam(value = "estatus", defaultValue = "empty") String estatus, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.queryAddenda(consulta, model, request, id_cliente, addenda, estatus, id, fromRow);
		model.addAttribute(even, event);

		return "catalogo/apoyo/addendasCrud";
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
	@RequestMapping(value = "/home/cat/apoyo/addendas/save", method = RequestMethod.POST)
	public String saveAddendas(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "fecha_crea", defaultValue = "null") String fecha_cre,
			@RequestParam(value = "fecha_modi", defaultValue = "null") String fecha_mod,
			@RequestParam(value = "valor", defaultValue = "") String valor,
			@RequestParam(value = "id", defaultValue = "") Integer id,
			@RequestParam(value = "id_cliente", defaultValue = "") Integer id_cliente,
			@RequestParam(value = "nombre", defaultValue = "") String nombre,
			@RequestParam(value = "descripcion", defaultValue = "") String descripcion,
			@RequestParam(value = "evento", defaultValue = "null") String evento, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.crudAddenda(model, request, evento, fecha_cre, fecha_mod, valor, id_cliente, nombre, descripcion,
				id);
		return "redirect:/home/cat/apoyo/addendas/";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/home/cat/apoyo/moneda")
	public String viewMonedas(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			HttpServletRequest request, @RequestParam(value = "id_moneda", defaultValue = "0") Integer id_moneda) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaMonedas(model, request);
		apoyoService.queryMoneda(count, model, request, id_moneda, fromRow);
		apoyoService.queryMoneda(consulta, model, request, id_moneda, fromRow);
		return "catalogo/apoyo/monedas";
	}

	/**
	 * 
	 * @param model
	 * @param id_moneda
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/moneda/consulta", method = RequestMethod.POST)
	public String showMonedas(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "id_moneda", defaultValue = "0") Integer id_moneda, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaMonedas(model, request);
		apoyoService.queryMoneda(count, model, request, id_moneda, fromRow);
		apoyoService.queryMoneda(consulta, model, request, id_moneda, fromRow);
		return "catalogo/apoyo/monedas";
	}

	/**
	 * 
	 * @param model
	 * @param event
	 * @param id_moneda
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/moneda/crud", method = RequestMethod.POST)
	public String operationMoneda(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "event", defaultValue = "none") String event,
			@RequestParam(value = "id_moneda", defaultValue = "0") Integer id_moneda, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.queryMoneda(consulta, model, request, id_moneda, fromRow);
		model.addAttribute(even, event);
		return "catalogo/apoyo/monedasCrud";
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
	@RequestMapping(value = "/home/cat/apoyo/moneda/save", method = RequestMethod.POST)
	public String saveMonedas(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "evento", defaultValue = "null") String evento, HttpServletRequest request,
			@RequestParam(value = "id_moneda", defaultValue = "") Integer id_moneda,
			@RequestParam(value = "nombre_moneda", defaultValue = "") String nombre_moneda,
			@RequestParam(value = "pais", defaultValue = "") String pais,
			@RequestParam(value = "simbolo", defaultValue = "") String simbolo,
			@RequestParam(value = "t_moneda", defaultValue = "") Integer t_moneda,
			@RequestParam(value = "estatus", defaultValue = "") String estatus,
			@RequestParam(value = "fecha_cre", defaultValue = "") String fecha_cre,
			@RequestParam(value = "fecha_mod", defaultValue = "") String fecha_mod,
			@RequestParam(value = "usuario", defaultValue = "") String usuario,
			@RequestParam(value = "comentarios", defaultValue = "") String comentarios,
			@RequestParam(value = "clave_sat", defaultValue = "") String clave_sat,
			@RequestParam(value = "nombre_sat", defaultValue = "") String nombre_sat,
			@RequestParam(value = "decimales", defaultValue = "") Integer decimales,
			@RequestParam(value = "variacion", defaultValue = "") Integer variacion

	) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.crudMoneda(model, request, evento, id_moneda, nombre_moneda, pais, simbolo, t_moneda, estatus,
				fecha_cre, fecha_mod, usuario, comentarios, clave_sat, nombre_sat, decimales, variacion);
		return "redirect:/home/cat/apoyo/moneda/";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @param usuario
	 * @return
	 */
	@RequestMapping("/home/cat/apoyo/perfiles")
	public String viewUsuarios(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			HttpServletRequest request, @RequestParam(value = "usuario", defaultValue = "empty") String usuario) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaUsuarios(model, request);
		apoyoService.queryUsuario(count, model, request, usuario, fromRow);
		apoyoService.queryUsuario(consulta, model, request, usuario, fromRow);
		return "catalogo/apoyo/usuarios";
	}

	/**
	 * 
	 * @param model
	 * @param usuario
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/perfiles/consulta", method = RequestMethod.POST)
	public String showUsuarios(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "usuario", defaultValue = "empty") String usuario, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaUsuarios(model, request);
		apoyoService.queryUsuario(count, model, request, usuario, fromRow);
		apoyoService.queryUsuario(consulta, model, request, usuario, fromRow);
		return "catalogo/apoyo/usuarios";
	}

	/**
	 * 
	 * @param model
	 * @param event
	 * @param usuario
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/perfiles/crud", method = RequestMethod.POST)
	public String operationUsuarios(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "event", defaultValue = "none") String event,
			@RequestParam(value = "usuario", defaultValue = "empty") String usuario, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.queryUsuario(consulta, model, request, usuario, fromRow);
		model.addAttribute(even, event);

		return "catalogo/apoyo/usuariosCrud";
	}

	/**
	 * 
	 * @param model
	 * @param insert
	 * @param evento
	 * @param nombre_usuario
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/perfiles/save", method = RequestMethod.POST)
	public String savePerfiles(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@ModelAttribute("insert") TablaUsuario insert,
			@RequestParam(value = "evento", defaultValue = "null") String evento,
			@RequestParam(value = "nombre_usuario", defaultValue = "null") String nombre_usuario,
			HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.crudUsuario(model, request, evento, insert, nombre_usuario);
		return "redirect:/home/cat/apoyo/perfiles/";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/home/cat/apoyo/funcionalidades")
	public String viewFuncionalidades(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			HttpServletRequest request, @RequestParam(value = "id", defaultValue = "0") Integer id) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaFuncionalidades(model, request);
		apoyoService.queryFuncionalidad(count, model, request, id, fromRow);
		apoyoService.queryFuncionalidad(consulta, model, request, id, fromRow);
		return "catalogo/apoyo/funcionalidades";
	}

	/**
	 * 
	 * @param model
	 * @param id
	 * @param request
	 * @return
	 */

	@RequestMapping(value = "/home/cat/apoyo/funcionalidades/consulta", method = RequestMethod.POST)
	public String showFuncionalidades(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "id", defaultValue = "0") Integer id, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaFuncionalidades(model, request);
		apoyoService.queryFuncionalidad(count, model, request, id, fromRow);
		apoyoService.queryFuncionalidad(consulta, model, request, id, fromRow);
		return "catalogo/apoyo/funcionalidades";
	}

	/**
	 * 
	 * @param model
	 * @param event
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/funcionalidades/crud", method = RequestMethod.POST)
	public String operationFuncionalidades(Model model,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "event", defaultValue = "none") String event,
			@RequestParam(value = "id", defaultValue = "0") Integer id, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.queryFuncionalidad(consulta, model, request, id, fromRow);
		model.addAttribute(even, event);

		return "catalogo/apoyo/funcionalidadesCrud";
	}

	/**
	 * 
	 * @param model
	 * @param insert
	 * @param evento
	 * @param fecha_cre
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/funcionalidades/save", method = RequestMethod.POST)
	public String saveFuncionalidades(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@ModelAttribute("insert") TablaFuncionalidad insert,
			@RequestParam(value = "evento", defaultValue = "null") String evento,
			@RequestParam(value = "fecha_crea", defaultValue = "null") String fecha_cre, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.crudFuncionalidad(model, request, evento, insert, fecha_cre);
		return "redirect:/home/cat/apoyo/funcionalidades/";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/home/cat/apoyo/parametros")
	public String viewParametros(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			HttpServletRequest request, @RequestParam(value = "id", defaultValue = "0") Integer id) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaFuncionalidades(model, request);
		listaGeneralService.listaParametros(model, request);
		apoyoService.queryParametro(count, model, request, id, fromRow);
		apoyoService.queryParametro(consulta, model, request, id, fromRow);
		return "catalogo/apoyo/parametros";
	}

	/**
	 * 
	 * @param model
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/parametros/consulta", method = RequestMethod.POST)
	public String showParametros(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "id", defaultValue = "0") Integer id, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaFuncionalidades(model, request);
		listaGeneralService.listaParametros(model, request);
		apoyoService.queryParametro(count, model, request, id, fromRow);
		apoyoService.queryParametro(consulta, model, request, id, fromRow);
		return "catalogo/apoyo/parametros";
	}

	/**
	 * 
	 * @param model
	 * @param event
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/parametros/crud", method = RequestMethod.POST)
	public String operationParametros(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "event", defaultValue = "none") String event,
			@RequestParam(value = "id", defaultValue = "0") Integer id, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.queryParametro("consultaCrud", model, request, id, fromRow);
		model.addAttribute(even, event);
		return "catalogo/apoyo/parametrosCrud";
	}

	/**
	 * 
	 * @param model
	 * @param insert
	 * @param evento
	 * @param fecha_cre
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/parametros/save", method = RequestMethod.POST)
	public String saveParametros(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "evento", defaultValue = "null") String evento, HttpServletRequest request,
			@RequestParam(value = "fecha", defaultValue = "") String fecha,
			@RequestParam(value = "id", defaultValue = "") Integer id,
			@RequestParam(value = "id_funcionalidad", defaultValue = "") Integer id_funcionalidad,
			@RequestParam(value = "valor2", defaultValue = "") String valor2,
			@RequestParam(value = "estatus", defaultValue = "") String estatus,
			@RequestParam(value = "usuario", defaultValue = "") String usuario,
			@RequestParam(value = "valor1", defaultValue = "") String valor1,
			@RequestParam(value = "nombre", defaultValue = "") String nombre

	) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.crudParametro(model, request, evento, fecha, id, id_funcionalidad, valor2, estatus, usuario,
				valor1, nombre);
		return "redirect:/home/cat/apoyo/parametros/";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/home/cat/apoyo/eventos")
	public String viewEventoServicio(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			HttpServletRequest request, @RequestParam(value = "id", defaultValue = "") Integer id,
			@RequestParam(value = "evento", defaultValue = "") Integer evento,
			@RequestParam(value = "estatus", defaultValue = "") String estatus) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.queryEventoServicio(count, model, request, fromRow, id, evento, estatus);
		apoyoService.queryEventoServicio("join", model, request, fromRow, id, evento, estatus);
		apoyoService.queryEventoServicio(consulta, model, request, fromRow, id, evento, estatus);
		apoyoService.queryEventoServicio("distinct", model, request, fromRow, id, evento, estatus);
		return "catalogo/apoyo/eventosServicio";
	}

	@RequestMapping(value = "/home/cat/apoyo/eventos/consulta", method = RequestMethod.POST)
	public String showEventoServicio(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "id", defaultValue = "") Integer id,
			@RequestParam(value = "evento", defaultValue = "") Integer evento,
			@RequestParam(value = "estatus", defaultValue = "") String estatus, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.queryEventoServicio(count, model, request, fromRow, id, evento, estatus);
		apoyoService.queryEventoServicio("join", model, request, fromRow, id, evento, estatus);
		apoyoService.queryEventoServicio(consulta, model, request, fromRow, id, evento, estatus);
		apoyoService.queryEventoServicio("distinct", model, request, fromRow, id, evento, estatus);
		return "catalogo/apoyo/eventosServicio";
	}

	/**
	 * 
	 * @param model
	 * @param event
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/eventos/crud", method = RequestMethod.POST)
	public String operationEventoServicio(Model model,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "event", defaultValue = "none") String event,
			@RequestParam(value = "evento", defaultValue = "0") Integer evento,
			@RequestParam(value = "estatus", defaultValue = "empty") String estatus,
			@RequestParam(value = "id", defaultValue = "0") Integer id, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.queryEventoServicio("param", model, request, fromRow, id, evento, estatus);
		model.addAttribute(even, event);
		return "catalogo/apoyo/eventosServicioCrud";
	}

	/**
	 * 
	 * @param model
	 * @param insert
	 * @param evento
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/eventos/save", method = RequestMethod.POST)
	public String saveEventos(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@ModelAttribute("insert") TablaEventoServicio insert,
			@RequestParam(value = "evento", defaultValue = "null") String evento, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.crudEventoServicio(evento, insert, model, request);
		return "redirect:/home/cat/apoyo/eventos/";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/home/cat/apoyo/servicios")
	public String viewServiciosParticulares(Model model,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow, HttpServletRequest request,
			@RequestParam(value = "id", defaultValue = "0") Integer id) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaServiciosParticulares(model, request);
		apoyoService.queryServiciosParticulares(count, model, request, fromRow, id);
		apoyoService.queryServiciosParticulares(consulta, model, request, fromRow, id);
		return "catalogo/apoyo/serviciosParticulares";
	}

	/**
	 * 
	 * @param model
	 * @param event
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/servicios/crud", method = RequestMethod.POST)
	public String operationServiciosParticulares(Model model,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "event", defaultValue = "none") String event,
			@RequestParam(value = "id", defaultValue = "0") Integer id, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.queryServiciosParticulares(consulta, model, request, fromRow, id);
		model.addAttribute(even, event);
		return "catalogo/apoyo/serviciosParticularesCrud";
	}

	/**
	 * 
	 * @param model
	 * @param insert
	 * @param evento
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/servicios/save", method = RequestMethod.POST)
	public String saveServiciosParticulares(Model model,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@ModelAttribute("insert") TablaServicioParticular insert,
			@RequestParam(value = "evento", defaultValue = "null") String evento, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.crudServiciosParticulares(model, request, evento, insert);
		return "redirect:/home/cat/apoyo/servicios/";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/home/cat/apoyo/categorias")
	public String viewIngreso(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			HttpServletRequest request, @RequestParam(value = "id", defaultValue = "0") Integer id) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaIngreso(model, request);
		apoyoService.queryIngreso(count, model, request, fromRow, id);
		apoyoService.queryIngreso(consulta, model, request, fromRow, id);
		return "catalogo/apoyo/ingreso";
	}


	@RequestMapping(value = "/home/cat/apoyo/categorias/consulta", method = RequestMethod.POST)
	public String showIngreso(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "id", defaultValue = "0") Integer id, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaIngreso(model, request);
		apoyoService.queryIngreso(count, model, request, fromRow, id);
		apoyoService.queryIngreso(consulta, model, request, fromRow, id);
		return "catalogo/apoyo/ingreso";
	}

	/**
	 * 
	 * @param model
	 * @param event
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/categorias/crud", method = RequestMethod.POST)
	public String operationIngreso(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@RequestParam(value = "event", defaultValue = "none") String event,
			@RequestParam(value = "id", defaultValue = "0") Integer id, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.queryIngreso(consulta, model, request, fromRow, id);
		model.addAttribute(even, event);
		return "catalogo/apoyo/ingresoCrud";
	}

	/**
	 * 
	 * @param model
	 * @param insert
	 * @param evento
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home/cat/apoyo/categorias/save", method = RequestMethod.POST)
	public String saveCategorias(Model model, @RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@ModelAttribute("insert") TablaIngreso insert,
			@RequestParam(value = "evento", defaultValue = "null") String evento, HttpServletRequest request) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.crudIngreso(model, request, evento, insert);
		return "redirect:/home/cat/apoyo/categorias/";
	}

	/**
	 * Actualizaciones
	 */
	@RequestMapping("/home/cat/apoyo/usuario")
	public String usuarioPorCliente() {

		return "catalogo/apoyo/usuarioCliente";
	}

	@RequestMapping("/home/cat/apoyo/clientes")
	public String clienteEnServicio(Model model, HttpServletRequest request,
			@RequestParam(value = "listaClienteEnServicio", defaultValue = "") String listaClienteEnServicio,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.queryclienteEnServicio(model, request, listaClienteEnServicio, "lista", fromRow);
		return "catalogo/apoyo/clienteServicio";
	}

	@RequestMapping(value = "/home/cat/apoyo/clientes/consulta", method = { RequestMethod.GET, RequestMethod.POST })
	public String consultaClienteEnServicio(Model model, HttpServletRequest request,
			@RequestParam(value = "listaClienteEnServicio", defaultValue = "sim") String listaClienteEnServicio,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			@ModelAttribute("listaClienteEnServicio") String listaClienteEnServicioModel) {
		procesoGeneral.loggerUsr(contr, request);
		
		if (listaClienteEnServicio.equals("sim")) {
			listaClienteEnServicio = listaClienteEnServicioModel;
		}
		
		model.addAttribute("listaClienteEnServicioModelo", listaClienteEnServicio);
		apoyoService.queryclienteEnServicio(model, request, listaClienteEnServicio, "lista", fromRow);
		apoyoService.queryclienteEnServicio(model, request, listaClienteEnServicio, count, fromRow);
		apoyoService.queryclienteEnServicio(model, request, listaClienteEnServicio, consulta, fromRow);
		apoyoService.queryclienteEnServicio(model, request, listaClienteEnServicio, "cliente", fromRow);
		return "catalogo/apoyo/clienteServicio";
	}

	@RequestMapping(value = "/home/cat/apoyo/clientes/save", method = RequestMethod.POST)
	public String saveClienteEnServicio(Model model, HttpServletRequest request, RedirectAttributes redirectAttributes,
			@RequestParam(value = "listaClienteServicio", defaultValue = "") String listaClienteServicio,
			@RequestParam(value = "listaClienteEnServicio", defaultValue = "") String listaClienteEnServicio,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.crudClienteEnServicio(model, request, listaClienteServicio, fromRow, "asignar");
		redirectAttributes.addFlashAttribute("listaClienteEnServicio", listaClienteEnServicio);
		redirectAttributes.addFlashAttribute("fromRow", 69);
		return "redirect:/home/cat/apoyo/clientes/consulta";
	}

	@RequestMapping("/home/cat/apoyo/banco")
	public String cuentasBanco(Model model, HttpServletRequest request, RedirectAttributes redirectAttributes,
			@RequestParam(value = "estatus", defaultValue = "ACT") String estatus,
			@RequestParam(value = "id_cuenta", defaultValue = "") Integer id_cuenta,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow) {
		procesoGeneral.loggerUsr(contr, request);
		apoyoService.queryBanco(count, model, request, redirectAttributes, id_cuenta, estatus, fromRow);
		apoyoService.queryBanco(consulta, model, request, redirectAttributes, id_cuenta, estatus, fromRow);
		return "catalogo/apoyo/banco";
	}

}