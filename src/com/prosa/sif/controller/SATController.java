/**
################################################################################
# Autor               : Garnica Garcia David                                   #
# Compania            : Codigo Geek                                            #
# Proyecto/Procliente :                                      Fecha: 25/04/2018 #
# Descripcion General : Controlador para catalogos sat   			           #
# Marca del cambio    :                                                        #
################################################################################
**/

package com.prosa.sif.controller;



import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import com.prosa.sif.operation.ProcesoGeneral;
import com.prosa.sif.service.ListaGeneralService;
import com.prosa.sif.service.SATService;



@Controller
public class SATController {
	@Autowired
	private SATService satService;
	@Autowired
	private ProcesoGeneral procesoGeneral;
	@Autowired
	private ListaGeneralService listaGeneralService;
	
	
	private static String contr = "controller";
	private static String consulta = "consulta";
	private static String count = "count";
	private static String sat = "catalogo/sat/mantenerCatalogoRegimen";
	private static String satCrud = "catalogo/sat/mantenerCatalogoRegimenCrud";
	private static String comprobantes = "catalogo/sat/mantenerCatalogoTiposComprobante";
	private static String comprobantesCrud = "catalogo/sat/mantenerCatalogoTiposComprobanteCrud";
	private static String usocfdi = "catalogo/sat/mantenerCatalogoUsosCfdi";
	private static String usocfdiCrud = "catalogo/sat/mantenerCatalogoUsosCfdiCrud";
	private static String formapago = "catalogo/sat/mantenerCatalogoFormasPago";
	private static String formapagoCrud = "catalogo/sat/mantenerCatalogoFormasPagoCrud";
	private static String satM = "catalogo/sat/mantenerCatalogoMetodosPago";
	private static String satMCrud = "catalogo/sat/mantenerCatalogoMetodosPagoCrud";
	private static String Imp = "catalogo/sat/mantenerCatalogoTiposImpuesto";
	private static String Imf = "catalogo/sat/mantenerCatalogoTiposFactor";
	private static String tc = "catalogo/sat/mantenerCatalogoTasasCuotas";
	private static String tiposR = "catalogo/sat/mantenerCatalogoTiposRelacion";
	private static String tiposRCrud = "catalogo/sat/mantenerCatalogoTiposRelacionCrud";
	private static String cc = "catalogo/sat/mantenerCatalogoCertificado";
	private static String clavesS = "catalogo/sat/mantenerCatalogoClavesServiciosProductos";
	private static String clavesSCrud="catalogo/sat/mantenerCatalogoClavesServiciosProductosCrud";
	private static String clavesU = "catalogo/sat/mantenerCatalogoClavesUnidad";
	private static String clavesUCrud="catalogo/sat/mantenerCatalogoClavesUnidadCrud";
	


	

	@RequestMapping(value = "/home/cat/sat/regimen", method = {RequestMethod.POST,RequestMethod.GET})
	public String mostrarConsultaMantenerCatalogoRegimenFiscal(Model model, SessionStatus sessionStatus,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			HttpServletRequest request,@RequestParam(value= "regimen" , defaultValue = "0") Integer regimen
			,@RequestParam(value= "estatus" , defaultValue = "empty") String estatus){
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaRegimenFiscal(model, request);	
		satService.queryRegimenFiscal(count, model, request, fromRow, regimen, estatus);
		satService.queryRegimenFiscal(consulta, model, request, fromRow, regimen, estatus);
		model.addAttribute("regimen",regimen);
		model.addAttribute("estatus",estatus);
		return sat;
	}
	
	@RequestMapping(value = "/home/cat/sat/regimen/crud", method = {RequestMethod.POST,RequestMethod.GET})
	public String operationRegimenFiscales(Model model, SessionStatus sessionStatus,
			HttpServletRequest request,@RequestParam(value= "clave" , defaultValue = "0") Integer regimen
			,@RequestParam(value= "event" , defaultValue = "empty") String evento){
		procesoGeneral.loggerUsr(contr, request);
		satService.queryFindRegimenFiscal(model,request,regimen,evento);
		return satCrud;
	}
	
