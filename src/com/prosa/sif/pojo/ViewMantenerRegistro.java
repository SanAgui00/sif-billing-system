package com.prosa.sif.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VIEW_SIF_MANTENER_REGISTRO")
public class ViewMantenerRegistro {
	@Id
	private Integer id_poliza;
	private Integer id_registro;
	private Integer id_proceso;
	private String clave_proceso;
	private String descripcion_proceso;
	private Integer id_negocio;
	private String clave;
	private String descripcion_negocio;
	private Integer id_cliente;
	private String clave_cliente;
	private String nombre_corto;
	private Integer id_empresa;
	private String razon_social;
	private Integer numero_cuenta_contable;
	private String codigo_centro_costos;
	private String tipo_movimiento;
	private String proyecto;
	private String producto;
	private String temporal;
	private String descripcion_registro;
	private Integer importe;
	public ViewMantenerRegistro() {
		
	}
	public ViewMantenerRegistro(Integer id_poliza, Integer id_registro, Integer id_proceso, String clave_proceso,
			String descripcion_proceso, Integer id_negocio, String clave, String descripcion_negocio,
			Integer id_cliente, String clave_cliente, String nombre_corto, Integer id_empresa, String razon_social,
			Integer numero_cuenta_contable, String codigo_centro_costos, String tipo_movimiento, String proyecto,
			String producto, String temporal, String descripcion_registro, Integer importe) {
		super();
		this.id_poliza = id_poliza;
		this.id_registro = id_registro;
		this.id_proceso = id_proceso;
		this.clave_proceso = clave_proceso;
		this.descripcion_proceso = descripcion_proceso;
		this.id_negocio = id_negocio;
		this.clave = clave;
		this.descripcion_negocio = descripcion_negocio;
		this.id_cliente = id_cliente;
		this.clave_cliente = clave_cliente;
		this.nombre_corto = nombre_corto;
		this.id_empresa = id_empresa;
		this.razon_social = razon_social;
		this.numero_cuenta_contable = numero_cuenta_contable;
		this.codigo_centro_costos = codigo_centro_costos;
		this.tipo_movimiento = tipo_movimiento;
		this.proyecto = proyecto;
		this.producto = producto;
		this.temporal = temporal;
		this.descripcion_registro = descripcion_registro;
		this.importe = importe;
	}
	public Integer getId_poliza() {
		return id_poliza;
	}
	public void setId_poliza(Integer id_poliza) {
		this.id_poliza = id_poliza;
	}
	public Integer getId_registro() {
		return id_registro;
	}
	public void setId_registro(Integer id_registro) {
		this.id_registro = id_registro;
	}
	public Integer getId_proceso() {
		return id_proceso;
	}
	public void setId_proceso(Integer id_proceso) {
		this.id_proceso = id_proceso;
	}
	public String getClave_proceso() {
		return clave_proceso;
	}
	public void setClave_proceso(String clave_proceso) {
		this.clave_proceso = clave_proceso;
	}
	public String getDescripcion_proceso() {
		return descripcion_proceso;
	}
	public void setDescripcion_proceso(String descripcion_proceso) {
		this.descripcion_proceso = descripcion_proceso;
	}
	public Integer getId_negocio() {
		return id_negocio;
	}
	public void setId_negocio(Integer id_negocio) {
		this.id_negocio = id_negocio;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getDescripcion_negocio() {
		return descripcion_negocio;
	}
	public void setDescripcion_negocio(String descripcion_negocio) {
		this.descripcion_negocio = descripcion_negocio;
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
	public String getNombre_corto() {
		return nombre_corto;
	}
	public void setNombre_corto(String nombre_corto) {
		this.nombre_corto = nombre_corto;
	}
	public Integer getId_empresa() {
		return id_empresa;
	}
	public void setId_empresa(Integer id_empresa) {
		this.id_empresa = id_empresa;
	}
	public String getRazon_social() {
		return razon_social;
	}
	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}
	public Integer getNumero_cuenta_contable() {
		return numero_cuenta_contable;
	}
	public void setNumero_cuenta_contable(Integer numero_cuenta_contable) {
		this.numero_cuenta_contable = numero_cuenta_contable;
	}
	public String getCodigo_centro_costos() {
		return codigo_centro_costos;
	}
	public void setCodigo_centro_costos(String codigo_centro_costos) {
		this.codigo_centro_costos = codigo_centro_costos;
	}
	public String getTipo_movimiento() {
		return tipo_movimiento;
	}
	public void setTipo_movimiento(String tipo_movimiento) {
		this.tipo_movimiento = tipo_movimiento;
	}
	public String getProyecto() {
		return proyecto;
	}
	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getTemporal() {
		return temporal;
	}
	public void setTemporal(String temporal) {
		this.temporal = temporal;
	}
	public String getDescripcion_registro() {
		return descripcion_registro;
	}
	public void setDescripcion_registro(String descripcion_registro) {
		this.descripcion_registro = descripcion_registro;
	}
	public Integer getImporte() {
		return importe;
	}
	public void setImporte(Integer importe) {
		this.importe = importe;
	}
	
}
