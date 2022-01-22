package com.ftn.ISA2122.helper;

import com.ftn.ISA2122.dto.InstruktorPecanjaDTO;
import com.ftn.ISA2122.dto.RezervacijaDTO;
import com.ftn.ISA2122.model.InstruktorPecanja;
import com.ftn.ISA2122.model.Rezervacija;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class InstruktorMapper implements MapperInterface<InstruktorPecanja, InstruktorPecanjaDTO>{

    @Autowired
    RezervacijaMapper rezervacijaMapper;

    public InstruktorMapper(){
        rezervacijaMapper = new RezervacijaMapper();
    }

    @Override
    public InstruktorPecanja toEntity(InstruktorPecanjaDTO dto) {
        return null;
    }

    @Override
    public InstruktorPecanjaDTO toDto(InstruktorPecanja entity) {
        Set<RezervacijaDTO> rezervacijaDTOList = new HashSet<>();
        for(Rezervacija r: entity.getRezervacije())
            rezervacijaDTOList.add(rezervacijaMapper.toDto(r));
        //String ime, String prezime, String broj, String lokacija, int ocena, Set<RezervacijaDTO> rezervacije
        return new InstruktorPecanjaDTO(entity.getId(),entity.getIme(),entity.getPrezime(), entity.getBroj(), entity.getLokacija(), entity.getOcena(), rezervacijaDTOList);
    }
}
