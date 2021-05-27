package com.example.projekat.repository;

import com.example.projekat.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

    Administrator findByKorisnickoimeAndLozinka(String korisnickoime, String lozinka);
}
