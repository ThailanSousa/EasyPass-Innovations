package com.br.lymtt.easypass.model.entities;

public class Promotor extends Pessoa{
    private String empresa;
    
public Promotor(){
}

public Promotor (String empresa){
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
