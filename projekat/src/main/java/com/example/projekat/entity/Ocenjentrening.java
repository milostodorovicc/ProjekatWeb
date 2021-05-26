package com.example.projekat.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Ocenjentrening implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private double ocena;

    @ManyToOne(fetch = FetchType.EAGER)
    private Termin termin;

    @ManyToOne(fetch = FetchType.EAGER)
    private Clanfitnescentra clan;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getOcena() {
        return ocena;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }

    public Termin getTermin() {
        return termin;
    }

    public void setTermin(Termin termin) {
        this.termin = termin;
    }


    public Ocenjentrening(Long id, double ocena) {
        this.id = id;
        this.ocena = ocena;

    }

    public Ocenjentrening() {
    }




}
