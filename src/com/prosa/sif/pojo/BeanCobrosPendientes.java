/**
################################################################################
# Autor               : Garnica Garcia David                                   #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 25/04/2018 #
# Descripcion General : Bean para cobros pendientes                            #
# Marca del cambio    :                                                        #
#------------------------------------------------------------------------------#
# Numero de Parametros: N/A                                                    #
# Parametros Entrada  : N/A                                  Formato:          #
# Parametros Salida   : N/A                                  Formato:          #
################################################################################
**/
package com.prosa.sif.pojo;

import java.util.Date;
/**
 * 
 * @author David Garnica Garcia
 *
 */
public class BeanCobrosPendientes {
	private String folio_interno;
	private String folio_impresion;
	private Number id_cliente;
	private String clave_cliente;
	private String nombre_corto_cliente;
	private Number id_negocio;
	private String clave_negocio;
	private String descripcion_negocio;
	private Number id_centro_costos;
	private Number id_proceso;
	private String periodicidad_cobro;
	private Number id_moneda_cobro;
	private String sistema_cobro;
	private Number id_servicio_cobrable;
	private Date fecha_datos;
	private Date fecha_cobro_area_op;
	private Date fecha_calculo;
	private Date fecha_cobro_libra;
	private Date fecha_cobro_sac;
	private Date fecha_cobro;
	private Number costo_servicio;
	private Number descuento;
	private Number desc_adicional;
	private Number iva_servicio;
	private String tipo_documento;
	private Number tipo_cambio;
	
	
	public BeanCobrosPendientes() {
		
	}


	public BeanCobrosPendientes(String folio_interno, String folio_impresion, Number id_cliente, String clave_cliente,
			String nombre_corto_cliente, Number id_negocio, String clave_negocio, String descripcion_negocio,
			Number id_centro_costos, Number id_proceso, String periodicidad_cobro, Number id_moneda_cobro,
			String sistema_cobro, Number id_servicio_cobrable, Date fecha_datos, Date fecha_cobro_area_op,
			Date fecha_calculo, Date fecha_cobro_libra, Date fecha_cobro_sac, Date fecha_cobro, Number costo_servicio,
			Number descuento, Number desc_adicional, Number iva_servicio, String tipo_documento,
			Number tipo_cambio) {
		super();
		this.folio_interno = folio_interno;
		this.folio_impresion = folio_impresion;
		this.id_cliente = id_cliente;
		this.clave_cliente = clave_cliente;
		this.nombre_corto_cliente = nombre_corto_cliente;
		this.id_negocio = id_negocio;
		this.clave_negocio = clave_negocio;
		this.descripcion_negocio = descripcion_negocio;
		this.id_centro_costos = id_centro_costos;
		this.id_proceso = id_proceso;
		this.periodicidad_cobro = periodicidad_cobro;
		this.id_moneda_cobro = id_moneda_cobro;
		this.sistema_cobro = sistema_cobro;
		this.id_servicio_cobrable = id_servicio_cobrable;
		this.fecha_datos = fecha_datos;
		this.fecha_cobro_area_op = fecha_cobro_area_op;
		this.fecha_calculo = fecha_calculo;
		this.fecha_cobro_libra = fecha_cobro_libra;
		this.fecha_cobro_sac = fecha_cobro_sac;
		this.fecha_cobro = fecha_cobro;
		this.costo_servicio = costo_servicio;
		this.descuento = descuento;
		this.desc_adicional = desc_adicional;
		this.iva_servicio = iva_servicio;
		this.tipo_documento = tipo_documento;
		this.tipo_cambio = tipo_cambio;
	}


	public String getFolio_interno() {
		return folio_interno;
	}


	public void setFolio_interno(String folio_interno) {
		this.folio_interno = folio_interno;
	}


	public String getFolio_impresion() {
		return folio_impresion;
	}


	public void setFolio_impresion(String folio_impresion) {
		this.folio_impresion = folio_impresion;
	}


	public Number getId_cliente() {
		return id_cliente;
	}


	public void setId_cliente(Number id_cliente) {
		this.id_cliente = id_cliente;
	}


	public String getClave_cliente() {
		return clave_cliente;
	}


	public void setClave_cliente(String clave_cliente) {
		this.clave_cliente = clave_cliente;
	}


