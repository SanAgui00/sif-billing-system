/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 02/04/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.pojo;

import java.util.Date;

public class B_HISTORICO_SERVICIOS {

	private Number ID_SERVICIO;
	private Number ID_SERVICIO_FACTURAR;
	private Number ID_CLIENTE;
	private String CLAVE;
	private String CLAVE_CLIENTE;
	private String NOMBRE_CORTO;
	private String DESCRIPCION;
	private String UNIDAD_MEDIDA;
	private String ESTATUS_CALCULO;
	private String ESTATUS_REGISTRO_CONTABLE;
	private String ESTATUS_COBRO;
	private String ESTATUS_FACTURA;
	private String ESTATUS;
	private String USUARIO;
	private String COMENTARIOS;
	private Date FECHA_DATOS;
	private Date FECHA_MOD;
	private Date FECHA_COBRO_AREA;
	private Date FECHA_COBRO_AREA_OP;
	private Date FECHA_COBRO;
	private Date FECHA_CALCULO;
	private Date FECHA_CRE;
	private Number TOTAL_TRANS_EMISOR;
	private Number TOTAL_IVA_EMISOR;
	private Number TOTAL_TRANS_ADQ;
	private Number TOTAL_IMPORTE_EMISOR;
	private Number TOTAL_IMPORTE_ADQ;
	private Number TOTAL_IVA_ADQ;
	private Number TOTAL_COBRANZA;

	public B_HISTORICO_SERVICIOS() {

	}

	public B_HISTORICO_SERVICIOS(Number iD_SERVICIO, Number iD_SERVICIO_FACTURAR, Number iD_CLIENTE, String cLAVE,
			String cLAVE_CLIENTE, String nOMBRE_CORTO, String dESCRIPCION, String uNIDAD_MEDIDA, String eSTATUS_CALCULO,
			String eSTATUS_REGISTRO_CONTABLE, String eSTATUS_COBRO, String eSTATUS_FACTURA, String eSTATUS,
			String uSUARIO, String cOMENTARIOS, Date fECHA_DATOS, Date fECHA_MOD, Date fECHA_COBRO_AREA,
			Date fECHA_COBRO_AREA_OP, Date fECHA_COBRO, Date fECHA_CALCULO, Date fECHA_CRE, Number tOTAL_TRANS_EMISOR,
			Number tOTAL_IVA_EMISOR, Number tOTAL_TRANS_ADQ, Number tOTAL_IMPORTE_EMISOR, Number tOTAL_IMPORTE_ADQ,
			Number tOTAL_IVA_ADQ, Number tOTAL_COBRANZA) {
		super();
		ID_SERVICIO = iD_SERVICIO;
		ID_SERVICIO_FACTURAR = iD_SERVICIO_FACTURAR;
		ID_CLIENTE = iD_CLIENTE;
		CLAVE = cLAVE;
		CLAVE_CLIENTE = cLAVE_CLIENTE;
		NOMBRE_CORTO = nOMBRE_CORTO;
		DESCRIPCION = dESCRIPCION;
		UNIDAD_MEDIDA = uNIDAD_MEDIDA;
		ESTATUS_CALCULO = eSTATUS_CALCULO;
		ESTATUS_REGISTRO_CONTABLE = eSTATUS_REGISTRO_CONTABLE;
		ESTATUS_COBRO = eSTATUS_COBRO;
		ESTATUS_FACTURA = eSTATUS_FACTURA;
		ESTATUS = eSTATUS;
		USUARIO = uSUARIO;
		COMENTARIOS = cOMENTARIOS;
		FECHA_DATOS = fECHA_DATOS;
		FECHA_MOD = fECHA_MOD;
		FECHA_COBRO_AREA = fECHA_COBRO_AREA;
		FECHA_COBRO_AREA_OP = fECHA_COBRO_AREA_OP;
		FECHA_COBRO = fECHA_COBRO;
		FECHA_CALCULO = fECHA_CALCULO;
		FECHA_CRE = fECHA_CRE;
		TOTAL_TRANS_EMISOR = tOTAL_TRANS_EMISOR;
		TOTAL_IVA_EMISOR = tOTAL_IVA_EMISOR;
		TOTAL_TRANS_ADQ = tOTAL_TRANS_ADQ;
		TOTAL_IMPORTE_EMISOR = tOTAL_IMPORTE_EMISOR;
		TOTAL_IMPORTE_ADQ = tOTAL_IMPORTE_ADQ;
		TOTAL_IVA_ADQ = tOTAL_IVA_ADQ;
		TOTAL_COBRANZA = tOTAL_COBRANZA;
	}

