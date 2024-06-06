package com.br.lymtt.easypass.model.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
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
    @Column(unique = true)
    private String nomeEvento;
    private LocalDate data;
    private String local;
    private LocalTime hora;

    public Evento() {
    }

    public Evento(Long id, LocalDate data, String local, LocalTime hora,String nomeEvento) {
        this.id = id;
        this.data = data;
        this.local = local;
        this.hora = hora;
        this.nomeEvento = nomeEvento;
    }

    public Long getId() {return id; }

    public void setId(Long id) {this.id = id;}

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

    public String getNomeEvento() {return nomeEvento; }

    public void setNomeEvento(String nomeEvento) {this.nomeEvento = nomeEvento;}

    @Override
    public String toString() {
        return "Evento [ id= " + id + " data=" + data + ", local=" + local + ", hora=" + hora + " ]";
    }
}
