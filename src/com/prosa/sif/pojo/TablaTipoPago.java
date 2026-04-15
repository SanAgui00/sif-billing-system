/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 08/03/2018 #
# Descripcion General : Pojo para mapeo de TablaTipoPago              #
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
@Table(name = "TBL_SIF_CAT_TIPOS_PAGO")
public class TablaTipoPago {
	@Id
	private Integer id_tipos_pago;
	private String clave;
	private String descripcion;
	private String estatus;
	private Date fecha_mod;
	private Date fecha_cre;
	private String usuario;
	private String comentarios;

	public TablaTipoPago() {

	}

	public TablaTipoPago(Integer id_tipos_pago, String clave, String descripcion, String estatus, Date fecha_mod,
			Date fecha_cre, String usuario, String comentarios) {
		super();
		this.id_tipos_pago = id_tipos_pago;
		this.clave = clave;
		this.descripcion = descripcion;
		this.estatus = estatus;
		this.fecha_mod = fecha_mod;
		this.fecha_cre = fecha_cre;
		this.usuario = usuario;
		this.comentarios = comentarios;
	}

	public Integer getId_tipos_pago() {
		return id_tipos_pago;
	}

	public void setId_tipos_pago(Integer id_tipos_pago) {
		this.id_tipos_pago = id_tipos_pago;
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
		return "TablaTipoPago [id_tipos_pago=" + id_tipos_pago + ", clave=" + clave + ", descripcion=" + descripcion
				+ ", estatus=" + estatus + ", fecha_mod=" + fecha_mod + ", fecha_cre=" + fecha_cre + ", usuario="
				+ usuario + ", comentarios=" + comentarios + "]";
	}

}
