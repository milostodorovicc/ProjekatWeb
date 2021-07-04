package com.example.projekat.controller;


import com.example.projekat.entity.*;
import com.example.projekat.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping(value = "/api/treninzi")
public class TreningController {

    private final KorisnikService korisnikService;

    @Autowired
    public TreningController(KorisnikService korisnikService) {
        this.korisnikService = korisnikService;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value= "/svitreninzi")
    public ResponseEntity<List<TreningDTO>> getTreninzi() {

        List<Termin> terminlist = this.korisnikService.findTermini();


        List<TreningDTO> treningDTOS = new ArrayList<>();

        for (Termin termin : terminlist) {


            TreningDTO treningDTO = new TreningDTO(termin.getDatum(), termin.getCena(),
                    termin.getBrojprijavljenihclanova(),termin.getFitnesscentar().getNaziv(), termin.getSala().getOznaka(),termin.getTrener().getIme(),termin.getTrener().getPrezime(),
            termin.getTrening().getNaziv(),termin.getTrening().getOpis(),termin.getTrening().getTip(),termin.getTrening().getTrajanje(), termin.getId(), termin.isAktivan() );
            treningDTOS.add(treningDTO);
        }


        return new ResponseEntity<>(treningDTOS, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDTO>> getTreninzi(@RequestParam(value = "naziv", required = false, defaultValue = "") String naziv,
                                                        @RequestParam(value = "tip", required = false, defaultValue = "") String tip,
                                                        @RequestParam(value = "opis", required = false, defaultValue = "") String opis,
                                                        @RequestParam(value = "cena", required = false, defaultValue = "50000") double cena,
                                                        @RequestParam(value = "vreme", required = false, defaultValue = "2021-07-01T13:00:00") String vreme) {

        LocalDateTime vremeTreninga = LocalDateTime.parse(vreme);

        List<Termin> novitermini = korisnikService.findTermini1( naziv, opis,  tip, vremeTreninga,  cena);
        List<TreningDTO> treningDTOS1 = new ArrayList<>();

      for (Termin termin : novitermini) {


          TreningDTO treningDTO = new TreningDTO(termin.getDatum(), termin.getCena(),
                  termin.getBrojprijavljenihclanova(),termin.getFitnesscentar().getNaziv(), termin.getSala().getOznaka(),termin.getTrener().getIme(),termin.getTrener().getPrezime(),
                  termin.getTrening().getNaziv(),termin.getTrening().getOpis(),termin.getTrening().getTip(),termin.getTrening().getTrajanje(), termin.getId(), termin.isAktivan());
          treningDTOS1.add(treningDTO);
       }

        return new ResponseEntity<>(treningDTOS1, HttpStatus.OK);


    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
    public ResponseEntity<List<TreningDTO>> sortiraj(@PathVariable("id") Long id) {

          List<Termin> terminlist = this.korisnikService.sortiraj( id);


        List<TreningDTO> treningDTOS = new ArrayList<>();

        for (Termin termin : terminlist) {


            TreningDTO treningDTO = new TreningDTO(termin.getDatum(), termin.getCena(),
                    termin.getBrojprijavljenihclanova(),termin.getFitnesscentar().getNaziv(), termin.getSala().getOznaka(),termin.getTrener().getIme(),termin.getTrener().getPrezime(),
                    termin.getTrening().getNaziv(),termin.getTrening().getOpis(),termin.getTrening().getTip(),termin.getTrening().getTrajanje(), termin.getId(), termin.isAktivan());
            treningDTOS.add(treningDTO);
        }


        return new ResponseEntity<>(treningDTOS, HttpStatus.OK);
    }



    @PostMapping (
            produces = MediaType.APPLICATION_JSON_VALUE, value ="/oceni")
    public ResponseEntity<Ocenjentrening> ocenitrening(@RequestParam(value = "uloga") String uloga,
                                                          @RequestParam(value = "korisnik")Long korisnik,
                                                          @RequestParam(value = "termin") String termin,
                                                          @RequestParam(value = "ocena") Double ocena) throws Exception {



        Ocenjentrening ocenjentrening = this.korisnikService.ocenitrening(uloga, korisnik, termin, ocena);






        return new ResponseEntity<>(ocenjentrening, HttpStatus.CREATED);
    }




    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/odabir")
    public ResponseEntity<TreningDTO> odabirtreninga(@RequestParam(value = "uloga" ) String uloga,
                                                        @RequestParam(value = "termin") String termin
                                                        ) throws Exception{

        Termin termin1 = this.korisnikService.odabirtermina(uloga, termin);




            TreningDTO treningDTO = new TreningDTO(termin1.getDatum(), termin1.getCena(),
                    termin1.getBrojprijavljenihclanova(),termin1.getFitnesscentar().getNaziv(), termin1.getSala().getOznaka(),termin1.getTrener().getIme(),termin1.getTrener().getPrezime(),
                    termin1.getTrening().getNaziv(),termin1.getTrening().getOpis(),termin1.getTrening().getTip(),termin1.getTrening().getTrajanje(), termin1.getId(), termin1.isAktivan());



        return new ResponseEntity<>(treningDTO, HttpStatus.OK);


    }






}
