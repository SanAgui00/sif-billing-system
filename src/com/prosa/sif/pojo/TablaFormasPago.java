package com.prosa.sif.pojo;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_CAT_FORMAS_PAGO")
public class TablaFormasPago {

	@Id
	private Integer id;
	private String clave;
	private String descripcion;
	private String bancarizado;
	private String estatus;
	private String usuario;
	private Date fecha;

	public TablaFormasPago() {

	}

	public TablaFormasPago(Integer id, String clave, String descripcion, String bancarizado, String estatus,
			String usuario, Date fecha) {

		this.id = id;
		this.clave = clave;
		this.descripcion = descripcion;
		this.bancarizado = bancarizado;
		this.estatus = estatus;
		this.usuario = usuario;
		this.fecha = fecha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getBancarizado() {
		return bancarizado;
	}

	public void setBancarizado(String bancarizado) {
		this.bancarizado = bancarizado;
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

	@Override
	public String toString() {
		return "TBL_SIF_CAT_FORMAS_PAGO [id=" + id + ", clave=" + clave + ", descripcion=" + descripcion
				+ ", bancarizado=" + bancarizado + ", estatus=" + estatus + ", usuario=" + usuario + ", fecha=" + fecha
				+ "]";
	}

}
