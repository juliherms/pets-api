package com.github.juliherms.ms.pet.service;

import com.github.juliherms.ms.pet.dto.BreedDTO;
import com.github.juliherms.ms.pet.exception.DuplicateBreedException;
import com.github.juliherms.ms.pet.exception.NotFoundException;
import com.github.juliherms.ms.pet.mapper.BreedMapper;
import com.github.juliherms.ms.pet.model.Breed;
import com.github.juliherms.ms.pet.repository.BreedRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class BreedService {

    final BreedRepository repository;
    final BreedMapper mapper;


    public BreedService(BreedRepository repository, BreedMapper mapper)
    {
        this.repository = repository;
        this.mapper = mapper;

    }

    @Transactional
    public Breed save(BreedDTO breedDTO) {
        Breed breed = mapper.toBreed(breedDTO);

        if(existsByDescription(breed.getDescription())){
            throw new DuplicateBreedException(breed.getDescription());
        } else {
            return repository.save(breed);
        }
    }

    public boolean existsByDescription(String description){
        return repository.existsByDescription(description);
    }

    public Page<BreedDTO> findAll (Pageable pageable) {
        return mapper.converterPageEntityToDto(repository.findAll(pageable));
    }

    public BreedDTO findById(UUID id) {
        Optional<Breed> breed = repository.findById(id);
        if (!breed.isPresent()) {
            throw new NotFoundException("A raça com o id " + id + "não foi encontrada");
        }
        return mapper.toBreedDTO(breed.get());
    }

    @Transactional
    public void delete(UUID id) {
        Optional<Breed> breed = repository.findById(id);
        if (!breed.isPresent()) {
            throw new NotFoundException("A raça com o id " + id + "não foi encontrada");
        }
        repository.delete(breed.get());
    }
}
