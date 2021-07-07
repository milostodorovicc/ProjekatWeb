package com.example.projekat.service.impl;
import java.util.ArrayList;

import com.example.projekat.entity.*;
import com.example.projekat.repository.*;
import com.example.projekat.service.KorisnikService;
import com.sun.xml.internal.ws.policy.spi.PolicyAssertionValidator;
import javassist.tools.web.BadHttpRequest;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import javax.swing.*;
import javax.xml.ws.Response;
import java.awt.*;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;

import static com.example.projekat.entity.Uloga.CLANFITNESCENTRA;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.sql.Types.NULL;
import static jdk.nashorn.internal.objects.Global.undefined;

@Service
public class KorisnikServiceImpl implements KorisnikService {

    private final ClanfitnescentraRepository clanfitnescentraRepository;
    private final TrenerRepository trenerRepository;
    private final AdministratorRepository administratorRepository;
    private final TerminRepository terminRepository;
    private final TreningRepository treningRepository;
    private final FitnescentarRepository fitnescentarRepository;
    private final OcenjentreningRepository ocenjentreningRepository;
    private final SalaRepository salaRepository;



    @Autowired
    public KorisnikServiceImpl(ClanfitnescentraRepository clanfitnescentraRepository, TrenerRepository trenerRepository, AdministratorRepository administratorRepository, TerminRepository terminRepository, TreningRepository treningRepository, FitnescentarRepository fitnescentarRepository, OcenjentreningRepository ocenjentreningRepository, SalaRepository salaRepository) {
        this.clanfitnescentraRepository = clanfitnescentraRepository;
        this.trenerRepository = trenerRepository;
        this.administratorRepository = administratorRepository;
        this.terminRepository = terminRepository;
        this.treningRepository = treningRepository;
        this.fitnescentarRepository = fitnescentarRepository;
        this.ocenjentreningRepository = ocenjentreningRepository;
        this.salaRepository = salaRepository;
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
//        trener.setN(1);
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

           fitnescentar.setAktivan(true);
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
    public Termin prijavitermin(String termin, Long korisnik, String uloga) throws Exception{
        if (!uloga.equals( "CLANFITNESCENTRA")) {
            throw new Exception("Nemate pristup ovim podacima!");
        }







        if(termin.equals("undefined") ){
            throw new Exception("Niste izabrali termin!");
        }
        if(termin.equals("null")){
            throw new Exception("Niste izabrali termin!");
        }

        Long l = Long.parseLong(termin);

        Termin termin3 = new Termin();
        Clanfitnescentra clanfitnescentra3 = new Clanfitnescentra();

        Termin termin2 = this.terminRepository.getOne(l);
        if(!termin2.isAktivan()){
            throw new Exception("Termin(Fitnes centar) vise nije aktivan");
        }
        if(!termin2.getFitnesscentar().isAktivan()){
            throw new Exception("Fitnes centar u kojem se odvija trening vise nije aktivan!");
        }
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
    public  Set<Termin> otkazitermin(Long korisnik, String uloga, String termin) throws Exception{

        if(!uloga.equals("CLANFITNESCENTRA")){
            throw new Exception("Nemate pristup ovim podacima!");
        }

        if(termin.equals("undefined") ){
            throw new Exception("Niste izabrali termin!");
        }
        if(termin.equals("null")){
            throw new Exception("Niste izabrali termin!");
        }

        Long l = Long.parseLong(termin);

        Clanfitnescentra clan = this.clanfitnescentraRepository.getOne(korisnik);
        Termin termin1 = this.terminRepository.getOne(l);

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
    public Ocenjentrening ocenitrening(String uloga, Long korisnik, String termin, Double ocena) throws Exception{
        if(!uloga.equals("CLANFITNESCENTRA")){
            throw new Exception("Nemate pristup ovim podacima!");
        }


        if(termin.equals("undefined") ){
            throw new Exception("Niste izabrali termin!");
        }
        if(termin.equals("null")){
            throw new Exception("Niste izabrali termin!");
        }

        Long l = Long.parseLong(termin);
        Termin termin1 = this.terminRepository.getOne(l);
        Clanfitnescentra clan1 = this.clanfitnescentraRepository.getOne(korisnik);

        Ocenjentrening ocenjentrening2 = this.ocenjentreningRepository.findByTerminAndClan(termin1, clan1);
        if(ocenjentrening2.getOcena()!=null){
            throw new Exception("Vec ste ocenili ovaj trening!");
        }

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
    public  Termin odabirtermina(String uloga, String termin) throws Exception{
        if(!uloga.equals("CLANFITNESCENTRA")){
            throw new Exception("Nemate pristup ovim podacima!");

        }


        if(termin.equals("undefined") ){
            throw new Exception("Niste izabrali termin!");
        }
        if(termin.equals("null")){
            throw new Exception("Niste izabrali termin!");
        }

        Long l = Long.parseLong(termin);

        Termin termin1 = this.terminRepository.getOne(l);
        if(!termin1.getFitnesscentar().isAktivan()){
            termin1.setAktivan(false);
        }

        Termin termin2 = this.terminRepository.save(termin1);
        return termin2;





    }

    @Override
   public List<Fitnesscentar> svifitnescentri(String uloga) throws Exception{
        if(!uloga.equals("ADMINISTRATOR")){
            throw new Exception ("Nemate pristup ovim podacima!");

        }


        List<Fitnesscentar> svifitnescentri1 = this.fitnescentarRepository.findAll();

        List<Fitnesscentar> svifitnescentri2 = new ArrayList<>();

        for(Fitnesscentar fitnescentar: svifitnescentri1){
            if(fitnescentar.isAktivan()==TRUE){
                svifitnescentri2.add(fitnescentar);
            }
        }
        return svifitnescentri2;



   }

   @Override
   public Fitnesscentar nadjifitnescentar(String fitnescentar, String uloga) throws Exception{
        if(!uloga.equals("ADMINISTRATOR")){
            throw new Exception("Nemate pristup ovim podacima");
        }


       if(fitnescentar.equals("undefined") ){
           throw new Exception("Niste izabrali fitnes centar!");
       }
       if(fitnescentar.equals("null")){
           throw new Exception("Niste izabrali fitnes centar!");
       }

       Long l = Long.parseLong(fitnescentar);
        Fitnesscentar fitnescentar1 = this.fitnescentarRepository.getOne(l);
        return fitnescentar1;
   }


    @Override
    public Fitnesscentar izbrisifitnescentar(String fitnescentar, String uloga) throws Exception{
        if(!uloga.equals("ADMINISTRATOR")){
            throw new Exception("Nemate pristup ovim podacima");
        }


        if(fitnescentar.equals("undefined") ){
            throw new Exception("Niste izabrali fitnes centar!");
        }
        if(fitnescentar.equals("null")){
            throw new Exception("Niste izabrali fitnes centar!");
        }

        Long l = Long.parseLong(fitnescentar);

        Fitnesscentar fitnescentar1 = this.fitnescentarRepository.getOne(l);
        fitnescentar1.setAktivan(FALSE);
        Fitnesscentar fitnescentar2 = this.fitnescentarRepository.save(fitnescentar1);
        return fitnescentar2;
    }




    @Override
    public Fitnesscentar izmenifitnescentar(Fitnesscentar fitnescentar1, String fitnescentar, String uloga) throws Exception{
        if(!uloga.equals("ADMINISTRATOR")){
            throw new Exception("Nemate pristup ovim podacima!");
        }

        if(fitnescentar.equals("undefined") ){
          throw new Exception("Niste izabrali fitnes centar!");
        }
        if(fitnescentar.equals("null")){
            throw new Exception("Niste izabrali fitnes centar!");
        }
        Long l = Long.parseLong(fitnescentar);
        Fitnesscentar fitnescentar2 = this.fitnescentarRepository.getOne(l);
        fitnescentar2.setNaziv(fitnescentar1.getNaziv());
        fitnescentar2.setAdresa(fitnescentar1.getAdresa());
        fitnescentar2.setBrojtelefonacentrale(fitnescentar1.getBrojtelefonacentrale());
        fitnescentar2.setEmail(fitnescentar1.getEmail());

        Fitnesscentar novifitnescentar = this.fitnescentarRepository.save(fitnescentar2);
        return novifitnescentar;


    }


    @Override
    public Sala dodajnovusalu(Sala sala, String fitnescentar1, String uloga) throws Exception{
    if(!uloga.equals("ADMINISTRATOR")){
        throw new Exception("Nemate pristup ovim podacima!");
    }

        if(fitnescentar1.equals("undefined") ){
            throw new Exception("Niste izabrali fitnes centar!");
        }
        if(fitnescentar1.equals("null")){
            throw new Exception("Niste izabrali fitnes centar!");
        }
        Long l = Long.parseLong(fitnescentar1);
        sala.setAktivan(true);
        Sala salanova = this.salaRepository.save(sala);

        Fitnesscentar fitnescentar = this.fitnescentarRepository.getOne(l);

    salanova.setFitnesscentar(fitnescentar);

    Sala salanova1 = this.salaRepository.save(salanova);

    return salanova1;




    }


    @Override
    public Set<Sala> svesale(String fitnescentar, String uloga) throws Exception{
        if(!uloga.equals("ADMINISTRATOR")){
            throw new Exception("Nemate pristup ovim podacima!");
        }

        if(fitnescentar.equals("undefined")){
            throw new Exception("Niste izabrali fitnes centar!");
        }
        if(fitnescentar.equals("null")){
            throw new Exception("Niste izabrali fitnes centar!");
        }




        Long l = Long.parseLong(fitnescentar);
        Fitnesscentar salafitnescentar = this.fitnescentarRepository.getOne(l);

        Set<Sala> svesale1 = salafitnescentar.getSala();
        Set<Sala> svesale2 = new HashSet<>();
        for(Sala sala: svesale1){
            if(sala.isAktivan()==TRUE){
                svesale2.add(sala);
            }
        }

        return svesale2;


    }



    @Override
    public Sala jednasala(String sala, String uloga) throws Exception{
        if(!uloga.equals("ADMINISTRATOR")){
            throw new Exception("Nemate pristup ovim podacima!");
        }


        if(sala.equals("undefined")){
            throw new Exception("Niste izabrali salu!");
        }
        if(sala.equals("null")){
            throw new Exception("Niste izabrali salu!");
        }

        Long l = Long.parseLong(sala);

        Sala sala2 = this.salaRepository.getOne(l);
        if(sala2.isAktivan()==FALSE){
            throw new Exception("Sala vise nije u funkciji!");
        }
        return sala2;




   }



    @Override
    public Sala izmenisalu(Sala sala, String sala1, String uloga) throws Exception{
        if(!uloga.equals("ADMINISTRATOR")){
            throw new Exception("Nemate pristup ovim podacima!");
        }

        if(sala1.isEmpty() ){
            throw new Exception("Niste izabrali salu!");
        }


        if(sala1.equals("undefined") ){
            throw new Exception("Niste izabrali salu!");
        }
        if(sala1.equals("null")){
            throw new Exception("Niste izabrali salu!");
        }
        Long l = Long.parseLong(sala1);
        Sala sala3 = this.salaRepository.getOne(l);
       sala3.setKapacitet(sala.getKapacitet());
       sala3.setOznaka(sala.getOznaka());

       Sala sala4 = this.salaRepository.save(sala3);
       return sala4;




    }





    @Override
    public Sala izbrisisalu( String sala1, String uloga) throws Exception{
        if(!uloga.equals("ADMINISTRATOR")){
            throw new Exception("Nemate pristup ovim podacima!");
        }

        if(sala1.equals("undefined")){
            throw new Exception("Niste izabrali salu!");
        }

        if(sala1.equals("null")){
            throw new Exception("Niste izabrali salu!");
        }

        Long l = Long.parseLong(sala1);

        Sala sala3 = this.salaRepository.getOne(l);
        sala3.setAktivan(FALSE);
        Sala sala = this.salaRepository.save(sala3);

       return sala;


    }



    @Override
    public Trening novitrening(Trening trening, String uloga) throws Exception{
        if(!uloga.equals("TRENER")){
            throw new Exception("Nemate pristup ovim podacima!");

        }

        Trening trening1 = this.treningRepository.save(trening);
        return trening1;

    }


    @Override
    public List<Trening> svitreninzi(String uloga ) throws Exception{
        if(!uloga.equals("TRENER")){
            throw new Exception("Nemate pristup ovim podacima!");
        }

        List<Trening> svitreninzi = this.treningRepository.findAll();
        return svitreninzi;




    }


    @Override
    public Set<Sala> nadjisale(Long korisnik, String uloga) throws Exception{

        if(!uloga.equals("TRENER")){
            throw new Exception("Nemate pristup ovim podacima!");
        }

        Trener trener = this.trenerRepository.getOne(korisnik);
       Set<Sala> sale =  trener.getFitnesscentar().getSala();



      return sale;




    }



    @Override
    public Termin novitermin(Termin termin, String uloga, String trening, String sala, Long korisnik) throws Exception{
        if(!uloga.equals("TRENER")){
            throw new Exception("Nemate pristup ovim podacima!");
        }

        if(trening.equals("undefined")){
            throw new Exception("Niste izabrali trening!");
        }

        if(trening.equals("null")){
            throw new Exception("Niste izabrali trening!");
        }

        if(sala.equals("undefined")){
            throw new Exception("Niste izabrali salu!");
        }

        if(sala.equals("null")){
            throw new Exception("Niste izabrali salu!");
        }

        Long s = Long.parseLong(sala);
        Long t = Long.parseLong(trening);

        Sala sala2 = this.salaRepository.getOne(s);
        Trening trening2 = this.treningRepository.getOne(t);
        Trener trener2 = this.trenerRepository.getOne(korisnik);
        Fitnesscentar fitcentar2 = trener2.getFitnesscentar();

        Termin termin1 = new Termin();

        termin1.setDatum(termin.getDatum());
        termin1.setCena(termin.getCena());
        termin1.setSala(sala2);
        termin1.setTrening(trening2);
        termin1.setBrojprijavljenihclanova(0);
        termin1.setTrener(trener2);
        termin1.setFitnesscentar(fitcentar2);

        Termin termin3 = this.terminRepository.save(termin1);

        return termin3;


    }





    @Override
    public Trener aktivantrener(Trener trener, String fitnesscentar, String uloga1) throws Exception {
        if(!uloga1.equals("ADMINISTRATOR")){
            throw new Exception("Nemate pristup ovim podacima!");

        }



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
        trener.setAktivan(true);
//        trener.setN(1);
        Trener novitrener = this.trenerRepository.save(trener);
        return novitrener;
    }





    @Override
    public Trening nadjitrening(String uloga, String trening) throws Exception{
        if(!uloga.equals("TRENER")){
            throw new Exception("Nemate pristup ovim podacima!");

        }
        if(trening.equals("undefined")){
            throw new Exception("Niste izabrali trening!");
        }

        if(trening.equals("null")){
            throw new Exception("Niste izabrali trening!");
        }


        Long l = Long.parseLong(trening);
        Trening trening2 = this.treningRepository.getOne(l);
        return trening2;

    }



    @Override
    public Trening izmenitrening(Trening trening1, String uloga, String trening) throws Exception{
        if(!uloga.equals("TRENER")){
            throw new Exception("Nemate pristup ovim podacima!");
        }
        if(trening.equals("undefined")){
            throw new Exception("Niste izabrali trening!");
        }

        if(trening.equals("null")){
            throw new Exception("Niste izabrali trening!");
        }


        Long l = Long.parseLong(trening);

        Trening trening12 = this.treningRepository.getOne(l);

       Set<Termin> termini =  trening12.getTermini();


       for(Termin termin : termini){
           if(termin.getBrojprijavljenihclanova()!= 0){
               throw new Exception("Vec ima prijavljenih clanova, nije moguce menjati trening!");
           }
       }






        trening12.setNaziv(trening1.getNaziv());
        trening12.setOpis(trening1.getOpis());
        trening12.setTip(trening1.getTip());
        trening12.setTrajanje(trening1.getTrajanje());

        Trening trening13 = this.treningRepository.save(trening12);
        return trening13;






    }




    @Override
    public Set<Termin> terminitrenera(String uloga, Long korisnik) throws Exception{
        if(!uloga.equals("TRENER")){
            throw new Exception("Nemate pristup ovim podacima!");
        }

        Trener trener = this.trenerRepository.getOne(korisnik);

        Set<Termin> termini3 = trener.getTermin();

        Set<Termin> termini4 = new HashSet<>();

        for(Termin termin: termini3){
            if(termin.getDatum().isAfter(LocalDateTime.now())){
                termini4.add(termin);

            }
        }


        return termini4;

    }


    @Override
    public Termin nadjitermin(String uloga, String termin) throws Exception{
        if(!uloga.equals("TRENER")){
            throw new Exception("Nemate pristup ovim podacima!");
        }


        if(termin.equals("undefined")){
            throw new Exception("Niste izabrali termin!");
        }

        if(termin.equals("null")){
            throw new Exception("Niste izabrali termin!");
        }

        Long t = Long.parseLong(termin);
        Termin termin2 = this.terminRepository.getOne(t);

        return termin2;




    }




    @Override
    public Termin izmenitermin(Termin termin1, String uloga, String termin, String sala) throws Exception{
        if(!uloga.equals("TRENER")){
            throw new Exception("Nemate pristup ovim podacima!");
        }

        if(termin.equals("undefined")){
            throw new Exception("Niste izabrali termin!");
        }

        if(termin.equals("null")){
            throw new Exception("Niste izabrali termin!");
        }
        if(sala.equals("undefined")){
            throw new Exception("Niste izabrali salu!");
        }

        if(sala.equals("null")){
            throw new Exception("Niste izabrali salu!");
        }
//        HttpStatus badrequest = HttpStatus.BAD_REQUEST;

        Long t = Long.parseLong(termin);
        Long s = Long.parseLong(sala);
        Sala salanova = this.salaRepository.getOne(s);
        Termin promenitermin = this.terminRepository.getOne(t);
        if(promenitermin.getBrojprijavljenihclanova()!=0){
            throw new Exception("Vec ima prijavljenih clanova za ovaj termin!");
        }

        promenitermin.setDatum(termin1.getDatum());
        promenitermin.setCena(termin1.getCena());
        promenitermin.setSala(salanova);

        Termin promenjenitermin = this.terminRepository.save(promenitermin);

        return promenjenitermin;






    }



    @Override
    public List<Trener> svitreneri(String uloga) throws Exception{
        if(!uloga.equals("ADMINISTRATOR")){
            throw new Exception("Nemate pristup ovim podacima!");
        }

        List<Trener> aktivnitreneri = this.trenerRepository.findAll();
        List<Trener> aktivnitreneri1 = new ArrayList<>();
        for(Trener trener : aktivnitreneri){
            if(trener.isAktivan()){
                aktivnitreneri1.add(trener);
            }

        }

          return aktivnitreneri1;

    }



    @Override
    public Trener uklonitrenera(String uloga, String trener) throws Exception{
        if(!uloga.equals("ADMINISTRATOR")){
            throw new Exception("Nemate pristup ovim podacima!");
        }
        Long t = Long.parseLong(trener);

        Trener uklonjentrener1 = this.trenerRepository.getOne(t);
        uklonjentrener1.setAktivan(false);
        Trener uklonjentrener2 = this.trenerRepository.save(uklonjentrener1);
        return uklonjentrener2;

    }


}
