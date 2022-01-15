package com.ftn.ISA2122.dto;

import com.ftn.ISA2122.model.Korisnik;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ZahtevZaRegistracijuDTO {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String token;

    @NotBlank
    private String ime;

    @NotBlank
    private String prezime;

    @NotBlank
    private String adresa;

    @NotBlank
    private String grad;

    @NotBlank
    private String drzava;

    @NotBlank
    private String broj;

    @NotBlank
    private String obrazlozenje;

    public ZahtevZaRegistracijuDTO(Korisnik u, String obrazlozenje){
        this.email = u.getEmail();
        this.token = u.getToken().getToken();
        this.ime = u.getIme();
        this.prezime = u.getPrezime();
        this.adresa = u.getAdresa();
        this.grad = u.getGrad();
        this.drzava = u.getDrzava();
        this.broj = u.getBroj();
        this.obrazlozenje = obrazlozenje;
    }

    public ZahtevZaRegistracijuDTO(String email, String token, String ime, String prezime, String adresa, String grad, String drzava, String broj, String obrazlozenje) {
        this.email = email;
        this.token = token;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.grad = grad;
        this.drzava = drzava;
        this.broj = broj;
        this.obrazlozenje = obrazlozenje;
    }

    public ZahtevZaRegistracijuDTO() {
    }

    public String getObrazlozenje() {
        return obrazlozenje;
    }

    public void setObrazlozenje(String obrazlozenje) {
        this.obrazlozenje = obrazlozenje;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }
}
