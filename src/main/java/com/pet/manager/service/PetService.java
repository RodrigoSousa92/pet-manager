package com.pet.manager.service;

import com.mongodb.DuplicateKeyException;
import com.pet.manager.exception.DuplicatedPet;
import com.pet.manager.exception.PetNotFound;
import com.pet.manager.model.Pet;
import com.pet.manager.repository.PetRepository;
import com.pet.manager.request.PetCreationRQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {

    @Autowired
    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    //Save Pets List
    public List<Pet> save(List<PetCreationRQ> petCreationRQSList) {
        try {
            List<Pet> newPetList = new ArrayList<>();
            Pet newPet;
            for (PetCreationRQ petCreationRQ : petCreationRQSList) {
                newPet = Pet.builder().petType(petCreationRQ.getPetType()).name(petCreationRQ.getName()).build();
                petRepository.save(newPet);
                newPetList.add(newPet);
            }
            return newPetList;
        } catch (DuplicateKeyException exception) {
            throw new DuplicatedPet();
        }
    }
    //Find All Pets
    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    //Delete pet by Id
    public void deleteById(String petId) {
        petRepository.deleteById(petId);
    }
    //Find by Id
    public Pet findById(String petId) {

        return petRepository.findById(petId).orElseThrow(PetNotFound::new);
    }
}

