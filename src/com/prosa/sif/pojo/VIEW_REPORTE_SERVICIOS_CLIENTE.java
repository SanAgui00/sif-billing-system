/**
################################################################################
# Autor               : Valverde Méndez Arturo                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 25/04/2018 #
# Descripcion General : POJO para reporte Servicios Cliente                    #
# Marca del cambio    :                                                        #
#------------------------------------------------------------------------------#
# Numero de Parametros: N/A                                                    #
# Parametros Entrada  : N/A                                  Formato:          #
# Parametros Salida   : N/A                                  Formato:          #
################################################################################
**/

package com.prosa.sif.pojo;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VIEW_REPORTE_SERVICIOS_CLIENTE")
public class VIEW_REPORTE_SERVICIOS_CLIENTE {

	private String descripcion_grupo;
	private String nombrecorto;
	private String nombre_moneda;
	private String descripcion_servicio;
	private String clave_servicio;
	private String clave_cliente;
	private String clave_negocio;
	private BigDecimal precio_aplicado;
	private Integer id_negocio;
	private Integer id_empresa;
	private Integer id_cliente;
	private Integer id_servicio;
	private Integer id_proceso;
	private Integer id_grupo;
	private Integer id_moneda;
	private BigDecimal total_importe_real;
	@Id
	private Integer id_vista;
	private BigDecimal transacciones;
	private BigDecimal importe_cobranza;
	private BigDecimal importe_ajuste;
	private BigDecimal descuento;
	private BigDecimal descuento_adicional;
	private Date fecha_datos;

	public VIEW_REPORTE_SERVICIOS_CLIENTE() {

	}

	public VIEW_REPORTE_SERVICIOS_CLIENTE(String descripcion_grupo, String nombrecorto, String nombre_moneda,
			String descripcion_servicio, String clave_servicio, String clave_cliente, String clave_negocio,
			BigDecimal precio_aplicado, Integer id_negocio, Integer id_empresa, Integer id_cliente, Integer id_servicio,
			Integer id_proceso, Integer id_grupo, Integer id_moneda, BigDecimal total_importe_real, Integer id_vista,
			BigDecimal transacciones, BigDecimal importe_cobranza, BigDecimal importe_ajuste, BigDecimal descuento,
			BigDecimal descuento_adicional, Date fecha_datos) {
		super();
		this.descripcion_grupo = descripcion_grupo;
		this.nombrecorto = nombrecorto;
		this.nombre_moneda = nombre_moneda;
		this.descripcion_servicio = descripcion_servicio;
		this.clave_servicio = clave_servicio;
		this.clave_cliente = clave_cliente;
		this.clave_negocio = clave_negocio;
		this.precio_aplicado = precio_aplicado;
		this.id_negocio = id_negocio;
		this.id_empresa = id_empresa;
		this.id_cliente = id_cliente;
		this.id_servicio = id_servicio;
		this.id_proceso = id_proceso;
		this.id_grupo = id_grupo;
		this.id_moneda = id_moneda;
		this.total_importe_real = total_importe_real;
		this.id_vista = id_vista;
		this.transacciones = transacciones;
		this.importe_cobranza = importe_cobranza;
		this.importe_ajuste = importe_ajuste;
		this.descuento = descuento;
		this.descuento_adicional = descuento_adicional;
		this.fecha_datos = fecha_datos;
	}

	public String getDescripcion_grupo() {
		return descripcion_grupo;
	}

	public void setDescripcion_grupo(String descripcion_grupo) {
		this.descripcion_grupo = descripcion_grupo;
	}

	public String getNombrecorto() {
		return nombrecorto;
	}

	public void setNombrecorto(String nombrecorto) {
		this.nombrecorto = nombrecorto;
	}

	public String getNombre_moneda() {
		return nombre_moneda;
	}

	public void setNombre_moneda(String nombre_moneda) {
		this.nombre_moneda = nombre_moneda;
	}

	public String getDescripcion_servicio() {
		return descripcion_servicio;
	}

	public void setDescripcion_servicio(String descripcion_servicio) {
		this.descripcion_servicio = descripcion_servicio;
	}

	public String getClave_servicio() {
		return clave_servicio;
	}

	public void setClave_servicio(String clave_servicio) {
		this.clave_servicio = clave_servicio;
	}

	public String getClave_cliente() {
		return clave_cliente;
	}

	public void setClave_cliente(String clave_cliente) {
		this.clave_cliente = clave_cliente;
	}

	public String getClave_negocio() {
		return clave_negocio;
	}

	public void setClave_negocio(String clave_negocio) {
		this.clave_negocio = clave_negocio;
	}

	public BigDecimal getPrecio_aplicado() {
		return precio_aplicado;
	}

	public void setPrecio_aplicado(BigDecimal precio_aplicado) {
		this.precio_aplicado = precio_aplicado;
	}

	public Integer getId_negocio() {
		return id_negocio;
	}

	public void setId_negocio(Integer id_negocio) {
		this.id_negocio = id_negocio;
	}

	public Integer getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(Integer id_empresa) {
		this.id_empresa = id_empresa;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Integer getId_servicio() {
		return id_servicio;
	}

	public void setId_servicio(Integer id_servicio) {
		this.id_servicio = id_servicio;
	}

	public Integer getId_proceso() {
		return id_proceso;
	}

	public void setId_proceso(Integer id_proceso) {
		this.id_proceso = id_proceso;
	}

	public Integer getId_grupo() {
		return id_grupo;
	}

	public void setId_grupo(Integer id_grupo) {
		this.id_grupo = id_grupo;
	}

	public Integer getId_moneda() {
		return id_moneda;
	}

	public void setId_moneda(Integer id_moneda) {
		this.id_moneda = id_moneda;
	}

	public BigDecimal getTotal_importe_real() {
		return total_importe_real;
	}

	public void setTotal_importe_real(BigDecimal total_importe_real) {
		this.total_importe_real = total_importe_real;
	}

	public Integer getId_vista() {
		return id_vista;
	}

	public void setId_vista(Integer id_vista) {
		this.id_vista = id_vista;
	}

	public BigDecimal getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(BigDecimal transacciones) {
		this.transacciones = transacciones;
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

	public Date getFecha_datos() {
		return fecha_datos;
	}

	public void setFecha_datos(Date fecha_datos) {
		this.fecha_datos = fecha_datos;
	}

	@Override
	public String toString() {
		return "VIEW_REPORTE_SERVICIOS_CLIENTE [descripcion_grupo=" + descripcion_grupo + ", nombrecorto=" + nombrecorto
				+ ", nombre_moneda=" + nombre_moneda + ", descripcion_servicio=" + descripcion_servicio
				+ ", clave_servicio=" + clave_servicio + ", clave_cliente=" + clave_cliente + ", clave_negocio="
				+ clave_negocio + ", precio_aplicado=" + precio_aplicado + ", id_negocio=" + id_negocio
				+ ", id_empresa=" + id_empresa + ", id_cliente=" + id_cliente + ", id_servicio=" + id_servicio
				+ ", id_proceso=" + id_proceso + ", id_grupo=" + id_grupo + ", id_moneda=" + id_moneda
				+ ", total_importe_real=" + total_importe_real + ", id_vista=" + id_vista + ", transacciones="
				+ transacciones + ", importe_cobranza=" + importe_cobranza + ", importe_ajuste=" + importe_ajuste
				+ ", descuento=" + descuento + ", descuento_adicional=" + descuento_adicional + ", fecha_datos="
				+ fecha_datos + "]";
	}

}
