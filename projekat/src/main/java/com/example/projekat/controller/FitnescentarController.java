package com.example.projekat.controller;

import com.example.projekat.entity.Fitnesscentar;
import com.example.projekat.entity.FitnesscentarDTO;
import com.example.projekat.entity.Trener;
import com.example.projekat.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Fitnesscentar> dodajfitnescentar(@RequestBody Fitnesscentar fitnescentar,@RequestParam(value = "uloga")  String uloga) throws Exception {

        Fitnesscentar novifitnescentar = korisnikService.create(fitnescentar, uloga);


        return new ResponseEntity<>(novifitnescentar, HttpStatus.CREATED);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Fitnesscentar>> nadjifitnescentar1(){

        List<Fitnesscentar> svifitnescentri  = this.korisnikService.findFitnescentar();



        return new ResponseEntity<>(svifitnescentri, HttpStatus.CREATED);

    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/svi")
    public ResponseEntity<List<Fitnesscentar>> nadjifitnescentar2(@RequestParam(value = "uloga")  String uloga) throws Exception{

        List<Fitnesscentar> svifitnescentri  = this.korisnikService.svifitnescentri(uloga);



        return new ResponseEntity<>(svifitnescentri, HttpStatus.CREATED);

    }



    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/jedan")
    public ResponseEntity<FitnesscentarDTO> nadjifitnescentar3(@RequestParam(value = "fitnescentar")  Long fitnescentar,@RequestParam(value = "uloga")  String uloga) throws Exception{

        Fitnesscentar fitnescentar1  = this.korisnikService.nadjifitnescentar(fitnescentar, uloga);
        FitnesscentarDTO fitnesscentarDTO = new FitnesscentarDTO(fitnescentar1.getNaziv(),fitnescentar1.getAdresa(),fitnescentar1.getBrojtelefonacentrale(),fitnescentar1.getEmail());


        return new ResponseEntity<>(fitnesscentarDTO, HttpStatus.CREATED);

    }





}
