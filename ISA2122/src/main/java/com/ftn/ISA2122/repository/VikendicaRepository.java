package com.ftn.ISA2122.repository;

import com.ftn.ISA2122.model.Vikendica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VikendicaRepository extends JpaRepository<Vikendica, Long> {
}
