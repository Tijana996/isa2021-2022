package com.ftn.ISA2122.dto;

import com.ftn.ISA2122.model.Rezervacija;

import javax.persistence.*;
import java.util.Set;

public class InstruktorPecanjaDTO {

    private Long id;
    private String ime;
    private String prezime;
    private String broj;
    private String lokacija;
    private int ocena;
    private Set<RezervacijaDTO> rezervacije;

    public InstruktorPecanjaDTO(){}

    public InstruktorPecanjaDTO(Long id, String ime, String prezime, String broj, String lokacija, int ocena, Set<RezervacijaDTO> rezervacije) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.broj = broj;
        this.lokacija = lokacija;
        this.ocena = ocena;
        this.rezervacije = rezervacije;
    }

    public InstruktorPecanjaDTO(String ime, String prezime, String broj, String lokacija, int ocena, Set<RezervacijaDTO> rezervacije) {
        this.ime = ime;
        this.prezime = prezime;
        this.broj = broj;
        this.lokacija = lokacija;
        this.ocena = ocena;
        this.rezervacije = rezervacije;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public Set<RezervacijaDTO> getRezervacije() {
        return rezervacije;
    }

    public void setRezervacije(Set<RezervacijaDTO> rezervacije) {
        this.rezervacije = rezervacije;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
