/**
################################################################################
# Autor               : Garnica                                                #
# Compania            : Código Geek                                            #
# Proyecto/Procliente : Bean de Estado Cobranza              Fecha: 08/03/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/
package com.prosa.sif.pojo;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 
 * @author David Garnica Garcia
 *
 */
public class BeanEstadoCobranza {
	private String cv_banco;
	private String nm_banco;
	private String cv_negocio;
	private String nm_negocio;
	private Date fecha_datos;
	private Date fecha_cobro;
	private String cv_servicio;
	private String nm_servicio;
	private Number cv_moneda;
	private String nm_moneda;
	private Number tipo_cambio;
	private BigDecimal TRX;
	private BigDecimal IMPORTE;
	private BigDecimal DESCUENTO;
	private BigDecimal DESCUENTO_ADICIONAL;
	private BigDecimal IVA;
	private BigDecimal TOTAL;

	public BeanEstadoCobranza() {

	}

	public BeanEstadoCobranza(String cv_banco, String nm_banco, String cv_negocio, String nm_negocio, Date fecha_datos,
			Date fecha_cobro, String cv_servicio, String nm_servicio, Number cv_moneda, String nm_moneda,
			Number tipo_cambio, BigDecimal tRX, BigDecimal iMPORTE, BigDecimal dESCUENTO,
			BigDecimal dESCUENTO_ADICIONAL, BigDecimal iVA, BigDecimal tOTAL) {
		super();
		this.cv_banco = cv_banco;
		this.nm_banco = nm_banco;
		this.cv_negocio = cv_negocio;
		this.nm_negocio = nm_negocio;
		this.fecha_datos = fecha_datos;
		this.fecha_cobro = fecha_cobro;
		this.cv_servicio = cv_servicio;
		this.nm_servicio = nm_servicio;
		this.cv_moneda = cv_moneda;
		this.nm_moneda = nm_moneda;
		this.tipo_cambio = tipo_cambio;
		TRX = tRX;
		IMPORTE = iMPORTE;
		DESCUENTO = dESCUENTO;
		DESCUENTO_ADICIONAL = dESCUENTO_ADICIONAL;
		IVA = iVA;
		TOTAL = tOTAL;
	}

	public String getCv_banco() {
		return cv_banco;
	}

	public void setCv_banco(String cv_banco) {
		this.cv_banco = cv_banco;
	}

	public String getNm_banco() {
		return nm_banco;
	}

	public void setNm_banco(String nm_banco) {
		this.nm_banco = nm_banco;
	}

	public String getCv_negocio() {
		return cv_negocio;
	}

	public void setCv_negocio(String cv_negocio) {
		this.cv_negocio = cv_negocio;
	}

	public String getNm_negocio() {
		return nm_negocio;
	}

	public void setNm_negocio(String nm_negocio) {
		this.nm_negocio = nm_negocio;
	}

	public Date getFecha_datos() {
		return fecha_datos;
	}

	public void setFecha_datos(Date fecha_datos) {
		this.fecha_datos = fecha_datos;
	}

	public Date getFecha_cobro() {
		return fecha_cobro;
	}

	public void setFecha_cobro(Date fecha_cobro) {
		this.fecha_cobro = fecha_cobro;
	}

	public String getCv_servicio() {
		return cv_servicio;
	}

	public void setCv_servicio(String cv_servicio) {
		this.cv_servicio = cv_servicio;
	}

	public String getNm_servicio() {
		return nm_servicio;
	}

	public void setNm_servicio(String nm_servicio) {
		this.nm_servicio = nm_servicio;
	}

	public Number getCv_moneda() {
		return cv_moneda;
	}

	public void setCv_moneda(Number cv_moneda) {
		this.cv_moneda = cv_moneda;
	}

	public String getNm_moneda() {
		return nm_moneda;
	}

	public void setNm_moneda(String nm_moneda) {
		this.nm_moneda = nm_moneda;
	}

	public Number getTipo_cambio() {
		return tipo_cambio;
	}

	public void setTipo_cambio(Number tipo_cambio) {
		this.tipo_cambio = tipo_cambio;
	}

	public BigDecimal getTRX() {
		return TRX;
	}

	public void setTRX(BigDecimal tRX) {
		TRX = tRX;
	}

	public BigDecimal getIMPORTE() {
		return IMPORTE;
	}

	public void setIMPORTE(BigDecimal iMPORTE) {
		IMPORTE = iMPORTE;
	}

	public BigDecimal getDESCUENTO() {
		return DESCUENTO;
	}

	public void setDESCUENTO(BigDecimal dESCUENTO) {
		DESCUENTO = dESCUENTO;
	}

	public BigDecimal getDESCUENTO_ADICIONAL() {
		return DESCUENTO_ADICIONAL;
	}

	public void setDESCUENTO_ADICIONAL(BigDecimal dESCUENTO_ADICIONAL) {
		DESCUENTO_ADICIONAL = dESCUENTO_ADICIONAL;
	}

	public BigDecimal getIVA() {
		return IVA;
	}

	public void setIVA(BigDecimal iVA) {
		IVA = iVA;
	}

	public BigDecimal getTOTAL() {
		return TOTAL;
	}

	public void setTOTAL(BigDecimal tOTAL) {
		TOTAL = tOTAL;
	}
	


}
