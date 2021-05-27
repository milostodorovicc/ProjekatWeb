package com.example.projekat.service;

import com.example.projekat.entity.Clanfitnescentra;
import com.example.projekat.entity.Trener;

import java.util.List;

public interface KorisnikService {

    Clanfitnescentra create(Clanfitnescentra clanfitnescentra) throws Exception;

    Trener create(Trener trener) throws Exception;

    List<Trener> findAll();



}
