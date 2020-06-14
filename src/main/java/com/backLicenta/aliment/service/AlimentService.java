package com.backLicenta.aliment.service;

import com.backLicenta.aliment.domain.Aliment;
import com.backLicenta.aliment.domain.CodDeBare;
import com.backLicenta.aliment.repository.IAlimentRepository;
import com.backLicenta.aliment.repository.ICodBareRepository;
import com.backLicenta.aliment.validator.AlimentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backLicenta.validation.AlimentNotFoundException;
import com.backLicenta.validation.ValidationResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlimentService implements IAlimentService {

    private final IAlimentRepository alimentRepository;
    private final AlimentValidator alimentValidator;
    private final ICodBareRepository codBareRepository;

    @Autowired
    public AlimentService(final IAlimentRepository alimentRepository, final ICodBareRepository codBareRepository, final AlimentValidator alimentValidator) {
        this.alimentRepository = alimentRepository;
        this.codBareRepository = codBareRepository;
        this.alimentValidator = alimentValidator;
    }

    public Aliment add(Aliment aliment) {
        ValidationResult validationResult = new ValidationResult();
        alimentValidator.validate(aliment, validationResult);
        System.out.println("geettt!!!"+ aliment.getCod_de_bare());
        validationResult.rejectIfHasErrors();
        if(!aliment.getCod_de_bare().equals("") )
        {
            Optional<CodDeBare> produs = null;

            produs = codBareRepository.findById(aliment.getCod_de_bare());
            if(produs.equals(Optional.empty())) {
                alimentValidator.validateDateCodBare(aliment, validationResult);
                validationResult.rejectIfHasErrors();

                codBareRepository.save(new CodDeBare(aliment.getCod_de_bare(),aliment.getCategorie(),aliment.getNume(),aliment.getTemperatura()));
                //codBareRepository.save(new CodDeBare(aliment.getCod_de_bare(), "fastfood", "Pate Porc BUCEGI", 4));
            }
        }
        return alimentRepository.save(aliment);
    }
    public Aliment update(Aliment aliment) {
        ValidationResult validationResult = new ValidationResult();
        alimentValidator.validate(aliment, validationResult);
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

    public List<Aliment> getAll(int userId) {
        return alimentRepository.findAllByUserId(userId);
    }

    @Override
    public int countByType(final String categorie, int userId) {
        List<Aliment> alimentList = new ArrayList<Aliment>();
        alimentList = alimentRepository.findAllByUserId(userId);
        final int[] countElemes = {0};
        alimentList.forEach(x->{
            if(x.getCategorie().equals(categorie))
                countElemes[0] += 1;
        });

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
    public int getOptimumTemp() {
        List<Aliment> alimentList = alimentRepository.getAllWithTempQuantity();
        System.out.println( "->>>>>>>>>>>>>>" +alimentList);
        float CC = temperatureStorage(alimentList);
        float C = quantity(alimentList);
        Fuzzy fuzzy = new Fuzzy(CC,C);
        System.out.println("de cee??");

        return 3;
    }

    private float quantity(List<Aliment> alimentList) {
        float sum = 0.0f;
        for(int i = 0; i< alimentList.size(); i++)
        {
            sum+= (float)alimentList.get(i).getBucati()* (float)Integer.parseInt(alimentList.get(i).getCantitate());
        }
        return sum;
    }

    private float temperatureStorage(List<Aliment> alimentList) {
        float sum = 0.0f;
        for(int i = 0; i< alimentList.size(); i++)
        {
            sum+= (float)alimentList.get(i).getTemperatura();
        }
        return sum/(alimentList.size() - 1);
    }

    @Override
    public int getActualTemp() {
        System.out.println("in get ActualTempp");
        return 0;
    }

    @Override
    public CodDeBare getByBarcode(String id) {
        System.out.println(id);
        Optional<CodDeBare> produs = null;

        produs = codBareRepository.findById(id);
        if(!produs.equals(Optional.empty())) {
            return produs.get();
        }
        else
            return new CodDeBare(id,"","",-100);

    }

    public int calculateOptimum(List<Integer> list)
    {
        return 0;
    }

    /*
    String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        Date date = simpleDateFormat.parse("2018-09-09");
     */
}
