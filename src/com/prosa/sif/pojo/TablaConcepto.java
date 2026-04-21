/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 08/03/2018 #
# Descripcion General : Pojo para mapeo de TablaConcepto                       #
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
@Table(name = "TBL_SIF_CAT_CONCEPTOS")
public class TablaConcepto {
	@Id
	private Integer id;
	private String tipo;
	private String descripcion;
	private String valor;
	private String estatus;
	private String usuario;
	private Date fecha;
	private Integer id_grupo;

	public TablaConcepto() {
	}

	public TablaConcepto(Integer id, String tipo, String descripcion, String valor, String estatus,
			String usuario, Date fecha, Integer id_grupo) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.valor = valor;
		this.estatus = estatus;
		this.usuario = usuario;
		this.fecha = fecha;
		this.id_grupo = id_grupo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
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

	public Integer getId_grupo() {
		return id_grupo;
	}

	public void setId_grupo(Integer id_grupo) {
		this.id_grupo = id_grupo;
	}

	@Override
	public String toString() {
		return "TablaConcepto [id=" + id + ", tipo=" + tipo + ", descripcion=" + descripcion + ", valor="
				+ valor + ", estatus=" + estatus + ", usuario=" + usuario + ", fecha=" + fecha + ", id_grupo="
				+ id_grupo + "]";
	}

}
