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

public class B_TBL_SIF_ESTRUCTURA_DATOS_FTE {
	private Number id_estructura;
	private Number id_fuente;
	private String tabla_totales;
	private String tabla_temporal;
	private Number b_suspender_depuracion;
	private Number b_no_hay_carga;
	private String nombre_campo_cliente;
	private String nombre_campo_cliente_adq;
	private String usuario;
	private String estatus;
	private Date fecha_creacion;
	private Date fecha_mod;
	private String comentarios;
	private String clave;

	public B_TBL_SIF_ESTRUCTURA_DATOS_FTE() {
	}

	public B_TBL_SIF_ESTRUCTURA_DATOS_FTE(Number id_estructura, Number id_fuente, String tabla_totales,
			String tabla_temporal, Number b_suspender_depuracion, Number b_no_hay_carga, String nombre_campo_cliente,
			String nombre_campo_cliente_adq, String usuario, String estatus, Date fecha_creacion, Date fecha_mod,
			String comentarios, String clave) {
		super();
		this.id_estructura = id_estructura;
		this.id_fuente = id_fuente;
		this.tabla_totales = tabla_totales;
		this.tabla_temporal = tabla_temporal;
		this.b_suspender_depuracion = b_suspender_depuracion;
		this.b_no_hay_carga = b_no_hay_carga;
		this.nombre_campo_cliente = nombre_campo_cliente;
		this.nombre_campo_cliente_adq = nombre_campo_cliente_adq;
		this.usuario = usuario;
		this.estatus = estatus;
		this.fecha_creacion = fecha_creacion;
		this.fecha_mod = fecha_mod;
		this.comentarios = comentarios;
		this.clave = clave;
	}

	public Number getId_estructura() {
		return id_estructura;
	}

	public void setId_estructura(Number id_estructura) {
		this.id_estructura = id_estructura;
	}

	public Number getId_fuente() {
		return id_fuente;
	}

	public void setId_fuente(Number id_fuente) {
		this.id_fuente = id_fuente;
	}

	public String getTabla_totales() {
		return tabla_totales;
	}

	public void setTabla_totales(String tabla_totales) {
		this.tabla_totales = tabla_totales;
	}

	public String getTabla_temporal() {
		return tabla_temporal;
	}

	public void setTabla_temporal(String tabla_temporal) {
		this.tabla_temporal = tabla_temporal;
	}

	public Number getB_suspender_depuracion() {
		return b_suspender_depuracion;
	}

	public void setB_suspender_depuracion(Number b_suspender_depuracion) {
		this.b_suspender_depuracion = b_suspender_depuracion;
	}

	public Number getB_no_hay_carga() {
		return b_no_hay_carga;
	}

	public void setB_no_hay_carga(Number b_no_hay_carga) {
		this.b_no_hay_carga = b_no_hay_carga;
	}

	public String getNombre_campo_cliente() {
		return nombre_campo_cliente;
	}

	public void setNombre_campo_cliente(String nombre_campo_cliente) {
		this.nombre_campo_cliente = nombre_campo_cliente;
	}

	public String getNombre_campo_cliente_adq() {
		return nombre_campo_cliente_adq;
	}

	public void setNombre_campo_cliente_adq(String nombre_campo_cliente_adq) {
		this.nombre_campo_cliente_adq = nombre_campo_cliente_adq;
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

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String toString() {
		return "B_TBL_SIF_ESTRUCTURA_DATOS_FTE [id_estructura=" + id_estructura + ", id_fuente=" + id_fuente
				+ ", tabla_totales=" + tabla_totales + ", tabla_temporal=" + tabla_temporal
				+ ", b_suspender_depuracion=" + b_suspender_depuracion + ", b_no_hay_carga=" + b_no_hay_carga
				+ ", nombre_campo_cliente=" + nombre_campo_cliente + ", nombre_campo_cliente_adq="
				+ nombre_campo_cliente_adq + ", usuario=" + usuario + ", estatus=" + estatus + ", fecha_creacion="
				+ fecha_creacion + ", fecha_mod=" + fecha_mod + ", comentarios=" + comentarios + ", clave=" + clave
				+ "]";
	}

}