	@RequestMapping(value = "/home/cat/sat/regimen/save", method = {RequestMethod.POST,RequestMethod.GET})
	public String saveRegimenFiscales(Model model, SessionStatus sessionStatus,
			HttpServletRequest request,@RequestParam(value= "idRegimen" , defaultValue = "0") Integer regimen
			,@RequestParam(value= "clave" , defaultValue = "empty") String clave
			,@RequestParam(value= "descripcion" , defaultValue = "empty") String descripcion
			,@RequestParam(value= "fisica" , defaultValue = "empty") String fisica
			,@RequestParam(value= "moral" , defaultValue = "empty") String moral
			,@RequestParam(value= "estatus" , defaultValue = "empty") String estatus
			,@RequestParam(value= "evento" , defaultValue = "empty") String evento){
		procesoGeneral.loggerUsr(contr, request);
		satService.SaveOrUpdateRegimenFiscal(model,request,regimen,clave,descripcion,fisica,moral,evento,estatus);
		return "redirect:/home/cat/sat/regimen";
	}

	@RequestMapping(value = "/home/cat/sat/comprobantes", method = {RequestMethod.POST,RequestMethod.GET})
	public String mostrarConsultaTipoComprobantes(Model model, SessionStatus sessionStatus,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			HttpServletRequest request,@RequestParam(value= "comprobante" , defaultValue = "0") Integer comprobante
			,@RequestParam(value= "estatus" , defaultValue = "empty") String estatus){
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaTipoComprobantes(model, request);	
		satService.queryTiposComprobante(count, model, request, fromRow, comprobante, estatus);
		satService.queryTiposComprobante(consulta, model, request, fromRow, comprobante, estatus);
		model.addAttribute("comprobante",comprobante);
		model.addAttribute("estatus",estatus);
		return comprobantes;
	}
	@RequestMapping(value = "/home/cat/sat/comprobantes/crud", method = {RequestMethod.POST,RequestMethod.GET})
	public String operationComprobantes(Model model, SessionStatus sessionStatus,
			HttpServletRequest request,@RequestParam(value= "clave" , defaultValue = "0") Integer comprobante
			,@RequestParam(value= "event" , defaultValue = "empty") String evento){
		procesoGeneral.loggerUsr(contr, request);
		satService.queryFindTiposComprobante(model,request,comprobante,evento);
		
		return comprobantesCrud;
	}
	@RequestMapping(value = "/home/cat/sat/comprobantes/save", method = {RequestMethod.POST,RequestMethod.GET})
	public String saveTipoComprobante(Model model, SessionStatus sessionStatus,
			HttpServletRequest request,@RequestParam(value= "idComprobantes" , defaultValue = "0") Integer comprobantes
			,@RequestParam(value= "clave" , defaultValue = "empty") String clave
			,@RequestParam(value= "descripcion" , defaultValue = "empty") String descripcion
			,@RequestParam(value= "minimo" , defaultValue = "0") Integer minimo
			,@RequestParam(value= "maximo" , defaultValue = "0") Integer maximo
			,@RequestParam(value= "estatus" , defaultValue = "empty") String estatus
			,@RequestParam(value= "evento" , defaultValue = "empty") String evento){
		procesoGeneral.loggerUsr(contr, request);
		satService.SaveOrUpdateTiposComprobante(model,request,comprobantes,clave,descripcion,minimo,maximo,evento,estatus);
		return "redirect:/home/cat/sat/comprobantes";
	}
	

	
	
