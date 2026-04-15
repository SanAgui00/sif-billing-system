/**
################################################################################
# Autor               : Valverde Méndez Arturo                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 25/04/2018 #
# Descripcion General : POJO para reporte Cuentas Activas                      #
# Marca del cambio    :                                                        #
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
@Table(name = "VIEW_REPORTE_CUENTAS_ACT_2")
public class ViewReporteCuentaActivaDos {

	@Id
	private BigDecimal id_vistas;
	private BigDecimal id_periodos;
	private String nombre;
	private String clave_cliente;
	private String nombre_corto;
	private BigDecimal trans_credito;
	private BigDecimal trans_debito;
	private BigDecimal total;

	public ViewReporteCuentaActivaDos() {

	}

	public ViewReporteCuentaActivaDos(BigDecimal id_vistas, BigDecimal id_periodos, String nombre,
			String clave_cliente, String nombre_corto, BigDecimal trans_credito, BigDecimal trans_debito,
			BigDecimal total) {
		super();
		this.id_vistas = id_vistas;
		this.id_periodos = id_periodos;
		this.nombre = nombre;
		this.clave_cliente = clave_cliente;
		this.nombre_corto = nombre_corto;
		this.trans_credito = trans_credito;
		this.trans_debito = trans_debito;
		this.total = total;
	}

	public BigDecimal getId_vistas() {
		return id_vistas;
	}

	public void setId_vistas(BigDecimal id_vistas) {
		this.id_vistas = id_vistas;
	}

	public BigDecimal getId_periodos() {
		return id_periodos;
	}

	public void setId_periodos(BigDecimal id_periodos) {
		this.id_periodos = id_periodos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave_cliente() {
		return clave_cliente;
	}

	public void setClave_cliente(String clave_cliente) {
		this.clave_cliente = clave_cliente;
	}

	public String getNombre_corto() {
		return nombre_corto;
	}

	public void setNombre_corto(String nombre_corto) {
		this.nombre_corto = nombre_corto;
	}

	public BigDecimal getTrans_credito() {
		return trans_credito;
	}

	public void setTrans_credito(BigDecimal trans_credito) {
		this.trans_credito = trans_credito;
	}

	public BigDecimal getTrans_debito() {
		return trans_debito;
	}

	public void setTrans_debito(BigDecimal trans_debito) {
		this.trans_debito = trans_debito;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "VIEW_REPORTES_CUENTAS_ACT_2 [id_vistas=" + id_vistas + ", id_periodos=" + id_periodos + ", nombre="
				+ nombre + ", clave_cliente=" + clave_cliente + ", nombre_corto=" + nombre_corto + ", trans_credito="
				+ trans_credito + ", trans_debito=" + trans_debito + ", total=" + total + "]";
	}

}
