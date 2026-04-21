package com.prosa.sif.pojo;

import java.util.Date;

public class ViewRegistrosPendientes {

	private Integer id_registro_prendiente;
	private Integer imp_neto_emi_visa_mds;
	private Integer imp_total_emi_bnmr;
	private Integer imp_iva_jcb1_atm;
	private Integer importe_neto;
	private Integer importe_total_emi;
	private Integer id_servicio;
	private Integer importe_cobranza;
	private Date fecha_datos;
	private Integer id_cliente;
	private Integer imp_iva_eglo_atm;
	private Integer id_tipo_cuenta_contable;
	private Date fecha_calculo;
	private Integer id_centro_costos_serv;
	private String clave_cliente;
	private Integer imp_total_upay_atm;
	private Integer imp_total_emi_bnpl;
	private Integer id_proceso;
	private Integer imp_neto_adq_visa;
	private Integer imp_total_adq_bsoc;
	private Integer importe_total_pago;
	private Number id_modelo_poliza;
	private Integer importe_neto_emi;
	private Integer importe_total_adq;
	private String clave_modelo_poliza;
	private Integer tipo_moneda;
	private Integer importe_iva_pago;
	private Integer imp_iva_adq_visa_mds;
	private String clave_negocio;
	private Integer imp_neto_mds1_atm;
	private String descripcion;
	private String clave_proceso;
	private Integer descuento_adicional_pago;
	private Integer importe_iva_adq;
	private Integer imp_total_emi_visa_mds;
	private Integer imp_total_emi_bnmx;
	private Integer importe_iva_emi;
	private Integer imp_neto_adq_mds;
	private Integer id_moneda;
	private Integer importe_neto_emi_pago;
	private Integer importe_descuento_pago;
	private Integer importe_total;
	private Integer imp_total_emi_bsoc_eglo;
	private Number id_negocio;
	private Date fecha_cobro;
	private Integer imp_neto_eglo_atm;
	private Integer imp_iva_upay_atm;
	private Integer imp_neto_upay_atm;
	private Integer importe_iva_adq_pago;
	private String clave_servicio;
	private Integer importe_neto_adq_pago;
	private Integer imp_iva_mds1_atm;
	private Integer importe_cobranza_pago;
	private Integer imp_total_adq_visa_mds;
	private Integer imp_total_mds1_atm;
	private String numero_cuenta;
	private Integer imp_neto_adq_visa_mds;
	private Integer imp_total_eglo_atm;
	private String descripcion_negocio;
	private Number id_servicios_facturar;
	private Integer imp_neto_jcb1_atm;
	private Integer imp_iva_emi_visa_mds;
	private Integer id_empresa;
	private Date fecha_registro_gl;
	private Integer imp_total_jcb1_atm;
	private Integer descuento_adicional;
	private Integer importe_iva_emi_pago;
	private Integer importe_neto_adq;
	private String tipo_modelo_poliza;
	private String clave_empresa;
	private Integer importe_iva;
	private Integer imp_total_adq_bsoc_eglo;
	private Integer importe_descuento;
	private Integer importe_total_adq_pago;
	private Integer numero_modelo_registro;
	private Integer importe_total_emi_pago;
	private Integer imp_neto_adq_visa1;
	private String numero_cuenta_default;
	private Integer importe_neto_pago;
	private String nombre_moneda;

	public ViewRegistrosPendientes() {

	}