	@RequestMapping(value = "/home/cat/sat/cfdi", method = {RequestMethod.POST,RequestMethod.GET})
	public String mostrarConsultaMantenerCatalogoUsosCfdi(Model model, SessionStatus sessionStatus,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			HttpServletRequest request,@RequestParam(value= "cfdi" , defaultValue = "0") Integer cfdi
			,@RequestParam(value= "estatus" , defaultValue = "empty") String estatus){
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaUsosCFDI(model, request);	
		satService.queryUsosCfdi(count, model, request, fromRow, cfdi, estatus);
		satService.queryUsosCfdi(consulta, model, request, fromRow, cfdi, estatus);
		model.addAttribute("cfdi",cfdi);
		model.addAttribute("estatus",estatus);
		return usocfdi;
	}
	@RequestMapping(value = "/home/cat/sat/cfdi/crud", method = {RequestMethod.POST,RequestMethod.GET})
	public String operationUsoCfdi(Model model, SessionStatus sessionStatus,
			HttpServletRequest request,@RequestParam(value= "clave" , defaultValue = "0") Integer cfdi
			,@RequestParam(value= "event" , defaultValue = "empty") String evento){
		procesoGeneral.loggerUsr(contr, request);
		satService.queryFindUsoCfdi(model,request,cfdi,evento);
		return usocfdiCrud;
	}
	@RequestMapping(value = "/home/cat/sat/cfdi/save", method = {RequestMethod.POST,RequestMethod.GET})
	public String saveUsoCfdi(Model model, SessionStatus sessionStatus,
			HttpServletRequest request,@RequestParam(value= "idcfdi" , defaultValue = "0") Integer cfdi
			,@RequestParam(value= "clave" , defaultValue = "empty") String clave
			,@RequestParam(value= "descripcion" , defaultValue = "empty") String descripcion
			,@RequestParam(value= "fisica" , defaultValue = "empty") String fisica
			,@RequestParam(value= "moral" , defaultValue = "empty") String moral
			,@RequestParam(value= "estatus" , defaultValue = "empty") String estatus
			,@RequestParam(value= "evento" , defaultValue = "empty") String evento){
		procesoGeneral.loggerUsr(contr, request);
		satService.SaveOrUpdateUsoCfdi(model,request,cfdi,clave,descripcion,fisica,moral,evento,estatus);
		return "redirect:/home/cat/sat/cfdi";
	}
	@RequestMapping(value = "/home/cat/sat/formaspago", method = {RequestMethod.POST,RequestMethod.GET})
	public String mostrarConsultaFormasDePago(Model model, SessionStatus sessionStatus,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			HttpServletRequest request,@RequestParam(value= "forma" , defaultValue = "0") Integer forma
			,@RequestParam(value= "estatus" , defaultValue = "empty") String estatus){
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaFormaPago(model, request);	
		satService.queryFormasPago(count, model, request, fromRow, forma, estatus);
		satService.queryFormasPago(consulta, model, request, fromRow, forma, estatus);
		model.addAttribute("forma",forma);
		model.addAttribute("estatus",estatus);
		return formapago;
	}
	@RequestMapping(value = "/home/cat/sat/formaspago/crud", method = {RequestMethod.POST,RequestMethod.GET})
	public String operationFormasPago(Model model, SessionStatus sessionStatus,
			HttpServletRequest request,@RequestParam(value= "clave" , defaultValue = "0") Integer formas
			,@RequestParam(value= "event" , defaultValue = "empty") String evento){
		procesoGeneral.loggerUsr(contr, request);
		satService.queryFindFormasPago(model,request,formas,evento);
		return formapagoCrud;
	}
	@RequestMapping(value = "/home/cat/sat/formaspago/save", method = {RequestMethod.POST,RequestMethod.GET})
	public String saveFormasPago(Model model, SessionStatus sessionStatus,
			HttpServletRequest request,@RequestParam(value= "idpago" , defaultValue = "0") Integer formas
			,@RequestParam(value= "clave" , defaultValue = "empty") String clave
			,@RequestParam(value= "descripcion" , defaultValue = "empty") String descripcion
			,@RequestParam(value= "bancarizado" , defaultValue = "empty") String bancarizado
			,@RequestParam(value= "estatus" , defaultValue = "empty") String estatus
			,@RequestParam(value= "evento" , defaultValue = "empty") String evento){
		procesoGeneral.loggerUsr(contr, request);
		satService.SaveOrUpdateFormasPago(model,request,formas,clave,descripcion,bancarizado,evento,estatus);
		return "redirect:/home/cat/sat/formaspago";
		
	}
	/**
	 * LUIS ANOTNIO GUTIERREZ ESTRADA
	 * @param model
	 * @param sessionStatus
	 * @param fromRow
	 * @param request
	 * @param impuesto
	 * @param estatus
	 * @return
	 */
	@RequestMapping("/home/cat/sat/impuesto")
	public String mostrarTiposImpuesto(Model model,SessionStatus sessionStatus,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			HttpServletRequest request,@RequestParam(value= "idImpuesto" , defaultValue = "0") Integer impuesto	
			,@RequestParam(value= "estatus" , defaultValue = "empty") String estatus) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaTiposImpuesto(model, request);
		satService.queryTiposImpuesto(count, model, request, fromRow,impuesto,estatus );
		satService.queryTiposImpuesto(consulta, model, request, fromRow,impuesto,estatus );
		model.addAttribute("impuesto",impuesto);
		model.addAttribute("estatus",estatus);
		return Imp;

	}
	/**
	 * LUIS ANOTNIO GUTIERREZ ESTRADA
	 * @param model
	 * @param sessionStatus
	 * @param request
	 * @param impuesto
	 * @param evento
	 * @return
	 */
	@RequestMapping(value = "/home/cat/sat/impuesto/crud", method = {RequestMethod.POST,RequestMethod.GET})
	public String operationTiposImpuesto(Model model, SessionStatus sessionStatus,
			HttpServletRequest request
			,@RequestParam(value= "clave" , defaultValue = "0") Integer impuesto
			,@RequestParam(value= "event" , defaultValue = "empty") String evento){
		procesoGeneral.loggerUsr(contr, request);
		satService.queryFindTipoImpuesto(model,request,impuesto,evento);
		return "catalogo/sat/mantenerCatalagoTiposImpuestoCrud";
		
	}
	/**
	 * LUIS ANOTNIO GUTIERREZ ESTRADA
	 * @param model
	 * @param sessionStatus
	 * @param request
	 * @param impuesto
	 * @param clave
	 * @param tras
	 * @param estatus
	 * @param Tipoentidad
	 * @param descripcion
	 * @param reten
	 * @param entidad
	 * @param evento
	 * @return
	 */
	@RequestMapping(value = "/home/cat/sat/impuesto/save", method = {RequestMethod.POST,RequestMethod.GET})
	public String saveTiposImpuesto(Model model, SessionStatus sessionStatus,
			HttpServletRequest request
			,@RequestParam(value= "idImpuesto" , defaultValue = "0") Integer impuesto
			,@RequestParam(value= "clave" , defaultValue = "empty") String clave
			,@RequestParam(value= "tras" , defaultValue = "empty") String tras
			,@RequestParam(value= "estatus" , defaultValue = "empty") String estatus
			,@RequestParam(value= "Tipoentidad" , defaultValue = "empty") String Tipoentidad
			,@RequestParam(value= "descripcion" , defaultValue = "empty") String descripcion
			,@RequestParam(value= "reten" , defaultValue = "empty") String reten
			,@RequestParam(value= "entidad" , defaultValue = "empty") String entidad
			,@RequestParam(value= "evento" , defaultValue = "empty") String evento
			){
	procesoGeneral.loggerUsr(contr, request);
		satService.SaveOrUpdateTiposImpuesto(model,request,impuesto,clave,tras,estatus,Tipoentidad,descripcion,reten,entidad,evento);
		return "redirect:/home/cat/sat/impuesto";
		
	}
	
	
