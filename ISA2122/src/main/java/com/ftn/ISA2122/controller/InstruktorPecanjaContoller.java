package com.ftn.ISA2122.controller;


import com.ftn.ISA2122.dto.InstruktorPecanjaDTO;
import com.ftn.ISA2122.dto.SearchVikDTO;
import com.ftn.ISA2122.helper.InstruktorMapper;
import com.ftn.ISA2122.model.InstruktorPecanja;
import com.ftn.ISA2122.service.InstruktorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/instruktori", produces = MediaType.APPLICATION_JSON_VALUE)
public class InstruktorPecanjaContoller {

    @Autowired
    InstruktorService instruktorService;

    InstruktorMapper instruktorMapper;

    public InstruktorPecanjaContoller() {
        this.instruktorMapper = new InstruktorMapper();
    }

    @GetMapping()
    public ResponseEntity<?> getInstruktorovi() {
        List<InstruktorPecanja> instruktori = instruktorService.findAll();
        List<InstruktorPecanjaDTO> instruktorPecanjaDTOS = new ArrayList<>();
        for (InstruktorPecanja vik: instruktori) {
            instruktorPecanjaDTOS.add(instruktorMapper.toDto(vik));
        }
        return new ResponseEntity<>(instruktorPecanjaDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInstruktor(@PathVariable("id") Long id) {

        //new ResponseEntity<>(getDTOList(apoteke), HttpStatus.OK);
        InstruktorPecanja v = instruktorService.findOne(id);
        return ResponseEntity.ok(instruktorMapper.toDto(v));
    }


    @PostMapping("/search")
    public ResponseEntity<?> searchInstruktor(@RequestBody String search){
        try {
            SearchVikDTO searchVikDTO = new SearchVikDTO(search);
            List<InstruktorPecanja> instruktori = instruktorService.search(searchVikDTO.getDateod(), searchVikDTO.getDatedo(), searchVikDTO.getLokacija(), searchVikDTO.getOcena());
            List<InstruktorPecanjaDTO> instruktorPecanjaDTOS = new ArrayList<>();
            for (InstruktorPecanja vik: instruktori) {
                instruktorPecanjaDTOS.add(instruktorMapper.toDto(vik));
            }
            return new ResponseEntity<>(instruktorPecanjaDTOS, HttpStatus.OK);
        } catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
