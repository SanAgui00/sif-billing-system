/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 08/03/2018 #
# Descripcion General : Pojo para mapeo de TablaEventoServicio       #
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_CAT_EVENTOS_SERVICIOS")
public class TablaEventoServicio {
	@Id
	private Integer id;
	private String codigo;
	private String clave;
	private String descripcion;
	private String b_adq_emi;
	private String origen;
	private String estatus;
	private Integer id_servicios;
	private String usuario;
	private Date fecha;
	@ManyToOne
	@JoinColumn(name = "id_servicios", insertable = false, updatable = false)
	private TablaServicio tbl_sif_servicios;

	public TablaEventoServicio() {
	}

	public TablaEventoServicio(String codigo, String clave, Integer id_servicios, String descripcion,
			String b_adq_emi, String origen, String estatus, String usuario, Date fecha,
			TablaServicio tbl_sif_servicios) {
		super();
		this.codigo = codigo;
		this.clave = clave;
		this.id_servicios = id_servicios;
		this.descripcion = descripcion;
		this.b_adq_emi = b_adq_emi;
		this.origen = origen;
		this.estatus = estatus;
		this.usuario = usuario;
		this.fecha = fecha;
		this.tbl_sif_servicios = tbl_sif_servicios;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_servicios() {
		return id_servicios;
	}

	public void setId_servicios(Integer id_servicios) {
		this.id_servicios = id_servicios;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public String getB_adq_emi() {
		return b_adq_emi;
	}

	public void setB_adq_emi(String b_adq_emi) {
		this.b_adq_emi = b_adq_emi;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public TablaServicio getTbl_sif_servicios() {
		return tbl_sif_servicios;
	}

	public void setTbl_sif_servicios(TablaServicio tbl_sif_servicios) {
		this.tbl_sif_servicios = tbl_sif_servicios;
	}

	@Override
	public String toString() {
		return "TablaEventoServicio [id=" + id + ",id_servicios=" + id_servicios + ",codigo=" + codigo
				+ ", clave=" + clave + ", descripcion=" + descripcion + ", b_adq_emi=" + b_adq_emi + ", origen="
				+ origen + ", estatus=" + estatus + ", usuario=" + usuario + ", fecha=" + fecha + "]";
	}

}
