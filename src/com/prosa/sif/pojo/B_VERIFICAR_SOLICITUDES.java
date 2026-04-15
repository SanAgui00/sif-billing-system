/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 28/06/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.pojo;

import java.util.Date;

public class B_VERIFICAR_SOLICITUDES {

	private Number ID_SERVICIO;
	private Number ID_MONEDA;
	private Number ID_SERVICIOS_FACTURAR;
	private Date FECHA_DATOS;
	private String ESTATUS;
	private String DESCRIPCION;
	private String NOMBRE_MONEDA;
	private String USUARIO;
	private Date FECHA_COBRO_AREA_OP;
	private Number TOTAL_TRANS_EMISOR;
	private Number TOTAL_IMPORTE_EMISOR;
	private Number TOTAL_IVA_EMISOR;
	private Number TOTAL_TRANS_ADQ;
	private Number TOTAL_IMPORTE_ADQ;
	private String CLAVE;
	private Date FECHA_CALCULO;
	private Date FECHA_CRE;
	private Number ID_CLIENTE;
	private String CLAVE_CLIENTE;
	private String NOMBRE_CORTO;

	public B_VERIFICAR_SOLICITUDES() {

	}

	public B_VERIFICAR_SOLICITUDES(Number iD_SERVICIO, Number iD_MONEDA, Number iD_SERVICIOS_FACTURAR, Date fECHA_DATOS,
			String eSTATUS, String dESCRIPCION, String nOMBRE_MONEDA, String uSUARIO, Date fECHA_COBRO_AREA_OP,
			Number tOTAL_TRANS_EMISOR, Number tOTAL_IMPORTE_EMISOR, Number tOTAL_IVA_EMISOR, Number tOTAL_TRANS_ADQ,
			Number tOTAL_IMPORTE_ADQ, String cLAVE, Date fECHA_CALCULO, Date fECHA_CRE, Number iD_CLIENTE,
			String cLAVE_CLIENTE, String nOMBRE_CORTO) {
		super();
		ID_SERVICIO = iD_SERVICIO;
		ID_MONEDA = iD_MONEDA;
		ID_SERVICIOS_FACTURAR = iD_SERVICIOS_FACTURAR;
		FECHA_DATOS = fECHA_DATOS;
		ESTATUS = eSTATUS;
		DESCRIPCION = dESCRIPCION;
		NOMBRE_MONEDA = nOMBRE_MONEDA;
		USUARIO = uSUARIO;
		FECHA_COBRO_AREA_OP = fECHA_COBRO_AREA_OP;
		TOTAL_TRANS_EMISOR = tOTAL_TRANS_EMISOR;
		TOTAL_IMPORTE_EMISOR = tOTAL_IMPORTE_EMISOR;
		TOTAL_IVA_EMISOR = tOTAL_IVA_EMISOR;
		TOTAL_TRANS_ADQ = tOTAL_TRANS_ADQ;
		TOTAL_IMPORTE_ADQ = tOTAL_IMPORTE_ADQ;
		CLAVE = cLAVE;
		FECHA_CALCULO = fECHA_CALCULO;
		FECHA_CRE = fECHA_CRE;
		ID_CLIENTE = iD_CLIENTE;
		CLAVE_CLIENTE = cLAVE_CLIENTE;
		NOMBRE_CORTO = nOMBRE_CORTO;
	}

	public Number getID_SERVICIO() {
		return ID_SERVICIO;
	}

	public void setID_SERVICIO(Number iD_SERVICIO) {
		ID_SERVICIO = iD_SERVICIO;
	}

	public Number getID_MONEDA() {
		return ID_MONEDA;
	}

	public void setID_MONEDA(Number iD_MONEDA) {
		ID_MONEDA = iD_MONEDA;
	}

	public Number getID_SERVICIOS_FACTURAR() {
		return ID_SERVICIOS_FACTURAR;
	}

	public void setID_SERVICIOS_FACTURAR(Number iD_SERVICIOS_FACTURAR) {
		ID_SERVICIOS_FACTURAR = iD_SERVICIOS_FACTURAR;
	}

	public Date getFECHA_DATOS() {
		return FECHA_DATOS;
	}

	public void setFECHA_DATOS(Date fECHA_DATOS) {
		FECHA_DATOS = fECHA_DATOS;
	}

	public String getESTATUS() {
		return ESTATUS;
	}

	public void setESTATUS(String eSTATUS) {
		ESTATUS = eSTATUS;
	}

	public String getDESCRIPCION() {
		return DESCRIPCION;
	}

	public void setDESCRIPCION(String dESCRIPCION) {
		DESCRIPCION = dESCRIPCION;
	}

	public String getNOMBRE_MONEDA() {
		return NOMBRE_MONEDA;
	}

