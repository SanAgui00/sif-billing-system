/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 08/03/2018 #
# Descripcion General : Pojo para mapeo de TBL_SIF_CAT_PARAMETROS              #
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
@Table(name = "TBL_SIF_CAT_PARAMETROS")
public class TBL_SIF_CAT_PARAMETROS {
	@Id
	private Integer id;
	private String nombre;
	private String estatus;
	private String valor1;
	private String valor2;
	private String usuario;
	private Date fecha;
	private Integer id_funcionalidad;

	public TBL_SIF_CAT_PARAMETROS() {
	}

	public TBL_SIF_CAT_PARAMETROS(Integer id, String nombre, String estatus, String valor1, String valor2,
			String usuario, Date fecha, Integer id_funcionalidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.estatus = estatus;
		this.valor1 = valor1;
		this.valor2 = valor2;
		this.usuario = usuario;
		this.fecha = fecha;
		this.id_funcionalidad = id_funcionalidad;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getValor1() {
		return valor1;
	}

	public void setValor1(String valor1) {
		this.valor1 = valor1;
	}

	public String getValor2() {
		return valor2;
	}

	public void setValor2(String valor2) {
		this.valor2 = valor2;
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

	public Integer getId_funcionalidad() {
		return id_funcionalidad;
	}

	public void setId_funcionalidad(Integer id_funcionalidad) {
		this.id_funcionalidad = id_funcionalidad;
	}

	@Override
	public String toString() {
		return "TBL_SIF_CAT_PARAMETROS [id=" + id + ", nombre=" + nombre + ", estatus=" + estatus + ", valor1=" + valor1
				+ ", valor2=" + valor2 + ", usuario=" + usuario + ", fecha=" + fecha + ", id_funcionalidad="
				+ id_funcionalidad + "]";
	}

}
