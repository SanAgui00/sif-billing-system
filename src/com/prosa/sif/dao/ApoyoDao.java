/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 16/04/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.dao;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prosa.sif.pojo.TablaCentroCosto;
import com.prosa.sif.pojo.TablaConcepto;
import com.prosa.sif.pojo.TablaEmpresa;
import com.prosa.sif.pojo.TablaEventoServicio;
import com.prosa.sif.pojo.TablaFormaPagos;
import com.prosa.sif.pojo.TablaFuncionalidad;
import com.prosa.sif.pojo.TablaIngreso;
import com.prosa.sif.pojo.TablaProceso;
import com.prosa.sif.pojo.TablaServicioParticular;
import com.prosa.sif.pojo.TablaTipoCuenta;
import com.prosa.sif.pojo.TablaTipoPago;
import com.prosa.sif.pojo.TablaUMedida;
import com.prosa.sif.pojo.TablaUsuario;

public interface ApoyoDao {

	void queryEmpresa(String tipo, Model model, HttpServletRequest request, Integer id_empresa, Integer fromRow);

	void crudEmpresa(Model model, HttpServletRequest request, String evento, TablaEmpresa insert, String fecha_cre,
			String fecha_mod);

	void queryFuente(String tipo, Model model, HttpServletRequest request, Integer id_fuente, Integer fromRow);

	void crudFuente(Model model, HttpServletRequest request, String evento, Integer id_fuente, String clave,
			Integer id_fuente_base_clave_cli, String descripcion, String comentarios);
	
	void queryProceso(String tipo, Model model, HttpServletRequest request, Integer id_proceso, Integer fromRow);

	void crudProceso(Model model, HttpServletRequest request, String evento, TablaProceso insert, String fecha_cre,
			String fecha_mod);

	void queryCentroCosto(String tipo, Model model, HttpServletRequest request, Integer id_centro_costos,
			Integer fromRow);

	void crudCentroCosto(Model model, HttpServletRequest request, String evento, TablaCentroCosto insert,
			String fecha_cre, String fecha_mod);

	void queryCuentaContable(String tipo, Model model, HttpServletRequest request, Integer id_tipo_cuenta,
			Integer fromRow);

	void crudCuentaContable(Model model, HttpServletRequest request, String evento, TablaTipoCuenta insert,
			String fecha_cre, String fecha_mod);

	void queryFormaPago(String tipo, Model model, HttpServletRequest request, Integer id_forma_pago, Integer fromRow);

	void crudFormaPago(Model model, HttpServletRequest request, String evento, TablaFormaPagos insert, String fecha_cre,
			String fecha_mod);

	void queryTipoPago(String tipo, Model model, HttpServletRequest request, Integer id_tipos_pago, Integer fromRow);

	void crudTipoPago(Model model, HttpServletRequest request, String evento, TablaTipoPago insert, String fecha_cre,
			String fecha_mod);

	void queryUMedida(String tipo, Model model, HttpServletRequest request, Integer id, String estatus,
			Integer fromRow);

	void crudUMedida(Model model, HttpServletRequest request, String evento, TablaUMedida insert, String fecha_cre,
			String fecha_mod);

	void queryConcepto(String tipo2, Model model, HttpServletRequest request, String tipo, Integer grupo,
			String descripcion, String estatus, Integer id, Integer fromRow);

	void crudConcepto(Model model, HttpServletRequest request, String evento, TablaConcepto insert, String fecha_cre,
			String fecha_mod);

	void queryAddenda(String tipo, Model model, HttpServletRequest request, Integer id_cliente, String addenda,
			String estatus, Integer id, Integer fromRow);

	void queryMoneda(String tipo, Model model, HttpServletRequest request, Integer id_moneda, Integer fromRow);

	void queryUsuario(String tipo, Model model, HttpServletRequest request, String usuario, Integer fromRow);

	void crudUsuario(Model model, HttpServletRequest request, String evento, TablaUsuario insert,
			String nombre_usuario);

	void queryFuncionalidad(String tipo, Model model, HttpServletRequest request, Integer id, Integer fromRow);

	void crudFuncionalidad(Model model, HttpServletRequest request, String evento, TablaFuncionalidad insert,
			String fecha_cre);

	void queryParametro(String tipo, Model model, HttpServletRequest request, Integer id, Integer fromRow);

	void queryEventoServicio(String tipo, Model model, HttpServletRequest request, Integer fromRow, Integer id,
			Integer evento, String estatus);

	void crudEventoServicio(String evento, TablaEventoServicio insert, Model model, HttpServletRequest request);

	void queryServiciosParticulares(String tipo, Model model, HttpServletRequest request, Integer fromRow, Integer id);

	void crudServiciosParticulares(Model model, HttpServletRequest request, String evento,
			TablaServicioParticular insert);

	void queryIngreso(String tipo, Model model, HttpServletRequest request, Integer fromRow, Integer id);

	void crudIngreso(Model model, HttpServletRequest request, String evento, TablaIngreso insert);

	void crudAddenda(Model model, HttpServletRequest request, String evento, String fecha_cre, String fecha_mod,
			String valor, Integer id_cliente, String nombre, String descripcion, Integer id);

	void crudParametro(Model model, HttpServletRequest request, String evento, String fecha, Integer id,
			Integer id_funcionalidad, String valor2, String estatus, String usuario, String valor1, String nombre);

	void crudMoneda(Model model, HttpServletRequest request, String evento, Integer id_moneda, String nombre_moneda,
			String pais, String simbolo, Integer t_moneda, String estatus, String fecha_cre, String fecha_mod,
			String usuario, String comentarios, String clave_sat, String nombre_sat, Integer decimales,
			Integer variacion);

	void queryclienteEnServicio(Model model, HttpServletRequest request, String listaClienteEnServicio, String tipo, Integer fromRow);

	void crudClienteEnServicio(Model model, HttpServletRequest request, String listaClienteServicio, Integer fromRow,
			String tipo);

	void queryBanco(String tipo, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes, Integer id_cuenta, String estatus, Integer fromRow);


	

}
