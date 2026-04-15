/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 08/03/2018 #
# Descripcion General : Pojo para mapeo de TBL_SIF_CAT_FORMAS_PAGOS            #
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
@Table(name = "TBL_SIF_CAT_FORMAS_PAGOS")
public class TBL_SIF_CAT_FORMAS_PAGOS {
	@Id
	private Integer id_forma_pago;
	private String clave;
	private String descripcion;
	private String estatus;
	private Date fecha_cre;
	private Date fecha_mod;
	private String usuario;
	private String comentarios;

	public TBL_SIF_CAT_FORMAS_PAGOS() {
	}

	public TBL_SIF_CAT_FORMAS_PAGOS(Integer id_forma_pago, String clave, String descripcion, String estatus,
			Date fecha_cre, Date fecha_mod, String usuario, String comentarios) {
		super();
		this.id_forma_pago = id_forma_pago;
		this.clave = clave;
		this.descripcion = descripcion;
		this.estatus = estatus;
		this.fecha_cre = fecha_cre;
		this.fecha_mod = fecha_mod;
		this.usuario = usuario;
		this.comentarios = comentarios;
	}

	public Integer getId_forma_pago() {
		return id_forma_pago;
	}

	public void setId_forma_pago(Integer id_forma_pago) {
		this.id_forma_pago = id_forma_pago;
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

	@Override
	public String toString() {
		return "TBL_SIF_CAT_FORMAS_PAGOS [id_forma_pago=" + id_forma_pago + ", clave=" + clave + ", descripcion="
				+ descripcion + ", estatus=" + estatus + ", fecha_cre=" + fecha_cre + ", fecha_mod=" + fecha_mod
				+ ", usuario=" + usuario + ", comentarios=" + comentarios + "]";
	}

}
