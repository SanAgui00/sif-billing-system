/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 08/03/2018 #
# Descripcion General : Pojo para mapeo de TBL_SIF_CAT_TIPO_CUENTAS            #
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
@Table(name = "TBL_SIF_CAT_TIPO_CUENTAS")
public class TBL_SIF_CAT_TIPO_CUENTAS {
	@Id
	private Integer id_tipo_cuenta;

	private String descripcion;
	private String clave;
	private String numero_cta_contable;
	private String estatus;
	private Date fecha_cre;
	private Date fecha_mod;
	private String usuario;
	private String comentarios;

	private Integer tipo_mov;

	public TBL_SIF_CAT_TIPO_CUENTAS() {
	}

	public TBL_SIF_CAT_TIPO_CUENTAS(Integer id_tipo_cuenta, String descripcion, String clave,
			String numero_cta_contable, String estatus, Date fecha_cre, Date fecha_mod, String usuario,
			String comentarios, Integer tipo_mov) {
		super();
		this.id_tipo_cuenta = id_tipo_cuenta;
		this.descripcion = descripcion;
		this.clave = clave;
		this.numero_cta_contable = numero_cta_contable;
		this.estatus = estatus;
		this.fecha_cre = fecha_cre;
		this.fecha_mod = fecha_mod;
		this.usuario = usuario;
		this.comentarios = comentarios;
		this.tipo_mov = tipo_mov;
	}

	public Integer getId_tipo_cuenta() {
		return id_tipo_cuenta;
	}

	public void setId_tipo_cuenta(Integer id_tipo_cuenta) {
		this.id_tipo_cuenta = id_tipo_cuenta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNumero_cta_contable() {
		return numero_cta_contable;
	}

	public void setNumero_cta_contable(String numero_cta_contable) {
		this.numero_cta_contable = numero_cta_contable;
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

	public Integer getTipo_mov() {
		return tipo_mov;
	}

	public void setTipo_mov(Integer tipo_mov) {
		this.tipo_mov = tipo_mov;
	}

	@Override
	public String toString() {
		return "TBL_SIF_CAT_TIPO_CUENTAS [id_tipo_cuenta=" + id_tipo_cuenta + ", descripcion=" + descripcion
				+ ", clave=" + clave + ", numero_cta_contable=" + numero_cta_contable + ", estatus=" + estatus
				+ ", fecha_cre=" + fecha_cre + ", fecha_mod=" + fecha_mod + ", usuario=" + usuario + ", comentarios="
				+ comentarios + ", tipo_mov=" + tipo_mov + "]";
	}

}
