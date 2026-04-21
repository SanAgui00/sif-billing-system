/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 10/08/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/
package com.prosa.sif.pojo;

import java.util.Date;

public class BeanAsignarServicio {
	private String clave;
	private String descripcion;
	private Date fecha_mod;
	private String usuario;
	private Number id_servicios;
	private Number distribucion;
	private Number id_grupo;
	private Number id_cliente;
	private String clave_grupo;
	private String clave_cliente;
	private String descripcion_grupo;
	private String estatus;
	private Date fecha_mod_grupo;
	private Date fecha_crea;
	private Date fecha_cre;
	private Date fecha_crea_grupo;
	private String comentarios_grupo;
	private String comentarios;
	private String nombre_corto;
	private String b_beneficiario;
	private String usuario_grupo;
	private String esquema;

	public BeanAsignarServicio() {

	}

	public BeanAsignarServicio(String clave, String descripcion, Date fecha_mod, String usuario, Number id_servicios,
			Number distribucion, Number id_grupo, Number id_cliente, String clave_grupo, String clave_cliente,
			String descripcion_grupo, String estatus, Date fecha_mod_grupo, Date fecha_crea, Date fecha_cre,
			Date fecha_crea_grupo, String comentarios_grupo, String comentarios, String nombre_corto,
			String b_beneficiario, String usuario_grupo, String esquema) {
		super();
		this.clave = clave;
		this.descripcion = descripcion;
		this.fecha_mod = fecha_mod;
		this.usuario = usuario;
		this.id_servicios = id_servicios;
		this.distribucion = distribucion;
		this.id_grupo = id_grupo;
		this.id_cliente = id_cliente;
		this.clave_grupo = clave_grupo;
		this.clave_cliente = clave_cliente;
		this.descripcion_grupo = descripcion_grupo;
		this.estatus = estatus;
		this.fecha_mod_grupo = fecha_mod_grupo;
		this.fecha_crea = fecha_crea;
		this.fecha_cre = fecha_cre;
		this.fecha_crea_grupo = fecha_crea_grupo;
		this.comentarios_grupo = comentarios_grupo;
		this.comentarios = comentarios;
		this.nombre_corto = nombre_corto;
		this.b_beneficiario = b_beneficiario;
		this.usuario_grupo = usuario_grupo;
		this.esquema = esquema;
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

	public Number getId_servicios() {
		return id_servicios;
	}

	public void setId_servicios(Number id_servicios) {
		this.id_servicios = id_servicios;
	}

	public Number getDistribucion() {
		return distribucion;
	}

	public void setDistribucion(Number distribucion) {
		this.distribucion = distribucion;
	}

	public Number getId_grupo() {
		return id_grupo;
	}

	public void setId_grupo(Number id_grupo) {
		this.id_grupo = id_grupo;
	}

	public Number getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Number id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getClave_grupo() {
		return clave_grupo;
	}

	public void setClave_grupo(String clave_grupo) {
		this.clave_grupo = clave_grupo;
	}

	public String getClave_cliente() {
		return clave_cliente;
	}

	public void setClave_cliente(String clave_cliente) {
		this.clave_cliente = clave_cliente;
	}

	public String getDescripcion_grupo() {
		return descripcion_grupo;
	}

	public void setDescripcion_grupo(String descripcion_grupo) {
		this.descripcion_grupo = descripcion_grupo;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Date getFecha_mod_grupo() {
		return fecha_mod_grupo;
	}

	public void setFecha_mod_grupo(Date fecha_mod_grupo) {
		this.fecha_mod_grupo = fecha_mod_grupo;
	}

	public Date getFecha_crea() {
		return fecha_crea;
	}

	public void setFecha_crea(Date fecha_crea) {
		this.fecha_crea = fecha_crea;
	}

	public Date getFecha_cre() {
		return fecha_cre;
	}

	public void setFecha_cre(Date fecha_cre) {
		this.fecha_cre = fecha_cre;
	}

	public Date getFecha_crea_grupo() {
		return fecha_crea_grupo;
	}

	public void setFecha_crea_grupo(Date fecha_crea_grupo) {
		this.fecha_crea_grupo = fecha_crea_grupo;
	}

	public String getComentarios_grupo() {
		return comentarios_grupo;
	}

	public void setComentarios_grupo(String comentarios_grupo) {
		this.comentarios_grupo = comentarios_grupo;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getNombre_corto() {
		return nombre_corto;
	}

	public void setNombre_corto(String nombre_corto) {
		this.nombre_corto = nombre_corto;
	}

	public String getB_beneficiario() {
		return b_beneficiario;
	}

	public void setB_beneficiario(String b_beneficiario) {
		this.b_beneficiario = b_beneficiario;
	}

	public String getUsuario_grupo() {
		return usuario_grupo;
	}

	public void setUsuario_grupo(String usuario_grupo) {
		this.usuario_grupo = usuario_grupo;
	}

	public String getEsquema() {
		return esquema;
	}

	public void setEsquema(String esquema) {
		this.esquema = esquema;
	}

	@Override
	public String toString() {
		return "BeanAsignarServicio [clave=" + clave + ", descripcion=" + descripcion + ", fecha_mod=" + fecha_mod
				+ ", usuario=" + usuario + ", id_servicios=" + id_servicios + ", distribucion=" + distribucion
				+ ", id_grupo=" + id_grupo + ", id_cliente=" + id_cliente + ", clave_grupo=" + clave_grupo
				+ ", clave_cliente=" + clave_cliente + ", descripcion_grupo=" + descripcion_grupo + ", estatus="
				+ estatus + ", fecha_mod_grupo=" + fecha_mod_grupo + ", fecha_crea=" + fecha_crea + ", fecha_cre="
				+ fecha_cre + ", fecha_crea_grupo=" + fecha_crea_grupo + ", comentarios_grupo=" + comentarios_grupo
				+ ", comentarios=" + comentarios + ", nombre_corto=" + nombre_corto + ", b_beneficiario="
				+ b_beneficiario + ", usuario_grupo=" + usuario_grupo + ", esquema=" + esquema + "]";
	}

}
