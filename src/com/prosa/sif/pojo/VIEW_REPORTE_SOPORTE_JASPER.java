package com.prosa.sif.pojo;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VIEW_REPORTE_SOPORTE_JASPER")
public class VIEW_REPORTE_SOPORTE_JASPER {

	@Id
	private Integer id_vista;
	private Date fecha_datos;
	private Integer id_fuente;
	private Integer id_servicio;
	private Integer id_cliente;
	private String cv_negocio;
	private String dc_negocio;
	private String banco;
	private String nombre_corto;
	private String servicio;
	private String descripcion;
	private BigDecimal pct_iva;
	private BigDecimal mt_dispensado_ps;
	private BigDecimal mt_crossborder_dls;
	private BigDecimal mt_dispensado_dls;
	private BigDecimal subtotal_cobdia;
	private BigDecimal iva_cobdia;
	private BigDecimal total_cobdia;

	public VIEW_REPORTE_SOPORTE_JASPER() {

	}

	public VIEW_REPORTE_SOPORTE_JASPER(Integer id_vista, Date fecha_datos, Integer id_fuente, Integer id_servicio,
			Integer id_cliente, String cv_negocio, String dc_negocio, String banco, String nombre_corto,
			String servicio, String descripcion, BigDecimal pct_iva, BigDecimal mt_dispensado_ps,
			BigDecimal mt_crossborder_dls, BigDecimal mt_dispensado_dls, BigDecimal subtotal_cobdia,
			BigDecimal iva_cobdia, BigDecimal total_cobdia) {
		super();
		this.id_vista = id_vista;
		this.fecha_datos = fecha_datos;
		this.id_fuente = id_fuente;
		this.id_servicio = id_servicio;
		this.id_cliente = id_cliente;
		this.cv_negocio = cv_negocio;
		this.dc_negocio = dc_negocio;
		this.banco = banco;
		this.nombre_corto = nombre_corto;
		this.servicio = servicio;
		this.descripcion = descripcion;
		this.pct_iva = pct_iva;
		this.mt_dispensado_ps = mt_dispensado_ps;
		this.mt_crossborder_dls = mt_crossborder_dls;
		this.mt_dispensado_dls = mt_dispensado_dls;
		this.subtotal_cobdia = subtotal_cobdia;
		this.iva_cobdia = iva_cobdia;
		this.total_cobdia = total_cobdia;
	}

	public Integer getId_vista() {
		return id_vista;
	}

	public void setId_vista(Integer id_vista) {
		this.id_vista = id_vista;
	}

	public Date getFecha_datos() {
		return fecha_datos;
	}

	public void setFecha_datos(Date fecha_datos) {
		this.fecha_datos = fecha_datos;
	}

	public Integer getId_fuente() {
		return id_fuente;
	}

	public void setId_fuente(Integer id_fuente) {
		this.id_fuente = id_fuente;
	}

	public Integer getId_servicio() {
		return id_servicio;
	}

	public void setId_servicio(Integer id_servicio) {
		this.id_servicio = id_servicio;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getCv_negocio() {
		return cv_negocio;
	}

	public void setCv_negocio(String cv_negocio) {
		this.cv_negocio = cv_negocio;
	}

	public String getDc_negocio() {
		return dc_negocio;
	}

	public void setDc_negocio(String dc_negocio) {
		this.dc_negocio = dc_negocio;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getNombre_corto() {
		return nombre_corto;
	}

	public void setNombre_corto(String nombre_corto) {
		this.nombre_corto = nombre_corto;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getPct_iva() {
		return pct_iva;
	}

	public void setPct_iva(BigDecimal pct_iva) {
		this.pct_iva = pct_iva;
	}

	public BigDecimal getMt_dispensado_ps() {
		return mt_dispensado_ps;
	}

	public void setMt_dispensado_ps(BigDecimal mt_dispensado_ps) {
		this.mt_dispensado_ps = mt_dispensado_ps;
	}

	public BigDecimal getMt_crossborder_dls() {
		return mt_crossborder_dls;
	}

	public void setMt_crossborder_dls(BigDecimal mt_crossborder_dls) {
		this.mt_crossborder_dls = mt_crossborder_dls;
	}

	public BigDecimal getMt_dispensado_dls() {
		return mt_dispensado_dls;
	}

	public void setMt_dispensado_dls(BigDecimal mt_dispensado_dls) {
		this.mt_dispensado_dls = mt_dispensado_dls;
	}

	public BigDecimal getSubtotal_cobdia() {
		return subtotal_cobdia;
	}

	public void setSubtotal_cobdia(BigDecimal subtotal_cobdia) {
		this.subtotal_cobdia = subtotal_cobdia;
	}

	public BigDecimal getIva_cobdia() {
		return iva_cobdia;
	}

	public void setIva_cobdia(BigDecimal iva_cobdia) {
		this.iva_cobdia = iva_cobdia;
	}

	public BigDecimal getTotal_cobdia() {
		return total_cobdia;
	}

	public void setTotal_cobdia(BigDecimal total_cobdia) {
		this.total_cobdia = total_cobdia;
	}

	@Override
	public String toString() {
		return "VIEW_REPORTE_SOPORTE_JASPER [id_vista=" + id_vista + ", fecha_datos=" + fecha_datos + ", id_fuente="
				+ id_fuente + ", id_servicio=" + id_servicio + ", id_cliente=" + id_cliente + ", cv_negocio="
				+ cv_negocio + ", dc_negocio=" + dc_negocio + ", banco=" + banco + ", nombre_corto=" + nombre_corto
				+ ", servicio=" + servicio + ", descripcion=" + descripcion + ", pct_iva=" + pct_iva
				+ ", mt_dispensado_ps=" + mt_dispensado_ps + ", mt_crossborder_dls=" + mt_crossborder_dls
				+ ", mt_dispensado_dls=" + mt_dispensado_dls + ", subtotal_cobdia=" + subtotal_cobdia + ", iva_cobdia="
				+ iva_cobdia + ", total_cobdia=" + total_cobdia + "]";
	}

}
