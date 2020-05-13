package com.backLicenta.categorii.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Builder
@Table(name = "categorii", schema="licenta")
public class Categorie {
    @Getter
    @Setter
    @Id
    @Column(name = "id", unique = true)
    private int id;


    @Getter
    @Setter
    @Column(name = "categorie", nullable = false)
    private String categorie;

    public Categorie(String categorie) {
        this.categorie = categorie;
    }

    public Categorie(int id, String categorie) {
        this.id = id;
        this.categorie = categorie;
    }

    public Categorie() {
    }
}
