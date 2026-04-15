/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 05/06/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.pojo;

import java.util.Date;

public class BeanMantenerRegistro {
	private Number id_poliza;
	private String descripcion;
	private Date fecha_cre;
	private String estatus;
	private Number id_generado_gl;
	private Number id_poliza_reversada;
	private Date fecha_datos_ini;
	private Date fecha_datos_fin;
	public BeanMantenerRegistro() {
		
	}
	public BeanMantenerRegistro(Number id_poliza, String descripcion, Date fecha_cre, String estatus,
			Number id_generado_gl, Number id_poliza_reversada, Date fecha_datos_ini, Date fecha_datos_fin) {
		super();
		this.id_poliza = id_poliza;
		this.descripcion = descripcion;
		this.fecha_cre = fecha_cre;
		this.estatus = estatus;
		this.id_generado_gl = id_generado_gl;
		this.id_poliza_reversada = id_poliza_reversada;
		this.fecha_datos_ini = fecha_datos_ini;
		this.fecha_datos_fin = fecha_datos_fin;
	}
	public Number getId_poliza() {
		return id_poliza;
	}
	public void setId_poliza(Number id_poliza) {
		this.id_poliza = id_poliza;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha_cre() {
		return fecha_cre;
	}
	public void setFecha_cre(Date fecha_cre) {
		this.fecha_cre = fecha_cre;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public Number getId_generado_gl() {
		return id_generado_gl;
	}
	public void setId_generado_gl(Number id_generado_gl) {
		this.id_generado_gl = id_generado_gl;
	}
	public Number getId_poliza_reversada() {
		return id_poliza_reversada;
	}
	public void setId_poliza_reversada(Number id_poliza_reversada) {
		this.id_poliza_reversada = id_poliza_reversada;
	}
	public Date getFecha_datos_ini() {
		return fecha_datos_ini;
	}
	public void setFecha_datos_ini(Date fecha_datos_ini) {
		this.fecha_datos_ini = fecha_datos_ini;
	}
	public Date getFecha_datos_fin() {
		return fecha_datos_fin;
	}
	public void setFecha_datos_fin(Date fecha_datos_fin) {
		this.fecha_datos_fin = fecha_datos_fin;
	}	
	
}
