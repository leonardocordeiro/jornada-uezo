package br.com.uezo.jornada.validador.logicas;

import java.util.Calendar;

public class VerificadorDeAnoPadrao2010 implements LogicaValidacaoMatricula {
	
	private int ano = Calendar.getInstance().get(Calendar.YEAR) - 2000;

	@Override
	public boolean ehValido(String matricula) {
		int anoMatricula = Integer.parseInt(matricula.substring(0, 2)); 
		return anoMatricula <= ano;
	}
}
