package com.ftn.ISA2122.helper;

import com.ftn.ISA2122.dto.RezervacijaDTO;
import com.ftn.ISA2122.dto.VikendicaDTO;
import com.ftn.ISA2122.model.Rezervacija;
import com.ftn.ISA2122.model.Slike;
import com.ftn.ISA2122.model.Vikendica;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VikendicaMapper implements MapperInterface<Vikendica, VikendicaDTO> {

    @Autowired
    RezervacijaMapper rezervacijaMapper;

    public VikendicaMapper(){
        rezervacijaMapper = new RezervacijaMapper();
    }

    @Override
    public Vikendica toEntity(VikendicaDTO dto) {
        return new Vikendica( dto.getId(),  dto.getNaziv(),  dto.getOpis(),  new HashSet<>(),  dto.getSobe(),  dto.getSobe(),  dto.getPravila(),  dto.getCenovnik(),  dto.getMaxosoba(), dto.getAdresa(), dto.getOcena());
    }

    @Override
    public VikendicaDTO toDto(Vikendica entity) {
        Set<RezervacijaDTO> rezervacijaDTOList = new HashSet<>();
        for(Rezervacija r: entity.getRezervacije())
            rezervacijaDTOList.add(rezervacijaMapper.toDto(r));
        Set<String> slike = new HashSet<>();
        for(Slike s:entity.getSlike())
            slike.add(s.getBase64());
        return new VikendicaDTO(entity.getId(), entity.getNaziv(), entity.getOpis(), slike, entity.getSobe(), entity.getKreveti(), entity.getPravila(), entity.getCenovnik(), entity.getMaxosoba(), entity.getAdresa(), entity.getOcena(), rezervacijaDTOList);
    }
}
