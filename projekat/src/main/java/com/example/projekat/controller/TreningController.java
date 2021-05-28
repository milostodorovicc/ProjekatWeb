package com.example.projekat.controller;


import com.example.projekat.entity.Fitnesscentar;
import com.example.projekat.entity.Termin;
import com.example.projekat.entity.Trening;
import com.example.projekat.entity.TreningDTO;
import com.example.projekat.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/treninzi")
public class TreningController {

    private final KorisnikService korisnikService;

    @Autowired
    public TreningController(KorisnikService korisnikService) {
        this.korisnikService = korisnikService;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDTO>> getTreninzi() {

        List<Termin> terminlist = this.korisnikService.findTermini();


        List<TreningDTO> treningDTOS = new ArrayList<>();

        for (Termin termin : terminlist) {


            TreningDTO treningDTO = new TreningDTO(termin.getDatum(), termin.getCena(),
                    termin.getBrojprijavljenihclanova(),termin.getFitnesscentar().getNaziv(), termin.getSala().getOznaka(),termin.getTrener().getIme(),termin.getTrener().getPrezime(),
            termin.getTrening().getNaziv(),termin.getTrening().getOpis(),termin.getTrening().getTip(),termin.getTrening().getTrajanje());
            treningDTOS.add(treningDTO);
        }


        return new ResponseEntity<>(treningDTOS, HttpStatus.OK);
    }





}
