package com.br.lymtt.easypass.model.entities;

import java.time.LocalDate;
import java.time.LocalTime;

public class Evento {
    private LocalDate data;
    private String local;
    private LocalTime hora;
    private Cliente cliente;

    public Evento() {
    }

    public Evento(LocalDate data, String local, LocalTime hora, Cliente cliente) {
        this.data = data;
        this.local = local;
        this.hora = hora;
        this.cliente = cliente;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Evento [data=" + data + ", local=" + local + ", hora=" + hora + ", cliente=" + cliente + "]";
    }
}
