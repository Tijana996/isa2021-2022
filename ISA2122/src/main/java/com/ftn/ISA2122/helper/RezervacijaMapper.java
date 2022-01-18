package com.ftn.ISA2122.helper;

import com.ftn.ISA2122.dto.RezervacijaDTO;
import com.ftn.ISA2122.model.Rezervacija;
import org.springframework.beans.factory.annotation.Autowired;

public class RezervacijaMapper implements MapperInterface<Rezervacija, RezervacijaDTO>{

    @Autowired
    UserRegMapper user;

    public RezervacijaMapper(){
        user = new UserRegMapper();
    }

    @Override
    public Rezervacija toEntity(RezervacijaDTO dto) {
        return new Rezervacija(dto.getStart(), dto.getEnd(), dto.getBrdana(), dto.getBrgostiju());

    }

    @Override
    public RezervacijaDTO toDto(Rezervacija entity) {
        if(entity.getKlijenti()==null)
            return new RezervacijaDTO(entity.getId(), entity.getStart(), entity.getEnd(), entity.getBrdana(), entity.getBrgostiju(), null, entity.getVikendice().getId());
        return new RezervacijaDTO(entity.getId(), entity.getStart(), entity.getEnd(), entity.getBrdana(), entity.getBrgostiju(), entity.getKlijenti().getId(), entity.getVikendice().getId());
    }
}
