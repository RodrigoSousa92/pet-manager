package com.pet.manager.controller;

import com.pet.manager.model.Pet;
import com.pet.manager.request.PetCreationRQ;
import com.pet.manager.service.PetService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PetController {
    public final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }


    @GetMapping("/pets")
    public List<Pet> getPets() {
        return petService.findAll();
    }

    //Create a Pet
    @PostMapping(value = "/createPet", consumes = "aplication/json")
    public List<Pet> addPet(@RequestBody @Valid List<PetCreationRQ> petCreationRQS) {
        return petService.save(petCreationRQS);

    }
}
