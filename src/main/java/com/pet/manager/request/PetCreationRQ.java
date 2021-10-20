package com.pet.manager.request;

import com.pet.manager.model.PetType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PetCreationRQ {

    private String id;

    private String name;

    @Enumerated(EnumType.STRING)
    private PetType petType;


}
