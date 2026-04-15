package com.prosa.sif.pojo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VIEW_SIF_TIPOS_CAMBIO")
public class ViewTiposCambio {
	@Id
	private Integer id_tipo;
	private Integer id_moneda;
	private Integer id_periodo;
	private Date fecha_tipo_cambio;
	private BigDecimal tipo_cambio;
	private String usuario;
	private Date fecha_cre;
	private BigDecimal b_en_pesos;

	public ViewTiposCambio() {
	}

	public ViewTiposCambio(Integer id_tipo, Integer id_moneda, Integer id_periodo, Date fecha_tipo_cambio,
			BigDecimal tipo_cambio, String usuario, Date fecha_cre, BigDecimal b_en_pesos) {
		this.id_tipo = id_tipo;
		this.id_moneda = id_moneda;
		this.id_periodo = id_periodo;
		this.fecha_tipo_cambio = fecha_tipo_cambio;
		this.tipo_cambio = tipo_cambio;
		this.usuario = usuario;
		this.fecha_cre = fecha_cre;
		this.b_en_pesos = b_en_pesos;
	}

	public Integer getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(Integer id_tipo) {
		this.id_tipo = id_tipo;
	}

	public Integer getId_moneda() {
		return id_moneda;
	}

	public void setId_moneda(Integer id_moneda) {
		this.id_moneda = id_moneda;
	}

	public Integer getId_periodo() {
		return id_periodo;
	}

	public void setId_periodo(Integer id_periodo) {
		this.id_periodo = id_periodo;
	}

	public Date getFecha_tipo_cambio() {
		return fecha_tipo_cambio;
	}

	public void setFecha_tipo_cambio(Date fecha_tipo_cambio) {
		this.fecha_tipo_cambio = fecha_tipo_cambio;
	}

	public BigDecimal getTipo_cambio() {
		return tipo_cambio;
	}

	public void setTipo_cambio(BigDecimal tipo_cambio) {
		this.tipo_cambio = tipo_cambio;
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

	public BigDecimal getB_en_pesos() {
		return b_en_pesos;
	}

	public void setB_en_pesos(BigDecimal b_en_pesos) {
		this.b_en_pesos = b_en_pesos;
	}

	@Override
	public String toString() {
		return "V_SIF_TIPOS_CAMBIO [id_tipo=" + id_tipo + ", id_moneda=" + id_moneda + ", id_periodo=" + id_periodo
				+ ", fecha_tipo_cambio=" + fecha_tipo_cambio + ", tipo_cambio=" + tipo_cambio + ", usuario=" + usuario
				+ ", fecha_cre=" + fecha_cre + ", b_en_pesos=" + b_en_pesos + "]";
	}

}
