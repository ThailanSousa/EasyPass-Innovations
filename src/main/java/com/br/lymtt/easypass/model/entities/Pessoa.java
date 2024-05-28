package com.br.lymtt.easypass.model.entities;

public class Pessoa {

    private Long id;
    private String nome;
    private String cpf;
    private String genero; //maculino ou feminino
    private int idade;

    public Pessoa() {
    }

    public Pessoa(Long id, String nome, String cpf, String genero, int idade) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.genero = genero;
        this.idade = idade;
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

    @Override
    public String toString() {
        return "Pessoa [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", genero=" + genero + ", idade=" + idade + "]";
    }

}
