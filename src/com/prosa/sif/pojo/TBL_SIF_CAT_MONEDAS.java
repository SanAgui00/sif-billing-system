/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 08/03/2018 #
# Descripcion General : Pojo para mapeo de TBL_SIF_CAT_MONEDAS                 #
# Marca del cambio    : 									                   #
#------------------------------------------------------------------------------#
# Numero de Parametros: N/A                                                    #
# Parametros Entrada  : N/A                                  Formato:          #
# Parametros Salida   : N/A                                  Formato:          #
################################################################################
**/
package com.prosa.sif.pojo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_CAT_MONEDAS")
public class TBL_SIF_CAT_MONEDAS {

	@Id
	private Integer id_moneda;
	private String nombre_moneda;
	private String pais;
	private String simbolo;
	private BigDecimal t_moneda;
	private String estatus;
	private Date fecha_cre;
	private Date fecha_mod;
	private String usuario;
	private String comentarios;
	private String clave_sat;
	private String nombre_sat;
	private BigDecimal decimales;
	private BigDecimal variacion;

	// @OneToMany(mappedBy = "monedas")
	// private Set<TBL_SIF_FACTURAS> facturas;

	public TBL_SIF_CAT_MONEDAS() {

	}

	public TBL_SIF_CAT_MONEDAS(Integer id_moneda, String nombre_moneda, String pais, String simbolo,
			BigDecimal t_moneda, String estatus, Date fecha_cre, Date fecha_mod, String usuario, String comentarios,
			String clave_sat, String nombre_sat, BigDecimal decimales, BigDecimal variacion) {
		super();
		this.id_moneda = id_moneda;
		this.nombre_moneda = nombre_moneda;
		this.pais = pais;
		this.simbolo = simbolo;
		this.t_moneda = t_moneda;
		this.estatus = estatus;
		this.fecha_cre = fecha_cre;
		this.fecha_mod = fecha_mod;
		this.usuario = usuario;
		this.comentarios = comentarios;
		this.clave_sat = clave_sat;
		this.nombre_sat = nombre_sat;
		this.decimales = decimales;
		this.variacion = variacion;
	}

	public Integer getId_moneda() {
		return id_moneda;
	}

	public void setId_moneda(Integer id_moneda) {
		this.id_moneda = id_moneda;
	}

	public String getNombre_moneda() {
		return nombre_moneda;
	}

	public void setNombre_moneda(String nombre_moneda) {
		this.nombre_moneda = nombre_moneda;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public BigDecimal getT_moneda() {
		return t_moneda;
	}

	public void setT_moneda(BigDecimal t_moneda) {
		this.t_moneda = t_moneda;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Date getFecha_cre() {
		return fecha_cre;
	}

	public void setFecha_cre(Date fecha_cre) {
		this.fecha_cre = fecha_cre;
	}

	public Date getFecha_mod() {
		return fecha_mod;
	}

	public void setFecha_mod(Date fecha_mod) {
		this.fecha_mod = fecha_mod;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getClave_sat() {
		return clave_sat;
	}

	public void setClave_sat(String clave_sat) {
		this.clave_sat = clave_sat;
	}

	public String getNombre_sat() {
		return nombre_sat;
	}

	public void setNombre_sat(String nombre_sat) {
		this.nombre_sat = nombre_sat;
	}

	public BigDecimal getDecimales() {
		return decimales;
	}

	public void setDecimales(BigDecimal decimales) {
		this.decimales = decimales;
	}

	public BigDecimal getVariacion() {
		return variacion;
	}

	public void setVariacion(BigDecimal variacion) {
		this.variacion = variacion;
	}

	@Override
	public String toString() {
		return "TBL_SIF_CAT_MONEDAS [id_moneda=" + id_moneda + ", nombre_moneda=" + nombre_moneda + ", pais=" + pais
				+ ", simbolo=" + simbolo + ", t_moneda=" + t_moneda + ", estatus=" + estatus + ", fecha_cre="
				+ fecha_cre + ", fecha_mod=" + fecha_mod + ", usuario=" + usuario + ", comentarios=" + comentarios
				+ ", clave_sat=" + clave_sat + ", nombre_sat=" + nombre_sat + ", decimales=" + decimales
				+ ", variacion=" + variacion + "]";
	}

}
