package com.ftn.ISA2122.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@DiscriminatorValue("K")
public class Klijent  extends Korisnik{


    @OneToMany(mappedBy="id")
    private Set<Rezervacija> rezervacije;

    public Klijent(){};

    public Klijent(Korisnik entity) {
        super(entity.getEmail(), entity.getLozinka(), entity.getIme(), entity.getPrezime(), entity.getAdresa(), entity.getGrad(), entity.getDrzava(), entity.getBroj(), entity.getPoeni(), entity.getKategorija(), entity.getPenali(), entity.isEnabled());
    }


    public Klijent(String email, String lozinka, String ime, String prezime, String adresa, String grad, String drzava, String broj, int poeni, int kategorija, int penali, boolean enabled) {
        super(email, lozinka, ime, prezime, adresa, grad, drzava, broj, poeni, kategorija, penali, enabled);
    }

    public Klijent(String email, String lozinka, String ime, String prezime, String adresa, String grad, String drzava, String broj, int poeni, int kategorija, int penali, boolean enabled, Set<Rezervacija> rezervacije) {
        super(email, lozinka, ime, prezime, adresa, grad, drzava, broj, poeni, kategorija, penali, enabled);
        this.rezervacije = rezervacije;
    }

    public Set<Rezervacija> getRezervacije() {
        return rezervacije;
    }

    public void setRezervacije(Set<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }
}
