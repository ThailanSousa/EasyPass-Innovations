package com.br.lymtt.easypass.model.entities;

public class Promotor extends Pessoa{
    private String empresa;
    
public Promotor(){
}

public Promotor(Long id, String nome, String cpf, String genero, int idade, String empresa) {
    super(id, nome, cpf, genero, idade);
    this.empresa = empresa;
}


public String getEmpresa() {
    return empresa;
}

@Override
    public String toString() {
        return "Promotor [ id=" + getId() + ", nome=" + getNome() + ", cpf=" + getCpf() + ", empresa=" + empresa + ", genero=" + getGenero() + ", idade=" + getIdade() + "]";
    }
}
