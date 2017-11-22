/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.logic.trilha.daos;

import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author douglas
 */
@RunWith(Arquillian.class)
public class LancamentoDAOTest {

    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "test.war").addPackage(LancamentoDAO.class.getPackage())
//                .addPackage(Producer.class.getPackage()).addPackage(SimpleProperty.class.getPackage())
//                .addPackage(RepositoryManager.class.getPackage()).addAsResource("META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

    }

    @Inject
    private LancamentoDAO lancamentoDAO;
    

    /**
     * Test of buscar method, of class LancamentoDAO.
     */
//    @Test
//    public void testBuscar() throws Exception {
//        System.out.println("buscar");
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        LancamentoDAO instance = (LancamentoDAO)container.getContext().lookup("java:global/classes/LancamentoDAO");
//        List<Lancamento> expResult = null;
//        List<Lancamento> result = instance.buscar();
//        assertEquals(expResult, result);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of contasMes method, of class LancamentoDAO.
     */
//    @Test
//    public void testContasMes() throws Exception {
//        System.out.println("contasMes");
//        Lancamento lancamento = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        LancamentoDAO instance = (LancamentoDAO)container.getContext().lookup("java:global/classes/LancamentoDAO");
//        instance.contasMes(lancamento);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of testMethod method, of class LancamentoDAO.
     */
    @Test
    public void testTestMethod() throws Exception {

        Assert.assertTrue(lancamentoDAO.testMethod());
    }

}
