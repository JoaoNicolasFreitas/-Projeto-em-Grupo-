package com.example.demo.entities;

import jakarta.persistence.*;

@Entity // Adicionando a anotação para indicar que é uma entidade JPA
@Table(name = "metodo_pagamento") // Opcional: Especifica o nome da tabela no banco de dados
public class MetodoPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long metodoPagamentoID;

    private String descricao;

    // Construtor padrão
    public MetodoPagamento() {}

    // Construtor com parâmetros
    public MetodoPagamento(String descricao) {
        this.descricao = descricao;
    }

    public Long getMetodoPagamentoID() {
        return metodoPagamentoID;
    }

    public void setMetodoPagamentoID(Long metodoPagamentoID) {
        this.metodoPagamentoID = metodoPagamentoID;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "MetodoPagamento{" +
                "metodoPagamentoID=" + metodoPagamentoID +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MetodoPagamento)) return false;
        MetodoPagamento that = (MetodoPagamento) o;
        return metodoPagamentoID != null && metodoPagamentoID.equals(that.metodoPagamentoID);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
