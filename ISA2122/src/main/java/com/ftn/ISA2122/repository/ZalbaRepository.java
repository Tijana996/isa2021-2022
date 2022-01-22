package com.ftn.ISA2122.repository;

import com.ftn.ISA2122.model.Zalba;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ZalbaRepository extends JpaRepository<Zalba, Long> {

    List<Zalba> findAllByResenaIsFalse();
}
