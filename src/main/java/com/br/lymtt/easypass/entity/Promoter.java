package com.br.lymtt.easypass.entity;

import java.util.ArrayList;
import java.util.List;

public class Promoter extends Person {
  
  private String codigoPromotor;


  private List<Event> events = new ArrayList<>();


  public String getCodigoPromotor() {
      return codigoPromotor;
  }

  public void setCodigoPromotor(String codigoPromotor) {
      this.codigoPromotor = codigoPromotor;
  }

  public List<Event> getEvents() {
      return events;
  }

  public void setEvents(List<Event> events) {
      this.events = events;
  }

  public void addEvent(Event event) {
      events.add(event);
      event.setPromoter(this);
  }

  public void removeEvent(Event event) {
      events.remove(event);
      event.setPromoter(null);
  }
}
