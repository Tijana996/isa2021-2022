package com.ftn.ISA2122.controller;

import com.ftn.ISA2122.dto.UserDTO;
import com.ftn.ISA2122.helper.UserRegMapper;
import com.ftn.ISA2122.model.Klijent;
import com.ftn.ISA2122.model.Korisnik;
import com.ftn.ISA2122.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    KorisnikService korisnikService;

    UserRegMapper userRegMapper;

    public UserController(){this.userRegMapper = new UserRegMapper();}

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userRegMapper.toDto((Klijent) korisnikService.findOne(id)));
    }

    @PutMapping("/id")
    public ResponseEntity.BodyBuilder update(@PathVariable("id") Long id, @RequestBody UserDTO userDto){
        try{
            Korisnik k = korisnikService.update(userRegMapper.toEntity(userDto), id);
            return ResponseEntity.status(HttpStatus.OK);
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }
}
