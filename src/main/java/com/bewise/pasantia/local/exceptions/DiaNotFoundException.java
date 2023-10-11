package com.bewise.pasantia.local.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DiaNotFoundException extends RuntimeException {

    public DiaNotFoundException(Long diaId) {
        super("Día con ID " + diaId + " no encontrado.");
    }
}

