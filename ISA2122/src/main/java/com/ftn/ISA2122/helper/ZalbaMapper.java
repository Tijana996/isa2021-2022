package com.ftn.ISA2122.helper;

import com.ftn.ISA2122.dto.ZalbaDTO;
import com.ftn.ISA2122.model.Korisnik;
import com.ftn.ISA2122.model.Zalba;

public class ZalbaMapper implements MapperInterface<Zalba, ZalbaDTO>{
    @Override
    public Zalba toEntity(ZalbaDTO dto) {
        return new Zalba(dto.getId(), dto.getTekst(), dto.getOdgovor(), dto.getTip());
    }

    @Override
    public ZalbaDTO toDto(Zalba entity) {
        return null;
    }


    public ZalbaDTO toDtoZalba(Zalba entity, Korisnik korisnik) {
        return new ZalbaDTO(entity.getId(), entity.getTekst(), entity.getRezervacija().getId(), entity.getTip(), entity.getKlijent().getIme(),
        entity.getKlijent().getPrezime(), entity.getKlijent().getEmail(), korisnik.getIme(), korisnik.getPrezime(), korisnik.getEmail());
    }
}
