package com.ftn.ISA2122.repository;

import com.ftn.ISA2122.model.Rezervacija;
import com.ftn.ISA2122.model.Vikendica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RezervacijaRepository extends JpaRepository<Rezervacija, Long> {

}
