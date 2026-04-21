package com.prosa.sif.pojo;

import java.util.Date;

public class BeanCobrosFinancieros {
	private Number id_cobro;
	private Number id_cliente; 
	private Number id_negocio;
	private Number id_moneda_cobro;
	private String sistema_cobro;
	private String tipo_documento;
	private String folio_temporal;
	private Date fecha_datos_ini;
	private Date fecha_datos_fin;
	private String descripcion;
	private Number importe_costo;
	private Number importe_iva; 
	private Number tipo_cambio;
	private String clave_externa_cliente;
	private Number id_gen_sistema_cobro;
	private String estatus; 
	private String usuario; 
	private Date fecha_envio;
	private Date fecha_mod;
	private Date fecha_cre;
	private Date fecha_cobr; 
	private String observacion;
	private String estatus_cfdi;
	private String clave_cliente;
	private String nombre_corto;
	private Number importe;
	
	public BeanCobrosFinancieros() {
		
	}

	public BeanCobrosFinancieros(Number id_cobro, Number id_cliente, Number id_negocio, Number id_moneda_cobro,
			String sistema_cobro, String tipo_documento, String folio_temporal, Date fecha_datos_ini,
			Date fecha_datos_fin, String descripcion, Number importe_costo, Number importe_iva, Number tipo_cambio,
			String clave_externa_cliente, Number id_gen_sistema_cobro, String estatus, String usuario, Date fecha_envio,
			Date fecha_mod, Date fecha_cre, Date fecha_cobr, String observacion, String estatus_cfdi,
			String clave_cliente, String nombre_corto, Number importe) {
		super();
		this.id_cobro = id_cobro;
		this.id_cliente = id_cliente;
		this.id_negocio = id_negocio;
		this.id_moneda_cobro = id_moneda_cobro;
		this.sistema_cobro = sistema_cobro;
		this.tipo_documento = tipo_documento;
		this.folio_temporal = folio_temporal;
		this.fecha_datos_ini = fecha_datos_ini;
		this.fecha_datos_fin = fecha_datos_fin;
		this.descripcion = descripcion;
		this.importe_costo = importe_costo;
		this.importe_iva = importe_iva;
		this.tipo_cambio = tipo_cambio;
		this.clave_externa_cliente = clave_externa_cliente;
		this.id_gen_sistema_cobro = id_gen_sistema_cobro;
		this.estatus = estatus;
		this.usuario = usuario;
		this.fecha_envio = fecha_envio;
		this.fecha_mod = fecha_mod;
		this.fecha_cre = fecha_cre;
		this.fecha_cobr = fecha_cobr;
		this.observacion = observacion;
		this.estatus_cfdi = estatus_cfdi;
		this.clave_cliente = clave_cliente;
		this.nombre_corto = nombre_corto;
		this.importe = importe;
	}

	public Number getId_cobro() {
		return id_cobro;
	}

	public void setId_cobro(Number id_cobro) {
		this.id_cobro = id_cobro;
	}

	public Number getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Number id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Number getId_negocio() {
		return id_negocio;
	}

	public void setId_negocio(Number id_negocio) {
		this.id_negocio = id_negocio;
	}

	public Number getId_moneda_cobro() {
		return id_moneda_cobro;
	}

	public void setId_moneda_cobro(Number id_moneda_cobro) {
		this.id_moneda_cobro = id_moneda_cobro;
	}

	public String getSistema_cobro() {
		return sistema_cobro;
	}

	public void setSistema_cobro(String sistema_cobro) {
		this.sistema_cobro = sistema_cobro;
	}

	public String getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public String getFolio_temporal() {
		return folio_temporal;
	}

	public void setFolio_temporal(String folio_temporal) {
		this.folio_temporal = folio_temporal;
	}

	public Date getFecha_datos_ini() {
		return fecha_datos_ini;
	}

	public void setFecha_datos_ini(Date fecha_datos_ini) {
		this.fecha_datos_ini = fecha_datos_ini;
	}

	public Date getFecha_datos_fin() {
		return fecha_datos_fin;
	}

	public void setFecha_datos_fin(Date fecha_datos_fin) {
		this.fecha_datos_fin = fecha_datos_fin;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Number getImporte_costo() {
		return importe_costo;
	}

	public void setImporte_costo(Number importe_costo) {
		this.importe_costo = importe_costo;
	}

	public Number getImporte_iva() {
		return importe_iva;
	}

	public void setImporte_iva(Number importe_iva) {
		this.importe_iva = importe_iva;
	}

	public Number getTipo_cambio() {
		return tipo_cambio;
	}

	public void setTipo_cambio(Number tipo_cambio) {
		this.tipo_cambio = tipo_cambio;
	}

	public String getClave_externa_cliente() {
		return clave_externa_cliente;
	}

	public void setClave_externa_cliente(String clave_externa_cliente) {
		this.clave_externa_cliente = clave_externa_cliente;
	}

	public Number getId_gen_sistema_cobro() {
		return id_gen_sistema_cobro;
	}

	public void setId_gen_sistema_cobro(Number id_gen_sistema_cobro) {
		this.id_gen_sistema_cobro = id_gen_sistema_cobro;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getFecha_envio() {
		return fecha_envio;
	}

	public void setFecha_envio(Date fecha_envio) {
		this.fecha_envio = fecha_envio;
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

	public Date getFecha_cobr() {
		return fecha_cobr;
	}

	public void setFecha_cobr(Date fecha_cobr) {
		this.fecha_cobr = fecha_cobr;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getEstatus_cfdi() {
		return estatus_cfdi;
	}

	public void setEstatus_cfdi(String estatus_cfdi) {
		this.estatus_cfdi = estatus_cfdi;
	}

	public String getClave_cliente() {
		return clave_cliente;
	}

	public void setClave_cliente(String clave_cliente) {
		this.clave_cliente = clave_cliente;
	}

	public String getNombre_corto() {
		return nombre_corto;
	}

	public void setNombre_corto(String nombre_corto) {
		this.nombre_corto = nombre_corto;
	}

	public Number getImporte() {
		return importe;
	}

	public void setImporte(Number importe) {
		this.importe = importe;
	}

	@Override
	public String toString() {
		return "BeanCobrosFinancieros [id_cobro=" + id_cobro + ", id_cliente=" + id_cliente + ", id_negocio="
				+ id_negocio + ", id_moneda_cobro=" + id_moneda_cobro + ", sistema_cobro=" + sistema_cobro
				+ ", tipo_documento=" + tipo_documento + ", folio_temporal=" + folio_temporal + ", fecha_datos_ini="
				+ fecha_datos_ini + ", fecha_datos_fin=" + fecha_datos_fin + ", descripcion=" + descripcion
				+ ", importe_costo=" + importe_costo + ", importe_iva=" + importe_iva + ", tipo_cambio=" + tipo_cambio
				+ ", clave_externa_cliente=" + clave_externa_cliente + ", id_gen_sistema_cobro=" + id_gen_sistema_cobro
				+ ", estatus=" + estatus + ", usuario=" + usuario + ", fecha_envio=" + fecha_envio + ", fecha_mod="
				+ fecha_mod + ", fecha_cre=" + fecha_cre + ", fecha_cobr=" + fecha_cobr + ", observacion=" + observacion
				+ ", estatus_cfdi=" + estatus_cfdi + ", clave_cliente=" + clave_cliente + ", nombre_corto="
				+ nombre_corto + ", importe=" + importe + "]";
	}
	
}
