/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 08/03/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.pojo;

import java.util.Date;

public class B_REPORTE_COBRANZA {

	private Date FECHA_DATOS;
	private Number DESC_ADICIONAL;
	private Number TRX_COBDIA;
	private Number DESC_COBDIA;
	private Number IVA_AJUSTE;
	private Number SUBTOTAL_AJUSTE;
	private Number TOTAL;
	private Number DESC_AJUSTE;
	private Number IVA;
	private Number AJUSTE;
	private Number TOTAL_COBDIA;
	private Number TOTAL_AJUSTE;
	private Number IVA_COBDIA;
	private Number SUBTOTAL_COBDIA;
	private Number IMP_COBDIA;
	private Number PRECIO;
	private Number ID_CLIENTE;
	private Number ID_SERVICIOS;
	private Number ID_NEGOCIO;
	private Number ID_MONEDA;
	private Number ID_PROCESO;
	private Number ID_EMPRESA;
	private Number TIPO_CAMBIO;
	private String TIPO_SERVICIO;
	private String CLAVE_PROCESO;
	private String CLAVE_NEGOCIO;
	private String CLAVE_EMPRESA;
	private String CLAVE_CLIENTE;
	private String RAZON_SOCIAL;
	private String CLAVE_SERVICIO;
	private String DESCRIPCION_SERVICIO;
	private String DESC_PROCESO;
	private String DESCRIPCION_NEGOCIO;
	private String NOMBRE_MONEDA;
	private String NOMBRE_CLIENTE;

	public B_REPORTE_COBRANZA() {

	}

	public B_REPORTE_COBRANZA(Date fECHA_DATOS, Number dESC_ADICIONAL, Number tRX_COBDIA, Number dESC_COBDIA,
			Number iVA_AJUSTE, Number sUBTOTAL_AJUSTE, Number tOTAL, Number dESC_AJUSTE, Number iVA, Number aJUSTE,
			Number tOTAL_COBDIA, Number tOTAL_AJUSTE, Number iVA_COBDIA, Number sUBTOTAL_COBDIA, Number iMP_COBDIA,
			Number pRECIO, Number iD_CLIENTE, Number iD_SERVICIOS, Number iD_NEGOCIO, Number iD_MONEDA,
			Number iD_PROCESO, Number iD_EMPRESA, Number tIPO_CAMBIO, String tIPO_SERVICIO, String cLAVE_PROCESO,
			String cLAVE_NEGOCIO, String cLAVE_EMPRESA, String cLAVE_CLIENTE, String rAZON_SOCIAL,
			String cLAVE_SERVICIO, String dESCRIPCION_SERVICIO, String dESC_PROCESO, String dESCRIPCION_NEGOCIO,
			String nOMBRE_MONEDA, String nOMBRE_CLIENTE) {
		super();
		FECHA_DATOS = fECHA_DATOS;
		DESC_ADICIONAL = dESC_ADICIONAL;
		TRX_COBDIA = tRX_COBDIA;
		DESC_COBDIA = dESC_COBDIA;
		IVA_AJUSTE = iVA_AJUSTE;
		SUBTOTAL_AJUSTE = sUBTOTAL_AJUSTE;
		TOTAL = tOTAL;
		DESC_AJUSTE = dESC_AJUSTE;
		IVA = iVA;
		AJUSTE = aJUSTE;
		TOTAL_COBDIA = tOTAL_COBDIA;
		TOTAL_AJUSTE = tOTAL_AJUSTE;
		IVA_COBDIA = iVA_COBDIA;
		SUBTOTAL_COBDIA = sUBTOTAL_COBDIA;
		IMP_COBDIA = iMP_COBDIA;
		PRECIO = pRECIO;
		ID_CLIENTE = iD_CLIENTE;
		ID_SERVICIOS = iD_SERVICIOS;
		ID_NEGOCIO = iD_NEGOCIO;
		ID_MONEDA = iD_MONEDA;
		ID_PROCESO = iD_PROCESO;
		ID_EMPRESA = iD_EMPRESA;
		TIPO_CAMBIO = tIPO_CAMBIO;
		TIPO_SERVICIO = tIPO_SERVICIO;
		CLAVE_PROCESO = cLAVE_PROCESO;
		CLAVE_NEGOCIO = cLAVE_NEGOCIO;
		CLAVE_EMPRESA = cLAVE_EMPRESA;
		CLAVE_CLIENTE = cLAVE_CLIENTE;
		RAZON_SOCIAL = rAZON_SOCIAL;
		CLAVE_SERVICIO = cLAVE_SERVICIO;
		DESCRIPCION_SERVICIO = dESCRIPCION_SERVICIO;
		DESC_PROCESO = dESC_PROCESO;
		DESCRIPCION_NEGOCIO = dESCRIPCION_NEGOCIO;
		NOMBRE_MONEDA = nOMBRE_MONEDA;
		NOMBRE_CLIENTE = nOMBRE_CLIENTE;
	}

