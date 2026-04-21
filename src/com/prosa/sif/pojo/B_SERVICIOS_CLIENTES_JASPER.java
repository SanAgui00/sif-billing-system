/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 23/08/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.pojo;

public class B_SERVICIOS_CLIENTES_JASPER {

	private Number ID_NEGOCIO;
	private Number ID_CLIENTE;
	private Number ID_GRUPO;
	private String CLAVE_EMPRESA;
	private String RAZON_SOCIAL;
	private String CALLE;
	private String COLONIA;
	private String ESTADO;
	private String NOMBRE_MONEDA;
	private String FOLIO;
	private String CLAVE_NEGOCIO;
	private String DESC_NEGOCIO;
	private String CLAVE_CLIENTE;
	private String NOMBRE_CORTO;
	private String CLAVE_GRUPO;
	private String DESCRIPCION_GRUPO;
	private String CLAVE_SERVICIO;
	private String DESCRIPCION_SERVICIO;
	private Number NUMERO_SUBCONCEPTO;
	private String DESCRIPCION;
	private Number TRANSACCIONES;
	private Number APLICA_PROMEDIO;
	private Number IMPORTE_COBRANZA;
	private Number DESCUENTO;
	private Number DESCUENTO_ADICIONAL;
	private Number TOTAL_IMPORTE_REAL;
	private Number TRANS_SUBCONCEPTO;
	private Number COSTO_SUBCONCEPTO;
	private Number DESC_SUBCONCEPTO;
	private Number REBATE_SUBCONCEPTO;
	private Number TOTAL_SUBCONCEPTO;
	private Number HAY_DESCUENTO;
	private Number HAY_REBATE;
	private Number PRECIO;

	public B_SERVICIOS_CLIENTES_JASPER() {

	}

	public B_SERVICIOS_CLIENTES_JASPER(Number iD_NEGOCIO, Number iD_CLIENTE, Number iD_GRUPO, String cLAVE_EMPRESA,
			String rAZON_SOCIAL, String cALLE, String cOLONIA, String eSTADO, String nOMBRE_MONEDA, String fOLIO,
			String cLAVE_NEGOCIO, String dESC_NEGOCIO, String cLAVE_CLIENTE, String nOMBRE_CORTO, String cLAVE_GRUPO,
			String dESCRIPCION_GRUPO, String cLAVE_SERVICIO, String dESCRIPCION_SERVICIO, Number nUMERO_SUBCONCEPTO,
			String dESCRIPCION, Number tRANSACCIONES, Number aPLICA_PROMEDIO, Number iMPORTE_COBRANZA, Number dESCUENTO,
			Number dESCUENTO_ADICIONAL, Number tOTAL_IMPORTE_REAL, Number tRANS_SUBCONCEPTO, Number cOSTO_SUBCONCEPTO,
			Number dESC_SUBCONCEPTO, Number rEBATE_SUBCONCEPTO, Number tOTAL_SUBCONCEPTO, Number hAY_DESCUENTO,
			Number hAY_REBATE, Number pRECIO) {
		super();
		ID_NEGOCIO = iD_NEGOCIO;
		ID_CLIENTE = iD_CLIENTE;
		ID_GRUPO = iD_GRUPO;
		CLAVE_EMPRESA = cLAVE_EMPRESA;
		RAZON_SOCIAL = rAZON_SOCIAL;
		CALLE = cALLE;
		COLONIA = cOLONIA;
		ESTADO = eSTADO;
		NOMBRE_MONEDA = nOMBRE_MONEDA;
		FOLIO = fOLIO;
		CLAVE_NEGOCIO = cLAVE_NEGOCIO;
		DESC_NEGOCIO = dESC_NEGOCIO;
		CLAVE_CLIENTE = cLAVE_CLIENTE;
		NOMBRE_CORTO = nOMBRE_CORTO;
		CLAVE_GRUPO = cLAVE_GRUPO;
		DESCRIPCION_GRUPO = dESCRIPCION_GRUPO;
		CLAVE_SERVICIO = cLAVE_SERVICIO;
		DESCRIPCION_SERVICIO = dESCRIPCION_SERVICIO;
		NUMERO_SUBCONCEPTO = nUMERO_SUBCONCEPTO;
		DESCRIPCION = dESCRIPCION;
		TRANSACCIONES = tRANSACCIONES;
		APLICA_PROMEDIO = aPLICA_PROMEDIO;
		IMPORTE_COBRANZA = iMPORTE_COBRANZA;
		DESCUENTO = dESCUENTO;
		DESCUENTO_ADICIONAL = dESCUENTO_ADICIONAL;
		TOTAL_IMPORTE_REAL = tOTAL_IMPORTE_REAL;
		TRANS_SUBCONCEPTO = tRANS_SUBCONCEPTO;
		COSTO_SUBCONCEPTO = cOSTO_SUBCONCEPTO;
		DESC_SUBCONCEPTO = dESC_SUBCONCEPTO;
		REBATE_SUBCONCEPTO = rEBATE_SUBCONCEPTO;
		TOTAL_SUBCONCEPTO = tOTAL_SUBCONCEPTO;
		HAY_DESCUENTO = hAY_DESCUENTO;
		HAY_REBATE = hAY_REBATE;
		PRECIO = pRECIO;
	}

