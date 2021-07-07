package com.example.projekat.controller;


import com.example.projekat.entity.*;
import com.example.projekat.service.KorisnikService;
import jdk.nashorn.internal.ir.RuntimeNode;
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
    public ResponseEntity<List<TreningDTO>> getTermini() {

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







    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE, value= "/novitrening")
    public ResponseEntity<Trening> novitrening(@RequestBody Trening trening, @RequestParam(value = "uloga") String uloga) throws Exception {



        Trening trening1 = this.korisnikService.novitrening(trening, uloga);




        return new ResponseEntity<>(trening1, HttpStatus.OK);

    }



    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value= "/svitreninzi1")
    public ResponseEntity<List<Trening>> svitreninzi1( @RequestParam(value = "uloga") String uloga) throws Exception {



        List<Trening> svitreninzi = this.korisnikService.svitreninzi( uloga);




        return new ResponseEntity<>(svitreninzi, HttpStatus.OK);

    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE, value= "/novitermin1")
    public ResponseEntity<TreningDTO> novitrening(@RequestBody Termin termin, @RequestParam(value = "uloga") String uloga, @RequestParam(value = "trening") String trening, @RequestParam(value = "sala") String sala, @RequestParam(value = "korisnik") Long korisnik  ) throws Exception {



       Termin termin1 = this.korisnikService.novitermin(termin, uloga, trening, sala, korisnik);

        TreningDTO treningDTO = new TreningDTO(termin1.getDatum(), termin1.getCena(),
                termin1.getBrojprijavljenihclanova(),termin1.getFitnesscentar().getNaziv(), termin1.getSala().getOznaka(),termin1.getTrener().getIme(),termin1.getTrener().getPrezime(),
                termin1.getTrening().getNaziv(),termin1.getTrening().getOpis(),termin1.getTrening().getTip(),termin1.getTrening().getTrajanje(), termin1.getId(), termin1.isAktivan());



        return new ResponseEntity<>(treningDTO, HttpStatus.OK);

    }



    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value= "/nadjitrening")
    public ResponseEntity<Trening> nadjitrening( @RequestParam(value = "uloga") String uloga, @RequestParam(value = "trening") String trening) throws Exception {



       Trening trening1 = this.korisnikService.nadjitrening( uloga, trening);

       Trening trening2 = new Trening();
       trening2.setId(trening1.getId());
       trening2.setNaziv(trening1.getNaziv());
        trening2.setOpis(trening1.getOpis());
        trening2.setTip(trening1.getTip());
        trening2.setTrajanje(trening1.getTrajanje());




        return new ResponseEntity<>(trening2, HttpStatus.OK);

    }







    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE, value= "/izmenitrening")
    public ResponseEntity<Trening> izmenitrening(@RequestBody Trening trening1, @RequestParam(value = "uloga") String uloga, @RequestParam(value = "trening") String trening) throws Exception {



        Trening trening2 = this.korisnikService.izmenitrening(trening1, uloga, trening);




        return new ResponseEntity<>(trening2, HttpStatus.OK);

    }







    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value= "/nadjitermine")
    public ResponseEntity<List<TreningDTO>> nadjitermine( @RequestParam(value = "uloga") String uloga, @RequestParam(value = "korisnik") Long korisnik) throws Exception {



        Set<Termin> terminitrenera1 = this.korisnikService.terminitrenera(uloga, korisnik);

        List<TreningDTO> treningDTO1 = new ArrayList<>();

        for (Termin termin : terminitrenera1) {


            TreningDTO treningDTO = new TreningDTO(termin.getDatum(), termin.getCena(),
                    termin.getBrojprijavljenihclanova(),termin.getFitnesscentar().getNaziv(), termin.getSala().getOznaka(),termin.getTrener().getIme(),termin.getTrener().getPrezime(),
                    termin.getTrening().getNaziv(),termin.getTrening().getOpis(),termin.getTrening().getTip(),termin.getTrening().getTrajanje(), termin.getId(), termin.isAktivan());
            treningDTO1.add(treningDTO);
        }



        return new ResponseEntity<>(treningDTO1, HttpStatus.OK);

    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value= "/nadjitermin")
    public ResponseEntity<Termin> nadjitermin( @RequestParam(value = "uloga") String uloga, @RequestParam(value = "termin") String termin) throws Exception {





        Termin termin1 = this.korisnikService.nadjitermin(uloga, termin);

        Termin termin4 = new Termin();
        termin4.setDatum(termin1.getDatum());
        termin4.setCena(termin1.getCena());


        return new ResponseEntity<>(termin4, HttpStatus.OK);

    }



    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE, value= "/izmenitermin")
    public ResponseEntity<TreningDTO> izmenitermin(@RequestBody Termin termin1, @RequestParam(value = "uloga") String uloga, @RequestParam(value = "termin") String termin, @RequestParam(value = "sala") String sala) throws Exception {



        Termin izmenjenitermin = this.korisnikService.izmenitermin(termin1, uloga, termin, sala);
        TreningDTO treningDTO = new TreningDTO(izmenjenitermin.getDatum(), izmenjenitermin.getCena(),
                izmenjenitermin.getBrojprijavljenihclanova(),izmenjenitermin.getFitnesscentar().getNaziv(), izmenjenitermin.getSala().getOznaka(),izmenjenitermin.getTrener().getIme(),izmenjenitermin.getTrener().getPrezime(),
                izmenjenitermin.getTrening().getNaziv(),izmenjenitermin.getTrening().getOpis(),izmenjenitermin.getTrening().getTip(),izmenjenitermin.getTrening().getTrajanje(), izmenjenitermin.getId(), izmenjenitermin.isAktivan());




        return new ResponseEntity<>(treningDTO, HttpStatus.OK);

    }







}
