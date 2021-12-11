package com.ftn.ISA2122.dto;

import com.ftn.ISA2122.model.Korisnik;

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

    public UserDTO(Korisnik u){
        this.email = u.getEmail();
        this.password = u.getPassword();
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


}
