package com.ftn.ISA2122.controller;

import com.ftn.ISA2122.dto.UserDTO;
import com.ftn.ISA2122.helper.UserRegMapper;
import com.ftn.ISA2122.model.Admin;
import com.ftn.ISA2122.model.Authority;
import com.ftn.ISA2122.model.Klijent;
import com.ftn.ISA2122.model.Korisnik;
import com.ftn.ISA2122.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    KorisnikService korisnikService;

    UserRegMapper userRegMapper;

    public UserController(){this.userRegMapper = new UserRegMapper();}

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userRegMapper.toDto(korisnikService.findOne(id)));
    }

    @PutMapping("/{email}")
    public ResponseEntity.BodyBuilder update(@PathVariable("email") String email, @RequestBody UserDTO userDto){
        try{
            Korisnik k = korisnikService.update(userRegMapper.toEntity(userDto), email);
            return ResponseEntity.status(HttpStatus.OK);
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/is_admin")
    public ResponseEntity<?> getMenjanjeLozinke() {
        try{
            Admin k = (Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return new ResponseEntity<>(k.isMenjanjeLozinke(), HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>("Korisnik nije admin", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("all/{id}")
    public ResponseEntity<?> getAll(@PathVariable("id") Long id){
        List<Korisnik> korisnici = korisnikService.findAll();
        List<UserDTO> dtos = new ArrayList<>();
        for(Korisnik k : korisnici)
        {
            if(k.getId()== id) continue;
            dtos.add(userRegMapper.toDto(k));
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String email) throws Exception {
        Korisnik k = korisnikService.findByEmail(email);
        korisnikService.delete(k.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
