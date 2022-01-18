package com.ftn.ISA2122.model;

import javax.persistence.*;

@Entity
@Table(name = "slike")
public class Slike {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "slike_generator")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(length=100000)
    private String base64;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="vikendica_id", nullable=true)
    private Vikendica vikendica;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="brod_id", nullable=true)
    private Brod brod;

    public Slike(){}

    public Slike(Long id, String base64) {
        this.id = id;
        this.base64 = base64;
    }

    public Slike(Long id, String base64, Vikendica vikendica) {
        this.id = id;
        this.base64 = base64;
        this.vikendica = vikendica;
    }

    public Slike(String base64) {
        this.base64 = base64;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public Vikendica getVikendica() {
        return vikendica;
    }

    public void setVikendica(Vikendica vikendica) {
        this.vikendica = vikendica;
    }
}
