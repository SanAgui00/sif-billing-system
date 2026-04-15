package com.prosa.sif.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prosa.sif.dao.ApoyoDao;
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

@Service
public class ApoyoService {
	@Autowired
	private ApoyoDao apoyoDao;

	public void queryEmpresa(String tipo, Model model, HttpServletRequest request, Integer id_empresa,
			Integer fromRow) {
		apoyoDao.queryEmpresa(tipo, model, request, id_empresa, fromRow);

	}

	public void crudEmpresa(Model model, HttpServletRequest request, String evento, TablaEmpresa insert,
			String fecha_cre, String fecha_mod) {
		apoyoDao.crudEmpresa(model, request, evento, insert, fecha_cre, fecha_mod);
	}

	public void queryFuente(String tipo, Model model, HttpServletRequest request, Integer id_fuente, Integer fromRow) {
		apoyoDao.queryFuente(tipo, model, request, id_fuente, fromRow);
	}

	public void crudFuente(Model model, HttpServletRequest request, String evento, Integer id_fuente, String clave,
			Integer id_fuente_base_clave_cli, String descripcion, String comentarios) {
		apoyoDao.crudFuente(model, request, evento, id_fuente, clave, id_fuente_base_clave_cli, descripcion,
				comentarios);
	}

	public void queryProceso(String tipo, Model model, HttpServletRequest request, Integer id_proceso,
			Integer fromRow) {
		apoyoDao.queryProceso(tipo, model, request, id_proceso, fromRow);
	}

	public void crudProceso(Model model, HttpServletRequest request, String evento, TablaProceso insert,
			String fecha_cre, String fecha_mod) {
		apoyoDao.crudProceso(model, request, evento, insert, fecha_cre, fecha_mod);

	}

	public void queryCentroCosto(String tipo, Model model, HttpServletRequest request, Integer id_centro_costos,
			Integer fromRow) {
		apoyoDao.queryCentroCosto(tipo, model, request, id_centro_costos, fromRow);
	}

	public void crudCentroCosto(Model model, HttpServletRequest request, String evento, TablaCentroCosto insert,
			String fecha_cre, String fecha_mod) {
		apoyoDao.crudCentroCosto(model, request, evento, insert, fecha_cre, fecha_mod);
	}

	public void queryCuentaContable(String tipo, Model model, HttpServletRequest request, Integer id_tipo_cuenta,
			Integer fromRow) {
		apoyoDao.queryCuentaContable(tipo, model, request, id_tipo_cuenta, fromRow);
	}

	public void crudCuentaContable(Model model, HttpServletRequest request, String evento, TablaTipoCuenta insert,
			String fecha_cre, String fecha_mod) {
		apoyoDao.crudCuentaContable(model, request, evento, insert, fecha_cre, fecha_mod);
	}

	public void queryFormaPago(String tipo, Model model, HttpServletRequest request, Integer id_forma_pago,
			Integer fromRow) {
		apoyoDao.queryFormaPago(tipo, model, request, id_forma_pago, fromRow);
	}

	public void crudFormaPago(Model model, HttpServletRequest request, String evento, TablaFormaPagos insert,
			String fecha_cre, String fecha_mod) {
		apoyoDao.crudFormaPago(model, request, evento, insert, fecha_cre, fecha_mod);
	}

	public void queryTipoPago(String tipo, Model model, HttpServletRequest request, Integer id_tipos_pago,
			Integer fromRow) {
		apoyoDao.queryTipoPago(tipo, model, request, id_tipos_pago, fromRow);
	}

	public void crudTipoPago(Model model, HttpServletRequest request, String evento, TablaTipoPago insert,
			String fecha_cre, String fecha_mod) {
		apoyoDao.crudTipoPago(model, request, evento, insert, fecha_cre, fecha_mod);
	}

	public void queryUMedida(String tipo, Model model, HttpServletRequest request, Integer id, String estatus,
			Integer fromRow) {
		apoyoDao.queryUMedida(tipo, model, request, id, estatus, fromRow);
	}

	public void crudUMedida(Model model, HttpServletRequest request, String evento, TablaUMedida insert,
			String fecha_cre, String fecha_mod) {
		apoyoDao.crudUMedida(model, request, evento, insert, fecha_cre, fecha_mod);
	}

	public void queryConcepto(String tipos, Model model, HttpServletRequest request, String tipo, Integer grupo,
			String descripcion, String estatus, Integer id, Integer fromRow) {
		apoyoDao.queryConcepto(tipos, model, request, tipo, grupo, descripcion, estatus, id, fromRow);
	}

	public void crudConcepto(Model model, HttpServletRequest request, String evento, TablaConcepto insert,
			String fecha_cre, String fecha_mod) {
		apoyoDao.crudConcepto(model, request, evento, insert, fecha_cre, fecha_mod);
	}

