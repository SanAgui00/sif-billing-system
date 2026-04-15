package com.prosa.sif.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VIEW_SIF_ESTADO_CUENTA")
public class ViewEstadoCuenta {
	@Id
	private Integer id_vista;
	private Integer id_cliente;
	private Integer id_periodo;
	private Integer mon_id_moneda;
	private Integer doc_id_moneda;
	private Integer id_doc;
	private String clave_grupo;
	private String desc_grupo;
	private String clave_neg;
	private String desc_neg;
	private String desc_mon;
	private String clave_cliente;
	private String nombre_corto;
	private String tipo_doc;
	private String num_fac;
	private Integer referencia;
	private Date fecha_cre;
	private String descripcion;
	private Integer subtotal;
	private Integer iva_monto;
	private Integer total_monto;
	private String estatus;
	
	
	public ViewEstadoCuenta() {
		super();
	}


	public ViewEstadoCuenta(Integer id_vista, Integer id_cliente, Integer id_periodo, Integer mon_id_moneda,
			Integer doc_id_moneda, Integer id_doc, String clave_grupo, String desc_grupo, String clave_neg,
			String desc_neg, String desc_mon, String clave_cliente, String nombre_corto, String tipo_doc,
			String num_fac, Integer referencia, Date fecha_cre, String descripcion, Integer subtotal, Integer iva_monto,
			Integer total_monto, String estatus) {
		super();
		this.id_vista = id_vista;
		this.id_cliente = id_cliente;
		this.id_periodo = id_periodo;
		this.mon_id_moneda = mon_id_moneda;
		this.doc_id_moneda = doc_id_moneda;
		this.id_doc = id_doc;
		this.clave_grupo = clave_grupo;
		this.desc_grupo = desc_grupo;
		this.clave_neg = clave_neg;
		this.desc_neg = desc_neg;
		this.desc_mon = desc_mon;
		this.clave_cliente = clave_cliente;
		this.nombre_corto = nombre_corto;
		this.tipo_doc = tipo_doc;
		this.num_fac = num_fac;
		this.referencia = referencia;
		this.fecha_cre = fecha_cre;
		this.descripcion = descripcion;
		this.subtotal = subtotal;
		this.iva_monto = iva_monto;
		this.total_monto = total_monto;
		this.estatus = estatus;
	}


	public Integer getId_vista() {
		return id_vista;
	}


	public void setId_vista(Integer id_vista) {
		this.id_vista = id_vista;
	}


	public Integer getId_cliente() {
		return id_cliente;
	}


	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}


	public Integer getId_periodo() {
		return id_periodo;
	}


	public void setId_periodo(Integer id_periodo) {
		this.id_periodo = id_periodo;
	}


	public Integer getMon_id_moneda() {
		return mon_id_moneda;
	}


	public void setMon_id_moneda(Integer mon_id_moneda) {
		this.mon_id_moneda = mon_id_moneda;
	}


	public Integer getDoc_id_moneda() {
		return doc_id_moneda;
	}


	public void setDoc_id_moneda(Integer doc_id_moneda) {
		this.doc_id_moneda = doc_id_moneda;
	}


	public Integer getId_doc() {
		return id_doc;
	}


	public void setId_doc(Integer id_doc) {
		this.id_doc = id_doc;
	}


	public String getClave_grupo() {
		return clave_grupo;
	}


	public void setClave_grupo(String clave_grupo) {
		this.clave_grupo = clave_grupo;
	}


	public String getDesc_grupo() {
		return desc_grupo;
	}


	public void setDesc_grupo(String desc_grupo) {
		this.desc_grupo = desc_grupo;
	}


	public String getClave_neg() {
		return clave_neg;
	}


	public void setClave_neg(String clave_neg) {
		this.clave_neg = clave_neg;
	}


	public String getDesc_neg() {
		return desc_neg;
	}


	public void setDesc_neg(String desc_neg) {
		this.desc_neg = desc_neg;
	}


	public String getDesc_mon() {
		return desc_mon;
	}


	public void setDesc_mon(String desc_mon) {
		this.desc_mon = desc_mon;
	}


	public String getClave_cliente() {
		return clave_cliente;
	}


	public void setClave_cliente(String clave_cliente) {
		this.clave_cliente = clave_cliente;
	}


	public String getNombre_corto() {
		return nombre_corto;
	}


	public void setNombre_corto(String nombre_corto) {
		this.nombre_corto = nombre_corto;
	}


	public String getTipo_doc() {
		return tipo_doc;
	}


	public void setTipo_doc(String tipo_doc) {
		this.tipo_doc = tipo_doc;
	}


	public String getNum_fac() {
		return num_fac;
	}


	public void setNum_fac(String num_fac) {
		this.num_fac = num_fac;
	}


	public Integer getReferencia() {
		return referencia;
	}


	public void setReferencia(Integer referencia) {
		this.referencia = referencia;
	}


	public Date getFecha_cre() {
		return fecha_cre;
	}


	public void setFecha_cre(Date fecha_cre) {
		this.fecha_cre = fecha_cre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Integer getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(Integer subtotal) {
		this.subtotal = subtotal;
	}


	public Integer getIva_monto() {
		return iva_monto;
	}


	public void setIva_monto(Integer iva_monto) {
		this.iva_monto = iva_monto;
	}


	public Integer getTotal_monto() {
		return total_monto;
	}


	public void setTotal_monto(Integer total_monto) {
		this.total_monto = total_monto;
	}


	public String getEstatus() {
		return estatus;
	}


	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}


	@Override
	public String toString() {
		return "ViewEstadoCuenta [id_vista=" + id_vista + ", id_cliente=" + id_cliente + ", id_periodo=" + id_periodo
				+ ", mon_id_moneda=" + mon_id_moneda + ", doc_id_moneda=" + doc_id_moneda + ", id_doc=" + id_doc
				+ ", clave_grupo=" + clave_grupo + ", desc_grupo=" + desc_grupo + ", clave_neg=" + clave_neg
				+ ", desc_neg=" + desc_neg + ", desc_mon=" + desc_mon + ", clave_cliente=" + clave_cliente
				+ ", nombre_corto=" + nombre_corto + ", tipo_doc=" + tipo_doc + ", num_fac=" + num_fac + ", referencia="
				+ referencia + ", fecha_cre=" + fecha_cre + ", descripcion=" + descripcion + ", subtotal=" + subtotal
				+ ", iva_monto=" + iva_monto + ", total_monto=" + total_monto + ", estatus=" + estatus + "]";
	}
	
	
	
	

}
