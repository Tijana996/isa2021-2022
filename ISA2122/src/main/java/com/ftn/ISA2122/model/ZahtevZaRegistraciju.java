package com.ftn.ISA2122.model;

import javax.persistence.*;

@Entity
@Table(name="zahtevi")
public class ZahtevZaRegistraciju {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "zahtevi_generator")
    @SequenceGenerator(name="zahtevi_generator",initialValue = 1 ,sequenceName = "zahtevi_seq")
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @OneToOne(targetEntity = Korisnik.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = true, name = "korisnik_id")
    private Korisnik korisnik;

    public ZahtevZaRegistraciju(){}

    public ZahtevZaRegistraciju(Long id, Korisnik korisnik) {
        this.id = id;
        this.korisnik = korisnik;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
}
