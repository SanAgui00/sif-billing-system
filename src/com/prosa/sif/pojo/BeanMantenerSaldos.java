package com.prosa.sif.pojo;

import java.util.Date;

public class BeanMantenerSaldos {
	
	private String clave_cliente;
	private String nombre_corto;
	private String descripcion;
	private Date fecha_aplicacion;
	private String numero_cuenta;
	private Number importe;
	private String nombre_moneda;
	private Date fecha_cre;
	private Number id_cliente;
	private Number id_moneda;
	private Number id_tipo_cuenta;
	
	public BeanMantenerSaldos() {
		
	}

	public BeanMantenerSaldos(String clave_cliente, String nombre_corto, String descripcion, Date fecha_aplicacion,
			String numero_cuenta, Number importe, String nombre_moneda, Date fecha_cre, Number id_cliente,
			Number id_moneda, Number id_tipo_cuenta) {
		super();
		this.clave_cliente = clave_cliente;
		this.nombre_corto = nombre_corto;
		this.descripcion = descripcion;
		this.fecha_aplicacion = fecha_aplicacion;
		this.numero_cuenta = numero_cuenta;
		this.importe = importe;
		this.nombre_moneda = nombre_moneda;
		this.fecha_cre = fecha_cre;
		this.id_cliente = id_cliente;
		this.id_moneda = id_moneda;
		this.id_tipo_cuenta = id_tipo_cuenta;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha_aplicacion() {
		return fecha_aplicacion;
	}

	public void setFecha_aplicacion(Date fecha_aplicacion) {
		this.fecha_aplicacion = fecha_aplicacion;
	}

	public String getNumero_cuenta() {
		return numero_cuenta;
	}

	public void setNumero_cuenta(String numero_cuenta) {
		this.numero_cuenta = numero_cuenta;
	}

	public Number getImporte() {
		return importe;
	}

	public void setImporte(Number importe) {
		this.importe = importe;
	}

	public String getNombre_moneda() {
		return nombre_moneda;
	}

	public void setNombre_moneda(String nombre_moneda) {
		this.nombre_moneda = nombre_moneda;
	}

	public Date getFecha_cre() {
		return fecha_cre;
	}

	public void setFecha_cre(Date fecha_cre) {
		this.fecha_cre = fecha_cre;
	}

	public Number getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Number id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Number getId_moneda() {
		return id_moneda;
	}

	public void setId_moneda(Number id_moneda) {
		this.id_moneda = id_moneda;
	}

	public Number getId_tipo_cuenta() {
		return id_tipo_cuenta;
	}

	public void setId_tipo_cuenta(Number id_tipo_cuenta) {
		this.id_tipo_cuenta = id_tipo_cuenta;
	}

	@Override
	public String toString() {
		return "BeanMantenerSaldos [clave_cliente=" + clave_cliente + ", nombre_corto=" + nombre_corto
				+ ", descripcion=" + descripcion + ", fecha_aplicacion=" + fecha_aplicacion + ", numero_cuenta="
				+ numero_cuenta + ", importe=" + importe + ", nombre_moneda=" + nombre_moneda + ", fecha_cre="
				+ fecha_cre + ", id_cliente=" + id_cliente + ", id_moneda=" + id_moneda + ", id_tipo_cuenta="
				+ id_tipo_cuenta + "]";
	}
	
}
