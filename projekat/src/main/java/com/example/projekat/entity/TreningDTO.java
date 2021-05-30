package com.example.projekat.entity;

import java.time.LocalDateTime;
import java.util.Date;

public class TreningDTO {

    private LocalDateTime datum;
    private double cena;
    private int brojprijavljenihclanova;
   private String nazivfitnescentra;
   private int oznaka;
   private String ime;
   private String prezime;
   private String nazivtreninga;
   private String opis;
   private String tip;
   private Double trajanje;


    public TreningDTO(LocalDateTime datum, double cena, int brojprijavljenihclanova, String nazivfitnescentra, int oznaka, String ime, String prezime, String nazivtreninga, String opis, String tip, Double trajanje) {
        this.datum = datum;
        this.cena = cena;
        this.brojprijavljenihclanova = brojprijavljenihclanova;
        this.nazivfitnescentra = nazivfitnescentra;
        this.oznaka = oznaka;
        this.ime = ime;
        this.prezime = prezime;
        this.nazivtreninga = nazivtreninga;
        this.opis = opis;
        this.tip = tip;
        this.trajanje = trajanje;
    }


    public TreningDTO() {
    }




    public LocalDateTime getDatum() {
        return datum;
    }

    public void setDatum(LocalDateTime datum) {
        this.datum = datum;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getBrojprijavljenihclanova() {
        return brojprijavljenihclanova;
    }

    public void setBrojprijavljenihclanova(int brojprijavljenihclanova) {
        this.brojprijavljenihclanova = brojprijavljenihclanova;
    }

    public String getNazivfitnescentra() {
        return nazivfitnescentra;
    }

    public void setNazivfitnescentra(String nazivfitnescentra) {
        this.nazivfitnescentra = nazivfitnescentra;
    }

    public int getOznaka() {
        return oznaka;
    }

    public void setOznaka(int oznaka) {
        this.oznaka = oznaka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getNazivtreninga() {
        return nazivtreninga;
    }

    public void setNazivtreninga(String nazivtreninga) {
        this.nazivtreninga = nazivtreninga;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Double getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(Double trajanje) {
        this.trajanje = trajanje;
    }
}
