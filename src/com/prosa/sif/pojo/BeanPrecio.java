/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 02/07/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.pojo;

public class BeanPrecio {
	private Number id_cliente;
	private Number id_servicio;
	private String clave_cliente;
	private String clave;
	private String descripcion;
	private String negocio;
	private String nombre_corto;
	private String rfc;
	private Number porcentaje_descuento;

	public BeanPrecio() {
	}

	public BeanPrecio(Number id_cliente, Number id_servicio, String clave_cliente, String clave, String descripcion,
			String negocio, String nombre_corto, String rfc, Number porcentaje_descuento) {
		super();
		this.id_cliente = id_cliente;
		this.id_servicio = id_servicio;
		this.clave_cliente = clave_cliente;
		this.clave = clave;
		this.descripcion = descripcion;
		this.negocio = negocio;
		this.nombre_corto = nombre_corto;
		this.rfc = rfc;
		this.porcentaje_descuento = porcentaje_descuento;
	}

	public Number getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Number id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Number getId_servicio() {
		return id_servicio;
	}

	public void setId_servicio(Number id_servicio) {
		this.id_servicio = id_servicio;
	}

	public String getClave_cliente() {
		return clave_cliente;
	}

	public void setClave_cliente(String clave_cliente) {
		this.clave_cliente = clave_cliente;
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

	public String getNegocio() {
		return negocio;
	}

	public void setNegocio(String negocio) {
		this.negocio = negocio;
	}

	public String getNombre_corto() {
		return nombre_corto;
	}

	public void setNombre_corto(String nombre_corto) {
		this.nombre_corto = nombre_corto;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public Number getPorcentaje_descuento() {
		return porcentaje_descuento;
	}

	public void setPorcentaje_descuento(Number porcentaje_descuento) {
		this.porcentaje_descuento = porcentaje_descuento;
	}

	@Override
	public String toString() {
		return "BeanPrecio [id_cliente=" + id_cliente + ", id_servicio=" + id_servicio + ", clave_cliente="
				+ clave_cliente + ", clave=" + clave + ", descripcion=" + descripcion + ", negocio=" + negocio
				+ ", nombre_corto=" + nombre_corto + ", rfc=" + rfc + ", porcentaje_descuento=" + porcentaje_descuento
				+ "]";
	}

}