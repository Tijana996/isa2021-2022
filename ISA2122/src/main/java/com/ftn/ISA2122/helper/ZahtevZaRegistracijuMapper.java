package com.ftn.ISA2122.helper;

import com.ftn.ISA2122.dto.ZahtevZaRegistracijuDTO;
import com.ftn.ISA2122.model.ZahtevZaRegistraciju;

public class ZahtevZaRegistracijuMapper implements MapperInterface<ZahtevZaRegistraciju, ZahtevZaRegistracijuDTO>{
    @Override
    public ZahtevZaRegistraciju toEntity(ZahtevZaRegistracijuDTO dto) {
        return null;
    }

    @Override
    public ZahtevZaRegistracijuDTO toDto(ZahtevZaRegistraciju entity) {
        return new ZahtevZaRegistracijuDTO(entity.getKorisnik(), entity.getObrazlozenje());
    }
}
