package com.br.lymtt.easypass.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "LYMTT", name = "promotor")

public class Promotor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_evento", referencedColumnName = "id")
    private Evento evento;
    
    private String nome;
    private String cpf;
    private String genero; // masculino ou feminino
    private int idade;
    private String empresa;

    public Promotor() {
    }

    public Promotor(Long id, String nome, String cpf, String genero, int idade, String empresa, Evento evento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.genero = genero;
        this.idade = idade;
        this.empresa = empresa;
        this.evento = evento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "Promotor [ id=" + getId() + ", nome=" + getNome() + ", cpf=" + getCpf() + ", empresa=" + getEmpresa()
                + ", genero=" + getGenero() + ", idade=" + getIdade() + "]";
    }

}
