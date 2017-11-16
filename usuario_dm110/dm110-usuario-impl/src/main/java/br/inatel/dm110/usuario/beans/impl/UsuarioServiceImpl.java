package br.inatel.dm110.usuario.beans.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.inatel.dm110.usuario.api.UsuarioService;
import br.inatel.dm110.usuario.api.to.UsuarioTO;
import br.inatel.dm110.usuario.interfaces.UsuarioRemote;

public class UsuarioServiceImpl implements UsuarioService {

	@EJB(lookup = "java:app/dm110-ejb-0.1-SNAPSHOT/UsuarioBean!br.inatel.dm110.hello.interfaces.InventoryRemote")
	private UsuarioRemote usuarioRemote;

	@Override
	public Response findAll() {
		List<UsuarioTO> usuarios = usuarioRemote.findAll();
		return Response.ok().entity(usuarios).build();
	}

	@Override
	public Response findById(Long id) {
		UsuarioTO usuario = usuarioRemote.findById(id);
		if (usuario != null) {
			return Response.ok().entity(usuario).build();
		}
		return Response.noContent().build();
	}

	@Override
	public Response createUser(UsuarioTO usuarioTO) {
		UsuarioTO uCreated;
		try {
			uCreated = usuarioRemote.createUser(usuarioTO);
			if (uCreated != null) {
				return Response.ok().entity(uCreated).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		return Response.noContent().build();
	}

	@Override
	public Response updateUser(UsuarioTO usuarioTO, Long id) {

		UsuarioTO uUpdated = null;

		if (id == usuarioTO.getId()) {
			try {
				uUpdated = usuarioRemote.updateUser(usuarioTO);
				return Response.accepted().entity(uUpdated).build();
			} catch (Exception e) {
				e.printStackTrace();
				return Response.status(Status.INTERNAL_SERVER_ERROR).build();
			}
		}
		return Response.noContent().build();
	}

	@Override
	public Response deleteUser(Long id) {

		usuarioRemote.deleteUser(id);

		return Response.ok().build();
	}

}
