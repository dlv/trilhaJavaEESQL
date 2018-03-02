package br.com.logic.trilha.test;

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

/**
 *
 * @author douglas
 */
@RunWith(Arquillian.class)
public class LancamentoTest {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Lancamento.class)
                .addClass(LancamentoBean.class)
                .addClass(LancamentoDAO.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    private LancamentoBean lancamentoBean;

    @Test
    public void teste() {
        Assert.assertTrue(lancamentoBean.teste());
    }
}
