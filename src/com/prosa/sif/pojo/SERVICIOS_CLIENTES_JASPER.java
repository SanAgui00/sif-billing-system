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

public class SERVICIOS_CLIENTES_JASPER {

	private String clave_empresa;
	private String razon_social;
	private String calle;
	private String colonia;
	private String estado;
	private String nombre_moneda;
	private String folio;
	private String clave_negocio;
	private String desc_negocio;
	private String clave_cliente;
	private String nombre_corto;
	private String clave_grupo;
	private String descripcion_grupo;
	private String clave_servicio;
	private String descripcion_servicio;
	private BigDecimal numero_subconcepto;
	private String descripcion;
	private BigDecimal transacciones;
	private BigDecimal aplica_promedio;
	private BigDecimal importe_cobranza;
	private BigDecimal descuento;
	private BigDecimal descuento_adicional;
	private BigDecimal total_importe_real;
	private BigDecimal trans_subconcepto;
	private BigDecimal costo_subconcepto;
	private BigDecimal desc_subconcepto;
	private BigDecimal rebate_subconcepto;
	private BigDecimal total_subconcepto;
	private BigDecimal hay_descuento;
	private BigDecimal hay_rebate;
	private BigDecimal precio;

	public SERVICIOS_CLIENTES_JASPER(String clave_empresa, String razon_social, String calle, String colonia,
			String estado, String nombre_moneda, String folio, String clave_negocio, String desc_negocio,
			String clave_cliente, String nombre_corto, String clave_grupo, String descripcion_grupo,
			String clave_servicio, String descripcion_servicio, BigDecimal numero_subconcepto, String descripcion,
			BigDecimal transacciones, BigDecimal aplica_promedio, BigDecimal importe_cobranza, BigDecimal descuento,
			BigDecimal descuento_adicional, BigDecimal total_importe_real, BigDecimal trans_subconcepto,
			BigDecimal costo_subconcepto, BigDecimal desc_subconcepto, BigDecimal rebate_subconcepto,
			BigDecimal total_subconcepto, BigDecimal hay_descuento, BigDecimal hay_rebate, BigDecimal precio) {
		super();
		this.clave_empresa = clave_empresa;
		this.razon_social = razon_social;
		this.calle = calle;
		this.colonia = colonia;
		this.estado = estado;
		this.nombre_moneda = nombre_moneda;
		this.folio = folio;
		this.clave_negocio = clave_negocio;
		this.desc_negocio = desc_negocio;
		this.clave_cliente = clave_cliente;
		this.nombre_corto = nombre_corto;
		this.clave_grupo = clave_grupo;
		this.descripcion_grupo = descripcion_grupo;
		this.clave_servicio = clave_servicio;
		this.descripcion_servicio = descripcion_servicio;
		this.numero_subconcepto = numero_subconcepto;
		this.descripcion = descripcion;
		this.transacciones = transacciones;
		this.aplica_promedio = aplica_promedio;
		this.importe_cobranza = importe_cobranza;
		this.descuento = descuento;
		this.descuento_adicional = descuento_adicional;
		this.total_importe_real = total_importe_real;
		this.trans_subconcepto = trans_subconcepto;
		this.costo_subconcepto = costo_subconcepto;
		this.desc_subconcepto = desc_subconcepto;
		this.rebate_subconcepto = rebate_subconcepto;
		this.total_subconcepto = total_subconcepto;
		this.hay_descuento = hay_descuento;
		this.hay_rebate = hay_rebate;
		this.precio = precio;
	}

	public String getClave_empresa() {
		return clave_empresa;
	}

