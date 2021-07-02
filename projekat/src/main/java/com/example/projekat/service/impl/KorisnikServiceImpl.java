package com.example.projekat.service.impl;
import java.util.ArrayList;

import com.example.projekat.entity.*;
import com.example.projekat.repository.*;
import com.example.projekat.service.KorisnikService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;

import static com.example.projekat.entity.Uloga.CLANFITNESCENTRA;
import static java.sql.Types.NULL;

@Service
public class KorisnikServiceImpl implements KorisnikService {

    private final ClanfitnescentraRepository clanfitnescentraRepository;
    private final TrenerRepository trenerRepository;
    private final AdministratorRepository administratorRepository;
    private final TerminRepository terminRepository;
    private final TreningRepository treningRepository;
    private final FitnescentarRepository fitnescentarRepository;
    private final OcenjentreningRepository ocenjentreningRepository;



    @Autowired
    public KorisnikServiceImpl(ClanfitnescentraRepository clanfitnescentraRepository, TrenerRepository trenerRepository, AdministratorRepository administratorRepository, TerminRepository terminRepository, TreningRepository treningRepository, FitnescentarRepository fitnescentarRepository, OcenjentreningRepository ocenjentreningRepository) {
        this.clanfitnescentraRepository = clanfitnescentraRepository;
        this.trenerRepository = trenerRepository;
        this.administratorRepository = administratorRepository;
        this.terminRepository = terminRepository;
        this.treningRepository = treningRepository;
        this.fitnescentarRepository = fitnescentarRepository;
        this.ocenjentreningRepository = ocenjentreningRepository;
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

        List<Termin> termini = this.terminRepository.findByTreningNazivContainsAndTreningOpisContainsAndTreningTipContainsAndDatumGreaterThanEqualAndCenaLessThanEqual(naziv, opis, tip, vremeTreninga, cena);
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
            loginDTO2.setId(trener.getId());
            loginDTO2.setAktivan(trener.isAktivan());
            loginDTO2.setUloga(trener.getUloga());
            loginDTO2.setKorisnickoime(trener.getKorisnickoime());
            loginDTO2.setLozinka(trener.getLozinka());
        }
        Clanfitnescentra clanfitnescentra = clanfitnescentraRepository.findByKorisnickoimeAndLozinka(korisnickoime, lozinka);
        if(clanfitnescentra!= null){
            loginDTO2.setId(clanfitnescentra.getId());
            loginDTO2.setUloga(clanfitnescentra.getUloga());
            loginDTO2.setKorisnickoime(clanfitnescentra.getKorisnickoime());
            loginDTO2.setLozinka(clanfitnescentra.getLozinka());
        }
        Administrator administrator = administratorRepository.findByKorisnickoimeAndLozinka(korisnickoime, lozinka);
        if(administrator!=null){
            loginDTO2.setId(administrator.getId());
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


    @Override
    public Termin prijavitermin(Long termin, Long korisnik, String uloga) throws Exception{
        if (!uloga.equals( "CLANFITNESCENTRA")) {
            throw new Exception("Nemate pristup ovim podacima!");
        }

        Termin termin3 = new Termin();
        Clanfitnescentra clanfitnescentra3 = new Clanfitnescentra();

        Termin termin2 = this.terminRepository.getOne(termin);
      Clanfitnescentra clanfitnescentra2 =  this.clanfitnescentraRepository.getOne( korisnik);


        if(termin2.getBrojprijavljenihclanova()<termin2.getSala().getKapacitet()) {

            termin2.addnewclan1(clanfitnescentra2);
            clanfitnescentra2.addnewtermin(termin2);
             int a = termin2.getBrojprijavljenihclanova();
             a++;
             termin2.setBrojprijavljenihclanova(a);

            this.terminRepository.save(termin2);
            this.clanfitnescentraRepository.save(clanfitnescentra2);


            return termin2;
        }
        else{
            return null;
        }

    }
  @Override
  public  Set<Termin> prijavljenitermini1(Long korisnik, String uloga) throws Exception{
      if (!uloga.equals( "CLANFITNESCENTRA")) {
          throw new Exception("Nemate pristup ovim podacima!");
      }

        Clanfitnescentra clan = this.clanfitnescentraRepository.getOne(korisnik);
       Set<Termin> termini =  clan.getTermin1();

       return termini;



    }



    @Override
    public  Set<Termin> otkazitermin(Long korisnik, String uloga, Long termin) throws Exception{

        if(!uloga.equals("CLANFITNESCENTRA")){
            throw new Exception("Nemate pristup ovim podacima!");
        }

        Clanfitnescentra clan = this.clanfitnescentraRepository.getOne(korisnik);
        Termin termin1 = this.terminRepository.getOne(termin);

        clan.removetermin(termin1);
        termin1.removeclan1(clan);

        this.terminRepository.save(termin1);
        this.clanfitnescentraRepository.save(clan);
        Set<Termin> termini =  clan.getTermin1();


        return termini;


    }




    @Override
    public  Set<Termin> odradjenitreninzi(Long korisnik, String uloga) throws Exception{
        if(!uloga.equals("CLANFITNESCENTRA")){
            throw new Exception("Nemate pristup ovim podacima!");
        }


       Clanfitnescentra clan = this.clanfitnescentraRepository.getOne(korisnik);
        Set<Termin> odradjeni = clan.getTermin();

        return odradjeni;



    }


   @Override
   public Clanfitnescentra nadjiclana(Long korisnik, String uloga) throws Exception{
        if(!uloga.equals("CLANFITNESCENTRA")){
            throw new Exception("Nemate pristup ovim podacima!");
        }

        Clanfitnescentra clan = this.clanfitnescentraRepository.getOne(korisnik);

        return clan;



    }

   @Override
    public Clanfitnescentra izmeniclana(Clanfitnescentra clanfitnescentra) throws Exception{
       Uloga uloga = clanfitnescentra.getUloga();
        if(!(uloga.equals(CLANFITNESCENTRA))){
            throw new Exception("Nemate pristup ovim podacima!");
        }

        Clanfitnescentra clan = this.clanfitnescentraRepository.findByEmail(clanfitnescentra.getEmail());

        clan.setIme(clanfitnescentra.getIme());
        clan.setPrezime(clanfitnescentra.getPrezime());
        clan.setKorisnickoime(clanfitnescentra.getKorisnickoime());
        clan.setLozinka(clanfitnescentra.getLozinka());
        clan.setEmail(clanfitnescentra.getEmail());
        clan.setDatumrodjenja(clanfitnescentra.getDatumrodjenja());
        clan.setTelefon(clanfitnescentra.getTelefon());

        Clanfitnescentra clan1 = this.clanfitnescentraRepository.save(clan);
        return clan1;

   }


   @Override
  public List<Termin> ocenjenitermini(Long korisnik, String uloga) throws Exception{



       if(!uloga.equals("CLANFITNESCENTRA")){
           throw new Exception("Nemate pristup ovim podacima!");
       }



       Clanfitnescentra clan = this.clanfitnescentraRepository.getOne(korisnik);

       List <Ocenjentrening> ocenjentrening1 = this.ocenjentreningRepository.findByClan(  clan);

       List<Termin> ocenjeni = new ArrayList<>();


        for(Ocenjentrening ocenjentrening : ocenjentrening1){

            if(ocenjentrening.getOcena()!=null){

            Termin termin = ocenjentrening.getTermin();

            ocenjeni.add(termin);}


        }



        return ocenjeni;

  }

  @Override
 public Ocenjentrening ocenjen(Termin termin1, Long korisnik){

        Clanfitnescentra clan = this.clanfitnescentraRepository.getOne(korisnik);

        Ocenjentrening ocenjentrening1 = this.ocenjentreningRepository.findByTerminAndClan(termin1, clan);

       return ocenjentrening1;
  }




    @Override
    public List<Termin> neocenjenitermini(Long korisnik, String uloga) throws Exception{



        if(!uloga.equals("CLANFITNESCENTRA")){
            throw new Exception("Nemate pristup ovim podacima!");
        }



        Clanfitnescentra clan = this.clanfitnescentraRepository.getOne(korisnik);

        List <Ocenjentrening> ocenjentrening1 = this.ocenjentreningRepository.findByClan(  clan);

        List<Termin> ocenjeni = new ArrayList<>();


        for(Ocenjentrening ocenjentrening : ocenjentrening1){

            if(ocenjentrening.getOcena()==null){

                Termin termin = ocenjentrening.getTermin();

                ocenjeni.add(termin);}


        }



        return ocenjeni;

    }


    @Override
    public Ocenjentrening ocenitrening(String uloga, Long korisnik, Long termin, Double ocena) throws Exception{
        if(!uloga.equals("CLANFITNESCENTRA")){
            throw new Exception("Nemate pristup ovim podacima!");
        }
        Termin termin1 = this.terminRepository.getOne(termin);

        double prosecna = termin1.getTrener().getProsecnaocena();
//        if(ocena!=null){
            double n = termin1.getTrener().getN() + 1;
            termin1.getTrener().setN(n);
            double prosecna1;
            prosecna1 = (prosecna + ocena)/termin1.getTrener().getN();
            Trener trener = termin1.getTrener();
            trener.setProsecnaocena(prosecna1);
            this.trenerRepository.save(trener);
//        }







        Clanfitnescentra clan = this.clanfitnescentraRepository.getOne(korisnik);

        Ocenjentrening ocenjentrening = this.ocenjentreningRepository.findByTerminAndClan(termin1, clan);
        ocenjentrening.setOcena(ocena);

        Ocenjentrening ocenjentrening1 = this.ocenjentreningRepository.save(ocenjentrening);

        return ocenjentrening1;





    }


    @Override
    public  Termin odabirtermina(String uloga, Long termin) throws Exception{
        if(!uloga.equals("CLANFITNESCENTRA")){
            throw new Exception("Nemate pristup ovim podacima!");

        }

        Termin termin1 = this.terminRepository.getOne(termin);
        return termin1;





    }

    @Override
   public List<Fitnesscentar> svifitnescentri(String uloga) throws Exception{
        if(!uloga.equals("ADMINISTRATOR")){
            throw new Exception ("Nemate pristup ovim podacima!");

        }
        List<Fitnesscentar> svifitnescentri1 = this.fitnescentarRepository.findAll();
        return svifitnescentri1;



   }

   @Override
   public Fitnesscentar nadjifitnescentar(Long fitnescentar, String uloga) throws Exception{
        if(!uloga.equals("ADMINISTRATOR")){
            throw new Exception("Nemate pristup ovim podacima");
        }

        Fitnesscentar fitnescentar1 = this.fitnescentarRepository.getOne(fitnescentar);
        return fitnescentar1;
   }







}
