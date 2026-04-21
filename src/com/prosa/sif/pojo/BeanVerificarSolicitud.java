/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente : D-52-8268-17                         Fecha: 01/06/2018 #
# Descripcion General : Bean de mapeo para  Verificar Solicitud			   	   #
# Marca del cambio    : LOGASIF									               #
################################################################################
**/
package com.prosa.sif.pojo;

import java.util.Date;

public class BeanVerificarSolicitud {
	private Number id_servicio;
	private Number id_moneda;
	private Date fecha_datos;
	private String estatus;
	private String descripcion;
	private String nombre_moneda;
	private String usuario;
	private Date fecha_cobro_area_op;
	private Number total_trans_emisor;
	private Number total_importe_emisor;
	private Number total_iva_emisor;
	private Number total_trans_adq;
	private Number total_importe_adq;
	private String clave;
	private Date fecha_calculo;
	private Date fecha_cre;
	private Number id_cliente;
	private String clave_cliente;
	private String nombre_corto;

	public BeanVerificarSolicitud() {

	}

	public BeanVerificarSolicitud(Number id_servicio, Number id_moneda, Date fecha_datos, String estatus,
			String descripcion, String nombre_moneda, String usuario, Date fecha_cobro_area_op,
			Number total_trans_emisor, Number total_importe_emisor, Number total_iva_emisor, Number total_trans_adq,
			Number total_importe_adq, String clave, Date fecha_calculo, Date fecha_cre, Number id_cliente,
			String clave_cliente, String nombre_corto) {
		super();
		this.id_servicio = id_servicio;
		this.id_moneda = id_moneda;
		this.fecha_datos = fecha_datos;
		this.estatus = estatus;
		this.descripcion = descripcion;
		this.nombre_moneda = nombre_moneda;
		this.usuario = usuario;
		this.fecha_cobro_area_op = fecha_cobro_area_op;
		this.total_trans_emisor = total_trans_emisor;
		this.total_importe_emisor = total_importe_emisor;
		this.total_iva_emisor = total_iva_emisor;
		this.total_trans_adq = total_trans_adq;
		this.total_importe_adq = total_importe_adq;
		this.clave = clave;
		this.fecha_calculo = fecha_calculo;
		this.fecha_cre = fecha_cre;
		this.id_cliente = id_cliente;
		this.clave_cliente = clave_cliente;
		this.nombre_corto = nombre_corto;
	}

	public Number getId_servicio() {
		return id_servicio;
	}

	public void setId_servicio(Number id_servicio) {
		this.id_servicio = id_servicio;
	}

	public Number getId_moneda() {
		return id_moneda;
	}

	public void setId_moneda(Number id_moneda) {
		this.id_moneda = id_moneda;
	}

	public Date getFecha_datos() {
		return fecha_datos;
	}

	public void setFecha_datos(Date fecha_datos) {
		this.fecha_datos = fecha_datos;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre_moneda() {
		return nombre_moneda;
	}

	public void setNombre_moneda(String nombre_moneda) {
		this.nombre_moneda = nombre_moneda;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getFecha_cobro_area_op() {
		return fecha_cobro_area_op;
	}

	public void setFecha_cobro_area_op(Date fecha_cobro_area_op) {
		this.fecha_cobro_area_op = fecha_cobro_area_op;
	}

	public Number getTotal_trans_emisor() {
		return total_trans_emisor;
	}

	public void setTotal_trans_emisor(Number total_trans_emisor) {
		this.total_trans_emisor = total_trans_emisor;
	}

	public Number getTotal_importe_emisor() {
		return total_importe_emisor;
	}

	public void setTotal_importe_emisor(Number total_importe_emisor) {
		this.total_importe_emisor = total_importe_emisor;
	}

	public Number getTotal_iva_emisor() {
		return total_iva_emisor;
	}

	public void setTotal_iva_emisor(Number total_iva_emisor) {
		this.total_iva_emisor = total_iva_emisor;
	}

	public Number getTotal_trans_adq() {
		return total_trans_adq;
	}

	public void setTotal_trans_adq(Number total_trans_adq) {
		this.total_trans_adq = total_trans_adq;
	}

	public Number getTotal_importe_adq() {
		return total_importe_adq;
	}

	public void setTotal_importe_adq(Number total_importe_adq) {
		this.total_importe_adq = total_importe_adq;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Date getFecha_calculo() {
		return fecha_calculo;
	}

	public void setFecha_calculo(Date fecha_calculo) {
		this.fecha_calculo = fecha_calculo;
	}

	public Date getFecha_cre() {
		return fecha_cre;
	}

	public void setFecha_cre(Date fecha_cre) {
		this.fecha_cre = fecha_cre;
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

	public String getNombre_corto() {
		return nombre_corto;
	}

	public void setNombre_corto(String nombre_corto) {
		this.nombre_corto = nombre_corto;
	}

	@Override
	public String toString() {
		return "BeanVerificarSolicitud [id_servicio=" + id_servicio + ", id_moneda=" + id_moneda + ", fecha_datos="
				+ fecha_datos + ", estatus=" + estatus + ", descripcion=" + descripcion + ", nombre_moneda="
				+ nombre_moneda + ", usuario=" + usuario + ", fecha_cobro_area_op=" + fecha_cobro_area_op
				+ ", total_trans_emisor=" + total_trans_emisor + ", total_importe_emisor=" + total_importe_emisor
				+ ", total_iva_emisor=" + total_iva_emisor + ", total_trans_adq=" + total_trans_adq
				+ ", total_importe_adq=" + total_importe_adq + ", clave=" + clave + ", fecha_calculo=" + fecha_calculo
				+ ", fecha_cre=" + fecha_cre + ", id_cliente=" + id_cliente + ", clave_cliente=" + clave_cliente
				+ ", nombre_corto=" + nombre_corto + "]";
	}

}
