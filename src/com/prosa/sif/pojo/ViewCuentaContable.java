package com.prosa.sif.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VIEW_SIF_CUENTA_CONTABLE")
public class ViewCuentaContable {
	@Id
	private Integer id_vista;
	private Integer id_cliente;
	private Integer id_tipo_cta_contable;
	private String numero_cuenta;
	private String descripcion;
	private String clave;

	public ViewCuentaContable() {

	}

	public ViewCuentaContable(Integer id_vista, Integer id_cliente, Integer id_tipo_cta_contable, String numero_cuenta,
			String descripcion, String clave) {
		super();
		this.id_vista = id_vista;
		this.id_cliente = id_cliente;
		this.id_tipo_cta_contable = id_tipo_cta_contable;
		this.numero_cuenta = numero_cuenta;
		this.descripcion = descripcion;
		this.clave = clave;
	}

	public Integer getId_vista() {
		return id_vista;
	}

	public void setId_vista(Integer id_vista) {
		this.id_vista = id_vista;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Integer getId_tipo_cta_contable() {
		return id_tipo_cta_contable;
	}

	public void setId_tipo_cta_contable(Integer id_tipo_cta_contable) {
		this.id_tipo_cta_contable = id_tipo_cta_contable;
	}

	public String getNumero_cuenta() {
		return numero_cuenta;
	}

	public void setNumero_cuenta(String numero_cuenta) {
		this.numero_cuenta = numero_cuenta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String toString() {
		return "ViewCuentaContable [id_vista=" + id_vista + ", id_cliente=" + id_cliente + ", id_tipo_cta_contable="
				+ id_tipo_cta_contable + ", numero_cuenta=" + numero_cuenta + ", descripcion=" + descripcion
				+ ", clave=" + clave + "]";
	}

}
