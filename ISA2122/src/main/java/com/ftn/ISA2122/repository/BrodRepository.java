package com.ftn.ISA2122.repository;

import com.ftn.ISA2122.model.Brod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrodRepository extends JpaRepository<Brod, Long> {
}
