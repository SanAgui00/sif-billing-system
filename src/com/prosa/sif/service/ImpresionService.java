package com.prosa.sif.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prosa.sif.dao.ImpresionDao;
import com.prosa.sif.pojo.TablaEstiloCarta;


@Service
public class ImpresionService {
	@Autowired
	private ImpresionDao impresiones_dao;
	public List<TablaEstiloCarta> findAll_TBL_SIF_ESTILO_CARTA() {
		return impresiones_dao.findAll_TBL_SIF_ESTILO_CARTA();
	}
	public List<TablaEstiloCarta> findById_TBL_SIF_CAT_ESTILOS_CARTA(int id) {
		return impresiones_dao.findById_TBL_SIF_ESTILO_CARTA(id);
	}
	public void ActbyId_TBL_SIF_CAT_ESTILOS_CARTA( String event, int id,
			String status, String cuenta, String clave, String descripcion, String autor, String cuenta1) {
		impresiones_dao.ImpresionesDaoImpl(event,id,status,cuenta,clave,descripcion,autor,cuenta1);
	}
	
}
