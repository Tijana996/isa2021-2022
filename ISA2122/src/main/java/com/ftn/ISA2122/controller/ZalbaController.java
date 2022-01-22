package com.ftn.ISA2122.controller;

import com.ftn.ISA2122.dto.ZalbaDTO;
import com.ftn.ISA2122.helper.ZalbaMapper;
import com.ftn.ISA2122.model.*;
import com.ftn.ISA2122.repository.VlasnikBrodaRepository;
import com.ftn.ISA2122.service.RezervacijaService;
import com.ftn.ISA2122.service.VlasnikBrodaService;
import com.ftn.ISA2122.service.VlasnikVikendiceService;
import com.ftn.ISA2122.service.ZalbaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/zalba", produces = MediaType.APPLICATION_JSON_VALUE)
public class ZalbaController {

    @Autowired
    private ZalbaService zalbaService;

    @Autowired
    private RezervacijaService rezervacijaService;

    @Autowired
    private VlasnikVikendiceService vlasnikVikendiceService;

    @Autowired
    private VlasnikBrodaService vlasnikBrodaService;

    private ZalbaMapper zalbaMapper;

    @PostMapping("/create")
    public ResponseEntity<?> createZalba(@Valid @RequestBody ZalbaDTO zalbaDTO) {
        try {
            Klijent userDetails = (Klijent) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Rezervacija rezervacija = rezervacijaService.findOne(zalbaDTO.getIdrezervacije());
            Zalba zalba = new Zalba(zalbaDTO.getTekst(), null, zalbaDTO.getTip(), rezervacija, userDetails, false);
            zalbaService.create(zalba);
            return new ResponseEntity<>(
                    "true",
                    HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(
                    "Error! Comment not created!",
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/answer")
    public ResponseEntity<?> answerZalba(@Valid @RequestBody ZalbaDTO zalbaDTO) {
        try {
            Zalba zalba = zalbaMapper.toEntity(zalbaDTO);
            zalbaService.update(zalba, zalba.getId());

            //TODO Poslati imejl obema stranama - ima u dto-u oba mejla
            return new ResponseEntity<>(
                    "true",
                    HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(
                    "Error! Comment not created!",
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getZalbe() {
        List<Zalba> zalbe = zalbaService.findAllNeresene();
        return new ResponseEntity<>(toZalbaDtoList(zalbe),HttpStatus.OK);
    }



    public ZalbaController(){
        zalbaMapper = new ZalbaMapper();
    }

    private List<ZalbaDTO> toZalbaDtoList(List<Zalba> zalbe) {
        List<ZalbaDTO> zalbeDTOS = new ArrayList<>();
        for(Zalba zalba: zalbe){
            if (zalba.getTip() == TipZalbe.VIKENDICA && vlasnikVikendiceService.findOneByVikendica(zalba.getRezervacija().getVikendice()) != null) {
                VlasnikVikendice vlasnikVikendice = vlasnikVikendiceService.findOneByVikendica(zalba.getRezervacija().getVikendice());
                zalbeDTOS.add(zalbaMapper.toDtoZalba(zalba, vlasnikVikendice));
            }else if (zalba.getTip() == TipZalbe.BROD && vlasnikBrodaService.findOneByBrod(zalba.getRezervacija().getBrodovi()) != null) {
                VlasnikBroda vlasnikBroda = vlasnikBrodaService.findOneByBrod(zalba.getRezervacija().getBrodovi());
                zalbeDTOS.add(zalbaMapper.toDtoZalba(zalba, vlasnikBroda));
            }else if (zalba.getTip() == TipZalbe.INSTRUKTOR && zalba.getRezervacija().getInstruktori() != null){
                zalbeDTOS.add(zalbaMapper.toDtoZalba(zalba, zalba.getRezervacija().getInstruktori()));
            }
        }
        return zalbeDTOS;
    }


}
