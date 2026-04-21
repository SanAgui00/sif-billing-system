/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 08/03/2018 #
# Descripcion General : Pojo para mapeo de TBL_SIF_SERVICIOS                   #
# Marca del cambio    : 									                   #
#------------------------------------------------------------------------------#
# Numero de Parametros: N/A                                                    #
# Parametros Entrada  : N/A                                  Formato:          #
# Parametros Salida   : N/A                                  Formato:          #
################################################################################
**/
package com.prosa.sif.pojo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_SERVICIOS")
public class TBL_SIF_SERVICIOS {

	@Id
	private Integer id_servicios;
	private Integer id_fuente;
	private Integer id_negocio;
	private Integer id_precio;
	private Integer id_forma_pago;
	private Integer id_grupo_vol;
	private Integer id_grupo_concepto;
	private Integer id_moneda_importe_adq;
	private Integer id_moneda_adq;
	private Integer id_centro_costos;
	private String clave;
	private String descripcion;
	private String estatus;
	private BigDecimal b_adquisicion_auto;
	private String periodicidad_adquisicion;
	private String periodicidad_cobro;
	private BigDecimal dias_habiles_cobro;
	private BigDecimal dia_limite_solicitud;
	private BigDecimal b_habilitar_op_av;
	private String realizar_envio;
	private String realizar_reg_cont;
	private String realizar_emision_fact;
	private String b_auto_cobro;
	private String b_auto_reg_cont;
	private BigDecimal b_incluir_rebate;
	private String unidad_medida;
	private String tipo_cargo;
	private String sistem_cobro;
	private BigDecimal b_captura_imp_liquidado;
	private BigDecimal b_precio_controlado;
	private BigDecimal b_adquisicion_sin_iva;
	private BigDecimal b_info_extra_desc_subconcep;
	private BigDecimal b_info_extra_transaccion;
	private BigDecimal b_imp_cantidad_en_fact;
	private BigDecimal b_imp_costo_unitario;
	private String usuario;
	private Date fecha_cre;
	private Date fecha_mod;
	private String comentarios;
	private String tipo_servicio;
	private String realizar_calculo;
	private String cuenta_ingreso;
	private String umedida_factura;
	private Integer id_serv_part;
	private Integer id_cat_ingreso;
	private String clave_servicio_sat;
	private String clave_unidad_sat;
	private String clave_impuesto_sat;
	private String clave_factor_sat;
	private BigDecimal valor_tasa_sat;

	public TBL_SIF_SERVICIOS() {

	}

