package com.example.projekat.repository;

import com.example.projekat.entity.Trener;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrenerRepository extends JpaRepository<Trener, Long> {

    List<Trener> findByAktivan(boolean aktivan);
    Trener findByKorisnickoimeAndLozinka(String korisnickoime, String lozinka);
    boolean existsTrenerByKorisnickoimeOrLozinkaOrEmail(String korisnickoime, String lozinka, String email);

}
