package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "pagamentos")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "valor_pago")
    private String valorPago;

    @Column(name = "data_pagamento")
    private String dataPagamento;

    public Pagamento() {
    }

    public Pagamento(int id, String valorPago, String dataPagamento) {
        this.id = id;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValorPago() {
        return valorPago;
    }

    public void setValorPago(String valorPago) {
        this.valorPago = valorPago;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
