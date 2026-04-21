/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 18/07/2018 #
# Descripcion General : Pojo para mapeo de TablaCatNegocios                    #
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
@Table(name = "TBL_SIF_CAT_NEGOCIOS")
public class TablaNegocio {
	@Id
	private Integer id_negocio;
	private Integer id_proceso;
	private Integer id_centro_costos;
	private Integer id_negocio_padre;
	private Integer id_grupo_edo_cuenta;
	private String clave;
	private String descripcion;
	private String cuenta_ingreso;
	private String clave_gl;
	private String usuario;
	private String status;
	private Date fecha_cre;
	private Date fecha_mod;
	private String comentarios;
	private String concepto_carta;
	private String clave_metodopago_sat;
	private String clave_usocfdi_sat;

	public TablaNegocio() {
	}

	public TablaNegocio(Integer id_negocio, Integer id_proceso, Integer id_centro_costos, Integer id_negocio_padre,
			Integer id_grupo_edo_cuenta, String clave, String descripcion, String cuenta_ingreso, String clave_gl,
			String usuario, String status, Date fecha_cre, Date fecha_mod, String comentarios, String concepto_carta,
			String clave_metodopago_sat, String clave_usocfdi_sat) {
		super();
		this.id_negocio = id_negocio;
		this.id_proceso = id_proceso;
		this.id_centro_costos = id_centro_costos;
		this.id_negocio_padre = id_negocio_padre;
		this.id_grupo_edo_cuenta = id_grupo_edo_cuenta;
		this.clave = clave;
		this.descripcion = descripcion;
		this.cuenta_ingreso = cuenta_ingreso;
		this.clave_gl = clave_gl;
		this.usuario = usuario;
		this.status = status;
		this.fecha_cre = fecha_cre;
		this.fecha_mod = fecha_mod;
		this.comentarios = comentarios;
		this.concepto_carta = concepto_carta;
		this.clave_metodopago_sat = clave_metodopago_sat;
		this.clave_usocfdi_sat = clave_usocfdi_sat;
	}

	public Integer getId_negocio() {
		return id_negocio;
	}

	public void setId_negocio(Integer id_negocio) {
		this.id_negocio = id_negocio;
	}

	public Integer getId_proceso() {
		return id_proceso;
	}

	public void setId_proceso(Integer id_proceso) {
		this.id_proceso = id_proceso;
	}

	public Integer getId_centro_costos() {
		return id_centro_costos;
	}

	public void setId_centro_costos(Integer id_centro_costos) {
		this.id_centro_costos = id_centro_costos;
	}

	public Integer getId_negocio_padre() {
		return id_negocio_padre;
	}

	public void setId_negocio_padre(Integer id_negocio_padre) {
		this.id_negocio_padre = id_negocio_padre;
	}

	public Integer getId_grupo_edo_cuenta() {
		return id_grupo_edo_cuenta;
	}

	public void setId_grupo_edo_cuenta(Integer id_grupo_edo_cuenta) {
		this.id_grupo_edo_cuenta = id_grupo_edo_cuenta;
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

	public String getCuenta_ingreso() {
		return cuenta_ingreso;
	}

	public void setCuenta_ingreso(String cuenta_ingreso) {
		this.cuenta_ingreso = cuenta_ingreso;
	}

	public String getClave_gl() {
		return clave_gl;
	}

	public void setClave_gl(String clave_gl) {
		this.clave_gl = clave_gl;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getConcepto_carta() {
		return concepto_carta;
	}

	public void setConcepto_carta(String concepto_carta) {
		this.concepto_carta = concepto_carta;
	}

	public String getClave_metodopago_sat() {
		return clave_metodopago_sat;
	}

	public void setClave_metodopago_sat(String clave_metodopago_sat) {
		this.clave_metodopago_sat = clave_metodopago_sat;
	}

	public String getClave_usocfdi_sat() {
		return clave_usocfdi_sat;
	}

	public void setClave_usocfdi_sat(String clave_usocfdi_sat) {
		this.clave_usocfdi_sat = clave_usocfdi_sat;
	}

	@Override
	public String toString() {
		return "TablaNegocio [id_negocio=" + id_negocio + ", id_proceso=" + id_proceso + ", id_centro_costos="
				+ id_centro_costos + ", id_negocio_padre=" + id_negocio_padre + ", id_grupo_edo_cuenta="
				+ id_grupo_edo_cuenta + ", clave=" + clave + ", descripcion=" + descripcion + ", cuenta_ingreso="
				+ cuenta_ingreso + ", clave_gl=" + clave_gl + ", usuario=" + usuario + ", status=" + status
				+ ", fecha_cre=" + fecha_cre + ", fecha_mod=" + fecha_mod + ", comentarios=" + comentarios
				+ ", concepto_carta=" + concepto_carta + ", clave_metodopago_sat=" + clave_metodopago_sat
				+ ", clave_usocfdi_sat=" + clave_usocfdi_sat + "]";
	}

}
