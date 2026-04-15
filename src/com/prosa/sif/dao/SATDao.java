/**
################################################################################
# Autor               : Garnica Garcia David                                   #
# Compania            : Codigo Geek                                            #
# Proyecto/Procliente :                                      Fecha: 25/04/2018 #
# Descripcion General : 											           #
# Marca del cambio    :                                                        #
################################################################################
**/

package com.prosa.sif.dao;


import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;


public interface SATDao {

//	// Mantener Cat�logo R�gimen Fiscal
//	// Consultar
//	public List<TablaRegimenFical> findAll_TBL_SIF_CAT_REGIMEN_FISCAL();
//
//	public List<TablaRegimenFical> findByRows_TBL_SIF_CAT_REGIMEN_FISCAL(Integer fuentes_clave,
//			String status_nombre);
//
//	public List<TablaRegimenFical> consultaLastId_TBL_SIF_CAT_REGIMEN_FISCAL();
//
//	// Agregar
//	public void save_TBL_SIF_CAT_REGIMEN_FISCAL(TablaRegimenFical agregar);
//
//	// Actualizar
//	public void update_TBL_SIF_CAT_REGIMEN_FISCAL(TablaRegimenFical actualizar);
//	
//	//Jasper
//	public JasperReport getCompiledFile(String Regimen_report, HttpServletRequest request) throws JRException, IOException;
//
//	// Mantener Cat�logo Tipos de Comprobante
//	public List<TBL_SIF_CAT_TIPOS_COMPROBANTE> findAll_TBL_SIF_CAT_TIPOS_COMPROBANTE();
//
//	public List<TBL_SIF_CAT_TIPOS_COMPROBANTE> findByRows_TBL_SIF_CAT_TIPOS_COMPROBANTE(Integer fuentes_clave,
//			String status_nombre);
//
//	public List<TBL_SIF_CAT_TIPOS_COMPROBANTE> consultaLastId_TBL_SIF_CAT_TIPOS_COMPROBANTE();
//
//	// Agregar
//	public void save_TBL_SIF_CAT_TIPOS_COMPROBANTE(TBL_SIF_CAT_TIPOS_COMPROBANTE agregar);
//
//	// Actualizar
//	public void update_TBL_SIF_CAT_TIPOS_COMPROBANTE(TBL_SIF_CAT_TIPOS_COMPROBANTE actualizar);
//
//	// Mantener Cat�logo Usos CFDI
//	public List<TBL_SIF_CAT_USOS_CFDI> findAll_TBL_SIF_CAT_USOS_CFDI();
//
//	public List<TBL_SIF_CAT_USOS_CFDI> findByRows_TBL_SIF_CAT_USOS_CFDI(Integer fuentes_clave, String status_nombre);
//
//	public List<TBL_SIF_CAT_USOS_CFDI> consultaLastId_TBL_SIF_CAT_USOS_CFDI();
//
//	// Agregar
//	public void save_TBL_SIF_CAT_USOS_CFDI(TBL_SIF_CAT_USOS_CFDI agregar);
//
//	// Actualizar
//	public void update_TBL_SIF_CAT_USOS_CFDI(TBL_SIF_CAT_USOS_CFDI actualizar);
//
//	// Mantener Cat�logo Formas de Pago
//	public List<TBL_SIF_CAT_FORMAS_PAGO> findAll_TBL_SIF_CAT_FORMAS_PAGO();
//
//	public List<TBL_SIF_CAT_FORMAS_PAGO> findByRows_TBL_SIF_CAT_FORMAS_PAGO(Integer fuentes_clave,
//			String status_nombre);
//
//	public List<TBL_SIF_CAT_FORMAS_PAGO> consultaLastId_TBL_SIF_CAT_FORMAS_PAGO();
//
//	// Agregar
//	public void save_TBL_SIF_CAT_FORMAS_PAGO(TBL_SIF_CAT_FORMAS_PAGO agregar);
//
//	// Actualizar
//	public void update_TBL_SIF_CAT_FORMAS_PAGO(TBL_SIF_CAT_FORMAS_PAGO actualizar);
//
//	// Mantener Cat�logo M�todos de Pago
//	public List<TBL_SIF_CAT_METODOS_PAGO> findAll_TBL_SIF_CAT_METODOS_PAGO();
//
//	public List<TBL_SIF_CAT_METODOS_PAGO> findByRows_TBL_SIF_CAT_METODOS_PAGO(Integer fuentes_clave,
//			String status_nombre);
//
//	public List<TBL_SIF_CAT_METODOS_PAGO> consultaLastId_TBL_SIF_CAT_METODOS_PAGO();
//
//	// Agregar
//	public void save_TBL_SIF_CAT_METODOS_PAGO(TBL_SIF_CAT_METODOS_PAGO agregar);
//
//	// Actualizar
//	public void update_TBL_SIF_CAT_METODOS_PAGO(TBL_SIF_CAT_METODOS_PAGO actualizar);
//
//	// Mantener Cat�logo Tipos de Relaci�n
//	public List<TBL_SIF_CAT_TIPOS_RELACION> findAll_TBL_SIF_CAT_TIPOS_RELACION();
//
//	public List<TBL_SIF_CAT_TIPOS_RELACION> findByRows_TBL_SIF_CAT_TIPOS_RELACION(Integer fuentes_clave,
//			String status_nombre);
//
//	public List<TBL_SIF_CAT_TIPOS_RELACION> consultaLastId_TBL_SIF_CAT_TIPOS_RELACION();
//
//	// Agregar
//	public void save_TBL_SIF_CAT_TIPOS_RELACION(TBL_SIF_CAT_TIPOS_RELACION agregar);
//
//	// Actualizar
//	public void update_TBL_SIF_CAT_TIPOS_RELACION(TBL_SIF_CAT_TIPOS_RELACION actualizar);
//
//	// Mantener Cat�logo Claves Servicios/Productos
//	public List<TBL_SIF_CAT_CLAVES_SERVICIO> findAll_TBL_SIF_CAT_CLAVES_SERVICIO();
//
//	public List<TBL_SIF_CAT_CLAVES_SERVICIO> findByRows_TBL_SIF_CAT_CLAVES_SERVICIO(Integer fuentes_clave,
//			String status_nombre);
//
//	public List<TBL_SIF_CAT_CLAVES_SERVICIO> consultaLastId_TBL_SIF_CAT_CLAVES_SERVICIO();
//
//	// Agregar
//	public void save_TBL_SIF_CAT_CLAVES_SERVICIO(TBL_SIF_CAT_CLAVES_SERVICIO agregar);
//
//	// Actualizar
//	public void update_TBL_SIF_CAT_CLAVES_SERVICIO(TBL_SIF_CAT_CLAVES_SERVICIO actualizar);
//
//	// Mantener Cat�logo Claves de Unidad
//	public List<TBL_SIF_CAT_CLAVES_UNIDAD> findAll_TBL_SIF_CAT_CLAVES_UNIDAD();
//
//	public List<TBL_SIF_CAT_CLAVES_UNIDAD> findByRows_TBL_SIF_CAT_CLAVES_UNIDAD(Integer fuentes_clave,
//			String status_nombre);
//
//	public List<TBL_SIF_CAT_CLAVES_UNIDAD> consultaLastId_TBL_SIF_CAT_CLAVES_UNIDAD();
//
//	// Agregar
//	public void save_TBL_SIF_CAT_CLAVES_UNIDAD(TBL_SIF_CAT_CLAVES_UNIDAD agregar);
//
//	// Actualizar
//	public void update_TBL_SIF_CAT_CLAVES_UNIDAD(TBL_SIF_CAT_CLAVES_UNIDAD actualizar);
//
//	// Mantener Cat�logo Tipos de Impuesto
//	public List<TBL_SIF_CAT_TIPOS_IMPUESTO> findAll_TBL_SIF_CAT_TIPOS_IMPUESTO();
//
//	public List<TBL_SIF_CAT_TIPOS_IMPUESTO> findByRows_TBL_SIF_CAT_TIPOS_IMPUESTO(Integer fuentes_clave,
//			String status_nombre);
//
//	public List<TBL_SIF_CAT_TIPOS_IMPUESTO> consultaLastId_TBL_SIF_CAT_TIPOS_IMPUESTO();
//
//	// Agregar
//	public void save_TBL_SIF_CAT_TIPOS_IMPUESTO(TBL_SIF_CAT_TIPOS_IMPUESTO agregar);
//
//	// Actualizar
//	public void update_TBL_SIF_CAT_TIPOS_IMPUESTO(TBL_SIF_CAT_TIPOS_IMPUESTO actualizar);
//
//	// Mantener Cat�logo Tipos de Factor
//	public List<TBL_SIF_CAT_TIPOS_FACTOR> findAll_TBL_SIF_CAT_TIPOS_FACTOR();
//
//	public List<TBL_SIF_CAT_TIPOS_FACTOR> findByRows_TBL_SIF_CAT_TIPOS_FACTOR(Integer fuentes_clave,
//			String status_nombre);
//
//	public List<TBL_SIF_CAT_TIPOS_FACTOR> consultaLastId_TBL_SIF_CAT_TIPOS_FACTOR();
//
//	// Agregar
//	public void save_TBL_SIF_CAT_TIPOS_FACTOR(TBL_SIF_CAT_TIPOS_FACTOR agregar);
//
//	// Actualizar
//	public void update_TBL_SIF_CAT_TIPOS_FACTOR(TBL_SIF_CAT_TIPOS_FACTOR actualizar);
//
//	// Mantener Cat�logo Tasas/Cuotas
//	public List<TBL_SIF_CAT_TASAS_CUOTAS> findAll_TBL_SIF_CAT_TASAS_CUOTAS();
//
//	public List<TBL_SIF_CAT_TASAS_CUOTAS> findByRows_TBL_SIF_CAT_TASAS_CUOTAS(Integer fuentes_clave,
//			String status_nombre);
//
//	public List<TBL_SIF_CAT_TASAS_CUOTAS> consultaLastId_TBL_SIF_CAT_TASAS_CUOTAS();
//
//	// Agregar
//	public void save_TBL_SIF_CAT_TASAS_CUOTAS(TBL_SIF_CAT_TASAS_CUOTAS agregar);
//
//	// Actualizar
//	public void update_TBL_SIF_CAT_TASAS_CUOTAS(TBL_SIF_CAT_TASAS_CUOTAS actualizar);

