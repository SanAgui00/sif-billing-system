/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 08/03/2018 #
# Descripcion General : Pojo para mapeo de TBL_SIF_FUENTES                     #
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
@Table(name = "TBL_SIF_FUENTES")
public class TBL_SIF_FUENTES {
	@Id
	private Integer id_fuente;
	private Integer id_fuente_base_clave_cli;
	private String clave;
	private String descripcion;
	private String estatus;
	private Date fecha_creacion;
	private Date fecha_mod;
	private String usuario;
	private String comentarios;

	public TBL_SIF_FUENTES() {

	}

	public TBL_SIF_FUENTES(int id_fuente_base_clave_cli, String clave, String descripcion, String estatus,
			Date fecha_creacion, Date fecha_mod, String usuario, String comentarios) {
		super();
		this.id_fuente_base_clave_cli = id_fuente_base_clave_cli;
		this.clave = clave;
		this.descripcion = descripcion;
		this.estatus = estatus;
		this.fecha_creacion = fecha_creacion;
		this.fecha_mod = fecha_mod;
		this.usuario = usuario;
		this.comentarios = comentarios;
	}

	public int getId_fuente() {
		return id_fuente;
	}

	public void setId_fuente(int id_fuente) {
		this.id_fuente = id_fuente;
	}

	public int getId_fuente_base_clave_cli() {
		return id_fuente_base_clave_cli;
	}

	public void setId_fuente_base_clave_cli(int id_fuente_base_clave_cli) {
		this.id_fuente_base_clave_cli = id_fuente_base_clave_cli;
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

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
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
		return "TBL_SIF_FUENTES [id_fuente=" + id_fuente + ", id_fuente_base_clave_cli=" + id_fuente_base_clave_cli
				+ ", clave=" + clave + ", descripcion=" + descripcion + ", estatus=" + estatus + ", fecha_creacion="
				+ fecha_creacion + ", fecha_mod=" + fecha_mod + ", usuario=" + usuario + ", comentarios=" + comentarios
				+ "]";
	}

}
