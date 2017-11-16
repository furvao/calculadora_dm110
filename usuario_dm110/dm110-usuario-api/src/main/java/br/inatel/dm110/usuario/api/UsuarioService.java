package br.inatel.dm110.usuario.api;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.inatel.dm110.usuario.api.to.UsuarioTO;

@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
public interface UsuarioService {

	@GET
	public Response findAll();

	@GET
	@Path("/{id}")
	public Response findById(@PathParam("id") Long id);

	@POST
	public Response createUser(UsuarioTO usuarioTO);

	@PUT
	@Path("/{id}")
	public Response updateUser(UsuarioTO usuarioTO, @PathParam("id") Long id);

	@DELETE
	@Path("/{id}")
	public Response deleteUser(@PathParam("id") Long id);

}
