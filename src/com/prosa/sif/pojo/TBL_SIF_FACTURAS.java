package com.prosa.sif.pojo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_FACTURAS")
public class TBL_SIF_FACTURAS {

	@Id
	private Integer id_factura;
	private Integer id_cliente;
	private Integer id_negocio;
	private Integer id_moneda;
	private Integer id_centro_costos;
	private Integer id_periodo;
	private String folio;
	private Date fecha_datos;
	private BigDecimal total_importe_neto;
	private BigDecimal porc_iva_cliente;
	private BigDecimal total_importe_iva;
	private BigDecimal tipo_cambio;
	private BigDecimal total_desc_especial;
	private BigDecimal total_desc_adic_vol;
	private BigDecimal total_importe_liquidado;
	private BigDecimal total_iva_liquidado;
	private Integer id_carta_impresa;
	private Integer id_contacto_cliente;
	private String razon_social_cliente;
	private String rfc_cliente;
	private String direccion_cliente;
	private String nombre_contacto_cliente;
	private String comentarios;
	private String usuario;
	private String estatus;
	private Date fecha_mod;
	private Date fecha_cre;
	private Date fecha_cancelacion;

	public TBL_SIF_FACTURAS() {

	}

	public TBL_SIF_FACTURAS(Integer id_factura, Integer id_cliente, Integer id_negocio, Integer id_moneda,
			Integer id_centro_costos, Integer id_periodo, String folio, Date fecha_datos,
			BigDecimal total_importe_neto, BigDecimal porc_iva_cliente, BigDecimal total_importe_iva,
			BigDecimal tipo_cambio, BigDecimal total_desc_especial, BigDecimal total_desc_adic_vol,
			BigDecimal total_importe_liquidado, BigDecimal total_iva_liquidado, Integer id_carta_impresa,
			Integer id_contacto_cliente, String razon_social_cliente, String rfc_cliente, String direccion_cliente,
			String nombre_contacto_cliente, String comentarios, String usuario, String estatus, Date fecha_mod,
			Date fecha_cre, Date fecha_cancelacion) {
		super();
		this.id_factura = id_factura;
		this.id_cliente = id_cliente;
		this.id_negocio = id_negocio;
		this.id_moneda = id_moneda;
		this.id_centro_costos = id_centro_costos;
		this.id_periodo = id_periodo;
		this.folio = folio;
		this.fecha_datos = fecha_datos;
		this.total_importe_neto = total_importe_neto;
		this.porc_iva_cliente = porc_iva_cliente;
		this.total_importe_iva = total_importe_iva;
		this.tipo_cambio = tipo_cambio;
		this.total_desc_especial = total_desc_especial;
		this.total_desc_adic_vol = total_desc_adic_vol;
		this.total_importe_liquidado = total_importe_liquidado;
		this.total_iva_liquidado = total_iva_liquidado;
		this.id_carta_impresa = id_carta_impresa;
		this.id_contacto_cliente = id_contacto_cliente;
		this.razon_social_cliente = razon_social_cliente;
		this.rfc_cliente = rfc_cliente;
		this.direccion_cliente = direccion_cliente;
		this.nombre_contacto_cliente = nombre_contacto_cliente;
		this.comentarios = comentarios;
		this.usuario = usuario;
		this.estatus = estatus;
		this.fecha_mod = fecha_mod;
		this.fecha_cre = fecha_cre;
		this.fecha_cancelacion = fecha_cancelacion;
	}

	public Integer getId_factura() {
		return id_factura;
	}

