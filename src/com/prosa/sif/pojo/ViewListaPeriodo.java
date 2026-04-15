package com.prosa.sif.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "V_SIF_CAT_PERIODOS")
public class ViewListaPeriodo {
	@Id
	private Integer id_periodos;
	private String nombre;
	private Date fecha_inicio;
	private Date fecha_fin;
	private Date fecha_cierre;
	private String estatus;

	public ViewListaPeriodo() {

	}

	public ViewListaPeriodo(Integer id_periodos, String nombre, Date fecha_inicio, Date fecha_fin, Date fecha_cierre,
			String estatus) {
		super();
		this.id_periodos = id_periodos;
		this.nombre = nombre;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.fecha_cierre = fecha_cierre;
		this.estatus = estatus;
	}

	public Integer getId_periodos() {
		return id_periodos;
	}

	public void setId_periodos(Integer id_periodos) {
		this.id_periodos = id_periodos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public Date getFecha_cierre() {
		return fecha_cierre;
	}

	public void setFecha_cierre(Date fecha_cierre) {
		this.fecha_cierre = fecha_cierre;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "ViewListaPeriodo [id_periodos=" + id_periodos + ", nombre=" + nombre + ", fecha_inicio=" + fecha_inicio
				+ ", fecha_fin=" + fecha_fin + ", fecha_cierre=" + fecha_cierre + ", estatus=" + estatus + "]";
	}

}
