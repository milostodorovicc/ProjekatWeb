package com.example.projekat.controller;

import com.example.projekat.entity.*;
import com.example.projekat.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    public ResponseEntity<Trener> createEmployee(@RequestBody Trener trener) throws Exception {

        Trener novitrener = korisnikService.create(trener);


        return new ResponseEntity<>(novitrener, HttpStatus.CREATED);
    }



    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Trener>> getTreneri() {

        List<Trener> trenerList = this.korisnikService.findAll();


        return new ResponseEntity<>(trenerList, HttpStatus.OK);
    }



    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Trener> getEmployee(@PathVariable("id") Long id) {

        Trener trener = this.korisnikService.findOne(id);


        return new ResponseEntity<>(trener, HttpStatus.OK);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE, value= "/login")
    public ResponseEntity<LoginDTO> potvrdilogin(@RequestBody Trener trener) throws Exception {
        LoginDTO loginDTO = new LoginDTO();
       Trener trener1 =  this.korisnikService.findByKorisnickoimeAndLozinka(trener.getKorisnickoime(),trener.getLozinka());
       if(trener1!=null){

           loginDTO.setId(trener1.getId());
           loginDTO.setUloga(trener1.getUloga());
           loginDTO.setAktivan(trener1.isAktivan());

       }

       Clanfitnescentra clanfitnescentra1 = this.korisnikService.findByKorisnickoimeAndLozinka1(trener.getKorisnickoime(),trener.getLozinka());
       if(clanfitnescentra1!=null){
           loginDTO.setId(clanfitnescentra1.getId());
           loginDTO.setUloga(clanfitnescentra1.getUloga());
       }

       Administrator administrator1 = this.korisnikService.findByKorisnickoimeAndLozinka2(trener.getKorisnickoime(), trener.getLozinka());
       if(administrator1!=null){
           loginDTO.setId(administrator1.getId());
           loginDTO.setUloga(administrator1.getUloga());
       }


        return new ResponseEntity<>(loginDTO, HttpStatus.CREATED);
    }





}
