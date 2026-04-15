/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 08/03/2018 #
# Descripcion General : Pojo para mapeo de TBL_SIF_CAT_PROCESOS                #
# Marca del cambio    : 									                   #
#------------------------------------------------------------------------------#
# Numero de Parametros: N/A                                                    #
# Parametros Entrada  : N/A                                  Formato:          #
# Parametros Salida   : N/A                                  Formato:          #
################################################################################
**/
package com.prosa.sif.pojo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class TBL_SIF_CAT_PROCESOS {

	@Id
	private Integer id_proceso;
	private Integer id_empresa;
	private String clave_proceso;
	private String descripcion;
	private BigDecimal b_servicios_en_rebate;
	private String estatus;
	private Date fecha_cre;
	private Date fecha_mod;
	private String usuario;
	private String comentarios;
	private String clave_tipocomp_sat;

	public TBL_SIF_CAT_PROCESOS() {

	}

	public TBL_SIF_CAT_PROCESOS(Integer id_proceso, Integer id_empresa, String clave_proceso, String descripcion,
			BigDecimal b_servicios_en_rebate, String estatus, Date fecha_cre, Date fecha_mod, String usuario,
			String comentarios, String clave_tipocomp_sat) {
		super();
		this.id_proceso = id_proceso;
		this.id_empresa = id_empresa;
		this.clave_proceso = clave_proceso;
		this.descripcion = descripcion;
		this.b_servicios_en_rebate = b_servicios_en_rebate;
		this.estatus = estatus;
		this.fecha_cre = fecha_cre;
		this.fecha_mod = fecha_mod;
		this.usuario = usuario;
		this.comentarios = comentarios;
		this.clave_tipocomp_sat = clave_tipocomp_sat;
	}

	public Integer getId_proceso() {
		return id_proceso;
	}

	public void setId_proceso(Integer id_proceso) {
		this.id_proceso = id_proceso;
	}

	public Integer getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(Integer id_empresa) {
		this.id_empresa = id_empresa;
	}

	public String getClave_proceso() {
		return clave_proceso;
	}

	public void setClave_proceso(String clave_proceso) {
		this.clave_proceso = clave_proceso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getB_servicios_en_rebate() {
		return b_servicios_en_rebate;
	}

	public void setB_servicios_en_rebate(BigDecimal b_servicios_en_rebate) {
		this.b_servicios_en_rebate = b_servicios_en_rebate;
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

	public String getClave_tipocomp_sat() {
		return clave_tipocomp_sat;
	}

	public void setClave_tipocomp_sat(String clave_tipocomp_sat) {
		this.clave_tipocomp_sat = clave_tipocomp_sat;
	}

	@Override
	public String toString() {
		return "TBL_SIF_CAT_PROCESOS [id_proceso=" + id_proceso + ", id_empresa=" + id_empresa + ", clave_proceso="
				+ clave_proceso + ", descripcion=" + descripcion + ", b_servicios_en_rebate=" + b_servicios_en_rebate
				+ ", estatus=" + estatus + ", fecha_cre=" + fecha_cre + ", fecha_mod=" + fecha_mod + ", usuario="
				+ usuario + ", comentarios=" + comentarios + ", clave_tipocomp_sat=" + clave_tipocomp_sat + "]";
	}

}
