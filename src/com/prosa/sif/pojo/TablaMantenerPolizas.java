/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 01/08/2018 #
# Descripcion General : Pojo para mapeo de TablaPolizasContables               #
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
@Table(name = "TBL_SIF_POLIZAS_CONTABLES")
public class TablaMantenerPolizas {
	@Id
	private Integer id_poliza;
	private Integer id_moneda;
	private Integer id_modelo_poliza;
	private Integer id_generado_gl;
	private Integer id_poliza_reversada;
	private String tipo_documento;
	private String lote;
	private Integer tipo_cambio;
	private String estatus;
	private String usuario;
	private String usuario_envio;
	private String usuario_reverso;
	private Date fecha_cre;
	private Date fecha_envio;
	private Date fecha_reverso;
	private String comentarios;
	private Date fecha_datos_ini;
	private Date fecha_datos_fin;
	public TablaMantenerPolizas() {
		
	}
	public TablaMantenerPolizas(Integer id_poliza, Integer id_moneda, Integer id_modelo_poliza, Integer id_generado_gl,
			Integer id_poliza_reversada, String tipo_documento, String lote, Integer tipo_cambio, String estatus,
			String usuario, String usuario_envio, String usuario_reverso, Date fecha_cre, Date fecha_envio,
			Date fecha_reverso, String comentarios, Date fecha_datos_ini, Date fecha_datos_fin) {
		super();
		this.id_poliza = id_poliza;
		this.id_moneda = id_moneda;
		this.id_modelo_poliza = id_modelo_poliza;
		this.id_generado_gl = id_generado_gl;
		this.id_poliza_reversada = id_poliza_reversada;
		this.tipo_documento = tipo_documento;
		this.lote = lote;
		this.tipo_cambio = tipo_cambio;
		this.estatus = estatus;
		this.usuario = usuario;
		this.usuario_envio = usuario_envio;
		this.usuario_reverso = usuario_reverso;
		this.fecha_cre = fecha_cre;
		this.fecha_envio = fecha_envio;
		this.fecha_reverso = fecha_reverso;
		this.comentarios = comentarios;
		this.fecha_datos_ini = fecha_datos_ini;
		this.fecha_datos_fin = fecha_datos_fin;
	}
	public Integer getId_poliza() {
		return id_poliza;
	}
	public void setId_poliza(Integer id_poliza) {
		this.id_poliza = id_poliza;
	}
	public Integer getId_moneda() {
		return id_moneda;
	}
	public void setId_moneda(Integer id_moneda) {
		this.id_moneda = id_moneda;
	}
	public Integer getId_modelo_poliza() {
		return id_modelo_poliza;
	}
	public void setId_modelo_poliza(Integer id_modelo_poliza) {
		this.id_modelo_poliza = id_modelo_poliza;
	}
	public Integer getId_generado_gl() {
		return id_generado_gl;
	}
	public void setId_generado_gl(Integer id_generado_gl) {
		this.id_generado_gl = id_generado_gl;
	}
	public Integer getId_poliza_reversada() {
		return id_poliza_reversada;
	}
	public void setId_poliza_reversada(Integer id_poliza_reversada) {
		this.id_poliza_reversada = id_poliza_reversada;
	}
	public String getTipo_documento() {
		return tipo_documento;
	}
	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public Integer getTipo_cambio() {
		return tipo_cambio;
	}
	public void setTipo_cambio(Integer tipo_cambio) {
		this.tipo_cambio = tipo_cambio;
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
	public String getUsuario_envio() {
		return usuario_envio;
	}
	public void setUsuario_envio(String usuario_envio) {
		this.usuario_envio = usuario_envio;
	}
	public String getUsuario_reverso() {
		return usuario_reverso;
	}
	public void setUsuario_reverso(String usuario_reverso) {
		this.usuario_reverso = usuario_reverso;
	}
	public Date getFecha_cre() {
		return fecha_cre;
	}
	public void setFecha_cre(Date fecha_cre) {
		this.fecha_cre = fecha_cre;
	}
	public Date getFecha_envio() {
		return fecha_envio;
	}
	public void setFecha_envio(Date fecha_envio) {
		this.fecha_envio = fecha_envio;
	}
	public Date getFecha_reverso() {
		return fecha_reverso;
	}
	public void setFecha_reverso(Date fecha_reverso) {
		this.fecha_reverso = fecha_reverso;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public Date getFecha_datos_ini() {
		return fecha_datos_ini;
	}
	public void setFecha_datos_ini(Date fecha_datos_ini) {
		this.fecha_datos_ini = fecha_datos_ini;
	}
	public Date getFecha_datos_fin() {
		return fecha_datos_fin;
	}
	public void setFecha_datos_fin(Date fecha_datos_fin) {
		this.fecha_datos_fin = fecha_datos_fin;
	}
	
	
}
