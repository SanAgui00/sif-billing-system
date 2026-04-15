package com.prosa.sif.pojo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_CAT_PERIODO")
public class TBL_SIF_CAT_PERIODO {

	private Date fecha_cierre;
	private Date fecha_mod;
	private Date fecha_cre;
	private Date fecha_fin;
	private Date fecha_inicio;
	@Id
	private Integer id_periodos;
	private String usuario;
	private String comentarios;
	private String estatus;
	private String nombre;

	public TBL_SIF_CAT_PERIODO() {

	}

	public TBL_SIF_CAT_PERIODO(Date fecha_cierre, Date fecha_mod, Date fecha_cre, Date fecha_fin, Date fecha_inicio,
			Integer id_periodos, String usuario, String comentarios, String estatus, String nombre) {
		super();
		this.fecha_cierre = fecha_cierre;
		this.fecha_mod = fecha_mod;
		this.fecha_cre = fecha_cre;
		this.fecha_fin = fecha_fin;
		this.fecha_inicio = fecha_inicio;
		this.id_periodos = id_periodos;
		this.usuario = usuario;
		this.comentarios = comentarios;
		this.estatus = estatus;
		this.nombre = nombre;
	}

	public Date getFecha_cierre() {
		return fecha_cierre;
	}

	public void setFecha_cierre(Date fecha_cierre) {
		this.fecha_cierre = fecha_cierre;
	}

	public Date getFecha_mod() {
		return fecha_mod;
	}

	public void setFecha_mod(Date fecha_mod) {
		this.fecha_mod = fecha_mod;
	}

	public Date getFecha_cre() {
		return fecha_cre;
	}

	public void setFecha_cre(Date fecha_cre) {
		this.fecha_cre = fecha_cre;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Integer getId_periodos() {
		return id_periodos;
	}

	public void setId_periodos(Integer id_periodos) {
		this.id_periodos = id_periodos;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "TBL_SIF_CAT_PERIODO [fecha_cierre=" + fecha_cierre + ", fecha_mod=" + fecha_mod + ", fecha_cre="
				+ fecha_cre + ", fecha_fin=" + fecha_fin + ", fecha_inicio=" + fecha_inicio + ", id_periodos="
				+ id_periodos + ", usuario=" + usuario + ", comentarios=" + comentarios + ", estatus=" + estatus
				+ ", nombre=" + nombre + "]";
	}

}
