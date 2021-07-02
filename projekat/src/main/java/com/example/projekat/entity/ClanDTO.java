package com.example.projekat.entity;

import java.time.LocalDate;
import java.util.Date;

public class ClanDTO {

    private String korisnickoime;
    private String lozinka;
    private String ime;
    private String prezime;
    private int telefon;
    private String email;
    private LocalDate datumrodjenja;


    public ClanDTO(String korisnickoime, String lozinka, String ime, String prezime, int telefon, String email, LocalDate datumrodjenja) {
        this.korisnickoime = korisnickoime;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.telefon = telefon;
        this.email = email;
        this.datumrodjenja = datumrodjenja;
    }


    public String getKorisnickoime() {
        return korisnickoime;
    }

    public void setKorisnickoime(String korisnickoime) {
        this.korisnickoime = korisnickoime;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
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

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDatumrodjenja() {
        return datumrodjenja;
    }

    public void setDatumrodjenja(LocalDate datumrodjenja) {
        this.datumrodjenja = datumrodjenja;
    }
}
