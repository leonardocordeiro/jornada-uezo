package br.com.caelum.jornada.servico;

import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import br.com.uezo.jornada.modelo.Usuario;
import br.com.uezo.jornada.servico.UsuarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring-context.xml")
public class UsuarioServiceTest {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Test(expected=ConstraintViolationException.class)
	public void deveDarErroDeValidacaoAoCadastrarUmUsuarioInvalido() { 
		usuarioService.cadastrar(new Usuario());
	}
	
}
