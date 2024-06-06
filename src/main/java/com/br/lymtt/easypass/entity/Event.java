package com.br.lymtt.easypass.entity;

import java.util.Date;

public class Event {
  private Long id;
  private String nome;
  private String local;
  private Date data;


  private Promoter promoter;

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

  public String getLocal() {
      return local;
  }

  public void setLocal(String local) {
      this.local = local;
  }

  public Date getData() {
      return data;
  }

  public void setData(Date data) {
      this.data = data;
  }

  public Promoter getPromoter() {
      return promoter;
  }

  public void setPromoter(Promoter promoter) {
      this.promoter = promoter;
  }
}
