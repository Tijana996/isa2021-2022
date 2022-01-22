package com.ftn.ISA2122.event;

import com.ftn.ISA2122.model.Korisnik;
import org.springframework.context.ApplicationEvent;

public class OnRegistrationCompleteEvent extends ApplicationEvent {
    private Korisnik user;

    public OnRegistrationCompleteEvent(Korisnik user) {
        super(user);

        this.user = user;
    }

    public Korisnik getUser() {
        return user;
    }

    public void setUser(Korisnik user) {
        this.user = user;
    }
}
