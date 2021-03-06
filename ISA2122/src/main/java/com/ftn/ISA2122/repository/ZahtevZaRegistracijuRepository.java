package com.ftn.ISA2122.repository;

import com.ftn.ISA2122.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ZahtevZaRegistracijuRepository extends JpaRepository<ZahtevZaRegistraciju, Long> {

    List<ZahtevZaRegistraciju> findAllByObrazlozenjeNotNull();

    ZahtevZaRegistraciju findByKorisnik(Korisnik k);
}
