package com.ftn.ISA2122.dto;

import com.ftn.ISA2122.model.Korisnik;
import com.ftn.ISA2122.model.TipKorisnika;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

public class UserDTO {
    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 4, message = "Password must be at least 4 characters long")
    private String password;

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

    private String obrazlozenje;

    private TipKorisnika tipKorisnika;

    public UserDTO(String email, String password, String ime, String prezime, String adresa, String grad, String drzava, String broj, String obrazlozenje, TipKorisnika tipKorisnika) {
        this.email = email;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.grad = grad;
        this.drzava = drzava;
        this.broj = broj;
        this.obrazlozenje = obrazlozenje;
        this.tipKorisnika = tipKorisnika;
    }

    public UserDTO(Korisnik u){
        this.email = u.getEmail();
        this.password = u.getPassword();
        this.ime = u.getIme();
        this.prezime = u.getPrezime();
        this.adresa = u.getAdresa();
        this.grad = u.getGrad();
        this.drzava = u.getDrzava();
        this.broj = u.getBroj();
    }

    public UserDTO(@NotBlank @Email String email, @NotBlank @Size(min = 4, message = "Password must be at least 4 characters long") String password) {
        this.email = email;
        this.password = password;

    }



    public UserDTO(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getObrazlozenje() {
        return obrazlozenje;
    }

    public void setObrazlozenje(String obrazlozenje) {
        this.obrazlozenje = obrazlozenje;
    }

    public TipKorisnika getTipKorisnika() {
        return tipKorisnika;
    }

    public void setTipKorisnika(TipKorisnika tipKorisnika) {
        this.tipKorisnika = tipKorisnika;
    }
}
