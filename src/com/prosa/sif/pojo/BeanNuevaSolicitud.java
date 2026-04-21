package com.prosa.sif.pojo;

public class BeanNuevaSolicitud {
	private Number id;
	private Number id_cliente;
	private Number id_servicio;
	private String clave_servicio;
	private String clave_cliente;
	private String nombre_corto;
	private String unidad_medida;
	private String tipo_cargo;
	private Number precio_controlado;
	private Number id_servicios;
	private Number id_precio;
	private Number id_moneda;
	private String nombre_moneda;
	
	public BeanNuevaSolicitud(){
		
	}

	public BeanNuevaSolicitud(Number id, Number id_cliente, Number id_servicio, String clave_servicio,
			String clave_cliente, String nombre_corto, String unidad_medida, String tipo_cargo,
			Number precio_controlado, Number id_servicios, Number id_precio, Number id_moneda, String nombre_moneda) {
		super();
		this.id = id;
		this.id_cliente = id_cliente;
		this.id_servicio = id_servicio;
		this.clave_servicio = clave_servicio;
		this.clave_cliente = clave_cliente;
		this.nombre_corto = nombre_corto;
		this.unidad_medida = unidad_medida;
		this.tipo_cargo = tipo_cargo;
		this.precio_controlado = precio_controlado;
		this.id_servicios = id_servicios;
		this.id_precio = id_precio;
		this.id_moneda = id_moneda;
		this.nombre_moneda = nombre_moneda;
	}

	public Number getId() {
		return id;
	}

	public void setId(Number id) {
		this.id = id;
	}

	public Number getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Number id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Number getId_servicio() {
		return id_servicio;
	}

	public void setId_servicio(Number id_servicio) {
		this.id_servicio = id_servicio;
	}

	public String getClave_servicio() {
		return clave_servicio;
	}

	public void setClave_servicio(String clave_servicio) {
		this.clave_servicio = clave_servicio;
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

	public String getUnidad_medida() {
		return unidad_medida;
	}

	public void setUnidad_medida(String unidad_medida) {
		this.unidad_medida = unidad_medida;
	}

	public String getTipo_cargo() {
		return tipo_cargo;
	}

	public void setTipo_cargo(String tipo_cargo) {
		this.tipo_cargo = tipo_cargo;
	}

	public Number getPrecio_controlado() {
		return precio_controlado;
	}

	public void setPrecio_controlado(Number precio_controlado) {
		this.precio_controlado = precio_controlado;
	}

	public Number getId_servicios() {
		return id_servicios;
	}

	public void setId_servicios(Number id_servicios) {
		this.id_servicios = id_servicios;
	}

	public Number getId_precio() {
		return id_precio;
	}

	public void setId_precio(Number id_precio) {
		this.id_precio = id_precio;
	}

	public Number getId_moneda() {
		return id_moneda;
	}

	public void setId_moneda(Number id_moneda) {
		this.id_moneda = id_moneda;
	}

	public String getNombre_moneda() {
		return nombre_moneda;
	}

	public void setNombre_moneda(String nombre_moneda) {
		this.nombre_moneda = nombre_moneda;
	}

	@Override
	public String toString() {
		return "BeanNuevaSolicitud [id=" + id + ", id_cliente=" + id_cliente + ", id_servicio=" + id_servicio
				+ ", clave_servicio=" + clave_servicio + ", clave_cliente=" + clave_cliente + ", nombre_corto="
				+ nombre_corto + ", unidad_medida=" + unidad_medida + ", tipo_cargo=" + tipo_cargo
				+ ", precio_controlado=" + precio_controlado + ", id_servicios=" + id_servicios + ", id_precio="
				+ id_precio + ", id_moneda=" + id_moneda + ", nombre_moneda=" + nombre_moneda + "]";
	}
	
}
