package com.example.projekat.repository;

import com.example.projekat.entity.Termin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;

import java.util.Date;
import java.util.List;

public interface TerminRepository extends JpaRepository<Termin, Long> {

    List<Termin> findByDatumAfter( LocalDateTime datum);

    List<Termin> findByTreningNazivContainsAndTreningOpisContainsAndTreningTipContainsAndDatumLessThanEqualAndCenaLessThanEqual(String naziv,String opis, String tip,LocalDateTime vremeTreninga, Double cena);

    List<Termin> findByOrderByCenaAsc();
    List<Termin> findByOrderByCenaDesc();
    List<Termin> findByOrderByDatumAsc();
    List<Termin> findByOrderByDatumDesc();
}
