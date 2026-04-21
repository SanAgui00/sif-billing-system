package com.prosa.sif.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VIEW_SIF_CUENTAS_CLIENTE")
public class ViewClavesCliente {
	@Id
	private Integer id_cuentas_cliente;
	private Integer id_cliente;
	private String clave_externa;
	private Integer id_fuente;
	private String clave;
	private String descripcion;
	private String clave_sistema_salida;
	private Integer b_adquirente;
	private Integer id_agrupador;
	private String clave_cliente;
	private String nombre_corto;
	public ViewClavesCliente() {
		super();
	}
	public ViewClavesCliente(Integer id_cuentas_cliente, Integer id_cliente, String clave_externa, Integer id_fuente,
			String clave, String descripcion, String clave_sistema_salida, Integer b_adquirente, Integer id_agrupador,
			String clave_cliente, String nombre_corto) {
		super();
		this.id_cuentas_cliente = id_cuentas_cliente;
		this.id_cliente = id_cliente;
		this.clave_externa = clave_externa;
		this.id_fuente = id_fuente;
		this.clave = clave;
		this.descripcion = descripcion;
		this.clave_sistema_salida = clave_sistema_salida;
		this.b_adquirente = b_adquirente;
		this.id_agrupador = id_agrupador;
		this.clave_cliente = clave_cliente;
		this.nombre_corto = nombre_corto;
	}
	public Integer getId_cuentas_cliente() {
		return id_cuentas_cliente;
	}
	public void setId_cuentas_cliente(Integer id_cuentas_cliente) {
		this.id_cuentas_cliente = id_cuentas_cliente;
	}
	public Integer getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getClave_externa() {
		return clave_externa;
	}
	public void setClave_externa(String clave_externa) {
		this.clave_externa = clave_externa;
	}
	public Integer getId_fuente() {
		return id_fuente;
	}
	public void setId_fuente(Integer id_fuente) {
		this.id_fuente = id_fuente;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getClave_sistema_salida() {
		return clave_sistema_salida;
	}
	public void setClave_sistema_salida(String clave_sistema_salida) {
		this.clave_sistema_salida = clave_sistema_salida;
	}
	public Integer getB_adquirente() {
		return b_adquirente;
	}
	public void setB_adquirente(Integer b_adquirente) {
		this.b_adquirente = b_adquirente;
	}
	public Integer getId_agrupador() {
		return id_agrupador;
	}
	public void setId_agrupador(Integer id_agrupador) {
		this.id_agrupador = id_agrupador;
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
		
}
