/**
################################################################################
# Autor               : Garnica Garcia David                                   #
# Compania            : Codigo Geek                                            #
# Proyecto/Procliente :                                      Fecha: 25/04/2018 #
# Descripcion General : Service para catalogo sat       			           #
# Marca del cambio    :                                                        #
################################################################################
**/

package com.prosa.sif.service;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.prosa.sif.dao.SATDao;



@Service
public class SATService {

	@Autowired
	private SATDao satDao;


	public void queryRegimenFiscal(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			Integer regimen, String estatus) {
		satDao.queryRegimenFiscal(tipo,model,request,fromRow,regimen,estatus);
		
	}


	public void queryFindRegimenFiscal(Model model, HttpServletRequest request, Integer regimen, String evento) {
		satDao.queryFindRegimenFiscal(model,request,regimen,evento);
		
	}


	public void SaveOrUpdateRegimenFiscal(Model model, HttpServletRequest request, Integer regimen, String clave, String descripcion,
			String fisica, String moral, String evento, String estatus) {
		satDao.SaveOrUpdateRegimenFiscal(model,request,regimen,clave,descripcion,fisica, moral, evento,estatus);
	}


	public void queryTiposComprobante(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			Integer comprobante, String estatus) {
		satDao.queryTiposComprobante(tipo,model,request,fromRow,comprobante,estatus);
		
	}


	public void queryFindTiposComprobante(Model model, HttpServletRequest request, Integer comprobante, String evento) {
		satDao.queryFindTiposComprobante(model,request,comprobante,evento);
		
	}


	public void SaveOrUpdateTiposComprobante(Model model, HttpServletRequest request, Integer comprobantes,
			String clave, String descripcion, Integer minimo, Integer maximo, String evento, String estatus) {
		satDao.SaveOrUpdateTiposComprobante(model,request,comprobantes,clave, descripcion,minimo,maximo,evento,estatus);
		
	}


	public void queryUsosCfdi(String tipo, Model model, HttpServletRequest request, Integer fromRow, Integer cfdi,
			String estatus) {
		satDao.queryUsosCfdi(tipo, model,request,fromRow,cfdi,estatus);
		
	}


	public void queryFindUsoCfdi(Model model, HttpServletRequest request, Integer cfdi, String evento) {
		satDao.queryFindUsoCfdi(model,request,cfdi,evento);
		
	}


	public void SaveOrUpdateUsoCfdi(Model model, HttpServletRequest request, Integer cfdi, String clave,
			String descripcion, String fisica, String moral, String evento, String estatus) {
		satDao.SaveOrUpdateUsoCfdi(model,request,cfdi,clave,descripcion, fisica, moral, evento,estatus);
		
	}


	public void queryFormasPago(String tipo, Model model, HttpServletRequest request, Integer fromRow, Integer forma,
			String estatus) {
		satDao.queryFormasPago(tipo,model,request,fromRow,forma,estatus);
		
	}


	public void queryFindFormasPago(Model model, HttpServletRequest request, Integer formas, String evento) {
		satDao.queryFindFormasPago(model,request,formas,evento);
		
	}


	public void SaveOrUpdateFormasPago(Model model, HttpServletRequest request, Integer formas, String clave,
			String descripcion, String bancarizado, String evento, String estatus) {
		satDao.SaveOrUpdateFormasPago(model,request,formas,clave,descripcion,bancarizado,evento,estatus);
		
	}


	



	public void queryTiposImpuesto(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			Integer impuesto, String estatus) {
		satDao.queryTiposImpuesto(tipo, model, request, fromRow,impuesto,  estatus);
		
	}


	public void queryFindTipoImpuesto(Model model, HttpServletRequest request, Integer impuesto, String evento) {
		satDao.queryFindTipoImpuesto(model,request,impuesto,evento);
		
	}

	public void queryTiposFactor(String tipo, Model model, HttpServletRequest request, Integer fromRow, Integer factor,
			String estatus) {
		satDao.queryTiposFactor(tipo, model, request, fromRow,factor,  estatus);
		
	}


	public void SaveOrUpdateTiposFactor(Model model, HttpServletRequest request, Integer factor, String clave,
			String descripcion, String estatus, String evento) {
		satDao.SaveOrUpdateTiposFactor(model,request,factor,clave,descripcion,estatus,evento);
		
	}


	public void queryFindTipoFactor(Model model, HttpServletRequest request, Integer factor, String evento) {
		satDao.queryFindTipoFactor(model,request,factor,evento);
		
	}


