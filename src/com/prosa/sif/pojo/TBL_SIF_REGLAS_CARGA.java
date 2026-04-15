package com.prosa.sif.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_REGLAS_CARGA")
public class TBL_SIF_REGLAS_CARGA {
	@Id
	private Integer id_reglas_carga;
	private Integer id_fuente;
	private String usuario;
	private String estatus;
	private Date fecha_creacion;
	private Date fecha_mod;
	private String comentarios;
	private String sentencia;
	private String sentencia2;

	public TBL_SIF_REGLAS_CARGA() {
	}

	public TBL_SIF_REGLAS_CARGA(Integer id_reglas_carga, Integer id_fuente, String usuario, String estatus,
			Date fecha_creacion, Date fecha_mod, String comentarios, String sentencia, String sentencia2) {
		super();
		this.id_reglas_carga = id_reglas_carga;
		this.id_fuente = id_fuente;
		this.usuario = usuario;
		this.estatus = estatus;
		this.fecha_creacion = fecha_creacion;
		this.fecha_mod = fecha_mod;
		this.comentarios = comentarios;
		this.sentencia = sentencia;
		this.sentencia2 = sentencia2;
	}

	public Integer getId_reglas_carga() {
		return id_reglas_carga;
	}

	public void setId_reglas_carga(Integer id_reglas_carga) {
		this.id_reglas_carga = id_reglas_carga;
	}

	public Integer getId_fuente() {
		return id_fuente;
	}

	public void setId_fuente(Integer id_fuente) {
		this.id_fuente = id_fuente;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
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

	public String getSentencia() {
		return sentencia;
	}

	public void setSentencia(String sentencia) {
		this.sentencia = sentencia;
	}

	public String getSentencia2() {
		return sentencia2;
	}

	public void setSentencia2(String sentencia2) {
		this.sentencia2 = sentencia2;
	}

	@Override
	public String toString() {
		return "TBL_SIF_REGLAS_CARGA [id_reglas_carga=" + id_reglas_carga + ", id_fuente=" + id_fuente + ", usuario="
				+ usuario + ", estatus=" + estatus + ", fecha_creacion=" + fecha_creacion + ", fecha_mod=" + fecha_mod
				+ ", comentarios=" + comentarios + ", sentencia=" + sentencia + ", sentencia2=" + sentencia2 + "]";
	}

}
