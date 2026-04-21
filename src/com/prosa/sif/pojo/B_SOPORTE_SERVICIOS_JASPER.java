/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 24/08/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.pojo;

import java.math.BigDecimal;

public class B_SOPORTE_SERVICIOS_JASPER {

	private String CV_NEGOCIO;
	private String DC_NEGOCIO;
	private String BANCO;
	private String NOMBRE_CORTO;
	private String SERVICIO;
	private String DESCRIPCION;
	private BigDecimal MT_DISPENSADO_DLS;
	private BigDecimal MT_DISPENSADO_PS;
	private BigDecimal MT_CROSSBORDER_DLS;
	private BigDecimal TIPO_CAMBIO;
	private BigDecimal MT_CROSSBORDER_PS;
	private BigDecimal IVA;
	private BigDecimal TOTAL;

	public B_SOPORTE_SERVICIOS_JASPER() {

	}

	public B_SOPORTE_SERVICIOS_JASPER(String cV_NEGOCIO, String dC_NEGOCIO, String bANCO, String nOMBRE_CORTO,
			String sERVICIO, String dESCRIPCION, BigDecimal mT_DISPENSADO_DLS, BigDecimal mT_DISPENSADO_PS,
			BigDecimal mT_CROSSBORDER_DLS, BigDecimal tIPO_CAMBIO, BigDecimal mT_CROSSBORDER_PS, BigDecimal iVA,
			BigDecimal tOTAL) {
		super();
		CV_NEGOCIO = cV_NEGOCIO;
		DC_NEGOCIO = dC_NEGOCIO;
		BANCO = bANCO;
		NOMBRE_CORTO = nOMBRE_CORTO;
		SERVICIO = sERVICIO;
		DESCRIPCION = dESCRIPCION;
		MT_DISPENSADO_DLS = mT_DISPENSADO_DLS;
		MT_DISPENSADO_PS = mT_DISPENSADO_PS;
		MT_CROSSBORDER_DLS = mT_CROSSBORDER_DLS;
		TIPO_CAMBIO = tIPO_CAMBIO;
		MT_CROSSBORDER_PS = mT_CROSSBORDER_PS;
		IVA = iVA;
		TOTAL = tOTAL;
	}

	public String getCV_NEGOCIO() {
		return CV_NEGOCIO;
	}

	public void setCV_NEGOCIO(String cV_NEGOCIO) {
		CV_NEGOCIO = cV_NEGOCIO;
	}

	public String getDC_NEGOCIO() {
		return DC_NEGOCIO;
	}

	public void setDC_NEGOCIO(String dC_NEGOCIO) {
		DC_NEGOCIO = dC_NEGOCIO;
	}

	public String getBANCO() {
		return BANCO;
	}

	public void setBANCO(String bANCO) {
		BANCO = bANCO;
	}

	public String getNOMBRE_CORTO() {
		return NOMBRE_CORTO;
	}

	public void setNOMBRE_CORTO(String nOMBRE_CORTO) {
		NOMBRE_CORTO = nOMBRE_CORTO;
	}

	public String getSERVICIO() {
		return SERVICIO;
	}

	public void setSERVICIO(String sERVICIO) {
		SERVICIO = sERVICIO;
	}

	public String getDESCRIPCION() {
		return DESCRIPCION;
	}

	public void setDESCRIPCION(String dESCRIPCION) {
		DESCRIPCION = dESCRIPCION;
	}

	public BigDecimal getMT_DISPENSADO_DLS() {
		return MT_DISPENSADO_DLS;
	}

	public void setMT_DISPENSADO_DLS(BigDecimal mT_DISPENSADO_DLS) {
		MT_DISPENSADO_DLS = mT_DISPENSADO_DLS;
	}

	public BigDecimal getMT_DISPENSADO_PS() {
		return MT_DISPENSADO_PS;
	}

	public void setMT_DISPENSADO_PS(BigDecimal mT_DISPENSADO_PS) {
		MT_DISPENSADO_PS = mT_DISPENSADO_PS;
	}

	public BigDecimal getMT_CROSSBORDER_DLS() {
		return MT_CROSSBORDER_DLS;
	}

	public void setMT_CROSSBORDER_DLS(BigDecimal mT_CROSSBORDER_DLS) {
		MT_CROSSBORDER_DLS = mT_CROSSBORDER_DLS;
	}

	public BigDecimal getTIPO_CAMBIO() {
		return TIPO_CAMBIO;
	}

	public void setTIPO_CAMBIO(BigDecimal tIPO_CAMBIO) {
		TIPO_CAMBIO = tIPO_CAMBIO;
	}

	public BigDecimal getMT_CROSSBORDER_PS() {
		return MT_CROSSBORDER_PS;
	}

	public void setMT_CROSSBORDER_PS(BigDecimal mT_CROSSBORDER_PS) {
		MT_CROSSBORDER_PS = mT_CROSSBORDER_PS;
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

	@Override
	public String toString() {
		return "B_SOPORTE_SERVICIOS_JASPER [CV_NEGOCIO=" + CV_NEGOCIO + ", DC_NEGOCIO=" + DC_NEGOCIO + ", BANCO="
				+ BANCO + ", NOMBRE_CORTO=" + NOMBRE_CORTO + ", SERVICIO=" + SERVICIO + ", DESCRIPCION=" + DESCRIPCION
				+ ", MT_DISPENSADO_DLS=" + MT_DISPENSADO_DLS + ", MT_DISPENSADO_PS=" + MT_DISPENSADO_PS
				+ ", MT_CROSSBORDER_DLS=" + MT_CROSSBORDER_DLS + ", TIPO_CAMBIO=" + TIPO_CAMBIO + ", MT_CROSSBORDER_PS="
				+ MT_CROSSBORDER_PS + ", IVA=" + IVA + ", TOTAL=" + TOTAL + "]";
	}

}
