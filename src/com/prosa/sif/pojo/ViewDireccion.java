package com.prosa.sif.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//klmwdmklaklmdakml
@Entity
@Table(name = "VIEW_SIF_DIRECCIONES")
public class ViewDireccion {
	@Id
	private Integer id_domicilio;
	private Integer id_pais;
	private Integer id_codigo_postal;
	private Integer id_poblacion;
	private Integer id_estado;
	private String calle;
	private String numero_ext;
	private String numero_int;
	private String cp;
	private String colonia;
	private String ciudad;
	private String pais;
	private String estado;
	private String delegacion;
	private String apartado_postal;

	public ViewDireccion() {

	}

	public ViewDireccion(Integer id_domicilio, Integer id_pais, Integer id_codigo_postal, Integer id_poblacion,
			Integer id_estado, String calle, String numero_ext, String numero_int, String cp, String colonia,
			String ciudad, String pais, String estado, String delegacion, String apartado_postal) {
		super();
		this.id_domicilio = id_domicilio;
		this.id_pais = id_pais;
		this.id_codigo_postal = id_codigo_postal;
		this.id_poblacion = id_poblacion;
		this.id_estado = id_estado;
		this.calle = calle;
		this.numero_ext = numero_ext;
		this.numero_int = numero_int;
		this.cp = cp;
		this.colonia = colonia;
		this.ciudad = ciudad;
		this.pais = pais;
		this.estado = estado;
		this.delegacion = delegacion;
		this.apartado_postal = apartado_postal;
	}

	public Integer getId_domicilio() {
		return id_domicilio;
	}

	public void setId_domicilio(Integer id_domicilio) {
		this.id_domicilio = id_domicilio;
	}

	public Integer getId_pais() {
		return id_pais;
	}

	public void setId_pais(Integer id_pais) {
		this.id_pais = id_pais;
	}

	public Integer getId_codigo_postal() {
		return id_codigo_postal;
	}

	public void setId_codigo_postal(Integer id_codigo_postal) {
		this.id_codigo_postal = id_codigo_postal;
	}

	public Integer getId_poblacion() {
		return id_poblacion;
	}

	public void setId_poblacion(Integer id_poblacion) {
		this.id_poblacion = id_poblacion;
	}

	public Integer getId_estado() {
		return id_estado;
	}

	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero_ext() {
		return numero_ext;
	}

	public void setNumero_ext(String numero_ext) {
		this.numero_ext = numero_ext;
	}

	public String getNumero_int() {
		return numero_int;
	}

	public void setNumero_int(String numero_int) {
		this.numero_int = numero_int;
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

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
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

	public String getApartado_postal() {
		return apartado_postal;
	}

	public void setApartado_postal(String apartado_postal) {
		this.apartado_postal = apartado_postal;
	}

	@Override
	public String toString() {
		return "ViewDireccion [id_domicilio=" + id_domicilio + ", id_pais=" + id_pais + ", id_codigo_postal="
				+ id_codigo_postal + ", id_poblacion=" + id_poblacion + ", id_estado=" + id_estado + ", calle=" + calle
				+ ", numero_ext=" + numero_ext + ", numero_int=" + numero_int + ", cp=" + cp + ", colonia=" + colonia
				+ ", ciudad=" + ciudad + ", pais=" + pais + ", estado=" + estado + ", delegacion=" + delegacion
				+ ", apartado_postal=" + apartado_postal + "]";
	}

}
