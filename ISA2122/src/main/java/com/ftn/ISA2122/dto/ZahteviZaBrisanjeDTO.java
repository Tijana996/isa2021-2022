package com.ftn.ISA2122.dto;

import com.ftn.ISA2122.model.Klijent;
import com.ftn.ISA2122.model.ZahteviZaBrisanje;

import javax.persistence.OneToOne;

public class ZahteviZaBrisanjeDTO {
    private Long id;
    private Long klijent;
    private String email;

    public ZahteviZaBrisanjeDTO(){}

    public ZahteviZaBrisanjeDTO(Long id, Long klijent, String email) {
        this.id = id;
        this.klijent = klijent;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getKlijent() {
        return klijent;
    }

    public void setKlijent(Long klijent) {
        this.klijent = klijent;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
