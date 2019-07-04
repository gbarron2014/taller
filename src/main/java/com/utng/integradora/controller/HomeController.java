package com.utng.integradora.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.utng.integradora.dao.UsuarioDao;
import com.utng.integradora.form.Usuario;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	UsuarioDao usuarioDao;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	  @RequestMapping(value = "/", method = RequestMethod.GET)
	  public ModelAndView showHome(HttpServletRequest request, HttpServletResponse response) {
		  logger.info("UsuarioDao " + usuarioDao);
	    ModelAndView mav = new ModelAndView("home");
	    mav.addObject("error",0);
	    mav.addObject("usuario", new Usuario());

	    return mav;

	  }

	  
	@RequestMapping("/usuarios")
	public String usuarios(Model model) {
		
		logger.info("UsuarioDao " + usuarioDao);
		List<Usuario> usuarios = usuarioDao.getUsuarios();
		model.addAttribute("error", 0);
		model.addAttribute("usuarios", usuarios);
		return "usuarios";
	}



	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(Locale locale, Model model, HttpServletRequest request,
			@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult,
			HttpServletResponse response) {

		model.addAttribute("error", 0);
		if (bindingResult.hasErrors()) {
			model.addAttribute("error", 1);
		} else {
			Usuario login = usuarioDao.login(usuario.getCorreo(), usuario.getPassword());
			
			if (login != null) {
				logger.info("Los datos son correctos");
				String token = "Nuestra propia implementación de tokens";
				request.getSession().setAttribute("token", token);
				try {
					response.sendRedirect("welcome");
				} catch (Exception e) {
					model.addAttribute("error", 3);
				}
			} else {
				logger.info("Los datos son incorrectos " + usuario);
				model.addAttribute("error", 2);
			}
		}

		return "home";
	}

}