	public Date getFECHA_DATOS() {
		return FECHA_DATOS;
	}

	public void setFECHA_DATOS(Date fECHA_DATOS) {
		FECHA_DATOS = fECHA_DATOS;
	}

	public Number getDESC_ADICIONAL() {
		return DESC_ADICIONAL;
	}

	public void setDESC_ADICIONAL(Number dESC_ADICIONAL) {
		DESC_ADICIONAL = dESC_ADICIONAL;
	}

	public Number getTRX_COBDIA() {
		return TRX_COBDIA;
	}

	public void setTRX_COBDIA(Number tRX_COBDIA) {
		TRX_COBDIA = tRX_COBDIA;
	}

	public Number getDESC_COBDIA() {
		return DESC_COBDIA;
	}

	public void setDESC_COBDIA(Number dESC_COBDIA) {
		DESC_COBDIA = dESC_COBDIA;
	}

	public Number getIVA_AJUSTE() {
		return IVA_AJUSTE;
	}

	public void setIVA_AJUSTE(Number iVA_AJUSTE) {
		IVA_AJUSTE = iVA_AJUSTE;
	}

	public Number getSUBTOTAL_AJUSTE() {
		return SUBTOTAL_AJUSTE;
	}

	public void setSUBTOTAL_AJUSTE(Number sUBTOTAL_AJUSTE) {
		SUBTOTAL_AJUSTE = sUBTOTAL_AJUSTE;
	}

	public Number getTOTAL() {
		return TOTAL;
	}

	public void setTOTAL(Number tOTAL) {
		TOTAL = tOTAL;
	}

	public Number getDESC_AJUSTE() {
		return DESC_AJUSTE;
	}

	public void setDESC_AJUSTE(Number dESC_AJUSTE) {
		DESC_AJUSTE = dESC_AJUSTE;
	}

	public Number getIVA() {
		return IVA;
	}

	public void setIVA(Number iVA) {
		IVA = iVA;
	}

	public Number getAJUSTE() {
		return AJUSTE;
	}

	public void setAJUSTE(Number aJUSTE) {
		AJUSTE = aJUSTE;
	}

	public Number getTOTAL_COBDIA() {
		return TOTAL_COBDIA;
	}

	public void setTOTAL_COBDIA(Number tOTAL_COBDIA) {
		TOTAL_COBDIA = tOTAL_COBDIA;
	}

	public Number getTOTAL_AJUSTE() {
		return TOTAL_AJUSTE;
	}

	public void setTOTAL_AJUSTE(Number tOTAL_AJUSTE) {
		TOTAL_AJUSTE = tOTAL_AJUSTE;
	}

	public Number getIVA_COBDIA() {
		return IVA_COBDIA;
	}

	public void setIVA_COBDIA(Number iVA_COBDIA) {
		IVA_COBDIA = iVA_COBDIA;
	}

