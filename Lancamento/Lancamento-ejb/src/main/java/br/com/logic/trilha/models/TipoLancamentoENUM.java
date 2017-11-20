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
public enum TipoLancamentoENUM {
    DEBITO(1),
    CREDITO(2);

    private Integer tipo;

    private TipoLancamentoENUM(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getTipo() {
        return tipo;
    }

    public static TipoLancamentoENUM getTipo(Integer valor) {
        int v = valor;
        switch (v) {
            case 1:
                return TipoLancamentoENUM.DEBITO;
            case 2:
                return TipoLancamentoENUM.CREDITO;
            default:
                return null;
        }
    }
}
