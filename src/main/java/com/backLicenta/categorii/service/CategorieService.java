package com.backLicenta.categorii.service;

import com.backLicenta.aliment.domain.Aliment;
import com.backLicenta.aliment.repository.IAlimentRepository;
import com.backLicenta.aliment.validator.AlimentValidator;
import com.backLicenta.categorii.domain.Categorie;
import com.backLicenta.categorii.repository.ICategorieRepository;
import com.backLicenta.categorii.validator.CategorieValidator;
import com.backLicenta.validation.AlimentNotFoundException;
import com.backLicenta.validation.CategorieNotFoundException;
import com.backLicenta.validation.ValidationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService implements ICategorieService {

    private final ICategorieRepository categorieRepository;
    private final CategorieValidator categorieValidator;

    @Autowired
    public CategorieService(final ICategorieRepository categorieRepository, final CategorieValidator categorieValidator) {
        this.categorieRepository = categorieRepository;
        this.categorieValidator = categorieValidator;
    }

    @Override
    public Categorie add(Categorie categorie) {
        ValidationResult validationResult = new ValidationResult();
        categorieValidator.validate(categorie,validationResult);
        validationResult.rejectIfHasErrors();
        return categorieRepository.save(categorie);
    }

    @Override
    public List<Categorie> getAll() {
            return categorieRepository.findAll();
    }

    @Override
    public void remove(int id) throws CategorieNotFoundException {
        Categorie categorie = categorieRepository.findById(id);
        if (categorie == null) {
            throw new CategorieNotFoundException("categoria nu a fost gasit ");
        }
        categorieRepository.delete(categorie);
    }
}
