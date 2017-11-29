/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.logic.trilha.models;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
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

    public String toXML(){
        return new XStream().toXML(this);
    }
    
    public String toJSON(){
        return new Gson().toJson(this);
    }
}
