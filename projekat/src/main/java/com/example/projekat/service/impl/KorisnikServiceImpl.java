package com.example.projekat.service.impl;

import com.example.projekat.entity.*;
import com.example.projekat.repository.*;
import com.example.projekat.service.KorisnikService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    @Autowired
    public KorisnikServiceImpl(ClanfitnescentraRepository clanfitnescentraRepository, TrenerRepository trenerRepository, AdministratorRepository administratorRepository, TerminRepository terminRepository, TreningRepository treningRepository) {
        this.clanfitnescentraRepository = clanfitnescentraRepository;
        this.trenerRepository = trenerRepository;
        this.administratorRepository = administratorRepository;
        this.terminRepository = terminRepository;
        this.treningRepository = treningRepository;
    }

    @Override
    public Clanfitnescentra create(Clanfitnescentra clanfitnescentra) throws Exception {
        if (clanfitnescentra.getId() != null) {
            throw new Exception("ID must be null!");
        }
        Clanfitnescentra noviclanfitnescentra = this.clanfitnescentraRepository.save(clanfitnescentra);
        return noviclanfitnescentra;
    }


    public Trener create(Trener trener) throws Exception{
        if(trener.getId()!= null){
            throw new Exception("ID must be null!");
        }
        Trener novitrener = this.trenerRepository.save(trener);
        return novitrener;
    }



    @Override
    public List<Trener> findAll() {
        List<Trener> treneri = this.trenerRepository.findByAktivan(false);
        return treneri;
    }



    @Override
    public Trener findOne(Long id) {
        Trener trener = this.trenerRepository.getOne(id);
        return trener;
    }

    @Override
    public Trener findByKorisnickoimeAndLozinka( String korisnickoime, String lozinka){
        Trener trener = this.trenerRepository.findByKorisnickoimeAndLozinka(korisnickoime, lozinka);
        return trener;
    }

    @Override
    public Clanfitnescentra findByKorisnickoimeAndLozinka1(String korisnickoime, String lozinka){
        Clanfitnescentra clanfitnescentra = this.clanfitnescentraRepository.findByKorisnickoimeAndLozinka(korisnickoime, lozinka);
         return clanfitnescentra;
    }

    @Override
    public Administrator findByKorisnickoimeAndLozinka2(String korisnickoime, String lozinka){
        Administrator administrator = this.administratorRepository.findByKorisnickoimeAndLozinka(korisnickoime, lozinka);
        return administrator;
    }

     @Override
    public Trener update(Trener trener) {
         Trener novitrener = this.trenerRepository.getOne(trener.getId());

         novitrener.setAktivan(true);


         Trener novitrener1 = this.trenerRepository.save(novitrener);
         return novitrener1;


     }


    public List<Termin> findTermini() {
        LocalDateTime datum = LocalDateTime.now();
        List<Termin> termini = this.terminRepository.findByDatumAfter(datum);
        return termini;
    }


    public List<Termin> findTermini1(String naziv, String opis, String tip, LocalDateTime vremeTreninga, Double cena) {

        List<Termin> termini = this.terminRepository.findByTreningNazivContainsAndTreningOpisContainsAndTreningTipContainsAndDatumLessThanEqualAndCenaLessThanEqual( naziv, opis,  tip, vremeTreninga, cena);
        return termini;
    }


    public Trening findTreningByNaziv(String naziv){
        Trening trening1 = this.treningRepository.findByNaziv(naziv);
        return trening1;
    }

   public List<Termin> sortiraj(Long id){

       int a =(int) (long) id;
       switch( a) {
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
}}
