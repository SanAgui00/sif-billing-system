package com.prosa.sif.pojo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VIEW_SIF_PREC_SERVICIO_CLIENTE")
public class ViewPrecioServicioCliente {

	@Id
	private BigDecimal id_vista;
	private Integer id_servicio;
	private Integer id_precio;
	private Integer id_forma_pago;
	private Integer id_moneda_cobro;
	private String sistema_cobro;
	private Integer id_moneda_precio_temp_per;
	private Integer id_grupo_concepto;
	private String clave_grupo;
	private String clave_cliente;
	private Integer b_id_cliente;
	private String clave_servicio;
	private String descripcion;
	private String clave_negocio;
	private BigDecimal id;
	private Date fecha_mod;
	private String usuario;
	private String estatus;
	private Date fecha_cre;
	private String comentarios;
	private BigDecimal precio_temporal_periodo;
	private BigDecimal porcentaje_descuento;
	private Integer b_incluir_rebate;
	private Integer b_incluir_en_ajuste;
	private Integer b_incluir_en_cobranza;
	private Integer id_cliente;

	public ViewPrecioServicioCliente() {
	}

	public ViewPrecioServicioCliente(BigDecimal id_vista, Integer id_servicio, Integer id_precio, Integer id_forma_pago,
			Integer id_moneda_cobro, String sistema_cobro, Integer id_moneda_precio_temp_per, Integer id_grupo_concepto,
			String clave_grupo, String clave_cliente, Integer b_id_cliente, String clave_servicio, String descripcion,
			String clave_negocio, BigDecimal id, Date fecha_mod, String usuario, String estatus, Date fecha_cre,
			String comentarios, BigDecimal precio_temporal_periodo, BigDecimal porcentaje_descuento,
			Integer b_incluir_rebate, Integer b_incluir_en_ajuste, Integer b_incluir_en_cobranza, Integer id_cliente) {
		super();
		this.id_vista = id_vista;
		this.id_servicio = id_servicio;
		this.id_precio = id_precio;
		this.id_forma_pago = id_forma_pago;
		this.id_moneda_cobro = id_moneda_cobro;
		this.sistema_cobro = sistema_cobro;
		this.id_moneda_precio_temp_per = id_moneda_precio_temp_per;
		this.id_grupo_concepto = id_grupo_concepto;
		this.clave_grupo = clave_grupo;
		this.clave_cliente = clave_cliente;
		this.b_id_cliente = b_id_cliente;
		this.clave_servicio = clave_servicio;
		this.descripcion = descripcion;
		this.clave_negocio = clave_negocio;
		this.id = id;
		this.fecha_mod = fecha_mod;
		this.usuario = usuario;
		this.estatus = estatus;
		this.fecha_cre = fecha_cre;
		this.comentarios = comentarios;
		this.precio_temporal_periodo = precio_temporal_periodo;
		this.porcentaje_descuento = porcentaje_descuento;
		this.b_incluir_rebate = b_incluir_rebate;
		this.b_incluir_en_ajuste = b_incluir_en_ajuste;
		this.b_incluir_en_cobranza = b_incluir_en_cobranza;
		this.id_cliente = id_cliente;
	}

	public BigDecimal getId_vista() {
		return id_vista;
	}

	public void setId_vista(BigDecimal id_vista) {
		this.id_vista = id_vista;
	}

	public Integer getId_servicio() {
		return id_servicio;
	}

