package com.prosa.sif.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_CAT_UNIDAD_MEDIDA")
public class TBL_SIF_CAT_UNIDAD_MEDIDA {
	@Id
	private String unidad_medida;
	private String descripcion;

	public TBL_SIF_CAT_UNIDAD_MEDIDA() {
	}

	public TBL_SIF_CAT_UNIDAD_MEDIDA(String unidad_medida, String descripcion) {
		this.unidad_medida = unidad_medida;
		this.descripcion = descripcion;
	}

	public String getUnidad_medida() {
		return unidad_medida;
	}

	public void setUnidad_medida(String unidad_medida) {
		this.unidad_medida = unidad_medida;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TBL_SIF_CAT_UNIDAD_MEDIDA [unidad_medida=" + unidad_medida + ", descripcion=" + descripcion + "]";
	}

}
