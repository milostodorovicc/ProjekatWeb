package com.example.projekat.service.impl;

import com.example.projekat.entity.Clanfitnescentra;
import com.example.projekat.entity.Trener;
import com.example.projekat.repository.ClanfitnescentraRepository;
import com.example.projekat.repository.TrenerRepository;
import com.example.projekat.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KorisnikServiceImpl implements KorisnikService {

    private final ClanfitnescentraRepository clanfitnescentraRepository;
    private final TrenerRepository trenerRepository;


    @Autowired
    public KorisnikServiceImpl(ClanfitnescentraRepository clanfitnescentraRepository, TrenerRepository trenerRepository) {
        this.clanfitnescentraRepository = clanfitnescentraRepository;
        this.trenerRepository = trenerRepository;
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



}
