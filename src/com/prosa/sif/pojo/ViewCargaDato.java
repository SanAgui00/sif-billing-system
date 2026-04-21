package com.prosa.sif.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VIEW_SIF_CARGA_DATO")
public class ViewCargaDato {
	@Id
	private Integer id;
	private String clave;
	private String tabla_temporal;
	private Integer id_reglas_carga;
	private String fecha_mod;
	private String sentencia;
	private String usuario;
	private Date fecha_creacion;
	private String comentarios;
	private String estatus;
	private String sentencia2;
	private Integer id_fuente;

	public ViewCargaDato() {

	}

	public ViewCargaDato(Integer id, String clave, String tabla_temporal, Integer id_reglas_carga, String fecha_mod,
			String sentencia, String usuario, Date fecha_creacion, String comentarios, String estatus,
			String sentencia2, Integer id_fuente) {
		super();
		this.id = id;
		this.clave = clave;
		this.tabla_temporal = tabla_temporal;
		this.id_reglas_carga = id_reglas_carga;
		this.fecha_mod = fecha_mod;
		this.sentencia = sentencia;
		this.usuario = usuario;
		this.fecha_creacion = fecha_creacion;
		this.comentarios = comentarios;
		this.estatus = estatus;
		this.sentencia2 = sentencia2;
		this.id_fuente = id_fuente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getTabla_temporal() {
		return tabla_temporal;
	}

	public void setTabla_temporal(String tabla_temporal) {
		this.tabla_temporal = tabla_temporal;
	}

	public Integer getId_reglas_carga() {
		return id_reglas_carga;
	}

	public void setId_reglas_carga(Integer id_reglas_carga) {
		this.id_reglas_carga = id_reglas_carga;
	}

	public String getFecha_mod() {
		return fecha_mod;
	}

	public void setFecha_mod(String fecha_mod) {
		this.fecha_mod = fecha_mod;
	}

	public String getSentencia() {
		return sentencia;
	}

	public void setSentencia(String sentencia) {
		this.sentencia = sentencia;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getSentencia2() {
		return sentencia2;
	}

	public void setSentencia2(String sentencia2) {
		this.sentencia2 = sentencia2;
	}

	public Integer getId_fuente() {
		return id_fuente;
	}

	public void setId_fuente(Integer id_fuente) {
		this.id_fuente = id_fuente;
	}

	@Override
	public String toString() {
		return "ViewCargaDato [id=" + id + ", clave=" + clave + ", tabla_temporal=" + tabla_temporal
				+ ", id_reglas_carga=" + id_reglas_carga + ", fecha_mod=" + fecha_mod + ", sentencia=" + sentencia
				+ ", usuario=" + usuario + ", fecha_creacion=" + fecha_creacion + ", comentarios=" + comentarios
				+ ", estatus=" + estatus + ", sentencia2=" + sentencia2 + ", id_fuente=" + id_fuente + "]";
	}

}
