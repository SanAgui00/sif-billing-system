
/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 08/03/2018 #
# Descripcion General : Pojo para mapeo de TBL_SIF_BIT_ADQUISICIONES           #
# Marca del cambio    : 									                   #
#------------------------------------------------------------------------------#
# Numero de Parametros: N/A                                                    #
# Parametros Entrada  : N/A                                  Formato:          #
# Parametros Salida   : N/A                                  Formato:          #
################################################################################
**/
package com.prosa.sif.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
/**
 * 
 * @author Loredo
 *
 */
@Entity
@Table(name = "TBL_SIF_BIT_ADQUISICIONES")
@IdClass(TablaBitacoraAdq.class)
public class TablaBitacoraAdq implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	private Integer id_fuente;
	@Id
	@Column
	private Date pk_hora;
	@Id
	@Column
	private String procedimiento;
	@Id
	@Column
	private String usuario;
	@Id
	@Column
	private String codigo;
	@Id
	private String descripcion;

	public TablaBitacoraAdq() {

	}

	public TablaBitacoraAdq(Integer id_fuente, Date pk_hora, String procedimiento, String usuario, String codigo,
			String descripcion) {
		super();
		this.id_fuente = id_fuente;
		this.pk_hora = pk_hora;
		this.procedimiento = procedimiento;
		this.usuario = usuario;
		this.codigo = codigo;
		this.descripcion = descripcion;
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

	@Override
	public String toString() {
		return "TablaBitacoraAdq [id_fuente=" + id_fuente + ", pk_hora=" + pk_hora + ", procedimiento=" + procedimiento
				+ ", usuario=" + usuario + ", codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}

}
