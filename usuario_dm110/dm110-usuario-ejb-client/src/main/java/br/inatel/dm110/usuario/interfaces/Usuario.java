package br.inatel.dm110.usuario.interfaces;

import java.util.List;

import br.inatel.dm110.usuario.api.to.UsuarioTO;

public interface Usuario {

	public List<UsuarioTO> findAll();

	public UsuarioTO findById(Long id);

	public UsuarioTO createUser(UsuarioTO usuarioTO) throws Exception;

	public UsuarioTO updateUser(UsuarioTO usuarioTO) throws Exception;

	public void deleteUser(Long id);
}
