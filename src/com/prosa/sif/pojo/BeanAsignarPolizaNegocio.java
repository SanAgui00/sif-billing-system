/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 09/08/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.pojo;

public class BeanAsignarPolizaNegocio {
	private Number id_modelo_poliza;
	private String clave;
	public BeanAsignarPolizaNegocio() {
		
	}
	public BeanAsignarPolizaNegocio(Number id_modelo_poliza, String clave) {
		super();
		this.id_modelo_poliza = id_modelo_poliza;
		this.clave = clave;
	}
	public Number getId_modelo_poliza() {
		return id_modelo_poliza;
	}
	public void setId_modelo_poliza(Number id_modelo_poliza) {
		this.id_modelo_poliza = id_modelo_poliza;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	

}
