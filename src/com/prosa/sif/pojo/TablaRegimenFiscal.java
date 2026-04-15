/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 06/08/2018 #
# Descripcion General : Pojo para mapeo de TablaCatRegimenFiscal               #
# Marca del cambio    : 									                   #
#------------------------------------------------------------------------------#
# Numero de Parametros: N/A                                                    #
# Parametros Entrada  : N/A                                  Formato:          #
# Parametros Salida   : N/A                                  Formato:          #
################################################################################
**/

package com.prosa.sif.pojo;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_CAT_REGIMEN_FISCAL")
public class TablaRegimenFiscal {

	@Id
	private Integer id;
	private String clave;
	private String descripcion;
	private String aplica_fisica;
	private String aplica_moral;
	private String estatus;
	private String usuario;
	private Timestamp fecha;

	public TablaRegimenFiscal() {

	}

	public TablaRegimenFiscal(Integer id, String clave, String descripcion, String aplica_fisica, String aplica_moral,
			String estatus, String usuario, Timestamp fecha) {
		this.id = id;
		this.clave = clave;
		this.descripcion = descripcion;
		this.aplica_fisica = aplica_fisica;
		this.aplica_moral = aplica_moral;
		this.estatus = estatus;
		this.usuario = usuario;
		this.fecha = fecha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getAplica_fisica() {
		return aplica_fisica;
	}

	public void setAplica_fisica(String aplica_fisica) {
		this.aplica_fisica = aplica_fisica;
	}

	public String getAplica_moral() {
		return aplica_moral;
	}

	public void setAplica_moral(String aplica_moral) {
		this.aplica_moral = aplica_moral;
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

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "TablaRegimenFiscal [id=" + id + ", clave=" + clave + ", descripcion=" + descripcion + ", aplica_fisica="
				+ aplica_fisica + ", aplica_moral=" + aplica_moral + ", estatus=" + estatus + ", usuario=" + usuario
				+ ", fecha=" + fecha + "]";
	}

}
