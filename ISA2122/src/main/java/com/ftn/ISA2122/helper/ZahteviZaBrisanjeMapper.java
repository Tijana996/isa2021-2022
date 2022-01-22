package com.ftn.ISA2122.helper;

import com.ftn.ISA2122.dto.ZahteviZaBrisanjeDTO;
import com.ftn.ISA2122.model.ZahteviZaBrisanje;

public class ZahteviZaBrisanjeMapper implements MapperInterface<ZahteviZaBrisanje, ZahteviZaBrisanjeDTO> {
    @Override
    public ZahteviZaBrisanje toEntity(ZahteviZaBrisanjeDTO dto) {
        return null;
    }

    @Override
    public ZahteviZaBrisanjeDTO toDto(ZahteviZaBrisanje entity) {
        return new ZahteviZaBrisanjeDTO(entity.getId(), entity.getKlijent(), entity.getEmail());
    }
}
