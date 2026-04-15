package com.prosa.sif.service;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prosa.sif.dao.PrincipalDao;
import com.prosa.sif.pojo.ViewClavesCliente;

@Service
public class PrincipalService {
	@Autowired
	private PrincipalDao principalDao;

	public void queryNegocio(String tipo, Integer fromRow, Integer idNegocio, Model model, HttpServletRequest request) {
		principalDao.queryNegocio(tipo, fromRow, idNegocio, model, request);
	}

	public void crudNegocio(String evento, String clave, String descripcion, String clave_metodopago_sat,
			String clave_usocfdi_sat, Integer id_proceso, Integer id_negocio_padre, Integer id_centro_costos,
			Integer cuenta_ingreso, String clave_gl, String comentarios, String concepto_carta, String usuario,
			String fecha_cre, String fecha_mod, Model model, HttpServletRequest request, Integer id_negocio,
			Integer id_grupo_edo_cuenta, String status) {
		principalDao.crudNegocio(evento, clave, descripcion, clave_metodopago_sat, clave_usocfdi_sat, id_proceso,
				id_negocio_padre, id_centro_costos, cuenta_ingreso, clave_gl, comentarios, concepto_carta, usuario,
				fecha_cre, fecha_mod, model, request, id_negocio, id_grupo_edo_cuenta, status);
	}

	public void queryServicio(String tipo, Integer fromRow, Integer servicio, Integer concepto, Integer volumen,
			String estatus, Integer negocio, Integer fuente, Model model, HttpServletRequest request) {
		principalDao.queryServicio(tipo, fromRow, servicio, concepto, volumen, estatus, negocio, fuente, model,
				request);
	}

	public void queryCliente(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			String clave_cliente, String nombre_corto, Integer clave_grupo, String estatus) {
		principalDao.queryCliente(tipo, model, request, fromRow, clave_cliente, nombre_corto, clave_grupo, estatus);
	}

	public void crudServicio(Model model, HttpServletRequest request, Integer id_servicios, Integer id_fuente,
			Integer id_negocio, Integer id_precio, Integer id_forma_pago, Integer id_grupo_vol,
			Integer id_grupo_concepto, Integer id_moneda_importe_adq, Integer id_moneda_adq, Integer id_centro_costos,
			String clave, String descripcion, String estatus, Integer b_adquisicion_auto,
			String periodicidad_adquisicion, String periodicidad_cobro, Integer dias_habiles_cobro,
			Integer dia_limite_solicitud, String b_habilitar_op_av, String realizar_envio, String realizar_reg_cont,
			String realizar_emision_fact, String b_auto_cobro, String b_auto_reg_cont, String b_incluir_rebate,
			String unidad_medida, String tipo_cargo, String sistem_cobro, String b_captura_imp_liquidado,
			Integer b_precio_controlado, Integer b_adquisicion_sin_iva, String b_info_extra_desc_subconcep,
			String b_info_extra_transaccion, String b_imp_cantidad_en_fact, String b_imp_costo_unitario, String usuario,
			String fecha_cre, String fecha_mod, String comentarios, String tipo_servicio, String realizar_calculo,
			String cuenta_ingreso, String umedida_factura, Integer id_serv_part, Integer id_cat_ingreso,
			String clave_servicio_sat, String clave_unidad_sat, String clave_impuesto_sat, String clave_factor_sat,
			BigDecimal valor_tasa_sat, String evento) {
		principalDao.crudServicio(model, request, id_servicios, id_fuente, id_negocio, id_precio, id_forma_pago,
				id_grupo_vol, id_grupo_concepto, id_moneda_importe_adq, id_moneda_adq, id_centro_costos, clave,
				descripcion, estatus, b_adquisicion_auto, periodicidad_adquisicion, periodicidad_cobro,
				dias_habiles_cobro, dia_limite_solicitud, b_habilitar_op_av, realizar_envio, realizar_reg_cont,
				realizar_emision_fact, b_auto_cobro, b_auto_reg_cont, b_incluir_rebate, unidad_medida, tipo_cargo,
				sistem_cobro, b_captura_imp_liquidado, b_precio_controlado, b_adquisicion_sin_iva,
				b_info_extra_desc_subconcep, b_info_extra_transaccion, b_imp_cantidad_en_fact, b_imp_costo_unitario,
				usuario, fecha_cre, fecha_mod, comentarios, tipo_servicio, realizar_calculo, cuenta_ingreso,
				umedida_factura, id_serv_part, id_cat_ingreso, clave_servicio_sat, clave_unidad_sat, clave_impuesto_sat,
				clave_factor_sat, valor_tasa_sat, evento);
	}

