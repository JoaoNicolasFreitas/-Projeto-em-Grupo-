package com.example.demo.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "feedback") // Especifica o nome da tabela no banco de dados
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedbackID;

    @Column(nullable = false) // Opcional: impede que o comentário seja nulo
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "clienteID", nullable = false) // Relaciona com a entidade Cliente
    private Cliente cliente;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFeedback;

    // Construtor padrão
    public Feedback() {}

    // Construtor com parâmetros
    public Feedback(String comentario, Cliente cliente, Date dataFeedback) {
        this.comentario = comentario;
        this.cliente = cliente;
        this.dataFeedback = dataFeedback;
    }

    // Getters e Setters
    public Long getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(Long feedbackID) {
        this.feedbackID = feedbackID;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataFeedback() {
        return dataFeedback;
    }

    public void setDataFeedback(Date dataFeedback) {
        this.dataFeedback = dataFeedback;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "feedbackID=" + feedbackID +
                ", comentario='" + comentario + '\'' +
                ", cliente=" + cliente.getNome() + // Exibindo o nome do cliente, supondo que ele tenha um método getNome()
                ", dataFeedback=" + dataFeedback +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Feedback)) return false;
        Feedback feedback = (Feedback) o;
        return feedbackID != null && feedbackID.equals(feedback.feedbackID);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