/**
 * LUIS ANOTNIO GUTIERREZ ESTRADA	
 * @param model
 * @param sessionStatus
 * @param fromRow
 * @param request
 * @param factor
 * @param estatus
 * @return
 */
	@RequestMapping("/home/cat/sat/factor")
	public String mostrarTiposFactor(Model model,SessionStatus sessionStatus,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			HttpServletRequest request,@RequestParam(value= "factor" , defaultValue = "0") Integer factor	
			,@RequestParam(value= "estatus" , defaultValue = "empty") String estatus) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaTiposFactor(model, request);
		satService.queryTiposFactor(count, model, request, fromRow,factor,estatus );
		satService.queryTiposFactor(consulta, model, request, fromRow,factor,estatus );
		model.addAttribute("factor",factor);
		model.addAttribute("estatus",estatus);
		return Imf;
		
	}
	
/**
 * LUIS ANOTNIO GUTIERREZ ESTRADA
 * @param model
 * @param sessionStatus
 * @param request
 * @param factor
 * @param evento
 * @return
 */
	@RequestMapping(value = "/home/cat/sat/factor/crud", method = {RequestMethod.POST,RequestMethod.GET})
	public String operationTiposFactor(Model model, SessionStatus sessionStatus,
			HttpServletRequest request
			,@RequestParam(value= "clave" , defaultValue = "0") Integer factor
			,@RequestParam(value= "event" , defaultValue = "empty") String evento){
		procesoGeneral.loggerUsr(contr, request);
		satService.queryFindTipoFactor(model,request,factor,evento);
		return "catalogo/sat/mantenerCatalogoTiposFactorCrud";
		
	}
	/**LUIS ANOTNIO GUTIERREZ ESTRADA
	 * 
	 * @param model
	 * @param sessionStatus
	 * @param request
	 * @param factor
	 * @param clave
	 * @param descripcion
	 * @param estatus
	 * @param evento
	 * @return
	 */
	@RequestMapping(value = "/home/cat/sat/factor/save", method = {RequestMethod.POST,RequestMethod.GET})
	public String saveTiposFactor(Model model, SessionStatus sessionStatus,
			HttpServletRequest request
			,@RequestParam(value= "idFactor" , defaultValue = "0") Integer factor
			,@RequestParam(value= "clave" , defaultValue = "empty") String clave
			,@RequestParam(value= "descripcion" , defaultValue = "empty") String descripcion
			,@RequestParam(value= "estatus" , defaultValue = "empty") String estatus
			,@RequestParam(value= "evento" , defaultValue = "empty") String evento
			){
	procesoGeneral.loggerUsr(contr, request);
		satService.SaveOrUpdateTiposFactor(model,request,factor,clave,descripcion,estatus,evento);
		return "redirect:/home/cat/sat/factor";
		
	}

	/**
	 * LUIS ANOTNIO GUTIERREZ ESTRADA
	 * @param model
	 * @param sessionStatus
	 * @param fromRow
	 * @param request
	 * @param tasascuota
	 * @param estatus
	 * @return
	 */
	@RequestMapping("/home/cat/sat/tasascuota")
	public String mostrarTasasCuotas(Model model,SessionStatus sessionStatus,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			HttpServletRequest request,@RequestParam(value= "tasascuota" , defaultValue = "0") Integer tasascuota	
			,@RequestParam(value= "estatus" , defaultValue = "empty") String estatus) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaTasasCuotas(model, request);
		satService.queryTasasCuota(count, model, request, fromRow,tasascuota,estatus );
		satService.queryTasasCuota(consulta, model, request, fromRow,tasascuota,estatus );
		model.addAttribute("tasascuota",tasascuota);
		model.addAttribute("estatus",estatus);
		return tc;
		
	}
	
	@RequestMapping(value = "/home/cat/sat/metodopago", method = {RequestMethod.POST,RequestMethod.GET})
	public String mostrarConsultaMetodoPago(Model model, SessionStatus sessionStatus,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			HttpServletRequest request,@RequestParam(value= "metodos" , defaultValue = "0") Integer metodos
			,@RequestParam(value= "estatus" , defaultValue = "empty") String estatus){
		procesoGeneral.loggerUsr(contr, request);		
		satService.queryMetodosPagos(count, model, request, fromRow, metodos, estatus);
		satService.queryMetodosPagos(consulta, model, request, fromRow, metodos, estatus);
		
		listaGeneralService.listaMetodosPago(model, request);
		model.addAttribute("metodos",metodos);
		model.addAttribute("estatus",estatus);
		return satM;
	}
	@RequestMapping(value = "/home/cat/sat/metodopago/crud", method = {RequestMethod.POST,RequestMethod.GET})
	public String operationMetodoPago(Model model, SessionStatus sessionStatus,
			HttpServletRequest request,@RequestParam(value= "clave" , defaultValue = "0") Integer metodos
			,@RequestParam(value= "event" , defaultValue = "empty") String evento){
		procesoGeneral.loggerUsr(contr, request);
		satService.queryFindMetodosPago(model,request,metodos,evento);
		return satMCrud;
	}
	
	@RequestMapping(value = "/home/cat/sat/metodopago/save", method = {RequestMethod.POST,RequestMethod.GET})
	public String saveMetodoPago(Model model, SessionStatus sessionStatus,
			HttpServletRequest request,@RequestParam(value= "idMetodos" , defaultValue = "0") Integer metodos
			,@RequestParam(value= "clave" , defaultValue = "empty") String clave
			,@RequestParam(value= "descripcion" , defaultValue = "empty") String descripcion
			,@RequestParam(value= "estatus" , defaultValue = "empty") String estatus
			,@RequestParam(value= "usuario" , defaultValue = "empty") String usuario
			,@RequestParam(value= "evento" , defaultValue = "empty") String evento){
		procesoGeneral.loggerUsr(contr, request);
		satService.SaveOrUpdateMetodosPago(model,request,metodos,clave,descripcion,evento,estatus);
		return "redirect:/home/cat/sat/metodopago";
	}
	
	/**
	 * LUIS ANOTNIO GUTIERREZ ESTRADA
	 * @param model
	 * @param sessionStatus
	 * @param request
	 * @param tasascuota
	 * @param evento
	 * @return
	 */
	@RequestMapping(value = "/home/cat/sat/tasascuota/crud", method = {RequestMethod.POST,RequestMethod.GET})
	public String operationTasasCuotas(Model model, SessionStatus sessionStatus,
			HttpServletRequest request
			,@RequestParam(value= "clave" , defaultValue = "0") Integer tasascuota
			,@RequestParam(value= "event" , defaultValue = "empty") String evento){
		procesoGeneral.loggerUsr(contr, request);
		satService.queryFindTasasCuotas(model,request,tasascuota,evento);
		return "catalogo/sat/mantenerCatalogoTasasCuotasCrud";




	}
	/**
	 * LUIS ANOTNIO GUTIERREZ ESTRADA
	 * @param model
	 * @param sessionStatus
	 * @param request
	 * @param tasascuota
	 * @param clave
	 * @param descripcion
	 * @param valormaximo
	 * @param valorminimo
	 * @param estatus
	 * @param usuario
	 * @param evento
	 * @return
	 */
	@RequestMapping(value = "/home/cat/sat/tasascuota/save", method = {RequestMethod.POST,RequestMethod.GET})
	public String saveTasascuota(Model model, SessionStatus sessionStatus,
			HttpServletRequest request
			,@RequestParam(value= "idtasascuota" , defaultValue = "0") Integer tasascuota
			,@RequestParam(value= "clave" , defaultValue = "empty") String clave
			,@RequestParam(value= "descripcion" , defaultValue = "empty") String descripcion
			,@RequestParam(value= "valorminimo" , defaultValue = "empty") String valormaximo
			,@RequestParam(value= "valormaximo" , defaultValue = "empty") String valorminimo
			,@RequestParam(value= "estatus" , defaultValue = "empty") String estatus
			,@RequestParam(value= "evento" , defaultValue = "empty") String evento
			){
	procesoGeneral.loggerUsr(contr, request);
		satService.SaveOrUpdateTasascuota(model,request,tasascuota,clave,descripcion,valorminimo,valormaximo,estatus,evento);
		return "redirect:/home/cat/sat/tasascuota";
		
	}
	
	/**
	 * Sanchez Aguilar Jesus Alfonso
	 * @return
	 */
	@RequestMapping(value = "/home/cat/sat/relacion", method = {RequestMethod.POST,RequestMethod.GET})
	public String mostrarConsultaTipoRelacion(Model model, SessionStatus sessionStatus,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			HttpServletRequest request,@RequestParam(value= "metodos" , defaultValue = "0") Integer metodos
			,@RequestParam(value= "estatus" , defaultValue = "empty") String estatus){
		procesoGeneral.loggerUsr(contr, request);		
		satService.queryTiposRelacion(count, model, request, fromRow, metodos, estatus);
		satService.queryTiposRelacion(consulta, model, request, fromRow, metodos, estatus);
		
		listaGeneralService.listaTipoRelacion(model, request);
		model.addAttribute("metodos",metodos);
		model.addAttribute("estatus",estatus);
		return tiposR;
	}
	/**
	 * Sanchez Aguilar Jesus Alfonso
	 * @return
	 */
	@RequestMapping(value = "/home/cat/sat/relacion/crud", method = {RequestMethod.POST,RequestMethod.GET})
	public String operationTipoRelacion(Model model, SessionStatus sessionStatus,
			HttpServletRequest request,@RequestParam(value= "clave" , defaultValue = "0") Integer metodos
			,@RequestParam(value= "event" , defaultValue = "empty") String evento){
		procesoGeneral.loggerUsr(contr, request);
		satService.queryFindTiposRelacion(model,request,metodos,evento);
		return tiposRCrud;
	}
	/**
	 * Sanchez Aguilar Jesus Alfonso
	 * @return
	 */
	@RequestMapping(value = "/home/cat/sat/relacion/save", method = {RequestMethod.POST,RequestMethod.GET})
	public String saveTipoRelacion(Model model, SessionStatus sessionStatus,
			HttpServletRequest request,@RequestParam(value= "idRelacion" , defaultValue = "0") Integer metodos
			,@RequestParam(value= "clave" , defaultValue = "empty") String clave
			,@RequestParam(value= "descripcion" , defaultValue = "empty") String descripcion
			,@RequestParam(value= "estatus" , defaultValue = "empty") String estatus
			,@RequestParam(value= "usuario" , defaultValue = "empty") String usuario
			,@RequestParam(value= "evento" , defaultValue = "empty") String evento){
		procesoGeneral.loggerUsr(contr, request);
		satService.SaveOrUpdateTiposRelacion(model,request,metodos,clave,descripcion,evento,estatus);
		return "redirect:/home/cat/sat/relacion";
	}
	
	/**
	 * LUIS ANOTNIO GUTIERREZ ESTRADA
	 * @param model
	 * @param sessionStatus
	 * @param fromRow
	 * @param request
	 * @param certificado
	 * @param estatus
	 * @return
	 */
	@RequestMapping("home/cat/sat/certificado")
	public String mostrarCertificados(Model model,SessionStatus sessionStatus,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			HttpServletRequest request,@RequestParam(value= "certificado" , defaultValue = "0") Integer certificado	
			,@RequestParam(value= "estatus" , defaultValue = "empty") String estatus) {
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.ListaCertificados(model, request);
		satService.queryCertificado(count, model, request, fromRow,certificado,estatus );
		satService.queryCertificado(consulta, model, request, fromRow,certificado,estatus );
		model.addAttribute("certificado",certificado);
		model.addAttribute("estatus",estatus);
		return cc;
		
	}
	/**
	 * LUIS ANOTNIO GUTIERREZ ESTRADA
	 * @param model
	 * @param sessionStatus
	 * @param request
	 * @param certificado
	 * @param evento
	 * @return
	 */
	@RequestMapping(value = "/home/cat/sat/certificado/crud", method = {RequestMethod.POST,RequestMethod.GET})
	public String operationCertificados(Model model, SessionStatus sessionStatus,
			HttpServletRequest request,@RequestParam(value= "clave" , defaultValue = "0") Integer certificado
			,@RequestParam(value= "event" , defaultValue = "empty") String evento){
		procesoGeneral.loggerUsr(contr, request);
		listaGeneralService.listaEmpresas(model, request);
		satService.queryFindCertificados(model,request,certificado,evento);
		return "catalogo/sat/mantenerCatalogoCertificadoCrud";
	}
	/**
	 * LUIS ANOTNIO GUTIERREZ ESTRADA
	 * @param model
	 * @param sessionStatus
	 * @param request
	 * @param certificado
	 * @param cert_privado
	 * @param cert_publico
	 * @param descripcion
	 * @param estatus
	 * @param id_empresa
	 * @param cert_ruta
	 * @param evento
	 * @return
	 */
	@RequestMapping(value = "/home/cat/sat/certificado/save", method = {RequestMethod.POST,RequestMethod.GET})
	public String saveCertificado(Model model, SessionStatus sessionStatus,
			HttpServletRequest request
			,@RequestParam(value= "idcertificado" , defaultValue = "0") Integer certificado
			,@RequestParam(value= "cert_privado" , defaultValue = "empty") String cert_privado
			,@RequestParam(value= "cert_publico" , defaultValue = "empty") String cert_publico
			,@RequestParam(value= "descripcion" , defaultValue = "empty") String descripcion
			,@RequestParam(value= "estatus" , defaultValue = "empty") String estatus
			,@RequestParam(value= "certificado" , defaultValue = "empty") String id_empresa
			,@RequestParam(value= "cert_ruta" , defaultValue = "empty") String cert_ruta
			,@RequestParam(value= "evento" , defaultValue = "empty") String evento){
		procesoGeneral.loggerUsr(contr, request);

		satService.SaveOrUpdateCertificado(model,request,certificado,cert_privado,cert_publico,descripcion,estatus,id_empresa,cert_ruta,evento);
		return "redirect:/home/cat/sat/certificado";
		
		
	}
	/**
	 * Sanchez Aguilar Jesus Alfonso
	 * @return
	 */
	@RequestMapping(value = "/home/cat/sat/servicio", method = {RequestMethod.POST,RequestMethod.GET})
	public String mostrarConsultaClavesServicio(Model model, SessionStatus sessionStatus,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			HttpServletRequest request,@RequestParam(value= "metodos" , defaultValue = "0") Integer metodos
			,@RequestParam(value= "estatus" , defaultValue = "empty") String estatus){
		procesoGeneral.loggerUsr(contr, request);		
		satService.queryClavesServicio(count, model, request, fromRow, metodos, estatus);
		satService.queryClavesServicio(consulta, model, request, fromRow, metodos, estatus);
		
		listaGeneralService.listaClavesServicio(model, request);
		model.addAttribute("metodos",metodos);
		model.addAttribute("estatus",estatus);
		return clavesS;
	}
	/**
	 * Sanchez Aguilar Jesus Alfonso
	 * @return
	 */
	@RequestMapping(value = "/home/cat/sat/servicio/crud", method = {RequestMethod.POST,RequestMethod.GET})
	public String operationClavesServicio(Model model, SessionStatus sessionStatus,
			HttpServletRequest request,@RequestParam(value= "clave" , defaultValue = "0") Integer metodos
			,@RequestParam(value= "event" , defaultValue = "empty") String evento){
		procesoGeneral.loggerUsr(contr, request);
		satService.queryFindClavesServicio(model,request,metodos,evento);
		return 	clavesSCrud;
	}
	/**
	 * Sanchez Aguilar Jesus Alfonso
	 * @return
	 */
	@RequestMapping(value = "/home/cat/sat/servicio/save", method = {RequestMethod.POST,RequestMethod.GET})
	public String saveClavesServicio(Model model, SessionStatus sessionStatus,
			HttpServletRequest request,@RequestParam(value= "idServicio" , defaultValue = "0") Integer metodos
			,@RequestParam(value= "clave" , defaultValue = "empty") String clave
			,@RequestParam(value= "descripcion" , defaultValue = "empty") String descripcion
			,@RequestParam(value= "iva_traslado" , defaultValue = "empty") String iva_traslado
			,@RequestParam(value= "ieps_traslado" , defaultValue = "empty") String ieps_traslado
			,@RequestParam(value= "estatus" , defaultValue = "empty") String estatus
			,@RequestParam(value= "usuario" , defaultValue = "empty") String usuario
			,@RequestParam(value= "evento" , defaultValue = "empty") String evento){
		procesoGeneral.loggerUsr(contr, request);
		satService.SaveOrUpdateClavesServicio(model,request,metodos,clave,descripcion,iva_traslado,ieps_traslado,evento,estatus);
		return "redirect:/home/cat/sat/servicio";
	}
	
	/**
	 * Sanchez Aguilar Jesus Alfonso
	 * @return
	 */
	@RequestMapping(value = "/home/cat/sat/unidad", method = {RequestMethod.POST,RequestMethod.GET})
	public String mostrarConsultaClavesUnidad(Model model, SessionStatus sessionStatus,
			@RequestParam(value = "fromRow", defaultValue = "0") Integer fromRow,
			HttpServletRequest request,@RequestParam(value= "metodos" , defaultValue = "0") Integer metodos
			,@RequestParam(value= "estatus" , defaultValue = "empty") String estatus){
		procesoGeneral.loggerUsr(contr, request);		
		satService.queryClavesUnidad(count, model, request, fromRow, metodos, estatus);
		satService.queryClavesUnidad(consulta, model, request, fromRow, metodos, estatus);
		
		listaGeneralService.listaClavesUnidad(model, request);
		model.addAttribute("metodos",metodos);
		model.addAttribute("estatus",estatus);
		return clavesU;
	}
	/**
	 * Sanchez Aguilar Jesus Alfonso
	 * @return
	 */
	@RequestMapping(value = "/home/cat/sat/unidad/crud", method = {RequestMethod.POST,RequestMethod.GET})
	public String operationClavesUnidad(Model model, SessionStatus sessionStatus,
			HttpServletRequest request,@RequestParam(value= "clave" , defaultValue = "0") Integer metodos
			,@RequestParam(value= "event" , defaultValue = "empty") String evento){
		procesoGeneral.loggerUsr(contr, request);
		satService.queryFindClavesUnidad(model,request,metodos,evento);
		return 	clavesUCrud;
	}
	/**
	 * Sanchez Aguilar Jesus Alfonso
	 * @return
	 */
	@RequestMapping(value = "/home/cat/sat/unidad/save", method = {RequestMethod.POST,RequestMethod.GET})
	public String saveClavesUnidad(Model model, SessionStatus sessionStatus,
			HttpServletRequest request,@RequestParam(value= "idUnidad" , defaultValue = "0") Integer metodos
			,@RequestParam(value= "clave" , defaultValue = "empty") String clave
			,@RequestParam(value= "descripcion" , defaultValue = "empty") String descripcion
			,@RequestParam(value= "simbolo" , defaultValue = "empty") String simbolo
			,@RequestParam(value= "estatus" , defaultValue = "empty") String estatus
			,@RequestParam(value= "usuario" , defaultValue = "empty") String usuario
			,@RequestParam(value= "evento" , defaultValue = "empty") String evento){
		procesoGeneral.loggerUsr(contr, request);
		satService.SaveOrUpdateClavesUnidad(model,request,metodos,clave,descripcion,simbolo,evento,estatus);
		return "redirect:/home/cat/sat/unidad";
	}
}

