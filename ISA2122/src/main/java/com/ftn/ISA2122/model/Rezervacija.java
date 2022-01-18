package com.ftn.ISA2122.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.DiscriminatorType.STRING;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

@Entity
@Table(name="rezervacija")
@Inheritance(strategy=SINGLE_TABLE)
@SequenceGenerator(name="rezervacija_generator" ,sequenceName = "rezervacija_seq")
public class Rezervacija {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rezervacija_generator")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column
    private String start;

    @Column(name = "enddate")
    private String end;

    @Column
    private int brdana;

    @Column
    private int brgostiju;

    //@JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="korisnik_id", nullable=true)
    private Klijent klijenti;

    //@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="vikendica_id", nullable=true)
    private Vikendica vikendice;

    //@JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="brod_id", nullable=true)
    private Brod brodovi;

    //@JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="instruktor_id", nullable=true)
    private InstruktorPecanja instruktori;

    public Rezervacija(){}

    public Rezervacija(Long id, String start, String end, int brdana, int brgostiju, Klijent klijenti, Vikendica vikendice, Brod brodovi, InstruktorPecanja instruktori) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.brdana = brdana;
        this.brgostiju = brgostiju;
        this.klijenti = klijenti;
        this.vikendice = vikendice;
        this.brodovi = brodovi;
        this.instruktori = instruktori;
    }

    public Rezervacija(String start, String end, int brdana, int brgostiju) {
        this.start = start;
        this.end = end;
        this.brdana = brdana;
        this.brgostiju = brgostiju;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getBrdana() {
        return brdana;
    }

    public void setBrdana(int brdana) {
        this.brdana = brdana;
    }

    public int getBrgostiju() {
        return brgostiju;
    }

    public void setBrgostiju(int brgostiju) {
        this.brgostiju = brgostiju;
    }

    public Klijent getKlijenti() {
        return klijenti;
    }

    public void setKlijenti(Klijent klijenti) {
        this.klijenti = klijenti;
    }

    public Vikendica getVikendice() {
        return vikendice;
    }

    public void setVikendice(Vikendica vikendice) {
        this.vikendice = vikendice;
    }

    public Brod getBrodovi() {
        return brodovi;
    }

    public void setBrodovi(Brod brodovi) {
        this.brodovi = brodovi;
    }

    public InstruktorPecanja getInstruktori() {
        return instruktori;
    }

    public void setInstruktori(InstruktorPecanja instruktori) {
        this.instruktori = instruktori;
    }
}
