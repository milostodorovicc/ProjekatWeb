package com.example.projekat.service.impl;

import com.example.projekat.entity.Administrator;
import com.example.projekat.entity.Clanfitnescentra;
import com.example.projekat.entity.Termin;
import com.example.projekat.entity.Trener;
import com.example.projekat.repository.AdministratorRepository;
import com.example.projekat.repository.ClanfitnescentraRepository;
import com.example.projekat.repository.TerminRepository;
import com.example.projekat.repository.TrenerRepository;
import com.example.projekat.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class KorisnikServiceImpl implements KorisnikService {

    private final ClanfitnescentraRepository clanfitnescentraRepository;
    private final TrenerRepository trenerRepository;
    private final AdministratorRepository administratorRepository;
    private final TerminRepository terminRepository;


    @Autowired
    public KorisnikServiceImpl(ClanfitnescentraRepository clanfitnescentraRepository, TrenerRepository trenerRepository, AdministratorRepository administratorRepository, TerminRepository terminRepository) {
        this.clanfitnescentraRepository = clanfitnescentraRepository;
        this.trenerRepository = trenerRepository;
        this.administratorRepository = administratorRepository;
        this.terminRepository = terminRepository;
    }

    @Override
    public Clanfitnescentra create(Clanfitnescentra clanfitnescentra) throws Exception {
        if (clanfitnescentra.getId() != null) {
            throw new Exception("ID must be null!");
        }
        Clanfitnescentra noviclanfitnescentra = this.clanfitnescentraRepository.save(clanfitnescentra);
        return noviclanfitnescentra;
    }


    public Trener create(Trener trener) throws Exception{
        if(trener.getId()!= null){
            throw new Exception("ID must be null!");
        }
        Trener novitrener = this.trenerRepository.save(trener);
        return novitrener;
    }



    @Override
    public List<Trener> findAll() {
        List<Trener> treneri = this.trenerRepository.findByAktivan(false);
        return treneri;
    }



    @Override
    public Trener findOne(Long id) {
        Trener trener = this.trenerRepository.getOne(id);
        return trener;
    }

    @Override
    public Trener findByKorisnickoimeAndLozinka( String korisnickoime, String lozinka){
        Trener trener = this.trenerRepository.findByKorisnickoimeAndLozinka(korisnickoime, lozinka);
        return trener;
    }

    @Override
    public Clanfitnescentra findByKorisnickoimeAndLozinka1(String korisnickoime, String lozinka){
        Clanfitnescentra clanfitnescentra = this.clanfitnescentraRepository.findByKorisnickoimeAndLozinka(korisnickoime, lozinka);
         return clanfitnescentra;
    }

    @Override
    public Administrator findByKorisnickoimeAndLozinka2(String korisnickoime, String lozinka){
        Administrator administrator = this.administratorRepository.findByKorisnickoimeAndLozinka(korisnickoime, lozinka);
        return administrator;
    }

     @Override
    public Trener update(Trener trener) {
         Trener novitrener = this.trenerRepository.getOne(trener.getId());

         novitrener.setAktivan(true);


         Trener novitrener1 = this.trenerRepository.save(novitrener);
         return novitrener1;


     }


    public List<Termin> findTermini() {
        Date datum = new Date();
        List<Termin> termini = this.terminRepository.findByDatumAfter(datum);
        return termini;
    }


}
