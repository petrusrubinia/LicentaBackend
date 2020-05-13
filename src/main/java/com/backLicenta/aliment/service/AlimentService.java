package com.backLicenta.aliment.service;

import com.backLicenta.aliment.domain.Aliment;
import com.backLicenta.aliment.repository.IAlimentRepository;
import com.backLicenta.aliment.validator.AlimentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import com.backLicenta.validation.AlimentNotFoundException;
import com.backLicenta.validation.ValidationResult;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlimentService implements IAlimentService {

    private final IAlimentRepository alimentRepository;
    private final AlimentValidator alimentValidator;

    @Autowired
    public AlimentService(final IAlimentRepository alimentRepository, final AlimentValidator alimentValidator) {
        this.alimentRepository = alimentRepository;
        this.alimentValidator = alimentValidator;
    }

    public Aliment add(Aliment aliment) {
        ValidationResult validationResult = new ValidationResult();
        alimentValidator.validate(aliment,validationResult);
        validationResult.rejectIfHasErrors();
        return alimentRepository.save(aliment);
    }

    public void remove(int id) throws AlimentNotFoundException {
        Aliment aliment = alimentRepository.findById(id);
        if (aliment == null) {
            throw new AlimentNotFoundException("alimentul nu a fost gasit ");
        }
        alimentRepository.delete(aliment);
    }

    public Aliment get(int id) throws AlimentNotFoundException {
        Aliment aliment = alimentRepository.findById(id);
        if (aliment == null) {
            throw new AlimentNotFoundException("alimentul nu a fost gasit ");
        }
        return aliment;
    }

    public List<Aliment> getAll() {
        return alimentRepository.findAll();
    }

    @Override
    public int countByType(final String categorie) {
        List<Aliment> alimentList = new ArrayList<Aliment>();
        alimentList = alimentRepository.findAll();
        final int[] countElemes = {0};
        alimentList.forEach(x->{
            if(x.getCategorie().equals(categorie))
                countElemes[0] += 1;
        });

        System.out.println(countElemes[0] + " ---- countByType");
        return countElemes[0];
    }
    public List<String> getAllCategory(){
        List<Aliment> alimentList = new ArrayList<Aliment>();
        alimentList = alimentRepository.findAll();
        List<String> category= new ArrayList<>();
        alimentList.forEach(x ->{
            if(!category.contains(x.getCategorie()))
                category.add(x.getCategorie());
        });
        System.out.println("get all category");
        return category;
    }

    @Override
    public int getOptimalTemp() {
        return 3;
    }

    @Override
    public int getActualTemp() {
        return 0;
    }

    /*
    String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        Date date = simpleDateFormat.parse("2018-09-09");
     */
}
