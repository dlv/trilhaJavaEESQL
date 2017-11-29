/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.logic.trilha.resource;

import br.com.logic.trilha.daos.LancamentoDAO;
import br.com.logic.trilha.models.Lancamento;
import br.com.logic.trilha.util.Data;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import java.net.URI;
import java.util.List;
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
    private LancamentoDAO lancamentoDAO;
    
//    private Gson JSon;

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscaLancamento(@PathParam("id") Integer id) {
        Lancamento lancamento = lancamentoDAO.buscar(id);
        return Response.ok(lancamento.toJSON()).build();
    }
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {

        List<Lancamento> lista = lancamentoDAO.buscar();

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
     * EX: curl -v -H "Content-Type: application/json" -d "{id: 1,descricaoLancamento: "Supermercado",data: "2017-11-28",valor: 20,tipoLancamento: "ALIMENTACAO"}" http://localhost:8080/lancamento
     * @param conteudo
     * @return 
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response lancamentoMensal(String conteudo) {
        Lancamento lancamento = (Lancamento) new Gson().fromJson(conteudo, Lancamento.class);
        lancamentoDAO.lancamentoMensal(lancamento);

        URI uri = URI.create("lancamento/" + lancamento.getId());
        return Response.created(uri).build();
    }

    @Path("periodo/{dataLancamento}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response pesquisarLancamentoPorPeriodo(@PathParam("dataLancamento") String dataLancamento) {

        List<Lancamento> listaLancamento = lancamentoDAO.pesquisarPorPeriodo(dataLancamento);
        XStream xStream = new XStream();
        xStream.alias("Lancamento", Lancamento.class);

        return Response.ok(xStream.toXML(listaLancamento)).build();
    }

    @Path("descricao/{nome}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response pesquisarLancamentoPorNome(@PathParam("nome") String descricaoLancamento) {

        List<Lancamento> listaLancamento = lancamentoDAO.pesquisarPorNome(descricaoLancamento);
        XStream xStream = new XStream();
        xStream.alias("Lancamento", Lancamento.class);

        return Response.ok(xStream.toXML(listaLancamento)).build();
    }

    @Path("tipo/{tipo}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response pesquisarLancamentoPorTipo(@PathParam("tipo") String tipo) {

        List<Lancamento> listaLancamento = lancamentoDAO.pesquisarPorTipo(tipo);
        XStream xStream = new XStream();
        xStream.alias("Lancamento", Lancamento.class);

        return Response.ok(xStream.toXML(listaLancamento)).build();
    }

    @PUT
    @Path("/alterar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response alterarLancamento(@FormParam("idLancamento") Integer idLancamento) {
        return Response.ok().entity("Lançamento " + idLancamento + " alterado com sucesso").build();
    }
}
