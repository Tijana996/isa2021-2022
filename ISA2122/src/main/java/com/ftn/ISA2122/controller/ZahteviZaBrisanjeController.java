package com.ftn.ISA2122.controller;

import com.ftn.ISA2122.dto.BrodDTO;
import com.ftn.ISA2122.dto.ZahteviZaBrisanjeDTO;
import com.ftn.ISA2122.helper.ZahteviZaBrisanjeMapper;
import com.ftn.ISA2122.model.Brod;
import com.ftn.ISA2122.model.Klijent;
import com.ftn.ISA2122.model.Korisnik;
import com.ftn.ISA2122.model.ZahteviZaBrisanje;
import com.ftn.ISA2122.service.KorisnikService;
import com.ftn.ISA2122.service.ZavteviZaBrisanjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/zahtevibrisanje", produces = MediaType.APPLICATION_JSON_VALUE)
public class ZahteviZaBrisanjeController {

    @Autowired
    private ZavteviZaBrisanjeService service;

    @Autowired
    private KorisnikService korisnikService;

    private ZahteviZaBrisanjeMapper zahteviZaBrisanjeMapper;

    public ZahteviZaBrisanjeController(){this.zahteviZaBrisanjeMapper = new ZahteviZaBrisanjeMapper();}

    @GetMapping()
    public ResponseEntity getAll(){
        List<ZahteviZaBrisanje> zahteviZaBrisanje = service.findAll();
        List<ZahteviZaBrisanjeDTO> dtos = new ArrayList<>();
        for (ZahteviZaBrisanje vik: zahteviZaBrisanje) {
            dtos.add(zahteviZaBrisanjeMapper.toDto(vik));
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Long id) throws Exception {
        //Korisnik k = korisnikService.findOne(id);
        korisnikService.delete(id);
        Korisnik k = korisnikService.findOne(id);
        List<ZahteviZaBrisanje> zahteviZaBrisanje = service.findAll();
        for(ZahteviZaBrisanje z : zahteviZaBrisanje)
            if(z.getKlijent() == id)
                service.delete(z.getId());
        if(k != null) return new ResponseEntity<>("Korisnik ne moze da bude obrisan",HttpStatus.OK);
        return new ResponseEntity<>("Korisnik obrisan",HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity create(@PathVariable("id") Long id) throws Exception {
        Klijent k = (Klijent) korisnikService.findOne(id);
        ZahteviZaBrisanje zzb = new ZahteviZaBrisanje();
        zzb.setKlijent(k.getId());
        zzb.setEmail(k.getEmail());
        try{
            service.create(zzb);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
