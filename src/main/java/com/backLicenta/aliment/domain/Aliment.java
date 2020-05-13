package com.backLicenta.aliment.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Blob;
import java.util.Date;

@Entity
@Builder
@Table(name = "aliment", schema="licenta")
public class Aliment {
    @Getter
    @Setter
    @Id
    @Column(name = "id", unique = true)
    private int id;


    @Getter
    @Setter
    @Column(name = "nume", nullable = false)
    private String nume;

    @Getter
    @Setter
    @Column(name = "categorie", nullable = true)
    private String categorie;


    @Getter
    @Setter
    @Column(name = "cantitate", nullable = true)
    private String cantitate;


    @Getter
    @Setter
    @Column(name = "temperatura", nullable = true)
    private int temperatura;

    @Getter
    @Setter
    @Column(name = "data_expirare", nullable = false)
    private String data_expirare;

    @Getter
    @Setter
    @Column(name = "data_achizitionare", nullable = false)
    private String data_achizitionare;

    @Getter
    @Setter
    @Column(name = "cod_de_bare", nullable = true)
    private String cod_de_bare;

    @Getter
    @Setter
    @Column(name = "imagine", nullable = true)
    private Blob imagine;

    @Getter
    @Setter
    @Column(name = "nume_imagine", nullable = true)
    private String nume_imagine;

    public Aliment(int id, String nume,String categorie, String cantitate, int temperatura, String data_expirare, String data_achizitionare, String cod_de_bare) {
        this.id = id;
        this.nume = nume;
        this.categorie = categorie;
        this.cantitate = cantitate;
        this.temperatura = temperatura;
        this.data_expirare = data_expirare;
        this.data_achizitionare = data_achizitionare;
        this.cod_de_bare = cod_de_bare;
    }

    public Aliment(String nume, String categorie, String cantitate, int temperatura, String data_expirare, String data_achizitionare, String cod_de_bare) {
        this.nume = nume;
        this.categorie = categorie;
        this.cantitate = cantitate;
        this.temperatura = temperatura;
        this.data_expirare = data_expirare;
        this.data_achizitionare = data_achizitionare;
        this.cod_de_bare = cod_de_bare;
    }

    public Aliment() {

    }

    public Aliment(int id, String nume, String categorie, String cantitate, int temperatura, String data_expirare, String data_achizitionare, String cod_de_bare, Blob imagine, String nume_imagine) {
        this.id = id;
        this.nume = nume;
        this.categorie = categorie;
        this.cantitate = cantitate;
        this.temperatura = temperatura;
        this.data_expirare = data_expirare;
        this.data_achizitionare = data_achizitionare;
        this.cod_de_bare = cod_de_bare;
        this.imagine = imagine;
        this.nume_imagine = nume_imagine;
    }
}
