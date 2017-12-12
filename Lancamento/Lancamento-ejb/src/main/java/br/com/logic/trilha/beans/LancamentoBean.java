/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.logic.trilha.beans;

import br.com.logic.trilha.daos.LancamentoDAO;
import br.com.logic.trilha.models.Lancamento;
import br.com.logic.trilha.util.Data;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author douglas
 */
@Stateless
public class LancamentoBean {
    
    @Inject
    LancamentoDAO lancamentoDAO;
    
    public void salvar(Lancamento lancamento) throws Exception {
        //<editor-fold defaultstate="collapsed" desc="Validar dados">
        if (lancamento == null){
            throw new Exception("Lancamento inválido.");
        }
        // TODO: verificar formato da data
        if (lancamento.getData() == null || lancamento.getData().toString().isEmpty() ){
            throw new Exception("Data de Lancamento inválida.");
        }
        
        if (lancamento.getDescricaoLancamento() == null || lancamento.getDescricaoLancamento().isEmpty() ){
            throw new Exception("Descrição do Lancamento inválido.");
        }
        
        if (lancamento.getValor() == null || lancamento.getValor() < 0 ){
            throw new Exception("Valor de Lancamento inválido.");
        }
        //</editor-fold>
        
        lancamentoDAO.lancamentoMensal(lancamento);
    }
    
    public List<Lancamento> buscar() {
        return lancamentoDAO.buscar();
    }
    
    public Lancamento buscar(Integer id) {
        return lancamentoDAO.buscar(id);
    }
    
    public List<Lancamento> buscarLancamentoPorPeriodo(Integer dia, Integer mes, Integer ano) throws Exception {

        //<editor-fold defaultstate="collapsed" desc="Validar data">
        Date data = Data.converterIntegerToDate(dia, mes, ano);
        //</editor-fold>

        return lancamentoDAO.pesquisarPorPeriodo(data);
    }

    /**
     * EX : curl -v -X PUT -H "Content-Type: application/json" -d '{"id":20,"descricaoLancamento":"Barzinho","data":"2017-12-12","valor":68.85,"tipoLancamento":"OUTROS"}' http://localhost:8080/lancamento/api/alterar
     * @param lancamento
     * @throws Exception 
     */
    public void alterar(Lancamento lancamento) throws Exception {
        // TODO: fazer o cast da String para objeto Lancamento
        
        //<editor-fold defaultstate="collapsed" desc="Validar Dados">
        if (lancamento == null){
            throw new Exception("Parametro Inválido");
        }
        
        if (lancamento.getId() <= 0) {
            throw new Exception("Parametro Id Inválido");
        }
        //</editor-fold>
        
        lancamentoDAO.alterarLancamento(lancamento);
    }
}