	public void setId_factura(Integer id_factura) {
		this.id_factura = id_factura;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Integer getId_negocio() {
		return id_negocio;
	}

	public void setId_negocio(Integer id_negocio) {
		this.id_negocio = id_negocio;
	}

	public Integer getId_moneda() {
		return id_moneda;
	}

	public void setId_moneda(Integer id_moneda) {
		this.id_moneda = id_moneda;
	}

	public Integer getId_centro_costos() {
		return id_centro_costos;
	}

	public void setId_centro_costos(Integer id_centro_costos) {
		this.id_centro_costos = id_centro_costos;
	}

	public Integer getId_periodo() {
		return id_periodo;
	}

	public void setId_periodo(Integer id_periodo) {
		this.id_periodo = id_periodo;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public Date getFecha_datos() {
		return fecha_datos;
	}

	public void setFecha_datos(Date fecha_datos) {
		this.fecha_datos = fecha_datos;
	}

	public BigDecimal getTotal_importe_neto() {
		return total_importe_neto;
	}

	public void setTotal_importe_neto(BigDecimal total_importe_neto) {
		this.total_importe_neto = total_importe_neto;
	}

	public BigDecimal getPorc_iva_cliente() {
		return porc_iva_cliente;
	}

	public void setPorc_iva_cliente(BigDecimal porc_iva_cliente) {
		this.porc_iva_cliente = porc_iva_cliente;
	}

	public BigDecimal getTotal_importe_iva() {
		return total_importe_iva;
	}

	public void setTotal_importe_iva(BigDecimal total_importe_iva) {
		this.total_importe_iva = total_importe_iva;
	}

	public BigDecimal getTipo_cambio() {
		return tipo_cambio;
	}

	public void setTipo_cambio(BigDecimal tipo_cambio) {
		this.tipo_cambio = tipo_cambio;
	}

	public BigDecimal getTotal_desc_especial() {
		return total_desc_especial;
	}

	public void setTotal_desc_especial(BigDecimal total_desc_especial) {
		this.total_desc_especial = total_desc_especial;
	}

	public BigDecimal getTotal_desc_adic_vol() {
		return total_desc_adic_vol;
	}

	public void setTotal_desc_adic_vol(BigDecimal total_desc_adic_vol) {
		this.total_desc_adic_vol = total_desc_adic_vol;
	}

	public BigDecimal getTotal_importe_liquidado() {
		return total_importe_liquidado;
	}

	public void setTotal_importe_liquidado(BigDecimal total_importe_liquidado) {
		this.total_importe_liquidado = total_importe_liquidado;
	}

	public BigDecimal getTotal_iva_liquidado() {
		return total_iva_liquidado;
	}

	public void setTotal_iva_liquidado(BigDecimal total_iva_liquidado) {
		this.total_iva_liquidado = total_iva_liquidado;
	}

	public Integer getId_carta_impresa() {
		return id_carta_impresa;
	}

	public void setId_carta_impresa(Integer id_carta_impresa) {
		this.id_carta_impresa = id_carta_impresa;
	}

	public Integer getId_contacto_cliente() {
		return id_contacto_cliente;
	}

	public void setId_contacto_cliente(Integer id_contacto_cliente) {
		this.id_contacto_cliente = id_contacto_cliente;
	}

	public String getRazon_social_cliente() {
		return razon_social_cliente;
	}

	public void setRazon_social_cliente(String razon_social_cliente) {
		this.razon_social_cliente = razon_social_cliente;
	}

	public String getRfc_cliente() {
		return rfc_cliente;
	}

	public void setRfc_cliente(String rfc_cliente) {
		this.rfc_cliente = rfc_cliente;
	}

	public String getDireccion_cliente() {
		return direccion_cliente;
	}

	public void setDireccion_cliente(String direccion_cliente) {
		this.direccion_cliente = direccion_cliente;
	}

	public String getNombre_contacto_cliente() {
		return nombre_contacto_cliente;
	}

	public void setNombre_contacto_cliente(String nombre_contacto_cliente) {
		this.nombre_contacto_cliente = nombre_contacto_cliente;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
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

	public Date getFecha_cancelacion() {
		return fecha_cancelacion;
	}

	public void setFecha_cancelacion(Date fecha_cancelacion) {
		this.fecha_cancelacion = fecha_cancelacion;
	}

	@Override
	public String toString() {
		return "TBL_SIF_FACTURAS [id_factura=" + id_factura + ", id_cliente=" + id_cliente + ", id_negocio="
				+ id_negocio + ", id_moneda=" + id_moneda + ", id_centro_costos=" + id_centro_costos + ", id_periodo="
				+ id_periodo + ", folio=" + folio + ", fecha_datos=" + fecha_datos + ", total_importe_neto="
				+ total_importe_neto + ", porc_iva_cliente=" + porc_iva_cliente + ", total_importe_iva="
				+ total_importe_iva + ", tipo_cambio=" + tipo_cambio + ", total_desc_especial=" + total_desc_especial
				+ ", total_desc_adic_vol=" + total_desc_adic_vol + ", total_importe_liquidado="
				+ total_importe_liquidado + ", total_iva_liquidado=" + total_iva_liquidado + ", id_carta_impresa="
				+ id_carta_impresa + ", id_contacto_cliente=" + id_contacto_cliente + ", razon_social_cliente="
				+ razon_social_cliente + ", rfc_cliente=" + rfc_cliente + ", direccion_cliente=" + direccion_cliente
				+ ", nombre_contacto_cliente=" + nombre_contacto_cliente + ", comentarios=" + comentarios + ", usuario="
				+ usuario + ", estatus=" + estatus + ", fecha_mod=" + fecha_mod + ", fecha_cre=" + fecha_cre
				+ ", fecha_cancelacion=" + fecha_cancelacion + "]";
	}

}
