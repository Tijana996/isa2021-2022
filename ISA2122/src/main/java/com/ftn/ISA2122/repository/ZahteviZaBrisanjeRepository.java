package com.ftn.ISA2122.repository;

import com.ftn.ISA2122.model.ZahteviZaBrisanje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZahteviZaBrisanjeRepository extends JpaRepository<ZahteviZaBrisanje, Long> {
}
