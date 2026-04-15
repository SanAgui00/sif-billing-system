/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 16/08/2018 #
# Descripcion General : Pojo para mapeo de TablaCatDiasPeriodo                 #
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
@Table
public class TBL_SIF_CAT_DIAS_PERIODO {

	@Id
	private Integer id_periodo;
	private Date fecha_referencia;
	private Date fecha_calculo;
	private Date fecha_cobro_libra;
	private Date fecha_cobro_sac;
	private Date fecha_contingencia;
	private Date fecha_cobro;
	private Date fecha_registro_gl;
	private Integer b_dia_habil;
	private Integer b_dia_cierre;

	public TBL_SIF_CAT_DIAS_PERIODO() {

	}

	public TBL_SIF_CAT_DIAS_PERIODO(Integer id_periodo, Date fecha_referencia, Date fecha_calculo,
			Date fecha_cobro_libra, Date fecha_cobro_sac, Date fecha_contingencia, Date fecha_cobro,
			Date fecha_registro_gl, Integer b_dia_habil, Integer b_dia_cierre) {
		super();
		this.id_periodo = id_periodo;
		this.fecha_referencia = fecha_referencia;
		this.fecha_calculo = fecha_calculo;
		this.fecha_cobro_libra = fecha_cobro_libra;
		this.fecha_cobro_sac = fecha_cobro_sac;
		this.fecha_contingencia = fecha_contingencia;
		this.fecha_cobro = fecha_cobro;
		this.fecha_registro_gl = fecha_registro_gl;
		this.b_dia_habil = b_dia_habil;
		this.b_dia_cierre = b_dia_cierre;
	}

	public Integer getId_periodo() {
		return id_periodo;
	}

	public void setId_periodo(Integer id_periodo) {
		this.id_periodo = id_periodo;
	}

	public Date getFecha_referencia() {
		return fecha_referencia;
	}

	public void setFecha_referencia(Date fecha_referencia) {
		this.fecha_referencia = fecha_referencia;
	}

	public Date getFecha_calculo() {
		return fecha_calculo;
	}

	public void setFecha_calculo(Date fecha_calculo) {
		this.fecha_calculo = fecha_calculo;
	}

	public Date getFecha_cobro_libra() {
		return fecha_cobro_libra;
	}

	public void setFecha_cobro_libra(Date fecha_cobro_libra) {
		this.fecha_cobro_libra = fecha_cobro_libra;
	}

	public Date getFecha_cobro_sac() {
		return fecha_cobro_sac;
	}

	public void setFecha_cobro_sac(Date fecha_cobro_sac) {
		this.fecha_cobro_sac = fecha_cobro_sac;
	}

	public Date getFecha_contingencia() {
		return fecha_contingencia;
	}

	public void setFecha_contingencia(Date fecha_contingencia) {
		this.fecha_contingencia = fecha_contingencia;
	}

	public Date getFecha_cobro() {
		return fecha_cobro;
	}

	public void setFecha_cobro(Date fecha_cobro) {
		this.fecha_cobro = fecha_cobro;
	}

	public Date getFecha_registro_gl() {
		return fecha_registro_gl;
	}

	public void setFecha_registro_gl(Date fecha_registro_gl) {
		this.fecha_registro_gl = fecha_registro_gl;
	}

	public Integer getB_dia_habil() {
		return b_dia_habil;
	}

	public void setB_dia_habil(Integer b_dia_habil) {
		this.b_dia_habil = b_dia_habil;
	}

	public Integer getB_dia_cierre() {
		return b_dia_cierre;
	}

	public void setB_dia_cierre(Integer b_dia_cierre) {
		this.b_dia_cierre = b_dia_cierre;
	}

	@Override
	public String toString() {
		return "TBL_SIF_CAT_DIAS_PERIODO [id_periodo=" + id_periodo + ", fecha_referencia=" + fecha_referencia
				+ ", fecha_calculo=" + fecha_calculo + ", fecha_cobro_libra=" + fecha_cobro_libra + ", fecha_cobro_sac="
				+ fecha_cobro_sac + ", fecha_contingencia=" + fecha_contingencia + ", fecha_cobro=" + fecha_cobro
				+ ", fecha_registro_gl=" + fecha_registro_gl + ", b_dia_habil=" + b_dia_habil + ", b_dia_cierre="
				+ b_dia_cierre + "]";
	}

}
