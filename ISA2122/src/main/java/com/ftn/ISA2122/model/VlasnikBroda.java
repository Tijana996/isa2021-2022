package com.ftn.ISA2122.model;

import javax.persistence.OneToMany;
import java.util.Set;

public class VlasnikBroda extends Korisnik {

    @OneToMany(mappedBy="id")
    private Set<Brod> brodovi;

}
