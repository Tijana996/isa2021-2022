package com.ftn.ISA2122.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@DiscriminatorValue("VV")
public class VlasnikVikendice extends Korisnik {

    @OneToMany(mappedBy="id")
    private Set<Vikendica> vikendice;

    public VlasnikVikendice(){}

    public VlasnikVikendice(String email, String lozinka, String ime, String prezime, String adresa, String grad, String drzava, String broj, int poeni, int kategorija, int penali, boolean enabled) {
        super(email, lozinka, ime, prezime, adresa, grad, drzava, broj, poeni, kategorija, penali, enabled);
    }

    public VlasnikVikendice(String email, String lozinka, String ime, String prezime, String adresa, String grad, String drzava, String broj, int poeni, int kategorija, int penali, boolean enabled, Set<Vikendica> vikendice) {
        super(email, lozinka, ime, prezime, adresa, grad, drzava, broj, poeni, kategorija, penali, enabled);
        this.vikendice = vikendice;
    }

    public Set<Vikendica> getVikendice() {
        return vikendice;
    }

    public void setVikendice(Set<Vikendica> vikendice) {
        this.vikendice = vikendice;
    }
}
