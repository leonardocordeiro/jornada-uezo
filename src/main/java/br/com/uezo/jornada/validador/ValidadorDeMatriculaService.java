package br.com.uezo.jornada.validador;

import java.util.HashMap;
import java.util.Map;

public class ValidadorDeMatriculaService {
	
	public static Map<String, String> cursos = new HashMap<String, String>();

	private ValidacaoStrategy strategy;
	
	static { 
		cursos.put("333", "Ciência da Computação");
		cursos.put("141", "Análise e Desenvolvimento de Sistemas");		
	}
	
	public ValidadorDeMatriculaService(ValidacaoStrategy strategy) { 
		this.strategy = strategy;
	}
	
	public boolean ehValida(String matricula) {
		if(matricula.isEmpty()) return true;
		
		return strategy.ehValida(matricula);
	}
	
	
}
