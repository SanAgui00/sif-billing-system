/**
################################################################################
# Autor               : Valverde Méndez Arturo                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 25/04/2018 #
# Descripcion General : POJO para reporte Tesorería                            #
# Marca del cambio    :                                                        #
#------------------------------------------------------------------------------#
# Numero de Parametros: N/A                                                    #
# Parametros Entrada  : N/A                                  Formato:          #
# Parametros Salida   : N/A                                  Formato:          #
################################################################################
**/

package com.prosa.sif.pojo;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VIEW_REPORTE_TESORERIA")
public class ViewReporteTesoreria {

	private BigDecimal id_moneda;
	private String interfase;
	private BigDecimal id_cliente;
	private BigDecimal id_negocio;
	private BigDecimal id_proceso;
	private BigDecimal id_empresa;
	private Date fecha_datos_ini;
	private Date fecha_datos_fin;
	private String nombre_corto;
	private String sistema_cobro;
	private String folio_temporal;
	private Date fecha_envio;
	private Date fecha_cobro;
	private Date fecha_cobro2;
	private String estatus;
	private Date fecha_referencia;
	private String descripcion_cobros;
	private BigDecimal importe_de_cargo;
	private BigDecimal iva_de_cargo;
	private BigDecimal total_de_cargo;
	private BigDecimal importe_de_abono;
	private BigDecimal iva_de_abono;
	private BigDecimal total_de_abono;
	@Id
	private BigDecimal id_vista;
	private String razon_social;

	public ViewReporteTesoreria() {

	}

	public ViewReporteTesoreria(BigDecimal id_moneda, String interfase, BigDecimal id_cliente, BigDecimal id_negocio,
			BigDecimal id_proceso, BigDecimal id_empresa, Date fecha_datos_ini, Date fecha_datos_fin,
			String nombre_corto, String sistema_cobro, String folio_temporal, Date fecha_envio, Date fecha_cobro,
			Date fecha_cobro2, String estatus, Date fecha_referencia, String descripcion_cobros,
			BigDecimal importe_de_cargo, BigDecimal iva_de_cargo, BigDecimal total_de_cargo,
			BigDecimal importe_de_abono, BigDecimal iva_de_abono, BigDecimal total_de_abono, BigDecimal id_vista,
			String razon_social) {
		super();
		this.id_moneda = id_moneda;
		this.interfase = interfase;
		this.id_cliente = id_cliente;
		this.id_negocio = id_negocio;
		this.id_proceso = id_proceso;
		this.id_empresa = id_empresa;
		this.fecha_datos_ini = fecha_datos_ini;
		this.fecha_datos_fin = fecha_datos_fin;
		this.nombre_corto = nombre_corto;
		this.sistema_cobro = sistema_cobro;
		this.folio_temporal = folio_temporal;
		this.fecha_envio = fecha_envio;
		this.fecha_cobro = fecha_cobro;
		this.fecha_cobro2 = fecha_cobro2;
		this.estatus = estatus;
		this.fecha_referencia = fecha_referencia;
		this.descripcion_cobros = descripcion_cobros;
		this.importe_de_cargo = importe_de_cargo;
		this.iva_de_cargo = iva_de_cargo;
		this.total_de_cargo = total_de_cargo;
		this.importe_de_abono = importe_de_abono;
		this.iva_de_abono = iva_de_abono;
		this.total_de_abono = total_de_abono;
		this.id_vista = id_vista;
		this.razon_social = razon_social;
	}

	public BigDecimal getId_moneda() {
		return id_moneda;
	}

	public void setId_moneda(BigDecimal id_moneda) {
		this.id_moneda = id_moneda;
	}

	public String getInterfase() {
		return interfase;
	}

	public void setInterfase(String interfase) {
		this.interfase = interfase;
	}

	public BigDecimal getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(BigDecimal id_cliente) {
		this.id_cliente = id_cliente;
	}

	public BigDecimal getId_negocio() {
		return id_negocio;
	}

	public void setId_negocio(BigDecimal id_negocio) {
		this.id_negocio = id_negocio;
	}

	public BigDecimal getId_proceso() {
		return id_proceso;
	}

	public void setId_proceso(BigDecimal id_proceso) {
		this.id_proceso = id_proceso;
	}

