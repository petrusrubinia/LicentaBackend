package com.backLicenta.validation;

import java.util.List;

public class ValidationExcetion extends RuntimeException {
    private final List<Error> errors;
    public ValidationExcetion(List<Error> errorList) {
        this.errors = errorList;
    }
    public List<Error> getErrors(){
        return errors;
    }
}
