package com.example.projekat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Ocenjentrening implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private Double ocena;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Termin termin;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Clanfitnescentra clan;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getOcena() {
        return ocena;
    }

    public void setOcena(Double ocena) {
        this.ocena = ocena;
    }

    public Clanfitnescentra getClan() {
        return clan;
    }

    public void setClan(Clanfitnescentra clan) {
        this.clan = clan;
    }

    public Termin getTermin() {
        return termin;
    }

    public void setTermin(Termin termin) {
        this.termin = termin;
    }


    public Ocenjentrening(Long id, Double ocena) {
        this.id = id;
        this.ocena = ocena;

    }

    public Ocenjentrening() {
    }




}
