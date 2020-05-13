package com.backLicenta.validation;

import java.util.List;

public interface IValidationResult {
    boolean hasErrors();
    void rejectError(String field, String message);
    List<Error> getErrors();
    void rejectIfHasErrors();

}
