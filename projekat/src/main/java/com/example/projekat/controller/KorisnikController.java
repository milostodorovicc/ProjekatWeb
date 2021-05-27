package com.example.projekat.controller;

import com.example.projekat.entity.Clanfitnescentra;
import com.example.projekat.entity.Trener;
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
        // Pozivanjem metode servisa dobavljamo sve zaposlene
        List<Trener> trenerList = this.korisnikService.findAll();

        // Kreiramo listu DTO objekata koju ćemo vratiti u odgovoru na zahtev
//        List<EmployeeDTO> employeeDTOS = new ArrayList<>();

//        for (Employee employee : employeeList) {
//            // Kreiramo EmployeeDTO za svakog zaposlenog, kojeg je vratila metoda findAll()
//            // i ubacujemo ga u listu employeeDTOS
//            EmployeeDTO employeeDTO = new EmployeeDTO(employee.getId(), employee.getFirstName(),
//                    employee.getLastName(), employee.getPosition());
//            employeeDTOS.add(employeeDTO);
//        }

        // Vraćamo odgovor 200 OK, a kroz body odgovora šaljemo podatke o pronađenim zaposlenima
        return new ResponseEntity<>(trenerList, HttpStatus.OK);
    }













}
