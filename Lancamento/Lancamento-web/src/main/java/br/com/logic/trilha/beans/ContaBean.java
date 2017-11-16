/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.logic.trilha.beans;

import br.com.logic.trilha.daos.LancamentoDAO;
import br.com.logic.trilha.models.Lancamento;
import br.com.logic.trilha.models.TipoLancamento;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author douglas
 */
@Stateless
@Path("lancamento")
public class ContaBean {

//    @Context
//    private UriInfo context;

    @Inject
    private LancamentoDAO lancamento;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {

        List<Lancamento> lista = lancamento.buscar();

        String html = "<html lang=\"en\"><body><h2>";
        html += "TOTAL: " + lista.size() + "</h2></br></br><h4>";

        for (Lancamento lancamento : lista) {
            html += lancamento.getId() + " - ";
            html += lancamento.getNome() + " - ";
//            html += lanc.getValor() +"</br>";
            html += lancamento.getData() + " - ";
            html += lancamento.getTipoLancamento().getDescricao() + "</br>";
        }

        html += "</h4></body></html>";
        return html;
    }

    
    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_HTML)
    public Response lancarContaMes(@FormParam("nome") String nome, 
            @FormParam("data") String data, @FormParam("valor") String valor) {

        if (nome == null || nome.isEmpty())
            return Response.ok().entity("Informe o Nome.").build();
        
        if (data == null || data.isEmpty())
            return Response.ok().entity("Informe o Data.").build(); 
        
        if (valor == null || valor.isEmpty())
            return Response.ok().entity("Informe o Valor.").build();
        
        Lancamento lanc = new Lancamento();
        
        lanc.setNome(nome.toUpperCase());
        lanc.setData(data);
        lanc.setValor(13.0);
        
        TipoLancamento tipo = new TipoLancamento();
        tipo.setId(1);
        lanc.setTipoLancamento(tipo);

        lancamento.contasMes(lanc);
//        return "<html lang=\"en\"><body><h1>" + lanc.getNome().toUpperCase() + "</h1></body></html>";
        return Response.ok().entity("Lançamento cadastrado com sucesso").build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/teste")
    public Response loginService(@Context HttpServletRequest req, String nome) {
        try {

            return Response.ok("{}").build();

        } catch (Exception e) {

            return Response.ok().build();
        }
    }
}
