package com.example.projekat.service;

import com.example.projekat.entity.Administrator;
import com.example.projekat.entity.Clanfitnescentra;
import com.example.projekat.entity.Trener;

import java.util.List;

public interface KorisnikService {

    Clanfitnescentra create(Clanfitnescentra clanfitnescentra) throws Exception;

    Trener create(Trener trener) throws Exception;

    List<Trener> findAll();

    Trener findOne(Long id);

    Trener findByKorisnickoimeAndLozinka( String korisnickoime, String lozinka);

   Clanfitnescentra findByKorisnickoimeAndLozinka1(String korisnickoime, String lozinka);

   Administrator findByKorisnickoimeAndLozinka2(String korisnickoime, String lozinka);

   Trener update(Trener trener) ;
}
