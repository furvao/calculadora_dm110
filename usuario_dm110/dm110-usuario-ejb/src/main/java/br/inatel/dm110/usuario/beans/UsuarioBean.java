package br.inatel.dm110.usuario.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.inatel.dm110.usuario.api.to.UsuarioTO;
import br.inatel.dm110.usuario.entities.dao.UsuarioDAO;
import br.inatel.dm110.usuario.interfaces.Usuario;
import br.inatel.dm110.usuario.interfaces.UsuarioLocal;
import br.inatel.dm110.usuario.interfaces.UsuarioRemote;

@Stateless
@Local(UsuarioLocal.class)
@Remote(UsuarioRemote.class)
public class UsuarioBean implements Usuario {
	
	@EJB
	private UsuarioDAO usuarioDAO;

	@Override
	public List<UsuarioTO> findAll() {
		List<br.inatel.dm110.usuario.entities.Usuario> usuarios = usuarioDAO.consultar();
		
		List<UsuarioTO> usuariosTO = new ArrayList<>();
		for(br.inatel.dm110.usuario.entities.Usuario u : usuarios){
			usuariosTO.add(u.toUsuarioTO());
		}
		
		return usuariosTO;
	}

	@Override
	public UsuarioTO findById(Long id) {
		
		br.inatel.dm110.usuario.entities.Usuario usuario = usuarioDAO.consultarPorId(id);
		
		UsuarioTO to = null;
		if(usuario != null){
			to = usuario.toUsuarioTO();
		}
		
		return to;
	}

	@Override
	public UsuarioTO createUser(UsuarioTO usuarioTO) throws Exception {
		
		UsuarioTO uRetorno = null;
		if(usuarioTO != null){
			br.inatel.dm110.usuario.entities.Usuario usuario = new br.inatel.dm110.usuario.entities.Usuario(usuarioTO);
			br.inatel.dm110.usuario.entities.Usuario usuarioCriado = usuarioDAO.salvar(usuario);
		
			uRetorno = usuarioCriado.toUsuarioTO();
		}
		
		
		return uRetorno;
	}

	@Override
	public UsuarioTO updateUser(UsuarioTO usuarioTO) throws Exception {
		UsuarioTO uRetorno = null;
		if(usuarioTO != null){
			br.inatel.dm110.usuario.entities.Usuario uToUpdate = usuarioDAO.consultarPorId(usuarioTO.getId());
			
			uToUpdate.setEmail(usuarioTO.getEmail());
			uToUpdate.setNome(usuarioTO.getNome());
			uToUpdate.setTelefone(usuarioTO.getTelefone());

			br.inatel.dm110.usuario.entities.Usuario usuarioCriado = usuarioDAO.salvar(uToUpdate);
		
			uRetorno = usuarioCriado.toUsuarioTO();
		}
		
		
		return uRetorno;
	}

	@Override
	public void deleteUser(Long id) {
		
		usuarioDAO.excluir(id);
		
	}

}
