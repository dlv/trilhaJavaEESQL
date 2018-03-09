package br.com.logic.trilha.test;

import br.com.logic.trilha.beans.LancamentoBean;
import java.io.File;
import javax.inject.Inject;

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

/**
 *
 * @author douglas
 */
@RunWith(Arquillian.class)
public class LancamentoTest {

    @Deployment
    public static EnterpriseArchive createDeployment() {

        EnterpriseArchive ear = ShrinkWrap.create(EnterpriseArchive.class, 
                "lancamento-test" + System.currentTimeMillis() + ".ear");

        ear.addAsModule(new File("/home/douglas/Documentos/projeto/trilhaJEE/trilhaJavaEESQL/Lancamento/Lancamento-ejb/target/Lancamento-ejb-1.0-SNAPSHOT.jar"), 
                "Lancamento-ejb" + System.currentTimeMillis() + ".jar");

        JavaArchive jarTest = ShrinkWrap.create(JavaArchive.class, "lancamento-test.jar")
                .addPackages(true, "br.com.logic.trilha.test");

        jarTest.merge(ShrinkWrap.create(GenericArchive.class).as(ExplodedImporter.class)
                .importDirectory("src/test/resources").as(GenericArchive.class), "/", Filters.includeAll());

        ear.addAsLibrary(jarTest);

        return ear;

//        return ShrinkWrap.create(JavaArchive.class)
////                .addClass(Lancamento.class)
////                .addClass(LancamentoBean.class)
////                .addClass(LancamentoDAO.class)
//                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    private LancamentoBean lancamentoBean;

    @Test
    public void teste() {
        Assert.assertTrue(lancamentoBean.teste());
    }
}
