package com.pet.manager.exception;

public class PetNotFound extends RuntimeException {

    public PetNotFound() {
        super("Pet not Found");
    }

    public PetNotFound(String message) {
        super(message);
    }
}