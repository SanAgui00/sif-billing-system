package com.prosa.sif.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_CAT_IMPORTES")
public class TablaImporte {
	@Id
	private Integer id_importe;
	private String clave;
	private String descripcion;
	private String usuario;
	private String estatus;
	private Date fecha_cre;
	public TablaImporte() {
		super();
	}
	public TablaImporte(Integer id_importe, String clave, String descripcion, String usuario, String estatus,
			Date fecha_cre) {
		super();
		this.id_importe = id_importe;
		this.clave = clave;
		this.descripcion = descripcion;
		this.usuario = usuario;
		this.estatus = estatus;
		this.fecha_cre = fecha_cre;
	}
	public Integer getId_importe() {
		return id_importe;
	}
	public void setId_importe(Integer id_importe) {
		this.id_importe = id_importe;
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
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
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
	
	
	

}
