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

public class BeanRedesLogica {
	//REDLOGICA
	private String cv_red_logica;
	private String cv_servicio;
	private String estatus;
	private String usuario;
	private Date fecha;
	//SERVICIO
	private String clave;
	private String descripcion;
	
	public BeanRedesLogica() {
		
	}
	public BeanRedesLogica(String cv_red_logica, String cv_servicio, String estatus, String usuario, Date fecha,
			String clave, String descripcion) {
		super();
		this.cv_red_logica = cv_red_logica;
		this.cv_servicio = cv_servicio;
		this.estatus = estatus;
		this.usuario = usuario;
		this.fecha = fecha;
		this.clave = clave;
		this.descripcion = descripcion;
	}
	public String getCv_red_logica() {
		return cv_red_logica;
	}
	public void setCv_red_logica(String cv_red_logica) {
		this.cv_red_logica = cv_red_logica;
	}
	public String getCv_servicio() {
		return cv_servicio;
	}
	public void setCv_servicio(String cv_servicio) {
		this.cv_servicio = cv_servicio;
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
		
	
}
