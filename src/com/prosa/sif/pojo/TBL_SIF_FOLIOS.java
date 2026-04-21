package com.prosa.sif.pojo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SIF_FOLIOS")
public class TBL_SIF_FOLIOS {

	private String tipo_documento;
	private String serie;
	@Id
	private Integer numero;
	private String estatus;

	// @ManyToOne
	// @JoinColumn(name = "id_documento")
	// private TBL_SIF_FACTURAS id_facturas;
	private Integer id_documento;

	private String usuario_creacion;
	private String usuario_reservacion;
	private String usuario_ult_impresion;
	private String usuario_ult_modific;
	private Date fecha_creacion;
	private Date fecha_reservacion;
	private Date fecha_ult_impresion;
	private Date fecha_ult_modific;
	private String comentarios;
	private String clave_documento;
	private Integer ano_aprobacion;
	private Integer num_aprobacion;
	private String usuario_cancela;
	private Date fecha_cancelacion;
	private Integer id_poliza;

	public TBL_SIF_FOLIOS() {
	}

	public TBL_SIF_FOLIOS(String tipo_documento, String serie, Integer numero, String estatus, Integer id_documento,
			String usuario_creacion, String usuario_reservacion, String usuario_ult_impresion,
			String usuario_ult_modific, Date fecha_creacion, Date fecha_reservacion, Date fecha_ult_impresion,
			Date fecha_ult_modific, String comentarios, String clave_documento, Integer ano_aprobacion,
			Integer num_aprobacion, String usuario_cancela, Date fecha_cancelacion, Integer id_poliza) {
		super();
		this.tipo_documento = tipo_documento;
		this.serie = serie;
		this.numero = numero;
		this.estatus = estatus;
		this.id_documento = id_documento;
		this.usuario_creacion = usuario_creacion;
		this.usuario_reservacion = usuario_reservacion;
		this.usuario_ult_impresion = usuario_ult_impresion;
		this.usuario_ult_modific = usuario_ult_modific;
		this.fecha_creacion = fecha_creacion;
		this.fecha_reservacion = fecha_reservacion;
		this.fecha_ult_impresion = fecha_ult_impresion;
		this.fecha_ult_modific = fecha_ult_modific;
		this.comentarios = comentarios;
		this.clave_documento = clave_documento;
		this.ano_aprobacion = ano_aprobacion;
		this.num_aprobacion = num_aprobacion;
		this.usuario_cancela = usuario_cancela;
		this.fecha_cancelacion = fecha_cancelacion;
		this.id_poliza = id_poliza;
	}

	public String getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Integer getId_documento() {
		return id_documento;
	}

	public void setId_documento(Integer id_documento) {
		this.id_documento = id_documento;
	}

	public String getUsuario_creacion() {
		return usuario_creacion;
	}

	public void setUsuario_creacion(String usuario_creacion) {
		this.usuario_creacion = usuario_creacion;
	}

	public String getUsuario_reservacion() {
		return usuario_reservacion;
	}

	public void setUsuario_reservacion(String usuario_reservacion) {
		this.usuario_reservacion = usuario_reservacion;
	}

	public String getUsuario_ult_impresion() {
		return usuario_ult_impresion;
	}

	public void setUsuario_ult_impresion(String usuario_ult_impresion) {
		this.usuario_ult_impresion = usuario_ult_impresion;
	}

	public String getUsuario_ult_modific() {
		return usuario_ult_modific;
	}

	public void setUsuario_ult_modific(String usuario_ult_modific) {
		this.usuario_ult_modific = usuario_ult_modific;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Date getFecha_reservacion() {
		return fecha_reservacion;
	}

	public void setFecha_reservacion(Date fecha_reservacion) {
		this.fecha_reservacion = fecha_reservacion;
	}

	public Date getFecha_ult_impresion() {
		return fecha_ult_impresion;
	}

	public void setFecha_ult_impresion(Date fecha_ult_impresion) {
		this.fecha_ult_impresion = fecha_ult_impresion;
	}

	public Date getFecha_ult_modific() {
		return fecha_ult_modific;
	}

	public void setFecha_ult_modific(Date fecha_ult_modific) {
		this.fecha_ult_modific = fecha_ult_modific;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getClave_documento() {
		return clave_documento;
	}

	public void setClave_documento(String clave_documento) {
		this.clave_documento = clave_documento;
	}

	public Integer getAno_aprobacion() {
		return ano_aprobacion;
	}

	public void setAno_aprobacion(Integer ano_aprobacion) {
		this.ano_aprobacion = ano_aprobacion;
	}

	public Integer getNum_aprobacion() {
		return num_aprobacion;
	}

	public void setNum_aprobacion(Integer num_aprobacion) {
		this.num_aprobacion = num_aprobacion;
	}

	public String getUsuario_cancela() {
		return usuario_cancela;
	}

	public void setUsuario_cancela(String usuario_cancela) {
		this.usuario_cancela = usuario_cancela;
	}

	public Date getFecha_cancelacion() {
		return fecha_cancelacion;
	}

	public void setFecha_cancelacion(Date fecha_cancelacion) {
		this.fecha_cancelacion = fecha_cancelacion;
	}

	public Integer getId_poliza() {
		return id_poliza;
	}

	public void setId_poliza(Integer id_poliza) {
		this.id_poliza = id_poliza;
	}

	@Override
	public String toString() {
		return "TBL_SIF_FOLIOS [tipo_documento=" + tipo_documento + ", serie=" + serie + ", numero=" + numero
				+ ", estatus=" + estatus + ", id_documento=" + id_documento + ", usuario_creacion=" + usuario_creacion
				+ ", usuario_reservacion=" + usuario_reservacion + ", usuario_ult_impresion=" + usuario_ult_impresion
				+ ", usuario_ult_modific=" + usuario_ult_modific + ", fecha_creacion=" + fecha_creacion
				+ ", fecha_reservacion=" + fecha_reservacion + ", fecha_ult_impresion=" + fecha_ult_impresion
				+ ", fecha_ult_modific=" + fecha_ult_modific + ", comentarios=" + comentarios + ", clave_documento="
				+ clave_documento + ", ano_aprobacion=" + ano_aprobacion + ", num_aprobacion=" + num_aprobacion
				+ ", usuario_cancela=" + usuario_cancela + ", fecha_cancelacion=" + fecha_cancelacion + ", id_poliza="
				+ id_poliza + "]";
	}

}
