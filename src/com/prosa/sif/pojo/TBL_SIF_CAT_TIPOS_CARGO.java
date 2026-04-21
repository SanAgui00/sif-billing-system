package com.prosa.sif.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_CAT_TIPOS_CARGO")
public class TBL_SIF_CAT_TIPOS_CARGO {
	@Id
	private String tipo_cargo;
	private String descripcion;

	public TBL_SIF_CAT_TIPOS_CARGO() {
	}

	public TBL_SIF_CAT_TIPOS_CARGO(String tipo_cargo, String descripcion) {

		this.tipo_cargo = tipo_cargo;
		this.descripcion = descripcion;
	}

	public String getTipo_cargo() {
		return tipo_cargo;
	}

	public void setTipo_cargo(String tipo_cargo) {
		this.tipo_cargo = tipo_cargo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TBL_SIF_CAT_TIPOS_CARGO [tipo_cargo=" + tipo_cargo + ", descripcion=" + descripcion + "]";
	}

}
