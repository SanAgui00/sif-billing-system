/**
################################################################################
# Autor               : Valverde Méndez Arturo                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 25/04/2018 #
# Descripcion General : POJO para reporte Cobranza Diaria                      #
# Marca del cambio    :                                                        #
#------------------------------------------------------------------------------#
# Numero de Parametros: N/A                                                    #
# Parametros Entrada  : N/A                                  Formato:          #
# Parametros Salida   : N/A                                  Formato:          #
################################################################################
**/
package com.prosa.sif.pojo;

import java.math.BigDecimal;

public class COBRANZA_DIARIA {

	private String clave_negocio;
	private String descripcion_negocio;
	private BigDecimal total_trx_cobdia;
	private BigDecimal total_imp_cobdia;
	private BigDecimal total_imp_ajuste;
	private BigDecimal total_desc_especial;
	private BigDecimal total_desc_adicional;

	public COBRANZA_DIARIA(String clave_negocio, String descripcion_negocio, BigDecimal total_trx_cobdia,
			BigDecimal total_imp_cobdia, BigDecimal total_imp_ajuste, BigDecimal total_desc_especial, BigDecimal total_desc_adicional) {
		super();
		this.clave_negocio = clave_negocio;
		this.descripcion_negocio = descripcion_negocio;
		this.total_trx_cobdia = total_trx_cobdia;
		this.total_imp_cobdia = total_imp_cobdia;
		this.total_imp_ajuste = total_imp_ajuste;
		this.total_desc_especial = total_desc_especial;
		this.total_desc_adicional = total_desc_adicional;
	}

	public String getClave_negocio() {
		return clave_negocio;
	}

	public void setClave_negocio(String clave_negocio) {
		this.clave_negocio = clave_negocio;
	}

	public String getDescripcion_negocio() {
		return descripcion_negocio;
	}

	public void setDescripcion_negocio(String descripcion_negocio) {
		this.descripcion_negocio = descripcion_negocio;
	}

	public BigDecimal getTotal_trx_cobdia() {
		return total_trx_cobdia;
	}

	public void setTotal_trx_cobdia(BigDecimal total_trx_cobdia) {
		this.total_trx_cobdia = total_trx_cobdia;
	}

	public BigDecimal getTotal_imp_cobdia() {
		return total_imp_cobdia;
	}

	public void setTotal_imp_cobdia(BigDecimal total_imp_cobdia) {
		this.total_imp_cobdia = total_imp_cobdia;
	}

	public BigDecimal getTotal_imp_ajuste() {
		return total_imp_ajuste;
	}

	public void setTotal_imp_ajuste(BigDecimal total_imp_ajuste) {
		this.total_imp_ajuste = total_imp_ajuste;
	}

	public BigDecimal getTotal_desc_especial() {
		return total_desc_especial;
	}

	public void setTotal_desc_especial(BigDecimal total_desc_especial) {
		this.total_desc_especial = total_desc_especial;
	}

	public BigDecimal getTotal_desc_adicional() {
		return total_desc_adicional;
	}

	public void setTotal_desc_adicional(BigDecimal total_desc_adicional) {
		this.total_desc_adicional = total_desc_adicional;
	}

	@Override
	public String toString() {
		return "COBRANZA_DIARIA [clave_negocio=" + clave_negocio + ", descripcion_negocio=" + descripcion_negocio
				+ ", total_trx_cobdia=" + total_trx_cobdia + ", total_imp_cobdia=" + total_imp_cobdia
				+ ", total_imp_ajuste=" + total_imp_ajuste + ", total_desc_especial=" + total_desc_especial
				+ ", total_desc_adicional=" + total_desc_adicional + "]";
	}

}
