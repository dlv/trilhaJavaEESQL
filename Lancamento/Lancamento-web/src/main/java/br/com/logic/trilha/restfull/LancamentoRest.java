/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.logic.trilha.restfull;

import br.com.logic.trilha.daos.LancamentoDAO;
import br.com.logic.trilha.models.Lancamento;
import br.com.logic.trilha.models.TipoLancamentoENUM;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
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
@RequestScoped
@Path("/")
public class LancamentoRest {

    SimpleDateFormat FORMAT_DATA = new SimpleDateFormat("dd/MM/yyy");
    SimpleDateFormat FORMAT_DATADB = new SimpleDateFormat("yyyyMMdd");

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
            html += lancamento.getValor() + " - ";
            html += lancamento.getData() + " - ";
            html += lancamento.getTipoLancamento().name() + "</br>";
        }

        html += "</h4></body></html>";
        return html;
    }

    @POST
    @Path("/conta")
    @Produces(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.TEXT_HTML)
    public Response lancarContaMes(@FormParam("nome") String nome,
            @FormParam("data") String data, @FormParam("valor") String valor, @FormParam("tipo") String tipo) {

        TipoLancamentoENUM  tipoLanc = null;
        String paramIsEmpty = "";

        if (nome == null || nome.isEmpty()) {
            paramIsEmpty += " Informe o Nome";
        }

        if (data == null || data.isEmpty()) {
            paramIsEmpty += (paramIsEmpty.isEmpty()) ? "Informe a Data" : ", a Data";
        }

        if (valor == null || valor.isEmpty()) {
            paramIsEmpty += (paramIsEmpty.isEmpty()) ? "Informe o Valor" : ", o Valor";
        }

        if (tipo == null || tipo.isEmpty()) {
            paramIsEmpty += (paramIsEmpty.isEmpty()) ? "Informe o Tipo de Lançamento" : ", o Tipo de Lançamento";
        }

        try {
            data = FORMAT_DATADB.format(FORMAT_DATA.parse(data));
        } catch (Exception ex) {
            paramIsEmpty += (paramIsEmpty.isEmpty()) ? "Informe a Data no formato dia/mes/ano" : ", a Data no formato dia/mes/ano";
        }

        try {
            tipoLanc = TipoLancamentoENUM.valueOf(tipo.toUpperCase());
        } catch (Exception ex){
             paramIsEmpty += (paramIsEmpty.isEmpty()) ? "Informe Tipo de Lançamento Débito ou Crédito" : ", o Tipo de Lançamento Débito ou Crédito";
        }
        
        if (!paramIsEmpty.isEmpty()) {
            return Response.ok().entity(paramIsEmpty).build();
        }

        Lancamento lanc = new Lancamento();

        lanc.setNome(nome.toUpperCase());
        lanc.setData(data);
        lanc.setValor(Double.parseDouble(valor));

        
        lanc.setTipoLancamento(tipoLanc);

        lancamento.contasMes(lanc);

        return Response.ok().entity("Lançamento cadastrado com sucesso").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/teste")
    public Response loginService(@Context HttpServletRequest req, String nome) {
        try {

            Lancamento l = new Lancamento();
            l.setNome("TESTE");
            return Response.ok(l.toString()).build();

        } catch (Exception e) {

            return Response.ok().build();
        }
    }
}