	public Number getID_NEGOCIO() {
		return ID_NEGOCIO;
	}

	public void setID_NEGOCIO(Number iD_NEGOCIO) {
		ID_NEGOCIO = iD_NEGOCIO;
	}

	public Number getID_CLIENTE() {
		return ID_CLIENTE;
	}

	public void setID_CLIENTE(Number iD_CLIENTE) {
		ID_CLIENTE = iD_CLIENTE;
	}

	public Number getID_GRUPO() {
		return ID_GRUPO;
	}

	public void setID_GRUPO(Number iD_GRUPO) {
		ID_GRUPO = iD_GRUPO;
	}

	public String getCLAVE_EMPRESA() {
		return CLAVE_EMPRESA;
	}

	public void setCLAVE_EMPRESA(String cLAVE_EMPRESA) {
		CLAVE_EMPRESA = cLAVE_EMPRESA;
	}

	public String getRAZON_SOCIAL() {
		return RAZON_SOCIAL;
	}

	public void setRAZON_SOCIAL(String rAZON_SOCIAL) {
		RAZON_SOCIAL = rAZON_SOCIAL;
	}

	public String getCALLE() {
		return CALLE;
	}

	public void setCALLE(String cALLE) {
		CALLE = cALLE;
	}

	public String getCOLONIA() {
		return COLONIA;
	}

	public void setCOLONIA(String cOLONIA) {
		COLONIA = cOLONIA;
	}

	public String getESTADO() {
		return ESTADO;
	}

	public void setESTADO(String eSTADO) {
		ESTADO = eSTADO;
	}

	public String getNOMBRE_MONEDA() {
		return NOMBRE_MONEDA;
	}

	public void setNOMBRE_MONEDA(String nOMBRE_MONEDA) {
		NOMBRE_MONEDA = nOMBRE_MONEDA;
	}

	public String getFOLIO() {
		return FOLIO;
	}

	public void setFOLIO(String fOLIO) {
		FOLIO = fOLIO;
	}

	public String getCLAVE_NEGOCIO() {
		return CLAVE_NEGOCIO;
	}

	public void setCLAVE_NEGOCIO(String cLAVE_NEGOCIO) {
		CLAVE_NEGOCIO = cLAVE_NEGOCIO;
	}

	public String getDESC_NEGOCIO() {
		return DESC_NEGOCIO;
	}

