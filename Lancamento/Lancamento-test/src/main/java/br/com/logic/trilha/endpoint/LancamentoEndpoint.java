package br.com.logic.trilha.endpoint;

import br.com.logic.trilha.service.LancamentoService;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author douglas
 */
@Stateless
@Path("api")
public class LancamentoEndpoint {

    @Inject
    private LancamentoService lancamentoService;
    
    @GET
    @Path("/buscar")
    @Produces({MediaType.APPLICATION_JSON})
    public Response buscarLancamento() {
        return Response.ok(lancamentoService.buscar(1)).build();
    }

    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response findAll() {
        return Response.ok(lancamentoService.findAll()).build();
    }
}