	public void setNOMBRE_MONEDA(String nOMBRE_MONEDA) {
		NOMBRE_MONEDA = nOMBRE_MONEDA;
	}

	public String getUSUARIO() {
		return USUARIO;
	}

	public void setUSUARIO(String uSUARIO) {
		USUARIO = uSUARIO;
	}

	public Date getFECHA_COBRO_AREA_OP() {
		return FECHA_COBRO_AREA_OP;
	}

	public void setFECHA_COBRO_AREA_OP(Date fECHA_COBRO_AREA_OP) {
		FECHA_COBRO_AREA_OP = fECHA_COBRO_AREA_OP;
	}

	public Number getTOTAL_TRANS_EMISOR() {
		return TOTAL_TRANS_EMISOR;
	}

	public void setTOTAL_TRANS_EMISOR(Number tOTAL_TRANS_EMISOR) {
		TOTAL_TRANS_EMISOR = tOTAL_TRANS_EMISOR;
	}

	public Number getTOTAL_IMPORTE_EMISOR() {
		return TOTAL_IMPORTE_EMISOR;
	}

	public void setTOTAL_IMPORTE_EMISOR(Number tOTAL_IMPORTE_EMISOR) {
		TOTAL_IMPORTE_EMISOR = tOTAL_IMPORTE_EMISOR;
	}

	public Number getTOTAL_IVA_EMISOR() {
		return TOTAL_IVA_EMISOR;
	}

	public void setTOTAL_IVA_EMISOR(Number tOTAL_IVA_EMISOR) {
		TOTAL_IVA_EMISOR = tOTAL_IVA_EMISOR;
	}

	public Number getTOTAL_TRANS_ADQ() {
		return TOTAL_TRANS_ADQ;
	}

	public void setTOTAL_TRANS_ADQ(Number tOTAL_TRANS_ADQ) {
		TOTAL_TRANS_ADQ = tOTAL_TRANS_ADQ;
	}

	public Number getTOTAL_IMPORTE_ADQ() {
		return TOTAL_IMPORTE_ADQ;
	}

	public void setTOTAL_IMPORTE_ADQ(Number tOTAL_IMPORTE_ADQ) {
		TOTAL_IMPORTE_ADQ = tOTAL_IMPORTE_ADQ;
	}

	public String getCLAVE() {
		return CLAVE;
	}

	public void setCLAVE(String cLAVE) {
		CLAVE = cLAVE;
	}

	public Date getFECHA_CALCULO() {
		return FECHA_CALCULO;
	}

	public void setFECHA_CALCULO(Date fECHA_CALCULO) {
		FECHA_CALCULO = fECHA_CALCULO;
	}

	public Date getFECHA_CRE() {
		return FECHA_CRE;
	}

	public void setFECHA_CRE(Date fECHA_CRE) {
		FECHA_CRE = fECHA_CRE;
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

	public String getNOMBRE_CORTO() {
		return NOMBRE_CORTO;
	}

	public void setNOMBRE_CORTO(String nOMBRE_CORTO) {
		NOMBRE_CORTO = nOMBRE_CORTO;
	}

	@Override
	public String toString() {
		return "VERIFICAR_SOLICITUDES [ID_SERVICIO=" + ID_SERVICIO + ", ID_MONEDA=" + ID_MONEDA
				+ ", ID_SERVICIOS_FACTURAR=" + ID_SERVICIOS_FACTURAR + ", FECHA_DATOS=" + FECHA_DATOS + ", ESTATUS="
				+ ESTATUS + ", DESCRIPCION=" + DESCRIPCION + ", NOMBRE_MONEDA=" + NOMBRE_MONEDA + ", USUARIO=" + USUARIO
				+ ", FECHA_COBRO_AREA_OP=" + FECHA_COBRO_AREA_OP + ", TOTAL_TRANS_EMISOR=" + TOTAL_TRANS_EMISOR
				+ ", TOTAL_IMPORTE_EMISOR=" + TOTAL_IMPORTE_EMISOR + ", TOTAL_IVA_EMISOR=" + TOTAL_IVA_EMISOR
				+ ", TOTAL_TRANS_ADQ=" + TOTAL_TRANS_ADQ + ", TOTAL_IMPORTE_ADQ=" + TOTAL_IMPORTE_ADQ + ", CLAVE="
				+ CLAVE + ", FECHA_CALCULO=" + FECHA_CALCULO + ", FECHA_CRE=" + FECHA_CRE + ", ID_CLIENTE=" + ID_CLIENTE
				+ ", CLAVE_CLIENTE=" + CLAVE_CLIENTE + ", NOMBRE_CORTO=" + NOMBRE_CORTO + "]";
	}

}
