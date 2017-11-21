/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.logic.trilha.daos;

import javax.ejb.embeddable.EJBContainer;
import static org.junit.Assert.*;

/**
 *
 * @author douglas
 */
//@RunWith(Arquillian.class)
public class LancamentoDAOTest {
    
//    @Deployment
//    public static JavaArchive createDeployment() {
//        return ShrinkWrap.create(JavaArchive.class).addClass(LancamentoDAOTest.class)
//                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
//    }
//
//    @Inject
//    private LancamentoDAO lancamentoDAO;
//    
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
//    @Test
    public void testTestMethod() throws Exception {
        System.out.println("testMethod");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        LancamentoDAO instance = (LancamentoDAO)container.getContext().lookup("java:global/classes/LancamentoDAO");
        Boolean expResult = null;
        Boolean result = instance.testMethod();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
