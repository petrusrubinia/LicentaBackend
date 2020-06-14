package com.backLicenta.aliment.service;

import com.backLicenta.aliment.domain.Aliment;
import com.backLicenta.aliment.domain.CodDeBare;
import com.backLicenta.validation.AlimentNotFoundException;

import java.util.List;


public interface IAlimentService {
    Aliment add(Aliment aliment);

    Aliment update(Aliment aliment);

    void remove(int id) throws AlimentNotFoundException;

    Aliment get(int id) throws AlimentNotFoundException;

    List<Aliment> getAll(int id);

    int countByType(String categorie, int userId);

    List<String> getAllCategory();

    int getOptimumTemp();

    int getActualTemp();

    CodDeBare getByBarcode(String id);
}
