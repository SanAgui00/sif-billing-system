package com.prosa.sif.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.prosa.sif.dao.FacturaDao;

@Service
public class FacturaService {
	@Autowired
	private FacturaDao facturaDao;

	public void queryFacturas(Model model, HttpServletRequest request, String fecha_final) {
		facturaDao.queryFacturas(model, request, fecha_final);
	}

}
