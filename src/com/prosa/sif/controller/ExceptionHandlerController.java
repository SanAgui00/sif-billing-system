/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 08/03/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/
package com.prosa.sif.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.prosa.sif.operation.ProcesoGeneral;

@ControllerAdvice
public class ExceptionHandlerController {
	@Autowired
	private ProcesoGeneral procesoGeneral;
	
	private static String dataexception = "layout/dataexception";

	/*
	 * Manejador de Rollback transaction
	 */
	@ExceptionHandler(org.hibernate.TransactionException.class)
	public String handleErrorRollback(HttpServletRequest request, Exception e) {
		procesoGeneral.loggerErr("TransactionException", request, e);
		return dataexception;
	}

	/*
	 * Manejador de errores al crear una nueva conexión
	 */
	@ExceptionHandler(org.hibernate.exception.GenericJDBCException.class)
	public String handleErrorConnection(HttpServletRequest request, Exception e) {
		procesoGeneral.loggerErr("GenericJDBCException", request, e);
		return dataexception;
	}

	/*
	 * Manejador de errores 404
	 */
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleError404(HttpServletRequest request, Exception e) {
		procesoGeneral.loggerErr("404", request, e);
		return "layout/404";
	}
	@ExceptionHandler(java.lang.ArrayIndexOutOfBoundsException.class)
	public String handleArray(HttpServletRequest request, Exception ex) {
		
		procesoGeneral.loggerErr("ArrayIndexOutOfBoundsException", request, ex);
		return dataexception;
	}
	@ExceptionHandler(java.sql.SQLException.class)
	public String handleSQLException(HttpServletRequest request, Exception e) {
		
		return dataexception;
	}
	@ExceptionHandler(org.hibernate.exception.SQLGrammarException.class)
	public String handleSQLGrammarException(HttpServletRequest request, Exception e) {
		
		return dataexception;
	}
	@ExceptionHandler(org.hibernate.exception.DataException.class)
	public String handleSQLDataException(HttpServletRequest request, Exception e) {

		return dataexception;
	}
}