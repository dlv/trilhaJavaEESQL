/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.logic.trilha.models;

/**
 *
 * @author douglas
 */
public class Lancamento {

    private Integer id;
    private String nome;
    private String data;
    private Double valor;
    private TipoLancamentoENUM tipoLancamento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
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

    @Override
    public String toString() {
        return "{" + "id=" + id + ", nome=" + nome + ", data=" + data + ", valor=" + valor + ", tipoLancamento=" + tipoLancamento + '}';
    }
}
