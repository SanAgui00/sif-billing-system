/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 15/03/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.pojo;

public class B_ENVIAR_CIFRAS_SUM {

	private String INTERFASE;
	private String NOMBRE_MONEDA;
	private Number TOTAL_IMPORTE;
	private Number TOTAL_CARGO;
	private Number DIFERENCIA;

	public B_ENVIAR_CIFRAS_SUM() {

	}

	public B_ENVIAR_CIFRAS_SUM(String iNTERFASE, String nOMBRE_MONEDA, Number tOTAL_IMPORTE, Number tOTAL_CARGO,
			Number dIFERENCIA) {
		super();
		INTERFASE = iNTERFASE;
		NOMBRE_MONEDA = nOMBRE_MONEDA;
		TOTAL_IMPORTE = tOTAL_IMPORTE;
		TOTAL_CARGO = tOTAL_CARGO;
		DIFERENCIA = dIFERENCIA;
	}

	public String getINTERFASE() {
		return INTERFASE;
	}

	public void setINTERFASE(String iNTERFASE) {
		INTERFASE = iNTERFASE;
	}

	public String getNOMBRE_MONEDA() {
		return NOMBRE_MONEDA;
	}

	public void setNOMBRE_MONEDA(String nOMBRE_MONEDA) {
		NOMBRE_MONEDA = nOMBRE_MONEDA;
	}

	public Number getTOTAL_IMPORTE() {
		return TOTAL_IMPORTE;
	}

	public void setTOTAL_IMPORTE(Number tOTAL_IMPORTE) {
		TOTAL_IMPORTE = tOTAL_IMPORTE;
	}

	public Number getTOTAL_CARGO() {
		return TOTAL_CARGO;
	}

	public void setTOTAL_CARGO(Number tOTAL_CARGO) {
		TOTAL_CARGO = tOTAL_CARGO;
	}

	public Number getDIFERENCIA() {
		return DIFERENCIA;
	}

	public void setDIFERENCIA(Number dIFERENCIA) {
		DIFERENCIA = dIFERENCIA;
	}

	@Override
	public String toString() {
		return "ENVIAR_CIFRAS_SUM [INTERFASE=" + INTERFASE + ", NOMBRE_MONEDA=" + NOMBRE_MONEDA + ", TOTAL_IMPORTE="
				+ TOTAL_IMPORTE + ", TOTAL_CARGO=" + TOTAL_CARGO + ", DIFERENCIA=" + DIFERENCIA + "]";
	}

}
