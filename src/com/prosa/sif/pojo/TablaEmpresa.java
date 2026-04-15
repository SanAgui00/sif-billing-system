/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 10/07/2018 #
# Descripcion General : Pojo para mapeo de TablaEmpresas                       #
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
@Table(name = "TBL_SIF_CAT_EMPRESAS")
public class TablaEmpresa {
	@Id
	private Integer id_empresa;
	private String clave_empresa;
	private String razon_social;
	private String curp;
	private String rfc;
	private String tel1;
	private String tel2;
	private String fax;
	private String representante_legal;
	private String email;
	private Integer id_domicilio;
	private String usuario;
	private String estatus;
	private Date fecha_cre;
	private Date fecha_mod;
	private String comentarios;
	private String certificado;
	private String key;
	private String regimen_fiscal;
	private String lugar_expedicion;
	private String version_cfdi_sat;
	private String clave_regfiscal_sat;
	private String clave_lugarexp_sat;

	public TablaEmpresa() {

	}

	public TablaEmpresa(Integer id_empresa, String clave_empresa, String razon_social, String curp, String rfc,
			String tel1, String tel2, String fax, String representante_legal, String email, Integer id_domicilio,
			String usuario, String estatus, Date fecha_cre, Date fecha_mod, String comentarios, String certificado,
			String key, String regimen_fiscal, String lugar_expedicion, String version_cfdi_sat,
			String clave_regfiscal_sat, String clave_lugarexp_sat) {
		super();
		this.id_empresa = id_empresa;
		this.clave_empresa = clave_empresa;
		this.razon_social = razon_social;
		this.curp = curp;
		this.rfc = rfc;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.fax = fax;
		this.representante_legal = representante_legal;
		this.email = email;
		this.id_domicilio = id_domicilio;
		this.usuario = usuario;
		this.estatus = estatus;
		this.fecha_cre = fecha_cre;
		this.fecha_mod = fecha_mod;
		this.comentarios = comentarios;
		this.certificado = certificado;
		this.key = key;
		this.regimen_fiscal = regimen_fiscal;
		this.lugar_expedicion = lugar_expedicion;
		this.version_cfdi_sat = version_cfdi_sat;
		this.clave_regfiscal_sat = clave_regfiscal_sat;
		this.clave_lugarexp_sat = clave_lugarexp_sat;
	}

	public Integer getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(Integer id_empresa) {
		this.id_empresa = id_empresa;
	}

	public String getClave_empresa() {
		return clave_empresa;
	}

	public void setClave_empresa(String clave_empresa) {
		this.clave_empresa = clave_empresa;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getRepresentante_legal() {
		return representante_legal;
	}

	public void setRepresentante_legal(String representante_legal) {
		this.representante_legal = representante_legal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId_domicilio() {
		return id_domicilio;
	}

	public void setId_domicilio(Integer id_domicilio) {
		this.id_domicilio = id_domicilio;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
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

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getCertificado() {
		return certificado;
	}

	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getRegimen_fiscal() {
		return regimen_fiscal;
	}

	public void setRegimen_fiscal(String regimen_fiscal) {
		this.regimen_fiscal = regimen_fiscal;
	}

	public String getLugar_expedicion() {
		return lugar_expedicion;
	}

	public void setLugar_expedicion(String lugar_expedicion) {
		this.lugar_expedicion = lugar_expedicion;
	}

	public String getVersion_cfdi_sat() {
		return version_cfdi_sat;
	}

	public void setVersion_cfdi_sat(String version_cfdi_sat) {
		this.version_cfdi_sat = version_cfdi_sat;
	}

	public String getClave_regfiscal_sat() {
		return clave_regfiscal_sat;
	}

	public void setClave_regfiscal_sat(String clave_regfiscal_sat) {
		this.clave_regfiscal_sat = clave_regfiscal_sat;
	}

	public String getClave_lugarexp_sat() {
		return clave_lugarexp_sat;
	}

	public void setClave_lugarexp_sat(String clave_lugarexp_sat) {
		this.clave_lugarexp_sat = clave_lugarexp_sat;
	}

	@Override
	public String toString() {
		return "TablaEmpresa [id_empresa=" + id_empresa + ", clave_empresa=" + clave_empresa + ", razon_social="
				+ razon_social + ", curp=" + curp + ", rfc=" + rfc + ", tel1=" + tel1 + ", tel2=" + tel2 + ", fax="
				+ fax + ", representante_legal=" + representante_legal + ", email=" + email + ", id_domicilio="
				+ id_domicilio + ", usuario=" + usuario + ", estatus=" + estatus + ", fecha_cre=" + fecha_cre
				+ ", fecha_mod=" + fecha_mod + ", comentarios=" + comentarios + ", certificado=" + certificado
				+ ", key=" + key + ", regimen_fiscal=" + regimen_fiscal + ", lugar_expedicion=" + lugar_expedicion
				+ ", version_cfdi_sat=" + version_cfdi_sat + ", clave_regfiscal_sat=" + clave_regfiscal_sat
				+ ", clave_lugarexp_sat=" + clave_lugarexp_sat + "]";
	}

}
