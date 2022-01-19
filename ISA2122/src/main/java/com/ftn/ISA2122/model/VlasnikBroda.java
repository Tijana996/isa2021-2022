package com.ftn.ISA2122.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@DiscriminatorValue("VB")
public class VlasnikBroda extends Korisnik {

    @OneToMany(mappedBy="id")
    private Set<Brod> brodovi;

    public VlasnikBroda(Korisnik entity) {
        super(entity.getEmail(), entity.getLozinka(), entity.getIme(), entity.getPrezime(), entity.getAdresa(), entity.getGrad(), entity.getDrzava(), entity.getBroj(), entity.getPoeni(), entity.getKategorija(), entity.getPenali(), entity.isEnabled());
    }

    public VlasnikBroda(String email, String lozinka, String ime, String prezime, String adresa, String grad, String drzava, String broj, int poeni, int kategorija, int penali, boolean enabled, Set<Brod> brodovi) {
        super(email, lozinka, ime, prezime, adresa, grad, drzava, broj, poeni, kategorija, penali, enabled);
        this.brodovi = brodovi;
    }

    public VlasnikBroda() {}

    public VlasnikBroda(String email, String lozinka, String ime, String prezime, String adresa, String grad, String drzava, String broj, int poeni, int kategorija, int penali, boolean enabled) {
        super(email, lozinka, ime, prezime, adresa, grad, drzava, broj, poeni, kategorija, penali, enabled);
    }

    public Set<Brod> getBrodovi() {
        return brodovi;
    }

    public void setBrodovi(Set<Brod> brodovi) {
        this.brodovi = brodovi;
    }
}
