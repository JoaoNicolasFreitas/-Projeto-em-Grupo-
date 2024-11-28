package com.example.demo.entities;


import jakarta.persistence.*;

@Entity
@Table(name="organizador")
public class Organizador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "Nome")
    private String Nome;

    @Column(name = "Telefone")
    private String Telefone;

    @Column(name = "Email")
    private String Email;

    public Organizador() {

    }

    public Organizador(int id, String Nome) {
        this.id = id;
        this.Nome = Nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }


}
