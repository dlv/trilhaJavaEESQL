/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.logic.trilha.resource;

import br.com.logic.trilha.beans.LancamentoBean;
import br.com.logic.trilha.models.Lancamento;
import br.com.logic.trilha.util.Data;
import java.net.URI;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author douglas
 */
@Path("/")
public class LancamentoResource {

    @Inject
    private LancamentoBean lancamentoBean;

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscaLancamento(@PathParam("id") Integer id) {
        return Response.ok(lancamentoBean.buscar(id)).build();
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {

        List<Lancamento> lista = lancamentoBean.buscar();

        String html = "<html lang=\"en\"><body><h2>";
        html += "TOTAL: " + lista.size() + "</h2></br></br><h4>";

        for (Lancamento lancamento : lista) {
            html += lancamento.getId() + " - ";
            html += lancamento.getDescricaoLancamento() + " - ";
            html += lancamento.getValor() + " - ";
            html += Data.FORMAT_DATA.format(lancamento.getData()) + " - ";
            html += lancamento.getTipoLancamento().getDescricao() + "</br>";
        }

        html += "</h4></body></html>";
        return html;
    }

    /**
     * EX: 
     * 
     * curl -v -H "Content-Type: application/json" -H "Accept:
     * application/json" -d '{"id": 1,"descricaoLancamento": "Barzinho","data":
     * "2017-11-28","valor": 68.85,"tipoLancamento": "OUTROS"}'
     * http://localhost:8080/lancamento
     *
     * @param lancamento
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response lancamentoMensal(Lancamento lancamento) {
        try {
            lancamentoBean.salvar(lancamento);
            URI uri = URI.create("lancamento/" + lancamento.getId());
            return Response.created(uri).build();
        } catch (Exception ex) {
            Logger.getLogger(LancamentoResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(ex.getMessage()).build();
        }
    }

    @Path("periodo/{dia}/{mes}/{ano}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response pesquisarLancamentoPorPeriodo(@PathParam("dia") Integer dia, @PathParam("mes") Integer mes, @PathParam("ano") Integer ano) {

        try {
            return Response.ok(lancamentoBean.buscarLancamentoPorPeriodo(dia, mes, ano)).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.EXPECTATION_FAILED).build();
        }
    }

//    @Path("descricao/{nome}")
//    @GET
//    @Produces(MediaType.APPLICATION_XML)
//    public Response pesquisarLancamentoPorNome(@PathParam("nome") String descricaoLancamento) {
//
//        List<Lancamento> listaLancamento = lancamentoDAO.pesquisarPorNome(descricaoLancamento);
//        XStream xStream = new XStream();
//        xStream.alias("Lancamento", Lancamento.class);
//
//        return Response.ok(xStream.toXML(listaLancamento)).build();
//    }

//    @Path("tipo/{tipo}")
//    @GET
//    @Produces(MediaType.APPLICATION_XML)
//    public Response pesquisarLancamentoPorTipo(@PathParam("tipo") String tipo) {
//
//        List<Lancamento> listaLancamento = lancamentoDAO.pesquisarPorTipo(tipo);
//        XStream xStream = new XStream();
//        xStream.alias("Lancamento", Lancamento.class);
//
//        return Response.ok(xStream.toXML(listaLancamento)).build();
//    }

    @PUT
    @Path("/alterar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response alterarLancamento(@FormParam("idLancamento") Integer idLancamento) {
        return Response.ok().entity("Lançamento " + idLancamento + " alterado com sucesso").build();
    }
}
