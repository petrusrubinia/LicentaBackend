package com.backLicenta.aliment.validator;

import com.backLicenta.aliment.domain.Aliment;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;
import com.backLicenta.validation.ValidationResult;

@Component
public class AlimentValidator {
    public void validate(Aliment aliment, ValidationResult result)
    {
        if(aliment.getNume() == null || aliment.getNume().equals(Strings.EMPTY)){
            result.rejectError("nume","Numele nu poate sa fie null");
        }
        if( aliment.getTemperatura() > 6)
        {
            result.rejectError("temperatura", "Temperatura introdusa nu este una optima!");
        }

        if(aliment.getData_expirare() == null || aliment.getData_expirare().equals(Strings.EMPTY)) {
            result.rejectError("data_expirare", "Data de expirare nu ar trebui sa fie nulla");
        }
        if(aliment.getData_achizitionare() == null || aliment.getData_achizitionare().equals(Strings.EMPTY)) {
            result.rejectError("data_achizitionare", "Data de achizitionare nu ar trebui sa fie nulla");
        }


    }

    public void validateDateCodBare(Aliment aliment, ValidationResult validationResult) {
        if(aliment.getNume() == null || aliment.getNume().equals(Strings.EMPTY)){
            validationResult.rejectError("nume","Numele nu poate sa fie null");
        }
        if( aliment.getTemperatura() > 6 || aliment.getTemperatura()== -100)
        {
            validationResult.rejectError("temperatura", "Temperatura introdusa nu este una optima!");
        }
        if(aliment.getCategorie().equals(""))
            validationResult.rejectError("categorie", "Categoria nu poate lipsi!");

    }
}