	public void queryRegimenFiscal(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			Integer regimen, String estatus);

	public void queryFindRegimenFiscal(Model model, HttpServletRequest request, Integer regimen, String evento);

	public void SaveOrUpdateRegimenFiscal(Model model, HttpServletRequest request, Integer regimen, String clave,
			String descripcion, String fisica, String moral, String evento, String estatus);

	public void queryTiposComprobante(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			Integer comprobante, String estatus);

	public void queryFindTiposComprobante(Model model, HttpServletRequest request, Integer comprobante, String evento);

	public void SaveOrUpdateTiposComprobante(Model model, HttpServletRequest request, Integer comprobantes,
			String clave, String descripcion, Integer minimo, Integer maximo, String evento, String estatus);

	public void queryUsosCfdi(String tipo, Model model, HttpServletRequest request, Integer fromRow, Integer cfdi,
			String estatus);

	public void queryFindUsoCfdi(Model model, HttpServletRequest request, Integer cfdi, String evento);

	public void SaveOrUpdateUsoCfdi(Model model, HttpServletRequest request, Integer cfdi, String clave,
			String descripcion, String fisica, String moral, String evento, String estatus);

	public void queryFormasPago(String tipo, Model model, HttpServletRequest request, Integer fromRow, Integer forma,
			String estatus);

