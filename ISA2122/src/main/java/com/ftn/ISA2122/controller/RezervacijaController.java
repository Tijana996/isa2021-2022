package com.ftn.ISA2122.controller;

import com.ftn.ISA2122.dto.RezervacijaDTO;
import com.ftn.ISA2122.dto.VikendicaDTO;
import com.ftn.ISA2122.helper.RezervacijaMapper;
import com.ftn.ISA2122.model.Klijent;
import com.ftn.ISA2122.model.Korisnik;
import com.ftn.ISA2122.model.Rezervacija;
import com.ftn.ISA2122.model.Vikendica;
import com.ftn.ISA2122.service.KorisnikService;
import com.ftn.ISA2122.service.RezervacijaService;
import com.ftn.ISA2122.service.VikendicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/rezervacija", produces = MediaType.APPLICATION_JSON_VALUE)
public class RezervacijaController {

    @Autowired
    RezervacijaService rezervacijaService;

    @Autowired
    VikendicaService vikendicaService;

    @Autowired
    KorisnikService korisnikService;

    private RezervacijaMapper rezervacijaMapper;

    public RezervacijaController(){
        rezervacijaMapper = new RezervacijaMapper();
    }

    @PostMapping()
    public ResponseEntity<?> addRezervacija(@RequestBody RezervacijaDTO rezervacijaDTO) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(rezervacijaDTO.getStart(), dtf);
        LocalDate date2 = LocalDate.parse(rezervacijaDTO.getEnd(), dtf);
        int daysBetween = (int) Duration.between(date1.atStartOfDay(), date2.atStartOfDay()).toDays();
        rezervacijaDTO.setBrdana(daysBetween);
        Rezervacija r = rezervacijaMapper.toEntity(rezervacijaDTO);
        Klijent k = (Klijent) korisnikService.findOne(rezervacijaDTO.getKlijenti());
        Vikendica v = vikendicaService.findOne(rezervacijaDTO.getVikendice());
        r.setKlijenti(k);
        r.setVikendice(v);
        rezervacijaService.create(r);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_KLIJENT')")
    public ResponseEntity<?> getRezervacije(@PathVariable("id") Long id) {
        List<Rezervacija> rezervacije = rezervacijaService.findAll();
        List<RezervacijaDTO> rezervacijaDTOS = new ArrayList<>();
        for (Rezervacija rez: rezervacije) {
            if(id == 0 && rez.getKlijenti() == null)
                rezervacijaDTOS.add(rezervacijaMapper.toDto(rez));
            else if(rez.getKlijenti()!= null && rez.getKlijenti().getId() == id)
                rezervacijaDTOS.add(rezervacijaMapper.toDto(rez));
        }
        return new ResponseEntity<>(rezervacijaDTOS, HttpStatus.OK);
    }

    @PutMapping("/{korisnik}/{id}")
    public ResponseEntity<?> rezervisiBrzu(@PathVariable("korisnik") Long klijent_id, @PathVariable("id") Long rez_id) throws Exception {
        Klijent k = (Klijent) korisnikService.findOne(klijent_id);
        Rezervacija r = rezervacijaService.findOne(rez_id);
        r.setKlijenti(k);
        rezervacijaService.update(r,rez_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
