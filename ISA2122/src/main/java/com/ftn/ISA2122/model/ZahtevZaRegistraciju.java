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

    @Column(name="obrazlozenje", unique=false, nullable=false)
    private String obrazlozenje;

    @OneToOne(targetEntity = Korisnik.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = true, name = "korisnik_id")
    private Korisnik korisnik;

    public ZahtevZaRegistraciju(){}

    public ZahtevZaRegistraciju(Long id, Korisnik korisnik) {
        this.id = id;
        this.korisnik = korisnik;
    }

    public ZahtevZaRegistraciju(Long id, String obrazlozenje, Korisnik korisnik) {
        this.id = id;
        this.obrazlozenje = obrazlozenje;
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

    public String getObrazlozenje() {
        return obrazlozenje;
    }

    public void setObrazlozenje(String obrazlozenje) {
        this.obrazlozenje = obrazlozenje;
    }
}
