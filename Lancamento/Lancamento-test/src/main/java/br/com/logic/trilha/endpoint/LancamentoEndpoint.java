package br.com.logic.trilha.endpoint;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author douglas
 */
@Stateless
@Path("api")
public class LancamentoEndpoint {

    @GET
    public Response consultarLancamento() {
        return Response.ok("OK").build();
    }
}
