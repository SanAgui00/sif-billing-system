/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 08/03/2018 #
# Descripcion General : Pojo para mapeo de TBL_SIF_CAT_CLIENTES                #
# Marca del cambio    : 									                   #
#------------------------------------------------------------------------------#
# Numero de Parametros: N/A                                                    #
# Parametros Entrada  : N/A                                  Formato:          #
# Parametros Salida   : N/A                                  Formato:          #
################################################################################
**/
package com.prosa.sif.pojo;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_CAT_CLIENTES")
public class TBL_SIF_CAT_CLIENTES {

	@Id
	private Integer id_cliente;
	private String clave_cliente;

	private Integer id_grupo_vol;

	private Integer id_domicilio;

	private String nombre_corto;
	private String razon_social;
	private String rfc;
	private String curp;
	private BigDecimal fiid;
	private BigDecimal pct_iva;
	private String telefono_pric;
	private BigDecimal b_cliente_consorcio;
	private BigDecimal b_cliente_nacional;
	private BigDecimal b_cliente_socio;
	private BigDecimal b_incluir_rebate;
	private String inf_addicional;
	private String inf_addicional_1;
	private String usuario;
	private String estatus;
	private Date fecha_mod;
	private String comentarios;
	private String clave_formapago_sat;
	private String clave_residfiscal_sat;
	private String numero_idfiscal_sat;

	// @OneToMany(mappedBy = "clientes")
	// private Set<TBL_SIF_FACTURAS> facturas;

	public TBL_SIF_CAT_CLIENTES() {

	}

