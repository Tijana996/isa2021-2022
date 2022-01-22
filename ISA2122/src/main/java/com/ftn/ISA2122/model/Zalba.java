package com.ftn.ISA2122.model;

import javax.persistence.*;

import static javax.persistence.InheritanceType.SINGLE_TABLE;

@Entity
@Table(name="zalba")
@SequenceGenerator(name="zalba_generator" ,sequenceName = "zalba_seq")
public class Zalba {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "zalba_generator")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name="tekst", nullable=false)
    private String tekst;

    @Column(name="odgovor", nullable=true)
    private String odgovor;

    @Column(name="tip", nullable=false)
    private TipZalbe tip;

    @OneToOne(targetEntity = Rezervacija.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = true, name = "rezervacija_id")
    private Rezervacija rezervacija;

    @OneToOne(targetEntity = Klijent.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = true, name = "klijent_id")
    private Klijent klijent;

    @Column(name="resena", nullable=false)
    private boolean resena;

    public Zalba(String tekst, String odgovor, TipZalbe tip, Rezervacija rezervacija, Klijent klijent, boolean resena) {
        this.tekst = tekst;
        this.odgovor = odgovor;
        this.tip = tip;
        this.rezervacija = rezervacija;
        this.klijent = klijent;
        this.resena = resena;
    }

    public Zalba(Long id, String tekst, String odgovor, TipZalbe tip) {
        this.id = id;
        this.tekst = tekst;
        this.odgovor = odgovor;
        this.tip = tip;
    }

    public Zalba() {

    }

    public Long getId() {
        return id;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public TipZalbe getTip() {
        return tip;
    }

    public void setTip(TipZalbe tip) {
        this.tip = tip;
    }

    public Rezervacija getRezervacija() {
        return rezervacija;
    }

    public void setRezervacija(Rezervacija rezervacija) {
        this.rezervacija = rezervacija;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public boolean isResena() {
        return resena;
    }

    public void setResena(boolean resena) {
        this.resena = resena;
    }

    public String getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(String odgovor) {
        this.odgovor = odgovor;
    }
}
