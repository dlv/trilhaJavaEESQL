/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.logic.trilha.lancamento;

import br.com.logic.trilha.daos.LancamentoDAO;
import br.com.logic.trilha.models.Lancamento;
import java.util.List;
import javax.ejb.EJB;
import org.junit.Assert;

import org.junit.Test;

/**
 *
 * @author douglas
 */
public class LancamentoTest {

    @EJB
    LancamentoDAO lancamentoDAO;

//    @Test
    public void testBuscar() {
        List<Lancamento> lista = lancamentoDAO.buscar();
        Assert.assertNotNull(lista);
//        Assert.assertEquals(0,dados.size());

    }
}
