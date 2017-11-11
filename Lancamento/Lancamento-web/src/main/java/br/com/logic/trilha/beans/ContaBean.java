/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.logic.trilha.beans;

import br.com.logic.trilha.daos.LancamentoDAO;
import br.com.logic.trilha.models.Lancamento;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author douglas
 */
@Stateless
@Path("/lancamento")
public class ContaBean {

    @Inject
    private LancamentoDAO lancamento;
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        
        List<Lancamento> lista = lancamento.buscar();

       
        String html = "<html lang=\"en\"><body><h3>";
        
        for (Lancamento lancamento : lista) {
            html += lancamento.getId() +"</br>";
            html += lancamento.getNome() +"</br>";
            html += lancamento.getValor() +"</br>";
            html += lancamento.getData() +"</br>";
            html += lancamento.getTipoLancamento().getDescricao() +"</br>";
        }
        
        html += "</h3></body></html>";
        return html;
//        return "<html lang=\"en\"><body><h1>"+html+" </h1></body></html>";
    }
}
