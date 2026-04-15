package com.prosa.sif.pojo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_SERVICIOS_FACTURAR")
public class TBL_SIF_SERVICIOS_FACTURAR {

	@Id
	private Long id_servicios_facturar;
	private Integer id_servicio;
	private Integer id_cliente;
	private Date fecha_datos;
	private BigDecimal total_trans_emisor;
	private BigDecimal total_importe_emisor;
	private BigDecimal total_iva_emisor;
	private BigDecimal total_trans_adq;
	private BigDecimal total_importe_adq;
	private BigDecimal total_iva_adq;
	private BigDecimal total_importe_liq;
	private String estatus_calculo;
	private String estatus_registro_contable;
	private String estatus_cobro;
	private String estatus_factura;
	private Date fecha_calculo;
	private Date fecha_registro_contable;
	private Date fecha_cobro;
	private Date fecha_factura;
	private Integer id_factura;
	private Integer id_moneda;
	private BigDecimal b_prorrateo;
	private BigDecimal b_contingencia;
	private BigDecimal b_ajuste_reg_cont;
	private Date fecha_cobro_area_op;
	private BigDecimal monto_prorrateado;
	private BigDecimal descuento;
	private BigDecimal costo_servicio;
	private BigDecimal iva_servicio;
	private String usuario;
	private String estatus;
	private Date fecha_cre;
	private Date fecha_mod;
	private String comentarios;
	private BigDecimal precio_aplicado;
	private BigDecimal trx_ajuste_cont;
	private BigDecimal imp_ajuste_cont;
	private BigDecimal imp_real_mensual;
	private BigDecimal imp_ajuste_mensual;
	private BigDecimal iva_ajuste_mensual;
	private BigDecimal desc_ajuste_mensual;
	private BigDecimal imp_rebate_mensual;
	private BigDecimal iva_rebate_mensual;
	private BigDecimal iva_ajuste_rebate;
	private BigDecimal imp_cobro_ps;
	private BigDecimal imp_iva_ps;
	private BigDecimal imp_descuento_ps;
	private BigDecimal precio_cobro_ps;
	private BigDecimal tipo_cambio_ps;

	public TBL_SIF_SERVICIOS_FACTURAR() {

	}

	public TBL_SIF_SERVICIOS_FACTURAR(Long id_servicios_facturar, Integer id_servicio, Integer id_cliente,
			Date fecha_datos, BigDecimal total_trans_emisor, BigDecimal total_importe_emisor,
			BigDecimal total_iva_emisor, BigDecimal total_trans_adq, BigDecimal total_importe_adq,
			BigDecimal total_iva_adq, BigDecimal total_importe_liq, String estatus_calculo,
			String estatus_registro_contable, String estatus_cobro, String estatus_factura, Date fecha_calculo,
			Date fecha_registro_contable, Date fecha_cobro, Date fecha_factura, Integer id_factura, Integer id_moneda,
			BigDecimal b_prorrateo, BigDecimal b_contingencia, BigDecimal b_ajuste_reg_cont, Date fecha_cobro_area_op,
			BigDecimal monto_prorrateado, BigDecimal descuento, BigDecimal costo_servicio, BigDecimal iva_servicio,
			String usuario, String estatus, Date fecha_cre, Date fecha_mod, String comentarios,
			BigDecimal precio_aplicado, BigDecimal trx_ajuste_cont, BigDecimal imp_ajuste_cont,
			BigDecimal imp_real_mensual, BigDecimal imp_ajuste_mensual, BigDecimal iva_ajuste_mensual,
			BigDecimal desc_ajuste_mensual, BigDecimal imp_rebate_mensual, BigDecimal iva_rebate_mensual,
			BigDecimal iva_ajuste_rebate, BigDecimal imp_cobro_ps, BigDecimal imp_iva_ps, BigDecimal imp_descuento_ps,
			BigDecimal precio_cobro_ps, BigDecimal tipo_cambio_ps) {
		super();
		this.id_servicios_facturar = id_servicios_facturar;
		this.id_servicio = id_servicio;
		this.id_cliente = id_cliente;
		this.fecha_datos = fecha_datos;
		this.total_trans_emisor = total_trans_emisor;
		this.total_importe_emisor = total_importe_emisor;
		this.total_iva_emisor = total_iva_emisor;
		this.total_trans_adq = total_trans_adq;
		this.total_importe_adq = total_importe_adq;
		this.total_iva_adq = total_iva_adq;
		this.total_importe_liq = total_importe_liq;
		this.estatus_calculo = estatus_calculo;
		this.estatus_registro_contable = estatus_registro_contable;
		this.estatus_cobro = estatus_cobro;
		this.estatus_factura = estatus_factura;
		this.fecha_calculo = fecha_calculo;
		this.fecha_registro_contable = fecha_registro_contable;
		this.fecha_cobro = fecha_cobro;
		this.fecha_factura = fecha_factura;
		this.id_factura = id_factura;
		this.id_moneda = id_moneda;
		this.b_prorrateo = b_prorrateo;
		this.b_contingencia = b_contingencia;
		this.b_ajuste_reg_cont = b_ajuste_reg_cont;
		this.fecha_cobro_area_op = fecha_cobro_area_op;
		this.monto_prorrateado = monto_prorrateado;
		this.descuento = descuento;
		this.costo_servicio = costo_servicio;
		this.iva_servicio = iva_servicio;
		this.usuario = usuario;
		this.estatus = estatus;
		this.fecha_cre = fecha_cre;
		this.fecha_mod = fecha_mod;
		this.comentarios = comentarios;
		this.precio_aplicado = precio_aplicado;
		this.trx_ajuste_cont = trx_ajuste_cont;
		this.imp_ajuste_cont = imp_ajuste_cont;
		this.imp_real_mensual = imp_real_mensual;
		this.imp_ajuste_mensual = imp_ajuste_mensual;
		this.iva_ajuste_mensual = iva_ajuste_mensual;
		this.desc_ajuste_mensual = desc_ajuste_mensual;
		this.imp_rebate_mensual = imp_rebate_mensual;
		this.iva_rebate_mensual = iva_rebate_mensual;
		this.iva_ajuste_rebate = iva_ajuste_rebate;
		this.imp_cobro_ps = imp_cobro_ps;
		this.imp_iva_ps = imp_iva_ps;
		this.imp_descuento_ps = imp_descuento_ps;
		this.precio_cobro_ps = precio_cobro_ps;
		this.tipo_cambio_ps = tipo_cambio_ps;
	}

