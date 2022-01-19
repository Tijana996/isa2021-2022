package com.ftn.ISA2122.dto;

import com.ftn.ISA2122.model.Slike;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.Set;

public class BrodDTO {
    private Long id;
    private String naziv;
    private String opis;
    private Set<String> slike;
    private String pravila;
    private int cenovnik;
    private String adresa;
    private String tip;
    private int duzina;
    private int brojmotora;
    private int snaga;
    private int maxBrzina;
    private int kapacitet;
    private String oprema;
    private String usloviOtkaza;
    private Set<RezervacijaDTO> rezervacije;
    private int ocena;

    public BrodDTO(){}

    public BrodDTO(Long id, String naziv, String opis, Set<String> slike, String pravila, int cenovnik, String adresa, String tip, int duzina, int brojmotora, int snaga, int maxBrzina, int kapacitet, String oprema, String usloviOtkaza, Set<RezervacijaDTO> rezervacije, int ocena) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.slike = slike;
        this.pravila = pravila;
        this.cenovnik = cenovnik;
        this.adresa = adresa;
        this.tip = tip;
        this.duzina = duzina;
        this.brojmotora = brojmotora;
        this.snaga = snaga;
        this.maxBrzina = maxBrzina;
        this.kapacitet = kapacitet;
        this.oprema = oprema;
        this.usloviOtkaza = usloviOtkaza;
        this.rezervacije = rezervacije;
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

    public Set<String> getSlike() {
        return slike;
    }

    public void setSlike(Set<String> slike) {
        this.slike = slike;
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

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getDuzina() {
        return duzina;
    }

    public void setDuzina(int duzina) {
        this.duzina = duzina;
    }

    public int getBrojmotora() {
        return brojmotora;
    }

    public void setBrojmotora(int brojmotora) {
        this.brojmotora = brojmotora;
    }

    public int getSnaga() {
        return snaga;
    }

    public void setSnaga(int snaga) {
        this.snaga = snaga;
    }

    public int getMaxBrzina() {
        return maxBrzina;
    }

    public void setMaxBrzina(int maxBrzina) {
        this.maxBrzina = maxBrzina;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    public String getOprema() {
        return oprema;
    }

    public void setOprema(String oprema) {
        this.oprema = oprema;
    }

    public String getUsloviOtkaza() {
        return usloviOtkaza;
    }

    public void setUsloviOtkaza(String usloviOtkaza) {
        this.usloviOtkaza = usloviOtkaza;
    }

    public Set<RezervacijaDTO> getRezervacije() {
        return rezervacije;
    }

    public void setRezervacije(Set<RezervacijaDTO> rezervacije) {
        this.rezervacije = rezervacije;
    }
}
