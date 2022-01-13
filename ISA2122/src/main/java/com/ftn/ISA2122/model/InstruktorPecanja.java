package com.ftn.ISA2122.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("IP")
public class InstruktorPecanja extends Korisnik {

    @Column
    private String lokacija;

    @Column
    private int ocena;

    public InstruktorPecanja(){}

    public InstruktorPecanja(String email, String lozinka, String ime, String prezime, String adresa, String grad, String drzava, String broj, int poeni, int kategorija, int penali, boolean enabled) {
        super(email, lozinka, ime, prezime, adresa, grad, drzava, broj, poeni, kategorija, penali, enabled);
    }

    public InstruktorPecanja(String email, String lozinka, String ime, String prezime, String adresa, String grad, String drzava, String broj, int poeni, int kategorija, int penali, boolean enabled, String lokacija, int ocena) {
        super(email, lozinka, ime, prezime, adresa, grad, drzava, broj, poeni, kategorija, penali, enabled);
        this.lokacija = lokacija;
        this.ocena = ocena;
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
}
