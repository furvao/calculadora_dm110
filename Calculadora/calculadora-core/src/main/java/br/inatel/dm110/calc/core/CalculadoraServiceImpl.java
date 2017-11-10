package br.inatel.dm110.calc.core;

import javax.ws.rs.core.Response;

import br.inatel.dm110.calc.api.CalculadoraService;
import br.inatel.dm110.calc.api.Result;

public class CalculadoraServiceImpl implements CalculadoraService {

	@Override
	public Response sum(String first, String second) {

		Result result = new Result();
		result.setFirst(first);
		result.setSecond(second);
		result.setResult(String.valueOf(Integer.parseInt(first) + Integer.parseInt(second)));

		return Response.ok().entity(result).build();
	}

	@Override
	public Response subtract(String first, String second) {
		Result result = new Result();
		result.setFirst(first);
		result.setSecond(second);
		result.setResult(String.valueOf(Integer.parseInt(first) - Integer.parseInt(second)));

		return Response.ok().entity(result).build();
	}

}
