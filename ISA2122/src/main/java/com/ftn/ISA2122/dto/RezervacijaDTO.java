package com.ftn.ISA2122.dto;

import com.ftn.ISA2122.model.Brod;
import com.ftn.ISA2122.model.InstruktorPecanja;
import com.ftn.ISA2122.model.Klijent;
import com.ftn.ISA2122.model.Vikendica;

import javax.persistence.*;

public class RezervacijaDTO {
    private Long id;
    private String start;
    private String end;
    private int brdana;
    private int brgostiju;
    private Long klijenti;
    private Long vikendice;
    private Long brodovi;


    public RezervacijaDTO(){}

    public RezervacijaDTO(Long id, String start, String end, int brdana, int brgostiju, Long klijenti) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.brdana = brdana;
        this.brgostiju = brgostiju;
        this.klijenti = klijenti;
    }

    public RezervacijaDTO(Long id, String start, String end, int brdana, int brgostiju, Long klijenti, Long vikendice, Long brodovi) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.brdana = brdana;
        this.brgostiju = brgostiju;
        this.klijenti = klijenti;
        this.vikendice = vikendice;
        this.brodovi = brodovi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getBrdana() {
        return brdana;
    }

    public void setBrdana(int brdana) {
        this.brdana = brdana;
    }

    public int getBrgostiju() {
        return brgostiju;
    }

    public void setBrgostiju(int brgostiju) {
        this.brgostiju = brgostiju;
    }

    public Long getKlijenti() {
        return klijenti;
    }

    public void setKlijenti(Long klijenti) {
        this.klijenti = klijenti;
    }

    public Long getVikendice() {
        return vikendice;
    }

    public void setVikendice(Long vikendice) {
        this.vikendice = vikendice;
    }

    public Long getBrodovi() {
        return brodovi;
    }

    public void setBrodovi(Long brodovi) {
        this.brodovi = brodovi;
    }
}
