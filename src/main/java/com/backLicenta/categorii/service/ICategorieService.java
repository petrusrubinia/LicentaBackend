package com.backLicenta.categorii.service;

import com.backLicenta.aliment.domain.Aliment;
import com.backLicenta.categorii.domain.Categorie;
import com.backLicenta.validation.CategorieNotFoundException;

import java.util.List;

public interface ICategorieService {

    Categorie add(Categorie categorie);

    List<Categorie> getAll();

    void remove(int id) throws CategorieNotFoundException, CategorieNotFoundException;;
}