	public ViewRegistrosPendientes(Integer id_registro_prendiente, Integer imp_neto_emi_visa_mds,
			Integer imp_total_emi_bnmr, Integer imp_iva_jcb1_atm, Integer importe_neto, Integer importe_total_emi,
			Integer id_servicio, Integer importe_cobranza, Date fecha_datos, Integer id_cliente,
			Integer imp_iva_eglo_atm, Integer id_tipo_cuenta_contable, Date fecha_calculo,
			Integer id_centro_costos_serv, String clave_cliente, Integer imp_total_upay_atm, Integer imp_total_emi_bnpl,
			Integer id_proceso, Integer imp_neto_adq_visa, Integer imp_total_adq_bsoc, Integer importe_total_pago,
			Number id_modelo_poliza, Integer importe_neto_emi, Integer importe_total_adq, String clave_modelo_poliza,
			Integer tipo_moneda, Integer importe_iva_pago, Integer imp_iva_adq_visa_mds, String clave_negocio,
			Integer imp_neto_mds1_atm, String descripcion, String clave_proceso, Integer descuento_adicional_pago,
			Integer importe_iva_adq, Integer imp_total_emi_visa_mds, Integer imp_total_emi_bnmx,
			Integer importe_iva_emi, Integer imp_neto_adq_mds, Integer id_moneda, Integer importe_neto_emi_pago,
			Integer importe_descuento_pago, Integer importe_total, Integer imp_total_emi_bsoc_eglo, Number id_negocio,
			Date fecha_cobro, Integer imp_neto_eglo_atm, Integer imp_iva_upay_atm, Integer imp_neto_upay_atm,
			Integer importe_iva_adq_pago, String clave_servicio, Integer importe_neto_adq_pago,
			Integer imp_iva_mds1_atm, Integer importe_cobranza_pago, Integer imp_total_adq_visa_mds,
			Integer imp_total_mds1_atm, String numero_cuenta, Integer imp_neto_adq_visa_mds, Integer imp_total_eglo_atm,
			String descripcion_negocio, Number id_servicios_facturar, Integer imp_neto_jcb1_atm,
			Integer imp_iva_emi_visa_mds, Integer id_empresa, Date fecha_registro_gl, Integer imp_total_jcb1_atm,
			Integer descuento_adicional, Integer importe_iva_emi_pago, Integer importe_neto_adq,
			String tipo_modelo_poliza, String clave_empresa, Integer importe_iva, Integer imp_total_adq_bsoc_eglo,
			Integer importe_descuento, Integer importe_total_adq_pago, Integer numero_modelo_registro,
			Integer importe_total_emi_pago, Integer imp_neto_adq_visa1, String numero_cuenta_default,
			Integer importe_neto_pago, String nombre_moneda) {
		super();
		this.id_registro_prendiente = id_registro_prendiente;
		this.imp_neto_emi_visa_mds = imp_neto_emi_visa_mds;
		this.imp_total_emi_bnmr = imp_total_emi_bnmr;
		this.imp_iva_jcb1_atm = imp_iva_jcb1_atm;
		this.importe_neto = importe_neto;
		this.importe_total_emi = importe_total_emi;
		this.id_servicio = id_servicio;
		this.importe_cobranza = importe_cobranza;
		this.fecha_datos = fecha_datos;
		this.id_cliente = id_cliente;
		this.imp_iva_eglo_atm = imp_iva_eglo_atm;
		this.id_tipo_cuenta_contable = id_tipo_cuenta_contable;
		this.fecha_calculo = fecha_calculo;
		this.id_centro_costos_serv = id_centro_costos_serv;
		this.clave_cliente = clave_cliente;
		this.imp_total_upay_atm = imp_total_upay_atm;
		this.imp_total_emi_bnpl = imp_total_emi_bnpl;
		this.id_proceso = id_proceso;
		this.imp_neto_adq_visa = imp_neto_adq_visa;
		this.imp_total_adq_bsoc = imp_total_adq_bsoc;
		this.importe_total_pago = importe_total_pago;
		this.id_modelo_poliza = id_modelo_poliza;
		this.importe_neto_emi = importe_neto_emi;
		this.importe_total_adq = importe_total_adq;
		this.clave_modelo_poliza = clave_modelo_poliza;
		this.tipo_moneda = tipo_moneda;
		this.importe_iva_pago = importe_iva_pago;
		this.imp_iva_adq_visa_mds = imp_iva_adq_visa_mds;
		this.clave_negocio = clave_negocio;
		this.imp_neto_mds1_atm = imp_neto_mds1_atm;
		this.descripcion = descripcion;
		this.clave_proceso = clave_proceso;
		this.descuento_adicional_pago = descuento_adicional_pago;
		this.importe_iva_adq = importe_iva_adq;
		this.imp_total_emi_visa_mds = imp_total_emi_visa_mds;
		this.imp_total_emi_bnmx = imp_total_emi_bnmx;
		this.importe_iva_emi = importe_iva_emi;
		this.imp_neto_adq_mds = imp_neto_adq_mds;
		this.id_moneda = id_moneda;
		this.importe_neto_emi_pago = importe_neto_emi_pago;
		this.importe_descuento_pago = importe_descuento_pago;
		this.importe_total = importe_total;
		this.imp_total_emi_bsoc_eglo = imp_total_emi_bsoc_eglo;
		this.id_negocio = id_negocio;
		this.fecha_cobro = fecha_cobro;
		this.imp_neto_eglo_atm = imp_neto_eglo_atm;
		this.imp_iva_upay_atm = imp_iva_upay_atm;
		this.imp_neto_upay_atm = imp_neto_upay_atm;
		this.importe_iva_adq_pago = importe_iva_adq_pago;
		this.clave_servicio = clave_servicio;
		this.importe_neto_adq_pago = importe_neto_adq_pago;
		this.imp_iva_mds1_atm = imp_iva_mds1_atm;
		this.importe_cobranza_pago = importe_cobranza_pago;
		this.imp_total_adq_visa_mds = imp_total_adq_visa_mds;
		this.imp_total_mds1_atm = imp_total_mds1_atm;
		this.numero_cuenta = numero_cuenta;
		this.imp_neto_adq_visa_mds = imp_neto_adq_visa_mds;
		this.imp_total_eglo_atm = imp_total_eglo_atm;
		this.descripcion_negocio = descripcion_negocio;
		this.id_servicios_facturar = id_servicios_facturar;
		this.imp_neto_jcb1_atm = imp_neto_jcb1_atm;
		this.imp_iva_emi_visa_mds = imp_iva_emi_visa_mds;
		this.id_empresa = id_empresa;
		this.fecha_registro_gl = fecha_registro_gl;
		this.imp_total_jcb1_atm = imp_total_jcb1_atm;
		this.descuento_adicional = descuento_adicional;
		this.importe_iva_emi_pago = importe_iva_emi_pago;
		this.importe_neto_adq = importe_neto_adq;
		this.tipo_modelo_poliza = tipo_modelo_poliza;
		this.clave_empresa = clave_empresa;
		this.importe_iva = importe_iva;
		this.imp_total_adq_bsoc_eglo = imp_total_adq_bsoc_eglo;
		this.importe_descuento = importe_descuento;
		this.importe_total_adq_pago = importe_total_adq_pago;
		this.numero_modelo_registro = numero_modelo_registro;
		this.importe_total_emi_pago = importe_total_emi_pago;
		this.imp_neto_adq_visa1 = imp_neto_adq_visa1;
		this.numero_cuenta_default = numero_cuenta_default;
		this.importe_neto_pago = importe_neto_pago;
		this.nombre_moneda = nombre_moneda;
	}

