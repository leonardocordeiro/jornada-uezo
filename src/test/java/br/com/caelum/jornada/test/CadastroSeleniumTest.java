package br.com.caelum.jornada.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.caelum.jornada.page.CadastroPage;
import br.com.uezo.jornada.modelo.Usuario;

public class CadastroSeleniumTest {

	private CadastroPage cadastro;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver","/Users/leonardocordeiro/Downloads/chromedriver");
		
		cadastro = new CadastroPage(new ChromeDriver());
	}
	
	@Test
	public void deveDarErroDeValidacaoAoCadastrarUsuarioNulo() {
		cadastro.cadastraUsuario(criaUsuarioNulo());
		
		assertTrue(cadastro.mostrouErroDeValidacao());
	}
	
	@Test
	public void deveInvalidarEmail() {
		Usuario usuarioEmailInvalido = criaUsuario("Leonardo", "leonardo.cordeiro", "leonardo", "1413331050");
		
		cadastro.cadastraUsuario(usuarioEmailInvalido);
		
		assertTrue(cadastro.mostrouErroDeValidacao());
	}
	
	private Usuario criaUsuarioNulo() { 
		return criaUsuario("", "", "", "");
	}
	
	private Usuario criaUsuario(String nome, String email, String senha, String matricula) { 
		Usuario usuario = new Usuario();
		
		usuario.setNome(nome);
		usuario.setMatricula(matricula);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		
		return usuario;
	}
	
}
