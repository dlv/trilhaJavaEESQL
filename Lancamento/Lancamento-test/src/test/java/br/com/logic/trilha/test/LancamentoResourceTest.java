package br.com.logic.trilha.test;

import br.com.logic.trilha.local.LancamentoLocal;
import java.io.File;
import javax.ejb.EJB;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Filters;
import org.jboss.shrinkwrap.api.GenericArchive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ExplodedImporter;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
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

//    @Deployment
//    public static JavaArchive createDeployment() {
////        EnterpriseArchive ear = ShrinkWrap.create(EnterpriseArchive.class, "lancamento-sistema-test" + System.currentTimeMillis() + ".ear");
//        JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
//                .addClass(LancamentoBean.class)
//                .addClass(LancamentoDAO.class)
//                .addClass(Lancamento.class)
//                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
//        System.out.println(jar.toString(true));
//        return jar;
//    }

    @Deployment
    public static EnterpriseArchive createTestArchive() throws Exception {
        try {
            EnterpriseArchive ear = ShrinkWrap.create(EnterpriseArchive.class, 
                    "lancamento-sistema-test" + System.currentTimeMillis() + ".ear");

            ear.addAsModule(new File("../Lancamento-ejb/target/Lancamento-ejb-1.0-SNAPSHOT.jar"),
                    "lancamento-ejb" + System.currentTimeMillis() + ".jar");
            
            JavaArchive jarTest = ShrinkWrap.create(JavaArchive.class, "lancamento-sistema-test.jar")
                    .addPackages(true, "br.com.logic.trilha.test");
            jarTest.merge(ShrinkWrap.create(GenericArchive.class).as(ExplodedImporter.class)
                    .importDirectory("src/test/resources").as(GenericArchive.class), "/", Filters.includeAll());

            ear.addAsLibrary(jarTest);
//            ear.addAsLibraries(MavenArtifactResolver.resolve("com.oracle:ojdbc6:11.2.0"));
//            ear.addAsLibraries(MavenArtifactResolver.resolve("org.mockito:mockito-all:1.8.3"));

            return ear;

        } catch (Exception e) {
            System.err.println("### ERRO: "+ e.getMessage());
        }

        return null;
    }
    
    @EJB
    private LancamentoLocal lancamentoBean;

    @Test
    public void testBuscarLancamento() {
//        Lancamento result = lancamentoBean.buscar(10);
//        System.out.println(result);

        Assert.assertTrue(lancamentoBean.teste());
    }
}
