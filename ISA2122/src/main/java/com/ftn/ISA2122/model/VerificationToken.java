package com.ftn.ISA2122.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import javax.persistence.*;

@Entity
@Table(name="verificationtoken")
public class VerificationToken {
	
	private static final int EXPIRATION = 60 * 24;
	 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "token_id")
    private Integer id;

    @Column(unique = true)
    private String token;
    
    @OneToOne(targetEntity = Korisnik.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private Korisnik user;
	
    private Date expiryDate;

    @Enumerated(EnumType.STRING)
    private VerificationTokenType type;

    public VerificationToken(String token, Korisnik user, VerificationTokenType type) {
        this.token = token;
        this.user = user;
        this.expiryDate = this.calculateExpiryDate(this.EXPIRATION);
        this.type = type;
    }

    public VerificationToken() {
    }

    private Date calculateExpiryDate(int expiryTimeInMinutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }

    public static int getEXPIRATION() {
        return EXPIRATION;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Korisnik getUser() {
        return user;
    }

    public void setUser(Korisnik user) {
        this.user = user;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public VerificationTokenType getType() {
        return type;
    }

    public void setType(VerificationTokenType type) {
        this.type = type;
    }
}
