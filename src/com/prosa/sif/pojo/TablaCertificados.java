package com.prosa.sif.pojo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_CAT_CERTIFICADOS")

public class TablaCertificados {

	@Id
	private Integer id;
	private String cert_privado;
	private String cert_publico;
	private String descripcion;
	private String estatus;
	private String usuario;
	private Date fecha;
	private Integer id_empresa;
	private String cert_ruta;
	
	
	public TablaCertificados() {
	}
	
	public TablaCertificados(Integer id, String cert_privado, String cert_publico, String descripcion, String estatus, String usuario,
			Date fecha, Integer id_empresa,String cert_ruta) {
	super();
		this.id = id;
		this.cert_privado = cert_privado;
		this.cert_publico = cert_publico;
		this.descripcion = descripcion;
		this.estatus = estatus;
		this.usuario = usuario;
		this.fecha = fecha;
		this.id_empresa = id_empresa;
		this.cert_ruta = cert_ruta;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCert_privado() {
		return cert_privado;
	}

	public void setCert_privado(String cert_privado) {
		this.cert_privado = cert_privado;
	}
	
	public String getCert_publico() {
		return cert_publico;
	}

	public void setCert_publico(String cert_publico) {
		this.cert_publico = cert_publico;
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
	
	public Integer getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(Integer id_empresa) {
		this.id_empresa = id_empresa;
	}
	public String getCert_ruta() {
		return cert_ruta;
	}

	public void setCcert_ruta(String cert_ruta) {
		this.cert_ruta = cert_ruta;
	}
	@Override
	public String toString() {
		return "TablaCertificados [id=" + id + ", cert_privado=" + cert_privado + ", cert_publico=" + cert_publico + ", descripcion=" + descripcion
				+ ", estatus=" + estatus + ", usuario=" + usuario + ", fecha=" + fecha + ", fecha=" + fecha
				+ ", id_empresa=" + id_empresa + ", cert_ruta=" + cert_ruta +"]";
	}

	
}
