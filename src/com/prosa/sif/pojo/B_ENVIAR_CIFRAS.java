/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 12/03/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.pojo;

import java.sql.Timestamp;

public class B_ENVIAR_CIFRAS {

	private Number ID_SERVICIO_COBRABLE;
	private Number ID_CLIENTE;
	private String CLAVE_CLIENTE;
	private String NOMBRE_CORTO;
	private Number ID_NEGOCIO;
	private String CLAVE_NEGOCIO;
	private String DESCRIPCION_NEGOCIO;
	private Number ID_CENTRO_COSTOS;
	private Number ID_PROCESO;
	private String PERIODICIDAD_COBRO;
	private Number ID_MONEDA_COBRO;
	private String SISTEMA_COBRO;
	private String NOMBRE_MONEDA;
	private Timestamp FECHA_DATOS;
	private Timestamp FECHA_COBRO_AREA;
	private Timestamp FECHA_CALCULO;
	private Timestamp FECHA_COBRO_LIBRA;
	private Timestamp FECHA_COBRO_SAC;
	private Number COSTO_SERVICIO;
	private Number DESCUENTO;
	private Number IVA_SERVICIO;
	private String TIPO_DOCUMENTO;
	private Number TIPO_CAMBIO;
	private String FOLIO_INTERNO;
	private String FOLIO_IMPRESION;
	private Timestamp FECHA_COBRO;

	public B_ENVIAR_CIFRAS() {

	}

	public B_ENVIAR_CIFRAS(Number iD_SERVICIO_COBRABLE, Number iD_CLIENTE, String cLAVE_CLIENTE, String nOMBRE_CORTO,
			Number iD_NEGOCIO, String cLAVE_NEGOCIO, String dESCRIPCION_NEGOCIO, Number iD_CENTRO_COSTOS,
			Number iD_PROCESO, String pERIODICIDAD_COBRO, Number iD_MONEDA_COBRO, String sISTEMA_COBRO,
			String nOMBRE_MONEDA, Timestamp fECHA_DATOS, Timestamp fECHA_COBRO_AREA, Timestamp fECHA_CALCULO, Timestamp fECHA_COBRO_LIBRA,
			Timestamp fECHA_COBRO_SAC, Number cOSTO_SERVICIO, Number dESCUENTO, Number iVA_SERVICIO, String tIPO_DOCUMENTO,
			Number tIPO_CAMBIO, String fOLIO_INTERNO, String fOLIO_IMPRESION, Timestamp fECHA_COBRO) {
		super();
		ID_SERVICIO_COBRABLE = iD_SERVICIO_COBRABLE;
		ID_CLIENTE = iD_CLIENTE;
		CLAVE_CLIENTE = cLAVE_CLIENTE;
		NOMBRE_CORTO = nOMBRE_CORTO;
		ID_NEGOCIO = iD_NEGOCIO;
		CLAVE_NEGOCIO = cLAVE_NEGOCIO;
		DESCRIPCION_NEGOCIO = dESCRIPCION_NEGOCIO;
		ID_CENTRO_COSTOS = iD_CENTRO_COSTOS;
		ID_PROCESO = iD_PROCESO;
		PERIODICIDAD_COBRO = pERIODICIDAD_COBRO;
		ID_MONEDA_COBRO = iD_MONEDA_COBRO;
		SISTEMA_COBRO = sISTEMA_COBRO;
		NOMBRE_MONEDA = nOMBRE_MONEDA;
		FECHA_DATOS = fECHA_DATOS;
		FECHA_COBRO_AREA = fECHA_COBRO_AREA;
		FECHA_CALCULO = fECHA_CALCULO;
		FECHA_COBRO_LIBRA = fECHA_COBRO_LIBRA;
		FECHA_COBRO_SAC = fECHA_COBRO_SAC;
		COSTO_SERVICIO = cOSTO_SERVICIO;
		DESCUENTO = dESCUENTO;
		IVA_SERVICIO = iVA_SERVICIO;
		TIPO_DOCUMENTO = tIPO_DOCUMENTO;
		TIPO_CAMBIO = tIPO_CAMBIO;
		FOLIO_INTERNO = fOLIO_INTERNO;
		FOLIO_IMPRESION = fOLIO_IMPRESION;
		FECHA_COBRO = fECHA_COBRO;
	}

	public Number getID_SERVICIO_COBRABLE() {
		return ID_SERVICIO_COBRABLE;
	}

