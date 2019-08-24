package org.sang.controller;

import org.sang.interfaces.ValidationGroup2;
import org.sang.model.ValidationGroupTable;
import org.sang.model.ValidationTable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ValidationGroupController {
    @GetMapping("/validates")
    public List<String> checkValidation(@Validated(ValidationGroup2.class) ValidationGroupTable validationGroupTable, BindingResult result) {
        List<String> errors = new ArrayList<>();
        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError error : allErrors) {
                errors.add(error.getDefaultMessage());
            }
        }
        return errors;
    }
}