	public void queryFindFormasPago(Model model, HttpServletRequest request, Integer formas, String evento);

	public void SaveOrUpdateFormasPago(Model model, HttpServletRequest request, Integer formas, String clave,
			String descripcion, String bancarizado, String evento, String estatus);


	public void queryTiposImpuesto(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			Integer impuesto, String estatus);

	public void queryFindTipoImpuesto(Model model, HttpServletRequest request, Integer impuesto, String evento);

	public void SaveOrUpdateTiposImpuesto(Model model, HttpServletRequest request, Integer impuesto, String clave,
			String tras, String estatus, String tipoentidad, String descripcion, String reten,
			String entidad,String evento);

	public void SaveOrUpdateTiposFactor(Model model, HttpServletRequest request, Integer factor, String clave,
			String descripcion, String estatus,String evento);
	public void queryFindTipoFactor(Model model, HttpServletRequest request, Integer factor, String evento);
	public void queryMetodosPagos(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			Integer metodos, String estatus);

	void queryTiposFactor(String tipo, Model model, HttpServletRequest request, Integer fromRow, Integer factor,
			String estatus);

	public void queryTasasCuota(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			Integer tasascuota, String estatus);

	public void queryFindTasasCuotas(Model model, HttpServletRequest request, Integer tasascuota, String evento);

	public void SaveOrUpdateTasascuota(Model model, HttpServletRequest request, Integer tasascuota, String clave,
			String descripcion, String valorminimo, String valormaximo,String estatus, String evento );


	public void queryFindMetodosPago(Model model, HttpServletRequest request, Integer metodos, String evento);

	public void SaveOrUpdateMetodosPago(Model model, HttpServletRequest request, Integer metodos, String clave,
			String descripcion, String evento, String estatus);

	public void queryTiposRelacion(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			Integer metodos, String estatus);
	public void queryFindTiposRelacion(Model model, HttpServletRequest request, Integer metodos, String evento);
	public void queryCertificado(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			Integer certificado, String estatus);

	public void SaveOrUpdateTiposRelacion(Model model, HttpServletRequest request, Integer metodos, String clave,
			String descripcion, String evento, String estatus);


	public void queryFindCertificados(Model model, HttpServletRequest request, Integer certificado, String evento);

	public void SaveOrUpdateCertificado(Model model, HttpServletRequest request, Integer certificado,
			String cert_privado, String cert_publico, String descripcion, String estatus, String id_empresa,
			String cert_ruta, String evento);

	public void queryClavesServicio(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			Integer metodos, String estatus);

	public void queryFindClavesServicio(Model model, HttpServletRequest request, Integer metodos, String evento);

	public void SaveOrUpdateClavesServicio(Model model, HttpServletRequest request, Integer metodos, String clave,
			String descripcion, String iva_traslado, String ieps_traslado, String evento, String estatus);

	public void queryClavesUnidad(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			Integer metodos, String estatus);

	public void queryFindClavesUnidad(Model model, HttpServletRequest request, Integer metodos, String evento);

	public void SaveOrUpdateClavesUnidad(Model model, HttpServletRequest request, Integer metodos, String clave,
			String descripcion, String simbolo, String evento, String estatus);



}
