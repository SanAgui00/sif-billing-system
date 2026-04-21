/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 15/08/2018 #
# Descripcion General : Pojo para mapeo de TablaCatDomicilios                  #
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
@Table(name = "TBL_SIF_CAT_DOMICILIOS")
public class TBL_SIF_CAT_DOMICILIOS {
	@Id
	private Integer id_domicilio;
	private Integer id_codigo_postal;
	private Integer id_pais;

	private String zip_code;
	private String numero_int;
	private String numero_ext;
	private String calle;
	private String ciudad;

	public TBL_SIF_CAT_DOMICILIOS() {

	}

	public TBL_SIF_CAT_DOMICILIOS(Integer id_domicilio, Integer id_codigo_postal, Integer id_pais, String zip_code,
			String numero_int, String numero_ext, String calle, String ciudad) {
		this.id_domicilio = id_domicilio;
		this.id_codigo_postal = id_codigo_postal;
		this.id_pais = id_pais;
		this.zip_code = zip_code;
		this.numero_int = numero_int;
		this.numero_ext = numero_ext;
		this.calle = calle;
		this.ciudad = ciudad;
	}

	public Integer getId_domicilio() {
		return id_domicilio;
	}

	public void setId_domicilio(Integer id_domicilio) {
		this.id_domicilio = id_domicilio;
	}

	public Integer getId_codigo_postal() {
		return id_codigo_postal;
	}

	public void setId_codigo_postal(Integer id_codigo_postal) {
		this.id_codigo_postal = id_codigo_postal;
	}

	public Integer getId_pais() {
		return id_pais;
	}

	public void setId_pais(Integer id_pais) {
		this.id_pais = id_pais;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public String getNumero_int() {
		return numero_int;
	}

	public void setNumero_int(String numero_int) {
		this.numero_int = numero_int;
	}

	public String getNumero_ext() {
		return numero_ext;
	}

	public void setNumero_ext(String numero_ext) {
		this.numero_ext = numero_ext;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "TBL_SIF_CAT_DOMICILIOS [id_domicilio=" + id_domicilio + ", id_codigo_postal=" + id_codigo_postal
				+ ", id_pais=" + id_pais + ", zip_code=" + zip_code + ", numero_int=" + numero_int + ", numero_ext="
				+ numero_ext + ", calle=" + calle + ", ciudad=" + ciudad + "]";
	}

}