	public Integer getId_registro_prendiente() {
		return id_registro_prendiente;
	}

	public void setId_registro_prendiente(Integer id_registro_prendiente) {
		this.id_registro_prendiente = id_registro_prendiente;
	}

	public Integer getImp_neto_emi_visa_mds() {
		return imp_neto_emi_visa_mds;
	}

	public void setImp_neto_emi_visa_mds(Integer imp_neto_emi_visa_mds) {
		this.imp_neto_emi_visa_mds = imp_neto_emi_visa_mds;
	}

	public Integer getImp_total_emi_bnmr() {
		return imp_total_emi_bnmr;
	}

	public void setImp_total_emi_bnmr(Integer imp_total_emi_bnmr) {
		this.imp_total_emi_bnmr = imp_total_emi_bnmr;
	}

	public Integer getImp_iva_jcb1_atm() {
		return imp_iva_jcb1_atm;
	}

	public void setImp_iva_jcb1_atm(Integer imp_iva_jcb1_atm) {
		this.imp_iva_jcb1_atm = imp_iva_jcb1_atm;
	}

	public Integer getImporte_neto() {
		return importe_neto;
	}

	public void setImporte_neto(Integer importe_neto) {
		this.importe_neto = importe_neto;
	}

	public Integer getImporte_total_emi() {
		return importe_total_emi;
	}

	public void setImporte_total_emi(Integer importe_total_emi) {
		this.importe_total_emi = importe_total_emi;
	}

