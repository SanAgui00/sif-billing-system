package com.prosa.sif.pojo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VIEW_SIF_PREC_SERVICIO")
public class ViewPrecioServicio {
	@Id
	private BigDecimal id_vista;
	private BigDecimal id;
	private String clave;
	private String clave_cliente;
	private String nombre_corto;
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
	private Integer id_servicio;
	private Integer id_precio;
	private Integer id_forma_pago;
	private Integer id_moneda_cobro;
	private String sistema_cobro;
	private Integer id_moneda_precio_temp_per;

	public ViewPrecioServicio() {

	}

	public ViewPrecioServicio(BigDecimal id_vista, BigDecimal id, String clave, String clave_cliente,
			String nombre_corto, Date fecha_mod, String usuario, String estatus, Date fecha_cre, String comentarios,
			BigDecimal precio_temporal_periodo, BigDecimal porcentaje_descuento, Integer b_incluir_rebate,
			Integer b_incluir_en_ajuste, Integer b_incluir_en_cobranza, Integer id_cliente, Integer id_servicio,
			Integer id_precio, Integer id_forma_pago, Integer id_moneda_cobro, String sistema_cobro,
			Integer id_moneda_precio_temp_per) {
		super();
		this.id_vista = id_vista;
		this.id = id;
		this.clave = clave;
		this.clave_cliente = clave_cliente;
		this.nombre_corto = nombre_corto;
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
		this.id_servicio = id_servicio;
		this.id_precio = id_precio;
		this.id_forma_pago = id_forma_pago;
		this.id_moneda_cobro = id_moneda_cobro;
		this.sistema_cobro = sistema_cobro;
		this.id_moneda_precio_temp_per = id_moneda_precio_temp_per;
	}

	public BigDecimal getId_vista() {
		return id_vista;
	}

	public void setId_vista(BigDecimal id_vista) {
		this.id_vista = id_vista;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
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

	@Override
	public String toString() {
		return "ViewPrecioServicio [id_vista=" + id_vista + ", id=" + id + ", clave=" + clave + ", clave_cliente="
				+ clave_cliente + ", nombre_corto=" + nombre_corto + ", fecha_mod=" + fecha_mod + ", usuario=" + usuario
				+ ", estatus=" + estatus + ", fecha_cre=" + fecha_cre + ", comentarios=" + comentarios
				+ ", precio_temporal_periodo=" + precio_temporal_periodo + ", porcentaje_descuento="
				+ porcentaje_descuento + ", b_incluir_rebate=" + b_incluir_rebate + ", b_incluir_en_ajuste="
				+ b_incluir_en_ajuste + ", b_incluir_en_cobranza=" + b_incluir_en_cobranza + ", id_cliente="
				+ id_cliente + ", id_servicio=" + id_servicio + ", id_precio=" + id_precio + ", id_forma_pago="
				+ id_forma_pago + ", id_moneda_cobro=" + id_moneda_cobro + ", sistema_cobro=" + sistema_cobro
				+ ", id_moneda_precio_temp_per=" + id_moneda_precio_temp_per + "]";
	}

}