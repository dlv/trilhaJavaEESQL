package br.com.logic.trilha.lancamento.test;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.runner.RunWith;

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
@RunWith(Arquillian.class)
public class LancamentoResourceTest {

    @Deployment
    public static Archive<?> criarArquivoTeste() {
        Archive<?> arquivoTeste = ShrinkWrap.create(WebArchive.class, "aplicacaoTeste.war")
                // Adicionando o pacote inteiro da classe PessoaDao, ou seja incluí todas as outras classes deste pacote
//                .addPackage(PessoaDao.class.getPackage())
                // Adicionando apenas a classe Pessoa, e não o pacote inteiro como na linha anterior
//                .addClass(Pessoa.class)
                // Adicionando o arquivo persistence.xml para conexão JPA
//                .addAsResource("META-INF/persistence.xml")
                // Adicionando o beans.xml para ativação do CDI
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
        return arquivoTeste;
    }
}
