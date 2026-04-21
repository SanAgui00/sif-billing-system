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

public class B_SERVICIOS_CLIENTE {

	private String NOMBRE_MONEDA;
	private Number ID_NEGOCIO;
	private String CLAVE_NEGOCIO;
	private Number ID_CLIENTE;
	private String CLAVE_CLIENTE;
	private String NOMBRECORTO;
	private Number ID_GRUPO;
	private String DESCRIPCION_GRUPO;
	private String CLAVE_SERVICIO;
	private String DESCRIPCION_SERVICIO;
	private Number TRANSACCIONES;
	private Number PRECIO;
	private Number IMPORTE_COBRANZA;
	private Number IMPORTE_AJUSTE;
	private Number DESCUENTO;
	private Number DESCUENTO_ADICIONAL;
	private Number PRECIO_APLICADO;
	private Number TOTAL_IMPORTE_REAL;

	public B_SERVICIOS_CLIENTE() {

	}

	public B_SERVICIOS_CLIENTE(String nOMBRE_MONEDA, Number iD_NEGOCIO, String cLAVE_NEGOCIO, Number iD_CLIENTE,
			String cLAVE_CLIENTE, String nOMBRECORTO, Number iD_GRUPO, String dESCRIPCION_GRUPO, String cLAVE_SERVICIO,
			String dESCRIPCION_SERVICIO, Number tRANSACCIONES, Number pRECIO, Number iMPORTE_COBRANZA,
			Number iMPORTE_AJUSTE, Number dESCUENTO, Number dESCUENTO_ADICIONAL, Number pRECIO_APLICADO,
			Number tOTAL_IMPORTE_REAL) {
		super();
		NOMBRE_MONEDA = nOMBRE_MONEDA;
		ID_NEGOCIO = iD_NEGOCIO;
		CLAVE_NEGOCIO = cLAVE_NEGOCIO;
		ID_CLIENTE = iD_CLIENTE;
		CLAVE_CLIENTE = cLAVE_CLIENTE;
		NOMBRECORTO = nOMBRECORTO;
		ID_GRUPO = iD_GRUPO;
		DESCRIPCION_GRUPO = dESCRIPCION_GRUPO;
		CLAVE_SERVICIO = cLAVE_SERVICIO;
		DESCRIPCION_SERVICIO = dESCRIPCION_SERVICIO;
		TRANSACCIONES = tRANSACCIONES;
		PRECIO = pRECIO;
		IMPORTE_COBRANZA = iMPORTE_COBRANZA;
		IMPORTE_AJUSTE = iMPORTE_AJUSTE;
		DESCUENTO = dESCUENTO;
		DESCUENTO_ADICIONAL = dESCUENTO_ADICIONAL;
		PRECIO_APLICADO = pRECIO_APLICADO;
		TOTAL_IMPORTE_REAL = tOTAL_IMPORTE_REAL;
	}

	public String getNOMBRE_MONEDA() {
		return NOMBRE_MONEDA;
	}

	public void setNOMBRE_MONEDA(String nOMBRE_MONEDA) {
		NOMBRE_MONEDA = nOMBRE_MONEDA;
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

	public String getNOMBRECORTO() {
		return NOMBRECORTO;
	}

	public void setNOMBRECORTO(String nOMBRECORTO) {
		NOMBRECORTO = nOMBRECORTO;
	}

	public Number getID_GRUPO() {
		return ID_GRUPO;
	}

	public void setID_GRUPO(Number iD_GRUPO) {
		ID_GRUPO = iD_GRUPO;
	}

	public String getDESCRIPCION_GRUPO() {
		return DESCRIPCION_GRUPO;
	}

	public void setDESCRIPCION_GRUPO(String dESCRIPCION_GRUPO) {
		DESCRIPCION_GRUPO = dESCRIPCION_GRUPO;
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

	public Number getTRANSACCIONES() {
		return TRANSACCIONES;
	}

	public void setTRANSACCIONES(Number tRANSACCIONES) {
		TRANSACCIONES = tRANSACCIONES;
	}

	public Number getPRECIO() {
		return PRECIO;
	}

	public void setPRECIO(Number pRECIO) {
		PRECIO = pRECIO;
	}

	public Number getIMPORTE_COBRANZA() {
		return IMPORTE_COBRANZA;
	}

	public void setIMPORTE_COBRANZA(Number iMPORTE_COBRANZA) {
		IMPORTE_COBRANZA = iMPORTE_COBRANZA;
	}

	public Number getIMPORTE_AJUSTE() {
		return IMPORTE_AJUSTE;
	}

	public void setIMPORTE_AJUSTE(Number iMPORTE_AJUSTE) {
		IMPORTE_AJUSTE = iMPORTE_AJUSTE;
	}

	public Number getDESCUENTO() {
		return DESCUENTO;
	}

	public void setDESCUENTO(Number dESCUENTO) {
		DESCUENTO = dESCUENTO;
	}

	public Number getDESCUENTO_ADICIONAL() {
		return DESCUENTO_ADICIONAL;
	}

	public void setDESCUENTO_ADICIONAL(Number dESCUENTO_ADICIONAL) {
		DESCUENTO_ADICIONAL = dESCUENTO_ADICIONAL;
	}

	public Number getPRECIO_APLICADO() {
		return PRECIO_APLICADO;
	}

	public void setPRECIO_APLICADO(Number pRECIO_APLICADO) {
		PRECIO_APLICADO = pRECIO_APLICADO;
	}

	public Number getTOTAL_IMPORTE_REAL() {
		return TOTAL_IMPORTE_REAL;
	}

	public void setTOTAL_IMPORTE_REAL(Number tOTAL_IMPORTE_REAL) {
		TOTAL_IMPORTE_REAL = tOTAL_IMPORTE_REAL;
	}

	@Override
	public String toString() {
		return "B_SERVICIOS_CLIENTE [NOMBRE_MONEDA=" + NOMBRE_MONEDA + ", ID_NEGOCIO=" + ID_NEGOCIO + ", CLAVE_NEGOCIO="
				+ CLAVE_NEGOCIO + ", ID_CLIENTE=" + ID_CLIENTE + ", CLAVE_CLIENTE=" + CLAVE_CLIENTE + ", NOMBRECORTO="
				+ NOMBRECORTO + ", ID_GRUPO=" + ID_GRUPO + ", DESCRIPCION_GRUPO=" + DESCRIPCION_GRUPO
				+ ", CLAVE_SERVICIO=" + CLAVE_SERVICIO + ", DESCRIPCION_SERVICIO=" + DESCRIPCION_SERVICIO
				+ ", TRANSACCIONES=" + TRANSACCIONES + ", PRECIO=" + PRECIO + ", IMPORTE_COBRANZA=" + IMPORTE_COBRANZA
				+ ", IMPORTE_AJUSTE=" + IMPORTE_AJUSTE + ", DESCUENTO=" + DESCUENTO + ", DESCUENTO_ADICIONAL="
				+ DESCUENTO_ADICIONAL + ", PRECIO_APLICADO=" + PRECIO_APLICADO + ", TOTAL_IMPORTE_REAL="
				+ TOTAL_IMPORTE_REAL + "]";
	}

}
