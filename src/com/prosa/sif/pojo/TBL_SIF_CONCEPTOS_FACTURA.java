package com.prosa.sif.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_CONCEPTOS_FACTURA")
public class TBL_SIF_CONCEPTOS_FACTURA {

	// @ManyToOne
	// @JoinColumn(name = "id_factura")
	// private TBL_SIF_FACTURAS facturas;
	private Integer id_factura;

	@Id
	private Integer numero;
	private Integer cantidad;
	private Double costo_unitario;
	private Double importe;
	private String descripcion;
	private Double descuento;
	private Double desc_adicional;
	private String clave_servicio_sat;
	private String clave_unidad_sat;
	private String clave_impuesto_sat;
	private String clave_factor_sat;
	private Double valor_tasa_sat;
	private Double impuesto;
	private Double total_importe;

	public TBL_SIF_CONCEPTOS_FACTURA() {
	}

	public TBL_SIF_CONCEPTOS_FACTURA(Integer id_factura, Integer numero, Integer cantidad, Double costo_unitario,
			Double importe, String descripcion, Double descuento, Double desc_adicional, String clave_servicio_sat,
			String clave_unidad_sat, String clave_impuesto_sat, String clave_factor_sat, Double valor_tasa_sat,
			Double impuesto, Double total_importe) {
		super();
		this.id_factura = id_factura;
		this.numero = numero;
		this.cantidad = cantidad;
		this.costo_unitario = costo_unitario;
		this.importe = importe;
		this.descripcion = descripcion;
		this.descuento = descuento;
		this.desc_adicional = desc_adicional;
		this.clave_servicio_sat = clave_servicio_sat;
		this.clave_unidad_sat = clave_unidad_sat;
		this.clave_impuesto_sat = clave_impuesto_sat;
		this.clave_factor_sat = clave_factor_sat;
		this.valor_tasa_sat = valor_tasa_sat;
		this.impuesto = impuesto;
		this.total_importe = total_importe;
	}

	public Integer getId_factura() {
		return id_factura;
	}

	public void setId_factura(Integer id_factura) {
		this.id_factura = id_factura;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getCosto_unitario() {
		return costo_unitario;
	}

	public void setCosto_unitario(Double costo_unitario) {
		this.costo_unitario = costo_unitario;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	public Double getDesc_adicional() {
		return desc_adicional;
	}

	public void setDesc_adicional(Double desc_adicional) {
		this.desc_adicional = desc_adicional;
	}

	public String getClave_servicio_sat() {
		return clave_servicio_sat;
	}

	public void setClave_servicio_sat(String clave_servicio_sat) {
		this.clave_servicio_sat = clave_servicio_sat;
	}

	public String getClave_unidad_sat() {
		return clave_unidad_sat;
	}

	public void setClave_unidad_sat(String clave_unidad_sat) {
		this.clave_unidad_sat = clave_unidad_sat;
	}

	public String getClave_impuesto_sat() {
		return clave_impuesto_sat;
	}

	public void setClave_impuesto_sat(String clave_impuesto_sat) {
		this.clave_impuesto_sat = clave_impuesto_sat;
	}

	public String getClave_factor_sat() {
		return clave_factor_sat;
	}

	public void setClave_factor_sat(String clave_factor_sat) {
		this.clave_factor_sat = clave_factor_sat;
	}

	public Double getValor_tasa_sat() {
		return valor_tasa_sat;
	}

	public void setValor_tasa_sat(Double valor_tasa_sat) {
		this.valor_tasa_sat = valor_tasa_sat;
	}

	public Double getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(Double impuesto) {
		this.impuesto = impuesto;
	}

	public Double getTotal_importe() {
		return total_importe;
	}

	public void setTotal_importe(Double total_importe) {
		this.total_importe = total_importe;
	}

	@Override
	public String toString() {
		return "TBL_SIF_CONCEPTOS_FACTURA [id_factura=" + id_factura + ", numero=" + numero + ", cantidad=" + cantidad
				+ ", costo_unitario=" + costo_unitario + ", importe=" + importe + ", descripcion=" + descripcion
				+ ", descuento=" + descuento + ", desc_adicional=" + desc_adicional + ", clave_servicio_sat="
				+ clave_servicio_sat + ", clave_unidad_sat=" + clave_unidad_sat + ", clave_impuesto_sat="
				+ clave_impuesto_sat + ", clave_factor_sat=" + clave_factor_sat + ", valor_tasa_sat=" + valor_tasa_sat
				+ ", impuesto=" + impuesto + ", total_importe=" + total_importe + "]";
	}

}
