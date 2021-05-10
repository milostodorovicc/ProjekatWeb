package com.example.projekat.entity;

import javax.persistence.*;

@Entity
public class Ocenjentrening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private double ocena;

    @ManyToOne(fetch = FetchType.EAGER)
    private Termin termin;















}
