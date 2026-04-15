package com.prosa.sif.pojo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_CAT_PAISES")
public class TablaPais {
	@Id
	private Integer id_pais;
	private Integer clave;
	private String nombre;
	private String abreviatura;
	private BigDecimal codigo;
	private String clave_sat;

	public TablaPais() {

	}

	public TablaPais(Integer id_pais, Integer clave, String nombre, String abreviatura, BigDecimal codigo,
			String clave_sat) {
		super();
		this.id_pais = id_pais;
		this.clave = clave;
		this.nombre = nombre;
		this.abreviatura = abreviatura;
		this.codigo = codigo;
		this.clave_sat = clave_sat;
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

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public BigDecimal getCodigo() {
		return codigo;
	}

	public void setCodigo(BigDecimal codigo) {
		this.codigo = codigo;
	}

	public String getClave_sat() {
		return clave_sat;
	}

	public void setClave_sat(String clave_sat) {
		this.clave_sat = clave_sat;
	}

	@Override
	public String toString() {
		return "TablaPais [id_pais=" + id_pais + ", clave=" + clave + ", nombre=" + nombre + ", abreviatura="
				+ abreviatura + ", codigo=" + codigo + ", clave_sat=" + clave_sat + "]";
	}

}
