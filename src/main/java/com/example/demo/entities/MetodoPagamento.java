package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "metodo_pagamento")  // Adjusted to snake_case for the database table name
public class MetodoPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "endereco", nullable = false)
    private String endereco;

    // Default constructor required by JPA
    public MetodoPagamento() {}

    // Constructor without ID (as ID is auto-generated)
    public MetodoPagamento(String endereco) {
        this.endereco = endereco;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
