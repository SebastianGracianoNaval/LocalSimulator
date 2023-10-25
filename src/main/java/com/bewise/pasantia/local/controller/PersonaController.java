package com.bewise.pasantia.local.controller;

import com.bewise.pasantia.local.model.Persona;
import com.bewise.pasantia.local.service.impl.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaServiceImpl personaService;

    @GetMapping("")
    public List<Persona> getAllPersonas() {
        return personaService.listarPersonas();
    }

    @GetMapping("/{id}")
    public Persona getPersonaById(@PathVariable Long id) {
        Persona persona = personaService.obtenerPersonaPorId(id);
        if (persona == null) {
            // Manejo de errores
            return null; // ResponseEntity con un mensaje de error
        }
        return persona;
    }

    @PostMapping("")
    public Persona createPersona(@RequestBody Persona persona) {
        return personaService.crearPersona(persona);
    }

    @PutMapping("/{id}")
    public Persona updateLocal(@PathVariable Long id, @RequestBody Persona actualizarPersona) {
        return personaService.actualizarPersona(id, actualizarPersona);
    }


    @DeleteMapping("/{id}")
    public void deletePersona(@PathVariable Long id) {
        personaService.eliminarPersona(id);
    }
}
