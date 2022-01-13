package com.ftn.ISA2122.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "brod")
public class Brod {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "brod_generator")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column
    private String naziv;

    @Column
    private String opis;

    @OneToMany(mappedBy="id")
    private Set<Slike> slike;

    @Column
    private String pravila;

    @Column
    private int cenovnik;

    @Column
    private String adresa;

    @Column
    private String tip;

    @Column
    private int duzina;

    @Column
    private int brojmotora;

    @Column
    private int snaga;

    @Column
    private int maxBrzina;

    @Column
    private int kapacitet;

    @Column
    private String oprema;

    @Column
    private int usloviOtkaza; // 0 besplatno 1 zadrzava procenat

    public Brod (){}

    public Brod(Long id, String naziv, String opis, Set<Slike> slike, String pravila, int cenovnik, String adresa, String tip, int duzina, int brojmotora, int snaga, int maxBrzina, int kapacitet, String oprema, int usloviOtkaza) {
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
    }

    public Brod(String naziv, String opis, Set<Slike> slike, String pravila, int cenovnik, String adresa, String tip, int duzina, int brojmotora, int snaga, int maxBrzina, int kapacitet, String oprema, int usloviOtkaza) {
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

    public int getUsloviOtkaza() {
        return usloviOtkaza;
    }

    public void setUsloviOtkaza(int usloviOtkaza) {
        this.usloviOtkaza = usloviOtkaza;
    }
}
