/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 12/09/2018 #
# Descripcion General : Pojo para mapeo de TablaCatConvCveCli                  #
# Marca del cambio    : 									                   #
#------------------------------------------------------------------------------#
# Numero de Parametros: N/A                                                    #
# Parametros Entrada  : N/A                                  Formato:          #
# Parametros Salida   : N/A                                  Formato:          #
################################################################################
**/

package com.prosa.sif.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_CAT_CONV_CVE_CLI")
public class TBL_SIF_CAT_CONV_CVE_CLI {
	@Id
	private Integer id_cliente;
	private String clave_externa;
	private Long id_fuente;
	private String clave_sistema_salida;
	private Integer b_adquirente;
	private Integer id_agrupador;

	public TBL_SIF_CAT_CONV_CVE_CLI() {

	}

	public TBL_SIF_CAT_CONV_CVE_CLI(Integer id_cliente, String clave_externa, Long id_fuente,
			String clave_sistema_salida, Integer b_adquirente, Integer id_agrupador) {
		this.id_cliente = id_cliente;
		this.clave_externa = clave_externa;
		this.id_fuente = id_fuente;
		this.clave_sistema_salida = clave_sistema_salida;
		this.b_adquirente = b_adquirente;
		this.id_agrupador = id_agrupador;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getClave_externa() {
		return clave_externa;
	}

	public void setClave_externa(String clave_externa) {
		this.clave_externa = clave_externa;
	}

	public Long getId_fuente() {
		return id_fuente;
	}

	public void setId_fuente(Long id_fuente) {
		this.id_fuente = id_fuente;
	}

	public String getClave_sistema_salida() {
		return clave_sistema_salida;
	}

	public void setClave_sistema_salida(String clave_sistema_salida) {
		this.clave_sistema_salida = clave_sistema_salida;
	}

	public Integer getB_adquirente() {
		return b_adquirente;
	}

	public void setB_adquirente(Integer b_adquirente) {
		this.b_adquirente = b_adquirente;
	}

	public Integer getId_agrupador() {
		return id_agrupador;
	}

	public void setId_agrupador(Integer id_agrupador) {
		this.id_agrupador = id_agrupador;
	}

	@Override
	public String toString() {
		return "TBL_SIF_CAT_CONV_CVE_CLI [id_cliente=" + id_cliente + ", clave_externa=" + clave_externa
				+ ", id_fuente=" + id_fuente + ", clave_sistema_salida=" + clave_sistema_salida + ", b_adquirente="
				+ b_adquirente + ", id_agrupador=" + id_agrupador + "]";
	}

}
