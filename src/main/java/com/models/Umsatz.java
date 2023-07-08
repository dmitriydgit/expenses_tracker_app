package com.models;


public class Umsatz {

  private Long id;
  private String anbieter;
//  private Long abbuchungskonto;
//  private Date buchungszeit;
//  private double beitrag;
//  private String typ;
//  private String kategorie;
//  private String umsatzart;
//  private String kommentar;
//


  public Umsatz(Long id, String anbieter) {
    this.id = id;
    this.anbieter = anbieter;
  }

  public Umsatz(String anbieter) {
    this.anbieter = anbieter;
  }

  public Umsatz() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAnbieter() {
    return anbieter;
  }

  public void setAnbieter(String anbieter) {
    this.anbieter = anbieter;
  }

  @Override
  public String toString() {
    return "Umsatz{" +
        "id=" + id +
        ", anbieter='" + anbieter + '\'' +
        '}';
  }
}