	public String getNombre_corto_cliente() {
		return nombre_corto_cliente;
	}


	public void setNombre_corto_cliente(String nombre_corto_cliente) {
		this.nombre_corto_cliente = nombre_corto_cliente;
	}


	public Number getId_negocio() {
		return id_negocio;
	}


	public void setId_negocio(Number id_negocio) {
		this.id_negocio = id_negocio;
	}


	public String getClave_negocio() {
		return clave_negocio;
	}


	public void setClave_negocio(String clave_negocio) {
		this.clave_negocio = clave_negocio;
	}


	public String getDescripcion_negocio() {
		return descripcion_negocio;
	}


	public void setDescripcion_negocio(String descripcion_negocio) {
		this.descripcion_negocio = descripcion_negocio;
	}


	public Number getId_centro_costos() {
		return id_centro_costos;
	}


	public void setId_centro_costos(Number id_centro_costos) {
		this.id_centro_costos = id_centro_costos;
	}


	public Number getId_proceso() {
		return id_proceso;
	}


	public void setId_proceso(Number id_proceso) {
		this.id_proceso = id_proceso;
	}


	public String getPeriodicidad_cobro() {
		return periodicidad_cobro;
	}


	public void setPeriodicidad_cobro(String periodicidad_cobro) {
		this.periodicidad_cobro = periodicidad_cobro;
	}


	public Number getId_moneda_cobro() {
		return id_moneda_cobro;
	}


	public void setId_moneda_cobro(Number id_moneda_cobro) {
		this.id_moneda_cobro = id_moneda_cobro;
	}


	public String getSistema_cobro() {
		return sistema_cobro;
	}


	public void setSistema_cobro(String sistema_cobro) {
		this.sistema_cobro = sistema_cobro;
	}


	public Number getId_servicio_cobrable() {
		return id_servicio_cobrable;
	}


	public void setId_servicio_cobrable(Number id_servicio_cobrable) {
		this.id_servicio_cobrable = id_servicio_cobrable;
	}


	public Date getFecha_datos() {
		return fecha_datos;
	}


	public void setFecha_datos(Date fecha_datos) {
		this.fecha_datos = fecha_datos;
	}


	public Date getFecha_cobro_area_op() {
		return fecha_cobro_area_op;
	}


	public void setFecha_cobro_area_op(Date fecha_cobro_area_op) {
		this.fecha_cobro_area_op = fecha_cobro_area_op;
	}


	public Date getFecha_calculo() {
		return fecha_calculo;
	}


	public void setFecha_calculo(Date fecha_calculo) {
		this.fecha_calculo = fecha_calculo;
	}


	public Date getFecha_cobro_libra() {
		return fecha_cobro_libra;
	}


	public void setFecha_cobro_libra(Date fecha_cobro_libra) {
		this.fecha_cobro_libra = fecha_cobro_libra;
	}


	public Date getFecha_cobro_sac() {
		return fecha_cobro_sac;
	}


	public void setFecha_cobro_sac(Date fecha_cobro_sac) {
		this.fecha_cobro_sac = fecha_cobro_sac;
	}


	public Date getFecha_cobro() {
		return fecha_cobro;
	}


	public void setFecha_cobro(Date fecha_cobro) {
		this.fecha_cobro = fecha_cobro;
	}


	public Number getCosto_servicio() {
		return costo_servicio;
	}


	public void setCosto_servicio(Number costo_servicio) {
		this.costo_servicio = costo_servicio;
	}


	public Number getDescuento() {
		return descuento;
	}


	public void setDescuento(Number descuento) {
		this.descuento = descuento;
	}


	public Number getDesc_adicional() {
		return desc_adicional;
	}


	public void setDesc_adicional(Number desc_adicional) {
		this.desc_adicional = desc_adicional;
	}


	public Number getIva_servicio() {
		return iva_servicio;
	}


	public void setIva_servicio(Number iva_servicio) {
		this.iva_servicio = iva_servicio;
	}


	public String getTipo_documento() {
		return tipo_documento;
	}


	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}


	public Number getTipo_cambio() {
		return tipo_cambio;
	}


	public void setTipo_cambio(Number tipo_cambio) {
		this.tipo_cambio = tipo_cambio;
	}
	
	

}
