package com.prosa.sif.pojo;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_CAT_TIPOS_IMPUESTO")
public class TBL_SIF_CAT_TIPOS_IMPUESTO {

	@Id
	private Integer id;
	private String clave;
	private String descripcion;
	private String retencion;
	private String traslado;
	private String estatus;
	private String usuario;
	private Timestamp fecha;
	private String tipo_entidad;
	private String nombre_entidad;

	public TBL_SIF_CAT_TIPOS_IMPUESTO() {

	}

	public TBL_SIF_CAT_TIPOS_IMPUESTO(Integer id, String clave, String descripcion, String retencion, String traslado,
			String estatus, String usuario, Timestamp fecha, String tipo_entidad, String nombre_entidad) {
		super();
		this.id = id;
		this.clave = clave;
		this.descripcion = descripcion;
		this.retencion = retencion;
		this.traslado = traslado;
		this.estatus = estatus;
		this.usuario = usuario;
		this.fecha = fecha;
		this.tipo_entidad = tipo_entidad;
		this.nombre_entidad = nombre_entidad;
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

	public String getRetencion() {
		return retencion;
	}

	public void setRetencion(String retencion) {
		this.retencion = retencion;
	}

	public String getTraslado() {
		return traslado;
	}

	public void setTraslado(String traslado) {
		this.traslado = traslado;
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

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public String getTipo_entidad() {
		return tipo_entidad;
	}

	public void setTipo_entidad(String tipo_entidad) {
		this.tipo_entidad = tipo_entidad;
	}

	public String getNombre_entidad() {
		return nombre_entidad;
	}

	public void setNombre_entidad(String nombre_entidad) {
		this.nombre_entidad = nombre_entidad;
	}

	@Override
	public String toString() {
		return "TBL_SIF_CAT_TIPOS_IMPUESTO [id=" + id + ", clave=" + clave + ", descripcion=" + descripcion
				+ ", retencion=" + retencion + ", traslado=" + traslado + ", estatus=" + estatus + ", usuario="
				+ usuario + ", fecha=" + fecha + ", tipo_entidad=" + tipo_entidad + ", nombre_entidad=" + nombre_entidad
				+ "]";
	}

}
