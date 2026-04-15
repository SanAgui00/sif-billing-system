/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 06/08/2018 #
# Descripcion General : Pojo para mapeo de TablaHisReglasConversion            #
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
@Table(name = "tbl_sif_his_reglas_conversion")
public class TablaHisReglaConversion {
	@Id
	private Integer id;
	private Integer servicio_id;
	private Integer id_version_anterior; 
	private Integer id_version_nueva;
	private String estatus;
	private Date fecha_creacion;
	private Date fecha_mod;
	private String usuario;
	private String comentarios;
	private String aprobador;
	private String fecha_aprobacion;
	private String mapeo_columnas;
	private String criterios;
	
	public TablaHisReglaConversion() {

	}

	public TablaHisReglaConversion(Integer id, Integer servicio_id, Integer id_version_anterior,
			Integer id_version_nueva, String estatus, Date fecha_creacion, Date fecha_mod, String usuario,
			String comentarios, String aprobador, String fecha_aprobacion, String mapeo_columnas, String criterios) {
		super();
		this.id = id;
		this.servicio_id = servicio_id;
		this.id_version_anterior = id_version_anterior;
		this.id_version_nueva = id_version_nueva;
		this.estatus = estatus;
		this.fecha_creacion = fecha_creacion;
		this.fecha_mod = fecha_mod;
		this.usuario = usuario;
		this.comentarios = comentarios;
		this.aprobador = aprobador;
		this.fecha_aprobacion = fecha_aprobacion;
		this.mapeo_columnas = mapeo_columnas;
		this.criterios = criterios;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getServicio_id() {
		return servicio_id;
	}

	public void setServicio_id(Integer servicio_id) {
		this.servicio_id = servicio_id;
	}

	public Integer getId_version_anterior() {
		return id_version_anterior;
	}

	public void setId_version_anterior(Integer id_version_anterior) {
		this.id_version_anterior = id_version_anterior;
	}

	public Integer getId_version_nueva() {
		return id_version_nueva;
	}

	public void setId_version_nueva(Integer id_version_nueva) {
		this.id_version_nueva = id_version_nueva;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
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

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getAprobador() {
		return aprobador;
	}

	public void setAprobador(String aprobador) {
		this.aprobador = aprobador;
	}

	public String getFecha_aprobacion() {
		return fecha_aprobacion;
	}

	public void setFecha_aprobacion(String fecha_aprobacion) {
		this.fecha_aprobacion = fecha_aprobacion;
	}

	public String getMapeo_columnas() {
		return mapeo_columnas;
	}

	public void setMapeo_columnas(String mapeo_columnas) {
		this.mapeo_columnas = mapeo_columnas;
	}

	public String getCriterios() {
		return criterios;
	}

	public void setCriterios(String criterios) {
		this.criterios = criterios;
	}

	@Override
	public String toString() {
		return "TablaHisReglaConversion [id=" + id + ", servicio_id=" + servicio_id + ", id_version_anterior="
				+ id_version_anterior + ", id_version_nueva=" + id_version_nueva + ", estatus=" + estatus
				+ ", fecha_creacion=" + fecha_creacion + ", fecha_mod=" + fecha_mod + ", usuario=" + usuario
				+ ", comentarios=" + comentarios + ", aprobador=" + aprobador + ", fecha_aprobacion=" + fecha_aprobacion
				+ ", mapeo_columnas=" + mapeo_columnas + ", criterios=" + criterios + "]";
	}

}