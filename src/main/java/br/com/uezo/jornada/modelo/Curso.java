package br.com.uezo.jornada.modelo;

public enum Curso {

	CIENCIA_DA_COMPUTACAO(333), ANALISE_DE_SISTEMAS(222);

	private int codigo;

	Curso(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() { 
		return codigo;
	}

	public static Curso getInstance(int codigo) { 
		for (Curso curso : values()) {
			if (curso.getCodigo() == codigo) 
				return curso;
		}
		
		return null;
	}
	
}
