/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 08/03/2018 #
# Descripcion General : Pojo para mapeo de TBL_SIF_CAT_FUNCIONALIDADES         #
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
@Table(name = "TBL_SIF_CAT_FUNCIONALIDADES")
public class TBL_SIF_CAT_FUNCIONALIDADES {
	@Id
	private Integer id;
	private String nombre;
	private String descripcion;
	private String usuario;
	private Date fecha;

	public TBL_SIF_CAT_FUNCIONALIDADES() {
	}

	public TBL_SIF_CAT_FUNCIONALIDADES(Integer id, String nombre, String descripcion, String usuario, Date fecha) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.usuario = usuario;
		this.fecha = fecha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	@Override
	public String toString() {
		return "TBL_SIF_CAT_FUNCIONALIDADES [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", usuario=" + usuario + ", fecha=" + fecha + "]";
	}

}
