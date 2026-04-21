/**
################################################################################
# Autor               : Valverde Méndez Arturo                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 25/04/2018 #
# Descripcion General : POJO para reporte Acumulado Cobranza                   #
# Marca del cambio    :                                                        #
#------------------------------------------------------------------------------#
# Numero de Parametros: N/A                                                    #
# Parametros Entrada  : N/A                                  Formato:          #
# Parametros Salida   : N/A                                  Formato:          #
################################################################################
**/
package com.prosa.sif.pojo;

public class B_ACUMULADO_COBRANZA {

	private Number ID_NEGOCIO;
	private String CLAVE_NEGOCIO;
	private String DESCRIPCION_NEGOCIO;
	private Number ID_CLIENTE;
	private String CLAVE_CLIENTE;
	private String NOMBRE_CLIENTE;
	private Number TRX_COBDIA;
	private Number IMP_COBDIA;
	private Number DESC_COBDIA;
	private Number DESC_ADICIONAL;
	private Number SUBTOTAL_COBDIA;
	private Number IVA_COBDIA;
	private Number TOTAL_COBDIA;
	private Number AJUSTE;
	private Number DESC_AJUSTE;
	private Number SUBTOTAL_AJUSTE;
	private Number IVA_AJUSTE;
	private Number TOTAL_AJUSTE;
	private Number IVA;
	private Number TOTAL;

	public B_ACUMULADO_COBRANZA() {

	}

	public B_ACUMULADO_COBRANZA(Number iD_NEGOCIO, String cLAVE_NEGOCIO, String dESCRIPCION_NEGOCIO, Number iD_CLIENTE,
			String cLAVE_CLIENTE, String nOMBRE_CLIENTE, Number tRX_COBDIA, Number iMP_COBDIA, Number dESC_COBDIA,
			Number dESC_ADICIONAL, Number sUBTOTAL_COBDIA, Number iVA_COBDIA, Number tOTAL_COBDIA, Number aJUSTE,
			Number dESC_AJUSTE, Number sUBTOTAL_AJUSTE, Number iVA_AJUSTE, Number tOTAL_AJUSTE, Number iVA,
			Number tOTAL) {
		super();
		ID_NEGOCIO = iD_NEGOCIO;
		CLAVE_NEGOCIO = cLAVE_NEGOCIO;
		DESCRIPCION_NEGOCIO = dESCRIPCION_NEGOCIO;
		ID_CLIENTE = iD_CLIENTE;
		CLAVE_CLIENTE = cLAVE_CLIENTE;
		NOMBRE_CLIENTE = nOMBRE_CLIENTE;
		TRX_COBDIA = tRX_COBDIA;
		IMP_COBDIA = iMP_COBDIA;
		DESC_COBDIA = dESC_COBDIA;
		DESC_ADICIONAL = dESC_ADICIONAL;
		SUBTOTAL_COBDIA = sUBTOTAL_COBDIA;
		IVA_COBDIA = iVA_COBDIA;
		TOTAL_COBDIA = tOTAL_COBDIA;
		AJUSTE = aJUSTE;
		DESC_AJUSTE = dESC_AJUSTE;
		SUBTOTAL_AJUSTE = sUBTOTAL_AJUSTE;
		IVA_AJUSTE = iVA_AJUSTE;
		TOTAL_AJUSTE = tOTAL_AJUSTE;
		IVA = iVA;
		TOTAL = tOTAL;
	}

	public Number getID_NEGOCIO() {
		return ID_NEGOCIO;
	}

	public void setID_NEGOCIO(Number iD_NEGOCIO) {
		ID_NEGOCIO = iD_NEGOCIO;
	}

	public String getCLAVE_NEGOCIO() {
		return CLAVE_NEGOCIO;
	}

	public void setCLAVE_NEGOCIO(String cLAVE_NEGOCIO) {
		CLAVE_NEGOCIO = cLAVE_NEGOCIO;
	}

	public String getDESCRIPCION_NEGOCIO() {
		return DESCRIPCION_NEGOCIO;
	}

	public void setDESCRIPCION_NEGOCIO(String dESCRIPCION_NEGOCIO) {
		DESCRIPCION_NEGOCIO = dESCRIPCION_NEGOCIO;
	}

	public Number getID_CLIENTE() {
		return ID_CLIENTE;
	}

	public void setID_CLIENTE(Number iD_CLIENTE) {
		ID_CLIENTE = iD_CLIENTE;
	}

	public String getCLAVE_CLIENTE() {
		return CLAVE_CLIENTE;
	}

	public void setCLAVE_CLIENTE(String cLAVE_CLIENTE) {
		CLAVE_CLIENTE = cLAVE_CLIENTE;
	}

	public String getNOMBRE_CLIENTE() {
		return NOMBRE_CLIENTE;
	}

