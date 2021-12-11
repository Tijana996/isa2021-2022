package com.ftn.ISA2122.helper;

import com.ftn.ISA2122.dto.UserDTO;
import com.ftn.ISA2122.model.Korisnik;

public class UserRegMapper implements MapperInterface<Korisnik, UserDTO>{
    @Override
    public Korisnik toEntity(UserDTO dto) {
        return new Korisnik(dto.getEmail(), dto.getPassword());
    }

    @Override
    public UserDTO toDto(Korisnik entity) {
        return new UserDTO(entity.getEmail(), null);
    }
}