	public void queryTasasCuota(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			Integer tasascuota, String estatus) {
		satDao.queryTasasCuota(tipo, model, request, fromRow,tasascuota,  estatus);
		
	}


	public void queryFindTasasCuotas(Model model, HttpServletRequest request, Integer tasascuota, String evento) {
		satDao.queryFindTasasCuotas(model,request,tasascuota,evento);
		
	}




	public void SaveOrUpdateTasascuota(Model model, HttpServletRequest request, Integer tasascuota, String clave,
			String descripcion, String valorminimo, String valormaximo, String estatus, String evento) {
		satDao.SaveOrUpdateTasascuota(model,request,tasascuota,clave,descripcion,valorminimo,valormaximo,estatus,evento);
		
	}


	public void SaveOrUpdateTiposImpuesto(Model model, HttpServletRequest request, Integer impuesto, String clave,
			String tras, String estatus, String tipoentidad, String descripcion, String reten, String entidad,
			String evento) {
		satDao.SaveOrUpdateTiposImpuesto(model,request,impuesto,clave,tras,estatus,tipoentidad,descripcion,reten,entidad,evento);
		
	}

	


	public void queryMetodosPagos(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			Integer metodos, String estatus) {
		satDao.queryMetodosPagos(tipo, model, request, fromRow,metodos,estatus);
	}


	public void queryFindMetodosPago(Model model, HttpServletRequest request, Integer metodos, String evento) {
		satDao.queryFindMetodosPago(model,request,metodos,evento);
		
	}


	public void SaveOrUpdateMetodosPago(Model model, HttpServletRequest request, Integer metodos, String clave,
			String descripcion, String evento, String estatus) {
		satDao.SaveOrUpdateMetodosPago(model,request,metodos,clave,descripcion,evento,estatus);
		
	}


	public void queryTiposRelacion(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			Integer metodos, String estatus) {
		satDao.queryTiposRelacion(tipo, model, request, fromRow,metodos,estatus);
	}


	public void queryFindTiposRelacion(Model model, HttpServletRequest request, Integer metodos, String evento) {
		satDao.queryFindTiposRelacion(model,request,metodos,evento);
		
	}


	public void SaveOrUpdateTiposRelacion(Model model, HttpServletRequest request, Integer metodos, String clave,
			String descripcion, String evento, String estatus) {
		satDao.SaveOrUpdateTiposRelacion(model,request,metodos,clave,descripcion,evento,estatus);
		
	}


	public void queryCertificado(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			Integer certificado, String estatus) {
		satDao.queryCertificado(tipo, model, request, fromRow,certificado,estatus);
	}


	public void queryFindCertificados(Model model, HttpServletRequest request, Integer certificado, String evento) {
		satDao.queryFindCertificados(model,request,certificado,evento);
		
	}


	public void SaveOrUpdateCertificado(Model model, HttpServletRequest request, Integer certificado,
			String cert_privado, String cert_publico, String descripcion, String estatus, String id_empresa,
			String cert_ruta, String evento) {
		satDao.SaveOrUpdateCertificado(model,request,certificado,cert_privado,cert_publico,descripcion,estatus,id_empresa,cert_ruta,evento);
		
	}


	public void queryClavesServicio(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			Integer metodos, String estatus) {
		satDao.queryClavesServicio(tipo, model, request, fromRow,metodos,estatus);
		
	}
	public void queryFindClavesServicio(Model model, HttpServletRequest request, Integer metodos, String evento) {
		satDao.queryFindClavesServicio(model,request,metodos,evento);
		
	}


	public void SaveOrUpdateClavesServicio(Model model, HttpServletRequest request, Integer metodos, String clave,
	String descripcion, String iva_traslado, String ieps_traslado, String evento, String estatus) {
		satDao.SaveOrUpdateClavesServicio(model,request,metodos,clave,descripcion,iva_traslado,ieps_traslado,evento,estatus);
		
	}
	
	public void queryClavesUnidad(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			Integer metodos, String estatus) {
		satDao.queryClavesUnidad(tipo, model, request, fromRow,metodos,estatus);
		
	}
	public void queryFindClavesUnidad(Model model, HttpServletRequest request, Integer metodos, String evento) {
		satDao.queryFindClavesUnidad(model,request,metodos,evento);
		
	}


	public void SaveOrUpdateClavesUnidad(Model model, HttpServletRequest request, Integer metodos, String clave,
	String descripcion, String simbolo, String evento, String estatus) {
		satDao.SaveOrUpdateClavesUnidad(model,request,metodos,clave,descripcion,simbolo,evento,estatus);
		
	}


	
}