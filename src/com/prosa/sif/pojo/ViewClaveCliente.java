package com.prosa.sif.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VIEW_SIF_CLAVE_CLIENTE")
public class ViewClaveCliente {
	@Id
	private Integer id_clave;
	private Integer id_cliente;
	private String clave_externa;
	private String entrada;
	private String salida;
	private String adquirente;
	private String agrupador;

	public ViewClaveCliente() {
	}

	public ViewClaveCliente(Integer id_clave, Integer id_cliente, String clave_externa, String entrada, String salida,
			String adquirente, String agrupador) {
		super();
		this.id_clave = id_clave;
		this.id_cliente = id_cliente;
		this.clave_externa = clave_externa;
		this.entrada = entrada;
		this.salida = salida;
		this.adquirente = adquirente;
		this.agrupador = agrupador;
	}

	public Integer getId_clave() {
		return id_clave;
	}

	public void setId_clave(Integer id_clave) {
		this.id_clave = id_clave;
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

	public String getEntrada() {
		return entrada;
	}

	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	public String getSalida() {
		return salida;
	}

	public void setSalida(String salida) {
		this.salida = salida;
	}

	public String getAdquirente() {
		return adquirente;
	}

	public void setAdquirente(String adquirente) {
		this.adquirente = adquirente;
	}

	public String getAgrupador() {
		return agrupador;
	}

	public void setAgrupador(String agrupador) {
		this.agrupador = agrupador;
	}

	@Override
	public String toString() {
		return "ViewClaveCliente [id_clave=" + id_clave + ", id_cliente=" + id_cliente + ", clave_externa="
				+ clave_externa + ", entrada=" + entrada + ", salida=" + salida + ", adquirente=" + adquirente
				+ ", agrupador=" + agrupador + "]";
	}

}
