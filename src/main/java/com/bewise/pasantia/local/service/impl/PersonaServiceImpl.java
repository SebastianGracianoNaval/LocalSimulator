package com.bewise.pasantia.local.service.impl;

import com.bewise.pasantia.local.model.Persona;
import com.bewise.pasantia.local.repository.PersonaRepository;
import com.bewise.pasantia.local.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {
    private PersonaRepository personaRepository;


    public PersonaServiceImpl(PersonaRepository personaRepository){
        this.personaRepository = personaRepository;
    }

    @Override
    public List<Persona> listarPersonas(){
        return personaRepository.findAll();
    }

    @Override
    public Persona obtenerPersonaPorId(Long id){
        return personaRepository.findById(id).orElse(null);
    }
    @Override
    public Persona crearPersona(Persona persona) {
        return  personaRepository.save(persona);
    }

    @Override
    public Persona actualizarPersona(Long id, Persona persona){
        Persona existePersona = personaRepository.findById(id).orElse(null);
        if(existePersona != null){
            existePersona.setNombre(persona.getNombre());
            return  personaRepository.save(existePersona);
        }
        return  null;
    }

    @Override
    public void eliminarPersona(Long id){
        personaRepository.deleteById(id);

    }
}
