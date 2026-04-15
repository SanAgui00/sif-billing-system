/**
################################################################################
# Autor               : Valverde Méndez Arturo                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 25/04/2018 #
# Descripcion General : POJO para reporte Consecutivo de Folios                #
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
@Table(name = "VIEW_REPORTE_FOLIOS")
public class VIEW_REPORTE_FOLIOS {

	private BigDecimal numero;
	private Integer id_moneda;
	private Integer id_proceso;
	private Integer id_negocio;
	private Integer id_cliente;
	private String folio;
	private Integer id_empresa;
	private String tipo_documento;
	private String clave_proceso;
	private String descripcion_proceso;
	private String clave;
	private String descripcion_negocio;
	private String rfc;
	private String clave_cliente;
	private String razon_social;
	private String nombre_corto;
	private String direccion_cliente;
	private String nombre_moneda;
	private BigDecimal subtotal_monto;
	private BigDecimal importe_iva;
	private BigDecimal total;
	private BigDecimal tipo_cambio;
	private Date fecha_reservacion;
	private Date fecha_ult_impresion;
	private Date fecha_ult_modific;
	private String estatus;
	private String comentarios;
	private String concepto_descripcion;
	private Date fecha_datos;
	private String serie;
	private BigDecimal descuento;
	private String clave_documento;
	private BigDecimal porc_iva_cliente;
	@Id
	private Integer id_vista;

	public VIEW_REPORTE_FOLIOS() {

	}

	public VIEW_REPORTE_FOLIOS(BigDecimal numero, Integer id_moneda, Integer id_proceso, Integer id_negocio,
			Integer id_cliente, String folio, Integer id_empresa, String tipo_documento, String clave_proceso,
			String descripcion_proceso, String clave, String descripcion_negocio, String rfc, String clave_cliente,
			String razon_social, String nombre_corto, String direccion_cliente, String nombre_moneda,
			BigDecimal subtotal_monto, BigDecimal importe_iva, BigDecimal total, BigDecimal tipo_cambio,
			Date fecha_reservacion, Date fecha_ult_impresion, Date fecha_ult_modific, String estatus,
			String comentarios, String concepto_descripcion, Date fecha_datos, String serie, BigDecimal descuento,
			String clave_documento, BigDecimal porc_iva_cliente, Integer id_vista) {
		super();
		this.numero = numero;
		this.id_moneda = id_moneda;
		this.id_proceso = id_proceso;
		this.id_negocio = id_negocio;
		this.id_cliente = id_cliente;
		this.folio = folio;
		this.id_empresa = id_empresa;
		this.tipo_documento = tipo_documento;
		this.clave_proceso = clave_proceso;
		this.descripcion_proceso = descripcion_proceso;
		this.clave = clave;
		this.descripcion_negocio = descripcion_negocio;
		this.rfc = rfc;
		this.clave_cliente = clave_cliente;
		this.razon_social = razon_social;
		this.nombre_corto = nombre_corto;
		this.direccion_cliente = direccion_cliente;
		this.nombre_moneda = nombre_moneda;
		this.subtotal_monto = subtotal_monto;
		this.importe_iva = importe_iva;
		this.total = total;
		this.tipo_cambio = tipo_cambio;
		this.fecha_reservacion = fecha_reservacion;
		this.fecha_ult_impresion = fecha_ult_impresion;
		this.fecha_ult_modific = fecha_ult_modific;
		this.estatus = estatus;
		this.comentarios = comentarios;
		this.concepto_descripcion = concepto_descripcion;
		this.fecha_datos = fecha_datos;
		this.serie = serie;
		this.descuento = descuento;
		this.clave_documento = clave_documento;
		this.porc_iva_cliente = porc_iva_cliente;
		this.id_vista = id_vista;
	}

	public BigDecimal getNumero() {
		return numero;
	}

	public void setNumero(BigDecimal numero) {
		this.numero = numero;
	}

	public Integer getId_moneda() {
		return id_moneda;
	}

	public void setId_moneda(Integer id_moneda) {
		this.id_moneda = id_moneda;
	}

	public Integer getId_proceso() {
		return id_proceso;
	}

	public void setId_proceso(Integer id_proceso) {
		this.id_proceso = id_proceso;
	}

	public Integer getId_negocio() {
		return id_negocio;
	}

	public void setId_negocio(Integer id_negocio) {
		this.id_negocio = id_negocio;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public Integer getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(Integer id_empresa) {
		this.id_empresa = id_empresa;
	}

	public String getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public String getClave_proceso() {
		return clave_proceso;
	}

	public void setClave_proceso(String clave_proceso) {
		this.clave_proceso = clave_proceso;
	}

	public String getDescripcion_proceso() {
		return descripcion_proceso;
	}

	public void setDescripcion_proceso(String descripcion_proceso) {
		this.descripcion_proceso = descripcion_proceso;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDescripcion_negocio() {
		return descripcion_negocio;
	}

	public void setDescripcion_negocio(String descripcion_negocio) {
		this.descripcion_negocio = descripcion_negocio;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getClave_cliente() {
		return clave_cliente;
	}

	public void setClave_cliente(String clave_cliente) {
		this.clave_cliente = clave_cliente;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public String getNombre_corto() {
		return nombre_corto;
	}

	public void setNombre_corto(String nombre_corto) {
		this.nombre_corto = nombre_corto;
	}

	public String getDireccion_cliente() {
		return direccion_cliente;
	}

	public void setDireccion_cliente(String direccion_cliente) {
		this.direccion_cliente = direccion_cliente;
	}

	public String getNombre_moneda() {
		return nombre_moneda;
	}

	public void setNombre_moneda(String nombre_moneda) {
		this.nombre_moneda = nombre_moneda;
	}

	public BigDecimal getSubtotal_monto() {
		return subtotal_monto;
	}

	public void setSubtotal_monto(BigDecimal subtotal_monto) {
		this.subtotal_monto = subtotal_monto;
	}

	public BigDecimal getImporte_iva() {
		return importe_iva;
	}

	public void setImporte_iva(BigDecimal importe_iva) {
		this.importe_iva = importe_iva;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getTipo_cambio() {
		return tipo_cambio;
	}

	public void setTipo_cambio(BigDecimal tipo_cambio) {
		this.tipo_cambio = tipo_cambio;
	}

	public Date getFecha_reservacion() {
		return fecha_reservacion;
	}

	public void setFecha_reservacion(Date fecha_reservacion) {
		this.fecha_reservacion = fecha_reservacion;
	}

	public Date getFecha_ult_impresion() {
		return fecha_ult_impresion;
	}

	public void setFecha_ult_impresion(Date fecha_ult_impresion) {
		this.fecha_ult_impresion = fecha_ult_impresion;
	}

	public Date getFecha_ult_modific() {
		return fecha_ult_modific;
	}

	public void setFecha_ult_modific(Date fecha_ult_modific) {
		this.fecha_ult_modific = fecha_ult_modific;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getConcepto_descripcion() {
		return concepto_descripcion;
	}

	public void setConcepto_descripcion(String concepto_descripcion) {
		this.concepto_descripcion = concepto_descripcion;
	}

	public Date getFecha_datos() {
		return fecha_datos;
	}

	public void setFecha_datos(Date fecha_datos) {
		this.fecha_datos = fecha_datos;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public String getClave_documento() {
		return clave_documento;
	}

	public void setClave_documento(String clave_documento) {
		this.clave_documento = clave_documento;
	}

	public BigDecimal getPorc_iva_cliente() {
		return porc_iva_cliente;
	}

	public void setPorc_iva_cliente(BigDecimal porc_iva_cliente) {
		this.porc_iva_cliente = porc_iva_cliente;
	}

	public Integer getId_vista() {
		return id_vista;
	}

	public void setId_vista(Integer id_vista) {
		this.id_vista = id_vista;
	}

	@Override
	public String toString() {
		return "VIEW_REPORTE_FOLIOS [numero=" + numero + ", id_moneda=" + id_moneda + ", id_proceso=" + id_proceso
				+ ", id_negocio=" + id_negocio + ", id_cliente=" + id_cliente + ", folio=" + folio + ", id_empresa="
				+ id_empresa + ", tipo_documento=" + tipo_documento + ", clave_proceso=" + clave_proceso
				+ ", descripcion_proceso=" + descripcion_proceso + ", clave=" + clave + ", descripcion_negocio="
				+ descripcion_negocio + ", rfc=" + rfc + ", clave_cliente=" + clave_cliente + ", razon_social="
				+ razon_social + ", nombre_corto=" + nombre_corto + ", direccion_cliente=" + direccion_cliente
				+ ", nombre_moneda=" + nombre_moneda + ", subtotal_monto=" + subtotal_monto + ", importe_iva="
				+ importe_iva + ", total=" + total + ", tipo_cambio=" + tipo_cambio + ", fecha_reservacion="
				+ fecha_reservacion + ", fecha_ult_impresion=" + fecha_ult_impresion + ", fecha_ult_modific="
				+ fecha_ult_modific + ", estatus=" + estatus + ", comentarios=" + comentarios
				+ ", concepto_descripcion=" + concepto_descripcion + ", fecha_datos=" + fecha_datos + ", serie=" + serie
				+ ", descuento=" + descuento + ", clave_documento=" + clave_documento + ", porc_iva_cliente="
				+ porc_iva_cliente + ", id_vista=" + id_vista + "]";
	}

}
