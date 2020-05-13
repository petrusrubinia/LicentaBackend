package com.backLicenta.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult implements IValidationResult {
    private List<Error> errorList;

    public ValidationResult() {
        this.errorList = new ArrayList<Error>();
    }

    public boolean hasErrors() {
        return !errorList.isEmpty();
    }

    public void rejectError(String field, String message) {
        errorList.add(new Error(field,message));
    }

    public List<Error> getErrors() {
        return this.errorList;
    }

    public void rejectIfHasErrors() {
        if(hasErrors()){
            throw new ValidationExcetion(this.errorList);
        }
    }
}
