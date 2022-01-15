package com.ftn.ISA2122.repository;

import com.ftn.ISA2122.model.Admin;
import com.ftn.ISA2122.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
