/**
################################################################################
# Autor               : Valverde Méndez Arturo                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 25/04/2018 #
# Descripcion General : POJO para reporte ODT's                                #
# Marca del cambio    :                                                        #
#------------------------------------------------------------------------------#
# Numero de Parametros: N/A                                                    #
# Parametros Entrada  : N/A                                  Formato:          #
# Parametros Salida   : N/A                                  Formato:          #
################################################################################
**/

package com.prosa.sif.pojo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VIEW_REPORTE_ODT_2")
public class VIEW_REPORTE_ODT_2 {

	private Integer p_id_cliente;
	private BigDecimal numero_odt;
	private Integer p_id_moneda;
	@Id
	private Integer id_vista;
	private Date p_fecha_datos;

	public VIEW_REPORTE_ODT_2() {

	}

	public VIEW_REPORTE_ODT_2(Integer p_id_cliente, BigDecimal numero_odt, Integer p_id_moneda, Integer id_vista,
			Date p_fecha_datos) {
		super();
		this.p_id_cliente = p_id_cliente;
		this.numero_odt = numero_odt;
		this.p_id_moneda = p_id_moneda;
		this.id_vista = id_vista;
		this.p_fecha_datos = p_fecha_datos;
	}

	public Integer getP_id_cliente() {
		return p_id_cliente;
	}

	public void setP_id_cliente(Integer p_id_cliente) {
		this.p_id_cliente = p_id_cliente;
	}

	public BigDecimal getNumero_odt() {
		return numero_odt;
	}

	public void setNumero_odt(BigDecimal numero_odt) {
		this.numero_odt = numero_odt;
	}

	public Integer getP_id_moneda() {
		return p_id_moneda;
	}

	public void setP_id_moneda(Integer p_id_moneda) {
		this.p_id_moneda = p_id_moneda;
	}

	public Integer getId_vista() {
		return id_vista;
	}

	public void setId_vista(Integer id_vista) {
		this.id_vista = id_vista;
	}

	public Date getP_fecha_datos() {
		return p_fecha_datos;
	}

	public void setP_fecha_datos(Date p_fecha_datos) {
		this.p_fecha_datos = p_fecha_datos;
	}

	@Override
	public String toString() {
		return "VIEW_REPORTE_ODT_2 [p_id_cliente=" + p_id_cliente + ", numero_odt=" + numero_odt + ", p_id_moneda="
				+ p_id_moneda + ", id_vista=" + id_vista + ", p_fecha_datos=" + p_fecha_datos + "]";
	}

}
