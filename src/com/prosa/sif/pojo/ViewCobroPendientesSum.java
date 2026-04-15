/**
################################################################################
# Autor               : Garnica Garcia David                                   #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 25/04/2018 #
# Descripcion General : POJO para Cobros pendientes suma                       #
# Marca del cambio    :                                                        #
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
/**
 * 
 * @author David Garnica Garcia
 *
 */
@Entity
@Table(name = "V_SIF_COBROS_PENDIENTES_SUM")
public class ViewCobroPendientesSum {
	
	@Id
	private Integer id_vista;
	private Date fecha_cobro_libra;
	private Date fecha_cobro_sac;
	private Integer id_cliente;
	private Integer id_negocio;
	private Integer id_proceso;
	private String interfase;
	private String nombre_moneda;
	private String periodicidad;
	private String tipo_documento;
	private Integer total_cargo;
	private Integer total_importe;
	public ViewCobroPendientesSum() {
		super();
	}
	public ViewCobroPendientesSum(Integer id_vista, Date fecha_cobro_libra, Date fecha_cobro_sac, Integer id_cliente,
			Integer id_negocio, Integer id_proceso, String interfase, String nombre_moneda, String periodicidad,
			String tipo_documento, Integer total_cargo, Integer total_importe) {
		super();
		this.id_vista = id_vista;
		this.fecha_cobro_libra = fecha_cobro_libra;
		this.fecha_cobro_sac = fecha_cobro_sac;
		this.id_cliente = id_cliente;
		this.id_negocio = id_negocio;
		this.id_proceso = id_proceso;
		this.interfase = interfase;
		this.nombre_moneda = nombre_moneda;
		this.periodicidad = periodicidad;
		this.tipo_documento = tipo_documento;
		this.total_cargo = total_cargo;
		this.total_importe = total_importe;
	}
	public Integer getId_vista() {
		return id_vista;
	}
	public void setId_vista(Integer id_vista) {
		this.id_vista = id_vista;
	}
	public Date getFecha_cobro_libra() {
		return fecha_cobro_libra;
	}
	public void setFecha_cobro_libra(Date fecha_cobro_libra) {
		this.fecha_cobro_libra = fecha_cobro_libra;
	}
	public Date getFecha_cobro_sac() {
		return fecha_cobro_sac;
	}
	public void setFecha_cobro_sac(Date fecha_cobro_sac) {
		this.fecha_cobro_sac = fecha_cobro_sac;
	}
	public Integer getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}
	public Integer getId_negocio() {
		return id_negocio;
	}
	public void setId_negocio(Integer id_negocio) {
		this.id_negocio = id_negocio;
	}
	public Integer getId_proceso() {
		return id_proceso;
	}
	public void setId_proceso(Integer id_proceso) {
		this.id_proceso = id_proceso;
	}
	public String getInterfase() {
		return interfase;
	}
	public void setInterfase(String interfase) {
		this.interfase = interfase;
	}
	public String getNombre_moneda() {
		return nombre_moneda;
	}
	public void setNombre_moneda(String nombre_moneda) {
		this.nombre_moneda = nombre_moneda;
	}
	public String getPeriodicidad() {
		return periodicidad;
	}
	public void setPeriodicidad(String periodicidad) {
		this.periodicidad = periodicidad;
	}
	public String getTipo_documento() {
		return tipo_documento;
	}
	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}
	public Integer getTotal_cargo() {
		return total_cargo;
	}
	public void setTotal_cargo(Integer total_cargo) {
		this.total_cargo = total_cargo;
	}
	public Integer getTotal_importe() {
		return total_importe;
	}
	public void setTotal_importe(Integer total_importe) {
		this.total_importe = total_importe;
	}
	
	
}
