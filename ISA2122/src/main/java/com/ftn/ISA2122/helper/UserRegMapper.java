package com.ftn.ISA2122.helper;

import com.ftn.ISA2122.dto.UserDTO;
import com.ftn.ISA2122.model.*;

public class UserRegMapper implements MapperInterface<Klijent, UserDTO> {
    @Override
    public Klijent toEntity(UserDTO dto) {
        //email, lozinka, ime, prezime, adresa, grad, drzava, broj, poeni, kategorija, penali, obrazlozenje, enabled
        return new Klijent(dto.getEmail(), dto.getPassword(), dto.getIme(), dto.getPrezime(), dto.getAdresa(), dto.getGrad(), dto.getDrzava(), dto.getBroj(), 0, 0, 0, true);

    }

    @Override
    public UserDTO toDto(Klijent entity) {
        return new UserDTO(entity);
    }
}
