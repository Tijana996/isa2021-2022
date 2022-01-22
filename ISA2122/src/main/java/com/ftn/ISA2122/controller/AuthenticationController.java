package com.ftn.ISA2122.controller;

import com.ftn.ISA2122.dto.UserDTO;
import com.ftn.ISA2122.dto.UserLoginDTO;
import com.ftn.ISA2122.dto.UserTokenStateDTO;
import com.ftn.ISA2122.dto.ZahtevZaRegistracijuDTO;
import com.ftn.ISA2122.event.OnRegistrationCompleteEvent;
import com.ftn.ISA2122.helper.UserRegMapper;
import com.ftn.ISA2122.helper.ZahtevZaRegistracijuMapper;
import com.ftn.ISA2122.model.Admin;
import com.ftn.ISA2122.model.Klijent;
import com.ftn.ISA2122.model.Korisnik;
import com.ftn.ISA2122.model.ZahtevZaRegistraciju;
import com.ftn.ISA2122.security.TokenUtils;
import com.ftn.ISA2122.service.AdminService;
import com.ftn.ISA2122.service.KorisnikService;
import com.ftn.ISA2122.service.ZahtevZaRegistracijuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

    @Autowired
    private KorisnikService userService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private ZahtevZaRegistracijuService zahtevZaRegistracijuService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    private UserRegMapper userMapper;

    private ZahtevZaRegistracijuMapper zahtevZaRegistracijuMapper;

    public AuthenticationController() {
        this.userMapper = new UserRegMapper();
        this.zahtevZaRegistracijuMapper = new ZahtevZaRegistracijuMapper();
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody UserLoginDTO authenticationRequest,
                                                       HttpServletResponse response) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));

        // Ubaci korisnika u trenutni security kontekst
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Kreiraj token za tog korisnika
        Korisnik user = (Korisnik) authentication.getPrincipal();
        String jwt = tokenUtils.generateToken(user); // prijavljujemo se na sistem sa email adresom
        int expiresIn = tokenUtils.getExpiredIn();

        // Vrati token kao odgovor na uspesnu autentifikaciju
        return ResponseEntity.ok(new UserTokenStateDTO(user.getId(), jwt, expiresIn));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> registerUser(@RequestBody @Valid UserDTO userRequest, UriComponentsBuilder ucBuilder) throws Exception {
       try {
           Korisnik user = userService.createKorisnik(userMapper.toEntity(userRequest), userRequest.getTipKorisnika());

           if (!(user instanceof Klijent)){
               String token = UUID.randomUUID().toString();
               userService.createRegistrationVerificationToken(user, token);
           }

           if ((user instanceof Klijent)){
               HttpHeaders headers = new HttpHeaders();
               headers.setLocation(ucBuilder.path("/api/user/{userId}").buildAndExpand(user.getId()).toUri());
               eventPublisher.publishEvent(new OnRegistrationCompleteEvent(user));
           }

           ZahtevZaRegistraciju zahtevZaRegistraciju = new ZahtevZaRegistraciju();
           zahtevZaRegistraciju.setKorisnik(user);
           zahtevZaRegistraciju.setObrazlozenje(userRequest.getObrazlozenje());
           zahtevZaRegistracijuService.create(zahtevZaRegistraciju);
           return new ResponseEntity<>("User successfully registered.", HttpStatus.CREATED);
       } catch (Exception e) {
           e.printStackTrace();
           return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
       }
    }

    @PostMapping("/sign-up-admin")
    public ResponseEntity<?> registerAdmin(@RequestBody @Valid UserDTO userRequest, UriComponentsBuilder ucBuilder) throws Exception {
        try {
            Korisnik user = userService.createKorisnik(userMapper.toEntity(userRequest), userRequest.getTipKorisnika());

            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/registration-confirm/{token}")
    public void confirmRegistration(@PathVariable("token") String token) throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        userService.verifyRegistrationToken(token);
    }

    @GetMapping("/registration-confirm-owners/{token}")
    public ResponseEntity<?> confirmRegistrationOwners(@PathVariable("token") String token){
        try {
            userService.verifyRegistrationToken(token);
            SimpleMailMessage email = new SimpleMailMessage();
            email.setFrom("isatijana@outlook.com");
            email.setTo("isatijana@outlook.com");
            email.setSubject("Zahtev potvrdjen");
            mailSender.send(email);
            return new ResponseEntity<>("Korisnik je registrovan", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/registration-reject-owners/{token}")
    public ResponseEntity<?> rejectRegistrationOwners(@PathVariable("token") String token){
        try {
            userService.rejectRegistration(token);
            SimpleMailMessage email = new SimpleMailMessage();
            email.setFrom("isatijana@outlook.com");
            email.setTo("isatijana@outlook.com");
            email.setSubject("Zahtev odbijen");
            mailSender.send(email);
            return new ResponseEntity<>("Korisnik je odbijen", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/applications")
    public ResponseEntity<?> getAllZahteviZaRegistraciju(){
        try {
            List<ZahtevZaRegistraciju> zahtevi = zahtevZaRegistracijuService.findAllExceptKlijenti();
            return new ResponseEntity<>(getDTOList(zahtevi), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/predefined/{id}")
    public ResponseEntity<?> getIfPredefinisan(@PathVariable("id") Long id){
        try {
            Admin a = adminService.findOne(id);
            if(a.isPredefinisan())
                return new ResponseEntity<>("true", HttpStatus.OK);
            else
                return new ResponseEntity<>("false", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping ("/first-login-password")
    public ResponseEntity<?> setChangedPasswordFirstLogin(@RequestBody String password){
        try {
            Admin user = (Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            user.setLozinka(password);
            adminService.update(user, user.getId());
            return new ResponseEntity<>("true", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    private List<ZahtevZaRegistracijuDTO> getDTOList(List<ZahtevZaRegistraciju> zahtevi) {
        List<ZahtevZaRegistracijuDTO> list = new ArrayList<>();
        for(ZahtevZaRegistraciju zahtev: zahtevi)
            list.add(zahtevZaRegistracijuMapper.toDto(zahtev));
        return list;
    }





//    @GetMapping("/registration-confirm/{token}")
//    public ResponseEntity<?> confirmRegistration(@PathVariable("token") String token) throws URISyntaxException {
//       HttpHeaders httpHeaders = new HttpHeaders();
//       try {
//            registeredUserService.verifyRegistrationToken(token);
//            return ResponseEntity.status(HttpStatus.FOUND)
//                    .location(URI.create("https://localhost:4200/register-success-redirect"))
//                    .build();
//        } catch (Exception e) {
//           return ResponseEntity.status(HttpStatus.FOUND)
//                   .location(URI.create("https://localhost:4200/register-token-expired"))
//                   .build();
//        }
//    }
}
