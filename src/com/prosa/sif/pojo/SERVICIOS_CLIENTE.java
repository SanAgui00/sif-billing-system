/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 12/06/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.pojo;

import java.math.BigDecimal;

public class SERVICIOS_CLIENTE {

	private String nombre_moneda;
	private Integer id_negocio;
	private String clave_negocio;
	private Integer id_cliente;
	private String clave_cliente;
	private String nombrecorto;
	private Integer id_grupo;
	private String descripcion_grupo;
	private String clave_servicio;
	private String descripcion_servicio;
	private BigDecimal transacciones;
	private BigDecimal precio;
	private BigDecimal importe_cobranza;
	private BigDecimal importe_ajuste;
	private BigDecimal descuento;
	private BigDecimal descuento_adicional;
	private BigDecimal precio_aplicado;
	private BigDecimal total_importe_real;

	public SERVICIOS_CLIENTE(String nombre_moneda, Integer id_negocio, String clave_negocio, Integer id_cliente,
			String clave_cliente, String nombrecorto, Integer id_grupo, String descripcion_grupo, String clave_servicio,
			String descripcion_servicio, BigDecimal transacciones, BigDecimal precio, BigDecimal importe_cobranza,
			BigDecimal importe_ajuste, BigDecimal descuento, BigDecimal descuento_adicional, BigDecimal precio_aplicado,
			BigDecimal total_importe_real) {
		super();
		this.nombre_moneda = nombre_moneda;
		this.id_negocio = id_negocio;
		this.clave_negocio = clave_negocio;
		this.id_cliente = id_cliente;
		this.clave_cliente = clave_cliente;
		this.nombrecorto = nombrecorto;
		this.id_grupo = id_grupo;
		this.descripcion_grupo = descripcion_grupo;
		this.clave_servicio = clave_servicio;
		this.descripcion_servicio = descripcion_servicio;
		this.transacciones = transacciones;
		this.precio = precio;
		this.importe_cobranza = importe_cobranza;
		this.importe_ajuste = importe_ajuste;
		this.descuento = descuento;
		this.descuento_adicional = descuento_adicional;
		this.precio_aplicado = precio_aplicado;
		this.total_importe_real = total_importe_real;
	}

	public String getNombre_moneda() {
		return nombre_moneda;
	}

	public void setNombre_moneda(String nombre_moneda) {
		this.nombre_moneda = nombre_moneda;
	}

	public Integer getId_negocio() {
		return id_negocio;
	}

	public void setId_negocio(Integer id_negocio) {
		this.id_negocio = id_negocio;
	}

	public String getClave_negocio() {
		return clave_negocio;
	}

	public void setClave_negocio(String clave_negocio) {
		this.clave_negocio = clave_negocio;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getClave_cliente() {
		return clave_cliente;
	}

	public void setClave_cliente(String clave_cliente) {
		this.clave_cliente = clave_cliente;
	}

	public String getNombrecorto() {
		return nombrecorto;
	}

	public void setNombrecorto(String nombrecorto) {
		this.nombrecorto = nombrecorto;
	}

	public Integer getId_grupo() {
		return id_grupo;
	}

	public void setId_grupo(Integer id_grupo) {
		this.id_grupo = id_grupo;
	}

	public String getDescripcion_grupo() {
		return descripcion_grupo;
	}

	public void setDescripcion_grupo(String descripcion_grupo) {
		this.descripcion_grupo = descripcion_grupo;
	}

	public String getClave_servicio() {
		return clave_servicio;
	}

	public void setClave_servicio(String clave_servicio) {
		this.clave_servicio = clave_servicio;
	}

	public String getDescripcion_servicio() {
		return descripcion_servicio;
	}

	public void setDescripcion_servicio(String descripcion_servicio) {
		this.descripcion_servicio = descripcion_servicio;
	}

	public BigDecimal getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(BigDecimal transacciones) {
		this.transacciones = transacciones;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public BigDecimal getImporte_cobranza() {
		return importe_cobranza;
	}

	public void setImporte_cobranza(BigDecimal importe_cobranza) {
		this.importe_cobranza = importe_cobranza;
	}

	public BigDecimal getImporte_ajuste() {
		return importe_ajuste;
	}

	public void setImporte_ajuste(BigDecimal importe_ajuste) {
		this.importe_ajuste = importe_ajuste;
	}

	public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public BigDecimal getDescuento_adicional() {
		return descuento_adicional;
	}

	public void setDescuento_adicional(BigDecimal descuento_adicional) {
		this.descuento_adicional = descuento_adicional;
	}

	public BigDecimal getPrecio_aplicado() {
		return precio_aplicado;
	}

	public void setPrecio_aplicado(BigDecimal precio_aplicado) {
		this.precio_aplicado = precio_aplicado;
	}

	public BigDecimal getTotal_importe_real() {
		return total_importe_real;
	}

	public void setTotal_importe_real(BigDecimal total_importe_real) {
		this.total_importe_real = total_importe_real;
	}

	@Override
	public String toString() {
		return "SERVICIOS_CLIENTE [nombre_moneda=" + nombre_moneda + ", id_negocio=" + id_negocio + ", clave_negocio="
				+ clave_negocio + ", id_cliente=" + id_cliente + ", clave_cliente=" + clave_cliente + ", nombrecorto="
				+ nombrecorto + ", id_grupo=" + id_grupo + ", descripcion_grupo=" + descripcion_grupo
				+ ", clave_servicio=" + clave_servicio + ", descripcion_servicio=" + descripcion_servicio
				+ ", transacciones=" + transacciones + ", precio=" + precio + ", importe_cobranza=" + importe_cobranza
				+ ", importe_ajuste=" + importe_ajuste + ", descuento=" + descuento + ", descuento_adicional="
				+ descuento_adicional + ", precio_aplicado=" + precio_aplicado + ", total_importe_real="
				+ total_importe_real + "]";
	}

}
