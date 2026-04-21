/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 08/03/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prosa.sif.pojo.ViewClavesCliente;

public interface PrincipalDao {

	void queryNegocio(String tipo, Integer fromRow, Integer idNegocio, Model model, HttpServletRequest request);

	void crudNegocio(String evento, String clave, String descripcion, String clave_metodopago_sat,
			String clave_usocfdi_sat, Integer id_proceso, Integer id_negocio_padre, Integer id_centro_costos,
			Integer cuenta_ingreso, String clave_gl, String comentarios, String concepto_carta, String usuario,
			String fecha_cre, String fecha_mod, Model model, HttpServletRequest request, Integer id_negocio,
			Integer id_grupo_edo_cuenta, String status);

	void queryServicio(String tipo, Integer fromRow, Integer servicio, Integer concepto, Integer volumen,
			String estatus, Integer negocio, Integer fuente, Model model, HttpServletRequest request);

	void queryCliente(String tipo, Model model, HttpServletRequest request, Integer fromRow, String clave_cliente,
			String nombre_corto, Integer clave_grupo, String estatus);

	void crudServicio(Model model, HttpServletRequest request, Integer id_servicios, Integer id_fuente,
			Integer id_negocio, Integer id_precio, Integer id_forma_pago, Integer id_grupo_vol,
			Integer id_grupo_concepto, Integer id_moneda_importe_adq, Integer id_moneda_adq, Integer id_centro_costos,
			String clave, String descripcion, String estatus, Integer b_adquisicion_auto,
			String periodicidad_adquisicion, String periodicidad_cobro, Integer dias_habiles_cobro,
			Integer dia_limite_solicitud, String b_habilitar_op_av, String realizar_envio, String realizar_reg_cont,
			String realizar_emision_fact, String b_auto_cobro, String b_auto_reg_cont, String b_incluir_rebate,
			String unidad_medida, String tipo_cargo, String sistem_cobro, String b_captura_imp_liquidado,
			Integer b_precio_controlado, Integer b_adquisicion_sin_iva, String b_info_extra_desc_subconcep,
			String b_info_extra_transaccion, String b_imp_cantidad_en_fact, String b_imp_costo_unitario,
			String usuario, String fecha_cre, String fecha_mod, String comentarios, String tipo_servicio,
			String realizar_calculo, String cuenta_ingreso, String umedida_factura, Integer id_serv_part,
			Integer id_cat_ingreso, String clave_servicio_sat, String clave_unidad_sat, String clave_impuesto_sat,
			String clave_factor_sat, BigDecimal valor_tasa_sat, String evento);


	void queryHistorico(Model model, HttpServletRequest request, Integer id_servicios);

	void queryPrecio(String tipo, Model model, HttpServletRequest request, Integer id_servicios, Integer id_precio);

	void crudPrecio(Model model, HttpServletRequest request, Integer id_servicios, Integer id_precio,
			String listaPrecios, String inputPrecio, String tipoPrecio, Integer inputMoneda,
			RedirectAttributes redirectAttributes);

	void queryConcepto(String tipo, Model model, HttpServletRequest request, Integer id_servicios, Integer id_precio);

	void jasper(Model model, HttpServletRequest request, HttpServletResponse response, Integer servicio, Integer concepto, 
			Integer volumen, String estatus, Integer negocio, Integer fuente, String tipo);

	void jasperClientes(Model model, HttpServletRequest request, HttpServletResponse response, String clave_cliente,
			String nombre_corto, Integer clave_grupo, String estatus, String tipo);

	void queryHistoricoCliente(Model model, HttpServletRequest request, Integer id_cliente);

	void queryContacto(Model model, HttpServletRequest request, Integer id_cliente);

	void queryMetodoPago(Model model, HttpServletRequest request, Integer id_cliente);
//CAMBIO

	void crudCliente(Model model, HttpServletRequest request, String evento, Integer fromRow, Integer id_cliente,
			String clave_cliente, String rfc, String curp, Integer fiid, String nombre_corto, String razon_social,
			Integer id_grupo_vol, String clave_formapago_sat, String numero_idfiscal_sat, String rfc_entidad_emi,
			String cuenta_bancaria, String nom_entidad_emi, Integer id_cuenta_banco, String b_cliente_consorcio,
			String b_cliente_socio, String b_incluir_rebate, Integer pct_iva, String inf_addicional,
			String inf_addicional_1, String comentarios);

	void queryClavesCliente(String tipo,Model model, HttpServletRequest request, Integer id_cliente,Integer fromRow);

	List<ViewClavesCliente> buscarClavesCliente(Model model, HttpServletRequest request, Integer cliente,
			Integer fromRow);

	Integer saveClavesCliente(Model model, HttpServletRequest request, String clave, Integer adquirente,
			Integer cliente, String fuentesistema, Integer fuentesis,Integer agrupador);


}
