/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 06/07/2018 #
# Descripcion General : Pojo para mapeo de TablaCatPolizasContables            #
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
@Table(name = "TBL_SIF_CAT_POLIZAS_CONTABLES")
public class TablaPolizasContable {
	@Id
	private Integer id_modelo_poliza;
	private String clave;
	private String descripcion;
	private String tipo;
	private String usuario;
	private String estatus;
	private Date fecha_cre;
	private Date fecha_mod;
	private String comentarios;
	public TablaPolizasContable() {
		
	}
	public TablaPolizasContable(Integer id_modelo_poliza, String clave, String descripcion, String tipo, String usuario,
			String estatus, Date fecha_cre, Date fecha_mod, String comentarios) {
		super();
		this.id_modelo_poliza = id_modelo_poliza;
		this.clave = clave;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.usuario = usuario;
		this.estatus = estatus;
		this.fecha_cre = fecha_cre;
		this.fecha_mod = fecha_mod;
		this.comentarios = comentarios;
	}
	public Integer getId_modelo_poliza() {
		return id_modelo_poliza;
	}
	public void setId_modelo_poliza(Integer id_modelo_poliza) {
		this.id_modelo_poliza = id_modelo_poliza;
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
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
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
	
	
}
