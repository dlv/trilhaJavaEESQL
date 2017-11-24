/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.logic.trilha.dto;

import java.io.Serializable;

/**
 *
 * @author douglas
 */
public class LancamentoDTO implements Serializable{

    private String nome;
    private String data;
    private String valor;
    private String tipo;

    public LancamentoDTO() {
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "LancamentoDTO{" + "nome=" + nome + ", data=" + data + ", valor=" + valor + ", tipo=" + tipo + '}';
    }
}
