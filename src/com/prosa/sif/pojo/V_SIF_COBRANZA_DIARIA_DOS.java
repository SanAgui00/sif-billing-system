/**
################################################################################
# Autor               : Valverde Méndez Arturo                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 25/04/2018 #
# Descripcion General : POJO para reporte Cobranza Diaria                      #
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
@Table(name = "V_SIF_COBRANZA_DIARIA_DOS")
public class V_SIF_COBRANZA_DIARIA_DOS {

	private Date fecha_datos;
	private BigDecimal precio_aplicado;
	private BigDecimal imp_cobdia;
	@Id
	private BigDecimal id_vista;
	private BigDecimal desc_ajuste;
	private BigDecimal ajuste;
	private BigDecimal desc_cobdia;
	private BigDecimal total_cobdia;
	private BigDecimal iva_ajuste;
	private BigDecimal iva_cobdia;
	private BigDecimal subtotal_cobdia;
	private BigDecimal subtotal_ajuste;
	private BigDecimal desc_adicional;
	private BigDecimal trx_cobdia;
	private BigDecimal total_ajuste;
	private BigDecimal id_cliente;
	private BigDecimal id_servicios;
	private BigDecimal id_negocio;
	private BigDecimal id_moneda;
	private BigDecimal id_proceso;
	private BigDecimal id_empresa;
	private BigDecimal tipo_cambio;
	private String clave_cliente;
	private String clave_negocio;
	private String clave_empresa;
	private String clave_proceso;
	private String razon_social;
	private String clave_servicio;
	private String descripcion_servicio;
	private String nombre_moneda;
	private String desc_proceso;
	private String descripcion_negocio;
	private String nombre_cliente;

	public V_SIF_COBRANZA_DIARIA_DOS() {

	}

	public V_SIF_COBRANZA_DIARIA_DOS(Date fecha_datos, BigDecimal precio_aplicado, BigDecimal imp_cobdia,
			BigDecimal id_vista, BigDecimal desc_ajuste, BigDecimal ajuste, BigDecimal desc_cobdia,
			BigDecimal total_cobdia, BigDecimal iva_ajuste, BigDecimal iva_cobdia, BigDecimal subtotal_cobdia,
			BigDecimal subtotal_ajuste, BigDecimal desc_adicional, BigDecimal trx_cobdia, BigDecimal total_ajuste,
			BigDecimal id_cliente, BigDecimal id_servicios, BigDecimal id_negocio, BigDecimal id_moneda,
			BigDecimal id_proceso, BigDecimal id_empresa, BigDecimal tipo_cambio, String clave_cliente,
			String clave_negocio, String clave_empresa, String clave_proceso, String razon_social,
			String clave_servicio, String descripcion_servicio, String nombre_moneda, String desc_proceso,
			String descripcion_negocio, String nombre_cliente) {
		super();
		this.fecha_datos = fecha_datos;
		this.precio_aplicado = precio_aplicado;
		this.imp_cobdia = imp_cobdia;
		this.id_vista = id_vista;
		this.desc_ajuste = desc_ajuste;
		this.ajuste = ajuste;
		this.desc_cobdia = desc_cobdia;
		this.total_cobdia = total_cobdia;
		this.iva_ajuste = iva_ajuste;
		this.iva_cobdia = iva_cobdia;
		this.subtotal_cobdia = subtotal_cobdia;
		this.subtotal_ajuste = subtotal_ajuste;
		this.desc_adicional = desc_adicional;
		this.trx_cobdia = trx_cobdia;
		this.total_ajuste = total_ajuste;
		this.id_cliente = id_cliente;
		this.id_servicios = id_servicios;
		this.id_negocio = id_negocio;
		this.id_moneda = id_moneda;
		this.id_proceso = id_proceso;
		this.id_empresa = id_empresa;
		this.tipo_cambio = tipo_cambio;
		this.clave_cliente = clave_cliente;
		this.clave_negocio = clave_negocio;
		this.clave_empresa = clave_empresa;
		this.clave_proceso = clave_proceso;
		this.razon_social = razon_social;
		this.clave_servicio = clave_servicio;
		this.descripcion_servicio = descripcion_servicio;
		this.nombre_moneda = nombre_moneda;
		this.desc_proceso = desc_proceso;
		this.descripcion_negocio = descripcion_negocio;
		this.nombre_cliente = nombre_cliente;
	}

	public Date getFecha_datos() {
		return fecha_datos;
	}

	public void setFecha_datos(Date fecha_datos) {
		this.fecha_datos = fecha_datos;
	}

	public BigDecimal getPrecio_aplicado() {
		return precio_aplicado;
	}

	public void setPrecio_aplicado(BigDecimal precio_aplicado) {
		this.precio_aplicado = precio_aplicado;
	}

	public BigDecimal getImp_cobdia() {
		return imp_cobdia;
	}

	public void setImp_cobdia(BigDecimal imp_cobdia) {
		this.imp_cobdia = imp_cobdia;
	}

	public BigDecimal getId_vista() {
		return id_vista;
	}

	public void setId_vista(BigDecimal id_vista) {
		this.id_vista = id_vista;
	}

	public BigDecimal getDesc_ajuste() {
		return desc_ajuste;
	}

	public void setDesc_ajuste(BigDecimal desc_ajuste) {
		this.desc_ajuste = desc_ajuste;
	}

	public BigDecimal getAjuste() {
		return ajuste;
	}

	public void setAjuste(BigDecimal ajuste) {
		this.ajuste = ajuste;
	}

	public BigDecimal getDesc_cobdia() {
		return desc_cobdia;
	}

	public void setDesc_cobdia(BigDecimal desc_cobdia) {
		this.desc_cobdia = desc_cobdia;
	}

	public BigDecimal getTotal_cobdia() {
		return total_cobdia;
	}

	public void setTotal_cobdia(BigDecimal total_cobdia) {
		this.total_cobdia = total_cobdia;
	}

	public BigDecimal getIva_ajuste() {
		return iva_ajuste;
	}

	public void setIva_ajuste(BigDecimal iva_ajuste) {
		this.iva_ajuste = iva_ajuste;
	}

	public BigDecimal getIva_cobdia() {
		return iva_cobdia;
	}

	public void setIva_cobdia(BigDecimal iva_cobdia) {
		this.iva_cobdia = iva_cobdia;
	}

	public BigDecimal getSubtotal_cobdia() {
		return subtotal_cobdia;
	}

	public void setSubtotal_cobdia(BigDecimal subtotal_cobdia) {
		this.subtotal_cobdia = subtotal_cobdia;
	}

	public BigDecimal getSubtotal_ajuste() {
		return subtotal_ajuste;
	}

	public void setSubtotal_ajuste(BigDecimal subtotal_ajuste) {
		this.subtotal_ajuste = subtotal_ajuste;
	}

	public BigDecimal getDesc_adicional() {
		return desc_adicional;
	}

	public void setDesc_adicional(BigDecimal desc_adicional) {
		this.desc_adicional = desc_adicional;
	}

	public BigDecimal getTrx_cobdia() {
		return trx_cobdia;
	}

	public void setTrx_cobdia(BigDecimal trx_cobdia) {
		this.trx_cobdia = trx_cobdia;
	}

	public BigDecimal getTotal_ajuste() {
		return total_ajuste;
	}

	public void setTotal_ajuste(BigDecimal total_ajuste) {
		this.total_ajuste = total_ajuste;
	}

	public BigDecimal getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(BigDecimal id_cliente) {
		this.id_cliente = id_cliente;
	}

	public BigDecimal getId_servicios() {
		return id_servicios;
	}

	public void setId_servicios(BigDecimal id_servicios) {
		this.id_servicios = id_servicios;
	}

	public BigDecimal getId_negocio() {
		return id_negocio;
	}

	public void setId_negocio(BigDecimal id_negocio) {
		this.id_negocio = id_negocio;
	}

	public BigDecimal getId_moneda() {
		return id_moneda;
	}

	public void setId_moneda(BigDecimal id_moneda) {
		this.id_moneda = id_moneda;
	}

	public BigDecimal getId_proceso() {
		return id_proceso;
	}

	public void setId_proceso(BigDecimal id_proceso) {
		this.id_proceso = id_proceso;
	}

	public BigDecimal getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(BigDecimal id_empresa) {
		this.id_empresa = id_empresa;
	}

	public BigDecimal getTipo_cambio() {
		return tipo_cambio;
	}

	public void setTipo_cambio(BigDecimal tipo_cambio) {
		this.tipo_cambio = tipo_cambio;
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

	public String getClave_empresa() {
		return clave_empresa;
	}

	public void setClave_empresa(String clave_empresa) {
		this.clave_empresa = clave_empresa;
	}

	public String getClave_proceso() {
		return clave_proceso;
	}

	public void setClave_proceso(String clave_proceso) {
		this.clave_proceso = clave_proceso;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
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

	public String getNombre_moneda() {
		return nombre_moneda;
	}

	public void setNombre_moneda(String nombre_moneda) {
		this.nombre_moneda = nombre_moneda;
	}

	public String getDesc_proceso() {
		return desc_proceso;
	}

	public void setDesc_proceso(String desc_proceso) {
		this.desc_proceso = desc_proceso;
	}

	public String getDescripcion_negocio() {
		return descripcion_negocio;
	}

	public void setDescripcion_negocio(String descripcion_negocio) {
		this.descripcion_negocio = descripcion_negocio;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	@Override
	public String toString() {
		return "V_SIF_COBRANZA_DIARIA_DOS [fecha_datos=" + fecha_datos + ", precio_aplicado=" + precio_aplicado
				+ ", imp_cobdia=" + imp_cobdia + ", id_vista=" + id_vista + ", desc_ajuste=" + desc_ajuste + ", ajuste="
				+ ajuste + ", desc_cobdia=" + desc_cobdia + ", total_cobdia=" + total_cobdia + ", iva_ajuste="
				+ iva_ajuste + ", iva_cobdia=" + iva_cobdia + ", subtotal_cobdia=" + subtotal_cobdia
				+ ", subtotal_ajuste=" + subtotal_ajuste + ", desc_adicional=" + desc_adicional + ", trx_cobdia="
				+ trx_cobdia + ", total_ajuste=" + total_ajuste + ", id_cliente=" + id_cliente + ", id_servicios="
				+ id_servicios + ", id_negocio=" + id_negocio + ", id_moneda=" + id_moneda + ", id_proceso="
				+ id_proceso + ", id_empresa=" + id_empresa + ", tipo_cambio=" + tipo_cambio + ", clave_cliente="
				+ clave_cliente + ", clave_negocio=" + clave_negocio + ", clave_empresa=" + clave_empresa
				+ ", clave_proceso=" + clave_proceso + ", razon_social=" + razon_social + ", clave_servicio="
				+ clave_servicio + ", descripcion_servicio=" + descripcion_servicio + ", nombre_moneda=" + nombre_moneda
				+ ", desc_proceso=" + desc_proceso + ", descripcion_negocio=" + descripcion_negocio
				+ ", nombre_cliente=" + nombre_cliente + "]";
	}

}
