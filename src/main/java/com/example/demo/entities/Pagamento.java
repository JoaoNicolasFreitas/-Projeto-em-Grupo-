package com.example.demo.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pagamentoID;

    private BigDecimal valorPago;
    private Date dataPagamento;
    private String statusPagamento;

    @ManyToOne
    @JoinColumn(name = "MetodoPagamentoID")
    private MetodoPagamento metodoPagamento;

    @ManyToOne
    @JoinColumn(name = "ClienteID")
    private Cliente cliente;

    // Construtor padrão
    public Pagamento() {}

    // Construtor com parâmetros (opcional)
    public Pagamento(BigDecimal valorPago, Date dataPagamento, String statusPagamento, MetodoPagamento metodoPagamento, Cliente cliente) {
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.statusPagamento = statusPagamento;
        this.metodoPagamento = metodoPagamento;
        this.cliente = cliente;
    }

    // Getters e Setters
    public Long getPagamentoID() {
        return pagamentoID;
    }

    public void setPagamentoID(Long pagamentoID) {
        this.pagamentoID = pagamentoID;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(String statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "pagamentoID=" + pagamentoID +
                ", valorPago=" + valorPago +
                ", dataPagamento=" + dataPagamento +
                ", statusPagamento='" + statusPagamento + '\'' +
                ", metodoPagamento=" + metodoPagamento +
                ", cliente=" + cliente +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pagamento)) return false;
        Pagamento pagamento = (Pagamento) o;
        return pagamentoID.equals(pagamento.pagamentoID);
    }

    @Override
    public int hashCode() {
        return pagamentoID.hashCode();
    }
}
