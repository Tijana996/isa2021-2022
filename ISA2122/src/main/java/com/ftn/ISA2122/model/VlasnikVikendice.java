package com.ftn.ISA2122.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@DiscriminatorValue("VV")
public class VlasnikVikendice extends Korisnik {

    @OneToMany()
    @JoinTable(name = "vlasnik_vikendice", joinColumns = @JoinColumn(name = "vlasnik_id"), inverseJoinColumns = @JoinColumn(name = "vikendica_id"))
    private Set<Vikendica> vikendice;

    public VlasnikVikendice(){}

    public VlasnikVikendice(String email, String lozinka, String ime, String prezime, String adresa, String grad, String drzava, String broj, int poeni, int kategorija, int penali, boolean enabled) {
        super(email, lozinka, ime, prezime, adresa, grad, drzava, broj, poeni, kategorija, penali, enabled);
    }

    public VlasnikVikendice(String email, String lozinka, String ime, String prezime, String adresa, String grad, String drzava, String broj, int poeni, int kategorija, int penali, boolean enabled, Set<Vikendica> vikendice) {
        super(email, lozinka, ime, prezime, adresa, grad, drzava, broj, poeni, kategorija, penali, enabled);
        this.vikendice = vikendice;
    }

    public VlasnikVikendice(Korisnik entity) {
        super(entity.getEmail(), entity.getLozinka(), entity.getIme(), entity.getPrezime(), entity.getAdresa(), entity.getGrad(), entity.getDrzava(), entity.getBroj(), entity.getPoeni(), entity.getKategorija(), entity.getPenali(), entity.isEnabled());
    }


    public Set<Vikendica> getVikendice() {
        return vikendice;
    }

    public void setVikendice(Set<Vikendica> vikendice) {
        this.vikendice = vikendice;
    }
}
