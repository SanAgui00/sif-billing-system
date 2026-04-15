package com.prosa.sif.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_REBATE")
public class TBL_SIF_REBATE {

	@Id
	private Integer id_rebate;
	private Integer id_moneda;
	private Integer id_periodo;
	private String estatus;
	private Integer b_proyectado;
	private Integer relacion_porc_monto_rebate;
	private Integer relacion_porc_monto_servicio;
	private String monto_rebate;
	private String tipo_calculo_base;
	private String tipo_calculo_distribucion;
	private Date fecha_aplicacion;
	private String usuario;
	private Date fecha_mod;
	private Date fecha_cre;
	private String comentarios;
	public TBL_SIF_REBATE() {
		super();
	}
	public TBL_SIF_REBATE(Integer id_rebate, Integer id_moneda, Integer id_periodo, String estatus,
			Integer b_proyectado, Integer relacion_porc_monto_rebate, Integer relacion_porc_monto_servicio,
			String monto_rebate, String tipo_calculo_base, String tipo_calculo_distribucion, Date fecha_aplicacion,
			String usuario, Date fecha_mod, Date fecha_cre, String comentarios) {
		super();
		this.id_rebate = id_rebate;
		this.id_moneda = id_moneda;
		this.id_periodo = id_periodo;
		this.estatus = estatus;
		this.b_proyectado = b_proyectado;
		this.relacion_porc_monto_rebate = relacion_porc_monto_rebate;
		this.relacion_porc_monto_servicio = relacion_porc_monto_servicio;
		this.monto_rebate = monto_rebate;
		this.tipo_calculo_base = tipo_calculo_base;
		this.tipo_calculo_distribucion = tipo_calculo_distribucion;
		this.fecha_aplicacion = fecha_aplicacion;
		this.usuario = usuario;
		this.fecha_mod = fecha_mod;
		this.fecha_cre = fecha_cre;
		this.comentarios = comentarios;
	}
	
	public Integer getId_rebate() {
		return id_rebate;
	}
	public void setId_rebate(Integer id_rebate) {
		this.id_rebate = id_rebate;
	}
	public Integer getId_moneda() {
		return id_moneda;
	}
	public void setId_moneda(Integer id_moneda) {
		this.id_moneda = id_moneda;
	}
	public Integer getId_periodo() {
		return id_periodo;
	}
	public void setId_periodo(Integer id_periodo) {
		this.id_periodo = id_periodo;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public Integer getB_proyectado() {
		return b_proyectado;
	}
	public void setB_proyectado(Integer b_proyectado) {
		this.b_proyectado = b_proyectado;
	}
	public Integer getRelacion_porc_monto_rebate() {
		return relacion_porc_monto_rebate;
	}
	public void setRelacion_porc_monto_rebate(Integer relacion_porc_monto_rebate) {
		this.relacion_porc_monto_rebate = relacion_porc_monto_rebate;
	}
	public Integer getRelacion_porc_monto_servicio() {
		return relacion_porc_monto_servicio;
	}
	public void setRelacion_porc_monto_servicio(Integer relacion_porc_monto_servicio) {
		this.relacion_porc_monto_servicio = relacion_porc_monto_servicio;
	}
	public String getMonto_rebate() {
		return monto_rebate;
	}
	public void setMonto_rebate(String monto_rebate) {
		this.monto_rebate = monto_rebate;
	}
	public String getTipo_calculo_base() {
		return tipo_calculo_base;
	}
	public void setTipo_calculo_base(String tipo_calculo_base) {
		this.tipo_calculo_base = tipo_calculo_base;
	}
	public String getTipo_calculo_distribucion() {
		return tipo_calculo_distribucion;
	}
	public void setTipo_calculo_distribucion(String tipo_calculo_distribucion) {
		this.tipo_calculo_distribucion = tipo_calculo_distribucion;
	}
	public Date getFecha_aplicacion() {
		return fecha_aplicacion;
	}
	public void setFecha_aplicacion(Date fecha_aplicacion) {
		this.fecha_aplicacion = fecha_aplicacion;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Date getFecha_mod() {
		return fecha_mod;
	}
	public void setFecha_mod(Date fecha_mod) {
		this.fecha_mod = fecha_mod;
	}
	public Date getFecha_cre() {
		return fecha_cre;
	}
	public void setFecha_cre(Date fecha_cre) {
		this.fecha_cre = fecha_cre;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	@Override
	public String toString() {
		return "TBL_SIF_REBATE [id_rebate=" + id_rebate + ", id_moneda=" + id_moneda + ", id_periodo=" + id_periodo
				+ ", estatus=" + estatus + ", b_proyectado=" + b_proyectado + ", relacion_porc_monto_rebate="
				+ relacion_porc_monto_rebate + ", relacion_porc_monto_servicio=" + relacion_porc_monto_servicio
				+ ", monto_rebate=" + monto_rebate + ", tipo_calculo_base=" + tipo_calculo_base
				+ ", tipo_calculo_distribucion=" + tipo_calculo_distribucion + ", fecha_aplicacion=" + fecha_aplicacion
				+ ", usuario=" + usuario + ", fecha_mod=" + fecha_mod + ", fecha_cre=" + fecha_cre + ", comentarios="
				+ comentarios + "]";
	}
	
	
}
