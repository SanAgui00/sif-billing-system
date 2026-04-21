/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 08/03/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.pk;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Loredo
 *
 */
public class TablaBitacoraAdqPK implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id_fuente;
	private Date pk_hora;
	private String procedimiento;
	private String usuario;
	private String codigo;
	private String descripcion;

	public TablaBitacoraAdqPK() {

	}

	public Integer getId_fuente() {
		return id_fuente;
	}

	public void setId_fuente(Integer id_fuente) {
		this.id_fuente = id_fuente;
	}

	public Date getPk_hora() {
		return pk_hora;
	}

	public void setPk_hora(Date pk_hora) {
		this.pk_hora = pk_hora;
	}

	public String getProcedimiento() {
		return procedimiento;
	}

	public void setProcedimiento(String procedimiento) {
		this.procedimiento = procedimiento;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TablaBitacoraAdqPK(Integer id_fuente, Date pk_hora, String procedimiento, String usuario, String codigo,
			String descripcion) {
		super();
		this.id_fuente = id_fuente;
		this.pk_hora = pk_hora;
		this.procedimiento = procedimiento;
		this.usuario = usuario;
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

}
