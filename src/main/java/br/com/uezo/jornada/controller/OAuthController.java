package br.com.uezo.jornada.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import br.com.uezo.jornada.auth.OAuthManager;
import br.com.uezo.jornada.dao.UsuarioDao;
import br.com.uezo.jornada.modelo.SocialNetwork;
import br.com.uezo.jornada.modelo.Usuario;
import br.com.uezo.jornada.util.Constantes;

@Controller
@RequestMapping("/oauth")

//Sessao para manter o mesmo OAuthManager por cliente para os dois metodos 
@Scope("session")
public class OAuthController {

	@Autowired
	private UsuarioDao usuarioDao;
	
	private OAuthManager oauthManager;
	
	@Transactional
	@RequestMapping(method=RequestMethod.GET)
	public String email(@RequestParam(value="code", required=false) String authorizationCode, HttpSession sessao) {
		if(authorizationCode == null)
			return "redirect:/";
		
		String accessToken = oauthManager.getAccessToken(authorizationCode);
		
		String id = oauthManager.getId(accessToken);
		String email = oauthManager.getEmail(accessToken);
		String nome = oauthManager.getNome(accessToken);
		String sobrenome = oauthManager.getSobrenome(accessToken);
		
		Usuario usuario = usuarioDao.getByEmail(email);
		
		if(usuario == null) { 
			usuario = new Usuario(nome, sobrenome, email, Base64.encode(id.getBytes()));
			usuarioDao.inserir(usuario);
		}
		
		sessao.setAttribute(Constantes.USUARIO_LOGADO, usuario);		
		return "redirect:/";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String login(@RequestParam("s") SocialNetwork socialNetwork) {
		oauthManager = socialNetwork.getOAuthManager();
		
		return "redirect:" + oauthManager.getAuthorizationURL(); 	
		
	}

}
