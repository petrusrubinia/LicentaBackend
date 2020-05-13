package com.backLicenta.aliment.service;

import com.backLicenta.aliment.domain.Aliment;
import com.backLicenta.validation.AlimentNotFoundException;

import java.util.List;


public interface IAlimentService {
    Aliment add(Aliment aliment);

    void remove(int id) throws AlimentNotFoundException;

    Aliment get(int id) throws AlimentNotFoundException;

    List<Aliment> getAll();

    int countByType(String categorie);

    List<String> getAllCategory();

    int getOptimalTemp();

    int getActualTemp();

}
