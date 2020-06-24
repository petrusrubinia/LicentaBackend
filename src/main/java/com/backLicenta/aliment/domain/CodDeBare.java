package com.backLicenta.aliment.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Builder
@Table(name = "coddebare", schema="licenta")
public class CodDeBare {
    @Getter
    @Setter
    @Id
    @Column(name = "cod", unique = true)
    private String cod;

    @Getter
    @Setter
    @Column(name = "categorie", nullable = false)
    private String categorie;
    @Getter
    @Setter
    @Column(name = "denumire", nullable = false)
    private String denumire;

    @Getter
    @Setter
    @Column(name = "temperatura", nullable = false)
    private int temperatura;

    public CodDeBare(String cod,String categorie, String denumire, int temperatura) {
        this.cod = cod;
        this.denumire = denumire;
        this.temperatura = temperatura;
        this.categorie = categorie;
    }

    public CodDeBare() {
    }


}
