/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 13/09/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.pojo;

import java.math.BigDecimal;

public class SOPORTE_SERVICIOS_JASPER {

	private String cv_negocio;
	private String dc_negocio;
	private String banco;
	private String nombre_corto;
	private String servicio;
	private String descripcion;
	private BigDecimal mt_dispensado_dls;
	private BigDecimal mt_dispensado_ps;
	private BigDecimal mt_crossborder_dls;
	private BigDecimal tipo_cambio;
	private BigDecimal mt_crossborder_ps;
	private BigDecimal iva;
	private BigDecimal total;

	public SOPORTE_SERVICIOS_JASPER(String cv_negocio, String dc_negocio, String banco, String nombre_corto,
			String servicio, String descripcion, BigDecimal mt_dispensado_dls, BigDecimal mt_dispensado_ps,
			BigDecimal mt_crossborder_dls, BigDecimal tipo_cambio, BigDecimal mt_crossborder_ps, BigDecimal iva,
			BigDecimal total) {
		super();
		this.cv_negocio = cv_negocio;
		this.dc_negocio = dc_negocio;
		this.banco = banco;
		this.nombre_corto = nombre_corto;
		this.servicio = servicio;
		this.descripcion = descripcion;
		this.mt_dispensado_dls = mt_dispensado_dls;
		this.mt_dispensado_ps = mt_dispensado_ps;
		this.mt_crossborder_dls = mt_crossborder_dls;
		this.tipo_cambio = tipo_cambio;
		this.mt_crossborder_ps = mt_crossborder_ps;
		this.iva = iva;
		this.total = total;
	}

	public String getCv_negocio() {
		return cv_negocio;
	}

	public void setCv_negocio(String cv_negocio) {
		this.cv_negocio = cv_negocio;
	}

	public String getDc_negocio() {
		return dc_negocio;
	}

	public void setDc_negocio(String dc_negocio) {
		this.dc_negocio = dc_negocio;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getNombre_corto() {
		return nombre_corto;
	}

	public void setNombre_corto(String nombre_corto) {
		this.nombre_corto = nombre_corto;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getMt_dispensado_dls() {
		return mt_dispensado_dls;
	}

	public void setMt_dispensado_dls(BigDecimal mt_dispensado_dls) {
		this.mt_dispensado_dls = mt_dispensado_dls;
	}

	public BigDecimal getMt_dispensado_ps() {
		return mt_dispensado_ps;
	}

	public void setMt_dispensado_ps(BigDecimal mt_dispensado_ps) {
		this.mt_dispensado_ps = mt_dispensado_ps;
	}

	public BigDecimal getMt_crossborder_dls() {
		return mt_crossborder_dls;
	}

	public void setMt_crossborder_dls(BigDecimal mt_crossborder_dls) {
		this.mt_crossborder_dls = mt_crossborder_dls;
	}

	public BigDecimal getTipo_cambio() {
		return tipo_cambio;
	}

	public void setTipo_cambio(BigDecimal tipo_cambio) {
		this.tipo_cambio = tipo_cambio;
	}

	public BigDecimal getMt_crossborder_ps() {
		return mt_crossborder_ps;
	}

	public void setMt_crossborder_ps(BigDecimal mt_crossborder_ps) {
		this.mt_crossborder_ps = mt_crossborder_ps;
	}

	public BigDecimal getIva() {
		return iva;
	}

	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "SOPORTE_SERVICIOS_JASPER [cv_negocio=" + cv_negocio + ", dc_negocio=" + dc_negocio + ", banco=" + banco
				+ ", nombre_corto=" + nombre_corto + ", servicio=" + servicio + ", descripcion=" + descripcion
				+ ", mt_dispensado_dls=" + mt_dispensado_dls + ", mt_dispensado_ps=" + mt_dispensado_ps
				+ ", mt_crossborder_dls=" + mt_crossborder_dls + ", tipo_cambio=" + tipo_cambio + ", mt_crossborder_ps="
				+ mt_crossborder_ps + ", iva=" + iva + ", total=" + total + "]";
	}

}
