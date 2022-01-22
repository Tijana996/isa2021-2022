package com.ftn.ISA2122.service;

import com.ftn.ISA2122.model.*;
import com.ftn.ISA2122.repository.*;
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

    @Autowired
    BrodRepository brodRepository;

    @Autowired
    InstruktorPecanjaRepository instruktorPecanjaRepository;

    @Override
    public List<Rezervacija> findAll() {
        return rezervacijaRepository.findAll();
    }

    @Override
    public Rezervacija findOne(Long id) {
        return rezervacijaRepository.findById(id).orElse(null);
    }

    @Override
    public Rezervacija create(Rezervacija entity) throws Exception {
        Klijent k = entity.getKlijenti();
        Set<Rezervacija> r1 = k.getRezervacije();
        r1.add(entity);
        k.setRezervacije(r1);
        if(entity.getVikendice()!=null)
        {
            Vikendica v = entity.getVikendice();
            Set<Rezervacija> r2 = v.getRezervacije();
            r2.add(entity);
            v.setRezervacije(r2);
            vikendicaRepository.save(v);
        }
        if(entity.getBrodovi()!=null)
        {
            Brod v = entity.getBrodovi();
            Set<Rezervacija> r2 = v.getRezervacije();
            r2.add(entity);
            v.setRezervacije(r2);
            brodRepository.save(v);
        }
        if(entity.getInstruktori()!=null)
        {
            InstruktorPecanja v = entity.getInstruktori();
            Set<Rezervacija> r2 = v.getRezervacije();
            r2.add(entity);
            v.setRezervacije(r2);
            instruktorPecanjaRepository.save(v);
        }
        korisnikRepository.save(k);
        return rezervacijaRepository.save(entity);
    }

    @Override
    public Rezervacija update(Rezervacija entity, Long id) throws Exception {
        Klijent k = (Klijent) korisnikRepository.findById(entity.getKlijenti().getId()).orElse(null);
        Set<Rezervacija> rezervacije = k.getRezervacije();
        rezervacije.add(entity);
        k.setRezervacije(rezervacije);
        korisnikRepository.save(k);
        return rezervacijaRepository.save(entity);
    }

    @Override
    public void delete(Long id) throws Exception {
        Rezervacija entity = rezervacijaRepository.findById(id).orElse(null);
        if(entity == null) return;
        Klijent k = (Klijent) korisnikRepository.findById(entity.getKlijenti().getId()).orElse(null);
        Set<Rezervacija> rezervacije = k.getRezervacije();
        rezervacije.remove(entity);
        k.setRezervacije(rezervacije);
        korisnikRepository.save(k);
        rezervacijaRepository.delete(entity);
    }

}
