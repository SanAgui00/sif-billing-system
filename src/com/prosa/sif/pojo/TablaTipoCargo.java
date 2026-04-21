/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 16/08/2018 #
# Descripcion General : Pojo para mapeo de TablaCatTiposCargo                  #
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
@Table(name = "TBL_SIF_CAT_TIPOS_CARGO")
public class TablaTipoCargo {
	@Id
	private String tipo_cargo;
	private String descripcion;

	public TablaTipoCargo() {
	}

	public TablaTipoCargo(String tipo_cargo, String descripcion) {

		this.tipo_cargo = tipo_cargo;
		this.descripcion = descripcion;
	}

	public String getTipo_cargo() {
		return tipo_cargo;
	}

	public void setTipo_cargo(String tipo_cargo) {
		this.tipo_cargo = tipo_cargo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TablaTipoCargo [tipo_cargo=" + tipo_cargo + ", descripcion=" + descripcion + "]";
	}

}
