/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 17/07/2018 #
# Descripcion General : Pojo para mapeo de TablaHisServicios                   #
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
@Table(name = "TBL_SIF_HIS_SERVICIOS")
public class TablaHistoricoServicio {
	@Id
	private Integer id;
	private Integer id_fuente;
	private Integer id_precio;
	private Integer id_forma_pago;
	private Integer id_negocio;
	private Integer id_grupo_vol;
	private Integer id_grupo_concepto;
	private Integer id_moneda_importe_adq;
	private Integer id_moneda_adq;
	private Integer id_centro_costos;
	private String clave;
	private String descripcion;
	private String estatus;
	private String banderas_generales;
	private String realizar_emision_fact;
	private String realizar_envio;
	private String realizar_reg_cont;
	private String b_auto_cobro;
	private String b_auto_reg_cont;
	private String banderas_cobro_precio;
	private String detalle_cobro_precio;
	private String banderas_sub_concepto;
	private String informacion_extra;
	private String periocidad;
	private String unidades_medidas;
	private String usuario;
	private Date fecha_cre;
	private Date fecha_mod;
	private String comentarios;
	private Date fecha_cre_his;

	public TablaHistoricoServicio() {

	}

	public TablaHistoricoServicio(Integer id, Integer id_fuente, Integer id_precio, Integer id_forma_pago,
			Integer id_negocio, Integer id_grupo_vol, Integer id_grupo_concepto, Integer id_moneda_importe_adq,
			Integer id_moneda_adq, Integer id_centro_costos, String clave, String descripcion, String estatus,
			String banderas_generales, String realizar_emision_fact, String realizar_envio, String realizar_reg_cont,
			String b_auto_cobro, String b_auto_reg_cont, String banderas_cobro_precio, String detalle_cobro_precio,
			String banderas_sub_concepto, String informacion_extra, String periocidad, String unidades_medidas,
			String usuario, Date fecha_cre, Date fecha_mod, String comentarios, Date fecha_cre_his) {
		super();
		this.id = id;
		this.id_fuente = id_fuente;
		this.id_precio = id_precio;
		this.id_forma_pago = id_forma_pago;
		this.id_negocio = id_negocio;
		this.id_grupo_vol = id_grupo_vol;
		this.id_grupo_concepto = id_grupo_concepto;
		this.id_moneda_importe_adq = id_moneda_importe_adq;
		this.id_moneda_adq = id_moneda_adq;
		this.id_centro_costos = id_centro_costos;
		this.clave = clave;
		this.descripcion = descripcion;
		this.estatus = estatus;
		this.banderas_generales = banderas_generales;
		this.realizar_emision_fact = realizar_emision_fact;
		this.realizar_envio = realizar_envio;
		this.realizar_reg_cont = realizar_reg_cont;
		this.b_auto_cobro = b_auto_cobro;
		this.b_auto_reg_cont = b_auto_reg_cont;
		this.banderas_cobro_precio = banderas_cobro_precio;
		this.detalle_cobro_precio = detalle_cobro_precio;
		this.banderas_sub_concepto = banderas_sub_concepto;
		this.informacion_extra = informacion_extra;
		this.periocidad = periocidad;
		this.unidades_medidas = unidades_medidas;
		this.usuario = usuario;
		this.fecha_cre = fecha_cre;
		this.fecha_mod = fecha_mod;
		this.comentarios = comentarios;
		this.fecha_cre_his = fecha_cre_his;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_fuente() {
		return id_fuente;
	}

	public void setId_fuente(Integer id_fuente) {
		this.id_fuente = id_fuente;
	}

	public Integer getId_precio() {
		return id_precio;
	}

	public void setId_precio(Integer id_precio) {
		this.id_precio = id_precio;
	}

	public Integer getId_forma_pago() {
		return id_forma_pago;
	}

	public void setId_forma_pago(Integer id_forma_pago) {
		this.id_forma_pago = id_forma_pago;
	}

	public Integer getId_negocio() {
		return id_negocio;
	}

	public void setId_negocio(Integer id_negocio) {
		this.id_negocio = id_negocio;
	}

	public Integer getId_grupo_vol() {
		return id_grupo_vol;
	}

	public void setId_grupo_vol(Integer id_grupo_vol) {
		this.id_grupo_vol = id_grupo_vol;
	}

	public Integer getId_grupo_concepto() {
		return id_grupo_concepto;
	}

	public void setId_grupo_concepto(Integer id_grupo_concepto) {
		this.id_grupo_concepto = id_grupo_concepto;
	}

	public Integer getId_moneda_importe_adq() {
		return id_moneda_importe_adq;
	}

	public void setId_moneda_importe_adq(Integer id_moneda_importe_adq) {
		this.id_moneda_importe_adq = id_moneda_importe_adq;
	}

	public Integer getId_moneda_adq() {
		return id_moneda_adq;
	}

	public void setId_moneda_adq(Integer id_moneda_adq) {
		this.id_moneda_adq = id_moneda_adq;
	}

	public Integer getId_centro_costos() {
		return id_centro_costos;
	}

	public void setId_centro_costos(Integer id_centro_costos) {
		this.id_centro_costos = id_centro_costos;
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

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getBanderas_generales() {
		return banderas_generales;
	}

	public void setBanderas_generales(String banderas_generales) {
		this.banderas_generales = banderas_generales;
	}

	public String getRealizar_emision_fact() {
		return realizar_emision_fact;
	}

	public void setRealizar_emision_fact(String realizar_emision_fact) {
		this.realizar_emision_fact = realizar_emision_fact;
	}

	public String getRealizar_envio() {
		return realizar_envio;
	}

	public void setRealizar_envio(String realizar_envio) {
		this.realizar_envio = realizar_envio;
	}

	public String getRealizar_reg_cont() {
		return realizar_reg_cont;
	}

	public void setRealizar_reg_cont(String realizar_reg_cont) {
		this.realizar_reg_cont = realizar_reg_cont;
	}

	public String getB_auto_cobro() {
		return b_auto_cobro;
	}

	public void setB_auto_cobro(String b_auto_cobro) {
		this.b_auto_cobro = b_auto_cobro;
	}

	public String getB_auto_reg_cont() {
		return b_auto_reg_cont;
	}

	public void setB_auto_reg_cont(String b_auto_reg_cont) {
		this.b_auto_reg_cont = b_auto_reg_cont;
	}

	public String getBanderas_cobro_precio() {
		return banderas_cobro_precio;
	}

	public void setBanderas_cobro_precio(String banderas_cobro_precio) {
		this.banderas_cobro_precio = banderas_cobro_precio;
	}

	public String getDetalle_cobro_precio() {
		return detalle_cobro_precio;
	}

	public void setDetalle_cobro_precio(String detalle_cobro_precio) {
		this.detalle_cobro_precio = detalle_cobro_precio;
	}

	public String getBanderas_sub_concepto() {
		return banderas_sub_concepto;
	}

	public void setBanderas_sub_concepto(String banderas_sub_concepto) {
		this.banderas_sub_concepto = banderas_sub_concepto;
	}

	public String getInformacion_extra() {
		return informacion_extra;
	}

	public void setInformacion_extra(String informacion_extra) {
		this.informacion_extra = informacion_extra;
	}

	public String getPeriocidad() {
		return periocidad;
	}

	public void setPeriocidad(String periocidad) {
		this.periocidad = periocidad;
	}

	public String getUnidades_medidas() {
		return unidades_medidas;
	}

	public void setUnidades_medidas(String unidades_medidas) {
		this.unidades_medidas = unidades_medidas;
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

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Date getFecha_cre_his() {
		return fecha_cre_his;
	}

	public void setFecha_cre_his(Date fecha_cre_his) {
		this.fecha_cre_his = fecha_cre_his;
	}

	@Override
	public String toString() {
		return "TablaHistoricoServicio [id=" + id + ", id_fuente=" + id_fuente + ", id_precio=" + id_precio
				+ ", id_forma_pago=" + id_forma_pago + ", id_negocio=" + id_negocio + ", id_grupo_vol=" + id_grupo_vol
				+ ", id_grupo_concepto=" + id_grupo_concepto + ", id_moneda_importe_adq=" + id_moneda_importe_adq
				+ ", id_moneda_adq=" + id_moneda_adq + ", id_centro_costos=" + id_centro_costos + ", clave=" + clave
				+ ", descripcion=" + descripcion + ", estatus=" + estatus + ", banderas_generales=" + banderas_generales
				+ ", realizar_emision_fact=" + realizar_emision_fact + ", realizar_envio=" + realizar_envio
				+ ", realizar_reg_cont=" + realizar_reg_cont + ", b_auto_cobro=" + b_auto_cobro + ", b_auto_reg_cont="
				+ b_auto_reg_cont + ", banderas_cobro_precio=" + banderas_cobro_precio + ", detalle_cobro_precio="
				+ detalle_cobro_precio + ", banderas_sub_concepto=" + banderas_sub_concepto + ", informacion_extra="
				+ informacion_extra + ", periocidad=" + periocidad + ", unidades_medidas=" + unidades_medidas
				+ ", usuario=" + usuario + ", fecha_cre=" + fecha_cre + ", fecha_mod=" + fecha_mod + ", comentarios="
				+ comentarios + ", fecha_cre_his=" + fecha_cre_his + "]";
	}

}
