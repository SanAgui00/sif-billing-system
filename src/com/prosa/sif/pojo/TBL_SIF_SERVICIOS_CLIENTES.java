package com.prosa.sif.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_SERVICIOS_CLIENTES ")
public class TBL_SIF_SERVICIOS_CLIENTES {

	@Id
	private Integer id;
	private Integer id_servicio;
	private Integer id_cliente;
	private Integer id_precio;
	private Integer id_forma_pago;
	private Integer id_moneda_cobro;
	private String sistema_cobro;
	private Double porcentaje_descuento;
	private Double precio_temporal_periodo;
	private Integer id_moneda_precio_temp_per;
	private Double b_incluir_rebate;
	private String usuario;
	private String estatus;
	private Date fecha_cre;
	private Date fecha_mod;
	private String comentarios;
	private Double b_incluir_en_ajuste;
	private Double b_incluir_en_cobranza;

	public TBL_SIF_SERVICIOS_CLIENTES() {

	}

	public TBL_SIF_SERVICIOS_CLIENTES(Integer id, Integer id_servicio, Integer id_cliente, Integer id_precio,
			Integer id_forma_pago, Integer id_moneda_cobro, String sistema_cobro, Double porcentaje_descuento,
			Double precio_temporal_periodo, Integer id_moneda_precio_temp_per, Double b_incluir_rebate, String usuario,
			String estatus, Date fecha_cre, Date fecha_mod, String comentarios, Double b_incluir_en_ajuste,
			Double b_incluir_en_cobranza) {
		super();
		this.id = id;
		this.id_servicio = id_servicio;
		this.id_cliente = id_cliente;
		this.id_precio = id_precio;
		this.id_forma_pago = id_forma_pago;
		this.id_moneda_cobro = id_moneda_cobro;
		this.sistema_cobro = sistema_cobro;
		this.porcentaje_descuento = porcentaje_descuento;
		this.precio_temporal_periodo = precio_temporal_periodo;
		this.id_moneda_precio_temp_per = id_moneda_precio_temp_per;
		this.b_incluir_rebate = b_incluir_rebate;
		this.usuario = usuario;
		this.estatus = estatus;
		this.fecha_cre = fecha_cre;
		this.fecha_mod = fecha_mod;
		this.comentarios = comentarios;
		this.b_incluir_en_ajuste = b_incluir_en_ajuste;
		this.b_incluir_en_cobranza = b_incluir_en_cobranza;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getId_precio() {
		return id_precio;
	}

	public void setId_precio(Integer id_precio) {
		this.id_precio = id_precio;
	}

	public Integer getId_forma_pago() {
		return id_forma_pago;
	}

	public void setId_forma_pago(Integer id_forma_pago) {
		this.id_forma_pago = id_forma_pago;
	}

	public Integer getId_moneda_cobro() {
		return id_moneda_cobro;
	}

	public void setId_moneda_cobro(Integer id_moneda_cobro) {
		this.id_moneda_cobro = id_moneda_cobro;
	}

	public String getSistema_cobro() {
		return sistema_cobro;
	}

	public void setSistema_cobro(String sistema_cobro) {
		this.sistema_cobro = sistema_cobro;
	}

	public Double getPorcentaje_descuento() {
		return porcentaje_descuento;
	}

	public void setPorcentaje_descuento(Double porcentaje_descuento) {
		this.porcentaje_descuento = porcentaje_descuento;
	}

	public Double getPrecio_temporal_periodo() {
		return precio_temporal_periodo;
	}

	public void setPrecio_temporal_periodo(Double precio_temporal_periodo) {
		this.precio_temporal_periodo = precio_temporal_periodo;
	}

	public Integer getId_moneda_precio_temp_per() {
		return id_moneda_precio_temp_per;
	}

	public void setId_moneda_precio_temp_per(Integer id_moneda_precio_temp_per) {
		this.id_moneda_precio_temp_per = id_moneda_precio_temp_per;
	}

	public Double getB_incluir_rebate() {
		return b_incluir_rebate;
	}

	public void setB_incluir_rebate(Double b_incluir_rebate) {
		this.b_incluir_rebate = b_incluir_rebate;
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

	public Double getB_incluir_en_ajuste() {
		return b_incluir_en_ajuste;
	}

	public void setB_incluir_en_ajuste(Double b_incluir_en_ajuste) {
		this.b_incluir_en_ajuste = b_incluir_en_ajuste;
	}

	public Double getB_incluir_en_cobranza() {
		return b_incluir_en_cobranza;
	}

	public void setB_incluir_en_cobranza(Double b_incluir_en_cobranza) {
		this.b_incluir_en_cobranza = b_incluir_en_cobranza;
	}

	@Override
	public String toString() {
		return "TBL_SIF_SERVICIOS_CLIENTES [id=" + id + ", id_servicio=" + id_servicio + ", id_cliente=" + id_cliente
				+ ", id_precio=" + id_precio + ", id_forma_pago=" + id_forma_pago + ", id_moneda_cobro="
				+ id_moneda_cobro + ", sistema_cobro=" + sistema_cobro + ", porcentaje_descuento="
				+ porcentaje_descuento + ", precio_temporal_periodo=" + precio_temporal_periodo
				+ ", id_moneda_precio_temp_per=" + id_moneda_precio_temp_per + ", b_incluir_rebate=" + b_incluir_rebate
				+ ", usuario=" + usuario + ", estatus=" + estatus + ", fecha_cre=" + fecha_cre + ", fecha_mod="
				+ fecha_mod + ", comentarios=" + comentarios + ", b_incluir_en_ajuste=" + b_incluir_en_ajuste
				+ ", b_incluir_en_cobranza=" + b_incluir_en_cobranza + "]";
	}

}
