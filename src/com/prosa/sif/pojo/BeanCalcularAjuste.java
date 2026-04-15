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

import java.util.Date;

public class BeanCalcularAjuste {

	private Number id_fuente;
	private String clave;
	private String estatus;
	private Date fecha_datos;
	// campos ajuste por proceso
	private Number id_proceso;
	private String clave_proceso;
	private Number id_negocio;
	private Number num_serv;
	private Number periodo;
	private Number num_serv_cont;

	public BeanCalcularAjuste() {

	}

	public BeanCalcularAjuste(Number id_fuente, String clave, String estatus, Date fecha_datos, Number id_proceso,
			String clave_proceso, Number id_negocio, Number num_serv, Number periodo, Number num_serv_cont) {
		super();
		this.id_fuente = id_fuente;
		this.clave = clave;
		this.estatus = estatus;
		this.fecha_datos = fecha_datos;
		this.id_proceso = id_proceso;
		this.clave_proceso = clave_proceso;
		this.id_negocio = id_negocio;
		this.num_serv = num_serv;
		this.periodo = periodo;
		this.num_serv_cont = num_serv_cont;
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

	public Number getId_proceso() {
		return id_proceso;
	}

	public void setId_proceso(Number id_proceso) {
		this.id_proceso = id_proceso;
	}

	public String getClave_proceso() {
		return clave_proceso;
	}

	public void setClave_proceso(String clave_proceso) {
		this.clave_proceso = clave_proceso;
	}

	public Number getId_negocio() {
		return id_negocio;
	}

	public void setId_negocio(Number id_negocio) {
		this.id_negocio = id_negocio;
	}

	public Number getNum_serv() {
		return num_serv;
	}

	public void setNum_serv(Number num_serv) {
		this.num_serv = num_serv;
	}

	public Number getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Number periodo) {
		this.periodo = periodo;
	}

	public Number getNum_serv_cont() {
		return num_serv_cont;
	}

	public void setNum_serv_cont(Number num_serv_cont) {
		this.num_serv_cont = num_serv_cont;
	}

	@Override
	public String toString() {
		return "BeanCalcularAjuste [id_fuente=" + id_fuente + ", clave=" + clave + ", estatus=" + estatus
				+ ", fecha_datos=" + fecha_datos + ", id_proceso=" + id_proceso + ", clave_proceso=" + clave_proceso
				+ ", id_negocio=" + id_negocio + ", num_serv=" + num_serv + ", periodo=" + periodo + ", num_serv_cont="
				+ num_serv_cont + "]";
	}

}
