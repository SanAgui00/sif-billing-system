package com.prosa.sif.pojo;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_REP_CROSS")
public class TBL_SIF_REP_CROSS {

	@Id
	private Date fecha_datos;
	private Date fecha;
	private BigDecimal originales_ps;
	private BigDecimal revparciales_ps;
	private BigDecimal revtotales_ps;
	private BigDecimal diferencia;
	private BigDecimal originales_dls;
	private BigDecimal revparciales_dls;
	private BigDecimal revtotales_dls;
	private BigDecimal tipo_cambio;
	private BigDecimal totales;
	private BigDecimal mt_dispensado_dls;
	private BigDecimal mt_crossborder;
	private BigDecimal balance_ps;
	private BigDecimal mt_dispensado_ps;
	private BigDecimal balance_dls;
	private String usuario;
	private String banco;
	private String servicio;

	public TBL_SIF_REP_CROSS() {

	}

	public TBL_SIF_REP_CROSS(Date fecha_datos, Date fecha, BigDecimal originales_ps, BigDecimal revparciales_ps,
			BigDecimal revtotales_ps, BigDecimal diferencia, BigDecimal originales_dls, BigDecimal revparciales_dls,
			BigDecimal revtotales_dls, BigDecimal tipo_cambio, BigDecimal totales, BigDecimal mt_dispensado_dls,
			BigDecimal mt_crossborder, BigDecimal balance_ps, BigDecimal mt_dispensado_ps, BigDecimal balance_dls,
			String usuario, String banco, String servicio) {
		super();
		this.fecha_datos = fecha_datos;
		this.fecha = fecha;
		this.originales_ps = originales_ps;
		this.revparciales_ps = revparciales_ps;
		this.revtotales_ps = revtotales_ps;
		this.diferencia = diferencia;
		this.originales_dls = originales_dls;
		this.revparciales_dls = revparciales_dls;
		this.revtotales_dls = revtotales_dls;
		this.tipo_cambio = tipo_cambio;
		this.totales = totales;
		this.mt_dispensado_dls = mt_dispensado_dls;
		this.mt_crossborder = mt_crossborder;
		this.balance_ps = balance_ps;
		this.mt_dispensado_ps = mt_dispensado_ps;
		this.balance_dls = balance_dls;
		this.usuario = usuario;
		this.banco = banco;
		this.servicio = servicio;
	}

	public Date getFecha_datos() {
		return fecha_datos;
	}

	public void setFecha_datos(Date fecha_datos) {
		this.fecha_datos = fecha_datos;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getOriginales_ps() {
		return originales_ps;
	}

	public void setOriginales_ps(BigDecimal originales_ps) {
		this.originales_ps = originales_ps;
	}

	public BigDecimal getRevparciales_ps() {
		return revparciales_ps;
	}

	public void setRevparciales_ps(BigDecimal revparciales_ps) {
		this.revparciales_ps = revparciales_ps;
	}

	public BigDecimal getRevtotales_ps() {
		return revtotales_ps;
	}

	public void setRevtotales_ps(BigDecimal revtotales_ps) {
		this.revtotales_ps = revtotales_ps;
	}

	public BigDecimal getDiferencia() {
		return diferencia;
	}

	public void setDiferencia(BigDecimal diferencia) {
		this.diferencia = diferencia;
	}

	public BigDecimal getOriginales_dls() {
		return originales_dls;
	}

	public void setOriginales_dls(BigDecimal originales_dls) {
		this.originales_dls = originales_dls;
	}

	public BigDecimal getRevparciales_dls() {
		return revparciales_dls;
	}

	public void setRevparciales_dls(BigDecimal revparciales_dls) {
		this.revparciales_dls = revparciales_dls;
	}

	public BigDecimal getRevtotales_dls() {
		return revtotales_dls;
	}

	public void setRevtotales_dls(BigDecimal revtotales_dls) {
		this.revtotales_dls = revtotales_dls;
	}

	public BigDecimal getTipo_cambio() {
		return tipo_cambio;
	}

	public void setTipo_cambio(BigDecimal tipo_cambio) {
		this.tipo_cambio = tipo_cambio;
	}

	public BigDecimal getTotales() {
		return totales;
	}

	public void setTotales(BigDecimal totales) {
		this.totales = totales;
	}

	public BigDecimal getMt_dispensado_dls() {
		return mt_dispensado_dls;
	}

	public void setMt_dispensado_dls(BigDecimal mt_dispensado_dls) {
		this.mt_dispensado_dls = mt_dispensado_dls;
	}

	public BigDecimal getMt_crossborder() {
		return mt_crossborder;
	}

	public void setMt_crossborder(BigDecimal mt_crossborder) {
		this.mt_crossborder = mt_crossborder;
	}

	public BigDecimal getBalance_ps() {
		return balance_ps;
	}

	public void setBalance_ps(BigDecimal balance_ps) {
		this.balance_ps = balance_ps;
	}

	public BigDecimal getMt_dispensado_ps() {
		return mt_dispensado_ps;
	}

	public void setMt_dispensado_ps(BigDecimal mt_dispensado_ps) {
		this.mt_dispensado_ps = mt_dispensado_ps;
	}

	public BigDecimal getBalance_dls() {
		return balance_dls;
	}

	public void setBalance_dls(BigDecimal balance_dls) {
		this.balance_dls = balance_dls;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	@Override
	public String toString() {
		return "TBL_SIF_REP_CROSS [fecha_datos=" + fecha_datos + ", fecha=" + fecha + ", originales_ps=" + originales_ps
				+ ", revparciales_ps=" + revparciales_ps + ", revtotales_ps=" + revtotales_ps + ", diferencia="
				+ diferencia + ", originales_dls=" + originales_dls + ", revparciales_dls=" + revparciales_dls
				+ ", revtotales_dls=" + revtotales_dls + ", tipo_cambio=" + tipo_cambio + ", totales=" + totales
				+ ", mt_dispensado_dls=" + mt_dispensado_dls + ", mt_crossborder=" + mt_crossborder + ", balance_ps="
				+ balance_ps + ", mt_dispensado_ps=" + mt_dispensado_ps + ", balance_dls=" + balance_dls + ", usuario="
				+ usuario + ", banco=" + banco + ", servicio=" + servicio + "]";
	}

}
