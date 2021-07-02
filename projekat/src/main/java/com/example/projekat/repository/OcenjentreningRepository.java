package com.example.projekat.repository;

import com.example.projekat.entity.Administrator;
import com.example.projekat.entity.Clanfitnescentra;
import com.example.projekat.entity.Ocenjentrening;
import com.example.projekat.entity.Termin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OcenjentreningRepository  extends JpaRepository<Ocenjentrening, Long> {
    List<Ocenjentrening> findByClan(  Clanfitnescentra clan);
    Ocenjentrening findByTerminAndClan(Termin termin1, Clanfitnescentra clan);




}
