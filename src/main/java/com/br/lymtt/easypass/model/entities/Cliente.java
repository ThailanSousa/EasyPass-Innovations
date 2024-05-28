package com.br.lymtt.easypass.model.entities;

public class Cliente extends Pessoa {

    private String email;
    private String numeroTelefone;

    public Cliente() {
    }

    public Cliente(Long id, String nome, String cpf, String genero, int idade, String email, String numeroTelefone) {
        super(id, nome, cpf, genero, idade);
        this.email = email;
        this.numeroTelefone = numeroTelefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    @Override
    public String toString() {
        return "Cliente [email=" + email + ", numeroTelefone=" + numeroTelefone + ", id=" + getId() + ", nome=" + getNome() + ", cpf=" + getCpf() + ", genero=" + getGenero() + ", idade=" + getIdade() + "]";
    }

}