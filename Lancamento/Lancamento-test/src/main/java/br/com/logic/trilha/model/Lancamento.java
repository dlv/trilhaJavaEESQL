package br.com.logic.trilha.model;

import br.com.logic.trilha.models.TipoLancamentoENUM;
import java.util.Date;

/**
 *
 * @author douglas
 */
public class Lancamento {

    private Integer id;
    private String descricaoLancamento;
    private Date data;
    private Double valor;
    private TipoLancamentoENUM tipoLancamento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricaoLancamento() {
        return descricaoLancamento;
    }

    public void setDescricaoLancamento(String descricaoLancamento) {
        this.descricaoLancamento = descricaoLancamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public TipoLancamentoENUM getTipoLancamento() {
        return tipoLancamento;
    }

    public void setTipoLancamento(TipoLancamentoENUM tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }
}
