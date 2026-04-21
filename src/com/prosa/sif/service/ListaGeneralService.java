package com.prosa.sif.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.prosa.sif.dao.ListaGeneralDao;

/**
 * 
 * @author Loredo
 *
 */
@Service
public class ListaGeneralService {
	@Autowired
	private ListaGeneralDao listaGeneralDao;

	public void listaFuentes(Model model, HttpServletRequest request) {
		listaGeneralDao.listaFuentes(model, request);
	}

	public void listaServicios(Model model, HttpServletRequest request) {
		listaGeneralDao.listaServicios(model, request);
	}

	public void listaClientes(Model model, HttpServletRequest request) {
		listaGeneralDao.listaClientes(model, request);
	}

	public void listaNegocios(Model model, HttpServletRequest request) {
		listaGeneralDao.listaNegocios(model, request);
	}

	public void listaMetodosPago(Model model, HttpServletRequest request) {
		listaGeneralDao.listaMetodosPago(model, request);

	}

	public void listaUsosCFDI(Model model, HttpServletRequest request) {
		listaGeneralDao.listaUsosCFDI(model, request);

	}

	public void listaProceso(Model model, HttpServletRequest request) {
		listaGeneralDao.listaProceso(model, request);

	}

	public void listaCentroCostos(Model model, HttpServletRequest request) {
		listaGeneralDao.listaCentroCostos(model, request);

	}

	public void listaGrupoVolumen(Model model, HttpServletRequest request) {
		listaGeneralDao.listaGrupoVolumen(model, request);

	}

	public void listaGrupoConcepto(Model model, HttpServletRequest request) {
		listaGeneralDao.listaGrupoConcepto(model, request);

	}

	public void listaIngreso(Model model, HttpServletRequest request) {
		listaGeneralDao.listaIngreso(model, request);
	}

	public void listaClavesServicio(Model model, HttpServletRequest request) {
		listaGeneralDao.listaClavesServicio(model, request);
	}

	public void listaClavesUnidad(Model model, HttpServletRequest request) {
		listaGeneralDao.listaClavesUnidad(model, request);
	}

	public void listaServiciosParticulares(Model model, HttpServletRequest request) {
		listaGeneralDao.listaServiciosParticulares(model, request);
	}

	public void listaTiposImpuesto(Model model, HttpServletRequest request) {
		listaGeneralDao.listaTipoImpuesto(model, request);
	}

	public void listaTiposFactor(Model model, HttpServletRequest request) {
		listaGeneralDao.listaTiposFactor(model, request);
	}

	public void listaTasasCuotas(Model model, HttpServletRequest request) {
		listaGeneralDao.listaTasasCuotas(model, request);
	}

	public void listaUnidadMedida(Model model, HttpServletRequest request) {
		listaGeneralDao.listaUnidadMedida(model, request);
	}

	public void listaTiposCargo(Model model, HttpServletRequest request) {
		listaGeneralDao.listaTiposCargo(model, request);
	}

	public void listaUMedida(Model model, HttpServletRequest request) {
		listaGeneralDao.listaUMedida(model, request);
	}

	public void listaCuentasContables(Model model, HttpServletRequest request) {
		listaGeneralDao.listaCuentasContables(model, request);
	}

	public void listaFormaPagos(Model model, HttpServletRequest request) {
		listaGeneralDao.listaFormaPagos(model, request);
	}

	public void listaGrupoCliente(Model model, HttpServletRequest request) {
		listaGeneralDao.listaGrupoCliente(model, request);
	}

	public void listaRedesLogicas(Model model, HttpServletRequest request) {
		listaGeneralDao.listaRedesLogicas(model, request);
	}

	public void listaEmpresas(Model model, HttpServletRequest request) {
		listaGeneralDao.listaEmpresas(model, request);
	}

	public void listaRegimenFiscal(Model model, HttpServletRequest request) {
		listaGeneralDao.listaRegimenFiscal(model, request);
	}

	public void listaTipoPago(Model model, HttpServletRequest request) {
		listaGeneralDao.listaTipoPago(model, request);
	}

	public void listaConceptos(Model model, HttpServletRequest request) {
		listaGeneralDao.listaConceptos(model, request);
	}

	public void listaTipoConceptos(Model model, HttpServletRequest request) {
		listaGeneralDao.listaTipoConceptos(model, request);
	}

	public void listaDescripcionConceptos(Model model, HttpServletRequest request) {
		listaGeneralDao.listaDescripcionConceptos(model, request);
	}

	public void listaAddendas(Model model, HttpServletRequest request) {
		listaGeneralDao.listaAddendas(model, request);
	}

	public void listaMonedas(Model model, HttpServletRequest request) {
		listaGeneralDao.listaMonedas(model, request);

	}

	public void listaUsuarios(Model model, HttpServletRequest request) {
		listaGeneralDao.listaUsuarios(model, request);
	}

	public void listaFuncionalidades(Model model, HttpServletRequest request) {
		listaGeneralDao.listaFuncionalidades(model, request);
	}

	public void listaParametros(Model model, HttpServletRequest request) {
		listaGeneralDao.listaParametros(model, request);
	}

	public void listaGrupoConceptoServ(Model model, HttpServletRequest request) {
		listaGeneralDao.listaGrupoConceptoServ(model, request);
	}

	public void listaPeriodos(Model model, HttpServletRequest request) {
		listaGeneralDao.listaPeriodos(model, request);
	}

	public void listaGruposCliente(Model model, HttpServletRequest request) {
		listaGeneralDao.listaGruposCliente(model, request);
	}

	public void listaPolizas(Model model, HttpServletRequest request) {
		listaGeneralDao.listaPolizas(model, request);
		
	}

	public void reglasConversion(Model model, HttpServletRequest request, Integer servicio_id) {
		listaGeneralDao.reglasConversion(model, request, servicio_id);
	}
	public void listaTipoComprobantes(Model model, HttpServletRequest request) {
		listaGeneralDao.listaTipoComprobantes(model,request);
	}

	public void listaFormaPago(Model model, HttpServletRequest request) {
		listaGeneralDao.listaFormaPago(model,request);
		
	}
	
	public void ListaCertificados(Model model, HttpServletRequest request) {
		listaGeneralDao.ListaCertificados(model, request);
	}
	public void listaTipoRelacion(Model model, HttpServletRequest request) {
		listaGeneralDao.listaTipoRelacion(model,request);
		
	}

	public void listaImportes(Model model, HttpServletRequest request) {
		listaGeneralDao.listaImportes(model,request);
		
	}

	public void listaSegmentos(Model model, HttpServletRequest request, int i) {
		listaGeneralDao.listaSegmentos(model,request,i);
		
	}

	public void listaCuentasBanco(Model model, HttpServletRequest request) {
		// TODO Auto-generated method stub
		listaGeneralDao.listaCuentasBanco(model,request);
	}

	public void listaFormasPago(Model model, HttpServletRequest request) {
		// TODO Auto-generated method stub
		listaGeneralDao.listaFormasPago(model,request);
	}

	public void listaPaises(Model model, HttpServletRequest request) {
		// TODO Auto-generated method stub
		listaGeneralDao.listaPaises(model,request);
	}

	public void listaEstados(Model model, HttpServletRequest request) {
		// TODO Auto-generated method stub
		listaGeneralDao.listaEstados(model,request);
	}
}