	public Number getSUBTOTAL_COBDIA() {
		return SUBTOTAL_COBDIA;
	}

	public void setSUBTOTAL_COBDIA(Number sUBTOTAL_COBDIA) {
		SUBTOTAL_COBDIA = sUBTOTAL_COBDIA;
	}

	public Number getIMP_COBDIA() {
		return IMP_COBDIA;
	}

	public void setIMP_COBDIA(Number iMP_COBDIA) {
		IMP_COBDIA = iMP_COBDIA;
	}

	public Number getPRECIO() {
		return PRECIO;
	}

	public void setPRECIO(Number pRECIO) {
		PRECIO = pRECIO;
	}

	public Number getID_CLIENTE() {
		return ID_CLIENTE;
	}

	public void setID_CLIENTE(Number iD_CLIENTE) {
		ID_CLIENTE = iD_CLIENTE;
	}

	public Number getID_SERVICIOS() {
		return ID_SERVICIOS;
	}

	public void setID_SERVICIOS(Number iD_SERVICIOS) {
		ID_SERVICIOS = iD_SERVICIOS;
	}

	public Number getID_NEGOCIO() {
		return ID_NEGOCIO;
	}

	public void setID_NEGOCIO(Number iD_NEGOCIO) {
		ID_NEGOCIO = iD_NEGOCIO;
	}

	public Number getID_MONEDA() {
		return ID_MONEDA;
	}

	public void setID_MONEDA(Number iD_MONEDA) {
		ID_MONEDA = iD_MONEDA;
	}

	public Number getID_PROCESO() {
		return ID_PROCESO;
	}

	public void setID_PROCESO(Number iD_PROCESO) {
		ID_PROCESO = iD_PROCESO;
	}

	public Number getID_EMPRESA() {
		return ID_EMPRESA;
	}

	public void setID_EMPRESA(Number iD_EMPRESA) {
		ID_EMPRESA = iD_EMPRESA;
	}

	public Number getTIPO_CAMBIO() {
		return TIPO_CAMBIO;
	}

	public void setTIPO_CAMBIO(Number tIPO_CAMBIO) {
		TIPO_CAMBIO = tIPO_CAMBIO;
	}

	public String getTIPO_SERVICIO() {
		return TIPO_SERVICIO;
	}

	public void setTIPO_SERVICIO(String tIPO_SERVICIO) {
		TIPO_SERVICIO = tIPO_SERVICIO;
	}

	public String getCLAVE_PROCESO() {
		return CLAVE_PROCESO;
	}

	public void setCLAVE_PROCESO(String cLAVE_PROCESO) {
		CLAVE_PROCESO = cLAVE_PROCESO;
	}

	public String getCLAVE_NEGOCIO() {
		return CLAVE_NEGOCIO;
	}

	public void setCLAVE_NEGOCIO(String cLAVE_NEGOCIO) {
		CLAVE_NEGOCIO = cLAVE_NEGOCIO;
	}

	public String getCLAVE_EMPRESA() {
		return CLAVE_EMPRESA;
	}

	public void setCLAVE_EMPRESA(String cLAVE_EMPRESA) {
		CLAVE_EMPRESA = cLAVE_EMPRESA;
	}

	public String getCLAVE_CLIENTE() {
		return CLAVE_CLIENTE;
	}

	public void setCLAVE_CLIENTE(String cLAVE_CLIENTE) {
		CLAVE_CLIENTE = cLAVE_CLIENTE;
	}

	public String getRAZON_SOCIAL() {
		return RAZON_SOCIAL;
	}

	public void setRAZON_SOCIAL(String rAZON_SOCIAL) {
		RAZON_SOCIAL = rAZON_SOCIAL;
	}

	public String getCLAVE_SERVICIO() {
		return CLAVE_SERVICIO;
	}

	public void setCLAVE_SERVICIO(String cLAVE_SERVICIO) {
		CLAVE_SERVICIO = cLAVE_SERVICIO;
	}

