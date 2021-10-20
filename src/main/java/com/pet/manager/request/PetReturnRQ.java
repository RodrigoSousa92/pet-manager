package com.pet.manager.request;

import com.pet.manager.model.PetType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PetReturnRQ {

    private String id;

    private String name;

    private PetType type;

}
