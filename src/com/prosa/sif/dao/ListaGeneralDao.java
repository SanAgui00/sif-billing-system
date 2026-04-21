/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : C�digo Geek                                            #
# Proyecto/Procliente :                                      Fecha: 08/05/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.dao;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
/**
 * 
 * @author Loredo
 *
 */
public interface ListaGeneralDao {

	void listaFuentes(Model model, HttpServletRequest request);

	void listaServicios(Model model, HttpServletRequest request);

	void listaClientes(Model model, HttpServletRequest request);

	void listaNegocios(Model model, HttpServletRequest request);

	void listaMetodosPago(Model model, HttpServletRequest request);

	void listaUsosCFDI(Model model, HttpServletRequest request);

	void listaProceso(Model model, HttpServletRequest request);

	void listaCentroCostos(Model model, HttpServletRequest request);

	void listaGrupoVolumen(Model model, HttpServletRequest request);

	void listaGrupoConcepto(Model model, HttpServletRequest request);

	void listaRegimenFiscal(Model model, HttpServletRequest request);
	
	void listaIngreso(Model model, HttpServletRequest request);

	void listaClavesServicio(Model model, HttpServletRequest request);

	void listaClavesUnidad(Model model, HttpServletRequest request);

	void listaServiciosParticulares(Model model, HttpServletRequest request);

	void listaTipoImpuesto(Model model, HttpServletRequest request);

	void listaTiposFactor(Model model, HttpServletRequest request);

	void listaTasasCuotas(Model model, HttpServletRequest request);

	void listaUnidadMedida(Model model, HttpServletRequest request);

	void listaTiposCargo(Model model, HttpServletRequest request);

	void listaUMedida(Model model, HttpServletRequest request);

	void listaCuentasContables(Model model, HttpServletRequest request);

	void listaFormaPagos(Model model, HttpServletRequest request);

	void listaGrupoCliente(Model model, HttpServletRequest request);

	void listaRedesLogicas(Model model, HttpServletRequest request);

	void listaEmpresas(Model model, HttpServletRequest request);

	void listaTipoPago(Model model, HttpServletRequest request);

	void listaConceptos(Model model, HttpServletRequest request);

	void listaTipoConceptos(Model model, HttpServletRequest request);

	void listaDescripcionConceptos(Model model, HttpServletRequest request);

	void listaAddendas(Model model, HttpServletRequest request);

	void listaMonedas(Model model, HttpServletRequest request);

	void listaUsuarios(Model model, HttpServletRequest request);

	void listaFuncionalidades(Model model, HttpServletRequest request);

	void listaParametros(Model model, HttpServletRequest request);

	void listaGrupoConceptoServ(Model model, HttpServletRequest request);

	void listaPeriodos(Model model, HttpServletRequest request);

	void listaGruposCliente(Model model, HttpServletRequest request);

	void listaPolizas(Model model, HttpServletRequest request);

	void reglasConversion(Model model, HttpServletRequest request, Integer servicio_id);

	void listaTipoComprobantes(Model model, HttpServletRequest request);

	void listaFormaPago(Model model, HttpServletRequest request);

	void listaTipoRelacion(Model model, HttpServletRequest request);

	void ListaCertificados(Model model, HttpServletRequest request);

	void listaImportes(Model model, HttpServletRequest request);

	void listaSegmentos(Model model, HttpServletRequest request, int i);

	void listaCuentasBanco(Model model, HttpServletRequest request);

	void listaFormasPago(Model model, HttpServletRequest request);

	void listaPaises(Model model, HttpServletRequest request);

	void listaEstados(Model model, HttpServletRequest request);

}
