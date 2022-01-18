package com.ftn.ISA2122.controller;

import com.ftn.ISA2122.dto.SearchVikDTO;
import com.ftn.ISA2122.dto.UserLoginDTO;
import com.ftn.ISA2122.dto.UserTokenStateDTO;
import com.ftn.ISA2122.dto.VikendicaDTO;
import com.ftn.ISA2122.helper.UserRegMapper;
import com.ftn.ISA2122.helper.VikendicaMapper;
import com.ftn.ISA2122.model.Korisnik;
import com.ftn.ISA2122.model.Slike;
import com.ftn.ISA2122.model.Vikendica;
import com.ftn.ISA2122.service.VikendicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/vikendica", produces = MediaType.APPLICATION_JSON_VALUE)
public class VikendicaController {

    @Autowired
    VikendicaService vikendicaService;

    VikendicaMapper vikendicaMapper;

    public VikendicaController() {
        this.vikendicaMapper = new VikendicaMapper();
    }

    @GetMapping()
    public ResponseEntity<?> getVikendice() {
        List<Vikendica> vikendice = vikendicaService.findAll();
        List<VikendicaDTO> vikendicaDTOS = new ArrayList<>();
        for (Vikendica vik: vikendice) {
            vikendicaDTOS.add(vikendicaMapper.toDto(vik));
        }
        return new ResponseEntity<>(vikendicaDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVikendica(@PathVariable("id") Long id) {

        //new ResponseEntity<>(getDTOList(apoteke), HttpStatus.OK);
        Vikendica v = vikendicaService.findOne(id);
        return ResponseEntity.ok(vikendicaMapper.toDto(v));
    }

    @GetMapping("/slike/{id}")
    public ResponseEntity<?> getVikendicaSLike(@PathVariable("id") Long id) {

        //new ResponseEntity<>(getDTOList(apoteke), HttpStatus.OK);
        Vikendica v = vikendicaService.findOne(id);
        List<String> slike = new ArrayList<>();
        for(Slike s : v.getSlike())
            slike.add(s.getBase64());
        return ResponseEntity.ok(slike);
    }

    @PostMapping("/search")
    public ResponseEntity<?> searchVikendica(@RequestBody String search){
        try {
            SearchVikDTO searchVikDTO = new SearchVikDTO(search);
            List<Vikendica> vikendice = vikendicaService.search(searchVikDTO.getDateod(), searchVikDTO.getDatedo(), searchVikDTO.getLokacija(), searchVikDTO.getOcena());
            List<VikendicaDTO> vikendicaDTOS = new ArrayList<>();
            for (Vikendica vik: vikendice) {
                vikendicaDTOS.add(vikendicaMapper.toDto(vik));
            }
            return new ResponseEntity<>(vikendicaDTOS, HttpStatus.OK);
        } catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
