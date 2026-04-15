package com.prosa.sif.pojo;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VIEW_SERVICIOS_CLIENTES_JASP_2")
public class ViewServicioClienteJaspDos {

	@Id
	private Integer id_vista;
	private Integer id_cliente;
	private Integer id_moneda;
	private Integer id_periodo;
	private Integer id_negocio;
	private Integer id_servicio;
	private Integer id_empresa;
	private Integer id_grupo;
	private BigDecimal trans_subconcepto;
	private BigDecimal costo_subconcepto;
	private BigDecimal desc_subconcepto;
	private BigDecimal rebate_subconcepto;
	private BigDecimal total_subconcepto;
	private BigDecimal hay_descuento;
	private BigDecimal hay_rebate;
	private Date fecha_datos;

	public ViewServicioClienteJaspDos() {

	}

	public ViewServicioClienteJaspDos(Integer id_vista, Integer id_cliente, Integer id_moneda, Integer id_periodo,
			Integer id_negocio, Integer id_servicio, Integer id_empresa, Integer id_grupo, BigDecimal trans_subconcepto,
			BigDecimal costo_subconcepto, BigDecimal desc_subconcepto, BigDecimal rebate_subconcepto,
			BigDecimal total_subconcepto, BigDecimal hay_descuento, BigDecimal hay_rebate, Date fecha_datos) {
		super();
		this.id_vista = id_vista;
		this.id_cliente = id_cliente;
		this.id_moneda = id_moneda;
		this.id_periodo = id_periodo;
		this.id_negocio = id_negocio;
		this.id_servicio = id_servicio;
		this.id_empresa = id_empresa;
		this.id_grupo = id_grupo;
		this.trans_subconcepto = trans_subconcepto;
		this.costo_subconcepto = costo_subconcepto;
		this.desc_subconcepto = desc_subconcepto;
		this.rebate_subconcepto = rebate_subconcepto;
		this.total_subconcepto = total_subconcepto;
		this.hay_descuento = hay_descuento;
		this.hay_rebate = hay_rebate;
		this.fecha_datos = fecha_datos;
	}

	public Integer getId_vista() {
		return id_vista;
	}

	public void setId_vista(Integer id_vista) {
		this.id_vista = id_vista;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
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

	public Integer getId_negocio() {
		return id_negocio;
	}

	public void setId_negocio(Integer id_negocio) {
		this.id_negocio = id_negocio;
	}

	public Integer getId_servicio() {
		return id_servicio;
	}

	public void setId_servicio(Integer id_servicio) {
		this.id_servicio = id_servicio;
	}

	public Integer getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(Integer id_empresa) {
		this.id_empresa = id_empresa;
	}

	public Integer getId_grupo() {
		return id_grupo;
	}

	public void setId_grupo(Integer id_grupo) {
		this.id_grupo = id_grupo;
	}

	public BigDecimal getTrans_subconcepto() {
		return trans_subconcepto;
	}

	public void setTrans_subconcepto(BigDecimal trans_subconcepto) {
		this.trans_subconcepto = trans_subconcepto;
	}

	public BigDecimal getCosto_subconcepto() {
		return costo_subconcepto;
	}

	public void setCosto_subconcepto(BigDecimal costo_subconcepto) {
		this.costo_subconcepto = costo_subconcepto;
	}

	public BigDecimal getDesc_subconcepto() {
		return desc_subconcepto;
	}

	public void setDesc_subconcepto(BigDecimal desc_subconcepto) {
		this.desc_subconcepto = desc_subconcepto;
	}

	public BigDecimal getRebate_subconcepto() {
		return rebate_subconcepto;
	}

	public void setRebate_subconcepto(BigDecimal rebate_subconcepto) {
		this.rebate_subconcepto = rebate_subconcepto;
	}

	public BigDecimal getTotal_subconcepto() {
		return total_subconcepto;
	}

	public void setTotal_subconcepto(BigDecimal total_subconcepto) {
		this.total_subconcepto = total_subconcepto;
	}

	public BigDecimal getHay_descuento() {
		return hay_descuento;
	}

	public void setHay_descuento(BigDecimal hay_descuento) {
		this.hay_descuento = hay_descuento;
	}

	public BigDecimal getHay_rebate() {
		return hay_rebate;
	}

	public void setHay_rebate(BigDecimal hay_rebate) {
		this.hay_rebate = hay_rebate;
	}

	public Date getFecha_datos() {
		return fecha_datos;
	}

	public void setFecha_datos(Date fecha_datos) {
		this.fecha_datos = fecha_datos;
	}

	@Override
	public String toString() {
		return "VIEW_SERVICIOS_CLIENTES_JASP_2 [id_vista=" + id_vista + ", id_cliente=" + id_cliente + ", id_moneda="
				+ id_moneda + ", id_periodo=" + id_periodo + ", id_negocio=" + id_negocio + ", id_servicio="
				+ id_servicio + ", id_empresa=" + id_empresa + ", id_grupo=" + id_grupo + ", trans_subconcepto="
				+ trans_subconcepto + ", costo_subconcepto=" + costo_subconcepto + ", desc_subconcepto="
				+ desc_subconcepto + ", rebate_subconcepto=" + rebate_subconcepto + ", total_subconcepto="
				+ total_subconcepto + ", hay_descuento=" + hay_descuento + ", hay_rebate=" + hay_rebate
				+ ", fecha_datos=" + fecha_datos + "]";
	}

}
