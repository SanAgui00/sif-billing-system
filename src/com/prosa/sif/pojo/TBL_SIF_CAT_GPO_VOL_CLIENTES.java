package com.prosa.sif.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_CAT_GPO_VOL_CLIENTES")
public class TBL_SIF_CAT_GPO_VOL_CLIENTES {
	@Id
	private Integer id_grupo;
	private String clave;
	private String descripcion;
	private String estatus;
	private Date fecha_mod;
	private Date fecha_crea;
	private String comentarios;
	private String usuario;

	public TBL_SIF_CAT_GPO_VOL_CLIENTES() {

	}

	public TBL_SIF_CAT_GPO_VOL_CLIENTES(Integer id_grupo, String clave, String descripcion, String estatus,
			Date fecha_mod, Date fecha_crea, String comentarios, String usuario) {

		this.id_grupo = id_grupo;
		this.clave = clave;
		this.descripcion = descripcion;
		this.estatus = estatus;
		this.fecha_mod = fecha_mod;
		this.fecha_crea = fecha_crea;
		this.comentarios = comentarios;
		this.usuario = usuario;
	}

	public Integer getId_grupo() {
		return id_grupo;
	}

	public void setId_grupo(Integer id_grupo) {
		this.id_grupo = id_grupo;
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

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Date getFecha_mod() {
		return fecha_mod;
	}

	public void setFecha_mod(Date fecha_mod) {
		this.fecha_mod = fecha_mod;
	}

	public Date getFecha_crea() {
		return fecha_crea;
	}

	public void setFecha_crea(Date fecha_crea) {
		this.fecha_crea = fecha_crea;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "TBL_SIF_CAT_GPO_VOL_CLIENTES [id_grupo=" + id_grupo + ", clave=" + clave + ", descripcion="
				+ descripcion + ", estatus=" + estatus + ", fecha_mod=" + fecha_mod + ", fecha_crea=" + fecha_crea
				+ ", comentarios=" + comentarios + ", usuario=" + usuario + "]";
	}

}
