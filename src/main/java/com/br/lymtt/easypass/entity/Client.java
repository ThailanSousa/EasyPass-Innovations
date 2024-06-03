package com.br.lymtt.easypass.entity;

public class Client extends Person {
    
    private String codigoCliente;

    // Métodos getters e setters
    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }
}