	public TBL_SIF_SERVICIOS(Integer id_servicios, Integer id_fuente, Integer id_negocio, Integer id_precio,
			Integer id_forma_pago, Integer id_grupo_vol, Integer id_grupo_concepto, Integer id_moneda_importe_adq,
			Integer id_moneda_adq, Integer id_centro_costos, String clave, String descripcion, String estatus,
			BigDecimal b_adquisicion_auto, String periodicidad_adquisicion, String periodicidad_cobro,
			BigDecimal dias_habiles_cobro, BigDecimal dia_limite_solicitud, BigDecimal b_habilitar_op_av,
			String realizar_envio, String realizar_reg_cont, String realizar_emision_fact, String b_auto_cobro,
			String b_auto_reg_cont, BigDecimal b_incluir_rebate, String unidad_medida, String tipo_cargo,
			String sistem_cobro, BigDecimal b_captura_imp_liquidado, BigDecimal b_precio_controlado,
			BigDecimal b_adquisicion_sin_iva, BigDecimal b_info_extra_desc_subconcep,
			BigDecimal b_info_extra_transaccion, BigDecimal b_imp_cantidad_en_fact, BigDecimal b_imp_costo_unitario,
			String usuario, Date fecha_cre, Date fecha_mod, String comentarios, String tipo_servicio,
			String realizar_calculo, String cuenta_ingreso, String umedida_factura, Integer id_serv_part,
			Integer id_cat_ingreso, String clave_servicio_sat, String clave_unidad_sat, String clave_impuesto_sat,
			String clave_factor_sat, BigDecimal valor_tasa_sat) {
		super();
		this.id_servicios = id_servicios;
		this.id_fuente = id_fuente;
		this.id_negocio = id_negocio;
		this.id_precio = id_precio;
		this.id_forma_pago = id_forma_pago;
		this.id_grupo_vol = id_grupo_vol;
		this.id_grupo_concepto = id_grupo_concepto;
		this.id_moneda_importe_adq = id_moneda_importe_adq;
		this.id_moneda_adq = id_moneda_adq;
		this.id_centro_costos = id_centro_costos;
		this.clave = clave;
		this.descripcion = descripcion;
		this.estatus = estatus;
		this.b_adquisicion_auto = b_adquisicion_auto;
		this.periodicidad_adquisicion = periodicidad_adquisicion;
		this.periodicidad_cobro = periodicidad_cobro;
		this.dias_habiles_cobro = dias_habiles_cobro;
		this.dia_limite_solicitud = dia_limite_solicitud;
		this.b_habilitar_op_av = b_habilitar_op_av;
		this.realizar_envio = realizar_envio;
		this.realizar_reg_cont = realizar_reg_cont;
		this.realizar_emision_fact = realizar_emision_fact;
		this.b_auto_cobro = b_auto_cobro;
		this.b_auto_reg_cont = b_auto_reg_cont;
		this.b_incluir_rebate = b_incluir_rebate;
		this.unidad_medida = unidad_medida;
		this.tipo_cargo = tipo_cargo;
		this.sistem_cobro = sistem_cobro;
		this.b_captura_imp_liquidado = b_captura_imp_liquidado;
		this.b_precio_controlado = b_precio_controlado;
		this.b_adquisicion_sin_iva = b_adquisicion_sin_iva;
		this.b_info_extra_desc_subconcep = b_info_extra_desc_subconcep;
		this.b_info_extra_transaccion = b_info_extra_transaccion;
		this.b_imp_cantidad_en_fact = b_imp_cantidad_en_fact;
		this.b_imp_costo_unitario = b_imp_costo_unitario;
		this.usuario = usuario;
		this.fecha_cre = fecha_cre;
		this.fecha_mod = fecha_mod;
		this.comentarios = comentarios;
		this.tipo_servicio = tipo_servicio;
		this.realizar_calculo = realizar_calculo;
		this.cuenta_ingreso = cuenta_ingreso;
		this.umedida_factura = umedida_factura;
		this.id_serv_part = id_serv_part;
		this.id_cat_ingreso = id_cat_ingreso;
		this.clave_servicio_sat = clave_servicio_sat;
		this.clave_unidad_sat = clave_unidad_sat;
		this.clave_impuesto_sat = clave_impuesto_sat;
		this.clave_factor_sat = clave_factor_sat;
		this.valor_tasa_sat = valor_tasa_sat;
	}

	public Integer getId_servicios() {
		return id_servicios;
	}

	public void setId_servicios(Integer id_servicios) {
		this.id_servicios = id_servicios;
	}

	public Integer getId_fuente() {
		return id_fuente;
	}

	public void setId_fuente(Integer id_fuente) {
		this.id_fuente = id_fuente;
	}

	public Integer getId_negocio() {
		return id_negocio;
	}

	public void setId_negocio(Integer id_negocio) {
		this.id_negocio = id_negocio;
	}

	public Integer getId_precio() {
		return id_precio;
	}

	public void setId_precio(Integer id_precio) {
		this.id_precio = id_precio;
	}

	public Integer getId_forma_pago() {
		return id_forma_pago;
	}

	public void setId_forma_pago(Integer id_forma_pago) {
		this.id_forma_pago = id_forma_pago;
	}

	public Integer getId_grupo_vol() {
		return id_grupo_vol;
	}

	public void setId_grupo_vol(Integer id_grupo_vol) {
		this.id_grupo_vol = id_grupo_vol;
	}

