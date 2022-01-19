package com.ftn.ISA2122.controller;

import com.ftn.ISA2122.dto.BrodDTO;
import com.ftn.ISA2122.dto.SearchVikDTO;
import com.ftn.ISA2122.helper.BrodMapper;
import com.ftn.ISA2122.model.Brod;
import com.ftn.ISA2122.model.Slike;
import com.ftn.ISA2122.service.BrodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/brod", produces = MediaType.APPLICATION_JSON_VALUE)
public class BrodController {

    @Autowired
    BrodService brodService;

    BrodMapper brodMapper;

    public BrodController() {
        this.brodMapper = new BrodMapper();
    }

    @GetMapping()
    public ResponseEntity<?> getVikendice() {
        List<Brod> brodovi = brodService.findAll();
        List<BrodDTO> brodoviDTOs = new ArrayList<>();
        for (Brod vik: brodovi) {
            brodoviDTOs.add(brodMapper.toDto(vik));
        }
        return new ResponseEntity<>(brodoviDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVikendica(@PathVariable("id") Long id) {

        //new ResponseEntity<>(getDTOList(apoteke), HttpStatus.OK);
        Brod v = brodService.findOne(id);
        return ResponseEntity.ok(brodMapper.toDto(v));
    }


    @PostMapping("/search")
    public ResponseEntity<?> searchVikendica(@RequestBody String search){
        try {
            SearchVikDTO searchVikDTO = new SearchVikDTO(search);
            List<Brod> brodovi = brodService.search(searchVikDTO.getDateod(), searchVikDTO.getDatedo(), searchVikDTO.getLokacija(), searchVikDTO.getOcena());
            List<BrodDTO> brodoviDTOs = new ArrayList<>();
            for (Brod vik: brodovi) {
                brodoviDTOs.add(brodMapper.toDto(vik));
            }
            return new ResponseEntity<>(brodoviDTOs, HttpStatus.OK);
        } catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
