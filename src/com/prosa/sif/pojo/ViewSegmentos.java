package com.prosa.sif.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VIEW_SIF_SEGMENTOS")
public class ViewSegmentos {
	@Id
	private Integer id;
	private Integer id_segmento;
	private String descripcion_segmento;
	private String valor_segmento;
	private String descripcion;
	private Integer estatus;
	public ViewSegmentos() {
		super();
	}
	public ViewSegmentos(Integer id, Integer id_segmento, String descripcion_segmento, String valor_segmento,
			String descripcion, Integer estatus) {
		super();
		this.id = id;
		this.id_segmento = id_segmento;
		this.descripcion_segmento = descripcion_segmento;
		this.valor_segmento = valor_segmento;
		this.descripcion = descripcion;
		this.estatus = estatus;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_segmento() {
		return id_segmento;
	}
	public void setId_segmento(Integer id_segmento) {
		this.id_segmento = id_segmento;
	}
	public String getDescripcion_segmento() {
		return descripcion_segmento;
	}
	public void setDescripcion_segmento(String descripcion_segmento) {
		this.descripcion_segmento = descripcion_segmento;
	}
	public String getValor_segmento() {
		return valor_segmento;
	}
	public void setValor_segmento(String valor_segmento) {
		this.valor_segmento = valor_segmento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getEstatus() {
		return estatus;
	}
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}
	
}
