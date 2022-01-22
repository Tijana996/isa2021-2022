package com.ftn.ISA2122.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "zahtevizabrisanje")
public class ZahteviZaBrisanje {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "zahtevizabrisanje_generator")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column
    private Long klijent;

    @Column
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ZahteviZaBrisanje(){}

    public ZahteviZaBrisanje(Long id, Long klijent) {
        this.id = id;
        this.klijent = klijent;
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
}
