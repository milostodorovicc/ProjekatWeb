package com.example.projekat.service;

import com.example.projekat.entity.*;

import java.time.LocalDateTime;
import java.util.List;

public interface KorisnikService {

    Clanfitnescentra create(Clanfitnescentra clanfitnescentra) throws Exception;

    Trener create(Trener trener) throws Exception;

    List<Trener> findAll(String uloga) throws Exception ;

    Trener findOne(Long id);

    Trener findByKorisnickoimeAndLozinka( String korisnickoime, String lozinka);

   Clanfitnescentra findByKorisnickoimeAndLozinka1(String korisnickoime, String lozinka);

   Administrator findByKorisnickoimeAndLozinka2(String korisnickoime, String lozinka);

   Trener update(Trener trener, String uloga) throws Exception ;

   List<Termin> findTermini();
   Trening findTreningByNaziv(String naziv);
    List<Termin> findTermini1(String naziv, String opis, String tip, LocalDateTime vremeTreninga, Double cena);

   List<Termin> sortiraj(Long id);

   Fitnesscentar create(Fitnesscentar fitnescentar, String uloga) throws Exception;



}
