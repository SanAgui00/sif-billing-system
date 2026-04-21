package com.prosa.sif.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_RESU_PERIO_SERV_CLI")
public class TBL_SIF_RESU_PERIO_SERV_CLI {

	// @ManyToOne
	// @JoinColumn(name = "id_servicio")
	// private TBL_SIF_SERVICIOS_CLIENTES ser_cl;
	private Integer id_servicio;

	// @ManyToOne
	// @JoinColumn(name = "id_periodo")
	// private TBL_SIF_CAT_DIAS_PERIODO periodos;
	private Integer id_periodo;

	// @ManyToOne
	// @JoinColumn(name = "id_cliente")
	// private TBL_SIF_SERVICIOS_FACTURAR servicios_fac_cl;
	private Integer id_cliente;

	// @ManyToOne
	// @JoinColumn(name = "id_moneda")
	// private TBL_SIF_SERVICIOS_FACTURAR servicios_fac_mo;
	private Integer id_moneda;

	@Id
	private Integer id_resumen;
	private Double total_trans_emisor;
	private Double total_importe_neto;
	private Double total_iva_emisor;
	private Double total_trans_adquirente;
	private Double total_importe_neto_adq;
	private Double total_iva_adq;
	private Double total_periodo_liqui;
	private Double total_descuento;
	private Double total_costo_servicio;
	private Double total_iva_servicio;
	private Integer b_incluye_rebate;
	private Double total_rebate;
	private Double poc_rebate;
	private Double calculo_ajuste_neto;
	private Double cal_importe_recibo;
	private String usuario;
	private String estatus;
	private Date fecha_cre;
	private Date fecha_mod;
	private String comentarios;
	private Double precio_aplicado;
	private Double imp_cobro_ps;
	private Double imp_iva_ps;
	private Double imp_descuento_ps;
	private Double precio_cobro_ps;
	private Double tipo_cambio_ps;

	public TBL_SIF_RESU_PERIO_SERV_CLI() {
	}

	public TBL_SIF_RESU_PERIO_SERV_CLI(Integer id_servicio, Integer id_periodo, Integer id_cliente, Integer id_moneda,
			Integer id_resumen, Double total_trans_emisor, Double total_importe_neto, Double total_iva_emisor,
			Double total_trans_adquirente, Double total_importe_neto_adq, Double total_iva_adq,
			Double total_periodo_liqui, Double total_descuento, Double total_costo_servicio, Double total_iva_servicio,
			Integer b_incluye_rebate, Double total_rebate, Double poc_rebate, Double calculo_ajuste_neto,
			Double cal_importe_recibo, String usuario, String estatus, Date fecha_cre, Date fecha_mod,
			String comentarios, Double precio_aplicado, Double imp_cobro_ps, Double imp_iva_ps, Double imp_descuento_ps,
			Double precio_cobro_ps, Double tipo_cambio_ps) {
		super();
		this.id_servicio = id_servicio;
		this.id_periodo = id_periodo;
		this.id_cliente = id_cliente;
		this.id_moneda = id_moneda;
		this.id_resumen = id_resumen;
		this.total_trans_emisor = total_trans_emisor;
		this.total_importe_neto = total_importe_neto;
		this.total_iva_emisor = total_iva_emisor;
		this.total_trans_adquirente = total_trans_adquirente;
		this.total_importe_neto_adq = total_importe_neto_adq;
		this.total_iva_adq = total_iva_adq;
		this.total_periodo_liqui = total_periodo_liqui;
		this.total_descuento = total_descuento;
		this.total_costo_servicio = total_costo_servicio;
		this.total_iva_servicio = total_iva_servicio;
		this.b_incluye_rebate = b_incluye_rebate;
		this.total_rebate = total_rebate;
		this.poc_rebate = poc_rebate;
		this.calculo_ajuste_neto = calculo_ajuste_neto;
		this.cal_importe_recibo = cal_importe_recibo;
		this.usuario = usuario;
		this.estatus = estatus;
		this.fecha_cre = fecha_cre;
		this.fecha_mod = fecha_mod;
		this.comentarios = comentarios;
		this.precio_aplicado = precio_aplicado;
		this.imp_cobro_ps = imp_cobro_ps;
		this.imp_iva_ps = imp_iva_ps;
		this.imp_descuento_ps = imp_descuento_ps;
		this.precio_cobro_ps = precio_cobro_ps;
		this.tipo_cambio_ps = tipo_cambio_ps;
	}

	public Integer getId_servicio() {
		return id_servicio;
	}

	public void setId_servicio(Integer id_servicio) {
		this.id_servicio = id_servicio;
	}

	public Integer getId_periodo() {
		return id_periodo;
	}

