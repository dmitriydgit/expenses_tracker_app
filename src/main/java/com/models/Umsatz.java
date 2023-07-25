package com.models;


public class Umsatz {

  private Long id;
  private String anbieter;
  private String abbuchungskonto;
  private String buchungszeit;
  private String beitrag;
  private String typ;
  private String kategorie;
  private String umsatzart;
  private String kommentar;

  public Umsatz(Long id, String anbieter, String abbuchungskonto, String buchungszeit,
      String beitrag, String typ, String kategorie, String umsatzart, String kommentar) {
    this.id = id;
    this.anbieter = anbieter;
    this.abbuchungskonto = abbuchungskonto;
    this.buchungszeit = buchungszeit;
    this.beitrag = beitrag;
    this.typ = typ;
    this.kategorie = kategorie;
    this.umsatzart = umsatzart;
    this.kommentar = kommentar;
  }


  public Umsatz() {}

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

  public String getAbbuchungskonto() {
    return abbuchungskonto;
  }

  public void setAbbuchungskonto(String abbuchungskonto) {
    this.abbuchungskonto = abbuchungskonto;
  }

  public String getBuchungszeit() {
    return buchungszeit;
  }

  public void setBuchungszeit(String buchungszeit) {
    this.buchungszeit = buchungszeit;
  }

  public String getBeitrag() {
    return beitrag;
  }

  public void setBeitrag(String beitrag) {
    this.beitrag = beitrag;
  }

  public String getTyp() {
    return typ;
  }

  public void setTyp(String typ) {
    this.typ = typ;
  }

  public String getKategorie() {
    return kategorie;
  }

  public void setKategorie(String kategorie) {
    this.kategorie = kategorie;
  }

  public String getUmsatzart() {
    return umsatzart;
  }

  public void setUmsatzart(String umsatzart) {
    this.umsatzart = umsatzart;
  }

  public String getKommentar() {
    return kommentar;
  }

  public void setKommentar(String kommentar) {
    this.kommentar = kommentar;
  }

  @Override
  public String toString() {
    return "Umsatz{" +
        "id=" + id +
        ", anbieter='" + anbieter + '\'' +
        ", abbuchungskonto='" + abbuchungskonto + '\'' +
        ", buchungszeit='" + buchungszeit + '\'' +
        ", beitrag='" + beitrag + '\'' +
        ", typ='" + typ + '\'' +
        ", kategorie='" + kategorie + '\'' +
        ", umsatzart='" + umsatzart + '\'' +
        ", kommentar='" + kommentar + '\'' +
        '}';
  }
}
