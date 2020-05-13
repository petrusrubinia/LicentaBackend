package com.backLicenta.categorii.api;

import com.backLicenta.categorii.domain.Categorie;
import com.backLicenta.categorii.service.ICategorieService;
import com.backLicenta.categorii.validator.CategorieAPIException;
import com.backLicenta.validation.CategorieNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/categorii")
@RestController
public class CategorieAPI {
    private final ICategorieService categorieService;

    @Autowired
    public CategorieAPI(final ICategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Categorie add(@RequestBody Categorie categorie) {
        return categorieService.add(categorie);
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Categorie> getAll() {
        // System.out.println("in http://localhost:8080/api/categorie/all");
        return categorieService.getAll();
    }


    @DeleteMapping("/remove/{id}")
    public void removeCategorie(@PathVariable("id") int id) {
        try {
            categorieService.remove(id);
        } catch (CategorieNotFoundException e) {
            throw new CategorieAPIException("Nu exista categoria cu acest id, pentru a putea fi sters");
        }
    }
}
