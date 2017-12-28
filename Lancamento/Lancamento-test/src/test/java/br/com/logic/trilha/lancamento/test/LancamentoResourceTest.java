package br.com.logic.trilha.lancamento.test;

import br.com.logic.trilha.beans.LancamentoBean;
import org.jboss.arquillian.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;


/*
 * Ref:. https://www.devmedia.com.br/testes-de-integracao-utilizando-cdi-jpa-e-ejb-e-arquillian/33340
 * 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
/**
 *
 * @author douglas
 */
//@RunWith(Arquillian.class)
public class LancamentoResourceTest {

//    @
//    private LancamentoBean lancamentoBean;

//    @Deployment
    public static JavaArchive createTestArchive() {
        return ShrinkWrap.create(JavaArchive.class, "lancamentoTest.jar")
                .addClasses(LancamentoBean.class);
    }

//    @Test
    public void testBuscarLancamento() {
//        Lancamento result = lancamentoBean.buscar(10);
//        Assert.assert
    }
}
