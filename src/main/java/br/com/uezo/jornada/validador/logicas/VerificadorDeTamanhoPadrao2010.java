package br.com.uezo.jornada.validador.logicas;

public class VerificadorDeTamanhoPadrao2010 implements LogicaValidacaoMatricula {

	@Override
	public boolean ehValido(String matricula) {
		if(matricula.length() != 10)
			return false;
		return true;
	}
	
}