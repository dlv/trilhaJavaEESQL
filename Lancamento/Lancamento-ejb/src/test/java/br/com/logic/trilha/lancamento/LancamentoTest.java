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
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author douglas
 */
@RunWith(Arquillian.class)
public class LancamentoTest {

    @EJB
    LancamentoDAO lancamentoDAO;

    @Test
    public void testBuscar() {
        List<Lancamento> lista = lancamentoDAO.buscar();
        Assert.assertNotNull(lista);
//        Assert.assertEquals(0,dados.size());

    }
}