	public TBL_SIF_CAT_CLIENTES(Integer id_cliente, String clave_cliente, Integer id_grupo_vol, Integer id_domicilio,
			String nombre_corto, String razon_social, String rfc, String curp, BigDecimal fiid, BigDecimal pct_iva,
			String telefono_pric, BigDecimal b_cliente_consorcio, BigDecimal b_cliente_nacional,
			BigDecimal b_cliente_socio, BigDecimal b_incluir_rebate, String inf_addicional, String inf_addicional_1,
			String usuario, String estatus, Date fecha_mod, String comentarios, String clave_formapago_sat,
			String clave_residfiscal_sat, String numero_idfiscal_sat) {
		super();
		this.id_cliente = id_cliente;
		this.clave_cliente = clave_cliente;
		this.id_grupo_vol = id_grupo_vol;
		this.id_domicilio = id_domicilio;
		this.nombre_corto = nombre_corto;
		this.razon_social = razon_social;
		this.rfc = rfc;
		this.curp = curp;
		this.fiid = fiid;
		this.pct_iva = pct_iva;
		this.telefono_pric = telefono_pric;
		this.b_cliente_consorcio = b_cliente_consorcio;
		this.b_cliente_nacional = b_cliente_nacional;
		this.b_cliente_socio = b_cliente_socio;
		this.b_incluir_rebate = b_incluir_rebate;
		this.inf_addicional = inf_addicional;
		this.inf_addicional_1 = inf_addicional_1;
		this.usuario = usuario;
		this.estatus = estatus;
		this.fecha_mod = fecha_mod;
		this.comentarios = comentarios;
		this.clave_formapago_sat = clave_formapago_sat;
		this.clave_residfiscal_sat = clave_residfiscal_sat;
		this.numero_idfiscal_sat = numero_idfiscal_sat;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getClave_cliente() {
		return clave_cliente;
	}

	public void setClave_cliente(String clave_cliente) {
		this.clave_cliente = clave_cliente;
	}

	public Integer getId_grupo_vol() {
		return id_grupo_vol;
	}

	public void setId_grupo_vol(Integer id_grupo_vol) {
		this.id_grupo_vol = id_grupo_vol;
	}

	public Integer getId_domicilio() {
		return id_domicilio;
	}

	public void setId_domicilio(Integer id_domicilio) {
		this.id_domicilio = id_domicilio;
	}

	public String getNombre_corto() {
		return nombre_corto;
	}

	public void setNombre_corto(String nombre_corto) {
		this.nombre_corto = nombre_corto;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public BigDecimal getFiid() {
		return fiid;
	}

	public void setFiid(BigDecimal fiid) {
		this.fiid = fiid;
	}

	public BigDecimal getPct_iva() {
		return pct_iva;
	}

	public void setPct_iva(BigDecimal pct_iva) {
		this.pct_iva = pct_iva;
	}

	public String getTelefono_pric() {
		return telefono_pric;
	}

	public void setTelefono_pric(String telefono_pric) {
		this.telefono_pric = telefono_pric;
	}

	public BigDecimal getB_cliente_consorcio() {
		return b_cliente_consorcio;
	}

	public void setB_cliente_consorcio(BigDecimal b_cliente_consorcio) {
		this.b_cliente_consorcio = b_cliente_consorcio;
	}

	public BigDecimal getB_cliente_nacional() {
		return b_cliente_nacional;
	}

	public void setB_cliente_nacional(BigDecimal b_cliente_nacional) {
		this.b_cliente_nacional = b_cliente_nacional;
	}

	public BigDecimal getB_cliente_socio() {
		return b_cliente_socio;
	}

	public void setB_cliente_socio(BigDecimal b_cliente_socio) {
		this.b_cliente_socio = b_cliente_socio;
	}

	public BigDecimal getB_incluir_rebate() {
		return b_incluir_rebate;
	}

	public void setB_incluir_rebate(BigDecimal b_incluir_rebate) {
		this.b_incluir_rebate = b_incluir_rebate;
	}

	public String getInf_addicional() {
		return inf_addicional;
	}

	public void setInf_addicional(String inf_addicional) {
		this.inf_addicional = inf_addicional;
	}

	public String getInf_addicional_1() {
		return inf_addicional_1;
	}

	public void setInf_addicional_1(String inf_addicional_1) {
		this.inf_addicional_1 = inf_addicional_1;
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

	public String getClave_formapago_sat() {
		return clave_formapago_sat;
	}

	public void setClave_formapago_sat(String clave_formapago_sat) {
		this.clave_formapago_sat = clave_formapago_sat;
	}

	public String getClave_residfiscal_sat() {
		return clave_residfiscal_sat;
	}

	public void setClave_residfiscal_sat(String clave_residfiscal_sat) {
		this.clave_residfiscal_sat = clave_residfiscal_sat;
	}

	public String getNumero_idfiscal_sat() {
		return numero_idfiscal_sat;
	}

	public void setNumero_idfiscal_sat(String numero_idfiscal_sat) {
		this.numero_idfiscal_sat = numero_idfiscal_sat;
	}

	@Override
	public String toString() {
		return "TBL_SIF_CAT_CLIENTES [id_cliente=" + id_cliente + ", clave_cliente=" + clave_cliente + ", id_grupo_vol="
				+ id_grupo_vol + ", id_domicilio=" + id_domicilio + ", nombre_corto=" + nombre_corto + ", razon_social="
				+ razon_social + ", rfc=" + rfc + ", curp=" + curp + ", fiid=" + fiid + ", pct_iva=" + pct_iva
				+ ", telefono_pric=" + telefono_pric + ", b_cliente_consorcio=" + b_cliente_consorcio
				+ ", b_cliente_nacional=" + b_cliente_nacional + ", b_cliente_socio=" + b_cliente_socio
				+ ", b_incluir_rebate=" + b_incluir_rebate + ", inf_addicional=" + inf_addicional
				+ ", inf_addicional_1=" + inf_addicional_1 + ", usuario=" + usuario + ", estatus=" + estatus
				+ ", fecha_mod=" + fecha_mod + ", comentarios=" + comentarios + ", clave_formapago_sat="
				+ clave_formapago_sat + ", clave_residfiscal_sat=" + clave_residfiscal_sat + ", numero_idfiscal_sat="
				+ numero_idfiscal_sat + "]";
	}

}
