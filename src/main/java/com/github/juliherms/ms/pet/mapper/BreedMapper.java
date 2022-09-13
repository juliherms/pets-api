package com.github.juliherms.ms.pet.mapper;

import com.github.juliherms.ms.pet.dto.BreedDTO;
import com.github.juliherms.ms.pet.model.Breed;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class BreedMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public Breed toBreed(BreedDTO dto) {
        return MODEL_MAPPER.map(dto, Breed.class);
    }

    public BreedDTO toBreedDTO(Breed breed) {
        return MODEL_MAPPER.map(breed, BreedDTO.class);
    }

    @SuppressWarnings("unchecked")
    public Page<BreedDTO> converterPageEntityToDto(Page<Breed> breed) {
        return MODEL_MAPPER.map(breed, Page.class);
    }

}
