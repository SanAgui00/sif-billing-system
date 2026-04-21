/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 27/08/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.pojo;

import java.util.Date;

public class BeanClienteUsuarioServicio {
	private String clave;
	private String descripcion;
	private String clave_cliente;
	private String descripcion_cliente;
	private String inclusion_emi;
	private String inclusion_adq;
	private String estatus;
	private String usuario;
	private Date fecha;

	public BeanClienteUsuarioServicio() {

	}

	public BeanClienteUsuarioServicio(String clave, String descripcion, String clave_cliente,
			String descripcion_cliente, String inclusion_emi, String inclusion_adq, String estatus, String usuario,
			Date fecha) {
		super();
		this.clave = clave;
		this.descripcion = descripcion;
		this.clave_cliente = clave_cliente;
		this.descripcion_cliente = descripcion_cliente;
		this.inclusion_emi = inclusion_emi;
		this.inclusion_adq = inclusion_adq;
		this.estatus = estatus;
		this.usuario = usuario;
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

	public String getClave_cliente() {
		return clave_cliente;
	}

	public void setClave_cliente(String clave_cliente) {
		this.clave_cliente = clave_cliente;
	}

	public String getDescripcion_cliente() {
		return descripcion_cliente;
	}

	public void setDescripcion_cliente(String descripcion_cliente) {
		this.descripcion_cliente = descripcion_cliente;
	}

	public String getInclusion_emi() {
		return inclusion_emi;
	}

	public void setInclusion_emi(String inclusion_emi) {
		this.inclusion_emi = inclusion_emi;
	}

	public String getInclusion_adq() {
		return inclusion_adq;
	}

	public void setInclusion_adq(String inclusion_adq) {
		this.inclusion_adq = inclusion_adq;
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

	@Override
	public String toString() {
		return "BeanClienteUsuarioServicio [clave=" + clave + ", descripcion=" + descripcion + ", clave_cliente="
				+ clave_cliente + ", descripcion_cliente=" + descripcion_cliente + ", inclusion_emi=" + inclusion_emi
				+ ", inclusion_adq=" + inclusion_adq + ", estatus=" + estatus + ", usuario=" + usuario + ", fecha="
				+ fecha + "]";
	}

}