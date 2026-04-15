/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 17/04/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.prosa.sif.pojo.TBL_SIF_CAT_PERIODO;
import com.prosa.sif.pojo.TablaCentroCosto;
import com.prosa.sif.pojo.TablaCliente;
import com.prosa.sif.pojo.TablaContacto;
import com.prosa.sif.pojo.TablaFuente;
import com.prosa.sif.pojo.TablaImporte;
import com.prosa.sif.pojo.TablaNegocio;
import com.prosa.sif.pojo.TablaPolizasContable;
import com.prosa.sif.pojo.TablaServicio;
import com.prosa.sif.pojo.TablaTipoCuenta;
import com.prosa.sif.pojo.ViewDireccion;
import com.prosa.sif.pojo.ViewDireccionCliente;
import com.prosa.sif.pojo.ViewSegmentos;

public interface ListaBusquedaGeneralDao {

	List<TablaCliente> buscarCliente(String clave);

	List<TablaFuente> buscarFuente(String clave);

	List<TablaServicio> buscarServicio(String clave);

	void buscarServicioId(Model model, HttpServletRequest request, Integer id_servicios);

	void buscarClienteId(Model model, HttpServletRequest request, Integer id_cliente);

	void buscarDireccion(Model model, HttpServletRequest request, Integer id_domicilio);

	void buscarClaveCliente(Model model, HttpServletRequest request, Integer id_cliente);

	void buscarCuentaContable(Model model, HttpServletRequest request, Integer id_cliente);

	void buscarDireccionEmpresa(Model model, HttpServletRequest request, Integer id_empresa);

	List<TablaNegocio> buscarNegocio(int clave);

	List<TablaPolizasContable> buscarPoliza(String clave);

	List<TablaCentroCosto> buscarCentro(String clave);

	List<TablaPolizasContable> buscarPolizaUnica(String clave);

	List<TablaNegocio> buscarNegocioDin(String clave);

	List<TBL_SIF_CAT_PERIODO> search_TBL_SIF_CAT_PERIDO(int clave);

	List<TablaTipoCuenta> buscarCuentas(String clave);

	List<TablaImporte> buscarImporte(String clave);

	List<ViewSegmentos> buscarParametrizacion(String clave);

	List<ViewDireccion> buscarDireccion(Model model, HttpServletRequest request, String clave);

	List<ViewDireccionCliente> buscarContacto(Integer clave);

	

}
