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
    
    public void salvar(Lancamento lancamento) {
        lancamento.setId(1);
    }
    
    public Lancamento buscar(Integer id) {
        return lancamentoDAO.buscar(id);
    }
    
    public List<Lancamento> buscarLancamentoPorPeriodo(Integer dia, Integer mes, Integer ano) throws Exception {

        //<editor-fold defaultstate="collapsed" desc="Validar os dados">
        Date data = Data.converterIntegerToDate(dia, mes, ano);
        //</editor-fold>

        return lancamentoDAO.pesquisarPorPeriodo(data);
    }
}
