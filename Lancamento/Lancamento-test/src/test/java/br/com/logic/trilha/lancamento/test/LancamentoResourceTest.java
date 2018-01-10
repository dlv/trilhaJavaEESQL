package br.com.logic.trilha.lancamento.test;

import br.com.logic.trilha.beans.LancamentoBean;
import br.com.logic.trilha.daos.LancamentoDAO;
import br.com.logic.trilha.models.Lancamento;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


/*
 * Ref:. https://www.devmedia.com.br/testes-de-integracao-utilizando-cdi-jpa-e-ejb-e-arquillian/33340 
 * 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
/**
 * https://docs.jboss.org/author/display/ARQ/WildFly+8.1.0+-+Embedded
 *
 * @author douglas
 */
@RunWith(Arquillian.class)
public class LancamentoResourceTest {

    @Inject
    private LancamentoBean lancamentoBean;
    
    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
                .addClass(LancamentoBean.class)
                .addClass(LancamentoDAO.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        System.out.println(jar.toString(true));
        return jar;
    }

    @Test
    public void testBuscarLancamento() {
//        Lancamento result = lancamentoBean.buscar(10);
//        System.out.println(result);
        Assert.assertTrue(lancamentoBean.teste());
    }
}
