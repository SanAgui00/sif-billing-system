/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 10/09/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.pojo;

public class B_SOPORTE_SERVICIOS {
	private String fechadatos;
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
	private Number transacciones;
	private Number precio;
	private Number importe;
	private Number descadicional;
	private Number totalfactura;

	public B_SOPORTE_SERVICIOS() {

	}

	public B_SOPORTE_SERVICIOS(String fechadatos, String cvbanco, String nmbanco, String cvnegocio, String nmnegocio,
			String cvgrupoconcepto, String nmgrupoconcepto, String cvservicio, String nmservicio, String cvcaja,
			String nmcaja, Number transacciones, Number precio, Number importe, Number descadicional,
			Number totalfactura) {
		super();
		this.fechadatos = fechadatos;
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
		this.descadicional = descadicional;
		this.totalfactura = totalfactura;
	}

	public String getFechadatos() {
		return fechadatos;
	}

	public void setFechadatos(String fechadatos) {
		this.fechadatos = fechadatos;
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

	public Number getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(Number transacciones) {
		this.transacciones = transacciones;
	}

	public Number getPrecio() {
		return precio;
	}

	public void setPrecio(Number precio) {
		this.precio = precio;
	}

	public Number getImporte() {
		return importe;
	}

	public void setImporte(Number importe) {
		this.importe = importe;
	}

	public Number getDescadicional() {
		return descadicional;
	}

	public void setDescadicional(Number descadicional) {
		this.descadicional = descadicional;
	}

	public Number getTotalfactura() {
		return totalfactura;
	}

	public void setTotalfactura(Number totalfactura) {
		this.totalfactura = totalfactura;
	}

	@Override
	public String toString() {
		return "B_SOPORTE_SERVICIOS [fechadatos=" + fechadatos + ", cvbanco=" + cvbanco + ", nmbanco=" + nmbanco
				+ ", cvnegocio=" + cvnegocio + ", nmnegocio=" + nmnegocio + ", cvgrupoconcepto=" + cvgrupoconcepto
				+ ", nmgrupoconcepto=" + nmgrupoconcepto + ", cvservicio=" + cvservicio + ", nmservicio=" + nmservicio
				+ ", cvcaja=" + cvcaja + ", nmcaja=" + nmcaja + ", transacciones=" + transacciones + ", precio="
				+ precio + ", importe=" + importe + ", descadicional=" + descadicional + ", totalfactura="
				+ totalfactura + "]";
	}


}