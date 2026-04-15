package com.prosa.sif.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_CAT_CONV_CVE_CLI")
public class TablaClavesCliente {
	@Id
	private Integer id_cliente;
	private String clave_externa;
	private Integer id_fuente;
	private String clave_sistema_salida;
	private Integer b_adquirente;
	private Integer id_agrupador;
	public TablaClavesCliente() {
		
	}
	public TablaClavesCliente(Integer id_cliente, String clave_externa, Integer id_fuente, String clave_sistema_salida,
			Integer b_adquirente, Integer id_agrupador) {
		
		this.id_cliente = id_cliente;
		this.clave_externa = clave_externa;
		this.id_fuente = id_fuente;
		this.clave_sistema_salida = clave_sistema_salida;
		this.b_adquirente = b_adquirente;
		this.id_agrupador = id_agrupador;
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
	
	

}
