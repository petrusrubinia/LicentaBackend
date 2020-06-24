package com.backLicenta.detectare.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Builder
@Table(name = "alimente", schema="licenta")
public class AlimentDetect {
    @Getter
    @Setter
    @Id
    @Column(name = "id", unique = true)
    private int id;

    @Getter
    @Setter
    @Column(name = "id_user", nullable = false)
    private int idUser;


    @Getter
    @Setter
    @Column(name = "cod_de_bare", nullable = true)
    private String cod_de_bare;

    @Getter
    @Setter
    @Column(name = "nume", nullable = false)
    private String nume;

    @Getter
    @Setter
    @Column(name = "categorie", nullable = false)
    private String categorie;


    @Getter
    @Setter
    @Column(name = "cantitate", nullable = true)
    private String cantitate;
    @Getter
    @Setter
    @Column(name = "bucati", nullable = true)
    private int bucati;

    @Getter
    @Setter
    @Column(name = "temperatura", nullable = true)
    private int temperatura;

    @Getter
    @Setter
    @Column(name = "data_expirare", nullable = true)
    private String data_expirare;

    @Getter
    @Setter
    @Column(name = "data_achizitionare", nullable = true)
    private String data_achizitionare;

    public AlimentDetect(String cod_de_bare, String nume, String categorie, String cantitate, int bucati, int temperatura, String data_expirare, String data_achizitionare) {
        this.cod_de_bare = cod_de_bare;
        this.nume = nume;
        this.categorie = categorie;
        this.cantitate = cantitate;
        this.bucati = bucati;
        this.temperatura = temperatura;
        this.data_expirare = data_expirare;
        this.data_achizitionare = data_achizitionare;
    }

    public AlimentDetect(int id, String cod_de_bare, String nume, String categorie, String cantitate, int bucati, int temperatura, String data_expirare, String data_achizitionare) {
        this.id = id;
        this.cod_de_bare = cod_de_bare;
        this.nume = nume;
        this.bucati = bucati;
        this.categorie = categorie;
        this.cantitate = cantitate;
        this.temperatura = temperatura;
        this.data_expirare = data_expirare;
        this.data_achizitionare = data_achizitionare;
    }


    public AlimentDetect(int id, int idUser, String cod_de_bare, String nume, String categorie, String cantitate, int bucati, int temperatura, String data_expirare, String data_achizitionare) {
        this.id = id;
        this.idUser = idUser;
        this.cod_de_bare = cod_de_bare;
        this.nume = nume;
        this.categorie = categorie;
        this.cantitate = cantitate;
        this.bucati = bucati;

        this.temperatura = temperatura;
        this.data_expirare = data_expirare;
        this.data_achizitionare = data_achizitionare;
    }

    public AlimentDetect() {
    }

    public AlimentDetect(int idUser, String categorie) {
        this.idUser = idUser;
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return nume + " " + cantitate + " " + temperatura;
    }
}
