package com.prosa.sif.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.prosa.sif.dao.ListaBusquedaGeneralDao;
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

@Service
public class ListaBusquedaGeneralService {
	@Autowired
	private ListaBusquedaGeneralDao listaBusquedaGeneralDao;

	public List<TablaCliente> buscarCliente(String clave) {
		return listaBusquedaGeneralDao.buscarCliente(clave);

	}

	public List<TablaFuente> buscarFuente(String clave) {
		return listaBusquedaGeneralDao.buscarFuente(clave);
	}

	public List<TablaServicio> buscarServicio(String clave) {
		return listaBusquedaGeneralDao.buscarServicio(clave);
	}

	public void buscarServicioId(Model model, HttpServletRequest request, Integer id_servicios) {
		listaBusquedaGeneralDao.buscarServicioId(model, request, id_servicios);
	}

	public void buscarClienteId(Model model, HttpServletRequest request, Integer id_cliente) {
		listaBusquedaGeneralDao.buscarClienteId(model, request, id_cliente);
	}

	public void buscarDireccion(Model model, HttpServletRequest request, Integer id_domicilio) {
		listaBusquedaGeneralDao.buscarDireccion(model, request, id_domicilio);
	}

	public void buscarClaveCliente(Model model, HttpServletRequest request, Integer id_cliente) {
		listaBusquedaGeneralDao.buscarClaveCliente(model, request, id_cliente);
	}

	public void buscarCuentaContable(Model model, HttpServletRequest request, Integer id_cliente) {
		listaBusquedaGeneralDao.buscarCuentaContable(model, request, id_cliente);
	}

	public void buscarDireccionEmpresa(Model model, HttpServletRequest request, Integer id_empresa) {
		listaBusquedaGeneralDao.buscarDireccionEmpresa(model, request, id_empresa);
	}

	public List<TablaNegocio> buscarNegocio(int clave) {

		return listaBusquedaGeneralDao.buscarNegocio(clave);
	}

	public List<TablaPolizasContable> buscarPoliza(String clave) {

		return listaBusquedaGeneralDao.buscarPoliza(clave);
	}

	public List<TablaCentroCosto> buscarCentro(String clave) {

		return listaBusquedaGeneralDao.buscarCentro(clave);
	}

	public List<TablaPolizasContable> buscarPolizaUnica(String clave) {

		return listaBusquedaGeneralDao.buscarPolizaUnica(clave);
	}

	public List<TablaNegocio> buscarNegocioDin(String clave) {

		return listaBusquedaGeneralDao.buscarNegocioDin(clave);
	}

	public List<TBL_SIF_CAT_PERIODO> search_TBL_SIF_CAT_PERIDO(int clave) {
		return listaBusquedaGeneralDao.search_TBL_SIF_CAT_PERIDO(clave);
	}

	public List<TablaTipoCuenta> buscarCuentas(String clave) {
		return listaBusquedaGeneralDao.buscarCuentas(clave);
	}

	public List<TablaImporte> buscarImporte(String clave) {
		return listaBusquedaGeneralDao.buscarImporte(clave);
	}

	public List<ViewSegmentos> buscarParametrizacion(String clave) {
		return listaBusquedaGeneralDao.buscarParametrizacion(clave);
	}

	public List<ViewDireccion> buscarDireccion(Model model, HttpServletRequest request, String clave) {
		return listaBusquedaGeneralDao.buscarDireccion(model,request,clave);
	}

	public List<ViewDireccionCliente> buscarContacto(Integer clave) {
		return listaBusquedaGeneralDao.buscarContacto(clave);
	}

	
}