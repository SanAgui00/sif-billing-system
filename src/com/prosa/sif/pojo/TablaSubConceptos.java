package com.prosa.sif.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_SUBCONCEPTOS")
public class TablaSubConceptos {
	@Id
	private Number id; 
	private Number id_servicios; 
	private Number numero;
	private String descripcion; 
	private String valor; 
	private Number id_precio;
	
	public TablaSubConceptos() {
		
	}

	public TablaSubConceptos(Number id, Number id_servicios, Number numero, String descripcion, String valor,
			Number id_precio) {
		super();
		this.id = id;
		this.id_servicios = id_servicios;
		this.numero = numero;
		this.descripcion = descripcion;
		this.valor = valor;
		this.id_precio = id_precio;
	}

	public Number getId() {
		return id;
	}

	public void setId(Number id) {
		this.id = id;
	}

	public Number getId_servicios() {
		return id_servicios;
	}

	public void setId_servicios(Number id_servicios) {
		this.id_servicios = id_servicios;
	}

	public Number getNumero() {
		return numero;
	}

	public void setNumero(Number numero) {
		this.numero = numero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Number getId_precio() {
		return id_precio;
	}

	public void setId_precio(Number id_precio) {
		this.id_precio = id_precio;
	}

	@Override
	public String toString() {
		return "TablaSubConceptos [id=" + id + ", id_servicios=" + id_servicios + ", numero=" + numero
				+ ", descripcion=" + descripcion + ", valor=" + valor + ", id_precio=" + id_precio + "]";
	}
	
}
