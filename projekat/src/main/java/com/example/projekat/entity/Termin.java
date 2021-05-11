package com.example.projekat.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Entity
public class Termin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;




    private Date datum;
    private double cena;
    private int brojprijavljenihclanova;


    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Termin(Long id, Date datum, double cena, int brojprijavljenihclanova) {
        this.id = id;
        this.datum = datum;
        this.cena = cena;
        this.brojprijavljenihclanova = brojprijavljenihclanova;

    }


    public Termin() {
    }

    @ManyToOne(fetch = FetchType.EAGER)
    private Trening trening;

    @ManyToOne(fetch = FetchType.EAGER)
    private Sala sala;

    @ManyToOne(fetch = FetchType.EAGER)
    private Fitnesscentar fitnesscentar;

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @ManyToMany(mappedBy = "termin")
    private Set<Clanfitnescentra> clan = new HashSet<>();

    @ManyToMany(mappedBy = "termin1")
    private Set<Clanfitnescentra> clan1 = new HashSet<>();


    public Set<Clanfitnescentra> getClan() {
        return clan;
    }

    public void setClan(Set<Clanfitnescentra> clan) {
        this.clan = clan;
    }

    public Set<Clanfitnescentra> getClan1() {
        return clan1;
    }

    public void setClan1(Set<Clanfitnescentra> clan1) {
        this.clan1 = clan1;
    }

    @OneToMany(mappedBy ="termin", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set <Ocenjentrening>  ocenjentrening =  new HashSet<>();



    public Set<Ocenjentrening> getOcenjentrening() {
        return ocenjentrening;
    }

    public void setOcenjentrening(Set<Ocenjentrening> ocenjentrening) {
        this.ocenjentrening = ocenjentrening;
    }



    @ManyToOne(fetch = FetchType.EAGER)
    private Trener trener;

    public Trening getTrening() {
        return trening;
    }

    public void setTrening(Trening trening) {
        this.trening = trening;
    }

    public Fitnesscentar getFitnesscentar() {
        return fitnesscentar;
    }

    public void setFitnesscentar(Fitnesscentar fitnesscentar) {
        this.fitnesscentar = fitnesscentar;
    }

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
    }
}
