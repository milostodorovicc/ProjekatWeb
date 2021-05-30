package com.example.projekat.repository;

import com.example.projekat.entity.Trening;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreningRepository extends JpaRepository<Trening, Long> {
    Trening findByNaziv(String naziv);

}