	public void setId_periodo(Integer id_periodo) {
		this.id_periodo = id_periodo;
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

	public Integer getId_resumen() {
		return id_resumen;
	}

	public void setId_resumen(Integer id_resumen) {
		this.id_resumen = id_resumen;
	}

	public Double getTotal_trans_emisor() {
		return total_trans_emisor;
	}

	public void setTotal_trans_emisor(Double total_trans_emisor) {
		this.total_trans_emisor = total_trans_emisor;
	}

	public Double getTotal_importe_neto() {
		return total_importe_neto;
	}

	public void setTotal_importe_neto(Double total_importe_neto) {
		this.total_importe_neto = total_importe_neto;
	}

	public Double getTotal_iva_emisor() {
		return total_iva_emisor;
	}

	public void setTotal_iva_emisor(Double total_iva_emisor) {
		this.total_iva_emisor = total_iva_emisor;
	}

	public Double getTotal_trans_adquirente() {
		return total_trans_adquirente;
	}

	public void setTotal_trans_adquirente(Double total_trans_adquirente) {
		this.total_trans_adquirente = total_trans_adquirente;
	}

	public Double getTotal_importe_neto_adq() {
		return total_importe_neto_adq;
	}

	public void setTotal_importe_neto_adq(Double total_importe_neto_adq) {
		this.total_importe_neto_adq = total_importe_neto_adq;
	}

	public Double getTotal_iva_adq() {
		return total_iva_adq;
	}

	public void setTotal_iva_adq(Double total_iva_adq) {
		this.total_iva_adq = total_iva_adq;
	}

	public Double getTotal_periodo_liqui() {
		return total_periodo_liqui;
	}

	public void setTotal_periodo_liqui(Double total_periodo_liqui) {
		this.total_periodo_liqui = total_periodo_liqui;
	}

	public Double getTotal_descuento() {
		return total_descuento;
	}

	public void setTotal_descuento(Double total_descuento) {
		this.total_descuento = total_descuento;
	}

	public Double getTotal_costo_servicio() {
		return total_costo_servicio;
	}

	public void setTotal_costo_servicio(Double total_costo_servicio) {
		this.total_costo_servicio = total_costo_servicio;
	}

	public Double getTotal_iva_servicio() {
		return total_iva_servicio;
	}

	public void setTotal_iva_servicio(Double total_iva_servicio) {
		this.total_iva_servicio = total_iva_servicio;
	}

	public Integer getB_incluye_rebate() {
		return b_incluye_rebate;
	}

	public void setB_incluye_rebate(Integer b_incluye_rebate) {
		this.b_incluye_rebate = b_incluye_rebate;
	}

	public Double getTotal_rebate() {
		return total_rebate;
	}

	public void setTotal_rebate(Double total_rebate) {
		this.total_rebate = total_rebate;
	}

	public Double getPoc_rebate() {
		return poc_rebate;
	}

	public void setPoc_rebate(Double poc_rebate) {
		this.poc_rebate = poc_rebate;
	}

	public Double getCalculo_ajuste_neto() {
		return calculo_ajuste_neto;
	}

	public void setCalculo_ajuste_neto(Double calculo_ajuste_neto) {
		this.calculo_ajuste_neto = calculo_ajuste_neto;
	}

	public Double getCal_importe_recibo() {
		return cal_importe_recibo;
	}

	public void setCal_importe_recibo(Double cal_importe_recibo) {
		this.cal_importe_recibo = cal_importe_recibo;
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

	public Double getPrecio_aplicado() {
		return precio_aplicado;
	}

	public void setPrecio_aplicado(Double precio_aplicado) {
		this.precio_aplicado = precio_aplicado;
	}

	public Double getImp_cobro_ps() {
		return imp_cobro_ps;
	}

	public void setImp_cobro_ps(Double imp_cobro_ps) {
		this.imp_cobro_ps = imp_cobro_ps;
	}

	public Double getImp_iva_ps() {
		return imp_iva_ps;
	}

	public void setImp_iva_ps(Double imp_iva_ps) {
		this.imp_iva_ps = imp_iva_ps;
	}

	public Double getImp_descuento_ps() {
		return imp_descuento_ps;
	}

	public void setImp_descuento_ps(Double imp_descuento_ps) {
		this.imp_descuento_ps = imp_descuento_ps;
	}

	public Double getPrecio_cobro_ps() {
		return precio_cobro_ps;
	}

	public void setPrecio_cobro_ps(Double precio_cobro_ps) {
		this.precio_cobro_ps = precio_cobro_ps;
	}

	public Double getTipo_cambio_ps() {
		return tipo_cambio_ps;
	}

	public void setTipo_cambio_ps(Double tipo_cambio_ps) {
		this.tipo_cambio_ps = tipo_cambio_ps;
	}

	@Override
	public String toString() {
		return "TBL_SIF_RESU_PERIO_SERV_CLI [id_servicio=" + id_servicio + ", id_periodo=" + id_periodo
				+ ", id_cliente=" + id_cliente + ", id_moneda=" + id_moneda + ", id_resumen=" + id_resumen
				+ ", total_trans_emisor=" + total_trans_emisor + ", total_importe_neto=" + total_importe_neto
				+ ", total_iva_emisor=" + total_iva_emisor + ", total_trans_adquirente=" + total_trans_adquirente
				+ ", total_importe_neto_adq=" + total_importe_neto_adq + ", total_iva_adq=" + total_iva_adq
				+ ", total_periodo_liqui=" + total_periodo_liqui + ", total_descuento=" + total_descuento
				+ ", total_costo_servicio=" + total_costo_servicio + ", total_iva_servicio=" + total_iva_servicio
				+ ", b_incluye_rebate=" + b_incluye_rebate + ", total_rebate=" + total_rebate + ", poc_rebate="
				+ poc_rebate + ", calculo_ajuste_neto=" + calculo_ajuste_neto + ", cal_importe_recibo="
				+ cal_importe_recibo + ", usuario=" + usuario + ", estatus=" + estatus + ", fecha_cre=" + fecha_cre
				+ ", fecha_mod=" + fecha_mod + ", comentarios=" + comentarios + ", precio_aplicado=" + precio_aplicado
				+ ", imp_cobro_ps=" + imp_cobro_ps + ", imp_iva_ps=" + imp_iva_ps + ", imp_descuento_ps="
				+ imp_descuento_ps + ", precio_cobro_ps=" + precio_cobro_ps + ", tipo_cambio_ps=" + tipo_cambio_ps
				+ "]";
	}

}
