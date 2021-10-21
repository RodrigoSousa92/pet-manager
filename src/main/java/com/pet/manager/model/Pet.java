package com.pet.manager.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
@Table(name = "feedPet")
public class Pet {

    @Id
    private String id;

    private String name;

    @Enumerated
    private PetType petType;

    @Embedded
    private Feed feed;

}