	public Long getId_servicios_facturar() {
		return id_servicios_facturar;
	}

	public void setId_servicios_facturar(Long id_servicios_facturar) {
		this.id_servicios_facturar = id_servicios_facturar;
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

	public Date getFecha_datos() {
		return fecha_datos;
	}

	public void setFecha_datos(Date fecha_datos) {
		this.fecha_datos = fecha_datos;
	}

	public BigDecimal getTotal_trans_emisor() {
		return total_trans_emisor;
	}

	public void setTotal_trans_emisor(BigDecimal total_trans_emisor) {
		this.total_trans_emisor = total_trans_emisor;
	}

	public BigDecimal getTotal_importe_emisor() {
		return total_importe_emisor;
	}

	public void setTotal_importe_emisor(BigDecimal total_importe_emisor) {
		this.total_importe_emisor = total_importe_emisor;
	}

	public BigDecimal getTotal_iva_emisor() {
		return total_iva_emisor;
	}

	public void setTotal_iva_emisor(BigDecimal total_iva_emisor) {
		this.total_iva_emisor = total_iva_emisor;
	}

	public BigDecimal getTotal_trans_adq() {
		return total_trans_adq;
	}

	public void setTotal_trans_adq(BigDecimal total_trans_adq) {
		this.total_trans_adq = total_trans_adq;
	}

	public BigDecimal getTotal_importe_adq() {
		return total_importe_adq;
	}

	public void setTotal_importe_adq(BigDecimal total_importe_adq) {
		this.total_importe_adq = total_importe_adq;
	}

	public BigDecimal getTotal_iva_adq() {
		return total_iva_adq;
	}

	public void setTotal_iva_adq(BigDecimal total_iva_adq) {
		this.total_iva_adq = total_iva_adq;
	}

	public BigDecimal getTotal_importe_liq() {
		return total_importe_liq;
	}

	public void setTotal_importe_liq(BigDecimal total_importe_liq) {
		this.total_importe_liq = total_importe_liq;
	}

	public String getEstatus_calculo() {
		return estatus_calculo;
	}

	public void setEstatus_calculo(String estatus_calculo) {
		this.estatus_calculo = estatus_calculo;
	}

	public String getEstatus_registro_contable() {
		return estatus_registro_contable;
	}

	public void setEstatus_registro_contable(String estatus_registro_contable) {
		this.estatus_registro_contable = estatus_registro_contable;
	}

	public String getEstatus_cobro() {
		return estatus_cobro;
	}

	public void setEstatus_cobro(String estatus_cobro) {
		this.estatus_cobro = estatus_cobro;
	}

	public String getEstatus_factura() {
		return estatus_factura;
	}

	public void setEstatus_factura(String estatus_factura) {
		this.estatus_factura = estatus_factura;
	}

	public Date getFecha_calculo() {
		return fecha_calculo;
	}

	public void setFecha_calculo(Date fecha_calculo) {
		this.fecha_calculo = fecha_calculo;
	}

	public Date getFecha_registro_contable() {
		return fecha_registro_contable;
	}

	public void setFecha_registro_contable(Date fecha_registro_contable) {
		this.fecha_registro_contable = fecha_registro_contable;
	}

	public Date getFecha_cobro() {
		return fecha_cobro;
	}

	public void setFecha_cobro(Date fecha_cobro) {
		this.fecha_cobro = fecha_cobro;
	}

	public Date getFecha_factura() {
		return fecha_factura;
	}

	public void setFecha_factura(Date fecha_factura) {
		this.fecha_factura = fecha_factura;
	}

	public Integer getId_factura() {
		return id_factura;
	}

	public void setId_factura(Integer id_factura) {
		this.id_factura = id_factura;
	}

	public Integer getId_moneda() {
		return id_moneda;
	}

	public void setId_moneda(Integer id_moneda) {
		this.id_moneda = id_moneda;
	}

	public BigDecimal getB_prorrateo() {
		return b_prorrateo;
	}

	public void setB_prorrateo(BigDecimal b_prorrateo) {
		this.b_prorrateo = b_prorrateo;
	}

	public BigDecimal getB_contingencia() {
		return b_contingencia;
	}

	public void setB_contingencia(BigDecimal b_contingencia) {
		this.b_contingencia = b_contingencia;
	}

	public BigDecimal getB_ajuste_reg_cont() {
		return b_ajuste_reg_cont;
	}

	public void setB_ajuste_reg_cont(BigDecimal b_ajuste_reg_cont) {
		this.b_ajuste_reg_cont = b_ajuste_reg_cont;
	}

	public Date getFecha_cobro_area_op() {
		return fecha_cobro_area_op;
	}

	public void setFecha_cobro_area_op(Date fecha_cobro_area_op) {
		this.fecha_cobro_area_op = fecha_cobro_area_op;
	}

	public BigDecimal getMonto_prorrateado() {
		return monto_prorrateado;
	}

	public void setMonto_prorrateado(BigDecimal monto_prorrateado) {
		this.monto_prorrateado = monto_prorrateado;
	}

	public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public BigDecimal getCosto_servicio() {
		return costo_servicio;
	}

	public void setCosto_servicio(BigDecimal costo_servicio) {
		this.costo_servicio = costo_servicio;
	}

	public BigDecimal getIva_servicio() {
		return iva_servicio;
	}

	public void setIva_servicio(BigDecimal iva_servicio) {
		this.iva_servicio = iva_servicio;
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

	public BigDecimal getPrecio_aplicado() {
		return precio_aplicado;
	}

	public void setPrecio_aplicado(BigDecimal precio_aplicado) {
		this.precio_aplicado = precio_aplicado;
	}

	public BigDecimal getTrx_ajuste_cont() {
		return trx_ajuste_cont;
	}

	public void setTrx_ajuste_cont(BigDecimal trx_ajuste_cont) {
		this.trx_ajuste_cont = trx_ajuste_cont;
	}

	public BigDecimal getImp_ajuste_cont() {
		return imp_ajuste_cont;
	}

	public void setImp_ajuste_cont(BigDecimal imp_ajuste_cont) {
		this.imp_ajuste_cont = imp_ajuste_cont;
	}

	public BigDecimal getImp_real_mensual() {
		return imp_real_mensual;
	}

	public void setImp_real_mensual(BigDecimal imp_real_mensual) {
		this.imp_real_mensual = imp_real_mensual;
	}

	public BigDecimal getImp_ajuste_mensual() {
		return imp_ajuste_mensual;
	}

	public void setImp_ajuste_mensual(BigDecimal imp_ajuste_mensual) {
		this.imp_ajuste_mensual = imp_ajuste_mensual;
	}

	public BigDecimal getIva_ajuste_mensual() {
		return iva_ajuste_mensual;
	}

	public void setIva_ajuste_mensual(BigDecimal iva_ajuste_mensual) {
		this.iva_ajuste_mensual = iva_ajuste_mensual;
	}

	public BigDecimal getDesc_ajuste_mensual() {
		return desc_ajuste_mensual;
	}

	public void setDesc_ajuste_mensual(BigDecimal desc_ajuste_mensual) {
		this.desc_ajuste_mensual = desc_ajuste_mensual;
	}

	public BigDecimal getImp_rebate_mensual() {
		return imp_rebate_mensual;
	}

	public void setImp_rebate_mensual(BigDecimal imp_rebate_mensual) {
		this.imp_rebate_mensual = imp_rebate_mensual;
	}

	public BigDecimal getIva_rebate_mensual() {
		return iva_rebate_mensual;
	}

	public void setIva_rebate_mensual(BigDecimal iva_rebate_mensual) {
		this.iva_rebate_mensual = iva_rebate_mensual;
	}

	public BigDecimal getIva_ajuste_rebate() {
		return iva_ajuste_rebate;
	}

	public void setIva_ajuste_rebate(BigDecimal iva_ajuste_rebate) {
		this.iva_ajuste_rebate = iva_ajuste_rebate;
	}

	public BigDecimal getImp_cobro_ps() {
		return imp_cobro_ps;
	}

	public void setImp_cobro_ps(BigDecimal imp_cobro_ps) {
		this.imp_cobro_ps = imp_cobro_ps;
	}

	public BigDecimal getImp_iva_ps() {
		return imp_iva_ps;
	}

	public void setImp_iva_ps(BigDecimal imp_iva_ps) {
		this.imp_iva_ps = imp_iva_ps;
	}

	public BigDecimal getImp_descuento_ps() {
		return imp_descuento_ps;
	}

	public void setImp_descuento_ps(BigDecimal imp_descuento_ps) {
		this.imp_descuento_ps = imp_descuento_ps;
	}

	public BigDecimal getPrecio_cobro_ps() {
		return precio_cobro_ps;
	}

	public void setPrecio_cobro_ps(BigDecimal precio_cobro_ps) {
		this.precio_cobro_ps = precio_cobro_ps;
	}

	public BigDecimal getTipo_cambio_ps() {
		return tipo_cambio_ps;
	}

	public void setTipo_cambio_ps(BigDecimal tipo_cambio_ps) {
		this.tipo_cambio_ps = tipo_cambio_ps;
	}

	@Override
	public String toString() {
		return "TBL_SIF_SERVICIOS_FACTURAR [id_servicios_facturar=" + id_servicios_facturar + ", id_servicio="
				+ id_servicio + ", id_cliente=" + id_cliente + ", fecha_datos=" + fecha_datos + ", total_trans_emisor="
				+ total_trans_emisor + ", total_importe_emisor=" + total_importe_emisor + ", total_iva_emisor="
				+ total_iva_emisor + ", total_trans_adq=" + total_trans_adq + ", total_importe_adq=" + total_importe_adq
				+ ", total_iva_adq=" + total_iva_adq + ", total_importe_liq=" + total_importe_liq + ", estatus_calculo="
				+ estatus_calculo + ", estatus_registro_contable=" + estatus_registro_contable + ", estatus_cobro="
				+ estatus_cobro + ", estatus_factura=" + estatus_factura + ", fecha_calculo=" + fecha_calculo
				+ ", fecha_registro_contable=" + fecha_registro_contable + ", fecha_cobro=" + fecha_cobro
				+ ", fecha_factura=" + fecha_factura + ", id_factura=" + id_factura + ", id_moneda=" + id_moneda
				+ ", b_prorrateo=" + b_prorrateo + ", b_contingencia=" + b_contingencia + ", b_ajuste_reg_cont="
				+ b_ajuste_reg_cont + ", fecha_cobro_area_op=" + fecha_cobro_area_op + ", monto_prorrateado="
				+ monto_prorrateado + ", descuento=" + descuento + ", costo_servicio=" + costo_servicio
				+ ", iva_servicio=" + iva_servicio + ", usuario=" + usuario + ", estatus=" + estatus + ", fecha_cre="
				+ fecha_cre + ", fecha_mod=" + fecha_mod + ", comentarios=" + comentarios + ", precio_aplicado="
				+ precio_aplicado + ", trx_ajuste_cont=" + trx_ajuste_cont + ", imp_ajuste_cont=" + imp_ajuste_cont
				+ ", imp_real_mensual=" + imp_real_mensual + ", imp_ajuste_mensual=" + imp_ajuste_mensual
				+ ", iva_ajuste_mensual=" + iva_ajuste_mensual + ", desc_ajuste_mensual=" + desc_ajuste_mensual
				+ ", imp_rebate_mensual=" + imp_rebate_mensual + ", iva_rebate_mensual=" + iva_rebate_mensual
				+ ", iva_ajuste_rebate=" + iva_ajuste_rebate + ", imp_cobro_ps=" + imp_cobro_ps + ", imp_iva_ps="
				+ imp_iva_ps + ", imp_descuento_ps=" + imp_descuento_ps + ", precio_cobro_ps=" + precio_cobro_ps
				+ ", tipo_cambio_ps=" + tipo_cambio_ps + "]";
	}

}
