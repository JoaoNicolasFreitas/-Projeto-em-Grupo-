package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "eventos")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "titulo")
    private String Titulo;

    @Column(name = "valor")
    private String valor;

    @Column(name = "data_evento")
    private String DataEvento;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organizador_id", referencedColumnName = "id")
    private Organizador organizador;

    @OneToOne
    @JoinColumn(name = "localizacao")
    private Localizacao localizacao;

    @OneToOne
    @JoinColumn(name = "pagamento_id")
    private Pagamento pagamento;

    public Evento() {

    }

    public Evento(String titulo, String valor, String dataEvento, Organizador organizador, Localizacao localizacao) {
        Titulo = titulo;
        this.valor = valor;
        DataEvento = dataEvento;
        this.organizador = organizador;
        this.localizacao = localizacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDataEvento() {
        return DataEvento;
    }

    public void setDataEvento(String dataEvento) {
        DataEvento = dataEvento;
    }

    public Organizador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }
}

