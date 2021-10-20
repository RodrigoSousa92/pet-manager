package com.pet.manager.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Enumerated;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Pet {

    @Id
    private String id;

    private String name;

    @Enumerated
    private PetType petType;
}
