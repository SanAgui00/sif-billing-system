/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 23/08/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.pojo;

import java.util.Date;

public class BeanCalculaCobranza {
	// FUENTE
	private Number id_fuente;
	private String clave;
	private String descripcion_evento;
	private Number total_trans_leidas;
	private Number total_trans_conv;
	private Number total_trans_nconv;
	private String estatus;
	private Date fecha_datos;
	private Date fecha_base_contingencia;
	private Date fecha_ajuste;
	// SERVICIO
	private Number id_servicio;
	private String descripcion;
	private String estatus_calculo;
	private Number total_trans_emisor;
	private Number total_trans_adq;
	private Number costo_servicio;

	public BeanCalculaCobranza() {
	}

	public BeanCalculaCobranza(Number id_fuente, String clave, String descripcion_evento, Number total_trans_leidas,
			Number total_trans_conv, Number total_trans_nconv, String estatus, Date fecha_datos,
			Date fecha_base_contingencia, Date fecha_ajuste, Number id_servicio, String descripcion,
			String estatus_calculo, Number total_trans_emisor, Number total_trans_adq, Number costo_servicio) {
		this.id_fuente = id_fuente;
		this.clave = clave;
		this.descripcion_evento = descripcion_evento;
		this.total_trans_leidas = total_trans_leidas;
		this.total_trans_conv = total_trans_conv;
		this.total_trans_nconv = total_trans_nconv;
		this.estatus = estatus;
		this.fecha_datos = fecha_datos;
		this.fecha_base_contingencia = fecha_base_contingencia;
		this.fecha_ajuste = fecha_ajuste;
		this.id_servicio = id_servicio;
		this.descripcion = descripcion;
		this.estatus_calculo = estatus_calculo;
		this.total_trans_emisor = total_trans_emisor;
		this.total_trans_adq = total_trans_adq;
		this.costo_servicio = costo_servicio;
	}

	public Number getId_fuente() {
		return id_fuente;
	}

	public void setId_fuente(Number id_fuente) {
		this.id_fuente = id_fuente;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDescripcion_evento() {
		return descripcion_evento;
	}

	public void setDescripcion_evento(String descripcion_evento) {
		this.descripcion_evento = descripcion_evento;
	}

	public Number getTotal_trans_leidas() {
		return total_trans_leidas;
	}

	public void setTotal_trans_leidas(Number total_trans_leidas) {
		this.total_trans_leidas = total_trans_leidas;
	}

	public Number getTotal_trans_conv() {
		return total_trans_conv;
	}

	public void setTotal_trans_conv(Number total_trans_conv) {
		this.total_trans_conv = total_trans_conv;
	}

	public Number getTotal_trans_nconv() {
		return total_trans_nconv;
	}

	public void setTotal_trans_nconv(Number total_trans_nconv) {
		this.total_trans_nconv = total_trans_nconv;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Date getFecha_datos() {
		return fecha_datos;
	}

	public void setFecha_datos(Date fecha_datos) {
		this.fecha_datos = fecha_datos;
	}

	public Date getFecha_base_contingencia() {
		return fecha_base_contingencia;
	}

	public void setFecha_base_contingencia(Date fecha_base_contingencia) {
		this.fecha_base_contingencia = fecha_base_contingencia;
	}

	public Date getFecha_ajuste() {
		return fecha_ajuste;
	}

	public void setFecha_ajuste(Date fecha_ajuste) {
		this.fecha_ajuste = fecha_ajuste;
	}

	public Number getId_servicio() {
		return id_servicio;
	}

	public void setId_servicio(Number id_servicio) {
		this.id_servicio = id_servicio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstatus_calculo() {
		return estatus_calculo;
	}

	public void setEstatus_calculo(String estatus_calculo) {
		this.estatus_calculo = estatus_calculo;
	}

	public Number getTotal_trans_emisor() {
		return total_trans_emisor;
	}

	public void setTotal_trans_emisor(Number total_trans_emisor) {
		this.total_trans_emisor = total_trans_emisor;
	}

	public Number getTotal_trans_adq() {
		return total_trans_adq;
	}

	public void setTotal_trans_adq(Number total_trans_adq) {
		this.total_trans_adq = total_trans_adq;
	}

	public Number getCosto_servicio() {
		return costo_servicio;
	}

	public void setCosto_servicio(Number costo_servicio) {
		this.costo_servicio = costo_servicio;
	}

	@Override
	public String toString() {
		return "BeanCalculaCobranza [id_fuente=" + id_fuente + ", clave=" + clave + ", descripcion_evento="
				+ descripcion_evento + ", total_trans_leidas=" + total_trans_leidas + ", total_trans_conv="
				+ total_trans_conv + ", total_trans_nconv=" + total_trans_nconv + ", estatus=" + estatus
				+ ", fecha_datos=" + fecha_datos + ", fecha_base_contingencia=" + fecha_base_contingencia
				+ ", fecha_ajuste=" + fecha_ajuste + ", id_servicio=" + id_servicio + ", descripcion=" + descripcion
				+ ", estatus_calculo=" + estatus_calculo + ", total_trans_emisor=" + total_trans_emisor
				+ ", total_trans_adq=" + total_trans_adq + ", costo_servicio=" + costo_servicio + "]";
	}

}
