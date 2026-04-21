/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente : D-52-8268-17                         Fecha: 01/06/2018 #
# Descripcion General : Bean de mapeo para el Subconceptos y Aplicacioines en  #
#		   				Servicios											   #
# Marca del cambio    : LOGASIF									               #
################################################################################
**/
package com.prosa.sif.pojo;

public class BeanSubconceptoAplicacion {
	// Subconceptos asociados
	private Number id_servicios;
	private String clave;
	private Number numero;
	private String descripcion;
	private String valor;
	private Number id_precio;
	private String tipo_precio;
	private String nombre_moneda;

	// Asignación de Aplicaciones
	private Number id;
	private String descripcion_concepto;

	public BeanSubconceptoAplicacion() {

	}

	public BeanSubconceptoAplicacion(Number id_servicios, String clave, Number numero, String descripcion, String valor,
			Number id_precio, String tipo_precio, String nombre_moneda, Number id, String descripcion_concepto) {
		super();
		this.id_servicios = id_servicios;
		this.clave = clave;
		this.numero = numero;
		this.descripcion = descripcion;
		this.valor = valor;
		this.id_precio = id_precio;
		this.tipo_precio = tipo_precio;
		this.nombre_moneda = nombre_moneda;
		this.id = id;
		this.descripcion_concepto = descripcion_concepto;
	}

	public Number getId_servicios() {
		return id_servicios;
	}

	public void setId_servicios(Number id_servicios) {
		this.id_servicios = id_servicios;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Number getNumero() {
		return numero;
	}

	public void setNumero(Number numero) {
		this.numero = numero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Number getId_precio() {
		return id_precio;
	}

	public void setId_precio(Number id_precio) {
		this.id_precio = id_precio;
	}

	public String getTipo_precio() {
		return tipo_precio;
	}

	public void setTipo_precio(String tipo_precio) {
		this.tipo_precio = tipo_precio;
	}

	public String getNombre_moneda() {
		return nombre_moneda;
	}

	public void setNombre_moneda(String nombre_moneda) {
		this.nombre_moneda = nombre_moneda;
	}

	public Number getId() {
		return id;
	}

	public void setId(Number id) {
		this.id = id;
	}

	public String getDescripcion_concepto() {
		return descripcion_concepto;
	}

	public void setDescripcion_concepto(String descripcion_concepto) {
		this.descripcion_concepto = descripcion_concepto;
	}

	@Override
	public String toString() {
		return "BeanSubconceptoAplicacion [id_servicios=" + id_servicios + ", clave=" + clave + ", numero=" + numero
				+ ", descripcion=" + descripcion + ", valor=" + valor + ", id_precio=" + id_precio + ", tipo_precio="
				+ tipo_precio + ", nombre_moneda=" + nombre_moneda + ", id=" + id + ", descripcion_concepto="
				+ descripcion_concepto + "]";
	}

}