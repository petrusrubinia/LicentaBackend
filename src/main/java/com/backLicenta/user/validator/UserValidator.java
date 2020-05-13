package com.backLicenta.user.validator;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;
import com.backLicenta.user.domain.User;
import com.backLicenta.validation.ValidationResult;

@Component
public class UserValidator {
    public void validate(User user, ValidationResult validationResult) {
        if(user.getNume() == null || user.getNume().equals(Strings.EMPTY))
            validationResult.rejectError("nume","Campul nume are valoarea null");
        if(user.getPrenume() == null || user.getPrenume().equals(Strings.EMPTY))
            validationResult.rejectError("prenume","Campul prenume are valoarea null");
        if(user.getUtilizator() == null || user.getUtilizator().equals(Strings.EMPTY))
            validationResult.rejectError("utilizator","Campul utilizator are valoarea null");
        if(user.getEmail() == null || user.getEmail().equals(Strings.EMPTY))
            validationResult.rejectError("email","Campul email are valoarea null");
        if(user.getParola()== null || user.getParola().equals(Strings.EMPTY))
            validationResult.rejectError("parola","Campul parola are valoarea null");
    }

    public void validateLogin(User user, ValidationResult validationResult) {
        if(user.getParola()== null || user.getParola().equals(Strings.EMPTY))
            validationResult.rejectError("parola","Campul parola are valoarea null");
        if(user.getUtilizator() == null || user.getUtilizator().equals(Strings.EMPTY))
            validationResult.rejectError("utilizator","Campul Utilizator are valoarea null");


    }
}
