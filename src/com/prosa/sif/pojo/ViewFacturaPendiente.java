package com.prosa.sif.pojo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "V_SIF_FACTURAS_PENDIENTES")
public class ViewFacturaPendiente {
	@Id
	private BigDecimal total_importe;
	private String clave_cliente;
	private BigDecimal total_transacs;
	private BigDecimal id_cliente;
	private String descripcion_negocio;
	private BigDecimal total_desc_especial;
	private BigDecimal id_moneda;
	private String descripcion_grupo_concepto;
	private BigDecimal id_centro_costos;
	private BigDecimal total_desc_adic_vol;
	private String nombre_corto_cliente;
	private String clave_grupo_concepto;
	private BigDecimal id_resumen;
	private BigDecimal porc_iva_cliente;
	private String clave_servicio_sat;
	private String clave_impuesto_sat;
	private BigDecimal precio_unitario;
	private BigDecimal valor_tasa_sat;
	private BigDecimal id_proceso;
	private BigDecimal total_liquidado_periodo;
	private BigDecimal id_servicio;
	private BigDecimal total_importe_neto;
	private String b_incluye_rebate;
	private BigDecimal id_negocio;
	private String clave_negocio;
	private BigDecimal id_grupo;
	private BigDecimal total_importe_iva;
	private String descripcion_servicio;
	private BigDecimal id_periodo;
	private String clave_unidad_sat;
	private String clave_factor_sat;
	private String clave_servicio;

	public ViewFacturaPendiente() {
	}

	public ViewFacturaPendiente(BigDecimal total_importe, String clave_cliente, BigDecimal total_transacs,
			BigDecimal id_cliente, String descripcion_negocio, BigDecimal total_desc_especial, BigDecimal id_moneda,
			String descripcion_grupo_concepto, BigDecimal id_centro_costos, BigDecimal total_desc_adic_vol,
			String nombre_corto_cliente, String clave_grupo_concepto, BigDecimal id_resumen,
			BigDecimal porc_iva_cliente, String clave_servicio_sat, String clave_impuesto_sat,
			BigDecimal precio_unitario, BigDecimal valor_tasa_sat, BigDecimal id_proceso,
			BigDecimal total_liquidado_periodo, BigDecimal id_servicio, BigDecimal total_importe_neto,
			String b_incluye_rebate, BigDecimal id_negocio, String clave_negocio, BigDecimal id_grupo,
			BigDecimal total_importe_iva, String descripcion_servicio, BigDecimal id_periodo, String clave_unidad_sat,
			String clave_factor_sat, String clave_servicio) {
		super();
		this.total_importe = total_importe;
		this.clave_cliente = clave_cliente;
		this.total_transacs = total_transacs;
		this.id_cliente = id_cliente;
		this.descripcion_negocio = descripcion_negocio;
		this.total_desc_especial = total_desc_especial;
		this.id_moneda = id_moneda;
		this.descripcion_grupo_concepto = descripcion_grupo_concepto;
		this.id_centro_costos = id_centro_costos;
		this.total_desc_adic_vol = total_desc_adic_vol;
		this.nombre_corto_cliente = nombre_corto_cliente;
		this.clave_grupo_concepto = clave_grupo_concepto;
		this.id_resumen = id_resumen;
		this.porc_iva_cliente = porc_iva_cliente;
		this.clave_servicio_sat = clave_servicio_sat;
		this.clave_impuesto_sat = clave_impuesto_sat;
		this.precio_unitario = precio_unitario;
		this.valor_tasa_sat = valor_tasa_sat;
		this.id_proceso = id_proceso;
		this.total_liquidado_periodo = total_liquidado_periodo;
		this.id_servicio = id_servicio;
		this.total_importe_neto = total_importe_neto;
		this.b_incluye_rebate = b_incluye_rebate;
		this.id_negocio = id_negocio;
		this.clave_negocio = clave_negocio;
		this.id_grupo = id_grupo;
		this.total_importe_iva = total_importe_iva;
		this.descripcion_servicio = descripcion_servicio;
		this.id_periodo = id_periodo;
		this.clave_unidad_sat = clave_unidad_sat;
		this.clave_factor_sat = clave_factor_sat;
		this.clave_servicio = clave_servicio;
	}

