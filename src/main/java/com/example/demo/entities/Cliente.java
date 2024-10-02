package com.example.demo.entities;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteID;

    private String nome;
    private String telefone;
    private String email;

    @ManyToOne
    @JoinColumn(name = "enderecoID")
    private Endereco endereco;

    @OneToOne
    @JoinColumn(name = "feedbacks_FeedbackID")
    private Feedback feedback;

    // Getters e Setters
    public Long getClienteID() {
        return clienteID;
    }

    public void setClienteID(Long clienteID) {
        this.clienteID = clienteID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    // Métodos equals e hashCode, recomendados para evitar problemas com coleções
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(clienteID, cliente.clienteID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clienteID);
    }
}
