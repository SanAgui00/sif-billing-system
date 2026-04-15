/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 14/08/2018 #
# Descripcion General : Pojo para mapeo de TablaCatMetodosPago                 #
# Marca del cambio    : 									                   #
#------------------------------------------------------------------------------#
# Numero de Parametros: N/A                                                    #
# Parametros Entrada  : N/A                                  Formato:          #
# Parametros Salida   : N/A                                  Formato:          #
################################################################################
**/

package com.prosa.sif.pojo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_CAT_METODOSPAGO")
public class TablaMetodosPago {
	@Id
	private BigDecimal id;
	private String clave;
	private String descripcion;
	private String cuenta;
	private Integer id_negocio;
	private Integer id_cliente;
	private String estatus;
	private String clave_metodopago_sat;
	private String clave_usocfdi_sat;

	public TablaMetodosPago() {

	}

	public TablaMetodosPago(BigDecimal id, String clave, String descripcion, String cuenta, Integer id_negocio,
			Integer id_cliente, String estatus, String clave_metodopago_sat, String clave_usocfdi_sat) {
		super();
		this.id = id;
		this.clave = clave;
		this.descripcion = descripcion;
		this.cuenta = cuenta;
		this.id_negocio = id_negocio;
		this.id_cliente = id_cliente;
		this.estatus = estatus;
		this.clave_metodopago_sat = clave_metodopago_sat;
		this.clave_usocfdi_sat = clave_usocfdi_sat;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public Integer getId_negocio() {
		return id_negocio;
	}

	public void setId_negocio(Integer id_negocio) {
		this.id_negocio = id_negocio;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getClave_metodopago_sat() {
		return clave_metodopago_sat;
	}

	public void setClave_metodopago_sat(String clave_metodopago_sat) {
		this.clave_metodopago_sat = clave_metodopago_sat;
	}

	public String getClave_usocfdi_sat() {
		return clave_usocfdi_sat;
	}

	public void setClave_usocfdi_sat(String clave_usocfdi_sat) {
		this.clave_usocfdi_sat = clave_usocfdi_sat;
	}

	@Override
	public String toString() {
		return "TablaMetodosPago [id=" + id + ", clave=" + clave + ", descripcion=" + descripcion + ", cuenta=" + cuenta
				+ ", id_negocio=" + id_negocio + ", id_cliente=" + id_cliente + ", estatus=" + estatus
				+ ", clave_metodopago_sat=" + clave_metodopago_sat + ", clave_usocfdi_sat=" + clave_usocfdi_sat + "]";
	}

}
