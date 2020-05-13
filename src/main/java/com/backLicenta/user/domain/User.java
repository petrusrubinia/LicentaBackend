package com.backLicenta.user.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder
@Table(name = "user", schema="licenta")
public class User implements Serializable{

    @Id
    @Column(name = "id", unique = true)
    private int id;

    @Getter
    @Setter
    @Column(name = "nume", nullable = false)
    private String nume;

    @Getter
    @Setter
    @Column(name = "prenume", nullable = false)
    private String prenume;

    @Getter
    @Setter
    @Column(name = "email", nullable = false)
    private String email;

    @Getter
    @Setter
    @Column(name = "utilizator", nullable = false)
    private String utilizator;

    @Getter
    @Setter
    @Column(name = "parola", nullable = false)
    private String parola;


    public User(String nume, String prenume, String email, String utilizator, String parola) {
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.utilizator = utilizator;
        this.parola = parola;
    }

    public User(String utilizator, String parola) {
        this.utilizator = utilizator;
        this.parola = parola;
    }


    public User(int id, String nume, String prenume, String email, String utilizator, String parola) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.utilizator = utilizator;
        this.parola = parola;
    }

    public User() {
    }
}
