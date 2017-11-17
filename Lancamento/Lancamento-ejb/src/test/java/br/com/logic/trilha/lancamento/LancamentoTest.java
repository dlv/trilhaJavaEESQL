/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.logic.trilha.lancamento;

import br.com.logic.trilha.daos.LancamentoDAO;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author douglas
 */
@RunWith(Arquillian.class)
public class LancamentoTest {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class,"lancamento.jar")
                .addClass(LancamentoDAO.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }


    @Inject
    LancamentoDAO lancamentoDAO;

    @Test
    public void testBuscar() {
//        List<Lancamento> lista = lancamentoDAO.buscar();
//        Assert.assertNotNull(lista);
//        Assert.assertEquals(0,dados.size());

        Assert.assertTrue(lancamentoDAO.testMethod());

    }
}