	public void setDESC_NEGOCIO(String dESC_NEGOCIO) {
		DESC_NEGOCIO = dESC_NEGOCIO;
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

	public String getCLAVE_GRUPO() {
		return CLAVE_GRUPO;
	}

	public void setCLAVE_GRUPO(String cLAVE_GRUPO) {
		CLAVE_GRUPO = cLAVE_GRUPO;
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

	public Number getNUMERO_SUBCONCEPTO() {
		return NUMERO_SUBCONCEPTO;
	}

	public void setNUMERO_SUBCONCEPTO(Number nUMERO_SUBCONCEPTO) {
		NUMERO_SUBCONCEPTO = nUMERO_SUBCONCEPTO;
	}

	public String getDESCRIPCION() {
		return DESCRIPCION;
	}

	public void setDESCRIPCION(String dESCRIPCION) {
		DESCRIPCION = dESCRIPCION;
	}

	public Number getTRANSACCIONES() {
		return TRANSACCIONES;
	}

	public void setTRANSACCIONES(Number tRANSACCIONES) {
		TRANSACCIONES = tRANSACCIONES;
	}

	public Number getAPLICA_PROMEDIO() {
		return APLICA_PROMEDIO;
	}

	public void setAPLICA_PROMEDIO(Number aPLICA_PROMEDIO) {
		APLICA_PROMEDIO = aPLICA_PROMEDIO;
	}

	public Number getIMPORTE_COBRANZA() {
		return IMPORTE_COBRANZA;
	}

	public void setIMPORTE_COBRANZA(Number iMPORTE_COBRANZA) {
		IMPORTE_COBRANZA = iMPORTE_COBRANZA;
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

	public Number getTOTAL_IMPORTE_REAL() {
		return TOTAL_IMPORTE_REAL;
	}

	public void setTOTAL_IMPORTE_REAL(Number tOTAL_IMPORTE_REAL) {
		TOTAL_IMPORTE_REAL = tOTAL_IMPORTE_REAL;
	}

	public Number getTRANS_SUBCONCEPTO() {
		return TRANS_SUBCONCEPTO;
	}

	public void setTRANS_SUBCONCEPTO(Number tRANS_SUBCONCEPTO) {
		TRANS_SUBCONCEPTO = tRANS_SUBCONCEPTO;
	}

	public Number getCOSTO_SUBCONCEPTO() {
		return COSTO_SUBCONCEPTO;
	}

	public void setCOSTO_SUBCONCEPTO(Number cOSTO_SUBCONCEPTO) {
		COSTO_SUBCONCEPTO = cOSTO_SUBCONCEPTO;
	}

	public Number getDESC_SUBCONCEPTO() {
		return DESC_SUBCONCEPTO;
	}

	public void setDESC_SUBCONCEPTO(Number dESC_SUBCONCEPTO) {
		DESC_SUBCONCEPTO = dESC_SUBCONCEPTO;
	}

	public Number getREBATE_SUBCONCEPTO() {
		return REBATE_SUBCONCEPTO;
	}

	public void setREBATE_SUBCONCEPTO(Number rEBATE_SUBCONCEPTO) {
		REBATE_SUBCONCEPTO = rEBATE_SUBCONCEPTO;
	}

	public Number getTOTAL_SUBCONCEPTO() {
		return TOTAL_SUBCONCEPTO;
	}

	public void setTOTAL_SUBCONCEPTO(Number tOTAL_SUBCONCEPTO) {
		TOTAL_SUBCONCEPTO = tOTAL_SUBCONCEPTO;
	}

	public Number getHAY_DESCUENTO() {
		return HAY_DESCUENTO;
	}

	public void setHAY_DESCUENTO(Number hAY_DESCUENTO) {
		HAY_DESCUENTO = hAY_DESCUENTO;
	}

	public Number getHAY_REBATE() {
		return HAY_REBATE;
	}

	public void setHAY_REBATE(Number hAY_REBATE) {
		HAY_REBATE = hAY_REBATE;
	}

	public Number getPRECIO() {
		return PRECIO;
	}

	public void setPRECIO(Number pRECIO) {
		PRECIO = pRECIO;
	}

	@Override
	public String toString() {
		return "B_SERVICIOS_CLIENTES_JASPER [ID_NEGOCIO=" + ID_NEGOCIO + ", ID_CLIENTE=" + ID_CLIENTE + ", ID_GRUPO="
				+ ID_GRUPO + ", CLAVE_EMPRESA=" + CLAVE_EMPRESA + ", RAZON_SOCIAL=" + RAZON_SOCIAL + ", CALLE=" + CALLE
				+ ", COLONIA=" + COLONIA + ", ESTADO=" + ESTADO + ", NOMBRE_MONEDA=" + NOMBRE_MONEDA + ", FOLIO="
				+ FOLIO + ", CLAVE_NEGOCIO=" + CLAVE_NEGOCIO + ", DESC_NEGOCIO=" + DESC_NEGOCIO + ", CLAVE_CLIENTE="
				+ CLAVE_CLIENTE + ", NOMBRE_CORTO=" + NOMBRE_CORTO + ", CLAVE_GRUPO=" + CLAVE_GRUPO
				+ ", DESCRIPCION_GRUPO=" + DESCRIPCION_GRUPO + ", CLAVE_SERVICIO=" + CLAVE_SERVICIO
				+ ", DESCRIPCION_SERVICIO=" + DESCRIPCION_SERVICIO + ", NUMERO_SUBCONCEPTO=" + NUMERO_SUBCONCEPTO
				+ ", DESCRIPCION=" + DESCRIPCION + ", TRANSACCIONES=" + TRANSACCIONES + ", APLICA_PROMEDIO="
				+ APLICA_PROMEDIO + ", IMPORTE_COBRANZA=" + IMPORTE_COBRANZA + ", DESCUENTO=" + DESCUENTO
				+ ", DESCUENTO_ADICIONAL=" + DESCUENTO_ADICIONAL + ", TOTAL_IMPORTE_REAL=" + TOTAL_IMPORTE_REAL
				+ ", TRANS_SUBCONCEPTO=" + TRANS_SUBCONCEPTO + ", COSTO_SUBCONCEPTO=" + COSTO_SUBCONCEPTO
				+ ", DESC_SUBCONCEPTO=" + DESC_SUBCONCEPTO + ", REBATE_SUBCONCEPTO=" + REBATE_SUBCONCEPTO
				+ ", TOTAL_SUBCONCEPTO=" + TOTAL_SUBCONCEPTO + ", HAY_DESCUENTO=" + HAY_DESCUENTO + ", HAY_REBATE="
				+ HAY_REBATE + ", PRECIO=" + PRECIO + "]";
	}

}
