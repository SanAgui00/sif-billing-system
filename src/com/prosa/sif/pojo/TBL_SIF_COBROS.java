package com.prosa.sif.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "TBL_SIF_COBROS")
public class TBL_SIF_COBROS {
	@Id
	private Integer id_cobro; 
	private Integer id_cliente; 
	private Integer id_negocio ; 
	private Integer id_moneda_cobro; 
	private String sistema_cobro; 
	private String tipo_documento; 
	private String folio_temporal; 
	private Date fecha_datos_ini; 
	private Date fecha_datos_fin; 
	private String descripcion; 
	private Integer importe_costo; 
	private Integer importe_iva ; 
	private Integer tipo_cambio; 
	private String clave_externa_cliente; 
	private Integer id_gen_sistema_cobro; 
	private String estatus; 
	private String usuario; 
	private Date fecha_envio; 
	private Date fecha_mod ; 
	private Date fecha_cre ; 
	private Date fecha_cobro; 
	private String observacion; 
	private String estatus_cfdi;
	public TBL_SIF_COBROS (){
		
	}
	public TBL_SIF_COBROS(Integer id_cobro, Integer id_cliente, Integer id_negocio, Integer id_moneda_cobro,
			String sistema_cobro, String tipo_documento, String folio_temporal, Date fecha_datos_ini,
			Date fecha_datos_fin, String descripcion, Integer importe_costo, Integer importe_iva, Integer tipo_cambio,
			String clave_externa_cliente, Integer id_gen_sistema_cobro, String estatus, String usuario, Date fecha_envio,
			Date fecha_mod, Date fecha_cre, Date fecha_cobro, String observacion, String estatus_cfdi) {
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
		this.fecha_cobro = fecha_cobro;
		this.observacion = observacion;
		this.estatus_cfdi = estatus_cfdi;
	}
	public Integer getId_cobro() {
		return id_cobro;
	}
	public void setId_cobro(Integer id_cobro) {
		this.id_cobro = id_cobro;
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
	public Integer getImporte_costo() {
		return importe_costo;
	}
	public void setImporte_costo(Integer importe_costo) {
		this.importe_costo = importe_costo;
	}
	public Integer getImporte_iva() {
		return importe_iva;
	}
	public void setImporte_iva(Integer importe_iva) {
		this.importe_iva = importe_iva;
	}
	public Integer getTipo_cambio() {
		return tipo_cambio;
	}
	public void setTipo_cambio(Integer tipo_cambio) {
		this.tipo_cambio = tipo_cambio;
	}
	public String getClave_externa_cliente() {
		return clave_externa_cliente;
	}
	public void setClave_externa_cliente(String clave_externa_cliente) {
		this.clave_externa_cliente = clave_externa_cliente;
	}
	public Integer getId_gen_sistema_cobro() {
		return id_gen_sistema_cobro;
	}
	public void setId_gen_sistema_cobro(Integer id_gen_sistema_cobro) {
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
	public Date getFecha_cobro() {
		return fecha_cobro;
	}
	public void setFecha_cobro(Date fecha_cobro) {
		this.fecha_cobro = fecha_cobro;
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
	
	
	@Override
	public String toString() {
		return "TBL_SIF_COBROS [id_cobro=" + id_cobro + ", id_cliente=" + id_cliente + ", id_negocio=" + id_negocio
				+ ", id_moneda_cobro=" + id_moneda_cobro + ", sistema_cobro=" + sistema_cobro + ", tipo_documento="
				+ tipo_documento + ", folio_temporal=" + folio_temporal + ", fecha_datos_ini=" + fecha_datos_ini
				+ ", fecha_datos_fin=" + fecha_datos_fin + ", descripcion=" + descripcion + ", importe_costo="
				+ importe_costo + ", importe_iva=" + importe_iva + ", tipo_cambio=" + tipo_cambio
				+ ", clave_externa_cliente=" + clave_externa_cliente + ", id_gen_sistema_cobro=" + id_gen_sistema_cobro
				+ ", estatus=" + estatus + ", usuario=" + usuario + ", fecha_envio=" + fecha_envio + ", fecha_mod="
				+ fecha_mod + ", fecha_cre=" + fecha_cre + ", fecha_cobro=" + fecha_cobro + ", observacion="
				+ observacion + ", estatus_cfdi=" + estatus_cfdi + "]";
	}
	
	
	
	
}
