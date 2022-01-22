package com.ftn.ISA2122.dto;

import com.ftn.ISA2122.model.TipZalbe;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class ZalbaDTO {

    private Long id;

    @NotBlank
    private String tekst;
    @NotNull
    private Long idrezervacije;
    @NotNull
    private TipZalbe tip;

    private String odgovor;
    private String imeKlijenta;
    private String prezimeKlijenta;
    private String emailKlijenta;
    private String imeOptuzenog;
    private String prezimeOptuzenog;
    private String emailOptuzenog;

    public ZalbaDTO(Long id, String tekst, Long idrezervacije, TipZalbe tip, String odgovor, String imeKlijenta, String prezimeKlijenta, String emailKlijenta, String imeOptuzenog, String prezimeOptuzenog, String emailOptuzenog) {
        this.id = id;
        this.tekst = tekst;
        this.idrezervacije = idrezervacije;
        this.tip = tip;
        this.odgovor = odgovor;
        this.imeKlijenta = imeKlijenta;
        this.prezimeKlijenta = prezimeKlijenta;
        this.emailKlijenta = emailKlijenta;
        this.imeOptuzenog = imeOptuzenog;
        this.prezimeOptuzenog = prezimeOptuzenog;
        this.emailOptuzenog = emailOptuzenog;
    }

    public ZalbaDTO(Long id, String tekst, Long idrezervacije, TipZalbe tip, String imeKlijenta, String prezimeKlijenta, String emailKlijenta, String imeOptuzenog, String prezimeOptuzenog, String emailOptuzenog) {
        this.id = id;
        this.tekst = tekst;
        this.idrezervacije = idrezervacije;
        this.tip = tip;
        this.imeKlijenta = imeKlijenta;
        this.prezimeKlijenta = prezimeKlijenta;
        this.emailKlijenta = emailKlijenta;
        this.imeOptuzenog = imeOptuzenog;
        this.prezimeOptuzenog = prezimeOptuzenog;
        this.emailOptuzenog = emailOptuzenog;
    }

    public ZalbaDTO(String tekst, Long idrezervacije, TipZalbe tip) {
        this.tekst = tekst;
        this.idrezervacije = idrezervacije;
        this.tip = tip;
    }

    public ZalbaDTO(String tekst, Long idrezervacije, TipZalbe tip, String odgovor) {
        this.tekst = tekst;
        this.idrezervacije = idrezervacije;
        this.tip = tip;
        this.odgovor = odgovor;
    }

    public ZalbaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public Long getIdrezervacije() {
        return idrezervacije;
    }

    public void setIdrezervacije(Long idrezervacije) {
        this.idrezervacije = idrezervacije;
    }

    public TipZalbe getTip() {
        return tip;
    }

    public void setTip(TipZalbe tip) {
        this.tip = tip;
    }

    public String getImeKlijenta() {
        return imeKlijenta;
    }

    public void setImeKlijenta(String imeKlijenta) {
        this.imeKlijenta = imeKlijenta;
    }

    public String getPrezimeKlijenta() {
        return prezimeKlijenta;
    }

    public void setPrezimeKlijenta(String prezimeKlijenta) {
        this.prezimeKlijenta = prezimeKlijenta;
    }

    public String getEmailKlijenta() {
        return emailKlijenta;
    }

    public void setEmailKlijenta(String emailKlijenta) {
        this.emailKlijenta = emailKlijenta;
    }

    public String getImeOptuzenog() {
        return imeOptuzenog;
    }

    public void setImeOptuzenog(String imeOptuzenog) {
        this.imeOptuzenog = imeOptuzenog;
    }

    public String getPrezimeOptuzenog() {
        return prezimeOptuzenog;
    }

    public void setPrezimeOptuzenog(String prezimeOptuzenog) {
        this.prezimeOptuzenog = prezimeOptuzenog;
    }

    public String getEmailOptuzenog() {
        return emailOptuzenog;
    }

    public void setEmailOptuzenog(String emailOptuzenog) {
        this.emailOptuzenog = emailOptuzenog;
    }

    public String getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(String odgovor) {
        this.odgovor = odgovor;
    }

}
