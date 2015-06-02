package br.com.uezo.jornada.validador.strategy;

import java.util.ArrayList;
import java.util.List;

import br.com.uezo.jornada.validador.ValidacaoStrategy;
import br.com.uezo.jornada.validador.logicas.LogicaValidacaoMatricula;
import br.com.uezo.jornada.validador.logicas.VerificadorDeAnoPadrao2010;
import br.com.uezo.jornada.validador.logicas.VerificadorDeCursoPadrao2010;
import br.com.uezo.jornada.validador.logicas.VerificadorDeSemestrePadrao2010;
import br.com.uezo.jornada.validador.logicas.VerificadorDeTamanhoPadrao2010;

public class Padrao2010Strategy implements ValidacaoStrategy {
	
	private List<LogicaValidacaoMatricula> logicas = new ArrayList<>();
	
	public Padrao2010Strategy() {
		logicas.add(new VerificadorDeTamanhoPadrao2010());
		logicas.add(new VerificadorDeAnoPadrao2010());
		logicas.add(new VerificadorDeSemestrePadrao2010());
		logicas.add(new VerificadorDeCursoPadrao2010());
	}
	
	@Override
	public boolean ehValida(String matricula) {
		for(LogicaValidacaoMatricula logica : logicas) { 
			if(!logica.ehValido(matricula))
				return false;
		}
		
		return true;
	}

}


