package com.ftn.ISA2122.repository;

import com.ftn.ISA2122.model.Korisnik;
import com.ftn.ISA2122.model.Vikendica;
import com.ftn.ISA2122.model.VlasnikVikendice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VlasnikVikendiceRepository extends JpaRepository<VlasnikVikendice, Long> {

    VlasnikVikendice findByVikendiceContains(Vikendica vikendica);
}