	public BigDecimal getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(BigDecimal id_empresa) {
		this.id_empresa = id_empresa;
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

	public String getNombre_corto() {
		return nombre_corto;
	}

	public void setNombre_corto(String nombre_corto) {
		this.nombre_corto = nombre_corto;
	}

	public String getSistema_cobro() {
		return sistema_cobro;
	}

	public void setSistema_cobro(String sistema_cobro) {
		this.sistema_cobro = sistema_cobro;
	}

	public String getFolio_temporal() {
		return folio_temporal;
	}

	public void setFolio_temporal(String folio_temporal) {
		this.folio_temporal = folio_temporal;
	}

	public Date getFecha_envio() {
		return fecha_envio;
	}

	public void setFecha_envio(Date fecha_envio) {
		this.fecha_envio = fecha_envio;
	}

	public Date getFecha_cobro() {
		return fecha_cobro;
	}

	public void setFecha_cobro(Date fecha_cobro) {
		this.fecha_cobro = fecha_cobro;
	}

	public Date getFecha_cobro2() {
		return fecha_cobro2;
	}

	public void setFecha_cobro2(Date fecha_cobro2) {
		this.fecha_cobro2 = fecha_cobro2;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Date getFecha_referencia() {
		return fecha_referencia;
	}

	public void setFecha_referencia(Date fecha_referencia) {
		this.fecha_referencia = fecha_referencia;
	}

	public String getDescripcion_cobros() {
		return descripcion_cobros;
	}

	public void setDescripcion_cobros(String descripcion_cobros) {
		this.descripcion_cobros = descripcion_cobros;
	}

	public BigDecimal getImporte_de_cargo() {
		return importe_de_cargo;
	}

	public void setImporte_de_cargo(BigDecimal importe_de_cargo) {
		this.importe_de_cargo = importe_de_cargo;
	}

	public BigDecimal getIva_de_cargo() {
		return iva_de_cargo;
	}

	public void setIva_de_cargo(BigDecimal iva_de_cargo) {
		this.iva_de_cargo = iva_de_cargo;
	}

	public BigDecimal getTotal_de_cargo() {
		return total_de_cargo;
	}

	public void setTotal_de_cargo(BigDecimal total_de_cargo) {
		this.total_de_cargo = total_de_cargo;
	}

	public BigDecimal getImporte_de_abono() {
		return importe_de_abono;
	}

	public void setImporte_de_abono(BigDecimal importe_de_abono) {
		this.importe_de_abono = importe_de_abono;
	}

	public BigDecimal getIva_de_abono() {
		return iva_de_abono;
	}

	public void setIva_de_abono(BigDecimal iva_de_abono) {
		this.iva_de_abono = iva_de_abono;
	}

	public BigDecimal getTotal_de_abono() {
		return total_de_abono;
	}

	public void setTotal_de_abono(BigDecimal total_de_abono) {
		this.total_de_abono = total_de_abono;
	}

	public BigDecimal getId_vista() {
		return id_vista;
	}

	public void setId_vista(BigDecimal id_vista) {
		this.id_vista = id_vista;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	@Override
	public String toString() {
		return "VIEW_REPORTE_TESORERIA [id_moneda=" + id_moneda + ", interfase=" + interfase + ", id_cliente="
				+ id_cliente + ", id_negocio=" + id_negocio + ", id_proceso=" + id_proceso + ", id_empresa="
				+ id_empresa + ", fecha_datos_ini=" + fecha_datos_ini + ", fecha_datos_fin=" + fecha_datos_fin
				+ ", nombre_corto=" + nombre_corto + ", sistema_cobro=" + sistema_cobro + ", folio_temporal="
				+ folio_temporal + ", fecha_envio=" + fecha_envio + ", fecha_cobro=" + fecha_cobro + ", fecha_cobro2="
				+ fecha_cobro2 + ", estatus=" + estatus + ", fecha_referencia=" + fecha_referencia
				+ ", descripcion_cobros=" + descripcion_cobros + ", importe_de_cargo=" + importe_de_cargo
				+ ", iva_de_cargo=" + iva_de_cargo + ", total_de_cargo=" + total_de_cargo + ", importe_de_abono="
				+ importe_de_abono + ", iva_de_abono=" + iva_de_abono + ", total_de_abono=" + total_de_abono
				+ ", id_vista=" + id_vista + ", razon_social=" + razon_social + "]";
	}

}
