/**
################################################################################
# Autor               : Garnica                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 23/08/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.pojo;

import java.sql.Date;

public class B_VIEW_SIF_CONSECUTIVO_FOLIOS {

	private Date FECHA_RESERVACION;
	private Date FECHA_IMPRESION;
	private Date FECHA_COBRO;
	private Date FECHA_FACTURA;
	private Number CANTIDAD;
	private Number PRECIO_UNITARIO;
	private Number SUBTOTAL;
	private Number SUBTOTAL_DESC;
	private Number TIPO_CAMBIO;
	private Number TOTAL;
	private Number IVA;
	private Number ID_GENERADO_GL;
	private Number REFERENCIA;
	private Number CUENTA_CLIENTE;
	private String CENTRO_COSTOS;
	private String FOLIO_IMPRESO;
	private String CONCEPTO;
	private String RAZON_SOCIAL;
	private String CLAVE_PROCESO;
	private String CUENTA_INGRESO;
	private String FOLIO_INTERNO;
	private String CLAVE_CLIENTE;
	private String CLAVE_NEGOCIO;
	private String COMENTARIOS;
	private String RFC;
	private String CLAVE_SERVICIO;
	private String ESTATUS;
	private String TEMPORAL;
	private String TIPO_DOCUMENTO;
	private String DOMICILIO;
	private String DESC_NEGOCIO;
	private String NOMBRE_MONEDA;
	private String DESC_PROCESO;
	private String SERIE;
	private String CLAVE_SERVICIO_PARTICULAR;
	private String CLAVE_CATEGORIA_INGRESO;
	private String NOMBRE_CORTO;
	private String ESTATUS_COBRO;

	public B_VIEW_SIF_CONSECUTIVO_FOLIOS() {

	}

	public B_VIEW_SIF_CONSECUTIVO_FOLIOS(Date fECHA_RESERVACION, Date fECHA_IMPRESION, Date fECHA_COBRO,
			Date fECHA_FACTURA, Number cANTIDAD, Number pRECIO_UNITARIO, Number sUBTOTAL, Number sUBTOTAL_DESC,
			Number tIPO_CAMBIO, Number tOTAL, Number iVA, Number iD_GENERADO_GL, Number rEFERENCIA,
			Number cUENTA_CLIENTE, String cENTRO_COSTOS, String fOLIO_IMPRESO, String cONCEPTO, String rAZON_SOCIAL,
			String cLAVE_PROCESO, String cUENTA_INGRESO, String fOLIO_INTERNO, String cLAVE_CLIENTE,
			String cLAVE_NEGOCIO, String cOMENTARIOS, String rFC, String cLAVE_SERVICIO, String eSTATUS,
			String tEMPORAL, String tIPO_DOCUMENTO, String dOMICILIO, String dESC_NEGOCIO, String nOMBRE_MONEDA,
			String dESC_PROCESO, String sERIE, String cLAVE_SERVICIO_PARTICULAR, String cLAVE_CATEGORIA_INGRESO,
			String nOMBRE_CORTO, String eSTATUS_COBRO) {
		super();
		FECHA_RESERVACION = fECHA_RESERVACION;
		FECHA_IMPRESION = fECHA_IMPRESION;
		FECHA_COBRO = fECHA_COBRO;
		FECHA_FACTURA = fECHA_FACTURA;
		CANTIDAD = cANTIDAD;
		PRECIO_UNITARIO = pRECIO_UNITARIO;
		SUBTOTAL = sUBTOTAL;
		SUBTOTAL_DESC = sUBTOTAL_DESC;
		TIPO_CAMBIO = tIPO_CAMBIO;
		TOTAL = tOTAL;
		IVA = iVA;
		ID_GENERADO_GL = iD_GENERADO_GL;
		REFERENCIA = rEFERENCIA;
		CUENTA_CLIENTE = cUENTA_CLIENTE;
		CENTRO_COSTOS = cENTRO_COSTOS;
		FOLIO_IMPRESO = fOLIO_IMPRESO;
		CONCEPTO = cONCEPTO;
		RAZON_SOCIAL = rAZON_SOCIAL;
		CLAVE_PROCESO = cLAVE_PROCESO;
		CUENTA_INGRESO = cUENTA_INGRESO;
		FOLIO_INTERNO = fOLIO_INTERNO;
		CLAVE_CLIENTE = cLAVE_CLIENTE;
		CLAVE_NEGOCIO = cLAVE_NEGOCIO;
		COMENTARIOS = cOMENTARIOS;
		RFC = rFC;
		CLAVE_SERVICIO = cLAVE_SERVICIO;
		ESTATUS = eSTATUS;
		TEMPORAL = tEMPORAL;
		TIPO_DOCUMENTO = tIPO_DOCUMENTO;
		DOMICILIO = dOMICILIO;
		DESC_NEGOCIO = dESC_NEGOCIO;
		NOMBRE_MONEDA = nOMBRE_MONEDA;
		DESC_PROCESO = dESC_PROCESO;
		SERIE = sERIE;
		CLAVE_SERVICIO_PARTICULAR = cLAVE_SERVICIO_PARTICULAR;
		CLAVE_CATEGORIA_INGRESO = cLAVE_CATEGORIA_INGRESO;
		NOMBRE_CORTO = nOMBRE_CORTO;
		ESTATUS_COBRO = eSTATUS_COBRO;
	}

	public Date getFECHA_RESERVACION() {
		return FECHA_RESERVACION;
	}

	public void setFECHA_RESERVACION(Date fECHA_RESERVACION) {
		FECHA_RESERVACION = fECHA_RESERVACION;
	}

	public Date getFECHA_IMPRESION() {
		return FECHA_IMPRESION;
	}

	public void setFECHA_IMPRESION(Date fECHA_IMPRESION) {
		FECHA_IMPRESION = fECHA_IMPRESION;
	}

	public Date getFECHA_COBRO() {
		return FECHA_COBRO;
	}

	public void setFECHA_COBRO(Date fECHA_COBRO) {
		FECHA_COBRO = fECHA_COBRO;
	}

	public Date getFECHA_FACTURA() {
		return FECHA_FACTURA;
	}

	public void setFECHA_FACTURA(Date fECHA_FACTURA) {
		FECHA_FACTURA = fECHA_FACTURA;
	}

	public Number getCANTIDAD() {
		return CANTIDAD;
	}

	public void setCANTIDAD(Number cANTIDAD) {
		CANTIDAD = cANTIDAD;
	}

	public Number getPRECIO_UNITARIO() {
		return PRECIO_UNITARIO;
	}

	public void setPRECIO_UNITARIO(Number pRECIO_UNITARIO) {
		PRECIO_UNITARIO = pRECIO_UNITARIO;
	}

	public Number getSUBTOTAL() {
		return SUBTOTAL;
	}

	public void setSUBTOTAL(Number sUBTOTAL) {
		SUBTOTAL = sUBTOTAL;
	}

	public Number getSUBTOTAL_DESC() {
		return SUBTOTAL_DESC;
	}

	public void setSUBTOTAL_DESC(Number sUBTOTAL_DESC) {
		SUBTOTAL_DESC = sUBTOTAL_DESC;
	}

	public Number getTIPO_CAMBIO() {
		return TIPO_CAMBIO;
	}

	public void setTIPO_CAMBIO(Number tIPO_CAMBIO) {
		TIPO_CAMBIO = tIPO_CAMBIO;
	}

	public Number getTOTAL() {
		return TOTAL;
	}

	public void setTOTAL(Number tOTAL) {
		TOTAL = tOTAL;
	}

	public Number getIVA() {
		return IVA;
	}

	public void setIVA(Number iVA) {
		IVA = iVA;
	}

	public Number getID_GENERADO_GL() {
		return ID_GENERADO_GL;
	}

	public void setID_GENERADO_GL(Number iD_GENERADO_GL) {
		ID_GENERADO_GL = iD_GENERADO_GL;
	}

	public Number getREFERENCIA() {
		return REFERENCIA;
	}

	public void setREFERENCIA(Number rEFERENCIA) {
		REFERENCIA = rEFERENCIA;
	}

	public Number getCUENTA_CLIENTE() {
		return CUENTA_CLIENTE;
	}

	public void setCUENTA_CLIENTE(Number cUENTA_CLIENTE) {
		CUENTA_CLIENTE = cUENTA_CLIENTE;
	}

	public String getCENTRO_COSTOS() {
		return CENTRO_COSTOS;
	}

	public void setCENTRO_COSTOS(String cENTRO_COSTOS) {
		CENTRO_COSTOS = cENTRO_COSTOS;
	}

	public String getFOLIO_IMPRESO() {
		return FOLIO_IMPRESO;
	}

	public void setFOLIO_IMPRESO(String fOLIO_IMPRESO) {
		FOLIO_IMPRESO = fOLIO_IMPRESO;
	}

	public String getCONCEPTO() {
		return CONCEPTO;
	}

	public void setCONCEPTO(String cONCEPTO) {
		CONCEPTO = cONCEPTO;
	}

	public String getRAZON_SOCIAL() {
		return RAZON_SOCIAL;
	}

	public void setRAZON_SOCIAL(String rAZON_SOCIAL) {
		RAZON_SOCIAL = rAZON_SOCIAL;
	}

	public String getCLAVE_PROCESO() {
		return CLAVE_PROCESO;
	}

	public void setCLAVE_PROCESO(String cLAVE_PROCESO) {
		CLAVE_PROCESO = cLAVE_PROCESO;
	}

	public String getCUENTA_INGRESO() {
		return CUENTA_INGRESO;
	}

	public void setCUENTA_INGRESO(String cUENTA_INGRESO) {
		CUENTA_INGRESO = cUENTA_INGRESO;
	}

	public String getFOLIO_INTERNO() {
		return FOLIO_INTERNO;
	}

	public void setFOLIO_INTERNO(String fOLIO_INTERNO) {
		FOLIO_INTERNO = fOLIO_INTERNO;
	}

	public String getCLAVE_CLIENTE() {
		return CLAVE_CLIENTE;
	}

	public void setCLAVE_CLIENTE(String cLAVE_CLIENTE) {
		CLAVE_CLIENTE = cLAVE_CLIENTE;
	}

	public String getCLAVE_NEGOCIO() {
		return CLAVE_NEGOCIO;
	}

	public void setCLAVE_NEGOCIO(String cLAVE_NEGOCIO) {
		CLAVE_NEGOCIO = cLAVE_NEGOCIO;
	}

	public String getCOMENTARIOS() {
		return COMENTARIOS;
	}

	public void setCOMENTARIOS(String cOMENTARIOS) {
		COMENTARIOS = cOMENTARIOS;
	}

	public String getRFC() {
		return RFC;
	}

	public void setRFC(String rFC) {
		RFC = rFC;
	}

	public String getCLAVE_SERVICIO() {
		return CLAVE_SERVICIO;
	}

	public void setCLAVE_SERVICIO(String cLAVE_SERVICIO) {
		CLAVE_SERVICIO = cLAVE_SERVICIO;
	}

	public String getESTATUS() {
		return ESTATUS;
	}

	public void setESTATUS(String eSTATUS) {
		ESTATUS = eSTATUS;
	}

	public String getTEMPORAL() {
		return TEMPORAL;
	}

	public void setTEMPORAL(String tEMPORAL) {
		TEMPORAL = tEMPORAL;
	}

	public String getTIPO_DOCUMENTO() {
		return TIPO_DOCUMENTO;
	}

	public void setTIPO_DOCUMENTO(String tIPO_DOCUMENTO) {
		TIPO_DOCUMENTO = tIPO_DOCUMENTO;
	}

	public String getDOMICILIO() {
		return DOMICILIO;
	}

	public void setDOMICILIO(String dOMICILIO) {
		DOMICILIO = dOMICILIO;
	}

	public String getDESC_NEGOCIO() {
		return DESC_NEGOCIO;
	}

	public void setDESC_NEGOCIO(String dESC_NEGOCIO) {
		DESC_NEGOCIO = dESC_NEGOCIO;
	}

	public String getNOMBRE_MONEDA() {
		return NOMBRE_MONEDA;
	}

	public void setNOMBRE_MONEDA(String nOMBRE_MONEDA) {
		NOMBRE_MONEDA = nOMBRE_MONEDA;
	}

	public String getDESC_PROCESO() {
		return DESC_PROCESO;
	}

	public void setDESC_PROCESO(String dESC_PROCESO) {
		DESC_PROCESO = dESC_PROCESO;
	}

	public String getSERIE() {
		return SERIE;
	}

	public void setSERIE(String sERIE) {
		SERIE = sERIE;
	}

	public String getCLAVE_SERVICIO_PARTICULAR() {
		return CLAVE_SERVICIO_PARTICULAR;
	}

	public void setCLAVE_SERVICIO_PARTICULAR(String cLAVE_SERVICIO_PARTICULAR) {
		CLAVE_SERVICIO_PARTICULAR = cLAVE_SERVICIO_PARTICULAR;
	}

	public String getCLAVE_CATEGORIA_INGRESO() {
		return CLAVE_CATEGORIA_INGRESO;
	}

	public void setCLAVE_CATEGORIA_INGRESO(String cLAVE_CATEGORIA_INGRESO) {
		CLAVE_CATEGORIA_INGRESO = cLAVE_CATEGORIA_INGRESO;
	}

	public String getNOMBRE_CORTO() {
		return NOMBRE_CORTO;
	}

	public void setNOMBRE_CORTO(String nOMBRE_CORTO) {
		NOMBRE_CORTO = nOMBRE_CORTO;
	}

	public String getESTATUS_COBRO() {
		return ESTATUS_COBRO;
	}

	public void setESTATUS_COBRO(String eSTATUS_COBRO) {
		ESTATUS_COBRO = eSTATUS_COBRO;
	}

	@Override
	public String toString() {
		return "VIEW_SIF_CONSECUTIVO_FOLIOS [CANTIDAD=" + CANTIDAD + ", PRECIO_UNITARIO=" + PRECIO_UNITARIO
				+ ", SUBTOTAL=" + SUBTOTAL + ", SUBTOTAL_DESC=" + SUBTOTAL_DESC + ", TIPO_CAMBIO=" + TIPO_CAMBIO
				+ ", TOTAL=" + TOTAL + ", IVA=" + IVA + ", ID_GENERADO_GL=" + ID_GENERADO_GL + ", REFERENCIA="
				+ REFERENCIA + ", CUENTA_CLIENTE=" + CUENTA_CLIENTE + ", CENTRO_COSTOS=" + CENTRO_COSTOS
				+ ", FOLIO_IMPRESO=" + FOLIO_IMPRESO + ", CONCEPTO=" + CONCEPTO + ", RAZON_SOCIAL=" + RAZON_SOCIAL
				+ ", CLAVE_PROCESO=" + CLAVE_PROCESO + ", CUENTA_INGRESO=" + CUENTA_INGRESO + ", FOLIO_INTERNO="
				+ FOLIO_INTERNO + ", CLAVE_CLIENTE=" + CLAVE_CLIENTE + ", CLAVE_NEGOCIO=" + CLAVE_NEGOCIO
				+ ", COMENTARIOS=" + COMENTARIOS + ", RFC=" + RFC + ", CLAVE_SERVICIO=" + CLAVE_SERVICIO + ", ESTATUS="
				+ ESTATUS + ", TEMPORAL=" + TEMPORAL + ", TIPO_DOCUMENTO=" + TIPO_DOCUMENTO + ", DOMICILIO=" + DOMICILIO
				+ ", DESC_NEGOCIO=" + DESC_NEGOCIO + ", NOMBRE_MONEDA=" + NOMBRE_MONEDA + ", DESC_PROCESO="
				+ DESC_PROCESO + ", SERIE=" + SERIE + ", CLAVE_SERVICIO_PARTICULAR=" + CLAVE_SERVICIO_PARTICULAR
				+ ", CLAVE_CATEGORIA_INGRESO=" + CLAVE_CATEGORIA_INGRESO + ", NOMBRE_CORTO=" + NOMBRE_CORTO
				+ ", ESTATUS_COBRO=" + ESTATUS_COBRO + "]";
	}

}
