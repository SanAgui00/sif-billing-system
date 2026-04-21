/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 19/06/2018 #
# Descripcion General : Pojo para mapeo de TablaContactos                      #
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
@Table(name = "TBL_SIF_CAT_CONTACTOS")
public class TablaContacto {
	@Id
	private Integer id_contacto;
	private Integer id_domicilio;
	private Integer id_cliente;
	private String nombre_contacto;
	private String telefono_1;
	private String telefono_2;
	private String fax;
	private String email;
	private Integer b_cont_fact;
	private String puesto;
	private String usuario;
	private String estatus;
	private String extension;
	private Date fecha_cre;
	private Date fecha_mod;
	private String comentarios;
	private Integer b_enviocfd_x_email;
	private Integer b_addenda;
	private String addenda;

	public TablaContacto() {

	}

	public TablaContacto(Integer id_contacto, Integer id_domicilio, Integer id_cliente, String nombre_contacto,
			String telefono_1, String telefono_2, String fax, String email, Integer b_cont_fact, String puesto,
			String usuario, String estatus, String extension, Date fecha_cre, Date fecha_mod, String comentarios,
			Integer b_enviocfd_x_email, Integer b_addenda, String addenda) {
		super();
		this.id_contacto = id_contacto;
		this.id_domicilio = id_domicilio;
		this.id_cliente = id_cliente;
		this.nombre_contacto = nombre_contacto;
		this.telefono_1 = telefono_1;
		this.telefono_2 = telefono_2;
		this.fax = fax;
		this.email = email;
		this.b_cont_fact = b_cont_fact;
		this.puesto = puesto;
		this.usuario = usuario;
		this.estatus = estatus;
		this.extension = extension;
		this.fecha_cre = fecha_cre;
		this.fecha_mod = fecha_mod;
		this.comentarios = comentarios;
		this.b_enviocfd_x_email = b_enviocfd_x_email;
		this.b_addenda = b_addenda;
		this.addenda = addenda;
	}

	public Integer getId_contacto() {
		return id_contacto;
	}

	public void setId_contacto(Integer id_contacto) {
		this.id_contacto = id_contacto;
	}

	public Integer getId_domicilio() {
		return id_domicilio;
	}

	public void setId_domicilio(Integer id_domicilio) {
		this.id_domicilio = id_domicilio;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNombre_contacto() {
		return nombre_contacto;
	}

	public void setNombre_contacto(String nombre_contacto) {
		this.nombre_contacto = nombre_contacto;
	}

	public String getTelefono_1() {
		return telefono_1;
	}

	public void setTelefono_1(String telefono_1) {
		this.telefono_1 = telefono_1;
	}

	public String getTelefono_2() {
		return telefono_2;
	}

	public void setTelefono_2(String telefono_2) {
		this.telefono_2 = telefono_2;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getB_cont_fact() {
		return b_cont_fact;
	}

	public void setB_cont_fact(Integer b_cont_fact) {
		this.b_cont_fact = b_cont_fact;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
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

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public Date getFecha_cre() {
		return fecha_cre;
	}

	public void setFecha_cre(Date fecha_cre) {
		this.fecha_cre = fecha_cre;
	}

	public Date getFecha_mod() {
		return fecha_mod;
	}

	public void setFecha_mod(Date fecha_mod) {
		this.fecha_mod = fecha_mod;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Integer getB_enviocfd_x_email() {
		return b_enviocfd_x_email;
	}

	public void setB_enviocfd_x_email(Integer b_enviocfd_x_email) {
		this.b_enviocfd_x_email = b_enviocfd_x_email;
	}

	public Integer getB_addenda() {
		return b_addenda;
	}

	public void setB_addenda(Integer b_addenda) {
		this.b_addenda = b_addenda;
	}

	public String getAddenda() {
		return addenda;
	}

	public void setAddenda(String addenda) {
		this.addenda = addenda;
	}

	@Override
	public String toString() {
		return "TablaContacto [id_contacto=" + id_contacto + ", id_domicilio=" + id_domicilio + ", id_cliente="
				+ id_cliente + ", nombre_contacto=" + nombre_contacto + ", telefono_1=" + telefono_1 + ", telefono_2="
				+ telefono_2 + ", fax=" + fax + ", email=" + email + ", b_cont_fact=" + b_cont_fact + ", puesto="
				+ puesto + ", usuario=" + usuario + ", estatus=" + estatus + ", extension=" + extension + ", fecha_cre="
				+ fecha_cre + ", fecha_mod=" + fecha_mod + ", comentarios=" + comentarios + ", b_enviocfd_x_email="
				+ b_enviocfd_x_email + ", b_addenda=" + b_addenda + ", addenda=" + addenda + "]";
	}

}