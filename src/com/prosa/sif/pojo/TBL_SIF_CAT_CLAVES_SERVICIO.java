/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 02/07/2018 #
# Descripcion General : Pojo para mapeo de TablaCatClavesServicio              #
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
@Table(name= "TBL_SIF_CAT_CLAVES_SERVICIO")
public class TBL_SIF_CAT_CLAVES_SERVICIO {

	@Id
	private Integer	id;
	private String clave;
	private String descripcion;
	private String iva_traslado;
	private String ieps_traslado;
	private String estatus;
	private String usuario;
	private Timestamp fecha;
	
	public TBL_SIF_CAT_CLAVES_SERVICIO(){
		
	}

	public TBL_SIF_CAT_CLAVES_SERVICIO(Integer id, String clave, String descripcion, String iva_traslado,
			String ieps_traslado, String estatus, String usuario, Timestamp fecha) {
		super();
		this.id = id;
		this.clave = clave;
		this.descripcion = descripcion;
		this.iva_traslado = iva_traslado;
		this.ieps_traslado = ieps_traslado;
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

	public String getIva_traslado() {
		return iva_traslado;
	}

	public void setIva_traslado(String iva_traslado) {
		this.iva_traslado = iva_traslado;
	}

	public String getIeps_traslado() {
		return ieps_traslado;
	}

	public void setIeps_traslado(String ieps_traslado) {
		this.ieps_traslado = ieps_traslado;
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
		return "TBL_SIF_CAT_CLAVES_SERVICIO [id=" + id + ", clave=" + clave + ", descripcion=" + descripcion
				+ ", iva_traslado=" + iva_traslado + ", ieps_traslado=" + ieps_traslado + ", estatus=" + estatus
				+ ", usuario=" + usuario + ", fecha=" + fecha + "]";
	}
	
	
}
