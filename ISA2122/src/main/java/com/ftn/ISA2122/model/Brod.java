package com.ftn.ISA2122.model;

import javax.persistence.*;

@Entity
@Table(name = "brod")
public class Brod {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "brod_generator")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;



}
