/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 28/06/2018 #
# Descripcion General : Pojo para mapeo de Tabla                               #
# Marca del cambio    : 									                   #
#------------------------------------------------------------------------------#
# Numero de Parametros: N/A                                                    #
# Parametros Entrada  : N/A                                  Formato:          #
# Parametros Salida   : N/A                                  Formato:          #
################################################################################
**/

package com.prosa.sif.pojo;

import java.util.Date;

public class TablaBitacora {
	private Date hora;
	private String codigo;
	private String usuario;
	private String descripcion;
	private String procedimiento;

	public TablaBitacora() {
	}

	public TablaBitacora(Date hora, String codigo, String usuario, String descripcion, String procedimiento) {
		super();
		this.hora = hora;
		this.codigo = codigo;
		this.usuario = usuario;
		this.descripcion = descripcion;
		this.procedimiento = procedimiento;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getProcedimiento() {
		return procedimiento;
	}

	public void setProcedimiento(String procedimiento) {
		this.procedimiento = procedimiento;
	}

	@Override
	public String toString() {
		return "TablaBitacora [hora=" + hora + ", codigo=" + codigo + ", usuario=" + usuario + ", descripcion="
				+ descripcion + ", procedimiento=" + procedimiento + "]";
	}

}
