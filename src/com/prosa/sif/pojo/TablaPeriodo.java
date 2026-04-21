/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 06/08/2018 #
# Descripcion General : Pojo para mapeo de TablaCatPeriodo                     #
# Marca del cambio    : 									                   #
#------------------------------------------------------------------------------#
# Numero de Parametros: N/A                                                    #
# Parametros Entrada  : N/A                                  Formato:          #
# Parametros Salida   : N/A                                  Formato:          #
################################################################################
**/

package com.prosa.sif.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_CAT_PERIODO")
public class TablaPeriodo {
	@Id
	private Integer id_periodos;
	private String nombre;
	private Date fecha_inicio;
	private Date fecha_fin;
	private Date fecha_cierre;
	private String estatus;
	private Date fecha_cre;
	private Date fecha_mod;
	private String usuario;
	private String comentarios;

	public TablaPeriodo() {

	}

	public TablaPeriodo(Integer id_periodos, String nombre, Date fecha_inicio, Date fecha_fin, Date fecha_cierre,
			String estatus, Date fecha_cre, Date fecha_mod, String usuario, String comentarios) {
		super();
		this.id_periodos = id_periodos;
		this.nombre = nombre;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.fecha_cierre = fecha_cierre;
		this.estatus = estatus;
		this.fecha_cre = fecha_cre;
		this.fecha_mod = fecha_mod;
		this.usuario = usuario;
		this.comentarios = comentarios;
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

	public Date getFecha_cre() {
		return fecha_cre;
	}

	public void setFecha_cre(Date fecha_cre) {
		this.fecha_cre = fecha_cre;
	}

	public Date getFecha_mod() {
		return fecha_mod;
	}

	public void setFecha_mod(Date fecha_mod) {
		this.fecha_mod = fecha_mod;
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

	@Override
	public String toString() {
		return "TablaPeriodo [id_periodos=" + id_periodos + ", nombre=" + nombre + ", fecha_inicio=" + fecha_inicio
				+ ", fecha_fin=" + fecha_fin + ", fecha_cierre=" + fecha_cierre + ", estatus=" + estatus
				+ ", fecha_cre=" + fecha_cre + ", fecha_mod=" + fecha_mod + ", usuario=" + usuario + ", comentarios="
				+ comentarios + "]";
	}

}
