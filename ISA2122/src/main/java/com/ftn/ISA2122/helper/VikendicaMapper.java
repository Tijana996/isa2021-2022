package com.ftn.ISA2122.helper;

import com.ftn.ISA2122.dto.VikendicaDTO;
import com.ftn.ISA2122.model.Slike;
import com.ftn.ISA2122.model.Vikendica;

public class VikendicaMapper implements MapperInterface<Vikendica, VikendicaDTO> {

    @Override
    public Vikendica toEntity(VikendicaDTO dto) {
        return new Vikendica( dto.getId(),  dto.getNaziv(),  dto.getOpis(),  dto.getSlike(),  dto.getSobe(),  dto.getSobe(),  dto.getPravila(),  dto.getCenovnik(),  dto.getMaxosoba(), dto.getAdresa(), dto.getOcena());
    }

    @Override
    public VikendicaDTO toDto(Vikendica entity) {
        return new VikendicaDTO(entity.getId(), entity.getNaziv(), entity.getOpis(), entity.getSlike(), entity.getSobe(), entity.getSobe(), entity.getPravila(), entity.getCenovnik(), entity.getMaxosoba(), entity.getAdresa(), entity.getOcena());
    }
}
