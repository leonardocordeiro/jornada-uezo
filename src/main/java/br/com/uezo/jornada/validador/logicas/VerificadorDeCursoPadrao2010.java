package br.com.uezo.jornada.validador.logicas;

import br.com.uezo.jornada.validador.ValidadorDeMatriculaService;

public class VerificadorDeCursoPadrao2010 implements LogicaValidacaoMatricula {

	@Override
	public boolean ehValido(String matricula) {
		String curso = matricula.substring(3, 6);
		boolean cursoExiste = ValidadorDeMatriculaService.cursos.containsKey(curso);
		
		return cursoExiste;
	}
}
