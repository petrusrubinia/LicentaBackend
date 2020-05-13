package com.backLicenta.aliment.api;
import com.backLicenta.aliment.domain.Aliment;
import com.backLicenta.aliment.service.IAlimentService;
import com.backLicenta.aliment.validator.AlimentAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import com.backLicenta.validation.AlimentNotFoundException;

import java.util.List;
@RequestMapping(value = "/aliment")
@RestController
public class AlimentAPI {
    private final IAlimentService alimentService;

    @Autowired
    public AlimentAPI(final IAlimentService alimentService){
        this.alimentService = alimentService;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Aliment add(@RequestBody Aliment aliment){
        return alimentService.add(aliment);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Aliment update(@RequestBody Aliment aliment){
        return alimentService.add(aliment);
    }

    @RequestMapping(value = "/getOne/{id}", method = RequestMethod.GET)
    public Aliment getAliment(@PathVariable("id") int id) throws AlimentNotFoundException {
        return alimentService.get(id);
    }
    @RequestMapping(value = "/count/{categorie}", method = RequestMethod.GET)
    public int countByType(@PathVariable("categorie") String categorie) {
        return alimentService.countByType(categorie);
    }
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Aliment> getAll() {
       // System.out.println("in http://localhost:8080/api/aliment/all");
        return alimentService.getAll();
    }

    @RequestMapping(value = "/getAllCategory", method = RequestMethod.GET)
    public List<String> getAllCategory() {
        return alimentService.getAllCategory();
    }


    @DeleteMapping("/remove/{id}")
    public void removeAliment(@PathVariable("id") int id) {
        try {
            alimentService.remove(id);
        } catch (AlimentNotFoundException e) {
            throw new AlimentAPIException("Nu exista alimentul cu acest id, pentru a putea fi sters");
        }
    }


    @RequestMapping(value = "/optimTemp", method = RequestMethod.GET)
    public int optimTemp() {
        return alimentService.getOptimalTemp();
    }

    @RequestMapping(value = "/actualTemp", method = RequestMethod.GET)
    public int actualTemp() {
        return alimentService.getActualTemp();
    }



}

