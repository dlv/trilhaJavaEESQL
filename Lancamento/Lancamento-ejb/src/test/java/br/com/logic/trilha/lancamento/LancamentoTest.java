/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.logic.trilha.lancamento;

import br.com.logic.trilha.daos.LancamentoDAO;
import br.com.logic.trilha.models.Lancamento;
import br.com.logic.trilha.models.TipoLancamento;

import org.junit.Test;

/**
 *
 * @author douglas
 */
public class LancamentoTest {

    @Test
    public void testLancamentoContasDoMes() {
        LancamentoDAO lDao = new LancamentoDAO();
        Lancamento l = new Lancamento();
        TipoLancamento tipoLancamento = new TipoLancamento();

        l.setNome("TESTE");
        l.setData("20171108");
        l.setValor(15.0);
        
        tipoLancamento.setId(1);

        l.setTipoLancamento(tipoLancamento);
        
        lDao.contasMes(l);
        
//        List<Lancamento> dados = lDao.buscar();

//        Assert.assertNotNull(dados);
//        Assert.assertEquals(0,dados.size());

    }
}
