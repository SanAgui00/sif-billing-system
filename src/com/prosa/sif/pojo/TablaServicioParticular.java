/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 10/07/2018 #
# Descripcion General : Pojo para mapeo de TablaServPart                       #
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
@Table(name = "TBL_SIF_SERV_PART")
public class TablaServicioParticular {
	@Id
	private Integer id;
	private String clave;
	private String descripcion;
	private String estatus;
	private String usuario;
	private Date fecha;
	private String comentarios;

	public TablaServicioParticular() {
	}

	public TablaServicioParticular(Integer id, String clave, String descripcion, String estatus, String usuario,
			Date fecha, String comentarios) {
		super();
		this.id = id;
		this.clave = clave;
		this.descripcion = descripcion;
		this.estatus = estatus;
		this.usuario = usuario;
		this.fecha = fecha;
		this.comentarios = comentarios;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "TablaServicioParticular [id=" + id + ", clave=" + clave + ", descripcion=" + descripcion + ", estatus="
				+ estatus + ", usuario=" + usuario + ", fecha=" + fecha + ", comentarios=" + comentarios + "]";
	}

}
