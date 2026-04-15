/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 05/04/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String showIndex(Model model) {
		return "redirect:/home";
	}

	@RequestMapping("/home")
	public String showIndex(Model model, HttpServletRequest request) {
		return "home/home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin(@RequestParam(value = "error", required = false) boolean error,
			@RequestParam(value = "session", required = false) String session, Model model,
			HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (!(auth instanceof AnonymousAuthenticationToken)) {
			return "redirect:/";
		}
		if (error == true) {
			model.addAttribute("mensaje", "Credenciales inválidas");

		} else {
			model.addAttribute("mensaje", "");
		}
		
		return "home/login";
	}

	@RequestMapping("/accessDenied")
	public String showaccessDenied(HttpServletRequest request) {
		return "layout/unauthorized";
	}
}
