/**
################################################################################
# Autor               : Valverde Méndez Arturo                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 25/04/2018 #
# Descripcion General : POJO para reporte ODT's 	 	                       #
# Marca del cambio    :                                                        #
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
@Table(name = "VIEW_REPORTE_ODT")
public class VIEW_REPORTE_ODT {

	private Date fecha_datos;
	@Id
	private Integer id_vista;
	private BigDecimal neto;
	private BigDecimal total;
	private BigDecimal iva;
	private BigDecimal importe;
	private BigDecimal numero_odt;
	private String descripcion;
	private String tipo;
	private String clave_negocio;
	private String clave_cliente;
	private String folio;
	private String desc_negocio;
	private String nombre_corto;
	private String estatus;

	public VIEW_REPORTE_ODT() {

	}

	public VIEW_REPORTE_ODT(Date fecha_datos, Integer id_vista, BigDecimal neto, BigDecimal total, BigDecimal iva,
			BigDecimal importe, BigDecimal numero_odt, String descripcion, String tipo, String clave_negocio,
			String clave_cliente, String folio, String desc_negocio, String nombre_corto, String estatus) {
		super();
		this.fecha_datos = fecha_datos;
		this.id_vista = id_vista;
		this.neto = neto;
		this.total = total;
		this.iva = iva;
		this.importe = importe;
		this.numero_odt = numero_odt;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.clave_negocio = clave_negocio;
		this.clave_cliente = clave_cliente;
		this.folio = folio;
		this.desc_negocio = desc_negocio;
		this.nombre_corto = nombre_corto;
		this.estatus = estatus;
	}

	public Date getFecha_datos() {
		return fecha_datos;
	}

	public void setFecha_datos(Date fecha_datos) {
		this.fecha_datos = fecha_datos;
	}

	public Integer getId_vista() {
		return id_vista;
	}

	public void setId_vista(Integer id_vista) {
		this.id_vista = id_vista;
	}

	public BigDecimal getNeto() {
		return neto;
	}

	public void setNeto(BigDecimal neto) {
		this.neto = neto;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getIva() {
		return iva;
	}

	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public BigDecimal getNumero_odt() {
		return numero_odt;
	}

	public void setNumero_odt(BigDecimal numero_odt) {
		this.numero_odt = numero_odt;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getClave_negocio() {
		return clave_negocio;
	}

	public void setClave_negocio(String clave_negocio) {
		this.clave_negocio = clave_negocio;
	}

	public String getClave_cliente() {
		return clave_cliente;
	}

	public void setClave_cliente(String clave_cliente) {
		this.clave_cliente = clave_cliente;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public String getDesc_negocio() {
		return desc_negocio;
	}

	public void setDesc_negocio(String desc_negocio) {
		this.desc_negocio = desc_negocio;
	}

	public String getNombre_corto() {
		return nombre_corto;
	}

	public void setNombre_corto(String nombre_corto) {
		this.nombre_corto = nombre_corto;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "VIEW_REPORTE_ODT [fecha_datos=" + fecha_datos + ", id_vista=" + id_vista + ", neto=" + neto + ", total="
				+ total + ", iva=" + iva + ", importe=" + importe + ", numero_odt=" + numero_odt + ", descripcion="
				+ descripcion + ", tipo=" + tipo + ", clave_negocio=" + clave_negocio + ", clave_cliente="
				+ clave_cliente + ", folio=" + folio + ", desc_negocio=" + desc_negocio + ", nombre_corto="
				+ nombre_corto + ", estatus=" + estatus + "]";
	}

}