	public BigDecimal getTotal_importe() {
		return total_importe;
	}

	public void setTotal_importe(BigDecimal total_importe) {
		this.total_importe = total_importe;
	}

	public String getClave_cliente() {
		return clave_cliente;
	}

	public void setClave_cliente(String clave_cliente) {
		this.clave_cliente = clave_cliente;
	}

	public BigDecimal getTotal_transacs() {
		return total_transacs;
	}

	public void setTotal_transacs(BigDecimal total_transacs) {
		this.total_transacs = total_transacs;
	}

	public BigDecimal getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(BigDecimal id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getDescripcion_negocio() {
		return descripcion_negocio;
	}

	public void setDescripcion_negocio(String descripcion_negocio) {
		this.descripcion_negocio = descripcion_negocio;
	}

	public BigDecimal getTotal_desc_especial() {
		return total_desc_especial;
	}

	public void setTotal_desc_especial(BigDecimal total_desc_especial) {
		this.total_desc_especial = total_desc_especial;
	}

	public BigDecimal getId_moneda() {
		return id_moneda;
	}

	public void setId_moneda(BigDecimal id_moneda) {
		this.id_moneda = id_moneda;
	}

	public String getDescripcion_grupo_concepto() {
		return descripcion_grupo_concepto;
	}

	public void setDescripcion_grupo_concepto(String descripcion_grupo_concepto) {
		this.descripcion_grupo_concepto = descripcion_grupo_concepto;
	}

	public BigDecimal getId_centro_costos() {
		return id_centro_costos;
	}

	public void setId_centro_costos(BigDecimal id_centro_costos) {
		this.id_centro_costos = id_centro_costos;
	}

	public BigDecimal getTotal_desc_adic_vol() {
		return total_desc_adic_vol;
	}

	public void setTotal_desc_adic_vol(BigDecimal total_desc_adic_vol) {
		this.total_desc_adic_vol = total_desc_adic_vol;
	}

	public String getNombre_corto_cliente() {
		return nombre_corto_cliente;
	}

	public void setNombre_corto_cliente(String nombre_corto_cliente) {
		this.nombre_corto_cliente = nombre_corto_cliente;
	}

	public String getClave_grupo_concepto() {
		return clave_grupo_concepto;
	}

	public void setClave_grupo_concepto(String clave_grupo_concepto) {
		this.clave_grupo_concepto = clave_grupo_concepto;
	}

	public BigDecimal getId_resumen() {
		return id_resumen;
	}

	public void setId_resumen(BigDecimal id_resumen) {
		this.id_resumen = id_resumen;
	}

	public BigDecimal getPorc_iva_cliente() {
		return porc_iva_cliente;
	}

	public void setPorc_iva_cliente(BigDecimal porc_iva_cliente) {
		this.porc_iva_cliente = porc_iva_cliente;
	}

	public String getClave_servicio_sat() {
		return clave_servicio_sat;
	}

	public void setClave_servicio_sat(String clave_servicio_sat) {
		this.clave_servicio_sat = clave_servicio_sat;
	}

	public String getClave_impuesto_sat() {
		return clave_impuesto_sat;
	}

	public void setClave_impuesto_sat(String clave_impuesto_sat) {
		this.clave_impuesto_sat = clave_impuesto_sat;
	}

	public BigDecimal getPrecio_unitario() {
		return precio_unitario;
	}

	public void setPrecio_unitario(BigDecimal precio_unitario) {
		this.precio_unitario = precio_unitario;
	}

	public BigDecimal getValor_tasa_sat() {
		return valor_tasa_sat;
	}

	public void setValor_tasa_sat(BigDecimal valor_tasa_sat) {
		this.valor_tasa_sat = valor_tasa_sat;
	}

	public BigDecimal getId_proceso() {
		return id_proceso;
	}

	public void setId_proceso(BigDecimal id_proceso) {
		this.id_proceso = id_proceso;
	}

	public BigDecimal getTotal_liquidado_periodo() {
		return total_liquidado_periodo;
	}

	public void setTotal_liquidado_periodo(BigDecimal total_liquidado_periodo) {
		this.total_liquidado_periodo = total_liquidado_periodo;
	}

	public BigDecimal getId_servicio() {
		return id_servicio;
	}

	public void setId_servicio(BigDecimal id_servicio) {
		this.id_servicio = id_servicio;
	}

	public BigDecimal getTotal_importe_neto() {
		return total_importe_neto;
	}

	public void setTotal_importe_neto(BigDecimal total_importe_neto) {
		this.total_importe_neto = total_importe_neto;
	}

	public String getB_incluye_rebate() {
		return b_incluye_rebate;
	}

	public void setB_incluye_rebate(String b_incluye_rebate) {
		this.b_incluye_rebate = b_incluye_rebate;
	}

	public BigDecimal getId_negocio() {
		return id_negocio;
	}

	public void setId_negocio(BigDecimal id_negocio) {
		this.id_negocio = id_negocio;
	}

	public String getClave_negocio() {
		return clave_negocio;
	}

	public void setClave_negocio(String clave_negocio) {
		this.clave_negocio = clave_negocio;
	}

	public BigDecimal getId_grupo() {
		return id_grupo;
	}

	public void setId_grupo(BigDecimal id_grupo) {
		this.id_grupo = id_grupo;
	}

	public BigDecimal getTotal_importe_iva() {
		return total_importe_iva;
	}

	public void setTotal_importe_iva(BigDecimal total_importe_iva) {
		this.total_importe_iva = total_importe_iva;
	}

	public String getDescripcion_servicio() {
		return descripcion_servicio;
	}

	public void setDescripcion_servicio(String descripcion_servicio) {
		this.descripcion_servicio = descripcion_servicio;
	}

	public BigDecimal getId_periodo() {
		return id_periodo;
	}

	public void setId_periodo(BigDecimal id_periodo) {
		this.id_periodo = id_periodo;
	}

	public String getClave_unidad_sat() {
		return clave_unidad_sat;
	}

	public void setClave_unidad_sat(String clave_unidad_sat) {
		this.clave_unidad_sat = clave_unidad_sat;
	}

	public String getClave_factor_sat() {
		return clave_factor_sat;
	}

	public void setClave_factor_sat(String clave_factor_sat) {
		this.clave_factor_sat = clave_factor_sat;
	}

	public String getClave_servicio() {
		return clave_servicio;
	}

	public void setClave_servicio(String clave_servicio) {
		this.clave_servicio = clave_servicio;
	}

	@Override
	public String toString() {
		return "ViewFacturaPendiente [total_importe=" + total_importe + ", clave_cliente=" + clave_cliente
				+ ", total_transacs=" + total_transacs + ", id_cliente=" + id_cliente + ", descripcion_negocio="
				+ descripcion_negocio + ", total_desc_especial=" + total_desc_especial + ", id_moneda=" + id_moneda
				+ ", descripcion_grupo_concepto=" + descripcion_grupo_concepto + ", id_centro_costos="
				+ id_centro_costos + ", total_desc_adic_vol=" + total_desc_adic_vol + ", nombre_corto_cliente="
				+ nombre_corto_cliente + ", clave_grupo_concepto=" + clave_grupo_concepto + ", id_resumen=" + id_resumen
				+ ", porc_iva_cliente=" + porc_iva_cliente + ", clave_servicio_sat=" + clave_servicio_sat
				+ ", clave_impuesto_sat=" + clave_impuesto_sat + ", precio_unitario=" + precio_unitario
				+ ", valor_tasa_sat=" + valor_tasa_sat + ", id_proceso=" + id_proceso + ", total_liquidado_periodo="
				+ total_liquidado_periodo + ", id_servicio=" + id_servicio + ", total_importe_neto="
				+ total_importe_neto + ", b_incluye_rebate=" + b_incluye_rebate + ", id_negocio=" + id_negocio
				+ ", clave_negocio=" + clave_negocio + ", id_grupo=" + id_grupo + ", total_importe_iva="
				+ total_importe_iva + ", descripcion_servicio=" + descripcion_servicio + ", id_periodo=" + id_periodo
				+ ", clave_unidad_sat=" + clave_unidad_sat + ", clave_factor_sat=" + clave_factor_sat
				+ ", clave_servicio=" + clave_servicio + "]";
	}
}