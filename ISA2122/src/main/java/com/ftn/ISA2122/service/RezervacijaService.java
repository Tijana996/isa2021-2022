package com.ftn.ISA2122.service;

import com.ftn.ISA2122.model.Klijent;
import com.ftn.ISA2122.model.Rezervacija;
import com.ftn.ISA2122.model.Vikendica;
import com.ftn.ISA2122.repository.KorisnikRepository;
import com.ftn.ISA2122.repository.RezervacijaRepository;
import com.ftn.ISA2122.repository.VikendicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RezervacijaService implements ServiceInterface<Rezervacija>{

    @Autowired
    RezervacijaRepository rezervacijaRepository;

    @Autowired
    KorisnikRepository korisnikRepository;

    @Autowired
    VikendicaRepository vikendicaRepository;

    @Override
    public List<Rezervacija> findAll() {
        return rezervacijaRepository.findAll();
    }

    @Override
    public Rezervacija findOne(Long id) {
        return null;
    }

    @Override
    public Rezervacija create(Rezervacija entity) throws Exception {
        Klijent k = entity.getKlijenti();
        Vikendica v = entity.getVikendice();
        Set<Rezervacija> r1 = k.getRezervacije();
        r1.add(entity);
        k.setRezervacije(r1);
        Set<Rezervacija> r2 = v.getRezervacije();
        r2.add(entity);
        v.setRezervacije(r2);
        korisnikRepository.save(k);
        vikendicaRepository.save(v);
        return rezervacijaRepository.save(entity);
    }

    @Override
    public Rezervacija update(Rezervacija entity, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {

    }

}
