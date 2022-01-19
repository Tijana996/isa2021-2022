package com.ftn.ISA2122.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class Admin extends Korisnik{

    @Column(name="predefinisan", unique=false, nullable=true)
    private boolean predefinisan;

    @Column(name="menjanje_lozinke", unique=false, nullable=true)
    private boolean menjanjeLozinke;

    public Admin(String email, String lozinka, String ime, String prezime, String adresa, String grad, String drzava, String broj, int poeni, int kategorija, int penali, boolean enabled, boolean predefinisan, boolean menjanjeLozinke) {
        super(email, lozinka, ime, prezime, adresa, grad, drzava, broj, poeni, kategorija, penali, enabled);
        this.predefinisan = predefinisan;
        this.menjanjeLozinke = menjanjeLozinke;
    }

    public Admin(Korisnik entity) {
        super(entity.getEmail(), entity.getLozinka(), entity.getIme(), entity.getPrezime(), entity.getAdresa(), entity.getGrad(), entity.getDrzava(), entity.getBroj(), entity.getPoeni(), entity.getKategorija(), entity.getPenali(), entity.isEnabled());
    }


    public Admin() {

    }

    public boolean isPredefinisan() {
        return predefinisan;
    }

    public void setPredefinisan(boolean predefinisan) {
        this.predefinisan = predefinisan;
    }

    public boolean isMenjanjeLozinke() {
        return menjanjeLozinke;
    }

    public void setMenjanjeLozinke(boolean menjanjeLozinke) {
        this.menjanjeLozinke = menjanjeLozinke;
    }
}
