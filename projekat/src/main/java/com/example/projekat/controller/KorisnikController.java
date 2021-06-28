package com.example.projekat.controller;

import com.example.projekat.entity.*;
import com.example.projekat.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/korisnici")
public class KorisnikController {


    private final KorisnikService korisnikService;

    @Autowired
    public KorisnikController(KorisnikService korisnikService) {
        this.korisnikService = korisnikService;
    }



    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE, value ="/clanfitnescentra")
    public ResponseEntity<Clanfitnescentra> createEmployee(@RequestBody Clanfitnescentra clanfitnescentra) throws Exception {

        Clanfitnescentra noviclanfitnescentra = korisnikService.create(clanfitnescentra);


        return new ResponseEntity<>(noviclanfitnescentra, HttpStatus.CREATED);
    }




    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE, value ="/trener")
    public ResponseEntity<Trener> createEmployee(@RequestBody Trener trener,@RequestParam(value = "fitnesscentar") String fitnesscetar ) throws Exception {

        Trener novitrener = korisnikService.create(trener,fitnesscetar);


        return new ResponseEntity<>(novitrener, HttpStatus.CREATED);
    }



    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Trener>> getTreneri(@RequestParam(value = "uloga" ) String uloga) throws Exception {

        List<Trener> trenerList = this.korisnikService.findAll(uloga);


        return new ResponseEntity<>(trenerList, HttpStatus.OK);
    }



    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Trener> getEmployee(@PathVariable("id") Long id,@RequestParam(value = "uloga" ) String uloga) throws Exception{

        Trener trener = new Trener();
        trener.setId(id);
         Trener trener1 =   korisnikService.update(trener, uloga);


        return new ResponseEntity<>(trener1, HttpStatus.OK);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE, value= "/login")
    public ResponseEntity<LoginDTO> potvrdilogin(@RequestBody Trener trener) throws Exception  {


        LoginDTO loginDTO1 = new LoginDTO();
        loginDTO1 = korisnikService.proveri(trener.getKorisnickoime(),trener.getLozinka());


        return new ResponseEntity<>(loginDTO1, HttpStatus.CREATED);



    }



            @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, value= "/prijavljeni")
    public ResponseEntity<TreningDTO> prijavljenitermini(@RequestParam(value = "termin") Long termin,@RequestParam(value = "korisnik") Long korisnik,@RequestParam(value = "uloga") String uloga) throws Exception   {



      Termin termin1 = new Termin();
       termin1 = korisnikService.prijavitermin(termin, korisnik, uloga);

                TreningDTO treningDTO = new TreningDTO(termin1.getDatum(), termin1.getCena(),
                        termin1.getBrojprijavljenihclanova(),termin1.getFitnesscentar().getNaziv(), termin1.getSala().getOznaka(),termin1.getTrener().getIme(),termin1.getTrener().getPrezime(),
                        termin1.getTrening().getNaziv(),termin1.getTrening().getOpis(),termin1.getTrening().getTip(),termin1.getTrening().getTrajanje(), termin1.getId());


        return new ResponseEntity<>(treningDTO, HttpStatus.CREATED);



    }







    @GetMapping(value = "/listatermina", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<TreningDTO>> listatermina(@RequestParam(value = "korisnik" ) Long korisnik,@RequestParam(value = "uloga") String uloga) throws Exception{


       Set<Termin> listatermina1 = this.korisnikService.prijavljenitermini1(korisnik, uloga);
        Set<TreningDTO> treningDTOS1 = new HashSet<>();

        for (Termin termin : listatermina1) {


            TreningDTO treningDTO = new TreningDTO(termin.getDatum(), termin.getCena(),
                    termin.getBrojprijavljenihclanova(),termin.getFitnesscentar().getNaziv(), termin.getSala().getOznaka(),termin.getTrener().getIme(),termin.getTrener().getPrezime(),
                    termin.getTrening().getNaziv(),termin.getTrening().getOpis(),termin.getTrening().getTip(),termin.getTrening().getTrajanje(), termin.getId());
            treningDTOS1.add(treningDTO);
        }

        return new ResponseEntity<>(treningDTOS1, HttpStatus.OK);
    }


    @GetMapping(value = "/otkazitermin", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<TreningDTO>> listatermina(@RequestParam(value = "korisnik" ) Long korisnik,@RequestParam(value = "uloga") String uloga, @RequestParam(value = "termin") Long termin) throws Exception{


        Set<Termin> listatermina1 = this.korisnikService.otkazitermin(korisnik, uloga, termin);
        Set<TreningDTO> treningDTOS1 = new HashSet<>();

        for (Termin termin1 : listatermina1) {


            TreningDTO treningDTO = new TreningDTO(termin1.getDatum(), termin1.getCena(),
                    termin1.getBrojprijavljenihclanova(),termin1.getFitnesscentar().getNaziv(), termin1.getSala().getOznaka(),termin1.getTrener().getIme(),termin1.getTrener().getPrezime(),
                    termin1.getTrening().getNaziv(),termin1.getTrening().getOpis(),termin1.getTrening().getTip(),termin1.getTrening().getTrajanje(), termin1.getId());
            treningDTOS1.add(treningDTO);
        }

        return new ResponseEntity<>(treningDTOS1, HttpStatus.OK);
    }








}