	public void queryAddenda(String tipo, Model model, HttpServletRequest request, Integer id_cliente, String addenda,
			String estatus, Integer id, Integer fromRow) {
		apoyoDao.queryAddenda(tipo, model, request, id_cliente, addenda, estatus, id, fromRow);
	}

	public void queryMoneda(String tipo, Model model, HttpServletRequest request, Integer id_moneda, Integer fromRow) {
		apoyoDao.queryMoneda(tipo, model, request, id_moneda, fromRow);
	}

	public void queryUsuario(String tipo, Model model, HttpServletRequest request, String usuario, Integer fromRow) {
		apoyoDao.queryUsuario(tipo, model, request, usuario, fromRow);
	}

	public void crudUsuario(Model model, HttpServletRequest request, String evento, TablaUsuario insert,
			String nombre_usuario) {
		apoyoDao.crudUsuario(model, request, evento, insert, nombre_usuario);
	}

	public void queryFuncionalidad(String tipo, Model model, HttpServletRequest request, Integer id, Integer fromRow) {
		apoyoDao.queryFuncionalidad(tipo, model, request, id, fromRow);
	}

	public void crudFuncionalidad(Model model, HttpServletRequest request, String evento, TablaFuncionalidad insert,
			String fecha_cre) {
		apoyoDao.crudFuncionalidad(model, request, evento, insert, fecha_cre);
	}

	public void queryParametro(String tipo, Model model, HttpServletRequest request, Integer id, Integer fromRow) {
		apoyoDao.queryParametro(tipo, model, request, id, fromRow);
	}

	public void queryEventoServicio(String tipo, Model model, HttpServletRequest request, Integer fromRow, Integer id,
			Integer evento, String estatus) {
		apoyoDao.queryEventoServicio(tipo, model, request, fromRow, id, evento, estatus);
	}

	public void crudEventoServicio(String evento, TablaEventoServicio insert, Model model, HttpServletRequest request) {
		apoyoDao.crudEventoServicio(evento, insert, model, request);
	}

	public void queryServiciosParticulares(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			Integer id) {
		apoyoDao.queryServiciosParticulares(tipo, model, request, fromRow, id);
	}

	public void crudServiciosParticulares(Model model, HttpServletRequest request, String evento,
			TablaServicioParticular insert) {
		apoyoDao.crudServiciosParticulares(model, request, evento, insert);
	}

	public void queryIngreso(String tipo, Model model, HttpServletRequest request, Integer fromRow, Integer id) {
		apoyoDao.queryIngreso(tipo, model, request, fromRow, id);
	}

	public void crudIngreso(Model model, HttpServletRequest request, String evento, TablaIngreso insert) {
		apoyoDao.crudIngreso(model, request, evento, insert);
	}

	public void crudAddenda(Model model, HttpServletRequest request, String evento, String fecha_cre, String fecha_mod,
			String valor, Integer id_cliente, String nombre, String descripcion, Integer id) {
		apoyoDao.crudAddenda(model, request, evento, fecha_cre, fecha_mod, valor, id_cliente, nombre, descripcion, id);
	}

	public void crudParametro(Model model, HttpServletRequest request, String evento, String fecha, Integer id,
			Integer id_funcionalidad, String valor2, String estatus, String usuario, String valor1, String nombre) {
		apoyoDao.crudParametro(model, request, evento, fecha, id, id_funcionalidad, valor2, estatus, usuario, valor1,
				nombre);
	}

	public void crudMoneda(Model model, HttpServletRequest request, String evento, Integer id_moneda,
			String nombre_moneda, String pais, String simbolo, Integer t_moneda, String estatus, String fecha_cre,
			String fecha_mod, String usuario, String comentarios, String clave_sat, String nombre_sat,
			Integer decimales, Integer variacion) {
		apoyoDao.crudMoneda(model, request, evento, id_moneda, nombre_moneda, pais, simbolo, t_moneda, estatus,
				fecha_cre, fecha_mod, usuario, comentarios, clave_sat, nombre_sat, decimales, variacion);
	}

	public void queryclienteEnServicio(Model model, HttpServletRequest request, String listaClienteEnServicio,
			String tipo, Integer fromRow) {
		apoyoDao.queryclienteEnServicio(model, request, listaClienteEnServicio, tipo, fromRow);
	}

	public void crudClienteEnServicio(Model model, HttpServletRequest request, String listaClienteServicio,
			Integer fromRow, String tipo) {
		apoyoDao.crudClienteEnServicio(model, request, listaClienteServicio, fromRow, tipo);
	}

	public void queryBanco(String tipo, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes,
			Integer id_cuenta, String estatus, Integer fromRow) {
		apoyoDao.queryBanco(tipo, model, request, redirectAttributes, id_cuenta, estatus, fromRow);
	}



}
