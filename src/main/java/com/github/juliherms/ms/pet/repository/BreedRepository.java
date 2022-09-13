package com.github.juliherms.ms.pet.repository;

import com.github.juliherms.ms.pet.model.Breed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BreedRepository extends JpaRepository<Breed, UUID> {

    boolean existsByDescription(String description);
}
