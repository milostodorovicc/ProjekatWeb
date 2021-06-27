package com.example.projekat.repository;

import com.example.projekat.entity.Clanfitnescentra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClanfitnescentraRepository extends JpaRepository<Clanfitnescentra, Long> {


    Clanfitnescentra findByKorisnickoimeAndLozinka(String korisnickoime, String lozinka);
    boolean existsClanfitnescentraByKorisnickoimeOrLozinkaOrEmail(String korisnickoime, String lozinka, String email);

}
