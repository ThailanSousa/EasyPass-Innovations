package com.br.lymtt.easypass.model.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "LYMTT", name = "promotor")

public class Promotor extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
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
