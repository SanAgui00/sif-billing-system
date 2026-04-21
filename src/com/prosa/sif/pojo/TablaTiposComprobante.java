package com.prosa.sif.pojo;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_CAT_TIPOS_COMPROBANTE")
public class TablaTiposComprobante {

	@Id
	private Integer id;
	private String clave;
	private String descripcion;
	private Integer valor_minimo;
	private Integer valor_maximo;
	private String estatus;
	private String usuario;
	private Timestamp fecha;

	public TablaTiposComprobante() {

	}

	public TablaTiposComprobante(Integer id, String clave, String descripcion, Integer valor_minimo,
			Integer valor_maximo, String estatus, String usuario, Timestamp fecha) {
		super();
		this.id = id;
		this.clave = clave;
		this.descripcion = descripcion;
		this.valor_minimo = valor_minimo;
		this.valor_maximo = valor_maximo;
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

	public Integer getValor_minimo() {
		return valor_minimo;
	}

	public void setValor_minimo(Integer valor_minimo) {
		this.valor_minimo = valor_minimo;
	}

	public Integer getValor_maximo() {
		return valor_maximo;
	}

	public void setValor_maximo(Integer valor_maximo) {
		this.valor_maximo = valor_maximo;
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

	@Override
	public String toString() {
		return "TBL_SIF_CAT_TIPOS_COMPROBANTE [id=" + id + ", clave=" + clave + ", descripcion=" + descripcion
				+ ", valor_minimo=" + valor_minimo + ", valor_maximo=" + valor_maximo + ", estatus=" + estatus
				+ ", usuario=" + usuario + ", fecha=" + fecha + "]";
	}

}
