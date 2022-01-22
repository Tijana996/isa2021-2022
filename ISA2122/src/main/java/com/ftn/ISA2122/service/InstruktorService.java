package com.ftn.ISA2122.service;

import com.ftn.ISA2122.controller.InstruktorPecanjaContoller;
import com.ftn.ISA2122.model.Brod;
import com.ftn.ISA2122.model.InstruktorPecanja;
import com.ftn.ISA2122.model.Rezervacija;
import com.ftn.ISA2122.repository.InstruktorPecanjaRepository;
import com.ftn.ISA2122.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class InstruktorService implements ServiceInterface<InstruktorPecanja>{

    @Autowired
    InstruktorPecanjaRepository instruktorPecanjaRepository;

    @Autowired
    KorisnikRepository korisnikRepository;

    @Override
    public List<InstruktorPecanja> findAll() {
        return instruktorPecanjaRepository.findAll();
    }

    @Override
    public InstruktorPecanja findOne(Long id) {
        return (InstruktorPecanja) korisnikRepository.findById(id).orElse(null);
    }

    @Override
    public InstruktorPecanja create(InstruktorPecanja entity) throws Exception {
        return null;
    }

    @Override
    public InstruktorPecanja update(InstruktorPecanja entity, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {

    }

    public List<InstruktorPecanja> search(String datumod, String datumdo, String lokacija, int ocena) throws ParseException {
        List<InstruktorPecanja> searched = new ArrayList<InstruktorPecanja>();
        List<InstruktorPecanja> instruktori = instruktorPecanjaRepository.findAll();
        for(InstruktorPecanja v : instruktori){
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
