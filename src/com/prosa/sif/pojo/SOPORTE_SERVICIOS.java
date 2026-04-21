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

public class SOPORTE_SERVICIOS {

	private String fechaDatos;
	private String cvBanco;
	private String nmBanco;
	private String cvNegocio;
	private String nmNegocio;
	private String cvGrupoConcepto;
	private String nmGrupoConcepto;
	private String cvServicio;
	private String nmServicio;
	private String cvCaja;
	private String nmCaja;
	private BigDecimal transacciones;
	private BigDecimal precio;
	private BigDecimal importe;
	private BigDecimal descAdicional;
	private BigDecimal totalFactura;

	public SOPORTE_SERVICIOS(String fechaDatos, String cvBanco, String nmBanco, String cvNegocio, String nmNegocio,
			String cvGrupoConcepto, String nmGrupoConcepto, String cvServicio, String nmServicio, String cvCaja,
			String nmCaja, BigDecimal transacciones, BigDecimal precio, BigDecimal importe, BigDecimal descAdicional,
			BigDecimal totalFactura) {
		super();
		this.fechaDatos = fechaDatos;
		this.cvBanco = cvBanco;
		this.nmBanco = nmBanco;
		this.cvNegocio = cvNegocio;
		this.nmNegocio = nmNegocio;
		this.cvGrupoConcepto = cvGrupoConcepto;
		this.nmGrupoConcepto = nmGrupoConcepto;
		this.cvServicio = cvServicio;
		this.nmServicio = nmServicio;
		this.cvCaja = cvCaja;
		this.nmCaja = nmCaja;
		this.transacciones = transacciones;
		this.precio = precio;
		this.importe = importe;
		this.descAdicional = descAdicional;
		this.totalFactura = totalFactura;
	}

	public String getFechaDatos() {
		return fechaDatos;
	}

	public void setFechaDatos(String fechaDatos) {
		this.fechaDatos = fechaDatos;
	}

	public String getCvBanco() {
		return cvBanco;
	}

	public void setCvBanco(String cvBanco) {
		this.cvBanco = cvBanco;
	}

	public String getNmBanco() {
		return nmBanco;
	}

	public void setNmBanco(String nmBanco) {
		this.nmBanco = nmBanco;
	}

	public String getCvNegocio() {
		return cvNegocio;
	}

	public void setCvNegocio(String cvNegocio) {
		this.cvNegocio = cvNegocio;
	}

	public String getNmNegocio() {
		return nmNegocio;
	}

	public void setNmNegocio(String nmNegocio) {
		this.nmNegocio = nmNegocio;
	}

	public String getCvGrupoConcepto() {
		return cvGrupoConcepto;
	}

	public void setCvGrupoConcepto(String cvGrupoConcepto) {
		this.cvGrupoConcepto = cvGrupoConcepto;
	}

	public String getNmGrupoConcepto() {
		return nmGrupoConcepto;
	}

	public void setNmGrupoConcepto(String nmGrupoConcepto) {
		this.nmGrupoConcepto = nmGrupoConcepto;
	}

	public String getCvServicio() {
		return cvServicio;
	}

	public void setCvServicio(String cvServicio) {
		this.cvServicio = cvServicio;
	}

	public String getNmServicio() {
		return nmServicio;
	}

	public void setNmServicio(String nmServicio) {
		this.nmServicio = nmServicio;
	}

	public String getCvCaja() {
		return cvCaja;
	}

	public void setCvCaja(String cvCaja) {
		this.cvCaja = cvCaja;
	}

	public String getNmCaja() {
		return nmCaja;
	}

	public void setNmCaja(String nmCaja) {
		this.nmCaja = nmCaja;
	}

	public BigDecimal getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(BigDecimal transacciones) {
		this.transacciones = transacciones;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public BigDecimal getDescAdicional() {
		return descAdicional;
	}

	public void setDescAdicional(BigDecimal descAdicional) {
		this.descAdicional = descAdicional;
	}

	public BigDecimal getTotalFactura() {
		return totalFactura;
	}

	public void setTotalFactura(BigDecimal totalFactura) {
		this.totalFactura = totalFactura;
	}

	@Override
	public String toString() {
		return "SOPORTE_SERVICIOS [fechaDatos=" + fechaDatos + ", cvBanco=" + cvBanco + ", nmBanco=" + nmBanco
				+ ", cvNegocio=" + cvNegocio + ", nmNegocio=" + nmNegocio + ", cvGrupoConcepto=" + cvGrupoConcepto
				+ ", nmGrupoConcepto=" + nmGrupoConcepto + ", cvServicio=" + cvServicio + ", nmServicio=" + nmServicio
				+ ", cvCaja=" + cvCaja + ", nmCaja=" + nmCaja + ", transacciones=" + transacciones + ", precio="
				+ precio + ", importe=" + importe + ", descAdicional=" + descAdicional + ", totalFactura="
				+ totalFactura + "]";
	}

}
