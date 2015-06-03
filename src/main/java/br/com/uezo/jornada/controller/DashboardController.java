package br.com.uezo.jornada.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

	@RequestMapping(method=RequestMethod.GET)
	public String dashboard() { 
		return "dashboard";
	}
	
	
}