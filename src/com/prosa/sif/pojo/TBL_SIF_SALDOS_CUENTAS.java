package com.prosa.sif.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_SALDOS_CUENTAS")
public class TBL_SIF_SALDOS_CUENTAS {
	@Id
	private Date fecha_aplicacion;
	private Number id_tipo_cuenta;
	private Number id_cliente;
	private Number id_moneda;
	private String numero_cuenta;
	private Number importe;
	private String usuario;
	private Date fecha_cre;
	private Date fecha_mod;
	
	public TBL_SIF_SALDOS_CUENTAS() {
		
	}

	public TBL_SIF_SALDOS_CUENTAS(Date fecha_aplicacion, Number id_tipo_cuenta, Number id_cliente, Number id_moneda,
			String numero_cuenta, Number importe, String usuario, Date fecha_cre, Date fecha_mod) {
		super();
		this.fecha_aplicacion = fecha_aplicacion;
		this.id_tipo_cuenta = id_tipo_cuenta;
		this.id_cliente = id_cliente;
		this.id_moneda = id_moneda;
		this.numero_cuenta = numero_cuenta;
		this.importe = importe;
		this.usuario = usuario;
		this.fecha_cre = fecha_cre;
		this.fecha_mod = fecha_mod;
	}

	public Date getFecha_aplicacion() {
		return fecha_aplicacion;
	}

	public void setFecha_aplicacion(Date fecha_aplicacion) {
		this.fecha_aplicacion = fecha_aplicacion;
	}

	public Number getId_tipo_cuenta() {
		return id_tipo_cuenta;
	}

	public void setId_tipo_cuenta(Number id_tipo_cuenta) {
		this.id_tipo_cuenta = id_tipo_cuenta;
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getFecha_cre() {
		return fecha_cre;
	}

	public void setFecha_cre(Date fecha_cre) {
		this.fecha_cre = fecha_cre;
	}

	public Date getFecha_mod() {
		return fecha_mod;
	}

	public void setFecha_mod(Date fecha_mod) {
		this.fecha_mod = fecha_mod;
	}

	@Override
	public String toString() {
		return "TBL_SIF_SALDOS_CUENTAS [fecha_aplicacion=" + fecha_aplicacion + ", id_tipo_cuenta=" + id_tipo_cuenta
				+ ", id_cliente=" + id_cliente + ", id_moneda=" + id_moneda + ", numero_cuenta=" + numero_cuenta
				+ ", importe=" + importe + ", usuario=" + usuario + ", fecha_cre=" + fecha_cre + ", fecha_mod="
				+ fecha_mod + "]";
	}
	
}
