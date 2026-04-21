/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 26/07/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.pojo;

import java.util.Date;

public class B_TBL_SIF_BIT_ADQUISICIONES {
	private Date pk_hora;
	private Integer id_fuente;
	private String codigo;
	private String usuario;
	private String procedimiento;
	private String descripcion;

	public B_TBL_SIF_BIT_ADQUISICIONES() {

	}

	public B_TBL_SIF_BIT_ADQUISICIONES(Date pk_hora, Integer id_fuente, String codigo, String usuario,
			String procedimiento, String descripcion) {
		super();
		this.pk_hora = pk_hora;
		this.id_fuente = id_fuente;
		this.codigo = codigo;
		this.usuario = usuario;
		this.procedimiento = procedimiento;
		this.descripcion = descripcion;
	}

	public Date getPk_hora() {
		return pk_hora;
	}

	public void setPk_hora(Date pk_hora) {
		this.pk_hora = pk_hora;
	}

	public Integer getId_fuente() {
		return id_fuente;
	}

	public void setId_fuente(Integer id_fuente) {
		this.id_fuente = id_fuente;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getProcedimiento() {
		return procedimiento;
	}

	public void setProcedimiento(String procedimiento) {
		this.procedimiento = procedimiento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "B_TBL_SIF_BIT_ADQUISICIONES [pk_hora=" + pk_hora + ", id_fuente=" + id_fuente + ", codigo=" + codigo
				+ ", usuario=" + usuario + ", procedimiento=" + procedimiento + ", descripcion=" + descripcion + "]";
	}

}
