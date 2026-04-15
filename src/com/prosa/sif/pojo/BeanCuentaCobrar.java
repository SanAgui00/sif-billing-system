package com.prosa.sif.pojo;

public class BeanCuentaCobrar {
	private String clave_cliente;
	private String nombre_corto;
	private Number TOTAL_IMPORTE_NETO;
	private Number TOTAL_IMPORTE_IVA;
	private Number TOTAL_IMPORTE_DOCUMENTO;
	private Number id_cliente;
	
	public BeanCuentaCobrar() {
		
	}

	public BeanCuentaCobrar(String clave_cliente, String nombre_corto, Number tOTAL_IMPORTE_NETO,
			Number tOTAL_IMPORTE_IVA, Number tOTAL_IMPORTE_DOCUMENTO, Number id_cliente) {
		super();
		this.clave_cliente = clave_cliente;
		this.nombre_corto = nombre_corto;
		TOTAL_IMPORTE_NETO = tOTAL_IMPORTE_NETO;
		TOTAL_IMPORTE_IVA = tOTAL_IMPORTE_IVA;
		TOTAL_IMPORTE_DOCUMENTO = tOTAL_IMPORTE_DOCUMENTO;
		this.id_cliente = id_cliente;
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

	public Number getTOTAL_IMPORTE_NETO() {
		return TOTAL_IMPORTE_NETO;
	}

	public void setTOTAL_IMPORTE_NETO(Number tOTAL_IMPORTE_NETO) {
		TOTAL_IMPORTE_NETO = tOTAL_IMPORTE_NETO;
	}

	public Number getTOTAL_IMPORTE_IVA() {
		return TOTAL_IMPORTE_IVA;
	}

	public void setTOTAL_IMPORTE_IVA(Number tOTAL_IMPORTE_IVA) {
		TOTAL_IMPORTE_IVA = tOTAL_IMPORTE_IVA;
	}

	public Number getTOTAL_IMPORTE_DOCUMENTO() {
		return TOTAL_IMPORTE_DOCUMENTO;
	}

	public void setTOTAL_IMPORTE_DOCUMENTO(Number tOTAL_IMPORTE_DOCUMENTO) {
		TOTAL_IMPORTE_DOCUMENTO = tOTAL_IMPORTE_DOCUMENTO;
	}

	public Number getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Number id_cliente) {
		this.id_cliente = id_cliente;
	}

	@Override
	public String toString() {
		return "BeanCuentaCobrar [clave_cliente=" + clave_cliente + ", nombre_corto=" + nombre_corto
				+ ", TOTAL_IMPORTE_NETO=" + TOTAL_IMPORTE_NETO + ", TOTAL_IMPORTE_IVA=" + TOTAL_IMPORTE_IVA
				+ ", TOTAL_IMPORTE_DOCUMENTO=" + TOTAL_IMPORTE_DOCUMENTO + ", id_cliente=" + id_cliente + "]";
	}

}