	public Integer getId_grupo_concepto() {
		return id_grupo_concepto;
	}

	public void setId_grupo_concepto(Integer id_grupo_concepto) {
		this.id_grupo_concepto = id_grupo_concepto;
	}

	public Integer getId_moneda_importe_adq() {
		return id_moneda_importe_adq;
	}

	public void setId_moneda_importe_adq(Integer id_moneda_importe_adq) {
		this.id_moneda_importe_adq = id_moneda_importe_adq;
	}

	public Integer getId_moneda_adq() {
		return id_moneda_adq;
	}

	public void setId_moneda_adq(Integer id_moneda_adq) {
		this.id_moneda_adq = id_moneda_adq;
	}

	public Integer getId_centro_costos() {
		return id_centro_costos;
	}

	public void setId_centro_costos(Integer id_centro_costos) {
		this.id_centro_costos = id_centro_costos;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public BigDecimal getB_adquisicion_auto() {
		return b_adquisicion_auto;
	}

	public void setB_adquisicion_auto(BigDecimal b_adquisicion_auto) {
		this.b_adquisicion_auto = b_adquisicion_auto;
	}

	public String getPeriodicidad_adquisicion() {
		return periodicidad_adquisicion;
	}

	public void setPeriodicidad_adquisicion(String periodicidad_adquisicion) {
		this.periodicidad_adquisicion = periodicidad_adquisicion;
	}

	public String getPeriodicidad_cobro() {
		return periodicidad_cobro;
	}

	public void setPeriodicidad_cobro(String periodicidad_cobro) {
		this.periodicidad_cobro = periodicidad_cobro;
	}

	public BigDecimal getDias_habiles_cobro() {
		return dias_habiles_cobro;
	}

	public void setDias_habiles_cobro(BigDecimal dias_habiles_cobro) {
		this.dias_habiles_cobro = dias_habiles_cobro;
	}

	public BigDecimal getDia_limite_solicitud() {
		return dia_limite_solicitud;
	}

	public void setDia_limite_solicitud(BigDecimal dia_limite_solicitud) {
		this.dia_limite_solicitud = dia_limite_solicitud;
	}

	public BigDecimal getB_habilitar_op_av() {
		return b_habilitar_op_av;
	}

	public void setB_habilitar_op_av(BigDecimal b_habilitar_op_av) {
		this.b_habilitar_op_av = b_habilitar_op_av;
	}

	public String getRealizar_envio() {
		return realizar_envio;
	}

	public void setRealizar_envio(String realizar_envio) {
		this.realizar_envio = realizar_envio;
	}

	public String getRealizar_reg_cont() {
		return realizar_reg_cont;
	}

	public void setRealizar_reg_cont(String realizar_reg_cont) {
		this.realizar_reg_cont = realizar_reg_cont;
	}

	public String getRealizar_emision_fact() {
		return realizar_emision_fact;
	}

	public void setRealizar_emision_fact(String realizar_emision_fact) {
		this.realizar_emision_fact = realizar_emision_fact;
	}

	public String getB_auto_cobro() {
		return b_auto_cobro;
	}

	public void setB_auto_cobro(String b_auto_cobro) {
		this.b_auto_cobro = b_auto_cobro;
	}

	public String getB_auto_reg_cont() {
		return b_auto_reg_cont;
	}

	public void setB_auto_reg_cont(String b_auto_reg_cont) {
		this.b_auto_reg_cont = b_auto_reg_cont;
	}

	public BigDecimal getB_incluir_rebate() {
		return b_incluir_rebate;
	}

	public void setB_incluir_rebate(BigDecimal b_incluir_rebate) {
		this.b_incluir_rebate = b_incluir_rebate;
	}

	public String getUnidad_medida() {
		return unidad_medida;
	}

	public void setUnidad_medida(String unidad_medida) {
		this.unidad_medida = unidad_medida;
	}

	public String getTipo_cargo() {
		return tipo_cargo;
	}

	public void setTipo_cargo(String tipo_cargo) {
		this.tipo_cargo = tipo_cargo;
	}

	public String getSistem_cobro() {
		return sistem_cobro;
	}

	public void setSistem_cobro(String sistem_cobro) {
		this.sistem_cobro = sistem_cobro;
	}

	public BigDecimal getB_captura_imp_liquidado() {
		return b_captura_imp_liquidado;
	}

	public void setB_captura_imp_liquidado(BigDecimal b_captura_imp_liquidado) {
		this.b_captura_imp_liquidado = b_captura_imp_liquidado;
	}

	public BigDecimal getB_precio_controlado() {
		return b_precio_controlado;
	}

	public void setB_precio_controlado(BigDecimal b_precio_controlado) {
		this.b_precio_controlado = b_precio_controlado;
	}

	public BigDecimal getB_adquisicion_sin_iva() {
		return b_adquisicion_sin_iva;
	}

	public void setB_adquisicion_sin_iva(BigDecimal b_adquisicion_sin_iva) {
		this.b_adquisicion_sin_iva = b_adquisicion_sin_iva;
	}

	public BigDecimal getB_info_extra_desc_subconcep() {
		return b_info_extra_desc_subconcep;
	}

	public void setB_info_extra_desc_subconcep(BigDecimal b_info_extra_desc_subconcep) {
		this.b_info_extra_desc_subconcep = b_info_extra_desc_subconcep;
	}

	public BigDecimal getB_info_extra_transaccion() {
		return b_info_extra_transaccion;
	}

	public void setB_info_extra_transaccion(BigDecimal b_info_extra_transaccion) {
		this.b_info_extra_transaccion = b_info_extra_transaccion;
	}

	public BigDecimal getB_imp_cantidad_en_fact() {
		return b_imp_cantidad_en_fact;
	}

	public void setB_imp_cantidad_en_fact(BigDecimal b_imp_cantidad_en_fact) {
		this.b_imp_cantidad_en_fact = b_imp_cantidad_en_fact;
	}

	public BigDecimal getB_imp_costo_unitario() {
		return b_imp_costo_unitario;
	}

	public void setB_imp_costo_unitario(BigDecimal b_imp_costo_unitario) {
		this.b_imp_costo_unitario = b_imp_costo_unitario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getFecha_cre() {
		return fecha_cre;
	}

	public void setFecha_cre(Date fecha_cre) {
		this.fecha_cre = fecha_cre;
	}

	public Date getFecha_mod() {
		return fecha_mod;
	}

	public void setFecha_mod(Date fecha_mod) {
		this.fecha_mod = fecha_mod;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getTipo_servicio() {
		return tipo_servicio;
	}

	public void setTipo_servicio(String tipo_servicio) {
		this.tipo_servicio = tipo_servicio;
	}

	public String getRealizar_calculo() {
		return realizar_calculo;
	}

	public void setRealizar_calculo(String realizar_calculo) {
		this.realizar_calculo = realizar_calculo;
	}

	public String getCuenta_ingreso() {
		return cuenta_ingreso;
	}

	public void setCuenta_ingreso(String cuenta_ingreso) {
		this.cuenta_ingreso = cuenta_ingreso;
	}

	public String getUmedida_factura() {
		return umedida_factura;
	}

	public void setUmedida_factura(String umedida_factura) {
		this.umedida_factura = umedida_factura;
	}

	public Integer getId_serv_part() {
		return id_serv_part;
	}

	public void setId_serv_part(Integer id_serv_part) {
		this.id_serv_part = id_serv_part;
	}

	public Integer getId_cat_ingreso() {
		return id_cat_ingreso;
	}

	public void setId_cat_ingreso(Integer id_cat_ingreso) {
		this.id_cat_ingreso = id_cat_ingreso;
	}

	public String getClave_servicio_sat() {
		return clave_servicio_sat;
	}

	public void setClave_servicio_sat(String clave_servicio_sat) {
		this.clave_servicio_sat = clave_servicio_sat;
	}

	public String getClave_unidad_sat() {
		return clave_unidad_sat;
	}

	public void setClave_unidad_sat(String clave_unidad_sat) {
		this.clave_unidad_sat = clave_unidad_sat;
	}

	public String getClave_impuesto_sat() {
		return clave_impuesto_sat;
	}

	public void setClave_impuesto_sat(String clave_impuesto_sat) {
		this.clave_impuesto_sat = clave_impuesto_sat;
	}

	public String getClave_factor_sat() {
		return clave_factor_sat;
	}

	public void setClave_factor_sat(String clave_factor_sat) {
		this.clave_factor_sat = clave_factor_sat;
	}

	public BigDecimal getValor_tasa_sat() {
		return valor_tasa_sat;
	}

	public void setValor_tasa_sat(BigDecimal valor_tasa_sat) {
		this.valor_tasa_sat = valor_tasa_sat;
	}

	@Override
	public String toString() {
		return "TBL_SIF_SERVICIOS [id_servicios=" + id_servicios + ", id_fuente=" + id_fuente + ", id_negocio="
				+ id_negocio + ", id_precio=" + id_precio + ", id_forma_pago=" + id_forma_pago + ", id_grupo_vol="
				+ id_grupo_vol + ", id_grupo_concepto=" + id_grupo_concepto + ", id_moneda_importe_adq="
				+ id_moneda_importe_adq + ", id_moneda_adq=" + id_moneda_adq + ", id_centro_costos=" + id_centro_costos
				+ ", clave=" + clave + ", descripcion=" + descripcion + ", estatus=" + estatus + ", b_adquisicion_auto="
				+ b_adquisicion_auto + ", periodicidad_adquisicion=" + periodicidad_adquisicion
				+ ", periodicidad_cobro=" + periodicidad_cobro + ", dias_habiles_cobro=" + dias_habiles_cobro
				+ ", dia_limite_solicitud=" + dia_limite_solicitud + ", b_habilitar_op_av=" + b_habilitar_op_av
				+ ", realizar_envio=" + realizar_envio + ", realizar_reg_cont=" + realizar_reg_cont
				+ ", realizar_emision_fact=" + realizar_emision_fact + ", b_auto_cobro=" + b_auto_cobro
				+ ", b_auto_reg_cont=" + b_auto_reg_cont + ", b_incluir_rebate=" + b_incluir_rebate + ", unidad_medida="
				+ unidad_medida + ", tipo_cargo=" + tipo_cargo + ", sistem_cobro=" + sistem_cobro
				+ ", b_captura_imp_liquidado=" + b_captura_imp_liquidado + ", b_precio_controlado="
				+ b_precio_controlado + ", b_adquisicion_sin_iva=" + b_adquisicion_sin_iva
				+ ", b_info_extra_desc_subconcep=" + b_info_extra_desc_subconcep + ", b_info_extra_transaccion="
				+ b_info_extra_transaccion + ", b_imp_cantidad_en_fact=" + b_imp_cantidad_en_fact
				+ ", b_imp_costo_unitario=" + b_imp_costo_unitario + ", usuario=" + usuario + ", fecha_cre=" + fecha_cre
				+ ", fecha_mod=" + fecha_mod + ", comentarios=" + comentarios + ", tipo_servicio=" + tipo_servicio
				+ ", realizar_calculo=" + realizar_calculo + ", cuenta_ingreso=" + cuenta_ingreso + ", umedida_factura="
				+ umedida_factura + ", id_serv_part=" + id_serv_part + ", id_cat_ingreso=" + id_cat_ingreso
				+ ", clave_servicio_sat=" + clave_servicio_sat + ", clave_unidad_sat=" + clave_unidad_sat
				+ ", clave_impuesto_sat=" + clave_impuesto_sat + ", clave_factor_sat=" + clave_factor_sat
				+ ", valor_tasa_sat=" + valor_tasa_sat + "]";
	}

}
