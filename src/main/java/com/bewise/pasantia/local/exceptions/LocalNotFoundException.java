package com.bewise.pasantia.local.exceptions;

public class LocalNotFoundException extends RuntimeException {

    public LocalNotFoundException(Long localId) {
        super("Local con ID " + localId + " no encontrado");
    }
}

