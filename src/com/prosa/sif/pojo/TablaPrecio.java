/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 18/06/2018 #
# Descripcion General : Pojo para mapeo de TablaCatPrecios                     #
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
@Table(name = "TBL_SIF_CAT_PRECIOS")
public class TablaPrecio {
	@Id
	private Integer id_precio;
	private String tipo_precio;
	private Integer id_moneda;
	private String estatus;
	private Date fecha_mod;
	private Date fecha_cre;
	private String usuario;
	private String comentarios;

	public TablaPrecio() {

	}

	public TablaPrecio(Integer id_precio, String tipo_precio, Integer id_moneda, String estatus, Date fecha_mod,
			Date fecha_cre, String usuario, String comentarios) {
		super();
		this.id_precio = id_precio;
		this.tipo_precio = tipo_precio;
		this.id_moneda = id_moneda;
		this.estatus = estatus;
		this.fecha_mod = fecha_mod;
		this.fecha_cre = fecha_cre;
		this.usuario = usuario;
		this.comentarios = comentarios;
	}

	public Integer getId_precio() {
		return id_precio;
	}

	public void setId_precio(Integer id_precio) {
		this.id_precio = id_precio;
	}

	public String getTipo_precio() {
		return tipo_precio;
	}

	public void setTipo_precio(String tipo_precio) {
		this.tipo_precio = tipo_precio;
	}

	public Integer getId_moneda() {
		return id_moneda;
	}

	public void setId_moneda(Integer id_moneda) {
		this.id_moneda = id_moneda;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Date getFecha_mod() {
		return fecha_mod;
	}

	public void setFecha_mod(Date fecha_mod) {
		this.fecha_mod = fecha_mod;
	}

	public Date getFecha_cre() {
		return fecha_cre;
	}

	public void setFecha_cre(Date fecha_cre) {
		this.fecha_cre = fecha_cre;
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
		return "TablaPrecio [id_precio=" + id_precio + ", tipo_precio=" + tipo_precio + ", id_moneda=" + id_moneda
				+ ", estatus=" + estatus + ", fecha_mod=" + fecha_mod + ", fecha_cre=" + fecha_cre + ", usuario="
				+ usuario + ", comentarios=" + comentarios + "]";
	}

}
