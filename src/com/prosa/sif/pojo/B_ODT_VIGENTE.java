/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 10/07/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class B_ODT_VIGENTE {

	private BigDecimal NETO;
	private Date FECHA_DATOS;
	private BigDecimal TOTAL;
	private BigDecimal IVA;
	private BigDecimal IMPORTE;
	private BigDecimal NUMERO_ODT;
	private String DESCRIPCION;
	private String TIPO;
	private String CLAVE_NEGOCIO;
	private String CLAVE_CLIENTE;
	private String FOLIO;
	private String DESC_NEGOCIO;
	private String NOMBRE_CORTO;
	private String ESTATUS;

	public B_ODT_VIGENTE() {

	}

	public B_ODT_VIGENTE(BigDecimal nETO, Date fECHA_DATOS, BigDecimal tOTAL, BigDecimal iVA, BigDecimal iMPORTE,
			BigDecimal nUMERO_ODT, String dESCRIPCION, String tIPO, String cLAVE_NEGOCIO, String cLAVE_CLIENTE,
			String fOLIO, String dESC_NEGOCIO, String nOMBRE_CORTO, String eSTATUS) {
		super();
		NETO = nETO;
		FECHA_DATOS = fECHA_DATOS;
		TOTAL = tOTAL;
		IVA = iVA;
		IMPORTE = iMPORTE;
		NUMERO_ODT = nUMERO_ODT;
		DESCRIPCION = dESCRIPCION;
		TIPO = tIPO;
		CLAVE_NEGOCIO = cLAVE_NEGOCIO;
		CLAVE_CLIENTE = cLAVE_CLIENTE;
		FOLIO = fOLIO;
		DESC_NEGOCIO = dESC_NEGOCIO;
		NOMBRE_CORTO = nOMBRE_CORTO;
		ESTATUS = eSTATUS;
	}

	public BigDecimal getNETO() {
		return NETO;
	}

	public void setNETO(BigDecimal nETO) {
		NETO = nETO;
	}

	public Date getFECHA_DATOS() {
		return FECHA_DATOS;
	}

	public void setFECHA_DATOS(Date fECHA_DATOS) {
		FECHA_DATOS = fECHA_DATOS;
	}

	public BigDecimal getTOTAL() {
		return TOTAL;
	}

	public void setTOTAL(BigDecimal tOTAL) {
		TOTAL = tOTAL;
	}

	public BigDecimal getIVA() {
		return IVA;
	}

	public void setIVA(BigDecimal iVA) {
		IVA = iVA;
	}

	public BigDecimal getIMPORTE() {
		return IMPORTE;
	}

	public void setIMPORTE(BigDecimal iMPORTE) {
		IMPORTE = iMPORTE;
	}

	public BigDecimal getNUMERO_ODT() {
		return NUMERO_ODT;
	}

	public void setNUMERO_ODT(BigDecimal nUMERO_ODT) {
		NUMERO_ODT = nUMERO_ODT;
	}

	public String getDESCRIPCION() {
		return DESCRIPCION;
	}

	public void setDESCRIPCION(String dESCRIPCION) {
		DESCRIPCION = dESCRIPCION;
	}

	public String getTIPO() {
		return TIPO;
	}

	public void setTIPO(String tIPO) {
		TIPO = tIPO;
	}

	public String getCLAVE_NEGOCIO() {
		return CLAVE_NEGOCIO;
	}

	public void setCLAVE_NEGOCIO(String cLAVE_NEGOCIO) {
		CLAVE_NEGOCIO = cLAVE_NEGOCIO;
	}

	public String getCLAVE_CLIENTE() {
		return CLAVE_CLIENTE;
	}

	public void setCLAVE_CLIENTE(String cLAVE_CLIENTE) {
		CLAVE_CLIENTE = cLAVE_CLIENTE;
	}

	public String getFOLIO() {
		return FOLIO;
	}

	public void setFOLIO(String fOLIO) {
		FOLIO = fOLIO;
	}

	public String getDESC_NEGOCIO() {
		return DESC_NEGOCIO;
	}

	public void setDESC_NEGOCIO(String dESC_NEGOCIO) {
		DESC_NEGOCIO = dESC_NEGOCIO;
	}

	public String getNOMBRE_CORTO() {
		return NOMBRE_CORTO;
	}

	public void setNOMBRE_CORTO(String nOMBRE_CORTO) {
		NOMBRE_CORTO = nOMBRE_CORTO;
	}

	public String getESTATUS() {
		return ESTATUS;
	}

	public void setESTATUS(String eSTATUS) {
		ESTATUS = eSTATUS;
	}

	@Override
	public String toString() {
		return "B_ODT_VIGENTE [NETO=" + NETO + ", FECHA_DATOS=" + FECHA_DATOS + ", TOTAL=" + TOTAL + ", IVA=" + IVA
				+ ", IMPORTE=" + IMPORTE + ", NUMERO_ODT=" + NUMERO_ODT + ", DESCRIPCION=" + DESCRIPCION + ", TIPO="
				+ TIPO + ", CLAVE_NEGOCIO=" + CLAVE_NEGOCIO + ", CLAVE_CLIENTE=" + CLAVE_CLIENTE + ", FOLIO=" + FOLIO
				+ ", DESC_NEGOCIO=" + DESC_NEGOCIO + ", NOMBRE_CORTO=" + NOMBRE_CORTO + ", ESTATUS=" + ESTATUS + "]";
	}

}
