package com.prosa.sif.pojo;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VIEW_REPORTE_SOPORTE_SERVS")
public class ViewReporteSoporteServs {
	@Id
	private BigDecimal id_vista;
	private Integer id_fuente;
	private Integer id_cliente;
	private Date fechadatos;
	private String servicio;
	private String cvbanco;
	private String nmbanco;
	private String cvnegocio;
	private String nmnegocio;
	private String cvgrupoconcepto;
	private String nmgrupoconcepto;
	private String cvservicio;
	private String nmservicio;
	private String cvcaja;
	private String nmcaja;
	private BigDecimal transacciones;
	private BigDecimal precio;
	private BigDecimal importe;
	private BigDecimal importe_rebate_mensual;
	private BigDecimal descadicional;
	private BigDecimal totalfactura;

	public ViewReporteSoporteServs() {

	}

	public ViewReporteSoporteServs(BigDecimal id_vista, Integer id_fuente, Integer id_cliente, Date fechadatos,
			String servicio, String cvbanco, String nmbanco, String cvnegocio, String nmnegocio, String cvgrupoconcepto,
			String nmgrupoconcepto, String cvservicio, String nmservicio, String cvcaja, String nmcaja,
			BigDecimal transacciones, BigDecimal precio, BigDecimal importe, BigDecimal importe_rebate_mensual,
			BigDecimal descadicional, BigDecimal totalfactura) {
		super();
		this.id_vista = id_vista;
		this.id_fuente = id_fuente;
		this.id_cliente = id_cliente;
		this.fechadatos = fechadatos;
		this.servicio = servicio;
		this.cvbanco = cvbanco;
		this.nmbanco = nmbanco;
		this.cvnegocio = cvnegocio;
		this.nmnegocio = nmnegocio;
		this.cvgrupoconcepto = cvgrupoconcepto;
		this.nmgrupoconcepto = nmgrupoconcepto;
		this.cvservicio = cvservicio;
		this.nmservicio = nmservicio;
		this.cvcaja = cvcaja;
		this.nmcaja = nmcaja;
		this.transacciones = transacciones;
		this.precio = precio;
		this.importe = importe;
		this.importe_rebate_mensual = importe_rebate_mensual;
		this.descadicional = descadicional;
		this.totalfactura = totalfactura;
	}

	public BigDecimal getId_vista() {
		return id_vista;
	}

	public void setId_vista(BigDecimal id_vista) {
		this.id_vista = id_vista;
	}

	public Integer getId_fuente() {
		return id_fuente;
	}

	public void setId_fuente(Integer id_fuente) {
		this.id_fuente = id_fuente;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Date getFechadatos() {
		return fechadatos;
	}

	public void setFechadatos(Date fechadatos) {
		this.fechadatos = fechadatos;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public String getCvbanco() {
		return cvbanco;
	}

	public void setCvbanco(String cvbanco) {
		this.cvbanco = cvbanco;
	}

	public String getNmbanco() {
		return nmbanco;
	}

	public void setNmbanco(String nmbanco) {
		this.nmbanco = nmbanco;
	}

	public String getCvnegocio() {
		return cvnegocio;
	}

	public void setCvnegocio(String cvnegocio) {
		this.cvnegocio = cvnegocio;
	}

	public String getNmnegocio() {
		return nmnegocio;
	}

	public void setNmnegocio(String nmnegocio) {
		this.nmnegocio = nmnegocio;
	}

	public String getCvgrupoconcepto() {
		return cvgrupoconcepto;
	}

	public void setCvgrupoconcepto(String cvgrupoconcepto) {
		this.cvgrupoconcepto = cvgrupoconcepto;
	}

	public String getNmgrupoconcepto() {
		return nmgrupoconcepto;
	}

	public void setNmgrupoconcepto(String nmgrupoconcepto) {
		this.nmgrupoconcepto = nmgrupoconcepto;
	}

	public String getCvservicio() {
		return cvservicio;
	}

	public void setCvservicio(String cvservicio) {
		this.cvservicio = cvservicio;
	}

	public String getNmservicio() {
		return nmservicio;
	}

	public void setNmservicio(String nmservicio) {
		this.nmservicio = nmservicio;
	}

	public String getCvcaja() {
		return cvcaja;
	}

	public void setCvcaja(String cvcaja) {
		this.cvcaja = cvcaja;
	}

	public String getNmcaja() {
		return nmcaja;
	}

	public void setNmcaja(String nmcaja) {
		this.nmcaja = nmcaja;
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

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public BigDecimal getImporte_rebate_mensual() {
		return importe_rebate_mensual;
	}

	public void setImporte_rebate_mensual(BigDecimal importe_rebate_mensual) {
		this.importe_rebate_mensual = importe_rebate_mensual;
	}

	public BigDecimal getDescadicional() {
		return descadicional;
	}

	public void setDescadicional(BigDecimal descadicional) {
		this.descadicional = descadicional;
	}

	public BigDecimal getTotalfactura() {
		return totalfactura;
	}

	public void setTotalfactura(BigDecimal totalfactura) {
		this.totalfactura = totalfactura;
	}

	@Override
	public String toString() {
		return "VIEW_REPORTE_SOPORTE_SERVS [id_vista=" + id_vista + ", id_fuente=" + id_fuente + ", id_cliente="
				+ id_cliente + ", fechadatos=" + fechadatos + ", servicio=" + servicio + ", cvbanco=" + cvbanco
				+ ", nmbanco=" + nmbanco + ", cvnegocio=" + cvnegocio + ", nmnegocio=" + nmnegocio
				+ ", cvgrupoconcepto=" + cvgrupoconcepto + ", nmgrupoconcepto=" + nmgrupoconcepto + ", cvservicio="
				+ cvservicio + ", nmservicio=" + nmservicio + ", cvcaja=" + cvcaja + ", nmcaja=" + nmcaja
				+ ", transacciones=" + transacciones + ", precio=" + precio + ", importe=" + importe
				+ ", importe_rebate_mensual=" + importe_rebate_mensual + ", descadicional=" + descadicional
				+ ", totalfactura=" + totalfactura + "]";
	}

}
