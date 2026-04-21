/**
################################################################################
# Autor               : Valverde Méndez Arturo                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 25/04/2018 #
# Descripcion General : POJO para reporte Cuentas Activas                      #
# Marca del cambio    :                                                        #
#------------------------------------------------------------------------------#
# Numero de Parametros: N/A                                                    #
# Parametros Entrada  : N/A                                  Formato:          #
# Parametros Salida   : N/A                                  Formato:          #
################################################################################
**/

package com.prosa.sif.pojo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VIEW_REPORTE_CUENTAS_ACTIVAS")
public class ViewReporteCuentaActiva {

	@Id
	private BigDecimal id_vista;
	private BigDecimal trans_debito;
	private BigDecimal cuota_fija;
	private BigDecimal precio_debito;
	private BigDecimal precio_credito;
	private BigDecimal trans_credito;
	private BigDecimal total;
	private BigDecimal importe_credito;
	private BigDecimal importe_debito;
	private BigDecimal id_moneda;
	private BigDecimal id_periodo;
	private BigDecimal tipo_cambio;
	private String nombre_corto;
	private String nombre_p;

	public ViewReporteCuentaActiva() {

	}

	public ViewReporteCuentaActiva(BigDecimal id_vista, BigDecimal trans_debito, BigDecimal cuota_fija,
			BigDecimal precio_debito, BigDecimal precio_credito, BigDecimal trans_credito, BigDecimal total,
			BigDecimal importe_credito, BigDecimal importe_debito, BigDecimal id_moneda, BigDecimal id_periodo,
			BigDecimal tipo_cambio, String nombre_corto, String nombre_p) {
		super();
		this.id_vista = id_vista;
		this.trans_debito = trans_debito;
		this.cuota_fija = cuota_fija;
		this.precio_debito = precio_debito;
		this.precio_credito = precio_credito;
		this.trans_credito = trans_credito;
		this.total = total;
		this.importe_credito = importe_credito;
		this.importe_debito = importe_debito;
		this.id_moneda = id_moneda;
		this.id_periodo = id_periodo;
		this.tipo_cambio = tipo_cambio;
		this.nombre_corto = nombre_corto;
		this.nombre_p = nombre_p;
	}

	public BigDecimal getId_vista() {
		return id_vista;
	}

	public void setId_vista(BigDecimal id_vista) {
		this.id_vista = id_vista;
	}

	public BigDecimal getTrans_debito() {
		return trans_debito;
	}

	public void setTrans_debito(BigDecimal trans_debito) {
		this.trans_debito = trans_debito;
	}

	public BigDecimal getCuota_fija() {
		return cuota_fija;
	}

	public void setCuota_fija(BigDecimal cuota_fija) {
		this.cuota_fija = cuota_fija;
	}

	public BigDecimal getPrecio_debito() {
		return precio_debito;
	}

	public void setPrecio_debito(BigDecimal precio_debito) {
		this.precio_debito = precio_debito;
	}

	public BigDecimal getPrecio_credito() {
		return precio_credito;
	}

	public void setPrecio_credito(BigDecimal precio_credito) {
		this.precio_credito = precio_credito;
	}

	public BigDecimal getTrans_credito() {
		return trans_credito;
	}

	public void setTrans_credito(BigDecimal trans_credito) {
		this.trans_credito = trans_credito;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getImporte_credito() {
		return importe_credito;
	}

	public void setImporte_credito(BigDecimal importe_credito) {
		this.importe_credito = importe_credito;
	}

	public BigDecimal getImporte_debito() {
		return importe_debito;
	}

	public void setImporte_debito(BigDecimal importe_debito) {
		this.importe_debito = importe_debito;
	}

	public BigDecimal getId_moneda() {
		return id_moneda;
	}

	public void setId_moneda(BigDecimal id_moneda) {
		this.id_moneda = id_moneda;
	}

	public BigDecimal getId_periodo() {
		return id_periodo;
	}

	public void setId_periodo(BigDecimal id_periodo) {
		this.id_periodo = id_periodo;
	}

	public BigDecimal getTipo_cambio() {
		return tipo_cambio;
	}

	public void setTipo_cambio(BigDecimal tipo_cambio) {
		this.tipo_cambio = tipo_cambio;
	}

	public String getNombre_corto() {
		return nombre_corto;
	}

	public void setNombre_corto(String nombre_corto) {
		this.nombre_corto = nombre_corto;
	}

	public String getNombre_p() {
		return nombre_p;
	}

	public void setNombre_p(String nombre_p) {
		this.nombre_p = nombre_p;
	}

	@Override
	public String toString() {
		return "VIEW_REPORTE_CUENTAS_ACTIVAS [id_vista=" + id_vista + ", trans_debito=" + trans_debito + ", cuota_fija="
				+ cuota_fija + ", precio_debito=" + precio_debito + ", precio_credito=" + precio_credito
				+ ", trans_credito=" + trans_credito + ", total=" + total + ", importe_credito=" + importe_credito
				+ ", importe_debito=" + importe_debito + ", id_moneda=" + id_moneda + ", id_periodo=" + id_periodo
				+ ", tipo_cambio=" + tipo_cambio + ", nombre_corto=" + nombre_corto + ", nombre_p=" + nombre_p + "]";
	}

}
