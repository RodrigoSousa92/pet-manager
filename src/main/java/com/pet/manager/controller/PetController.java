package com.pet.manager.controller;

import com.pet.manager.model.Pet;
import com.pet.manager.model.PetType;
import com.pet.manager.request.PetCreationRQ;
import com.pet.manager.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PetController {
    public final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    //Get all pets
    @GetMapping("/pets")
    public List<Pet> getPets() {
        return petService.findAll();
    }

    //Get pets by id
    @GetMapping("/pets/{id}")
    public Pet getPets(@PathVariable(value = "id") String petId) {
        return petService.findById(petId);
    }

    //Get by type
    @GetMapping("/pets-type")
    public ResponseEntity<List<Pet>> getPets(@RequestParam PetType type) {

        System.out.println(type);
        return ResponseEntity.ok(Collections.emptyList());
    }

    //Create a Pet
    @PostMapping(value = "/pets")
    public List<Pet> addPet(@RequestBody @Valid List<PetCreationRQ> petCreationRQS) {
        return petService.save(petCreationRQS);
    }

    //Delete by Id
    @DeleteMapping(path = "/pets/{id}")
    public void deletePet(@PathVariable(value = "id") String petId) {
        petService.deleteById(petId);
    }
}
