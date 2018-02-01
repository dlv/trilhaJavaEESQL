package br.com.logic.trilha;

import br.com.logic.trilha.beans.LancamentoBean;
import br.com.logic.trilha.daos.LancamentoDAO;
import br.com.logic.trilha.local.LancamentoLocal;
import br.com.logic.trilha.models.Lancamento;
import javax.inject.Inject;
import org.jboss.arquillian.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.common.Assert;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

/**
 *
 * @author douglas
 */
@RunWith(Arquillian.class)
public class LancamentoTest {

    @Inject
    private LancamentoLocal lancamento;

    @Deployment
    public static Archive createDeployment() {
        JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class);
        deployment.addResource(Lancamento.class)
                .addResource(LancamentoBean.class)
                .addResource(LancamentoDAO.class);
        return deployment;
    }

    @Test
    public void testTestando(){
        Assert.assertTrue(lancamento.teste());
    }
}
