/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.logic.trilha.remote;

import br.com.logic.trilha.models.Lancamento;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author douglas
 */
@Remote
public interface LancamentoRemote {
    void salvar(Lancamento lancamento) throws Exception;

    List<Lancamento> buscar();

    Lancamento buscar(Integer id);

    List<Lancamento> buscarPorNome(String nome) throws Exception;

    void excluir(Lancamento lancamento) throws Exception;

    List<Lancamento> buscarLancamentoPorPeriodo(Integer dia, Integer mes, Integer ano) throws Exception;

    void alterar(Lancamento lancamento) throws Exception;

    Boolean teste();
}
