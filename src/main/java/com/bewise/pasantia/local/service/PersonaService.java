package com.bewise.pasantia.local.service;

import com.bewise.pasantia.local.model.Persona;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonaService {

    List<Persona> listarPersonas();
    Persona obtenerPersonaPorId(Long id);
    Persona crearPersona(Persona persona);
    Persona actualizarPersona(Long id, Persona persona);
    void eliminarPersona(Long id);
}
