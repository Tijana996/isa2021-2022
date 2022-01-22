package com.ftn.ISA2122.service;

import com.ftn.ISA2122.model.Korisnik;
import com.ftn.ISA2122.model.Rezervacija;
import com.ftn.ISA2122.model.Vikendica;
import com.ftn.ISA2122.model.VlasnikVikendice;
import com.ftn.ISA2122.repository.KorisnikRepository;
import com.ftn.ISA2122.repository.RezervacijaRepository;
import com.ftn.ISA2122.repository.VikendicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class VikendicaService implements ServiceInterface<Vikendica> {
    @Autowired
    VikendicaRepository vikendicaRepository;

    @Autowired
    RezervacijaRepository rezervacijaRepository;

    @Autowired
    KorisnikRepository korisnikRepository;

    @Override
    public List<Vikendica> findAll() {
        return vikendicaRepository.findAll();
    }

    @Override
    public Vikendica findOne(Long id) {
        return vikendicaRepository.findById(id).orElse(null);
    }

    @Override
    public Vikendica create(Vikendica entity) throws Exception {
        return null;
    }

    @Override
    public Vikendica update(Vikendica entity, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {
        List<Korisnik> korisnici = korisnikRepository.findAll();
        List<Rezervacija> rezervacije = rezervacijaRepository.findAll();
        Vikendica vikendica = vikendicaRepository.findById(id).orElse(null);
        for(Rezervacija r: rezervacije)
        {
            if(r.getVikendice()!= null && r.getVikendice().getId() == id) return;
        }
        for(Korisnik k : korisnici)
        {
            if(k instanceof VlasnikVikendice)
            {
                VlasnikVikendice vv = (VlasnikVikendice) k;
                Set<Vikendica> vikendice = vv.getVikendice();
                vikendice.remove(vikendica);
                korisnikRepository.save(k);
            }
        }
        vikendicaRepository.delete(vikendica);
    }

    public List<Vikendica> search(String datumod, String datumdo, String lokacija, int ocena) throws ParseException {
        List<Vikendica> searched = new ArrayList<Vikendica>();
        List<Vikendica> vikendice = vikendicaRepository.findAll();
        for(Vikendica v : vikendice){
            boolean ind = true;
            for(Rezervacija r : v.getRezervacije()) {
                if (r.getVikendice().getId() != v.getId()) continue;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                if (!datumod.isEmpty()) {
                    Date datum1 = sdf.parse(datumod + " 23-59");
                    Date datum11 = sdf.parse(r.getStart());
                    Date datum22 = sdf.parse(r.getEnd());
                    if (datum1.after(datum11) && datum1.before(datum22))
                        ind = false;
                }
                if (!datumod.isEmpty() && !datumdo.isEmpty()) {
                    Date datum1 = sdf.parse(datumod + " 23-59");
                    Date datum11 = sdf.parse(r.getStart());
                    Date datum2 = sdf.parse(datumdo + " 23-59");
                    Date datum22 = sdf.parse(r.getEnd());
                    if (!((datum1.before(datum11) && datum2.before(datum11)) || (datum1.before(datum22) && datum2.before(datum22))))
                        ind = false;
                }
            }
            if(lokacija != null && !v.getAdresa().contains(lokacija))
                ind = false;
            if(ocena != 0 && v.getOcena()!=ocena)
                ind = false;

            if(ind) searched.add(v);
        }
        return searched;
    }
}
