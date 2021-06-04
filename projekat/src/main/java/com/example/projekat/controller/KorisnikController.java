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





}