	public void setNOMBRE_CLIENTE(String nOMBRE_CLIENTE) {
		NOMBRE_CLIENTE = nOMBRE_CLIENTE;
	}

	public Number getTRX_COBDIA() {
		return TRX_COBDIA;
	}

	public void setTRX_COBDIA(Number tRX_COBDIA) {
		TRX_COBDIA = tRX_COBDIA;
	}

	public Number getIMP_COBDIA() {
		return IMP_COBDIA;
	}

	public void setIMP_COBDIA(Number iMP_COBDIA) {
		IMP_COBDIA = iMP_COBDIA;
	}

	public Number getDESC_COBDIA() {
		return DESC_COBDIA;
	}

	public void setDESC_COBDIA(Number dESC_COBDIA) {
		DESC_COBDIA = dESC_COBDIA;
	}

	public Number getDESC_ADICIONAL() {
		return DESC_ADICIONAL;
	}

	public void setDESC_ADICIONAL(Number dESC_ADICIONAL) {
		DESC_ADICIONAL = dESC_ADICIONAL;
	}

	public Number getSUBTOTAL_COBDIA() {
		return SUBTOTAL_COBDIA;
	}

	public void setSUBTOTAL_COBDIA(Number sUBTOTAL_COBDIA) {
		SUBTOTAL_COBDIA = sUBTOTAL_COBDIA;
	}

	public Number getIVA_COBDIA() {
		return IVA_COBDIA;
	}

	public void setIVA_COBDIA(Number iVA_COBDIA) {
		IVA_COBDIA = iVA_COBDIA;
	}

	public Number getTOTAL_COBDIA() {
		return TOTAL_COBDIA;
	}

	public void setTOTAL_COBDIA(Number tOTAL_COBDIA) {
		TOTAL_COBDIA = tOTAL_COBDIA;
	}

	public Number getAJUSTE() {
		return AJUSTE;
	}

	public void setAJUSTE(Number aJUSTE) {
		AJUSTE = aJUSTE;
	}

	public Number getDESC_AJUSTE() {
		return DESC_AJUSTE;
	}

	public void setDESC_AJUSTE(Number dESC_AJUSTE) {
		DESC_AJUSTE = dESC_AJUSTE;
	}

	public Number getSUBTOTAL_AJUSTE() {
		return SUBTOTAL_AJUSTE;
	}

	public void setSUBTOTAL_AJUSTE(Number sUBTOTAL_AJUSTE) {
		SUBTOTAL_AJUSTE = sUBTOTAL_AJUSTE;
	}

	public Number getIVA_AJUSTE() {
		return IVA_AJUSTE;
	}

	public void setIVA_AJUSTE(Number iVA_AJUSTE) {
		IVA_AJUSTE = iVA_AJUSTE;
	}

	public Number getTOTAL_AJUSTE() {
		return TOTAL_AJUSTE;
	}

	public void setTOTAL_AJUSTE(Number tOTAL_AJUSTE) {
		TOTAL_AJUSTE = tOTAL_AJUSTE;
	}

	public Number getIVA() {
		return IVA;
	}

	public void setIVA(Number iVA) {
		IVA = iVA;
	}

	public Number getTOTAL() {
		return TOTAL;
	}

	public void setTOTAL(Number tOTAL) {
		TOTAL = tOTAL;
	}

	@Override
	public String toString() {
		return "B_ACUMULADO_COBRANZA [ID_NEGOCIO=" + ID_NEGOCIO + ", CLAVE_NEGOCIO=" + CLAVE_NEGOCIO
				+ ", DESCRIPCION_NEGOCIO=" + DESCRIPCION_NEGOCIO + ", ID_CLIENTE=" + ID_CLIENTE + ", CLAVE_CLIENTE="
				+ CLAVE_CLIENTE + ", NOMBRE_CLIENTE=" + NOMBRE_CLIENTE + ", TRX_COBDIA=" + TRX_COBDIA + ", IMP_COBDIA="
				+ IMP_COBDIA + ", DESC_COBDIA=" + DESC_COBDIA + ", DESC_ADICIONAL=" + DESC_ADICIONAL
				+ ", SUBTOTAL_COBDIA=" + SUBTOTAL_COBDIA + ", IVA_COBDIA=" + IVA_COBDIA + ", TOTAL_COBDIA="
				+ TOTAL_COBDIA + ", AJUSTE=" + AJUSTE + ", DESC_AJUSTE=" + DESC_AJUSTE + ", SUBTOTAL_AJUSTE="
				+ SUBTOTAL_AJUSTE + ", IVA_AJUSTE=" + IVA_AJUSTE + ", TOTAL_AJUSTE=" + TOTAL_AJUSTE + ", IVA=" + IVA
				+ ", TOTAL=" + TOTAL + "]";
	}

}
