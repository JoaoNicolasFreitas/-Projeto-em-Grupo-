package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "feedbacks")
public class FeedBacks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "Descricao")
    private String descricao;

    @Column(name = "NotaFeedbacks")
    private int notaFeedbacks;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "cliente_id", referencedColumnName = "id")
    private Cliente cliente;

    public FeedBacks() {

    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNotaFeedbacks() {
        return notaFeedbacks;
    }

    public void setNotaFeedbacks(int notaFeedbacks) {
        this.notaFeedbacks = notaFeedbacks;
    }
}