	public Number getID_SERVICIO() {
		return ID_SERVICIO;
	}

	public void setID_SERVICIO(Number iD_SERVICIO) {
		ID_SERVICIO = iD_SERVICIO;
	}

	public Number getID_SERVICIO_FACTURAR() {
		return ID_SERVICIO_FACTURAR;
	}

	public void setID_SERVICIO_FACTURAR(Number iD_SERVICIO_FACTURAR) {
		ID_SERVICIO_FACTURAR = iD_SERVICIO_FACTURAR;
	}

	public Number getID_CLIENTE() {
		return ID_CLIENTE;
	}

	public void setID_CLIENTE(Number iD_CLIENTE) {
		ID_CLIENTE = iD_CLIENTE;
	}

	public String getCLAVE() {
		return CLAVE;
	}

	public void setCLAVE(String cLAVE) {
		CLAVE = cLAVE;
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

	public String getDESCRIPCION() {
		return DESCRIPCION;
	}

	public void setDESCRIPCION(String dESCRIPCION) {
		DESCRIPCION = dESCRIPCION;
	}

	public String getUNIDAD_MEDIDA() {
		return UNIDAD_MEDIDA;
	}

	public void setUNIDAD_MEDIDA(String uNIDAD_MEDIDA) {
		UNIDAD_MEDIDA = uNIDAD_MEDIDA;
	}

	public String getESTATUS_CALCULO() {
		return ESTATUS_CALCULO;
	}

	public void setESTATUS_CALCULO(String eSTATUS_CALCULO) {
		ESTATUS_CALCULO = eSTATUS_CALCULO;
	}

	public String getESTATUS_REGISTRO_CONTABLE() {
		return ESTATUS_REGISTRO_CONTABLE;
	}

	public void setESTATUS_REGISTRO_CONTABLE(String eSTATUS_REGISTRO_CONTABLE) {
		ESTATUS_REGISTRO_CONTABLE = eSTATUS_REGISTRO_CONTABLE;
	}

	public String getESTATUS_COBRO() {
		return ESTATUS_COBRO;
	}

	public void setESTATUS_COBRO(String eSTATUS_COBRO) {
		ESTATUS_COBRO = eSTATUS_COBRO;
	}

	public String getESTATUS_FACTURA() {
		return ESTATUS_FACTURA;
	}

	public void setESTATUS_FACTURA(String eSTATUS_FACTURA) {
		ESTATUS_FACTURA = eSTATUS_FACTURA;
	}

	public String getESTATUS() {
		return ESTATUS;
	}

	public void setESTATUS(String eSTATUS) {
		ESTATUS = eSTATUS;
	}

	public String getUSUARIO() {
		return USUARIO;
	}

	public void setUSUARIO(String uSUARIO) {
		USUARIO = uSUARIO;
	}

	public String getCOMENTARIOS() {
		return COMENTARIOS;
	}

	public void setCOMENTARIOS(String cOMENTARIOS) {
		COMENTARIOS = cOMENTARIOS;
	}

	public Date getFECHA_DATOS() {
		return FECHA_DATOS;
	}

	public void setFECHA_DATOS(Date fECHA_DATOS) {
		FECHA_DATOS = fECHA_DATOS;
	}

	public Date getFECHA_MOD() {
		return FECHA_MOD;
	}

	public void setFECHA_MOD(Date fECHA_MOD) {
		FECHA_MOD = fECHA_MOD;
	}

	public Date getFECHA_COBRO_AREA() {
		return FECHA_COBRO_AREA;
	}

	public void setFECHA_COBRO_AREA(Date fECHA_COBRO_AREA) {
		FECHA_COBRO_AREA = fECHA_COBRO_AREA;
	}

	public Date getFECHA_COBRO_AREA_OP() {
		return FECHA_COBRO_AREA_OP;
	}

	public void setFECHA_COBRO_AREA_OP(Date fECHA_COBRO_AREA_OP) {
		FECHA_COBRO_AREA_OP = fECHA_COBRO_AREA_OP;
	}

	public Date getFECHA_COBRO() {
		return FECHA_COBRO;
	}

	public void setFECHA_COBRO(Date fECHA_COBRO) {
		FECHA_COBRO = fECHA_COBRO;
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

	public Number getTOTAL_TRANS_EMISOR() {
		return TOTAL_TRANS_EMISOR;
	}

	public void setTOTAL_TRANS_EMISOR(Number tOTAL_TRANS_EMISOR) {
		TOTAL_TRANS_EMISOR = tOTAL_TRANS_EMISOR;
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

	public Number getTOTAL_IMPORTE_EMISOR() {
		return TOTAL_IMPORTE_EMISOR;
	}

	public void setTOTAL_IMPORTE_EMISOR(Number tOTAL_IMPORTE_EMISOR) {
		TOTAL_IMPORTE_EMISOR = tOTAL_IMPORTE_EMISOR;
	}

	public Number getTOTAL_IMPORTE_ADQ() {
		return TOTAL_IMPORTE_ADQ;
	}

	public void setTOTAL_IMPORTE_ADQ(Number tOTAL_IMPORTE_ADQ) {
		TOTAL_IMPORTE_ADQ = tOTAL_IMPORTE_ADQ;
	}

	public Number getTOTAL_IVA_ADQ() {
		return TOTAL_IVA_ADQ;
	}

	public void setTOTAL_IVA_ADQ(Number tOTAL_IVA_ADQ) {
		TOTAL_IVA_ADQ = tOTAL_IVA_ADQ;
	}

	public Number getTOTAL_COBRANZA() {
		return TOTAL_COBRANZA;
	}

	public void setTOTAL_COBRANZA(Number tOTAL_COBRANZA) {
		TOTAL_COBRANZA = tOTAL_COBRANZA;
	}

	@Override
	public String toString() {
		return "HISTORICO_SERVICIOS [ID_SERVICIO=" + ID_SERVICIO + ", ID_SERVICIO_FACTURAR=" + ID_SERVICIO_FACTURAR
				+ ", ID_CLIENTE=" + ID_CLIENTE + ", CLAVE=" + CLAVE + ", CLAVE_CLIENTE=" + CLAVE_CLIENTE
				+ ", NOMBRE_CORTO=" + NOMBRE_CORTO + ", DESCRIPCION=" + DESCRIPCION + ", UNIDAD_MEDIDA=" + UNIDAD_MEDIDA
				+ ", ESTATUS_CALCULO=" + ESTATUS_CALCULO + ", ESTATUS_REGISTRO_CONTABLE=" + ESTATUS_REGISTRO_CONTABLE
				+ ", ESTATUS_COBRO=" + ESTATUS_COBRO + ", ESTATUS_FACTURA=" + ESTATUS_FACTURA + ", ESTATUS=" + ESTATUS
				+ ", USUARIO=" + USUARIO + ", COMENTARIOS=" + COMENTARIOS + ", FECHA_DATOS=" + FECHA_DATOS
				+ ", FECHA_MOD=" + FECHA_MOD + ", FECHA_COBRO_AREA=" + FECHA_COBRO_AREA + ", FECHA_COBRO_AREA_OP="
				+ FECHA_COBRO_AREA_OP + ", FECHA_COBRO=" + FECHA_COBRO + ", FECHA_CALCULO=" + FECHA_CALCULO
				+ ", FECHA_CRE=" + FECHA_CRE + ", TOTAL_TRANS_EMISOR=" + TOTAL_TRANS_EMISOR + ", TOTAL_IVA_EMISOR="
				+ TOTAL_IVA_EMISOR + ", TOTAL_TRANS_ADQ=" + TOTAL_TRANS_ADQ + ", TOTAL_IMPORTE_EMISOR="
				+ TOTAL_IMPORTE_EMISOR + ", TOTAL_IMPORTE_ADQ=" + TOTAL_IMPORTE_ADQ + ", TOTAL_IVA_ADQ=" + TOTAL_IVA_ADQ
				+ ", TOTAL_COBRANZA=" + TOTAL_COBRANZA + "]";
	}

}
