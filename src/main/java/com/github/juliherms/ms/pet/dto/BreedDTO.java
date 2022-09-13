package com.github.juliherms.ms.pet.dto;

import javax.validation.constraints.NotBlank;

public class BreedDTO {

    @NotBlank
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
