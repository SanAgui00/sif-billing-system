/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 13/08/2018 #
# Descripcion General : Pojo para mapeo de TablaHisClientes                    #
# Marca del cambio    : 									                   #
#------------------------------------------------------------------------------#
# Numero de Parametros: N/A                                                    #
# Parametros Entrada  : N/A                                  Formato:          #
# Parametros Salida   : N/A                                  Formato:          #
################################################################################
**/

package com.prosa.sif.pojo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_HIS_CLIENTES")
public class TablaHistoricoCliente {
	@Id
	private Integer id;
	private Integer id_gpo_vol;
	private String clave_cliente;
	private String tipo_cliente;
	private String estatus_cliente;
	private String nombres_cliente;
	private String registros_cliente;
	private BigDecimal pct_iva_cliente;
	private String informacio_add_cliente;
	private String telefono_cli;
	private String b_incluir_rebate;
	private String clave_dom_fiscal;
	private String dir_fiscal_cli;
	private Date fecha_mod;
	private String usuario;
	private String comentarios;

	public TablaHistoricoCliente() {

	}

	public TablaHistoricoCliente(Integer id, Integer id_gpo_vol, String clave_cliente, String tipo_cliente,
			String estatus_cliente, String nombres_cliente, String registros_cliente, BigDecimal pct_iva_cliente,
			String informacio_add_cliente, String telefono_cli, String b_incluir_rebate, String clave_dom_fiscal,
			String dir_fiscal_cli, Date fecha_mod, String usuario, String comentarios) {
		super();
		this.id = id;
		this.id_gpo_vol = id_gpo_vol;
		this.clave_cliente = clave_cliente;
		this.tipo_cliente = tipo_cliente;
		this.estatus_cliente = estatus_cliente;
		this.nombres_cliente = nombres_cliente;
		this.registros_cliente = registros_cliente;
		this.pct_iva_cliente = pct_iva_cliente;
		this.informacio_add_cliente = informacio_add_cliente;
		this.telefono_cli = telefono_cli;
		this.b_incluir_rebate = b_incluir_rebate;
		this.clave_dom_fiscal = clave_dom_fiscal;
		this.dir_fiscal_cli = dir_fiscal_cli;
		this.fecha_mod = fecha_mod;
		this.usuario = usuario;
		this.comentarios = comentarios;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_gpo_vol() {
		return id_gpo_vol;
	}

	public void setId_gpo_vol(Integer id_gpo_vol) {
		this.id_gpo_vol = id_gpo_vol;
	}

	public String getClave_cliente() {
		return clave_cliente;
	}

	public void setClave_cliente(String clave_cliente) {
		this.clave_cliente = clave_cliente;
	}

	public String getTipo_cliente() {
		return tipo_cliente;
	}

	public void setTipo_cliente(String tipo_cliente) {
		this.tipo_cliente = tipo_cliente;
	}

	public String getEstatus_cliente() {
		return estatus_cliente;
	}

	public void setEstatus_cliente(String estatus_cliente) {
		this.estatus_cliente = estatus_cliente;
	}

	public String getNombres_cliente() {
		return nombres_cliente;
	}

	public void setNombres_cliente(String nombres_cliente) {
		this.nombres_cliente = nombres_cliente;
	}

	public String getRegistros_cliente() {
		return registros_cliente;
	}

	public void setRegistros_cliente(String registros_cliente) {
		this.registros_cliente = registros_cliente;
	}

	public BigDecimal getPct_iva_cliente() {
		return pct_iva_cliente;
	}

	public void setPct_iva_cliente(BigDecimal pct_iva_cliente) {
		this.pct_iva_cliente = pct_iva_cliente;
	}

	public String getInformacio_add_cliente() {
		return informacio_add_cliente;
	}

	public void setInformacio_add_cliente(String informacio_add_cliente) {
		this.informacio_add_cliente = informacio_add_cliente;
	}

	public String getTelefono_cli() {
		return telefono_cli;
	}

	public void setTelefono_cli(String telefono_cli) {
		this.telefono_cli = telefono_cli;
	}

	public String getB_incluir_rebate() {
		return b_incluir_rebate;
	}

	public void setB_incluir_rebate(String b_incluir_rebate) {
		this.b_incluir_rebate = b_incluir_rebate;
	}

	public String getClave_dom_fiscal() {
		return clave_dom_fiscal;
	}

	public void setClave_dom_fiscal(String clave_dom_fiscal) {
		this.clave_dom_fiscal = clave_dom_fiscal;
	}

	public String getDir_fiscal_cli() {
		return dir_fiscal_cli;
	}

	public void setDir_fiscal_cli(String dir_fiscal_cli) {
		this.dir_fiscal_cli = dir_fiscal_cli;
	}

	public Date getFecha_mod() {
		return fecha_mod;
	}

	public void setFecha_mod(Date fecha_mod) {
		this.fecha_mod = fecha_mod;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "TablaHistoricoCliente [id=" + id + ", id_gpo_vol=" + id_gpo_vol + ", clave_cliente=" + clave_cliente
				+ ", tipo_cliente=" + tipo_cliente + ", estatus_cliente=" + estatus_cliente + ", nombres_cliente="
				+ nombres_cliente + ", registros_cliente=" + registros_cliente + ", pct_iva_cliente=" + pct_iva_cliente
				+ ", informacio_add_cliente=" + informacio_add_cliente + ", telefono_cli=" + telefono_cli
				+ ", b_incluir_rebate=" + b_incluir_rebate + ", clave_dom_fiscal=" + clave_dom_fiscal
				+ ", dir_fiscal_cli=" + dir_fiscal_cli + ", fecha_mod=" + fecha_mod + ", usuario=" + usuario
				+ ", comentarios=" + comentarios + "]";
	}

}