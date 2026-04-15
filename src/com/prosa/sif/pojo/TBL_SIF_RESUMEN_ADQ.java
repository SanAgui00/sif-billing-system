/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 08/03/2018 #
# Descripcion General : Pojo para mapeo de TBL_SIF_RESUMEN_ADQ                 #
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
@Table(name = "TBL_SIF_RESUMEN_ADQ")
public class TBL_SIF_RESUMEN_ADQ {
	@Id
	private Integer id_fuente;
	private Date hora_inicio;
	private Date hora_final;
	private String descripcion_evento;
	private Long total_trans_leidas;
	private Long total_trans_conv;
	private Long total_trans_nconv;
	private String estatus;
	private Date fecha_datos;
	private Date fecha_base_contingencia;
	private Date fecha_ajuste;

	public TBL_SIF_RESUMEN_ADQ() {

	}

	public TBL_SIF_RESUMEN_ADQ(Integer id_fuente, Date hora_inicio, Date hora_final, String descripcion_evento,
			Long total_trans_leidas, Long total_trans_conv, Long total_trans_nconv, String estatus, Date fecha_datos,
			Date fecha_base_contingencia, Date fecha_ajuste) {
		super();
		this.id_fuente = id_fuente;
		this.hora_inicio = hora_inicio;
		this.hora_final = hora_final;
		this.descripcion_evento = descripcion_evento;
		this.total_trans_leidas = total_trans_leidas;
		this.total_trans_conv = total_trans_conv;
		this.total_trans_nconv = total_trans_nconv;
		this.estatus = estatus;
		this.fecha_datos = fecha_datos;
		this.fecha_base_contingencia = fecha_base_contingencia;
		this.fecha_ajuste = fecha_ajuste;
	}

	public Integer getId_fuente() {
		return id_fuente;
	}

	public void setId_fuente(Integer id_fuente) {
		this.id_fuente = id_fuente;
	}

	public Date getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(Date hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public Date getHora_final() {
		return hora_final;
	}

	public void setHora_final(Date hora_final) {
		this.hora_final = hora_final;
	}

	public String getDescripcion_evento() {
		return descripcion_evento;
	}

	public void setDescripcion_evento(String descripcion_evento) {
		this.descripcion_evento = descripcion_evento;
	}

	public Long getTotal_trans_leidas() {
		return total_trans_leidas;
	}

	public void setTotal_trans_leidas(Long total_trans_leidas) {
		this.total_trans_leidas = total_trans_leidas;
	}

	public Long getTotal_trans_conv() {
		return total_trans_conv;
	}

	public void setTotal_trans_conv(Long total_trans_conv) {
		this.total_trans_conv = total_trans_conv;
	}

	public Long getTotal_trans_nconv() {
		return total_trans_nconv;
	}

	public void setTotal_trans_nconv(Long total_trans_nconv) {
		this.total_trans_nconv = total_trans_nconv;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Date getFecha_datos() {
		return fecha_datos;
	}

	public void setFecha_datos(Date fecha_datos) {
		this.fecha_datos = fecha_datos;
	}

	public Date getFecha_base_contingencia() {
		return fecha_base_contingencia;
	}

	public void setFecha_base_contingencia(Date fecha_base_contingencia) {
		this.fecha_base_contingencia = fecha_base_contingencia;
	}

	public Date getFecha_ajuste() {
		return fecha_ajuste;
	}

	public void setFecha_ajuste(Date fecha_ajuste) {
		this.fecha_ajuste = fecha_ajuste;
	}

	@Override
	public String toString() {
		return "TBL_SIF_RESUMEN_ADQ [id_fuente=" + id_fuente + ", hora_inicio=" + hora_inicio + ", hora_final="
				+ hora_final + ", descripcion_evento=" + descripcion_evento + ", total_trans_leidas="
				+ total_trans_leidas + ", total_trans_conv=" + total_trans_conv + ", total_trans_nconv="
				+ total_trans_nconv + ", estatus=" + estatus + ", fecha_datos=" + fecha_datos
				+ ", fecha_base_contingencia=" + fecha_base_contingencia + ", fecha_ajuste=" + fecha_ajuste + "]";
	}

}
