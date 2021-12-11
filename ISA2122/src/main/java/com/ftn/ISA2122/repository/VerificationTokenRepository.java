package com.ftn.ISA2122.repository;

import com.ftn.ISA2122.model.VerificationToken;
import com.ftn.ISA2122.model.VerificationTokenType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    VerificationToken findByTokenAndType(String token, VerificationTokenType type);

}
