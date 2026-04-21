package com.prosa.sif.pojo;

import java.util.Date;

public class ViewPeriodo {

	private Number id_periodos;
	private String nombre;
	private Date fecha_inicio;
	private Date fecha_fin;
	private Date fecha_cierre;
	private String estatus;
	private Number id_periodo;
	private Date fecha_referencia;
	private Date fecha_calculo;
	private Date fecha_cobro_libra;
	private Date fecha_cobro_sac;
	private Date fecha_contingencia;
	private Date fecha_cobro;
	private Date fecha_registro_gl;
	private Number b_dia_habil;
	private Number b_dia_cierre;
	private Date fecha_cre;
	private Date fecha_mod;
	private String usuario;
	private String comentarios;

	public ViewPeriodo() {

	}

	public ViewPeriodo(Number id_periodos, String nombre, Date fecha_inicio, Date fecha_fin, Date fecha_cierre,
			String estatus, Number id_periodo, Date fecha_referencia, Date fecha_calculo, Date fecha_cobro_libra,
			Date fecha_cobro_sac, Date fecha_contingencia, Date fecha_cobro, Date fecha_registro_gl, Number b_dia_habil,
			Number b_dia_cierre, Date fecha_cre, Date fecha_mod, String usuario, String comentarios) {
		super();
		this.id_periodos = id_periodos;
		this.nombre = nombre;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.fecha_cierre = fecha_cierre;
		this.estatus = estatus;
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
		this.fecha_cre = fecha_cre;
		this.fecha_mod = fecha_mod;
		this.usuario = usuario;
		this.comentarios = comentarios;
	}

	public Number getId_periodos() {
		return id_periodos;
	}

	public void setId_periodos(Number id_periodos) {
		this.id_periodos = id_periodos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public Date getFecha_cierre() {
		return fecha_cierre;
	}

	public void setFecha_cierre(Date fecha_cierre) {
		this.fecha_cierre = fecha_cierre;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Number getId_periodo() {
		return id_periodo;
	}

	public void setId_periodo(Number id_periodo) {
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

	public Number getB_dia_habil() {
		return b_dia_habil;
	}

	public void setB_dia_habil(Number b_dia_habil) {
		this.b_dia_habil = b_dia_habil;
	}

	public Number getB_dia_cierre() {
		return b_dia_cierre;
	}

	public void setB_dia_cierre(Number b_dia_cierre) {
		this.b_dia_cierre = b_dia_cierre;
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

	@Override
	public String toString() {
		return "ViewPeriodo [id_periodos=" + id_periodos + ", nombre=" + nombre + ", fecha_inicio=" + fecha_inicio
				+ ", fecha_fin=" + fecha_fin + ", fecha_cierre=" + fecha_cierre + ", estatus=" + estatus
				+ ", id_periodo=" + id_periodo + ", fecha_referencia=" + fecha_referencia + ", fecha_calculo="
				+ fecha_calculo + ", fecha_cobro_libra=" + fecha_cobro_libra + ", fecha_cobro_sac=" + fecha_cobro_sac
				+ ", fecha_contingencia=" + fecha_contingencia + ", fecha_cobro=" + fecha_cobro + ", fecha_registro_gl="
				+ fecha_registro_gl + ", b_dia_habil=" + b_dia_habil + ", b_dia_cierre=" + b_dia_cierre + ", fecha_cre="
				+ fecha_cre + ", fecha_mod=" + fecha_mod + ", usuario=" + usuario + ", comentarios=" + comentarios
				+ "]";
	}

}
