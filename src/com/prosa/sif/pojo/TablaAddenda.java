/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 08/03/2018 #
# Descripcion General : Pojo para mapeo de TablaAddenda                #
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
@Table(name = "TBL_SIF_CAT_ADDENDAS")
public class TablaAddenda {
	@Id
	private Integer id;
	private String nombre;
	private String valor;
	private String descripcion;
	private String tipo;
	private String addenda;
	private String estatus;
	private String usuario;
	private Date fecha;
	private Integer id_padre;
	private Integer id_cliente;

	public TablaAddenda() {
	}

	public TablaAddenda(Integer id, String nombre, String valor, String descripcion, String tipo, String addenda,
			String estatus, String usuario, Date fecha, Integer id_padre, Integer id_cliente) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.valor = valor;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.addenda = addenda;
		this.estatus = estatus;
		this.usuario = usuario;
		this.fecha = fecha;
		this.id_padre = id_padre;
		this.id_cliente = id_cliente;
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

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getAddenda() {
		return addenda;
	}

	public void setAddenda(String addenda) {
		this.addenda = addenda;
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

	public Integer getId_padre() {
		return id_padre;
	}

	public void setId_padre(Integer id_padre) {
		this.id_padre = id_padre;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	@Override
	public String toString() {
		return "TablaAddenda [id=" + id + ", nombre=" + nombre + ", valor=" + valor + ", descripcion=" + descripcion
				+ ", tipo=" + tipo + ", addenda=" + addenda + ", estatus=" + estatus + ", usuario=" + usuario
				+ ", fecha=" + fecha + ", id_padre=" + id_padre + ", id_cliente=" + id_cliente + "]";
	}

}