	public void setClave_empresa(String clave_empresa) {
		this.clave_empresa = clave_empresa;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre_moneda() {
		return nombre_moneda;
	}

	public void setNombre_moneda(String nombre_moneda) {
		this.nombre_moneda = nombre_moneda;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public String getClave_negocio() {
		return clave_negocio;
	}

	public void setClave_negocio(String clave_negocio) {
		this.clave_negocio = clave_negocio;
	}

	public String getDesc_negocio() {
		return desc_negocio;
	}

	public void setDesc_negocio(String desc_negocio) {
		this.desc_negocio = desc_negocio;
	}

	public String getClave_cliente() {
		return clave_cliente;
	}

	public void setClave_cliente(String clave_cliente) {
		this.clave_cliente = clave_cliente;
	}

	public String getNombre_corto() {
		return nombre_corto;
	}

	public void setNombre_corto(String nombre_corto) {
		this.nombre_corto = nombre_corto;
	}

	public String getClave_grupo() {
		return clave_grupo;
	}

	public void setClave_grupo(String clave_grupo) {
		this.clave_grupo = clave_grupo;
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

	public BigDecimal getNumero_subconcepto() {
		return numero_subconcepto;
	}

	public void setNumero_subconcepto(BigDecimal numero_subconcepto) {
		this.numero_subconcepto = numero_subconcepto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(BigDecimal transacciones) {
		this.transacciones = transacciones;
	}

	public BigDecimal getAplica_promedio() {
		return aplica_promedio;
	}

	public void setAplica_promedio(BigDecimal aplica_promedio) {
		this.aplica_promedio = aplica_promedio;
	}

	public BigDecimal getImporte_cobranza() {
		return importe_cobranza;
	}

	public void setImporte_cobranza(BigDecimal importe_cobranza) {
		this.importe_cobranza = importe_cobranza;
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

	public BigDecimal getTotal_importe_real() {
		return total_importe_real;
	}

	public void setTotal_importe_real(BigDecimal total_importe_real) {
		this.total_importe_real = total_importe_real;
	}

	public BigDecimal getTrans_subconcepto() {
		return trans_subconcepto;
	}

	public void setTrans_subconcepto(BigDecimal trans_subconcepto) {
		this.trans_subconcepto = trans_subconcepto;
	}

	public BigDecimal getCosto_subconcepto() {
		return costo_subconcepto;
	}

	public void setCosto_subconcepto(BigDecimal costo_subconcepto) {
		this.costo_subconcepto = costo_subconcepto;
	}

	public BigDecimal getDesc_subconcepto() {
		return desc_subconcepto;
	}

	public void setDesc_subconcepto(BigDecimal desc_subconcepto) {
		this.desc_subconcepto = desc_subconcepto;
	}

	public BigDecimal getRebate_subconcepto() {
		return rebate_subconcepto;
	}

	public void setRebate_subconcepto(BigDecimal rebate_subconcepto) {
		this.rebate_subconcepto = rebate_subconcepto;
	}

	public BigDecimal getTotal_subconcepto() {
		return total_subconcepto;
	}

	public void setTotal_subconcepto(BigDecimal total_subconcepto) {
		this.total_subconcepto = total_subconcepto;
	}

	public BigDecimal getHay_descuento() {
		return hay_descuento;
	}

	public void setHay_descuento(BigDecimal hay_descuento) {
		this.hay_descuento = hay_descuento;
	}

	public BigDecimal getHay_rebate() {
		return hay_rebate;
	}

	public void setHay_rebate(BigDecimal hay_rebate) {
		this.hay_rebate = hay_rebate;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "SERVICIOS_CLIENTES_JASPER [clave_empresa=" + clave_empresa + ", razon_social=" + razon_social
				+ ", calle=" + calle + ", colonia=" + colonia + ", estado=" + estado + ", nombre_moneda="
				+ nombre_moneda + ", folio=" + folio + ", clave_negocio=" + clave_negocio + ", desc_negocio="
				+ desc_negocio + ", clave_cliente=" + clave_cliente + ", nombre_corto=" + nombre_corto
				+ ", clave_grupo=" + clave_grupo + ", descripcion_grupo=" + descripcion_grupo + ", clave_servicio="
				+ clave_servicio + ", descripcion_servicio=" + descripcion_servicio + ", numero_subconcepto="
				+ numero_subconcepto + ", descripcion=" + descripcion + ", transacciones=" + transacciones
				+ ", aplica_promedio=" + aplica_promedio + ", importe_cobranza=" + importe_cobranza + ", descuento="
				+ descuento + ", descuento_adicional=" + descuento_adicional + ", total_importe_real="
				+ total_importe_real + ", trans_subconcepto=" + trans_subconcepto + ", costo_subconcepto="
				+ costo_subconcepto + ", desc_subconcepto=" + desc_subconcepto + ", rebate_subconcepto="
				+ rebate_subconcepto + ", total_subconcepto=" + total_subconcepto + ", hay_descuento=" + hay_descuento
				+ ", hay_rebate=" + hay_rebate + ", precio=" + precio + "]";
	}

}
