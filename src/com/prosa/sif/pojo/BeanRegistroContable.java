/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 16/08/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.pojo;

public class BeanRegistroContable {
	private Number id_modelo_poliza;
	private Number numero;
	private Number id_empresa;
	private Number id_tipo_cuenta_contable;
	private String tipo_centro_costos;
	private Number id_centro_costos;
	private String tipo_movimiento;
	private String proyecto;
	private String producto;
	private String temporal;
	private String descripcion;
	private String tipo_importe;
	private String razon_social;
	public BeanRegistroContable() {
		super();
	}
	public BeanRegistroContable(Number id_modelo_poliza, Number numero, Number id_empresa,
			Number id_tipo_cuenta_contable, String tipo_centro_costos, Number id_centro_costos, String tipo_movimiento,
			String proyecto, String producto, String temporal, String descripcion, String tipo_importe,
			String razon_social) {
		super();
		this.id_modelo_poliza = id_modelo_poliza;
		this.numero = numero;
		this.id_empresa = id_empresa;
		this.id_tipo_cuenta_contable = id_tipo_cuenta_contable;
		this.tipo_centro_costos = tipo_centro_costos;
		this.id_centro_costos = id_centro_costos;
		this.tipo_movimiento = tipo_movimiento;
		this.proyecto = proyecto;
		this.producto = producto;
		this.temporal = temporal;
		this.descripcion = descripcion;
		this.tipo_importe = tipo_importe;
		this.razon_social = razon_social;
	}
	public Number getId_modelo_poliza() {
		return id_modelo_poliza;
	}
	public void setId_modelo_poliza(Number id_modelo_poliza) {
		this.id_modelo_poliza = id_modelo_poliza;
	}
	public Number getNumero() {
		return numero;
	}
	public void setNumero(Number numero) {
		this.numero = numero;
	}
	public Number getId_empresa() {
		return id_empresa;
	}
	public void setId_empresa(Number id_empresa) {
		this.id_empresa = id_empresa;
	}
	public Number getId_tipo_cuenta_contable() {
		return id_tipo_cuenta_contable;
	}
	public void setId_tipo_cuenta_contable(Number id_tipo_cuenta_contable) {
		this.id_tipo_cuenta_contable = id_tipo_cuenta_contable;
	}
	public String getTipo_centro_costos() {
		return tipo_centro_costos;
	}
	public void setTipo_centro_costos(String tipo_centro_costos) {
		this.tipo_centro_costos = tipo_centro_costos;
	}
	public Number getId_centro_costos() {
		return id_centro_costos;
	}
	public void setId_centro_costos(Number id_centro_costos) {
		this.id_centro_costos = id_centro_costos;
	}
	public String getTipo_movimiento() {
		return tipo_movimiento;
	}
	public void setTipo_movimiento(String tipo_movimiento) {
		this.tipo_movimiento = tipo_movimiento;
	}
	public String getProyecto() {
		return proyecto;
	}
	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getTemporal() {
		return temporal;
	}
	public void setTemporal(String temporal) {
		this.temporal = temporal;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTipo_importe() {
		return tipo_importe;
	}
	public void setTipo_importe(String tipo_importe) {
		this.tipo_importe = tipo_importe;
	}
	public String getRazon_social() {
		return razon_social;
	}
	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}
	
}
