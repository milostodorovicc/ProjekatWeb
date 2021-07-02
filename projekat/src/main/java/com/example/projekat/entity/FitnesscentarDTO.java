package com.example.projekat.entity;

import javax.persistence.Column;

public class FitnesscentarDTO {


    private String naziv;

    private String adresa;

    private int brojtelefonacentrale;

    private String email;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getBrojtelefonacentrale() {
        return brojtelefonacentrale;
    }

    public void setBrojtelefonacentrale(int brojtelefonacentrale) {
        this.brojtelefonacentrale = brojtelefonacentrale;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public FitnesscentarDTO(String naziv, String adresa, int brojtelefonacentrale, String email) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.brojtelefonacentrale = brojtelefonacentrale;
        this.email = email;
    }


    public FitnesscentarDTO() {
    }
}