	public void queryHistorico(Model model, HttpServletRequest request, Integer id_servicios) {
		principalDao.queryHistorico(model, request, id_servicios);
	}

	public void queryPrecio(String tipo, Model model, HttpServletRequest request, Integer id_servicios,
			Integer id_precio) {
		principalDao.queryPrecio(tipo, model, request, id_servicios, id_precio);

	}

	public void crudPrecio(Model model, HttpServletRequest request, Integer id_servicios, Integer id_precio,
			String listaPrecios, String inputPrecio, String tipoPrecio, Integer inputMoneda,
			RedirectAttributes redirectAttributes) {
		principalDao.crudPrecio(model, request, id_servicios, id_precio, listaPrecios, inputPrecio, tipoPrecio,
				inputMoneda, redirectAttributes);
	}

	public void queryConcepto(String tipo, Model model, HttpServletRequest request, Integer id_servicios,
			Integer id_precio) {
		principalDao.queryConcepto(tipo, model, request, id_servicios, id_precio);
	}

	public void jasper(Model model, HttpServletRequest request, HttpServletResponse response, Integer servicio,
			Integer concepto, Integer volumen, String estatus, Integer negocio, Integer fuente, String tipo) {
		principalDao.jasper(model, request, response, servicio, concepto, volumen, estatus, negocio, fuente, tipo);

	}

	public void jasperClientes(Model model, HttpServletRequest request, HttpServletResponse response,
			String clave_cliente, String nombre_corto, Integer clave_grupo, String estatus, String tipo) {
		principalDao.jasperClientes(model, request, response, clave_cliente, nombre_corto, clave_grupo, estatus, tipo);

	}

	public void queryHistoricoCliente(Model model, HttpServletRequest request, Integer id_cliente) {
		principalDao.queryHistoricoCliente(model, request, id_cliente);

	}

	public void queryContacto(Model model, HttpServletRequest request, Integer id_cliente) {
		principalDao.queryContacto(model, request, id_cliente);

	}

	public void queryMetodoPago(Model model, HttpServletRequest request, Integer id_cliente) {
		principalDao.queryMetodoPago(model, request, id_cliente);
	}
//CAMBIO

	public void crudCliente(Model model, HttpServletRequest request, String evento, Integer fromRow, Integer id_cliente,
			String clave_cliente, String rfc, String curp, Integer fiid, String nombre_corto, String razon_social,
			Integer id_grupo_vol, String clave_formapago_sat, String numero_idfiscal_sat, String rfc_entidad_emi,
			String cuenta_bancaria, String nom_entidad_emi, Integer id_cuenta_banco, String b_cliente_consorcio,
			String b_cliente_socio, String b_incluir_rebate, Integer pct_iva, String inf_addicional,
			String inf_addicional_1, String comentarios) {
		principalDao.crudCliente(model, request, evento, fromRow, id_cliente, clave_cliente, rfc, curp, fiid,
				nombre_corto, razon_social, id_grupo_vol, clave_formapago_sat, numero_idfiscal_sat, rfc_entidad_emi,
				cuenta_bancaria, nom_entidad_emi, id_cuenta_banco, b_cliente_consorcio, b_cliente_socio,
				b_incluir_rebate, pct_iva, inf_addicional, inf_addicional_1, comentarios);

	}

	public void queryClavesCliente(String tipo,Model model, HttpServletRequest request, Integer id_cliente,Integer fromRow) {
		principalDao.queryClavesCliente(tipo,model, request, id_cliente,fromRow);
		
	}

	public List<ViewClavesCliente> buscarClavesCliente(Model model, HttpServletRequest request, Integer cliente,
			Integer fromRow) {
		return principalDao.buscarClavesCliente(model,request,cliente,fromRow);
	}

	public Integer saveClavesCliente(Model model, HttpServletRequest request, String clave, Integer adquirente,
			Integer cliente, String fuentesistema, Integer fuentesis,Integer agrupador) {
		return principalDao.saveClavesCliente(model,request,clave,adquirente,cliente,fuentesistema,fuentesis,agrupador);
	}

}
