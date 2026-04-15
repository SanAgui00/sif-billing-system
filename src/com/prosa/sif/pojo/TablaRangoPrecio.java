/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 08/08/2018 #
# Descripcion General :                                                        #
# Marca del cambio    : 									                   #
#------------------------------------------------------------------------------#
# Numero de Parametros: N/A                                                    #
# Parametros Entrada  : N/A                                  Formato:          #
# Parametros Salida   : N/A                                  Formato:          #
################################################################################
**/

package com.prosa.sif.pojo;

public class TablaRangoPrecio {

	private Number id_precio;
	private Number rango_inicial;
	private Number rango_final;
	private Number precio;
	private Number cuota_fija;

	public TablaRangoPrecio() {

	}

	public TablaRangoPrecio(Number id_precio, Number rango_inicial, Number rango_final, Number precio,
			Number cuota_fija) {
		super();
		this.id_precio = id_precio;
		this.rango_inicial = rango_inicial;
		this.rango_final = rango_final;
		this.precio = precio;
		this.cuota_fija = cuota_fija;
	}

	public Number getId_precio() {
		return id_precio;
	}

	public void setId_precio(Number id_precio) {
		this.id_precio = id_precio;
	}

	public Number getRango_inicial() {
		return rango_inicial;
	}

	public void setRango_inicial(Number rango_inicial) {
		this.rango_inicial = rango_inicial;
	}

	public Number getRango_final() {
		return rango_final;
	}

	public void setRango_final(Number rango_final) {
		this.rango_final = rango_final;
	}

	public Number getPrecio() {
		return precio;
	}

	public void setPrecio(Number precio) {
		this.precio = precio;
	}

	public Number getCuota_fija() {
		return cuota_fija;
	}

	public void setCuota_fija(Number cuota_fija) {
		this.cuota_fija = cuota_fija;
	}

	@Override
	public String toString() {
		return "TablaRangoPrecio [id_precio=" + id_precio + ", rango_inicial=" + rango_inicial + ", rango_final="
				+ rango_final + ", precio=" + precio + ", cuota_fija=" + cuota_fija + "]";
	}

}