	public void setID_SERVICIO_COBRABLE(Number iD_SERVICIO_COBRABLE) {
		ID_SERVICIO_COBRABLE = iD_SERVICIO_COBRABLE;
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

	public Number getID_CENTRO_COSTOS() {
		return ID_CENTRO_COSTOS;
	}

	public void setID_CENTRO_COSTOS(Number iD_CENTRO_COSTOS) {
		ID_CENTRO_COSTOS = iD_CENTRO_COSTOS;
	}

	public Number getID_PROCESO() {
		return ID_PROCESO;
	}

	public void setID_PROCESO(Number iD_PROCESO) {
		ID_PROCESO = iD_PROCESO;
	}

	public String getPERIODICIDAD_COBRO() {
		return PERIODICIDAD_COBRO;
	}

	public void setPERIODICIDAD_COBRO(String pERIODICIDAD_COBRO) {
		PERIODICIDAD_COBRO = pERIODICIDAD_COBRO;
	}

	public Number getID_MONEDA_COBRO() {
		return ID_MONEDA_COBRO;
	}

	public void setID_MONEDA_COBRO(Number iD_MONEDA_COBRO) {
		ID_MONEDA_COBRO = iD_MONEDA_COBRO;
	}

	public String getSISTEMA_COBRO() {
		return SISTEMA_COBRO;
	}

	public void setSISTEMA_COBRO(String sISTEMA_COBRO) {
		SISTEMA_COBRO = sISTEMA_COBRO;
	}

	public String getNOMBRE_MONEDA() {
		return NOMBRE_MONEDA;
	}

	public void setNOMBRE_MONEDA(String nOMBRE_MONEDA) {
		NOMBRE_MONEDA = nOMBRE_MONEDA;
	}

	public Timestamp getFECHA_DATOS() {
		return FECHA_DATOS;
	}

	public void setFECHA_DATOS(Timestamp fECHA_DATOS) {
		FECHA_DATOS = fECHA_DATOS;
	}

	public Timestamp getFECHA_COBRO_AREA() {
		return FECHA_COBRO_AREA;
	}

	public void setFECHA_COBRO_AREA(Timestamp fECHA_COBRO_AREA) {
		FECHA_COBRO_AREA = fECHA_COBRO_AREA;
	}

	public Timestamp getFECHA_CALCULO() {
		return FECHA_CALCULO;
	}

	public void setFECHA_CALCULO(Timestamp fECHA_CALCULO) {
		FECHA_CALCULO = fECHA_CALCULO;
	}

	public Timestamp getFECHA_COBRO_LIBRA() {
		return FECHA_COBRO_LIBRA;
	}

	public void setFECHA_COBRO_LIBRA(Timestamp fECHA_COBRO_LIBRA) {
		FECHA_COBRO_LIBRA = fECHA_COBRO_LIBRA;
	}

	public Timestamp getFECHA_COBRO_SAC() {
		return FECHA_COBRO_SAC;
	}

	public void setFECHA_COBRO_SAC(Timestamp fECHA_COBRO_SAC) {
		FECHA_COBRO_SAC = fECHA_COBRO_SAC;
	}

	public Number getCOSTO_SERVICIO() {
		return COSTO_SERVICIO;
	}

	public void setCOSTO_SERVICIO(Number cOSTO_SERVICIO) {
		COSTO_SERVICIO = cOSTO_SERVICIO;
	}

	public Number getDESCUENTO() {
		return DESCUENTO;
	}

	public void setDESCUENTO(Number dESCUENTO) {
		DESCUENTO = dESCUENTO;
	}

	public Number getIVA_SERVICIO() {
		return IVA_SERVICIO;
	}

	public void setIVA_SERVICIO(Number iVA_SERVICIO) {
		IVA_SERVICIO = iVA_SERVICIO;
	}

	public String getTIPO_DOCUMENTO() {
		return TIPO_DOCUMENTO;
	}

	public void setTIPO_DOCUMENTO(String tIPO_DOCUMENTO) {
		TIPO_DOCUMENTO = tIPO_DOCUMENTO;
	}

	public Number getTIPO_CAMBIO() {
		return TIPO_CAMBIO;
	}

	public void setTIPO_CAMBIO(Number tIPO_CAMBIO) {
		TIPO_CAMBIO = tIPO_CAMBIO;
	}

	public String getFOLIO_INTERNO() {
		return FOLIO_INTERNO;
	}

	public void setFOLIO_INTERNO(String fOLIO_INTERNO) {
		FOLIO_INTERNO = fOLIO_INTERNO;
	}

	public String getFOLIO_IMPRESION() {
		return FOLIO_IMPRESION;
	}

	public void setFOLIO_IMPRESION(String fOLIO_IMPRESION) {
		FOLIO_IMPRESION = fOLIO_IMPRESION;
	}

	public Timestamp getFECHA_COBRO() {
		return FECHA_COBRO;
	}

	public void setFECHA_COBRO(Timestamp fECHA_COBRO) {
		FECHA_COBRO = fECHA_COBRO;
	}

	@Override
	public String toString() {
		return "ENVIAR_CIFRAS [ID_SERVICIO_COBRABLE=" + ID_SERVICIO_COBRABLE + ", ID_CLIENTE=" + ID_CLIENTE
				+ ", CLAVE_CLIENTE=" + CLAVE_CLIENTE + ", NOMBRE_CORTO=" + NOMBRE_CORTO + ", ID_NEGOCIO=" + ID_NEGOCIO
				+ ", CLAVE_NEGOCIO=" + CLAVE_NEGOCIO + ", DESCRIPCION_NEGOCIO=" + DESCRIPCION_NEGOCIO
				+ ", ID_CENTRO_COSTOS=" + ID_CENTRO_COSTOS + ", ID_PROCESO=" + ID_PROCESO + ", PERIODICIDAD_COBRO="
				+ PERIODICIDAD_COBRO + ", ID_MONEDA_COBRO=" + ID_MONEDA_COBRO + ", SISTEMA_COBRO=" + SISTEMA_COBRO
				+ ", NOMBRE_MONEDA=" + NOMBRE_MONEDA + ", FECHA_DATOS=" + FECHA_DATOS + ", FECHA_COBRO_AREA="
				+ FECHA_COBRO_AREA + ", FECHA_CALCULO=" + FECHA_CALCULO + ", FECHA_COBRO_LIBRA=" + FECHA_COBRO_LIBRA
				+ ", FECHA_COBRO_SAC=" + FECHA_COBRO_SAC + ", COSTO_SERVICIO=" + COSTO_SERVICIO + ", DESCUENTO="
				+ DESCUENTO + ", IVA_SERVICIO=" + IVA_SERVICIO + ", TIPO_DOCUMENTO=" + TIPO_DOCUMENTO + ", TIPO_CAMBIO="
				+ TIPO_CAMBIO + ", FOLIO_INTERNO=" + FOLIO_INTERNO + ", FOLIO_IMPRESION=" + FOLIO_IMPRESION
				+ ", FECHA_COBRO=" + FECHA_COBRO + "]";
	}

}
