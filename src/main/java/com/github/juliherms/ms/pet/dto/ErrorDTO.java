package com.github.juliherms.ms.pet.dto;

import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ErrorDTO {

    private List<String> errors;

    public ErrorDTO(BindingResult result) {
        this.errors = new ArrayList<>();
        result.getAllErrors().forEach(error ->
        this.errors.add(error.getDefaultMessage()));
    }

    public ErrorDTO(RuntimeException ex) {
        this.errors = Arrays.asList(ex.getMessage());
    }

    public List<String> getErrors() {
        return errors;
    }
}
