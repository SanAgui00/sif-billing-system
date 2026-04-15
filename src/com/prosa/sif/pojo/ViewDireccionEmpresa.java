package com.prosa.sif.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VIEW_SIF_DIRECCION_EMPRESA")
public class ViewDireccionEmpresa {
	@Id
	private Integer id_empresa;
	private Integer id_domicilio;
	private String calle;
	private String num_int;
	private String num_ext;
	private String ciudad;
	private String cp;
	private String colonia;
	private String pais;
	private String estado;
	private String delegacion;
	private String apartado;

	public ViewDireccionEmpresa() {
	}

	public ViewDireccionEmpresa(Integer id_empresa, Integer id_domicilio, String calle, String num_int, String num_ext,
			String ciudad, String cp, String colonia, String pais, String estado, String delegacion, String apartado) {
		super();
		this.id_empresa = id_empresa;
		this.id_domicilio = id_domicilio;
		this.calle = calle;
		this.num_int = num_int;
		this.num_ext = num_ext;
		this.ciudad = ciudad;
		this.cp = cp;
		this.colonia = colonia;
		this.pais = pais;
		this.estado = estado;
		this.delegacion = delegacion;
		this.apartado = apartado;
	}

	public Integer getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(Integer id_empresa) {
		this.id_empresa = id_empresa;
	}

	public Integer getId_domicilio() {
		return id_domicilio;
	}

	public void setId_domicilio(Integer id_domicilio) {
		this.id_domicilio = id_domicilio;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNum_int() {
		return num_int;
	}

	public void setNum_int(String num_int) {
		this.num_int = num_int;
	}

	public String getNum_ext() {
		return num_ext;
	}

	public void setNum_ext(String num_ext) {
		this.num_ext = num_ext;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDelegacion() {
		return delegacion;
	}

	public void setDelegacion(String delegacion) {
		this.delegacion = delegacion;
	}

	public String getApartado() {
		return apartado;
	}

	public void setApartado(String apartado) {
		this.apartado = apartado;
	}

	@Override
	public String toString() {
		return "ViewDireccionEmpresa [id_empresa=" + id_empresa + ", id_domicilio=" + id_domicilio + ", calle=" + calle
				+ ", num_int=" + num_int + ", num_ext=" + num_ext + ", ciudad=" + ciudad + ", cp=" + cp + ", colonia="
				+ colonia + ", pais=" + pais + ", estado=" + estado + ", delegacion=" + delegacion + ", apartado="
				+ apartado + "]";
	}

}
