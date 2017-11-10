package br.inatel.dm110.calc.api;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/calc")
public interface CalculadoraService {

	@GET
	@Path("/sum/{first}/{seconde}")
	@Produces(MediaType.APPLICATION_JSON)
	Response sum(@QueryParam("first") String first, @QueryParam("second") String second);

	@POST
	@Path("/subtract")
	@Produces(MediaType.APPLICATION_JSON)
	Response subtract(@FormParam("first") String first, @FormParam("second") String second);

}
