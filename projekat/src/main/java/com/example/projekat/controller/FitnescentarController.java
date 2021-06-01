package com.example.projekat.controller;

import com.example.projekat.entity.Fitnesscentar;
import com.example.projekat.entity.Trener;
import com.example.projekat.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/fitnescentar")
public class FitnescentarController {

    private final KorisnikService korisnikService;

    @Autowired
    public FitnescentarController(KorisnikService korisnikService) {
        this.korisnikService = korisnikService;
    }





    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Fitnesscentar> dodajfitnescentar(@RequestBody Fitnesscentar fitnescentar) throws Exception {

        Fitnesscentar novifitnescentar = korisnikService.create(fitnescentar);


        return new ResponseEntity<>(novifitnescentar, HttpStatus.CREATED);
    }







}
