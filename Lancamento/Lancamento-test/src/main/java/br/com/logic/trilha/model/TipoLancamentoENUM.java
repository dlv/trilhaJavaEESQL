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
    UNKNOWN(-1,"Desconhecido"),
    ALIMENTACAO(1, "Alimetação"),
    MORADIA(2, "Moradia"),
    EDUCACAO(3, "Educação"),
    TRANSPORTE(4, "Transporte"),
    SAUDE(5, "Saúde"),
    LAZER(6, "Lazer"),
    OUTROS(7, "Outros");

    private Integer id;
    private String descricao;

    private TipoLancamentoENUM(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static TipoLancamentoENUM getTipoLancamentoENUM(Integer id) {
        for (TipoLancamentoENUM e : values()) {
            if (e.id.equals(id)) {
                return e;
            }
        }
        return UNKNOWN;
    }
}
