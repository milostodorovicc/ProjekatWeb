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
            termin.getTrening().getNaziv(),termin.getTrening().getOpis(),termin.getTrening().getTip(),termin.getTrening().getTrajanje(), termin.getId());
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
                  termin.getTrening().getNaziv(),termin.getTrening().getOpis(),termin.getTrening().getTip(),termin.getTrening().getTrajanje(), termin.getId());
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
                    termin.getTrening().getNaziv(),termin.getTrening().getOpis(),termin.getTrening().getTip(),termin.getTrening().getTrajanje(), termin.getId());
            treningDTOS.add(treningDTO);
        }


        return new ResponseEntity<>(treningDTOS, HttpStatus.OK);
    }







}
