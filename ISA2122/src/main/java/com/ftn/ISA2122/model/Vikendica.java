package com.ftn.ISA2122.model;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.persistence.*;

@Entity
@Table(name = "vikendica")
public class Vikendica {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vikendica_generator")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

}
