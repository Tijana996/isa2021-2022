package com.ftn.ISA2122.helper;

import com.ftn.ISA2122.dto.BrodDTO;
import com.ftn.ISA2122.dto.RezervacijaDTO;
import com.ftn.ISA2122.model.Brod;
import com.ftn.ISA2122.model.Rezervacija;
import com.ftn.ISA2122.model.Slike;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class BrodMapper implements MapperInterface<Brod, BrodDTO>{

    @Autowired
    RezervacijaMapper rezervacijaMapper;

    public BrodMapper(){rezervacijaMapper = new RezervacijaMapper();}

    @Override
    public Brod toEntity(BrodDTO dto) {
        return new Brod();
    }

    @Override
    public BrodDTO toDto(Brod entity) {
        Set<RezervacijaDTO> rezervacijaDTOList = new HashSet<>();
        for(Rezervacija r: entity.getRezervacije())
            rezervacijaDTOList.add(rezervacijaMapper.toDto(r));
        Set<String> slike = new HashSet<>();
        for(Slike s:entity.getSlike())
            slike.add(s.getBase64());
        String usloviOtkaza = entity.getUsloviOtkaza() == 0 ? "besplatno":"zadrzava procenat";
        // id,  naziv,  opis, Set<> slike,  pravila,  cenovnik,  adresa,  tip,  duzina,  brojmotora,  snaga,  maxBrzina,  kapacitet,  oprema,  usloviOtkaza
        return new BrodDTO(entity.getId(), entity.getNaziv(), entity.getOpis(), slike, entity.getPravila(), entity.getCenovnik(), entity.getAdresa(), entity.getTip(), entity.getDuzina(), entity.getBrojmotora(), entity.getSnaga(), entity.getMaxBrzina(), entity.getKapacitet(), entity.getOprema(),usloviOtkaza, rezervacijaDTOList, entity.getOcena());
    }
}
