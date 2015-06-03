package br.com.uezo.jornada.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.uezo.jornada.modelo.Usuario;

@Repository
public class UsuarioDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void inserir(Usuario usuario) { 
		em.persist(usuario);
	}
	
	public Usuario getByEmail(String email) { 
		TypedQuery<Usuario> query =
				em.createQuery("select u from Usuario u where u.email=:pEmail", Usuario.class);
		
		query.setParameter("pEmail", email);
		
		try {
			return query.getSingleResult();
		} catch(NoResultException e) { 
			return null;
		}
		
	}
	
	public Usuario buscarPeloEmailESenha(Usuario usuario) { 
		TypedQuery<Usuario> query =
				em.createQuery("select u from Usuario u where u.email=:pEmail and u.senha=:pSenha", 
																					Usuario.class);
		
		query.setParameter("pEmail", usuario.getEmail());
		query.setParameter("pSenha", usuario.getSenha());
		
		try {
			return query.getSingleResult();
		} catch(NoResultException e) { 
			return null;
		}
	}

	public Usuario atualizar(Usuario usuario) {
		return em.merge(usuario);
	}

}
