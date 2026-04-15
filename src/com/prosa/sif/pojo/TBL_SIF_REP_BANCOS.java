package com.prosa.sif.pojo;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_REP_BANCOS")
public class TBL_SIF_REP_BANCOS {

	@Id
	private Date fecha;
	private Date fecha_datos;
	private BigDecimal transacciones;
	private String usuario;
	private String banco;
	private String caja;
	private String fuente;
	private String servicio;

	public TBL_SIF_REP_BANCOS() {

	}

	public TBL_SIF_REP_BANCOS(Date fecha, Date fecha_datos, BigDecimal transacciones, String usuario, String banco,
			String caja, String fuente, String servicio) {
		super();
		this.fecha = fecha;
		this.fecha_datos = fecha_datos;
		this.transacciones = transacciones;
		this.usuario = usuario;
		this.banco = banco;
		this.caja = caja;
		this.fuente = fuente;
		this.servicio = servicio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFecha_datos() {
		return fecha_datos;
	}

	public void setFecha_datos(Date fecha_datos) {
		this.fecha_datos = fecha_datos;
	}

	public BigDecimal getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(BigDecimal transacciones) {
		this.transacciones = transacciones;
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

	public String getCaja() {
		return caja;
	}

	public void setCaja(String caja) {
		this.caja = caja;
	}

	public String getFuente() {
		return fuente;
	}

	public void setFuente(String fuente) {
		this.fuente = fuente;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	@Override
	public String toString() {
		return "TBL_SIF_REP_BANCOS [usuario=" + usuario + ", banco=" + banco + ", caja=" + caja + ", fuente=" + fuente
				+ ", servicio=" + servicio + "]";
	}

}
