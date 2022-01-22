package com.ftn.ISA2122.listener;


import com.ftn.ISA2122.event.OnRegistrationCompleteEvent;
import com.ftn.ISA2122.model.Korisnik;
import com.ftn.ISA2122.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private KorisnikService korisnikService;

    @Override
    public void onApplicationEvent(OnRegistrationCompleteEvent onRegistrationCompleteEvent) {
        Korisnik user = onRegistrationCompleteEvent.getUser();
        String token = UUID.randomUUID().toString();
        korisnikService.createRegistrationVerificationToken(user, token);

        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom("isatijana@outlook.com");
        email.setTo("isatijana@outlook.com");
        email.setSubject("Potvrdite registraciju");
        email.setText("http://localhost:8080/auth/registration-confirm/" + token);
        mailSender.send(email);

        System.out.println("ISSUED TOKEN: " + token);
    }
}
