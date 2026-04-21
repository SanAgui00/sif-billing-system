package com.prosa.sif.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "VIEW_SIF_DIRECCION_CLIENTE")
public class ViewDireccionCliente {
	@Id
	private Integer id_contacto;
	private Integer id_domicilio;
	private Integer id_pais;
	private Integer id_codigo_postal;
	private Integer id_poblacion;
	private Integer id_estado;
	private String calle;
	private String numero_ext;
	private String numero_int;
	private String cp;
	private String colonia;
	private String ciudad;
	private String pais;
	private String estado;
	private String delegacion;
	private String apartado_postal;
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
	public ViewDireccionCliente() {
		super();
	}
	public ViewDireccionCliente(Integer id_contacto, Integer id_domicilio, Integer id_pais, Integer id_codigo_postal,
			Integer id_poblacion, Integer id_estado, String calle, String numero_ext, String numero_int, String cp,
			String colonia, String ciudad, String pais, String estado, String delegacion, String apartado_postal,
			String nombre_contacto, String telefono_1, String telefono_2, String fax, String email, Integer b_cont_fact,
			String puesto, String usuario, String estatus, String extension, Date fecha_cre, Date fecha_mod,
			String comentarios, Integer b_enviocfd_x_email, Integer b_addenda, String addenda) {
		super();
		this.id_contacto = id_contacto;
		this.id_domicilio = id_domicilio;
		this.id_pais = id_pais;
		this.id_codigo_postal = id_codigo_postal;
		this.id_poblacion = id_poblacion;
		this.id_estado = id_estado;
		this.calle = calle;
		this.numero_ext = numero_ext;
		this.numero_int = numero_int;
		this.cp = cp;
		this.colonia = colonia;
		this.ciudad = ciudad;
		this.pais = pais;
		this.estado = estado;
		this.delegacion = delegacion;
		this.apartado_postal = apartado_postal;
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
	public Integer getId_pais() {
		return id_pais;
	}
	public void setId_pais(Integer id_pais) {
		this.id_pais = id_pais;
	}
	public Integer getId_codigo_postal() {
		return id_codigo_postal;
	}
	public void setId_codigo_postal(Integer id_codigo_postal) {
		this.id_codigo_postal = id_codigo_postal;
	}
	public Integer getId_poblacion() {
		return id_poblacion;
	}
	public void setId_poblacion(Integer id_poblacion) {
		this.id_poblacion = id_poblacion;
	}
	public Integer getId_estado() {
		return id_estado;
	}
	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumero_ext() {
		return numero_ext;
	}
	public void setNumero_ext(String numero_ext) {
		this.numero_ext = numero_ext;
	}
	public String getNumero_int() {
		return numero_int;
	}
	public void setNumero_int(String numero_int) {
		this.numero_int = numero_int;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDelegacion() {
		return delegacion;
	}
	public void setDelegacion(String delegacion) {
		this.delegacion = delegacion;
	}
	public String getApartado_postal() {
		return apartado_postal;
	}
	public void setApartado_postal(String apartado_postal) {
		this.apartado_postal = apartado_postal;
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
	
}
