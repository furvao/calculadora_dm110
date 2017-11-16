package br.inatel.dm110.usuario.entities.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.inatel.dm110.usuario.entities.Usuario;

@Stateless
public class UsuarioDAO {
	
	private EntityManager getEntityManager() {
	    EntityManagerFactory factory = null;
	    EntityManager entityManager = null;
	    try {
	      //Obtém o factory a partir da unidade de persistência.
	      factory = Persistence.createEntityManagerFactory("usuarios");
	      //Cria um entity manager.
	      entityManager = factory.createEntityManager();
	      //Fecha o factory para liberar os recursos utilizado.
	    } finally {
	      factory.close();
	    }
	    return entityManager;
	  }

	  /**
	   * Método utilizado para salvar ou atualizar as informações de um usuario.
	   * @param usuario
	   * @return
	   * @throws java.lang.Exception
	   */
	  public Usuario salvar(Usuario usuario) throws Exception {
	    EntityManager entityManager = getEntityManager();
	    try {
	      entityManager.getTransaction().begin();
	      if(usuario.getId() == null) {
	        //Salva os dados da pessoa.
	        entityManager.persist(usuario);
	      } else {
	        //Atualiza os dados da pessoa.
	        usuario = entityManager.merge(usuario);
	      }
	      // Finaliza a transação.
	      entityManager.getTransaction().commit();
	    } finally {
	      entityManager.close();
	    }
	    return usuario;
	  }

	  /**
	   * Método que apaga o usuario do banco de dados.
	   * @param id
	   */
	  public void excluir(Long id) {
	    EntityManager entityManager = getEntityManager();
	    try {
	      entityManager.getTransaction().begin();
	      Usuario usuario = entityManager.find(Usuario.class, id);
	      entityManager.remove(usuario);
	      entityManager.getTransaction().commit();
	    } finally {
	      entityManager.close();
	    }
	  }

	  /**
	   * Consulta o usuario pelo ID.
	   * @param id
	   * @return o objeto Pessoa.
	   */
	  public Usuario consultarPorId(Long id) {
	    EntityManager entityManager = getEntityManager();
	    Usuario usuario = null;
	    try {
	      usuario = entityManager.find(Usuario.class, id);
	    } finally {
	      entityManager.close();
	    }
	    return usuario;
	  }
	  
	  /**
	   * Consulta todos os usuarios
	   * @return
	   */
	  public List<Usuario> consultar(){
		 
		  EntityManager entityManager = getEntityManager();
		  List<Usuario> usuarios = null;
		  try {
		      usuarios = entityManager.createQuery("from Usuario u", Usuario.class).getResultList();
		    } finally {
		      entityManager.close();
		    }
		  return usuarios;
	  }

}
