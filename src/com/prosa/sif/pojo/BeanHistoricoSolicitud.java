/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente : D-52-8268-17                         Fecha: 01/06/2018 #
# Descripcion General : Bean de mapeo para el Historico de Solicitud		   #
# Marca del cambio    : LOGASIF									               #
################################################################################
**/
package com.prosa.sif.pojo;

import java.util.Date;

public class BeanHistoricoSolicitud {
	private Number id_servicio;
	private String clave;
	private String descripcion;
	private Date fecha_datos;
	private Date fecha_cobro_area_op;
	private String estatus;
	private Date fecha_cre;
	private String usuario;
	private Number total_trans_emisor;
	private Number total_trans_adq;
	private Number total_importe_emisor;
	private Number total_importe_adq;
	private Number total_cobranza;

	public BeanHistoricoSolicitud() {

	}

	public BeanHistoricoSolicitud(Number id_servicio, String clave, String descripcion, Date fecha_datos,
			Date fecha_cobro_area_op, String estatus, Date fecha_cre, String usuario, Number total_trans_emisor,
			Number total_trans_adq, Number total_importe_emisor, Number total_importe_adq, Number total_cobranza) {
		super();
		this.id_servicio = id_servicio;
		this.clave = clave;
		this.descripcion = descripcion;
		this.fecha_datos = fecha_datos;
		this.fecha_cobro_area_op = fecha_cobro_area_op;
		this.estatus = estatus;
		this.fecha_cre = fecha_cre;
		this.usuario = usuario;
		this.total_trans_emisor = total_trans_emisor;
		this.total_trans_adq = total_trans_adq;
		this.total_importe_emisor = total_importe_emisor;
		this.total_importe_adq = total_importe_adq;
		this.total_cobranza = total_cobranza;
	}

	public Number getId_servicio() {
		return id_servicio;
	}

	public void setId_servicio(Number id_servicio) {
		this.id_servicio = id_servicio;
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

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Date getFecha_cre() {
		return fecha_cre;
	}

	public void setFecha_cre(Date fecha_cre) {
		this.fecha_cre = fecha_cre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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

	public Number getTotal_importe_emisor() {
		return total_importe_emisor;
	}

	public void setTotal_importe_emisor(Number total_importe_emisor) {
		this.total_importe_emisor = total_importe_emisor;
	}

	public Number getTotal_importe_adq() {
		return total_importe_adq;
	}

	public void setTotal_importe_adq(Number total_importe_adq) {
		this.total_importe_adq = total_importe_adq;
	}

	public Number getTotal_cobranza() {
		return total_cobranza;
	}

	public void setTotal_cobranza(Number total_cobranza) {
		this.total_cobranza = total_cobranza;
	}

	@Override
	public String toString() {
		return "BeanHistoricoSolicitud [id_servicio=" + id_servicio + ", clave=" + clave + ", descripcion="
				+ descripcion + ", fecha_datos=" + fecha_datos + ", fecha_cobro_area_op=" + fecha_cobro_area_op
				+ ", estatus=" + estatus + ", fecha_cre=" + fecha_cre + ", usuario=" + usuario + ", total_trans_emisor="
				+ total_trans_emisor + ", total_trans_adq=" + total_trans_adq + ", total_importe_emisor="
				+ total_importe_emisor + ", total_importe_adq=" + total_importe_adq + ", total_cobranza="
				+ total_cobranza + "]";
	}

}