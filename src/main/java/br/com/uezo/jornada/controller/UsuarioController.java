package br.com.uezo.jornada.controller;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.uezo.jornada.modelo.Usuario;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@RequestMapping(method=RequestMethod.POST)
	public String cadastro(Model model, @Valid Usuario usuario, BindingResult result) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "form_cadastro";
	}

}
