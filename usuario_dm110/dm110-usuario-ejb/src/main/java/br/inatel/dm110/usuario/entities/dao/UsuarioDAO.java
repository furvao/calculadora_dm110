package br.inatel.dm110.usuario.entities.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import br.inatel.dm110.usuario.entities.Usuario;

@Stateless
public class UsuarioDAO {
	
	@PersistenceContext(unitName = "usuarios")
	private EntityManager entityManager;

	  /**
	   * Método utilizado para salvar ou atualizar as informações de um usuario.
	   * @param usuario
	   * @return
	   * @throws java.lang.Exception
	   */
	  public Usuario salvar(Usuario usuario) throws Exception {
	      if(usuario.getId() == null) {
	        entityManager.persist(usuario);
	      } else {
	        usuario = entityManager.merge(usuario);
	      }
	    return usuario;
	  }

	  /**
	   * Método que apaga o usuario do banco de dados.
	   * @param id
	   */
	  public void excluir(Long id) {
	      Usuario usuario = entityManager.find(Usuario.class, id);
	      entityManager.remove(usuario);
	  }

	  /**
	   * Consulta o usuario pelo ID.
	   * @param id
	   * @return o objeto Pessoa.
	   */
	  public Usuario consultarPorId(Long id) {
	    Usuario usuario = null;
	      usuario = entityManager.find(Usuario.class, id);
	    return usuario;
	  }
	  
	  /**
	   * Consulta todos os usuarios
	   * @return
	   */
	  public List<Usuario> consultar(){
		 
		  List<Usuario> usuarios = null;
	      usuarios = entityManager.createQuery("from Usuario u", Usuario.class).getResultList();
		  return usuarios;
	  }

}
