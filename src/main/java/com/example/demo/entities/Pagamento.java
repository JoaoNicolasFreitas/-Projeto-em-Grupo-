package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "pagamentos")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "ValorPago")
    private String ValorPago;

    @Column(name = "DataPagamento")
    private String DataPagamento;

    public Pagamento() {
    }

    public Pagamento(int id, String valorPago, String dataPagamento) {
        this.id = id;
        ValorPago = valorPago;
        DataPagamento = dataPagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValorPago() {
        return ValorPago;
    }

    public void setValorPago(String valorPago) {
        ValorPago = valorPago;
    }

    public String getDataPagamento() {
        return DataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        DataPagamento = dataPagamento;
    }
}
