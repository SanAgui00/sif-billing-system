/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 19/08/2018 #
# Descripcion General : Pojo para mapeo de TablaCatClavesUnidad                #
# Marca del cambio    : 									                   #
#------------------------------------------------------------------------------#
# Numero de Parametros: N/A                                                    #
# Parametros Entrada  : N/A                                  Formato:          #
# Parametros Salida   : N/A                                  Formato:          #
################################################################################
**/

package com.prosa.sif.pojo;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_CAT_CLAVES_UNIDAD")
public class TBL_SIF_CAT_CLAVES_UNIDAD {

	@Id
	private Integer id;
	private String clave;
	private String descripcion;
	private String simbolo;
	private String estatus;
	private String usuario;
	private Timestamp fecha;

	public TBL_SIF_CAT_CLAVES_UNIDAD() {

	}

	public TBL_SIF_CAT_CLAVES_UNIDAD(Integer id, String clave, String descripcion, String simbolo, String estatus,
			String usuario, Timestamp fecha) {
		super();
		this.id = id;
		this.clave = clave;
		this.descripcion = descripcion;
		this.simbolo = simbolo;
		this.estatus = estatus;
		this.usuario = usuario;
		this.fecha = fecha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "TBL_SIF_CAT_CLAVES_UNIDAD [id=" + id + ", clave=" + clave + ", descripcion=" + descripcion
				+ ", simbolo=" + simbolo + ", estatus=" + estatus + ", usuario=" + usuario + ", fecha=" + fecha + "]";
	}

}
