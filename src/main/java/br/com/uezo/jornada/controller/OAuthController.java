package br.com.uezo.jornada.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.uezo.jornada.auth.OAuthManager;
import br.com.uezo.jornada.modelo.SocialNetwork;

@Controller
@RequestMapping("/oauth")

//Sessao para manter o mesmo OAuthManager para os dois metodos 
@Scope("session")
public class OAuthController {
	
	private OAuthManager oauthManager;
	
	@RequestMapping(method=RequestMethod.GET)
	public String email(@RequestParam(value="code", required=false) String authorizationCode) {
		if(authorizationCode == null)
			return "redirect:/";
		
		String accessToken = oauthManager.getAccessToken(authorizationCode);
		
		String email = oauthManager.getEmail(accessToken);
		System.out.println("Email: " + email);
		
		return "redirect:/";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String login(@RequestParam("s") SocialNetwork socialNetwork) {
		oauthManager = socialNetwork.getOAuthManager();
		
		return "redirect:" + oauthManager.getAuthorizationURL(); 	
		
	}

}
