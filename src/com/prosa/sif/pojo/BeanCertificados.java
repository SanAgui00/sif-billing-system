package com.prosa.sif.pojo;

import java.util.Date;

public class BeanCertificados {
private Number id; 
private String razon_social;
private String cert_publico;
private String cert_privado;
private String descripcion;
private String estatus;
private String usuario;
private Date fecha;
private String cert_ruta ;

public BeanCertificados() {
	super();
}

public BeanCertificados(Number id, String razon_social, String cert_publico, String cert_privado, String descripcion,
		String estatus, String usuario, Date fecha, String cert_ruta) {
	super();
	this.id = id;
	this.razon_social = razon_social;
	this.cert_publico = cert_publico;
	this.cert_privado = cert_privado;
	this.descripcion = descripcion;
	this.estatus = estatus;
	this.usuario = usuario;
	this.fecha = fecha;
	this.cert_ruta = cert_ruta;
}

public Number getId() {
	return id;
}

public void setId(Number id) {
	this.id = id;
}

public String getRazon_social() {
	return razon_social;
}

public void setRazon_social(String razon_social) {
	this.razon_social = razon_social;
}

public String getCert_publico() {
	return cert_publico;
}

public void setCert_publico(String cert_publico) {
	this.cert_publico = cert_publico;
}

public String getCert_privado() {
	return cert_privado;
}

public void setCert_privado(String cert_privado) {
	this.cert_privado = cert_privado;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

public String getEstatus() {
	return estatus;
}

public void setEstatus(String estatus) {
	this.estatus = estatus;
}

public String getUsuario() {
	return usuario;
}

public void setUsuario(String usuario) {
	this.usuario = usuario;
}

public Date getFecha() {
	return fecha;
}

public void setFecha(Date fecha) {
	this.fecha = fecha;
}

public String getCert_ruta() {
	return cert_ruta;
}

public void setCert_ruta(String cert_ruta) {
	this.cert_ruta = cert_ruta;
}




}
