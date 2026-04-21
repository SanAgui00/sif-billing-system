/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 28/06/2018 #
# Descripcion General : Pojo para mapeo de TablaCentroCostos                   #
# Marca del cambio    : 									                   #
#------------------------------------------------------------------------------#
# Numero de Parametros: N/A                                                    #
# Parametros Entrada  : N/A                                  Formato:          #
# Parametros Salida   : N/A                                  Formato:          #
################################################################################
**/

package com.prosa.sif.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_CAT_CENTRO_COSTOS")
public class TablaCentroCosto {
	@Id
	private Integer id_centro_costos;
	private String clave_centro_costos;
	private String descripcion;
	private String estatus;
	private Date fecha_cre;
	private Date fecha_mod;
	private String usuario;
	private String comentarios;

	public TablaCentroCosto() {

	}

	public TablaCentroCosto(Integer id_centro_costos, String clave_centro_costos, String descripcion, String estatus,
			Date fecha_cre, Date fecha_mod, String usuario, String comentarios) {
		super();
		this.id_centro_costos = id_centro_costos;
		this.clave_centro_costos = clave_centro_costos;
		this.descripcion = descripcion;
		this.estatus = estatus;
		this.fecha_cre = fecha_cre;
		this.fecha_mod = fecha_mod;
		this.usuario = usuario;
		this.comentarios = comentarios;
	}

	public Integer getId_centro_costos() {
		return id_centro_costos;
	}

	public void setId_centro_costos(Integer id_centro_costos) {
		this.id_centro_costos = id_centro_costos;
	}

	public String getClave_centro_costos() {
		return clave_centro_costos;
	}

	public void setClave_centro_costos(String clave_centro_costos) {
		this.clave_centro_costos = clave_centro_costos;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	@Override
	public String toString() {
		return "TablaCentroCosto [id_centro_costos=" + id_centro_costos + ", clave_centro_costos=" + clave_centro_costos
				+ ", descripcion=" + descripcion + ", estatus=" + estatus + ", fecha_cre=" + fecha_cre + ", fecha_mod="
				+ fecha_mod + ", usuario=" + usuario + ", comentarios=" + comentarios + "]";
	}

}
