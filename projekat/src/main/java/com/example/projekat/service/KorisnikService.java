package com.example.projekat.service;

import com.example.projekat.entity.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface KorisnikService {

    Clanfitnescentra create(Clanfitnescentra clanfitnescentra) throws Exception;

    Trener create(Trener trener, String fitnesscentar ) throws Exception;

    List<Trener> findAll(String uloga) throws Exception ;

    Trener findOne(Long id);


    LoginDTO proveri(String korisnickoime, String lozinka) throws Exception;






   Trener update(Trener trener, String uloga) throws Exception ;

   List<Termin> findTermini();
   Trening findTreningByNaziv(String naziv);
    List<Termin> findTermini1(String naziv, String opis, String tip, LocalDateTime vremeTreninga, Double cena);

   List<Termin> sortiraj(Long id);

   Fitnesscentar create(Fitnesscentar fitnescentar, String uloga) throws Exception;

   List<Fitnesscentar> findFitnescentar();

   Termin prijavitermin( Long termin,Long  korisnik, String uloga) throws Exception;

   Set<Termin> prijavljenitermini1(Long korisnik, String uloga) throws Exception;

    Set<Termin> otkazitermin(Long korisnik, String uloga, Long termin) throws Exception;

    Set<Termin> odradjenitreninzi(Long korisnik, String uloga) throws Exception;

    Clanfitnescentra nadjiclana( Long korisnik,String uloga) throws Exception;

    Clanfitnescentra izmeniclana( Clanfitnescentra clanfitnescentra) throws Exception;

    List<Termin> ocenjenitermini(Long korisnik, String uloga) throws Exception;

    Ocenjentrening ocenjen(Termin termin1, Long korisnik);

    List<Termin> neocenjenitermini(Long korisnik, String uloga) throws Exception;

    Ocenjentrening ocenitrening(String uloga, Long korisnik, Long termin, Double ocena) throws Exception;

    Termin odabirtermina(String uloga, Long termin) throws Exception;

    List<Fitnesscentar> svifitnescentri( String uloga) throws Exception;

    Fitnesscentar nadjifitnescentar(Long fitnescentar, String uloga) throws Exception;
}
