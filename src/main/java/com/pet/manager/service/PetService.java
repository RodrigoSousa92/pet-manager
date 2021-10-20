package com.pet.manager.service;

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

    public List<Pet> save(List<PetCreationRQ> petCreationRQSList) {
        List<Pet> newPetList = new ArrayList<>();
        Pet newPet;
        for (PetCreationRQ petCreationRQ : petCreationRQSList) {
            newPet = Pet.builder().petType(petCreationRQ.getPetType()).name(petCreationRQ.getName()).build();
            petRepository.save(newPet);
            newPetList.add(newPet);
        }
        return newPetList;
    }

    public List<Pet> findAll() {
        return petRepository.findAll();
    }

}