	public String getDESCRIPCION_SERVICIO() {
		return DESCRIPCION_SERVICIO;
	}

	public void setDESCRIPCION_SERVICIO(String dESCRIPCION_SERVICIO) {
		DESCRIPCION_SERVICIO = dESCRIPCION_SERVICIO;
	}

	public String getDESC_PROCESO() {
		return DESC_PROCESO;
	}

	public void setDESC_PROCESO(String dESC_PROCESO) {
		DESC_PROCESO = dESC_PROCESO;
	}

	public String getDESCRIPCION_NEGOCIO() {
		return DESCRIPCION_NEGOCIO;
	}

	public void setDESCRIPCION_NEGOCIO(String dESCRIPCION_NEGOCIO) {
		DESCRIPCION_NEGOCIO = dESCRIPCION_NEGOCIO;
	}

	public String getNOMBRE_MONEDA() {
		return NOMBRE_MONEDA;
	}

	public void setNOMBRE_MONEDA(String nOMBRE_MONEDA) {
		NOMBRE_MONEDA = nOMBRE_MONEDA;
	}

	public String getNOMBRE_CLIENTE() {
		return NOMBRE_CLIENTE;
	}

	public void setNOMBRE_CLIENTE(String nOMBRE_CLIENTE) {
		NOMBRE_CLIENTE = nOMBRE_CLIENTE;
	}

	@Override
	public String toString() {
		return "B_REPORTE_COBRANZA [FECHA_DATOS=" + FECHA_DATOS + ", DESC_ADICIONAL=" + DESC_ADICIONAL + ", TRX_COBDIA="
				+ TRX_COBDIA + ", DESC_COBDIA=" + DESC_COBDIA + ", IVA_AJUSTE=" + IVA_AJUSTE + ", SUBTOTAL_AJUSTE="
				+ SUBTOTAL_AJUSTE + ", TOTAL=" + TOTAL + ", DESC_AJUSTE=" + DESC_AJUSTE + ", IVA=" + IVA + ", AJUSTE="
				+ AJUSTE + ", TOTAL_COBDIA=" + TOTAL_COBDIA + ", TOTAL_AJUSTE=" + TOTAL_AJUSTE + ", IVA_COBDIA="
				+ IVA_COBDIA + ", SUBTOTAL_COBDIA=" + SUBTOTAL_COBDIA + ", IMP_COBDIA=" + IMP_COBDIA + ", PRECIO="
				+ PRECIO + ", ID_CLIENTE=" + ID_CLIENTE + ", ID_SERVICIOS=" + ID_SERVICIOS + ", ID_NEGOCIO="
				+ ID_NEGOCIO + ", ID_MONEDA=" + ID_MONEDA + ", ID_PROCESO=" + ID_PROCESO + ", ID_EMPRESA=" + ID_EMPRESA
				+ ", TIPO_CAMBIO=" + TIPO_CAMBIO + ", TIPO_SERVICIO=" + TIPO_SERVICIO + ", CLAVE_PROCESO="
				+ CLAVE_PROCESO + ", CLAVE_NEGOCIO=" + CLAVE_NEGOCIO + ", CLAVE_EMPRESA=" + CLAVE_EMPRESA
				+ ", CLAVE_CLIENTE=" + CLAVE_CLIENTE + ", RAZON_SOCIAL=" + RAZON_SOCIAL + ", CLAVE_SERVICIO="
				+ CLAVE_SERVICIO + ", DESCRIPCION_SERVICIO=" + DESCRIPCION_SERVICIO + ", DESC_PROCESO=" + DESC_PROCESO
				+ ", DESCRIPCION_NEGOCIO=" + DESCRIPCION_NEGOCIO + ", NOMBRE_MONEDA=" + NOMBRE_MONEDA
				+ ", NOMBRE_CLIENTE=" + NOMBRE_CLIENTE + "]";
	}

}
