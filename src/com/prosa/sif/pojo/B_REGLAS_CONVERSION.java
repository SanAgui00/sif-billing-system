/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 13/08/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.pojo;

import java.util.Date;

public class B_REGLAS_CONVERSION {
	private Number regla_conv_id;
	private Number servicio_id;
	private Number id_fuente;
	private String clave;
	private String descripcion;
	private Date fecha_mod;
	private String estatus;
	private String usuario;
	private String criterios;
	private String comentarios;
	private String clave_fuente;
	private String descripcion_fuente;

	public B_REGLAS_CONVERSION() {

	}

	public B_REGLAS_CONVERSION(Number regla_conv_id, Number servicio_id, Number id_fuente, String clave,
			String descripcion, Date fecha_mod, String estatus, String usuario, String criterios, String comentarios,
			String clave_fuente, String descripcion_fuente) {
		super();
		this.regla_conv_id = regla_conv_id;
		this.servicio_id = servicio_id;
		this.id_fuente = id_fuente;
		this.clave = clave;
		this.descripcion = descripcion;
		this.fecha_mod = fecha_mod;
		this.estatus = estatus;
		this.usuario = usuario;
		this.criterios = criterios;
		this.comentarios = comentarios;
		this.clave_fuente = clave_fuente;
		this.descripcion_fuente = descripcion_fuente;
	}

	public Number getRegla_conv_id() {
		return regla_conv_id;
	}

	public void setRegla_conv_id(Number regla_conv_id) {
		this.regla_conv_id = regla_conv_id;
	}

	public Number getServicio_id() {
		return servicio_id;
	}

	public void setServicio_id(Number servicio_id) {
		this.servicio_id = servicio_id;
	}

	public Number getId_fuente() {
		return id_fuente;
	}

	public void setId_fuente(Number id_fuente) {
		this.id_fuente = id_fuente;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha_mod() {
		return fecha_mod;
	}

	public void setFecha_mod(Date fecha_mod) {
		this.fecha_mod = fecha_mod;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getCriterios() {
		return criterios;
	}

	public void setCriterios(String criterios) {
		this.criterios = criterios;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getClave_fuente() {
		return clave_fuente;
	}

	public void setClave_fuente(String clave_fuente) {
		this.clave_fuente = clave_fuente;
	}

	public String getDescripcion_fuente() {
		return descripcion_fuente;
	}

	public void setDescripcion_fuente(String descripcion_fuente) {
		this.descripcion_fuente = descripcion_fuente;
	}

	@Override
	public String toString() {
		return "B_REGLAS_CONVERSION [regla_conv_id=" + regla_conv_id + ", servicio_id=" + servicio_id + ", id_fuente="
				+ id_fuente + ", clave=" + clave + ", descripcion=" + descripcion + ", fecha_mod=" + fecha_mod
				+ ", estatus=" + estatus + ", usuario=" + usuario + ", criterios=" + criterios + ", comentarios="
				+ comentarios + ", clave_fuente=" + clave_fuente + ", descripcion_fuente=" + descripcion_fuente + "]";
	}

}