	public void setId_servicio(Integer id_servicio) {
		this.id_servicio = id_servicio;
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

	public Integer getId_moneda_cobro() {
		return id_moneda_cobro;
	}

	public void setId_moneda_cobro(Integer id_moneda_cobro) {
		this.id_moneda_cobro = id_moneda_cobro;
	}

	public String getSistema_cobro() {
		return sistema_cobro;
	}

	public void setSistema_cobro(String sistema_cobro) {
		this.sistema_cobro = sistema_cobro;
	}

	public Integer getId_moneda_precio_temp_per() {
		return id_moneda_precio_temp_per;
	}

	public void setId_moneda_precio_temp_per(Integer id_moneda_precio_temp_per) {
		this.id_moneda_precio_temp_per = id_moneda_precio_temp_per;
	}

	public Integer getId_grupo_concepto() {
		return id_grupo_concepto;
	}

	public void setId_grupo_concepto(Integer id_grupo_concepto) {
		this.id_grupo_concepto = id_grupo_concepto;
	}

	public String getClave_grupo() {
		return clave_grupo;
	}

	public void setClave_grupo(String clave_grupo) {
		this.clave_grupo = clave_grupo;
	}

	public String getClave_cliente() {
		return clave_cliente;
	}

	public void setClave_cliente(String clave_cliente) {
		this.clave_cliente = clave_cliente;
	}

	public Integer getB_id_cliente() {
		return b_id_cliente;
	}

	public void setB_id_cliente(Integer b_id_cliente) {
		this.b_id_cliente = b_id_cliente;
	}

	public String getClave_servicio() {
		return clave_servicio;
	}

	public void setClave_servicio(String clave_servicio) {
		this.clave_servicio = clave_servicio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getClave_negocio() {
		return clave_negocio;
	}

	public void setClave_negocio(String clave_negocio) {
		this.clave_negocio = clave_negocio;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
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

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public BigDecimal getPrecio_temporal_periodo() {
		return precio_temporal_periodo;
	}

	public void setPrecio_temporal_periodo(BigDecimal precio_temporal_periodo) {
		this.precio_temporal_periodo = precio_temporal_periodo;
	}

	public BigDecimal getPorcentaje_descuento() {
		return porcentaje_descuento;
	}

	public void setPorcentaje_descuento(BigDecimal porcentaje_descuento) {
		this.porcentaje_descuento = porcentaje_descuento;
	}

	public Integer getB_incluir_rebate() {
		return b_incluir_rebate;
	}

	public void setB_incluir_rebate(Integer b_incluir_rebate) {
		this.b_incluir_rebate = b_incluir_rebate;
	}

	public Integer getB_incluir_en_ajuste() {
		return b_incluir_en_ajuste;
	}

	public void setB_incluir_en_ajuste(Integer b_incluir_en_ajuste) {
		this.b_incluir_en_ajuste = b_incluir_en_ajuste;
	}

	public Integer getB_incluir_en_cobranza() {
		return b_incluir_en_cobranza;
	}

	public void setB_incluir_en_cobranza(Integer b_incluir_en_cobranza) {
		this.b_incluir_en_cobranza = b_incluir_en_cobranza;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	@Override
	public String toString() {
		return "ViewServicioCliente [id_vista=" + id_vista + ", id_servicio=" + id_servicio + ", id_precio=" + id_precio
				+ ", id_forma_pago=" + id_forma_pago + ", id_moneda_cobro=" + id_moneda_cobro + ", sistema_cobro="
				+ sistema_cobro + ", id_moneda_precio_temp_per=" + id_moneda_precio_temp_per + ", id_grupo_concepto="
				+ id_grupo_concepto + ", clave_grupo=" + clave_grupo + ", clave_cliente=" + clave_cliente
				+ ", b_id_cliente=" + b_id_cliente + ", clave_servicio=" + clave_servicio + ", descripcion="
				+ descripcion + ", clave_negocio=" + clave_negocio + ", id=" + id + ", fecha_mod=" + fecha_mod
				+ ", usuario=" + usuario + ", estatus=" + estatus + ", fecha_cre=" + fecha_cre + ", comentarios="
				+ comentarios + ", precio_temporal_periodo=" + precio_temporal_periodo + ", porcentaje_descuento="
				+ porcentaje_descuento + ", b_incluir_rebate=" + b_incluir_rebate + ", b_incluir_en_ajuste="
				+ b_incluir_en_ajuste + ", b_incluir_en_cobranza=" + b_incluir_en_cobranza + ", id_cliente="
				+ id_cliente + "]";
	}
}