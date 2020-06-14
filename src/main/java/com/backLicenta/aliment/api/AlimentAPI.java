package com.backLicenta.aliment.api;
import com.backLicenta.aliment.domain.Aliment;
import com.backLicenta.aliment.domain.CodDeBare;
import com.backLicenta.aliment.service.IAlimentService;
import com.backLicenta.aliment.validator.AlimentAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import com.backLicenta.validation.AlimentNotFoundException;

import java.util.List;
@EnableAutoConfiguration
@RequestMapping(value = "/aliment")
@RestController
public class AlimentAPI {
    private final IAlimentService alimentService;

    @Autowired
    public AlimentAPI(final IAlimentService alimentService){
        this.alimentService = alimentService;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Aliment add(@RequestBody Aliment aliment ){
        return alimentService.add(aliment);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Aliment update(@RequestBody Aliment aliment){
        return alimentService.update(aliment);
    }


    @RequestMapping(value = "/getOne/{id}", method = RequestMethod.GET)
    public Aliment getAliment(@PathVariable("id") int id) throws AlimentNotFoundException {
        return alimentService.get(id);
    }
    @RequestMapping(value = "/getByBarcode/{id}", method = RequestMethod.GET)
    public CodDeBare getAlimentByBarcode(@PathVariable("id") String id) throws AlimentNotFoundException {
        return alimentService.getByBarcode(id);
    }
    @RequestMapping(value = "/count", method = RequestMethod.POST)
    public int countByType(@RequestBody Aliment categorie) {
        System.out.println("AFISARE ID-> "+ categorie.getIdUser());
        return alimentService.countByType(categorie.getCategorie(),categorie.getIdUser());
    }
    @RequestMapping(value = "/all/{id}", method = RequestMethod.GET)
    public List<Aliment> getAll(@PathVariable("id") int id) {
       // System.out.println("in http://localhost:8080/api/aliment/all");
        System.out.println("afisare id---->>" + id);
        return alimentService.getAll(id);
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
        return alimentService.getOptimumTemp();
    }

    @RequestMapping(value = "/actualTemp", method = RequestMethod.GET)
    public int actualTemp() {
        return alimentService.getActualTemp();
    }



}