	public Integer getId_servicio() {
		return id_servicio;
	}

	public void setId_servicio(Integer id_servicio) {
		this.id_servicio = id_servicio;
	}

	public Integer getImporte_cobranza() {
		return importe_cobranza;
	}

	public void setImporte_cobranza(Integer importe_cobranza) {
		this.importe_cobranza = importe_cobranza;
	}

	public Date getFecha_datos() {
		return fecha_datos;
	}

	public void setFecha_datos(Date fecha_datos) {
		this.fecha_datos = fecha_datos;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Integer getImp_iva_eglo_atm() {
		return imp_iva_eglo_atm;
	}

	public void setImp_iva_eglo_atm(Integer imp_iva_eglo_atm) {
		this.imp_iva_eglo_atm = imp_iva_eglo_atm;
	}

	public Integer getId_tipo_cuenta_contable() {
		return id_tipo_cuenta_contable;
	}

	public void setId_tipo_cuenta_contable(Integer id_tipo_cuenta_contable) {
		this.id_tipo_cuenta_contable = id_tipo_cuenta_contable;
	}

	public Date getFecha_calculo() {
		return fecha_calculo;
	}

	public void setFecha_calculo(Date fecha_calculo) {
		this.fecha_calculo = fecha_calculo;
	}

	public Integer getId_centro_costos_serv() {
		return id_centro_costos_serv;
	}

	public void setId_centro_costos_serv(Integer id_centro_costos_serv) {
		this.id_centro_costos_serv = id_centro_costos_serv;
	}

	public String getClave_cliente() {
		return clave_cliente;
	}

	public void setClave_cliente(String clave_cliente) {
		this.clave_cliente = clave_cliente;
	}

	public Integer getImp_total_upay_atm() {
		return imp_total_upay_atm;
	}

	public void setImp_total_upay_atm(Integer imp_total_upay_atm) {
		this.imp_total_upay_atm = imp_total_upay_atm;
	}

	public Integer getImp_total_emi_bnpl() {
		return imp_total_emi_bnpl;
	}

	public void setImp_total_emi_bnpl(Integer imp_total_emi_bnpl) {
		this.imp_total_emi_bnpl = imp_total_emi_bnpl;
	}

	public Integer getId_proceso() {
		return id_proceso;
	}

	public void setId_proceso(Integer id_proceso) {
		this.id_proceso = id_proceso;
	}

	public Integer getImp_neto_adq_visa() {
		return imp_neto_adq_visa;
	}

	public void setImp_neto_adq_visa(Integer imp_neto_adq_visa) {
		this.imp_neto_adq_visa = imp_neto_adq_visa;
	}

	public Integer getImp_total_adq_bsoc() {
		return imp_total_adq_bsoc;
	}

	public void setImp_total_adq_bsoc(Integer imp_total_adq_bsoc) {
		this.imp_total_adq_bsoc = imp_total_adq_bsoc;
	}

	public Integer getImporte_total_pago() {
		return importe_total_pago;
	}

	public void setImporte_total_pago(Integer importe_total_pago) {
		this.importe_total_pago = importe_total_pago;
	}

	public Number getId_modelo_poliza() {
		return id_modelo_poliza;
	}

	public void setId_modelo_poliza(Number id_modelo_poliza) {
		this.id_modelo_poliza = id_modelo_poliza;
	}

	public Integer getImporte_neto_emi() {
		return importe_neto_emi;
	}

	public void setImporte_neto_emi(Integer importe_neto_emi) {
		this.importe_neto_emi = importe_neto_emi;
	}

	public Integer getImporte_total_adq() {
		return importe_total_adq;
	}

	public void setImporte_total_adq(Integer importe_total_adq) {
		this.importe_total_adq = importe_total_adq;
	}

	public String getClave_modelo_poliza() {
		return clave_modelo_poliza;
	}

	public void setClave_modelo_poliza(String clave_modelo_poliza) {
		this.clave_modelo_poliza = clave_modelo_poliza;
	}

	public Integer getTipo_moneda() {
		return tipo_moneda;
	}

	public void setTipo_moneda(Integer tipo_moneda) {
		this.tipo_moneda = tipo_moneda;
	}

	public Integer getImporte_iva_pago() {
		return importe_iva_pago;
	}

	public void setImporte_iva_pago(Integer importe_iva_pago) {
		this.importe_iva_pago = importe_iva_pago;
	}

	public Integer getImp_iva_adq_visa_mds() {
		return imp_iva_adq_visa_mds;
	}

	public void setImp_iva_adq_visa_mds(Integer imp_iva_adq_visa_mds) {
		this.imp_iva_adq_visa_mds = imp_iva_adq_visa_mds;
	}

	public String getClave_negocio() {
		return clave_negocio;
	}

	public void setClave_negocio(String clave_negocio) {
		this.clave_negocio = clave_negocio;
	}

	public Integer getImp_neto_mds1_atm() {
		return imp_neto_mds1_atm;
	}

	public void setImp_neto_mds1_atm(Integer imp_neto_mds1_atm) {
		this.imp_neto_mds1_atm = imp_neto_mds1_atm;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getClave_proceso() {
		return clave_proceso;
	}

	public void setClave_proceso(String clave_proceso) {
		this.clave_proceso = clave_proceso;
	}

	public Integer getDescuento_adicional_pago() {
		return descuento_adicional_pago;
	}

	public void setDescuento_adicional_pago(Integer descuento_adicional_pago) {
		this.descuento_adicional_pago = descuento_adicional_pago;
	}

	public Integer getImporte_iva_adq() {
		return importe_iva_adq;
	}

	public void setImporte_iva_adq(Integer importe_iva_adq) {
		this.importe_iva_adq = importe_iva_adq;
	}

	public Integer getImp_total_emi_visa_mds() {
		return imp_total_emi_visa_mds;
	}

	public void setImp_total_emi_visa_mds(Integer imp_total_emi_visa_mds) {
		this.imp_total_emi_visa_mds = imp_total_emi_visa_mds;
	}

	public Integer getImp_total_emi_bnmx() {
		return imp_total_emi_bnmx;
	}

	public void setImp_total_emi_bnmx(Integer imp_total_emi_bnmx) {
		this.imp_total_emi_bnmx = imp_total_emi_bnmx;
	}

	public Integer getImporte_iva_emi() {
		return importe_iva_emi;
	}

	public void setImporte_iva_emi(Integer importe_iva_emi) {
		this.importe_iva_emi = importe_iva_emi;
	}

	public Integer getImp_neto_adq_mds() {
		return imp_neto_adq_mds;
	}

	public void setImp_neto_adq_mds(Integer imp_neto_adq_mds) {
		this.imp_neto_adq_mds = imp_neto_adq_mds;
	}

	public Integer getId_moneda() {
		return id_moneda;
	}

	public void setId_moneda(Integer id_moneda) {
		this.id_moneda = id_moneda;
	}

	public Integer getImporte_neto_emi_pago() {
		return importe_neto_emi_pago;
	}

	public void setImporte_neto_emi_pago(Integer importe_neto_emi_pago) {
		this.importe_neto_emi_pago = importe_neto_emi_pago;
	}

	public Integer getImporte_descuento_pago() {
		return importe_descuento_pago;
	}

	public void setImporte_descuento_pago(Integer importe_descuento_pago) {
		this.importe_descuento_pago = importe_descuento_pago;
	}

	public Integer getImporte_total() {
		return importe_total;
	}

	public void setImporte_total(Integer importe_total) {
		this.importe_total = importe_total;
	}

	public Integer getImp_total_emi_bsoc_eglo() {
		return imp_total_emi_bsoc_eglo;
	}

	public void setImp_total_emi_bsoc_eglo(Integer imp_total_emi_bsoc_eglo) {
		this.imp_total_emi_bsoc_eglo = imp_total_emi_bsoc_eglo;
	}

	public Number getId_negocio() {
		return id_negocio;
	}

	public void setId_negocio(Number id_negocio) {
		this.id_negocio = id_negocio;
	}

	public Date getFecha_cobro() {
		return fecha_cobro;
	}

	public void setFecha_cobro(Date fecha_cobro) {
		this.fecha_cobro = fecha_cobro;
	}

	public Integer getImp_neto_eglo_atm() {
		return imp_neto_eglo_atm;
	}

	public void setImp_neto_eglo_atm(Integer imp_neto_eglo_atm) {
		this.imp_neto_eglo_atm = imp_neto_eglo_atm;
	}

	public Integer getImp_iva_upay_atm() {
		return imp_iva_upay_atm;
	}

	public void setImp_iva_upay_atm(Integer imp_iva_upay_atm) {
		this.imp_iva_upay_atm = imp_iva_upay_atm;
	}

	public Integer getImp_neto_upay_atm() {
		return imp_neto_upay_atm;
	}

	public void setImp_neto_upay_atm(Integer imp_neto_upay_atm) {
		this.imp_neto_upay_atm = imp_neto_upay_atm;
	}

	public Integer getImporte_iva_adq_pago() {
		return importe_iva_adq_pago;
	}

	public void setImporte_iva_adq_pago(Integer importe_iva_adq_pago) {
		this.importe_iva_adq_pago = importe_iva_adq_pago;
	}

	public String getClave_servicio() {
		return clave_servicio;
	}

	public void setClave_servicio(String clave_servicio) {
		this.clave_servicio = clave_servicio;
	}

	public Integer getImporte_neto_adq_pago() {
		return importe_neto_adq_pago;
	}

	public void setImporte_neto_adq_pago(Integer importe_neto_adq_pago) {
		this.importe_neto_adq_pago = importe_neto_adq_pago;
	}

	public Integer getImp_iva_mds1_atm() {
		return imp_iva_mds1_atm;
	}

	public void setImp_iva_mds1_atm(Integer imp_iva_mds1_atm) {
		this.imp_iva_mds1_atm = imp_iva_mds1_atm;
	}

	public Integer getImporte_cobranza_pago() {
		return importe_cobranza_pago;
	}

	public void setImporte_cobranza_pago(Integer importe_cobranza_pago) {
		this.importe_cobranza_pago = importe_cobranza_pago;
	}

	public Integer getImp_total_adq_visa_mds() {
		return imp_total_adq_visa_mds;
	}

	public void setImp_total_adq_visa_mds(Integer imp_total_adq_visa_mds) {
		this.imp_total_adq_visa_mds = imp_total_adq_visa_mds;
	}

	public Integer getImp_total_mds1_atm() {
		return imp_total_mds1_atm;
	}

	public void setImp_total_mds1_atm(Integer imp_total_mds1_atm) {
		this.imp_total_mds1_atm = imp_total_mds1_atm;
	}

	public String getNumero_cuenta() {
		return numero_cuenta;
	}

	public void setNumero_cuenta(String numero_cuenta) {
		this.numero_cuenta = numero_cuenta;
	}

	public Integer getImp_neto_adq_visa_mds() {
		return imp_neto_adq_visa_mds;
	}

	public void setImp_neto_adq_visa_mds(Integer imp_neto_adq_visa_mds) {
		this.imp_neto_adq_visa_mds = imp_neto_adq_visa_mds;
	}

	public Integer getImp_total_eglo_atm() {
		return imp_total_eglo_atm;
	}

	public void setImp_total_eglo_atm(Integer imp_total_eglo_atm) {
		this.imp_total_eglo_atm = imp_total_eglo_atm;
	}

	public String getDescripcion_negocio() {
		return descripcion_negocio;
	}

	public void setDescripcion_negocio(String descripcion_negocio) {
		this.descripcion_negocio = descripcion_negocio;
	}

	public Number getId_servicios_facturar() {
		return id_servicios_facturar;
	}

	public void setId_servicios_facturar(Number id_servicios_facturar) {
		this.id_servicios_facturar = id_servicios_facturar;
	}

	public Integer getImp_neto_jcb1_atm() {
		return imp_neto_jcb1_atm;
	}

	public void setImp_neto_jcb1_atm(Integer imp_neto_jcb1_atm) {
		this.imp_neto_jcb1_atm = imp_neto_jcb1_atm;
	}

	public Integer getImp_iva_emi_visa_mds() {
		return imp_iva_emi_visa_mds;
	}

	public void setImp_iva_emi_visa_mds(Integer imp_iva_emi_visa_mds) {
		this.imp_iva_emi_visa_mds = imp_iva_emi_visa_mds;
	}

	public Integer getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(Integer id_empresa) {
		this.id_empresa = id_empresa;
	}

	public Date getFecha_registro_gl() {
		return fecha_registro_gl;
	}

	public void setFecha_registro_gl(Date fecha_registro_gl) {
		this.fecha_registro_gl = fecha_registro_gl;
	}

	public Integer getImp_total_jcb1_atm() {
		return imp_total_jcb1_atm;
	}

	public void setImp_total_jcb1_atm(Integer imp_total_jcb1_atm) {
		this.imp_total_jcb1_atm = imp_total_jcb1_atm;
	}

	public Integer getDescuento_adicional() {
		return descuento_adicional;
	}

	public void setDescuento_adicional(Integer descuento_adicional) {
		this.descuento_adicional = descuento_adicional;
	}

	public Integer getImporte_iva_emi_pago() {
		return importe_iva_emi_pago;
	}

	public void setImporte_iva_emi_pago(Integer importe_iva_emi_pago) {
		this.importe_iva_emi_pago = importe_iva_emi_pago;
	}

	public Integer getImporte_neto_adq() {
		return importe_neto_adq;
	}

	public void setImporte_neto_adq(Integer importe_neto_adq) {
		this.importe_neto_adq = importe_neto_adq;
	}

	public String getTipo_modelo_poliza() {
		return tipo_modelo_poliza;
	}

	public void setTipo_modelo_poliza(String tipo_modelo_poliza) {
		this.tipo_modelo_poliza = tipo_modelo_poliza;
	}

	public String getClave_empresa() {
		return clave_empresa;
	}

	public void setClave_empresa(String clave_empresa) {
		this.clave_empresa = clave_empresa;
	}

	public Integer getImporte_iva() {
		return importe_iva;
	}

	public void setImporte_iva(Integer importe_iva) {
		this.importe_iva = importe_iva;
	}

	public Integer getImp_total_adq_bsoc_eglo() {
		return imp_total_adq_bsoc_eglo;
	}

	public void setImp_total_adq_bsoc_eglo(Integer imp_total_adq_bsoc_eglo) {
		this.imp_total_adq_bsoc_eglo = imp_total_adq_bsoc_eglo;
	}

	public Integer getImporte_descuento() {
		return importe_descuento;
	}

	public void setImporte_descuento(Integer importe_descuento) {
		this.importe_descuento = importe_descuento;
	}

	public Integer getImporte_total_adq_pago() {
		return importe_total_adq_pago;
	}

	public void setImporte_total_adq_pago(Integer importe_total_adq_pago) {
		this.importe_total_adq_pago = importe_total_adq_pago;
	}

	public Integer getNumero_modelo_registro() {
		return numero_modelo_registro;
	}

	public void setNumero_modelo_registro(Integer numero_modelo_registro) {
		this.numero_modelo_registro = numero_modelo_registro;
	}

	public Integer getImporte_total_emi_pago() {
		return importe_total_emi_pago;
	}

	public void setImporte_total_emi_pago(Integer importe_total_emi_pago) {
		this.importe_total_emi_pago = importe_total_emi_pago;
	}

	public Integer getImp_neto_adq_visa1() {
		return imp_neto_adq_visa1;
	}

	public void setImp_neto_adq_visa1(Integer imp_neto_adq_visa1) {
		this.imp_neto_adq_visa1 = imp_neto_adq_visa1;
	}

	public String getNumero_cuenta_default() {
		return numero_cuenta_default;
	}

	public void setNumero_cuenta_default(String numero_cuenta_default) {
		this.numero_cuenta_default = numero_cuenta_default;
	}

	public Integer getImporte_neto_pago() {
		return importe_neto_pago;
	}

	public void setImporte_neto_pago(Integer importe_neto_pago) {
		this.importe_neto_pago = importe_neto_pago;
	}

	public String getNombre_moneda() {
		return nombre_moneda;
	}

	public void setNombre_moneda(String nombre_moneda) {
		this.nombre_moneda = nombre_moneda;
	}
	
}
