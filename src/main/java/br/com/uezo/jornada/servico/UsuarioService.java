package br.com.uezo.jornada.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.uezo.jornada.dao.UsuarioDao;
import br.com.uezo.jornada.modelo.Usuario;

@Service
public class UsuarioService {
	
	@Autowired 
	private UsuarioDao dao;
	
	@Transactional
	public void cadastrar(Usuario usuario) { 
		dao.inserir(usuario);
	}
	
	public boolean existe(Usuario usuario) {
		Usuario user = dao.buscarPeloEmailESenha(usuario);
		return user != null;
	}

	@Transactional
	public void atualiza(Usuario usuario) {
		dao.atualizar(usuario);
	}

	public Usuario buscaPorEmailESenha(Usuario usuario) {
		return dao.buscarPeloEmailESenha(usuario);
	}
	
}
