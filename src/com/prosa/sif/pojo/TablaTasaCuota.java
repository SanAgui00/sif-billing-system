/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 29/08/2018 #
# Descripcion General : Pojo para mapeo de TablaCatTasasCuotas                 #
# Marca del cambio    : 									                   #
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
@Table(name = "TBL_SIF_CAT_TASAS_CUOTAS")
public class TablaTasaCuota {

	@Id
	private Integer id;
	private String clave;
	private String descripcion;
	private BigDecimal valor_minimo;
	private BigDecimal valor_maximo;
	private String estatus;
	private String usuario;
	private Date fecha;

	public TablaTasaCuota() {

	}

	public TablaTasaCuota(Integer id, String clave, String descripcion, BigDecimal valor_minimo,
			BigDecimal valor_maximo, String estatus, String usuario, Date fecha) {
		super();
		this.id = id;
		this.clave = clave;
		this.descripcion = descripcion;
		this.valor_minimo = valor_minimo;
		this.valor_maximo = valor_maximo;
		this.estatus = estatus;
		this.usuario = usuario;
		this.fecha = fecha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getValor_minimo() {
		return valor_minimo;
	}

	public void setValor_minimo(BigDecimal valor_minimo) {
		this.valor_minimo = valor_minimo;
	}

	public BigDecimal getValor_maximo() {
		return valor_maximo;
	}

	public void setValor_maximo(BigDecimal valor_maximo) {
		this.valor_maximo = valor_maximo;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "TablaTasaCuota [id=" + id + ", clave=" + clave + ", descripcion=" + descripcion + ", valor_minimo="
				+ valor_minimo + ", valor_maximo=" + valor_maximo + ", estatus=" + estatus + ", usuario=" + usuario
				+ ", fecha=" + fecha + "]";
	}

}
