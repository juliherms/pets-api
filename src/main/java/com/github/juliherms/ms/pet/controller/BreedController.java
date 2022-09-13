package com.github.juliherms.ms.pet.controller;

import com.github.juliherms.ms.pet.dto.BreedDTO;
import com.github.juliherms.ms.pet.service.BreedService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/breeds")
public class BreedController {

    final BreedService service;

    public BreedController(BreedService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid BreedDTO breedDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(breedDTO));
    }

    @GetMapping
    public ResponseEntity<Page<BreedDTO>> list(
            @PageableDefault(page = 0, size = 10, sort = "description", direction = Sort.Direction.ASC) Pageable pageable){
        Page<BreedDTO> result = service.findAll(pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BreedDTO> findById(@PathVariable(value="id") UUID id) {
        BreedDTO result = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Raça excluída com sucesso!");
    }
}


