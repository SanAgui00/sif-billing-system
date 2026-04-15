/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 28/06/2018 #
# Descripcion General : Pojo para mapeo de TablaCuentasBanco                   #
# Marca del cambio    : 									                   #
#------------------------------------------------------------------------------#
# Numero de Parametros: N/A                                                    #
# Parametros Entrada  : N/A                                  Formato:          #
# Parametros Salida   : N/A                                  Formato:          #
################################################################################
**/

package com.prosa.sif.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_CAT_CUENTAS_BANCO")
public class TablaBanco {
	@Id
	private Integer id;
	private String cuenta;
	private String rfc_banco;
	private String nom_banco;
	private String tipo_cadena;
	private String estatus;
	private String usuario;
	private Date fecha;
	private Integer id_empresa;

	public TablaBanco() {
	}

	public TablaBanco(Integer id, String cuenta, String rfc_banco, String nom_banco, String tipo_cadena, String estatus,
			String usuario, Date fecha, Integer id_empresa) {
		super();
		this.id = id;
		this.cuenta = cuenta;
		this.rfc_banco = rfc_banco;
		this.nom_banco = nom_banco;
		this.tipo_cadena = tipo_cadena;
		this.estatus = estatus;
		this.usuario = usuario;
		this.fecha = fecha;
		this.id_empresa = id_empresa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getRfc_banco() {
		return rfc_banco;
	}

	public void setRfc_banco(String rfc_banco) {
		this.rfc_banco = rfc_banco;
	}

	public String getNom_banco() {
		return nom_banco;
	}

	public void setNom_banco(String nom_banco) {
		this.nom_banco = nom_banco;
	}

	public String getTipo_cadena() {
		return tipo_cadena;
	}

	public void setTipo_cadena(String tipo_cadena) {
		this.tipo_cadena = tipo_cadena;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(Integer id_empresa) {
		this.id_empresa = id_empresa;
	}

	@Override
	public String toString() {
		return "TablaBanco [id=" + id + ", cuenta=" + cuenta + ", rfc_banco=" + rfc_banco + ", nom_banco=" + nom_banco
				+ ", tipo_cadena=" + tipo_cadena + ", estatus=" + estatus + ", usuario=" + usuario + ", fecha=" + fecha
				+ ", id_empresa=" + id_empresa + "]";
	}

}