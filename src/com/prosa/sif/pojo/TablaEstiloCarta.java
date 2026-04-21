/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 16/08/2018 #
# Descripcion General : Pojo para mapeo de TablaEstilosCarta                   #
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
@Table(name = "TBL_SIF_CAT_ESTILOS_CARTA")
public class TablaEstiloCarta {
	@Id
	private Integer id_estilo;
	private String clave;
	private String descripcion;
	private Integer b_mostrar_facturas;
	private Integer b_mostrar_parcialidades;
	private String nombre_responsable;
	private String departamento;
	private String parrafo1;
	private String parrafo2;
	private String parrafo3;
	private String parrafo4;
	private String parrafo5;
	private String texto_pie_pagina;
	private String nombre_archivo_logo;
	private String nombre_archivo_firma;
	private String usuario;
	private String estatus;
	private Timestamp fecha_cre;
	private Timestamp fecha_mod;
	private String comentarios;

	public TablaEstiloCarta() {

	}

	public TablaEstiloCarta(Integer id_estilo, String clave, String descripcion, Integer b_mostrar_facturas,
			Integer b_mostrar_parcialidades, String nombre_responsable, String departamento, String parrafo1,
			String parrafo2, String parrafo3, String parrafo4, String parrafo5, String texto_pie_pagina,
			String nombre_archivo_logo, String nombre_archivo_firma, String usuario, String estatus,
			Timestamp fecha_cre, Timestamp fecha_mod, String comentarios) {
		super();
		this.id_estilo = id_estilo;
		this.clave = clave;
		this.descripcion = descripcion;
		this.b_mostrar_facturas = b_mostrar_facturas;
		this.b_mostrar_parcialidades = b_mostrar_parcialidades;
		this.nombre_responsable = nombre_responsable;
		this.departamento = departamento;
		this.parrafo1 = parrafo1;
		this.parrafo2 = parrafo2;
		this.parrafo3 = parrafo3;
		this.parrafo4 = parrafo4;
		this.parrafo5 = parrafo5;
		this.texto_pie_pagina = texto_pie_pagina;
		this.nombre_archivo_logo = nombre_archivo_logo;
		this.nombre_archivo_firma = nombre_archivo_firma;
		this.usuario = usuario;
		this.estatus = estatus;
		this.fecha_cre = fecha_cre;
		this.fecha_mod = fecha_mod;
		this.comentarios = comentarios;
	}

	public Integer getId_estilo() {
		return id_estilo;
	}

	public void setId_estilo(Integer id_estilo) {
		this.id_estilo = id_estilo;
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

	public Integer getB_mostrar_facturas() {
		return b_mostrar_facturas;
	}

	public void setB_mostrar_facturas(Integer b_mostrar_facturas) {
		this.b_mostrar_facturas = b_mostrar_facturas;
	}

	public Integer getB_mostrar_parcialidades() {
		return b_mostrar_parcialidades;
	}

	public void setB_mostrar_parcialidades(Integer b_mostrar_parcialidades) {
		this.b_mostrar_parcialidades = b_mostrar_parcialidades;
	}

	public String getNombre_responsable() {
		return nombre_responsable;
	}

	public void setNombre_responsable(String nombre_responsable) {
		this.nombre_responsable = nombre_responsable;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getParrafo1() {
		return parrafo1;
	}

	public void setParrafo1(String parrafo1) {
		this.parrafo1 = parrafo1;
	}

	public String getParrafo2() {
		return parrafo2;
	}

	public void setParrafo2(String parrafo2) {
		this.parrafo2 = parrafo2;
	}

	public String getParrafo3() {
		return parrafo3;
	}

	public void setParrafo3(String parrafo3) {
		this.parrafo3 = parrafo3;
	}

	public String getParrafo4() {
		return parrafo4;
	}

	public void setParrafo4(String parrafo4) {
		this.parrafo4 = parrafo4;
	}

	public String getParrafo5() {
		return parrafo5;
	}

	public void setParrafo5(String parrafo5) {
		this.parrafo5 = parrafo5;
	}

	public String getTexto_pie_pagina() {
		return texto_pie_pagina;
	}

	public void setTexto_pie_pagina(String texto_pie_pagina) {
		this.texto_pie_pagina = texto_pie_pagina;
	}

	public String getNombre_archivo_logo() {
		return nombre_archivo_logo;
	}

	public void setNombre_archivo_logo(String nombre_archivo_logo) {
		this.nombre_archivo_logo = nombre_archivo_logo;
	}

	public String getNombre_archivo_firma() {
		return nombre_archivo_firma;
	}

	public void setNombre_archivo_firma(String nombre_archivo_firma) {
		this.nombre_archivo_firma = nombre_archivo_firma;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Timestamp getFecha_cre() {
		return fecha_cre;
	}

	public void setFecha_cre(Timestamp fecha_cre) {
		this.fecha_cre = fecha_cre;
	}

	public Timestamp getFecha_mod() {
		return fecha_mod;
	}

	public void setFecha_mod(Timestamp fecha_mod) {
		this.fecha_mod = fecha_mod;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "TablaEstiloCarta [id_estilo=" + id_estilo + ", clave=" + clave + ", descripcion=" + descripcion
				+ ", b_mostrar_facturas=" + b_mostrar_facturas + ", b_mostrar_parcialidades=" + b_mostrar_parcialidades
				+ ", nombre_responsable=" + nombre_responsable + ", departamento=" + departamento + ", parrafo1="
				+ parrafo1 + ", parrafo2=" + parrafo2 + ", parrafo3=" + parrafo3 + ", parrafo4=" + parrafo4
				+ ", parrafo5=" + parrafo5 + ", texto_pie_pagina=" + texto_pie_pagina + ", nombre_archivo_logo="
				+ nombre_archivo_logo + ", nombre_archivo_firma=" + nombre_archivo_firma + ", usuario=" + usuario
				+ ", estatus=" + estatus + ", fecha_cre=" + fecha_cre + ", fecha_mod=" + fecha_mod + ", comentarios="
				+ comentarios + "]";
	}

}
