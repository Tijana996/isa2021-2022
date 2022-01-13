package com.ftn.ISA2122.dto;

import com.ftn.ISA2122.model.Slike;

import javax.persistence.*;
import java.util.Set;

public class VikendicaDTO {
    private Long id;
    
    private String naziv;

     
    private String opis;

    private Set<Slike> slike;

    private int sobe;

    private int kreveti;
     
    private String pravila;

    private int cenovnik;

    private int maxosoba;

    private String adresa;

    private int ocena;

    public VikendicaDTO(Long id, String naziv, String opis, Set<Slike> slike, int sobe, int kreveti, String pravila, int cenovnik, int maxosoba, String adresa, int ocena) {
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
}
