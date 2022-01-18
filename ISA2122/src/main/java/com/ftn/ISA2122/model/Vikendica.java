package com.ftn.ISA2122.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "vikendica")
public class Vikendica {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vikendica_generator")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column
    private String naziv;

    @Column
    private String opis;

    //@JsonIgnore
    @OneToMany(mappedBy="vikendica")
    private Set<Slike> slike;

    @Column
    private int sobe;

    @Column
    private int kreveti;

    @Column
    private String pravila;

    @Column
    private int cenovnik;

    @Column
    private int maxosoba;

    @Column
    private String adresa;

    @Column
    private int ocena;

    //@JsonIgnore
    @OneToMany(mappedBy="vikendice")
    private Set<Rezervacija> rezervacije;

    public Vikendica(){}

    public Vikendica(Long id, String naziv, String opis, Set<Slike> slike, int sobe, int kreveti, String pravila, int cenovnik, int maxosoba, String adresa, int ocena) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.slike = slike;
        this.sobe = sobe;
        this.kreveti = kreveti;
        this.pravila = pravila;
        this.cenovnik = cenovnik;
        this.maxosoba = maxosoba;
        this.adresa = adresa;
        this.ocena = ocena;
    }

    public Vikendica(String naziv, String opis, Set<Slike> slike, int sobe, int kreveti, String pravila, int cenovnik, int maxosoba, String adresa, int ocena) {
        this.naziv = naziv;
        this.opis = opis;
        this.slike = slike;
        this.sobe = sobe;
        this.kreveti = kreveti;
        this.pravila = pravila;
        this.cenovnik = cenovnik;
        this.maxosoba = maxosoba;
        this.adresa = adresa;
        this.ocena = ocena;
    }

    public Vikendica(Long id, String naziv, String opis, Set<Slike> slike, int sobe, int kreveti, String pravila, int cenovnik, int maxosoba, String adresa, int ocena, Set<Rezervacija> rezervacije) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.slike = slike;
        this.sobe = sobe;
        this.kreveti = kreveti;
        this.pravila = pravila;
        this.cenovnik = cenovnik;
        this.maxosoba = maxosoba;
        this.adresa = adresa;
        this.ocena = ocena;
        this.rezervacije = rezervacije;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Set<Slike> getSlike() {
        return slike;
    }

    public void setSlike(Set<Slike> slike) {
        this.slike = slike;
    }

    public int getSobe() {
        return sobe;
    }

    public void setSobe(int sobe) {
        this.sobe = sobe;
    }

    public int getKreveti() {
        return kreveti;
    }

    public void setKreveti(int kreveti) {
        this.kreveti = kreveti;
    }

    public String getPravila() {
        return pravila;
    }

    public void setPravila(String pravila) {
        this.pravila = pravila;
    }

    public int getCenovnik() {
        return cenovnik;
    }

    public void setCenovnik(int cenovnik) {
        this.cenovnik = cenovnik;
    }

    public int getMaxosoba() {
        return maxosoba;
    }

    public void setMaxosoba(int maxosoba) {
        this.maxosoba = maxosoba;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public Set<Rezervacija> getRezervacije() {
        return rezervacije;
    }

    public void setRezervacije(Set<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }
}
