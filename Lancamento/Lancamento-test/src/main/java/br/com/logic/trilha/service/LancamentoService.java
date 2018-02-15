package br.com.logic.trilha.service;

import br.com.logic.trilha.dao.LancamentoDAO;
import br.com.logic.trilha.model.Lancamento;
import br.com.logic.trilha.models.TipoLancamentoENUM;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author douglas
 */
@Stateless
public class LancamentoService {

    @Inject
    private LancamentoDAO lancamentoDAO;

    public LancamentoService() {
    }

    public Lancamento buscar(Integer id) {
        Lancamento l = new Lancamento();
        l.setId(1);
        l.setDescricaoLancamento("Teste");
        l.setTipoLancamento(TipoLancamentoENUM.UNKNOWN);
        l.setValor(15.00);
        
        return l;
    }

    public List<Lancamento> findAll() {
        return lancamentoDAO.buscar();
    }
}
