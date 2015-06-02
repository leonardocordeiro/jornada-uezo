package br.com.caelum.jornada.validador;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.uezo.jornada.validador.ValidadorDeMatriculaService;
import br.com.uezo.jornada.validador.strategy.Padrao2010Strategy;

public class ValidadorDeMatriculaTest {
	
	ValidadorDeMatriculaService validador;
	
	@Before
	public void setup() { 
		validador = new ValidadorDeMatriculaService(new Padrao2010Strategy());
	}
	
	private void deveInvalidar(String matricula) { 
		boolean ehValida = validador.ehValida(matricula);

		assertFalse(ehValida);
	}
	
	@Test
	public void deveValidarUmaMatriculaVazia() { 
		boolean ehValida = validador.ehValida("");
		
		assertTrue(ehValida);
	}
	
	@Test
	public void deveValidarUmaMatriculaValida() { 
		boolean ehValida = validador.ehValida("1413331050");
		
		assertTrue(ehValida);		
	}

	@Test
	public void deveIndalidarSeForMaiorDoQueDeveria() {		
		deveInvalidar("14133310501");
	}
	
	@Test
	public void deveInvalidarSeForMenorDoQueDeveria() { 
		deveInvalidar("121");
	} 
	
	@Test
	public void deveInvalidarCasoTerceiroNumeroSejaDiferenteDeUmEDois() { 
		deveInvalidar("1533331050");
	}
	
	@Test
	public void deveInvalidarCasoAMatriculaPossuaCursoInexistente() {
		deveInvalidar("1413321050");
	}
}
