package com.prosa.sif.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.prosa.sif.dao.GrupoDao;

@Service
public class GrupoService {
	@Autowired
	private GrupoDao grupoDao;

	public void queryConceptoServicio(String tipo, Integer idGrupo, Model model, HttpServletRequest request,
			Integer fromRow) {
		grupoDao.queryConceptoServicio(tipo, idGrupo, model, request, fromRow);
	}

	public void queryVolumenServicio(String tipo, Integer idGrupo, Model model, HttpServletRequest request,
			Integer fromRow) {
		grupoDao.queryVolumenServicio(tipo, idGrupo, model, request, fromRow);
	}

	public void queryVolumenCliente(String tipo, Integer idGrupo, Model model, HttpServletRequest request,
			Integer fromRow) {
		grupoDao.queryVolumenCliente(tipo, idGrupo, model, request, fromRow);
	}

	public void queryListaCliente(String tipo, Integer idGrupo, Model model, HttpServletRequest request,
			Integer fromRow) {
		grupoDao.queryListaCliente(tipo, idGrupo, model, request, fromRow);
	}

	public void crudConceptoServicio(String event, Integer idGrupo, String clave, String descripcion,
			String comentarios, Model model, HttpServletRequest request, String listaServiciosExluidos,
			String listaServiciosIncluidos) {
		grupoDao.crudConceptoServicio(event, idGrupo, clave, descripcion, comentarios, model, request,
				listaServiciosExluidos, listaServiciosIncluidos);
	}

	public void crudVolumenServicio(String event, Integer idGrupo, String clave, String descripcion, String comentarios,
			Model model, HttpServletRequest request, String listaServiciosExluidos, String listaServiciosIncluidos) {
		grupoDao.crudVolumenServicio(event, idGrupo, clave, descripcion, comentarios, model, request,
				listaServiciosExluidos, listaServiciosIncluidos);
	}

	public void crudVolumenCliente(String event, Integer idGrupo, String clave, String descripcion, String comentarios,
			Model model, HttpServletRequest request, String listaServiciosExluidos, String listaServiciosIncluidos) {
		grupoDao.crudVolumenCliente(event, idGrupo, clave, descripcion, comentarios, model, request,
				listaServiciosExluidos, listaServiciosIncluidos);
	}

	public void crudListaCliente(String event, Integer idGrupo, String clave, String descripcion, String comentarios,
			Model model, HttpServletRequest request, String esquema, String listaServiciosExluidos,
			String listaServiciosIncluidos, String listaBeneficiarios, String listaDistribucion) {
		grupoDao.crudListaCliente(event, idGrupo, clave, descripcion, comentarios, model, request, esquema,
				listaServiciosExluidos, listaServiciosIncluidos, listaBeneficiarios, listaDistribucion);
	}

}
