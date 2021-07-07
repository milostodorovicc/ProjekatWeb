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

   Termin prijavitermin( String termin,Long  korisnik, String uloga) throws Exception;

   Set<Termin> prijavljenitermini1(Long korisnik, String uloga) throws Exception;

    Set<Termin> otkazitermin(Long korisnik, String uloga, String termin) throws Exception;

    Set<Termin> odradjenitreninzi(Long korisnik, String uloga) throws Exception;

    Clanfitnescentra nadjiclana( Long korisnik,String uloga) throws Exception;

    Clanfitnescentra izmeniclana( Clanfitnescentra clanfitnescentra) throws Exception;

    List<Termin> ocenjenitermini(Long korisnik, String uloga) throws Exception;

    Ocenjentrening ocenjen(Termin termin1, Long korisnik);

    List<Termin> neocenjenitermini(Long korisnik, String uloga) throws Exception;

    Ocenjentrening ocenitrening(String uloga, Long korisnik, String termin, Double ocena) throws Exception;

    Termin odabirtermina(String uloga, String termin) throws Exception;

    List<Fitnesscentar> svifitnescentri( String uloga) throws Exception;

    Fitnesscentar nadjifitnescentar(String fitnescentar, String uloga) throws Exception;

    Fitnesscentar izbrisifitnescentar(String fitnescentar, String uloga) throws Exception;

    Fitnesscentar izmenifitnescentar(Fitnesscentar fitnescentar1, String fitnescentar, String uloga) throws Exception;

    Sala dodajnovusalu(Sala sala, String fitnescentar1, String uloga) throws Exception;

    Set<Sala> svesale(String fitnescentar, String uloga) throws Exception;

    Sala jednasala(String sala, String uloga) throws Exception;

    Sala izmenisalu(Sala sala, String sala1, String uloga) throws Exception;

    Sala izbrisisalu(String sala1, String uloga) throws Exception;

    Trening novitrening(Trening trening, String uloga) throws Exception;

    List<Trening> svitreninzi(String uloga) throws Exception;

    Set<Sala> nadjisale(Long korisnik,String uloga) throws Exception;

    Termin novitermin(Termin termin, String uloga, String trening, String sala, Long korisnik) throws Exception;

    Trener aktivantrener(Trener trener, String fitnesscentar, String uloga1) throws Exception;

    Trening nadjitrening(String uloga, String trening) throws Exception;

    Trening izmenitrening(Trening trening1, String uloga, String trening) throws Exception;

    Set<Termin> terminitrenera(String uloga, Long korisnik) throws Exception;

    Termin nadjitermin(String uloga, String termin) throws Exception;

    Termin izmenitermin(Termin termin1, String uloga, String termin, String sala) throws Exception;

    List<Trener> svitreneri(String uloga) throws Exception;

    Trener uklonitrenera(String uloga, String trener) throws Exception;

}
