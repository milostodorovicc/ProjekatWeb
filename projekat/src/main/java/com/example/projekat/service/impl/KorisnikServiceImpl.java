package com.example.projekat.service.impl;

import com.example.projekat.entity.*;
import com.example.projekat.repository.*;
import com.example.projekat.service.KorisnikService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class KorisnikServiceImpl implements KorisnikService {

    private final ClanfitnescentraRepository clanfitnescentraRepository;
    private final TrenerRepository trenerRepository;
    private final AdministratorRepository administratorRepository;
    private final TerminRepository terminRepository;
    private final TreningRepository treningRepository;
    private final FitnescentarRepository fitnescentarRepository;


    @Autowired
    public KorisnikServiceImpl(ClanfitnescentraRepository clanfitnescentraRepository, TrenerRepository trenerRepository, AdministratorRepository administratorRepository, TerminRepository terminRepository, TreningRepository treningRepository, FitnescentarRepository fitnescentarRepository) {
        this.clanfitnescentraRepository = clanfitnescentraRepository;
        this.trenerRepository = trenerRepository;
        this.administratorRepository = administratorRepository;
        this.terminRepository = terminRepository;
        this.treningRepository = treningRepository;
        this.fitnescentarRepository = fitnescentarRepository;
    }

    @Override
    public Clanfitnescentra create(Clanfitnescentra clanfitnescentra) throws Exception {

        if(clanfitnescentraRepository.existsClanfitnescentraByKorisnickoimeOrLozinkaOrEmail(clanfitnescentra.getKorisnickoime(), clanfitnescentra.getLozinka(),clanfitnescentra.getEmail())) {
            throw new Exception("Korisnik sa takvim korisnickim imenom, lozinkom ili email-om vec postoji!");
        }
        if(trenerRepository.existsTrenerByKorisnickoimeOrLozinkaOrEmail(clanfitnescentra.getKorisnickoime(), clanfitnescentra.getLozinka(),clanfitnescentra.getEmail())) {
            throw new Exception("Korisnik sa takvim korisnickim imenom, lozinkom ili email-om vec postoji!");
        }
        if(administratorRepository.existsAdministratorByKorisnickoimeOrLozinkaOrEmail(clanfitnescentra.getKorisnickoime(), clanfitnescentra.getLozinka(),clanfitnescentra.getEmail())) {
            throw new Exception("Korisnik sa takvim korisnickim imenom, lozinkom ili email-om vec postoji!");
        }

        Clanfitnescentra noviclanfitnescentra = this.clanfitnescentraRepository.save(clanfitnescentra);
        return noviclanfitnescentra;
    }

    @Override
    public Trener create(Trener trener, String fitnesscentar) throws Exception {
        if(trenerRepository.existsTrenerByKorisnickoimeOrLozinkaOrEmail(trener.getKorisnickoime(), trener.getLozinka(),trener.getEmail())) {
            throw new Exception("Korisnik sa takvim korisnickim imenom, lozinkom ili email-om vec postoji!");
        }
        if(clanfitnescentraRepository.existsClanfitnescentraByKorisnickoimeOrLozinkaOrEmail(trener.getKorisnickoime(), trener.getLozinka(),trener.getEmail())) {
            throw new Exception("Korisnik sa takvim korisnickim imenom, lozinkom ili email-om vec postoji!");
        }
        if(administratorRepository.existsAdministratorByKorisnickoimeOrLozinkaOrEmail(trener.getKorisnickoime(), trener.getLozinka(),trener.getEmail())) {
            throw new Exception("Korisnik sa takvim korisnickim imenom, lozinkom ili email-om vec postoji!");
        }

        Fitnesscentar fitnesscentar1 = this.fitnescentarRepository.findByNaziv(fitnesscentar);
        trener.setFitnesscentar(fitnesscentar1);
        Trener novitrener = this.trenerRepository.save(trener);
        return novitrener;
    }


    @Override
    public List<Trener> findAll(String uloga) throws Exception {
        if(!uloga.equals("ADMINISTRATOR")){
            throw new Exception("Nije Vam dozvoljen pristup podacima!");
        }

        List<Trener> treneri = this.trenerRepository.findByAktivan(false);
        return treneri;
    }


    @Override
    public Trener findOne(Long id) {
        Trener trener = this.trenerRepository.getOne(id);
        return trener;
    }



    @Override
    public Trener update(Trener trener, String uloga) throws Exception {
        if(!uloga.equals("ADMINISTRATOR")){
            throw new Exception("Nije vam dozvoljen pristup podacima!");
        }
        Trener novitrener = this.trenerRepository.getOne(trener.getId());

        novitrener.setAktivan(true);


        Trener novitrener1 = this.trenerRepository.save(novitrener);
        return novitrener1;


    }

    @Override
    public List<Termin> findTermini() {
        LocalDateTime datum = LocalDateTime.now();
        List<Termin> termini = this.terminRepository.findByDatumAfter(datum);
        return termini;
    }

    @Override
    public List<Termin> findTermini1(String naziv, String opis, String tip, LocalDateTime vremeTreninga, Double cena) {

        List<Termin> termini = this.terminRepository.findByTreningNazivContainsAndTreningOpisContainsAndTreningTipContainsAndDatumLessThanEqualAndCenaLessThanEqual(naziv, opis, tip, vremeTreninga, cena);
        return termini;
    }

    @Override
    public Trening findTreningByNaziv(String naziv) {
        Trening trening1 = this.treningRepository.findByNaziv(naziv);
        return trening1;
    }
    @Override
    public List<Termin> sortiraj(Long id) {

        int a = (int) (long) id;
        switch (a) {
            case 1:
                List<Termin> termini = this.terminRepository.findByOrderByCenaAsc();
                return termini;

            case 2:
                List<Termin> termini1 = this.terminRepository.findByOrderByCenaDesc();
                return termini1;

            case 3:
                List<Termin> termini2 = this.terminRepository.findByOrderByDatumAsc();
                return termini2;


            case 4:
                List<Termin> termini3 = this.terminRepository.findByOrderByDatumDesc();
                return termini3;

            default:
                return null;

        }
    }




       @Override
       public Fitnesscentar create(Fitnesscentar fitnescentar, String uloga) throws Exception{
           if(fitnescentar.getId()!= null){
               throw new Exception("ID must be null!");
           }
           if(!uloga.equals("ADMINISTRATOR")){
               throw new Exception("Nemate pristup ovim podacima!");
           }
           Fitnesscentar novifitnescentar = this.fitnescentarRepository.save(fitnescentar);
           return novifitnescentar;
       }



    @Override
    public LoginDTO proveri(String korisnickoime, String lozinka) throws Exception{
        LoginDTO loginDTO2 = new LoginDTO();
        Trener trener = trenerRepository.findByKorisnickoimeAndLozinka(korisnickoime, lozinka);
        if(trener!= null){
            loginDTO2.setAktivan(trener.isAktivan());
            loginDTO2.setUloga(trener.getUloga());
            loginDTO2.setKorisnickoime(trener.getKorisnickoime());
            loginDTO2.setLozinka(trener.getLozinka());
        }
        Clanfitnescentra clanfitnescentra = clanfitnescentraRepository.findByKorisnickoimeAndLozinka(korisnickoime, lozinka);
        if(clanfitnescentra!= null){
            loginDTO2.setUloga(clanfitnescentra.getUloga());
            loginDTO2.setKorisnickoime(clanfitnescentra.getKorisnickoime());
            loginDTO2.setLozinka(clanfitnescentra.getLozinka());
        }
        Administrator administrator = administratorRepository.findByKorisnickoimeAndLozinka(korisnickoime, lozinka);
        if(administrator!=null){
            loginDTO2.setUloga(administrator.getUloga());
            loginDTO2.setKorisnickoime(administrator.getKorisnickoime());
            loginDTO2.setLozinka(administrator.getLozinka());
        }
        if(loginDTO2.getKorisnickoime()==null & loginDTO2.getLozinka()==null){
            throw new Exception("Niste uneli tacno korisnicko ime ili lozinku!");
        }
        return loginDTO2;

    }



    @Override
    public List<Fitnesscentar> findFitnescentar(){


        List<Fitnesscentar> svifitnescentri = fitnescentarRepository.findAll();
        return svifitnescentri;



    }
}
