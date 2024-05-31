package com.br.lymtt.easypass.model.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(schema = "LYMTT", name = "evento")

public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private LocalDate data;
    private String local;
    private LocalTime hora;

    public Evento() {
    }

    public Evento(Long id ,LocalDate data, String local, LocalTime hora) {
        this.id = id;
        this.data = data;
        this.local = local;
        this.hora = hora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    @Override
    public String toString() {
        return "Evento [ id= " + id + " data=" + data + ", local=" + local + ", hora=" + hora +" ]";
    }
}
