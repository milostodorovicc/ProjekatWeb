package com.example.projekat.controller;

import com.example.projekat.entity.*;
import com.example.projekat.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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
    public ResponseEntity<FitnesscentarDTO> nadjifitnescentar3(@RequestParam(value = "fitnescentar")  String fitnescentar,@RequestParam(value = "uloga")  String uloga) throws Exception{

        Fitnesscentar fitnescentar1  = this.korisnikService.nadjifitnescentar(fitnescentar, uloga);
        FitnesscentarDTO fitnesscentarDTO = new FitnesscentarDTO(fitnescentar1.getNaziv(),fitnescentar1.getAdresa(),fitnescentar1.getBrojtelefonacentrale(),fitnescentar1.getEmail());


        return new ResponseEntity<>(fitnesscentarDTO, HttpStatus.CREATED);

    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/izbrisi")
    public ResponseEntity<FitnesscentarDTO> izbrisifitnescentar(@RequestParam(value = "fitnescentar")  String fitnescentar,@RequestParam(value = "uloga")  String uloga) throws Exception{

        Fitnesscentar fitnescentar1  = this.korisnikService.izbrisifitnescentar(fitnescentar, uloga);
        FitnesscentarDTO fitnesscentarDTO = new FitnesscentarDTO(fitnescentar1.getNaziv(),fitnescentar1.getAdresa(),fitnescentar1.getBrojtelefonacentrale(),fitnescentar1.getEmail());


        return new ResponseEntity<>(fitnesscentarDTO, HttpStatus.CREATED);

    }




    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE, value = "/izmenifitnescentar")
    public ResponseEntity<Fitnesscentar> izmenifitnescentar(@RequestBody Fitnesscentar fitnescentar1,@RequestParam(value = "fitnescentar")  String fitnescentar,@RequestParam(value = "uloga")  String uloga) throws Exception {

        Fitnesscentar novifitnescentar = this.korisnikService.izmenifitnescentar(fitnescentar1, fitnescentar, uloga);


        return new ResponseEntity<>(novifitnescentar, HttpStatus.CREATED);
    }






    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE, value = "/novasala")
    public ResponseEntity<Sala> dodajnovusalu(@RequestBody Sala sala, @RequestParam(value = "fitnescentar1")  String fitnescentar1, @RequestParam(value = "uloga")  String uloga) throws Exception {

        Sala novasala = this.korisnikService.dodajnovusalu(sala, fitnescentar1, uloga);


        return new ResponseEntity<>(novasala, HttpStatus.CREATED);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/svesale")
    public ResponseEntity<Set<Sala>> nadjisvesale(@RequestParam(value = "fitnescentar")  String fitnescentar, @RequestParam(value = "uloga")  String uloga) throws Exception{



        Set<Sala> svesale1  = this.korisnikService.svesale(fitnescentar, uloga);



        return new ResponseEntity<>(svesale1, HttpStatus.CREATED);

    }



    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/jednasala")
    public ResponseEntity<SalaDTO> nadjijednusalu(@RequestParam(value = "sala")  String sala, @RequestParam(value = "uloga")  String uloga) throws Exception{

        Sala sala1 = this.korisnikService.jednasala(sala, uloga);

        SalaDTO salaDTO = new SalaDTO(sala1.getKapacitet(), sala1.getOznaka());



        return new ResponseEntity<>(salaDTO, HttpStatus.CREATED);

    }



    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE, value = "/izmenisalu")
    public ResponseEntity<Sala> izmenisalu(@RequestBody Sala sala, @RequestParam(value = "sala1")  String sala1,@RequestParam(value = "uloga")  String uloga) throws Exception {

        Sala sala2 = this.korisnikService.izmenisalu(sala, sala1, uloga);


        return new ResponseEntity<>(sala2, HttpStatus.CREATED);
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE, value = "/izbrisisalu")
    public ResponseEntity<Sala> izbrisisalu( @RequestParam(value = "sala1")  String sala1,@RequestParam(value = "uloga")  String uloga) throws Exception {

        Sala sala2 = this.korisnikService.izbrisisalu( sala1, uloga);


        return new ResponseEntity<>(sala2, HttpStatus.CREATED);
    }






    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/nadjisale1")
    public ResponseEntity<Set<Sala>> izbrisifitnescentar(@RequestParam(value = "korisnik")  Long korisnik,@RequestParam(value = "uloga")  String uloga) throws Exception{

        Set<Sala> salefitnescentra = this.korisnikService.nadjisale(korisnik, uloga);


        return new ResponseEntity<>(salefitnescentra, HttpStatus.CREATED);

    }





}
