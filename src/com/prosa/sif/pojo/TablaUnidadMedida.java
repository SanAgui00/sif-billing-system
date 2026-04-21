/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 09/07/2018 #
# Descripcion General : Pojo para mapeo de TablaCatUnidadMedida                #
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
@Table(name = "TBL_SIF_CAT_UNIDAD_MEDIDA")
public class TablaUnidadMedida {
	@Id
	private String unidad_medida;
	private String descripcion;

	public TablaUnidadMedida() {
	}

	public TablaUnidadMedida(String unidad_medida, String descripcion) {
		this.unidad_medida = unidad_medida;
		this.descripcion = descripcion;
	}

	public String getUnidad_medida() {
		return unidad_medida;
	}

	public void setUnidad_medida(String unidad_medida) {
		this.unidad_medida = unidad_medida;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TablaUnidadMedida [unidad_medida=" + unidad_medida + ", descripcion=" + descripcion + "]";
	}

}
