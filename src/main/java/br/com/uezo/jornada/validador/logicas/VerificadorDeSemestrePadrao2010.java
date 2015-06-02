package br.com.uezo.jornada.validador.logicas;

public class VerificadorDeSemestrePadrao2010 implements LogicaValidacaoMatricula {

	@Override
	public boolean ehValido(String matricula) {
		int semestre = Integer.parseInt(matricula.substring(2, 3));
		boolean semestreigualUmOuDois = semestre == 1 || semestre == 2;
		
		return semestreigualUmOuDois;		
	}
}
