package com.prosa.sif.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_CAT_ESTADOS")
public class TablaEstados {
	@Id
	private Integer id_estado;
	private Integer id_pais;
	private Integer clave;
	private String nombre;
	private Integer uso_horario;
	private String clave_sat;
	public TablaEstados() {
		super();
	}
	public TablaEstados(Integer id_estado, Integer id_pais, Integer clave, String nombre, Integer uso_horario,
			String clave_sat) {
		super();
		this.id_estado = id_estado;
		this.id_pais = id_pais;
		this.clave = clave;
		this.nombre = nombre;
		this.uso_horario = uso_horario;
		this.clave_sat = clave_sat;
	}
	public Integer getId_estado() {
		return id_estado;
	}
	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}
	public Integer getId_pais() {
		return id_pais;
	}
	public void setId_pais(Integer id_pais) {
		this.id_pais = id_pais;
	}
	public Integer getClave() {
		return clave;
	}
	public void setClave(Integer clave) {
		this.clave = clave;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getUso_horario() {
		return uso_horario;
	}
	public void setUso_horario(Integer uso_horario) {
		this.uso_horario = uso_horario;
	}
	public String getClave_sat() {
		return clave_sat;
	}
	public void setClave_sat(String clave_sat) {
		this.clave_sat = clave_sat;
	}
	
	
}
