/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 12/07/2018 #
# Descripcion General : Pojo para mapeo de TablaGpoClientes                    #
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
@Table(name = "TBL_SIF_CAT_GPO_CLIENTES")
public class TablaGrupoCliente {
	@Id
	private Integer id_grupo;
	private Date fecha_mod;
	private Date fecha_crea;
	private String usuario;
	private String clave;
	private String esquema;
	private String comentarios;
	private String estatus;
	private String descripcion;

	public TablaGrupoCliente() {

	}

	public TablaGrupoCliente(Integer id_grupo, Date fecha_mod, Date fecha_crea, String usuario, String clave,
			String esquema, String comentarios, String estatus, String descripcion) {
		super();
		this.id_grupo = id_grupo;
		this.fecha_mod = fecha_mod;
		this.fecha_crea = fecha_crea;
		this.usuario = usuario;
		this.clave = clave;
		this.esquema = esquema;
		this.comentarios = comentarios;
		this.estatus = estatus;
		this.descripcion = descripcion;
	}

	public Integer getId_grupo() {
		return id_grupo;
	}

	public void setId_grupo(Integer id_grupo) {
		this.id_grupo = id_grupo;
	}

	public Date getFecha_mod() {
		return fecha_mod;
	}

	public void setFecha_mod(Date fecha_mod) {
		this.fecha_mod = fecha_mod;
	}

	public Date getFecha_crea() {
		return fecha_crea;
	}

	public void setFecha_crea(Date fecha_crea) {
		this.fecha_crea = fecha_crea;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getEsquema() {
		return esquema;
	}

	public void setEsquema(String esquema) {
		this.esquema = esquema;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TablaGrupoCliente [id_grupo=" + id_grupo + ", fecha_mod=" + fecha_mod + ", fecha_crea=" + fecha_crea
				+ ", usuario=" + usuario + ", clave=" + clave + ", esquema=" + esquema + ", comentarios=" + comentarios
				+ ", estatus=" + estatus + ", descripcion=" + descripcion + "]";
	}

}
