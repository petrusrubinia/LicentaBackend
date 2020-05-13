package com.backLicenta.categorii.validator;

import com.backLicenta.categorii.domain.Categorie;
import com.backLicenta.validation.ValidationResult;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

@Component
public class CategorieValidator {
    public void validate(Categorie categorie, ValidationResult result)
    {
        if(categorie.getCategorie() == null || categorie.getCategorie().equals(Strings.EMPTY)){
            result.rejectError("categorie","categoria nu poate sa fie null");
        }
    }
}
